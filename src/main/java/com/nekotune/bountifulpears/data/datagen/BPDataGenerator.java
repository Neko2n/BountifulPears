package com.nekotune.bountifulpears.data.datagen;

import com.nekotune.bountifulpears.data.datagen.assets.BPBlockStateProvider;
import com.nekotune.bountifulpears.data.datagen.assets.BPItemModelProvider;
import com.nekotune.bountifulpears.data.datagen.loot.BPLootTableProvider;
import com.nekotune.bountifulpears.data.datagen.recipes.BPRecipeProvider;
import com.nekotune.bountifulpears.data.datagen.tags.BPBiomeTagsProvider;
import com.nekotune.bountifulpears.data.datagen.tags.BPBlockTagsProvider;
import com.nekotune.bountifulpears.data.datagen.tags.BPItemTagsProvider;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber
public class BPDataGenerator {
    
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        if (!event.includeServer()) return;

        final var datapackEntries = event.addProvider(new BPDatapackEntriesProvider(event));

        // TODO: Group tag providers into sub-providers under one main provider
        final var blockTags = event.addProvider(new BPBlockTagsProvider(event));
        final var itemTags = event.addProvider(new BPItemTagsProvider(event, blockTags));
        final var biomeTags = event.addProvider(new BPBiomeTagsProvider(event));

        // TODO: Split recipes into sub-providers under a main provider
        final var recipes = event.addProvider(new BPRecipeProvider(event));

        final var lootTables = event.addProvider(new BPLootTableProvider(event));
    }

    @SubscribeEvent
    public static void onGatherDataClient(GatherDataEvent event) {
        if (!event.includeClient()) return;
        
        final var blockStates = event.addProvider(new BPBlockStateProvider(event));
        final var itemModels = event.addProvider(new BPItemModelProvider(event));
    }
}
