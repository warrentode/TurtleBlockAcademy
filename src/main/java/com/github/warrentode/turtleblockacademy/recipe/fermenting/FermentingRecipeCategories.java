package com.github.warrentode.turtleblockacademy.recipe.fermenting;

import com.github.warrentode.turtleblockacademy.items.TBAItems;
import com.github.warrentode.turtleblockacademy.recipe.TBARecipes;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class FermentingRecipeCategories {
    public static final Supplier<RecipeBookCategories> FERMENTING_SEARCH = Suppliers.memoize(() -> RecipeBookCategories.create("FERMENTING_SEARCH", new ItemStack(Items.COMPASS)));
    public static final Supplier<RecipeBookCategories> LIQUIDS = Suppliers.memoize(() -> RecipeBookCategories.create("LIQUIDS", new ItemStack(TBAItems.BEET_WINE.get())));
    public static final Supplier<RecipeBookCategories> PICKLES = Suppliers.memoize(() -> RecipeBookCategories.create("PICKLES", new ItemStack(TBAItems.BEET_PICKLES.get())));
    public static final Supplier<RecipeBookCategories> AGENTS = Suppliers.memoize(() -> RecipeBookCategories.create("AGENTS", new ItemStack(TBAItems.YEAST.get())));

    public static void init(@NotNull RegisterRecipeBookCategoriesEvent event) {
        event.registerBookCategories(TBARecipes.RECIPE_BOOK_FERMENTING, ImmutableList.of(FERMENTING_SEARCH.get(), LIQUIDS.get(), PICKLES.get(), AGENTS.get()));
        event.registerAggregateCategory(FERMENTING_SEARCH.get(), ImmutableList.of(LIQUIDS.get(), PICKLES.get(), AGENTS.get()));
        event.registerRecipeCategoryFinder(TBARecipes.RECIPE_TYPE_FERMENTING.get(), (recipe) -> {
            if (recipe instanceof FermentingPotRecipe fermentingPotRecipe) {
                FermentingRecipeBookTab tab = fermentingPotRecipe.getRecipeBookTab();
                if (tab != null) {
                    return switch (tab) {
                        case LIQUIDS -> LIQUIDS.get();
                        case PICKLES -> PICKLES.get();
                        case AGENTS -> AGENTS.get();
                    };
                }
            }

            // If no tab is specified in recipe, this fallback organizes them instead
            return AGENTS.get();
        });
    }
}