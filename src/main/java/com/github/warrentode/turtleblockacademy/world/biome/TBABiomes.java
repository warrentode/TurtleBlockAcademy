package com.github.warrentode.turtleblockacademy.world.biome;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TBABiomes {
    public static final DeferredRegister<Biome> TBA_BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, MODID);

    public static final ResourceKey<Biome> TBA_UNDERDEEP = createKey("underdeep");
    public static final ResourceKey<Biome> TBA_NETHER_CORRUPTION = createKey("nether_corruption");
    public static final ResourceKey<Biome> TBA_ENDER_EROSION = createKey("ender_erosion");
    public static final ResourceKey<Biome> TBA_AETHER_INCURSION = createKey("aether_incursion");
    public static final ResourceKey<Biome> TBA_SLIME_CAVES = createKey("slime_caves");

    public TBABiomes() {}

    private static @NotNull ResourceKey<Biome> createKey(String name) {
        TBA_BIOMES.register(name, () -> new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.NONE)
                .downfall(0)
                .temperature(0)
                .specialEffects(new BiomeSpecialEffects.Builder().fogColor(0).waterColor(0).waterFogColor(0).skyColor(0).build())
                .generationSettings(new BiomeGenerationSettings.Builder().build())
                .mobSpawnSettings(new MobSpawnSettings.Builder().build())
                .temperatureAdjustment(Biome.TemperatureModifier.NONE)
                .build());
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(MODID, name));
    }
}