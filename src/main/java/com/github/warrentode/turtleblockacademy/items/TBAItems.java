package com.github.warrentode.turtleblockacademy.items;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.entity.TBAEntityTypes;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;
import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.TAB;

public class TBAItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> STUDENT_CARD =
            ITEMS.register("student_card",
            () -> new StudentCard(new Item.Properties().stacksTo(1)
                    .tab(TAB)));

    public static final RegistryObject<Item> YEAST =
            ITEMS.register("yeast", () -> new Item(new Item.Properties()
                    .tab(TAB)));

    public static final RegistryObject<Item> CLOVES =
            ITEMS.register("cloves", () -> new Item(new Item.Properties()
                    .tab(TAB)));

    public static final RegistryObject<Item> DRIED_CLOVES =
            ITEMS.register("dried_cloves", () -> new Item(new Item.Properties()
                    .tab(TAB)));

    public static final RegistryObject<Item> GROUND_CLOVES =
            ITEMS.register("ground_cloves", () -> new Item(new Item.Properties()
                    .tab(TAB)));

    public static final RegistryObject<Item> PICKLING_SALT =
            ITEMS.register("pickling_salt", () ->
                    new Item(new Item.Properties().tab(TAB)));

    public static final RegistryObject<Item> WHEAT_FLOUR =
            ITEMS.register("wheat_flour", () ->
                    new Item(new Item.Properties().tab(TAB)));

    public static final RegistryObject<Item> DILL_HERB =
            ITEMS.register("dill_herb", () ->
                    new Item(new Item.Properties().tab(TAB)));


    public static final RegistryObject<ForgeSpawnEggItem> TREASURE_BEETLE_SPAWN_EGG =
            ITEMS.register("treasure_beetle_spawn_egg",
            () -> new ForgeSpawnEggItem(TBAEntityTypes.TREASURE_BEETLE,
                    0x006400, 0xB8860B,
                    new Item.Properties().tab(TAB)));

    public static final RegistryObject<ForgeSpawnEggItem> HEROBRINE_SPAWN_EGG =
            ITEMS.register("herobrine_spawn_egg",
                    () -> new ForgeSpawnEggItem(TBAEntityTypes.HEROBRINE,
                            0x5649cc, 0x00cccc,
                            new Item.Properties().tab(TAB)));


    public static final RegistryObject<Item> CLOVE_SEEDS =
            ITEMS.register("clove_seeds",
                    () -> new ItemNameBlockItem(TBABlocks.CLOVE_BUSH.get(),
                            new Item.Properties().tab(TAB)));

    public static final RegistryObject<Item> CUCUMBER_SEEDS =
            ITEMS.register("cucumber_seeds",
                    () -> new ItemNameBlockItem(TBABlocks.CUCUMBER_BUSH.get(),
                            new Item.Properties().tab(TAB)));

    public static final RegistryObject<Item> DILL_SEEDS =
            ITEMS.register("dill_seeds",
                    () -> new ItemNameBlockItem(TBABlocks.DILL_BUSH.get(),
                            new Item.Properties().tab(TAB)));



    public static final RegistryObject<Item> BEET_PICKLES =
            ITEMS.register("beet_pickles", () ->
                    new PickledItem(bowlFoodItem(TBAFoods.PICKLES),
                            true, true));

    public static final RegistryObject<Item> BEET_RISOTTO =
            ITEMS.register("beet_risotto", () ->
                    new ConsumableItem(bowlFoodItem(TBAFoods.RICE_DISHES)
                            .tab(TAB), false, false));

    public static final RegistryObject<Item> BEET_SALAD =
            ITEMS.register("beet_salad", () ->
                    new ConsumableItem(bowlFoodItem(TBAFoods.SALAD_DISHES),
                            false, false));


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

    public static final RegistryObject<Item> CUCUMBER =
            ITEMS.register("cucumber", () ->
                    new ConsumableItem(foodItem(TBAFoods.CUCUMBER).stacksTo(64),
                            false, false));

    public static final RegistryObject<Item> DILL_PICKLE =
            ITEMS.register("dill_pickle", () ->
                    new PickledItem(foodItem(TBAFoods.PICKLES).stacksTo(64),
                            true, true));


    public static final RegistryObject<Item> COLORED_EGG_BLANK_WHITE =
            ITEMS.register("colored_egg_blank_white", () ->
                    new EasterEggItem(0xFFFFFF, foodItem(TBAFoods.EASTER_EGGS)
                            .stacksTo(64),true, true));
    
    public static final RegistryObject<Item> COLORED_EGG_BLANK_ORANGE =
            ITEMS.register("colored_egg_blank_orange", () ->
                    new EasterEggItem(0xF9801D, foodItem(TBAFoods.EASTER_EGGS)
                            .stacksTo(64),true, true));

    public static final RegistryObject<Item> COLORED_EGG_BLANK_MAGENTA =
            ITEMS.register("colored_egg_blank_magenta", () ->
                    new EasterEggItem(0xC74EBD, foodItem(TBAFoods.EASTER_EGGS)
                            .stacksTo(64),true, true));

    public static final RegistryObject<Item> COLORED_EGG_BLANK_LIGHT_BLUE =
            ITEMS.register("colored_egg_blank_light_blue", () ->
                    new EasterEggItem(0x3AB3DA, foodItem(TBAFoods.EASTER_EGGS)
                            .stacksTo(64),true, true));

    public static final RegistryObject<Item> COLORED_EGG_BLANK_YELLOW =
            ITEMS.register("colored_egg_blank_yellow", () ->
                    new EasterEggItem(0xFED83D, foodItem(TBAFoods.EASTER_EGGS)
                            .stacksTo(64),true, true));

    public static final RegistryObject<Item> COLORED_EGG_BLANK_LIME =
            ITEMS.register("colored_egg_blank_lime", () ->
                    new EasterEggItem(0x80C71F, foodItem(TBAFoods.EASTER_EGGS)
                            .stacksTo(64),true, true));

    public static final RegistryObject<Item> COLORED_EGG_BLANK_PINK =
            ITEMS.register("colored_egg_blank_pink", () ->
                    new EasterEggItem(0xF38BAA, foodItem(TBAFoods.EASTER_EGGS)
                            .stacksTo(64),true, true));

    public static final RegistryObject<Item> COLORED_EGG_BLANK_GRAY =
            ITEMS.register("colored_egg_blank_gray", () ->
                    new EasterEggItem(0x474F52, foodItem(TBAFoods.EASTER_EGGS)
                            .stacksTo(64),true, true));

    public static final RegistryObject<Item> COLORED_EGG_BLANK_LIGHT_GRAY =
            ITEMS.register("colored_egg_blank_light_gray", () ->
                    new EasterEggItem(0x9D9D97, foodItem(TBAFoods.EASTER_EGGS)
                            .stacksTo(64),true, true));

    public static final RegistryObject<Item> COLORED_EGG_BLANK_CYAN =
            ITEMS.register("colored_egg_blank_cyan", () ->
                    new EasterEggItem(0x169C9C, foodItem(TBAFoods.EASTER_EGGS)
                            .stacksTo(64),true, true));

    public static final RegistryObject<Item> COLORED_EGG_BLANK_PURPLE =
            ITEMS.register("colored_egg_blank_purple", () ->
                    new EasterEggItem(0x8932B8, foodItem(TBAFoods.EASTER_EGGS)
                            .stacksTo(64),true, true));

    public static final RegistryObject<Item> COLORED_EGG_BLANK_BLUE =
            ITEMS.register("colored_egg_blank_blue", () ->
                    new EasterEggItem(0x3C44AA, foodItem(TBAFoods.EASTER_EGGS)
                            .stacksTo(64),true, true));

    public static final RegistryObject<Item> COLORED_EGG_BLANK_BROWN =
            ITEMS.register("colored_egg_blank_brown", () ->
                    new EasterEggItem(0x835432, foodItem(TBAFoods.EASTER_EGGS)
                            .stacksTo(64),true, true));

    public static final RegistryObject<Item> COLORED_EGG_BLANK_GREEN =
            ITEMS.register("colored_egg_blank_green", () ->
                    new EasterEggItem(0x5E7C16, foodItem(TBAFoods.EASTER_EGGS)
                            .stacksTo(64),true, true));

    public static final RegistryObject<Item> COLORED_EGG_BLANK_BLACK =
            ITEMS.register("colored_egg_blank_black", () ->
                    new EasterEggItem(0x1D1D21, foodItem(TBAFoods.EASTER_EGGS)
                            .stacksTo(64),true, true));
    
    public static final RegistryObject<Item> COLORED_EGG_BLANK_RED =
            ITEMS.register("colored_egg_blank_red", () ->
                    new EasterEggItem(0xB02E26, foodItem(TBAFoods.EASTER_EGGS)
                            .stacksTo(64),true, true));


    public static @NotNull Item.Properties foodItem(FoodProperties food) {
        return (new Item.Properties()).food(food)
                .tab(TAB)
                .tab(FarmersDelight.CREATIVE_TAB)
                .tab(CreativeModeTab.TAB_FOOD);
    }

    public static @NotNull Item.Properties bowlFoodItem(FoodProperties food) {
        return (new Item.Properties()).food(food)
                .stacksTo(16)
                .craftRemainder(Items.BOWL)
                .tab(TAB)
                .tab(FarmersDelight.CREATIVE_TAB)
                .tab(CreativeModeTab.TAB_FOOD);
    }

    public static @NotNull Item.Properties drinkItem() {
        return (new Item.Properties())
                .stacksTo(16)
                .craftRemainder(Items.GLASS_BOTTLE)
                .tab(TAB)
                .tab(FarmersDelight.CREATIVE_TAB)
                .tab(CreativeModeTab.TAB_FOOD);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}