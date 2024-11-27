package com.github.warrentode.turtleblockacademy.datagen.recipes.recipe;

import com.github.warrentode.turtleblockacademy.datagen.recipes.builder.LootBagRecipeBuilder;
import com.github.warrentode.turtleblockacademy.loot.tables.KitLootTables;
import com.github.warrentode.turtleblockacademy.loot.tables.LootbagLootTables;
import com.github.warrentode.turtleblockacademy.loot.tables.PackBuiltInLootTables;
import net.minecraft.data.recipes.FinishedRecipe;
import tech.thatgravyboat.lootbags.api.LootType;

import java.util.function.Consumer;

public class LootBagRecipesGen {
    public static void register(Consumer<FinishedRecipe> consumer) {
        lootBags(consumer);
    }

    private static void lootBags(Consumer<FinishedRecipe> consumer) {
        // common
        LootBagRecipeBuilder.writeRecipe(
                "rations_bag",
                "Rations Bag",
                "white",
                LootType.COMMON.name(),
                LootbagLootTables.RATIONS).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "basic_supplies_bag",
                "Basic Supplies Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_BASIC_SUPPLIES).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "master_map_bag",
                "Map Bag",
                "white",
                LootType.COMMON.name(),
                LootbagLootTables.MASTER_MAP_SALE).build(consumer);

        // uncommon
        LootBagRecipeBuilder.writeRecipe(
                "random_kit_bag",
                "Random Builder's Kit Bag",
                "blue",
                LootType.UNCOMMON.name(),
                KitLootTables.KIT_RANDOM_BAG).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "holiday_bag",
                "Holiday Bag",
                "blue",
                LootType.UNCOMMON.name(),
                LootbagLootTables.HOLIDAY_LOOTBAG).build(consumer);

        // rare
        LootBagRecipeBuilder.writeRecipe(
                "lucky_bag",
                "Lucky Bag",
                "gold",
                LootType.RARE.name(),
                LootbagLootTables.LUCKY_LOOTBAG).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "deco_bag",
                "Deco Bag",
                "gold",
                LootType.RARE.name(),
                LootbagLootTables.DECO_BAG).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "plushie_bag",
                "Plushie Bag",
                "gold",
                LootType.RARE.name(),
                LootbagLootTables.PLUSHIE_BAG).build(consumer);

        // epic
        LootBagRecipeBuilder.writeRecipe(
                "mystery_coin_pack",
                "Mystery Coin Pack",
                "purple",
                LootType.EPIC.name(),
                LootbagLootTables.MYSTERY_COIN_PACK).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "shulker_boxes_bag",
                "Shulker Boxes Bag",
                "purple",
                LootType.EPIC.name(),
                LootbagLootTables.SHULKER_BOXES).build(consumer);

        // legendary
            // artifacts bag for treasure beetle drops
        LootBagRecipeBuilder.writeRecipe(
                "artifacts_bag",
                "Artifacts Kit Bag",
                "limegreen",
                LootType.LEGENDARY.name(),
                LootbagLootTables.ARTIFACTS_BAG).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "refined_storage_bag",
                "Refined Storage Bag",
                "limegreen",
                LootType.LEGENDARY.name(),
                LootbagLootTables.REFINED_STORAGE_KIT).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "tinkers_bag",
                "Tinkers Kit Bag",
                "limegreen",
                LootType.LEGENDARY.name(),
                LootbagLootTables.TINKERS_KIT).build(consumer);
    }
}