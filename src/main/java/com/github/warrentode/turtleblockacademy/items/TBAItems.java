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
                    () -> new ItemNameBlockItem(TBABlocks.CLOVE_BUSH.get(),
                            basicItem()));
    public static final RegistryObject<Item> CUCUMBER_SEEDS =
            ITEMS.register("cucumber_seeds",
                    () -> new ItemNameBlockItem(TBABlocks.CUCUMBER_BUSH.get(),
                            basicItem()));
    public static final RegistryObject<Item> DILL_SEEDS =
            ITEMS.register("dill_seeds",
                    () -> new ItemNameBlockItem(TBABlocks.DILL_BUSH.get(),
                            basicItem()));

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

    // blank colored egg variants
    public static final RegistryObject<Item> COLORED_EGG_WHITE =
            ITEMS.register("colored_egg_white", ()-> blankEgg(DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE =
            ITEMS.register("colored_egg_orange", ()-> blankEgg(DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA =
            ITEMS.register("colored_egg_magenta", ()-> blankEgg(DyeColor.MAGENTA));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE =
            ITEMS.register("colored_egg_light_blue", ()-> blankEgg(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW =
            ITEMS.register("colored_egg_yellow", ()-> blankEgg(DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_LIME =
            ITEMS.register("colored_egg_lime", ()-> blankEgg(DyeColor.LIME));
        public static final RegistryObject<Item> COLORED_EGG_PINK =
            ITEMS.register("colored_egg_pink", ()-> blankEgg(DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_GRAY =
            ITEMS.register("colored_egg_gray", ()-> blankEgg(DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY =
            ITEMS.register("colored_egg_light_gray", ()-> blankEgg(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_CYAN =
            ITEMS.register("colored_egg_cyan", ()-> blankEgg(DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE =
            ITEMS.register("colored_egg_purple", ()-> blankEgg(DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_BLUE =
            ITEMS.register("colored_egg_blue", ()-> blankEgg(DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BROWN =
            ITEMS.register("colored_egg_brown", ()-> blankEgg(DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_GREEN =
            ITEMS.register("colored_egg_green", ()-> blankEgg(DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_RED =
            ITEMS.register("colored_egg_red", ()-> blankEgg(DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_BLACK =
            ITEMS.register("colored_egg_black", ()-> blankEgg(DyeColor.BLACK));

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

    // white colored egg checkered variants
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CHECKERED_WHITE =
            ITEMS.register("colored_egg_white_checkered_white",
                    ()-> checkeredStampedEgg(DyeColor.WHITE, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CHECKERED_ORANGE =
            ITEMS.register("colored_egg_white_checkered_orange",
                    ()-> checkeredStampedEgg(DyeColor.WHITE, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CHECKERED_MAGENTA =
            ITEMS.register("colored_egg_white_checkered_magenta",
                    ()-> checkeredStampedEgg(DyeColor.WHITE, DyeColor.MAGENTA));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CHECKERED_LIGHT_BLUE =
            ITEMS.register("colored_egg_white_checkered_light_blue",
                    ()-> checkeredStampedEgg(DyeColor.WHITE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CHECKERED_YELLOW =
            ITEMS.register("colored_egg_white_checkered_yellow",
                    ()-> checkeredStampedEgg(DyeColor.WHITE, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CHECKERED_LIME =
            ITEMS.register("colored_egg_white_checkered_lime",
                    ()-> checkeredStampedEgg(DyeColor.WHITE, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CHECKERED_PINK =
            ITEMS.register("colored_egg_white_checkered_pink",
                    ()-> checkeredStampedEgg(DyeColor.WHITE, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CHECKERED_GRAY =
            ITEMS.register("colored_egg_white_checkered_gray",
                    ()-> checkeredStampedEgg(DyeColor.WHITE, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CHECKERED_LIGHT_GRAY =
            ITEMS.register("colored_egg_white_checkered_light_gray",
                    ()-> checkeredStampedEgg(DyeColor.WHITE, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CHECKERED_CYAN =
            ITEMS.register("colored_egg_white_checkered_cyan",
                    ()-> checkeredStampedEgg(DyeColor.WHITE, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CHECKERED_PURPLE =
            ITEMS.register("colored_egg_white_checkered_purple",
                    ()-> checkeredStampedEgg(DyeColor.WHITE, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CHECKERED_BLUE =
            ITEMS.register("colored_egg_white_checkered_blue",
                    ()-> checkeredStampedEgg(DyeColor.WHITE, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CHECKERED_BROWN =
            ITEMS.register("colored_egg_white_checkered_brown",
                    ()-> checkeredStampedEgg(DyeColor.WHITE, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CHECKERED_GREEN =
            ITEMS.register("colored_egg_white_checkered_green",
                    ()-> checkeredStampedEgg(DyeColor.WHITE, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CHECKERED_RED =
            ITEMS.register("colored_egg_white_checkered_red",
                    ()-> checkeredStampedEgg(DyeColor.WHITE, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_WHITE_CHECKERED_BLACK =
            ITEMS.register("colored_egg_white_checkered_black",
                    ()-> checkeredStampedEgg(DyeColor.WHITE, DyeColor.BLACK));

    // orange colored egg checkered variants
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CHECKERED_WHITE =
            ITEMS.register("colored_egg_orange_checkered_white",
                    ()-> checkeredStampedEgg(DyeColor.ORANGE, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CHECKERED_ORANGE =
            ITEMS.register("colored_egg_orange_checkered_orange",
                    ()-> checkeredStampedEgg(DyeColor.ORANGE, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CHECKERED_MAGENTA =
            ITEMS.register("colored_egg_orange_checkered_magenta",
                    ()-> checkeredStampedEgg(DyeColor.ORANGE, DyeColor.MAGENTA));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CHECKERED_LIGHT_BLUE =
            ITEMS.register("colored_egg_orange_checkered_light_blue",
                    ()-> checkeredStampedEgg(DyeColor.ORANGE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CHECKERED_YELLOW =
            ITEMS.register("colored_egg_orange_checkered_yellow",
                    ()-> checkeredStampedEgg(DyeColor.ORANGE, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CHECKERED_LIME =
            ITEMS.register("colored_egg_orange_checkered_lime",
                    ()-> checkeredStampedEgg(DyeColor.ORANGE, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CHECKERED_PINK =
            ITEMS.register("colored_egg_orange_checkered_pink",
                    ()-> checkeredStampedEgg(DyeColor.ORANGE, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CHECKERED_GRAY =
            ITEMS.register("colored_egg_orange_checkered_gray",
                    ()-> checkeredStampedEgg(DyeColor.ORANGE, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CHECKERED_LIGHT_GRAY =
            ITEMS.register("colored_egg_orange_checkered_light_gray",
                    ()-> checkeredStampedEgg(DyeColor.ORANGE, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CHECKERED_CYAN =
            ITEMS.register("colored_egg_orange_checkered_cyan",
                    ()-> checkeredStampedEgg(DyeColor.ORANGE, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CHECKERED_PURPLE =
            ITEMS.register("colored_egg_orange_checkered_purple",
                    ()-> checkeredStampedEgg(DyeColor.ORANGE, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CHECKERED_BLUE =
            ITEMS.register("colored_egg_orange_checkered_blue",
                    ()-> checkeredStampedEgg(DyeColor.ORANGE, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CHECKERED_BROWN =
            ITEMS.register("colored_egg_orange_checkered_brown",
                    ()-> checkeredStampedEgg(DyeColor.ORANGE, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CHECKERED_GREEN =
            ITEMS.register("colored_egg_orange_checkered_green",
                    ()-> checkeredStampedEgg(DyeColor.ORANGE, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CHECKERED_RED =
            ITEMS.register("colored_egg_orange_checkered_red",
                    ()-> checkeredStampedEgg(DyeColor.ORANGE, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_ORANGE_CHECKERED_BLACK =
            ITEMS.register("colored_egg_orange_checkered_black",
                    ()-> checkeredStampedEgg(DyeColor.ORANGE, DyeColor.BLACK));

    // magenta colored egg checkered variants
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CHECKERED_WHITE =
            ITEMS.register("colored_egg_magenta_checkered_white",
                    ()-> checkeredStampedEgg(DyeColor.MAGENTA, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CHECKERED_ORANGE =
            ITEMS.register("colored_egg_magenta_checkered_orange",
                    ()-> checkeredStampedEgg(DyeColor.MAGENTA, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CHECKERED_MAGENTA =
            ITEMS.register("colored_egg_magenta_checkered_magenta",
                    ()-> checkeredStampedEgg(DyeColor.MAGENTA, DyeColor.MAGENTA));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CHECKERED_LIGHT_BLUE =
            ITEMS.register("colored_egg_magenta_checkered_light_blue",
                    ()-> checkeredStampedEgg(DyeColor.MAGENTA, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CHECKERED_YELLOW =
            ITEMS.register("colored_egg_magenta_checkered_yellow",
                    ()-> checkeredStampedEgg(DyeColor.MAGENTA, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CHECKERED_LIME =
            ITEMS.register("colored_egg_magenta_checkered_lime",
                    ()-> checkeredStampedEgg(DyeColor.MAGENTA, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CHECKERED_PINK =
            ITEMS.register("colored_egg_magenta_checkered_pink",
                    ()-> checkeredStampedEgg(DyeColor.MAGENTA, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CHECKERED_GRAY =
            ITEMS.register("colored_egg_magenta_checkered_gray",
                    ()-> checkeredStampedEgg(DyeColor.MAGENTA, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CHECKERED_LIGHT_GRAY =
            ITEMS.register("colored_egg_magenta_checkered_light_gray",
                    ()-> checkeredStampedEgg(DyeColor.MAGENTA, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CHECKERED_CYAN =
            ITEMS.register("colored_egg_magenta_checkered_cyan",
                    ()-> checkeredStampedEgg(DyeColor.MAGENTA, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CHECKERED_PURPLE =
            ITEMS.register("colored_egg_magenta_checkered_purple",
                    ()-> checkeredStampedEgg(DyeColor.MAGENTA, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CHECKERED_BLUE =
            ITEMS.register("colored_egg_magenta_checkered_blue",
                    ()-> checkeredStampedEgg(DyeColor.MAGENTA, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CHECKERED_BROWN =
            ITEMS.register("colored_egg_magenta_checkered_brown",
                    ()-> checkeredStampedEgg(DyeColor.MAGENTA, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CHECKERED_GREEN =
            ITEMS.register("colored_egg_magenta_checkered_green",
                    ()-> checkeredStampedEgg(DyeColor.MAGENTA, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CHECKERED_RED =
            ITEMS.register("colored_egg_magenta_checkered_red",
                    ()-> checkeredStampedEgg(DyeColor.MAGENTA, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_MAGENTA_CHECKERED_BLACK =
            ITEMS.register("colored_egg_magenta_checkered_black",
                    ()-> checkeredStampedEgg(DyeColor.MAGENTA, DyeColor.BLACK));

    // light blue colored egg checkered variants
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CHECKERED_WHITE =
            ITEMS.register("colored_egg_light_blue_checkered_white",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CHECKERED_ORANGE =
            ITEMS.register("colored_egg_light_blue_checkered_orange",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CHECKERED_MAGENTA =
            ITEMS.register("colored_egg_light_blue_checkered_magenta",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CHECKERED_LIGHT_BLUE =
            ITEMS.register("colored_egg_light_blue_checkered_light_blue",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CHECKERED_YELLOW =
            ITEMS.register("colored_egg_light_blue_checkered_yellow",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CHECKERED_LIME =
            ITEMS.register("colored_egg_light_blue_checkered_lime",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CHECKERED_PINK =
            ITEMS.register("colored_egg_light_blue_checkered_pink",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CHECKERED_GRAY =
            ITEMS.register("colored_egg_light_blue_checkered_gray",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CHECKERED_LIGHT_GRAY =
            ITEMS.register("colored_egg_light_blue_checkered_light_gray",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CHECKERED_CYAN =
            ITEMS.register("colored_egg_light_blue_checkered_cyan",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CHECKERED_PURPLE =
            ITEMS.register("colored_egg_light_blue_checkered_purple",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CHECKERED_BLUE =
            ITEMS.register("colored_egg_light_blue_checkered_blue",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CHECKERED_BROWN =
            ITEMS.register("colored_egg_light_blue_checkered_brown",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CHECKERED_GREEN =
            ITEMS.register("colored_egg_light_blue_checkered_green",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CHECKERED_RED =
            ITEMS.register("colored_egg_light_blue_checkered_red",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_BLUE_CHECKERED_BLACK =
            ITEMS.register("colored_egg_light_blue_checkered_black",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_BLUE, DyeColor.BLACK));

    // yellow colored egg checkered variants
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CHECKERED_WHITE =
            ITEMS.register("colored_egg_yellow_checkered_white",
                    ()-> checkeredStampedEgg(DyeColor.YELLOW, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CHECKERED_ORANGE =
            ITEMS.register("colored_egg_yellow_checkered_orange",
                    ()-> checkeredStampedEgg(DyeColor.YELLOW, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CHECKERED_MAGENTA =
            ITEMS.register("colored_egg_yellow_checkered_magenta",
                    ()-> checkeredStampedEgg(DyeColor.YELLOW, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CHECKERED_LIGHT_BLUE =
            ITEMS.register("colored_egg_yellow_checkered_light_blue",
                    ()-> checkeredStampedEgg(DyeColor.YELLOW, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CHECKERED_YELLOW =
            ITEMS.register("colored_egg_yellow_checkered_yellow",
                    ()-> checkeredStampedEgg(DyeColor.YELLOW, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CHECKERED_LIME =
            ITEMS.register("colored_egg_yellow_checkered_lime",
                    ()-> checkeredStampedEgg(DyeColor.YELLOW, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CHECKERED_PINK =
            ITEMS.register("colored_egg_yellow_checkered_pink",
                    ()-> checkeredStampedEgg(DyeColor.YELLOW, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CHECKERED_GRAY =
            ITEMS.register("colored_egg_yellow_checkered_gray",
                    ()-> checkeredStampedEgg(DyeColor.YELLOW, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CHECKERED_LIGHT_GRAY =
            ITEMS.register("colored_egg_yellow_checkered_light_gray",
                    ()-> checkeredStampedEgg(DyeColor.YELLOW, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CHECKERED_CYAN =
            ITEMS.register("colored_egg_yellow_checkered_cyan",
                    ()-> checkeredStampedEgg(DyeColor.YELLOW, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CHECKERED_PURPLE =
            ITEMS.register("colored_egg_yellow_checkered_purple",
                    ()-> checkeredStampedEgg(DyeColor.YELLOW, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CHECKERED_BLUE =
            ITEMS.register("colored_egg_yellow_checkered_blue",
                    ()-> checkeredStampedEgg(DyeColor.YELLOW, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CHECKERED_BROWN =
            ITEMS.register("colored_egg_yellow_checkered_brown",
                    ()-> checkeredStampedEgg(DyeColor.YELLOW, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CHECKERED_GREEN =
            ITEMS.register("colored_egg_yellow_checkered_green",
                    ()-> checkeredStampedEgg(DyeColor.YELLOW, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CHECKERED_RED =
            ITEMS.register("colored_egg_yellow_checkered_red",
                    ()-> checkeredStampedEgg(DyeColor.YELLOW, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_YELLOW_CHECKERED_BLACK =
            ITEMS.register("colored_egg_yellow_checkered_black",
                    ()-> checkeredStampedEgg(DyeColor.YELLOW, DyeColor.BLACK));

    // lime colored egg checkered variants
    public static final RegistryObject<Item> COLORED_EGG_LIME_CHECKERED_WHITE =
            ITEMS.register("colored_egg_lime_checkered_white",
                    ()-> checkeredStampedEgg(DyeColor.LIME, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CHECKERED_ORANGE =
            ITEMS.register("colored_egg_lime_checkered_orange",
                    ()-> checkeredStampedEgg(DyeColor.LIME, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CHECKERED_MAGENTA =
            ITEMS.register("colored_egg_lime_checkered_magenta",
                    ()-> checkeredStampedEgg(DyeColor.LIME, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CHECKERED_LIGHT_BLUE =
            ITEMS.register("colored_egg_lime_checkered_light_blue",
                    ()-> checkeredStampedEgg(DyeColor.LIME, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CHECKERED_YELLOW =
            ITEMS.register("colored_egg_lime_checkered_yellow",
                    ()-> checkeredStampedEgg(DyeColor.LIME, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CHECKERED_LIME =
            ITEMS.register("colored_egg_lime_checkered_lime",
                    ()-> checkeredStampedEgg(DyeColor.LIME, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CHECKERED_PINK =
            ITEMS.register("colored_egg_lime_checkered_pink",
                    ()-> checkeredStampedEgg(DyeColor.LIME, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CHECKERED_GRAY =
            ITEMS.register("colored_egg_lime_checkered_gray",
                    ()-> checkeredStampedEgg(DyeColor.LIME, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CHECKERED_LIGHT_GRAY =
            ITEMS.register("colored_egg_lime_checkered_light_gray",
                    ()-> checkeredStampedEgg(DyeColor.LIME, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CHECKERED_CYAN =
            ITEMS.register("colored_egg_lime_checkered_cyan",
                    ()-> checkeredStampedEgg(DyeColor.LIME, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CHECKERED_PURPLE =
            ITEMS.register("colored_egg_lime_checkered_purple",
                    ()-> checkeredStampedEgg(DyeColor.LIME, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CHECKERED_BLUE =
            ITEMS.register("colored_egg_lime_checkered_blue",
                    ()-> checkeredStampedEgg(DyeColor.LIME, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CHECKERED_BROWN =
            ITEMS.register("colored_egg_lime_checkered_brown",
                    ()-> checkeredStampedEgg(DyeColor.LIME, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CHECKERED_GREEN =
            ITEMS.register("colored_egg_lime_checkered_green",
                    ()-> checkeredStampedEgg(DyeColor.LIME, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CHECKERED_RED =
            ITEMS.register("colored_egg_lime_checkered_red",
                    ()-> checkeredStampedEgg(DyeColor.LIME, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_LIME_CHECKERED_BLACK =
            ITEMS.register("colored_egg_lime_checkered_black",
                    ()-> checkeredStampedEgg(DyeColor.LIME, DyeColor.BLACK));

    // pink colored egg checkered variants
    public static final RegistryObject<Item> COLORED_EGG_PINK_CHECKERED_WHITE =
            ITEMS.register("colored_egg_pink_checkered_white",
                    ()-> checkeredStampedEgg(DyeColor.PINK, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CHECKERED_ORANGE =
            ITEMS.register("colored_egg_pink_checkered_orange",
                    ()-> checkeredStampedEgg(DyeColor.PINK, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CHECKERED_MAGENTA =
            ITEMS.register("colored_egg_pink_checkered_magenta",
                    ()-> checkeredStampedEgg(DyeColor.PINK, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CHECKERED_LIGHT_BLUE =
            ITEMS.register("colored_egg_pink_checkered_light_blue",
                    ()-> checkeredStampedEgg(DyeColor.PINK, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CHECKERED_YELLOW =
            ITEMS.register("colored_egg_pink_checkered_yellow",
                    ()-> checkeredStampedEgg(DyeColor.PINK, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CHECKERED_LIME =
            ITEMS.register("colored_egg_pink_checkered_lime",
                    ()-> checkeredStampedEgg(DyeColor.PINK, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CHECKERED_PINK =
            ITEMS.register("colored_egg_pink_checkered_pink",
                    ()-> checkeredStampedEgg(DyeColor.PINK, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CHECKERED_GRAY =
            ITEMS.register("colored_egg_pink_checkered_gray",
                    ()-> checkeredStampedEgg(DyeColor.PINK, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CHECKERED_LIGHT_GRAY =
            ITEMS.register("colored_egg_pink_checkered_light_gray",
                    ()-> checkeredStampedEgg(DyeColor.PINK, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CHECKERED_CYAN =
            ITEMS.register("colored_egg_pink_checkered_cyan",
                    ()-> checkeredStampedEgg(DyeColor.PINK, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CHECKERED_PURPLE =
            ITEMS.register("colored_egg_pink_checkered_purple",
                    ()-> checkeredStampedEgg(DyeColor.PINK, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CHECKERED_BLUE =
            ITEMS.register("colored_egg_pink_checkered_blue",
                    ()-> checkeredStampedEgg(DyeColor.PINK, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CHECKERED_BROWN =
            ITEMS.register("colored_egg_pink_checkered_brown",
                    ()-> checkeredStampedEgg(DyeColor.PINK, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CHECKERED_GREEN =
            ITEMS.register("colored_egg_pink_checkered_green",
                    ()-> checkeredStampedEgg(DyeColor.PINK, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CHECKERED_RED =
            ITEMS.register("colored_egg_pink_checkered_red",
                    ()-> checkeredStampedEgg(DyeColor.PINK, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_PINK_CHECKERED_BLACK =
            ITEMS.register("colored_egg_pink_checkered_black",
                    ()-> checkeredStampedEgg(DyeColor.PINK, DyeColor.BLACK));

    // gray colored egg checkered variants
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CHECKERED_WHITE =
            ITEMS.register("colored_egg_gray_checkered_white",
                    ()-> checkeredStampedEgg(DyeColor.GRAY, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CHECKERED_ORANGE =
            ITEMS.register("colored_egg_gray_checkered_orange",
                    ()-> checkeredStampedEgg(DyeColor.GRAY, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CHECKERED_MAGENTA =
            ITEMS.register("colored_egg_gray_checkered_magenta",
                    ()-> checkeredStampedEgg(DyeColor.GRAY, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CHECKERED_LIGHT_BLUE =
            ITEMS.register("colored_egg_gray_checkered_light_blue",
                    ()-> checkeredStampedEgg(DyeColor.GRAY, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CHECKERED_YELLOW =
            ITEMS.register("colored_egg_gray_checkered_yellow",
                    ()-> checkeredStampedEgg(DyeColor.GRAY, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CHECKERED_LIME =
            ITEMS.register("colored_egg_gray_checkered_lime",
                    ()-> checkeredStampedEgg(DyeColor.GRAY, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CHECKERED_PINK =
            ITEMS.register("colored_egg_gray_checkered_pink",
                    ()-> checkeredStampedEgg(DyeColor.GRAY, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CHECKERED_GRAY =
            ITEMS.register("colored_egg_gray_checkered_gray",
                    ()-> checkeredStampedEgg(DyeColor.GRAY, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CHECKERED_LIGHT_GRAY =
            ITEMS.register("colored_egg_gray_checkered_light_gray",
                    ()-> checkeredStampedEgg(DyeColor.GRAY, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CHECKERED_CYAN =
            ITEMS.register("colored_egg_gray_checkered_cyan",
                    ()-> checkeredStampedEgg(DyeColor.GRAY, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CHECKERED_PURPLE =
            ITEMS.register("colored_egg_gray_checkered_purple",
                    ()-> checkeredStampedEgg(DyeColor.GRAY, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CHECKERED_BLUE =
            ITEMS.register("colored_egg_gray_checkered_blue",
                    ()-> checkeredStampedEgg(DyeColor.GRAY, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CHECKERED_BROWN =
            ITEMS.register("colored_egg_gray_checkered_brown",
                    ()-> checkeredStampedEgg(DyeColor.GRAY, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CHECKERED_GREEN =
            ITEMS.register("colored_egg_gray_checkered_green",
                    ()-> checkeredStampedEgg(DyeColor.GRAY, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CHECKERED_RED =
            ITEMS.register("colored_egg_gray_checkered_red",
                    ()-> checkeredStampedEgg(DyeColor.GRAY, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_GRAY_CHECKERED_BLACK =
            ITEMS.register("colored_egg_gray_checkered_black",
                    ()-> checkeredStampedEgg(DyeColor.GRAY, DyeColor.BLACK));

    // light gray colored egg checkered variants
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CHECKERED_WHITE =
            ITEMS.register("colored_egg_light_gray_checkered_white",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CHECKERED_ORANGE =
            ITEMS.register("colored_egg_light_gray_checkered_orange",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CHECKERED_MAGENTA =
            ITEMS.register("colored_egg_light_gray_checkered_magenta",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CHECKERED_LIGHT_BLUE =
            ITEMS.register("colored_egg_light_gray_checkered_light_blue",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CHECKERED_YELLOW =
            ITEMS.register("colored_egg_light_gray_checkered_yellow",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CHECKERED_LIME =
            ITEMS.register("colored_egg_light_gray_checkered_lime",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CHECKERED_PINK =
            ITEMS.register("colored_egg_light_gray_checkered_pink",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CHECKERED_GRAY =
            ITEMS.register("colored_egg_light_gray_checkered_gray",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CHECKERED_LIGHT_GRAY =
            ITEMS.register("colored_egg_light_gray_checkered_light_gray",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CHECKERED_CYAN =
            ITEMS.register("colored_egg_light_gray_checkered_cyan",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CHECKERED_PURPLE =
            ITEMS.register("colored_egg_light_gray_checkered_purple",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CHECKERED_BLUE =
            ITEMS.register("colored_egg_light_gray_checkered_blue",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CHECKERED_BROWN =
            ITEMS.register("colored_egg_light_gray_checkered_brown",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CHECKERED_GREEN =
            ITEMS.register("colored_egg_light_gray_checkered_green",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CHECKERED_RED =
            ITEMS.register("colored_egg_light_gray_checkered_red",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_LIGHT_GRAY_CHECKERED_BLACK =
            ITEMS.register("colored_egg_light_gray_checkered_black",
                    ()-> checkeredStampedEgg(DyeColor.LIGHT_GRAY, DyeColor.BLACK));

    // cyan colored egg checkered variants
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CHECKERED_WHITE =
            ITEMS.register("colored_egg_cyan_checkered_white",
                    ()-> checkeredStampedEgg(DyeColor.CYAN, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CHECKERED_ORANGE =
            ITEMS.register("colored_egg_cyan_checkered_orange",
                    ()-> checkeredStampedEgg(DyeColor.CYAN, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CHECKERED_MAGENTA =
            ITEMS.register("colored_egg_cyan_checkered_magenta",
                    ()-> checkeredStampedEgg(DyeColor.CYAN, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CHECKERED_LIGHT_BLUE =
            ITEMS.register("colored_egg_cyan_checkered_light_blue",
                    ()-> checkeredStampedEgg(DyeColor.CYAN, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CHECKERED_YELLOW =
            ITEMS.register("colored_egg_cyan_checkered_yellow",
                    ()-> checkeredStampedEgg(DyeColor.CYAN, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CHECKERED_LIME =
            ITEMS.register("colored_egg_cyan_checkered_lime",
                    ()-> checkeredStampedEgg(DyeColor.CYAN, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CHECKERED_PINK =
            ITEMS.register("colored_egg_cyan_checkered_pink",
                    ()-> checkeredStampedEgg(DyeColor.CYAN, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CHECKERED_GRAY =
            ITEMS.register("colored_egg_cyan_checkered_gray",
                    ()-> checkeredStampedEgg(DyeColor.CYAN, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CHECKERED_LIGHT_GRAY =
            ITEMS.register("colored_egg_cyan_checkered_light_gray",
                    ()-> checkeredStampedEgg(DyeColor.CYAN, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CHECKERED_CYAN =
            ITEMS.register("colored_egg_cyan_checkered_cyan",
                    ()-> checkeredStampedEgg(DyeColor.CYAN, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CHECKERED_PURPLE =
            ITEMS.register("colored_egg_cyan_checkered_purple",
                    ()-> checkeredStampedEgg(DyeColor.CYAN, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CHECKERED_BLUE =
            ITEMS.register("colored_egg_cyan_checkered_blue",
                    ()-> checkeredStampedEgg(DyeColor.CYAN, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CHECKERED_BROWN =
            ITEMS.register("colored_egg_cyan_checkered_brown",
                    ()-> checkeredStampedEgg(DyeColor.CYAN, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CHECKERED_GREEN =
            ITEMS.register("colored_egg_cyan_checkered_green",
                    ()-> checkeredStampedEgg(DyeColor.CYAN, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CHECKERED_RED =
            ITEMS.register("colored_egg_cyan_checkered_red",
                    ()-> checkeredStampedEgg(DyeColor.CYAN, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_CYAN_CHECKERED_BLACK =
            ITEMS.register("colored_egg_cyan_checkered_black",
                    ()-> checkeredStampedEgg(DyeColor.CYAN, DyeColor.BLACK));

    // purple colored egg checkered variants
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CHECKERED_WHITE =
            ITEMS.register("colored_egg_purple_checkered_white",
                    ()-> checkeredStampedEgg(DyeColor.PURPLE, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CHECKERED_ORANGE =
            ITEMS.register("colored_egg_purple_checkered_orange",
                    ()-> checkeredStampedEgg(DyeColor.PURPLE, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CHECKERED_MAGENTA =
            ITEMS.register("colored_egg_purple_checkered_magenta",
                    ()-> checkeredStampedEgg(DyeColor.PURPLE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CHECKERED_LIGHT_BLUE =
            ITEMS.register("colored_egg_purple_checkered_light_blue",
                    ()-> checkeredStampedEgg(DyeColor.PURPLE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CHECKERED_YELLOW =
            ITEMS.register("colored_egg_purple_checkered_yellow",
                    ()-> checkeredStampedEgg(DyeColor.PURPLE, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CHECKERED_LIME =
            ITEMS.register("colored_egg_purple_checkered_lime",
                    ()-> checkeredStampedEgg(DyeColor.PURPLE, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CHECKERED_PINK =
            ITEMS.register("colored_egg_purple_checkered_pink",
                    ()-> checkeredStampedEgg(DyeColor.PURPLE, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CHECKERED_GRAY =
            ITEMS.register("colored_egg_purple_checkered_gray",
                    ()-> checkeredStampedEgg(DyeColor.PURPLE, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CHECKERED_LIGHT_GRAY =
            ITEMS.register("colored_egg_purple_checkered_light_gray",
                    ()-> checkeredStampedEgg(DyeColor.PURPLE, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CHECKERED_CYAN =
            ITEMS.register("colored_egg_purple_checkered_cyan",
                    ()-> checkeredStampedEgg(DyeColor.PURPLE, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CHECKERED_PURPLE =
            ITEMS.register("colored_egg_purple_checkered_purple",
                    ()-> checkeredStampedEgg(DyeColor.PURPLE, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CHECKERED_BLUE =
            ITEMS.register("colored_egg_purple_checkered_blue",
                    ()-> checkeredStampedEgg(DyeColor.PURPLE, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CHECKERED_BROWN =
            ITEMS.register("colored_egg_purple_checkered_brown",
                    ()-> checkeredStampedEgg(DyeColor.PURPLE, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CHECKERED_GREEN =
            ITEMS.register("colored_egg_purple_checkered_green",
                    ()-> checkeredStampedEgg(DyeColor.PURPLE, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CHECKERED_RED =
            ITEMS.register("colored_egg_purple_checkered_red",
                    ()-> checkeredStampedEgg(DyeColor.PURPLE, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_PURPLE_CHECKERED_BLACK =
            ITEMS.register("colored_egg_purple_checkered_black",
                    ()-> checkeredStampedEgg(DyeColor.PURPLE, DyeColor.BLACK));

    // blue colored egg checkered variants
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CHECKERED_WHITE =
            ITEMS.register("colored_egg_blue_checkered_white",
                    ()-> checkeredStampedEgg(DyeColor.BLUE, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CHECKERED_ORANGE =
            ITEMS.register("colored_egg_blue_checkered_orange",
                    ()-> checkeredStampedEgg(DyeColor.BLUE, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CHECKERED_MAGENTA =
            ITEMS.register("colored_egg_blue_checkered_magenta",
                    ()-> checkeredStampedEgg(DyeColor.BLUE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CHECKERED_LIGHT_BLUE =
            ITEMS.register("colored_egg_blue_checkered_light_blue",
                    ()-> checkeredStampedEgg(DyeColor.BLUE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CHECKERED_YELLOW =
            ITEMS.register("colored_egg_blue_checkered_yellow",
                    ()-> checkeredStampedEgg(DyeColor.BLUE, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CHECKERED_LIME =
            ITEMS.register("colored_egg_blue_checkered_lime",
                    ()-> checkeredStampedEgg(DyeColor.BLUE, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CHECKERED_PINK =
            ITEMS.register("colored_egg_blue_checkered_pink",
                    ()-> checkeredStampedEgg(DyeColor.BLUE, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CHECKERED_GRAY =
            ITEMS.register("colored_egg_blue_checkered_gray",
                    ()-> checkeredStampedEgg(DyeColor.BLUE, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CHECKERED_LIGHT_GRAY =
            ITEMS.register("colored_egg_blue_checkered_light_gray",
                    ()-> checkeredStampedEgg(DyeColor.BLUE, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CHECKERED_CYAN =
            ITEMS.register("colored_egg_blue_checkered_cyan",
                    ()-> checkeredStampedEgg(DyeColor.BLUE, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CHECKERED_PURPLE =
            ITEMS.register("colored_egg_blue_checkered_purple",
                    ()-> checkeredStampedEgg(DyeColor.BLUE, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CHECKERED_BLUE =
            ITEMS.register("colored_egg_blue_checkered_blue",
                    ()-> checkeredStampedEgg(DyeColor.BLUE, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CHECKERED_BROWN =
            ITEMS.register("colored_egg_blue_checkered_brown",
                    ()-> checkeredStampedEgg(DyeColor.BLUE, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CHECKERED_GREEN =
            ITEMS.register("colored_egg_blue_checkered_green",
                    ()-> checkeredStampedEgg(DyeColor.BLUE, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CHECKERED_RED =
            ITEMS.register("colored_egg_blue_checkered_red",
                    ()-> checkeredStampedEgg(DyeColor.BLUE, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_BLUE_CHECKERED_BLACK =
            ITEMS.register("colored_egg_blue_checkered_black",
                    ()-> checkeredStampedEgg(DyeColor.BLUE, DyeColor.BLACK));

    // brown colored egg checkered variants
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CHECKERED_WHITE =
            ITEMS.register("colored_egg_brown_checkered_white",
                    ()-> checkeredStampedEgg(DyeColor.BROWN, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CHECKERED_ORANGE =
            ITEMS.register("colored_egg_brown_checkered_orange",
                    ()-> checkeredStampedEgg(DyeColor.BROWN, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CHECKERED_MAGENTA =
            ITEMS.register("colored_egg_brown_checkered_magenta",
                    ()-> checkeredStampedEgg(DyeColor.BROWN, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CHECKERED_LIGHT_BLUE =
            ITEMS.register("colored_egg_brown_checkered_light_blue",
                    ()-> checkeredStampedEgg(DyeColor.BROWN, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CHECKERED_YELLOW =
            ITEMS.register("colored_egg_brown_checkered_yellow",
                    ()-> checkeredStampedEgg(DyeColor.BROWN, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CHECKERED_LIME =
            ITEMS.register("colored_egg_brown_checkered_lime",
                    ()-> checkeredStampedEgg(DyeColor.BROWN, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CHECKERED_PINK =
            ITEMS.register("colored_egg_brown_checkered_pink",
                    ()-> checkeredStampedEgg(DyeColor.BROWN, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CHECKERED_GRAY =
            ITEMS.register("colored_egg_brown_checkered_gray",
                    ()-> checkeredStampedEgg(DyeColor.BROWN, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CHECKERED_LIGHT_GRAY =
            ITEMS.register("colored_egg_brown_checkered_light_gray",
                    ()-> checkeredStampedEgg(DyeColor.BROWN, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CHECKERED_CYAN =
            ITEMS.register("colored_egg_brown_checkered_cyan",
                    ()-> checkeredStampedEgg(DyeColor.BROWN, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CHECKERED_PURPLE =
            ITEMS.register("colored_egg_brown_checkered_purple",
                    ()-> checkeredStampedEgg(DyeColor.BROWN, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CHECKERED_BLUE =
            ITEMS.register("colored_egg_brown_checkered_blue",
                    ()-> checkeredStampedEgg(DyeColor.BROWN, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CHECKERED_BROWN =
            ITEMS.register("colored_egg_brown_checkered_brown",
                    ()-> checkeredStampedEgg(DyeColor.BROWN, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CHECKERED_GREEN =
            ITEMS.register("colored_egg_brown_checkered_green",
                    ()-> checkeredStampedEgg(DyeColor.BROWN, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CHECKERED_RED =
            ITEMS.register("colored_egg_brown_checkered_red",
                    ()-> checkeredStampedEgg(DyeColor.BROWN, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_BROWN_CHECKERED_BLACK =
            ITEMS.register("colored_egg_brown_checkered_black",
                    ()-> checkeredStampedEgg(DyeColor.BROWN, DyeColor.BLACK));

    // green colored egg checkered variants
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CHECKERED_WHITE =
            ITEMS.register("colored_egg_green_checkered_white",
                    ()-> checkeredStampedEgg(DyeColor.GREEN, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CHECKERED_ORANGE =
            ITEMS.register("colored_egg_green_checkered_orange",
                    ()-> checkeredStampedEgg(DyeColor.GREEN, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CHECKERED_MAGENTA =
            ITEMS.register("colored_egg_green_checkered_magenta",
                    ()-> checkeredStampedEgg(DyeColor.GREEN, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CHECKERED_LIGHT_BLUE =
            ITEMS.register("colored_egg_green_checkered_light_blue",
                    ()-> checkeredStampedEgg(DyeColor.GREEN, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CHECKERED_YELLOW =
            ITEMS.register("colored_egg_green_checkered_yellow",
                    ()-> checkeredStampedEgg(DyeColor.GREEN, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CHECKERED_LIME =
            ITEMS.register("colored_egg_green_checkered_lime",
                    ()-> checkeredStampedEgg(DyeColor.GREEN, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CHECKERED_PINK =
            ITEMS.register("colored_egg_green_checkered_pink",
                    ()-> checkeredStampedEgg(DyeColor.GREEN, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CHECKERED_GRAY =
            ITEMS.register("colored_egg_green_checkered_gray",
                    ()-> checkeredStampedEgg(DyeColor.GREEN, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CHECKERED_LIGHT_GRAY =
            ITEMS.register("colored_egg_green_checkered_light_gray",
                    ()-> checkeredStampedEgg(DyeColor.GREEN, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CHECKERED_CYAN =
            ITEMS.register("colored_egg_green_checkered_cyan",
                    ()-> checkeredStampedEgg(DyeColor.GREEN, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CHECKERED_PURPLE =
            ITEMS.register("colored_egg_green_checkered_purple",
                    ()-> checkeredStampedEgg(DyeColor.GREEN, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CHECKERED_BLUE =
            ITEMS.register("colored_egg_green_checkered_blue",
                    ()-> checkeredStampedEgg(DyeColor.GREEN, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CHECKERED_BROWN =
            ITEMS.register("colored_egg_green_checkered_brown",
                    ()-> checkeredStampedEgg(DyeColor.GREEN, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CHECKERED_GREEN =
            ITEMS.register("colored_egg_green_checkered_green",
                    ()-> checkeredStampedEgg(DyeColor.GREEN, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CHECKERED_RED =
            ITEMS.register("colored_egg_green_checkered_red",
                    ()-> checkeredStampedEgg(DyeColor.GREEN, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_GREEN_CHECKERED_BLACK =
            ITEMS.register("colored_egg_green_checkered_black",
                    ()-> checkeredStampedEgg(DyeColor.GREEN, DyeColor.BLACK));

    // red colored egg checkered variants
    public static final RegistryObject<Item> COLORED_EGG_RED_CHECKERED_WHITE =
            ITEMS.register("colored_egg_red_checkered_white",
                    ()-> checkeredStampedEgg(DyeColor.RED, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_RED_CHECKERED_ORANGE =
            ITEMS.register("colored_egg_red_checkered_orange",
                    ()-> checkeredStampedEgg(DyeColor.RED, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_RED_CHECKERED_MAGENTA =
            ITEMS.register("colored_egg_red_checkered_magenta",
                    ()-> checkeredStampedEgg(DyeColor.RED, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_RED_CHECKERED_LIGHT_BLUE =
            ITEMS.register("colored_egg_red_checkered_light_blue",
                    ()-> checkeredStampedEgg(DyeColor.RED, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_RED_CHECKERED_YELLOW =
            ITEMS.register("colored_egg_red_checkered_yellow",
                    ()-> checkeredStampedEgg(DyeColor.RED, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_RED_CHECKERED_LIME =
            ITEMS.register("colored_egg_red_checkered_lime",
                    ()-> checkeredStampedEgg(DyeColor.RED, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_RED_CHECKERED_PINK =
            ITEMS.register("colored_egg_red_checkered_pink",
                    ()-> checkeredStampedEgg(DyeColor.RED, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_RED_CHECKERED_GRAY =
            ITEMS.register("colored_egg_red_checkered_gray",
                    ()-> checkeredStampedEgg(DyeColor.RED, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_RED_CHECKERED_LIGHT_GRAY =
            ITEMS.register("colored_egg_red_checkered_light_gray",
                    ()-> checkeredStampedEgg(DyeColor.RED, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_RED_CHECKERED_CYAN =
            ITEMS.register("colored_egg_red_checkered_cyan",
                    ()-> checkeredStampedEgg(DyeColor.RED, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_RED_CHECKERED_PURPLE =
            ITEMS.register("colored_egg_red_checkered_purple",
                    ()-> checkeredStampedEgg(DyeColor.RED, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_RED_CHECKERED_BLUE =
            ITEMS.register("colored_egg_red_checkered_blue",
                    ()-> checkeredStampedEgg(DyeColor.RED, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_RED_CHECKERED_BROWN =
            ITEMS.register("colored_egg_red_checkered_brown",
                    ()-> checkeredStampedEgg(DyeColor.RED, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_RED_CHECKERED_GREEN =
            ITEMS.register("colored_egg_red_checkered_green",
                    ()-> checkeredStampedEgg(DyeColor.RED, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_RED_CHECKERED_RED =
            ITEMS.register("colored_egg_red_checkered_red",
                    ()-> checkeredStampedEgg(DyeColor.RED, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_RED_CHECKERED_BLACK =
            ITEMS.register("colored_egg_red_checkered_black",
                    ()-> checkeredStampedEgg(DyeColor.RED, DyeColor.BLACK));

    // black colored egg checkered variants
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CHECKERED_WHITE =
            ITEMS.register("colored_egg_black_checkered_white",
                    ()-> checkeredStampedEgg(DyeColor.BLACK, DyeColor.WHITE));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CHECKERED_ORANGE =
            ITEMS.register("colored_egg_black_checkered_orange",
                    ()-> checkeredStampedEgg(DyeColor.BLACK, DyeColor.ORANGE));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CHECKERED_MAGENTA =
            ITEMS.register("colored_egg_black_checkered_magenta",
                    ()-> checkeredStampedEgg(DyeColor.BLACK, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CHECKERED_LIGHT_BLUE =
            ITEMS.register("colored_egg_black_checkered_light_blue",
                    ()-> checkeredStampedEgg(DyeColor.BLACK, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CHECKERED_YELLOW =
            ITEMS.register("colored_egg_black_checkered_yellow",
                    ()-> checkeredStampedEgg(DyeColor.BLACK, DyeColor.YELLOW));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CHECKERED_LIME =
            ITEMS.register("colored_egg_black_checkered_lime",
                    ()-> checkeredStampedEgg(DyeColor.BLACK, DyeColor.LIME));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CHECKERED_PINK =
            ITEMS.register("colored_egg_black_checkered_pink",
                    ()-> checkeredStampedEgg(DyeColor.BLACK, DyeColor.PINK));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CHECKERED_GRAY =
            ITEMS.register("colored_egg_black_checkered_gray",
                    ()-> checkeredStampedEgg(DyeColor.BLACK, DyeColor.GRAY));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CHECKERED_LIGHT_GRAY =
            ITEMS.register("colored_egg_black_checkered_light_gray",
                    ()-> checkeredStampedEgg(DyeColor.BLACK, DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CHECKERED_CYAN =
            ITEMS.register("colored_egg_black_checkered_cyan",
                    ()-> checkeredStampedEgg(DyeColor.BLACK, DyeColor.CYAN));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CHECKERED_PURPLE =
            ITEMS.register("colored_egg_black_checkered_purple",
                    ()-> checkeredStampedEgg(DyeColor.BLACK, DyeColor.PURPLE));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CHECKERED_BLUE =
            ITEMS.register("colored_egg_black_checkered_blue",
                    ()-> checkeredStampedEgg(DyeColor.BLACK, DyeColor.BLUE));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CHECKERED_BROWN =
            ITEMS.register("colored_egg_black_checkered_brown",
                    ()-> checkeredStampedEgg(DyeColor.BLACK, DyeColor.BROWN));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CHECKERED_GREEN =
            ITEMS.register("colored_egg_black_checkered_green",
                    ()-> checkeredStampedEgg(DyeColor.BLACK, DyeColor.GREEN));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CHECKERED_RED =
            ITEMS.register("colored_egg_black_checkered_red",
                    ()-> checkeredStampedEgg(DyeColor.BLACK, DyeColor.RED));
    public static final RegistryObject<Item> COLORED_EGG_BLACK_CHECKERED_BLACK =
            ITEMS.register("colored_egg_black_checkered_black",
                    ()-> checkeredStampedEgg(DyeColor.BLACK, DyeColor.BLACK));

    @Contract("_ -> new")
    private static @NotNull EasterEggItem blankEgg(DyeColor color) {
        return new EasterEggItem(color, null,
                EasterEggProperties.Layer.BLANK,
                new Item.Properties().food(TBAFoods.EASTER_EGGS)
                        .stacksTo(64)
                        .tab(TBATab.TAB));
    }
    private static @NotNull EasterEggItem checkeredStampedEgg(DyeColor eggColor, DyeColor stampColor) {
        return new EasterEggItem(eggColor, stampColor,
                EasterEggProperties.Layer.CHECKERED,
                new Item.Properties().food(TBAFoods.EASTER_EGGS)
                        .stacksTo(64)
                        .tab(TBATab.TAB));
    }
    private static @NotNull EasterEggItem creeperStampedEgg(DyeColor eggColor, DyeColor stampColor) {
        return new EasterEggItem(eggColor, stampColor,
                EasterEggProperties.Layer.CREEPER,
                new Item.Properties().food(TBAFoods.EASTER_EGGS)
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

    public static Item.@NotNull Properties basicItem() {
        return (new Item.Properties()).tab(TBATab.TAB);
    }

    public static void register(final IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}