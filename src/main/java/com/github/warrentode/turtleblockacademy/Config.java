package com.github.warrentode.turtleblockacademy;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = TurtleBlockAcademy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> CURRENCY_1_NAME = BUILDER
            .comment("Currency 1 to convert to Emeralds")
            .defineListAllowEmpty(Collections.singletonList("items"),
                    () -> List.of("todecoins:copper_coin"),
                    Config::validateItemName);
    private static final ForgeConfigSpec.IntValue CURRENCY_1_VALUE = BUILDER
            .comment("How Many Equals 1 Emerald")
            .defineInRange("count", 162, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> CURRENCY_2_NAME = BUILDER
            .comment("Currency 2 to convert to Emeralds")
            .defineListAllowEmpty(Collections.singletonList("items"),
                    () -> List.of("todecoins:iron_coin"),
                    Config::validateItemName);
    private static final ForgeConfigSpec.IntValue CURRENCY_2_VALUE = BUILDER
            .comment("How Many Equals 1 Emerald")
            .defineInRange("count", 72, 0, Integer.MAX_VALUE);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static String currency1_name;
    public static Integer currency1_Value;

    public static String currency2_name;
    public static Integer currency2_Value;

    public static Set<Item> items;

    private static boolean validateItemName(final Object object) {
        return object instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(
                new ResourceLocation(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        currency1_name = CURRENCY_1_NAME.get().toString();
        currency1_Value = CURRENCY_1_VALUE.get();

        currency2_name = CURRENCY_2_NAME.get().toString();
        currency2_Value = CURRENCY_2_VALUE.get();

        // convert the list of strings into a set of items
        items = CURRENCY_1_NAME.get().stream()
                .map(itemName -> ForgeRegistries.ITEMS.getValue(
                        new ResourceLocation(itemName))).collect(Collectors.toSet());
        // convert the list of strings into a set of items
        items = CURRENCY_2_NAME.get().stream()
                .map(itemName -> ForgeRegistries.ITEMS.getValue(
                        new ResourceLocation(itemName))).collect(Collectors.toSet());
    }
}