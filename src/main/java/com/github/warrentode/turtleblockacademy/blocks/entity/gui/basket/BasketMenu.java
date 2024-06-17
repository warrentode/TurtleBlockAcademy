package com.github.warrentode.turtleblockacademy.blocks.entity.gui.basket;

import com.github.warrentode.turtleblockacademy.blocks.entity.BasketBlockEntity;
import com.github.warrentode.turtleblockacademy.blocks.entity.gui.TBAMenuTypes;
import com.github.warrentode.turtleblockacademy.items.BasketBlockItem;
import com.github.warrentode.turtleblockacademy.util.LogUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

public class BasketMenu extends AbstractContainerMenu {
    private static final int CONTAINER_SLOT_COUNT = BasketBlockEntity.INVENTORY_SIZE;
    private final ItemStack basketItem;
    private final ItemStackHandler basketInventory;

    public BasketMenu(int containerId, @NotNull Inventory playerInventory) {
        super(TBAMenuTypes.BASKET_MENU.get(), containerId);
        this.basketItem = getHeldItem(playerInventory.player);
        this.basketInventory = new ItemStackHandler(CONTAINER_SLOT_COUNT);
        if (basketItem.getTag() != null) {
            basketInventory.deserializeNBT(basketItem.getTag().getCompound("BlockEntityTag").getCompound("inventory"));
        }
        LogUtil.info("BasketMenu created with ID: {}", containerId);

        int numEntityRows = 3;
        int numEntityCols = 3;
        int entityStartX = 62;
        int entityStartY = 17;
        int playerStartX = 8;
        int playerInvStartY = 84;
        int hotbarStartY = 142;
        int borderSize = 18;
        int numPlayerInvRows = 3;
        int numPlayerInvCols = 9;

        // Add block entity slots
        for (int rows = 0; rows < numEntityRows; ++rows) {
            for (int cols = 0; cols < numEntityCols; ++cols) {
                this.addSlot(new BasketSlotHandler(this.basketInventory, playerInventory.player,
                        cols + rows * numEntityRows, entityStartX + cols * borderSize,
                        entityStartY + rows * borderSize));
            }
        }

        // add player inventory slots
        for (int rows = 0; rows < numPlayerInvRows; ++rows) {
            for (int cols = 0; cols < numPlayerInvCols; ++cols) {
                this.addSlot(new Slot(playerInventory, cols + rows * numPlayerInvCols + 9, playerStartX + cols * borderSize, playerInvStartY + rows * borderSize));
            }
        }

        // add player hotbar
        for (int cols = 0; cols < numPlayerInvCols; ++cols) {
            this.addSlot(new Slot(playerInventory, cols, playerStartX + cols * borderSize, hotbarStartY));
        }
    }

    private ItemStack getHeldItem(@NotNull Player player) {
        // Determine which held item is a basket (if either)
        if (isBasket(player.getMainHandItem())) {
            return player.getMainHandItem();
        }
        if (isBasket(player.getOffhandItem())) {
            return player.getOffhandItem();
        }
        return ItemStack.EMPTY;
    }

    private static boolean isBasket(@NotNull ItemStack stack) {
        return stack.getItem() instanceof BasketBlockItem;
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return player.getMainHandItem().getItem() instanceof BasketBlockItem || player.getOffhandItem().getItem() instanceof BasketBlockItem;
    }



    // method from dispenser menu
    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < 9) {
                if (!this.moveItemStackTo(itemstack1, 9, 45, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, 9, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }

    @Override
    public void removed(@NotNull Player player) {
        super.removed(player);
        LogUtil.info("BasketMenu removed for player: {}", player.getName().getString());

        // Save the inventory to the basket's NBT
        //noinspection IfStatementWithIdenticalBranches
        if (basketItem.getTag() != null) {
            CompoundTag tag = basketItem.getTag().getCompound("BlockEntityTag");
            tag.put("inventory", basketInventory.serializeNBT());
            basketItem.getTag().put("BlockEntityTag", tag);
            LogUtil.info("Basket inventory saved for player: {}", player.getName().getString());
        }
        else {
            CompoundTag tag = new CompoundTag();
            tag.put("inventory", basketInventory.serializeNBT());
            basketItem.getOrCreateTag().put("BlockEntityTag", tag);
            LogUtil.info("Basket inventory saved for player: {}", player.getName().getString());
        }
    }
}