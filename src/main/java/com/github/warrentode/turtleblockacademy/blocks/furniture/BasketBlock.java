package com.github.warrentode.turtleblockacademy.blocks.furniture;

import com.github.warrentode.turtleblockacademy.blocks.entity.BasketBlockEntity;
import com.github.warrentode.turtleblockacademy.blocks.entity.TBABlockEntities;
import com.github.warrentode.turtleblockacademy.util.SeasonalParticleColors;
import com.github.warrentode.turtleblockacademy.util.ShapeUtil;
import com.github.warrentode.turtleblockacademy.util.TBATags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class BasketBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty CONDITIONAL = BlockStateProperties.CONDITIONAL;
    private final DyeColor color;

    private static final Map<Direction, VoxelShape> SHAPES = new EnumMap<>(Direction.class);

    public final static VoxelShape SHAPE = Stream.of(
            Block.box(2, 0, 2, 14, 1, 14),
            Block.box(1, 0, 2, 2, 6, 14),
            Block.box(14, 0, 2, 15, 6, 14),
            Block.box(2, 0, 1, 14, 6, 2),
            Block.box(2, 0, 14, 14, 6, 15),
            Block.box(1, 6, 7, 2, 13, 8),
            Block.box(1, 6, 8, 2, 13, 9),
            Block.box(14, 6, 7, 15, 13, 8),
            Block.box(14, 6, 8, 15, 13, 9),
            Block.box(2, 12, 7, 14, 13, 8),
            Block.box(2, 12, 8, 14, 13, 9),
            Block.box(1, 0, 1, 2, 6, 2),
            Block.box(1, 0, 14, 2, 6, 15),
            Block.box(14, 0, 14, 15, 6, 15),
            Block.box(14, 0, 1, 15, 6, 2),
            Block.box(2, 1, 2, 14, 1.5, 14),
            Block.box(2, 1.5, 2, 14, 6, 2.5),
            Block.box(2, 6, 0.5, 14, 6.5, 2.5),
            Block.box(2, 2, 0.5, 14, 6, 1),
            Block.box(2, 1.5, 13.5, 14, 6, 14),
            Block.box(2, 6, 13.5, 14, 6.5, 15.5),
            Block.box(2, 2, 15, 14, 6, 15.5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public BasketBlock(DyeColor color, Properties properties) {
        super(properties);
        this.color = color;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(CONDITIONAL, Boolean.FALSE));
        ShapeUtil.runCalculation(SHAPES, SHAPE);
    }

    @Nullable
    public DyeColor getColor() {
        return this.color;
    }

    @Override
    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, CONDITIONAL);
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        ItemStack heldStack = player.getItemInHand(InteractionHand.MAIN_HAND);
        BlockEntity blockEntity = level.getBlockEntity(pos);

        if (blockEntity instanceof BasketBlockEntity basketEntity) {
            ItemStackHandler inventory = basketEntity.getItems();

            if (!heldStack.isEmpty()) {
                if (!heldStack.is(TBATags.Items.BASKET_ITEMS)) {
                    return InteractionResult.FAIL;
                }
                else {
                    for (int i = 0; i < inventory.getSlots(); ++i) {
                        ItemStack basketSlot = inventory.getStackInSlot(i);
                        if (basketSlot.isEmpty() && heldStack.is(TBATags.Items.BASKET_ITEMS)) {
                            if (basketEntity.placeItems(player, heldStack)) {
                                state.setValue(BasketBlock.CONDITIONAL, true);
                                return InteractionResult.sidedSuccess(level.isClientSide);
                            }
                        }
                    }
                }
            }
            else {
                for (int i = 0; i < inventory.getSlots(); ++i) {
                    ItemStack basketSlot = inventory.getStackInSlot(i);
                    if (!basketSlot.isEmpty()) {
                        ItemStack basketStack = basketEntity.removeItems();
                        ItemStack receivedStack = new ItemStack(basketStack.copy().getItem());
                        player.playSound(SoundEvents.ITEM_FRAME_REMOVE_ITEM);
                        if (!player.addItem(receivedStack)) {
                            player.drop(receivedStack, false);
                        }
                        return InteractionResult.SUCCESS;
                    }
                    else {
                        state.setValue(BasketBlock.CONDITIONAL, false);
                    }
                }
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public void setPlacedBy(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable LivingEntity placer, @NotNull ItemStack stack) {
        if (stack.hasTag()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof BasketBlockEntity basketEntity) {
                basketEntity.loadFromItem(stack);
            }
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull ItemStack getCloneItemStack(@NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull BlockState state) {
        ItemStack stack = super.getCloneItemStack(getter, pos, state);
        BasketBlockEntity basketEntity = (BasketBlockEntity) getter.getBlockEntity(pos);
        if (basketEntity != null) {
            CompoundTag tag = basketEntity.writeItems(new CompoundTag());
            if (!tag.isEmpty()) {
                stack.addTagElement("BlockEntityTag", tag);
            }
        }
        return stack;
    }

    @Override
    public void playerWillDestroy(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Player player) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof BasketBlockEntity basketEntity) {
            if (!level.isClientSide) {
                ItemStack itemstack = new ItemStack(this);
                basketEntity.saveToItem(itemstack);

                ItemEntity itementity = new ItemEntity(level, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, itemstack);
                itementity.setDefaultPickUpDelay();
                level.addFreshEntity(itementity);
            }
            level.updateNeighbourForOutputSignal(pos, this);
        }
        super.playerWillDestroy(level, pos, state, player);
    }


    @Override
    @SuppressWarnings("deprecation")
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockentity = level.getBlockEntity(pos);
            if (blockentity instanceof BasketBlockEntity) {
                level.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull List<ItemStack> getDrops(@NotNull BlockState state, LootContext.@NotNull Builder builder) {
        List<ItemStack> drops = super.getDrops(state, builder);
        BlockEntity blockEntity = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);

        if (blockEntity instanceof BasketBlockEntity basketEntity) {
            ItemStack stack = new ItemStack(this);
            basketEntity.saveToItem(stack);

            drops.add(stack);
            drops.removeIf(itemStack -> itemStack.getItem() == this.asItem());
        }

        return drops;
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING,
                context.getHorizontalDirection().getOpposite());
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @SuppressWarnings("deprecation")
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull BlockState rotate(@NotNull BlockState state, @NotNull Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull BlockState mirror(@NotNull BlockState state, @NotNull Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new BasketBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, TBABlockEntities.BASKET_BLOCK_ENTITY.get(),
                BasketBlockEntity::tick);
    }

    public static void resetBlockState(@NotNull Level level, BlockPos pos, @NotNull BlockState state, boolean hasCondition) {
        level.setBlock(pos, state.setValue(BasketBlock.CONDITIONAL, hasCondition), 3);
    }

    @Override
    public void animateTick(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (state.getValue(BasketBlock.CONDITIONAL)) {
            double x = pos.getX() + 0.7D;
            double y = pos.getY() + 0.7D;
            double z = pos.getZ() + 0.7D;

            double v = random.triangle(0.0D, 0.5D);
            double v1 = random.triangle(0.0D, 0.1D);
            double v2 = random.triangle(0.0D, 0.5D);

            float scale = 0.5f;

            double xPos = x + v;
            double yPos = y - v1;
            double zPos = z - v2;

            double xSpeed = random.triangle(xPos / 2, xPos * 2);
            double ySpeed = random.triangle(yPos / 2, yPos * 2);
            double zSpeed = random.triangle(zPos / 2, zPos * 2);


            if (random.nextFloat() < 0.05F) {
                level.addParticle(new DustParticleOptions(
                                SeasonalParticleColors.getPrimarySeasonalParticleColor(), scale),
                        xPos, yPos, zPos, xSpeed, ySpeed, zSpeed);
                level.addParticle(
                        new DustParticleOptions(
                                SeasonalParticleColors.getSecondarySeasonalParticleColor(), scale),
                        xPos, yPos, zPos, xSpeed, ySpeed, zSpeed);
            }
        }
    }
}