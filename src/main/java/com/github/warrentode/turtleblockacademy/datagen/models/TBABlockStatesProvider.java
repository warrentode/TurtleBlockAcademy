package com.github.warrentode.turtleblockacademy.datagen.models;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
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
    protected static final ExistingFileHelper.ResourceType TEXTURE
            = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES,
            ".png", "textures");
    public final ExistingFileHelper helper;

    public TBABlockStatesProvider(DataGenerator generator, String ignoredModid, ExistingFileHelper helper) {
        super(generator, MODID, helper);
        this.helper = helper;
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

        processWoodVariants(
                TBABlocks.DESK_CHAIR_ACACIA.get(),
                TBABlocks.TABLE_ACACIA.get(),
                TBABlocks.LOCKER_ACACIA.get(),
                TBABlocks.SCHOOL_DESK_CABINET_ACACIA.get(),
                TBABlocks.SCHOOL_DESK_ACACIA.get(),
                TBABlocks.PARK_BENCH_ACACIA.get(),
                TBABlocks.BOOKCASE_ACACIA.get(),
                "minecraft", "acacia");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_BIRCH.get(),
                TBABlocks.TABLE_BIRCH.get(),
                TBABlocks.LOCKER_BIRCH.get(),
                TBABlocks.SCHOOL_DESK_CABINET_BIRCH.get(),
                TBABlocks.SCHOOL_DESK_BIRCH.get(),
                TBABlocks.PARK_BENCH_BIRCH.get(),
                TBABlocks.BOOKCASE_BIRCH.get(),
                "minecraft", "birch");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_CRIMSON.get(),
                TBABlocks.TABLE_CRIMSON.get(),
                TBABlocks.LOCKER_CRIMSON.get(),
                TBABlocks.SCHOOL_DESK_CABINET_CRIMSON.get(),
                TBABlocks.SCHOOL_DESK_CRIMSON.get(),
                TBABlocks.PARK_BENCH_CRIMSON.get(),
                TBABlocks.BOOKCASE_CRIMSON.get(),
                "minecraft", "crimson");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_DARK_OAK.get(),
                TBABlocks.TABLE_DARK_OAK.get(),
                TBABlocks.LOCKER_DARK_OAK.get(),
                TBABlocks.SCHOOL_DESK_CABINET_DARK_OAK.get(),
                TBABlocks.SCHOOL_DESK_DARK_OAK.get(),
                TBABlocks.PARK_BENCH_DARK_OAK.get(),
                TBABlocks.BOOKCASE_DARK_OAK.get(),
                "minecraft", "dark_oak");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_JUNGLE.get(),
                TBABlocks.TABLE_JUNGLE.get(),
                TBABlocks.LOCKER_JUNGLE.get(),
                TBABlocks.SCHOOL_DESK_CABINET_JUNGLE.get(),
                TBABlocks.SCHOOL_DESK_JUNGLE.get(),
                TBABlocks.PARK_BENCH_JUNGLE.get(),
                TBABlocks.BOOKCASE_JUNGLE.get(),
                "minecraft", "jungle");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_SPRUCE.get(),
                TBABlocks.TABLE_SPRUCE.get(),
                TBABlocks.LOCKER_SPRUCE.get(),
                TBABlocks.SCHOOL_DESK_CABINET_SPRUCE.get(),
                TBABlocks.SCHOOL_DESK_SPRUCE.get(),
                TBABlocks.PARK_BENCH_SPRUCE.get(),
                TBABlocks.BOOKCASE_SPRUCE.get(),
                "minecraft", "spruce");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_MANGROVE.get(),
                TBABlocks.TABLE_MANGROVE.get(),
                TBABlocks.LOCKER_MANGROVE.get(),
                TBABlocks.SCHOOL_DESK_CABINET_MANGROVE.get(),
                TBABlocks.SCHOOL_DESK_MANGROVE.get(),
                TBABlocks.PARK_BENCH_MANGROVE.get(),
                TBABlocks.BOOKCASE_MANGROVE.get(),
                "minecraft", "mangrove");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_OAK.get(),
                TBABlocks.TABLE_OAK.get(),
                TBABlocks.LOCKER_OAK.get(),
                TBABlocks.SCHOOL_DESK_CABINET_OAK.get(),
                TBABlocks.SCHOOL_DESK_OAK.get(),
                TBABlocks.PARK_BENCH_OAK.get(),
                TBABlocks.BOOKCASE_OAK.get(),
                "minecraft", "oak");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_WARPED.get(),
                TBABlocks.TABLE_WARPED.get(),
                TBABlocks.LOCKER_WARPED.get(),
                TBABlocks.SCHOOL_DESK_CABINET_WARPED.get(),
                TBABlocks.SCHOOL_DESK_WARPED.get(),
                TBABlocks.PARK_BENCH_WARPED.get(),
                TBABlocks.BOOKCASE_WARPED.get(),
                "minecraft", "warped");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_FIR.get(),
                TBABlocks.TABLE_FIR.get(),
                TBABlocks.LOCKER_FIR.get(),
                TBABlocks.SCHOOL_DESK_CABINET_FIR.get(),
                TBABlocks.SCHOOL_DESK_FIR.get(),
                TBABlocks.PARK_BENCH_FIR.get(),
                TBABlocks.BOOKCASE_FIR.get(),
                "biomesoplenty", "fir");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_REDWOOD.get(),
                TBABlocks.TABLE_REDWOOD.get(),
                TBABlocks.LOCKER_REDWOOD.get(),
                TBABlocks.SCHOOL_DESK_CABINET_REDWOOD.get(),
                TBABlocks.SCHOOL_DESK_REDWOOD.get(),
                TBABlocks.PARK_BENCH_REDWOOD.get(),
                TBABlocks.BOOKCASE_REDWOOD.get(),
                "biomesoplenty", "redwood");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_CHERRY.get(),
                TBABlocks.TABLE_CHERRY.get(),
                TBABlocks.LOCKER_CHERRY.get(),
                TBABlocks.SCHOOL_DESK_CABINET_CHERRY.get(),
                TBABlocks.SCHOOL_DESK_CHERRY.get(),
                TBABlocks.PARK_BENCH_CHERRY.get(),
                TBABlocks.BOOKCASE_CHERRY.get(),
                "biomesoplenty", "cherry");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_MAHOGANY.get(),
                TBABlocks.TABLE_MAHOGANY.get(),
                TBABlocks.LOCKER_MAHOGANY.get(),
                TBABlocks.SCHOOL_DESK_CABINET_MAHOGANY.get(),
                TBABlocks.SCHOOL_DESK_MAHOGANY.get(),
                TBABlocks.PARK_BENCH_MAHOGANY.get(),
                TBABlocks.BOOKCASE_MAHOGANY.get(),
                "biomesoplenty", "mahogany");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_JACARANDA.get(),
                TBABlocks.TABLE_JACARANDA.get(),
                TBABlocks.LOCKER_JACARANDA.get(),
                TBABlocks.SCHOOL_DESK_CABINET_JACARANDA.get(),
                TBABlocks.SCHOOL_DESK_JACARANDA.get(),
                TBABlocks.PARK_BENCH_JACARANDA.get(),
                TBABlocks.BOOKCASE_JACARANDA.get(),
                "biomesoplenty", "jacaranda");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_PALM.get(),
                TBABlocks.TABLE_PALM.get(),
                TBABlocks.LOCKER_PALM.get(),
                TBABlocks.SCHOOL_DESK_CABINET_PALM.get(),
                TBABlocks.SCHOOL_DESK_PALM.get(),
                TBABlocks.PARK_BENCH_PALM.get(),
                TBABlocks.BOOKCASE_PALM.get(),
                "biomesoplenty", "palm");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_WILLOW.get(),
                TBABlocks.TABLE_WILLOW.get(),
                TBABlocks.LOCKER_WILLOW.get(),
                TBABlocks.SCHOOL_DESK_CABINET_WILLOW.get(),
                TBABlocks.SCHOOL_DESK_WILLOW.get(),
                TBABlocks.PARK_BENCH_WILLOW.get(),
                TBABlocks.BOOKCASE_WILLOW.get(),
                "biomesoplenty", "willow");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_DEAD.get(),
                TBABlocks.TABLE_DEAD.get(),
                TBABlocks.LOCKER_DEAD.get(),
                TBABlocks.SCHOOL_DESK_CABINET_DEAD.get(),
                TBABlocks.SCHOOL_DESK_DEAD.get(),
                TBABlocks.PARK_BENCH_DEAD.get(),
                TBABlocks.BOOKCASE_DEAD.get(),
                "biomesoplenty", "dead");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_MAGIC.get(),
                TBABlocks.TABLE_MAGIC.get(),
                TBABlocks.LOCKER_MAGIC.get(),
                TBABlocks.SCHOOL_DESK_CABINET_MAGIC.get(),
                TBABlocks.SCHOOL_DESK_MAGIC.get(),
                TBABlocks.PARK_BENCH_MAGIC.get(),
                TBABlocks.BOOKCASE_MAGIC.get(),
                "biomesoplenty", "magic");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_UMBRAN.get(),
                TBABlocks.TABLE_UMBRAN.get(),
                TBABlocks.LOCKER_UMBRAN.get(),
                TBABlocks.SCHOOL_DESK_CABINET_UMBRAN.get(),
                TBABlocks.SCHOOL_DESK_UMBRAN.get(),
                TBABlocks.PARK_BENCH_UMBRAN.get(),
                TBABlocks.BOOKCASE_UMBRAN.get(),
                "biomesoplenty", "umbran");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_HELLBARK.get(),
                TBABlocks.TABLE_HELLBARK.get(),
                TBABlocks.LOCKER_HELLBARK.get(),
                TBABlocks.SCHOOL_DESK_CABINET_HELLBARK.get(),
                TBABlocks.SCHOOL_DESK_HELLBARK.get(),
                TBABlocks.PARK_BENCH_HELLBARK.get(),
                TBABlocks.BOOKCASE_HELLBARK.get(),
                "biomesoplenty", "hellbark");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_COCONUT.get(),
                TBABlocks.TABLE_COCONUT.get(),
                TBABlocks.LOCKER_COCONUT.get(),
                TBABlocks.SCHOOL_DESK_CABINET_COCONUT.get(),
                TBABlocks.SCHOOL_DESK_COCONUT.get(),
                TBABlocks.PARK_BENCH_COCONUT.get(),
                TBABlocks.BOOKCASE_COCONUT.get(),
                "ecologics", "coconut");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_WALNUT.get(),
                TBABlocks.TABLE_WALNUT.get(),
                TBABlocks.LOCKER_WALNUT.get(),
                TBABlocks.SCHOOL_DESK_CABINET_WALNUT.get(),
                TBABlocks.SCHOOL_DESK_WALNUT.get(),
                TBABlocks.PARK_BENCH_WALNUT.get(),
                TBABlocks.BOOKCASE_WALNUT.get(),
                "ecologics", "walnut");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_AZALEA.get(),
                TBABlocks.TABLE_AZALEA.get(),
                TBABlocks.LOCKER_AZALEA.get(),
                TBABlocks.SCHOOL_DESK_CABINET_AZALEA.get(),
                TBABlocks.SCHOOL_DESK_AZALEA.get(),
                TBABlocks.PARK_BENCH_AZALEA.get(),
                TBABlocks.BOOKCASE_AZALEA.get(),
                "ecologics", "azalea");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_FLOWERING_AZALEA.get(),
                TBABlocks.TABLE_FLOWERING_AZALEA.get(),
                TBABlocks.LOCKER_FLOWERING_AZALEA.get(),
                TBABlocks.SCHOOL_DESK_CABINET_FLOWERING_AZALEA.get(),
                TBABlocks.SCHOOL_DESK_FLOWERING_AZALEA.get(),
                TBABlocks.PARK_BENCH_FLOWERING_AZALEA.get(),
                TBABlocks.BOOKCASE_FLOWERING_AZALEA.get(),
                "ecologics", "flowering_azalea");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_GOLDEN_OAK.get(),
                TBABlocks.TABLE_GOLDEN_OAK.get(),
                TBABlocks.LOCKER_GOLDEN_OAK.get(),
                TBABlocks.SCHOOL_DESK_CABINET_GOLDEN_OAK.get(),
                TBABlocks.SCHOOL_DESK_GOLDEN_OAK.get(),
                TBABlocks.PARK_BENCH_GOLDEN_OAK.get(),
                TBABlocks.BOOKCASE_GOLDEN_OAK.get(),
                "aether", "golden_oak");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_AETHER_SKYROOT.get(),
                TBABlocks.TABLE_AETHER_SKYROOT.get(),
                TBABlocks.LOCKER_AETHER_SKYROOT.get(),
                TBABlocks.SCHOOL_DESK_CABINET_AETHER_SKYROOT.get(),
                TBABlocks.SCHOOL_DESK_AETHER_SKYROOT.get(),
                TBABlocks.PARK_BENCH_AETHER_SKYROOT.get(),
                TBABlocks.BOOKCASE_AETHER_SKYROOT.get(),
                "aether", "skyroot");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_PREAM.get(),
                TBABlocks.TABLE_PREAM.get(),
                TBABlocks.LOCKER_PREAM.get(),
                TBABlocks.SCHOOL_DESK_CABINET_PREAM.get(),
                TBABlocks.SCHOOL_DESK_PREAM.get(),
                TBABlocks.PARK_BENCH_PREAM.get(),
                TBABlocks.BOOKCASE_PREAM.get(),
                "phantasm", "pream");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_EBONY.get(),
                TBABlocks.TABLE_EBONY.get(),
                TBABlocks.LOCKER_EBONY.get(),
                TBABlocks.SCHOOL_DESK_CABINET_EBONY.get(),
                TBABlocks.SCHOOL_DESK_EBONY.get(),
                TBABlocks.PARK_BENCH_EBONY.get(),
                TBABlocks.BOOKCASE_EBONY.get(),
                "phantasm", "ebony");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_CHORUS_NEST.get(),
                TBABlocks.TABLE_CHORUS_NEST.get(),
                TBABlocks.LOCKER_CHORUS_NEST.get(),
                TBABlocks.SCHOOL_DESK_CABINET_CHORUS_NEST.get(),
                TBABlocks.SCHOOL_DESK_CHORUS_NEST.get(),
                TBABlocks.PARK_BENCH_CHORUS_NEST.get(),
                TBABlocks.BOOKCASE_CHORUS_NEST.get(),
                "unusualend", "chorus_nest");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_BLOODSHROOM.get(),
                TBABlocks.TABLE_BLOODSHROOM.get(),
                TBABlocks.LOCKER_BLOODSHROOM.get(),
                TBABlocks.SCHOOL_DESK_CABINET_BLOODSHROOM.get(),
                TBABlocks.SCHOOL_DESK_BLOODSHROOM.get(),
                TBABlocks.PARK_BENCH_BLOODSHROOM.get(),
                TBABlocks.BOOKCASE_BLOODSHROOM.get(),
                "tconstruct", "bloodshroom");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_ENDERBARK.get(),
                TBABlocks.TABLE_ENDERBARK.get(),
                TBABlocks.LOCKER_ENDERBARK.get(),
                TBABlocks.SCHOOL_DESK_CABINET_ENDERBARK.get(),
                TBABlocks.SCHOOL_DESK_ENDERBARK.get(),
                TBABlocks.PARK_BENCH_ENDERBARK.get(),
                TBABlocks.BOOKCASE_ENDERBARK.get(),
                "tconstruct", "enderbark");
        processWoodVariants(
                TBABlocks.DESK_CHAIR_GREENHEART.get(),
                TBABlocks.TABLE_GREENHEART.get(),
                TBABlocks.LOCKER_GREENHEART.get(),
                TBABlocks.SCHOOL_DESK_CABINET_GREENHEART.get(),
                TBABlocks.SCHOOL_DESK_GREENHEART.get(),
                TBABlocks.PARK_BENCH_GREENHEART.get(),
                TBABlocks.BOOKCASE_GREENHEART.get(),
                "tconstruct", "greenheart");
        processWoodVariants(
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

        processBasketVariants(TBABlocks.BASKET_OAK_WHITE.get(), "minecraft", "oak", "white");
        processBasketVariants(TBABlocks.BASKET_OAK_LIGHT_GRAY.get(), "minecraft", "oak", "light_gray");
        processBasketVariants(TBABlocks.BASKET_OAK_GRAY.get(), "minecraft", "oak", "gray");
        processBasketVariants(TBABlocks.BASKET_OAK_BLACK.get(), "minecraft", "oak", "black");
        processBasketVariants(TBABlocks.BASKET_OAK_BROWN.get(), "minecraft", "oak", "brown");
        processBasketVariants(TBABlocks.BASKET_OAK_RED.get(), "minecraft", "oak", "red");
        processBasketVariants(TBABlocks.BASKET_OAK_ORANGE.get(), "minecraft", "oak", "orange");
        processBasketVariants(TBABlocks.BASKET_OAK_YELLOW.get(), "minecraft", "oak", "yellow");
        processBasketVariants(TBABlocks.BASKET_OAK_LIME.get(), "minecraft", "oak", "lime");
        processBasketVariants(TBABlocks.BASKET_OAK_GREEN.get(), "minecraft", "oak", "green");
        processBasketVariants(TBABlocks.BASKET_OAK_CYAN.get(), "minecraft", "oak", "cyan");
        processBasketVariants(TBABlocks.BASKET_OAK_BLUE.get(), "minecraft", "oak", "blue");
        processBasketVariants(TBABlocks.BASKET_OAK_LIGHT_BLUE.get(), "minecraft", "oak", "light_blue");
        processBasketVariants(TBABlocks.BASKET_OAK_PURPLE.get(), "minecraft", "oak", "purple");
        processBasketVariants(TBABlocks.BASKET_OAK_MAGENTA.get(), "minecraft", "oak", "magenta");
        processBasketVariants(TBABlocks.BASKET_OAK_PINK.get(), "minecraft", "oak", "pink");
        processBasketVariants(TBABlocks.BASKET_BIRCH_WHITE.get(), "minecraft", "birch", "white");
        processBasketVariants(TBABlocks.BASKET_BIRCH_LIGHT_GRAY.get(), "minecraft", "birch", "light_gray");
        processBasketVariants(TBABlocks.BASKET_BIRCH_GRAY.get(), "minecraft", "birch", "gray");
        processBasketVariants(TBABlocks.BASKET_BIRCH_BLACK.get(), "minecraft", "birch", "black");
        processBasketVariants(TBABlocks.BASKET_BIRCH_BROWN.get(), "minecraft", "birch", "brown");
        processBasketVariants(TBABlocks.BASKET_BIRCH_RED.get(), "minecraft", "birch", "red");
        processBasketVariants(TBABlocks.BASKET_BIRCH_ORANGE.get(), "minecraft", "birch", "orange");
        processBasketVariants(TBABlocks.BASKET_BIRCH_YELLOW.get(), "minecraft", "birch", "yellow");
        processBasketVariants(TBABlocks.BASKET_BIRCH_LIME.get(), "minecraft", "birch", "lime");
        processBasketVariants(TBABlocks.BASKET_BIRCH_GREEN.get(), "minecraft", "birch", "green");
        processBasketVariants(TBABlocks.BASKET_BIRCH_CYAN.get(), "minecraft", "birch", "cyan");
        processBasketVariants(TBABlocks.BASKET_BIRCH_BLUE.get(), "minecraft", "birch", "blue");
        processBasketVariants(TBABlocks.BASKET_BIRCH_LIGHT_BLUE.get(), "minecraft", "birch", "light_blue");
        processBasketVariants(TBABlocks.BASKET_BIRCH_PURPLE.get(), "minecraft", "birch", "purple");
        processBasketVariants(TBABlocks.BASKET_BIRCH_MAGENTA.get(), "minecraft", "birch", "magenta");
        processBasketVariants(TBABlocks.BASKET_BIRCH_PINK.get(), "minecraft", "birch", "pink");
        processBasketVariants(TBABlocks.BASKET_SPRUCE_WHITE.get(), "minecraft", "spruce", "white");
        processBasketVariants(TBABlocks.BASKET_SPRUCE_LIGHT_GRAY.get(), "minecraft", "spruce", "light_gray");
        processBasketVariants(TBABlocks.BASKET_SPRUCE_GRAY.get(), "minecraft", "spruce", "gray");
        processBasketVariants(TBABlocks.BASKET_SPRUCE_BLACK.get(), "minecraft", "spruce", "black");
        processBasketVariants(TBABlocks.BASKET_SPRUCE_BROWN.get(), "minecraft", "spruce", "brown");
        processBasketVariants(TBABlocks.BASKET_SPRUCE_RED.get(), "minecraft", "spruce", "red");
        processBasketVariants(TBABlocks.BASKET_SPRUCE_ORANGE.get(), "minecraft", "spruce", "orange");
        processBasketVariants(TBABlocks.BASKET_SPRUCE_YELLOW.get(), "minecraft", "spruce", "yellow");
        processBasketVariants(TBABlocks.BASKET_SPRUCE_LIME.get(), "minecraft", "spruce", "lime");
        processBasketVariants(TBABlocks.BASKET_SPRUCE_GREEN.get(), "minecraft", "spruce", "green");
        processBasketVariants(TBABlocks.BASKET_SPRUCE_CYAN.get(), "minecraft", "spruce", "cyan");
        processBasketVariants(TBABlocks.BASKET_SPRUCE_BLUE.get(), "minecraft", "spruce", "blue");
        processBasketVariants(TBABlocks.BASKET_SPRUCE_LIGHT_BLUE.get(), "minecraft", "spruce", "light_blue");
        processBasketVariants(TBABlocks.BASKET_SPRUCE_PURPLE.get(), "minecraft", "spruce", "purple");
        processBasketVariants(TBABlocks.BASKET_SPRUCE_MAGENTA.get(), "minecraft", "spruce", "magenta");
        processBasketVariants(TBABlocks.BASKET_SPRUCE_PINK.get(), "minecraft", "spruce", "pink");
        processBasketVariants(TBABlocks.BASKET_JUNGLE_WHITE.get(), "minecraft", "jungle", "white");
        processBasketVariants(TBABlocks.BASKET_JUNGLE_LIGHT_GRAY.get(), "minecraft", "jungle", "light_gray");
        processBasketVariants(TBABlocks.BASKET_JUNGLE_GRAY.get(), "minecraft", "jungle", "gray");
        processBasketVariants(TBABlocks.BASKET_JUNGLE_BLACK.get(), "minecraft", "jungle", "black");
        processBasketVariants(TBABlocks.BASKET_JUNGLE_BROWN.get(), "minecraft", "jungle", "brown");
        processBasketVariants(TBABlocks.BASKET_JUNGLE_RED.get(), "minecraft", "jungle", "red");
        processBasketVariants(TBABlocks.BASKET_JUNGLE_ORANGE.get(), "minecraft", "jungle", "orange");
        processBasketVariants(TBABlocks.BASKET_JUNGLE_YELLOW.get(), "minecraft", "jungle", "yellow");
        processBasketVariants(TBABlocks.BASKET_JUNGLE_LIME.get(), "minecraft", "jungle", "lime");
        processBasketVariants(TBABlocks.BASKET_JUNGLE_GREEN.get(), "minecraft", "jungle", "green");
        processBasketVariants(TBABlocks.BASKET_JUNGLE_CYAN.get(), "minecraft", "jungle", "cyan");
        processBasketVariants(TBABlocks.BASKET_JUNGLE_BLUE.get(), "minecraft", "jungle", "blue");
        processBasketVariants(TBABlocks.BASKET_JUNGLE_LIGHT_BLUE.get(), "minecraft", "jungle", "light_blue");
        processBasketVariants(TBABlocks.BASKET_JUNGLE_PURPLE.get(), "minecraft", "jungle", "purple");
        processBasketVariants(TBABlocks.BASKET_JUNGLE_MAGENTA.get(), "minecraft", "jungle", "magenta");
        processBasketVariants(TBABlocks.BASKET_JUNGLE_PINK.get(), "minecraft", "jungle", "pink");
        processBasketVariants(TBABlocks.BASKET_ACACIA_WHITE.get(), "minecraft", "acacia", "white");
        processBasketVariants(TBABlocks.BASKET_ACACIA_LIGHT_GRAY.get(), "minecraft", "acacia", "light_gray");
        processBasketVariants(TBABlocks.BASKET_ACACIA_GRAY.get(), "minecraft", "acacia", "gray");
        processBasketVariants(TBABlocks.BASKET_ACACIA_BLACK.get(), "minecraft", "acacia", "black");
        processBasketVariants(TBABlocks.BASKET_ACACIA_BROWN.get(), "minecraft", "acacia", "brown");
        processBasketVariants(TBABlocks.BASKET_ACACIA_RED.get(), "minecraft", "acacia", "red");
        processBasketVariants(TBABlocks.BASKET_ACACIA_ORANGE.get(), "minecraft", "acacia", "orange");
        processBasketVariants(TBABlocks.BASKET_ACACIA_YELLOW.get(), "minecraft", "acacia", "yellow");
        processBasketVariants(TBABlocks.BASKET_ACACIA_LIME.get(), "minecraft", "acacia", "lime");
        processBasketVariants(TBABlocks.BASKET_ACACIA_GREEN.get(), "minecraft", "acacia", "green");
        processBasketVariants(TBABlocks.BASKET_ACACIA_CYAN.get(), "minecraft", "acacia", "cyan");
        processBasketVariants(TBABlocks.BASKET_ACACIA_BLUE.get(), "minecraft", "acacia", "blue");
        processBasketVariants(TBABlocks.BASKET_ACACIA_LIGHT_BLUE.get(), "minecraft", "acacia", "light_blue");
        processBasketVariants(TBABlocks.BASKET_ACACIA_PURPLE.get(), "minecraft", "acacia", "purple");
        processBasketVariants(TBABlocks.BASKET_ACACIA_MAGENTA.get(), "minecraft", "acacia", "magenta");
        processBasketVariants(TBABlocks.BASKET_ACACIA_PINK.get(), "minecraft", "acacia", "pink");
        processBasketVariants(TBABlocks.BASKET_DARK_OAK_WHITE.get(), "minecraft", "dark_oak", "white");
        processBasketVariants(TBABlocks.BASKET_DARK_OAK_LIGHT_GRAY.get(), "minecraft", "dark_oak", "light_gray");
        processBasketVariants(TBABlocks.BASKET_DARK_OAK_GRAY.get(), "minecraft", "dark_oak", "gray");
        processBasketVariants(TBABlocks.BASKET_DARK_OAK_BLACK.get(), "minecraft", "dark_oak", "black");
        processBasketVariants(TBABlocks.BASKET_DARK_OAK_BROWN.get(), "minecraft", "dark_oak", "brown");
        processBasketVariants(TBABlocks.BASKET_DARK_OAK_RED.get(), "minecraft", "dark_oak", "red");
        processBasketVariants(TBABlocks.BASKET_DARK_OAK_ORANGE.get(), "minecraft", "dark_oak", "orange");
        processBasketVariants(TBABlocks.BASKET_DARK_OAK_YELLOW.get(), "minecraft", "dark_oak", "yellow");
        processBasketVariants(TBABlocks.BASKET_DARK_OAK_LIME.get(), "minecraft", "dark_oak", "lime");
        processBasketVariants(TBABlocks.BASKET_DARK_OAK_GREEN.get(), "minecraft", "dark_oak", "green");
        processBasketVariants(TBABlocks.BASKET_DARK_OAK_CYAN.get(), "minecraft", "dark_oak", "cyan");
        processBasketVariants(TBABlocks.BASKET_DARK_OAK_BLUE.get(), "minecraft", "dark_oak", "blue");
        processBasketVariants(TBABlocks.BASKET_DARK_OAK_LIGHT_BLUE.get(), "minecraft", "dark_oak", "light_blue");
        processBasketVariants(TBABlocks.BASKET_DARK_OAK_PURPLE.get(), "minecraft", "dark_oak", "purple");
        processBasketVariants(TBABlocks.BASKET_DARK_OAK_MAGENTA.get(), "minecraft", "dark_oak", "magenta");
        processBasketVariants(TBABlocks.BASKET_DARK_OAK_PINK.get(), "minecraft", "dark_oak", "pink");
        processBasketVariants(TBABlocks.BASKET_MANGROVE_WHITE.get(), "minecraft", "mangrove", "white");
        processBasketVariants(TBABlocks.BASKET_MANGROVE_LIGHT_GRAY.get(), "minecraft", "mangrove", "light_gray");
        processBasketVariants(TBABlocks.BASKET_MANGROVE_GRAY.get(), "minecraft", "mangrove", "gray");
        processBasketVariants(TBABlocks.BASKET_MANGROVE_BLACK.get(), "minecraft", "mangrove", "black");
        processBasketVariants(TBABlocks.BASKET_MANGROVE_BROWN.get(), "minecraft", "mangrove", "brown");
        processBasketVariants(TBABlocks.BASKET_MANGROVE_RED.get(), "minecraft", "mangrove", "red");
        processBasketVariants(TBABlocks.BASKET_MANGROVE_ORANGE.get(), "minecraft", "mangrove", "orange");
        processBasketVariants(TBABlocks.BASKET_MANGROVE_YELLOW.get(), "minecraft", "mangrove", "yellow");
        processBasketVariants(TBABlocks.BASKET_MANGROVE_LIME.get(), "minecraft", "mangrove", "lime");
        processBasketVariants(TBABlocks.BASKET_MANGROVE_GREEN.get(), "minecraft", "mangrove", "green");
        processBasketVariants(TBABlocks.BASKET_MANGROVE_CYAN.get(), "minecraft", "mangrove", "cyan");
        processBasketVariants(TBABlocks.BASKET_MANGROVE_BLUE.get(), "minecraft", "mangrove", "blue");
        processBasketVariants(TBABlocks.BASKET_MANGROVE_LIGHT_BLUE.get(), "minecraft", "mangrove", "light_blue");
        processBasketVariants(TBABlocks.BASKET_MANGROVE_PURPLE.get(), "minecraft", "mangrove", "purple");
        processBasketVariants(TBABlocks.BASKET_MANGROVE_MAGENTA.get(), "minecraft", "mangrove", "magenta");
        processBasketVariants(TBABlocks.BASKET_MANGROVE_PINK.get(), "minecraft", "mangrove", "pink");
        processBasketVariants(TBABlocks.BASKET_CRIMSON_WHITE.get(), "minecraft", "crimson", "white");
        processBasketVariants(TBABlocks.BASKET_CRIMSON_LIGHT_GRAY.get(), "minecraft", "crimson", "light_gray");
        processBasketVariants(TBABlocks.BASKET_CRIMSON_GRAY.get(), "minecraft", "crimson", "gray");
        processBasketVariants(TBABlocks.BASKET_CRIMSON_BLACK.get(), "minecraft", "crimson", "black");
        processBasketVariants(TBABlocks.BASKET_CRIMSON_BROWN.get(), "minecraft", "crimson", "brown");
        processBasketVariants(TBABlocks.BASKET_CRIMSON_RED.get(), "minecraft", "crimson", "red");
        processBasketVariants(TBABlocks.BASKET_CRIMSON_ORANGE.get(), "minecraft", "crimson", "orange");
        processBasketVariants(TBABlocks.BASKET_CRIMSON_YELLOW.get(), "minecraft", "crimson", "yellow");
        processBasketVariants(TBABlocks.BASKET_CRIMSON_LIME.get(), "minecraft", "crimson", "lime");
        processBasketVariants(TBABlocks.BASKET_CRIMSON_GREEN.get(), "minecraft", "crimson", "green");
        processBasketVariants(TBABlocks.BASKET_CRIMSON_CYAN.get(), "minecraft", "crimson", "cyan");
        processBasketVariants(TBABlocks.BASKET_CRIMSON_BLUE.get(), "minecraft", "crimson", "blue");
        processBasketVariants(TBABlocks.BASKET_CRIMSON_LIGHT_BLUE.get(), "minecraft", "crimson", "light_blue");
        processBasketVariants(TBABlocks.BASKET_CRIMSON_PURPLE.get(), "minecraft", "crimson", "purple");
        processBasketVariants(TBABlocks.BASKET_CRIMSON_MAGENTA.get(), "minecraft", "crimson", "magenta");
        processBasketVariants(TBABlocks.BASKET_CRIMSON_PINK.get(), "minecraft", "crimson", "pink");
        processBasketVariants(TBABlocks.BASKET_WARPED_WHITE.get(), "minecraft", "warped", "white");
        processBasketVariants(TBABlocks.BASKET_WARPED_LIGHT_GRAY.get(), "minecraft", "warped", "light_gray");
        processBasketVariants(TBABlocks.BASKET_WARPED_GRAY.get(), "minecraft", "warped", "gray");
        processBasketVariants(TBABlocks.BASKET_WARPED_BLACK.get(), "minecraft", "warped", "black");
        processBasketVariants(TBABlocks.BASKET_WARPED_BROWN.get(), "minecraft", "warped", "brown");
        processBasketVariants(TBABlocks.BASKET_WARPED_RED.get(), "minecraft", "warped", "red");
        processBasketVariants(TBABlocks.BASKET_WARPED_ORANGE.get(), "minecraft", "warped", "orange");
        processBasketVariants(TBABlocks.BASKET_WARPED_YELLOW.get(), "minecraft", "warped", "yellow");
        processBasketVariants(TBABlocks.BASKET_WARPED_LIME.get(), "minecraft", "warped", "lime");
        processBasketVariants(TBABlocks.BASKET_WARPED_GREEN.get(), "minecraft", "warped", "green");
        processBasketVariants(TBABlocks.BASKET_WARPED_CYAN.get(), "minecraft", "warped", "cyan");
        processBasketVariants(TBABlocks.BASKET_WARPED_BLUE.get(), "minecraft", "warped", "blue");
        processBasketVariants(TBABlocks.BASKET_WARPED_LIGHT_BLUE.get(), "minecraft", "warped", "light_blue");
        processBasketVariants(TBABlocks.BASKET_WARPED_PURPLE.get(), "minecraft", "warped", "purple");
        processBasketVariants(TBABlocks.BASKET_WARPED_MAGENTA.get(), "minecraft", "warped", "magenta");
        processBasketVariants(TBABlocks.BASKET_WARPED_PINK.get(), "minecraft", "warped", "pink");
        processBasketVariants(TBABlocks.BASKET_FIR_WHITE.get(), "biomesoplenty", "fir", "white");
        processBasketVariants(TBABlocks.BASKET_FIR_LIGHT_GRAY.get(), "biomesoplenty", "fir", "light_gray");
        processBasketVariants(TBABlocks.BASKET_FIR_GRAY.get(), "biomesoplenty", "fir", "gray");
        processBasketVariants(TBABlocks.BASKET_FIR_BLACK.get(), "biomesoplenty", "fir", "black");
        processBasketVariants(TBABlocks.BASKET_FIR_BROWN.get(), "biomesoplenty", "fir", "brown");
        processBasketVariants(TBABlocks.BASKET_FIR_RED.get(), "biomesoplenty", "fir", "red");
        processBasketVariants(TBABlocks.BASKET_FIR_ORANGE.get(), "biomesoplenty", "fir", "orange");
        processBasketVariants(TBABlocks.BASKET_FIR_YELLOW.get(), "biomesoplenty", "fir", "yellow");
        processBasketVariants(TBABlocks.BASKET_FIR_LIME.get(), "biomesoplenty", "fir", "lime");
        processBasketVariants(TBABlocks.BASKET_FIR_GREEN.get(), "biomesoplenty", "fir", "green");
        processBasketVariants(TBABlocks.BASKET_FIR_CYAN.get(), "biomesoplenty", "fir", "cyan");
        processBasketVariants(TBABlocks.BASKET_FIR_BLUE.get(), "biomesoplenty", "fir", "blue");
        processBasketVariants(TBABlocks.BASKET_FIR_LIGHT_BLUE.get(), "biomesoplenty", "fir", "light_blue");
        processBasketVariants(TBABlocks.BASKET_FIR_PURPLE.get(), "biomesoplenty", "fir", "purple");
        processBasketVariants(TBABlocks.BASKET_FIR_MAGENTA.get(), "biomesoplenty", "fir", "magenta");
        processBasketVariants(TBABlocks.BASKET_FIR_PINK.get(), "biomesoplenty", "fir", "pink");
        processBasketVariants(TBABlocks.BASKET_REDWOOD_WHITE.get(), "biomesoplenty", "redwood", "white");
        processBasketVariants(TBABlocks.BASKET_REDWOOD_LIGHT_GRAY.get(), "biomesoplenty", "redwood", "light_gray");
        processBasketVariants(TBABlocks.BASKET_REDWOOD_GRAY.get(), "biomesoplenty", "redwood", "gray");
        processBasketVariants(TBABlocks.BASKET_REDWOOD_BLACK.get(), "biomesoplenty", "redwood", "black");
        processBasketVariants(TBABlocks.BASKET_REDWOOD_BROWN.get(), "biomesoplenty", "redwood", "brown");
        processBasketVariants(TBABlocks.BASKET_REDWOOD_RED.get(), "biomesoplenty", "redwood", "red");
        processBasketVariants(TBABlocks.BASKET_REDWOOD_ORANGE.get(), "biomesoplenty", "redwood", "orange");
        processBasketVariants(TBABlocks.BASKET_REDWOOD_YELLOW.get(), "biomesoplenty", "redwood", "yellow");
        processBasketVariants(TBABlocks.BASKET_REDWOOD_LIME.get(), "biomesoplenty", "redwood", "lime");
        processBasketVariants(TBABlocks.BASKET_REDWOOD_GREEN.get(), "biomesoplenty", "redwood", "green");
        processBasketVariants(TBABlocks.BASKET_REDWOOD_CYAN.get(), "biomesoplenty", "redwood", "cyan");
        processBasketVariants(TBABlocks.BASKET_REDWOOD_BLUE.get(), "biomesoplenty", "redwood", "blue");
        processBasketVariants(TBABlocks.BASKET_REDWOOD_LIGHT_BLUE.get(), "biomesoplenty", "redwood", "light_blue");
        processBasketVariants(TBABlocks.BASKET_REDWOOD_PURPLE.get(), "biomesoplenty", "redwood", "purple");
        processBasketVariants(TBABlocks.BASKET_REDWOOD_MAGENTA.get(), "biomesoplenty", "redwood", "magenta");
        processBasketVariants(TBABlocks.BASKET_REDWOOD_PINK.get(), "biomesoplenty", "redwood", "pink");
        processBasketVariants(TBABlocks.BASKET_CHERRY_WHITE.get(), "biomesoplenty", "cherry", "white");
        processBasketVariants(TBABlocks.BASKET_CHERRY_LIGHT_GRAY.get(), "biomesoplenty", "cherry", "light_gray");
        processBasketVariants(TBABlocks.BASKET_CHERRY_GRAY.get(), "biomesoplenty", "cherry", "gray");
        processBasketVariants(TBABlocks.BASKET_CHERRY_BLACK.get(), "biomesoplenty", "cherry", "black");
        processBasketVariants(TBABlocks.BASKET_CHERRY_BROWN.get(), "biomesoplenty", "cherry", "brown");
        processBasketVariants(TBABlocks.BASKET_CHERRY_RED.get(), "biomesoplenty", "cherry", "red");
        processBasketVariants(TBABlocks.BASKET_CHERRY_ORANGE.get(), "biomesoplenty", "cherry", "orange");
        processBasketVariants(TBABlocks.BASKET_CHERRY_YELLOW.get(), "biomesoplenty", "cherry", "yellow");
        processBasketVariants(TBABlocks.BASKET_CHERRY_LIME.get(), "biomesoplenty", "cherry", "lime");
        processBasketVariants(TBABlocks.BASKET_CHERRY_GREEN.get(), "biomesoplenty", "cherry", "green");
        processBasketVariants(TBABlocks.BASKET_CHERRY_CYAN.get(), "biomesoplenty", "cherry", "cyan");
        processBasketVariants(TBABlocks.BASKET_CHERRY_BLUE.get(), "biomesoplenty", "cherry", "blue");
        processBasketVariants(TBABlocks.BASKET_CHERRY_LIGHT_BLUE.get(), "biomesoplenty", "cherry", "light_blue");
        processBasketVariants(TBABlocks.BASKET_CHERRY_PURPLE.get(), "biomesoplenty", "cherry", "purple");
        processBasketVariants(TBABlocks.BASKET_CHERRY_MAGENTA.get(), "biomesoplenty", "cherry", "magenta");
        processBasketVariants(TBABlocks.BASKET_CHERRY_PINK.get(), "biomesoplenty", "cherry", "pink");
        processBasketVariants(TBABlocks.BASKET_MAHOGANY_WHITE.get(), "biomesoplenty", "mahogany", "white");
        processBasketVariants(TBABlocks.BASKET_MAHOGANY_LIGHT_GRAY.get(), "biomesoplenty", "mahogany", "light_gray");
        processBasketVariants(TBABlocks.BASKET_MAHOGANY_GRAY.get(), "biomesoplenty", "mahogany", "gray");
        processBasketVariants(TBABlocks.BASKET_MAHOGANY_BLACK.get(), "biomesoplenty", "mahogany", "black");
        processBasketVariants(TBABlocks.BASKET_MAHOGANY_BROWN.get(), "biomesoplenty", "mahogany", "brown");
        processBasketVariants(TBABlocks.BASKET_MAHOGANY_RED.get(), "biomesoplenty", "mahogany", "red");
        processBasketVariants(TBABlocks.BASKET_MAHOGANY_ORANGE.get(), "biomesoplenty", "mahogany", "orange");
        processBasketVariants(TBABlocks.BASKET_MAHOGANY_YELLOW.get(), "biomesoplenty", "mahogany", "yellow");
        processBasketVariants(TBABlocks.BASKET_MAHOGANY_LIME.get(), "biomesoplenty", "mahogany", "lime");
        processBasketVariants(TBABlocks.BASKET_MAHOGANY_GREEN.get(), "biomesoplenty", "mahogany", "green");
        processBasketVariants(TBABlocks.BASKET_MAHOGANY_CYAN.get(), "biomesoplenty", "mahogany", "cyan");
        processBasketVariants(TBABlocks.BASKET_MAHOGANY_BLUE.get(), "biomesoplenty", "mahogany", "blue");
        processBasketVariants(TBABlocks.BASKET_MAHOGANY_LIGHT_BLUE.get(), "biomesoplenty", "mahogany", "light_blue");
        processBasketVariants(TBABlocks.BASKET_MAHOGANY_PURPLE.get(), "biomesoplenty", "mahogany", "purple");
        processBasketVariants(TBABlocks.BASKET_MAHOGANY_MAGENTA.get(), "biomesoplenty", "mahogany", "magenta");
        processBasketVariants(TBABlocks.BASKET_MAHOGANY_PINK.get(), "biomesoplenty", "mahogany", "pink");
        processBasketVariants(TBABlocks.BASKET_JACARANDA_WHITE.get(), "biomesoplenty", "jacaranda", "white");
        processBasketVariants(TBABlocks.BASKET_JACARANDA_LIGHT_GRAY.get(), "biomesoplenty", "jacaranda", "light_gray");
        processBasketVariants(TBABlocks.BASKET_JACARANDA_GRAY.get(), "biomesoplenty", "jacaranda", "gray");
        processBasketVariants(TBABlocks.BASKET_JACARANDA_BLACK.get(), "biomesoplenty", "jacaranda", "black");
        processBasketVariants(TBABlocks.BASKET_JACARANDA_BROWN.get(), "biomesoplenty", "jacaranda", "brown");
        processBasketVariants(TBABlocks.BASKET_JACARANDA_RED.get(), "biomesoplenty", "jacaranda", "red");
        processBasketVariants(TBABlocks.BASKET_JACARANDA_ORANGE.get(), "biomesoplenty", "jacaranda", "orange");
        processBasketVariants(TBABlocks.BASKET_JACARANDA_YELLOW.get(), "biomesoplenty", "jacaranda", "yellow");
        processBasketVariants(TBABlocks.BASKET_JACARANDA_LIME.get(), "biomesoplenty", "jacaranda", "lime");
        processBasketVariants(TBABlocks.BASKET_JACARANDA_GREEN.get(), "biomesoplenty", "jacaranda", "green");
        processBasketVariants(TBABlocks.BASKET_JACARANDA_CYAN.get(), "biomesoplenty", "jacaranda", "cyan");
        processBasketVariants(TBABlocks.BASKET_JACARANDA_BLUE.get(), "biomesoplenty", "jacaranda", "blue");
        processBasketVariants(TBABlocks.BASKET_JACARANDA_LIGHT_BLUE.get(), "biomesoplenty", "jacaranda", "light_blue");
        processBasketVariants(TBABlocks.BASKET_JACARANDA_PURPLE.get(), "biomesoplenty", "jacaranda", "purple");
        processBasketVariants(TBABlocks.BASKET_JACARANDA_MAGENTA.get(), "biomesoplenty", "jacaranda", "magenta");
        processBasketVariants(TBABlocks.BASKET_JACARANDA_PINK.get(), "biomesoplenty", "jacaranda", "pink");
        processBasketVariants(TBABlocks.BASKET_PALM_WHITE.get(), "biomesoplenty", "palm", "white");
        processBasketVariants(TBABlocks.BASKET_PALM_LIGHT_GRAY.get(), "biomesoplenty", "palm", "light_gray");
        processBasketVariants(TBABlocks.BASKET_PALM_GRAY.get(), "biomesoplenty", "palm", "gray");
        processBasketVariants(TBABlocks.BASKET_PALM_BLACK.get(), "biomesoplenty", "palm", "black");
        processBasketVariants(TBABlocks.BASKET_PALM_BROWN.get(), "biomesoplenty", "palm", "brown");
        processBasketVariants(TBABlocks.BASKET_PALM_RED.get(), "biomesoplenty", "palm", "red");
        processBasketVariants(TBABlocks.BASKET_PALM_ORANGE.get(), "biomesoplenty", "palm", "orange");
        processBasketVariants(TBABlocks.BASKET_PALM_YELLOW.get(), "biomesoplenty", "palm", "yellow");
        processBasketVariants(TBABlocks.BASKET_PALM_LIME.get(), "biomesoplenty", "palm", "lime");
        processBasketVariants(TBABlocks.BASKET_PALM_GREEN.get(), "biomesoplenty", "palm", "green");
        processBasketVariants(TBABlocks.BASKET_PALM_CYAN.get(), "biomesoplenty", "palm", "cyan");
        processBasketVariants(TBABlocks.BASKET_PALM_BLUE.get(), "biomesoplenty", "palm", "blue");
        processBasketVariants(TBABlocks.BASKET_PALM_LIGHT_BLUE.get(), "biomesoplenty", "palm", "light_blue");
        processBasketVariants(TBABlocks.BASKET_PALM_PURPLE.get(), "biomesoplenty", "palm", "purple");
        processBasketVariants(TBABlocks.BASKET_PALM_MAGENTA.get(), "biomesoplenty", "palm", "magenta");
        processBasketVariants(TBABlocks.BASKET_PALM_PINK.get(), "biomesoplenty", "palm", "pink");
        processBasketVariants(TBABlocks.BASKET_WILLOW_WHITE.get(), "biomesoplenty", "willow", "white");
        processBasketVariants(TBABlocks.BASKET_WILLOW_LIGHT_GRAY.get(), "biomesoplenty", "willow", "light_gray");
        processBasketVariants(TBABlocks.BASKET_WILLOW_GRAY.get(), "biomesoplenty", "willow", "gray");
        processBasketVariants(TBABlocks.BASKET_WILLOW_BLACK.get(), "biomesoplenty", "willow", "black");
        processBasketVariants(TBABlocks.BASKET_WILLOW_BROWN.get(), "biomesoplenty", "willow", "brown");
        processBasketVariants(TBABlocks.BASKET_WILLOW_RED.get(), "biomesoplenty", "willow", "red");
        processBasketVariants(TBABlocks.BASKET_WILLOW_ORANGE.get(), "biomesoplenty", "willow", "orange");
        processBasketVariants(TBABlocks.BASKET_WILLOW_YELLOW.get(), "biomesoplenty", "willow", "yellow");
        processBasketVariants(TBABlocks.BASKET_WILLOW_LIME.get(), "biomesoplenty", "willow", "lime");
        processBasketVariants(TBABlocks.BASKET_WILLOW_GREEN.get(), "biomesoplenty", "willow", "green");
        processBasketVariants(TBABlocks.BASKET_WILLOW_CYAN.get(), "biomesoplenty", "willow", "cyan");
        processBasketVariants(TBABlocks.BASKET_WILLOW_BLUE.get(), "biomesoplenty", "willow", "blue");
        processBasketVariants(TBABlocks.BASKET_WILLOW_LIGHT_BLUE.get(), "biomesoplenty", "willow", "light_blue");
        processBasketVariants(TBABlocks.BASKET_WILLOW_PURPLE.get(), "biomesoplenty", "willow", "purple");
        processBasketVariants(TBABlocks.BASKET_WILLOW_MAGENTA.get(), "biomesoplenty", "willow", "magenta");
        processBasketVariants(TBABlocks.BASKET_WILLOW_PINK.get(), "biomesoplenty", "willow", "pink");
        processBasketVariants(TBABlocks.BASKET_DEAD_WHITE.get(), "biomesoplenty", "dead", "white");
        processBasketVariants(TBABlocks.BASKET_DEAD_LIGHT_GRAY.get(), "biomesoplenty", "dead", "light_gray");
        processBasketVariants(TBABlocks.BASKET_DEAD_GRAY.get(), "biomesoplenty", "dead", "gray");
        processBasketVariants(TBABlocks.BASKET_DEAD_BLACK.get(), "biomesoplenty", "dead", "black");
        processBasketVariants(TBABlocks.BASKET_DEAD_BROWN.get(), "biomesoplenty", "dead", "brown");
        processBasketVariants(TBABlocks.BASKET_DEAD_RED.get(), "biomesoplenty", "dead", "red");
        processBasketVariants(TBABlocks.BASKET_DEAD_ORANGE.get(), "biomesoplenty", "dead", "orange");
        processBasketVariants(TBABlocks.BASKET_DEAD_YELLOW.get(), "biomesoplenty", "dead", "yellow");
        processBasketVariants(TBABlocks.BASKET_DEAD_LIME.get(), "biomesoplenty", "dead", "lime");
        processBasketVariants(TBABlocks.BASKET_DEAD_GREEN.get(), "biomesoplenty", "dead", "green");
        processBasketVariants(TBABlocks.BASKET_DEAD_CYAN.get(), "biomesoplenty", "dead", "cyan");
        processBasketVariants(TBABlocks.BASKET_DEAD_BLUE.get(), "biomesoplenty", "dead", "blue");
        processBasketVariants(TBABlocks.BASKET_DEAD_LIGHT_BLUE.get(), "biomesoplenty", "dead", "light_blue");
        processBasketVariants(TBABlocks.BASKET_DEAD_PURPLE.get(), "biomesoplenty", "dead", "purple");
        processBasketVariants(TBABlocks.BASKET_DEAD_MAGENTA.get(), "biomesoplenty", "dead", "magenta");
        processBasketVariants(TBABlocks.BASKET_DEAD_PINK.get(), "biomesoplenty", "dead", "pink");
        processBasketVariants(TBABlocks.BASKET_MAGIC_WHITE.get(), "biomesoplenty", "magic", "white");
        processBasketVariants(TBABlocks.BASKET_MAGIC_LIGHT_GRAY.get(), "biomesoplenty", "magic", "light_gray");
        processBasketVariants(TBABlocks.BASKET_MAGIC_GRAY.get(), "biomesoplenty", "magic", "gray");
        processBasketVariants(TBABlocks.BASKET_MAGIC_BLACK.get(), "biomesoplenty", "magic", "black");
        processBasketVariants(TBABlocks.BASKET_MAGIC_BROWN.get(), "biomesoplenty", "magic", "brown");
        processBasketVariants(TBABlocks.BASKET_MAGIC_RED.get(), "biomesoplenty", "magic", "red");
        processBasketVariants(TBABlocks.BASKET_MAGIC_ORANGE.get(), "biomesoplenty", "magic", "orange");
        processBasketVariants(TBABlocks.BASKET_MAGIC_YELLOW.get(), "biomesoplenty", "magic", "yellow");
        processBasketVariants(TBABlocks.BASKET_MAGIC_LIME.get(), "biomesoplenty", "magic", "lime");
        processBasketVariants(TBABlocks.BASKET_MAGIC_GREEN.get(), "biomesoplenty", "magic", "green");
        processBasketVariants(TBABlocks.BASKET_MAGIC_CYAN.get(), "biomesoplenty", "magic", "cyan");
        processBasketVariants(TBABlocks.BASKET_MAGIC_BLUE.get(), "biomesoplenty", "magic", "blue");
        processBasketVariants(TBABlocks.BASKET_MAGIC_LIGHT_BLUE.get(), "biomesoplenty", "magic", "light_blue");
        processBasketVariants(TBABlocks.BASKET_MAGIC_PURPLE.get(), "biomesoplenty", "magic", "purple");
        processBasketVariants(TBABlocks.BASKET_MAGIC_MAGENTA.get(), "biomesoplenty", "magic", "magenta");
        processBasketVariants(TBABlocks.BASKET_MAGIC_PINK.get(), "biomesoplenty", "magic", "pink");
        processBasketVariants(TBABlocks.BASKET_UMBRAN_WHITE.get(), "biomesoplenty", "umbran", "white");
        processBasketVariants(TBABlocks.BASKET_UMBRAN_LIGHT_GRAY.get(), "biomesoplenty", "umbran", "light_gray");
        processBasketVariants(TBABlocks.BASKET_UMBRAN_GRAY.get(), "biomesoplenty", "umbran", "gray");
        processBasketVariants(TBABlocks.BASKET_UMBRAN_BLACK.get(), "biomesoplenty", "umbran", "black");
        processBasketVariants(TBABlocks.BASKET_UMBRAN_BROWN.get(), "biomesoplenty", "umbran", "brown");
        processBasketVariants(TBABlocks.BASKET_UMBRAN_RED.get(), "biomesoplenty", "umbran", "red");
        processBasketVariants(TBABlocks.BASKET_UMBRAN_ORANGE.get(), "biomesoplenty", "umbran", "orange");
        processBasketVariants(TBABlocks.BASKET_UMBRAN_YELLOW.get(), "biomesoplenty", "umbran", "yellow");
        processBasketVariants(TBABlocks.BASKET_UMBRAN_LIME.get(), "biomesoplenty", "umbran", "lime");
        processBasketVariants(TBABlocks.BASKET_UMBRAN_GREEN.get(), "biomesoplenty", "umbran", "green");
        processBasketVariants(TBABlocks.BASKET_UMBRAN_CYAN.get(), "biomesoplenty", "umbran", "cyan");
        processBasketVariants(TBABlocks.BASKET_UMBRAN_BLUE.get(), "biomesoplenty", "umbran", "blue");
        processBasketVariants(TBABlocks.BASKET_UMBRAN_LIGHT_BLUE.get(), "biomesoplenty", "umbran", "light_blue");
        processBasketVariants(TBABlocks.BASKET_UMBRAN_PURPLE.get(), "biomesoplenty", "umbran", "purple");
        processBasketVariants(TBABlocks.BASKET_UMBRAN_MAGENTA.get(), "biomesoplenty", "umbran", "magenta");
        processBasketVariants(TBABlocks.BASKET_UMBRAN_PINK.get(), "biomesoplenty", "umbran", "pink");
        processBasketVariants(TBABlocks.BASKET_HELLBARK_WHITE.get(), "biomesoplenty", "hellbark", "white");
        processBasketVariants(TBABlocks.BASKET_HELLBARK_LIGHT_GRAY.get(), "biomesoplenty", "hellbark", "light_gray");
        processBasketVariants(TBABlocks.BASKET_HELLBARK_GRAY.get(), "biomesoplenty", "hellbark", "gray");
        processBasketVariants(TBABlocks.BASKET_HELLBARK_BLACK.get(), "biomesoplenty", "hellbark", "black");
        processBasketVariants(TBABlocks.BASKET_HELLBARK_BROWN.get(), "biomesoplenty", "hellbark", "brown");
        processBasketVariants(TBABlocks.BASKET_HELLBARK_RED.get(), "biomesoplenty", "hellbark", "red");
        processBasketVariants(TBABlocks.BASKET_HELLBARK_ORANGE.get(), "biomesoplenty", "hellbark", "orange");
        processBasketVariants(TBABlocks.BASKET_HELLBARK_YELLOW.get(), "biomesoplenty", "hellbark", "yellow");
        processBasketVariants(TBABlocks.BASKET_HELLBARK_LIME.get(), "biomesoplenty", "hellbark", "lime");
        processBasketVariants(TBABlocks.BASKET_HELLBARK_GREEN.get(), "biomesoplenty", "hellbark", "green");
        processBasketVariants(TBABlocks.BASKET_HELLBARK_CYAN.get(), "biomesoplenty", "hellbark", "cyan");
        processBasketVariants(TBABlocks.BASKET_HELLBARK_BLUE.get(), "biomesoplenty", "hellbark", "blue");
        processBasketVariants(TBABlocks.BASKET_HELLBARK_LIGHT_BLUE.get(), "biomesoplenty", "hellbark", "light_blue");
        processBasketVariants(TBABlocks.BASKET_HELLBARK_PURPLE.get(), "biomesoplenty", "hellbark", "purple");
        processBasketVariants(TBABlocks.BASKET_HELLBARK_MAGENTA.get(), "biomesoplenty", "hellbark", "magenta");
        processBasketVariants(TBABlocks.BASKET_HELLBARK_PINK.get(), "biomesoplenty", "hellbark", "pink");
        processBasketVariants(TBABlocks.BASKET_COCONUT_WHITE.get(), "ecologics", "coconut", "white");
        processBasketVariants(TBABlocks.BASKET_COCONUT_LIGHT_GRAY.get(), "ecologics", "coconut", "light_gray");
        processBasketVariants(TBABlocks.BASKET_COCONUT_GRAY.get(), "ecologics", "coconut", "gray");
        processBasketVariants(TBABlocks.BASKET_COCONUT_BLACK.get(), "ecologics", "coconut", "black");
        processBasketVariants(TBABlocks.BASKET_COCONUT_BROWN.get(), "ecologics", "coconut", "brown");
        processBasketVariants(TBABlocks.BASKET_COCONUT_RED.get(), "ecologics", "coconut", "red");
        processBasketVariants(TBABlocks.BASKET_COCONUT_ORANGE.get(), "ecologics", "coconut", "orange");
        processBasketVariants(TBABlocks.BASKET_COCONUT_YELLOW.get(), "ecologics", "coconut", "yellow");
        processBasketVariants(TBABlocks.BASKET_COCONUT_LIME.get(), "ecologics", "coconut", "lime");
        processBasketVariants(TBABlocks.BASKET_COCONUT_GREEN.get(), "ecologics", "coconut", "green");
        processBasketVariants(TBABlocks.BASKET_COCONUT_CYAN.get(), "ecologics", "coconut", "cyan");
        processBasketVariants(TBABlocks.BASKET_COCONUT_BLUE.get(), "ecologics", "coconut", "blue");
        processBasketVariants(TBABlocks.BASKET_COCONUT_LIGHT_BLUE.get(), "ecologics", "coconut", "light_blue");
        processBasketVariants(TBABlocks.BASKET_COCONUT_PURPLE.get(), "ecologics", "coconut", "purple");
        processBasketVariants(TBABlocks.BASKET_COCONUT_MAGENTA.get(), "ecologics", "coconut", "magenta");
        processBasketVariants(TBABlocks.BASKET_COCONUT_PINK.get(), "ecologics", "coconut", "pink");
        processBasketVariants(TBABlocks.BASKET_WALNUT_WHITE.get(), "ecologics", "walnut", "white");
        processBasketVariants(TBABlocks.BASKET_WALNUT_LIGHT_GRAY.get(), "ecologics", "walnut", "light_gray");
        processBasketVariants(TBABlocks.BASKET_WALNUT_GRAY.get(), "ecologics", "walnut", "gray");
        processBasketVariants(TBABlocks.BASKET_WALNUT_BLACK.get(), "ecologics", "walnut", "black");
        processBasketVariants(TBABlocks.BASKET_WALNUT_BROWN.get(), "ecologics", "walnut", "brown");
        processBasketVariants(TBABlocks.BASKET_WALNUT_RED.get(), "ecologics", "walnut", "red");
        processBasketVariants(TBABlocks.BASKET_WALNUT_ORANGE.get(), "ecologics", "walnut", "orange");
        processBasketVariants(TBABlocks.BASKET_WALNUT_YELLOW.get(), "ecologics", "walnut", "yellow");
        processBasketVariants(TBABlocks.BASKET_WALNUT_LIME.get(), "ecologics", "walnut", "lime");
        processBasketVariants(TBABlocks.BASKET_WALNUT_GREEN.get(), "ecologics", "walnut", "green");
        processBasketVariants(TBABlocks.BASKET_WALNUT_CYAN.get(), "ecologics", "walnut", "cyan");
        processBasketVariants(TBABlocks.BASKET_WALNUT_BLUE.get(), "ecologics", "walnut", "blue");
        processBasketVariants(TBABlocks.BASKET_WALNUT_LIGHT_BLUE.get(), "ecologics", "walnut", "light_blue");
        processBasketVariants(TBABlocks.BASKET_WALNUT_PURPLE.get(), "ecologics", "walnut", "purple");
        processBasketVariants(TBABlocks.BASKET_WALNUT_MAGENTA.get(), "ecologics", "walnut", "magenta");
        processBasketVariants(TBABlocks.BASKET_WALNUT_PINK.get(), "ecologics", "walnut", "pink");
        processBasketVariants(TBABlocks.BASKET_AZALEA_WHITE.get(), "ecologics", "azalea", "white");
        processBasketVariants(TBABlocks.BASKET_AZALEA_LIGHT_GRAY.get(), "ecologics", "azalea", "light_gray");
        processBasketVariants(TBABlocks.BASKET_AZALEA_GRAY.get(), "ecologics", "azalea", "gray");
        processBasketVariants(TBABlocks.BASKET_AZALEA_BLACK.get(), "ecologics", "azalea", "black");
        processBasketVariants(TBABlocks.BASKET_AZALEA_BROWN.get(), "ecologics", "azalea", "brown");
        processBasketVariants(TBABlocks.BASKET_AZALEA_RED.get(), "ecologics", "azalea", "red");
        processBasketVariants(TBABlocks.BASKET_AZALEA_ORANGE.get(), "ecologics", "azalea", "orange");
        processBasketVariants(TBABlocks.BASKET_AZALEA_YELLOW.get(), "ecologics", "azalea", "yellow");
        processBasketVariants(TBABlocks.BASKET_AZALEA_LIME.get(), "ecologics", "azalea", "lime");
        processBasketVariants(TBABlocks.BASKET_AZALEA_GREEN.get(), "ecologics", "azalea", "green");
        processBasketVariants(TBABlocks.BASKET_AZALEA_CYAN.get(), "ecologics", "azalea", "cyan");
        processBasketVariants(TBABlocks.BASKET_AZALEA_BLUE.get(), "ecologics", "azalea", "blue");
        processBasketVariants(TBABlocks.BASKET_AZALEA_LIGHT_BLUE.get(), "ecologics", "azalea", "light_blue");
        processBasketVariants(TBABlocks.BASKET_AZALEA_PURPLE.get(), "ecologics", "azalea", "purple");
        processBasketVariants(TBABlocks.BASKET_AZALEA_MAGENTA.get(), "ecologics", "azalea", "magenta");
        processBasketVariants(TBABlocks.BASKET_AZALEA_PINK.get(), "ecologics", "azalea", "pink");
        processBasketVariants(TBABlocks.BASKET_FLOWERING_AZALEA_WHITE.get(), "ecologics", "flowering_azalea", "white");
        processBasketVariants(TBABlocks.BASKET_FLOWERING_AZALEA_LIGHT_GRAY.get(), "ecologics", "flowering_azalea", "light_gray");
        processBasketVariants(TBABlocks.BASKET_FLOWERING_AZALEA_GRAY.get(), "ecologics", "flowering_azalea", "gray");
        processBasketVariants(TBABlocks.BASKET_FLOWERING_AZALEA_BLACK.get(), "ecologics", "flowering_azalea", "black");
        processBasketVariants(TBABlocks.BASKET_FLOWERING_AZALEA_BROWN.get(), "ecologics", "flowering_azalea", "brown");
        processBasketVariants(TBABlocks.BASKET_FLOWERING_AZALEA_RED.get(), "ecologics", "flowering_azalea", "red");
        processBasketVariants(TBABlocks.BASKET_FLOWERING_AZALEA_ORANGE.get(), "ecologics", "flowering_azalea", "orange");
        processBasketVariants(TBABlocks.BASKET_FLOWERING_AZALEA_YELLOW.get(), "ecologics", "flowering_azalea", "yellow");
        processBasketVariants(TBABlocks.BASKET_FLOWERING_AZALEA_LIME.get(), "ecologics", "flowering_azalea", "lime");
        processBasketVariants(TBABlocks.BASKET_FLOWERING_AZALEA_GREEN.get(), "ecologics", "flowering_azalea", "green");
        processBasketVariants(TBABlocks.BASKET_FLOWERING_AZALEA_CYAN.get(), "ecologics", "flowering_azalea", "cyan");
        processBasketVariants(TBABlocks.BASKET_FLOWERING_AZALEA_BLUE.get(), "ecologics", "flowering_azalea", "blue");
        processBasketVariants(TBABlocks.BASKET_FLOWERING_AZALEA_LIGHT_BLUE.get(), "ecologics", "flowering_azalea", "light_blue");
        processBasketVariants(TBABlocks.BASKET_FLOWERING_AZALEA_PURPLE.get(), "ecologics", "flowering_azalea", "purple");
        processBasketVariants(TBABlocks.BASKET_FLOWERING_AZALEA_MAGENTA.get(), "ecologics", "flowering_azalea", "magenta");
        processBasketVariants(TBABlocks.BASKET_FLOWERING_AZALEA_PINK.get(), "ecologics", "flowering_azalea", "pink");
        processBasketVariants(TBABlocks.BASKET_AETHER_SKYROOT_WHITE.get(), "aether", "skyroot", "white");
        processBasketVariants(TBABlocks.BASKET_AETHER_SKYROOT_LIGHT_GRAY.get(), "aether", "skyroot", "light_gray");
        processBasketVariants(TBABlocks.BASKET_AETHER_SKYROOT_GRAY.get(), "aether", "skyroot", "gray");
        processBasketVariants(TBABlocks.BASKET_AETHER_SKYROOT_BLACK.get(), "aether", "skyroot", "black");
        processBasketVariants(TBABlocks.BASKET_AETHER_SKYROOT_BROWN.get(), "aether", "skyroot", "brown");
        processBasketVariants(TBABlocks.BASKET_AETHER_SKYROOT_RED.get(), "aether", "skyroot", "red");
        processBasketVariants(TBABlocks.BASKET_AETHER_SKYROOT_ORANGE.get(), "aether", "skyroot", "orange");
        processBasketVariants(TBABlocks.BASKET_AETHER_SKYROOT_YELLOW.get(), "aether", "skyroot", "yellow");
        processBasketVariants(TBABlocks.BASKET_AETHER_SKYROOT_LIME.get(), "aether", "skyroot", "lime");
        processBasketVariants(TBABlocks.BASKET_AETHER_SKYROOT_GREEN.get(), "aether", "skyroot", "green");
        processBasketVariants(TBABlocks.BASKET_AETHER_SKYROOT_CYAN.get(), "aether", "skyroot", "cyan");
        processBasketVariants(TBABlocks.BASKET_AETHER_SKYROOT_BLUE.get(), "aether", "skyroot", "blue");
        processBasketVariants(TBABlocks.BASKET_AETHER_SKYROOT_LIGHT_BLUE.get(), "aether", "skyroot", "light_blue");
        processBasketVariants(TBABlocks.BASKET_AETHER_SKYROOT_PURPLE.get(), "aether", "skyroot", "purple");
        processBasketVariants(TBABlocks.BASKET_AETHER_SKYROOT_MAGENTA.get(), "aether", "skyroot", "magenta");
        processBasketVariants(TBABlocks.BASKET_AETHER_SKYROOT_PINK.get(), "aether", "skyroot", "pink");
        processBasketVariants(TBABlocks.BASKET_PREAM_WHITE.get(), "phantasm", "pream", "white");
        processBasketVariants(TBABlocks.BASKET_PREAM_LIGHT_GRAY.get(), "phantasm", "pream", "light_gray");
        processBasketVariants(TBABlocks.BASKET_PREAM_GRAY.get(), "phantasm", "pream", "gray");
        processBasketVariants(TBABlocks.BASKET_PREAM_BLACK.get(), "phantasm", "pream", "black");
        processBasketVariants(TBABlocks.BASKET_PREAM_BROWN.get(), "phantasm", "pream", "brown");
        processBasketVariants(TBABlocks.BASKET_PREAM_RED.get(), "phantasm", "pream", "red");
        processBasketVariants(TBABlocks.BASKET_PREAM_ORANGE.get(), "phantasm", "pream", "orange");
        processBasketVariants(TBABlocks.BASKET_PREAM_YELLOW.get(), "phantasm", "pream", "yellow");
        processBasketVariants(TBABlocks.BASKET_PREAM_LIME.get(), "phantasm", "pream", "lime");
        processBasketVariants(TBABlocks.BASKET_PREAM_GREEN.get(), "phantasm", "pream", "green");
        processBasketVariants(TBABlocks.BASKET_PREAM_CYAN.get(), "phantasm", "pream", "cyan");
        processBasketVariants(TBABlocks.BASKET_PREAM_BLUE.get(), "phantasm", "pream", "blue");
        processBasketVariants(TBABlocks.BASKET_PREAM_LIGHT_BLUE.get(), "phantasm", "pream", "light_blue");
        processBasketVariants(TBABlocks.BASKET_PREAM_PURPLE.get(), "phantasm", "pream", "purple");
        processBasketVariants(TBABlocks.BASKET_PREAM_MAGENTA.get(), "phantasm", "pream", "magenta");
        processBasketVariants(TBABlocks.BASKET_PREAM_PINK.get(), "phantasm", "pream", "pink");
        processBasketVariants(TBABlocks.BASKET_EBONY_WHITE.get(), "phantasm", "ebony", "white");
        processBasketVariants(TBABlocks.BASKET_EBONY_LIGHT_GRAY.get(), "phantasm", "ebony", "light_gray");
        processBasketVariants(TBABlocks.BASKET_EBONY_GRAY.get(), "phantasm", "ebony", "gray");
        processBasketVariants(TBABlocks.BASKET_EBONY_BLACK.get(), "phantasm", "ebony", "black");
        processBasketVariants(TBABlocks.BASKET_EBONY_BROWN.get(), "phantasm", "ebony", "brown");
        processBasketVariants(TBABlocks.BASKET_EBONY_RED.get(), "phantasm", "ebony", "red");
        processBasketVariants(TBABlocks.BASKET_EBONY_ORANGE.get(), "phantasm", "ebony", "orange");
        processBasketVariants(TBABlocks.BASKET_EBONY_YELLOW.get(), "phantasm", "ebony", "yellow");
        processBasketVariants(TBABlocks.BASKET_EBONY_LIME.get(), "phantasm", "ebony", "lime");
        processBasketVariants(TBABlocks.BASKET_EBONY_GREEN.get(), "phantasm", "ebony", "green");
        processBasketVariants(TBABlocks.BASKET_EBONY_CYAN.get(), "phantasm", "ebony", "cyan");
        processBasketVariants(TBABlocks.BASKET_EBONY_BLUE.get(), "phantasm", "ebony", "blue");
        processBasketVariants(TBABlocks.BASKET_EBONY_LIGHT_BLUE.get(), "phantasm", "ebony", "light_blue");
        processBasketVariants(TBABlocks.BASKET_EBONY_PURPLE.get(), "phantasm", "ebony", "purple");
        processBasketVariants(TBABlocks.BASKET_EBONY_MAGENTA.get(), "phantasm", "ebony", "magenta");
        processBasketVariants(TBABlocks.BASKET_EBONY_PINK.get(), "phantasm", "ebony", "pink");
        processBasketVariants(TBABlocks.BASKET_CHORUS_NEST_WHITE.get(), "unusualend", "chorus_nest", "white");
        processBasketVariants(TBABlocks.BASKET_CHORUS_NEST_LIGHT_GRAY.get(), "unusualend", "chorus_nest", "light_gray");
        processBasketVariants(TBABlocks.BASKET_CHORUS_NEST_GRAY.get(), "unusualend", "chorus_nest", "gray");
        processBasketVariants(TBABlocks.BASKET_CHORUS_NEST_BLACK.get(), "unusualend", "chorus_nest", "black");
        processBasketVariants(TBABlocks.BASKET_CHORUS_NEST_BROWN.get(), "unusualend", "chorus_nest", "brown");
        processBasketVariants(TBABlocks.BASKET_CHORUS_NEST_RED.get(), "unusualend", "chorus_nest", "red");
        processBasketVariants(TBABlocks.BASKET_CHORUS_NEST_ORANGE.get(), "unusualend", "chorus_nest", "orange");
        processBasketVariants(TBABlocks.BASKET_CHORUS_NEST_YELLOW.get(), "unusualend", "chorus_nest", "yellow");
        processBasketVariants(TBABlocks.BASKET_CHORUS_NEST_LIME.get(), "unusualend", "chorus_nest", "lime");
        processBasketVariants(TBABlocks.BASKET_CHORUS_NEST_GREEN.get(), "unusualend", "chorus_nest", "green");
        processBasketVariants(TBABlocks.BASKET_CHORUS_NEST_CYAN.get(), "unusualend", "chorus_nest", "cyan");
        processBasketVariants(TBABlocks.BASKET_CHORUS_NEST_BLUE.get(), "unusualend", "chorus_nest", "blue");
        processBasketVariants(TBABlocks.BASKET_CHORUS_NEST_LIGHT_BLUE.get(), "unusualend", "chorus_nest", "light_blue");
        processBasketVariants(TBABlocks.BASKET_CHORUS_NEST_PURPLE.get(), "unusualend", "chorus_nest", "purple");
        processBasketVariants(TBABlocks.BASKET_CHORUS_NEST_MAGENTA.get(), "unusualend", "chorus_nest", "magenta");
        processBasketVariants(TBABlocks.BASKET_CHORUS_NEST_PINK.get(), "unusualend", "chorus_nest", "pink");
        processBasketVariants(TBABlocks.BASKET_BLOODSHROOM_WHITE.get(), "tconstruct", "bloodshroom", "white");
        processBasketVariants(TBABlocks.BASKET_BLOODSHROOM_LIGHT_GRAY.get(), "tconstruct", "bloodshroom", "light_gray");
        processBasketVariants(TBABlocks.BASKET_BLOODSHROOM_GRAY.get(), "tconstruct", "bloodshroom", "gray");
        processBasketVariants(TBABlocks.BASKET_BLOODSHROOM_BLACK.get(), "tconstruct", "bloodshroom", "black");
        processBasketVariants(TBABlocks.BASKET_BLOODSHROOM_BROWN.get(), "tconstruct", "bloodshroom", "brown");
        processBasketVariants(TBABlocks.BASKET_BLOODSHROOM_RED.get(), "tconstruct", "bloodshroom", "red");
        processBasketVariants(TBABlocks.BASKET_BLOODSHROOM_ORANGE.get(), "tconstruct", "bloodshroom", "orange");
        processBasketVariants(TBABlocks.BASKET_BLOODSHROOM_YELLOW.get(), "tconstruct", "bloodshroom", "yellow");
        processBasketVariants(TBABlocks.BASKET_BLOODSHROOM_LIME.get(), "tconstruct", "bloodshroom", "lime");
        processBasketVariants(TBABlocks.BASKET_BLOODSHROOM_GREEN.get(), "tconstruct", "bloodshroom", "green");
        processBasketVariants(TBABlocks.BASKET_BLOODSHROOM_CYAN.get(), "tconstruct", "bloodshroom", "cyan");
        processBasketVariants(TBABlocks.BASKET_BLOODSHROOM_BLUE.get(), "tconstruct", "bloodshroom", "blue");
        processBasketVariants(TBABlocks.BASKET_BLOODSHROOM_LIGHT_BLUE.get(), "tconstruct", "bloodshroom", "light_blue");
        processBasketVariants(TBABlocks.BASKET_BLOODSHROOM_PURPLE.get(), "tconstruct", "bloodshroom", "purple");
        processBasketVariants(TBABlocks.BASKET_BLOODSHROOM_MAGENTA.get(), "tconstruct", "bloodshroom", "magenta");
        processBasketVariants(TBABlocks.BASKET_BLOODSHROOM_PINK.get(), "tconstruct", "bloodshroom", "pink");
        processBasketVariants(TBABlocks.BASKET_ENDERBARK_WHITE.get(), "tconstruct", "enderbark", "white");
        processBasketVariants(TBABlocks.BASKET_ENDERBARK_LIGHT_GRAY.get(), "tconstruct", "enderbark", "light_gray");
        processBasketVariants(TBABlocks.BASKET_ENDERBARK_GRAY.get(), "tconstruct", "enderbark", "gray");
        processBasketVariants(TBABlocks.BASKET_ENDERBARK_BLACK.get(), "tconstruct", "enderbark", "black");
        processBasketVariants(TBABlocks.BASKET_ENDERBARK_BROWN.get(), "tconstruct", "enderbark", "brown");
        processBasketVariants(TBABlocks.BASKET_ENDERBARK_RED.get(), "tconstruct", "enderbark", "red");
        processBasketVariants(TBABlocks.BASKET_ENDERBARK_ORANGE.get(), "tconstruct", "enderbark", "orange");
        processBasketVariants(TBABlocks.BASKET_ENDERBARK_YELLOW.get(), "tconstruct", "enderbark", "yellow");
        processBasketVariants(TBABlocks.BASKET_ENDERBARK_LIME.get(), "tconstruct", "enderbark", "lime");
        processBasketVariants(TBABlocks.BASKET_ENDERBARK_GREEN.get(), "tconstruct", "enderbark", "green");
        processBasketVariants(TBABlocks.BASKET_ENDERBARK_CYAN.get(), "tconstruct", "enderbark", "cyan");
        processBasketVariants(TBABlocks.BASKET_ENDERBARK_BLUE.get(), "tconstruct", "enderbark", "blue");
        processBasketVariants(TBABlocks.BASKET_ENDERBARK_LIGHT_BLUE.get(), "tconstruct", "enderbark", "light_blue");
        processBasketVariants(TBABlocks.BASKET_ENDERBARK_PURPLE.get(), "tconstruct", "enderbark", "purple");
        processBasketVariants(TBABlocks.BASKET_ENDERBARK_MAGENTA.get(), "tconstruct", "enderbark", "magenta");
        processBasketVariants(TBABlocks.BASKET_ENDERBARK_PINK.get(), "tconstruct", "enderbark", "pink");
        processBasketVariants(TBABlocks.BASKET_GREENHEART_WHITE.get(), "tconstruct", "greenheart", "white");
        processBasketVariants(TBABlocks.BASKET_GREENHEART_LIGHT_GRAY.get(), "tconstruct", "greenheart", "light_gray");
        processBasketVariants(TBABlocks.BASKET_GREENHEART_GRAY.get(), "tconstruct", "greenheart", "gray");
        processBasketVariants(TBABlocks.BASKET_GREENHEART_BLACK.get(), "tconstruct", "greenheart", "black");
        processBasketVariants(TBABlocks.BASKET_GREENHEART_BROWN.get(), "tconstruct", "greenheart", "brown");
        processBasketVariants(TBABlocks.BASKET_GREENHEART_RED.get(), "tconstruct", "greenheart", "red");
        processBasketVariants(TBABlocks.BASKET_GREENHEART_ORANGE.get(), "tconstruct", "greenheart", "orange");
        processBasketVariants(TBABlocks.BASKET_GREENHEART_YELLOW.get(), "tconstruct", "greenheart", "yellow");
        processBasketVariants(TBABlocks.BASKET_GREENHEART_LIME.get(), "tconstruct", "greenheart", "lime");
        processBasketVariants(TBABlocks.BASKET_GREENHEART_GREEN.get(), "tconstruct", "greenheart", "green");
        processBasketVariants(TBABlocks.BASKET_GREENHEART_CYAN.get(), "tconstruct", "greenheart", "cyan");
        processBasketVariants(TBABlocks.BASKET_GREENHEART_BLUE.get(), "tconstruct", "greenheart", "blue");
        processBasketVariants(TBABlocks.BASKET_GREENHEART_LIGHT_BLUE.get(), "tconstruct", "greenheart", "light_blue");
        processBasketVariants(TBABlocks.BASKET_GREENHEART_PURPLE.get(), "tconstruct", "greenheart", "purple");
        processBasketVariants(TBABlocks.BASKET_GREENHEART_MAGENTA.get(), "tconstruct", "greenheart", "magenta");
        processBasketVariants(TBABlocks.BASKET_GREENHEART_PINK.get(), "tconstruct", "greenheart", "pink");
        processBasketVariants(TBABlocks.BASKET_TINKER_SKYROOT_WHITE.get(), "tconstruct", "skyroot", "white");
        processBasketVariants(TBABlocks.BASKET_TINKER_SKYROOT_LIGHT_GRAY.get(), "tconstruct", "skyroot", "light_gray");
        processBasketVariants(TBABlocks.BASKET_TINKER_SKYROOT_GRAY.get(), "tconstruct", "skyroot", "gray");
        processBasketVariants(TBABlocks.BASKET_TINKER_SKYROOT_BLACK.get(), "tconstruct", "skyroot", "black");
        processBasketVariants(TBABlocks.BASKET_TINKER_SKYROOT_BROWN.get(), "tconstruct", "skyroot", "brown");
        processBasketVariants(TBABlocks.BASKET_TINKER_SKYROOT_RED.get(), "tconstruct", "skyroot", "red");
        processBasketVariants(TBABlocks.BASKET_TINKER_SKYROOT_ORANGE.get(), "tconstruct", "skyroot", "orange");
        processBasketVariants(TBABlocks.BASKET_TINKER_SKYROOT_YELLOW.get(), "tconstruct", "skyroot", "yellow");
        processBasketVariants(TBABlocks.BASKET_TINKER_SKYROOT_LIME.get(), "tconstruct", "skyroot", "lime");
        processBasketVariants(TBABlocks.BASKET_TINKER_SKYROOT_GREEN.get(), "tconstruct", "skyroot", "green");
        processBasketVariants(TBABlocks.BASKET_TINKER_SKYROOT_CYAN.get(), "tconstruct", "skyroot", "cyan");
        processBasketVariants(TBABlocks.BASKET_TINKER_SKYROOT_BLUE.get(), "tconstruct", "skyroot", "blue");
        processBasketVariants(TBABlocks.BASKET_TINKER_SKYROOT_LIGHT_BLUE.get(), "tconstruct", "skyroot", "light_blue");
        processBasketVariants(TBABlocks.BASKET_TINKER_SKYROOT_PURPLE.get(), "tconstruct", "skyroot", "purple");
        processBasketVariants(TBABlocks.BASKET_TINKER_SKYROOT_MAGENTA.get(), "tconstruct", "skyroot", "magenta");
        processBasketVariants(TBABlocks.BASKET_TINKER_SKYROOT_PINK.get(), "tconstruct", "skyroot", "pink");
    }

    protected void processBasketVariants(Block result, String modid, String woodType, @NotNull String color) {
        String path_1;

        if (Objects.equals(woodType, "golden_oak") || (Objects.equals(modid, "aether") && Objects.equals(woodType, "skyroot"))) {
            path_1 = "block/construction/skyroot_planks";
        }
        else if (Objects.equals(woodType, "pream") || Objects.equals(woodType, "ebony") || Objects.equals(woodType, "chorus_nest")) {
            path_1 = "blocks/" + woodType + "_planks";
        }
        else if (Objects.equals(modid, "tconstruct") && (Objects.equals(woodType, "bloodshroom") || Objects.equals(woodType, "enderbark")
                || Objects.equals(woodType, "greenheart") || Objects.equals(woodType, "skyroot"))) {
            path_1 = "block/wood/" + woodType + "/planks";
        }
        else {
            path_1 = "block/" + woodType + "_planks";
        }

        String path_2 = "block/" + color + "_wool";

        ModelFile parentModel = new ModelFile.UncheckedModelFile("turtleblockacademy:block/basket");

        ResourceLocation existingTexture1 = new ResourceLocation(modid, path_1);
        ResourceLocation existingTexture2 = new ResourceLocation("minecraft", path_2);

        this.helper.trackGenerated(existingTexture1, TEXTURE);
        this.helper.trackGenerated(existingTexture2, TEXTURE);

        final var model = models()
                .getBuilder(blockName(result)).parent(parentModel)
                .texture("0", existingTexture1)
                .texture("1", existingTexture2)
                .texture("particle", existingTexture1);

        horizontalBlock(result, model);
        simpleBlockItem(result, model);
    }

    @SuppressWarnings("SameParameterValue")
    protected void processPlateVariants(Block result, String modid, String path) {
        plateVariant(result, MODID + ":" + "block/plate_block", modid, path);
    }

    protected void processWoodVariants(Block result1, Block result2,
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
            path_1 = "block/construction/skyroot_planks";
            path_2 = "block/natural/stripped_skyroot_log";
            path_3 = "block/natural/" + woodType + "_log";
        }
        else if (Objects.equals(modid, "aether") && Objects.equals(woodType, "skyroot")) {
            path_1 = "block/construction/skyroot_planks";
            path_2 = "block/natural/stripped_skyroot_log";
            path_3 = "block/natural/" + woodType + "_log";
        }
        else if (Objects.equals(woodType, "pream")) {
            path_1 = "blocks/" + woodType + "_planks";
            path_2 = "blocks/stripped_" + woodType + "_log_side";
            path_3 = "blocks/" + woodType + "_log_side";
        }
        else if (Objects.equals(woodType, "ebony")) {
            path_1 = "blocks/" + woodType + "_planks";
            path_2 = "blocks/" + woodType + "_stems_side_stripped";
            path_3 = "blocks/" + woodType + "_stems_side";
        }
        else if (Objects.equals(woodType, "chorus_nest")) {
            path_1 = "blocks/" + woodType + "_planks";
            path_2 = "blocks/stripped_" + woodType + "_planks";
            path_3 = "blocks/" + woodType + "_mosaic";
        }
        else if (Objects.equals(modid, "tconstruct") && (Objects.equals(woodType, "bloodshroom") || Objects.equals(woodType, "enderbark")
                || Objects.equals(woodType, "greenheart") || Objects.equals(woodType, "skyroot"))) {
            path_1 = "block/wood/" + woodType + "/planks";
            path_2 = "block/wood/" + woodType + "/stripped_log";
            path_3 = "block/wood/" + woodType + "/log";
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

        ResourceLocation existingTexture1 = new ResourceLocation(modid, path_1);
        ResourceLocation existingTexture2 = new ResourceLocation(modid, path_2);
        ResourceLocation existingTexture3 = new ResourceLocation(modid, path_3);

        this.helper.trackGenerated(existingTexture1, TEXTURE);
        this.helper.trackGenerated(existingTexture2, TEXTURE);
        this.helper.trackGenerated(existingTexture3, TEXTURE);

        final var model = models()
                .getBuilder(blockName(result)).parent(parentModel)
                .texture("1", existingTexture1)
                .texture("2", existingTexture2)
                .texture("3", existingTexture3)
                .texture("4", new ResourceLocation(MODID, "block/books"))
                .texture("particle", existingTexture1);

        horizontalBlock(result, model);
        simpleBlockItem(result, model);
    }

    protected void threeTextureHorizontalVariant(Block result, String parent, String modid, String path_1, String path_2, String path_3) {

        ModelFile parentModel = new ModelFile.UncheckedModelFile(parent);

        ResourceLocation existingTexture1 = new ResourceLocation(modid, path_1);
        ResourceLocation existingTexture2 = new ResourceLocation(modid, path_2);
        ResourceLocation existingTexture3 = new ResourceLocation(modid, path_3);

        this.helper.trackGenerated(existingTexture1, TEXTURE);
        this.helper.trackGenerated(existingTexture2, TEXTURE);
        this.helper.trackGenerated(existingTexture3, TEXTURE);

        final var model = models()
                .getBuilder(blockName(result)).parent(parentModel)
                .texture("1", existingTexture1)
                .texture("2", existingTexture2)
                .texture("3", existingTexture3)
                .texture("particle", existingTexture1);

        horizontalBlock(result, model);
        simpleBlockItem(result, model);
    }

    protected void twoTextureHorizontalVariant(Block result, String parent, String modid, String path_1, String path_2) {
        ModelFile parentModel = new ModelFile.UncheckedModelFile(parent);

        ResourceLocation existingTexture1 = new ResourceLocation(modid, path_1);
        ResourceLocation existingTexture2 = new ResourceLocation(modid, path_2);

        this.helper.trackGenerated(existingTexture1, TEXTURE);
        this.helper.trackGenerated(existingTexture2, TEXTURE);

        final var model = models()
                .getBuilder(blockName(result)).parent(parentModel)
                .texture("1", existingTexture1)
                .texture("2", existingTexture2)
                .texture("particle", existingTexture1);

        horizontalBlock(result, model);
        simpleBlockItem(result, model);
    }

    @SuppressWarnings({"SameParameterValue", "ConstantValue"})
    protected void tableVariant(Block result, String parent1, String parent2, String modid,
                                String path_1, String path_2, String path_3) {

        ModelFile parentModel1 = new ModelFile.UncheckedModelFile(parent1);
        ModelFile parentModel2 = new ModelFile.UncheckedModelFile(parent2);

        ResourceLocation existingTexture1 = new ResourceLocation(modid, path_1);
        ResourceLocation existingTexture2 = new ResourceLocation(modid, path_2);
        ResourceLocation existingTexture3 = new ResourceLocation(modid, path_3);

        this.helper.trackGenerated(existingTexture1, TEXTURE);
        this.helper.trackGenerated(existingTexture2, TEXTURE);
        this.helper.trackGenerated(existingTexture3, TEXTURE);

        final var table = models()
                .getBuilder(blockName(result)).parent(parentModel1)
                .texture("1", existingTexture1)
                .texture("2", existingTexture2)
                .texture("3", existingTexture3)
                .texture("particle", existingTexture1);

        final var tableCenter = models()
                .getBuilder(blockName(result) + "_center").parent(parentModel2)
                .texture("1", existingTexture1)
                .texture("particle", existingTexture1);

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