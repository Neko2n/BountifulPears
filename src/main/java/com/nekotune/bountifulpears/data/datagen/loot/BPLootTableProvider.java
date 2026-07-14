package com.nekotune.bountifulpears.data.datagen.loot;

import java.util.Collections;
import java.util.List;

import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class BPLootTableProvider extends LootTableProvider {

    public BPLootTableProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), Collections.emptySet(),
                fetchSubProviders(), event.getLookupProvider());
    }

    private static final List<SubProviderEntry> fetchSubProviders() {
        return List.of(
            new SubProviderEntry(provider -> new BPBlockLootSubProvider(provider),
                    LootContextParamSets.BLOCK)
        );
    }
}
