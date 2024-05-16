package com.github.warrentode.turtleblockacademy.items;

import com.github.warrentode.turtleblockacademy.entity.TBAEntityTypes;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;
import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.TAB;

public class TBAItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> STUDENT_CARD = ITEMS.register("student_card",
            () -> new StudentCard(new Item.Properties().stacksTo(1).tab(TAB)));

    public static final RegistryObject<ForgeSpawnEggItem> TREASURE_BEETLE_SPAWN_EGG =
            ITEMS.register("treasure_beetle_spawn_egg",
            () -> new ForgeSpawnEggItem(TBAEntityTypes.TREASURE_BEETLE,
                    0x006400, 0xB8860B,
                    new Item.Properties().tab(TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}