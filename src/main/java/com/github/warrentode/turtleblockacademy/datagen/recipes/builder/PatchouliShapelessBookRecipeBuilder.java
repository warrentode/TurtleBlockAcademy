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
import vazkii.patchouli.common.recipe.ShapelessBookRecipe;

import java.util.List;
import java.util.function.Consumer;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class PatchouliShapelessBookRecipeBuilder {
    private final String saveName;
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final int count;

    public PatchouliShapelessBookRecipeBuilder(String saveName, int  count) {
        this.saveName = saveName;
        this.count = count;
    }

    public static PatchouliShapelessBookRecipeBuilder writeRecipe(String saveName, int count) {
        return new PatchouliShapelessBookRecipeBuilder(saveName, count);
    }

    @SuppressWarnings("unused")
    public PatchouliShapelessBookRecipeBuilder addIngredient(TagKey<Item> tagIn) {
        return this.addIngredient(Ingredient.of(tagIn));
    }

    public PatchouliShapelessBookRecipeBuilder addIngredient(ItemLike itemIn) {
        return this.addIngredient(itemIn, 1);
    }

    public PatchouliShapelessBookRecipeBuilder addIngredient(ItemLike itemIn, int count) {
        for(int i = 0; i < count; ++i) {
            this.addIngredient(Ingredient.of(itemIn));
        }

        return this;
    }

    public PatchouliShapelessBookRecipeBuilder addIngredient(Ingredient ingredientIn) {
        return this.addIngredient(ingredientIn, 1);
    }

    public PatchouliShapelessBookRecipeBuilder addIngredient(Ingredient ingredientIn, int quantity) {
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
            JsonObject objectResult = new JsonObject();
            if (this.count > 1) {
                objectResult.addProperty("count", this.count);
            }

            json.addProperty("book", String.valueOf(save));
        }

        @Override
        public @NotNull ResourceLocation getId() {
            return new ResourceLocation("patchouli", save.getPath());
        }

        @Override
        public @NotNull RecipeSerializer<?> getType() {
            return ShapelessBookRecipe.SERIALIZER;
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
