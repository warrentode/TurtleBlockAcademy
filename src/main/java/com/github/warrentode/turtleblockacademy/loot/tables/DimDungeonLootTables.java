package com.github.warrentode.turtleblockacademy.loot.tables;

import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

public class DimDungeonLootTables {
    private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();

    public static final ResourceLocation KIT_RANDOM = register("dimdungeons" + ":" + "chests/kit_random");
    public static final ResourceLocation KIT_FOOD = register("dimdungeons" + ":" + "chests/kit_food");

    public static final ResourceLocation KIT_CONCRETE = register("dimdungeons" + ":" + "chests/kit_concrete");
    public static final ResourceLocation KIT_GLASS = register("dimdungeons" + ":" + "chests/kit_glass");
    public static final ResourceLocation KIT_REDSTONE = register("dimdungeons" + ":" + "chests/kit_redstone");
    public static final ResourceLocation KIT_WOOL = register("dimdungeons" + ":" + "chests/kit_wool");
    public static final ResourceLocation KIT_INGOTS = register("dimdungeons" + ":" + "chests/kit_ingots");
    public static final ResourceLocation KIT_TERRACOTTA = register("dimdungeons" + ":" + "chests/kit_terracotta");
    public static final ResourceLocation KIT_GLAZED_TERRACOTTA = register("dimdungeons" + ":" + "chests/kit_glazed_terracotta");
    public static final ResourceLocation KIT_STONE = register("dimdungeons" + ":" + "chests/kit_stone");
    public static final ResourceLocation KIT_SANDSTONE = register("dimdungeons" + ":" + "chests/kit_sandstone");
    public static final ResourceLocation KIT_MISC_STONE = register("dimdungeons" + ":" + "chests/kit_misc_stone");
    public static final ResourceLocation KIT_BLACKSTONE = register("dimdungeons" + ":" + "chests/kit_blackstone");
    public static final ResourceLocation KIT_DEEPSLATE = register("dimdungeons" + ":" + "chests/kit_deepslate");
    public static final ResourceLocation KIT_PRISMARINE = register("dimdungeons" + ":" + "chests/kit_prismarine");
    public static final ResourceLocation KIT_END_STONES = register("dimdungeons" + ":" + "chests/kit_end_stones");
    public static final ResourceLocation KIT_PURPUR_STONES = register("dimdungeons" + ":" + "chests/kit_purpur_stones");
    public static final ResourceLocation KIT_CREATURE_STONES = register("dimdungeons" + ":" + "chests/kit_creature_stones");
    public static final ResourceLocation KIT_OBSIDIAN = register("dimdungeons" + ":" + "chests/kit_obsidian");
    public static final ResourceLocation KIT_CRYSTAL = register("dimdungeons" + ":" + "chests/kit_crystal");
    public static final ResourceLocation KIT_BRICK_SET = register("dimdungeons" + ":" + "chests/kit_brick_set");
    public static final ResourceLocation KIT_QUARTZ = register("dimdungeons" + ":" + "chests/kit_quartz");

    public static final ResourceLocation KIT_CHRISTMAS_BLOCKS = register("dimdungeons" + ":" + "chests/kit_christmas_blocks");
    public static final ResourceLocation KIT_WINTER_BLOCKS = register("dimdungeons" + ":" + "chests/kit_winter_blocks");

    public static final ResourceLocation KIT_LOGS = register("dimdungeons" + ":" + "chests/kit_logs");
    public static final ResourceLocation KIT_SAND = register("dimdungeons" + ":" + "chests/kit_sand");
    public static final ResourceLocation KIT_BASIC_SUPPLIES = register("dimdungeons" + ":" + "chests/kit_basic_supplies");
    public static final ResourceLocation KIT_DECOR = register("dimdungeons" + ":" + "chests/kit_decor");

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