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
                ModBlocks.BOOKCASE_ACACIA.get(),
                "minecraft", "acacia");
        processVariants(
                ModBlocks.DESK_CHAIR_BIRCH.get(),
                ModBlocks.TABLE_BIRCH.get(),
                ModBlocks.LOCKER_BIRCH.get(),
                ModBlocks.SCHOOL_DESK_CABINET_BIRCH.get(),
                ModBlocks.SCHOOL_DESK_BIRCH.get(),
                ModBlocks.PARK_BENCH_BIRCH.get(),
                ModBlocks.BOOKCASE_BIRCH.get(),
                "minecraft", "birch");
        processVariants(
                ModBlocks.DESK_CHAIR_CRIMSON.get(),
                ModBlocks.TABLE_CRIMSON.get(),
                ModBlocks.LOCKER_CRIMSON.get(),
                ModBlocks.SCHOOL_DESK_CABINET_CRIMSON.get(),
                ModBlocks.SCHOOL_DESK_CRIMSON.get(),
                ModBlocks.PARK_BENCH_CRIMSON.get(),
                ModBlocks.BOOKCASE_CRIMSON.get(),
                "minecraft", "crimson");
        processVariants(
                ModBlocks.DESK_CHAIR_DARK_OAK.get(),
                ModBlocks.TABLE_DARK_OAK.get(),
                ModBlocks.LOCKER_DARK_OAK.get(),
                ModBlocks.SCHOOL_DESK_CABINET_DARK_OAK.get(),
                ModBlocks.SCHOOL_DESK_DARK_OAK.get(),
                ModBlocks.PARK_BENCH_DARK_OAK.get(),
                ModBlocks.BOOKCASE_DARK_OAK.get(),
                "minecraft", "dark_oak");
        processVariants(
                ModBlocks.DESK_CHAIR_JUNGLE.get(),
                ModBlocks.TABLE_JUNGLE.get(),
                ModBlocks.LOCKER_JUNGLE.get(),
                ModBlocks.SCHOOL_DESK_CABINET_JUNGLE.get(),
                ModBlocks.SCHOOL_DESK_JUNGLE.get(),
                ModBlocks.PARK_BENCH_JUNGLE.get(),
                ModBlocks.BOOKCASE_JUNGLE.get(),
                "minecraft", "jungle");
        processVariants(
                ModBlocks.DESK_CHAIR_SPRUCE.get(),
                ModBlocks.TABLE_SPRUCE.get(),
                ModBlocks.LOCKER_SPRUCE.get(),
                ModBlocks.SCHOOL_DESK_CABINET_SPRUCE.get(),
                ModBlocks.SCHOOL_DESK_SPRUCE.get(),
                ModBlocks.PARK_BENCH_SPRUCE.get(),
                ModBlocks.BOOKCASE_SPRUCE.get(),
                "minecraft", "spruce");
        processVariants(
                ModBlocks.DESK_CHAIR_MANGROVE.get(),
                ModBlocks.TABLE_MANGROVE.get(),
                ModBlocks.LOCKER_MANGROVE.get(),
                ModBlocks.SCHOOL_DESK_CABINET_MANGROVE.get(),
                ModBlocks.SCHOOL_DESK_MANGROVE.get(),
                ModBlocks.PARK_BENCH_MANGROVE.get(),
                ModBlocks.BOOKCASE_MANGROVE.get(),
                "minecraft", "mangrove");
        processVariants(
                ModBlocks.DESK_CHAIR_OAK.get(),
                ModBlocks.TABLE_OAK.get(),
                ModBlocks.LOCKER_OAK.get(),
                ModBlocks.SCHOOL_DESK_CABINET_OAK.get(),
                ModBlocks.SCHOOL_DESK_OAK.get(),
                ModBlocks.PARK_BENCH_OAK.get(),
                ModBlocks.BOOKCASE_OAK.get(),
                "minecraft", "oak");
        processVariants(
                ModBlocks.DESK_CHAIR_WARPED.get(),
                ModBlocks.TABLE_WARPED.get(),
                ModBlocks.LOCKER_WARPED.get(),
                ModBlocks.SCHOOL_DESK_CABINET_WARPED.get(),
                ModBlocks.SCHOOL_DESK_WARPED.get(),
                ModBlocks.PARK_BENCH_WARPED.get(),
                ModBlocks.BOOKCASE_WARPED.get(),
                "minecraft", "warped");
        processVariants(
                ModBlocks.DESK_CHAIR_FIR.get(),
                ModBlocks.TABLE_FIR.get(),
                ModBlocks.LOCKER_FIR.get(),
                ModBlocks.SCHOOL_DESK_CABINET_FIR.get(),
                ModBlocks.SCHOOL_DESK_FIR.get(),
                ModBlocks.PARK_BENCH_FIR.get(),
                ModBlocks.BOOKCASE_FIR.get(),
                "biomesoplenty", "fir");
        processVariants(
                ModBlocks.DESK_CHAIR_REDWOOD.get(),
                ModBlocks.TABLE_REDWOOD.get(),
                ModBlocks.LOCKER_REDWOOD.get(),
                ModBlocks.SCHOOL_DESK_CABINET_REDWOOD.get(),
                ModBlocks.SCHOOL_DESK_REDWOOD.get(),
                ModBlocks.PARK_BENCH_REDWOOD.get(),
                ModBlocks.BOOKCASE_REDWOOD.get(),
                "biomesoplenty", "redwood");
        processVariants(
                ModBlocks.DESK_CHAIR_CHERRY.get(),
                ModBlocks.TABLE_CHERRY.get(),
                ModBlocks.LOCKER_CHERRY.get(),
                ModBlocks.SCHOOL_DESK_CABINET_CHERRY.get(),
                ModBlocks.SCHOOL_DESK_CHERRY.get(),
                ModBlocks.PARK_BENCH_CHERRY.get(),
                ModBlocks.BOOKCASE_CHERRY.get(),
                "biomesoplenty", "cherry");
        processVariants(
                ModBlocks.DESK_CHAIR_MAHOGANY.get(),
                ModBlocks.TABLE_MAHOGANY.get(),
                ModBlocks.LOCKER_MAHOGANY.get(),
                ModBlocks.SCHOOL_DESK_CABINET_MAHOGANY.get(),
                ModBlocks.SCHOOL_DESK_MAHOGANY.get(),
                ModBlocks.PARK_BENCH_MAHOGANY.get(),
                ModBlocks.BOOKCASE_MAHOGANY.get(),
                "biomesoplenty", "mahogany");
        processVariants(
                ModBlocks.DESK_CHAIR_JACARANDA.get(),
                ModBlocks.TABLE_JACARANDA.get(),
                ModBlocks.LOCKER_JACARANDA.get(),
                ModBlocks.SCHOOL_DESK_CABINET_JACARANDA.get(),
                ModBlocks.SCHOOL_DESK_JACARANDA.get(),
                ModBlocks.PARK_BENCH_JACARANDA.get(),
                ModBlocks.BOOKCASE_JACARANDA.get(),
                "biomesoplenty", "jacaranda");
        processVariants(
                ModBlocks.DESK_CHAIR_PALM.get(),
                ModBlocks.TABLE_PALM.get(),
                ModBlocks.LOCKER_PALM.get(),
                ModBlocks.SCHOOL_DESK_CABINET_PALM.get(),
                ModBlocks.SCHOOL_DESK_PALM.get(),
                ModBlocks.PARK_BENCH_PALM.get(),
                ModBlocks.BOOKCASE_PALM.get(),
                "biomesoplenty", "palm");
        processVariants(
                ModBlocks.DESK_CHAIR_WILLOW.get(),
                ModBlocks.TABLE_WILLOW.get(),
                ModBlocks.LOCKER_WILLOW.get(),
                ModBlocks.SCHOOL_DESK_CABINET_WILLOW.get(),
                ModBlocks.SCHOOL_DESK_WILLOW.get(),
                ModBlocks.PARK_BENCH_WILLOW.get(),
                ModBlocks.BOOKCASE_WILLOW.get(),
                "biomesoplenty", "willow");
        processVariants(
                ModBlocks.DESK_CHAIR_DEAD.get(),
                ModBlocks.TABLE_DEAD.get(),
                ModBlocks.LOCKER_DEAD.get(),
                ModBlocks.SCHOOL_DESK_CABINET_DEAD.get(),
                ModBlocks.SCHOOL_DESK_DEAD.get(),
                ModBlocks.PARK_BENCH_DEAD.get(),
                ModBlocks.BOOKCASE_DEAD.get(),
                "biomesoplenty", "dead");
        processVariants(
                ModBlocks.DESK_CHAIR_MAGIC.get(),
                ModBlocks.TABLE_MAGIC.get(),
                ModBlocks.LOCKER_MAGIC.get(),
                ModBlocks.SCHOOL_DESK_CABINET_MAGIC.get(),
                ModBlocks.SCHOOL_DESK_MAGIC.get(),
                ModBlocks.PARK_BENCH_MAGIC.get(),
                ModBlocks.BOOKCASE_MAGIC.get(),
                "biomesoplenty", "magic");
        processVariants(
                ModBlocks.DESK_CHAIR_UMBRAN.get(),
                ModBlocks.TABLE_UMBRAN.get(),
                ModBlocks.LOCKER_UMBRAN.get(),
                ModBlocks.SCHOOL_DESK_CABINET_UMBRAN.get(),
                ModBlocks.SCHOOL_DESK_UMBRAN.get(),
                ModBlocks.PARK_BENCH_UMBRAN.get(),
                ModBlocks.BOOKCASE_UMBRAN.get(),
                "biomesoplenty", "umbran");
        processVariants(
                ModBlocks.DESK_CHAIR_HELLBARK.get(),
                ModBlocks.TABLE_HELLBARK.get(),
                ModBlocks.LOCKER_HELLBARK.get(),
                ModBlocks.SCHOOL_DESK_CABINET_HELLBARK.get(),
                ModBlocks.SCHOOL_DESK_HELLBARK.get(),
                ModBlocks.PARK_BENCH_HELLBARK.get(),
                ModBlocks.BOOKCASE_HELLBARK.get(),
                "biomesoplenty", "hellbark");
        processVariants(
                ModBlocks.DESK_CHAIR_COCONUT.get(),
                ModBlocks.TABLE_COCONUT.get(),
                ModBlocks.LOCKER_COCONUT.get(),
                ModBlocks.SCHOOL_DESK_CABINET_COCONUT.get(),
                ModBlocks.SCHOOL_DESK_COCONUT.get(),
                ModBlocks.PARK_BENCH_COCONUT.get(),
                ModBlocks.BOOKCASE_COCONUT.get(),
                "ecologics", "coconut");
        processVariants(
                ModBlocks.DESK_CHAIR_WALNUT.get(),
                ModBlocks.TABLE_WALNUT.get(),
                ModBlocks.LOCKER_WALNUT.get(),
                ModBlocks.SCHOOL_DESK_CABINET_WALNUT.get(),
                ModBlocks.SCHOOL_DESK_WALNUT.get(),
                ModBlocks.PARK_BENCH_WALNUT.get(),
                ModBlocks.BOOKCASE_WALNUT.get(),
                "ecologics", "walnut");
        processVariants(
                ModBlocks.DESK_CHAIR_AZALEA.get(),
                ModBlocks.TABLE_AZALEA.get(),
                ModBlocks.LOCKER_AZALEA.get(),
                ModBlocks.SCHOOL_DESK_CABINET_AZALEA.get(),
                ModBlocks.SCHOOL_DESK_AZALEA.get(),
                ModBlocks.PARK_BENCH_AZALEA.get(),
                ModBlocks.BOOKCASE_AZALEA.get(),
                "ecologics", "azalea");
        processVariants(
                ModBlocks.DESK_CHAIR_FLOWERING_AZALEA.get(),
                ModBlocks.TABLE_FLOWERING_AZALEA.get(),
                ModBlocks.LOCKER_FLOWERING_AZALEA.get(),
                ModBlocks.SCHOOL_DESK_CABINET_FLOWERING_AZALEA.get(),
                ModBlocks.SCHOOL_DESK_FLOWERING_AZALEA.get(),
                ModBlocks.PARK_BENCH_FLOWERING_AZALEA.get(),
                ModBlocks.BOOKCASE_FLOWERING_AZALEA.get(),
                "ecologics", "flowering_azalea");
        processVariants(
                ModBlocks.DESK_CHAIR_GOLDEN_OAK.get(),
                ModBlocks.TABLE_GOLDEN_OAK.get(),
                ModBlocks.LOCKER_GOLDEN_OAK.get(),
                ModBlocks.SCHOOL_DESK_CABINET_GOLDEN_OAK.get(),
                ModBlocks.SCHOOL_DESK_GOLDEN_OAK.get(),
                ModBlocks.PARK_BENCH_GOLDEN_OAK.get(),
                ModBlocks.BOOKCASE_GOLDEN_OAK.get(),
                "aether", "golden_oak");
        processVariants(
                ModBlocks.DESK_CHAIR_AETHER_SKYROOT.get(),
                ModBlocks.TABLE_AETHER_SKYROOT.get(),
                ModBlocks.LOCKER_AETHER_SKYROOT.get(),
                ModBlocks.SCHOOL_DESK_CABINET_AETHER_SKYROOT.get(),
                ModBlocks.SCHOOL_DESK_AETHER_SKYROOT.get(),
                ModBlocks.PARK_BENCH_AETHER_SKYROOT.get(),
                ModBlocks.BOOKCASE_AETHER_SKYROOT.get(),
                "aether", "skyroot");
        processVariants(
                ModBlocks.DESK_CHAIR_PREAM.get(),
                ModBlocks.TABLE_PREAM.get(),
                ModBlocks.LOCKER_PREAM.get(),
                ModBlocks.SCHOOL_DESK_CABINET_PREAM.get(),
                ModBlocks.SCHOOL_DESK_PREAM.get(),
                ModBlocks.PARK_BENCH_PREAM.get(),
                ModBlocks.BOOKCASE_PREAM.get(),
                "phantasm", "pream");
        processVariants(
                ModBlocks.DESK_CHAIR_EBONY.get(),
                ModBlocks.TABLE_EBONY.get(),
                ModBlocks.LOCKER_EBONY.get(),
                ModBlocks.SCHOOL_DESK_CABINET_EBONY.get(),
                ModBlocks.SCHOOL_DESK_EBONY.get(),
                ModBlocks.PARK_BENCH_EBONY.get(),
                ModBlocks.BOOKCASE_EBONY.get(),
                "phantasm", "ebony");
        processVariants(
                ModBlocks.DESK_CHAIR_CHORUS_NEST.get(),
                ModBlocks.TABLE_CHORUS_NEST.get(),
                ModBlocks.LOCKER_CHORUS_NEST.get(),
                ModBlocks.SCHOOL_DESK_CABINET_CHORUS_NEST.get(),
                ModBlocks.SCHOOL_DESK_CHORUS_NEST.get(),
                ModBlocks.PARK_BENCH_CHORUS_NEST.get(),
                ModBlocks.BOOKCASE_CHORUS_NEST.get(),
                "unusualend", "chorus_nest");
        processVariants(
                ModBlocks.DESK_CHAIR_BLOODSHROOM.get(),
                ModBlocks.TABLE_BLOODSHROOM.get(),
                ModBlocks.LOCKER_BLOODSHROOM.get(),
                ModBlocks.SCHOOL_DESK_CABINET_BLOODSHROOM.get(),
                ModBlocks.SCHOOL_DESK_BLOODSHROOM.get(),
                ModBlocks.PARK_BENCH_BLOODSHROOM.get(),
                ModBlocks.BOOKCASE_BLOODSHROOM.get(),
                "tconstruct", "bloodshroom");
        processVariants(
                ModBlocks.DESK_CHAIR_ENDERBARK.get(),
                ModBlocks.TABLE_ENDERBARK.get(),
                ModBlocks.LOCKER_ENDERBARK.get(),
                ModBlocks.SCHOOL_DESK_CABINET_ENDERBARK.get(),
                ModBlocks.SCHOOL_DESK_ENDERBARK.get(),
                ModBlocks.PARK_BENCH_ENDERBARK.get(),
                ModBlocks.BOOKCASE_ENDERBARK.get(),
                "tconstruct", "enderbark");
        processVariants(
                ModBlocks.DESK_CHAIR_GREENHEART.get(),
                ModBlocks.TABLE_GREENHEART.get(),
                ModBlocks.LOCKER_GREENHEART.get(),
                ModBlocks.SCHOOL_DESK_CABINET_GREENHEART.get(),
                ModBlocks.SCHOOL_DESK_GREENHEART.get(),
                ModBlocks.PARK_BENCH_GREENHEART.get(),
                ModBlocks.BOOKCASE_GREENHEART.get(),
                "tconstruct", "greenheart");
        processVariants(
                ModBlocks.DESK_CHAIR_TINKER_SKYROOT.get(),
                ModBlocks.TABLE_TINKER_SKYROOT.get(),
                ModBlocks.LOCKER_TINKER_SKYROOT.get(),
                ModBlocks.SCHOOL_DESK_CABINET_TINKER_SKYROOT.get(),
                ModBlocks.SCHOOL_DESK_TINKER_SKYROOT.get(),
                ModBlocks.PARK_BENCH_TINKER_SKYROOT.get(),
                ModBlocks.BOOKCASE_TINKER_SKYROOT.get(),
                "tconstruct", "skyroot");

        processPlateVariants(ModBlocks.PLATE_WHITE.get(), MODID, "block/plate_white");
    }

    @SuppressWarnings("SameParameterValue")
    protected void processPlateVariants(Block result, String modid, String path) {
        plateVariant(result, MODID + ":" + "block/plate_block", modid, path);
    }

    protected void processVariants(Block result1, Block result2,
                                   Block result3, Block result4,
                                   Block result5, Block result6,
                                   Block result7,
                                   String modid, String woodType) {
        String path_1;
        String path_2;
        String path_3;

        if (Objects.equals(woodType, "crimson") || Objects.equals(woodType, "warped")) {
            path_2 = "block/stripped_" + woodType + "_stem";
            path_3 = "block/" + woodType + "_stem";
        }
        else if (Objects.equals(woodType, "flowering_azalea")) {
            path_2 = "block/stripped_azalea_log";
            path_3 = "block/" + woodType + "_log";
        }
        else {
            path_2 = "block/stripped_" + woodType + "_log";
            path_3 = "block/" + woodType + "_log";
        }

        if (Objects.equals(woodType, "golden_oak")) {
            path_1 = "block/skyroot_planks";
            path_2 = "block/stripped_skyroot_log";
            path_3 = "block/" + woodType + "_log";
        }
        else if (Objects.equals(woodType, "pream")) {
            path_1 = "block/" + woodType + "_planks";
            path_2 = "block/stripped_" + woodType + "_log_side";
            path_3 = "block/" + woodType + "_log_side";
        }
        else if (Objects.equals(woodType, "ebony")) {
            path_1 = "block/" + woodType + "_planks";
            path_2 = "block/" + woodType + "_stems_side_stripped";
            path_3 = "block/" + woodType + "_stems_side";
        }
        else if (Objects.equals(woodType, "chorus_nest")) {
            path_1 = "block/" + woodType + "_planks";
            path_2 = "block/stripped_" + woodType + "_planks";
            path_3 = "block/" + woodType + "_mosaic";
        }
        else if (Objects.equals(modid, "tconstruct") && (Objects.equals(woodType, "bloodshroom") || Objects.equals(woodType, "enderbark")
                || Objects.equals(woodType, "greenheart") || Objects.equals(woodType, "skyroot"))) {
            path_1 = "block/" + woodType + "/planks";
            path_2 = "block/" + woodType + "/stripped_log";
            path_3 = "block/" + woodType + "/log";
        }
        else {
            path_1 = "block/" + woodType + "_planks";
        }

        threeTextureHorizontalVariant(result1, MODID + ":" + "block/desk_chair", modid, path_1, path_2, path_3);
        threeTextureHorizontalVariant(result3, MODID + ":" + "block/locker", modid, path_1, path_2, path_3);
        threeTextureHorizontalVariant(result4, MODID + ":" + "block/school_desk_cabinet", modid, path_1, path_2, path_3);

        fourTextureHorizontalVariant(result7, MODID + ":" + "block/bookcase", modid, path_1, path_3, path_2);

        twoTextureHorizontalVariant(result6, MODID + ":" + "block/park_bench", modid, path_1, path_2);
        twoTextureHorizontalVariant(result5, MODID + ":" + "block/school_desk", modid, path_1, path_2);

        tableVariant(result2, MODID + ":" + "block/table", MODID + ":" + "block/table_center", modid, path_1, path_2, path_3);
    }

    @SuppressWarnings("SameParameterValue")
    protected void plateVariant(Block result, String parent, String modid, String path) {

        ModelFile parentModel = new ModelFile.UncheckedModelFile(parent);

        final var model = models()
                .getBuilder(blockName(result)).parent(parentModel)
                .texture("1", new ResourceLocation(modid, path))
                .texture("particle", new ResourceLocation(modid, path));

        horizontalBlock(result, model);
        simpleBlockItem(result, model);
    }

    @SuppressWarnings("SameParameterValue")
    protected void fourTextureHorizontalVariant(Block result, String parent, String modid, String path_1, String path_2, String path_3) {

        ModelFile parentModel = new ModelFile.UncheckedModelFile(parent);

        final var model = models()
                .getBuilder(blockName(result)).parent(parentModel)
                .texture("1", new ResourceLocation(modid, path_1))
                .texture("2", new ResourceLocation(modid, path_2))
                .texture("3", new ResourceLocation(modid, path_3))
                .texture("4", new ResourceLocation(MODID, "block/books"))
                .texture("particle", new ResourceLocation(modid, path_1));

        horizontalBlock(result, model);
        simpleBlockItem(result, model);
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