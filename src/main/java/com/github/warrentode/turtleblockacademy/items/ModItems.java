package com.github.warrentode.turtleblockacademy.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
