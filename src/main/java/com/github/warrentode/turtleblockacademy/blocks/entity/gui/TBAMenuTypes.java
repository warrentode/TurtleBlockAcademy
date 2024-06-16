package com.github.warrentode.turtleblockacademy.blocks.entity.gui;
import com.github.warrentode.turtleblockacademy.blocks.entity.gui.basket.BasketMenu;
import com.github.warrentode.turtleblockacademy.blocks.entity.gui.desk.SchoolDeskMenu;
import com.github.warrentode.turtleblockacademy.blocks.entity.gui.fermentingpot.FermentingPotMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TBAMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, MODID);

    public static final RegistryObject<MenuType<SchoolDeskMenu>> SCHOOL_DESK_MENU =
            registerMenuType(SchoolDeskMenu::new, "school_desk_menu");

    public static final RegistryObject<MenuType<FermentingPotMenu>> FERMENTING_POT_MENU =
            registerMenuType(FermentingPotMenu::new, "fermenting_pot_menu");

    public static final RegistryObject<MenuType<BasketMenu>> BASKET_MENU =
            registerSimpleMenuType("basket_menu", new MenuType<>(BasketMenu::new));

    private static RegistryObject<MenuType<BasketMenu>> registerSimpleMenuType(String name, MenuType<BasketMenu> type) {
        return MENUS.register(name, () -> type);
    }

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}