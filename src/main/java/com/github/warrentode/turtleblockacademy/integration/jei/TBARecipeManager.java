package com.github.warrentode.turtleblockacademy.integration.jei;

import com.github.warrentode.turtleblockacademy.recipe.TBARecipes;
import com.github.warrentode.turtleblockacademy.recipe.fermenting.FermentingPotRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

public class TBARecipeManager {
    private final RecipeManager recipeManager;

    TBARecipeManager() {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel level = minecraft.level;
        if (level != null) {
            this.recipeManager = level.getRecipeManager();
        }
        else {
            throw new NullPointerException("minecraft world must not be null.");
        }
    }

    public List<FermentingPotRecipe> getFermentingPotRecipes() {
        return this.recipeManager.getAllRecipesFor(TBARecipes.RECIPE_TYPE_FERMENTING.get()).stream().toList();
    }
}
