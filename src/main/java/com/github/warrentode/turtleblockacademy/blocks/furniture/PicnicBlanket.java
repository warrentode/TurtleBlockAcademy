package com.github.warrentode.turtleblockacademy.blocks.furniture;

import com.github.warrentode.turtleblockacademy.entity.SeatEntity;
import com.github.warrentode.turtleblockacademy.util.SeasonalParticleColors;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PicnicBlanket extends Block {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
    private final DyeColor clothColor;
    public static final List<PicnicBlanket> PICNIC_BLANKET_LIST = new ArrayList<>();

    public PicnicBlanket(DyeColor clothColor, Properties properties) {
        super(properties);
        this.clothColor = clothColor;

        PICNIC_BLANKET_LIST.add(this);
    }

    public DyeColor getClothColor(ItemStack stack) {
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
    @SuppressWarnings("deprecation")
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction, @NotNull BlockState newState, @NotNull LevelAccessor accessor, @NotNull BlockPos pos, @NotNull BlockPos newPos) {
        return !state.canSurvive(accessor, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, newState, accessor, pos, newPos);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader reader, @NotNull BlockPos pos) {
        return !reader.isEmptyBlock(pos.below());
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        return SeatEntity.create(level, pos, 0, player, player.getDirection());
    }

    @Override
    public void animateTick(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        SeasonalParticleColors.eventCheck();

        double x = pos.getX() + 0.7D;
        double y = pos.getY() + 0.1D;
        double z = pos.getZ() + 0.7D;

        double v = random.triangle(0.0D, 0.5D);
        double v1 = random.triangle(0.0D, 0.1D);
        double v2 = random.triangle(0.0D, 0.5D);

        float scale = 0.5f;

        double xPos = x + v;
        double yPos = y - v1;
        double zPos = z - v2;

        double xPos1 = xPos + v;
        double yPos1 = yPos - v1;
        double zPos1 = zPos - v2;

        double xSpeed = random.triangle(xPos / 2, xPos * 2);
        double ySpeed = random.triangle(yPos / 2, yPos * 2);
        double zSpeed = random.triangle(zPos / 2, zPos * 2);

        double xSpeed1 = random.triangle(xSpeed / 2, xSpeed * 2);
        double ySpeed1 = random.triangle(ySpeed / 2, ySpeed * 2);
        double zSpeed1 = random.triangle(zSpeed / 2, zSpeed * 2);

        if (random.nextFloat() < 0.05F) {
            level.addParticle(new DustParticleOptions(
                            SeasonalParticleColors.getPrimarySeasonalParticleColor(), scale),
                    xPos, yPos, zPos, xSpeed, ySpeed, zSpeed);
            level.addParticle(
                    new DustParticleOptions(
                            SeasonalParticleColors.getSecondarySeasonalParticleColor(), scale),
                    xPos1, yPos1, zPos1, xSpeed1, ySpeed1, zSpeed1);
        }
    }
}