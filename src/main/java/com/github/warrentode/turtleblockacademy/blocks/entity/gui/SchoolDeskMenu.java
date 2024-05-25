package com.github.warrentode.turtleblockacademy.blocks.entity.gui;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SchoolDeskMenu extends AbstractContainerMenu {
    private static final int SLOT_COUNT = 1;
    private static final int DATA_COUNT = 1;
    public static final int BUTTON_PREV_PAGE = 1;
    public static final int BUTTON_NEXT_PAGE = 2;
    public static final int BUTTON_TAKE_BOOK = 3;
    public static final int BUTTON_PAGE_JUMP_RANGE_START = 100;
    private final Container schoolDesk;
    private final ContainerData schoolDeskData;

    public SchoolDeskMenu(int containerId, Inventory ignoredInventory, FriendlyByteBuf ignoredByteBuf) {
        this(containerId, new SimpleContainer(1), new SimpleContainerData(1));
    }

    public SchoolDeskMenu(int containerId, Container schoolDesk, ContainerData schoolDeskData) {
        super(TBAMenuTypes.SCHOOL_DESK_MENU.get(), containerId);
        checkContainerSize(schoolDesk, SLOT_COUNT);
        checkContainerDataCount(schoolDeskData, DATA_COUNT);
        this.schoolDesk = schoolDesk;
        this.schoolDeskData = schoolDeskData;
        this.addSlot(new Slot(schoolDesk, 0, 0, 0) {
            /** Called when the stack in a Slot changes */
            public void setChanged() {
                super.setChanged();
                SchoolDeskMenu.this.slotsChanged(this.container);
            }
        });
        this.addDataSlots(schoolDeskData);
    }

    public boolean clickMenuButton(@NotNull Player player, int id) {
        if (id >= BUTTON_PAGE_JUMP_RANGE_START) {
            int k = id - BUTTON_PAGE_JUMP_RANGE_START;
            this.setData(0, k);
            return true;
        }
        else {
            switch (id) {
                case BUTTON_PREV_PAGE:
                    int j = this.schoolDeskData.get(0);
                    this.setData(0, j - 1);
                    return true;
                case BUTTON_NEXT_PAGE:
                    int i = this.schoolDeskData.get(0);
                    this.setData(0, i + 1);
                    return true;
                case BUTTON_TAKE_BOOK:
                    if (!player.mayBuild()) {
                        return false;
                    }

                    ItemStack stack = this.schoolDesk.removeItemNoUpdate(0);
                    this.schoolDesk.setChanged();
                    if (!player.getInventory().add(stack)) {
                        player.drop(stack, false);
                    }

                    return true;
                default:
                    return false;
            }
        }
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        return ItemStack.EMPTY;
    }

    public void setData(int id, int data) {
        super.setData(id, data);
        this.broadcastChanges();
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return this.schoolDesk.stillValid(player);
    }

    public ItemStack getBook() {
        return this.schoolDesk.getItem(0);
    }

    public int getPage() {
        return this.schoolDeskData.get(0);
    }
}
