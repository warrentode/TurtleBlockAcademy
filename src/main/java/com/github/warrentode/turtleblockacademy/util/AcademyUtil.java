package com.github.warrentode.turtleblockacademy.util;

import com.github.warrentode.turtleblockacademy.config.AcademyConfig;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class AcademyUtil {
    public static final String ACADEMIC_NAME_KEY = "academic_student";
    public static final String ACADEMIC_YEAR_KEY = "academic_year";
    public static final String ACADEMIC_SUBJECT_KEY = "academic_subject";

    public static String getAcademicStudent(@NotNull Player player) {
        return player.getGameProfile().getName();
    }

    public static String getAcademicYear() {
        return AcademyConfig.getConfigYear();
    }
}