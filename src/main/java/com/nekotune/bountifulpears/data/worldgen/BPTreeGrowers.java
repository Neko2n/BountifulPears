package com.nekotune.bountifulpears.data.worldgen;

import java.util.Optional;

import net.minecraft.world.level.block.grower.TreeGrower;

public class BPTreeGrowers {

    public static final TreeGrower PEAR_SAPLING_GENERATOR = new TreeGrower(
            "pear", 0.0F,
            Optional.empty(),
            Optional.empty(),
            Optional.of(BPConfiguredFeatures.PEAR_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
}
