package com.github.warrentode.turtleblockacademy.blocks.furniture;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class TableBlock extends Block {
    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty WEST = BooleanProperty.create("west");

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public TableBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(NORTH, false).setValue(EAST, false)
                .setValue(SOUTH, false).setValue(WEST, false));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    @SuppressWarnings("ConstantValue")
    private @NotNull ImmutableMap<BlockState, VoxelShape> generateShapes(@NotNull ImmutableList<BlockState> states) {
        final VoxelShape TABLE = Stream.of(
                Block.box(0, 15, 0, 16, 16, 16),
                Block.box(5, 14.5, 5, 11, 15, 11),
                Block.box(6, 14, 6, 10, 14.5, 10),
                Block.box(7, 0, 7, 9, 14, 9)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
        final VoxelShape TABLE_CENTER = Block.box(0, 15, 0, 16, 16, 16);

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            boolean north = state.getValue(NORTH);
            boolean east = state.getValue(EAST);
            boolean south = state.getValue(SOUTH);
            boolean west = state.getValue(WEST);

            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(TABLE_CENTER);

            if (!north & !east && !south && !west) {
                shapes.add(TABLE);
            }
            else if (north && east && south && west) {
                shapes.add(TABLE_CENTER);
            }
            else if (!north && east && !south && west) {
                shapes.add(TABLE_CENTER);
            }
            else if (north && !east && south && !west) {
                shapes.add(TABLE_CENTER);
            }
            else if (!north && east && south && west) {
                shapes.add(TABLE_CENTER);
            }
            else if (north && !east && south && west) {
                shapes.add(TABLE_CENTER);
            }
            else if (north && east && !south && west) {
                shapes.add(TABLE_CENTER);
            }
            else if (north && east && south && !west) {
                shapes.add(TABLE_CENTER);
            }
            else if (north && !east && !south && west) {
                shapes.add(calculateShapes(Direction.NORTH, TABLE));
            }
            else if (north && east && !south && !west) {
                shapes.add(calculateShapes(Direction.EAST, TABLE));
            }
            else if (!north && east && south && !west) {
                shapes.add(calculateShapes(Direction.SOUTH, TABLE));
            }
            else if (!north && !east && south && west) {
                shapes.add(calculateShapes(Direction.WEST, TABLE));
            }
            else if (!north & !east && south && !west) {
                shapes.add(calculateShapes(Direction.SOUTH, TABLE));
            }
            else if (!north & !east && !south && west) {
                shapes.add(calculateShapes(Direction.WEST, TABLE));
            }
            else if (north & !east && !south && !west) {
                shapes.add(calculateShapes(Direction.NORTH, TABLE));
            }
            else if (!north & east && !south && !west) {
                shapes.add(calculateShapes(Direction.EAST, TABLE));
            }

            builder.put(state, combineAll(shapes));
        }
        return builder.build();
    }

    private @NotNull VoxelShape combineAll(@NotNull List<VoxelShape> shapes) {
        VoxelShape result = Shapes.empty();
        for (VoxelShape shape : shapes) {
            result = Shapes.joinUnoptimized(result, shape, BooleanOp.OR);
        }
        return result.optimize();
    }

    public static VoxelShape calculateShapes(@NotNull Direction to, VoxelShape shape) {
        final VoxelShape[] buffer = {shape, Shapes.empty()};

        final int times = (to.get2DDataValue() - Direction.NORTH.get2DDataValue() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = Shapes.or(buffer[1],
                    Shapes.create(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = Shapes.empty();
        }

        return buffer[0];
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter reader, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return Objects.requireNonNull(SHAPES.get(state));
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter reader, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return Objects.requireNonNull(SHAPES.get(state));
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction, @NotNull BlockState newState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos newPos) {
        boolean north = level.getBlockState(pos.north()).getBlock() == this;
        boolean east = level.getBlockState(pos.east()).getBlock() == this;
        boolean south = level.getBlockState(pos.south()).getBlock() == this;
        boolean west = level.getBlockState(pos.west()).getBlock() == this;

        return state.setValue(NORTH, north).setValue(EAST, east).setValue(SOUTH, south).setValue(WEST, west);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(NORTH);
        builder.add(EAST);
        builder.add(SOUTH);
        builder.add(WEST);
    }
}
