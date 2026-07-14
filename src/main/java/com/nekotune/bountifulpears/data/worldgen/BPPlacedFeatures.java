package com.nekotune.bountifulpears.data.worldgen;

import java.util.List;

import com.nekotune.bountifulpears.BountifulPears;
import com.nekotune.bountifulpears.shared.registries.content.BPBlocks;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class BPPlacedFeatures {

    public static final ResourceKey<PlacedFeature> PEAR_PLACED_KEY = registerKey("pear_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // Pear trees
        register(context, PEAR_PLACED_KEY,
                configuredFeatures.getOrThrow(BPConfiguredFeatures.PEAR_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(0, 0.5f, 1),
                        BPBlocks.PEAR_SAPLING.get()));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(BountifulPears.MOD_ID, name));
    }

    @SuppressWarnings("unused")
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                                                                   Holder<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
