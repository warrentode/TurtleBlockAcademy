package com.github.warrentode.turtleblockacademy.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.*;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AcademyConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<String> ACADEMIC_YEAR;
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> BIRTHDAYS;

    public static String academyYear;
    public static Set<String> birthdays;

    static {
        BUILDER.push("Config Settings for Turtle Block Academy");

        ACADEMIC_YEAR = BUILDER.comment("Academic Year")
                .define("Year", "2024-2025");

        BIRTHDAYS = BUILDER.comment("List of birthdays")
                .comment("A list of custom birthdays to celebrate. Default is the mod's birthday. Format: MM-DD")
                .defineList("birthdays", List.of("04-17"),
                        AcademyConfig::validateBirthday);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    public static String getConfigYear() {
        if (Objects.equals(ACADEMIC_YEAR.get(), ACADEMIC_YEAR.getDefault())) {
            return ACADEMIC_YEAR.getDefault();
        }
        else {
            return ACADEMIC_YEAR.get();
        }
    }

    private static boolean validateBirthday(Object value) {
        return value instanceof String;
    }

    public static List<? extends String> getBirthdays() {
        if (Objects.equals(BIRTHDAYS.get(), BIRTHDAYS.getDefault())) {
            return BIRTHDAYS.getDefault();
        }
        else {
            return BIRTHDAYS.get();
        }
    }
}