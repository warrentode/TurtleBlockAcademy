package com.github.warrentode.turtleblockacademy.blocks.entity;

import com.github.warrentode.turtleblockacademy.blocks.BookCaseBlock;
import com.github.warrentode.turtleblockacademy.blocks.SchoolDeskCabinetBlock;
import com.github.warrentode.turtleblockacademy.blocks.SchoolLockerBlock;
import com.github.warrentode.turtleblockacademy.util.TBASounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class SchoolStorageEntity extends RandomizableContainerBlockEntity {
    private NonNullList<ItemStack> contents = NonNullList.withSize(27, ItemStack.EMPTY);

    private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter() {
        protected void onOpen(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state) {
            if (state.getBlock() instanceof SchoolDeskCabinetBlock) {
                SchoolStorageEntity.this.playSound(state, TBASounds.BLOCK_DESK_OPEN.get());
                SchoolStorageEntity.this.updateBlockState(state, true);
            }
            else if (state.getBlock() instanceof SchoolLockerBlock) {
                SchoolStorageEntity.this.playSound(state, TBASounds.BLOCK_LOCKER_OPEN.get());
                SchoolStorageEntity.this.updateBlockState(state, true);
            }
            else if (state.getBlock() instanceof BookCaseBlock) {
                SchoolStorageEntity.this.playSound(state, TBASounds.BLOCK_BOOKCASE_OPEN.get());
                SchoolStorageEntity.this.updateBlockState(state, true);
            }
        }

        protected void onClose(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state) {
            if (state.getBlock() instanceof SchoolDeskCabinetBlock) {
                SchoolStorageEntity.this.playSound(state, TBASounds.BLOCK_DESK_CLOSE.get());
                SchoolStorageEntity.this.updateBlockState(state, true);
            }
            else if (state.getBlock() instanceof SchoolLockerBlock) {
                SchoolStorageEntity.this.playSound(state, TBASounds.BLOCK_LOCKER_CLOSE.get());
                SchoolStorageEntity.this.updateBlockState(state, false);
            }
            else if (state.getBlock() instanceof BookCaseBlock) {
                SchoolStorageEntity.this.playSound(state, TBASounds.BLOCK_BOOKCASE_CLOSE.get());
                SchoolStorageEntity.this.updateBlockState(state, true);
            }
        }

        protected void openerCountChanged(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, int count, int openCount) {
        }

        protected boolean isOwnContainer(@NotNull Player player) {
            if (player.containerMenu instanceof ChestMenu) {
                Container container = ((ChestMenu) player.containerMenu).getContainer();
                return container == SchoolStorageEntity.this;
            }
            else {
                return false;
            }
        }
    };

    public SchoolStorageEntity(BlockPos pos, BlockState state) {
        super(TBABlockEntities.SCHOOL_STORAGE_ENTITY.get(), pos, state);
    }

    @Override
    public void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        if (!trySaveLootTable(tag)) {
            ContainerHelper.saveAllItems(tag, contents);
        }
    }

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        contents = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
        if (!tryLoadLootTable(tag)) {
            ContainerHelper.loadAllItems(tag, contents);
        }
    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    @Override
    protected @NotNull NonNullList<ItemStack> getItems() {
        return contents;
    }

    @Override
    protected void setItems(@NotNull NonNullList<ItemStack> itemsIn) {
        contents = itemsIn;
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("container.turtleblockacademy.storage");
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int id, @NotNull Inventory player) {
        return ChestMenu.threeRows(id, player, this);
    }

    public void startOpen(@NotNull Player player) {
        if (level != null && !this.remove && !player.isSpectator()) {
            this.openersCounter.incrementOpeners(player, level, this.getBlockPos(), this.getBlockState());
        }
    }

    public void stopOpen(@NotNull Player player) {
        if (level != null && !this.remove && !player.isSpectator()) {
            this.openersCounter.decrementOpeners(player, level, this.getBlockPos(), this.getBlockState());
        }
    }

    public void recheckOpen() {
        if (level != null && !this.remove) {
            this.openersCounter.recheckOpeners(level, this.getBlockPos(), this.getBlockState());
        }
    }

    void updateBlockState(BlockState state, boolean open) {
        if (level != null) {
            if (state.getBlock() instanceof SchoolDeskCabinetBlock) {
                this.level.setBlock(this.getBlockPos(), state.setValue(SchoolDeskCabinetBlock.OPEN, open), 3);
            }
            else if (state.getBlock() instanceof SchoolLockerBlock) {
                this.level.setBlock(this.getBlockPos(), state.setValue(SchoolLockerBlock.OPEN, open), 3);
            }
            else if (state.getBlock() instanceof BookCaseBlock) {
                this.level.setBlock(this.getBlockPos(), state.setValue(BookCaseBlock.OPEN, open), 3);
            }
        }
    }

    private void playSound(BlockState state, SoundEvent sound) {
        if (level == null) {
            return;
        }

        Vec3i facingVector = state.getValue(SchoolDeskCabinetBlock.FACING).getNormal();
        double x = (double) worldPosition.getX() + 0.5D + (double) facingVector.getX() / 2.0D;
        double y = (double) worldPosition.getY() + 0.5D + (double) facingVector.getY() / 2.0D;
        double z = (double) worldPosition.getZ() + 0.5D + (double) facingVector.getZ() / 2.0D;
        level.playSound(null, x, y, z, sound, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);
    }
}
