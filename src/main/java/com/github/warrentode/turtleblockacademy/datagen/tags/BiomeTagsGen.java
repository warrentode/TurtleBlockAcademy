package com.github.warrentode.turtleblockacademy.datagen.tags;

import biomesoplenty.api.biome.BOPBiomes;
import com.github.warrentode.turtleblockacademy.util.TBATags;
import com.github.warrentode.turtleblockacademy.world.biome.TBABiomes;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class BiomeTagsGen extends BiomeTagsProvider {
    public BiomeTagsGen(DataGenerator generator, String modid, @Nullable ExistingFileHelper helper) {
        super(generator, modid, helper);
    }

    @Override
    protected void addTags() {
        tag(TBATags.Biomes.HAS_SKY_SLIME_POOLS)
                .add(TBABiomes.TBA_UNDERDEEP)
                .add(TBABiomes.TBA_AETHER_INCURSION);
        tag(TBATags.Biomes.HAS_ICHOR_SLIME_POOLS)
                .add(TBABiomes.TBA_NETHER_CORRUPTION);
        tag(TBATags.Biomes.HAS_ENDER_SLIME_POOLS)
                .add(TBABiomes.TBA_ENDER_EROSION);
        tag(TBATags.Biomes.HAS_SWET_POOLS)
                .add(TBABiomes.TBA_AETHER_INCURSION);
        tag(TBATags.Biomes.HAS_EARTH_SLIME_POOLS)
                .addTag(TBATags.Biomes.TBA_MINING_BIOMES);
        tag(TBATags.Biomes.HAS_CLAY_SLIME_POOLS)
                .add(TBABiomes.TBA_UNDERDEEP)
                .add(TBABiomes.TBA_SLIME_CAVES);
        tag(TBATags.Biomes.HAS_NETHER_FOSSIL)
                .add(TBABiomes.TBA_AETHER_INCURSION)
                .add(TBABiomes.TBA_ENDER_EROSION)
                .add(TBABiomes.TBA_NETHER_CORRUPTION)
                .add(TBABiomes.TBA_SLIME_CAVES);
        tag(TBATags.Biomes.HAS_CAMP_UNDERGROUND)
                .addTag(TBATags.Biomes.UNDERGROUND_BUT_NOT_DEEP_DARK);
        tag(TBATags.Biomes.TBA_MINING_BIOMES)
                .add(TBABiomes.TBA_UNDERDEEP)
                .add(TBABiomes.TBA_AETHER_INCURSION)
                .add(TBABiomes.TBA_ENDER_EROSION)
                .add(TBABiomes.TBA_NETHER_CORRUPTION)
                .add(TBABiomes.TBA_SLIME_CAVES);
        tag(TBATags.Biomes.UNDERGROUND_BUT_NOT_DEEP_DARK)
                .addTag(TBATags.Biomes.TBA_MINING_BIOMES)
                .add(Biomes.LUSH_CAVES)
                .add(Biomes.DRIPSTONE_CAVES)
                .addOptional(BOPBiomes.SPIDER_NEST.location())
                .addOptional(BOPBiomes.GLOWING_GROTTO.location());
        tag(TBATags.Biomes.IS_CAVE)
                .addTag(TBATags.Biomes.TBA_MINING_BIOMES)
                .add(Biomes.LUSH_CAVES)
                .add(Biomes.DRIPSTONE_CAVES)
                .add(Biomes.DEEP_DARK)
                .addOptional(BOPBiomes.SPIDER_NEST.location())
                .addOptional(BOPBiomes.GLOWING_GROTTO.location());
        tag(TBATags.Biomes.IS_UNDERGROUND)
                .addTag(TBATags.Biomes.IS_CAVE);
        tag(BiomeTags.HAS_MINESHAFT)
                .addTag(TBATags.Biomes.TBA_MINING_BIOMES);
    }
}
