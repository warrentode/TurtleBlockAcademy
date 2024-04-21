package com.github.warrentode.turtleblockacademy.datagen.recipes;

import com.github.warrentode.turtleblockacademy.datagen.recipes.recipe.CraftingRecipesGen;
import com.github.warrentode.turtleblockacademy.datagen.recipes.recipe.CuttingRecipesGen;
import com.github.warrentode.turtleblockacademy.datagen.recipes.recipe.LootBagRecipesGen;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class RecipesGen extends RecipeProvider {
    public RecipesGen(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        CraftingRecipesGen.register(consumer);
        LootBagRecipesGen.register(consumer);
        CuttingRecipesGen.register(consumer);
    }
}
