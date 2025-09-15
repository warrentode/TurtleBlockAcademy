package com.github.warrentode.turtleblockacademy.datagen.recipes.builder;

import com.github.warrentode.turtleblockacademy.recipe.TBARecipes;
import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
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

public class ShapelessRemainderRecipeBuilder {
    @Nullable
    private String group;
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final Item result;
    private final int count;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    public ShapelessRemainderRecipeBuilder(Item result, int count) {
        this.group = null;
        this.result = result;
        this.count = count;
    }

    @Contract("_ -> new")
    public static @NotNull ShapelessRemainderRecipeBuilder recipe(Item result) {
        return new ShapelessRemainderRecipeBuilder(result, 1);
    }

    @Contract("_, _ -> new")
    public static @NotNull ShapelessRemainderRecipeBuilder recipe(Item result, int count) {
        return new ShapelessRemainderRecipeBuilder(result, count);
    }

    public ShapelessRemainderRecipeBuilder addIngredient(TagKey<Item> tagIn) {
        return this.addIngredient(Ingredient.of(tagIn));
    }

    public ShapelessRemainderRecipeBuilder addIngredient(ItemLike itemIn) {
        return this.addIngredient(itemIn, 1);
    }

    public ShapelessRemainderRecipeBuilder addIngredient(ItemLike itemIn, int quantity) {
        for (int i = 0; i < quantity; ++i) {
            this.addIngredient(Ingredient.of(itemIn));
        }

        return this;
    }

    public ShapelessRemainderRecipeBuilder addIngredient(Ingredient ingredientIn) {
        return this.addIngredient(ingredientIn, 1);
    }

    public ShapelessRemainderRecipeBuilder addIngredient(Ingredient ingredientIn, int quantity) {
        for (int i = 0; i < quantity; ++i) {
            this.ingredients.add(ingredientIn);
        }

        return this;
    }

    public ShapelessRemainderRecipeBuilder unlockedBy(String criterionName, CriterionTriggerInstance criterionTrigger) {
        this.advancement.addCriterion(criterionName, criterionTrigger);
        return this;
    }

    public ShapelessRemainderRecipeBuilder unlockedByItems(String criterionName, ItemLike... items) {
        return this.unlockedBy(criterionName, InventoryChangeTrigger.TriggerInstance.hasItems(items));
    }

    public ShapelessRemainderRecipeBuilder unlockedByAnyIngredient(ItemLike... items) {
        this.advancement.addCriterion("has_any_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items).build()));
        return this;
    }

    public ShapelessRemainderRecipeBuilder setGroup(String group) {
        this.group = group;
        return this;
    }

    public void build(Consumer<FinishedRecipe> consumerIn) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(this.result);
        if (location != null) {
            this.build(consumerIn, "turtleblockacademy:" + location.getPath());
        }
        else {
            throw new IllegalStateException(this.result + " needs a file location!");
        }
    }

    public void build(Consumer<FinishedRecipe> consumerIn, String save) {
        ResourceLocation resourcelocation = ForgeRegistries.ITEMS.getKey(this.result);
        if ((new ResourceLocation(save)).equals(resourcelocation)) {
            throw new IllegalStateException("Fermenting Recipe " + save + " needs a unique 'save' file location!");
        }
        else {
            this.build(consumerIn, new ResourceLocation(save));
        }
    }

    public void build(Consumer<FinishedRecipe> consumerIn, ResourceLocation id) {
        if (!this.advancement.getCriteria().isEmpty()) {
            this.advancement.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id)).rewards(AdvancementRewards.Builder.recipe(id)).requirements(RequirementsStrategy.OR);
            String namespace = id.getNamespace();
            assert this.result.getItemCategory() != null;
            String folderName = this.result.getItemCategory().getRecipeFolderName();
            ResourceLocation advancementId = new ResourceLocation(namespace, "recipes/" + folderName + "/" + id.getPath());
            consumerIn.accept(new ShapelessRemainderRecipeBuilder.Result(id, this.group,
                    this.ingredients, this.result, this.count, this.advancement, advancementId));
        }
        else {
            consumerIn.accept(new ShapelessRemainderRecipeBuilder.Result(id, this.group, this.ingredients, this.result, this.count));
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final String group;
        private final List<Ingredient> ingredients;
        private final Item result;
        private final int count;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation id, String group, List<Ingredient> ingredients, Item result, int count, Advancement.Builder advancement, ResourceLocation advancementId) {
            this.id = id;
            this.group = group;
            this.ingredients = ingredients;
            this.result = result;
            this.count = count;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        public Result(ResourceLocation id, @Nullable String group, List<Ingredient> ingredients, Item result, int count) {
            this(id, null, ingredients, result, count, null, null);
        }

        public void serializeRecipeData(@NotNull JsonObject json) {
            if (group != null) {
                json.addProperty("group", group);
            }

            JsonArray arrayIngredients = new JsonArray();
            for (Ingredient ingredient : this.ingredients) {
                arrayIngredients.add(ingredient.toJson());
            }
            json.add("ingredients", arrayIngredients);

            JsonObject objectResult = new JsonObject();
            objectResult.addProperty("item", Objects.requireNonNull(
                    ForgeRegistries.ITEMS.getKey(this.result)).toString());
            if (this.count > 1) {
                objectResult.addProperty("count", this.count);
            }
            json.add("result", objectResult);
        }

        public @NotNull ResourceLocation getId() {
            return this.id;
        }

        public @NotNull RecipeSerializer<?> getType() {
            return TBARecipes.SHAPELESS_REMAINDER_SERIALIZER.get();
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