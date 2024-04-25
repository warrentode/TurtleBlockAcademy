package com.github.warrentode.turtleblockacademy.items.entity;

import com.github.warrentode.turtleblockacademy.entity.ModEntityTypes;
import com.github.warrentode.turtleblockacademy.items.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DiodeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import javax.annotation.Nullable;
import java.util.OptionalInt;

public class PlateEntity extends ItemFrame {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final EntityDataAccessor<ItemStack> DATA_ITEM = SynchedEntityData.defineId(PlateEntity.class, EntityDataSerializers.ITEM_STACK);
    private static final EntityDataAccessor<Integer> DATA_ROTATION = SynchedEntityData.defineId(PlateEntity.class, EntityDataSerializers.INT);
    public static final int NUM_ROTATIONS = 8;
    private float dropChance = 1.0F;
    private boolean fixed;

    public PlateEntity(EntityType<? extends PlateEntity> entityType, Level level) {
        super(entityType, level);
    }

    @SuppressWarnings("unused")
    public PlateEntity(Level level, BlockPos pos, Direction direction) {
        this(ModEntityTypes.PLATE_ENTITY.get(), level, pos, direction);
    }

    public PlateEntity(EntityType<? extends PlateEntity> entityType, Level level, BlockPos ignoredPos, Direction direction) {
        super(entityType, level);
        this.setDirection(direction);
    }

    protected float getEyeHeight(@NotNull Pose pose, @NotNull EntityDimensions size) {
        return 0.0F;
    }

    protected void defineSynchedData() {
        this.getEntityData().define(DATA_ITEM, ItemStack.EMPTY);
        this.getEntityData().define(DATA_ROTATION, 0);
    }

    /** Updates facing and bounding box based on it */
    protected void setDirection(@NotNull Direction direction) {
        //noinspection deprecation
        Validate.notNull(direction);
        this.direction = direction;
        if (direction.getAxis().isHorizontal()) {
            this.setXRot(0.0F);
            this.setYRot((float) (this.direction.get2DDataValue() * 90));
        }
        else {
            this.setXRot((float) (-90 * direction.getAxisDirection().getStep()));
            this.setYRot(0.0F);
        }

        this.xRotO = this.getXRot();
        this.yRotO = this.getYRot();
        this.recalculateBoundingBox();
    }

    /** Updates the entity bounding box based on current facing */
    protected void recalculateBoundingBox() {
        //noinspection unused
        double d0 = 0.46875D;
        double d1 = (double) this.pos.getX() + 0.5D - (double) this.direction.getStepX() * 0.46875D;
        double d2 = (double) this.pos.getY() + 0.5D - (double) this.direction.getStepY() * 0.46875D;
        double d3 = (double) this.pos.getZ() + 0.5D - (double) this.direction.getStepZ() * 0.46875D;
        this.setPosRaw(d1, d2, d3);
        double d4 = this.getWidth();
        double d5 = this.getHeight();
        double d6 = this.getWidth();
        Direction.Axis direction$axis = this.direction.getAxis();
        switch (direction$axis) {
            case X:
                d4 = 1.0D;
                break;
            case Y:
                d5 = 1.0D;
                break;
            case Z:
                d6 = 1.0D;
        }

        d4 /= 32.0D;
        d5 /= 32.0D;
        d6 /= 32.0D;
        this.setBoundingBox(new AABB(d1 - d4, d2 - d5, d3 - d6, d1 + d4, d2 + d5, d3 + d6));
    }

    /** Checks to make sure the {@code HangingEntity} can be placed there. */
    public boolean survives() {
        if (this.fixed) {
            return true;
        }
        else if (!this.level.noCollision(this)) {
            return false;
        }
        else {
            BlockState blockstate = this.level.getBlockState(this.pos.relative(this.direction.getOpposite()));
            return (blockstate.getMaterial().isSolid() ||
                    this.direction.getAxis().isHorizontal() && DiodeBlock.isDiode(blockstate)) &&
                    this.level.getEntities(this, this.getBoundingBox(),
                            HANGING_ENTITY).isEmpty();
        }
    }

    public void move(@NotNull MoverType type, @NotNull Vec3 pos) {
        if (!this.fixed) {
            super.move(type, pos);
        }
    }

    public void push(double pX, double pY, double pZ) {
        if (!this.fixed) {
            super.push(pX, pY, pZ);
        }
    }

    public float getPickRadius() {
        return super.getPickRadius();
    }

    /** Called by the /kill command. */
    public void kill() {
        this.removeFramedMap(this.getItem());
        super.kill();
    }

    /** Called when the entity is attacked. */
    public boolean hurt(@NotNull DamageSource source, float amount) {
        if (this.fixed) {
            return (source == DamageSource.OUT_OF_WORLD || source.isCreativePlayer()) && super.hurt(source, amount);
        }
        else if (this.isInvulnerableTo(source)) {
            return false;
        }
        else if (!source.isExplosion() && !this.getItem().isEmpty()) {
            if (!this.level.isClientSide) {
                this.dropItem(source.getEntity(), false);
                this.playSound(this.getRemoveItemSound(), 1.0F, 1.0F);
            }

            return true;
        }
        else {
            return super.hurt(source, amount);
        }
    }

    public @NotNull SoundEvent getRemoveItemSound() {
        return SoundEvents.ITEM_FRAME_REMOVE_ITEM;
    }

    /** Checks if the entity is in range to render. */
    public boolean shouldRenderAtSqrDistance(double distance) {
        double d0 = 16.0D;
        d0 *= 64.0D * getViewScale();
        return distance < d0 * d0;
    }

    /** Called when this entity is broken. Entity parameter may be null. */
    public void dropItem(@Nullable Entity brokenEntity) {
        this.playSound(this.getBreakSound(), 1.0F, 1.0F);
        this.dropItem(brokenEntity, true);
    }

    public @NotNull SoundEvent getBreakSound() {
        return SoundEvents.ITEM_FRAME_BREAK;
    }

    public void playPlacementSound() {
        this.playSound(this.getPlaceSound(), 1.0F, 1.0F);
    }

    public @NotNull SoundEvent getPlaceSound() {
        return SoundEvents.ITEM_FRAME_PLACE;
    }

    private void dropItem(@Nullable Entity entity, boolean dropSelf) {
        if (!this.fixed) {
            ItemStack itemstack = this.getItem();
            this.setItem(ItemStack.EMPTY);
            if (!this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                if (entity == null) {
                    this.removeFramedMap(itemstack);
                }
            }
            else {
                if (entity instanceof Player player) {
                    if (player.getAbilities().instabuild) {
                        this.removeFramedMap(itemstack);
                        return;
                    }
                }

                if (dropSelf) {
                    this.spawnAtLocation(this.getFrameItemStack());
                }

                if (!itemstack.isEmpty()) {
                    itemstack = itemstack.copy();
                    this.removeFramedMap(itemstack);
                    if (this.random.nextFloat() < this.dropChance) {
                        this.spawnAtLocation(itemstack);
                    }
                }
            }
        }
    }

    /** Removes the dot representing this frame's position from the map when the item frame is broken. */
    private void removeFramedMap(@NotNull ItemStack stack) {
        this.getFramedMapId().ifPresent((mapID) -> {
            MapItemSavedData mapItemSavedData = MapItem.getSavedData(mapID, this.level);
            if (mapItemSavedData != null) {
                mapItemSavedData.removedFromFrame(this.pos, this.getId());
                mapItemSavedData.setDirty(true);
            }
        });
        stack.setEntityRepresentation(null);
    }

    public @NotNull ItemStack getItem() {
        return this.getEntityData().get(DATA_ITEM);
    }

    public @NotNull OptionalInt getFramedMapId() {
        ItemStack stack = this.getItem();
        if (stack.is(Items.FILLED_MAP)) {
            Integer integer = MapItem.getMapId(stack);
            if (integer != null) {
                return OptionalInt.of(integer);
            }
        }

        return OptionalInt.empty();
    }

    public boolean hasFramedMap() {
        return this.getFramedMapId().isPresent();
    }

    public void setItem(@NotNull ItemStack stack) {
        this.setItem(stack, true);
    }

    public void setItem(@NotNull ItemStack stack, boolean updateNeighbours) {
        if (!stack.isEmpty()) {
            stack = stack.copy();
            stack.setCount(1);
        }

        this.onItemChanged(stack);
        this.getEntityData().set(DATA_ITEM, stack);
        if (!stack.isEmpty()) {
            this.playSound(this.getAddItemSound(), 1.0F, 1.0F);
        }

        if (updateNeighbours) {
            this.level.updateNeighbourForOutputSignal(this.pos, Blocks.AIR);
        }
    }

    public @NotNull SoundEvent getAddItemSound() {
        return SoundEvents.ITEM_FRAME_ADD_ITEM;
    }

    public @NotNull SlotAccess getSlot(int slot) {
        return slot == 0 ? new SlotAccess() {
            public @NotNull ItemStack get() {
                return PlateEntity.this.getItem();
            }

            public boolean set(@NotNull ItemStack carriedStack) {
                PlateEntity.this.setItem(carriedStack);
                return true;
            }
        } : super.getSlot(slot);
    }

    public void onSyncedDataUpdated(@NotNull EntityDataAccessor<?> key) {
        if (key.equals(DATA_ITEM)) {
            this.onItemChanged(this.getItem());
        }
    }

    private void onItemChanged(@NotNull ItemStack stack) {
        if (!stack.isEmpty() && getFrame(stack) != this) {
            stack.setEntityRepresentation(this);
        }

        this.recalculateBoundingBox();
    }

    @Nullable
    public PlateEntity getFrame(@NotNull ItemStack stack) {
        ItemStack stack1 = ItemStack.EMPTY;
        return stack.getEntityRepresentation() instanceof PlateEntity ? (PlateEntity) this.getEntityRepresentation(stack1) : null;
    }

    @Contract(pure = true)
    private @Nullable Entity getEntityRepresentation(@NotNull ItemStack stack) {
        return stack.getEntityRepresentation();
    }

    /**
     Return the rotation of the item currently on this frame.
     */
    public int getRotation() {
        return this.getEntityData().get(DATA_ROTATION);
    }

    public void setRotation(int pRotation) {
        this.setRotation(pRotation, true);
    }

    private void setRotation(int pRotation, boolean pUpdateNeighbours) {
        this.getEntityData().set(DATA_ROTATION, pRotation % NUM_ROTATIONS);
        if (pUpdateNeighbours) {
            this.level.updateNeighbourForOutputSignal(this.pos, Blocks.AIR);
        }
    }

    public void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        if (!this.getItem().isEmpty()) {
            tag.put("Item", this.getItem().save(new CompoundTag()));
            tag.putByte("ItemRotation", (byte) this.getRotation());
            tag.putFloat("ItemDropChance", this.dropChance);
        }

        tag.putByte("Facing", (byte) this.direction.get3DDataValue());
        tag.putBoolean("Invisible", this.isInvisible());
        tag.putBoolean("Fixed", this.fixed);
    }

    /** (abstract) Protected helper method to read subclass entity data from NBT. */
    public void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        CompoundTag compoundTag = tag.getCompound("Item");
        if (!compoundTag.isEmpty()) {
            ItemStack itemStack = ItemStack.of(compoundTag);
            if (itemStack.isEmpty()) {
                LOGGER.warn("Unable to load item from: {}", compoundTag);
            }

            ItemStack itemStack1 = this.getItem();
            if (!itemStack1.isEmpty() && !ItemStack.matches(itemStack, itemStack1)) {
                this.removeFramedMap(itemStack1);
            }

            this.setItem(itemStack, false);
            this.setRotation(tag.getByte("ItemRotation"), false);
            if (tag.contains("ItemDropChance", 99)) {
                this.dropChance = tag.getFloat("ItemDropChance");
            }
        }

        this.setDirection(Direction.from3DDataValue(tag.getByte("Facing")));
        this.setInvisible(tag.getBoolean("Invisible"));
        this.fixed = tag.getBoolean("Fixed");
    }

    public @NotNull InteractionResult interact(@NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack itemInHand = player.getItemInHand(hand);
        boolean flag = !this.getItem().isEmpty();
        boolean flag1 = !itemInHand.isEmpty();
        if (this.fixed) {
            return InteractionResult.PASS;
        }
        else if (!this.level.isClientSide) {
            if (!flag) {
                if (flag1 && !this.isRemoved()) {
                    if (itemInHand.is(Items.FILLED_MAP)) {
                        MapItemSavedData mapItemSavedData = MapItem.getSavedData(itemInHand, this.level);
                        if (mapItemSavedData != null && mapItemSavedData.isTrackedCountOverLimit(256)) {
                            return InteractionResult.FAIL;
                        }
                    }

                    this.setItem(itemInHand);
                    if (!player.getAbilities().instabuild) {
                        itemInHand.shrink(1);
                    }
                }
            }
            else {
                this.playSound(this.getRotateItemSound(), 1.0F, 1.0F);
                this.setRotation(this.getRotation() + 1);
            }

            return InteractionResult.CONSUME;
        }
        else {
            return !flag && !flag1 ? InteractionResult.PASS : InteractionResult.SUCCESS;
        }
    }

    public @NotNull SoundEvent getRotateItemSound() {
        return SoundEvents.ITEM_FRAME_ROTATE_ITEM;
    }

    public int getAnalogOutput() {
        return this.getItem().isEmpty() ? 0 : this.getRotation() % NUM_ROTATIONS + 1;
    }

    public @NotNull Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this, this.direction.get3DDataValue(), this.getPos());
    }

    public void recreateFromPacket(@NotNull ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        this.setDirection(Direction.from3DDataValue(packet.getData()));
    }

    public ItemStack getPickResult() {
        ItemStack stack = this.getItem();
        return stack.isEmpty() ? this.getFrameItemStack() : stack.copy();
    }

    protected @NotNull ItemStack getFrameItemStack() {
        if (this.getItem() == ModItems.PLATE_WHITE.get().getDefaultInstance()) {
            return new ItemStack(ModItems.PLATE_WHITE.get());
        }
        else {
            return new ItemStack(ModItems.PLATE_ITEM.get());
        }
    }

    public float getVisualRotationYInDegrees() {
        Direction direction = this.getDirection();
        int i = direction.getAxis().isVertical() ? 90 * direction.getAxisDirection().getStep() : 0;
        return (float) Mth.wrapDegrees(180 + direction.get2DDataValue() * 90 + this.getRotation() * 45 + i);
    }
}