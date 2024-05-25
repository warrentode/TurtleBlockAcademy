package com.github.warrentode.turtleblockacademy.blocks.entity.gui;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.blocks.entity.FermentingPotBlockEntity;
import com.github.warrentode.turtleblockacademy.blocks.entity.slot.FermentingPotResultSlot;
import com.github.warrentode.turtleblockacademy.recipe.TBARecipes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class FermentingPotMenu extends RecipeBookMenu<RecipeWrapper> {
    public final FermentingPotBlockEntity potEntity;
    public final ItemStackHandler inventory;
    private final Level level;
    private final ContainerData data;
    private final ContainerLevelAccess canInteractWithCallable;

    public FermentingPotMenu(int id, Inventory inventory, @NotNull FriendlyByteBuf extraData) {
        // the simple container data value NEEDS to match the getCount value in the block entity
        this(id, inventory, inventory.player.level.getBlockEntity(extraData.readBlockPos()),
                new SimpleContainerData(2));
    }

    public FermentingPotMenu(int id, Inventory inventory, BlockEntity blockEntity, ContainerData data) {
        super(TBAMenuTypes.FERMENTING_POT_MENU.get(), id);
        // this value NEEDS to match the value given to the item stack handler managing the inventory in the block entity
        checkContainerSize(inventory, 9);

        potEntity = (FermentingPotBlockEntity) blockEntity;
        this.inventory = potEntity.getInventory();
        this.level = inventory.player.level;
        this.data = data;
        this.canInteractWithCallable = ContainerLevelAccess.create(Objects.requireNonNull(potEntity.getLevel()), potEntity.getBlockPos());

        this.potEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            this.addSlot(new SlotItemHandler(handler, 0, 30, 17));
            this.addSlot(new SlotItemHandler(handler, 1, 48, 17));
            this.addSlot(new SlotItemHandler(handler, 2, 66, 17));
            this.addSlot(new SlotItemHandler(handler, 3, 30, 35));
            this.addSlot(new SlotItemHandler(handler, 4, 48, 35));
            this.addSlot(new SlotItemHandler(handler, 5, 66, 35));
            this.addSlot(new SlotItemHandler(handler, 6, 124, 7));
            this.addSlot(new SlotItemHandler(handler, 7, 124, 27));
            this.addSlot(new FermentingPotResultSlot(inventory.player, potEntity, handler, 8, 124, 55));
        });

        this.addPlayerInventory(inventory);
        this.addPlayerHotbar(inventory);

        this.addDataSlots(data);
    }

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1); // total/max time
        int progressArrowSize = 22; // size of arrow: if running lengthwise, use width - otherwise use height

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_LAST_SLOT_INDEX = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = 0;
    private static final int RESULT_SLOT_INDEX = 8;
    private static final int TE_INVENTORY_LAST_SLOT_INDEX = RESULT_SLOT_INDEX + 1;  // must be the number of slots you have!
    private static final int VANILLA_FIRST_SLOT_INDEX = TE_INVENTORY_LAST_SLOT_INDEX + 1;

    @SuppressWarnings("ConstantValue")
    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player playerIn, int index) {
        Slot sourceSlot = slots.get(index);
        if (!sourceSlot.hasItem()) {
            return ItemStack.EMPTY;  //EMPTY_ITEM
        }
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index > RESULT_SLOT_INDEX) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, RESULT_SLOT_INDEX, false)) {
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
    public boolean stillValid(@NotNull Player player) {
        return stillValid(this.canInteractWithCallable, player, TBABlocks.FERMENTING_POT_BLOCK.get());
    }

    private void addPlayerInventory(Inventory inventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(inventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory inventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(inventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public void fillCraftSlotsStackedContents(@NotNull StackedContents helper) {
        for (int i = 0; i < inventory.getSlots(); i++) {
            helper.accountSimpleStack(inventory.getStackInSlot(i));
        }
    }

    @Override
    public void clearCraftingContent() {
        for (int i = 0; i < 2; i++) {
            this.inventory.setStackInSlot(i, ItemStack.EMPTY);
        }
    }

    @Override
    public boolean recipeMatches(Recipe<? super RecipeWrapper> recipe) {
        return recipe.matches(new RecipeWrapper(inventory), level);
    }

    @Override
    public int getResultSlotIndex() {
        return FermentingPotBlockEntity.RESULT_SLOT;
    }

    @Override
    public int getGridWidth() {
        return 3;
    }

    @Override
    public int getGridHeight() {
        return 2;
    }

    @Override
    public int getSize() {
        return FermentingPotBlockEntity.INVENTORY_SIZE;
    }

    @Override
    public @NotNull RecipeBookType getRecipeBookType() {
        return TBARecipes.RECIPE_BOOK_FERMENTING;
    }

    @Override
    public boolean shouldMoveToInventory(int slot) {
        return slot < (getGridWidth() * getGridHeight());
    }
}