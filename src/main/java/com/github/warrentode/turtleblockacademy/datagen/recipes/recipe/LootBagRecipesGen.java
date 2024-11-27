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
                "concrete_bag",
                "Concrete Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_CONCRETE).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "glass_bag",
                "Glass Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_GLASS).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "redstone_bag",
                "Redstone Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_REDSTONE).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "wool_bag",
                "Wool Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_WOOL).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "terracotta_bag",
                "Terracotta Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_TERRACOTTA).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "glazed_terracotta_bag",
                "Glazed Terracotta Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_GLAZED_TERRACOTTA).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "stone_bag",
                "Stone Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_STONE).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "sandstone_bag",
                "Sandstone Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_SANDSTONE).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "misc_stone_bag",
                "Misc. Stone Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_MISC_STONE).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "blackstone_bag",
                "Blackstone Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_BLACKSTONE).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "deepslate_bag",
                "Deepslate Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_DEEPSLATE).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "endstone_bag",
                "End Stones Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_END_STONES).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "purpur_bag",
                "Purpur Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_PURPUR_STONES).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "bricks_bag",
                "Bricks Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_BRICK_SET).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "quartz_bag",
                "Quartz Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_QUARTZ).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "christmas_block_bag",
                "Christmas Block Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_CHRISTMAS_BLOCKS).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "winter_block_bag",
                "Winter Block Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_WINTER_BLOCKS).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "logs_bag",
                "Logs Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_LOGS).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "sand_bag",
                "Sand Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_SAND).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "basic_supplies_bag",
                "Basic Supplies Kit Bag",
                "white",
                LootType.COMMON.name(),
                KitLootTables.KIT_BASIC_SUPPLIES).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "leather_gear_bag",
                "Leather Tier Gear Bag",
                "white",
                LootType.COMMON.name(),
                PackBuiltInLootTables.LEATHER_TIER_GEAR).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "deco_bag",
                "Deco Bag",
                "white",
                LootType.COMMON.name(),
                LootbagLootTables.DECO_BAG).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "plushie_bag",
                "Plushie Bag",
                "white",
                LootType.COMMON.name(),
                LootbagLootTables.PLUSHIE_BAG).build(consumer);

        // uncommon
        LootBagRecipeBuilder.writeRecipe(
                "shulker_boxes_bag",
                "Shulker Boxes Bag",
                "blue",
                LootType.UNCOMMON.name(),
                LootbagLootTables.SHULKER_BOXES).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "iron_gear_bag",
                "Iron Tier Gear Bag",
                "blue",
                LootType.UNCOMMON.name(),
                PackBuiltInLootTables.IRON_TIER_GEAR).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "holiday_bag",
                "Holiday Bag",
                "blue",
                LootType.UNCOMMON.name(),
                LootbagLootTables.HOLIDAY_LOOTBAG).build(consumer);

        // rare
        LootBagRecipeBuilder.writeRecipe(
                "prismarine_bag",
                "Prismarine Kit Bag",
                "gold",
                LootType.RARE.name(),
                KitLootTables.KIT_PRISMARINE).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "creature_stone_bag",
                "Creature Stone Kit Bag",
                "gold",
                LootType.RARE.name(),
                KitLootTables.KIT_CREATURE_STONES).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "obsidian_bag",
                "Obsidian Kit Bag",
                "gold",
                LootType.RARE.name(),
                KitLootTables.KIT_OBSIDIAN).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "crystal_bag",
                "Crystal Kit Bag",
                "gold",
                LootType.RARE.name(),
                KitLootTables.KIT_CRYSTAL).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "refined_storage_bag",
                "Refined Storage Bag",
                "gold",
                LootType.RARE.name(),
                LootbagLootTables.REFINED_STORAGE_GIFTS).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "tinkers_bag",
                "Tinkers Kit Bag",
                "gold",
                LootType.RARE.name(),
                LootbagLootTables.TINKERS_KIT).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "gems_bag",
                "Gems Kit Bag",
                "rare",
                LootType.RARE.name(),
                PackBuiltInLootTables.GEMS).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "music_discs_bag",
                "Music Discs Bag",
                "gold",
                LootType.RARE.name(),
                LootbagLootTables.MUSIC_DISCS).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "backpack_upgrades_bag",
                "Backpack Upgrades Bag",
                "gold",
                LootType.RARE.name(),
                LootbagLootTables.BACKPACK_UPGRADES).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "lucky_bag",
                "Lucky Bag",
                "gold",
                LootType.RARE.name(),
                LootbagLootTables.LUCKY_LOOTBAG).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "diamond_gear_bag",
                "Diamond Tier Gear Bag",
                "gold",
                LootType.RARE.name(),
                PackBuiltInLootTables.LEATHER_TIER_GEAR).build(consumer);

        // epic
        LootBagRecipeBuilder.writeRecipe(
                "ingots_bag",
                "Ingots Kit Bag",
                "purple",
                LootType.EPIC.name(),
                KitLootTables.KIT_INGOTS).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "ufo_bag",
                "UFO Bag",
                "purple",
                LootType.EPIC.name(),
                LootbagLootTables.UFO_BAG).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "mystery_coin_pack",
                "Mystery Coin Pack",
                "purple",
                LootType.EPIC.name(),
                LootbagLootTables.MYSTERY_COIN_PACK).build(consumer);

        // legendary
        LootBagRecipeBuilder.writeRecipe(
                "artifacts_bag",
                "Artifacts Kit Bag",
                "limegreen",
                LootType.LEGENDARY.name(),
                LootbagLootTables.ARTIFACTS_GIFTS).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "cagerium_bag",
                "Cagerium Kit Bag",
                "limegreen",
                LootType.LEGENDARY.name(),
                LootbagLootTables.CAGERIUM_KIT).build(consumer);
        LootBagRecipeBuilder.writeRecipe(
                "netherite_gear_bag",
                "Netherite Tier Gear Bag",
                "limegreen",
                LootType.LEGENDARY.name(),
                PackBuiltInLootTables.NETHERITE_TIER_GEAR).build(consumer);

        // map bags for villager trades
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
                "master_map_bag",
                "Map Bag",
                "white",
                LootType.COMMON.name(),
                LootbagLootTables.MASTER_MAP_SALE).build(consumer);
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
                "underground_map_bag",
                "Underground Map Bag",
                "white",
                LootType.COMMON.name(),
                LootbagLootTables.UNDERGROUND_MAP_SALE).build(consumer);
    }
}