package com.github.warrentode.turtleblockacademy.recipe;

/*
 * Copyright (c) 2024 Warren Tode
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the “Software”), to deal in the
 * Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the
 * following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies
 * or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import com.github.warrentode.turtleblockacademy.util.IngredientRemainderUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.SingleThreadedRandomSource;
import net.minecraftforge.common.util.RecipeMatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ShapelessRemainderRecipe implements CraftingRecipe {
    public static final int INPUT_SLOTS = 9;
    private final ResourceLocation id;
    private final String group;
    private final NonNullList<Ingredient> inputItems;
    private final ItemStack result;

    public ShapelessRemainderRecipe(ResourceLocation id, String group, NonNullList<Ingredient> inputItems, @NotNull ItemStack result) {
        this.id = id;
        this.group = group;
        this.inputItems = inputItems;
        this.result = result;
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return this.id;
    }

    @Override
    public boolean matches(@NotNull CraftingContainer container, @NotNull Level level) {
        if (level.isClientSide()) {
            return false;
        }
        List<ItemStack> inputs = new ArrayList<>();
        int i = 0;

        for (int j = 0; j < container.getContainerSize(); ++j) {
            ItemStack itemStack = container.getItem(j);
            if (!itemStack.isEmpty()) {
                ++i;
                inputs.add(itemStack);
            }
        }

        return i == this.inputItems.size() && RecipeMatcher.findMatches(inputs, this.inputItems) != null;
    }

    public @NotNull ItemStack getResultItem() {
        return this.result;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull CraftingContainer container) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.inputItems.size();
    }

    @Override
    public @NotNull NonNullList<ItemStack> getRemainingItems(@NotNull CraftingContainer container) {
        NonNullList<ItemStack> remainderList =
                NonNullList.withSize(container.getContainerSize(), ItemStack.EMPTY);

        for (int i = 0; i < remainderList.size(); ++i) {
            ItemStack item = container.getItem(i);
            ItemStack durabilityAdjustedItem;
            if (item.hasCraftingRemainingItem()) {
                durabilityAdjustedItem = processRemainingItemDamage(container, item.getCraftingRemainingItem());
                remainderList.set(i, durabilityAdjustedItem);
            }
            else if (IngredientRemainderUtil.getRemainder(item.getItem()) != null) {
                ItemStack remainderStack = IngredientRemainderUtil.INGREDIENT_REMAINDER_OVERRIDES.get(item.getItem()).getDefaultInstance();
                durabilityAdjustedItem = processRemainingItemDamage(container, remainderStack);
                remainderList.set(i, durabilityAdjustedItem);
            }
        }

        return remainderList;
    }

    private @Nullable ItemStack processRemainingItemDamage(@NotNull CraftingContainer container, @NotNull ItemStack stack) {
        if (stack.isDamageableItem() || (stack.getTag() != null && !stack.getTag().getBoolean("Unbreaking"))) {
            if (stack.getDamageValue() >= stack.getMaxDamage() - 1) {
                stack.hurt(1, new SingleThreadedRandomSource(1), null);
                stack.shrink(1);
                stack.setDamageValue(0);
            }
            else {
                stack.hurt(1, new SingleThreadedRandomSource(1), null);
            }
        }

        return stack;
    }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        return this.inputItems;
    }

    @Override
    public @NotNull String getGroup() {
        return this.group;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return TBARecipes.SHAPELESS_REMAINDER_SERIALIZER.get();
    }

    public static class Serializer implements RecipeSerializer<ShapelessRemainderRecipe> {
        private static final ResourceLocation NAME = new ResourceLocation("minecraft", "crafting_shapeless");

        @Override
        public @NotNull ShapelessRemainderRecipe fromJson(@NotNull ResourceLocation id, @NotNull JsonObject jsonObject) {
            String group = GsonHelper.getAsString(jsonObject, "group", "");
            NonNullList<Ingredient> inputItems = readIngredients(GsonHelper.getAsJsonArray(jsonObject, "ingredients"));
            if (inputItems.isEmpty()) {
                throw new JsonParseException("No ingredients for shapeless recipe");
            }
            else if (inputItems.size() > INPUT_SLOTS) {
                throw new JsonParseException("Too many ingredients for shapeless recipe. The maximum is " + INPUT_SLOTS);
            }
            else {
                ItemStack result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "result"));
                return new ShapelessRemainderRecipe(id, group, inputItems, result);
            }
        }

        private static @NotNull NonNullList<Ingredient> readIngredients(@NotNull JsonArray ingredientArray) {
            NonNullList<Ingredient> ingredientList = NonNullList.create();

            for (int i = 0; i < ingredientArray.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(ingredientArray.get(i));
                if (!ingredient.isEmpty()) {
                    ingredientList.add(ingredient);
                }
            }

            return ingredientList;
        }

        public ShapelessRemainderRecipe fromNetwork(@NotNull ResourceLocation id, @NotNull FriendlyByteBuf buffer) {
            String group = buffer.readUtf();

            int i = buffer.readVarInt();
            NonNullList<Ingredient> inputItems = NonNullList.withSize(i, Ingredient.EMPTY);
            inputItems.replaceAll(ignored -> Ingredient.fromNetwork(buffer));

            ItemStack result = buffer.readItem();
            return new ShapelessRemainderRecipe(id, group, inputItems, result);
        }

        public void toNetwork(@NotNull FriendlyByteBuf buffer, @NotNull ShapelessRemainderRecipe recipe) {
            buffer.writeUtf(recipe.group);

            buffer.writeVarInt(recipe.inputItems.size());
            for (Ingredient ingredient : recipe.inputItems) {
                ingredient.toNetwork(buffer);
            }

            buffer.writeItem(recipe.result);
        }
    }
}