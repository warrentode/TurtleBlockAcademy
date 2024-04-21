package com.github.warrentode.turtleblockacademy.datagen.recipes.recipe;

import com.github.warrentode.turtleblockacademy.util.PackTags;
import net.brnbrd.delightful.common.item.DelightfulItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

import java.util.function.Consumer;

public class CookingRecipesGen extends RecipeProvider implements IConditionBuilder {
    public CookingRecipesGen(DataGenerator generator) {
        super(generator);
    }

    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        delightful(consumer);
    }

    private void delightful(Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("delightful"))
                .addCondition(this.itemExists(DelightfulItems.ROCK_CANDY.getId().getNamespace(), DelightfulItems.ROCK_CANDY.getId().getPath()))
                .addCondition(this.not(this.tagEmpty(PackTags.Items.GEM_SHARDS)))
                .addRecipe(CookingPotRecipeBuilder.cookingPotRecipe(DelightfulItems.ROCK_CANDY.get(), 1, 200, 0.35F, Items.STICK)
                        .addIngredient(Ingredient.of(PackTags.Items.GEM_SHARDS), 2)
                        .addIngredient(PackTags.Items.SUGAR)
                        .unlockedBy("has_gem_shards", has(PackTags.Items.GEM_SHARDS))
                        ::build)
                .build(consumer, new ResourceLocation("delightful", "cooking/rock_candy"));
    }
}
