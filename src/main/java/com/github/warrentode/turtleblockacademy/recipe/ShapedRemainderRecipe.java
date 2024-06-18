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
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.SingleThreadedRandomSource;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IShapedRecipe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

public class ShapedRemainderRecipe implements CraftingRecipe, IShapedRecipe<CraftingContainer> {
    static int MAX_WIDTH = 3;
    static int MAX_HEIGHT = 3;

    public static void setCraftingSize(int width, int height) {
        if (MAX_WIDTH < width) MAX_WIDTH = width;
        if (MAX_HEIGHT < height) MAX_HEIGHT = height;
    }

    final int width;
    final int height;
    private final ResourceLocation id;
    private final String group;
    private final NonNullList<Ingredient> inputItems;
    private final ItemStack result;

    public ShapedRemainderRecipe(int width, int height, ResourceLocation id, String group, NonNullList<Ingredient> inputItems, ItemStack result) {
        this.width = width;
        this.height = height;
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
        for (int i = 0; i <= container.getWidth() - this.width; ++i) {
            for (int j = 0; j <= container.getHeight() - this.height; ++j) {
                if (this.matches(container, i, j, true)) {
                    return true;
                }

                if (this.matches(container, i, j, false)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean matches(@NotNull CraftingContainer container, int width, int height, boolean mirrored) {
        for (int i = 0; i < container.getWidth(); ++i) {
            for (int j = 0; j < container.getHeight(); ++j) {
                int k = i - width;
                int l = j - height;
                Ingredient ingredient = Ingredient.EMPTY;
                if (k >= 0 && l >= 0 && k < this.width && l < this.height) {
                    if (mirrored) {
                        ingredient = this.inputItems.get(this.width - k - 1 + l * this.width);
                    }
                    else {
                        ingredient = this.inputItems.get(k + l * this.width);
                    }
                }

                if (!ingredient.test(container.getItem(i + j * container.getWidth()))) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem() {
        return this.result;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull CraftingContainer container) {
        return this.getResultItem().copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width >= this.width && height >= this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getRecipeWidth() {
        return getWidth();
    }

    public int getHeight() {
        return this.height;
    }

    public int getRecipeHeight() {
        return getHeight();
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
        return TBARecipes.SHAPED_REMAINDER_SERIALIZER.get();
    }

    static @NotNull NonNullList<Ingredient> dissolvePattern(String @NotNull [] pattern, @NotNull Map<String, Ingredient> keys, int patternWidth, int patternHeight) {
        NonNullList<Ingredient> ingredients = NonNullList.withSize(patternWidth * patternHeight, Ingredient.EMPTY);
        Set<String> keySet = Sets.newHashSet(keys.keySet());
        keySet.remove(" ");

        for (int i = 0; i < pattern.length; ++i) {
            for (int j = 0; j < pattern[i].length(); ++j) {
                String patternSymbol = pattern[i].substring(j, j + 1);
                Ingredient ingredient = keys.get(patternSymbol);
                if (ingredient == null) {
                    throw new JsonSyntaxException("Pattern references symbol '" + patternSymbol + "' but it's not defined in the key");
                }

                keySet.remove(patternSymbol);
                ingredients.set(j + patternWidth * i, ingredient);
            }
        }

        if (!keySet.isEmpty()) {
            throw new JsonSyntaxException("Key defines symbols that aren't used in pattern: " + keySet);
        }
        else {
            return ingredients;
        }
    }

    @VisibleForTesting
    static String @NotNull [] shrink(String @NotNull ... pToShrink) {
        int i = Integer.MAX_VALUE;
        int j = 0;
        int k = 0;
        int l = 0;

        for (int i1 = 0; i1 < pToShrink.length; ++i1) {
            String s = pToShrink[i1];
            i = Math.min(i, firstNonSpace(s));
            int j1 = lastNonSpace(s);
            j = Math.max(j, j1);
            if (j1 < 0) {
                if (k == i1) {
                    ++k;
                }

                ++l;
            }
            else {
                l = 0;
            }
        }

        if (pToShrink.length == l) {
            return new String[0];
        }
        else {
            String[] astring = new String[pToShrink.length - l - k];

            for (int k1 = 0; k1 < astring.length; ++k1) {
                astring[k1] = pToShrink[k1 + k].substring(i, j + 1);
            }

            return astring;
        }
    }

    public boolean isIncomplete() {
        NonNullList<Ingredient> ingredients = this.getIngredients();
        return ingredients.isEmpty() || ingredients.stream().filter((ingredient) ->
                !ingredient.isEmpty()).anyMatch(ForgeHooks::hasNoElements);
    }

    private static int firstNonSpace(@NotNull String entry) {
        int i;
        //noinspection StatementWithEmptyBody
        for (i = 0; i < entry.length() && entry.charAt(i) == ' '; ++i) {
        }

        return i;
    }

    private static int lastNonSpace(@NotNull String entry) {
        int i;
        //noinspection StatementWithEmptyBody
        for (i = entry.length() - 1; i >= 0 && entry.charAt(i) == ' '; --i) {
        }

        return i;
    }

    static String @NotNull [] patternFromJson(@NotNull JsonArray patternArray) {
        String[] astring = new String[patternArray.size()];
        if (astring.length > MAX_HEIGHT) {
            throw new JsonSyntaxException("Invalid pattern: too many rows, " + MAX_HEIGHT + " is maximum");
        }
        else if (astring.length == 0) {
            throw new JsonSyntaxException("Invalid pattern: empty pattern not allowed");
        }
        else {
            for (int i = 0; i < astring.length; ++i) {
                String s = GsonHelper.convertToString(patternArray.get(i), "pattern[" + i + "]");
                if (s.length() > MAX_WIDTH) {
                    throw new JsonSyntaxException("Invalid pattern: too many columns, " + MAX_WIDTH + " is maximum");
                }

                if (i > 0 && astring[0].length() != s.length()) {
                    throw new JsonSyntaxException("Invalid pattern: each row must be the same width");
                }

                astring[i] = s;
            }

            return astring;
        }
    }

    static @NotNull Map<String, Ingredient> keyFromJson(@NotNull JsonObject keyEntry) {
        Map<String, Ingredient> map = Maps.newHashMap();

        for (Map.Entry<String, JsonElement> entry : keyEntry.entrySet()) {
            if (entry.getKey().length() != 1) {
                throw new JsonSyntaxException("Invalid key entry: '" + entry.getKey() + "' is an invalid symbol (must be 1 character only).");
            }

            if (" ".equals(entry.getKey())) {
                throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
            }

            map.put(entry.getKey(), Ingredient.fromJson(entry.getValue()));
        }

        map.put(" ", Ingredient.EMPTY);
        return map;
    }

    public static @NotNull ItemStack itemStackFromJson(JsonObject stackObject) {
        return CraftingHelper.getItemStack(stackObject, true, true);
    }

    public static Item itemFromJson(JsonObject pItemObject) {
        String itemEntry = GsonHelper.getAsString(pItemObject, "item");
        //noinspection deprecation
        Item item = Registry.ITEM.getOptional(new ResourceLocation(itemEntry))
                .orElseThrow(() -> new JsonSyntaxException("Unknown item '" + itemEntry + "'"));
        if (item == Items.AIR) {
            throw new JsonSyntaxException("Invalid item: " + itemEntry);
        }
        else {
            return item;
        }
    }

    public static class Serializer implements RecipeSerializer<ShapedRemainderRecipe> {
        private static final ResourceLocation NAME = new ResourceLocation("minecraft", "crafting_shaped");

        @Override
        public @NotNull ShapedRemainderRecipe fromJson(@NotNull ResourceLocation id, @NotNull JsonObject jsonObject) {
            String group = GsonHelper.getAsString(jsonObject, "group", "");
            Map<String, Ingredient> keyMap = ShapedRemainderRecipe.keyFromJson(GsonHelper.getAsJsonObject(jsonObject, "key"));
            String[] patternString = ShapedRemainderRecipe.shrink(ShapedRemainderRecipe.patternFromJson(GsonHelper.getAsJsonArray(jsonObject, "pattern")));
            int width = patternString[0].length();
            int height = patternString.length;
            NonNullList<Ingredient> inputItems = ShapedRemainderRecipe.dissolvePattern(patternString, keyMap, width, height);
            ItemStack result = ShapedRemainderRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "result"));
            return new ShapedRemainderRecipe(width, height, id, group, inputItems, result);
        }

        @Override
        public @Nullable ShapedRemainderRecipe fromNetwork(@NotNull ResourceLocation id, @NotNull FriendlyByteBuf buffer) {
            int width = buffer.readVarInt();
            int height = buffer.readVarInt();

            String group = buffer.readUtf();

            NonNullList<Ingredient> inputItems = NonNullList.withSize(width * height, Ingredient.EMPTY);
            inputItems.replaceAll(ignored -> Ingredient.fromNetwork(buffer));

            ItemStack result = buffer.readItem();
            return new ShapedRemainderRecipe( width, height, id, group, inputItems, result);
        }

        @Override
        public void toNetwork(@NotNull FriendlyByteBuf buffer, @NotNull ShapedRemainderRecipe recipe) {
            buffer.writeVarInt(recipe.width);
            buffer.writeVarInt(recipe.height);
            buffer.writeUtf(recipe.group);

            for(Ingredient ingredient : recipe.inputItems) {
                ingredient.toNetwork(buffer);
            }

            buffer.writeItem(recipe.result);
        }
    }
}