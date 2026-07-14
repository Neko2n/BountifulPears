package com.nekotune.bountifulpears.data.datagen;

import java.util.Set;

import com.nekotune.bountifulpears.BountifulPears;
import com.nekotune.bountifulpears.data.worldgen.BPBiomeModifiers;
import com.nekotune.bountifulpears.data.worldgen.BPConfiguredFeatures;
import com.nekotune.bountifulpears.data.worldgen.BPPlacedFeatures;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries.Keys;

public class BPDatapackEntriesProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, BPConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, BPPlacedFeatures::bootstrap)
            .add(Keys.BIOME_MODIFIERS, BPBiomeModifiers::bootstrap);

    public BPDatapackEntriesProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(),
                event.getLookupProvider(),
                BUILDER,
                Set.of(BountifulPears.MOD_ID));
    }
    
}
