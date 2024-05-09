package com.github.warrentode.turtleblockacademy.datagen.recipes.builder;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class StringValueShapelessRecipeBuilder {
    private final String saveName;
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final int count;

    public StringValueShapelessRecipeBuilder(String saveName, int  count) {
        this.saveName = saveName;
        this.count = count;
    }

    public static StringValueShapelessRecipeBuilder writeRecipe(String saveName, int count) {
        return new StringValueShapelessRecipeBuilder(saveName, count);
    }

    public StringValueShapelessRecipeBuilder addIngredient(TagKey<Item> tagIn) {
        return this.addIngredient(Ingredient.of(tagIn));
    }

    public StringValueShapelessRecipeBuilder addIngredient(ItemLike itemIn) {
        return this.addIngredient(itemIn, 1);
    }

    public StringValueShapelessRecipeBuilder addIngredient(ItemLike itemIn, int count) {
        for(int i = 0; i < count; ++i) {
            this.addIngredient(Ingredient.of(itemIn));
        }

        return this;
    }

    public StringValueShapelessRecipeBuilder addIngredient(Ingredient ingredientIn) {
        return this.addIngredient(ingredientIn, 1);
    }

    public StringValueShapelessRecipeBuilder addIngredient(Ingredient ingredientIn, int quantity) {
        for(int i = 0; i < quantity; ++i) {
            this.ingredients.add(ingredientIn);
        }

        return this;
    }

    @SuppressWarnings("unused")
    public void build(Consumer<FinishedRecipe> consumerIn) {
        ResourceLocation save = new ResourceLocation(MODID, saveName);
        finish(consumerIn, save);
    }

    public void finish(Consumer<FinishedRecipe> consumerIn, ResourceLocation save) {
        consumerIn.accept(new Result(save, ingredients, count));
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation save;
        private final List<Ingredient> ingredients;
        private final int count;

        public Result(ResourceLocation save, List<Ingredient> ingredients, int count, @Nullable Advancement.Builder ignoredAdvancement, @Nullable ResourceLocation ignoredAdvancementId) {
            this.save = save;
            this.ingredients = ingredients;
            this.count = count;
        }

        public Result(ResourceLocation save, List<Ingredient> ingredients, int count) {
            this(save, ingredients, count, null, null);
        }

        @Override
        public void serializeRecipeData(@NotNull JsonObject json) {
            JsonArray arrayIngredients = new JsonArray();
            for (Ingredient ingredient : this.ingredients) {
                arrayIngredients.add(ingredient.toJson());
            }
            json.add("ingredients", arrayIngredients);
            JsonObject objectIngredients = new JsonObject();
            if (this.count > 1) {
                objectIngredients.addProperty("count", this.count);
            }

            JsonObject objectResult = new JsonObject();
            objectResult.addProperty("item", String.valueOf(save));
            objectResult.addProperty("count", Math.max(count, 1));
            json.add("result", objectResult);
        }

        @Override
        public @NotNull ResourceLocation getId() {
            return save;
        }

        @Override
        public @NotNull RecipeSerializer<?> getType() {
            return RecipeSerializer.SHAPELESS_RECIPE;
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }
}
