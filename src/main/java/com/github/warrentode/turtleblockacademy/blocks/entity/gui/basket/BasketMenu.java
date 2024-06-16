package com.github.warrentode.turtleblockacademy.blocks.entity.gui.basket;

import com.github.warrentode.turtleblockacademy.blocks.entity.BasketBlockEntity;
import com.github.warrentode.turtleblockacademy.blocks.entity.gui.TBAMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class BasketMenu extends AbstractContainerMenu {
    /**
     * CREDIT GOES TO: diesieben07 | <a href="https://github.com/diesieben07/SevenCommons">SevenCommons</a>
     * -- for the quickMoveStack method -- must assign a slot number to each of the slots used by the GUI.
     * For this container, we can see both the tile inventory's slots as well as the player inventory slots
     * and the hotbar. Each time we add a Slot to the container, it automatically increases the slotIndex,
     * which means:
     * 0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
     * 9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
     * 36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
     **/
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int VANILLA_LAST_SLOT_INDEX = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT - 1;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_LAST_SLOT_INDEX + 1;
    private static final int CONTAINER_SLOT_COUNT = BasketBlockEntity.INVENTORY_SIZE;
    private static final int TE_INVENTORY_LAST_SLOT_INDEX = TE_INVENTORY_FIRST_SLOT_INDEX + CONTAINER_SLOT_COUNT - 1;

    private final Container basket;

    public BasketMenu(int containerId, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(containerId, playerInventory, new SimpleContainer(CONTAINER_SLOT_COUNT));
    }

    public BasketMenu(int containerId, @NotNull Inventory playerInventory, Container container) {
        super(TBAMenuTypes.BASKET_MENU.get(), containerId);
        checkContainerSize(container, CONTAINER_SLOT_COUNT);
        this.basket = container;
        this.basket.startOpen(playerInventory.player);

        int numRows = 3;
        int numCols = 3;
        int entityStartX = 62;
        int entityStartY = 17;
        int playerStartX = 8;
        int playerInvStartY = 84;
        int hotbarStartY = 142;
        int borderSize = 18;

        // Add block entity slots
        for (int rows = 0; rows < numRows; ++rows) {
            for (int cols = 0; cols < numCols; ++cols) {
                this.addSlot(new Slot(this.basket, cols + rows * numRows,
                        entityStartX + cols * borderSize, entityStartY + rows * borderSize));
            }
        }

        // add player inventory slots
        for (int rows = 0; rows < PLAYER_INVENTORY_ROW_COUNT; ++rows) {
            for (int cols = 0; cols < PLAYER_INVENTORY_COLUMN_COUNT; ++cols) {
                this.addSlot(new Slot(playerInventory, cols + rows * PLAYER_INVENTORY_COLUMN_COUNT + 9, playerStartX + cols * borderSize, playerInvStartY + rows * borderSize));
            }
        }

        // add player hotbar
        for (int cols = 0; cols < HOTBAR_SLOT_COUNT; ++cols) {
            this.addSlot(new Slot(playerInventory, cols, playerStartX + cols * borderSize, hotbarStartY));
        }
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return this.basket.stillValid(player);
    }

    /** this is diesieben07's quickMoveStack method, slightly altered to match the varibles I changed above **/
    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player playerIn, int index) {
        Slot sourceSlot = slots.get(index);
        if (!sourceSlot.hasItem()) {
            return ItemStack.EMPTY;  //EMPTY_ITEM
        }
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index > CONTAINER_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, CONTAINER_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        }
        else //noinspection UnreachableCode
            if (index < VANILLA_FIRST_SLOT_INDEX) {
                // This is a TE slot so merge the stack into the players inventory
                if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_LAST_SLOT_INDEX, false)) {
                    return ItemStack.EMPTY;
                }
            }
            else {
                System.out.println("Invalid slotIndex:" + index);
                return ItemStack.EMPTY;
            }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        }
        else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public void removed(@NotNull Player player) {
        super.removed(player);
        this.basket.stopOpen(player);
    }
}