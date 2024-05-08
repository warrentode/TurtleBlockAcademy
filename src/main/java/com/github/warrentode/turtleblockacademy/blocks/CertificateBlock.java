package com.github.warrentode.turtleblockacademy.blocks;

import com.github.warrentode.turtleblockacademy.TurtleBlockAcademy;
import com.github.warrentode.turtleblockacademy.util.AcademyUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CertificateBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public final static VoxelShape NORTH_SHAPE = Block.box(2, 0, 15, 14, 16, 16);
    public final static VoxelShape SOUTH_SHAPE = calculateShapes(Direction.SOUTH, NORTH_SHAPE);
    public final static VoxelShape EAST_SHAPE = calculateShapes(Direction.EAST, NORTH_SHAPE);
    public final static VoxelShape WEST_SHAPE = calculateShapes(Direction.WEST, NORTH_SHAPE);

    public CertificateBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter,
                                        @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> NORTH_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case EAST -> EAST_SHAPE;
            default -> WEST_SHAPE;
        };
    }

    @Override
    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction, @NotNull BlockState state1, @NotNull LevelAccessor accessor, @NotNull BlockPos pos, @NotNull BlockPos pos1) {
        Direction direction1 = state.getValue(FACING);
        if (direction.getOpposite() != direction1 && state1.getMaterial().isSolid()
                || direction.getAxis().isHorizontal() || DiodeBlock.isDiode(state)) {
            return super.updateShape(state, direction, state1, accessor, pos, pos1);
        }
        else if (state1 == Blocks.AIR.defaultBlockState() || state1 == Blocks.WATER.defaultBlockState()) {
            accessor.playSound(null, pos, TurtleBlockAcademy.CERTIFICATE.getBreakSound(),
                    SoundSource.BLOCKS, 1.0F, 1.0F);
            this.dropSelf(state.getBlock().asItem().getDefaultInstance());
        }
        return state;
    }

    @SuppressWarnings("deprecation")
    public @NotNull BlockState rotate(@NotNull BlockState state, @NotNull Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    public @NotNull BlockState mirror(@NotNull BlockState state, @NotNull Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    private void dropSelf(ItemStack ignoredStack) {
        new ItemStack(ModBlockRegistry.CERTIFICATE_BLOCK.get().asItem());
    }

    public static VoxelShape calculateShapes(Direction to, VoxelShape shape) {
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

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter getter, @NotNull List<Component> tooltips, @NotNull TooltipFlag flag) {
        if (stack.getTag() != null && !stack.getTag().getString(AcademyUtil.ACADEMIC_NAME_KEY).isEmpty()
                && !stack.getTag().getString(AcademyUtil.ACADEMIC_YEAR_KEY).isEmpty()
                && stack.getTag().getString(AcademyUtil.ACADEMIC_SUBJECT_KEY).isEmpty()) {
            String academicNameTag = stack.getTag().getString(AcademyUtil.ACADEMIC_NAME_KEY);
            String academicYearTag = stack.getTag().getString(AcademyUtil.ACADEMIC_YEAR_KEY);
            tooltips.add(Component.literal(academicNameTag + " " + academicYearTag)
                    .withStyle(ChatFormatting.GOLD).withStyle(ChatFormatting.BOLD));
        }
        else if (stack.getTag() != null && !stack.getTag().getString(AcademyUtil.ACADEMIC_NAME_KEY).isEmpty()
                && !stack.getTag().getString(AcademyUtil.ACADEMIC_YEAR_KEY).isEmpty()
                && !stack.getTag().getString(AcademyUtil.ACADEMIC_SUBJECT_KEY).isEmpty()) {
            String academicSubjectTag = stack.getTag().getString(AcademyUtil.ACADEMIC_SUBJECT_KEY);
            String academicNameTag = stack.getTag().getString(AcademyUtil.ACADEMIC_NAME_KEY);
            String academicYearTag = stack.getTag().getString(AcademyUtil.ACADEMIC_YEAR_KEY);
            tooltips.add(Component.literal(academicSubjectTag + " " + academicNameTag + " " + academicYearTag)
                    .withStyle(ChatFormatting.GOLD).withStyle(ChatFormatting.BOLD));
        }
        else {
            tooltips.add(Component.translatable("tooltips.turtleblockacademy.certificate_blank").withStyle(ChatFormatting.GRAY));
        }
    }
}