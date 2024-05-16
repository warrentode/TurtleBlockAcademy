package com.github.warrentode.turtleblockacademy.world.dimension;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TBADimensions {
    private static final ResourceLocation TDA_MINING_ID =
            new ResourceLocation(MODID, "mining_dimension");

    public static final ResourceKey<DimensionType> TDA_MINING_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, TDA_MINING_ID);
    public static final ResourceKey<Level> TDA_MINING_LEVEL =
            ResourceKey.create(Registry.DIMENSION_REGISTRY, TDA_MINING_ID);
    public static final ResourceKey<LevelStem> TDA_MINING_STEM_KEY =
            ResourceKey.create(Registry.LEVEL_STEM_REGISTRY, TDA_MINING_ID);

    public TBADimensions() {}

    public static void register() {
        System.out.println("Registering Dimensions for " + MODID);
    }
}
