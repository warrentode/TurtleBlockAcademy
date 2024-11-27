package com.github.warrentode.turtleblockacademy.loot.tables;

import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class KitLootTables {
    private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();

    public static final ResourceLocation KIT_RANDOM = register("dimdungeons" + ":" + "chests/kit_random");

    public static final ResourceLocation KIT_CONCRETE = register(MODID + ":" + "chests/kits/kit_concrete");
    public static final ResourceLocation KIT_GLASS = register(MODID + ":" + "chests/kits/kit_glass");
    public static final ResourceLocation KIT_REDSTONE = register(MODID + ":" + "chests/kits/kit_redstone");
    public static final ResourceLocation KIT_WOOL = register(MODID + ":" + "chests/kits/kit_wool");
    public static final ResourceLocation KIT_INGOTS = register(MODID + ":" + "chests/kits/kit_ingots");
    public static final ResourceLocation KIT_TERRACOTTA = register(MODID + ":" + "chests/kits/kit_terracotta");
    public static final ResourceLocation KIT_GLAZED_TERRACOTTA = register(MODID + ":" + "chests/kits/kit_glazed_terracotta");
    public static final ResourceLocation KIT_STONE = register(MODID + ":" + "chests/kits/kit_stone");
    public static final ResourceLocation KIT_SANDSTONE = register(MODID + ":" + "chests/kits/kit_sandstone");
    public static final ResourceLocation KIT_MISC_STONE = register(MODID + ":" + "chests/kits/kit_misc_stone");
    public static final ResourceLocation KIT_BLACKSTONE = register(MODID + ":" + "chests/kits/kit_blackstone");
    public static final ResourceLocation KIT_DEEPSLATE = register(MODID + ":" + "chests/kits/kit_deepslate");
    public static final ResourceLocation KIT_PRISMARINE = register(MODID + ":" + "chests/kits/kit_prismarine");
    public static final ResourceLocation KIT_END_STONES = register(MODID + ":" + "chests/kits/kit_end_stones");
    public static final ResourceLocation KIT_PURPUR_STONES = register(MODID + ":" + "chests/kits/kit_purpur_stones");
    public static final ResourceLocation KIT_CREATURE_STONES = register(MODID + ":" + "chests/kits/kit_creature_stones");
    public static final ResourceLocation KIT_OBSIDIAN = register(MODID + ":" + "chests/kits/kit_obsidian");
    public static final ResourceLocation KIT_CRYSTAL = register(MODID + ":" + "chests/kits/kit_crystal");
    public static final ResourceLocation KIT_BRICK_SET = register(MODID + ":" + "chests/kits/kit_brick_set");
    public static final ResourceLocation KIT_QUARTZ = register(MODID + ":" + "chests/kits/kit_quartz");

    public static final ResourceLocation KIT_CHRISTMAS_BLOCKS = register(MODID + ":" + "chests/kits/kit_christmas_blocks");
    public static final ResourceLocation KIT_WINTER_BLOCKS = register(MODID + ":" + "chests/kits/kit_winter_blocks");

    public static final ResourceLocation KIT_LOGS = register(MODID + ":" + "chests/kits/kit_logs");
    public static final ResourceLocation KIT_SAND = register(MODID + ":" + "chests/kits/kit_sand");
    public static final ResourceLocation KIT_BASIC_SUPPLIES = register(MODID + ":" + "chests/kits/kit_basic_supplies");
    public static final ResourceLocation KIT_DECOR = register(MODID + ":" + "chests/kits/kit_decor");

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