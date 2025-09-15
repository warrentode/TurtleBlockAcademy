package com.github.warrentode.turtleblockacademy.loot.tables;

import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TradeLootTables {
    private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();
    private static final Set<ResourceLocation> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);

    public static final ResourceLocation LOG_BUY_TRADE_TABLE = register(MODID + ":" + "trade_loot_tables/log_buy_trade_table");
    public static final ResourceLocation LOG_SELL_TRADE_TABLE = register(MODID + ":" + "trade_loot_tables/log_sell_trade_table");
    public static final ResourceLocation SAPLING_BUY_TRADE_TABLE = register(MODID + ":" + "trade_loot_tables/sapling_buy_trade_table");
    public static final ResourceLocation SAPLING_SELL_TRADE_TABLE = register(MODID + ":" + "trade_loot_tables/sapling_sell_trade_table");
    public static final ResourceLocation FLOWER_SELL_TRADE_TABLE = register(MODID + ":" + "trade_loot_tables/flower_sell_trade_table");
    public static final ResourceLocation FLOWER_BUY_TRADE_TABLE = register(MODID + ":" + "trade_loot_tables/flower_buy_trade_table");

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