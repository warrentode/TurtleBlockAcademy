package com.github.warrentode.turtleblockacademy.commands;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.items.TBAItems;
import com.github.warrentode.turtleblockacademy.util.AcademyUtil;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class AcademyCommands {
    public static void register(@NotNull CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("academy")
                        .requires((commandSourceStack -> commandSourceStack.hasPermission(2)))
                        .then(Commands.literal("give")
                                .then(Commands.argument("targets", EntityArgument.players())
                                        .then(Commands.literal("studentCard")
                                                .executes(AcademyCommands::giveStudentCard))
                                        .then(Commands.literal("awardGenericCertificate")
                                                .executes(AcademyCommands::giveAwardGenericCertificate))
                                        .then(Commands.literal("awardKitchenCertificate")
                                                .executes(AcademyCommands::giveAwardKitchenCertificate))
                                )
                        ));
    }

    @SuppressWarnings("SameReturnValue")
    private static int giveStudentCard(@NotNull CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer serverPlayer = context.getSource().getPlayerOrException();

        ItemStack newCard = new ItemStack(TBAItems.STUDENT_CARD.get());

        if (serverPlayer.getMainHandItem().isEmpty()) {
            serverPlayer.setItemInHand(InteractionHand.MAIN_HAND, addBasicTags(serverPlayer, newCard));
        }
        else if (!serverPlayer.addItem(addBasicTags(serverPlayer, newCard))) {
            serverPlayer.drop(addBasicTags(serverPlayer, newCard), false);
        }

        return 0;
    }

    @SuppressWarnings("SameReturnValue")
    private static int giveAwardGenericCertificate(@NotNull CommandContext<CommandSourceStack> context)
            throws CommandSyntaxException {
        ServerPlayer serverPlayer = context.getSource().getPlayerOrException();

        ItemStack newCertificate = new ItemStack(TBABlocks.CERTIFICATE_BLOCK.get().asItem());

        if (serverPlayer.getMainHandItem().isEmpty()) {
            serverPlayer.setItemInHand(InteractionHand.MAIN_HAND, addBasicTags(serverPlayer, newCertificate));
        }
        else if (!serverPlayer.addItem(addBasicTags(serverPlayer, newCertificate))) {
            serverPlayer.drop(addBasicTags(serverPlayer, newCertificate), false);
        }

        return 0;
    }

    @SuppressWarnings("SameReturnValue")
    private static int giveAwardKitchenCertificate(@NotNull CommandContext<CommandSourceStack> context)
            throws CommandSyntaxException {
        ServerPlayer serverPlayer = context.getSource().getPlayerOrException();

        ItemStack newCertificate = new ItemStack(TBABlocks.CERTIFICATE_BLOCK.get().asItem());

        if (serverPlayer.getMainHandItem().isEmpty()) {
            serverPlayer.setItemInHand(InteractionHand.MAIN_HAND, addKitchenTags(serverPlayer, newCertificate));
        }
        else if (!serverPlayer.addItem(addKitchenTags(serverPlayer, newCertificate))) {
            serverPlayer.drop(addKitchenTags(serverPlayer, newCertificate), false);
        }

        return 0;
    }

    @Contract("_, _ -> param2")
    private static @NotNull ItemStack addBasicTags(ServerPlayer serverPlayer, @NotNull ItemStack stack) {
        final CompoundTag tag = stack.getOrCreateTag();
        tag.putString(AcademyUtil.ACADEMIC_NAME_KEY, AcademyUtil.getAcademicStudent(serverPlayer));
        tag.putString(AcademyUtil.ACADEMIC_YEAR_KEY, AcademyUtil.getAcademicYear());

        stack.setHoverName(Component.literal(AcademyUtil.getAcademicStudent(serverPlayer)
                + " " + AcademyUtil.getAcademicYear()));

        return stack;
    }

    private static @NotNull ItemStack addKitchenTags(ServerPlayer serverPlayer, @NotNull ItemStack stack) {
        final CompoundTag tag = stack.getOrCreateTag();
        tag.putString(AcademyUtil.ACADEMIC_SUBJECT_KEY, "Kitchen Unit Study");
        tag.putString(AcademyUtil.ACADEMIC_NAME_KEY, AcademyUtil.getAcademicStudent(serverPlayer));
        tag.putString(AcademyUtil.ACADEMIC_YEAR_KEY, AcademyUtil.getAcademicYear());

        stack.setHoverName(Component.literal(AcademyUtil.getAcademicStudent(serverPlayer) + "'s "
                + AcademyUtil.getAcademicYear() + " Kitchen Unit Study ").append(Component.translatable(stack.getDescriptionId())));

        return stack;
    }
}