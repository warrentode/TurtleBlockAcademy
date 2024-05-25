package com.github.warrentode.turtleblockacademy.datagen.models;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
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

public class TBABlockStatesProvider extends BlockStateProvider {
    private static final int DEFAULT_ANGLE_OFFSET = 180;

    public TBABlockStatesProvider(DataGenerator generator, String ignoredModid, ExistingFileHelper helper) {
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
        horizontalBlock(TBABlocks.CERTIFICATE_BLOCK.get(), existingModel(TBABlocks.CERTIFICATE_BLOCK.get()));

        processVariants(
                TBABlocks.DESK_CHAIR_ACACIA.get(),
                TBABlocks.TABLE_ACACIA.get(),
                TBABlocks.LOCKER_ACACIA.get(),
                TBABlocks.SCHOOL_DESK_CABINET_ACACIA.get(),
                TBABlocks.SCHOOL_DESK_ACACIA.get(),
                TBABlocks.PARK_BENCH_ACACIA.get(),
                TBABlocks.BOOKCASE_ACACIA.get(),
                "minecraft", "acacia");
        processVariants(
                TBABlocks.DESK_CHAIR_BIRCH.get(),
                TBABlocks.TABLE_BIRCH.get(),
                TBABlocks.LOCKER_BIRCH.get(),
                TBABlocks.SCHOOL_DESK_CABINET_BIRCH.get(),
                TBABlocks.SCHOOL_DESK_BIRCH.get(),
                TBABlocks.PARK_BENCH_BIRCH.get(),
                TBABlocks.BOOKCASE_BIRCH.get(),
                "minecraft", "birch");
        processVariants(
                TBABlocks.DESK_CHAIR_CRIMSON.get(),
                TBABlocks.TABLE_CRIMSON.get(),
                TBABlocks.LOCKER_CRIMSON.get(),
                TBABlocks.SCHOOL_DESK_CABINET_CRIMSON.get(),
                TBABlocks.SCHOOL_DESK_CRIMSON.get(),
                TBABlocks.PARK_BENCH_CRIMSON.get(),
                TBABlocks.BOOKCASE_CRIMSON.get(),
                "minecraft", "crimson");
        processVariants(
                TBABlocks.DESK_CHAIR_DARK_OAK.get(),
                TBABlocks.TABLE_DARK_OAK.get(),
                TBABlocks.LOCKER_DARK_OAK.get(),
                TBABlocks.SCHOOL_DESK_CABINET_DARK_OAK.get(),
                TBABlocks.SCHOOL_DESK_DARK_OAK.get(),
                TBABlocks.PARK_BENCH_DARK_OAK.get(),
                TBABlocks.BOOKCASE_DARK_OAK.get(),
                "minecraft", "dark_oak");
        processVariants(
                TBABlocks.DESK_CHAIR_JUNGLE.get(),
                TBABlocks.TABLE_JUNGLE.get(),
                TBABlocks.LOCKER_JUNGLE.get(),
                TBABlocks.SCHOOL_DESK_CABINET_JUNGLE.get(),
                TBABlocks.SCHOOL_DESK_JUNGLE.get(),
                TBABlocks.PARK_BENCH_JUNGLE.get(),
                TBABlocks.BOOKCASE_JUNGLE.get(),
                "minecraft", "jungle");
        processVariants(
                TBABlocks.DESK_CHAIR_SPRUCE.get(),
                TBABlocks.TABLE_SPRUCE.get(),
                TBABlocks.LOCKER_SPRUCE.get(),
                TBABlocks.SCHOOL_DESK_CABINET_SPRUCE.get(),
                TBABlocks.SCHOOL_DESK_SPRUCE.get(),
                TBABlocks.PARK_BENCH_SPRUCE.get(),
                TBABlocks.BOOKCASE_SPRUCE.get(),
                "minecraft", "spruce");
        processVariants(
                TBABlocks.DESK_CHAIR_MANGROVE.get(),
                TBABlocks.TABLE_MANGROVE.get(),
                TBABlocks.LOCKER_MANGROVE.get(),
                TBABlocks.SCHOOL_DESK_CABINET_MANGROVE.get(),
                TBABlocks.SCHOOL_DESK_MANGROVE.get(),
                TBABlocks.PARK_BENCH_MANGROVE.get(),
                TBABlocks.BOOKCASE_MANGROVE.get(),
                "minecraft", "mangrove");
        processVariants(
                TBABlocks.DESK_CHAIR_OAK.get(),
                TBABlocks.TABLE_OAK.get(),
                TBABlocks.LOCKER_OAK.get(),
                TBABlocks.SCHOOL_DESK_CABINET_OAK.get(),
                TBABlocks.SCHOOL_DESK_OAK.get(),
                TBABlocks.PARK_BENCH_OAK.get(),
                TBABlocks.BOOKCASE_OAK.get(),
                "minecraft", "oak");
        processVariants(
                TBABlocks.DESK_CHAIR_WARPED.get(),
                TBABlocks.TABLE_WARPED.get(),
                TBABlocks.LOCKER_WARPED.get(),
                TBABlocks.SCHOOL_DESK_CABINET_WARPED.get(),
                TBABlocks.SCHOOL_DESK_WARPED.get(),
                TBABlocks.PARK_BENCH_WARPED.get(),
                TBABlocks.BOOKCASE_WARPED.get(),
                "minecraft", "warped");
        processVariants(
                TBABlocks.DESK_CHAIR_FIR.get(),
                TBABlocks.TABLE_FIR.get(),
                TBABlocks.LOCKER_FIR.get(),
                TBABlocks.SCHOOL_DESK_CABINET_FIR.get(),
                TBABlocks.SCHOOL_DESK_FIR.get(),
                TBABlocks.PARK_BENCH_FIR.get(),
                TBABlocks.BOOKCASE_FIR.get(),
                "biomesoplenty", "fir");
        processVariants(
                TBABlocks.DESK_CHAIR_REDWOOD.get(),
                TBABlocks.TABLE_REDWOOD.get(),
                TBABlocks.LOCKER_REDWOOD.get(),
                TBABlocks.SCHOOL_DESK_CABINET_REDWOOD.get(),
                TBABlocks.SCHOOL_DESK_REDWOOD.get(),
                TBABlocks.PARK_BENCH_REDWOOD.get(),
                TBABlocks.BOOKCASE_REDWOOD.get(),
                "biomesoplenty", "redwood");
        processVariants(
                TBABlocks.DESK_CHAIR_CHERRY.get(),
                TBABlocks.TABLE_CHERRY.get(),
                TBABlocks.LOCKER_CHERRY.get(),
                TBABlocks.SCHOOL_DESK_CABINET_CHERRY.get(),
                TBABlocks.SCHOOL_DESK_CHERRY.get(),
                TBABlocks.PARK_BENCH_CHERRY.get(),
                TBABlocks.BOOKCASE_CHERRY.get(),
                "biomesoplenty", "cherry");
        processVariants(
                TBABlocks.DESK_CHAIR_MAHOGANY.get(),
                TBABlocks.TABLE_MAHOGANY.get(),
                TBABlocks.LOCKER_MAHOGANY.get(),
                TBABlocks.SCHOOL_DESK_CABINET_MAHOGANY.get(),
                TBABlocks.SCHOOL_DESK_MAHOGANY.get(),
                TBABlocks.PARK_BENCH_MAHOGANY.get(),
                TBABlocks.BOOKCASE_MAHOGANY.get(),
                "biomesoplenty", "mahogany");
        processVariants(
                TBABlocks.DESK_CHAIR_JACARANDA.get(),
                TBABlocks.TABLE_JACARANDA.get(),
                TBABlocks.LOCKER_JACARANDA.get(),
                TBABlocks.SCHOOL_DESK_CABINET_JACARANDA.get(),
                TBABlocks.SCHOOL_DESK_JACARANDA.get(),
                TBABlocks.PARK_BENCH_JACARANDA.get(),
                TBABlocks.BOOKCASE_JACARANDA.get(),
                "biomesoplenty", "jacaranda");
        processVariants(
                TBABlocks.DESK_CHAIR_PALM.get(),
                TBABlocks.TABLE_PALM.get(),
                TBABlocks.LOCKER_PALM.get(),
                TBABlocks.SCHOOL_DESK_CABINET_PALM.get(),
                TBABlocks.SCHOOL_DESK_PALM.get(),
                TBABlocks.PARK_BENCH_PALM.get(),
                TBABlocks.BOOKCASE_PALM.get(),
                "biomesoplenty", "palm");
        processVariants(
                TBABlocks.DESK_CHAIR_WILLOW.get(),
                TBABlocks.TABLE_WILLOW.get(),
                TBABlocks.LOCKER_WILLOW.get(),
                TBABlocks.SCHOOL_DESK_CABINET_WILLOW.get(),
                TBABlocks.SCHOOL_DESK_WILLOW.get(),
                TBABlocks.PARK_BENCH_WILLOW.get(),
                TBABlocks.BOOKCASE_WILLOW.get(),
                "biomesoplenty", "willow");
        processVariants(
                TBABlocks.DESK_CHAIR_DEAD.get(),
                TBABlocks.TABLE_DEAD.get(),
                TBABlocks.LOCKER_DEAD.get(),
                TBABlocks.SCHOOL_DESK_CABINET_DEAD.get(),
                TBABlocks.SCHOOL_DESK_DEAD.get(),
                TBABlocks.PARK_BENCH_DEAD.get(),
                TBABlocks.BOOKCASE_DEAD.get(),
                "biomesoplenty", "dead");
        processVariants(
                TBABlocks.DESK_CHAIR_MAGIC.get(),
                TBABlocks.TABLE_MAGIC.get(),
                TBABlocks.LOCKER_MAGIC.get(),
                TBABlocks.SCHOOL_DESK_CABINET_MAGIC.get(),
                TBABlocks.SCHOOL_DESK_MAGIC.get(),
                TBABlocks.PARK_BENCH_MAGIC.get(),
                TBABlocks.BOOKCASE_MAGIC.get(),
                "biomesoplenty", "magic");
        processVariants(
                TBABlocks.DESK_CHAIR_UMBRAN.get(),
                TBABlocks.TABLE_UMBRAN.get(),
                TBABlocks.LOCKER_UMBRAN.get(),
                TBABlocks.SCHOOL_DESK_CABINET_UMBRAN.get(),
                TBABlocks.SCHOOL_DESK_UMBRAN.get(),
                TBABlocks.PARK_BENCH_UMBRAN.get(),
                TBABlocks.BOOKCASE_UMBRAN.get(),
                "biomesoplenty", "umbran");
        processVariants(
                TBABlocks.DESK_CHAIR_HELLBARK.get(),
                TBABlocks.TABLE_HELLBARK.get(),
                TBABlocks.LOCKER_HELLBARK.get(),
                TBABlocks.SCHOOL_DESK_CABINET_HELLBARK.get(),
                TBABlocks.SCHOOL_DESK_HELLBARK.get(),
                TBABlocks.PARK_BENCH_HELLBARK.get(),
                TBABlocks.BOOKCASE_HELLBARK.get(),
                "biomesoplenty", "hellbark");
        processVariants(
                TBABlocks.DESK_CHAIR_COCONUT.get(),
                TBABlocks.TABLE_COCONUT.get(),
                TBABlocks.LOCKER_COCONUT.get(),
                TBABlocks.SCHOOL_DESK_CABINET_COCONUT.get(),
                TBABlocks.SCHOOL_DESK_COCONUT.get(),
                TBABlocks.PARK_BENCH_COCONUT.get(),
                TBABlocks.BOOKCASE_COCONUT.get(),
                "ecologics", "coconut");
        processVariants(
                TBABlocks.DESK_CHAIR_WALNUT.get(),
                TBABlocks.TABLE_WALNUT.get(),
                TBABlocks.LOCKER_WALNUT.get(),
                TBABlocks.SCHOOL_DESK_CABINET_WALNUT.get(),
                TBABlocks.SCHOOL_DESK_WALNUT.get(),
                TBABlocks.PARK_BENCH_WALNUT.get(),
                TBABlocks.BOOKCASE_WALNUT.get(),
                "ecologics", "walnut");
        processVariants(
                TBABlocks.DESK_CHAIR_AZALEA.get(),
                TBABlocks.TABLE_AZALEA.get(),
                TBABlocks.LOCKER_AZALEA.get(),
                TBABlocks.SCHOOL_DESK_CABINET_AZALEA.get(),
                TBABlocks.SCHOOL_DESK_AZALEA.get(),
                TBABlocks.PARK_BENCH_AZALEA.get(),
                TBABlocks.BOOKCASE_AZALEA.get(),
                "ecologics", "azalea");
        processVariants(
                TBABlocks.DESK_CHAIR_FLOWERING_AZALEA.get(),
                TBABlocks.TABLE_FLOWERING_AZALEA.get(),
                TBABlocks.LOCKER_FLOWERING_AZALEA.get(),
                TBABlocks.SCHOOL_DESK_CABINET_FLOWERING_AZALEA.get(),
                TBABlocks.SCHOOL_DESK_FLOWERING_AZALEA.get(),
                TBABlocks.PARK_BENCH_FLOWERING_AZALEA.get(),
                TBABlocks.BOOKCASE_FLOWERING_AZALEA.get(),
                "ecologics", "flowering_azalea");
        processVariants(
                TBABlocks.DESK_CHAIR_GOLDEN_OAK.get(),
                TBABlocks.TABLE_GOLDEN_OAK.get(),
                TBABlocks.LOCKER_GOLDEN_OAK.get(),
                TBABlocks.SCHOOL_DESK_CABINET_GOLDEN_OAK.get(),
                TBABlocks.SCHOOL_DESK_GOLDEN_OAK.get(),
                TBABlocks.PARK_BENCH_GOLDEN_OAK.get(),
                TBABlocks.BOOKCASE_GOLDEN_OAK.get(),
                "aether", "golden_oak");
        processVariants(
                TBABlocks.DESK_CHAIR_AETHER_SKYROOT.get(),
                TBABlocks.TABLE_AETHER_SKYROOT.get(),
                TBABlocks.LOCKER_AETHER_SKYROOT.get(),
                TBABlocks.SCHOOL_DESK_CABINET_AETHER_SKYROOT.get(),
                TBABlocks.SCHOOL_DESK_AETHER_SKYROOT.get(),
                TBABlocks.PARK_BENCH_AETHER_SKYROOT.get(),
                TBABlocks.BOOKCASE_AETHER_SKYROOT.get(),
                "aether", "skyroot");
        processVariants(
                TBABlocks.DESK_CHAIR_PREAM.get(),
                TBABlocks.TABLE_PREAM.get(),
                TBABlocks.LOCKER_PREAM.get(),
                TBABlocks.SCHOOL_DESK_CABINET_PREAM.get(),
                TBABlocks.SCHOOL_DESK_PREAM.get(),
                TBABlocks.PARK_BENCH_PREAM.get(),
                TBABlocks.BOOKCASE_PREAM.get(),
                "phantasm", "pream");
        processVariants(
                TBABlocks.DESK_CHAIR_EBONY.get(),
                TBABlocks.TABLE_EBONY.get(),
                TBABlocks.LOCKER_EBONY.get(),
                TBABlocks.SCHOOL_DESK_CABINET_EBONY.get(),
                TBABlocks.SCHOOL_DESK_EBONY.get(),
                TBABlocks.PARK_BENCH_EBONY.get(),
                TBABlocks.BOOKCASE_EBONY.get(),
                "phantasm", "ebony");
        processVariants(
                TBABlocks.DESK_CHAIR_CHORUS_NEST.get(),
                TBABlocks.TABLE_CHORUS_NEST.get(),
                TBABlocks.LOCKER_CHORUS_NEST.get(),
                TBABlocks.SCHOOL_DESK_CABINET_CHORUS_NEST.get(),
                TBABlocks.SCHOOL_DESK_CHORUS_NEST.get(),
                TBABlocks.PARK_BENCH_CHORUS_NEST.get(),
                TBABlocks.BOOKCASE_CHORUS_NEST.get(),
                "unusualend", "chorus_nest");
        processVariants(
                TBABlocks.DESK_CHAIR_BLOODSHROOM.get(),
                TBABlocks.TABLE_BLOODSHROOM.get(),
                TBABlocks.LOCKER_BLOODSHROOM.get(),
                TBABlocks.SCHOOL_DESK_CABINET_BLOODSHROOM.get(),
                TBABlocks.SCHOOL_DESK_BLOODSHROOM.get(),
                TBABlocks.PARK_BENCH_BLOODSHROOM.get(),
                TBABlocks.BOOKCASE_BLOODSHROOM.get(),
                "tconstruct", "bloodshroom");
        processVariants(
                TBABlocks.DESK_CHAIR_ENDERBARK.get(),
                TBABlocks.TABLE_ENDERBARK.get(),
                TBABlocks.LOCKER_ENDERBARK.get(),
                TBABlocks.SCHOOL_DESK_CABINET_ENDERBARK.get(),
                TBABlocks.SCHOOL_DESK_ENDERBARK.get(),
                TBABlocks.PARK_BENCH_ENDERBARK.get(),
                TBABlocks.BOOKCASE_ENDERBARK.get(),
                "tconstruct", "enderbark");
        processVariants(
                TBABlocks.DESK_CHAIR_GREENHEART.get(),
                TBABlocks.TABLE_GREENHEART.get(),
                TBABlocks.LOCKER_GREENHEART.get(),
                TBABlocks.SCHOOL_DESK_CABINET_GREENHEART.get(),
                TBABlocks.SCHOOL_DESK_GREENHEART.get(),
                TBABlocks.PARK_BENCH_GREENHEART.get(),
                TBABlocks.BOOKCASE_GREENHEART.get(),
                "tconstruct", "greenheart");
        processVariants(
                TBABlocks.DESK_CHAIR_TINKER_SKYROOT.get(),
                TBABlocks.TABLE_TINKER_SKYROOT.get(),
                TBABlocks.LOCKER_TINKER_SKYROOT.get(),
                TBABlocks.SCHOOL_DESK_CABINET_TINKER_SKYROOT.get(),
                TBABlocks.SCHOOL_DESK_TINKER_SKYROOT.get(),
                TBABlocks.PARK_BENCH_TINKER_SKYROOT.get(),
                TBABlocks.BOOKCASE_TINKER_SKYROOT.get(),
                "tconstruct", "skyroot");

        processPlateVariants(TBABlocks.PLATE_WHITE.get(), MODID, "block/plate_white");
        processPlateVariants(TBABlocks.PLATE_ORANGE.get(), MODID, "block/plate_orange");
        processPlateVariants(TBABlocks.PLATE_MAGENTA.get(), MODID, "block/plate_magenta");
        processPlateVariants(TBABlocks.PLATE_LIGHT_BLUE.get(), MODID, "block/plate_light_blue");
        processPlateVariants(TBABlocks.PLATE_YELLOW.get(), MODID, "block/plate_yellow");
        processPlateVariants(TBABlocks.PLATE_LIME.get(), MODID, "block/plate_lime");
        processPlateVariants(TBABlocks.PLATE_PINK.get(), MODID, "block/plate_pink");
        processPlateVariants(TBABlocks.PLATE_GRAY.get(), MODID, "block/plate_gray");
        processPlateVariants(TBABlocks.PLATE_LIGHT_GRAY.get(), MODID, "block/plate_light_gray");
        processPlateVariants(TBABlocks.PLATE_CYAN.get(), MODID, "block/plate_cyan");
        processPlateVariants(TBABlocks.PLATE_PURPLE.get(), MODID, "block/plate_purple");
        processPlateVariants(TBABlocks.PLATE_BLUE.get(), MODID, "block/plate_blue");
        processPlateVariants(TBABlocks.PLATE_BROWN.get(), MODID, "block/plate_brown");
        processPlateVariants(TBABlocks.PLATE_GREEN.get(), MODID, "block/plate_green");
        processPlateVariants(TBABlocks.PLATE_RED.get(), MODID, "block/plate_red");
        processPlateVariants(TBABlocks.PLATE_BLACK.get(), MODID, "block/plate_black");
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