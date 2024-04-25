package com.github.warrentode.turtleblockacademy.datagen.models;

import com.github.warrentode.turtleblockacademy.blocks.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
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

    public ResourceLocation modBlockLocation(String path) {
        return new ResourceLocation(MODID, "block/" + path);
    }

    public ModelFile existingModel(Block block) {
        return new ModelFile.ExistingModelFile(modBlockLocation(blockName(block)), models().existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        horizontalBlock(ModBlocks.CERTIFICATE_BLOCK.get(), existingModel(ModBlocks.CERTIFICATE_BLOCK.get()));

        processVariants(
                ModBlocks.DESK_CHAIR_ACACIA.get(),
                ModBlocks.TABLE_ACACIA.get(),
                ModBlocks.LOCKER_ACACIA.get(),
                ModBlocks.SCHOOL_DESK_CABINET_ACACIA.get(),
                ModBlocks.SCHOOL_DESK_ACACIA.get(),
                ModBlocks.PARK_BENCH_ACACIA.get(),

                "minecraft", "acacia");
        processVariants(
                ModBlocks.DESK_CHAIR_BIRCH.get(),
                ModBlocks.TABLE_BIRCH.get(),
                ModBlocks.LOCKER_BIRCH.get(),
                ModBlocks.SCHOOL_DESK_CABINET_BIRCH.get(),
                ModBlocks.SCHOOL_DESK_BIRCH.get(),
                ModBlocks.PARK_BENCH_BIRCH.get(),

                "minecraft", "birch");
        processVariants(
                ModBlocks.DESK_CHAIR_CRIMSON.get(),
                ModBlocks.TABLE_CRIMSON.get(),
                ModBlocks.LOCKER_CRIMSON.get(),
                ModBlocks.SCHOOL_DESK_CABINET_CRIMSON.get(),
                ModBlocks.SCHOOL_DESK_CRIMSON.get(),
                ModBlocks.PARK_BENCH_CRIMSON.get(),

                "minecraft", "crimson");
        processVariants(
                ModBlocks.DESK_CHAIR_DARK_OAK.get(),
                ModBlocks.TABLE_DARK_OAK.get(),
                ModBlocks.LOCKER_DARK_OAK.get(),
                ModBlocks.SCHOOL_DESK_CABINET_DARK_OAK.get(),
                ModBlocks.SCHOOL_DESK_DARK_OAK.get(),
                ModBlocks.PARK_BENCH_DARK_OAK.get(),

                "minecraft", "dark_oak");
        processVariants(
                ModBlocks.DESK_CHAIR_JUNGLE.get(),
                ModBlocks.TABLE_JUNGLE.get(),
                ModBlocks.LOCKER_JUNGLE.get(),
                ModBlocks.SCHOOL_DESK_CABINET_JUNGLE.get(),
                ModBlocks.SCHOOL_DESK_JUNGLE.get(),
                ModBlocks.PARK_BENCH_JUNGLE.get(),

                "minecraft", "jungle");
        processVariants(
                ModBlocks.DESK_CHAIR_SPRUCE.get(),
                ModBlocks.TABLE_SPRUCE.get(),
                ModBlocks.LOCKER_SPRUCE.get(),
                ModBlocks.SCHOOL_DESK_CABINET_SPRUCE.get(),
                ModBlocks.SCHOOL_DESK_SPRUCE.get(),
                ModBlocks.PARK_BENCH_SPRUCE.get(),

                "minecraft", "spruce");
        processVariants(
                ModBlocks.DESK_CHAIR_MANGROVE.get(),
                ModBlocks.TABLE_MANGROVE.get(),
                ModBlocks.LOCKER_MANGROVE.get(),
                ModBlocks.SCHOOL_DESK_CABINET_MANGROVE.get(),
                ModBlocks.SCHOOL_DESK_MANGROVE.get(),
                ModBlocks.PARK_BENCH_MANGROVE.get(),

                "minecraft", "mangrove");
        processVariants(
                ModBlocks.DESK_CHAIR_OAK.get(),
                ModBlocks.TABLE_OAK.get(),
                ModBlocks.LOCKER_OAK.get(),
                ModBlocks.SCHOOL_DESK_CABINET_OAK.get(),
                ModBlocks.SCHOOL_DESK_OAK.get(),
                ModBlocks.PARK_BENCH_OAK.get(),

                "minecraft", "oak");
        processVariants(
                ModBlocks.DESK_CHAIR_WARPED.get(),
                ModBlocks.TABLE_WARPED.get(),
                ModBlocks.LOCKER_WARPED.get(),
                ModBlocks.SCHOOL_DESK_CABINET_WARPED.get(),
                ModBlocks.SCHOOL_DESK_WARPED.get(),
                ModBlocks.PARK_BENCH_WARPED.get(),

                "minecraft", "warped");
        processVariants(
                ModBlocks.DESK_CHAIR_FIR.get(),
                ModBlocks.TABLE_FIR.get(),
                ModBlocks.LOCKER_FIR.get(),
                ModBlocks.SCHOOL_DESK_CABINET_FIR.get(),
                ModBlocks.SCHOOL_DESK_FIR.get(),
                ModBlocks.PARK_BENCH_FIR.get(),

                "biomesoplenty", "fir");
        processVariants(
                ModBlocks.DESK_CHAIR_REDWOOD.get(),
                ModBlocks.TABLE_REDWOOD.get(),
                ModBlocks.LOCKER_REDWOOD.get(),
                ModBlocks.SCHOOL_DESK_CABINET_REDWOOD.get(),
                ModBlocks.SCHOOL_DESK_REDWOOD.get(),
                ModBlocks.PARK_BENCH_REDWOOD.get(),

                "biomesoplenty", "redwood");
        processVariants(
                ModBlocks.DESK_CHAIR_CHERRY.get(),
                ModBlocks.TABLE_CHERRY.get(),
                ModBlocks.LOCKER_CHERRY.get(),
                ModBlocks.SCHOOL_DESK_CABINET_CHERRY.get(),
                ModBlocks.SCHOOL_DESK_CHERRY.get(),
                ModBlocks.PARK_BENCH_CHERRY.get(),

                "biomesoplenty", "cherry");
        processVariants(
                ModBlocks.DESK_CHAIR_MAHOGANY.get(),
                ModBlocks.TABLE_MAHOGANY.get(),
                ModBlocks.LOCKER_MAHOGANY.get(),
                ModBlocks.SCHOOL_DESK_CABINET_MAHOGANY.get(),
                ModBlocks.SCHOOL_DESK_MAHOGANY.get(),
                ModBlocks.PARK_BENCH_MAHOGANY.get(),

                "biomesoplenty", "mahogany");
        processVariants(
                ModBlocks.DESK_CHAIR_JACARANDA.get(),
                ModBlocks.TABLE_JACARANDA.get(),
                ModBlocks.LOCKER_JACARANDA.get(),
                ModBlocks.SCHOOL_DESK_CABINET_JACARANDA.get(),
                ModBlocks.SCHOOL_DESK_JACARANDA.get(),
                ModBlocks.PARK_BENCH_JACARANDA.get(),

                "biomesoplenty", "jacaranda");
        processVariants(
                ModBlocks.DESK_CHAIR_PALM.get(),
                ModBlocks.TABLE_PALM.get(),
                ModBlocks.LOCKER_PALM.get(),
                ModBlocks.SCHOOL_DESK_CABINET_PALM.get(),
                ModBlocks.SCHOOL_DESK_PALM.get(),
                ModBlocks.PARK_BENCH_PALM.get(),

                "biomesoplenty", "palm");
        processVariants(
                ModBlocks.DESK_CHAIR_WILLOW.get(),
                ModBlocks.TABLE_WILLOW.get(),
                ModBlocks.LOCKER_WILLOW.get(),
                ModBlocks.SCHOOL_DESK_CABINET_WILLOW.get(),
                ModBlocks.SCHOOL_DESK_WILLOW.get(),
                ModBlocks.PARK_BENCH_WILLOW.get(),

                "biomesoplenty", "willow");
        processVariants(
                ModBlocks.DESK_CHAIR_DEAD.get(),
                ModBlocks.TABLE_DEAD.get(),
                ModBlocks.LOCKER_DEAD.get(),
                ModBlocks.SCHOOL_DESK_CABINET_DEAD.get(),
                ModBlocks.SCHOOL_DESK_DEAD.get(),
                ModBlocks.PARK_BENCH_DEAD.get(),

                "biomesoplenty", "dead");
        processVariants(
                ModBlocks.DESK_CHAIR_MAGIC.get(),
                ModBlocks.TABLE_MAGIC.get(),
                ModBlocks.LOCKER_MAGIC.get(),
                ModBlocks.SCHOOL_DESK_CABINET_MAGIC.get(),
                ModBlocks.SCHOOL_DESK_MAGIC.get(),
                ModBlocks.PARK_BENCH_MAGIC.get(),

                "biomesoplenty", "magic");
        processVariants(
                ModBlocks.DESK_CHAIR_UMBRAN.get(),
                ModBlocks.TABLE_UMBRAN.get(),
                ModBlocks.LOCKER_UMBRAN.get(),
                ModBlocks.SCHOOL_DESK_CABINET_UMBRAN.get(),
                ModBlocks.SCHOOL_DESK_UMBRAN.get(),
                ModBlocks.PARK_BENCH_UMBRAN.get(),

                "biomesoplenty", "umbran");
        processVariants(
                ModBlocks.DESK_CHAIR_HELLBARK.get(),
                ModBlocks.TABLE_HELLBARK.get(),
                ModBlocks.LOCKER_HELLBARK.get(),
                ModBlocks.SCHOOL_DESK_CABINET_HELLBARK.get(),
                ModBlocks.SCHOOL_DESK_HELLBARK.get(),
                ModBlocks.PARK_BENCH_HELLBARK.get(),

                "biomesoplenty", "hellbark");
    }

    protected void processVariants(Block result1, Block result2,
                                   Block result3, Block result4,
                                   Block result5, Block result6,
                                   String modid, String woodType) {
        String path_2;
        String path_3;

        String path_1 = "block/" + woodType + "_planks";
        if (Objects.equals(woodType, "crimson") || Objects.equals(woodType, "warped")) {
            path_2 = "block/stripped_" + woodType + "_stem";
            path_3 = "block/" + woodType + "_stem";
        }
        else {
            path_2 = "block/stripped_" + woodType + "_log";
            path_3 = "block/" + woodType + "_log";
        }

        threeTextureHorizontalVariant(result1, MODID + ":" + "block/desk_chair", modid, path_1, path_2, path_3);
        threeTextureHorizontalVariant(result3, MODID + ":" + "block/locker", modid, path_1, path_2, path_3);

        twoTextureHorizontalVariant(result4, MODID + ":" + "block/school_desk_cabinet", modid, path_1, path_2);
        twoTextureHorizontalVariant(result6, MODID + ":" + "block/park_bench", modid, path_1, path_2);
        twoTextureHorizontalVariant(result5, MODID + ":" + "block/school_desk", modid, path_1, path_2);

        tableVariant(result2, MODID + ":" + "block/table", MODID + ":" + "block/table_center", modid, path_1, path_2, path_3);
    }

    protected void threeTextureHorizontalVariant(Block result, String parent, String modid, String path_1, String path_2, String path_3) {

        ModelFile parentModel = new ModelFile.UncheckedModelFile(parent);

        final var model = models()
                .getBuilder(blockName(result)).parent(parentModel)
                .texture("1", new ResourceLocation(modid, path_1))
                .texture("2", new ResourceLocation(modid, path_2))
                .texture("3", new ResourceLocation(modid, path_3))
                .texture("particle", new ResourceLocation(modid, path_1));

        horizontalBlock(result, model);
        simpleBlockItem(result, model);
    }

    protected void twoTextureHorizontalVariant(Block result, String parent, String modid, String path_1, String path_2) {
        ModelFile parentModel = new ModelFile.UncheckedModelFile(parent);

        final var model = models()
                .getBuilder(blockName(result)).parent(parentModel)
                .texture("1", new ResourceLocation(modid, path_1))
                .texture("2", new ResourceLocation(modid, path_2))
                .texture("particle", new ResourceLocation(modid, path_1));

        horizontalBlock(result, model);
        simpleBlockItem(result, model);
    }

    @SuppressWarnings({"SameParameterValue", "ConstantValue"})
    protected void tableVariant(Block result, String parent1, String parent2, String modid,
                                String path_1, String path_2, String path_3) {

        ModelFile parentModel1 = new ModelFile.UncheckedModelFile(parent1);
        ModelFile parentModel2 = new ModelFile.UncheckedModelFile(parent2);

        final var table = models()
                .getBuilder(blockName(result)).parent(parentModel1)
                .texture("1", new ResourceLocation(modid, path_1))
                .texture("2", new ResourceLocation(modid, path_2))
                .texture("3", new ResourceLocation(modid, path_3))
                .texture("particle", new ResourceLocation(modid, path_1));

        final var tableCenter = models()
                .getBuilder(blockName(result) + "_center").parent(parentModel2)
                .texture("1", new ResourceLocation(modid, path_1))
                .texture("particle", new ResourceLocation(modid, path_1));

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