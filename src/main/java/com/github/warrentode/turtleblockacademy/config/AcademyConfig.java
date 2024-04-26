package com.github.warrentode.turtleblockacademy.config;

import com.github.warrentode.turtleblockacademy.TurtleBlockAcademy;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = TurtleBlockAcademy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AcademyConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<String> ACADEMIC_YEAR;

    static {
        BUILDER.push("Config Settings for Turtle Block Academy");

        ACADEMIC_YEAR = BUILDER.comment("Academic Year")
                .define("Year", "2024-2025");

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
}