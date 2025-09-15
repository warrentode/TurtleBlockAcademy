package com.github.warrentode.turtleblockacademy.util;

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

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class IngredientRemainderUtil {

    /**
     * modified from the FarmersDelight <a href="https://github.com/vectorwing/FarmersDelight/blob/1.19/src/main/java/vectorwing/farmersdelight/common/block/entity/CookingPotBlockEntity.java">CookingPotBlockEntity</a>
     * into a utility class and adapted to include item tags for datapack customization -
     * anyone may copy and edit/adapt this class in its entirety to use in their mod to meet
     * their mod's unique crafting needs, it's not required, but it would be nice if this class remains
     * open source and under an MIT license to be shared with others to make coding for
     * crafting remainders easier to manage and improve cross compatibilty as whole within the
     * modding community - this is really my only desired goal in setting it up this way and I'm hoping
     * it's the right way to go about it since I just want it to be availble to anyone to learn from and use
     * as freely as possible given that it's just a utility class
     **/

    // Private constructor to prevent instantiation
    private IngredientRemainderUtil() {
        throw new UnsupportedOperationException("Utility class");
    }

    // Maps for storing item remainders and tag remainders
    public static final Map<Item, Item> INGREDIENT_REMAINDER_OVERRIDES = new HashMap<>();
    /**
     * you can see an example of how this class is used inside my
     * {@link com.github.warrentode.turtleblockacademy.blocks.entity.FermentingPotBlockEntity}
     * and {@link com.github.warrentode.turtleblockacademy.recipe.ShapelessRemainderRecipe} if you need a reference
     **/
    public static final Map<TagKey<Item>, Item> TAG_BUCKET_REMAINDER_OVERRIDES = new HashMap<>();
    public static final Map<TagKey<Item>, Item> TAG_BOWL_REMAINDER_OVERRIDES = new HashMap<>();
    public static final Map<TagKey<Item>, Item> TAG_BOTTLE_REMAINDER_OVERRIDES = new HashMap<>();
    public static final Map<TagKey<Item>, Item> TAG_MATCHING_ITEM_REMAINDER_OVERRIDES = new HashMap<>();

    static {
        Item matchingItem = getMatchedItem(ItemStack.EMPTY.getItem());

        // map of the remainder tags
        TAG_BUCKET_REMAINDER_OVERRIDES.put(TBATags.Items.BUCKET_REMAINDERS, Items.BUCKET);
        TAG_BUCKET_REMAINDER_OVERRIDES.put(TBATags.Items.BOWL_REMAINDERS, Items.BOWL);
        TAG_BUCKET_REMAINDER_OVERRIDES.put(TBATags.Items.BOTTLE_REMAINDERS, Items.GLASS_BOTTLE);
        /** not sure why with this tag, the item returns to your inventory instead of staying in the
         * crafting grid like the others, but at least the item is returned
         **/
        TAG_BUCKET_REMAINDER_OVERRIDES.put(TBATags.Items.MATCHING_ITEM_REMAINDERS, matchingItem);
    }

    // Utility method to get the remainder item
    public static @Nullable Item getRemainder(Item item) {
        // Check individual items first
        if (INGREDIENT_REMAINDER_OVERRIDES.containsKey(item)) {
            return INGREDIENT_REMAINDER_OVERRIDES.get(item);
        }

        // Check tags next
        for (Map.Entry<TagKey<Item>, Item> entry : TAG_BUCKET_REMAINDER_OVERRIDES.entrySet()) {
            TagKey<Item> tag = entry.getKey();
            if (item.getDefaultInstance().is(tag)) {
                return entry.getValue();
            }
        }
        for (Map.Entry<TagKey<Item>, Item> entry : TAG_BOWL_REMAINDER_OVERRIDES.entrySet()) {
            TagKey<Item> tag = entry.getKey();
            if (item.getDefaultInstance().is(tag)) {
                return entry.getValue();
            }
        }
        for (Map.Entry<TagKey<Item>, Item> entry : TAG_BOTTLE_REMAINDER_OVERRIDES.entrySet()) {
            TagKey<Item> tag = entry.getKey();
            if (item.getDefaultInstance().is(tag)) {
                return entry.getValue();
            }
        }
        for (Map.Entry<TagKey<Item>, Item> entry : TAG_MATCHING_ITEM_REMAINDER_OVERRIDES.entrySet()) {
            TagKey<Item> tag = entry.getKey();
            if (item.getDefaultInstance().is(tag)) {
                return entry.getValue();
            }
        }

        // Return null if no remainder is found
        return null;
    }

    public static @NotNull Item getMatchedItem(@NotNull Item item) {
        ItemStack matchedStack = ItemStack.EMPTY;
        if (item.getDefaultInstance().is(TBATags.Items.MATCHING_ITEM_REMAINDERS)) {
            matchedStack = item.getDefaultInstance().copy();
        }
        return matchedStack.getItem();
    }
}