package com.github.warrentode.turtleblockacademy.loot.tables;

import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class PackBuiltInLootTables {
    private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();

    public static final ResourceLocation BREWING_GUIDE = register(MODID + ":" + "advancements/loot_tables/give_brewing_guide");
    public static final ResourceLocation KITCHEN_TEXTBOOK = register(MODID + ":" + "advancements/loot_tables/give_kitchen_textbook");

    public static final ResourceLocation TREASURE_BEETLE_ITEM_DROPS = register(MODID + ":" + "entity/treasure_beetle_item_drops");
    public static final ResourceLocation TREASURE_BEETLE_LOOT = register(MODID + ":" + "entity/treasure_beetle");
    public static final ResourceLocation CAMP_CHEST = register(MODID + ":" + "chests/camp_chest");

    public static final ResourceLocation EASTER_EGG_LOOT = register(MODID + ":" + "chests/easter_eggs");

    // randomized map loot tables
    public static final ResourceLocation MASTER_MAPBOX = register(MODID + ":" + "chests/maps/master_mapbox");
    public static final ResourceLocation END_MAPBOX = register(MODID + ":" + "chests/maps/end_mapbox");
    public static final ResourceLocation NETHER_MAPBOX = register(MODID + ":" + "chests/maps/nether_mapbox");
    public static final ResourceLocation END_MAPS = register(MODID + ":" + "chests/maps/end_maps");
    public static final ResourceLocation OVERWORLD_END_MAPS = register(MODID + ":" + "chests/maps/overworld_end_maps");
    public static final ResourceLocation NETHER_MAPS = register(MODID + ":" + "chests/maps/nether_maps");
    public static final ResourceLocation OVERWORLD_NETHER_MAPS = register(MODID + ":" + "chests/maps/overworld_nether_maps");
    public static final ResourceLocation OVERWORLD_MAPS = register(MODID + ":" + "chests/maps/overworld_maps");
    public static final ResourceLocation UNDERGROUND_MAPS = register(MODID + ":" + "chests/maps/underground_maps");
    public static final ResourceLocation OCEAN_MAPS = register(MODID + ":" + "chests/maps/ocean_maps");
    public static final ResourceLocation SWAMP_MAPS = register(MODID + ":" + "chests/maps/swamp_maps");
    public static final ResourceLocation JUNGLE_MAPS = register(MODID + ":" + "chests/maps/jungle_maps");
    public static final ResourceLocation MERCHANT_MAPS = register(MODID + ":" + "chests/maps/merchant_maps");
    public static final ResourceLocation SCOUT_MAPS = register(MODID + ":" + "chests/maps/scout_maps");
    public static final ResourceLocation TREASURE_MAPS = register(MODID + ":" + "chests/maps/treasure_maps");

    public static final ResourceLocation LEATHER_TIER_GEAR = register(MODID + ":" + "chests/leather_tier_gear");
    public static final ResourceLocation IRON_TIER_GEAR = register(MODID + ":" + "chests/iron_tier_gear");
    public static final ResourceLocation DIAMOND_TIER_GEAR = register(MODID + ":" + "chests/diamond_tier_gear");
    public static final ResourceLocation NETHERITE_TIER_GEAR = register(MODID + ":" + "chests/netherite_tier_gear");

    public static final ResourceLocation HERO_REWARDS = register(MODID + ":" + "chests/hero_rewards");
    public static final ResourceLocation DUNGEON_REWARDS = register(MODID + ":" + "chests/dungeon_rewards");

    public static final ResourceLocation GEMS = register(MODID + ":" + "chests/gems");
    public static final ResourceLocation UFO = register(MODID + ":" + "chests/ufo");
    public static final ResourceLocation SPAWN_STARTER_BONUS = register(MODID + ":" + "chests/starter_bonus_chest");
    public static final ResourceLocation LOG_SET = register(MODID + ":" + "chests/log_set");
    public static final ResourceLocation GIFTS = register(MODID + ":" + "chests/gifts");

    public static final ResourceLocation PLUSHIES = register(MODID + ":" + "chests/plushies");
    public static final ResourceLocation BATH_DECO = register(MODID + ":" + "chests/bath_deco");
    public static final ResourceLocation ART_DECO = register(MODID + ":" + "chests/art_deco");
    public static final ResourceLocation COOKERY_DECO = register(MODID + ":" + "chests/cookery_deco");
    public static final ResourceLocation GARDEN_DECO = register(MODID + ":" + "chests/garden_deco");
    public static final ResourceLocation SCIENCE_DECO = register(MODID + ":" + "chests/science_deco");
    public static final ResourceLocation HOLIDAY_DECO = register(MODID + ":" + "chests/holiday_deco");
    public static final ResourceLocation MISC_DECO = register(MODID + ":" + "chests/misc_deco");
    public static final ResourceLocation BONUS_SAND_DROPS = register(MODID + ":" + "chests/bonus_sand_drops");

    // misc tables
    public static final ResourceLocation PIGLIN_BARTERING = register("minecraft" + ":" + "gameplay/piglin_bartering");
    public static final ResourceLocation CAT_MORNING_GIFT = register("minecraft" + ":" + "gameplay/cat_morning_gift");
    public static final ResourceLocation ARMORER_GIFT = register("minecraft" + ":" + "gameplay/hero_of_the_village/armorer_gift");
    public static final ResourceLocation BUTCHER_GIFT = register("minecraft" + ":" + "gameplay/hero_of_the_village/butcher_gift");
    public static final ResourceLocation CARTOGRAPHER_GIFT = register("minecraft" + ":" + "gameplay/hero_of_the_village/cartographer_gift");
    public static final ResourceLocation CLERIC_GIFT = register("minecraft" + ":" + "gameplay/hero_of_the_village/cleric_gift");
    public static final ResourceLocation FARMER_GIFT = register("minecraft" + ":" + "gameplay/hero_of_the_village/farmer_gift");
    public static final ResourceLocation FISHERMAN_GIFT = register("minecraft" + ":" + "gameplay/hero_of_the_village/fisherman_gift");
    public static final ResourceLocation FLETCHER_GIFT = register("minecraft" + ":" + "gameplay/hero_of_the_village/fletcher_gift");
    public static final ResourceLocation LEATHERWORKER_GIFT = register("minecraft" + ":" + "gameplay/hero_of_the_village/leatherworker_gift");
    public static final ResourceLocation LIBRARIAN_GIFT = register("minecraft" + ":" + "gameplay/hero_of_the_village/librarian_gift");
    public static final ResourceLocation MASON_GIFT = register("minecraft" + ":" + "gameplay/hero_of_the_village/mason_gift");
    public static final ResourceLocation SHEPHERD_GIFT = register("minecraft" + ":" + "gameplay/hero_of_the_village/shepherd_gift");
    public static final ResourceLocation TOOLSMITH_GIFT = register("minecraft" + ":" + "gameplay/hero_of_the_village/toolsmith_gift");
    public static final ResourceLocation WEAPONSMITH_GIFT = register("minecraft" + ":" + "gameplay/hero_of_the_village/weaponsmith_gift");

    // modified entity loot tables
    public static final ResourceLocation ENDER_DRAGON = register("minecraft" + ":" + "entities/ender_dragon");

    private static final Set<ResourceLocation> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);

    private static ResourceLocation register(String path) {
        return register(new ResourceLocation(path));
    }

    private static ResourceLocation register(ResourceLocation path) {
        if (LOCATIONS.add(path)) {
            return path;
        }
        else {
            throw new IllegalArgumentException(path + " is already a registered built-in loot table");
        }
    }

    @SuppressWarnings("unused")
    public static Set<ResourceLocation> all() {
        return IMMUTABLE_LOCATIONS;
    }
}