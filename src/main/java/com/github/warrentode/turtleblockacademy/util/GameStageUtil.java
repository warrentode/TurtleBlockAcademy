package com.github.warrentode.turtleblockacademy.util;

import net.darkhax.gamestages.GameStageHelper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.server.ServerLifecycleHooks;

public class GameStageUtil {

    public static boolean check(String stage) {
        if (ModList.get().isLoaded("gamestages")) {
            MinecraftServer minecraftServer = ServerLifecycleHooks.getCurrentServer().getPlayerList().getServer();
            //noinspection ConstantValue
            if (minecraftServer != null) {
                ServerPlayer player = minecraftServer.createCommandSourceStack().getPlayer();
                return GameStageHelper.hasStage(player, stage);
            }
        }
        return false;
    }
}
