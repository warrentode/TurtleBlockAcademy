package com.github.warrentode.turtleblockacademy.datagen.recipes.builder;

import com.github.warrentode.turtleblockacademy.recipe.TBARecipes;
import com.github.warrentode.turtleblockacademy.recipe.fermenting.FermentingRecipeBookTab;
import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.MethodsReturnNonnullByDefault;
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

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class FermentingPotRecipeBuilder {
    private FermentingRecipeBookTab tab;
    private String group;
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final Item result;
    private final int count;
    private final int fermentingTime;
    private final float experience;
    private final Item container;
    private final Item cover;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    private FermentingPotRecipeBuilder(ItemLike resultIn, int count, int fermentingTime, float experience, ItemLike cover, @Nullable ItemLike container) {
        this.result = resultIn.asItem();
        this.count = count;
        this.fermentingTime = fermentingTime;
        this.experience = experience;
        this.container = container != null ? container.asItem() : null;
        this.cover = cover.asItem();
        this.tab = null;
        this.group = null;
    }

    public static FermentingPotRecipeBuilder fermentingPotRecipe(ItemLike mainResult, int count, int fermentingTime, float experience, ItemLike cover) {
        return new FermentingPotRecipeBuilder(mainResult, count, fermentingTime, experience, cover, null);
    }

    public static FermentingPotRecipeBuilder fermentingPotRecipe(ItemLike mainResult, int count, int fermentingTime, float experience, ItemLike cover, ItemLike container) {
        return new FermentingPotRecipeBuilder(mainResult, count, fermentingTime, experience, cover, container);
    }

    public FermentingPotRecipeBuilder addIngredient(TagKey<Item> tagIn) {
        return this.addIngredient(Ingredient.of(tagIn));
    }

    public FermentingPotRecipeBuilder addIngredient(ItemLike itemIn) {
        return this.addIngredient(itemIn, 1);
    }

    public FermentingPotRecipeBuilder addIngredient(ItemLike itemIn, int quantity) {
        for (int i = 0; i < quantity; ++i) {
            this.addIngredient(Ingredient.of(itemIn));
        }

        return this;
    }

    public FermentingPotRecipeBuilder addIngredient(Ingredient ingredientIn) {
        return this.addIngredient(ingredientIn, 1);
    }

    public FermentingPotRecipeBuilder addIngredient(Ingredient ingredientIn, int quantity) {
        for (int i = 0; i < quantity; ++i) {
            this.ingredients.add(ingredientIn);
        }

        return this;
    }

    public FermentingPotRecipeBuilder unlockedBy(String criterionName, CriterionTriggerInstance criterionTrigger) {
        this.advancement.addCriterion(criterionName, criterionTrigger);
        return this;
    }

    public FermentingPotRecipeBuilder unlockedByItems(String criterionName, ItemLike... items) {
        return this.unlockedBy(criterionName, InventoryChangeTrigger.TriggerInstance.hasItems(items));
    }

    public FermentingPotRecipeBuilder unlockedByAnyIngredient(ItemLike... items) {
        this.advancement.addCriterion("has_any_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items).build()));
        return this;
    }

    public FermentingPotRecipeBuilder setRecipeBookTab(FermentingRecipeBookTab tab) {
        this.tab = tab;
        return this;
    }

    public FermentingPotRecipeBuilder setGroup(String group) {
        this.group = group;
        return this;
    }

    public void build(Consumer<FinishedRecipe> consumerIn) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(this.result);
        if (location != null) {
            this.build(consumerIn, "turtleblockacademy:fermenting/" + location.getPath());
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
            consumerIn.accept(new Result(id, this.tab, this.group, this.fermentingTime, this.experience, this.ingredients, this.cover, this.container, this.result, this.count, this.advancement, advancementId));
        }
        else {
            consumerIn.accept(new Result(id, this.tab, this.group, this.fermentingTime, this.experience, this.ingredients, this.cover, this.container, this.result, this.count));
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final FermentingRecipeBookTab tab;
        private final String group;
        private final List<Ingredient> ingredients;
        private final Item result;
        private final int count;
        private final int fermentingTime;
        private final float experience;
        private final Item cover;
        private final Item container;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation idIn, @Nullable FermentingRecipeBookTab tabIn, @Nullable String groupIn, int fermentingTimeIn, float experienceIn, List<Ingredient> ingredientsIn, Item coverIn, @Nullable Item containerIn, Item resultIn, int countIn, @Nullable Advancement.Builder advancement, @Nullable ResourceLocation advancementId) {
            this.id = idIn;
            this.tab = tabIn;
            this.group = groupIn;
            this.ingredients = ingredientsIn;
            this.result = resultIn;
            this.count = countIn;
            this.fermentingTime = fermentingTimeIn;
            this.experience = experienceIn;
            this.container = containerIn;
            this.cover = coverIn;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        public Result(ResourceLocation idIn, @Nullable FermentingRecipeBookTab tabIn, @Nullable String groupIn, int fermentingTimeIn, float experienceIn, List<Ingredient> ingredientsIn, Item coverIn, @Nullable Item containerIn, Item resultIn, int countIn) {
            this(idIn, tabIn, groupIn, fermentingTimeIn, experienceIn, ingredientsIn,coverIn, containerIn, resultIn, countIn, null, null);
        }

        public void serializeRecipeData(JsonObject json) {
            if (this.tab != null) {
                json.addProperty("recipe_book_tab", this.tab.toString());
            }
            if (group != null) {
                json.addProperty("group", group);
            }
            if (this.experience > 0.0F) {
                json.addProperty("experience", this.experience);
            }
            json.addProperty("fermenting_time", this.fermentingTime);

            JsonObject objectCover = new JsonObject();
            objectCover.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(this.cover)).toString());
            json.add("cover", objectCover);

            if (this.container != null) {
                JsonObject objectContainer = new JsonObject();
                objectContainer.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(this.container)).toString());
                json.add("container", objectContainer);
            }

            JsonArray arrayIngredients = new JsonArray();
            for (Ingredient ingredient : this.ingredients) {
                arrayIngredients.add(ingredient.toJson());
            }
            json.add("ingredients", arrayIngredients);

            JsonObject objectResult = new JsonObject();
            objectResult.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(this.result)).toString());
            if (this.count > 1) {
                objectResult.addProperty("count", this.count);
            }
            json.add("result", objectResult);
        }

        public ResourceLocation getId() {
            return this.id;
        }

        public RecipeSerializer<?> getType() {
            return TBARecipes.FERMENTING_SERIALIZER.get();
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