package com.github.warrentode.turtleblockacademy.datagen.recipes;

import com.github.warrentode.turtleblockacademy.datagen.recipes.recipe.CraftingRecipesGen;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.function.Consumer;

public class RecipesGen extends RecipeProvider {
    public RecipesGen(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        CraftingRecipesGen.register(consumer);
    }
}
