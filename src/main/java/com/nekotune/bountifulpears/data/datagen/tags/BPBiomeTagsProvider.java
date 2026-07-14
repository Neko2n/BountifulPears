package com.nekotune.bountifulpears.data.datagen.tags;

import com.farcr.nomansland.common.registry.worldgen.NMLBiomes;
import com.nekotune.bountifulpears.BountifulPears;
import com.nekotune.bountifulpears.data.tags.BPBiomeTags;

import net.hecco.bountifulfares.registry.tags.BFBiomeTags;
import net.hibiscus.naturespirit.registration.NSBiomes;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class BPBiomeTagsProvider extends BiomeTagsProvider {

    public BPBiomeTagsProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(),
                event.getLookupProvider(),
                BountifulPears.MOD_ID,
                event.getExistingFileHelper());
    }

    @Override
    protected void addTags(Provider provider) {

        // Custom tags
        tag(BPBiomeTags.HAS_PEAR_TREES)
            .add(NMLBiomes.AUTUMNAL_FOREST)
            .add(NMLBiomes.BOREAL_FOREST)
            .add(NMLBiomes.MAPLE_FOREST)
            .add(NMLBiomes.MAPLE_GROVE)
            .add(NMLBiomes.OLD_GROWTH_FOREST)
            .add(NMLBiomes.OLD_GROWTH_FOREST_CLEARING)
            .add(NMLBiomes.OLD_GROWTH_FOREST_EDGE)
            .addOptional(NSBiomes.MAPLE_WOODLANDS.location());
        
        // Bountiful fares compatibility
        tag(BFBiomeTags.HAS_APPLE_TREES)
            .add(NMLBiomes.OLD_GROWTH_FOREST)
            .add(NMLBiomes.OLD_GROWTH_FOREST_CLEARING)
            .add(NMLBiomes.OLD_GROWTH_FOREST_EDGE);
        tag(BFBiomeTags.HAS_ORANGE_TREES)
            .addOptional(NSBiomes.SUGI_FOREST.location())
            .addOptional(NSBiomes.WINDSWEPT_SUGI_FOREST.location())
            .addOptional(NSBiomes.BLOOMING_SUGI_FOREST.location());
        tag(BFBiomeTags.HAS_PLUM_TREES)
            .addOptional(NSBiomes.SUGI_FOREST.location())
            .addOptional(NSBiomes.WINDSWEPT_SUGI_FOREST.location())
            .addOptional(NSBiomes.BLOOMING_SUGI_FOREST.location())
            .addOptional(NSBiomes.WISTERIA_FOREST.location());
        tag(BFBiomeTags.HAS_WILD_WHEAT)
            .add(NMLBiomes.PRAIRIE)
            .add(NMLBiomes.AUTUMNAL_FOREST)
            .add(NMLBiomes.BOREAL_FOREST)
            .add(NMLBiomes.MAPLE_FOREST)
            .add(NMLBiomes.MAPLE_GROVE)
            .add(NMLBiomes.OLD_GROWTH_FOREST)
            .add(NMLBiomes.OLD_GROWTH_FOREST_CLEARING)
            .add(NMLBiomes.OLD_GROWTH_FOREST_EDGE)
            .add(NMLBiomes.DESERT_RIVER)
            .addOptional(NSBiomes.FLOWERING_SHRUBLAND.location());
        tag(BFBiomeTags.HAS_WILD_BEETROOT)
            .add(NMLBiomes.PRAIRIE)
            .add(NMLBiomes.OLD_GROWTH_FOREST)
            .add(NMLBiomes.OLD_GROWTH_FOREST_CLEARING)
            .add(NMLBiomes.OLD_GROWTH_FOREST_EDGE);
        tag(BFBiomeTags.HAS_WILD_POTATOES)
            .add(NMLBiomes.PRAIRIE)
            .add(NMLBiomes.AUTUMNAL_FOREST)
            .add(NMLBiomes.BOREAL_FOREST)
            .add(NMLBiomes.MAPLE_FOREST)
            .add(NMLBiomes.MAPLE_GROVE)
            .add(NMLBiomes.OLD_GROWTH_FOREST)
            .add(NMLBiomes.OLD_GROWTH_FOREST_CLEARING)
            .add(NMLBiomes.OLD_GROWTH_FOREST_EDGE)
            .addOptional(NSBiomes.WISTERIA_FOREST.location());
        tag(BFBiomeTags.HAS_WILD_LEEKS)
            .add(NMLBiomes.BLACKWATER_RIVER)
            .add(NMLBiomes.LUSH_RIVER);
        tag(BFBiomeTags.HAS_WILD_MAIZE)
            .add(NMLBiomes.LUSH_RIVER);
        tag(BFBiomeTags.HAS_LARGE_WILD_WHEAT)
            .addOptional(NSBiomes.OAK_SAVANNA.location())
            .addOptional(NSBiomes.SHRUBLAND.location());
        tag(BFBiomeTags.HAS_LARGE_WILD_CARROTS)
            .add(NMLBiomes.PRAIRIE);
        tag(BFBiomeTags.HAS_CHAMOMILE)
            .add(NMLBiomes.PRAIRIE)
            .addOptional(NSBiomes.BLOOMING_SUGI_FOREST.location())
            .addOptional(NSBiomes.BLOOMING_HIGHLANDS.location())
            .addOptional(NSBiomes.WISTERIA_FOREST.location())
            .addOptional(NSBiomes.FLOWERING_SHRUBLAND.location());
        tag(BFBiomeTags.HAS_HONEYSUCKLE)
            .add(NMLBiomes.OLD_GROWTH_FOREST)
            .add(NMLBiomes.OLD_GROWTH_FOREST_CLEARING)
            .add(NMLBiomes.OLD_GROWTH_FOREST_EDGE)
            .addOptional(NSBiomes.BLOOMING_SUGI_FOREST.location())
            .addOptional(NSBiomes.WISTERIA_FOREST.location());
        tag(BFBiomeTags.HAS_VIOLET_BELLFLOWER)
            .add(NMLBiomes.DARK_TAIGA)
            .addOptional(NSBiomes.ASPEN_FOREST.location())
            .addOptional(NSBiomes.BLOOMING_SUGI_FOREST.location())
            .addOptional(NSBiomes.WISTERIA_FOREST.location());
    }
}
