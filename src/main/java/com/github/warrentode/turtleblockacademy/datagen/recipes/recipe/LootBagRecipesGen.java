package com.github.warrentode.turtleblockacademy.datagen.recipes.recipe;

import com.github.warrentode.turtleblockacademy.datagen.recipes.builder.LootBagRecipeBuilder;
import com.github.warrentode.turtleblockacademy.loot.tables.LootbagLootTables;
import net.minecraft.data.recipes.FinishedRecipe;
import tech.thatgravyboat.lootbags.api.LootType;

import java.util.function.Consumer;

public class LootBagRecipesGen {
    public static void register(Consumer<FinishedRecipe> consumer) {
        lootBags(consumer);
    }

    private static void lootBags(Consumer<FinishedRecipe> consumer) {
        LootBagRecipeBuilder.writeRecipe(
                "deco_bag",
                "Deco Bag",
                "purple",
                LootType.EPIC.name(),
                LootbagLootTables.DECO_BAG).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "anniversary_bag",
                "Anniversary Bag",
                "silver",
                LootType.LEGENDARY.name(),
                LootbagLootTables.ANNIVERSARY_LOOTBAG).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "birthday_bag",
                "Birthday Bag",
                "aquamarine",
                LootType.LEGENDARY.name(),
                LootbagLootTables.BIRTHDAY_LOOTBAG).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "christmas_bag",
                "Christmas Bag",
                "aqua",
                LootType.LEGENDARY.name(),
                LootbagLootTables.CHRISTMAS_LOOTBAG).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "common_bag",
                "Loot Bag (Common)",
                "white",
                LootType.COMMON.name(),
                LootbagLootTables.COMMON).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "easter_bag",
                "Easter Bag",
                "lavender",
                LootType.LEGENDARY.name(),
                LootbagLootTables.EASTER_LOOTBAG).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "end_map_bag",
                "End Map Bag",
                "white",
                LootType.COMMON.name(),
                LootbagLootTables.END_MAP_SALE).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "jungle_map_bag",
                "Jungle Map Bag",
                "white",
                LootType.COMMON.name(),
                LootbagLootTables.JUNGLE_MAP_SALE).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "legendary_bag",
                "Loot Bag (Legendary)",
                "limegreen",
                LootType.LEGENDARY.name(),
                LootbagLootTables.LEGENDARY).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "lucky_bag",
                "Lucky Bag",
                "gold",
                LootType.RARE.name(),
                LootbagLootTables.LUCKY_LOOTBAG).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "master_map_bag",
                "Map Bag",
                "white",
                LootType.COMMON.name(),
                LootbagLootTables.MASTER_MAP_SALE).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "mystery_coin_pack",
                "Mystery Coin Pack",
                "purple",
                LootType.EPIC.name(),
                LootbagLootTables.MYSTERY_COIN_PACK).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "nether_map_bag",
                "Nether Map Bag",
                "white",
                LootType.COMMON.name(),
                LootbagLootTables.NETHER_MAP_SALE).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "ocean_map_bag",
                "Ocean Map Bag",
                "white",
                LootType.COMMON.name(),
                LootbagLootTables.OCEAN_MAP_SALE).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "plushie_bag",
                "Plushie Bag",
                "purple",
                LootType.EPIC.name(),
                LootbagLootTables.PLUSHIE_BAG).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "epic_bag",
                "Loot Bag (Epic)",
                "purple",
                LootType.EPIC.name(),
                LootbagLootTables.EPIC).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "rare_bag",
                "Loot Bag (Rare)",
                "gold",
                LootType.RARE.name(),
                LootbagLootTables.RARE).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "rations_bag",
                "Rations Bag",
                "white",
                LootType.COMMON.name(),
                LootbagLootTables.RATIONS).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "scout_map_bag",
                "Scout Map Bag",
                "white",
                LootType.COMMON.name(),
                LootbagLootTables.SCOUT_MAP_SALE).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "swamp_map_bag",
                "Swamp Map Bag",
                "white",
                LootType.COMMON.name(),
                LootbagLootTables.SWAMP_MAP_SALE).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "treasure_map_bag",
                "Treasure Map Bag",
                "white",
                LootType.COMMON.name(),
                LootbagLootTables.TREASURE_MAP_SALE).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "trick_or_treat_bag",
                "Trick or Treat Bag",
                "orange",
                LootType.LEGENDARY.name(),
                LootbagLootTables.HALLOWEEN_LOOTBAG).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "uncommon_bag",
                "Loot Bag (Uncommon)",
                "blue",
                LootType.UNCOMMON.name(),
                LootbagLootTables.UNCOMMON).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "underground_map_bag",
                "Underground Map Bag",
                "white",
                LootType.COMMON.name(),
                LootbagLootTables.UNDERGROUND_MAP_SALE).build(consumer);
    }
}
