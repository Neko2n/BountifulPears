package com.nekotune.bountifulpears.data.datagen.tags;

import com.farcr.nomansland.common.registry.items.NMLItems;
import com.nekotune.bountifulpears.BountifulPears;
import com.nekotune.bountifulpears.data.tags.BPItemTags;
import com.nekotune.bountifulpears.shared.registries.content.BPBlocks;

import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class BPItemTagsProvider extends ItemTagsProvider {

    public BPItemTagsProvider(GatherDataEvent event, BPBlockTagsProvider blockTags) {
        super(event.getGenerator().getPackOutput(),
                event.getLookupProvider(),
                blockTags.contentsGetter(),
                BountifulPears.MOD_ID,
                event.getExistingFileHelper());
    }

    @Override
    protected void addTags(Provider provider) {
    
        // Bountiful fares compatibility
        tag(BPItemTags.PEAR_LOGS)
            .add(BPBlocks.PEAR_LOG.asItem())
            .add(BPBlocks.PEAR_WOOD.asItem())
            .add(BPBlocks.STRIPPED_PEAR_LOG.asItem())
            .add(BPBlocks.STRIPPED_PEAR_WOOD.asItem());
        tag(BFItemTags.FRUIT_LOGS).addTag(BPItemTags.PEAR_LOGS);
        tag(ItemTags.LOGS_THAT_BURN).addTag(BPItemTags.PEAR_LOGS);
        tag(BPItemTags.PEAR_LEAVES)
            .add(BPBlocks.PEAR_LEAVES.asItem());
            // .add(MJBlocks.FLOWERING_PEAR_LEAVES.asItem());
        tag(ItemTags.LEAVES).addTag(BPItemTags.PEAR_LEAVES);
        tag(BFItemTags.C_FRUIT)
            .add(NMLItems.PEAR.get());
    }
}
