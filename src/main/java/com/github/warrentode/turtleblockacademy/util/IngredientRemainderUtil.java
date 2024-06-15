package com.github.warrentode.turtleblockacademy.util;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import slimeknights.tconstruct.fluids.TinkerFluids;

import java.util.Map;

public class IngredientRemainderUtil {

    // Private constructor to prevent instantiation
    private IngredientRemainderUtil() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static final Map<Item, Item> INGREDIENT_REMAINDER_OVERRIDES = Map.ofEntries(
            Map.entry(TinkerFluids.beetrootSoup.asItem(), Items.BUCKET),
            Map.entry(TinkerFluids.venomBottle.asItem(), Items.GLASS_BOTTLE),
            Map.entry(TinkerFluids.magmaBottle.asItem(), Items.GLASS_BOTTLE),
            Map.entry(TinkerFluids.meatSoupBowl.asItem(), Items.BOWL),
            Map.entry(TinkerFluids.earthSlime.asItem(), Items.BUCKET),
            Map.entry(TinkerFluids.skySlime.asItem(), Items.BUCKET),
            Map.entry(TinkerFluids.enderSlime.asItem(), Items.BUCKET),
            Map.entry(TinkerFluids.magma.asItem(), Items.BUCKET),
            Map.entry(TinkerFluids.honey.asItem(), Items.BUCKET),
            Map.entry(TinkerFluids.mushroomStew.asItem(), Items.BUCKET),
            Map.entry(TinkerFluids.rabbitStew.asItem(), Items.BUCKET),
            Map.entry(TinkerFluids.meatSoup.asItem(), Items.BUCKET),
            Map.entry(TinkerFluids.potion.asItem(), Items.BUCKET),
            Map.entry(TinkerFluids.blazingBlood.asItem(), Items.BUCKET),
            Map.entry(TinkerFluids.liquidSoul.asItem(), Items.BUCKET),
            Map.entry(Items.WATER_BUCKET, Items.BUCKET),
            Map.entry(Items.POWDER_SNOW_BUCKET, Items.BUCKET),
            Map.entry(Items.AXOLOTL_BUCKET, Items.BUCKET),
            Map.entry(Items.COD_BUCKET, Items.BUCKET),
            Map.entry(Items.PUFFERFISH_BUCKET, Items.BUCKET),
            Map.entry(Items.SALMON_BUCKET, Items.BUCKET),
            Map.entry(Items.TROPICAL_FISH_BUCKET, Items.BUCKET),
            Map.entry(Items.SUSPICIOUS_STEW, Items.BOWL),
            Map.entry(Items.MUSHROOM_STEW, Items.BOWL),
            Map.entry(Items.RABBIT_STEW, Items.BOWL),
            Map.entry(Items.BEETROOT_SOUP, Items.BOWL),
            Map.entry(Items.POTION, Items.GLASS_BOTTLE),
            Map.entry(Items.SPLASH_POTION, Items.GLASS_BOTTLE),
            Map.entry(Items.LINGERING_POTION, Items.GLASS_BOTTLE),
            Map.entry(Items.EXPERIENCE_BOTTLE, Items.GLASS_BOTTLE)
    );

    // Utility method to get the remainder item
    public static Item getRemainder(Item item) {
        return INGREDIENT_REMAINDER_OVERRIDES.get(item);
    }
}