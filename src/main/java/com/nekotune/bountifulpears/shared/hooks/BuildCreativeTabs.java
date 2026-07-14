package com.nekotune.bountifulpears.shared.hooks;

import com.nekotune.bountifulpears.shared.registries.content.BPBlocks;
import net.hecco.bountifulfares.registry.misc.BFItemGroups;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@EventBusSubscriber
public class BuildCreativeTabs {
    
    @SubscribeEvent
    public static void onBuildCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        CreativeModeTab tab = event.getTab();
        if (tab == BFItemGroups.COMPATIBILITY.get()) {
            event.accept(BPBlocks.PEAR_BLOCK.get().asItem());
            event.accept(BPBlocks.PEAR_LOG.get().asItem());
            event.accept(BPBlocks.PEAR_WOOD.get().asItem());
            event.accept(BPBlocks.STRIPPED_PEAR_LOG.get().asItem());
            event.accept(BPBlocks.STRIPPED_PEAR_WOOD.get().asItem());
            event.accept(BPBlocks.PEAR_SAPLING.get().asItem());
            event.accept(BPBlocks.PEAR_LEAVES.get().asItem());
            // event.accept(MJBlocks.FLOWERING_PEAR_LEAVES.get().asItem());
        }
    }
}
