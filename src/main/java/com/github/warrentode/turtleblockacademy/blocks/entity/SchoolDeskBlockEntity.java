package com.github.warrentode.turtleblockacademy.blocks.entity;

import com.github.warrentode.turtleblockacademy.blocks.SchoolDeskBlock;
import com.github.warrentode.turtleblockacademy.blocks.gui.SchoolDeskMenu;
import com.github.warrentode.turtleblockacademy.util.PackTags;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.Clearable;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.WrittenBookItem;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class SchoolDeskBlockEntity extends BlockEntity implements Clearable, MenuProvider {
    public static final int DATA_PAGE = 0;
    public static final int NUM_DATA = 1;
    public static final int SLOT_BOOK = 0;
    public static final int NUM_SLOTS = 1;
    ItemStack book = ItemStack.EMPTY;
    int page;
    private int pageCount;

    private final Container bookAccess = new Container() {
        /** Returns the number of slots in the inventory. */
        public int getContainerSize() {
            return NUM_SLOTS;
        }

        public boolean isEmpty() {
            return SchoolDeskBlockEntity.this.book.isEmpty();
        }

        /** Returns the stack in the given slot. */
        public @NotNull ItemStack getItem(int slot) {
            return slot == 0 ? SchoolDeskBlockEntity.this.book : ItemStack.EMPTY;
        }

        /** Removes up to a specified number of items from an inventory slot and returns them in a new stack. */
        public @NotNull ItemStack removeItem(int slot, int amount) {
            if (slot == 0) {
                ItemStack stack = SchoolDeskBlockEntity.this.book.split(amount);
                if (SchoolDeskBlockEntity.this.book.isEmpty()) {
                    SchoolDeskBlockEntity.this.onBookItemRemove();
                }

                return stack;
            }
            else {
                return ItemStack.EMPTY;
            }
        }

        /** Removes a stack from the given slot and returns it. */
        public @NotNull ItemStack removeItemNoUpdate(int slot) {
            if (slot == 0) {
                ItemStack itemstack = SchoolDeskBlockEntity.this.book;
                SchoolDeskBlockEntity.this.book = ItemStack.EMPTY;
                SchoolDeskBlockEntity.this.onBookItemRemove();
                return itemstack;
            }
            else {
                return ItemStack.EMPTY;
            }
        }

        /** Sets the given item stack to the specified slot in the inventory
         (can be crafting or armor sections). */
        public void setItem(int slot, @NotNull ItemStack stack) {
        }

        /** Returns the maximum stack size for an inventory slot.
         Seems to always be 64, possibly will be extended. */
        public int getMaxStackSize() {
            return NUM_DATA;
        }

        /**
         * For block entities, ensures the chunk containing the block entity is saved to disk later
         * - the game won't think it hasn't changed and skip it.
         */
        public void setChanged() {
            SchoolDeskBlockEntity.this.setChanged();
        }

        /** Don't rename this method to canInteractWith due to conflicts with Container */
        public boolean stillValid(@NotNull Player player) {
            assert SchoolDeskBlockEntity.this.level != null;
            if (SchoolDeskBlockEntity.this.level.getBlockEntity(SchoolDeskBlockEntity.this.worldPosition) != SchoolDeskBlockEntity.this) {
                return false;
            }
            else {
                return !(player.distanceToSqr((double) SchoolDeskBlockEntity.this.worldPosition.getX() + 0.5D,
                        (double) SchoolDeskBlockEntity.this.worldPosition.getY() + 0.5D,
                        (double) SchoolDeskBlockEntity.this.worldPosition.getZ() + 0.5D) > 64.0D)
                        && SchoolDeskBlockEntity.this.hasBook();
            }
        }

        /** Returns {@code true} if automation is allowed to insert the given stack (ignoring stack size)
         into the given slot. For guis use Slot.isItemValid */
        public boolean canPlaceItem(int index, @NotNull ItemStack stack) {
            return false;
        }

        public void clearContent() {
        }
    };

    private final ContainerData dataAccess = new ContainerData() {
        public int get(int index) {
            return index == 0 ? SchoolDeskBlockEntity.this.page : DATA_PAGE;
        }

        public void set(int index, int value) {
            if (index == SLOT_BOOK) {
                SchoolDeskBlockEntity.this.setPage(value);
            }
        }

        public int getCount() {
            return NUM_DATA;
        }
    };

    public SchoolDeskBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SCHOOL_DESK_ENTITY.get(), pos, state);
    }

    public ItemStack getBook() {
        return this.book;
    }

    public boolean hasBook() {
        return this.book.is(PackTags.Items.LECTERN_BOOKS);
    }

    public void setBook(ItemStack pStack) {
        this.setBook(pStack, null);
    }

    void onBookItemRemove() {
        this.page = 0;
        this.pageCount = 0;
        SchoolDeskBlock.resetBookState(Objects.requireNonNull(this.getLevel()),
                this.getBlockPos(), this.getBlockState(), false);
    }

    public void setBook(ItemStack pStack, @Nullable Player pPlayer) {
        this.book = this.resolveBook(pStack, pPlayer);
        this.page = 0;
        this.pageCount = WrittenBookItem.getPageCount(this.book);
        this.setChanged();
    }

    void setPage(int pPage) {
        int i = Mth.clamp(pPage, 0, this.pageCount - 1);
        if (i != this.page) {
            this.page = i;
            this.setChanged();
            SchoolDeskBlock.signalPageChange(Objects.requireNonNull(this.getLevel()),
                    this.getBlockPos(), this.getBlockState());
        }
    }

    private ItemStack resolveBook(ItemStack stack, @Nullable Player player) {
        if (this.level instanceof ServerLevel && stack.is(Items.WRITTEN_BOOK)) {
            WrittenBookItem.resolveBookComponents(stack,
                    this.createCommandSourceStack(player), player);
        }

        return stack;
    }

    @Contract("_ -> new")
    private @NotNull CommandSourceStack createCommandSourceStack(@Nullable Player player) {
        String string;
        Component component;
        if (player == null) {
            string = "Lectern";
            component = Component.literal("Lectern");
        }
        else {
            string = player.getName().getString();
            component = player.getDisplayName();
        }

        Vec3 vec3 = Vec3.atCenterOf(this.worldPosition);
        return new CommandSourceStack(CommandSource.NULL, vec3, Vec2.ZERO,
                (ServerLevel) this.level, 2, string, component,
                this.level.getServer(), player);
    }

    public boolean onlyOpCanSetNbt() {
        return true;
    }

    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        if (tag.contains("Book", 10)) {
            this.book = this.resolveBook(ItemStack.of(tag.getCompound("Book")), null);
        }
        else {
            this.book = ItemStack.EMPTY;
        }

        this.pageCount = WrittenBookItem.getPageCount(this.book);
        this.page = Mth.clamp(tag.getInt("Page"), 0, this.pageCount - 1);
    }

    protected void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        if (!this.getBook().isEmpty()) {
            tag.put("Book", this.getBook().save(new CompoundTag()));
            tag.putInt("Page", this.page);
        }
    }

    @Override
    public void clearContent() {
        this.setBook(ItemStack.EMPTY);
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("container.turtleblockacademy.desk");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, @NotNull Inventory playerInventory, @NotNull Player player) {
        return new SchoolDeskMenu(containerId, this.bookAccess, this.dataAccess);
    }
}
