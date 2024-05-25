package com.github.warrentode.turtleblockacademy.items;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.blocks.TBAMiningPortalBlock;
import com.github.warrentode.turtleblockacademy.util.AcademyUtil;
import com.github.warrentode.turtleblockacademy.world.dimension.TBADimensions;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class StudentCard extends Item {
    public StudentCard(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
        Player player = context.getPlayer();

        if (player != null) {
            Level level = player.getLevel();
            if (level.dimension() == TBADimensions.TDA_MINING_LEVEL || level.dimension() == Level.OVERWORLD) {
                for (Direction direction : Direction.Plane.VERTICAL) {
                    BlockPos framePos = context.getClickedPos().relative(direction);
                    if (((TBAMiningPortalBlock) TBABlocks.TBA_MINING_PORTAL_BLOCK.get()).trySpawnPortal(context.getLevel(), framePos)) {
                        context.getLevel().playSound(context.getPlayer(), framePos,
                                SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS,
                                1.0F, 1.0F);
                        return InteractionResult.CONSUME;
                    }
                    else return InteractionResult.FAIL;
                }
            }
        }
        return InteractionResult.FAIL;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player playerUsing, @NotNull InteractionHand useHand) {
        ItemStack stack = playerUsing.getItemInHand(useHand);

        if (!level.isClientSide
                && (stack.getTag() == null || stack.getTag().getString(AcademyUtil.ACADEMIC_NAME_KEY).isEmpty())
                || (stack.getTag() == null || stack.getTag().getString(AcademyUtil.ACADEMIC_YEAR_KEY).isEmpty())) {
            final CompoundTag itemTag = stack.getOrCreateTag();
            itemTag.putString(AcademyUtil.ACADEMIC_NAME_KEY, AcademyUtil.getAcademicStudent(playerUsing));
            itemTag.putString(AcademyUtil.ACADEMIC_YEAR_KEY, AcademyUtil.getAcademicYear());

            stack.setHoverName(Component.literal(AcademyUtil.getAcademicStudent(playerUsing)
                    + " " + AcademyUtil.getAcademicYear()));

            if (!level.isClientSide) {
                playerUsing.sendSystemMessage(Component.translatable("message." + MODID + ".registered")
                        .withStyle(ChatFormatting.GOLD));
            }

            return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
        }
        // item use fails if all checks above fail
        return new InteractionResultHolder<>(InteractionResult.FAIL, stack);

    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltips, @NotNull TooltipFlag tooltipFlag) {
        if (stack.getTag() != null && !stack.getTag().getString(AcademyUtil.ACADEMIC_NAME_KEY).isEmpty() && !stack.getTag().getString(AcademyUtil.ACADEMIC_YEAR_KEY).isEmpty()) {
            if (Screen.hasShiftDown()) {
                String academicNameTag = stack.getTag().getString(AcademyUtil.ACADEMIC_NAME_KEY);
                String academicYearTag = stack.getTag().getString(AcademyUtil.ACADEMIC_YEAR_KEY);
                tooltips.add(Component.literal(academicNameTag + "'s" + " " + academicYearTag + " ")
                        .append(Component.translatable(stack.getDescriptionId()))
                        .withStyle(ChatFormatting.GOLD));
            }
        }
        else {
            tooltips.add(Component.translatable("tooltips.turtleblockacademy.student_card_blank").withStyle(ChatFormatting.GRAY));
        }
    }
}
