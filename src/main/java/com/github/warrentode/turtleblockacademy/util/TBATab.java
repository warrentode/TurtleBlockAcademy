package com.github.warrentode.turtleblockacademy.util;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class TBATab extends CreativeModeTab {
    public static final TBATab TAB = new TBATab("turtleblockacademy");

    public TBATab(String label) {
        super(label);
    }

    public @NotNull ItemStack makeIcon() {
        return TBABlocks.CERTIFICATE_BLOCK.get().asItem().getDefaultInstance();
    }

    public void fillItemList(@NotNull NonNullList<ItemStack> list) {
        //noinspection deprecation
        for (Item item : Registry.ITEM) {
            item.fillItemCategory(this, list);
        }
    }
}