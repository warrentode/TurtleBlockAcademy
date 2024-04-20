package com.github.warrentode.turtleblockacademy.datagen.tags;

import com.aetherteam.aether.data.resources.registries.AetherBiomes;
import com.catastrophe573.dimdungeons.DimDungeons;
import com.github.warrentode.turtleblockacademy.util.PackTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class BiomeTagGen extends BiomeTagsProvider {
    public BiomeTagGen(DataGenerator pGenerator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.registerPackTags();
    }

    protected void registerPackTags() {
        tag(PackTags.Biomes.IS_THE_VOID)
                .addOptional(DimDungeons.DUNGEON_DIMENSION.location())
                .addOptional(DimDungeons.BUILD_DIMENSION.location());
        tag(PackTags.Biomes.IS_OVERWORLD)
                .addTag(Tags.Biomes.IS_COLD_OVERWORLD)
                .addTag(Tags.Biomes.IS_DENSE_OVERWORLD)
                .addTag(Tags.Biomes.IS_DRY_OVERWORLD)
                .addTag(Tags.Biomes.IS_HOT_OVERWORLD)
                .addTag(Tags.Biomes.IS_WET_OVERWORLD)
                .addTag(Tags.Biomes.IS_SPARSE_OVERWORLD);
        tag(PackTags.Biomes.IS_NETHER)
                .addTag(Tags.Biomes.IS_DRY_NETHER)
                .addTag(Tags.Biomes.IS_HOT_NETHER)
                .addOptionalTag(Tags.Biomes.IS_COLD_NETHER.location())
                .addOptionalTag(Tags.Biomes.IS_DENSE_NETHER.location())
                .addOptionalTag(Tags.Biomes.IS_WET_NETHER.location())
                .addOptionalTag(Tags.Biomes.IS_SPARSE_NETHER.location());
        tag(PackTags.Biomes.IS_END)
                .addTag(Tags.Biomes.IS_COLD_END)
                .addTag(Tags.Biomes.IS_DRY_END)
                .addOptionalTag(Tags.Biomes.IS_DENSE_END.location())
                .addOptionalTag(Tags.Biomes.IS_HOT_END.location())
                .addOptionalTag(Tags.Biomes.IS_WET_END.location())
                .addOptionalTag(Tags.Biomes.IS_SPARSE_END.location());
        tag(PackTags.Biomes.IS_AETHER)
                .addOptional(AetherBiomes.SKYROOT_MEADOW.location())
                .addOptional(AetherBiomes.SKYROOT_GROVE.location())
                .addOptional(AetherBiomes.SKYROOT_WOODLAND.location())
                .addOptional(AetherBiomes.SKYROOT_FOREST.location());
        tag(PackTags.Biomes.IS_UNDERGROUND)
                .addTag(Tags.Biomes.IS_CAVE);
    }
}