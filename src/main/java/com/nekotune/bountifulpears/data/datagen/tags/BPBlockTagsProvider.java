package com.nekotune.bountifulpears.data.datagen.tags;

import com.nekotune.bountifulpears.BountifulPears;
import com.nekotune.bountifulpears.data.tags.BPBlockTags;
import com.nekotune.bountifulpears.shared.registries.content.BPBlocks;

import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class BPBlockTagsProvider extends BlockTagsProvider {

    public BPBlockTagsProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(),
                event.getLookupProvider(),
                BountifulPears.MOD_ID,
                event.getExistingFileHelper());
    }

    @Override
    protected void addTags(Provider provider) {
        tag(BlockTags.MINEABLE_WITH_AXE)
            .add(BPBlocks.PEAR_BLOCK.get());
        tag(BFBlockTags.HANGING_FRUIT)
            .add(BPBlocks.HANGING_PEAR.get());
        tag(BPBlockTags.PEAR_LOGS)
            .add(BPBlocks.PEAR_LOG.get())
            .add(BPBlocks.PEAR_WOOD.get())
            .add(BPBlocks.STRIPPED_PEAR_LOG.get())
            .add(BPBlocks.STRIPPED_PEAR_WOOD.get());
        tag(BlockTags.LOGS_THAT_BURN)
            .addTag(BPBlockTags.PEAR_LOGS);
        tag(BPBlockTags.PEAR_LEAVES)
            .add(BPBlocks.PEAR_LEAVES.get());
            // .add(MJBlocks.FLOWERING_PEAR_LEAVES.get());
        tag(BlockTags.LEAVES).addTag(BPBlockTags.PEAR_LEAVES);
    }
}
