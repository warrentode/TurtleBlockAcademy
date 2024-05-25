package com.github.warrentode.turtleblockacademy.blocks;

import com.github.warrentode.turtleblockacademy.util.TBATags;
import com.github.warrentode.turtleblockacademy.world.dimension.TBADimensions;
import com.github.warrentode.turtleblockacademy.world.dimension.portal.TBAMiningTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Cancelable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TBAMiningPortalBlock extends Block {

    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected static final VoxelShape X_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    protected static final VoxelShape Z_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);

    public TBAMiningPortalBlock() {
        super(Properties.of(Material.PORTAL)
                .strength(-1F)
                .noCollission()
                .lightLevel((state) -> 10)
                .noLootTable()
        );
        registerDefaultState(stateDefinition.any().setValue(AXIS, Direction.Axis.X));
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        //noinspection EnhancedSwitchMigration
        switch (state.getValue(AXIS)) {
            case Z:
                return Z_AABB;
            case X:
            default:
                return X_AABB;
        }
    }

    public boolean trySpawnPortal(LevelAccessor accessor, BlockPos pos) {
        TBAMiningPortalBlock.Size size = this.isPortal(accessor, pos);
        if (size != null && !onTrySpawnPortal(accessor, pos, size)) {
            size.placePortalBlocks();
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean onTrySpawnPortal(LevelAccessor accessor, BlockPos pos, TBAMiningPortalBlock.Size size) {
        return MinecraftForge.EVENT_BUS.post(new PortalSpawnEvent(accessor, pos, accessor.getBlockState(pos), size));
    }

    @Cancelable
    public static class PortalSpawnEvent extends BlockEvent {
        private final TBAMiningPortalBlock.Size size;

        public PortalSpawnEvent(LevelAccessor accessor, BlockPos pos, BlockState state, TBAMiningPortalBlock.Size size) {
            super(accessor, pos, state);
            this.size = size;
        }

        public TBAMiningPortalBlock.Size getPortalSize() {
            return size;
        }
    }

    @org.jetbrains.annotations.Nullable
    public TBAMiningPortalBlock.Size isPortal(LevelAccessor accessor, BlockPos pos) {
        TBAMiningPortalBlock.Size size = new Size(accessor, pos, Direction.Axis.X);
        if (size.isValid() && size.portalBlockCount == 0) {
            return size;
        }
        else {
            TBAMiningPortalBlock.Size size1 = new Size(accessor, pos, Direction.Axis.Z);
            return size1.isValid() && size1.portalBlockCount == 0 ? size1 : null;
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull BlockState updateShape(@NotNull BlockState state, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor accessor, @NotNull BlockPos currentPos, @NotNull BlockPos facingPos) {
        Direction.Axis direction$axis = facing.getAxis();
        Direction.Axis direction$axis1 = state.getValue(AXIS);
        boolean flag = direction$axis1 != direction$axis && direction$axis.isHorizontal();
        return !flag && facingState.getBlock() != this && !(new Size(accessor, currentPos, direction$axis1)).validatePortal() ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, accessor, currentPos, facingPos);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void entityInside(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Entity entity) {
        if (!entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions()) {
            if (entity.isOnPortalCooldown()) {
                entity.setPortalCooldown();
            }
            else {
                if (!entity.level.isClientSide && !pos.equals(entity.portalEntrancePos)) {
                    entity.portalEntrancePos = pos.immutable();
                }
                Level level1 = entity.level;
                MinecraftServer minecraftserver = level1.getServer();
                ResourceKey<Level> destination = entity.level.dimension() == TBADimensions.TDA_MINING_LEVEL ? Level.OVERWORLD : TBADimensions.TDA_MINING_LEVEL;
                if (minecraftserver != null) {
                    ServerLevel destinationWorld = minecraftserver.getLevel(destination);
                    if (destinationWorld != null && minecraftserver.isNetherEnabled() && !entity.isPassenger()) {
                        entity.level.getProfiler().push("mining_portal");
                        entity.setPortalCooldown();
                        entity.changeDimension(destinationWorld, new TBAMiningTeleporter(destinationWorld));
                        entity.level.getProfiler().pop();
                    }
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (random.nextInt(100) == 0) {
            level.playLocalSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D,
                    SoundEvents.PORTAL_AMBIENT, SoundSource.BLOCKS, 0.5F,
                    random.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int i = 0; i < 4; ++i) {
            double x = (double) pos.getX() + random.nextDouble();
            double y = (double) pos.getY() + random.nextDouble();
            double z = (double) pos.getZ() + random.nextDouble();
            double xSpeed = ((double) random.nextFloat() - 0.5D) * 0.5D;
            double ySpeed = ((double) random.nextFloat() - 0.5D) * 0.5D;
            double zSpeed = ((double) random.nextFloat() - 0.5D) * 0.5D;
            int j = random.nextInt(2) * 2 - 1;
            if (!level.getBlockState(pos.west()).is(this) && !level.getBlockState(pos.east()).is(this)) {
                x = (double) pos.getX() + 0.5D + 0.25D * (double) j;
                xSpeed = random.nextFloat() * 2.0F * (float) j;
            }
            else {
                z = (double) pos.getZ() + 0.5D + 0.25D * (double) j;
                zSpeed = random.nextFloat() * 2.0F * (float) j;
            }

            level.addParticle(ParticleTypes.WHITE_ASH.getType(),
                    x, y, z, xSpeed, ySpeed, zSpeed);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull ItemStack getCloneItemStack(@NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull BlockState state) {
        return ItemStack.EMPTY;
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull BlockState rotate(@NotNull BlockState state, @NotNull Rotation rotation) {
        switch (rotation) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                //noinspection EnhancedSwitchMigration
                switch (state.getValue(AXIS)) {
                    case Z:
                        return state.setValue(AXIS, Direction.Axis.X);
                    case X:
                        return state.setValue(AXIS, Direction.Axis.Z);
                    default:
                        return state;
                }
            default:
                return state;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    public static class Size {
        private final LevelAccessor level;
        private final Direction.Axis axis;
        private final Direction rightDir;
        private final Direction leftDir;
        private int portalBlockCount;
        @Nullable
        private BlockPos bottomLeft;
        private int height;
        private int width;

        public Size(LevelAccessor level, BlockPos pos, Direction.Axis axis) {
            this.level = level;
            this.axis = axis;
            if (axis == Direction.Axis.X) {
                this.leftDir = Direction.EAST;
                this.rightDir = Direction.WEST;
            }
            else {
                this.leftDir = Direction.NORTH;
                this.rightDir = Direction.SOUTH;
            }

            //noinspection StatementWithEmptyBody
            for (BlockPos blockpos = pos; pos.getY() > blockpos.getY() - 21 && pos.getY() > 0 && this.canConnect(level.getBlockState(pos.below())); pos = pos.below()) {
            }

            int i = this.getDistanceUntilEdge(pos, this.leftDir) - 1;
            if (i >= 0) {
                this.bottomLeft = pos.relative(this.leftDir, i);
                this.width = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);
                if (this.width < 2 || this.width > 21) {
                    this.bottomLeft = null;
                    this.width = 0;
                }
            }

            if (this.bottomLeft != null) {
                this.height = this.calculatePortalHeight();
            }

        }

        protected int getDistanceUntilEdge(BlockPos pos, Direction directionIn) {
            int i;
            for (i = 0; i < 22; ++i) {
                BlockPos blockpos = pos.relative(directionIn, i);
                if (!this.canConnect(this.level.getBlockState(blockpos)) ||
                        !(this.level.getBlockState(blockpos.below()).is(TBATags.Blocks.TBA_MINING_PORTAL_FRAME_BLOCKS))) {
                    break;
                }
            }

            BlockPos framePos = pos.relative(directionIn, i);
            return this.level.getBlockState(framePos).is(TBATags.Blocks.TBA_MINING_PORTAL_FRAME_BLOCKS) ? i : 0;
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }

        protected int calculatePortalHeight() {
            label56:
            for (this.height = 0; this.height < 21; ++this.height) {
                for (int i = 0; i < this.width; ++i) {
                    if (this.bottomLeft != null) {
                        BlockPos blockPos = this.bottomLeft.relative(this.rightDir, i).above(this.height);
                        BlockState blockState = this.level.getBlockState(blockPos);
                        if (!this.canConnect(blockState)) {
                            break label56;
                        }

                        Block block = blockState.getBlock();
                        if (block == TBABlocks.TBA_MINING_PORTAL_BLOCK.get()) {
                            ++this.portalBlockCount;
                        }

                        if (i == 0) {
                            BlockPos framePos = blockPos.relative(this.leftDir);
                            if (!(this.level.getBlockState(framePos).is(TBATags.Blocks.TBA_MINING_PORTAL_FRAME_BLOCKS))) {
                                break label56;
                            }
                        }
                        else if (i == this.width - 1) {
                            BlockPos framePos = blockPos.relative(this.rightDir);
                            if (!(this.level.getBlockState(framePos).is(TBATags.Blocks.TBA_MINING_PORTAL_FRAME_BLOCKS))) {
                                break label56;
                            }
                        }
                    }
                }
            }

            for (int j = 0; j < this.width; ++j) {
                if (this.bottomLeft != null) {
                    BlockPos framePos = this.bottomLeft.relative(this.rightDir, j).above(this.height);
                    if (!(this.level.getBlockState(framePos).is(TBATags.Blocks.TBA_MINING_PORTAL_FRAME_BLOCKS))) {
                        this.height = 0;
                        break;
                    }
                }
            }

            if (this.height <= 21 && this.height >= 3) {
                return this.height;
            }
            else {
                this.bottomLeft = null;
                this.width = 0;
                this.height = 0;
                return 0;
            }
        }

        protected boolean canConnect(@NotNull BlockState pos) {
            Block block = pos.getBlock();
            return pos.isAir() || block == TBABlocks.TBA_MINING_PORTAL_BLOCK.get();
        }

        public boolean isValid() {
            return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
        }

        public void placePortalBlocks() {
            for (int i = 0; i < this.width; ++i) {
                if (this.bottomLeft != null) {
                    BlockPos blockpos = this.bottomLeft.relative(this.rightDir, i);

                    for (int j = 0; j < this.height; ++j) {
                        this.level.setBlock(blockpos.above(j),
                                TBABlocks.TBA_MINING_PORTAL_BLOCK.get().defaultBlockState()
                                        .setValue(TBAMiningPortalBlock.AXIS, this.axis), 18);
                    }
                }
            }
        }

        private boolean isPortalCountValidForSize() {
            return this.portalBlockCount >= this.width * this.height;
        }

        public boolean validatePortal() {
            return this.isValid() && this.isPortalCountValidForSize();
        }
    }
}