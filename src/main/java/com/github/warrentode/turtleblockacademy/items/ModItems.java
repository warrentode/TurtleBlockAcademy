package com.github.warrentode.turtleblockacademy.items;

import com.github.warrentode.turtleblockacademy.entity.ModEntityTypes;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;
import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.TAB;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> STUDENT_CARD = ITEMS.register("student_card",
            () -> new StudentCard(new Item.Properties().stacksTo(1).tab(TAB)));

    public static final RegistryObject<Item> PLATE_WHITE = ITEMS.register("plate_white_glazed",
            () -> new PlateItem(ModEntityTypes.PLATE_ENTITY.get(),
                    (new Item.Properties()).tab(TAB)));

    public static final RegistryObject<Item> PLATE_ITEM = ITEMS.register("plate_item",
            () -> new PlateItem(ModEntityTypes.PLATE_ENTITY.get(), (new Item.Properties()).tab(TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
