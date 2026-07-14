package com.nekotune.bountifulpears.shared.registries;

import com.nekotune.bountifulpears.shared.registries.content.BPBlocks;
import com.nekotune.bountifulpears.shared.registries.content.BPItems;

import net.neoforged.bus.api.IEventBus;

public final class MJRegistries {
    
    public static void registerAll(IEventBus modEventBus) {
        BPItems.ITEMS.register(modEventBus);
        BPBlocks.BLOCKS.register(modEventBus);
    }
}
