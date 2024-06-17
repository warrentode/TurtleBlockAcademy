package com.github.warrentode.turtleblockacademy.util;

/*
 * Copyright (c) 2024 Warren Tode
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the “Software”), to deal in the
 * Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 *  and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
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
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.fluids.TinkerFluids;

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
     * the tag being use here (TBATags.Items.CRAFTING_REMAINDERS) is already registered in my mod's tag class,
     * and the items listed in here are added to that tag via my mod's datagen class, so there was no need to
     * set up any kind of system in here to add those items to that tag being mapped in this class
     * (honestly it just felt less complicated to me to do it this way given how I was already doing
     * datagen for my tags)
     *
     * you can see an example of how this class is used inside an entity in here in my
     * FermentingPotBlockEntity class if you need a reference
     **/
    public static final Map<TagKey<Item>, Item> TAG_REMAINDER_OVERRIDES = new HashMap<>();

    static {
        // Hardcode vanilla items and remainders
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.WATER_BUCKET, Items.BUCKET);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.POWDER_SNOW_BUCKET, Items.BUCKET);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.AXOLOTL_BUCKET, Items.BUCKET);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.COD_BUCKET, Items.BUCKET);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.PUFFERFISH_BUCKET, Items.BUCKET);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.SALMON_BUCKET, Items.BUCKET);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.TROPICAL_FISH_BUCKET, Items.BUCKET);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.SUSPICIOUS_STEW, Items.BOWL);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.MUSHROOM_STEW, Items.BOWL);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.RABBIT_STEW, Items.BOWL);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.BEETROOT_SOUP, Items.BOWL);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.POTION, Items.GLASS_BOTTLE);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.SPLASH_POTION, Items.GLASS_BOTTLE);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.LINGERING_POTION, Items.GLASS_BOTTLE);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.EXPERIENCE_BOTTLE, Items.GLASS_BOTTLE);

        // Check for specific mods and add the pre-prepped items if present
        /* add crafting remainders from tconstruct */
        if (ModList.get().isLoaded("tconstruct")) {
            LogUtil.info("Tinker's Construct found, adding the pre-prepped crafting remainders to dynamic map.");
            INGREDIENT_REMAINDER_OVERRIDES.put(TinkerFluids.beetrootSoup.asItem(), Items.BUCKET);
            INGREDIENT_REMAINDER_OVERRIDES.put(TinkerFluids.earthSlime.asItem(), Items.BUCKET);
            INGREDIENT_REMAINDER_OVERRIDES.put(TinkerFluids.skySlime.asItem(), Items.BUCKET);
            INGREDIENT_REMAINDER_OVERRIDES.put(TinkerFluids.enderSlime.asItem(), Items.BUCKET);
            INGREDIENT_REMAINDER_OVERRIDES.put(TinkerFluids.magma.asItem(), Items.BUCKET);
            INGREDIENT_REMAINDER_OVERRIDES.put(TinkerFluids.honey.asItem(), Items.BUCKET);
            INGREDIENT_REMAINDER_OVERRIDES.put(TinkerFluids.mushroomStew.asItem(), Items.BUCKET);
            INGREDIENT_REMAINDER_OVERRIDES.put(TinkerFluids.rabbitStew.asItem(), Items.BUCKET);
            INGREDIENT_REMAINDER_OVERRIDES.put(TinkerFluids.potion.asItem(), Items.BUCKET);
            INGREDIENT_REMAINDER_OVERRIDES.put(TinkerFluids.blazingBlood.asItem(), Items.BUCKET);
            INGREDIENT_REMAINDER_OVERRIDES.put(TinkerFluids.liquidSoul.asItem(), Items.BUCKET);
            INGREDIENT_REMAINDER_OVERRIDES.put(TinkerFluids.venomBottle.asItem(), Items.GLASS_BOTTLE);
            INGREDIENT_REMAINDER_OVERRIDES.put(TinkerFluids.magmaBottle.asItem(), Items.GLASS_BOTTLE);
            INGREDIENT_REMAINDER_OVERRIDES.put(TinkerFluids.meatSoupBowl.asItem(), Items.BOWL);
        }
        else {
            LogUtil.info("Tinker's Construct not found, skipping pre-prepped crafting remainder list.");
        }
    }

    // Utility method to get the remainder item
    public static @Nullable Item getRemainder(Item item) {
        // Check individual items first
        if (INGREDIENT_REMAINDER_OVERRIDES.containsKey(item)) {
            return INGREDIENT_REMAINDER_OVERRIDES.get(item);
        }

        // Check tags next
        for (Map.Entry<TagKey<Item>, Item> entry : TAG_REMAINDER_OVERRIDES.entrySet()) {
            TagKey<Item> tag = entry.getKey();
            if (item.getDefaultInstance().is(tag)) {
                return entry.getValue();
            }
        }

        // Return null if no remainder is found
        return null;
    }
}