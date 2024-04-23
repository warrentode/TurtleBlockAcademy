package com.github.warrentode.turtleblockacademy.blocks;

import com.github.warrentode.turtleblockacademy.blocks.entity.SchoolDeskBlockEntity;
import com.github.warrentode.turtleblockacademy.util.PackTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.item.ILecternBookItem;
import vazkii.patchouli.api.PatchouliAPI;
import vazkii.patchouli.common.book.Book;
import vazkii.patchouli.common.util.ItemStackUtil;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class SchoolDeskBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty HAS_BOOK = BlockStateProperties.HAS_BOOK;

    private static final Map<Direction, VoxelShape> SHAPES = new EnumMap<>(Direction.class);

    public final static VoxelShape SHAPE = Stream.of(
            Block.box(0, 0, 3, 2, 14, 16),
            Block.box(14, 0, 3, 16, 14, 16),
            Block.box(0, 14, 0, 16, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape COLLISION_SHAPE = Shapes.or(SHAPE);

    public SchoolDeskBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(HAS_BOOK, Boolean.FALSE));
        runCalculation();
    }

    @Override
    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HAS_BOOK);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        Level level = context.getLevel();
        ItemStack stack = context.getItemInHand();
        Player player = context.getPlayer();
        boolean flag = false;
        if (!level.isClientSide && player != null && player.canUseGameMasterBlocks()) {
            CompoundTag tag = BlockItem.getBlockEntityData(stack);
            if (tag != null && tag.contains("Book")) {
                flag = true;
            }
        }

        return this.defaultBlockState().setValue(FACING,
                        context.getHorizontalDirection().getOpposite())
                .setValue(HAS_BOOK, flag);
    }

    protected void runCalculation() {
        for (Direction direction : Direction.values()) {
            SHAPES.put(direction, calculateShapes(direction, SchoolDeskBlock.SHAPE));
        }
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

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new SchoolDeskBlockEntity(pos, state);
    }

    public static boolean tryPlaceBook(@Nullable Player player, Level level, BlockPos pos, @NotNull BlockState state, ItemStack book) {
        if (!state.getValue(HAS_BOOK)) {
            if (!level.isClientSide) {
                placeBook(player, level, pos, state, book);
            }

            return true;
        }
        else {
            return false;
        }
    }

    private static void placeBook(@Nullable Player player, @NotNull Level level, BlockPos pos, BlockState state, ItemStack book) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof SchoolDeskBlockEntity schoolDeskBlockEntity) {
            schoolDeskBlockEntity.setBook(book.split(1));
            resetBookState(level, pos, state, true);
            level.playSound(null, pos, SoundEvents.BOOK_PUT, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
        }
    }

    public static void resetBookState(@NotNull Level level, BlockPos pos, @NotNull BlockState state, boolean hasBook) {
        level.setBlock(pos, state.setValue(HAS_BOOK, hasBook), 3);
    }

    public static void signalPageChange(@NotNull Level level, BlockPos pos, @NotNull BlockState state) {
        level.scheduleTick(pos, state.getBlock(), 2);
        level.levelEvent(1043, pos, 0);
    }

    @SuppressWarnings("deprecation")
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            if (state.getValue(HAS_BOOK)) {
                this.popBook(state, level, pos);
            }

            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    private void popBook(BlockState state, @NotNull Level level, BlockPos pos) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof SchoolDeskBlockEntity schoolDeskBlockEntity) {
            Direction direction = state.getValue(FACING);
            ItemStack book = schoolDeskBlockEntity.getBook().copy();
            float f = 0.25F * (float) direction.getStepX();
            float f1 = 0.25F * (float) direction.getStepZ();
            ItemEntity bookEntity = new ItemEntity(level, (double) pos.getX() + 0.5D + (double) f, pos.getY() + 1, (double) pos.getZ() + 0.5D + (double) f1, book);
            bookEntity.setDefaultPickUpDelay();
            level.addFreshEntity(bookEntity);
            schoolDeskBlockEntity.clearContent();
        }
    }

    @SuppressWarnings("deprecation")
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof SchoolDeskBlockEntity deskBlockEntity) {
            ItemStack bookInHand = player.getItemInHand(hand);
            ItemStack deskBook = deskBlockEntity.getBook();
            Book bookFromStack = ItemStackUtil.getBookFromStack(deskBlockEntity.getBook());
            if (state.getValue(HAS_BOOK)) {
                if (player.isSecondaryUseActive()) {
                    takeBook(player, deskBlockEntity);
                }
                else if (!level.isClientSide) {
                    if (bookFromStack != null) {
                        PatchouliAPI.get().openBookGUI((ServerPlayer) player, bookFromStack.id);

                        return InteractionResult.SUCCESS;
                    }
                    else if (deskBook.getItem() instanceof ILecternBookItem) {
                        ((ILecternBookItem) deskBook.getItem()).openLecternScreen(level, pos, player, deskBook);

                        return InteractionResult.SUCCESS;
                    }
                    else {
                        this.openScreen(level, pos, player);

                        return InteractionResult.sidedSuccess(level.isClientSide);
                    }
                }
            }
            else {
                if (!bookInHand.isEmpty() && bookInHand.is(PackTags.Items.LECTERN_BOOKS) && SchoolDeskBlock.tryPlaceBook(player, level, pos, state, bookInHand)) {
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }

    private void takeBook(@NotNull Player player, @NotNull SchoolDeskBlockEntity deskBlockEntity) {
        ItemStack book = deskBlockEntity.getBook();
        deskBlockEntity.setBook(ItemStack.EMPTY);
        SchoolDeskBlock.resetBookState(Objects.requireNonNull(deskBlockEntity.getLevel()), deskBlockEntity.getBlockPos(), deskBlockEntity.getBlockState(), false);
        if (!player.getInventory().add(book)) {
            player.drop(book, false);
        }
    }

    @Nullable
    public MenuProvider getMenuProvider(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos) {
        return !state.getValue(HAS_BOOK) ? null : super.getMenuProvider(state, level, pos);
    }

    private void openScreen(@NotNull Level level, BlockPos pos, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof SchoolDeskBlockEntity) {
            player.openMenu((SchoolDeskBlockEntity) blockEntity);
        }
    }
}