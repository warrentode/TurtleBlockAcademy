package com.github.warrentode.turtleblockacademy.util;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class PlayerUtil {
    public static final String PLAYER_NAME_TAG = MODID + ":" + "playerNameTag";

    @Nullable
    public static Player getPlayerEntityByName(@NotNull ServerLevel serverLevel, String name) {
        return serverLevel.players().stream().filter(player -> player.getName().getString().equals(name)).findFirst().orElse(null);
    }
}