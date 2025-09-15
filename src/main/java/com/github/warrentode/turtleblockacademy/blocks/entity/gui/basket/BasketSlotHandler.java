package com.github.warrentode.turtleblockacademy.blocks.entity.gui.basket;

import com.github.warrentode.turtleblockacademy.util.TBATags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class BasketSlotHandler extends SlotItemHandler {
    private final IItemHandler itemHandler;
    private final int index;
    private final Player player;

    public BasketSlotHandler(IItemHandler itemHandler, Player player, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
        this.itemHandler = itemHandler;
        this.index = index;
        this.player = player;
    }

    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        if (stack.is(TBATags.Items.BASKET_ITEMS) && itemHandler.getStackInSlot(index).isEmpty()) {
            return super.mayPlace(stack);
        }
        else return false;
    }

    @Override
    public boolean mayPickup(@NotNull Player playerIn) {
        return super.mayPickup(playerIn);
    }
}