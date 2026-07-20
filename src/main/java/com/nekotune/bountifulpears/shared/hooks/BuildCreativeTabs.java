package com.nekotune.bountifulpears.shared.hooks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.nekotune.bountifulpears.shared.registries.content.BPBlocks;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.integration.NoMansLandIntegration;
import net.hecco.bountifulfares.registry.misc.BFItemGroups;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@EventBusSubscriber
public class BuildCreativeTabs {
    
    @SubscribeEvent
    public static void onBuildCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        final CreativeModeTab tab = event.getTab();
        final var tabKey = event.getTabKey();
        if (tab == BFItemGroups.COMPATIBILITY.get()) {
            addOrdered(BPBlocks.PEAR_LOG);
            addOrdered(BPBlocks.PEAR_WOOD);
            addOrdered(BPBlocks.STRIPPED_PEAR_LOG);
            addOrdered(BPBlocks.STRIPPED_PEAR_WOOD);
            addOrdered(BPBlocks.PEAR_SAPLING);
            addOrdered(BPBlocks.PEAR_LEAVES);
            // addOrdered(BPBlocks.FLOWERING_PEAR_LEAVES);
            addOrdered(BPBlocks.PEAR_BLOCK);
            flushOrdered(event, NoMansLandIntegration.CANDIED_PEAR);
        } else if (tabKey == CreativeModeTabs.BUILDING_BLOCKS) {
            addOrdered(BPBlocks.PEAR_LOG);
            addOrdered(BPBlocks.PEAR_WOOD);
            addOrdered(BPBlocks.STRIPPED_PEAR_LOG);
            addOrdered(BPBlocks.STRIPPED_PEAR_WOOD);
            flushOrdered(event, BFBlocks.STRIPPED_APPLE_WOOD);
        } else if (tabKey == CreativeModeTabs.NATURAL_BLOCKS) {
            insertAfter(event, BPBlocks.PEAR_LOG, BFBlocks.APPLE_LOG);
            insertAfter(event, BPBlocks.PEAR_LEAVES, BFBlocks.FLOWERING_APPLE_LEAVES);
            insertAfter(event, BPBlocks.PEAR_SAPLING, BFBlocks.APPLE_SAPLING);
        } else if (tabKey == CreativeModeTabs.FOOD_AND_DRINKS) {
            insertAfter(event, BPBlocks.PEAR_BLOCK, BFBlocks.APPLE_BLOCK);
        }
    }

    private static void insertAfter(final BuildCreativeModeTabContentsEvent event, final Supplier<? extends ItemLike> item, final Supplier<? extends ItemLike> existing) {
        event.insertAfter(existing.get().asItem().getDefaultInstance(), item.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    private static List<ItemStack> ordered = new ArrayList<>();

    private static void addOrdered(final Supplier<? extends ItemLike> item) {
        ordered.add(item.get().asItem().getDefaultInstance());
    }

    private static void flushOrdered(final BuildCreativeModeTabContentsEvent event, final Supplier<? extends ItemLike> insertAfterExisting) {
        ItemStack previous = insertAfterExisting.get().asItem().getDefaultInstance();
        for (final ItemStack toInsert : ordered) {
            event.insertAfter(previous, toInsert, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            previous = toInsert;
        }
        ordered.clear();
    }
}
