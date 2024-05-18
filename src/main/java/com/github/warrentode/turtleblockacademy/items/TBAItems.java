package com.github.warrentode.turtleblockacademy.items;

import com.github.warrentode.turtleblockacademy.entity.TBAEntityTypes;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;
import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.TAB;
import static vectorwing.farmersdelight.common.registry.ModItems.bowlFoodItem;
import static vectorwing.farmersdelight.common.registry.ModItems.drinkItem;

public class TBAItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> STUDENT_CARD =
            ITEMS.register("student_card",
            () -> new StudentCard(new Item.Properties()
                    .stacksTo(1).tab(TAB)));

    public static final RegistryObject<ForgeSpawnEggItem> TREASURE_BEETLE_SPAWN_EGG =
            ITEMS.register("treasure_beetle_spawn_egg",
            () -> new ForgeSpawnEggItem(TBAEntityTypes.TREASURE_BEETLE,
                    0x006400, 0xB8860B,
                    new Item.Properties().tab(TAB)));

    public static final RegistryObject<ForgeSpawnEggItem> HEROBRINE_SPAWN_EGG =
            ITEMS.register("herobrine_spawn_egg",
                    () -> new ForgeSpawnEggItem(TBAEntityTypes.HEROBRINE,
                            0x0000FF, 0x1E90FF,
                            new Item.Properties().tab(TAB)));

    public static final RegistryObject<Item> BEET_WINE =
            ITEMS.register("beet_wine", () ->
                    new DrinkableItem(drinkItem().food(TBAFoods.BEET_WINE)
                            .tab(TAB), true, false));

    public static final RegistryObject<Item> VINEGAR_BOTTLE =
            ITEMS.register("vinegar_bottle", () ->
                    new DrinkableItem(drinkItem().food(TBAFoods.VINEGAR_BOTTLE)
                            .tab(TAB), true, false));

    public static final RegistryObject<Item> BEET_RISOTTO =
            ITEMS.register("beet_risotto", () ->
                    new ConsumableItem(bowlFoodItem(TBAFoods.RICE_DISHES)
                            .tab(TAB), true));

    public static final RegistryObject<Item> BEET_SALAD =
            ITEMS.register("beet_salad", () ->
                    new ConsumableItem(bowlFoodItem(TBAFoods.SALAD_DISHES)
                            .tab(TAB), true));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}