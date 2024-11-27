package com.github.warrentode.turtleblockacademy.loot.tables;

import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

public class LootbagLootTables {
    private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();
    private static final Set<ResourceLocation> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);

    public static final ResourceLocation HOLIDAY_LOOTBAG = register("holiday_lootbag");
    public static final ResourceLocation BIRTHDAY_LOOTBAG = register("birthday_lootbag");
    public static final ResourceLocation HALLOWEEN_LOOTBAG = register("trick_or_treat_lootbag");
    public static final ResourceLocation CHRISTMAS_LOOTBAG = register("christmas_lootbag");
    public static final ResourceLocation ANNIVERSARY_LOOTBAG = register("anniversary_lootbag");
    public static final ResourceLocation EASTER_LOOTBAG = register("easter_lootbag");
    public static final ResourceLocation NEW_YEAR_LOOTBAG = register("new_year_lootbag");

    public static final ResourceLocation RATIONS_BAG_DROP = register("rations_bag_drop");

    public static final ResourceLocation RATIONS = register("rations_lootbag");
    public static final ResourceLocation LUCKY_LOOTBAG = register("lucky_lootbag");

    public static final ResourceLocation CAGERIUM_KIT = register("cagerium_lootbag");
    public static final ResourceLocation TINKERS_KIT = register("tinkers_lootbag");
    public static final ResourceLocation UFO_BAG = register("ufo_lootbag");
    public static final ResourceLocation SHULKER_BOXES = register("shulker_boxes_lootbag");
    public static final ResourceLocation BACKPACK_UPGRADES = register("backpack_upgrade_lootbag");
    public static final ResourceLocation MUSIC_DISCS = register("music_disc_lootbag");
    public static final ResourceLocation MYSTERY_COIN_PACK = register("mystery_coin_pack");
    public static final ResourceLocation PLUSHIE_BAG = register("plushie_bag");
    public static final ResourceLocation DECO_BAG = register("deco_bag");
    public static final ResourceLocation REFINED_STORAGE_GIFTS = register("refined_storage_gifts");
    public static final ResourceLocation ARTIFACTS_GIFTS = register("artifacts_gifts");

    public static final ResourceLocation LOOTBAG_CURRENCY = register("lootbag_currency");

    public static final ResourceLocation MASTER_MAP_SALE = register("master_map_sale");

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