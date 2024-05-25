package com.github.warrentode.turtleblockacademy.world.feature;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TBAPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, MODID);

    public static final RegistryObject<PlacedFeature> CLOVE_BUSH_PLACED =
            PLACED_FEATURES.register("clove_bush_placed",
            () -> new PlacedFeature(TBAConfiguredFeatures.PATCH_CLOVE_BUSH.getHolder().get(),
                    List.of(RarityFilter.onAverageOnceEvery(32),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> CUCUMBER_BUSH_PLACED =
            PLACED_FEATURES.register("cucumber_bush_placed",
                    () -> new PlacedFeature(TBAConfiguredFeatures.PATCH_CUCUMBER_BUSH.getHolder().get(),
                            List.of(RarityFilter.onAverageOnceEvery(32),
                                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP,
                                    BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> DILL_BUSH_PLACED =
            PLACED_FEATURES.register("dill_bush_placed",
                    () -> new PlacedFeature(TBAConfiguredFeatures.PATCH_DILL_BUSH.getHolder().get(),
                            List.of(RarityFilter.onAverageOnceEvery(32),
                                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP,
                                    BiomeFilter.biome())));

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
