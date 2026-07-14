package com.nekotune.bountifulpears.data.datagen.recipes;

import com.farcr.nomansland.common.registry.items.NMLItems;
import com.nekotune.bountifulpears.shared.registries.content.BPBlocks;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class BPRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public BPRecipeProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(),
                event.getLookupProvider());
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        final ItemLike pearBlock = BPBlocks.PEAR_BLOCK.get();
        final ItemLike pear = NMLItems.PEAR.get();
        final ItemLike pearLog = BPBlocks.PEAR_LOG.get();
        final ItemLike strippedPearLog = BPBlocks.STRIPPED_PEAR_LOG.get();
        final ItemLike pearWood = BPBlocks.PEAR_WOOD.get();
        final ItemLike strippedPearWood = BPBlocks.STRIPPED_PEAR_WOOD.get();
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pear, 9)
            .requires(pearBlock)
            .unlockedBy(getHasName(pearBlock), has(pearBlock))
            .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pearBlock)
            .requires(pear, 9)
            .unlockedBy(getHasName(pear), has(pear))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pearWood, 3)
            .pattern("##")
            .pattern("##")
            .define('#', pearLog)
            .unlockedBy(getHasName(pearLog), has(pearLog))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, strippedPearWood, 3)
            .pattern("##")
            .pattern("##")
            .define('#', strippedPearLog)
            .unlockedBy(getHasName(strippedPearLog), has(strippedPearLog))
            .save(recipeOutput);
    }
}
