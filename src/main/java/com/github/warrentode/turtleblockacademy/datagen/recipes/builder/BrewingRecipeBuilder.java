package com.github.warrentode.turtleblockacademy.datagen.recipes.builder;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lekavar.lma.drinkbeer.registries.RecipeRegistry;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class BrewingRecipeBuilder {
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final Item result;
    private final int brewingTime;
    private final Item cup;
    private final int count;

    public BrewingRecipeBuilder(@NotNull ItemLike result, int brewingTime, @NotNull ItemLike cup, int count) {
        this.result = result.asItem();
        this.brewingTime = brewingTime;
        this.cup = cup.asItem();
        this.count = count;
    }

    @Contract("_, _, _, _ -> new")
    public static @NotNull BrewingRecipeBuilder brewingRecipe(ItemLike result, int brewingTime, ItemLike cup, int count) {
        return new BrewingRecipeBuilder(result, brewingTime, cup, count);
    }

    public BrewingRecipeBuilder addIngredient(TagKey<Item> tagIn) {
        return this.addIngredient(Ingredient.of(tagIn));
    }

    public BrewingRecipeBuilder addIngredient(ItemLike itemIn) {
        return this.addIngredient(itemIn, 1);
    }

    public BrewingRecipeBuilder addIngredient(ItemLike itemIn, int quantity) {
        for(int i = 0; i < quantity; ++i) {
            this.addIngredient(Ingredient.of(itemIn));
        }

        return this;
    }

    public BrewingRecipeBuilder addIngredient(Ingredient ingredientIn) {
        return this.addIngredient(ingredientIn, 1);
    }

    public BrewingRecipeBuilder addIngredient(Ingredient ingredientIn, int quantity) {
        for(int i = 0; i < quantity; ++i) {
            this.ingredients.add(ingredientIn);
        }

        return this;
    }

    public void build(Consumer<FinishedRecipe> consumerIn) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(this.result);
        if (location != null) {
            this.build(consumerIn, "drinkbeer:" + location.getPath());
        }
        else {
            throw new IllegalStateException("Brewing Recipe for " + this.result + " needs a file name!");
        }
    }

    public void build(Consumer<FinishedRecipe> consumerIn, String save) {
        ResourceLocation resourcelocation = ForgeRegistries.ITEMS.getKey(this.result);
        if ((new ResourceLocation(save)).equals(resourcelocation)) {
            throw new IllegalStateException("Brewing Recipe " + save + " should remove its 'save' argument!");
        } else {
            this.build(consumerIn, new ResourceLocation(save));
        }
    }

    public void build(Consumer<FinishedRecipe> consumerIn, ResourceLocation id) {
        consumerIn.accept(new BrewingRecipeBuilder.Result(id, this.result, this.cup, this.count, this.ingredients, this.brewingTime));
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final List<Ingredient> ingredients;
        private final Item result;
        private final int count;
        private final int brewingTime;
        private final Item cup;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation idIn, Item resultIn, Item cupIn, int countIn, List<Ingredient> ingredientsIn, int brewingTimeIn, @Nullable Advancement.Builder advancement, @Nullable ResourceLocation advancementId) {
            this.id = idIn;
            this.ingredients = ingredientsIn;
            this.result = resultIn;
            this.count = countIn;
            this.brewingTime = brewingTimeIn;
            this.cup = cupIn;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        public Result(ResourceLocation idIn, Item resultIn, Item cupIn, int countIn, List<Ingredient> ingredientsIn, int brewingTimeIn) {
            this(idIn, resultIn, cupIn, countIn, ingredientsIn, brewingTimeIn, null, null);
        }

        public void serializeRecipeData(@NotNull JsonObject json) {
            JsonArray arrayIngredients = new JsonArray();

            for (Ingredient ingredient : this.ingredients) {
                arrayIngredients.add(ingredient.toJson());
            }

            json.add("ingredients", arrayIngredients);
            JsonObject objectResult = new JsonObject();
            objectResult.addProperty("item",
                    Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(this.result)).toString());

            json.add("result", objectResult);

            JsonObject objectContainer = new JsonObject();
            objectContainer.addProperty("item",
                    Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(this.cup)).toString());
            json.add("cup", objectContainer);
            if (this.count > 1) {
                objectContainer.addProperty("count", this.count);
                objectResult.addProperty("count", this.count);
            }

            json.addProperty("brewing_time", this.brewingTime);
        }

        public @NotNull ResourceLocation getId() {
            return this.id;
        }

        public @NotNull RecipeSerializer<?> getType() {
            return RecipeRegistry.RECIPE_SERIALIZER_BREWING.get();
        }

        @Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement != null ? this.advancement.serializeToJson() : null;
        }

        @Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
