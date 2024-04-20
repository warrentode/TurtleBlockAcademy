package com.github.warrentode.turtleblockacademy.util;

import com.github.warrentode.turtleblockacademy.config.AcademyConfig;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class AcademyUtil {
    public static String ACADEMIC_NAME_KEY = "academic_student";
    public static String ACADEMIC_YEAR_KEY = "academic_year";
    public static String nameValue;
    public static String yearValue;

    public static String getAcademicStudent(@NotNull Player player) {
        return player.getGameProfile().getName();
    }

    public static String getAcademicYear() {
        return AcademyConfig.getConfigYear();
    }
}