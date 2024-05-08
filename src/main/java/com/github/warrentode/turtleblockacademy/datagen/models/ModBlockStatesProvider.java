package com.github.warrentode.turtleblockacademy.datagen.models;

import com.github.warrentode.turtleblockacademy.blocks.ModBlockRegistry;
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
        horizontalBlock(ModBlockRegistry.CERTIFICATE_BLOCK.get(), existingModel(ModBlockRegistry.CERTIFICATE_BLOCK.get()));

        processVariants(
                ModBlockRegistry.DESK_CHAIR_ACACIA.get(),
                ModBlockRegistry.TABLE_ACACIA.get(),
                ModBlockRegistry.LOCKER_ACACIA.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_ACACIA.get(),
                ModBlockRegistry.SCHOOL_DESK_ACACIA.get(),
                ModBlockRegistry.PARK_BENCH_ACACIA.get(),
                ModBlockRegistry.BOOKCASE_ACACIA.get(),
                "minecraft", "acacia");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_BIRCH.get(),
                ModBlockRegistry.TABLE_BIRCH.get(),
                ModBlockRegistry.LOCKER_BIRCH.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_BIRCH.get(),
                ModBlockRegistry.SCHOOL_DESK_BIRCH.get(),
                ModBlockRegistry.PARK_BENCH_BIRCH.get(),
                ModBlockRegistry.BOOKCASE_BIRCH.get(),
                "minecraft", "birch");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_CRIMSON.get(),
                ModBlockRegistry.TABLE_CRIMSON.get(),
                ModBlockRegistry.LOCKER_CRIMSON.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_CRIMSON.get(),
                ModBlockRegistry.SCHOOL_DESK_CRIMSON.get(),
                ModBlockRegistry.PARK_BENCH_CRIMSON.get(),
                ModBlockRegistry.BOOKCASE_CRIMSON.get(),
                "minecraft", "crimson");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_DARK_OAK.get(),
                ModBlockRegistry.TABLE_DARK_OAK.get(),
                ModBlockRegistry.LOCKER_DARK_OAK.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_DARK_OAK.get(),
                ModBlockRegistry.SCHOOL_DESK_DARK_OAK.get(),
                ModBlockRegistry.PARK_BENCH_DARK_OAK.get(),
                ModBlockRegistry.BOOKCASE_DARK_OAK.get(),
                "minecraft", "dark_oak");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_JUNGLE.get(),
                ModBlockRegistry.TABLE_JUNGLE.get(),
                ModBlockRegistry.LOCKER_JUNGLE.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_JUNGLE.get(),
                ModBlockRegistry.SCHOOL_DESK_JUNGLE.get(),
                ModBlockRegistry.PARK_BENCH_JUNGLE.get(),
                ModBlockRegistry.BOOKCASE_JUNGLE.get(),
                "minecraft", "jungle");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_SPRUCE.get(),
                ModBlockRegistry.TABLE_SPRUCE.get(),
                ModBlockRegistry.LOCKER_SPRUCE.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_SPRUCE.get(),
                ModBlockRegistry.SCHOOL_DESK_SPRUCE.get(),
                ModBlockRegistry.PARK_BENCH_SPRUCE.get(),
                ModBlockRegistry.BOOKCASE_SPRUCE.get(),
                "minecraft", "spruce");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_MANGROVE.get(),
                ModBlockRegistry.TABLE_MANGROVE.get(),
                ModBlockRegistry.LOCKER_MANGROVE.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_MANGROVE.get(),
                ModBlockRegistry.SCHOOL_DESK_MANGROVE.get(),
                ModBlockRegistry.PARK_BENCH_MANGROVE.get(),
                ModBlockRegistry.BOOKCASE_MANGROVE.get(),
                "minecraft", "mangrove");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_OAK.get(),
                ModBlockRegistry.TABLE_OAK.get(),
                ModBlockRegistry.LOCKER_OAK.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_OAK.get(),
                ModBlockRegistry.SCHOOL_DESK_OAK.get(),
                ModBlockRegistry.PARK_BENCH_OAK.get(),
                ModBlockRegistry.BOOKCASE_OAK.get(),
                "minecraft", "oak");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_WARPED.get(),
                ModBlockRegistry.TABLE_WARPED.get(),
                ModBlockRegistry.LOCKER_WARPED.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_WARPED.get(),
                ModBlockRegistry.SCHOOL_DESK_WARPED.get(),
                ModBlockRegistry.PARK_BENCH_WARPED.get(),
                ModBlockRegistry.BOOKCASE_WARPED.get(),
                "minecraft", "warped");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_FIR.get(),
                ModBlockRegistry.TABLE_FIR.get(),
                ModBlockRegistry.LOCKER_FIR.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_FIR.get(),
                ModBlockRegistry.SCHOOL_DESK_FIR.get(),
                ModBlockRegistry.PARK_BENCH_FIR.get(),
                ModBlockRegistry.BOOKCASE_FIR.get(),
                "biomesoplenty", "fir");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_REDWOOD.get(),
                ModBlockRegistry.TABLE_REDWOOD.get(),
                ModBlockRegistry.LOCKER_REDWOOD.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_REDWOOD.get(),
                ModBlockRegistry.SCHOOL_DESK_REDWOOD.get(),
                ModBlockRegistry.PARK_BENCH_REDWOOD.get(),
                ModBlockRegistry.BOOKCASE_REDWOOD.get(),
                "biomesoplenty", "redwood");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_CHERRY.get(),
                ModBlockRegistry.TABLE_CHERRY.get(),
                ModBlockRegistry.LOCKER_CHERRY.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_CHERRY.get(),
                ModBlockRegistry.SCHOOL_DESK_CHERRY.get(),
                ModBlockRegistry.PARK_BENCH_CHERRY.get(),
                ModBlockRegistry.BOOKCASE_CHERRY.get(),
                "biomesoplenty", "cherry");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_MAHOGANY.get(),
                ModBlockRegistry.TABLE_MAHOGANY.get(),
                ModBlockRegistry.LOCKER_MAHOGANY.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_MAHOGANY.get(),
                ModBlockRegistry.SCHOOL_DESK_MAHOGANY.get(),
                ModBlockRegistry.PARK_BENCH_MAHOGANY.get(),
                ModBlockRegistry.BOOKCASE_MAHOGANY.get(),
                "biomesoplenty", "mahogany");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_JACARANDA.get(),
                ModBlockRegistry.TABLE_JACARANDA.get(),
                ModBlockRegistry.LOCKER_JACARANDA.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_JACARANDA.get(),
                ModBlockRegistry.SCHOOL_DESK_JACARANDA.get(),
                ModBlockRegistry.PARK_BENCH_JACARANDA.get(),
                ModBlockRegistry.BOOKCASE_JACARANDA.get(),
                "biomesoplenty", "jacaranda");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_PALM.get(),
                ModBlockRegistry.TABLE_PALM.get(),
                ModBlockRegistry.LOCKER_PALM.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_PALM.get(),
                ModBlockRegistry.SCHOOL_DESK_PALM.get(),
                ModBlockRegistry.PARK_BENCH_PALM.get(),
                ModBlockRegistry.BOOKCASE_PALM.get(),
                "biomesoplenty", "palm");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_WILLOW.get(),
                ModBlockRegistry.TABLE_WILLOW.get(),
                ModBlockRegistry.LOCKER_WILLOW.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_WILLOW.get(),
                ModBlockRegistry.SCHOOL_DESK_WILLOW.get(),
                ModBlockRegistry.PARK_BENCH_WILLOW.get(),
                ModBlockRegistry.BOOKCASE_WILLOW.get(),
                "biomesoplenty", "willow");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_DEAD.get(),
                ModBlockRegistry.TABLE_DEAD.get(),
                ModBlockRegistry.LOCKER_DEAD.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_DEAD.get(),
                ModBlockRegistry.SCHOOL_DESK_DEAD.get(),
                ModBlockRegistry.PARK_BENCH_DEAD.get(),
                ModBlockRegistry.BOOKCASE_DEAD.get(),
                "biomesoplenty", "dead");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_MAGIC.get(),
                ModBlockRegistry.TABLE_MAGIC.get(),
                ModBlockRegistry.LOCKER_MAGIC.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_MAGIC.get(),
                ModBlockRegistry.SCHOOL_DESK_MAGIC.get(),
                ModBlockRegistry.PARK_BENCH_MAGIC.get(),
                ModBlockRegistry.BOOKCASE_MAGIC.get(),
                "biomesoplenty", "magic");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_UMBRAN.get(),
                ModBlockRegistry.TABLE_UMBRAN.get(),
                ModBlockRegistry.LOCKER_UMBRAN.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_UMBRAN.get(),
                ModBlockRegistry.SCHOOL_DESK_UMBRAN.get(),
                ModBlockRegistry.PARK_BENCH_UMBRAN.get(),
                ModBlockRegistry.BOOKCASE_UMBRAN.get(),
                "biomesoplenty", "umbran");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_HELLBARK.get(),
                ModBlockRegistry.TABLE_HELLBARK.get(),
                ModBlockRegistry.LOCKER_HELLBARK.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_HELLBARK.get(),
                ModBlockRegistry.SCHOOL_DESK_HELLBARK.get(),
                ModBlockRegistry.PARK_BENCH_HELLBARK.get(),
                ModBlockRegistry.BOOKCASE_HELLBARK.get(),
                "biomesoplenty", "hellbark");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_COCONUT.get(),
                ModBlockRegistry.TABLE_COCONUT.get(),
                ModBlockRegistry.LOCKER_COCONUT.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_COCONUT.get(),
                ModBlockRegistry.SCHOOL_DESK_COCONUT.get(),
                ModBlockRegistry.PARK_BENCH_COCONUT.get(),
                ModBlockRegistry.BOOKCASE_COCONUT.get(),
                "ecologics", "coconut");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_WALNUT.get(),
                ModBlockRegistry.TABLE_WALNUT.get(),
                ModBlockRegistry.LOCKER_WALNUT.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_WALNUT.get(),
                ModBlockRegistry.SCHOOL_DESK_WALNUT.get(),
                ModBlockRegistry.PARK_BENCH_WALNUT.get(),
                ModBlockRegistry.BOOKCASE_WALNUT.get(),
                "ecologics", "walnut");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_AZALEA.get(),
                ModBlockRegistry.TABLE_AZALEA.get(),
                ModBlockRegistry.LOCKER_AZALEA.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_AZALEA.get(),
                ModBlockRegistry.SCHOOL_DESK_AZALEA.get(),
                ModBlockRegistry.PARK_BENCH_AZALEA.get(),
                ModBlockRegistry.BOOKCASE_AZALEA.get(),
                "ecologics", "azalea");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_FLOWERING_AZALEA.get(),
                ModBlockRegistry.TABLE_FLOWERING_AZALEA.get(),
                ModBlockRegistry.LOCKER_FLOWERING_AZALEA.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_FLOWERING_AZALEA.get(),
                ModBlockRegistry.SCHOOL_DESK_FLOWERING_AZALEA.get(),
                ModBlockRegistry.PARK_BENCH_FLOWERING_AZALEA.get(),
                ModBlockRegistry.BOOKCASE_FLOWERING_AZALEA.get(),
                "ecologics", "flowering_azalea");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_GOLDEN_OAK.get(),
                ModBlockRegistry.TABLE_GOLDEN_OAK.get(),
                ModBlockRegistry.LOCKER_GOLDEN_OAK.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_GOLDEN_OAK.get(),
                ModBlockRegistry.SCHOOL_DESK_GOLDEN_OAK.get(),
                ModBlockRegistry.PARK_BENCH_GOLDEN_OAK.get(),
                ModBlockRegistry.BOOKCASE_GOLDEN_OAK.get(),
                "aether", "golden_oak");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_AETHER_SKYROOT.get(),
                ModBlockRegistry.TABLE_AETHER_SKYROOT.get(),
                ModBlockRegistry.LOCKER_AETHER_SKYROOT.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_AETHER_SKYROOT.get(),
                ModBlockRegistry.SCHOOL_DESK_AETHER_SKYROOT.get(),
                ModBlockRegistry.PARK_BENCH_AETHER_SKYROOT.get(),
                ModBlockRegistry.BOOKCASE_AETHER_SKYROOT.get(),
                "aether", "skyroot");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_PREAM.get(),
                ModBlockRegistry.TABLE_PREAM.get(),
                ModBlockRegistry.LOCKER_PREAM.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_PREAM.get(),
                ModBlockRegistry.SCHOOL_DESK_PREAM.get(),
                ModBlockRegistry.PARK_BENCH_PREAM.get(),
                ModBlockRegistry.BOOKCASE_PREAM.get(),
                "phantasm", "pream");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_EBONY.get(),
                ModBlockRegistry.TABLE_EBONY.get(),
                ModBlockRegistry.LOCKER_EBONY.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_EBONY.get(),
                ModBlockRegistry.SCHOOL_DESK_EBONY.get(),
                ModBlockRegistry.PARK_BENCH_EBONY.get(),
                ModBlockRegistry.BOOKCASE_EBONY.get(),
                "phantasm", "ebony");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_CHORUS_NEST.get(),
                ModBlockRegistry.TABLE_CHORUS_NEST.get(),
                ModBlockRegistry.LOCKER_CHORUS_NEST.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_CHORUS_NEST.get(),
                ModBlockRegistry.SCHOOL_DESK_CHORUS_NEST.get(),
                ModBlockRegistry.PARK_BENCH_CHORUS_NEST.get(),
                ModBlockRegistry.BOOKCASE_CHORUS_NEST.get(),
                "unusualend", "chorus_nest");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_BLOODSHROOM.get(),
                ModBlockRegistry.TABLE_BLOODSHROOM.get(),
                ModBlockRegistry.LOCKER_BLOODSHROOM.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_BLOODSHROOM.get(),
                ModBlockRegistry.SCHOOL_DESK_BLOODSHROOM.get(),
                ModBlockRegistry.PARK_BENCH_BLOODSHROOM.get(),
                ModBlockRegistry.BOOKCASE_BLOODSHROOM.get(),
                "tconstruct", "bloodshroom");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_ENDERBARK.get(),
                ModBlockRegistry.TABLE_ENDERBARK.get(),
                ModBlockRegistry.LOCKER_ENDERBARK.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_ENDERBARK.get(),
                ModBlockRegistry.SCHOOL_DESK_ENDERBARK.get(),
                ModBlockRegistry.PARK_BENCH_ENDERBARK.get(),
                ModBlockRegistry.BOOKCASE_ENDERBARK.get(),
                "tconstruct", "enderbark");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_GREENHEART.get(),
                ModBlockRegistry.TABLE_GREENHEART.get(),
                ModBlockRegistry.LOCKER_GREENHEART.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_GREENHEART.get(),
                ModBlockRegistry.SCHOOL_DESK_GREENHEART.get(),
                ModBlockRegistry.PARK_BENCH_GREENHEART.get(),
                ModBlockRegistry.BOOKCASE_GREENHEART.get(),
                "tconstruct", "greenheart");
        processVariants(
                ModBlockRegistry.DESK_CHAIR_TINKER_SKYROOT.get(),
                ModBlockRegistry.TABLE_TINKER_SKYROOT.get(),
                ModBlockRegistry.LOCKER_TINKER_SKYROOT.get(),
                ModBlockRegistry.SCHOOL_DESK_CABINET_TINKER_SKYROOT.get(),
                ModBlockRegistry.SCHOOL_DESK_TINKER_SKYROOT.get(),
                ModBlockRegistry.PARK_BENCH_TINKER_SKYROOT.get(),
                ModBlockRegistry.BOOKCASE_TINKER_SKYROOT.get(),
                "tconstruct", "skyroot");

        processPlateVariants(ModBlockRegistry.PLATE_WHITE.get(), MODID, "block/plate_white");
        processPlateVariants(ModBlockRegistry.PLATE_ORANGE.get(), MODID, "block/plate_orange");
        processPlateVariants(ModBlockRegistry.PLATE_MAGENTA.get(), MODID, "block/plate_magenta");
        processPlateVariants(ModBlockRegistry.PLATE_LIGHT_BLUE.get(), MODID, "block/plate_light_blue");
        processPlateVariants(ModBlockRegistry.PLATE_YELLOW.get(), MODID, "block/plate_yellow");
        processPlateVariants(ModBlockRegistry.PLATE_LIME.get(), MODID, "block/plate_lime");
        processPlateVariants(ModBlockRegistry.PLATE_PINK.get(), MODID, "block/plate_pink");
        processPlateVariants(ModBlockRegistry.PLATE_GRAY.get(), MODID, "block/plate_gray");
        processPlateVariants(ModBlockRegistry.PLATE_LIGHT_GRAY.get(), MODID, "block/plate_light_gray");
        processPlateVariants(ModBlockRegistry.PLATE_CYAN.get(), MODID, "block/plate_cyan");
        processPlateVariants(ModBlockRegistry.PLATE_PURPLE.get(), MODID, "block/plate_purple");
        processPlateVariants(ModBlockRegistry.PLATE_BLUE.get(), MODID, "block/plate_blue");
        processPlateVariants(ModBlockRegistry.PLATE_BROWN.get(), MODID, "block/plate_brown");
        processPlateVariants(ModBlockRegistry.PLATE_GREEN.get(), MODID, "block/plate_green");
        processPlateVariants(ModBlockRegistry.PLATE_RED.get(), MODID, "block/plate_red");
        processPlateVariants(ModBlockRegistry.PLATE_BLACK.get(), MODID, "block/plate_black");
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