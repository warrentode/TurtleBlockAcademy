package com.github.warrentode.turtleblockacademy.commands;

import com.github.warrentode.turtleblockacademy.blocks.ModBlocks;
import com.github.warrentode.turtleblockacademy.items.ModItems;
import com.github.warrentode.turtleblockacademy.util.AcademyUtil;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.nbt.CompoundTag;
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
                                        .then(Commands.literal("awardCertificate")
                                                .executes(AcademyCommands::giveAwardCertificate))
                                )
                        ));
    }

    @SuppressWarnings("SameReturnValue")
    private static int giveStudentCard(@NotNull CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer serverPlayer = context.getSource().getPlayerOrException();

        ItemStack newCard = new ItemStack(ModItems.STUDENT_CARD.get());

        if (serverPlayer.getMainHandItem().isEmpty()) {
            serverPlayer.setItemInHand(InteractionHand.MAIN_HAND, addTags(serverPlayer, newCard));
        }
        else if (!serverPlayer.addItem(addTags(serverPlayer, newCard))) {
            serverPlayer.drop(addTags(serverPlayer, newCard), false);
        }

        return 0;
    }

    @SuppressWarnings("SameReturnValue")
    private static int giveAwardCertificate(@NotNull CommandContext<CommandSourceStack> context)
            throws CommandSyntaxException {
        ServerPlayer serverPlayer = context.getSource().getPlayerOrException();

        ItemStack newCertificate = new ItemStack(ModBlocks.CERTIFICATE_BLOCK.get().asItem());

        if (serverPlayer.getMainHandItem().isEmpty()) {
            serverPlayer.setItemInHand(InteractionHand.MAIN_HAND, addTags(serverPlayer, newCertificate));
        }
        else if (!serverPlayer.addItem(addTags(serverPlayer, newCertificate))) {
            serverPlayer.drop(addTags(serverPlayer, newCertificate), false);
        }

        return 0;
    }

    @Contract("_, _ -> param2")
    private static @NotNull ItemStack addTags(ServerPlayer serverPlayer, @NotNull ItemStack stack) {
        final CompoundTag tag = stack.getOrCreateTag();
        tag.putString(AcademyUtil.ACADEMIC_NAME_KEY, AcademyUtil.getAcademicStudent(serverPlayer));
        tag.putString(AcademyUtil.ACADEMIC_YEAR_KEY, AcademyUtil.getAcademicYear());
        return stack;
    }
}