package com.github.warrentode.turtleblockacademy.world.feature;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TBAConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, MODID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> PATCH_CLOVE_BUSH =
            CONFIGURED_FEATURES.register("patch_clove_bush",
            () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH,
                    new RandomPatchConfiguration(32, 6, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(
                                    BlockStateProvider.simple(TBABlocks.CLOVE_BUSH.get()))))));

    public static final RegistryObject<ConfiguredFeature<?, ?>> PATCH_CUCUMBER_BUSH =
            CONFIGURED_FEATURES.register("patch_cucumber_bush",
                    () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH,
                            new RandomPatchConfiguration(32, 6, 2,
                                    PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                            new SimpleBlockConfiguration(
                                                    BlockStateProvider.simple(TBABlocks.CUCUMBER_BUSH.get()))))));

    public static final RegistryObject<ConfiguredFeature<?, ?>> PATCH_DILL_BUSH =
            CONFIGURED_FEATURES.register("patch_dill_bush",
                    () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH,
                            new RandomPatchConfiguration(32, 6, 2,
                                    PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                            new SimpleBlockConfiguration(
                                                    BlockStateProvider.simple(TBABlocks.DILL_BUSH.get()))))));

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
