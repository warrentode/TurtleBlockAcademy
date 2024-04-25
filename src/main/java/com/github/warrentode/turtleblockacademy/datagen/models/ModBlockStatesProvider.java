package com.github.warrentode.turtleblockacademy.datagen.models;

import com.github.warrentode.turtleblockacademy.blocks.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class ModBlockStatesProvider extends BlockStateProvider {
    private static final int DEFAULT_ANGLE_OFFSET = 180;

    public ModBlockStatesProvider(DataGenerator generator, String ignoredModid, ExistingFileHelper helper) {
        super(generator, MODID, helper);
    }

    private @NotNull String blockName(Block block) {
        return Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
    }

    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation(MODID, "block/" + path);
    }

    public ModelFile existingModel(Block block) {
        return new ModelFile.ExistingModelFile(resourceBlock(blockName(block)), models().existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        horizontalBlock(ModBlocks.CERTIFICATE_BLOCK.get(), existingModel(ModBlocks.CERTIFICATE_BLOCK.get()));

        threeTextureHorizontalVariant(ModBlocks.DESK_CHAIR_ACACIA.get(),
                "block/desk_chair",
                Blocks.ACACIA_PLANKS,
                Blocks.STRIPPED_ACACIA_LOG,
                Blocks.ACACIA_LOG);
        threeTextureHorizontalVariant(ModBlocks.DESK_CHAIR_BIRCH.get(),
                "block/desk_chair",
                Blocks.BIRCH_PLANKS,
                Blocks.STRIPPED_BIRCH_LOG,
                Blocks.BIRCH_LOG);
        threeTextureHorizontalVariant(ModBlocks.DESK_CHAIR_CRIMSON.get(),
                "block/desk_chair",
                Blocks.CRIMSON_PLANKS,
                Blocks.STRIPPED_CRIMSON_STEM,
                Blocks.CRIMSON_STEM);
        threeTextureHorizontalVariant(ModBlocks.DESK_CHAIR_DARK_OAK.get(),
                "block/desk_chair",
                Blocks.DARK_OAK_PLANKS,
                Blocks.STRIPPED_DARK_OAK_LOG,
                Blocks.DARK_OAK_LOG);
        threeTextureHorizontalVariant(ModBlocks.DESK_CHAIR_JUNGLE.get(),
                "block/desk_chair",
                Blocks.JUNGLE_PLANKS,
                Blocks.STRIPPED_JUNGLE_LOG,
                Blocks.JUNGLE_LOG);
        threeTextureHorizontalVariant(ModBlocks.DESK_CHAIR_MANGROVE.get(),
                "block/desk_chair",
                Blocks.MANGROVE_PLANKS,
                Blocks.STRIPPED_MANGROVE_LOG,
                Blocks.MANGROVE_LOG);
        threeTextureHorizontalVariant(ModBlocks.DESK_CHAIR_OAK.get(),
                "block/desk_chair",
                Blocks.OAK_PLANKS,
                Blocks.STRIPPED_OAK_LOG,
                Blocks.OAK_LOG);
        threeTextureHorizontalVariant(ModBlocks.DESK_CHAIR_SPRUCE.get(),
                "block/desk_chair",
                Blocks.SPRUCE_PLANKS,
                Blocks.STRIPPED_SPRUCE_LOG,
                Blocks.SPRUCE_LOG);
        threeTextureHorizontalVariant(ModBlocks.DESK_CHAIR_WARPED.get(),
                "block/locker",
                Blocks.WARPED_PLANKS,
                Blocks.STRIPPED_WARPED_STEM,
                Blocks.WARPED_STEM);

        threeTextureHorizontalVariant(ModBlocks.LOCKER_ACACIA.get(),
                "block/locker",
                Blocks.ACACIA_PLANKS,
                Blocks.STRIPPED_ACACIA_LOG,
                Blocks.ACACIA_LOG);
        threeTextureHorizontalVariant(ModBlocks.LOCKER_BIRCH.get(),
                "block/locker",
                Blocks.BIRCH_PLANKS,
                Blocks.STRIPPED_BIRCH_LOG,
                Blocks.BIRCH_LOG);
        threeTextureHorizontalVariant(ModBlocks.LOCKER_CRIMSON.get(),
                "block/locker",
                Blocks.CRIMSON_PLANKS,
                Blocks.STRIPPED_CRIMSON_STEM,
                Blocks.CRIMSON_STEM);
        threeTextureHorizontalVariant(ModBlocks.LOCKER_DARK_OAK.get(),
                "block/locker",
                Blocks.DARK_OAK_PLANKS,
                Blocks.STRIPPED_DARK_OAK_LOG,
                Blocks.DARK_OAK_LOG);
        threeTextureHorizontalVariant(ModBlocks.LOCKER_JUNGLE.get(),
                "block/locker",
                Blocks.JUNGLE_PLANKS,
                Blocks.STRIPPED_JUNGLE_LOG,
                Blocks.JUNGLE_LOG);
        threeTextureHorizontalVariant(ModBlocks.LOCKER_MANGROVE.get(),
                "block/locker",
                Blocks.MANGROVE_PLANKS,
                Blocks.STRIPPED_MANGROVE_LOG,
                Blocks.MANGROVE_LOG);
        threeTextureHorizontalVariant(ModBlocks.LOCKER_OAK.get(),
                "block/locker",
                Blocks.OAK_PLANKS,
                Blocks.STRIPPED_OAK_LOG,
                Blocks.OAK_LOG);
        threeTextureHorizontalVariant(ModBlocks.LOCKER_SPRUCE.get(),
                "block/locker",
                Blocks.SPRUCE_PLANKS,
                Blocks.STRIPPED_SPRUCE_LOG,
                Blocks.SPRUCE_LOG);
        threeTextureHorizontalVariant(ModBlocks.LOCKER_WARPED.get(),
                "block/locker",
                Blocks.WARPED_PLANKS,
                Blocks.STRIPPED_WARPED_STEM,
                Blocks.WARPED_STEM);

        twoTextureHorizontalVariant(ModBlocks.PARK_BENCH_ACACIA.get(),
                "block/park_bench",
                Blocks.ACACIA_PLANKS,
                Blocks.ACACIA_LOG);
        twoTextureHorizontalVariant(ModBlocks.PARK_BENCH_BIRCH.get(),
                "block/park_bench",
                Blocks.BIRCH_PLANKS,
                Blocks.BIRCH_LOG);
        twoTextureHorizontalVariant(ModBlocks.PARK_BENCH_CRIMSON.get(),
                "block/park_bench",
                Blocks.CRIMSON_PLANKS,
                Blocks.CRIMSON_STEM);
        twoTextureHorizontalVariant(ModBlocks.PARK_BENCH_DARK_OAK.get(),
                "block/park_bench",
                Blocks.DARK_OAK_PLANKS,
                Blocks.DARK_OAK_LOG);
        twoTextureHorizontalVariant(ModBlocks.PARK_BENCH_JUNGLE.get(),
                "block/park_bench",
                Blocks.JUNGLE_PLANKS,
                Blocks.JUNGLE_LOG);
        twoTextureHorizontalVariant(ModBlocks.PARK_BENCH_MANGROVE.get(),
                "block/park_bench",
                Blocks.MANGROVE_PLANKS,
                Blocks.MANGROVE_LOG);
        twoTextureHorizontalVariant(ModBlocks.PARK_BENCH_OAK.get(),
                "block/park_bench",
                Blocks.OAK_PLANKS,
                Blocks.OAK_LOG);
        twoTextureHorizontalVariant(ModBlocks.PARK_BENCH_SPRUCE.get(),
                "block/park_bench",
                Blocks.SPRUCE_PLANKS,
                Blocks.SPRUCE_LOG);
        twoTextureHorizontalVariant(ModBlocks.PARK_BENCH_WARPED.get(),
                "block/park_bench",
                Blocks.WARPED_PLANKS,
                Blocks.WARPED_STEM);

        twoTextureHorizontalVariant(ModBlocks.SCHOOL_DESK_ACACIA.get(),
                "block/school_desk",
                Blocks.ACACIA_PLANKS,
                Blocks.ACACIA_LOG);
        twoTextureHorizontalVariant(ModBlocks.SCHOOL_DESK_BIRCH.get(),
                "block/school_desk",
                Blocks.BIRCH_PLANKS,
                Blocks.BIRCH_LOG);
        twoTextureHorizontalVariant(ModBlocks.SCHOOL_DESK_CRIMSON.get(),
                "block/school_desk",
                Blocks.CRIMSON_PLANKS,
                Blocks.CRIMSON_STEM);
        twoTextureHorizontalVariant(ModBlocks.SCHOOL_DESK_DARK_OAK.get(),
                "block/school_desk",
                Blocks.DARK_OAK_PLANKS,
                Blocks.DARK_OAK_LOG);
        twoTextureHorizontalVariant(ModBlocks.SCHOOL_DESK_JUNGLE.get(),
                "block/school_desk",
                Blocks.JUNGLE_PLANKS,
                Blocks.JUNGLE_LOG);
        twoTextureHorizontalVariant(ModBlocks.SCHOOL_DESK_MANGROVE.get(),
                "block/school_desk",
                Blocks.MANGROVE_PLANKS,
                Blocks.MANGROVE_LOG);
        twoTextureHorizontalVariant(ModBlocks.SCHOOL_DESK_OAK.get(),
                "block/school_desk",
                Blocks.OAK_PLANKS,
                Blocks.OAK_LOG);
        twoTextureHorizontalVariant(ModBlocks.SCHOOL_DESK_SPRUCE.get(),
                "block/school_desk",
                Blocks.SPRUCE_PLANKS,
                Blocks.SPRUCE_LOG);
        twoTextureHorizontalVariant(ModBlocks.SCHOOL_DESK_WARPED.get(),
                "block/school_desk",
                Blocks.WARPED_PLANKS,
                Blocks.WARPED_STEM);

        twoTextureHorizontalVariant(ModBlocks.SCHOOL_DESK_CABINET_ACACIA.get(),
                "block/school_desk_cabinet",
                Blocks.ACACIA_PLANKS,
                Blocks.ACACIA_LOG);
        twoTextureHorizontalVariant(ModBlocks.SCHOOL_DESK_CABINET_BIRCH.get(),
                "block/school_desk_cabinet",
                Blocks.BIRCH_PLANKS,
                Blocks.BIRCH_LOG);
        twoTextureHorizontalVariant(ModBlocks.SCHOOL_DESK_CABINET_CRIMSON.get(),
                "block/school_desk_cabinet",
                Blocks.CRIMSON_PLANKS,
                Blocks.CRIMSON_STEM);
        twoTextureHorizontalVariant(ModBlocks.SCHOOL_DESK_CABINET_DARK_OAK.get(),
                "block/school_desk_cabinet",
                Blocks.DARK_OAK_PLANKS,
                Blocks.DARK_OAK_LOG);
        twoTextureHorizontalVariant(ModBlocks.SCHOOL_DESK_CABINET_JUNGLE.get(),
                "block/school_desk_cabinet",
                Blocks.JUNGLE_PLANKS,
                Blocks.JUNGLE_LOG);
        twoTextureHorizontalVariant(ModBlocks.SCHOOL_DESK_CABINET_MANGROVE.get(),
                "block/school_desk_cabinet",
                Blocks.MANGROVE_PLANKS,
                Blocks.MANGROVE_LOG);
        twoTextureHorizontalVariant(ModBlocks.SCHOOL_DESK_CABINET_OAK.get(),
                "block/school_desk_cabinet",
                Blocks.OAK_PLANKS,
                Blocks.OAK_LOG);
        twoTextureHorizontalVariant(ModBlocks.SCHOOL_DESK_CABINET_SPRUCE.get(),
                "block/school_desk_cabinet",
                Blocks.SPRUCE_PLANKS,
                Blocks.SPRUCE_LOG);
        twoTextureHorizontalVariant(ModBlocks.SCHOOL_DESK_CABINET_WARPED.get(),
                "block/school_desk_cabinet",
                Blocks.WARPED_PLANKS,
                Blocks.WARPED_STEM);

        tableVariant(ModBlocks.TABLE_ACACIA.get(),
                "table",
                "table_center",
                Blocks.ACACIA_PLANKS,
                Blocks.STRIPPED_ACACIA_LOG,
                Blocks.ACACIA_LOG);
        tableVariant(ModBlocks.TABLE_BIRCH.get(),
                "table",
                "table_center",
                Blocks.BIRCH_PLANKS,
                Blocks.STRIPPED_BIRCH_LOG,
                Blocks.BIRCH_LOG);
        tableVariant(ModBlocks.TABLE_CRIMSON.get(),
                "table",
                "table_center",
                Blocks.CRIMSON_PLANKS,
                Blocks.STRIPPED_CRIMSON_STEM,
                Blocks.CRIMSON_STEM);
        tableVariant(ModBlocks.TABLE_DARK_OAK.get(),
                "table",
                "table_center",
                Blocks.DARK_OAK_PLANKS,
                Blocks.STRIPPED_DARK_OAK_LOG,
                Blocks.DARK_OAK_LOG);
        tableVariant(ModBlocks.TABLE_JUNGLE.get(),
                "table",
                "table_center",
                Blocks.JUNGLE_PLANKS,
                Blocks.STRIPPED_JUNGLE_LOG,
                Blocks.JUNGLE_LOG);
        tableVariant(ModBlocks.TABLE_MANGROVE.get(),
                "table",
                "table_center",
                Blocks.MANGROVE_PLANKS,
                Blocks.STRIPPED_MANGROVE_LOG,
                Blocks.MANGROVE_LOG);
        tableVariant(ModBlocks.TABLE_OAK.get(),
                "table",
                "table_center",
                Blocks.OAK_PLANKS,
                Blocks.STRIPPED_OAK_LOG,
                Blocks.OAK_LOG);
        tableVariant(ModBlocks.TABLE_SPRUCE.get(),
                "table",
                "table_center",
                Blocks.SPRUCE_PLANKS,
                Blocks.STRIPPED_SPRUCE_LOG,
                Blocks.SPRUCE_LOG);
        tableVariant(ModBlocks.TABLE_WARPED.get(),
                "table",
                "table_center",
                Blocks.WARPED_PLANKS,
                Blocks.STRIPPED_WARPED_STEM,
                Blocks.WARPED_STEM);
    }

    protected void threeTextureHorizontalVariant(Block result, String parentModel, Block texture1, Block texture2, Block texture3) {

        final var model = models()
                .withExistingParent(blockName(result),
                        modLoc(parentModel))
                .texture("1", blockTexture(texture1))
                .texture("2", blockTexture(texture2))
                .texture("3", blockTexture(texture3))
                .texture("particle", blockTexture(texture1));

        horizontalBlock(result, model);
        simpleBlockItem(result, model);
    }

    protected void twoTextureHorizontalVariant(Block result, String parentModel, Block texture1, Block texture2) {

        final var model = models()
                .withExistingParent(blockName(result),
                        modLoc(parentModel))
                .texture("1", blockTexture(texture1))
                .texture("2", blockTexture(texture2))
                .texture("particle", blockTexture(texture1));

        horizontalBlock(result, model);
        simpleBlockItem(result, model);
    }

    @SuppressWarnings({"SameParameterValue", "ConstantValue"})
    protected void tableVariant(Block result, String parentModel1, String parentModel2, Block texture1, Block texture2, Block texture3) {

        final var table = models()
                .withExistingParent(blockName(result),
                        modLoc(parentModel1))
                .texture("1", blockTexture(texture1))
                .texture("2", blockTexture(texture2))
                .texture("3", blockTexture(texture3))
                .texture("particle", blockTexture(texture1));

        final var tableCenter = models()
                .withExistingParent(blockName(result) + "_center",
                        modLoc(parentModel2))
                .texture("1", blockTexture(texture1))
                .texture("particle", blockTexture(texture1));

        getVariantBuilder(result)
                // Set the rotation and default model for all states
                .forAllStates(state -> {
                    final BooleanProperty NORTH = BooleanProperty.create("north");
                    final BooleanProperty EAST = BooleanProperty.create("east");
                    final BooleanProperty SOUTH = BooleanProperty.create("south");
                    final BooleanProperty WEST = BooleanProperty.create("west");

                    boolean north = state.getValue(NORTH);
                    boolean east = state.getValue(EAST);
                    boolean south = state.getValue(SOUTH);
                    boolean west = state.getValue(WEST);

                    if (!north & !east && !south && !west) {
                        return ConfiguredModel.builder()
                                .modelFile(table)
                                .uvLock(true)
                                .build();
                    }
                    else if (north && east && south && west) {
                        return ConfiguredModel.builder()
                                .modelFile(tableCenter)
                                .uvLock(true)
                                .build();
                    }
                    else if (!north && east && !south && west) {
                        return ConfiguredModel.builder()
                                .modelFile(tableCenter)
                                .uvLock(true)
                                .build();
                    }
                    else if (north && !east && south && !west) {
                        return ConfiguredModel.builder()
                                .modelFile(tableCenter)
                                .uvLock(true)
                                .build();
                    }
                    else if (!north && east && south && west) {
                        return ConfiguredModel.builder()
                                .modelFile(tableCenter)
                                .uvLock(true)
                                .build();
                    }
                    else if (north && !east && south && west) {
                        return ConfiguredModel.builder()
                                .modelFile(tableCenter)
                                .uvLock(true)
                                .build();
                    }
                    else if (north && east && !south && west) {
                        return ConfiguredModel.builder()
                                .modelFile(tableCenter)
                                .uvLock(true)
                                .build();
                    }
                    else if (north && east && south && !west) {
                        return ConfiguredModel.builder()
                                .modelFile(tableCenter)
                                .uvLock(true)
                                .build();
                    }
                    else if (north && !east && !south && west) {
                        return ConfiguredModel.builder()
                                .modelFile(table)
                                .uvLock(true)
                                .rotationY(180)
                                .build();
                    }
                    else if (north && east && !south && !west) {
                        return ConfiguredModel.builder()
                                .modelFile(table)
                                .uvLock(true)
                                .rotationY(270)
                                .build();
                    }
                    else if (!north && east && south && !west) {
                        return ConfiguredModel.builder()
                                .modelFile(table)
                                .uvLock(true)
                                .build();
                    }
                    else if (!north && !east && south && west) {
                        return ConfiguredModel.builder()
                                .modelFile(table)
                                .uvLock(true)
                                .rotationY(90)
                                .build();
                    }
                    else if (!north & !east && south && !west) {
                        return ConfiguredModel.builder()
                                .modelFile(table)
                                .uvLock(true)
                                .rotationY(90)
                                .build();
                    }
                    else if (!north & !east && !south && west) {
                        return ConfiguredModel.builder()
                                .modelFile(table)
                                .uvLock(true)
                                .rotationY(180)
                                .build();
                    }
                    else if (north & !east && !south && !west) {
                        return ConfiguredModel.builder()
                                .modelFile(table)
                                .uvLock(true)
                                .rotationY(270)
                                .build();
                    }
                    else {
                        return ConfiguredModel.builder()
                                .modelFile(table)
                                .uvLock(true)
                                .build();
                    }
                });

        simpleBlockItem(result, table);
    }

    @SuppressWarnings("unused")
    private int getRotationY(final Direction direction) {
        return getRotationY(direction, DEFAULT_ANGLE_OFFSET);
    }

    @SuppressWarnings("SameParameterValue")
    private int getRotationY(final @NotNull Direction direction, final int offset) {
        return direction.getAxis().isVertical() ? 0 : (((int) direction.toYRot()) + offset) % 360;
    }
}