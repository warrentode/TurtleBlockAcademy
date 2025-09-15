package com.github.warrentode.turtleblockacademy.blocks.furniture;

import com.github.warrentode.turtleblockacademy.entity.SeatEntity;
import com.github.warrentode.turtleblockacademy.util.ShapeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class DeskChairBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    private static final Map<Direction, VoxelShape> SHAPES = new EnumMap<>(Direction.class);

    public final static VoxelShape SHAPE = Stream.of(
            Block.box(3, 6, 3, 13, 8, 13),
            Block.box(4, 8, 6, 12, 8.1, 12),
            Block.box(3, 0, 3, 5, 6, 5),
            Block.box(3, 0, 11, 5, 6, 13),
            Block.box(11, 0, 11, 13, 6, 13),
            Block.box(11, 0, 3, 13, 6, 5),
            Block.box(3, 11, 3, 13, 16, 5),
            Block.box(4, 12, 5, 12, 15, 5.1),
            Block.box(3, 8, 3, 5, 11, 5),
            Block.box(11, 8, 3, 13, 11, 5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape COLLISION_SHAPE = Shapes.or(SHAPE);
    private final DyeColor clothColor;
    public static final List<DeskChairBlock> DESK_CHAIR_LIST = new ArrayList<>();

    public DeskChairBlock(DyeColor color, Properties properties) {
        super(properties);
        this.clothColor = color;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH));
        ShapeUtil.runCalculation(SHAPES, SHAPE);

        DESK_CHAIR_LIST.add(this);
    }

    @Nullable
    public DyeColor getClothColor() {
        return this.clothColor;
    }

    public int getTintIndex() {
        DyeColor clothTint = this.clothColor;
        if (clothTint == null) {
            return DyeColor.WHITE.getFireworkColor();
        }
        return clothTint.getFireworkColor();
    }

    @Override
    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }

    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING,
                context.getHorizontalDirection().getOpposite());
    }

    @SuppressWarnings("deprecation")
    public @NotNull BlockState rotate(@NotNull BlockState state, @NotNull Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    public @NotNull BlockState mirror(@NotNull BlockState state, @NotNull Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @SuppressWarnings("deprecation")
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return COLLISION_SHAPE;
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        return SeatEntity.create(level, pos, 0.4, player, state.getValue(FACING));
    }
}