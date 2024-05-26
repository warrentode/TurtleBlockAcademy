package com.github.warrentode.turtleblockacademy.items.dyeable;

import net.minecraft.world.item.Item;

public class DyeableItem extends Item implements IDyeableItem {
    String TAG_COLOR = "color";
    String TAG_DISPLAY = "display";
    int DEFAULT_ITEM_COLOR = 16383998;

    public DyeableItem(Item.Properties properties) {
        super(properties);
    }
}