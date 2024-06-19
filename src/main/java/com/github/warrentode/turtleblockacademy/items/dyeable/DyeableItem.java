package com.github.warrentode.turtleblockacademy.items.dyeable;

import net.minecraft.world.item.Item;

// modified version of the vanilla DyeableArmorItem class
public class DyeableItem extends Item implements IDyeableItem {
    String TAG_COLOR = "color";
    String TAG_DISPLAY = "display";
    int DEFAULT_ITEM_COLOR = 16383998;

    public DyeableItem(Properties properties) {
        super(properties);
    }
}