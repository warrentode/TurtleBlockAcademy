package com.github.warrentode.turtleblockacademy.datagen.recipes.builder;

import com.github.warrentode.turtleblockacademy.recipe.TBARecipes;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
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
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

public class ShapedRemainderRecipeBuilder {
    private final Item result;
    private final int count;
    private final List<String> rows = Lists.newArrayList();
    private final Map<Character, Ingredient> keyMap = Maps.newLinkedHashMap();
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    @Nullable
    private String group;

    public ShapedRemainderRecipeBuilder(Item result, int count) {
        this.group = null;
        this.result = result;
        this.count = count;
    }

    @Contract("_ -> new")
    public static @NotNull ShapedRemainderRecipeBuilder recipe(Item result) {
        return new ShapedRemainderRecipeBuilder(result, 1);
    }

    @Contract("_, _ -> new")
    public static @NotNull ShapedRemainderRecipeBuilder recipe(Item result, int count) {
        return new ShapedRemainderRecipeBuilder(result, count);
    }

    public ShapedRemainderRecipeBuilder define(Character symbol, TagKey<Item> tagKey) {
        return this.define(symbol, Ingredient.of(tagKey));
    }

    public ShapedRemainderRecipeBuilder define(Character symbol, ItemLike itemLike) {
        return this.define(symbol, Ingredient.of(itemLike));
    }

    public ShapedRemainderRecipeBuilder define(Character symbol, Ingredient ingredient) {
        if (this.keyMap.containsKey(symbol)) {
            throw new IllegalArgumentException("Symbol '" + symbol + "' is already defined!");
        }
        else if (symbol == ' ') {
            throw new IllegalArgumentException("Symbol ' ' (whitespace) is reserved and cannot be defined");
        }
        else {
            this.keyMap.put(symbol, ingredient);
            return this;
        }
    }

    public ShapedRemainderRecipeBuilder pattern(String pattern) {
        if (!this.rows.isEmpty() && pattern.length() != this.rows.get(0).length()) {
            throw new IllegalArgumentException("Pattern must be the same width on every line!");
        }
        else {
            this.rows.add(pattern);
            return this;
        }
    }

    public ShapedRemainderRecipeBuilder unlockedBy(String criterionName, CriterionTriggerInstance criterionTrigger) {
        this.advancement.addCriterion(criterionName, criterionTrigger);
        return this;
    }

    public ShapedRemainderRecipeBuilder unlockedByItems(String criterionName, ItemLike... items) {
        return this.unlockedBy(criterionName, InventoryChangeTrigger.TriggerInstance.hasItems(items));
    }

    public ShapedRemainderRecipeBuilder unlockedByAnyIngredient(ItemLike... items) {
        this.advancement.addCriterion("has_any_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items).build()));
        return this;
    }

    public ShapedRemainderRecipeBuilder setGroup(String group) {
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
            throw new IllegalStateException("Shaped Remainder Recipe " + save + " needs a unique 'save' file location!");
        }
        else {
            this.build(consumerIn, new ResourceLocation(save));
        }
    }

    public void build(Consumer<FinishedRecipe> consumerIn, ResourceLocation id) {
        this.ensureValid(id);
        if (!this.advancement.getCriteria().isEmpty()) {
            this.advancement.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id)).rewards(AdvancementRewards.Builder.recipe(id)).requirements(RequirementsStrategy.OR);
            String namespace = id.getNamespace();
            assert this.result.getItemCategory() != null;
            String folderName = this.result.getItemCategory().getRecipeFolderName();
            ResourceLocation advancementId = new ResourceLocation(namespace, "recipes/" + folderName + "/" + id.getPath());
            consumerIn.accept(new ShapedRemainderRecipeBuilder.Result(id, this.result, this.count,
                    this.group, this.rows, this.keyMap, this.advancement, advancementId));
        }
        else {
            consumerIn.accept(new ShapedRemainderRecipeBuilder.Result(id, this.result, this.count,
                    this.group, this.rows, this.keyMap));
        }
    }

    private void ensureValid(ResourceLocation id) {
        if (this.rows.isEmpty()) {
            throw new IllegalStateException("No pattern is defined for shaped recipe " + id + "!");
        }
        else {
            Set<Character> set = Sets.newHashSet(this.keyMap.keySet());
            set.remove(' ');

            for (String patternString : this.rows) {
                for (int i = 0; i < patternString.length(); ++i) {
                    char symbol = patternString.charAt(i);
                    if (!this.keyMap.containsKey(symbol) && symbol != ' ') {
                        throw new IllegalStateException("Pattern in recipe " + id + " uses undefined symbol '" + symbol + "'");
                    }

                    set.remove(symbol);
                }
            }

            if (!set.isEmpty()) {
                throw new IllegalStateException("Ingredients are defined but not used in pattern for recipe " + id);
            }
            else if (this.rows.size() == 1 && this.rows.get(0).length() == 1) {
                throw new IllegalStateException("Shaped recipe " + id + " only takes in a single item - should it be a shapeless recipe instead?");
            }
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Item result;
        private final int count;
        private final String group;
        private final List<String> pattern;
        private final Map<Character, Ingredient> keyMap;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation id, Item result, int count, String group, List<String> pattern, Map<Character, Ingredient> keyMap, Advancement.Builder advancement, ResourceLocation advancementId) {
            this.id = id;
            this.result = result;
            this.count = count;
            this.group = group;
            this.pattern = pattern;
            this.keyMap = keyMap;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        public Result(ResourceLocation id, Item result, int count, @Nullable String group, List<String> pattern, Map<Character, Ingredient> keyMap) {
            this(id, result, count, null, pattern, keyMap, null, null);
        }

        public void serializeRecipeData(@NotNull JsonObject json) {
            if (group != null) {
                json.addProperty("group", group);
            }

            JsonArray jsonArray = new JsonArray();
            for (String patternString : this.pattern) {
                jsonArray.add(patternString);
            }
            json.add("pattern", jsonArray);

            JsonObject keyMapObject = new JsonObject();
            for (Map.Entry<Character, Ingredient> entry : this.keyMap.entrySet()) {
                keyMapObject.add(String.valueOf(entry.getKey()), entry.getValue().toJson());
            }
            json.add("key", keyMapObject);

            JsonObject itemObject = new JsonObject();
            itemObject.addProperty("item", Objects.requireNonNull(
                    ForgeRegistries.ITEMS.getKey(this.result)).toString());
            if (this.count > 1) {
                itemObject.addProperty("count", this.count);
            }
            json.add("result", itemObject);
        }

        public @NotNull ResourceLocation getId() {
            return this.id;
        }

        public @NotNull RecipeSerializer<?> getType() {
            return TBARecipes.SHAPED_REMAINDER_SERIALIZER.get();
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