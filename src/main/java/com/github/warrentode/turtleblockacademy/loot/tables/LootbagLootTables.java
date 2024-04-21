package com.github.warrentode.turtleblockacademy.loot.tables;

import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

public class LootbagLootTables {
    private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();
    private static final Set<ResourceLocation> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);

    public static final ResourceLocation LOOT_BAG_DROPS = register("loot_bag_drops");

    public static final ResourceLocation BIRTHDAY_BAG_DROP = register("birthday_bag_drop");
    public static final ResourceLocation HALLOWEEN_BAG_DROP = register("halloween_bag_drop");
    public static final ResourceLocation CHRISTMAS_BAG_DROP = register("christmas_bag_drop");
    public static final ResourceLocation ANNIVERSARY_BAG_DROP = register("anniversary_bag_drop");
    public static final ResourceLocation EASTER_BAG_DROP = register("easter_bag_drop");
    public static final ResourceLocation NEW_YEAR_BAG_DROP = register("new_year_bag_drop");

    public static final ResourceLocation BIRTHDAY_LOOTBAG = register("birthday_lootbag");
    public static final ResourceLocation HALLOWEEN_LOOTBAG = register("trick_or_treat_lootbag");
    public static final ResourceLocation CHRISTMAS_LOOTBAG = register("christmas_lootbag");
    public static final ResourceLocation ANNIVERSARY_LOOTBAG = register("anniversary_lootbag");
    public static final ResourceLocation EASTER_LOOTBAG = register("easter_lootbag");
    public static final ResourceLocation NEW_YEAR_LOOTBAG = register("new_year_lootbag");

    public static final ResourceLocation RATIONS_BAG_DROP = register("rations_bag_drop");
    public static final ResourceLocation COMMON_BAG_DROP = register("common_bag_drop");
    public static final ResourceLocation UNCOMMON_BAG_DROP = register("uncommon_bag_drop");
    public static final ResourceLocation LUCKY_LOOTBAG_DROP = register("lucky_lootbag_drop");
    public static final ResourceLocation RARE_BAG_DROP = register("rare_bag_drop");
    public static final ResourceLocation EPIC_BAG_DROP = register("epic_bag_drop");
    public static final ResourceLocation LEGENDARY_BAG_DROP = register("legendary_bag_drop");

    public static final ResourceLocation RATIONS = register("rations_lootbag");
    public static final ResourceLocation COMMON = register("common_lootbag");
    public static final ResourceLocation UNCOMMON = register("uncommon_lootbag");
    public static final ResourceLocation RARE = register("rare_lootbag");
    @SuppressWarnings("unused")
    public static final ResourceLocation LUCKY_LOOTBAG = register("lucky_lootbag");
    public static final ResourceLocation EPIC = register("epic_lootbag");
    public static final ResourceLocation LEGENDARY = register("legendary_lootbag");

    @SuppressWarnings("unused")
    public static final ResourceLocation MYSTERY_COIN_PACK = register("mystery_coin_pack");
    public static final ResourceLocation PLUSHIE_BAG = register("plushie_bag");
    public static final ResourceLocation REFINED_STORAGE_GIFTS = register("refined_storage_gifts");

    public static final ResourceLocation LOOTBAG_CURRENCY = register("lootbag_currency");

    public static final ResourceLocation MASTER_MAP_SALE = register("master_map_sale");
    public static final ResourceLocation END_MAP_SALE = register("end_map_sale");
    public static final ResourceLocation NETHER_MAP_SALE = register("nether_map_sale");
    public static final ResourceLocation OCEAN_MAP_SALE = register("ocean_map_sale");
    public static final ResourceLocation SCOUT_MAP_SALE = register("scout_map_sale");
    public static final ResourceLocation SWAMP_MAP_SALE = register("swamp_map_sale");
    public static final ResourceLocation TREASURE_MAP_SALE = register("treasure_map_sale");
    public static final ResourceLocation UNDERGROUND_MAP_SALE = register("underground_map_sale");
    public static final ResourceLocation JUNGLE_MAP_SALE = register("jungle_map_sale");

    private static ResourceLocation register(String path) {
        return register(new ResourceLocation("lootbags", "loot_bags/" + path));
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