package com.nekotune.bountifulpears.data.datagen.assets;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

import com.nekotune.bountifulpears.BountifulPears;
import com.nekotune.bountifulpears.shared.registries.content.BPItems;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class BPItemModelProvider extends ItemModelProvider {

    /**
     * Keeps track of which items have already been given an
     * explicit item model.
     * Populated automatically by {@link #getBuilder}.
     */
    private final Set<ResourceLocation> registered = new HashSet<>();

    public BPItemModelProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(),
                BountifulPears.MOD_ID,
                event.getExistingFileHelper());
    }

    @Override
    public ItemModelBuilder getBuilder(String path) {
        registered.add(
                path.contains(":") ? ResourceLocation.parse(path) : ResourceLocation.fromNamespaceAndPath(modid, path));
        return super.getBuilder(path);
    }

    @Override
    protected void registerModels() {

        // Any items which didn't get an explicit model are given a generic flat model.
        // Block items are skipped, as they're given models by BlockStateProvider.
        final Stream<Item> items = BPItems.ITEMS.getEntries().stream().map(Holder::value);
        items.forEach(item -> {
            if (item instanceof BlockItem) return;
            if (registered.contains(BuiltInRegistries.ITEM.getKey(item))) return;

            // All other items
            basicItem(item);
        });
    }
    
    @Override
    public ItemModelBuilder handheldItem(Item item) {
        return model(item, "item/handheld");
    }

    @Override
    public ItemModelBuilder basicItem(Item item) {
        return model(item, "item/generated");
    }

    private ItemModelBuilder model(Item item, final String modelPath) {
        ResourceLocation location = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
        final String texturePath = getTexturePath(item);
        return getBuilder(location.toString())
                .parent(new ModelFile.UncheckedModelFile(modelPath))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(
                        location.getNamespace(), texturePath));
    }

    private static String getTexturePath(Item item) {
        ResourceLocation modelLocation = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
        String modifier = "";
        if (item instanceof ArmorItem) {
            modifier = "armor/";
        } else if (item instanceof TieredItem) {
            modifier = "tool/";
        } else {
            modifier = "material/";
        }
        return "item/" + modifier + modelLocation.getPath();
    }
}
