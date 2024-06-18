package com.github.warrentode.turtleblockacademy.items;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.entity.TBAEntityTypes;
import com.github.warrentode.turtleblockacademy.items.food.PickledItem;
import com.github.warrentode.turtleblockacademy.items.food.TBAFoods;
import com.github.warrentode.turtleblockacademy.items.food.eastereggs.EasterEggItem;
import com.github.warrentode.turtleblockacademy.items.food.eastereggs.EasterEggProperties;
import com.github.warrentode.turtleblockacademy.util.TBATab;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TBAItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // ACADEMY
    public static final RegistryObject<Item> STUDENT_CARD =
            ITEMS.register("student_card",
                    () -> new StudentCard(basicItem().stacksTo(1)));
    public static final RegistryObject<Item> EGG_STAMP_CREEPER =
            ITEMS.register("egg_stamp_creeper",
                    () -> new Item(basicItem()));
    public static final RegistryObject<Item> EGG_STAMP_FLOWER =
            ITEMS.register("egg_stamp_flower",
                    () -> new Item(basicItem()));

    // BASIC ITEMS
    public static final RegistryObject<Item> YEAST =
            ITEMS.register("yeast", () -> new Item(basicItem()));
    public static final RegistryObject<Item> DRIED_CLOVES =
            ITEMS.register("dried_cloves", () -> new Item(basicItem()));
    public static final RegistryObject<Item> GROUND_CLOVES =
            ITEMS.register("ground_cloves", () -> new Item(basicItem()));
    public static final RegistryObject<Item> PICKLING_SALT =
            ITEMS.register("pickling_salt", () -> new Item(basicItem()));
    public static final RegistryObject<Item> WHEAT_FLOUR =
            ITEMS.register("wheat_flour", () -> new Item(basicItem()));
    public static final RegistryObject<Item> DILL_HERB =
            ITEMS.register("dill_herb", () -> new Item(basicItem()));
    public static final RegistryObject<Item> CLOVES =
            ITEMS.register("cloves", () -> new Item(basicItem()));

    // SPAWN EGGS
    public static final RegistryObject<ForgeSpawnEggItem> TREASURE_BEETLE_SPAWN_EGG =
            ITEMS.register("treasure_beetle_spawn_egg",
                    () -> new ForgeSpawnEggItem(TBAEntityTypes.TREASURE_BEETLE,
                            0x006400, 0xB8860B, basicItem()));
    public static final RegistryObject<ForgeSpawnEggItem> HEROBRINE_SPAWN_EGG =
            ITEMS.register("herobrine_spawn_egg",
                    () -> new ForgeSpawnEggItem(TBAEntityTypes.HEROBRINE,
                            0x5649cc, 0x00cccc, basicItem()));

    // SEEDS
    public static final RegistryObject<Item> CLOVE_SEEDS =
            ITEMS.register("clove_seeds",
                    () -> new ItemNameBlockItem(TBABlocks.CLOVE_BUSH.get(), basicItem()));
    public static final RegistryObject<Item> CUCUMBER_SEEDS =
            ITEMS.register("cucumber_seeds",
                    () -> new ItemNameBlockItem(TBABlocks.CUCUMBER_BUSH.get(), basicItem()));
    public static final RegistryObject<Item> DILL_SEEDS =
            ITEMS.register("dill_seeds",
                    () -> new ItemNameBlockItem(TBABlocks.DILL_BUSH.get(), basicItem()));

    // DRINKS
    public static final RegistryObject<Item> BEET_WINE =
            ITEMS.register("beet_wine", () ->
                    new DrinkableItem(drinkItem().food(TBAFoods.BEET_WINE),
                            false, false));
    public static final RegistryObject<Item> HARD_APPLE_CIDER =
            ITEMS.register("hard_apple_cider", () ->
                    new DrinkableItem(drinkItem().food(TBAFoods.HARD_APPLE_CIDER),
                            false, false));
    public static final RegistryObject<Item> VINEGAR_BOTTLE =
            ITEMS.register("vinegar_bottle", () ->
                    new DrinkableItem(drinkItem().food(TBAFoods.VINEGAR_BOTTLE),
                            false, false));

    // FOOD
    public static final RegistryObject<Item> BEET_RISOTTO =
            ITEMS.register("beet_risotto", () ->
                    new ConsumableItem(bowlFoodItem(TBAFoods.RICE_DISHES),
                            false, false));
    public static final RegistryObject<Item> BEET_SALAD =
            ITEMS.register("beet_salad", () ->
                    new ConsumableItem(bowlFoodItem(TBAFoods.SALAD_DISHES),
                            false, false));
    public static final RegistryObject<Item> CUCUMBER =
            ITEMS.register("cucumber", () ->
                    new ConsumableItem(foodItem(TBAFoods.CUCUMBER),
                            false, false));

    public static final RegistryObject<Item> BEET_PICKLES =
            ITEMS.register("beet_pickles", () ->
                    new PickledItem(bowlFoodItem(TBAFoods.PICKLES),
                            false, false));
    public static final RegistryObject<Item> DILL_PICKLE =
            ITEMS.register("dill_pickle", () ->
                    new PickledItem(foodItem(TBAFoods.PICKLES),
                            true, true));

    public static final RegistryObject<Item> BOILED_EGG =
            ITEMS.register("boiled_egg", () ->
                    new Item(basicItem()));
    public static final RegistryObject<Item> PEELED_EGG =
            ITEMS.register("peeled_egg", () ->
                    new ConsumableItem(foodItem(TBAFoods.PEELED_EGGS),
                            true, true));

    // blank colored egg variants
    public static final RegistryObject<Item> COLORED_EGG_WHITE =
            ITEMS.register("colored_egg_white", ()-> blankColoredEgg(DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE =
            ITEMS.register("colored_egg_orange", ()-> blankColoredEgg(DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA =
            ITEMS.register("colored_egg_magenta", ()-> blankColoredEgg(DyeColor.MAGENTA));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE =
            ITEMS.register("colored_egg_light_blue", ()-> blankColoredEgg(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW =
            ITEMS.register("colored_egg_yellow", ()-> blankColoredEgg(DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_LIME =
            ITEMS.register("colored_egg_lime", ()-> blankColoredEgg(DyeColor.LIME));
        public static final RegistryObject<Item> COLORED_EGG_PINK =
            ITEMS.register("colored_egg_pink", ()-> blankColoredEgg(DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_GRAY =
            ITEMS.register("colored_egg_gray", ()-> blankColoredEgg(DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY =
            ITEMS.register("colored_egg_light_gray", ()-> blankColoredEgg(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_CYAN =
            ITEMS.register("colored_egg_cyan", ()-> blankColoredEgg(DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE =
            ITEMS.register("colored_egg_purple", ()-> blankColoredEgg(DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_BLUE =
            ITEMS.register("colored_egg_blue", ()-> blankColoredEgg(DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BROWN =
            ITEMS.register("colored_egg_brown", ()-> blankColoredEgg(DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_GREEN =
            ITEMS.register("colored_egg_green", ()-> blankColoredEgg(DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_RED =
            ITEMS.register("colored_egg_red", ()-> blankColoredEgg(DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_BLACK =
            ITEMS.register("colored_egg_black", ()-> blankColoredEgg(DyeColor.BLACK));

    // white colored egg creeper variants
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CREEPER_WHITE =
            ITEMS.register("colored_egg_white_creeper_white",
                    ()-> creeperStampedEgg(DyeColor.WHITE, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CREEPER_ORANGE =
            ITEMS.register("colored_egg_white_creeper_orange",
                    ()-> creeperStampedEgg(DyeColor.WHITE, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CREEPER_MAGENTA =
            ITEMS.register("colored_egg_white_creeper_magenta",
                    ()-> creeperStampedEgg(DyeColor.WHITE, DyeColor.MAGENTA));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CREEPER_LIGHT_BLUE =
            ITEMS.register("colored_egg_white_creeper_light_blue",
                    ()-> creeperStampedEgg(DyeColor.WHITE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CREEPER_YELLOW =
            ITEMS.register("colored_egg_white_creeper_yellow",
                    ()-> creeperStampedEgg(DyeColor.WHITE, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CREEPER_LIME =
            ITEMS.register("colored_egg_white_creeper_lime",
                    ()-> creeperStampedEgg(DyeColor.WHITE, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CREEPER_PINK =
            ITEMS.register("colored_egg_white_creeper_pink",
                    ()-> creeperStampedEgg(DyeColor.WHITE, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CREEPER_GRAY =
            ITEMS.register("colored_egg_white_creeper_gray",
                    ()-> creeperStampedEgg(DyeColor.WHITE, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CREEPER_LIGHT_GRAY =
            ITEMS.register("colored_egg_white_creeper_light_gray",
                    ()-> creeperStampedEgg(DyeColor.WHITE, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CREEPER_CYAN =
            ITEMS.register("colored_egg_white_creeper_cyan",
                    ()-> creeperStampedEgg(DyeColor.WHITE, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CREEPER_PURPLE =
            ITEMS.register("colored_egg_white_creeper_purple",
                    ()-> creeperStampedEgg(DyeColor.WHITE, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CREEPER_BLUE =
            ITEMS.register("colored_egg_white_creeper_blue",
                    ()-> creeperStampedEgg(DyeColor.WHITE, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CREEPER_BROWN =
            ITEMS.register("colored_egg_white_creeper_brown",
                    ()-> creeperStampedEgg(DyeColor.WHITE, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CREEPER_GREEN =
            ITEMS.register("colored_egg_white_creeper_green",
                    ()-> creeperStampedEgg(DyeColor.WHITE, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CREEPER_RED =
            ITEMS.register("colored_egg_white_creeper_red",
                    ()-> creeperStampedEgg(DyeColor.WHITE, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CREEPER_BLACK =
            ITEMS.register("colored_egg_white_creeper_black",
                    ()-> creeperStampedEgg(DyeColor.WHITE, DyeColor.BLACK));

    // orange colored egg creeper variants
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CREEPER_WHITE =
            ITEMS.register("colored_egg_orange_creeper_white",
                    ()-> creeperStampedEgg(DyeColor.ORANGE, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CREEPER_ORANGE =
            ITEMS.register("colored_egg_orange_creeper_orange",
                    ()-> creeperStampedEgg(DyeColor.ORANGE, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CREEPER_MAGENTA =
            ITEMS.register("colored_egg_orange_creeper_magenta",
                    ()-> creeperStampedEgg(DyeColor.ORANGE, DyeColor.MAGENTA));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CREEPER_LIGHT_BLUE =
            ITEMS.register("colored_egg_orange_creeper_light_blue",
                    ()-> creeperStampedEgg(DyeColor.ORANGE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CREEPER_YELLOW =
            ITEMS.register("colored_egg_orange_creeper_yellow",
                    ()-> creeperStampedEgg(DyeColor.ORANGE, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CREEPER_LIME =
            ITEMS.register("colored_egg_orange_creeper_lime",
                    ()-> creeperStampedEgg(DyeColor.ORANGE, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CREEPER_PINK =
            ITEMS.register("colored_egg_orange_creeper_pink",
                    ()-> creeperStampedEgg(DyeColor.ORANGE, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CREEPER_GRAY =
            ITEMS.register("colored_egg_orange_creeper_gray",
                    ()-> creeperStampedEgg(DyeColor.ORANGE, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CREEPER_LIGHT_GRAY =
            ITEMS.register("colored_egg_orange_creeper_light_gray",
                    ()-> creeperStampedEgg(DyeColor.ORANGE, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CREEPER_CYAN =
            ITEMS.register("colored_egg_orange_creeper_cyan",
                    ()-> creeperStampedEgg(DyeColor.ORANGE, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CREEPER_PURPLE =
            ITEMS.register("colored_egg_orange_creeper_purple",
                    ()-> creeperStampedEgg(DyeColor.ORANGE, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CREEPER_BLUE =
            ITEMS.register("colored_egg_orange_creeper_blue",
                    ()-> creeperStampedEgg(DyeColor.ORANGE, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CREEPER_BROWN =
            ITEMS.register("colored_egg_orange_creeper_brown",
                    ()-> creeperStampedEgg(DyeColor.ORANGE, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CREEPER_GREEN =
            ITEMS.register("colored_egg_orange_creeper_green",
                    ()-> creeperStampedEgg(DyeColor.ORANGE, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CREEPER_RED =
            ITEMS.register("colored_egg_orange_creeper_red",
                    ()-> creeperStampedEgg(DyeColor.ORANGE, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CREEPER_BLACK =
            ITEMS.register("colored_egg_orange_creeper_black",
                    ()-> creeperStampedEgg(DyeColor.ORANGE, DyeColor.BLACK));

    // magenta colored egg creeper variants
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CREEPER_WHITE =
            ITEMS.register("colored_egg_magenta_creeper_white",
                    ()-> creeperStampedEgg(DyeColor.MAGENTA, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CREEPER_ORANGE =
            ITEMS.register("colored_egg_magenta_creeper_orange",
                    ()-> creeperStampedEgg(DyeColor.MAGENTA, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CREEPER_MAGENTA =
            ITEMS.register("colored_egg_magenta_creeper_magenta",
                    ()-> creeperStampedEgg(DyeColor.MAGENTA, DyeColor.MAGENTA));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CREEPER_LIGHT_BLUE =
            ITEMS.register("colored_egg_magenta_creeper_light_blue",
                    ()-> creeperStampedEgg(DyeColor.MAGENTA, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CREEPER_YELLOW =
            ITEMS.register("colored_egg_magenta_creeper_yellow",
                    ()-> creeperStampedEgg(DyeColor.MAGENTA, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CREEPER_LIME =
            ITEMS.register("colored_egg_magenta_creeper_lime",
                    ()-> creeperStampedEgg(DyeColor.MAGENTA, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CREEPER_PINK =
            ITEMS.register("colored_egg_magenta_creeper_pink",
                    ()-> creeperStampedEgg(DyeColor.MAGENTA, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CREEPER_GRAY =
            ITEMS.register("colored_egg_magenta_creeper_gray",
                    ()-> creeperStampedEgg(DyeColor.MAGENTA, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CREEPER_LIGHT_GRAY =
            ITEMS.register("colored_egg_magenta_creeper_light_gray",
                    ()-> creeperStampedEgg(DyeColor.MAGENTA, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CREEPER_CYAN =
            ITEMS.register("colored_egg_magenta_creeper_cyan",
                    ()-> creeperStampedEgg(DyeColor.MAGENTA, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CREEPER_PURPLE =
            ITEMS.register("colored_egg_magenta_creeper_purple",
                    ()-> creeperStampedEgg(DyeColor.MAGENTA, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CREEPER_BLUE =
            ITEMS.register("colored_egg_magenta_creeper_blue",
                    ()-> creeperStampedEgg(DyeColor.MAGENTA, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CREEPER_BROWN =
            ITEMS.register("colored_egg_magenta_creeper_brown",
                    ()-> creeperStampedEgg(DyeColor.MAGENTA, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CREEPER_GREEN =
            ITEMS.register("colored_egg_magenta_creeper_green",
                    ()-> creeperStampedEgg(DyeColor.MAGENTA, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CREEPER_RED =
            ITEMS.register("colored_egg_magenta_creeper_red",
                    ()-> creeperStampedEgg(DyeColor.MAGENTA, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CREEPER_BLACK =
            ITEMS.register("colored_egg_magenta_creeper_black",
                    ()-> creeperStampedEgg(DyeColor.MAGENTA, DyeColor.BLACK));

    // light blue colored egg creeper variants
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CREEPER_WHITE =
            ITEMS.register("colored_egg_light_blue_creeper_white",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CREEPER_ORANGE =
            ITEMS.register("colored_egg_light_blue_creeper_orange",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CREEPER_MAGENTA =
            ITEMS.register("colored_egg_light_blue_creeper_magenta",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CREEPER_LIGHT_BLUE =
            ITEMS.register("colored_egg_light_blue_creeper_light_blue",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CREEPER_YELLOW =
            ITEMS.register("colored_egg_light_blue_creeper_yellow",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CREEPER_LIME =
            ITEMS.register("colored_egg_light_blue_creeper_lime",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CREEPER_PINK =
            ITEMS.register("colored_egg_light_blue_creeper_pink",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CREEPER_GRAY =
            ITEMS.register("colored_egg_light_blue_creeper_gray",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CREEPER_LIGHT_GRAY =
            ITEMS.register("colored_egg_light_blue_creeper_light_gray",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CREEPER_CYAN =
            ITEMS.register("colored_egg_light_blue_creeper_cyan",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CREEPER_PURPLE =
            ITEMS.register("colored_egg_light_blue_creeper_purple",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CREEPER_BLUE =
            ITEMS.register("colored_egg_light_blue_creeper_blue",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CREEPER_BROWN =
            ITEMS.register("colored_egg_light_blue_creeper_brown",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CREEPER_GREEN =
            ITEMS.register("colored_egg_light_blue_creeper_green",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CREEPER_RED =
            ITEMS.register("colored_egg_light_blue_creeper_red",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CREEPER_BLACK =
            ITEMS.register("colored_egg_light_blue_creeper_black",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.BLACK));

    // yellow colored egg creeper variants
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CREEPER_WHITE =
            ITEMS.register("colored_egg_yellow_creeper_white",
                    ()-> creeperStampedEgg(DyeColor.YELLOW, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CREEPER_ORANGE =
            ITEMS.register("colored_egg_yellow_creeper_orange",
                    ()-> creeperStampedEgg(DyeColor.YELLOW, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CREEPER_MAGENTA =
            ITEMS.register("colored_egg_yellow_creeper_magenta",
                    ()-> creeperStampedEgg(DyeColor.YELLOW, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CREEPER_LIGHT_BLUE =
            ITEMS.register("colored_egg_yellow_creeper_light_blue",
                    ()-> creeperStampedEgg(DyeColor.YELLOW, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CREEPER_YELLOW =
            ITEMS.register("colored_egg_yellow_creeper_yellow",
                    ()-> creeperStampedEgg(DyeColor.YELLOW, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CREEPER_LIME =
            ITEMS.register("colored_egg_yellow_creeper_lime",
                    ()-> creeperStampedEgg(DyeColor.YELLOW, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CREEPER_PINK =
            ITEMS.register("colored_egg_yellow_creeper_pink",
                    ()-> creeperStampedEgg(DyeColor.YELLOW, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CREEPER_GRAY =
            ITEMS.register("colored_egg_yellow_creeper_gray",
                    ()-> creeperStampedEgg(DyeColor.YELLOW, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CREEPER_LIGHT_GRAY =
            ITEMS.register("colored_egg_yellow_creeper_light_gray",
                    ()-> creeperStampedEgg(DyeColor.YELLOW, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CREEPER_CYAN =
            ITEMS.register("colored_egg_yellow_creeper_cyan",
                    ()-> creeperStampedEgg(DyeColor.YELLOW, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CREEPER_PURPLE =
            ITEMS.register("colored_egg_yellow_creeper_purple",
                    ()-> creeperStampedEgg(DyeColor.YELLOW, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CREEPER_BLUE =
            ITEMS.register("colored_egg_yellow_creeper_blue",
                    ()-> creeperStampedEgg(DyeColor.YELLOW, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CREEPER_BROWN =
            ITEMS.register("colored_egg_yellow_creeper_brown",
                    ()-> creeperStampedEgg(DyeColor.YELLOW, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CREEPER_GREEN =
            ITEMS.register("colored_egg_yellow_creeper_green",
                    ()-> creeperStampedEgg(DyeColor.YELLOW, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CREEPER_RED =
            ITEMS.register("colored_egg_yellow_creeper_red",
                    ()-> creeperStampedEgg(DyeColor.YELLOW, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CREEPER_BLACK =
            ITEMS.register("colored_egg_yellow_creeper_black",
                    ()-> creeperStampedEgg(DyeColor.YELLOW, DyeColor.BLACK));

    // lime colored egg creeper variants
    public static final RegistryObject<Item> COLORED_EGG_LIME_CREEPER_WHITE =
            ITEMS.register("colored_egg_lime_creeper_white",
                    ()-> creeperStampedEgg(DyeColor.LIME, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CREEPER_ORANGE =
            ITEMS.register("colored_egg_lime_creeper_orange",
                    ()-> creeperStampedEgg(DyeColor.LIME, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CREEPER_MAGENTA =
            ITEMS.register("colored_egg_lime_creeper_magenta",
                    ()-> creeperStampedEgg(DyeColor.LIME, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CREEPER_LIGHT_BLUE =
            ITEMS.register("colored_egg_lime_creeper_light_blue",
                    ()-> creeperStampedEgg(DyeColor.LIME, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CREEPER_YELLOW =
            ITEMS.register("colored_egg_lime_creeper_yellow",
                    ()-> creeperStampedEgg(DyeColor.LIME, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CREEPER_LIME =
            ITEMS.register("colored_egg_lime_creeper_lime",
                    ()-> creeperStampedEgg(DyeColor.LIME, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CREEPER_PINK =
            ITEMS.register("colored_egg_lime_creeper_pink",
                    ()-> creeperStampedEgg(DyeColor.LIME, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CREEPER_GRAY =
            ITEMS.register("colored_egg_lime_creeper_gray",
                    ()-> creeperStampedEgg(DyeColor.LIME, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CREEPER_LIGHT_GRAY =
            ITEMS.register("colored_egg_lime_creeper_light_gray",
                    ()-> creeperStampedEgg(DyeColor.LIME, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CREEPER_CYAN =
            ITEMS.register("colored_egg_lime_creeper_cyan",
                    ()-> creeperStampedEgg(DyeColor.LIME, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CREEPER_PURPLE =
            ITEMS.register("colored_egg_lime_creeper_purple",
                    ()-> creeperStampedEgg(DyeColor.LIME, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CREEPER_BLUE =
            ITEMS.register("colored_egg_lime_creeper_blue",
                    ()-> creeperStampedEgg(DyeColor.LIME, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CREEPER_BROWN =
            ITEMS.register("colored_egg_lime_creeper_brown",
                    ()-> creeperStampedEgg(DyeColor.LIME, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CREEPER_GREEN =
            ITEMS.register("colored_egg_lime_creeper_green",
                    ()-> creeperStampedEgg(DyeColor.LIME, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CREEPER_RED =
            ITEMS.register("colored_egg_lime_creeper_red",
                    ()-> creeperStampedEgg(DyeColor.LIME, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CREEPER_BLACK =
            ITEMS.register("colored_egg_lime_creeper_black",
                    ()-> creeperStampedEgg(DyeColor.LIME, DyeColor.BLACK));

    // pink colored egg creeper variants
    public static final RegistryObject<Item> COLORED_EGG_PINK_CREEPER_WHITE =
            ITEMS.register("colored_egg_pink_creeper_white",
                    ()-> creeperStampedEgg(DyeColor.PINK, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CREEPER_ORANGE =
            ITEMS.register("colored_egg_pink_creeper_orange",
                    ()-> creeperStampedEgg(DyeColor.PINK, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CREEPER_MAGENTA =
            ITEMS.register("colored_egg_pink_creeper_magenta",
                    ()-> creeperStampedEgg(DyeColor.PINK, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CREEPER_LIGHT_BLUE =
            ITEMS.register("colored_egg_pink_creeper_light_blue",
                    ()-> creeperStampedEgg(DyeColor.PINK, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CREEPER_YELLOW =
            ITEMS.register("colored_egg_pink_creeper_yellow",
                    ()-> creeperStampedEgg(DyeColor.PINK, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CREEPER_LIME =
            ITEMS.register("colored_egg_pink_creeper_lime",
                    ()-> creeperStampedEgg(DyeColor.PINK, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CREEPER_PINK =
            ITEMS.register("colored_egg_pink_creeper_pink",
                    ()-> creeperStampedEgg(DyeColor.PINK, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CREEPER_GRAY =
            ITEMS.register("colored_egg_pink_creeper_gray",
                    ()-> creeperStampedEgg(DyeColor.PINK, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CREEPER_LIGHT_GRAY =
            ITEMS.register("colored_egg_pink_creeper_light_gray",
                    ()-> creeperStampedEgg(DyeColor.PINK, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CREEPER_CYAN =
            ITEMS.register("colored_egg_pink_creeper_cyan",
                    ()-> creeperStampedEgg(DyeColor.PINK, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CREEPER_PURPLE =
            ITEMS.register("colored_egg_pink_creeper_purple",
                    ()-> creeperStampedEgg(DyeColor.PINK, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CREEPER_BLUE =
            ITEMS.register("colored_egg_pink_creeper_blue",
                    ()-> creeperStampedEgg(DyeColor.PINK, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CREEPER_BROWN =
            ITEMS.register("colored_egg_pink_creeper_brown",
                    ()-> creeperStampedEgg(DyeColor.PINK, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CREEPER_GREEN =
            ITEMS.register("colored_egg_pink_creeper_green",
                    ()-> creeperStampedEgg(DyeColor.PINK, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CREEPER_RED =
            ITEMS.register("colored_egg_pink_creeper_red",
                    ()-> creeperStampedEgg(DyeColor.PINK, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CREEPER_BLACK =
            ITEMS.register("colored_egg_pink_creeper_black",
                    ()-> creeperStampedEgg(DyeColor.PINK, DyeColor.BLACK));

    // gray colored egg creeper variants
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CREEPER_WHITE =
            ITEMS.register("colored_egg_gray_creeper_white",
                    ()-> creeperStampedEgg(DyeColor.GRAY, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CREEPER_ORANGE =
            ITEMS.register("colored_egg_gray_creeper_orange",
                    ()-> creeperStampedEgg(DyeColor.GRAY, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CREEPER_MAGENTA =
            ITEMS.register("colored_egg_gray_creeper_magenta",
                    ()-> creeperStampedEgg(DyeColor.GRAY, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CREEPER_LIGHT_BLUE =
            ITEMS.register("colored_egg_gray_creeper_light_blue",
                    ()-> creeperStampedEgg(DyeColor.GRAY, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CREEPER_YELLOW =
            ITEMS.register("colored_egg_gray_creeper_yellow",
                    ()-> creeperStampedEgg(DyeColor.GRAY, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CREEPER_LIME =
            ITEMS.register("colored_egg_gray_creeper_lime",
                    ()-> creeperStampedEgg(DyeColor.GRAY, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CREEPER_PINK =
            ITEMS.register("colored_egg_gray_creeper_pink",
                    ()-> creeperStampedEgg(DyeColor.GRAY, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CREEPER_GRAY =
            ITEMS.register("colored_egg_gray_creeper_gray",
                    ()-> creeperStampedEgg(DyeColor.GRAY, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CREEPER_LIGHT_GRAY =
            ITEMS.register("colored_egg_gray_creeper_light_gray",
                    ()-> creeperStampedEgg(DyeColor.GRAY, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CREEPER_CYAN =
            ITEMS.register("colored_egg_gray_creeper_cyan",
                    ()-> creeperStampedEgg(DyeColor.GRAY, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CREEPER_PURPLE =
            ITEMS.register("colored_egg_gray_creeper_purple",
                    ()-> creeperStampedEgg(DyeColor.GRAY, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CREEPER_BLUE =
            ITEMS.register("colored_egg_gray_creeper_blue",
                    ()-> creeperStampedEgg(DyeColor.GRAY, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CREEPER_BROWN =
            ITEMS.register("colored_egg_gray_creeper_brown",
                    ()-> creeperStampedEgg(DyeColor.GRAY, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CREEPER_GREEN =
            ITEMS.register("colored_egg_gray_creeper_green",
                    ()-> creeperStampedEgg(DyeColor.GRAY, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CREEPER_RED =
            ITEMS.register("colored_egg_gray_creeper_red",
                    ()-> creeperStampedEgg(DyeColor.GRAY, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CREEPER_BLACK =
            ITEMS.register("colored_egg_gray_creeper_black",
                    ()-> creeperStampedEgg(DyeColor.GRAY, DyeColor.BLACK));

    // light gray colored egg creeper variants
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CREEPER_WHITE =
            ITEMS.register("colored_egg_light_gray_creeper_white",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CREEPER_ORANGE =
            ITEMS.register("colored_egg_light_gray_creeper_orange",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CREEPER_MAGENTA =
            ITEMS.register("colored_egg_light_gray_creeper_magenta",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CREEPER_LIGHT_BLUE =
            ITEMS.register("colored_egg_light_gray_creeper_light_blue",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CREEPER_YELLOW =
            ITEMS.register("colored_egg_light_gray_creeper_yellow",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CREEPER_LIME =
            ITEMS.register("colored_egg_light_gray_creeper_lime",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CREEPER_PINK =
            ITEMS.register("colored_egg_light_gray_creeper_pink",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CREEPER_GRAY =
            ITEMS.register("colored_egg_light_gray_creeper_gray",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CREEPER_LIGHT_GRAY =
            ITEMS.register("colored_egg_light_gray_creeper_light_gray",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CREEPER_CYAN =
            ITEMS.register("colored_egg_light_gray_creeper_cyan",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CREEPER_PURPLE =
            ITEMS.register("colored_egg_light_gray_creeper_purple",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CREEPER_BLUE =
            ITEMS.register("colored_egg_light_gray_creeper_blue",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CREEPER_BROWN =
            ITEMS.register("colored_egg_light_gray_creeper_brown",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CREEPER_GREEN =
            ITEMS.register("colored_egg_light_gray_creeper_green",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CREEPER_RED =
            ITEMS.register("colored_egg_light_gray_creeper_red",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CREEPER_BLACK =
            ITEMS.register("colored_egg_light_gray_creeper_black",
                    ()-> creeperStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.BLACK));

    // cyan colored egg creeper variants
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CREEPER_WHITE =
            ITEMS.register("colored_egg_cyan_creeper_white",
                    ()-> creeperStampedEgg(DyeColor.CYAN, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CREEPER_ORANGE =
            ITEMS.register("colored_egg_cyan_creeper_orange",
                    ()-> creeperStampedEgg(DyeColor.CYAN, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CREEPER_MAGENTA =
            ITEMS.register("colored_egg_cyan_creeper_magenta",
                    ()-> creeperStampedEgg(DyeColor.CYAN, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CREEPER_LIGHT_BLUE =
            ITEMS.register("colored_egg_cyan_creeper_light_blue",
                    ()-> creeperStampedEgg(DyeColor.CYAN, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CREEPER_YELLOW =
            ITEMS.register("colored_egg_cyan_creeper_yellow",
                    ()-> creeperStampedEgg(DyeColor.CYAN, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CREEPER_LIME =
            ITEMS.register("colored_egg_cyan_creeper_lime",
                    ()-> creeperStampedEgg(DyeColor.CYAN, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CREEPER_PINK =
            ITEMS.register("colored_egg_cyan_creeper_pink",
                    ()-> creeperStampedEgg(DyeColor.CYAN, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CREEPER_GRAY =
            ITEMS.register("colored_egg_cyan_creeper_gray",
                    ()-> creeperStampedEgg(DyeColor.CYAN, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CREEPER_LIGHT_GRAY =
            ITEMS.register("colored_egg_cyan_creeper_light_gray",
                    ()-> creeperStampedEgg(DyeColor.CYAN, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CREEPER_CYAN =
            ITEMS.register("colored_egg_cyan_creeper_cyan",
                    ()-> creeperStampedEgg(DyeColor.CYAN, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CREEPER_PURPLE =
            ITEMS.register("colored_egg_cyan_creeper_purple",
                    ()-> creeperStampedEgg(DyeColor.CYAN, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CREEPER_BLUE =
            ITEMS.register("colored_egg_cyan_creeper_blue",
                    ()-> creeperStampedEgg(DyeColor.CYAN, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CREEPER_BROWN =
            ITEMS.register("colored_egg_cyan_creeper_brown",
                    ()-> creeperStampedEgg(DyeColor.CYAN, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CREEPER_GREEN =
            ITEMS.register("colored_egg_cyan_creeper_green",
                    ()-> creeperStampedEgg(DyeColor.CYAN, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CREEPER_RED =
            ITEMS.register("colored_egg_cyan_creeper_red",
                    ()-> creeperStampedEgg(DyeColor.CYAN, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CREEPER_BLACK =
            ITEMS.register("colored_egg_cyan_creeper_black",
                    ()-> creeperStampedEgg(DyeColor.CYAN, DyeColor.BLACK));

    // purple colored egg creeper variants
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CREEPER_WHITE =
            ITEMS.register("colored_egg_purple_creeper_white",
                    ()-> creeperStampedEgg(DyeColor.PURPLE, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CREEPER_ORANGE =
            ITEMS.register("colored_egg_purple_creeper_orange",
                    ()-> creeperStampedEgg(DyeColor.PURPLE, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CREEPER_MAGENTA =
            ITEMS.register("colored_egg_purple_creeper_magenta",
                    ()-> creeperStampedEgg(DyeColor.PURPLE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CREEPER_LIGHT_BLUE =
            ITEMS.register("colored_egg_purple_creeper_light_blue",
                    ()-> creeperStampedEgg(DyeColor.PURPLE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CREEPER_YELLOW =
            ITEMS.register("colored_egg_purple_creeper_yellow",
                    ()-> creeperStampedEgg(DyeColor.PURPLE, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CREEPER_LIME =
            ITEMS.register("colored_egg_purple_creeper_lime",
                    ()-> creeperStampedEgg(DyeColor.PURPLE, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CREEPER_PINK =
            ITEMS.register("colored_egg_purple_creeper_pink",
                    ()-> creeperStampedEgg(DyeColor.PURPLE, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CREEPER_GRAY =
            ITEMS.register("colored_egg_purple_creeper_gray",
                    ()-> creeperStampedEgg(DyeColor.PURPLE, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CREEPER_LIGHT_GRAY =
            ITEMS.register("colored_egg_purple_creeper_light_gray",
                    ()-> creeperStampedEgg(DyeColor.PURPLE, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CREEPER_CYAN =
            ITEMS.register("colored_egg_purple_creeper_cyan",
                    ()-> creeperStampedEgg(DyeColor.PURPLE, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CREEPER_PURPLE =
            ITEMS.register("colored_egg_purple_creeper_purple",
                    ()-> creeperStampedEgg(DyeColor.PURPLE, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CREEPER_BLUE =
            ITEMS.register("colored_egg_purple_creeper_blue",
                    ()-> creeperStampedEgg(DyeColor.PURPLE, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CREEPER_BROWN =
            ITEMS.register("colored_egg_purple_creeper_brown",
                    ()-> creeperStampedEgg(DyeColor.PURPLE, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CREEPER_GREEN =
            ITEMS.register("colored_egg_purple_creeper_green",
                    ()-> creeperStampedEgg(DyeColor.PURPLE, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CREEPER_RED =
            ITEMS.register("colored_egg_purple_creeper_red",
                    ()-> creeperStampedEgg(DyeColor.PURPLE, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CREEPER_BLACK =
            ITEMS.register("colored_egg_purple_creeper_black",
                    ()-> creeperStampedEgg(DyeColor.PURPLE, DyeColor.BLACK));

    // blue colored egg creeper variants
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CREEPER_WHITE =
            ITEMS.register("colored_egg_blue_creeper_white",
                    ()-> creeperStampedEgg(DyeColor.BLUE, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CREEPER_ORANGE =
            ITEMS.register("colored_egg_blue_creeper_orange",
                    ()-> creeperStampedEgg(DyeColor.BLUE, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CREEPER_MAGENTA =
            ITEMS.register("colored_egg_blue_creeper_magenta",
                    ()-> creeperStampedEgg(DyeColor.BLUE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CREEPER_LIGHT_BLUE =
            ITEMS.register("colored_egg_blue_creeper_light_blue",
                    ()-> creeperStampedEgg(DyeColor.BLUE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CREEPER_YELLOW =
            ITEMS.register("colored_egg_blue_creeper_yellow",
                    ()-> creeperStampedEgg(DyeColor.BLUE, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CREEPER_LIME =
            ITEMS.register("colored_egg_blue_creeper_lime",
                    ()-> creeperStampedEgg(DyeColor.BLUE, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CREEPER_PINK =
            ITEMS.register("colored_egg_blue_creeper_pink",
                    ()-> creeperStampedEgg(DyeColor.BLUE, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CREEPER_GRAY =
            ITEMS.register("colored_egg_blue_creeper_gray",
                    ()-> creeperStampedEgg(DyeColor.BLUE, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CREEPER_LIGHT_GRAY =
            ITEMS.register("colored_egg_blue_creeper_light_gray",
                    ()-> creeperStampedEgg(DyeColor.BLUE, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CREEPER_CYAN =
            ITEMS.register("colored_egg_blue_creeper_cyan",
                    ()-> creeperStampedEgg(DyeColor.BLUE, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CREEPER_PURPLE =
            ITEMS.register("colored_egg_blue_creeper_purple",
                    ()-> creeperStampedEgg(DyeColor.BLUE, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CREEPER_BLUE =
            ITEMS.register("colored_egg_blue_creeper_blue",
                    ()-> creeperStampedEgg(DyeColor.BLUE, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CREEPER_BROWN =
            ITEMS.register("colored_egg_blue_creeper_brown",
                    ()-> creeperStampedEgg(DyeColor.BLUE, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CREEPER_GREEN =
            ITEMS.register("colored_egg_blue_creeper_green",
                    ()-> creeperStampedEgg(DyeColor.BLUE, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CREEPER_RED =
            ITEMS.register("colored_egg_blue_creeper_red",
                    ()-> creeperStampedEgg(DyeColor.BLUE, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CREEPER_BLACK =
            ITEMS.register("colored_egg_blue_creeper_black",
                    ()-> creeperStampedEgg(DyeColor.BLUE, DyeColor.BLACK));

    // brown colored egg creeper variants
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CREEPER_WHITE =
            ITEMS.register("colored_egg_brown_creeper_white",
                    ()-> creeperStampedEgg(DyeColor.BROWN, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CREEPER_ORANGE =
            ITEMS.register("colored_egg_brown_creeper_orange",
                    ()-> creeperStampedEgg(DyeColor.BROWN, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CREEPER_MAGENTA =
            ITEMS.register("colored_egg_brown_creeper_magenta",
                    ()-> creeperStampedEgg(DyeColor.BROWN, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CREEPER_LIGHT_BLUE =
            ITEMS.register("colored_egg_brown_creeper_light_blue",
                    ()-> creeperStampedEgg(DyeColor.BROWN, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CREEPER_YELLOW =
            ITEMS.register("colored_egg_brown_creeper_yellow",
                    ()-> creeperStampedEgg(DyeColor.BROWN, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CREEPER_LIME =
            ITEMS.register("colored_egg_brown_creeper_lime",
                    ()-> creeperStampedEgg(DyeColor.BROWN, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CREEPER_PINK =
            ITEMS.register("colored_egg_brown_creeper_pink",
                    ()-> creeperStampedEgg(DyeColor.BROWN, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CREEPER_GRAY =
            ITEMS.register("colored_egg_brown_creeper_gray",
                    ()-> creeperStampedEgg(DyeColor.BROWN, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CREEPER_LIGHT_GRAY =
            ITEMS.register("colored_egg_brown_creeper_light_gray",
                    ()-> creeperStampedEgg(DyeColor.BROWN, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CREEPER_CYAN =
            ITEMS.register("colored_egg_brown_creeper_cyan",
                    ()-> creeperStampedEgg(DyeColor.BROWN, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CREEPER_PURPLE =
            ITEMS.register("colored_egg_brown_creeper_purple",
                    ()-> creeperStampedEgg(DyeColor.BROWN, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CREEPER_BLUE =
            ITEMS.register("colored_egg_brown_creeper_blue",
                    ()-> creeperStampedEgg(DyeColor.BROWN, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CREEPER_BROWN =
            ITEMS.register("colored_egg_brown_creeper_brown",
                    ()-> creeperStampedEgg(DyeColor.BROWN, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CREEPER_GREEN =
            ITEMS.register("colored_egg_brown_creeper_green",
                    ()-> creeperStampedEgg(DyeColor.BROWN, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CREEPER_RED =
            ITEMS.register("colored_egg_brown_creeper_red",
                    ()-> creeperStampedEgg(DyeColor.BROWN, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CREEPER_BLACK =
            ITEMS.register("colored_egg_brown_creeper_black",
                    ()-> creeperStampedEgg(DyeColor.BROWN, DyeColor.BLACK));

    // green colored egg creeper variants
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CREEPER_WHITE =
            ITEMS.register("colored_egg_green_creeper_white",
                    ()-> creeperStampedEgg(DyeColor.GREEN, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CREEPER_ORANGE =
            ITEMS.register("colored_egg_green_creeper_orange",
                    ()-> creeperStampedEgg(DyeColor.GREEN, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CREEPER_MAGENTA =
            ITEMS.register("colored_egg_green_creeper_magenta",
                    ()-> creeperStampedEgg(DyeColor.GREEN, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CREEPER_LIGHT_BLUE =
            ITEMS.register("colored_egg_green_creeper_light_blue",
                    ()-> creeperStampedEgg(DyeColor.GREEN, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CREEPER_YELLOW =
            ITEMS.register("colored_egg_green_creeper_yellow",
                    ()-> creeperStampedEgg(DyeColor.GREEN, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CREEPER_LIME =
            ITEMS.register("colored_egg_green_creeper_lime",
                    ()-> creeperStampedEgg(DyeColor.GREEN, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CREEPER_PINK =
            ITEMS.register("colored_egg_green_creeper_pink",
                    ()-> creeperStampedEgg(DyeColor.GREEN, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CREEPER_GRAY =
            ITEMS.register("colored_egg_green_creeper_gray",
                    ()-> creeperStampedEgg(DyeColor.GREEN, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CREEPER_LIGHT_GRAY =
            ITEMS.register("colored_egg_green_creeper_light_gray",
                    ()-> creeperStampedEgg(DyeColor.GREEN, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CREEPER_CYAN =
            ITEMS.register("colored_egg_green_creeper_cyan",
                    ()-> creeperStampedEgg(DyeColor.GREEN, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CREEPER_PURPLE =
            ITEMS.register("colored_egg_green_creeper_purple",
                    ()-> creeperStampedEgg(DyeColor.GREEN, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CREEPER_BLUE =
            ITEMS.register("colored_egg_green_creeper_blue",
                    ()-> creeperStampedEgg(DyeColor.GREEN, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CREEPER_BROWN =
            ITEMS.register("colored_egg_green_creeper_brown",
                    ()-> creeperStampedEgg(DyeColor.GREEN, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CREEPER_GREEN =
            ITEMS.register("colored_egg_green_creeper_green",
                    ()-> creeperStampedEgg(DyeColor.GREEN, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CREEPER_RED =
            ITEMS.register("colored_egg_green_creeper_red",
                    ()-> creeperStampedEgg(DyeColor.GREEN, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CREEPER_BLACK =
            ITEMS.register("colored_egg_green_creeper_black",
                    ()-> creeperStampedEgg(DyeColor.GREEN, DyeColor.BLACK));

    // red colored egg creeper variants
    public static final RegistryObject<Item> COLORED_EGG_RED_CREEPER_WHITE =
            ITEMS.register("colored_egg_red_creeper_white",
                    ()-> creeperStampedEgg(DyeColor.RED, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_RED_CREEPER_ORANGE =
            ITEMS.register("colored_egg_red_creeper_orange",
                    ()-> creeperStampedEgg(DyeColor.RED, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_RED_CREEPER_MAGENTA =
            ITEMS.register("colored_egg_red_creeper_magenta",
                    ()-> creeperStampedEgg(DyeColor.RED, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_RED_CREEPER_LIGHT_BLUE =
            ITEMS.register("colored_egg_red_creeper_light_blue",
                    ()-> creeperStampedEgg(DyeColor.RED, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_RED_CREEPER_YELLOW =
            ITEMS.register("colored_egg_red_creeper_yellow",
                    ()-> creeperStampedEgg(DyeColor.RED, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_RED_CREEPER_LIME =
            ITEMS.register("colored_egg_red_creeper_lime",
                    ()-> creeperStampedEgg(DyeColor.RED, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_RED_CREEPER_PINK =
            ITEMS.register("colored_egg_red_creeper_pink",
                    ()-> creeperStampedEgg(DyeColor.RED, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_RED_CREEPER_GRAY =
            ITEMS.register("colored_egg_red_creeper_gray",
                    ()-> creeperStampedEgg(DyeColor.RED, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_RED_CREEPER_LIGHT_GRAY =
            ITEMS.register("colored_egg_red_creeper_light_gray",
                    ()-> creeperStampedEgg(DyeColor.RED, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_RED_CREEPER_CYAN =
            ITEMS.register("colored_egg_red_creeper_cyan",
                    ()-> creeperStampedEgg(DyeColor.RED, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_RED_CREEPER_PURPLE =
            ITEMS.register("colored_egg_red_creeper_purple",
                    ()-> creeperStampedEgg(DyeColor.RED, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_RED_CREEPER_BLUE =
            ITEMS.register("colored_egg_red_creeper_blue",
                    ()-> creeperStampedEgg(DyeColor.RED, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_RED_CREEPER_BROWN =
            ITEMS.register("colored_egg_red_creeper_brown",
                    ()-> creeperStampedEgg(DyeColor.RED, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_RED_CREEPER_GREEN =
            ITEMS.register("colored_egg_red_creeper_green",
                    ()-> creeperStampedEgg(DyeColor.RED, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_RED_CREEPER_RED =
            ITEMS.register("colored_egg_red_creeper_red",
                    ()-> creeperStampedEgg(DyeColor.RED, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_RED_CREEPER_BLACK =
            ITEMS.register("colored_egg_red_creeper_black",
                    ()-> creeperStampedEgg(DyeColor.RED, DyeColor.BLACK));

    // black colored egg creeper variants
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CREEPER_WHITE =
            ITEMS.register("colored_egg_black_creeper_white",
                    ()-> creeperStampedEgg(DyeColor.BLACK, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CREEPER_ORANGE =
            ITEMS.register("colored_egg_black_creeper_orange",
                    ()-> creeperStampedEgg(DyeColor.BLACK, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CREEPER_MAGENTA =
            ITEMS.register("colored_egg_black_creeper_magenta",
                    ()-> creeperStampedEgg(DyeColor.BLACK, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CREEPER_LIGHT_BLUE =
            ITEMS.register("colored_egg_black_creeper_light_blue",
                    ()-> creeperStampedEgg(DyeColor.BLACK, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CREEPER_YELLOW =
            ITEMS.register("colored_egg_black_creeper_yellow",
                    ()-> creeperStampedEgg(DyeColor.BLACK, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CREEPER_LIME =
            ITEMS.register("colored_egg_black_creeper_lime",
                    ()-> creeperStampedEgg(DyeColor.BLACK, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CREEPER_PINK =
            ITEMS.register("colored_egg_black_creeper_pink",
                    ()-> creeperStampedEgg(DyeColor.BLACK, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CREEPER_GRAY =
            ITEMS.register("colored_egg_black_creeper_gray",
                    ()-> creeperStampedEgg(DyeColor.BLACK, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CREEPER_LIGHT_GRAY =
            ITEMS.register("colored_egg_black_creeper_light_gray",
                    ()-> creeperStampedEgg(DyeColor.BLACK, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CREEPER_CYAN =
            ITEMS.register("colored_egg_black_creeper_cyan",
                    ()-> creeperStampedEgg(DyeColor.BLACK, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CREEPER_PURPLE =
            ITEMS.register("colored_egg_black_creeper_purple",
                    ()-> creeperStampedEgg(DyeColor.BLACK, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CREEPER_BLUE =
            ITEMS.register("colored_egg_black_creeper_blue",
                    ()-> creeperStampedEgg(DyeColor.BLACK, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CREEPER_BROWN =
            ITEMS.register("colored_egg_black_creeper_brown",
                    ()-> creeperStampedEgg(DyeColor.BLACK, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CREEPER_GREEN =
            ITEMS.register("colored_egg_black_creeper_green",
                    ()-> creeperStampedEgg(DyeColor.BLACK, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CREEPER_RED =
            ITEMS.register("colored_egg_black_creeper_red",
                    ()-> creeperStampedEgg(DyeColor.BLACK, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CREEPER_BLACK =
            ITEMS.register("colored_egg_black_creeper_black",
                    ()-> creeperStampedEgg(DyeColor.BLACK, DyeColor.BLACK));

    // white colored egg flower variants
    public static final RegistryObject<Item> COLORED_EGG_WHITE_FLOWER_WHITE =
            ITEMS.register("colored_egg_white_flower_white",
                    ()-> flowerStampedEgg(DyeColor.WHITE, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_FLOWER_ORANGE =
            ITEMS.register("colored_egg_white_flower_orange",
                    ()-> flowerStampedEgg(DyeColor.WHITE, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_FLOWER_MAGENTA =
            ITEMS.register("colored_egg_white_flower_magenta",
                    ()-> flowerStampedEgg(DyeColor.WHITE, DyeColor.MAGENTA));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_FLOWER_LIGHT_BLUE =
            ITEMS.register("colored_egg_white_flower_light_blue",
                    ()-> flowerStampedEgg(DyeColor.WHITE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_FLOWER_YELLOW =
            ITEMS.register("colored_egg_white_flower_yellow",
                    ()-> flowerStampedEgg(DyeColor.WHITE, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_FLOWER_LIME =
            ITEMS.register("colored_egg_white_flower_lime",
                    ()-> flowerStampedEgg(DyeColor.WHITE, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_FLOWER_PINK =
            ITEMS.register("colored_egg_white_flower_pink",
                    ()-> flowerStampedEgg(DyeColor.WHITE, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_FLOWER_GRAY =
            ITEMS.register("colored_egg_white_flower_gray",
                    ()-> flowerStampedEgg(DyeColor.WHITE, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_FLOWER_LIGHT_GRAY =
            ITEMS.register("colored_egg_white_flower_light_gray",
                    ()-> flowerStampedEgg(DyeColor.WHITE, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_FLOWER_CYAN =
            ITEMS.register("colored_egg_white_flower_cyan",
                    ()-> flowerStampedEgg(DyeColor.WHITE, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_FLOWER_PURPLE =
            ITEMS.register("colored_egg_white_flower_purple",
                    ()-> flowerStampedEgg(DyeColor.WHITE, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_FLOWER_BLUE =
            ITEMS.register("colored_egg_white_flower_blue",
                    ()-> flowerStampedEgg(DyeColor.WHITE, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_FLOWER_BROWN =
            ITEMS.register("colored_egg_white_flower_brown",
                    ()-> flowerStampedEgg(DyeColor.WHITE, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_FLOWER_GREEN =
            ITEMS.register("colored_egg_white_flower_green",
                    ()-> flowerStampedEgg(DyeColor.WHITE, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_FLOWER_RED =
            ITEMS.register("colored_egg_white_flower_red",
                    ()-> flowerStampedEgg(DyeColor.WHITE, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_FLOWER_BLACK =
            ITEMS.register("colored_egg_white_flower_black",
                    ()-> flowerStampedEgg(DyeColor.WHITE, DyeColor.BLACK));

    // orange colored egg flower variants
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_FLOWER_WHITE =
            ITEMS.register("colored_egg_orange_flower_white",
                    ()-> flowerStampedEgg(DyeColor.ORANGE, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_FLOWER_ORANGE =
            ITEMS.register("colored_egg_orange_flower_orange",
                    ()-> flowerStampedEgg(DyeColor.ORANGE, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_FLOWER_MAGENTA =
            ITEMS.register("colored_egg_orange_flower_magenta",
                    ()-> flowerStampedEgg(DyeColor.ORANGE, DyeColor.MAGENTA));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_FLOWER_LIGHT_BLUE =
            ITEMS.register("colored_egg_orange_flower_light_blue",
                    ()-> flowerStampedEgg(DyeColor.ORANGE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_FLOWER_YELLOW =
            ITEMS.register("colored_egg_orange_flower_yellow",
                    ()-> flowerStampedEgg(DyeColor.ORANGE, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_FLOWER_LIME =
            ITEMS.register("colored_egg_orange_flower_lime",
                    ()-> flowerStampedEgg(DyeColor.ORANGE, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_FLOWER_PINK =
            ITEMS.register("colored_egg_orange_flower_pink",
                    ()-> flowerStampedEgg(DyeColor.ORANGE, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_FLOWER_GRAY =
            ITEMS.register("colored_egg_orange_flower_gray",
                    ()-> flowerStampedEgg(DyeColor.ORANGE, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_FLOWER_LIGHT_GRAY =
            ITEMS.register("colored_egg_orange_flower_light_gray",
                    ()-> flowerStampedEgg(DyeColor.ORANGE, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_FLOWER_CYAN =
            ITEMS.register("colored_egg_orange_flower_cyan",
                    ()-> flowerStampedEgg(DyeColor.ORANGE, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_FLOWER_PURPLE =
            ITEMS.register("colored_egg_orange_flower_purple",
                    ()-> flowerStampedEgg(DyeColor.ORANGE, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_FLOWER_BLUE =
            ITEMS.register("colored_egg_orange_flower_blue",
                    ()-> flowerStampedEgg(DyeColor.ORANGE, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_FLOWER_BROWN =
            ITEMS.register("colored_egg_orange_flower_brown",
                    ()-> flowerStampedEgg(DyeColor.ORANGE, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_FLOWER_GREEN =
            ITEMS.register("colored_egg_orange_flower_green",
                    ()-> flowerStampedEgg(DyeColor.ORANGE, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_FLOWER_RED =
            ITEMS.register("colored_egg_orange_flower_red",
                    ()-> flowerStampedEgg(DyeColor.ORANGE, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_FLOWER_BLACK =
            ITEMS.register("colored_egg_orange_flower_black",
                    ()-> flowerStampedEgg(DyeColor.ORANGE, DyeColor.BLACK));

    // magenta colored egg flower variants
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_FLOWER_WHITE =
            ITEMS.register("colored_egg_magenta_flower_white",
                    ()-> flowerStampedEgg(DyeColor.MAGENTA, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_FLOWER_ORANGE =
            ITEMS.register("colored_egg_magenta_flower_orange",
                    ()-> flowerStampedEgg(DyeColor.MAGENTA, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_FLOWER_MAGENTA =
            ITEMS.register("colored_egg_magenta_flower_magenta",
                    ()-> flowerStampedEgg(DyeColor.MAGENTA, DyeColor.MAGENTA));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_FLOWER_LIGHT_BLUE =
            ITEMS.register("colored_egg_magenta_flower_light_blue",
                    ()-> flowerStampedEgg(DyeColor.MAGENTA, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_FLOWER_YELLOW =
            ITEMS.register("colored_egg_magenta_flower_yellow",
                    ()-> flowerStampedEgg(DyeColor.MAGENTA, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_FLOWER_LIME =
            ITEMS.register("colored_egg_magenta_flower_lime",
                    ()-> flowerStampedEgg(DyeColor.MAGENTA, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_FLOWER_PINK =
            ITEMS.register("colored_egg_magenta_flower_pink",
                    ()-> flowerStampedEgg(DyeColor.MAGENTA, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_FLOWER_GRAY =
            ITEMS.register("colored_egg_magenta_flower_gray",
                    ()-> flowerStampedEgg(DyeColor.MAGENTA, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_FLOWER_LIGHT_GRAY =
            ITEMS.register("colored_egg_magenta_flower_light_gray",
                    ()-> flowerStampedEgg(DyeColor.MAGENTA, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_FLOWER_CYAN =
            ITEMS.register("colored_egg_magenta_flower_cyan",
                    ()-> flowerStampedEgg(DyeColor.MAGENTA, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_FLOWER_PURPLE =
            ITEMS.register("colored_egg_magenta_flower_purple",
                    ()-> flowerStampedEgg(DyeColor.MAGENTA, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_FLOWER_BLUE =
            ITEMS.register("colored_egg_magenta_flower_blue",
                    ()-> flowerStampedEgg(DyeColor.MAGENTA, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_FLOWER_BROWN =
            ITEMS.register("colored_egg_magenta_flower_brown",
                    ()-> flowerStampedEgg(DyeColor.MAGENTA, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_FLOWER_GREEN =
            ITEMS.register("colored_egg_magenta_flower_green",
                    ()-> flowerStampedEgg(DyeColor.MAGENTA, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_FLOWER_RED =
            ITEMS.register("colored_egg_magenta_flower_red",
                    ()-> flowerStampedEgg(DyeColor.MAGENTA, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_FLOWER_BLACK =
            ITEMS.register("colored_egg_magenta_flower_black",
                    ()-> flowerStampedEgg(DyeColor.MAGENTA, DyeColor.BLACK));

    // light blue colored egg flower variants
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_FLOWER_WHITE =
            ITEMS.register("colored_egg_light_blue_flower_white",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_FLOWER_ORANGE =
            ITEMS.register("colored_egg_light_blue_flower_orange",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_FLOWER_MAGENTA =
            ITEMS.register("colored_egg_light_blue_flower_magenta",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_FLOWER_LIGHT_BLUE =
            ITEMS.register("colored_egg_light_blue_flower_light_blue",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_FLOWER_YELLOW =
            ITEMS.register("colored_egg_light_blue_flower_yellow",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_FLOWER_LIME =
            ITEMS.register("colored_egg_light_blue_flower_lime",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_FLOWER_PINK =
            ITEMS.register("colored_egg_light_blue_flower_pink",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_FLOWER_GRAY =
            ITEMS.register("colored_egg_light_blue_flower_gray",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_FLOWER_LIGHT_GRAY =
            ITEMS.register("colored_egg_light_blue_flower_light_gray",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_FLOWER_CYAN =
            ITEMS.register("colored_egg_light_blue_flower_cyan",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_FLOWER_PURPLE =
            ITEMS.register("colored_egg_light_blue_flower_purple",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_FLOWER_BLUE =
            ITEMS.register("colored_egg_light_blue_flower_blue",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_FLOWER_BROWN =
            ITEMS.register("colored_egg_light_blue_flower_brown",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_FLOWER_GREEN =
            ITEMS.register("colored_egg_light_blue_flower_green",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_FLOWER_RED =
            ITEMS.register("colored_egg_light_blue_flower_red",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_FLOWER_BLACK =
            ITEMS.register("colored_egg_light_blue_flower_black",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.BLACK));

    // yellow colored egg flower variants
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_FLOWER_WHITE =
            ITEMS.register("colored_egg_yellow_flower_white",
                    ()-> flowerStampedEgg(DyeColor.YELLOW, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_FLOWER_ORANGE =
            ITEMS.register("colored_egg_yellow_flower_orange",
                    ()-> flowerStampedEgg(DyeColor.YELLOW, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_FLOWER_MAGENTA =
            ITEMS.register("colored_egg_yellow_flower_magenta",
                    ()-> flowerStampedEgg(DyeColor.YELLOW, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_FLOWER_LIGHT_BLUE =
            ITEMS.register("colored_egg_yellow_flower_light_blue",
                    ()-> flowerStampedEgg(DyeColor.YELLOW, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_FLOWER_YELLOW =
            ITEMS.register("colored_egg_yellow_flower_yellow",
                    ()-> flowerStampedEgg(DyeColor.YELLOW, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_FLOWER_LIME =
            ITEMS.register("colored_egg_yellow_flower_lime",
                    ()-> flowerStampedEgg(DyeColor.YELLOW, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_FLOWER_PINK =
            ITEMS.register("colored_egg_yellow_flower_pink",
                    ()-> flowerStampedEgg(DyeColor.YELLOW, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_FLOWER_GRAY =
            ITEMS.register("colored_egg_yellow_flower_gray",
                    ()-> flowerStampedEgg(DyeColor.YELLOW, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_FLOWER_LIGHT_GRAY =
            ITEMS.register("colored_egg_yellow_flower_light_gray",
                    ()-> flowerStampedEgg(DyeColor.YELLOW, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_FLOWER_CYAN =
            ITEMS.register("colored_egg_yellow_flower_cyan",
                    ()-> flowerStampedEgg(DyeColor.YELLOW, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_FLOWER_PURPLE =
            ITEMS.register("colored_egg_yellow_flower_purple",
                    ()-> flowerStampedEgg(DyeColor.YELLOW, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_FLOWER_BLUE =
            ITEMS.register("colored_egg_yellow_flower_blue",
                    ()-> flowerStampedEgg(DyeColor.YELLOW, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_FLOWER_BROWN =
            ITEMS.register("colored_egg_yellow_flower_brown",
                    ()-> flowerStampedEgg(DyeColor.YELLOW, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_FLOWER_GREEN =
            ITEMS.register("colored_egg_yellow_flower_green",
                    ()-> flowerStampedEgg(DyeColor.YELLOW, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_FLOWER_RED =
            ITEMS.register("colored_egg_yellow_flower_red",
                    ()-> flowerStampedEgg(DyeColor.YELLOW, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_FLOWER_BLACK =
            ITEMS.register("colored_egg_yellow_flower_black",
                    ()-> flowerStampedEgg(DyeColor.YELLOW, DyeColor.BLACK));

    // lime colored egg flower variants
    public static final RegistryObject<Item> COLORED_EGG_LIME_FLOWER_WHITE =
            ITEMS.register("colored_egg_lime_flower_white",
                    ()-> flowerStampedEgg(DyeColor.LIME, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_LIME_FLOWER_ORANGE =
            ITEMS.register("colored_egg_lime_flower_orange",
                    ()-> flowerStampedEgg(DyeColor.LIME, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_LIME_FLOWER_MAGENTA =
            ITEMS.register("colored_egg_lime_flower_magenta",
                    ()-> flowerStampedEgg(DyeColor.LIME, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIME_FLOWER_LIGHT_BLUE =
            ITEMS.register("colored_egg_lime_flower_light_blue",
                    ()-> flowerStampedEgg(DyeColor.LIME, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIME_FLOWER_YELLOW =
            ITEMS.register("colored_egg_lime_flower_yellow",
                    ()-> flowerStampedEgg(DyeColor.LIME, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_LIME_FLOWER_LIME =
            ITEMS.register("colored_egg_lime_flower_lime",
                    ()-> flowerStampedEgg(DyeColor.LIME, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_LIME_FLOWER_PINK =
            ITEMS.register("colored_egg_lime_flower_pink",
                    ()-> flowerStampedEgg(DyeColor.LIME, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_LIME_FLOWER_GRAY =
            ITEMS.register("colored_egg_lime_flower_gray",
                    ()-> flowerStampedEgg(DyeColor.LIME, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_LIME_FLOWER_LIGHT_GRAY =
            ITEMS.register("colored_egg_lime_flower_light_gray",
                    ()-> flowerStampedEgg(DyeColor.LIME, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_LIME_FLOWER_CYAN =
            ITEMS.register("colored_egg_lime_flower_cyan",
                    ()-> flowerStampedEgg(DyeColor.LIME, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_LIME_FLOWER_PURPLE =
            ITEMS.register("colored_egg_lime_flower_purple",
                    ()-> flowerStampedEgg(DyeColor.LIME, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_LIME_FLOWER_BLUE =
            ITEMS.register("colored_egg_lime_flower_blue",
                    ()-> flowerStampedEgg(DyeColor.LIME, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIME_FLOWER_BROWN =
            ITEMS.register("colored_egg_lime_flower_brown",
                    ()-> flowerStampedEgg(DyeColor.LIME, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_LIME_FLOWER_GREEN =
            ITEMS.register("colored_egg_lime_flower_green",
                    ()-> flowerStampedEgg(DyeColor.LIME, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_LIME_FLOWER_RED =
            ITEMS.register("colored_egg_lime_flower_red",
                    ()-> flowerStampedEgg(DyeColor.LIME, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_LIME_FLOWER_BLACK =
            ITEMS.register("colored_egg_lime_flower_black",
                    ()-> flowerStampedEgg(DyeColor.LIME, DyeColor.BLACK));

    // pink colored egg flower variants
    public static final RegistryObject<Item> COLORED_EGG_PINK_FLOWER_WHITE =
            ITEMS.register("colored_egg_pink_flower_white",
                    ()-> flowerStampedEgg(DyeColor.PINK, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_PINK_FLOWER_ORANGE =
            ITEMS.register("colored_egg_pink_flower_orange",
                    ()-> flowerStampedEgg(DyeColor.PINK, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_PINK_FLOWER_MAGENTA =
            ITEMS.register("colored_egg_pink_flower_magenta",
                    ()-> flowerStampedEgg(DyeColor.PINK, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_PINK_FLOWER_LIGHT_BLUE =
            ITEMS.register("colored_egg_pink_flower_light_blue",
                    ()-> flowerStampedEgg(DyeColor.PINK, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_PINK_FLOWER_YELLOW =
            ITEMS.register("colored_egg_pink_flower_yellow",
                    ()-> flowerStampedEgg(DyeColor.PINK, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_PINK_FLOWER_LIME =
            ITEMS.register("colored_egg_pink_flower_lime",
                    ()-> flowerStampedEgg(DyeColor.PINK, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_PINK_FLOWER_PINK =
            ITEMS.register("colored_egg_pink_flower_pink",
                    ()-> flowerStampedEgg(DyeColor.PINK, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_PINK_FLOWER_GRAY =
            ITEMS.register("colored_egg_pink_flower_gray",
                    ()-> flowerStampedEgg(DyeColor.PINK, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_PINK_FLOWER_LIGHT_GRAY =
            ITEMS.register("colored_egg_pink_flower_light_gray",
                    ()-> flowerStampedEgg(DyeColor.PINK, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_PINK_FLOWER_CYAN =
            ITEMS.register("colored_egg_pink_flower_cyan",
                    ()-> flowerStampedEgg(DyeColor.PINK, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_PINK_FLOWER_PURPLE =
            ITEMS.register("colored_egg_pink_flower_purple",
                    ()-> flowerStampedEgg(DyeColor.PINK, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_PINK_FLOWER_BLUE =
            ITEMS.register("colored_egg_pink_flower_blue",
                    ()-> flowerStampedEgg(DyeColor.PINK, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_PINK_FLOWER_BROWN =
            ITEMS.register("colored_egg_pink_flower_brown",
                    ()-> flowerStampedEgg(DyeColor.PINK, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_PINK_FLOWER_GREEN =
            ITEMS.register("colored_egg_pink_flower_green",
                    ()-> flowerStampedEgg(DyeColor.PINK, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_PINK_FLOWER_RED =
            ITEMS.register("colored_egg_pink_flower_red",
                    ()-> flowerStampedEgg(DyeColor.PINK, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_PINK_FLOWER_BLACK =
            ITEMS.register("colored_egg_pink_flower_black",
                    ()-> flowerStampedEgg(DyeColor.PINK, DyeColor.BLACK));

    // gray colored egg flower variants
    public static final RegistryObject<Item> COLORED_EGG_GRAY_FLOWER_WHITE =
            ITEMS.register("colored_egg_gray_flower_white",
                    ()-> flowerStampedEgg(DyeColor.GRAY, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_FLOWER_ORANGE =
            ITEMS.register("colored_egg_gray_flower_orange",
                    ()-> flowerStampedEgg(DyeColor.GRAY, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_FLOWER_MAGENTA =
            ITEMS.register("colored_egg_gray_flower_magenta",
                    ()-> flowerStampedEgg(DyeColor.GRAY, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_FLOWER_LIGHT_BLUE =
            ITEMS.register("colored_egg_gray_flower_light_blue",
                    ()-> flowerStampedEgg(DyeColor.GRAY, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_FLOWER_YELLOW =
            ITEMS.register("colored_egg_gray_flower_yellow",
                    ()-> flowerStampedEgg(DyeColor.GRAY, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_FLOWER_LIME =
            ITEMS.register("colored_egg_gray_flower_lime",
                    ()-> flowerStampedEgg(DyeColor.GRAY, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_FLOWER_PINK =
            ITEMS.register("colored_egg_gray_flower_pink",
                    ()-> flowerStampedEgg(DyeColor.GRAY, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_FLOWER_GRAY =
            ITEMS.register("colored_egg_gray_flower_gray",
                    ()-> flowerStampedEgg(DyeColor.GRAY, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_FLOWER_LIGHT_GRAY =
            ITEMS.register("colored_egg_gray_flower_light_gray",
                    ()-> flowerStampedEgg(DyeColor.GRAY, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_FLOWER_CYAN =
            ITEMS.register("colored_egg_gray_flower_cyan",
                    ()-> flowerStampedEgg(DyeColor.GRAY, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_FLOWER_PURPLE =
            ITEMS.register("colored_egg_gray_flower_purple",
                    ()-> flowerStampedEgg(DyeColor.GRAY, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_FLOWER_BLUE =
            ITEMS.register("colored_egg_gray_flower_blue",
                    ()-> flowerStampedEgg(DyeColor.GRAY, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_FLOWER_BROWN =
            ITEMS.register("colored_egg_gray_flower_brown",
                    ()-> flowerStampedEgg(DyeColor.GRAY, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_FLOWER_GREEN =
            ITEMS.register("colored_egg_gray_flower_green",
                    ()-> flowerStampedEgg(DyeColor.GRAY, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_FLOWER_RED =
            ITEMS.register("colored_egg_gray_flower_red",
                    ()-> flowerStampedEgg(DyeColor.GRAY, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_FLOWER_BLACK =
            ITEMS.register("colored_egg_gray_flower_black",
                    ()-> flowerStampedEgg(DyeColor.GRAY, DyeColor.BLACK));

    // light gray colored egg flower variants
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_FLOWER_WHITE =
            ITEMS.register("colored_egg_light_gray_flower_white",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_FLOWER_ORANGE =
            ITEMS.register("colored_egg_light_gray_flower_orange",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_FLOWER_MAGENTA =
            ITEMS.register("colored_egg_light_gray_flower_magenta",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_FLOWER_LIGHT_BLUE =
            ITEMS.register("colored_egg_light_gray_flower_light_blue",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_FLOWER_YELLOW =
            ITEMS.register("colored_egg_light_gray_flower_yellow",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_FLOWER_LIME =
            ITEMS.register("colored_egg_light_gray_flower_lime",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_FLOWER_PINK =
            ITEMS.register("colored_egg_light_gray_flower_pink",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_FLOWER_GRAY =
            ITEMS.register("colored_egg_light_gray_flower_gray",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_FLOWER_LIGHT_GRAY =
            ITEMS.register("colored_egg_light_gray_flower_light_gray",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_FLOWER_CYAN =
            ITEMS.register("colored_egg_light_gray_flower_cyan",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_FLOWER_PURPLE =
            ITEMS.register("colored_egg_light_gray_flower_purple",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_FLOWER_BLUE =
            ITEMS.register("colored_egg_light_gray_flower_blue",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_FLOWER_BROWN =
            ITEMS.register("colored_egg_light_gray_flower_brown",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_FLOWER_GREEN =
            ITEMS.register("colored_egg_light_gray_flower_green",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_FLOWER_RED =
            ITEMS.register("colored_egg_light_gray_flower_red",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_FLOWER_BLACK =
            ITEMS.register("colored_egg_light_gray_flower_black",
                    ()-> flowerStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.BLACK));

    // cyan colored egg flower variants
    public static final RegistryObject<Item> COLORED_EGG_CYAN_FLOWER_WHITE =
            ITEMS.register("colored_egg_cyan_flower_white",
                    ()-> flowerStampedEgg(DyeColor.CYAN, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_FLOWER_ORANGE =
            ITEMS.register("colored_egg_cyan_flower_orange",
                    ()-> flowerStampedEgg(DyeColor.CYAN, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_FLOWER_MAGENTA =
            ITEMS.register("colored_egg_cyan_flower_magenta",
                    ()-> flowerStampedEgg(DyeColor.CYAN, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_FLOWER_LIGHT_BLUE =
            ITEMS.register("colored_egg_cyan_flower_light_blue",
                    ()-> flowerStampedEgg(DyeColor.CYAN, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_FLOWER_YELLOW =
            ITEMS.register("colored_egg_cyan_flower_yellow",
                    ()-> flowerStampedEgg(DyeColor.CYAN, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_FLOWER_LIME =
            ITEMS.register("colored_egg_cyan_flower_lime",
                    ()-> flowerStampedEgg(DyeColor.CYAN, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_FLOWER_PINK =
            ITEMS.register("colored_egg_cyan_flower_pink",
                    ()-> flowerStampedEgg(DyeColor.CYAN, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_FLOWER_GRAY =
            ITEMS.register("colored_egg_cyan_flower_gray",
                    ()-> flowerStampedEgg(DyeColor.CYAN, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_FLOWER_LIGHT_GRAY =
            ITEMS.register("colored_egg_cyan_flower_light_gray",
                    ()-> flowerStampedEgg(DyeColor.CYAN, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_FLOWER_CYAN =
            ITEMS.register("colored_egg_cyan_flower_cyan",
                    ()-> flowerStampedEgg(DyeColor.CYAN, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_FLOWER_PURPLE =
            ITEMS.register("colored_egg_cyan_flower_purple",
                    ()-> flowerStampedEgg(DyeColor.CYAN, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_FLOWER_BLUE =
            ITEMS.register("colored_egg_cyan_flower_blue",
                    ()-> flowerStampedEgg(DyeColor.CYAN, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_FLOWER_BROWN =
            ITEMS.register("colored_egg_cyan_flower_brown",
                    ()-> flowerStampedEgg(DyeColor.CYAN, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_FLOWER_GREEN =
            ITEMS.register("colored_egg_cyan_flower_green",
                    ()-> flowerStampedEgg(DyeColor.CYAN, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_FLOWER_RED =
            ITEMS.register("colored_egg_cyan_flower_red",
                    ()-> flowerStampedEgg(DyeColor.CYAN, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_FLOWER_BLACK =
            ITEMS.register("colored_egg_cyan_flower_black",
                    ()-> flowerStampedEgg(DyeColor.CYAN, DyeColor.BLACK));

    // purple colored egg flower variants
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_FLOWER_WHITE =
            ITEMS.register("colored_egg_purple_flower_white",
                    ()-> flowerStampedEgg(DyeColor.PURPLE, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_FLOWER_ORANGE =
            ITEMS.register("colored_egg_purple_flower_orange",
                    ()-> flowerStampedEgg(DyeColor.PURPLE, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_FLOWER_MAGENTA =
            ITEMS.register("colored_egg_purple_flower_magenta",
                    ()-> flowerStampedEgg(DyeColor.PURPLE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_FLOWER_LIGHT_BLUE =
            ITEMS.register("colored_egg_purple_flower_light_blue",
                    ()-> flowerStampedEgg(DyeColor.PURPLE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_FLOWER_YELLOW =
            ITEMS.register("colored_egg_purple_flower_yellow",
                    ()-> flowerStampedEgg(DyeColor.PURPLE, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_FLOWER_LIME =
            ITEMS.register("colored_egg_purple_flower_lime",
                    ()-> flowerStampedEgg(DyeColor.PURPLE, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_FLOWER_PINK =
            ITEMS.register("colored_egg_purple_flower_pink",
                    ()-> flowerStampedEgg(DyeColor.PURPLE, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_FLOWER_GRAY =
            ITEMS.register("colored_egg_purple_flower_gray",
                    ()-> flowerStampedEgg(DyeColor.PURPLE, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_FLOWER_LIGHT_GRAY =
            ITEMS.register("colored_egg_purple_flower_light_gray",
                    ()-> flowerStampedEgg(DyeColor.PURPLE, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_FLOWER_CYAN =
            ITEMS.register("colored_egg_purple_flower_cyan",
                    ()-> flowerStampedEgg(DyeColor.PURPLE, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_FLOWER_PURPLE =
            ITEMS.register("colored_egg_purple_flower_purple",
                    ()-> flowerStampedEgg(DyeColor.PURPLE, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_FLOWER_BLUE =
            ITEMS.register("colored_egg_purple_flower_blue",
                    ()-> flowerStampedEgg(DyeColor.PURPLE, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_FLOWER_BROWN =
            ITEMS.register("colored_egg_purple_flower_brown",
                    ()-> flowerStampedEgg(DyeColor.PURPLE, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_FLOWER_GREEN =
            ITEMS.register("colored_egg_purple_flower_green",
                    ()-> flowerStampedEgg(DyeColor.PURPLE, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_FLOWER_RED =
            ITEMS.register("colored_egg_purple_flower_red",
                    ()-> flowerStampedEgg(DyeColor.PURPLE, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_FLOWER_BLACK =
            ITEMS.register("colored_egg_purple_flower_black",
                    ()-> flowerStampedEgg(DyeColor.PURPLE, DyeColor.BLACK));

    // blue colored egg flower variants
    public static final RegistryObject<Item> COLORED_EGG_BLUE_FLOWER_WHITE =
            ITEMS.register("colored_egg_blue_flower_white",
                    ()-> flowerStampedEgg(DyeColor.BLUE, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_FLOWER_ORANGE =
            ITEMS.register("colored_egg_blue_flower_orange",
                    ()-> flowerStampedEgg(DyeColor.BLUE, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_FLOWER_MAGENTA =
            ITEMS.register("colored_egg_blue_flower_magenta",
                    ()-> flowerStampedEgg(DyeColor.BLUE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_FLOWER_LIGHT_BLUE =
            ITEMS.register("colored_egg_blue_flower_light_blue",
                    ()-> flowerStampedEgg(DyeColor.BLUE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_FLOWER_YELLOW =
            ITEMS.register("colored_egg_blue_flower_yellow",
                    ()-> flowerStampedEgg(DyeColor.BLUE, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_FLOWER_LIME =
            ITEMS.register("colored_egg_blue_flower_lime",
                    ()-> flowerStampedEgg(DyeColor.BLUE, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_FLOWER_PINK =
            ITEMS.register("colored_egg_blue_flower_pink",
                    ()-> flowerStampedEgg(DyeColor.BLUE, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_FLOWER_GRAY =
            ITEMS.register("colored_egg_blue_flower_gray",
                    ()-> flowerStampedEgg(DyeColor.BLUE, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_FLOWER_LIGHT_GRAY =
            ITEMS.register("colored_egg_blue_flower_light_gray",
                    ()-> flowerStampedEgg(DyeColor.BLUE, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_FLOWER_CYAN =
            ITEMS.register("colored_egg_blue_flower_cyan",
                    ()-> flowerStampedEgg(DyeColor.BLUE, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_FLOWER_PURPLE =
            ITEMS.register("colored_egg_blue_flower_purple",
                    ()-> flowerStampedEgg(DyeColor.BLUE, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_FLOWER_BLUE =
            ITEMS.register("colored_egg_blue_flower_blue",
                    ()-> flowerStampedEgg(DyeColor.BLUE, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_FLOWER_BROWN =
            ITEMS.register("colored_egg_blue_flower_brown",
                    ()-> flowerStampedEgg(DyeColor.BLUE, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_FLOWER_GREEN =
            ITEMS.register("colored_egg_blue_flower_green",
                    ()-> flowerStampedEgg(DyeColor.BLUE, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_FLOWER_RED =
            ITEMS.register("colored_egg_blue_flower_red",
                    ()-> flowerStampedEgg(DyeColor.BLUE, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_FLOWER_BLACK =
            ITEMS.register("colored_egg_blue_flower_black",
                    ()-> flowerStampedEgg(DyeColor.BLUE, DyeColor.BLACK));

    // brown colored egg flower variants
    public static final RegistryObject<Item> COLORED_EGG_BROWN_FLOWER_WHITE =
            ITEMS.register("colored_egg_brown_flower_white",
                    ()-> flowerStampedEgg(DyeColor.BROWN, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_FLOWER_ORANGE =
            ITEMS.register("colored_egg_brown_flower_orange",
                    ()-> flowerStampedEgg(DyeColor.BROWN, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_FLOWER_MAGENTA =
            ITEMS.register("colored_egg_brown_flower_magenta",
                    ()-> flowerStampedEgg(DyeColor.BROWN, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_FLOWER_LIGHT_BLUE =
            ITEMS.register("colored_egg_brown_flower_light_blue",
                    ()-> flowerStampedEgg(DyeColor.BROWN, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_FLOWER_YELLOW =
            ITEMS.register("colored_egg_brown_flower_yellow",
                    ()-> flowerStampedEgg(DyeColor.BROWN, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_FLOWER_LIME =
            ITEMS.register("colored_egg_brown_flower_lime",
                    ()-> flowerStampedEgg(DyeColor.BROWN, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_FLOWER_PINK =
            ITEMS.register("colored_egg_brown_flower_pink",
                    ()-> flowerStampedEgg(DyeColor.BROWN, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_FLOWER_GRAY =
            ITEMS.register("colored_egg_brown_flower_gray",
                    ()-> flowerStampedEgg(DyeColor.BROWN, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_FLOWER_LIGHT_GRAY =
            ITEMS.register("colored_egg_brown_flower_light_gray",
                    ()-> flowerStampedEgg(DyeColor.BROWN, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_FLOWER_CYAN =
            ITEMS.register("colored_egg_brown_flower_cyan",
                    ()-> flowerStampedEgg(DyeColor.BROWN, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_FLOWER_PURPLE =
            ITEMS.register("colored_egg_brown_flower_purple",
                    ()-> flowerStampedEgg(DyeColor.BROWN, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_FLOWER_BLUE =
            ITEMS.register("colored_egg_brown_flower_blue",
                    ()-> flowerStampedEgg(DyeColor.BROWN, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_FLOWER_BROWN =
            ITEMS.register("colored_egg_brown_flower_brown",
                    ()-> flowerStampedEgg(DyeColor.BROWN, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_FLOWER_GREEN =
            ITEMS.register("colored_egg_brown_flower_green",
                    ()-> flowerStampedEgg(DyeColor.BROWN, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_FLOWER_RED =
            ITEMS.register("colored_egg_brown_flower_red",
                    ()-> flowerStampedEgg(DyeColor.BROWN, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_FLOWER_BLACK =
            ITEMS.register("colored_egg_brown_flower_black",
                    ()-> flowerStampedEgg(DyeColor.BROWN, DyeColor.BLACK));

    // green colored egg flower variants
    public static final RegistryObject<Item> COLORED_EGG_GREEN_FLOWER_WHITE =
            ITEMS.register("colored_egg_green_flower_white",
                    ()-> flowerStampedEgg(DyeColor.GREEN, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_FLOWER_ORANGE =
            ITEMS.register("colored_egg_green_flower_orange",
                    ()-> flowerStampedEgg(DyeColor.GREEN, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_FLOWER_MAGENTA =
            ITEMS.register("colored_egg_green_flower_magenta",
                    ()-> flowerStampedEgg(DyeColor.GREEN, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_FLOWER_LIGHT_BLUE =
            ITEMS.register("colored_egg_green_flower_light_blue",
                    ()-> flowerStampedEgg(DyeColor.GREEN, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_FLOWER_YELLOW =
            ITEMS.register("colored_egg_green_flower_yellow",
                    ()-> flowerStampedEgg(DyeColor.GREEN, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_FLOWER_LIME =
            ITEMS.register("colored_egg_green_flower_lime",
                    ()-> flowerStampedEgg(DyeColor.GREEN, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_FLOWER_PINK =
            ITEMS.register("colored_egg_green_flower_pink",
                    ()-> flowerStampedEgg(DyeColor.GREEN, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_FLOWER_GRAY =
            ITEMS.register("colored_egg_green_flower_gray",
                    ()-> flowerStampedEgg(DyeColor.GREEN, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_FLOWER_LIGHT_GRAY =
            ITEMS.register("colored_egg_green_flower_light_gray",
                    ()-> flowerStampedEgg(DyeColor.GREEN, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_FLOWER_CYAN =
            ITEMS.register("colored_egg_green_flower_cyan",
                    ()-> flowerStampedEgg(DyeColor.GREEN, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_FLOWER_PURPLE =
            ITEMS.register("colored_egg_green_flower_purple",
                    ()-> flowerStampedEgg(DyeColor.GREEN, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_FLOWER_BLUE =
            ITEMS.register("colored_egg_green_flower_blue",
                    ()-> flowerStampedEgg(DyeColor.GREEN, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_FLOWER_BROWN =
            ITEMS.register("colored_egg_green_flower_brown",
                    ()-> flowerStampedEgg(DyeColor.GREEN, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_FLOWER_GREEN =
            ITEMS.register("colored_egg_green_flower_green",
                    ()-> flowerStampedEgg(DyeColor.GREEN, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_FLOWER_RED =
            ITEMS.register("colored_egg_green_flower_red",
                    ()-> flowerStampedEgg(DyeColor.GREEN, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_FLOWER_BLACK =
            ITEMS.register("colored_egg_green_flower_black",
                    ()-> flowerStampedEgg(DyeColor.GREEN, DyeColor.BLACK));

    // red colored egg flower variants
    public static final RegistryObject<Item> COLORED_EGG_RED_FLOWER_WHITE =
            ITEMS.register("colored_egg_red_flower_white",
                    ()-> flowerStampedEgg(DyeColor.RED, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_RED_FLOWER_ORANGE =
            ITEMS.register("colored_egg_red_flower_orange",
                    ()-> flowerStampedEgg(DyeColor.RED, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_RED_FLOWER_MAGENTA =
            ITEMS.register("colored_egg_red_flower_magenta",
                    ()-> flowerStampedEgg(DyeColor.RED, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_RED_FLOWER_LIGHT_BLUE =
            ITEMS.register("colored_egg_red_flower_light_blue",
                    ()-> flowerStampedEgg(DyeColor.RED, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_RED_FLOWER_YELLOW =
            ITEMS.register("colored_egg_red_flower_yellow",
                    ()-> flowerStampedEgg(DyeColor.RED, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_RED_FLOWER_LIME =
            ITEMS.register("colored_egg_red_flower_lime",
                    ()-> flowerStampedEgg(DyeColor.RED, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_RED_FLOWER_PINK =
            ITEMS.register("colored_egg_red_flower_pink",
                    ()-> flowerStampedEgg(DyeColor.RED, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_RED_FLOWER_GRAY =
            ITEMS.register("colored_egg_red_flower_gray",
                    ()-> flowerStampedEgg(DyeColor.RED, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_RED_FLOWER_LIGHT_GRAY =
            ITEMS.register("colored_egg_red_flower_light_gray",
                    ()-> flowerStampedEgg(DyeColor.RED, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_RED_FLOWER_CYAN =
            ITEMS.register("colored_egg_red_flower_cyan",
                    ()-> flowerStampedEgg(DyeColor.RED, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_RED_FLOWER_PURPLE =
            ITEMS.register("colored_egg_red_flower_purple",
                    ()-> flowerStampedEgg(DyeColor.RED, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_RED_FLOWER_BLUE =
            ITEMS.register("colored_egg_red_flower_blue",
                    ()-> flowerStampedEgg(DyeColor.RED, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_RED_FLOWER_BROWN =
            ITEMS.register("colored_egg_red_flower_brown",
                    ()-> flowerStampedEgg(DyeColor.RED, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_RED_FLOWER_GREEN =
            ITEMS.register("colored_egg_red_flower_green",
                    ()-> flowerStampedEgg(DyeColor.RED, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_RED_FLOWER_RED =
            ITEMS.register("colored_egg_red_flower_red",
                    ()-> flowerStampedEgg(DyeColor.RED, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_RED_FLOWER_BLACK =
            ITEMS.register("colored_egg_red_flower_black",
                    ()-> flowerStampedEgg(DyeColor.RED, DyeColor.BLACK));

    // black colored egg flower variants
    public static final RegistryObject<Item> COLORED_EGG_BLACK_FLOWER_WHITE =
            ITEMS.register("colored_egg_black_flower_white",
                    ()-> flowerStampedEgg(DyeColor.BLACK, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_FLOWER_ORANGE =
            ITEMS.register("colored_egg_black_flower_orange",
                    ()-> flowerStampedEgg(DyeColor.BLACK, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_FLOWER_MAGENTA =
            ITEMS.register("colored_egg_black_flower_magenta",
                    ()-> flowerStampedEgg(DyeColor.BLACK, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_FLOWER_LIGHT_BLUE =
            ITEMS.register("colored_egg_black_flower_light_blue",
                    ()-> flowerStampedEgg(DyeColor.BLACK, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_FLOWER_YELLOW =
            ITEMS.register("colored_egg_black_flower_yellow",
                    ()-> flowerStampedEgg(DyeColor.BLACK, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_FLOWER_LIME =
            ITEMS.register("colored_egg_black_flower_lime",
                    ()-> flowerStampedEgg(DyeColor.BLACK, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_FLOWER_PINK =
            ITEMS.register("colored_egg_black_flower_pink",
                    ()-> flowerStampedEgg(DyeColor.BLACK, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_FLOWER_GRAY =
            ITEMS.register("colored_egg_black_flower_gray",
                    ()-> flowerStampedEgg(DyeColor.BLACK, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_FLOWER_LIGHT_GRAY =
            ITEMS.register("colored_egg_black_flower_light_gray",
                    ()-> flowerStampedEgg(DyeColor.BLACK, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_FLOWER_CYAN =
            ITEMS.register("colored_egg_black_flower_cyan",
                    ()-> flowerStampedEgg(DyeColor.BLACK, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_FLOWER_PURPLE =
            ITEMS.register("colored_egg_black_flower_purple",
                    ()-> flowerStampedEgg(DyeColor.BLACK, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_FLOWER_BLUE =
            ITEMS.register("colored_egg_black_flower_blue",
                    ()-> flowerStampedEgg(DyeColor.BLACK, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_FLOWER_BROWN =
            ITEMS.register("colored_egg_black_flower_brown",
                    ()-> flowerStampedEgg(DyeColor.BLACK, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_FLOWER_GREEN =
            ITEMS.register("colored_egg_black_flower_green",
                    ()-> flowerStampedEgg(DyeColor.BLACK, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_FLOWER_RED =
            ITEMS.register("colored_egg_black_flower_red",
                    ()-> flowerStampedEgg(DyeColor.BLACK, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_FLOWER_BLACK =
            ITEMS.register("colored_egg_black_flower_black",
                    ()-> flowerStampedEgg(DyeColor.BLACK, DyeColor.BLACK));

    public static final RegistryObject<Item> BASKET_OAK_WHITE =
            ITEMS.register("basket_oak_white", () -> basket(TBABlocks.BASKET_OAK_WHITE.get()));
    public static final RegistryObject<Item> BASKET_OAK_LIGHT_GRAY =
            ITEMS.register("basket_oak_light_gray", () -> basket(TBABlocks.BASKET_OAK_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_OAK_GRAY =
            ITEMS.register("basket_oak_gray", () -> basket(TBABlocks.BASKET_OAK_GRAY.get()));
    public static final RegistryObject<Item> BASKET_OAK_BLACK =
            ITEMS.register("basket_oak_black", () -> basket(TBABlocks.BASKET_OAK_BLACK.get()));
    public static final RegistryObject<Item> BASKET_OAK_BROWN =
            ITEMS.register("basket_oak_brown", () -> basket(TBABlocks.BASKET_OAK_BROWN.get()));
    public static final RegistryObject<Item> BASKET_OAK_RED =
            ITEMS.register("basket_oak_red", () -> basket(TBABlocks.BASKET_OAK_RED.get()));
    public static final RegistryObject<Item> BASKET_OAK_ORANGE =
            ITEMS.register("basket_oak_orange", () -> basket(TBABlocks.BASKET_OAK_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_OAK_YELLOW =
            ITEMS.register("basket_oak_yellow", () -> basket(TBABlocks.BASKET_OAK_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_OAK_LIME =
            ITEMS.register("basket_oak_lime", () -> basket(TBABlocks.BASKET_OAK_LIME.get()));
    public static final RegistryObject<Item> BASKET_OAK_GREEN =
            ITEMS.register("basket_oak_green", () -> basket(TBABlocks.BASKET_OAK_GREEN.get()));
    public static final RegistryObject<Item> BASKET_OAK_CYAN =
            ITEMS.register("basket_oak_cyan", () -> basket(TBABlocks.BASKET_OAK_CYAN.get()));
    public static final RegistryObject<Item> BASKET_OAK_LIGHT_BLUE =
            ITEMS.register("basket_oak_light_blue", () -> basket(TBABlocks.BASKET_OAK_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_OAK_BLUE =
            ITEMS.register("basket_oak_blue", () -> basket(TBABlocks.BASKET_OAK_BLUE.get()));
    public static final RegistryObject<Item> BASKET_OAK_PURPLE =
            ITEMS.register("basket_oak_purple", () -> basket(TBABlocks.BASKET_OAK_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_OAK_MAGENTA =
            ITEMS.register("basket_oak_magenta", () -> basket(TBABlocks.BASKET_OAK_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_OAK_PINK =
            ITEMS.register("basket_oak_pink", () -> basket(TBABlocks.BASKET_OAK_PINK.get()));
    public static final RegistryObject<Item> BASKET_BIRCH_WHITE =
            ITEMS.register("basket_birch_white", () -> basket(TBABlocks.BASKET_BIRCH_WHITE.get()));
    public static final RegistryObject<Item> BASKET_BIRCH_LIGHT_GRAY =
            ITEMS.register("basket_birch_light_gray", () -> basket(TBABlocks.BASKET_BIRCH_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_BIRCH_GRAY =
            ITEMS.register("basket_birch_gray", () -> basket(TBABlocks.BASKET_BIRCH_GRAY.get()));
    public static final RegistryObject<Item> BASKET_BIRCH_BLACK =
            ITEMS.register("basket_birch_black", () -> basket(TBABlocks.BASKET_BIRCH_BLACK.get()));
    public static final RegistryObject<Item> BASKET_BIRCH_BROWN =
            ITEMS.register("basket_birch_brown", () -> basket(TBABlocks.BASKET_BIRCH_BROWN.get()));
    public static final RegistryObject<Item> BASKET_BIRCH_RED =
            ITEMS.register("basket_birch_red", () -> basket(TBABlocks.BASKET_BIRCH_RED.get()));
    public static final RegistryObject<Item> BASKET_BIRCH_ORANGE =
            ITEMS.register("basket_birch_orange", () -> basket(TBABlocks.BASKET_BIRCH_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_BIRCH_YELLOW =
            ITEMS.register("basket_birch_yellow", () -> basket(TBABlocks.BASKET_BIRCH_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_BIRCH_LIME =
            ITEMS.register("basket_birch_lime", () -> basket(TBABlocks.BASKET_BIRCH_LIME.get()));
    public static final RegistryObject<Item> BASKET_BIRCH_GREEN =
            ITEMS.register("basket_birch_green", () -> basket(TBABlocks.BASKET_BIRCH_GREEN.get()));
    public static final RegistryObject<Item> BASKET_BIRCH_CYAN =
            ITEMS.register("basket_birch_cyan", () -> basket(TBABlocks.BASKET_BIRCH_CYAN.get()));
    public static final RegistryObject<Item> BASKET_BIRCH_LIGHT_BLUE =
            ITEMS.register("basket_birch_light_blue", () -> basket(TBABlocks.BASKET_BIRCH_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_BIRCH_BLUE =
            ITEMS.register("basket_birch_blue", () -> basket(TBABlocks.BASKET_BIRCH_BLUE.get()));
    public static final RegistryObject<Item> BASKET_BIRCH_PURPLE =
            ITEMS.register("basket_birch_purple", () -> basket(TBABlocks.BASKET_BIRCH_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_BIRCH_MAGENTA =
            ITEMS.register("basket_birch_magenta", () -> basket(TBABlocks.BASKET_BIRCH_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_BIRCH_PINK =
            ITEMS.register("basket_birch_pink", () -> basket(TBABlocks.BASKET_BIRCH_PINK.get()));
    public static final RegistryObject<Item> BASKET_SPRUCE_WHITE =
            ITEMS.register("basket_spruce_white", () -> basket(TBABlocks.BASKET_SPRUCE_WHITE.get()));
    public static final RegistryObject<Item> BASKET_SPRUCE_LIGHT_GRAY =
            ITEMS.register("basket_spruce_light_gray", () -> basket(TBABlocks.BASKET_SPRUCE_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_SPRUCE_GRAY =
            ITEMS.register("basket_spruce_gray", () -> basket(TBABlocks.BASKET_SPRUCE_GRAY.get()));
    public static final RegistryObject<Item> BASKET_SPRUCE_BLACK =
            ITEMS.register("basket_spruce_black", () -> basket(TBABlocks.BASKET_SPRUCE_BLACK.get()));
    public static final RegistryObject<Item> BASKET_SPRUCE_BROWN =
            ITEMS.register("basket_spruce_brown", () -> basket(TBABlocks.BASKET_SPRUCE_BROWN.get()));
    public static final RegistryObject<Item> BASKET_SPRUCE_RED =
            ITEMS.register("basket_spruce_red", () -> basket(TBABlocks.BASKET_SPRUCE_RED.get()));
    public static final RegistryObject<Item> BASKET_SPRUCE_ORANGE =
            ITEMS.register("basket_spruce_orange", () -> basket(TBABlocks.BASKET_SPRUCE_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_SPRUCE_YELLOW =
            ITEMS.register("basket_spruce_yellow", () -> basket(TBABlocks.BASKET_SPRUCE_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_SPRUCE_LIME =
            ITEMS.register("basket_spruce_lime", () -> basket(TBABlocks.BASKET_SPRUCE_LIME.get()));
    public static final RegistryObject<Item> BASKET_SPRUCE_GREEN =
            ITEMS.register("basket_spruce_green", () -> basket(TBABlocks.BASKET_SPRUCE_GREEN.get()));
    public static final RegistryObject<Item> BASKET_SPRUCE_CYAN =
            ITEMS.register("basket_spruce_cyan", () -> basket(TBABlocks.BASKET_SPRUCE_CYAN.get()));
    public static final RegistryObject<Item> BASKET_SPRUCE_LIGHT_BLUE =
            ITEMS.register("basket_spruce_light_blue", () -> basket(TBABlocks.BASKET_SPRUCE_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_SPRUCE_BLUE =
            ITEMS.register("basket_spruce_blue", () -> basket(TBABlocks.BASKET_SPRUCE_BLUE.get()));
    public static final RegistryObject<Item> BASKET_SPRUCE_PURPLE =
            ITEMS.register("basket_spruce_purple", () -> basket(TBABlocks.BASKET_SPRUCE_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_SPRUCE_MAGENTA =
            ITEMS.register("basket_spruce_magenta", () -> basket(TBABlocks.BASKET_SPRUCE_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_SPRUCE_PINK =
            ITEMS.register("basket_spruce_pink", () -> basket(TBABlocks.BASKET_SPRUCE_PINK.get()));
    public static final RegistryObject<Item> BASKET_JUNGLE_WHITE =
            ITEMS.register("basket_jungle_white", () -> basket(TBABlocks.BASKET_JUNGLE_WHITE.get()));
    public static final RegistryObject<Item> BASKET_JUNGLE_LIGHT_GRAY =
            ITEMS.register("basket_jungle_light_gray", () -> basket(TBABlocks.BASKET_JUNGLE_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_JUNGLE_GRAY =
            ITEMS.register("basket_jungle_gray", () -> basket(TBABlocks.BASKET_JUNGLE_GRAY.get()));
    public static final RegistryObject<Item> BASKET_JUNGLE_BLACK =
            ITEMS.register("basket_jungle_black", () -> basket(TBABlocks.BASKET_JUNGLE_BLACK.get()));
    public static final RegistryObject<Item> BASKET_JUNGLE_BROWN =
            ITEMS.register("basket_jungle_brown", () -> basket(TBABlocks.BASKET_JUNGLE_BROWN.get()));
    public static final RegistryObject<Item> BASKET_JUNGLE_RED =
            ITEMS.register("basket_jungle_red", () -> basket(TBABlocks.BASKET_JUNGLE_RED.get()));
    public static final RegistryObject<Item> BASKET_JUNGLE_ORANGE =
            ITEMS.register("basket_jungle_orange", () -> basket(TBABlocks.BASKET_JUNGLE_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_JUNGLE_YELLOW =
            ITEMS.register("basket_jungle_yellow", () -> basket(TBABlocks.BASKET_JUNGLE_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_JUNGLE_LIME =
            ITEMS.register("basket_jungle_lime", () -> basket(TBABlocks.BASKET_JUNGLE_LIME.get()));
    public static final RegistryObject<Item> BASKET_JUNGLE_GREEN =
            ITEMS.register("basket_jungle_green", () -> basket(TBABlocks.BASKET_JUNGLE_GREEN.get()));
    public static final RegistryObject<Item> BASKET_JUNGLE_CYAN =
            ITEMS.register("basket_jungle_cyan", () -> basket(TBABlocks.BASKET_JUNGLE_CYAN.get()));
    public static final RegistryObject<Item> BASKET_JUNGLE_LIGHT_BLUE =
            ITEMS.register("basket_jungle_light_blue", () -> basket(TBABlocks.BASKET_JUNGLE_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_JUNGLE_BLUE =
            ITEMS.register("basket_jungle_blue", () -> basket(TBABlocks.BASKET_JUNGLE_BLUE.get()));
    public static final RegistryObject<Item> BASKET_JUNGLE_PURPLE =
            ITEMS.register("basket_jungle_purple", () -> basket(TBABlocks.BASKET_JUNGLE_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_JUNGLE_MAGENTA =
            ITEMS.register("basket_jungle_magenta", () -> basket(TBABlocks.BASKET_JUNGLE_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_JUNGLE_PINK =
            ITEMS.register("basket_jungle_pink", () -> basket(TBABlocks.BASKET_JUNGLE_PINK.get()));
    public static final RegistryObject<Item> BASKET_ACACIA_WHITE =
            ITEMS.register("basket_acacia_white", () -> basket(TBABlocks.BASKET_ACACIA_WHITE.get()));
    public static final RegistryObject<Item> BASKET_ACACIA_LIGHT_GRAY =
            ITEMS.register("basket_acacia_light_gray", () -> basket(TBABlocks.BASKET_ACACIA_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_ACACIA_GRAY =
            ITEMS.register("basket_acacia_gray", () -> basket(TBABlocks.BASKET_ACACIA_GRAY.get()));
    public static final RegistryObject<Item> BASKET_ACACIA_BLACK =
            ITEMS.register("basket_acacia_black", () -> basket(TBABlocks.BASKET_ACACIA_BLACK.get()));
    public static final RegistryObject<Item> BASKET_ACACIA_BROWN =
            ITEMS.register("basket_acacia_brown", () -> basket(TBABlocks.BASKET_ACACIA_BROWN.get()));
    public static final RegistryObject<Item> BASKET_ACACIA_RED =
            ITEMS.register("basket_acacia_red", () -> basket(TBABlocks.BASKET_ACACIA_RED.get()));
    public static final RegistryObject<Item> BASKET_ACACIA_ORANGE =
            ITEMS.register("basket_acacia_orange", () -> basket(TBABlocks.BASKET_ACACIA_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_ACACIA_YELLOW =
            ITEMS.register("basket_acacia_yellow", () -> basket(TBABlocks.BASKET_ACACIA_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_ACACIA_LIME =
            ITEMS.register("basket_acacia_lime", () -> basket(TBABlocks.BASKET_ACACIA_LIME.get()));
    public static final RegistryObject<Item> BASKET_ACACIA_GREEN =
            ITEMS.register("basket_acacia_green", () -> basket(TBABlocks.BASKET_ACACIA_GREEN.get()));
    public static final RegistryObject<Item> BASKET_ACACIA_CYAN =
            ITEMS.register("basket_acacia_cyan", () -> basket(TBABlocks.BASKET_ACACIA_CYAN.get()));
    public static final RegistryObject<Item> BASKET_ACACIA_LIGHT_BLUE =
            ITEMS.register("basket_acacia_light_blue", () -> basket(TBABlocks.BASKET_ACACIA_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_ACACIA_BLUE =
            ITEMS.register("basket_acacia_blue", () -> basket(TBABlocks.BASKET_ACACIA_BLUE.get()));
    public static final RegistryObject<Item> BASKET_ACACIA_PURPLE =
            ITEMS.register("basket_acacia_purple", () -> basket(TBABlocks.BASKET_ACACIA_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_ACACIA_MAGENTA =
            ITEMS.register("basket_acacia_magenta", () -> basket(TBABlocks.BASKET_ACACIA_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_ACACIA_PINK =
            ITEMS.register("basket_acacia_pink", () -> basket(TBABlocks.BASKET_ACACIA_PINK.get()));
    public static final RegistryObject<Item> BASKET_DARK_OAK_WHITE =
            ITEMS.register("basket_dark_oak_white", () -> basket(TBABlocks.BASKET_DARK_OAK_WHITE.get()));
    public static final RegistryObject<Item> BASKET_DARK_OAK_LIGHT_GRAY =
            ITEMS.register("basket_dark_oak_light_gray", () -> basket(TBABlocks.BASKET_DARK_OAK_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_DARK_OAK_GRAY =
            ITEMS.register("basket_dark_oak_gray", () -> basket(TBABlocks.BASKET_DARK_OAK_GRAY.get()));
    public static final RegistryObject<Item> BASKET_DARK_OAK_BLACK =
            ITEMS.register("basket_dark_oak_black", () -> basket(TBABlocks.BASKET_DARK_OAK_BLACK.get()));
    public static final RegistryObject<Item> BASKET_DARK_OAK_BROWN =
            ITEMS.register("basket_dark_oak_brown", () -> basket(TBABlocks.BASKET_DARK_OAK_BROWN.get()));
    public static final RegistryObject<Item> BASKET_DARK_OAK_RED =
            ITEMS.register("basket_dark_oak_red", () -> basket(TBABlocks.BASKET_DARK_OAK_RED.get()));
    public static final RegistryObject<Item> BASKET_DARK_OAK_ORANGE =
            ITEMS.register("basket_dark_oak_orange", () -> basket(TBABlocks.BASKET_DARK_OAK_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_DARK_OAK_YELLOW =
            ITEMS.register("basket_dark_oak_yellow", () -> basket(TBABlocks.BASKET_DARK_OAK_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_DARK_OAK_LIME =
            ITEMS.register("basket_dark_oak_lime", () -> basket(TBABlocks.BASKET_DARK_OAK_LIME.get()));
    public static final RegistryObject<Item> BASKET_DARK_OAK_GREEN =
            ITEMS.register("basket_dark_oak_green", () -> basket(TBABlocks.BASKET_DARK_OAK_GREEN.get()));
    public static final RegistryObject<Item> BASKET_DARK_OAK_CYAN =
            ITEMS.register("basket_dark_oak_cyan", () -> basket(TBABlocks.BASKET_DARK_OAK_CYAN.get()));
    public static final RegistryObject<Item> BASKET_DARK_OAK_LIGHT_BLUE =
            ITEMS.register("basket_dark_oak_light_blue", () -> basket(TBABlocks.BASKET_DARK_OAK_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_DARK_OAK_BLUE =
            ITEMS.register("basket_dark_oak_blue", () -> basket(TBABlocks.BASKET_DARK_OAK_BLUE.get()));
    public static final RegistryObject<Item> BASKET_DARK_OAK_PURPLE =
            ITEMS.register("basket_dark_oak_purple", () -> basket(TBABlocks.BASKET_DARK_OAK_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_DARK_OAK_MAGENTA =
            ITEMS.register("basket_dark_oak_magenta", () -> basket(TBABlocks.BASKET_DARK_OAK_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_DARK_OAK_PINK =
            ITEMS.register("basket_dark_oak_pink", () -> basket(TBABlocks.BASKET_DARK_OAK_PINK.get()));
    public static final RegistryObject<Item> BASKET_MANGROVE_WHITE =
            ITEMS.register("basket_mangrove_white", () -> basket(TBABlocks.BASKET_MANGROVE_WHITE.get()));
    public static final RegistryObject<Item> BASKET_MANGROVE_LIGHT_GRAY =
            ITEMS.register("basket_mangrove_light_gray", () -> basket(TBABlocks.BASKET_MANGROVE_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_MANGROVE_GRAY =
            ITEMS.register("basket_mangrove_gray", () -> basket(TBABlocks.BASKET_MANGROVE_GRAY.get()));
    public static final RegistryObject<Item> BASKET_MANGROVE_BLACK =
            ITEMS.register("basket_mangrove_black", () -> basket(TBABlocks.BASKET_MANGROVE_BLACK.get()));
    public static final RegistryObject<Item> BASKET_MANGROVE_BROWN =
            ITEMS.register("basket_mangrove_brown", () -> basket(TBABlocks.BASKET_MANGROVE_BROWN.get()));
    public static final RegistryObject<Item> BASKET_MANGROVE_RED =
            ITEMS.register("basket_mangrove_red", () -> basket(TBABlocks.BASKET_MANGROVE_RED.get()));
    public static final RegistryObject<Item> BASKET_MANGROVE_ORANGE =
            ITEMS.register("basket_mangrove_orange", () -> basket(TBABlocks.BASKET_MANGROVE_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_MANGROVE_YELLOW =
            ITEMS.register("basket_mangrove_yellow", () -> basket(TBABlocks.BASKET_MANGROVE_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_MANGROVE_LIME =
            ITEMS.register("basket_mangrove_lime", () -> basket(TBABlocks.BASKET_MANGROVE_LIME.get()));
    public static final RegistryObject<Item> BASKET_MANGROVE_GREEN =
            ITEMS.register("basket_mangrove_green", () -> basket(TBABlocks.BASKET_MANGROVE_GREEN.get()));
    public static final RegistryObject<Item> BASKET_MANGROVE_CYAN =
            ITEMS.register("basket_mangrove_cyan", () -> basket(TBABlocks.BASKET_MANGROVE_CYAN.get()));
    public static final RegistryObject<Item> BASKET_MANGROVE_LIGHT_BLUE =
            ITEMS.register("basket_mangrove_light_blue", () -> basket(TBABlocks.BASKET_MANGROVE_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_MANGROVE_BLUE =
            ITEMS.register("basket_mangrove_blue", () -> basket(TBABlocks.BASKET_MANGROVE_BLUE.get()));
    public static final RegistryObject<Item> BASKET_MANGROVE_PURPLE =
            ITEMS.register("basket_mangrove_purple", () -> basket(TBABlocks.BASKET_MANGROVE_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_MANGROVE_MAGENTA =
            ITEMS.register("basket_mangrove_magenta", () -> basket(TBABlocks.BASKET_MANGROVE_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_MANGROVE_PINK =
            ITEMS.register("basket_mangrove_pink", () -> basket(TBABlocks.BASKET_MANGROVE_PINK.get()));
    public static final RegistryObject<Item> BASKET_CRIMSON_WHITE =
            ITEMS.register("basket_crimson_white", () -> basket(TBABlocks.BASKET_CRIMSON_WHITE.get()));
    public static final RegistryObject<Item> BASKET_CRIMSON_LIGHT_GRAY =
            ITEMS.register("basket_crimson_light_gray", () -> basket(TBABlocks.BASKET_CRIMSON_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_CRIMSON_GRAY =
            ITEMS.register("basket_crimson_gray", () -> basket(TBABlocks.BASKET_CRIMSON_GRAY.get()));
    public static final RegistryObject<Item> BASKET_CRIMSON_BLACK =
            ITEMS.register("basket_crimson_black", () -> basket(TBABlocks.BASKET_CRIMSON_BLACK.get()));
    public static final RegistryObject<Item> BASKET_CRIMSON_BROWN =
            ITEMS.register("basket_crimson_brown", () -> basket(TBABlocks.BASKET_CRIMSON_BROWN.get()));
    public static final RegistryObject<Item> BASKET_CRIMSON_RED =
            ITEMS.register("basket_crimson_red", () -> basket(TBABlocks.BASKET_CRIMSON_RED.get()));
    public static final RegistryObject<Item> BASKET_CRIMSON_ORANGE =
            ITEMS.register("basket_crimson_orange", () -> basket(TBABlocks.BASKET_CRIMSON_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_CRIMSON_YELLOW =
            ITEMS.register("basket_crimson_yellow", () -> basket(TBABlocks.BASKET_CRIMSON_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_CRIMSON_LIME =
            ITEMS.register("basket_crimson_lime", () -> basket(TBABlocks.BASKET_CRIMSON_LIME.get()));
    public static final RegistryObject<Item> BASKET_CRIMSON_GREEN =
            ITEMS.register("basket_crimson_green", () -> basket(TBABlocks.BASKET_CRIMSON_GREEN.get()));
    public static final RegistryObject<Item> BASKET_CRIMSON_CYAN =
            ITEMS.register("basket_crimson_cyan", () -> basket(TBABlocks.BASKET_CRIMSON_CYAN.get()));
    public static final RegistryObject<Item> BASKET_CRIMSON_LIGHT_BLUE =
            ITEMS.register("basket_crimson_light_blue", () -> basket(TBABlocks.BASKET_CRIMSON_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_CRIMSON_BLUE =
            ITEMS.register("basket_crimson_blue", () -> basket(TBABlocks.BASKET_CRIMSON_BLUE.get()));
    public static final RegistryObject<Item> BASKET_CRIMSON_PURPLE =
            ITEMS.register("basket_crimson_purple", () -> basket(TBABlocks.BASKET_CRIMSON_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_CRIMSON_MAGENTA =
            ITEMS.register("basket_crimson_magenta", () -> basket(TBABlocks.BASKET_CRIMSON_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_CRIMSON_PINK =
            ITEMS.register("basket_crimson_pink", () -> basket(TBABlocks.BASKET_CRIMSON_PINK.get()));
    public static final RegistryObject<Item> BASKET_WARPED_WHITE =
            ITEMS.register("basket_warped_white", () -> basket(TBABlocks.BASKET_WARPED_WHITE.get()));
    public static final RegistryObject<Item> BASKET_WARPED_LIGHT_GRAY =
            ITEMS.register("basket_warped_light_gray", () -> basket(TBABlocks.BASKET_WARPED_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_WARPED_GRAY =
            ITEMS.register("basket_warped_gray", () -> basket(TBABlocks.BASKET_WARPED_GRAY.get()));
    public static final RegistryObject<Item> BASKET_WARPED_BLACK =
            ITEMS.register("basket_warped_black", () -> basket(TBABlocks.BASKET_WARPED_BLACK.get()));
    public static final RegistryObject<Item> BASKET_WARPED_BROWN =
            ITEMS.register("basket_warped_brown", () -> basket(TBABlocks.BASKET_WARPED_BROWN.get()));
    public static final RegistryObject<Item> BASKET_WARPED_RED =
            ITEMS.register("basket_warped_red", () -> basket(TBABlocks.BASKET_WARPED_RED.get()));
    public static final RegistryObject<Item> BASKET_WARPED_ORANGE =
            ITEMS.register("basket_warped_orange", () -> basket(TBABlocks.BASKET_WARPED_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_WARPED_YELLOW =
            ITEMS.register("basket_warped_yellow", () -> basket(TBABlocks.BASKET_WARPED_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_WARPED_LIME =
            ITEMS.register("basket_warped_lime", () -> basket(TBABlocks.BASKET_WARPED_LIME.get()));
    public static final RegistryObject<Item> BASKET_WARPED_GREEN =
            ITEMS.register("basket_warped_green", () -> basket(TBABlocks.BASKET_WARPED_GREEN.get()));
    public static final RegistryObject<Item> BASKET_WARPED_CYAN =
            ITEMS.register("basket_warped_cyan", () -> basket(TBABlocks.BASKET_WARPED_CYAN.get()));
    public static final RegistryObject<Item> BASKET_WARPED_LIGHT_BLUE =
            ITEMS.register("basket_warped_light_blue", () -> basket(TBABlocks.BASKET_WARPED_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_WARPED_BLUE =
            ITEMS.register("basket_warped_blue", () -> basket(TBABlocks.BASKET_WARPED_BLUE.get()));
    public static final RegistryObject<Item> BASKET_WARPED_PURPLE =
            ITEMS.register("basket_warped_purple", () -> basket(TBABlocks.BASKET_WARPED_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_WARPED_MAGENTA =
            ITEMS.register("basket_warped_magenta", () -> basket(TBABlocks.BASKET_WARPED_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_WARPED_PINK =
            ITEMS.register("basket_warped_pink", () -> basket(TBABlocks.BASKET_WARPED_PINK.get()));
    public static final RegistryObject<Item> BASKET_FIR_WHITE =
            ITEMS.register("basket_fir_white", () -> basket(TBABlocks.BASKET_FIR_WHITE.get()));
    public static final RegistryObject<Item> BASKET_FIR_LIGHT_GRAY =
            ITEMS.register("basket_fir_light_gray", () -> basket(TBABlocks.BASKET_FIR_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_FIR_GRAY =
            ITEMS.register("basket_fir_gray", () -> basket(TBABlocks.BASKET_FIR_GRAY.get()));
    public static final RegistryObject<Item> BASKET_FIR_BLACK =
            ITEMS.register("basket_fir_black", () -> basket(TBABlocks.BASKET_FIR_BLACK.get()));
    public static final RegistryObject<Item> BASKET_FIR_BROWN =
            ITEMS.register("basket_fir_brown", () -> basket(TBABlocks.BASKET_FIR_BROWN.get()));
    public static final RegistryObject<Item> BASKET_FIR_RED =
            ITEMS.register("basket_fir_red", () -> basket(TBABlocks.BASKET_FIR_RED.get()));
    public static final RegistryObject<Item> BASKET_FIR_ORANGE =
            ITEMS.register("basket_fir_orange", () -> basket(TBABlocks.BASKET_FIR_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_FIR_YELLOW =
            ITEMS.register("basket_fir_yellow", () -> basket(TBABlocks.BASKET_FIR_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_FIR_LIME =
            ITEMS.register("basket_fir_lime", () -> basket(TBABlocks.BASKET_FIR_LIME.get()));
    public static final RegistryObject<Item> BASKET_FIR_GREEN =
            ITEMS.register("basket_fir_green", () -> basket(TBABlocks.BASKET_FIR_GREEN.get()));
    public static final RegistryObject<Item> BASKET_FIR_CYAN =
            ITEMS.register("basket_fir_cyan", () -> basket(TBABlocks.BASKET_FIR_CYAN.get()));
    public static final RegistryObject<Item> BASKET_FIR_LIGHT_BLUE =
            ITEMS.register("basket_fir_light_blue", () -> basket(TBABlocks.BASKET_FIR_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_FIR_BLUE =
            ITEMS.register("basket_fir_blue", () -> basket(TBABlocks.BASKET_FIR_BLUE.get()));
    public static final RegistryObject<Item> BASKET_FIR_PURPLE =
            ITEMS.register("basket_fir_purple", () -> basket(TBABlocks.BASKET_FIR_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_FIR_MAGENTA =
            ITEMS.register("basket_fir_magenta", () -> basket(TBABlocks.BASKET_FIR_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_FIR_PINK =
            ITEMS.register("basket_fir_pink", () -> basket(TBABlocks.BASKET_FIR_PINK.get()));
    public static final RegistryObject<Item> BASKET_REDWOOD_WHITE =
            ITEMS.register("basket_redwood_white", () -> basket(TBABlocks.BASKET_REDWOOD_WHITE.get()));
    public static final RegistryObject<Item> BASKET_REDWOOD_LIGHT_GRAY =
            ITEMS.register("basket_redwood_light_gray", () -> basket(TBABlocks.BASKET_REDWOOD_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_REDWOOD_GRAY =
            ITEMS.register("basket_redwood_gray", () -> basket(TBABlocks.BASKET_REDWOOD_GRAY.get()));
    public static final RegistryObject<Item> BASKET_REDWOOD_BLACK =
            ITEMS.register("basket_redwood_black", () -> basket(TBABlocks.BASKET_REDWOOD_BLACK.get()));
    public static final RegistryObject<Item> BASKET_REDWOOD_BROWN =
            ITEMS.register("basket_redwood_brown", () -> basket(TBABlocks.BASKET_REDWOOD_BROWN.get()));
    public static final RegistryObject<Item> BASKET_REDWOOD_RED =
            ITEMS.register("basket_redwood_red", () -> basket(TBABlocks.BASKET_REDWOOD_RED.get()));
    public static final RegistryObject<Item> BASKET_REDWOOD_ORANGE =
            ITEMS.register("basket_redwood_orange", () -> basket(TBABlocks.BASKET_REDWOOD_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_REDWOOD_YELLOW =
            ITEMS.register("basket_redwood_yellow", () -> basket(TBABlocks.BASKET_REDWOOD_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_REDWOOD_LIME =
            ITEMS.register("basket_redwood_lime", () -> basket(TBABlocks.BASKET_REDWOOD_LIME.get()));
    public static final RegistryObject<Item> BASKET_REDWOOD_GREEN =
            ITEMS.register("basket_redwood_green", () -> basket(TBABlocks.BASKET_REDWOOD_GREEN.get()));
    public static final RegistryObject<Item> BASKET_REDWOOD_CYAN =
            ITEMS.register("basket_redwood_cyan", () -> basket(TBABlocks.BASKET_REDWOOD_CYAN.get()));
    public static final RegistryObject<Item> BASKET_REDWOOD_LIGHT_BLUE =
            ITEMS.register("basket_redwood_light_blue", () -> basket(TBABlocks.BASKET_REDWOOD_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_REDWOOD_BLUE =
            ITEMS.register("basket_redwood_blue", () -> basket(TBABlocks.BASKET_REDWOOD_BLUE.get()));
    public static final RegistryObject<Item> BASKET_REDWOOD_PURPLE =
            ITEMS.register("basket_redwood_purple", () -> basket(TBABlocks.BASKET_REDWOOD_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_REDWOOD_MAGENTA =
            ITEMS.register("basket_redwood_magenta", () -> basket(TBABlocks.BASKET_REDWOOD_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_REDWOOD_PINK =
            ITEMS.register("basket_redwood_pink", () -> basket(TBABlocks.BASKET_REDWOOD_PINK.get()));
    public static final RegistryObject<Item> BASKET_CHERRY_WHITE =
            ITEMS.register("basket_cherry_white", () -> basket(TBABlocks.BASKET_CHERRY_WHITE.get()));
    public static final RegistryObject<Item> BASKET_CHERRY_LIGHT_GRAY =
            ITEMS.register("basket_cherry_light_gray", () -> basket(TBABlocks.BASKET_CHERRY_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_CHERRY_GRAY =
            ITEMS.register("basket_cherry_gray", () -> basket(TBABlocks.BASKET_CHERRY_GRAY.get()));
    public static final RegistryObject<Item> BASKET_CHERRY_BLACK =
            ITEMS.register("basket_cherry_black", () -> basket(TBABlocks.BASKET_CHERRY_BLACK.get()));
    public static final RegistryObject<Item> BASKET_CHERRY_BROWN =
            ITEMS.register("basket_cherry_brown", () -> basket(TBABlocks.BASKET_CHERRY_BROWN.get()));
    public static final RegistryObject<Item> BASKET_CHERRY_RED =
            ITEMS.register("basket_cherry_red", () -> basket(TBABlocks.BASKET_CHERRY_RED.get()));
    public static final RegistryObject<Item> BASKET_CHERRY_ORANGE =
            ITEMS.register("basket_cherry_orange", () -> basket(TBABlocks.BASKET_CHERRY_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_CHERRY_YELLOW =
            ITEMS.register("basket_cherry_yellow", () -> basket(TBABlocks.BASKET_CHERRY_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_CHERRY_LIME =
            ITEMS.register("basket_cherry_lime", () -> basket(TBABlocks.BASKET_CHERRY_LIME.get()));
    public static final RegistryObject<Item> BASKET_CHERRY_GREEN =
            ITEMS.register("basket_cherry_green", () -> basket(TBABlocks.BASKET_CHERRY_GREEN.get()));
    public static final RegistryObject<Item> BASKET_CHERRY_CYAN =
            ITEMS.register("basket_cherry_cyan", () -> basket(TBABlocks.BASKET_CHERRY_CYAN.get()));
    public static final RegistryObject<Item> BASKET_CHERRY_LIGHT_BLUE =
            ITEMS.register("basket_cherry_light_blue", () -> basket(TBABlocks.BASKET_CHERRY_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_CHERRY_BLUE =
            ITEMS.register("basket_cherry_blue", () -> basket(TBABlocks.BASKET_CHERRY_BLUE.get()));
    public static final RegistryObject<Item> BASKET_CHERRY_PURPLE =
            ITEMS.register("basket_cherry_purple", () -> basket(TBABlocks.BASKET_CHERRY_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_CHERRY_MAGENTA =
            ITEMS.register("basket_cherry_magenta", () -> basket(TBABlocks.BASKET_CHERRY_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_CHERRY_PINK =
            ITEMS.register("basket_cherry_pink", () -> basket(TBABlocks.BASKET_CHERRY_PINK.get()));
    public static final RegistryObject<Item> BASKET_MAHOGANY_WHITE =
            ITEMS.register("basket_mahogany_white", () -> basket(TBABlocks.BASKET_MAHOGANY_WHITE.get()));
    public static final RegistryObject<Item> BASKET_MAHOGANY_LIGHT_GRAY =
            ITEMS.register("basket_mahogany_light_gray", () -> basket(TBABlocks.BASKET_MAHOGANY_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_MAHOGANY_GRAY =
            ITEMS.register("basket_mahogany_gray", () -> basket(TBABlocks.BASKET_MAHOGANY_GRAY.get()));
    public static final RegistryObject<Item> BASKET_MAHOGANY_BLACK =
            ITEMS.register("basket_mahogany_black", () -> basket(TBABlocks.BASKET_MAHOGANY_BLACK.get()));
    public static final RegistryObject<Item> BASKET_MAHOGANY_BROWN =
            ITEMS.register("basket_mahogany_brown", () -> basket(TBABlocks.BASKET_MAHOGANY_BROWN.get()));
    public static final RegistryObject<Item> BASKET_MAHOGANY_RED =
            ITEMS.register("basket_mahogany_red", () -> basket(TBABlocks.BASKET_MAHOGANY_RED.get()));
    public static final RegistryObject<Item> BASKET_MAHOGANY_ORANGE =
            ITEMS.register("basket_mahogany_orange", () -> basket(TBABlocks.BASKET_MAHOGANY_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_MAHOGANY_YELLOW =
            ITEMS.register("basket_mahogany_yellow", () -> basket(TBABlocks.BASKET_MAHOGANY_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_MAHOGANY_LIME =
            ITEMS.register("basket_mahogany_lime", () -> basket(TBABlocks.BASKET_MAHOGANY_LIME.get()));
    public static final RegistryObject<Item> BASKET_MAHOGANY_GREEN =
            ITEMS.register("basket_mahogany_green", () -> basket(TBABlocks.BASKET_MAHOGANY_GREEN.get()));
    public static final RegistryObject<Item> BASKET_MAHOGANY_CYAN =
            ITEMS.register("basket_mahogany_cyan", () -> basket(TBABlocks.BASKET_MAHOGANY_CYAN.get()));
    public static final RegistryObject<Item> BASKET_MAHOGANY_LIGHT_BLUE =
            ITEMS.register("basket_mahogany_light_blue", () -> basket(TBABlocks.BASKET_MAHOGANY_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_MAHOGANY_BLUE =
            ITEMS.register("basket_mahogany_blue", () -> basket(TBABlocks.BASKET_MAHOGANY_BLUE.get()));
    public static final RegistryObject<Item> BASKET_MAHOGANY_PURPLE =
            ITEMS.register("basket_mahogany_purple", () -> basket(TBABlocks.BASKET_MAHOGANY_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_MAHOGANY_MAGENTA =
            ITEMS.register("basket_mahogany_magenta", () -> basket(TBABlocks.BASKET_MAHOGANY_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_MAHOGANY_PINK =
            ITEMS.register("basket_mahogany_pink", () -> basket(TBABlocks.BASKET_MAHOGANY_PINK.get()));
    public static final RegistryObject<Item> BASKET_JACARANDA_WHITE =
            ITEMS.register("basket_jacaranda_white", () -> basket(TBABlocks.BASKET_JACARANDA_WHITE.get()));
    public static final RegistryObject<Item> BASKET_JACARANDA_LIGHT_GRAY =
            ITEMS.register("basket_jacaranda_light_gray", () -> basket(TBABlocks.BASKET_JACARANDA_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_JACARANDA_GRAY =
            ITEMS.register("basket_jacaranda_gray", () -> basket(TBABlocks.BASKET_JACARANDA_GRAY.get()));
    public static final RegistryObject<Item> BASKET_JACARANDA_BLACK =
            ITEMS.register("basket_jacaranda_black", () -> basket(TBABlocks.BASKET_JACARANDA_BLACK.get()));
    public static final RegistryObject<Item> BASKET_JACARANDA_BROWN =
            ITEMS.register("basket_jacaranda_brown", () -> basket(TBABlocks.BASKET_JACARANDA_BROWN.get()));
    public static final RegistryObject<Item> BASKET_JACARANDA_RED =
            ITEMS.register("basket_jacaranda_red", () -> basket(TBABlocks.BASKET_JACARANDA_RED.get()));
    public static final RegistryObject<Item> BASKET_JACARANDA_ORANGE =
            ITEMS.register("basket_jacaranda_orange", () -> basket(TBABlocks.BASKET_JACARANDA_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_JACARANDA_YELLOW =
            ITEMS.register("basket_jacaranda_yellow", () -> basket(TBABlocks.BASKET_JACARANDA_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_JACARANDA_LIME =
            ITEMS.register("basket_jacaranda_lime", () -> basket(TBABlocks.BASKET_JACARANDA_LIME.get()));
    public static final RegistryObject<Item> BASKET_JACARANDA_GREEN =
            ITEMS.register("basket_jacaranda_green", () -> basket(TBABlocks.BASKET_JACARANDA_GREEN.get()));
    public static final RegistryObject<Item> BASKET_JACARANDA_CYAN =
            ITEMS.register("basket_jacaranda_cyan", () -> basket(TBABlocks.BASKET_JACARANDA_CYAN.get()));
    public static final RegistryObject<Item> BASKET_JACARANDA_LIGHT_BLUE =
            ITEMS.register("basket_jacaranda_light_blue", () -> basket(TBABlocks.BASKET_JACARANDA_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_JACARANDA_BLUE =
            ITEMS.register("basket_jacaranda_blue", () -> basket(TBABlocks.BASKET_JACARANDA_BLUE.get()));
    public static final RegistryObject<Item> BASKET_JACARANDA_PURPLE =
            ITEMS.register("basket_jacaranda_purple", () -> basket(TBABlocks.BASKET_JACARANDA_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_JACARANDA_MAGENTA =
            ITEMS.register("basket_jacaranda_magenta", () -> basket(TBABlocks.BASKET_JACARANDA_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_JACARANDA_PINK =
            ITEMS.register("basket_jacaranda_pink", () -> basket(TBABlocks.BASKET_JACARANDA_PINK.get()));
    public static final RegistryObject<Item> BASKET_PALM_WHITE =
            ITEMS.register("basket_palm_white", () -> basket(TBABlocks.BASKET_PALM_WHITE.get()));
    public static final RegistryObject<Item> BASKET_PALM_LIGHT_GRAY =
            ITEMS.register("basket_palm_light_gray", () -> basket(TBABlocks.BASKET_PALM_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_PALM_GRAY =
            ITEMS.register("basket_palm_gray", () -> basket(TBABlocks.BASKET_PALM_GRAY.get()));
    public static final RegistryObject<Item> BASKET_PALM_BLACK =
            ITEMS.register("basket_palm_black", () -> basket(TBABlocks.BASKET_PALM_BLACK.get()));
    public static final RegistryObject<Item> BASKET_PALM_BROWN =
            ITEMS.register("basket_palm_brown", () -> basket(TBABlocks.BASKET_PALM_BROWN.get()));
    public static final RegistryObject<Item> BASKET_PALM_RED =
            ITEMS.register("basket_palm_red", () -> basket(TBABlocks.BASKET_PALM_RED.get()));
    public static final RegistryObject<Item> BASKET_PALM_ORANGE =
            ITEMS.register("basket_palm_orange", () -> basket(TBABlocks.BASKET_PALM_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_PALM_YELLOW =
            ITEMS.register("basket_palm_yellow", () -> basket(TBABlocks.BASKET_PALM_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_PALM_LIME =
            ITEMS.register("basket_palm_lime", () -> basket(TBABlocks.BASKET_PALM_LIME.get()));
    public static final RegistryObject<Item> BASKET_PALM_GREEN =
            ITEMS.register("basket_palm_green", () -> basket(TBABlocks.BASKET_PALM_GREEN.get()));
    public static final RegistryObject<Item> BASKET_PALM_CYAN =
            ITEMS.register("basket_palm_cyan", () -> basket(TBABlocks.BASKET_PALM_CYAN.get()));
    public static final RegistryObject<Item> BASKET_PALM_LIGHT_BLUE =
            ITEMS.register("basket_palm_light_blue", () -> basket(TBABlocks.BASKET_PALM_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_PALM_BLUE =
            ITEMS.register("basket_palm_blue", () -> basket(TBABlocks.BASKET_PALM_BLUE.get()));
    public static final RegistryObject<Item> BASKET_PALM_PURPLE =
            ITEMS.register("basket_palm_purple", () -> basket(TBABlocks.BASKET_PALM_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_PALM_MAGENTA =
            ITEMS.register("basket_palm_magenta", () -> basket(TBABlocks.BASKET_PALM_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_PALM_PINK =
            ITEMS.register("basket_palm_pink", () -> basket(TBABlocks.BASKET_PALM_PINK.get()));
    public static final RegistryObject<Item> BASKET_WILLOW_WHITE =
            ITEMS.register("basket_willow_white", () -> basket(TBABlocks.BASKET_WILLOW_WHITE.get()));
    public static final RegistryObject<Item> BASKET_WILLOW_LIGHT_GRAY =
            ITEMS.register("basket_willow_light_gray", () -> basket(TBABlocks.BASKET_WILLOW_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_WILLOW_GRAY =
            ITEMS.register("basket_willow_gray", () -> basket(TBABlocks.BASKET_WILLOW_GRAY.get()));
    public static final RegistryObject<Item> BASKET_WILLOW_BLACK =
            ITEMS.register("basket_willow_black", () -> basket(TBABlocks.BASKET_WILLOW_BLACK.get()));
    public static final RegistryObject<Item> BASKET_WILLOW_BROWN =
            ITEMS.register("basket_willow_brown", () -> basket(TBABlocks.BASKET_WILLOW_BROWN.get()));
    public static final RegistryObject<Item> BASKET_WILLOW_RED =
            ITEMS.register("basket_willow_red", () -> basket(TBABlocks.BASKET_WILLOW_RED.get()));
    public static final RegistryObject<Item> BASKET_WILLOW_ORANGE =
            ITEMS.register("basket_willow_orange", () -> basket(TBABlocks.BASKET_WILLOW_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_WILLOW_YELLOW =
            ITEMS.register("basket_willow_yellow", () -> basket(TBABlocks.BASKET_WILLOW_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_WILLOW_LIME =
            ITEMS.register("basket_willow_lime", () -> basket(TBABlocks.BASKET_WILLOW_LIME.get()));
    public static final RegistryObject<Item> BASKET_WILLOW_GREEN =
            ITEMS.register("basket_willow_green", () -> basket(TBABlocks.BASKET_WILLOW_GREEN.get()));
    public static final RegistryObject<Item> BASKET_WILLOW_CYAN =
            ITEMS.register("basket_willow_cyan", () -> basket(TBABlocks.BASKET_WILLOW_CYAN.get()));
    public static final RegistryObject<Item> BASKET_WILLOW_LIGHT_BLUE =
            ITEMS.register("basket_willow_light_blue", () -> basket(TBABlocks.BASKET_WILLOW_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_WILLOW_BLUE =
            ITEMS.register("basket_willow_blue", () -> basket(TBABlocks.BASKET_WILLOW_BLUE.get()));
    public static final RegistryObject<Item> BASKET_WILLOW_PURPLE =
            ITEMS.register("basket_willow_purple", () -> basket(TBABlocks.BASKET_WILLOW_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_WILLOW_MAGENTA =
            ITEMS.register("basket_willow_magenta", () -> basket(TBABlocks.BASKET_WILLOW_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_WILLOW_PINK =
            ITEMS.register("basket_willow_pink", () -> basket(TBABlocks.BASKET_WILLOW_PINK.get()));
    public static final RegistryObject<Item> BASKET_DEAD_WHITE =
            ITEMS.register("basket_dead_white", () -> basket(TBABlocks.BASKET_DEAD_WHITE.get()));
    public static final RegistryObject<Item> BASKET_DEAD_LIGHT_GRAY =
            ITEMS.register("basket_dead_light_gray", () -> basket(TBABlocks.BASKET_DEAD_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_DEAD_GRAY =
            ITEMS.register("basket_dead_gray", () -> basket(TBABlocks.BASKET_DEAD_GRAY.get()));
    public static final RegistryObject<Item> BASKET_DEAD_BLACK =
            ITEMS.register("basket_dead_black", () -> basket(TBABlocks.BASKET_DEAD_BLACK.get()));
    public static final RegistryObject<Item> BASKET_DEAD_BROWN =
            ITEMS.register("basket_dead_brown", () -> basket(TBABlocks.BASKET_DEAD_BROWN.get()));
    public static final RegistryObject<Item> BASKET_DEAD_RED =
            ITEMS.register("basket_dead_red", () -> basket(TBABlocks.BASKET_DEAD_RED.get()));
    public static final RegistryObject<Item> BASKET_DEAD_ORANGE =
            ITEMS.register("basket_dead_orange", () -> basket(TBABlocks.BASKET_DEAD_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_DEAD_YELLOW =
            ITEMS.register("basket_dead_yellow", () -> basket(TBABlocks.BASKET_DEAD_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_DEAD_LIME =
            ITEMS.register("basket_dead_lime", () -> basket(TBABlocks.BASKET_DEAD_LIME.get()));
    public static final RegistryObject<Item> BASKET_DEAD_GREEN =
            ITEMS.register("basket_dead_green", () -> basket(TBABlocks.BASKET_DEAD_GREEN.get()));
    public static final RegistryObject<Item> BASKET_DEAD_CYAN =
            ITEMS.register("basket_dead_cyan", () -> basket(TBABlocks.BASKET_DEAD_CYAN.get()));
    public static final RegistryObject<Item> BASKET_DEAD_LIGHT_BLUE =
            ITEMS.register("basket_dead_light_blue", () -> basket(TBABlocks.BASKET_DEAD_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_DEAD_BLUE =
            ITEMS.register("basket_dead_blue", () -> basket(TBABlocks.BASKET_DEAD_BLUE.get()));
    public static final RegistryObject<Item> BASKET_DEAD_PURPLE =
            ITEMS.register("basket_dead_purple", () -> basket(TBABlocks.BASKET_DEAD_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_DEAD_MAGENTA =
            ITEMS.register("basket_dead_magenta", () -> basket(TBABlocks.BASKET_DEAD_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_DEAD_PINK =
            ITEMS.register("basket_dead_pink", () -> basket(TBABlocks.BASKET_DEAD_PINK.get()));
    public static final RegistryObject<Item> BASKET_MAGIC_WHITE =
            ITEMS.register("basket_magic_white", () -> basket(TBABlocks.BASKET_MAGIC_WHITE.get()));
    public static final RegistryObject<Item> BASKET_MAGIC_LIGHT_GRAY =
            ITEMS.register("basket_magic_light_gray", () -> basket(TBABlocks.BASKET_MAGIC_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_MAGIC_GRAY =
            ITEMS.register("basket_magic_gray", () -> basket(TBABlocks.BASKET_MAGIC_GRAY.get()));
    public static final RegistryObject<Item> BASKET_MAGIC_BLACK =
            ITEMS.register("basket_magic_black", () -> basket(TBABlocks.BASKET_MAGIC_BLACK.get()));
    public static final RegistryObject<Item> BASKET_MAGIC_BROWN =
            ITEMS.register("basket_magic_brown", () -> basket(TBABlocks.BASKET_MAGIC_BROWN.get()));
    public static final RegistryObject<Item> BASKET_MAGIC_RED =
            ITEMS.register("basket_magic_red", () -> basket(TBABlocks.BASKET_MAGIC_RED.get()));
    public static final RegistryObject<Item> BASKET_MAGIC_ORANGE =
            ITEMS.register("basket_magic_orange", () -> basket(TBABlocks.BASKET_MAGIC_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_MAGIC_YELLOW =
            ITEMS.register("basket_magic_yellow", () -> basket(TBABlocks.BASKET_MAGIC_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_MAGIC_LIME =
            ITEMS.register("basket_magic_lime", () -> basket(TBABlocks.BASKET_MAGIC_LIME.get()));
    public static final RegistryObject<Item> BASKET_MAGIC_GREEN =
            ITEMS.register("basket_magic_green", () -> basket(TBABlocks.BASKET_MAGIC_GREEN.get()));
    public static final RegistryObject<Item> BASKET_MAGIC_CYAN =
            ITEMS.register("basket_magic_cyan", () -> basket(TBABlocks.BASKET_MAGIC_CYAN.get()));
    public static final RegistryObject<Item> BASKET_MAGIC_LIGHT_BLUE =
            ITEMS.register("basket_magic_light_blue", () -> basket(TBABlocks.BASKET_MAGIC_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_MAGIC_BLUE =
            ITEMS.register("basket_magic_blue", () -> basket(TBABlocks.BASKET_MAGIC_BLUE.get()));
    public static final RegistryObject<Item> BASKET_MAGIC_PURPLE =
            ITEMS.register("basket_magic_purple", () -> basket(TBABlocks.BASKET_MAGIC_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_MAGIC_MAGENTA =
            ITEMS.register("basket_magic_magenta", () -> basket(TBABlocks.BASKET_MAGIC_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_MAGIC_PINK =
            ITEMS.register("basket_magic_pink", () -> basket(TBABlocks.BASKET_MAGIC_PINK.get()));
    public static final RegistryObject<Item> BASKET_UMBRAN_WHITE =
            ITEMS.register("basket_umbran_white", () -> basket(TBABlocks.BASKET_UMBRAN_WHITE.get()));
    public static final RegistryObject<Item> BASKET_UMBRAN_LIGHT_GRAY =
            ITEMS.register("basket_umbran_light_gray", () -> basket(TBABlocks.BASKET_UMBRAN_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_UMBRAN_GRAY =
            ITEMS.register("basket_umbran_gray", () -> basket(TBABlocks.BASKET_UMBRAN_GRAY.get()));
    public static final RegistryObject<Item> BASKET_UMBRAN_BLACK =
            ITEMS.register("basket_umbran_black", () -> basket(TBABlocks.BASKET_UMBRAN_BLACK.get()));
    public static final RegistryObject<Item> BASKET_UMBRAN_BROWN =
            ITEMS.register("basket_umbran_brown", () -> basket(TBABlocks.BASKET_UMBRAN_BROWN.get()));
    public static final RegistryObject<Item> BASKET_UMBRAN_RED =
            ITEMS.register("basket_umbran_red", () -> basket(TBABlocks.BASKET_UMBRAN_RED.get()));
    public static final RegistryObject<Item> BASKET_UMBRAN_ORANGE =
            ITEMS.register("basket_umbran_orange", () -> basket(TBABlocks.BASKET_UMBRAN_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_UMBRAN_YELLOW =
            ITEMS.register("basket_umbran_yellow", () -> basket(TBABlocks.BASKET_UMBRAN_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_UMBRAN_LIME =
            ITEMS.register("basket_umbran_lime", () -> basket(TBABlocks.BASKET_UMBRAN_LIME.get()));
    public static final RegistryObject<Item> BASKET_UMBRAN_GREEN =
            ITEMS.register("basket_umbran_green", () -> basket(TBABlocks.BASKET_UMBRAN_GREEN.get()));
    public static final RegistryObject<Item> BASKET_UMBRAN_CYAN =
            ITEMS.register("basket_umbran_cyan", () -> basket(TBABlocks.BASKET_UMBRAN_CYAN.get()));
    public static final RegistryObject<Item> BASKET_UMBRAN_LIGHT_BLUE =
            ITEMS.register("basket_umbran_light_blue", () -> basket(TBABlocks.BASKET_UMBRAN_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_UMBRAN_BLUE =
            ITEMS.register("basket_umbran_blue", () -> basket(TBABlocks.BASKET_UMBRAN_BLUE.get()));
    public static final RegistryObject<Item> BASKET_UMBRAN_PURPLE =
            ITEMS.register("basket_umbran_purple", () -> basket(TBABlocks.BASKET_UMBRAN_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_UMBRAN_MAGENTA =
            ITEMS.register("basket_umbran_magenta", () -> basket(TBABlocks.BASKET_UMBRAN_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_UMBRAN_PINK =
            ITEMS.register("basket_umbran_pink", () -> basket(TBABlocks.BASKET_UMBRAN_PINK.get()));
    public static final RegistryObject<Item> BASKET_HELLBARK_WHITE =
            ITEMS.register("basket_hellbark_white", () -> basket(TBABlocks.BASKET_HELLBARK_WHITE.get()));
    public static final RegistryObject<Item> BASKET_HELLBARK_LIGHT_GRAY =
            ITEMS.register("basket_hellbark_light_gray", () -> basket(TBABlocks.BASKET_HELLBARK_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_HELLBARK_GRAY =
            ITEMS.register("basket_hellbark_gray", () -> basket(TBABlocks.BASKET_HELLBARK_GRAY.get()));
    public static final RegistryObject<Item> BASKET_HELLBARK_BLACK =
            ITEMS.register("basket_hellbark_black", () -> basket(TBABlocks.BASKET_HELLBARK_BLACK.get()));
    public static final RegistryObject<Item> BASKET_HELLBARK_BROWN =
            ITEMS.register("basket_hellbark_brown", () -> basket(TBABlocks.BASKET_HELLBARK_BROWN.get()));
    public static final RegistryObject<Item> BASKET_HELLBARK_RED =
            ITEMS.register("basket_hellbark_red", () -> basket(TBABlocks.BASKET_HELLBARK_RED.get()));
    public static final RegistryObject<Item> BASKET_HELLBARK_ORANGE =
            ITEMS.register("basket_hellbark_orange", () -> basket(TBABlocks.BASKET_HELLBARK_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_HELLBARK_YELLOW =
            ITEMS.register("basket_hellbark_yellow", () -> basket(TBABlocks.BASKET_HELLBARK_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_HELLBARK_LIME =
            ITEMS.register("basket_hellbark_lime", () -> basket(TBABlocks.BASKET_HELLBARK_LIME.get()));
    public static final RegistryObject<Item> BASKET_HELLBARK_GREEN =
            ITEMS.register("basket_hellbark_green", () -> basket(TBABlocks.BASKET_HELLBARK_GREEN.get()));
    public static final RegistryObject<Item> BASKET_HELLBARK_CYAN =
            ITEMS.register("basket_hellbark_cyan", () -> basket(TBABlocks.BASKET_HELLBARK_CYAN.get()));
    public static final RegistryObject<Item> BASKET_HELLBARK_LIGHT_BLUE =
            ITEMS.register("basket_hellbark_light_blue", () -> basket(TBABlocks.BASKET_HELLBARK_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_HELLBARK_BLUE =
            ITEMS.register("basket_hellbark_blue", () -> basket(TBABlocks.BASKET_HELLBARK_BLUE.get()));
    public static final RegistryObject<Item> BASKET_HELLBARK_PURPLE =
            ITEMS.register("basket_hellbark_purple", () -> basket(TBABlocks.BASKET_HELLBARK_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_HELLBARK_MAGENTA =
            ITEMS.register("basket_hellbark_magenta", () -> basket(TBABlocks.BASKET_HELLBARK_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_HELLBARK_PINK =
            ITEMS.register("basket_hellbark_pink", () -> basket(TBABlocks.BASKET_HELLBARK_PINK.get()));
    public static final RegistryObject<Item> BASKET_COCONUT_WHITE =
            ITEMS.register("basket_coconut_white", () -> basket(TBABlocks.BASKET_COCONUT_WHITE.get()));
    public static final RegistryObject<Item> BASKET_COCONUT_LIGHT_GRAY =
            ITEMS.register("basket_coconut_light_gray", () -> basket(TBABlocks.BASKET_COCONUT_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_COCONUT_GRAY =
            ITEMS.register("basket_coconut_gray", () -> basket(TBABlocks.BASKET_COCONUT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_COCONUT_BLACK =
            ITEMS.register("basket_coconut_black", () -> basket(TBABlocks.BASKET_COCONUT_BLACK.get()));
    public static final RegistryObject<Item> BASKET_COCONUT_BROWN =
            ITEMS.register("basket_coconut_brown", () -> basket(TBABlocks.BASKET_COCONUT_BROWN.get()));
    public static final RegistryObject<Item> BASKET_COCONUT_RED =
            ITEMS.register("basket_coconut_red", () -> basket(TBABlocks.BASKET_COCONUT_RED.get()));
    public static final RegistryObject<Item> BASKET_COCONUT_ORANGE =
            ITEMS.register("basket_coconut_orange", () -> basket(TBABlocks.BASKET_COCONUT_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_COCONUT_YELLOW =
            ITEMS.register("basket_coconut_yellow", () -> basket(TBABlocks.BASKET_COCONUT_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_COCONUT_LIME =
            ITEMS.register("basket_coconut_lime", () -> basket(TBABlocks.BASKET_COCONUT_LIME.get()));
    public static final RegistryObject<Item> BASKET_COCONUT_GREEN =
            ITEMS.register("basket_coconut_green", () -> basket(TBABlocks.BASKET_COCONUT_GREEN.get()));
    public static final RegistryObject<Item> BASKET_COCONUT_CYAN =
            ITEMS.register("basket_coconut_cyan", () -> basket(TBABlocks.BASKET_COCONUT_CYAN.get()));
    public static final RegistryObject<Item> BASKET_COCONUT_LIGHT_BLUE =
            ITEMS.register("basket_coconut_light_blue", () -> basket(TBABlocks.BASKET_COCONUT_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_COCONUT_BLUE =
            ITEMS.register("basket_coconut_blue", () -> basket(TBABlocks.BASKET_COCONUT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_COCONUT_PURPLE =
            ITEMS.register("basket_coconut_purple", () -> basket(TBABlocks.BASKET_COCONUT_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_COCONUT_MAGENTA =
            ITEMS.register("basket_coconut_magenta", () -> basket(TBABlocks.BASKET_COCONUT_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_COCONUT_PINK =
            ITEMS.register("basket_coconut_pink", () -> basket(TBABlocks.BASKET_COCONUT_PINK.get()));
    public static final RegistryObject<Item> BASKET_WALNUT_WHITE =
            ITEMS.register("basket_walnut_white", () -> basket(TBABlocks.BASKET_WALNUT_WHITE.get()));
    public static final RegistryObject<Item> BASKET_WALNUT_LIGHT_GRAY =
            ITEMS.register("basket_walnut_light_gray", () -> basket(TBABlocks.BASKET_WALNUT_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_WALNUT_GRAY =
            ITEMS.register("basket_walnut_gray", () -> basket(TBABlocks.BASKET_WALNUT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_WALNUT_BLACK =
            ITEMS.register("basket_walnut_black", () -> basket(TBABlocks.BASKET_WALNUT_BLACK.get()));
    public static final RegistryObject<Item> BASKET_WALNUT_BROWN =
            ITEMS.register("basket_walnut_brown", () -> basket(TBABlocks.BASKET_WALNUT_BROWN.get()));
    public static final RegistryObject<Item> BASKET_WALNUT_RED =
            ITEMS.register("basket_walnut_red", () -> basket(TBABlocks.BASKET_WALNUT_RED.get()));
    public static final RegistryObject<Item> BASKET_WALNUT_ORANGE =
            ITEMS.register("basket_walnut_orange", () -> basket(TBABlocks.BASKET_WALNUT_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_WALNUT_YELLOW =
            ITEMS.register("basket_walnut_yellow", () -> basket(TBABlocks.BASKET_WALNUT_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_WALNUT_LIME =
            ITEMS.register("basket_walnut_lime", () -> basket(TBABlocks.BASKET_WALNUT_LIME.get()));
    public static final RegistryObject<Item> BASKET_WALNUT_GREEN =
            ITEMS.register("basket_walnut_green", () -> basket(TBABlocks.BASKET_WALNUT_GREEN.get()));
    public static final RegistryObject<Item> BASKET_WALNUT_CYAN =
            ITEMS.register("basket_walnut_cyan", () -> basket(TBABlocks.BASKET_WALNUT_CYAN.get()));
    public static final RegistryObject<Item> BASKET_WALNUT_LIGHT_BLUE =
            ITEMS.register("basket_walnut_light_blue", () -> basket(TBABlocks.BASKET_WALNUT_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_WALNUT_BLUE =
            ITEMS.register("basket_walnut_blue", () -> basket(TBABlocks.BASKET_WALNUT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_WALNUT_PURPLE =
            ITEMS.register("basket_walnut_purple", () -> basket(TBABlocks.BASKET_WALNUT_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_WALNUT_MAGENTA =
            ITEMS.register("basket_walnut_magenta", () -> basket(TBABlocks.BASKET_WALNUT_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_WALNUT_PINK =
            ITEMS.register("basket_walnut_pink", () -> basket(TBABlocks.BASKET_WALNUT_PINK.get()));
    public static final RegistryObject<Item> BASKET_AZALEA_WHITE =
            ITEMS.register("basket_azalea_white", () -> basket(TBABlocks.BASKET_AZALEA_WHITE.get()));
    public static final RegistryObject<Item> BASKET_AZALEA_LIGHT_GRAY =
            ITEMS.register("basket_azalea_light_gray", () -> basket(TBABlocks.BASKET_AZALEA_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_AZALEA_GRAY =
            ITEMS.register("basket_azalea_gray", () -> basket(TBABlocks.BASKET_AZALEA_GRAY.get()));
    public static final RegistryObject<Item> BASKET_AZALEA_BLACK =
            ITEMS.register("basket_azalea_black", () -> basket(TBABlocks.BASKET_AZALEA_BLACK.get()));
    public static final RegistryObject<Item> BASKET_AZALEA_BROWN =
            ITEMS.register("basket_azalea_brown", () -> basket(TBABlocks.BASKET_AZALEA_BROWN.get()));
    public static final RegistryObject<Item> BASKET_AZALEA_RED =
            ITEMS.register("basket_azalea_red", () -> basket(TBABlocks.BASKET_AZALEA_RED.get()));
    public static final RegistryObject<Item> BASKET_AZALEA_ORANGE =
            ITEMS.register("basket_azalea_orange", () -> basket(TBABlocks.BASKET_AZALEA_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_AZALEA_YELLOW =
            ITEMS.register("basket_azalea_yellow", () -> basket(TBABlocks.BASKET_AZALEA_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_AZALEA_LIME =
            ITEMS.register("basket_azalea_lime", () -> basket(TBABlocks.BASKET_AZALEA_LIME.get()));
    public static final RegistryObject<Item> BASKET_AZALEA_GREEN =
            ITEMS.register("basket_azalea_green", () -> basket(TBABlocks.BASKET_AZALEA_GREEN.get()));
    public static final RegistryObject<Item> BASKET_AZALEA_CYAN =
            ITEMS.register("basket_azalea_cyan", () -> basket(TBABlocks.BASKET_AZALEA_CYAN.get()));
    public static final RegistryObject<Item> BASKET_AZALEA_LIGHT_BLUE =
            ITEMS.register("basket_azalea_light_blue", () -> basket(TBABlocks.BASKET_AZALEA_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_AZALEA_BLUE =
            ITEMS.register("basket_azalea_blue", () -> basket(TBABlocks.BASKET_AZALEA_BLUE.get()));
    public static final RegistryObject<Item> BASKET_AZALEA_PURPLE =
            ITEMS.register("basket_azalea_purple", () -> basket(TBABlocks.BASKET_AZALEA_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_AZALEA_MAGENTA =
            ITEMS.register("basket_azalea_magenta", () -> basket(TBABlocks.BASKET_AZALEA_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_AZALEA_PINK =
            ITEMS.register("basket_azalea_pink", () -> basket(TBABlocks.BASKET_AZALEA_PINK.get()));
    public static final RegistryObject<Item> BASKET_FLOWERING_AZALEA_WHITE =
            ITEMS.register("basket_flowering_azalea_white", () -> basket(TBABlocks.BASKET_FLOWERING_AZALEA_WHITE.get()));
    public static final RegistryObject<Item> BASKET_FLOWERING_AZALEA_LIGHT_GRAY =
            ITEMS.register("basket_flowering_azalea_light_gray", () -> basket(TBABlocks.BASKET_FLOWERING_AZALEA_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_FLOWERING_AZALEA_GRAY =
            ITEMS.register("basket_flowering_azalea_gray", () -> basket(TBABlocks.BASKET_FLOWERING_AZALEA_GRAY.get()));
    public static final RegistryObject<Item> BASKET_FLOWERING_AZALEA_BLACK =
            ITEMS.register("basket_flowering_azalea_black", () -> basket(TBABlocks.BASKET_FLOWERING_AZALEA_BLACK.get()));
    public static final RegistryObject<Item> BASKET_FLOWERING_AZALEA_BROWN =
            ITEMS.register("basket_flowering_azalea_brown", () -> basket(TBABlocks.BASKET_FLOWERING_AZALEA_BROWN.get()));
    public static final RegistryObject<Item> BASKET_FLOWERING_AZALEA_RED =
            ITEMS.register("basket_flowering_azalea_red", () -> basket(TBABlocks.BASKET_FLOWERING_AZALEA_RED.get()));
    public static final RegistryObject<Item> BASKET_FLOWERING_AZALEA_ORANGE =
            ITEMS.register("basket_flowering_azalea_orange", () -> basket(TBABlocks.BASKET_FLOWERING_AZALEA_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_FLOWERING_AZALEA_YELLOW =
            ITEMS.register("basket_flowering_azalea_yellow", () -> basket(TBABlocks.BASKET_FLOWERING_AZALEA_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_FLOWERING_AZALEA_LIME =
            ITEMS.register("basket_flowering_azalea_lime", () -> basket(TBABlocks.BASKET_FLOWERING_AZALEA_LIME.get()));
    public static final RegistryObject<Item> BASKET_FLOWERING_AZALEA_GREEN =
            ITEMS.register("basket_flowering_azalea_green", () -> basket(TBABlocks.BASKET_FLOWERING_AZALEA_GREEN.get()));
    public static final RegistryObject<Item> BASKET_FLOWERING_AZALEA_CYAN =
            ITEMS.register("basket_flowering_azalea_cyan", () -> basket(TBABlocks.BASKET_FLOWERING_AZALEA_CYAN.get()));
    public static final RegistryObject<Item> BASKET_FLOWERING_AZALEA_LIGHT_BLUE =
            ITEMS.register("basket_flowering_azalea_light_blue", () -> basket(TBABlocks.BASKET_FLOWERING_AZALEA_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_FLOWERING_AZALEA_BLUE =
            ITEMS.register("basket_flowering_azalea_blue", () -> basket(TBABlocks.BASKET_FLOWERING_AZALEA_BLUE.get()));
    public static final RegistryObject<Item> BASKET_FLOWERING_AZALEA_PURPLE =
            ITEMS.register("basket_flowering_azalea_purple", () -> basket(TBABlocks.BASKET_FLOWERING_AZALEA_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_FLOWERING_AZALEA_MAGENTA =
            ITEMS.register("basket_flowering_azalea_magenta", () -> basket(TBABlocks.BASKET_FLOWERING_AZALEA_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_FLOWERING_AZALEA_PINK =
            ITEMS.register("basket_flowering_azalea_pink", () -> basket(TBABlocks.BASKET_FLOWERING_AZALEA_PINK.get()));
    public static final RegistryObject<Item> BASKET_AETHER_SKYROOT_WHITE =
            ITEMS.register("basket_aether_skyroot_white", () -> basket(TBABlocks.BASKET_AETHER_SKYROOT_WHITE.get()));
    public static final RegistryObject<Item> BASKET_AETHER_SKYROOT_LIGHT_GRAY =
            ITEMS.register("basket_aether_skyroot_light_gray", () -> basket(TBABlocks.BASKET_AETHER_SKYROOT_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_AETHER_SKYROOT_GRAY =
            ITEMS.register("basket_aether_skyroot_gray", () -> basket(TBABlocks.BASKET_AETHER_SKYROOT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_AETHER_SKYROOT_BLACK =
            ITEMS.register("basket_aether_skyroot_black", () -> basket(TBABlocks.BASKET_AETHER_SKYROOT_BLACK.get()));
    public static final RegistryObject<Item> BASKET_AETHER_SKYROOT_BROWN =
            ITEMS.register("basket_aether_skyroot_brown", () -> basket(TBABlocks.BASKET_AETHER_SKYROOT_BROWN.get()));
    public static final RegistryObject<Item> BASKET_AETHER_SKYROOT_RED =
            ITEMS.register("basket_aether_skyroot_red", () -> basket(TBABlocks.BASKET_AETHER_SKYROOT_RED.get()));
    public static final RegistryObject<Item> BASKET_AETHER_SKYROOT_ORANGE =
            ITEMS.register("basket_aether_skyroot_orange", () -> basket(TBABlocks.BASKET_AETHER_SKYROOT_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_AETHER_SKYROOT_YELLOW =
            ITEMS.register("basket_aether_skyroot_yellow", () -> basket(TBABlocks.BASKET_AETHER_SKYROOT_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_AETHER_SKYROOT_LIME =
            ITEMS.register("basket_aether_skyroot_lime", () -> basket(TBABlocks.BASKET_AETHER_SKYROOT_LIME.get()));
    public static final RegistryObject<Item> BASKET_AETHER_SKYROOT_GREEN =
            ITEMS.register("basket_aether_skyroot_green", () -> basket(TBABlocks.BASKET_AETHER_SKYROOT_GREEN.get()));
    public static final RegistryObject<Item> BASKET_AETHER_SKYROOT_CYAN =
            ITEMS.register("basket_aether_skyroot_cyan", () -> basket(TBABlocks.BASKET_AETHER_SKYROOT_CYAN.get()));
    public static final RegistryObject<Item> BASKET_AETHER_SKYROOT_LIGHT_BLUE =
            ITEMS.register("basket_aether_skyroot_light_blue", () -> basket(TBABlocks.BASKET_AETHER_SKYROOT_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_AETHER_SKYROOT_BLUE =
            ITEMS.register("basket_aether_skyroot_blue", () -> basket(TBABlocks.BASKET_AETHER_SKYROOT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_AETHER_SKYROOT_PURPLE =
            ITEMS.register("basket_aether_skyroot_purple", () -> basket(TBABlocks.BASKET_AETHER_SKYROOT_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_AETHER_SKYROOT_MAGENTA =
            ITEMS.register("basket_aether_skyroot_magenta", () -> basket(TBABlocks.BASKET_AETHER_SKYROOT_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_AETHER_SKYROOT_PINK =
            ITEMS.register("basket_aether_skyroot_pink", () -> basket(TBABlocks.BASKET_AETHER_SKYROOT_PINK.get()));
    public static final RegistryObject<Item> BASKET_PREAM_WHITE =
            ITEMS.register("basket_pream_white", () -> basket(TBABlocks.BASKET_PREAM_WHITE.get()));
    public static final RegistryObject<Item> BASKET_PREAM_LIGHT_GRAY =
            ITEMS.register("basket_pream_light_gray", () -> basket(TBABlocks.BASKET_PREAM_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_PREAM_GRAY =
            ITEMS.register("basket_pream_gray", () -> basket(TBABlocks.BASKET_PREAM_GRAY.get()));
    public static final RegistryObject<Item> BASKET_PREAM_BLACK =
            ITEMS.register("basket_pream_black", () -> basket(TBABlocks.BASKET_PREAM_BLACK.get()));
    public static final RegistryObject<Item> BASKET_PREAM_BROWN =
            ITEMS.register("basket_pream_brown", () -> basket(TBABlocks.BASKET_PREAM_BROWN.get()));
    public static final RegistryObject<Item> BASKET_PREAM_RED =
            ITEMS.register("basket_pream_red", () -> basket(TBABlocks.BASKET_PREAM_RED.get()));
    public static final RegistryObject<Item> BASKET_PREAM_ORANGE =
            ITEMS.register("basket_pream_orange", () -> basket(TBABlocks.BASKET_PREAM_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_PREAM_YELLOW =
            ITEMS.register("basket_pream_yellow", () -> basket(TBABlocks.BASKET_PREAM_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_PREAM_LIME =
            ITEMS.register("basket_pream_lime", () -> basket(TBABlocks.BASKET_PREAM_LIME.get()));
    public static final RegistryObject<Item> BASKET_PREAM_GREEN =
            ITEMS.register("basket_pream_green", () -> basket(TBABlocks.BASKET_PREAM_GREEN.get()));
    public static final RegistryObject<Item> BASKET_PREAM_CYAN =
            ITEMS.register("basket_pream_cyan", () -> basket(TBABlocks.BASKET_PREAM_CYAN.get()));
    public static final RegistryObject<Item> BASKET_PREAM_LIGHT_BLUE =
            ITEMS.register("basket_pream_light_blue", () -> basket(TBABlocks.BASKET_PREAM_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_PREAM_BLUE =
            ITEMS.register("basket_pream_blue", () -> basket(TBABlocks.BASKET_PREAM_BLUE.get()));
    public static final RegistryObject<Item> BASKET_PREAM_PURPLE =
            ITEMS.register("basket_pream_purple", () -> basket(TBABlocks.BASKET_PREAM_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_PREAM_MAGENTA =
            ITEMS.register("basket_pream_magenta", () -> basket(TBABlocks.BASKET_PREAM_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_PREAM_PINK =
            ITEMS.register("basket_pream_pink", () -> basket(TBABlocks.BASKET_PREAM_PINK.get()));
    public static final RegistryObject<Item> BASKET_EBONY_WHITE =
            ITEMS.register("basket_ebony_white", () -> basket(TBABlocks.BASKET_EBONY_WHITE.get()));
    public static final RegistryObject<Item> BASKET_EBONY_LIGHT_GRAY =
            ITEMS.register("basket_ebony_light_gray", () -> basket(TBABlocks.BASKET_EBONY_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_EBONY_GRAY =
            ITEMS.register("basket_ebony_gray", () -> basket(TBABlocks.BASKET_EBONY_GRAY.get()));
    public static final RegistryObject<Item> BASKET_EBONY_BLACK =
            ITEMS.register("basket_ebony_black", () -> basket(TBABlocks.BASKET_EBONY_BLACK.get()));
    public static final RegistryObject<Item> BASKET_EBONY_BROWN =
            ITEMS.register("basket_ebony_brown", () -> basket(TBABlocks.BASKET_EBONY_BROWN.get()));
    public static final RegistryObject<Item> BASKET_EBONY_RED =
            ITEMS.register("basket_ebony_red", () -> basket(TBABlocks.BASKET_EBONY_RED.get()));
    public static final RegistryObject<Item> BASKET_EBONY_ORANGE =
            ITEMS.register("basket_ebony_orange", () -> basket(TBABlocks.BASKET_EBONY_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_EBONY_YELLOW =
            ITEMS.register("basket_ebony_yellow", () -> basket(TBABlocks.BASKET_EBONY_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_EBONY_LIME =
            ITEMS.register("basket_ebony_lime", () -> basket(TBABlocks.BASKET_EBONY_LIME.get()));
    public static final RegistryObject<Item> BASKET_EBONY_GREEN =
            ITEMS.register("basket_ebony_green", () -> basket(TBABlocks.BASKET_EBONY_GREEN.get()));
    public static final RegistryObject<Item> BASKET_EBONY_CYAN =
            ITEMS.register("basket_ebony_cyan", () -> basket(TBABlocks.BASKET_EBONY_CYAN.get()));
    public static final RegistryObject<Item> BASKET_EBONY_LIGHT_BLUE =
            ITEMS.register("basket_ebony_light_blue", () -> basket(TBABlocks.BASKET_EBONY_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_EBONY_BLUE =
            ITEMS.register("basket_ebony_blue", () -> basket(TBABlocks.BASKET_EBONY_BLUE.get()));
    public static final RegistryObject<Item> BASKET_EBONY_PURPLE =
            ITEMS.register("basket_ebony_purple", () -> basket(TBABlocks.BASKET_EBONY_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_EBONY_MAGENTA =
            ITEMS.register("basket_ebony_magenta", () -> basket(TBABlocks.BASKET_EBONY_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_EBONY_PINK =
            ITEMS.register("basket_ebony_pink", () -> basket(TBABlocks.BASKET_EBONY_PINK.get()));
    public static final RegistryObject<Item> BASKET_CHORUS_NEST_WHITE =
            ITEMS.register("basket_chorus_nest_white", () -> basket(TBABlocks.BASKET_CHORUS_NEST_WHITE.get()));
    public static final RegistryObject<Item> BASKET_CHORUS_NEST_LIGHT_GRAY =
            ITEMS.register("basket_chorus_nest_light_gray", () -> basket(TBABlocks.BASKET_CHORUS_NEST_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_CHORUS_NEST_GRAY =
            ITEMS.register("basket_chorus_nest_gray", () -> basket(TBABlocks.BASKET_CHORUS_NEST_GRAY.get()));
    public static final RegistryObject<Item> BASKET_CHORUS_NEST_BLACK =
            ITEMS.register("basket_chorus_nest_black", () -> basket(TBABlocks.BASKET_CHORUS_NEST_BLACK.get()));
    public static final RegistryObject<Item> BASKET_CHORUS_NEST_BROWN =
            ITEMS.register("basket_chorus_nest_brown", () -> basket(TBABlocks.BASKET_CHORUS_NEST_BROWN.get()));
    public static final RegistryObject<Item> BASKET_CHORUS_NEST_RED =
            ITEMS.register("basket_chorus_nest_red", () -> basket(TBABlocks.BASKET_CHORUS_NEST_RED.get()));
    public static final RegistryObject<Item> BASKET_CHORUS_NEST_ORANGE =
            ITEMS.register("basket_chorus_nest_orange", () -> basket(TBABlocks.BASKET_CHORUS_NEST_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_CHORUS_NEST_YELLOW =
            ITEMS.register("basket_chorus_nest_yellow", () -> basket(TBABlocks.BASKET_CHORUS_NEST_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_CHORUS_NEST_LIME =
            ITEMS.register("basket_chorus_nest_lime", () -> basket(TBABlocks.BASKET_CHORUS_NEST_LIME.get()));
    public static final RegistryObject<Item> BASKET_CHORUS_NEST_GREEN =
            ITEMS.register("basket_chorus_nest_green", () -> basket(TBABlocks.BASKET_CHORUS_NEST_GREEN.get()));
    public static final RegistryObject<Item> BASKET_CHORUS_NEST_CYAN =
            ITEMS.register("basket_chorus_nest_cyan", () -> basket(TBABlocks.BASKET_CHORUS_NEST_CYAN.get()));
    public static final RegistryObject<Item> BASKET_CHORUS_NEST_LIGHT_BLUE =
            ITEMS.register("basket_chorus_nest_light_blue", () -> basket(TBABlocks.BASKET_CHORUS_NEST_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_CHORUS_NEST_BLUE =
            ITEMS.register("basket_chorus_nest_blue", () -> basket(TBABlocks.BASKET_CHORUS_NEST_BLUE.get()));
    public static final RegistryObject<Item> BASKET_CHORUS_NEST_PURPLE =
            ITEMS.register("basket_chorus_nest_purple", () -> basket(TBABlocks.BASKET_CHORUS_NEST_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_CHORUS_NEST_MAGENTA =
            ITEMS.register("basket_chorus_nest_magenta", () -> basket(TBABlocks.BASKET_CHORUS_NEST_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_CHORUS_NEST_PINK =
            ITEMS.register("basket_chorus_nest_pink", () -> basket(TBABlocks.BASKET_CHORUS_NEST_PINK.get()));
    public static final RegistryObject<Item> BASKET_BLOODSHROOM_WHITE =
            ITEMS.register("basket_bloodshroom_white", () -> basket(TBABlocks.BASKET_BLOODSHROOM_WHITE.get()));
    public static final RegistryObject<Item> BASKET_BLOODSHROOM_LIGHT_GRAY =
            ITEMS.register("basket_bloodshroom_light_gray", () -> basket(TBABlocks.BASKET_BLOODSHROOM_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_BLOODSHROOM_GRAY =
            ITEMS.register("basket_bloodshroom_gray", () -> basket(TBABlocks.BASKET_BLOODSHROOM_GRAY.get()));
    public static final RegistryObject<Item> BASKET_BLOODSHROOM_BLACK =
            ITEMS.register("basket_bloodshroom_black", () -> basket(TBABlocks.BASKET_BLOODSHROOM_BLACK.get()));
    public static final RegistryObject<Item> BASKET_BLOODSHROOM_BROWN =
            ITEMS.register("basket_bloodshroom_brown", () -> basket(TBABlocks.BASKET_BLOODSHROOM_BROWN.get()));
    public static final RegistryObject<Item> BASKET_BLOODSHROOM_RED =
            ITEMS.register("basket_bloodshroom_red", () -> basket(TBABlocks.BASKET_BLOODSHROOM_RED.get()));
    public static final RegistryObject<Item> BASKET_BLOODSHROOM_ORANGE =
            ITEMS.register("basket_bloodshroom_orange", () -> basket(TBABlocks.BASKET_BLOODSHROOM_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_BLOODSHROOM_YELLOW =
            ITEMS.register("basket_bloodshroom_yellow", () -> basket(TBABlocks.BASKET_BLOODSHROOM_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_BLOODSHROOM_LIME =
            ITEMS.register("basket_bloodshroom_lime", () -> basket(TBABlocks.BASKET_BLOODSHROOM_LIME.get()));
    public static final RegistryObject<Item> BASKET_BLOODSHROOM_GREEN =
            ITEMS.register("basket_bloodshroom_green", () -> basket(TBABlocks.BASKET_BLOODSHROOM_GREEN.get()));
    public static final RegistryObject<Item> BASKET_BLOODSHROOM_CYAN =
            ITEMS.register("basket_bloodshroom_cyan", () -> basket(TBABlocks.BASKET_BLOODSHROOM_CYAN.get()));
    public static final RegistryObject<Item> BASKET_BLOODSHROOM_LIGHT_BLUE =
            ITEMS.register("basket_bloodshroom_light_blue", () -> basket(TBABlocks.BASKET_BLOODSHROOM_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_BLOODSHROOM_BLUE =
            ITEMS.register("basket_bloodshroom_blue", () -> basket(TBABlocks.BASKET_BLOODSHROOM_BLUE.get()));
    public static final RegistryObject<Item> BASKET_BLOODSHROOM_PURPLE =
            ITEMS.register("basket_bloodshroom_purple", () -> basket(TBABlocks.BASKET_BLOODSHROOM_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_BLOODSHROOM_MAGENTA =
            ITEMS.register("basket_bloodshroom_magenta", () -> basket(TBABlocks.BASKET_BLOODSHROOM_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_BLOODSHROOM_PINK =
            ITEMS.register("basket_bloodshroom_pink", () -> basket(TBABlocks.BASKET_BLOODSHROOM_PINK.get()));
    public static final RegistryObject<Item> BASKET_ENDERBARK_WHITE =
            ITEMS.register("basket_enderbark_white", () -> basket(TBABlocks.BASKET_ENDERBARK_WHITE.get()));
    public static final RegistryObject<Item> BASKET_ENDERBARK_LIGHT_GRAY =
            ITEMS.register("basket_enderbark_light_gray", () -> basket(TBABlocks.BASKET_ENDERBARK_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_ENDERBARK_GRAY =
            ITEMS.register("basket_enderbark_gray", () -> basket(TBABlocks.BASKET_ENDERBARK_GRAY.get()));
    public static final RegistryObject<Item> BASKET_ENDERBARK_BLACK =
            ITEMS.register("basket_enderbark_black", () -> basket(TBABlocks.BASKET_ENDERBARK_BLACK.get()));
    public static final RegistryObject<Item> BASKET_ENDERBARK_BROWN =
            ITEMS.register("basket_enderbark_brown", () -> basket(TBABlocks.BASKET_ENDERBARK_BROWN.get()));
    public static final RegistryObject<Item> BASKET_ENDERBARK_RED =
            ITEMS.register("basket_enderbark_red", () -> basket(TBABlocks.BASKET_ENDERBARK_RED.get()));
    public static final RegistryObject<Item> BASKET_ENDERBARK_ORANGE =
            ITEMS.register("basket_enderbark_orange", () -> basket(TBABlocks.BASKET_ENDERBARK_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_ENDERBARK_YELLOW =
            ITEMS.register("basket_enderbark_yellow", () -> basket(TBABlocks.BASKET_ENDERBARK_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_ENDERBARK_LIME =
            ITEMS.register("basket_enderbark_lime", () -> basket(TBABlocks.BASKET_ENDERBARK_LIME.get()));
    public static final RegistryObject<Item> BASKET_ENDERBARK_GREEN =
            ITEMS.register("basket_enderbark_green", () -> basket(TBABlocks.BASKET_ENDERBARK_GREEN.get()));
    public static final RegistryObject<Item> BASKET_ENDERBARK_CYAN =
            ITEMS.register("basket_enderbark_cyan", () -> basket(TBABlocks.BASKET_ENDERBARK_CYAN.get()));
    public static final RegistryObject<Item> BASKET_ENDERBARK_LIGHT_BLUE =
            ITEMS.register("basket_enderbark_light_blue", () -> basket(TBABlocks.BASKET_ENDERBARK_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_ENDERBARK_BLUE =
            ITEMS.register("basket_enderbark_blue", () -> basket(TBABlocks.BASKET_ENDERBARK_BLUE.get()));
    public static final RegistryObject<Item> BASKET_ENDERBARK_PURPLE =
            ITEMS.register("basket_enderbark_purple", () -> basket(TBABlocks.BASKET_ENDERBARK_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_ENDERBARK_MAGENTA =
            ITEMS.register("basket_enderbark_magenta", () -> basket(TBABlocks.BASKET_ENDERBARK_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_ENDERBARK_PINK =
            ITEMS.register("basket_enderbark_pink", () -> basket(TBABlocks.BASKET_ENDERBARK_PINK.get()));
    public static final RegistryObject<Item> BASKET_GREENHEART_WHITE =
            ITEMS.register("basket_greenheart_white", () -> basket(TBABlocks.BASKET_GREENHEART_WHITE.get()));
    public static final RegistryObject<Item> BASKET_GREENHEART_LIGHT_GRAY =
            ITEMS.register("basket_greenheart_light_gray", () -> basket(TBABlocks.BASKET_GREENHEART_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_GREENHEART_GRAY =
            ITEMS.register("basket_greenheart_gray", () -> basket(TBABlocks.BASKET_GREENHEART_GRAY.get()));
    public static final RegistryObject<Item> BASKET_GREENHEART_BLACK =
            ITEMS.register("basket_greenheart_black", () -> basket(TBABlocks.BASKET_GREENHEART_BLACK.get()));
    public static final RegistryObject<Item> BASKET_GREENHEART_BROWN =
            ITEMS.register("basket_greenheart_brown", () -> basket(TBABlocks.BASKET_GREENHEART_BROWN.get()));
    public static final RegistryObject<Item> BASKET_GREENHEART_RED =
            ITEMS.register("basket_greenheart_red", () -> basket(TBABlocks.BASKET_GREENHEART_RED.get()));
    public static final RegistryObject<Item> BASKET_GREENHEART_ORANGE =
            ITEMS.register("basket_greenheart_orange", () -> basket(TBABlocks.BASKET_GREENHEART_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_GREENHEART_YELLOW =
            ITEMS.register("basket_greenheart_yellow", () -> basket(TBABlocks.BASKET_GREENHEART_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_GREENHEART_LIME =
            ITEMS.register("basket_greenheart_lime", () -> basket(TBABlocks.BASKET_GREENHEART_LIME.get()));
    public static final RegistryObject<Item> BASKET_GREENHEART_GREEN =
            ITEMS.register("basket_greenheart_green", () -> basket(TBABlocks.BASKET_GREENHEART_GREEN.get()));
    public static final RegistryObject<Item> BASKET_GREENHEART_CYAN =
            ITEMS.register("basket_greenheart_cyan", () -> basket(TBABlocks.BASKET_GREENHEART_CYAN.get()));
    public static final RegistryObject<Item> BASKET_GREENHEART_LIGHT_BLUE =
            ITEMS.register("basket_greenheart_light_blue", () -> basket(TBABlocks.BASKET_GREENHEART_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_GREENHEART_BLUE =
            ITEMS.register("basket_greenheart_blue", () -> basket(TBABlocks.BASKET_GREENHEART_BLUE.get()));
    public static final RegistryObject<Item> BASKET_GREENHEART_PURPLE =
            ITEMS.register("basket_greenheart_purple", () -> basket(TBABlocks.BASKET_GREENHEART_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_GREENHEART_MAGENTA =
            ITEMS.register("basket_greenheart_magenta", () -> basket(TBABlocks.BASKET_GREENHEART_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_GREENHEART_PINK =
            ITEMS.register("basket_greenheart_pink", () -> basket(TBABlocks.BASKET_GREENHEART_PINK.get()));
    public static final RegistryObject<Item> BASKET_TINKER_SKYROOT_WHITE =
            ITEMS.register("basket_tinker_skyroot_white", () -> basket(TBABlocks.BASKET_TINKER_SKYROOT_WHITE.get()));
    public static final RegistryObject<Item> BASKET_TINKER_SKYROOT_LIGHT_GRAY =
            ITEMS.register("basket_tinker_skyroot_light_gray", () -> basket(TBABlocks.BASKET_TINKER_SKYROOT_LIGHT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_TINKER_SKYROOT_GRAY =
            ITEMS.register("basket_tinker_skyroot_gray", () -> basket(TBABlocks.BASKET_TINKER_SKYROOT_GRAY.get()));
    public static final RegistryObject<Item> BASKET_TINKER_SKYROOT_BLACK =
            ITEMS.register("basket_tinker_skyroot_black", () -> basket(TBABlocks.BASKET_TINKER_SKYROOT_BLACK.get()));
    public static final RegistryObject<Item> BASKET_TINKER_SKYROOT_BROWN =
            ITEMS.register("basket_tinker_skyroot_brown", () -> basket(TBABlocks.BASKET_TINKER_SKYROOT_BROWN.get()));
    public static final RegistryObject<Item> BASKET_TINKER_SKYROOT_RED =
            ITEMS.register("basket_tinker_skyroot_red", () -> basket(TBABlocks.BASKET_TINKER_SKYROOT_RED.get()));
    public static final RegistryObject<Item> BASKET_TINKER_SKYROOT_ORANGE =
            ITEMS.register("basket_tinker_skyroot_orange", () -> basket(TBABlocks.BASKET_TINKER_SKYROOT_ORANGE.get()));
    public static final RegistryObject<Item> BASKET_TINKER_SKYROOT_YELLOW =
            ITEMS.register("basket_tinker_skyroot_yellow", () -> basket(TBABlocks.BASKET_TINKER_SKYROOT_YELLOW.get()));
    public static final RegistryObject<Item> BASKET_TINKER_SKYROOT_LIME =
            ITEMS.register("basket_tinker_skyroot_lime", () -> basket(TBABlocks.BASKET_TINKER_SKYROOT_LIME.get()));
    public static final RegistryObject<Item> BASKET_TINKER_SKYROOT_GREEN =
            ITEMS.register("basket_tinker_skyroot_green", () -> basket(TBABlocks.BASKET_TINKER_SKYROOT_GREEN.get()));
    public static final RegistryObject<Item> BASKET_TINKER_SKYROOT_CYAN =
            ITEMS.register("basket_tinker_skyroot_cyan", () -> basket(TBABlocks.BASKET_TINKER_SKYROOT_CYAN.get()));
    public static final RegistryObject<Item> BASKET_TINKER_SKYROOT_LIGHT_BLUE =
            ITEMS.register("basket_tinker_skyroot_light_blue", () -> basket(TBABlocks.BASKET_TINKER_SKYROOT_LIGHT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_TINKER_SKYROOT_BLUE =
            ITEMS.register("basket_tinker_skyroot_blue", () -> basket(TBABlocks.BASKET_TINKER_SKYROOT_BLUE.get()));
    public static final RegistryObject<Item> BASKET_TINKER_SKYROOT_PURPLE =
            ITEMS.register("basket_tinker_skyroot_purple", () -> basket(TBABlocks.BASKET_TINKER_SKYROOT_PURPLE.get()));
    public static final RegistryObject<Item> BASKET_TINKER_SKYROOT_MAGENTA =
            ITEMS.register("basket_tinker_skyroot_magenta", () -> basket(TBABlocks.BASKET_TINKER_SKYROOT_MAGENTA.get()));
    public static final RegistryObject<Item> BASKET_TINKER_SKYROOT_PINK =
            ITEMS.register("basket_tinker_skyroot_pink", () -> basket(TBABlocks.BASKET_TINKER_SKYROOT_PINK.get()));

    private static @NotNull BasketBlockItem basket(Block basketBlock) {
        return new BasketBlockItem(basketBlock, new Item.Properties().stacksTo(1)
                .tab(TBATab.TAB));
    }

    @Contract("_ -> new")
    private static @NotNull EasterEggItem blankColoredEgg(DyeColor color) {
        return new EasterEggItem(color, null,
                EasterEggProperties.Layer.BLANK,
                new Item.Properties()
                        .stacksTo(64)
                        .tab(TBATab.TAB));
    }
    private static @NotNull EasterEggItem flowerStampedEgg(DyeColor eggColor, DyeColor stampColor) {
        return new EasterEggItem(eggColor, stampColor,
                EasterEggProperties.Layer.FLOWER,
                new Item.Properties()
                        .stacksTo(64)
                        .tab(TBATab.TAB));
    }
    private static @NotNull EasterEggItem creeperStampedEgg(DyeColor eggColor, DyeColor stampColor) {
        return new EasterEggItem(eggColor, stampColor,
                EasterEggProperties.Layer.CREEPER,
                new Item.Properties()
                        .stacksTo(64)
                        .tab(TBATab.TAB));
    }

    public static @NotNull Item.Properties foodItem(FoodProperties food) {
        return (new Item.Properties()).food(food).stacksTo(64)
                .tab(TBATab.TAB);
    }

    public static @NotNull Item.Properties bowlFoodItem(FoodProperties food) {
        return (new Item.Properties()).food(food).stacksTo(64)
                .craftRemainder(Items.BOWL)
                .tab(TBATab.TAB);
    }

    public static @NotNull Item.Properties drinkItem() {
        return (new Item.Properties()).stacksTo(64)
                .craftRemainder(Items.GLASS_BOTTLE)
                .tab(TBATab.TAB);
    }

    public static @NotNull Item.Properties basicItem() {
        return (new Item.Properties()).tab(TBATab.TAB);
    }

    public static void register(final IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}