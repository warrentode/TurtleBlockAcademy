package com.github.warrentode.turtleblockacademy.blocks;

import com.github.warrentode.turtleblockacademy.blocks.entity.FermentingPotBlockEntity;
import com.github.warrentode.turtleblockacademy.blocks.entity.TBABlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
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
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FermentingPotBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final Property<Boolean> HAS_PICKLING_STONE = BooleanProperty.create("has_pickling_stone");
    public static final Property<Boolean> HAS_CLOTH_COVER = BooleanProperty.create("has_cloth_cover");

    private static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 10, 15);

    protected FermentingPotBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(HAS_PICKLING_STONE, Boolean.FALSE)
                .setValue(HAS_CLOTH_COVER, Boolean.FALSE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(FACING, HAS_PICKLING_STONE, HAS_CLOTH_COVER);
    }

    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @SuppressWarnings("deprecation")
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        if (!level.isClientSide) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof FermentingPotBlockEntity potBlockEntity) {
                NetworkHooks.openScreen((ServerPlayer) player, potBlockEntity, pos);
            }

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.SUCCESS;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof FermentingPotBlockEntity) {
                ((FermentingPotBlockEntity) blockEntity).drops();
                level.updateNeighbourForOutputSignal(pos, this);
            }

            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @SuppressWarnings("deprecation")
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @SuppressWarnings("deprecation")
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    @SuppressWarnings("deprecation")
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull BlockState rotate(@NotNull BlockState state, @NotNull Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull BlockState mirror(@NotNull BlockState state, @NotNull Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    public void setPlacedBy(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable LivingEntity placer, @NotNull ItemStack stack) {
        if (stack.hasCustomHoverName()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof FermentingPotBlockEntity) {
                ((FermentingPotBlockEntity) blockEntity).setCustomName(stack.getHoverName());
            }
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return ((BlockEntityType<?>) TBABlockEntities.FERMENTING_POT_ENTITY.get()).create(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, TBABlockEntities.FERMENTING_POT_ENTITY.get(),
                FermentingPotBlockEntity::tick);
    }

    public static void resetPicklingStoneState(@NotNull Level level, BlockPos pos, @NotNull BlockState state, boolean hasPicklingStone) {
        level.setBlock(pos, state.setValue(HAS_PICKLING_STONE, hasPicklingStone), 3);
    }

    public static void resetClothCoverState(@NotNull Level level, BlockPos pos, @NotNull BlockState state, boolean hasClothCover) {
        level.setBlock(pos, state.setValue(HAS_CLOTH_COVER, hasClothCover), 3);
    }

    @Override
    public void animateTick(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (state.getValue(HAS_PICKLING_STONE) || state.getValue(HAS_CLOTH_COVER)) {
            double x = pos.getX() + 0.5D;
            double y = pos.getY() + 0.85D;
            double z = pos.getZ() + 0.5D;

            double v = random.triangle(0.0D, 0.5D);
            double v1 = random.triangle(0.0D, 0.1D);
            double v2 = random.triangle(0.0D, 0.5D);

            if (random.nextFloat() < 0.5F) {
                level.playLocalSound(x, y, z, SoundEvents.BUBBLE_COLUMN_BUBBLE_POP, SoundSource.BLOCKS, 0.25F, random.nextFloat() * 0.2F + 0.9F, true);
                level.addParticle(ParticleTypes.BUBBLE, x + v, y + v1, z + v2, 0.0D, 0.0D, 0.0D);
                level.addParticle(ParticleTypes.BUBBLE, x, y, z, 0.0D, 0.0D, 0.0D);
            }
        }
    }
}
