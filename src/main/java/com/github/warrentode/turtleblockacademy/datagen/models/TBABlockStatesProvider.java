package com.github.warrentode.turtleblockacademy.datagen.models;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.blocks.furniture.DeskChairBlock;
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
import static com.github.warrentode.turtleblockacademy.blocks.furniture.PicnicBlanket.PICNIC_BLANKET_LIST;

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

        processChairVariants(TBABlocks.DESK_CHAIR_ACACIA.get(), "minecraft", "acacia");
        processChairVariants(TBABlocks.DESK_CHAIR_ACACIA_WHITE.get(), "minecraft", "acacia");
        processChairVariants(TBABlocks.DESK_CHAIR_ACACIA_ORANGE.get(), "minecraft", "acacia");
        processChairVariants(TBABlocks.DESK_CHAIR_ACACIA_MAGENTA.get(), "minecraft", "acacia");
        processChairVariants(TBABlocks.DESK_CHAIR_ACACIA_LIGHT_BLUE.get(), "minecraft", "acacia");
        processChairVariants(TBABlocks.DESK_CHAIR_ACACIA_YELLOW.get(), "minecraft", "acacia");
        processChairVariants(TBABlocks.DESK_CHAIR_ACACIA_LIME.get(), "minecraft", "acacia");
        processChairVariants(TBABlocks.DESK_CHAIR_ACACIA_PINK.get(), "minecraft", "acacia");
        processChairVariants(TBABlocks.DESK_CHAIR_ACACIA_GRAY.get(), "minecraft", "acacia");
        processChairVariants(TBABlocks.DESK_CHAIR_ACACIA_LIGHT_GRAY.get(), "minecraft", "acacia");
        processChairVariants(TBABlocks.DESK_CHAIR_ACACIA_CYAN.get(), "minecraft", "acacia");
        processChairVariants(TBABlocks.DESK_CHAIR_ACACIA_PURPLE.get(), "minecraft", "acacia");
        processChairVariants(TBABlocks.DESK_CHAIR_ACACIA_BLUE.get(), "minecraft", "acacia");
        processChairVariants(TBABlocks.DESK_CHAIR_ACACIA_BROWN.get(), "minecraft", "acacia");
        processChairVariants(TBABlocks.DESK_CHAIR_ACACIA_GREEN.get(), "minecraft", "acacia");
        processChairVariants(TBABlocks.DESK_CHAIR_ACACIA_RED.get(), "minecraft", "acacia");
        processChairVariants(TBABlocks.DESK_CHAIR_ACACIA_BLACK.get(), "minecraft", "acacia");
        processTableVariants(TBABlocks.TABLE_ACACIA.get(), "minecraft", "acacia");
        processLockerVariants(TBABlocks.LOCKER_ACACIA.get(), "minecraft", "acacia");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_ACACIA.get(), "minecraft", "acacia");
        processDeskVariants(TBABlocks.SCHOOL_DESK_ACACIA.get(), "minecraft", "acacia");
        processBenchVariants(TBABlocks.PARK_BENCH_ACACIA.get(), "minecraft", "acacia");
        processBookcaseVariants(TBABlocks.BOOKCASE_ACACIA.get(), "minecraft", "acacia");

        processChairVariants(TBABlocks.DESK_CHAIR_BIRCH.get(), "minecraft", "birch");
        processChairVariants(TBABlocks.DESK_CHAIR_BIRCH_WHITE.get(), "minecraft", "birch");
        processChairVariants(TBABlocks.DESK_CHAIR_BIRCH_ORANGE.get(), "minecraft", "birch");
        processChairVariants(TBABlocks.DESK_CHAIR_BIRCH_MAGENTA.get(), "minecraft", "birch");
        processChairVariants(TBABlocks.DESK_CHAIR_BIRCH_LIGHT_BLUE.get(), "minecraft", "birch");
        processChairVariants(TBABlocks.DESK_CHAIR_BIRCH_YELLOW.get(), "minecraft", "birch");
        processChairVariants(TBABlocks.DESK_CHAIR_BIRCH_LIME.get(), "minecraft", "birch");
        processChairVariants(TBABlocks.DESK_CHAIR_BIRCH_PINK.get(), "minecraft", "birch");
        processChairVariants(TBABlocks.DESK_CHAIR_BIRCH_GRAY.get(), "minecraft", "birch");
        processChairVariants(TBABlocks.DESK_CHAIR_BIRCH_LIGHT_GRAY.get(), "minecraft", "birch");
        processChairVariants(TBABlocks.DESK_CHAIR_BIRCH_CYAN.get(), "minecraft", "birch");
        processChairVariants(TBABlocks.DESK_CHAIR_BIRCH_PURPLE.get(), "minecraft", "birch");
        processChairVariants(TBABlocks.DESK_CHAIR_BIRCH_BLUE.get(), "minecraft", "birch");
        processChairVariants(TBABlocks.DESK_CHAIR_BIRCH_BROWN.get(), "minecraft", "birch");
        processChairVariants(TBABlocks.DESK_CHAIR_BIRCH_GREEN.get(), "minecraft", "birch");
        processChairVariants(TBABlocks.DESK_CHAIR_BIRCH_RED.get(), "minecraft", "birch");
        processChairVariants(TBABlocks.DESK_CHAIR_BIRCH_BLACK.get(), "minecraft", "birch");
        processTableVariants(TBABlocks.TABLE_BIRCH.get(), "minecraft", "birch");
        processLockerVariants(TBABlocks.LOCKER_BIRCH.get(), "minecraft", "birch");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_BIRCH.get(), "minecraft", "birch");
        processDeskVariants(TBABlocks.SCHOOL_DESK_BIRCH.get(), "minecraft", "birch");
        processBenchVariants(TBABlocks.PARK_BENCH_BIRCH.get(), "minecraft", "birch");
        processBookcaseVariants(TBABlocks.BOOKCASE_BIRCH.get(), "minecraft", "birch");

        processChairVariants(TBABlocks.DESK_CHAIR_CRIMSON.get(), "minecraft", "crimson");
        processChairVariants(TBABlocks.DESK_CHAIR_CRIMSON_WHITE.get(), "minecraft", "crimson");
        processChairVariants(TBABlocks.DESK_CHAIR_CRIMSON_ORANGE.get(), "minecraft", "crimson");
        processChairVariants(TBABlocks.DESK_CHAIR_CRIMSON_MAGENTA.get(), "minecraft", "crimson");
        processChairVariants(TBABlocks.DESK_CHAIR_CRIMSON_LIGHT_BLUE.get(), "minecraft", "crimson");
        processChairVariants(TBABlocks.DESK_CHAIR_CRIMSON_YELLOW.get(), "minecraft", "crimson");
        processChairVariants(TBABlocks.DESK_CHAIR_CRIMSON_LIME.get(), "minecraft", "crimson");
        processChairVariants(TBABlocks.DESK_CHAIR_CRIMSON_PINK.get(), "minecraft", "crimson");
        processChairVariants(TBABlocks.DESK_CHAIR_CRIMSON_GRAY.get(), "minecraft", "crimson");
        processChairVariants(TBABlocks.DESK_CHAIR_CRIMSON_LIGHT_GRAY.get(), "minecraft", "crimson");
        processChairVariants(TBABlocks.DESK_CHAIR_CRIMSON_CYAN.get(), "minecraft", "crimson");
        processChairVariants(TBABlocks.DESK_CHAIR_CRIMSON_PURPLE.get(), "minecraft", "crimson");
        processChairVariants(TBABlocks.DESK_CHAIR_CRIMSON_BLUE.get(), "minecraft", "crimson");
        processChairVariants(TBABlocks.DESK_CHAIR_CRIMSON_BROWN.get(), "minecraft", "crimson");
        processChairVariants(TBABlocks.DESK_CHAIR_CRIMSON_GREEN.get(), "minecraft", "crimson");
        processChairVariants(TBABlocks.DESK_CHAIR_CRIMSON_RED.get(), "minecraft", "crimson");
        processChairVariants(TBABlocks.DESK_CHAIR_CRIMSON_BLACK.get(), "minecraft", "crimson");
        processTableVariants(TBABlocks.TABLE_CRIMSON.get(), "minecraft", "crimson");
        processLockerVariants(TBABlocks.LOCKER_CRIMSON.get(), "minecraft", "crimson");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_CRIMSON.get(), "minecraft", "crimson");
        processDeskVariants(TBABlocks.SCHOOL_DESK_CRIMSON.get(), "minecraft", "crimson");
        processBenchVariants(TBABlocks.PARK_BENCH_CRIMSON.get(), "minecraft", "crimson");
        processBookcaseVariants(TBABlocks.BOOKCASE_CRIMSON.get(), "minecraft", "crimson");

        processChairVariants(TBABlocks.DESK_CHAIR_DARK_OAK.get(), "minecraft", "dark_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_DARK_OAK_WHITE.get(), "minecraft", "dark_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_DARK_OAK_ORANGE.get(), "minecraft", "dark_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_DARK_OAK_MAGENTA.get(), "minecraft", "dark_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_DARK_OAK_LIGHT_BLUE.get(), "minecraft", "dark_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_DARK_OAK_YELLOW.get(), "minecraft", "dark_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_DARK_OAK_LIME.get(), "minecraft", "dark_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_DARK_OAK_PINK.get(), "minecraft", "dark_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_DARK_OAK_GRAY.get(), "minecraft", "dark_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_DARK_OAK_LIGHT_GRAY.get(), "minecraft", "dark_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_DARK_OAK_CYAN.get(), "minecraft", "dark_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_DARK_OAK_PURPLE.get(), "minecraft", "dark_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_DARK_OAK_BLUE.get(), "minecraft", "dark_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_DARK_OAK_BROWN.get(), "minecraft", "dark_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_DARK_OAK_GREEN.get(), "minecraft", "dark_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_DARK_OAK_RED.get(), "minecraft", "dark_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_DARK_OAK_BLACK.get(), "minecraft", "dark_oak");
        processTableVariants(TBABlocks.TABLE_DARK_OAK.get(), "minecraft", "dark_oak");
        processLockerVariants(TBABlocks.LOCKER_DARK_OAK.get(), "minecraft", "dark_oak");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_DARK_OAK.get(), "minecraft", "dark_oak");
        processDeskVariants(TBABlocks.SCHOOL_DESK_DARK_OAK.get(), "minecraft", "dark_oak");
        processBenchVariants(TBABlocks.PARK_BENCH_DARK_OAK.get(), "minecraft", "dark_oak");
        processBookcaseVariants(TBABlocks.BOOKCASE_DARK_OAK.get(), "minecraft", "dark_oak");

        processChairVariants(TBABlocks.DESK_CHAIR_JUNGLE.get(), "minecraft", "jungle");
        processChairVariants(TBABlocks.DESK_CHAIR_JUNGLE_WHITE.get(), "minecraft", "jungle");
        processChairVariants(TBABlocks.DESK_CHAIR_JUNGLE_ORANGE.get(), "minecraft", "jungle");
        processChairVariants(TBABlocks.DESK_CHAIR_JUNGLE_MAGENTA.get(), "minecraft", "jungle");
        processChairVariants(TBABlocks.DESK_CHAIR_JUNGLE_LIGHT_BLUE.get(), "minecraft", "jungle");
        processChairVariants(TBABlocks.DESK_CHAIR_JUNGLE_YELLOW.get(), "minecraft", "jungle");
        processChairVariants(TBABlocks.DESK_CHAIR_JUNGLE_LIME.get(), "minecraft", "jungle");
        processChairVariants(TBABlocks.DESK_CHAIR_JUNGLE_PINK.get(), "minecraft", "jungle");
        processChairVariants(TBABlocks.DESK_CHAIR_JUNGLE_GRAY.get(), "minecraft", "jungle");
        processChairVariants(TBABlocks.DESK_CHAIR_JUNGLE_LIGHT_GRAY.get(), "minecraft", "jungle");
        processChairVariants(TBABlocks.DESK_CHAIR_JUNGLE_CYAN.get(), "minecraft", "jungle");
        processChairVariants(TBABlocks.DESK_CHAIR_JUNGLE_PURPLE.get(), "minecraft", "jungle");
        processChairVariants(TBABlocks.DESK_CHAIR_JUNGLE_BLUE.get(), "minecraft", "jungle");
        processChairVariants(TBABlocks.DESK_CHAIR_JUNGLE_BROWN.get(), "minecraft", "jungle");
        processChairVariants(TBABlocks.DESK_CHAIR_JUNGLE_GREEN.get(), "minecraft", "jungle");
        processChairVariants(TBABlocks.DESK_CHAIR_JUNGLE_RED.get(), "minecraft", "jungle");
        processChairVariants(TBABlocks.DESK_CHAIR_JUNGLE_BLACK.get(), "minecraft", "jungle");
        processTableVariants(TBABlocks.TABLE_JUNGLE.get(), "minecraft", "jungle");
        processLockerVariants(TBABlocks.LOCKER_JUNGLE.get(), "minecraft", "jungle");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_JUNGLE.get(), "minecraft", "jungle");
        processDeskVariants(TBABlocks.SCHOOL_DESK_JUNGLE.get(), "minecraft", "jungle");
        processBenchVariants(TBABlocks.PARK_BENCH_JUNGLE.get(), "minecraft", "jungle");
        processBookcaseVariants(TBABlocks.BOOKCASE_JUNGLE.get(), "minecraft", "jungle");

        processChairVariants(TBABlocks.DESK_CHAIR_SPRUCE.get(), "minecraft", "spruce");
        processChairVariants(TBABlocks.DESK_CHAIR_SPRUCE_WHITE.get(), "minecraft", "spruce");
        processChairVariants(TBABlocks.DESK_CHAIR_SPRUCE_ORANGE.get(), "minecraft", "spruce");
        processChairVariants(TBABlocks.DESK_CHAIR_SPRUCE_MAGENTA.get(), "minecraft", "spruce");
        processChairVariants(TBABlocks.DESK_CHAIR_SPRUCE_LIGHT_BLUE.get(), "minecraft", "spruce");
        processChairVariants(TBABlocks.DESK_CHAIR_SPRUCE_YELLOW.get(), "minecraft", "spruce");
        processChairVariants(TBABlocks.DESK_CHAIR_SPRUCE_LIME.get(), "minecraft", "spruce");
        processChairVariants(TBABlocks.DESK_CHAIR_SPRUCE_PINK.get(), "minecraft", "spruce");
        processChairVariants(TBABlocks.DESK_CHAIR_SPRUCE_GRAY.get(), "minecraft", "spruce");
        processChairVariants(TBABlocks.DESK_CHAIR_SPRUCE_LIGHT_GRAY.get(), "minecraft", "spruce");
        processChairVariants(TBABlocks.DESK_CHAIR_SPRUCE_CYAN.get(), "minecraft", "spruce");
        processChairVariants(TBABlocks.DESK_CHAIR_SPRUCE_PURPLE.get(), "minecraft", "spruce");
        processChairVariants(TBABlocks.DESK_CHAIR_SPRUCE_BLUE.get(), "minecraft", "spruce");
        processChairVariants(TBABlocks.DESK_CHAIR_SPRUCE_BROWN.get(), "minecraft", "spruce");
        processChairVariants(TBABlocks.DESK_CHAIR_SPRUCE_GREEN.get(), "minecraft", "spruce");
        processChairVariants(TBABlocks.DESK_CHAIR_SPRUCE_RED.get(), "minecraft", "spruce");
        processChairVariants(TBABlocks.DESK_CHAIR_SPRUCE_BLACK.get(), "minecraft", "spruce");
        processTableVariants(TBABlocks.TABLE_SPRUCE.get(), "minecraft", "spruce");
        processLockerVariants(TBABlocks.LOCKER_SPRUCE.get(), "minecraft", "spruce");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_SPRUCE.get(), "minecraft", "spruce");
        processDeskVariants(TBABlocks.SCHOOL_DESK_SPRUCE.get(), "minecraft", "spruce");
        processBenchVariants(TBABlocks.PARK_BENCH_SPRUCE.get(), "minecraft", "spruce");
        processBookcaseVariants(TBABlocks.BOOKCASE_SPRUCE.get(), "minecraft", "spruce");

        processChairVariants(TBABlocks.DESK_CHAIR_MANGROVE.get(), "minecraft", "mangrove");
        processChairVariants(TBABlocks.DESK_CHAIR_MANGROVE_WHITE.get(), "minecraft", "mangrove");
        processChairVariants(TBABlocks.DESK_CHAIR_MANGROVE_ORANGE.get(), "minecraft", "mangrove");
        processChairVariants(TBABlocks.DESK_CHAIR_MANGROVE_MAGENTA.get(), "minecraft", "mangrove");
        processChairVariants(TBABlocks.DESK_CHAIR_MANGROVE_LIGHT_BLUE.get(), "minecraft", "mangrove");
        processChairVariants(TBABlocks.DESK_CHAIR_MANGROVE_YELLOW.get(), "minecraft", "mangrove");
        processChairVariants(TBABlocks.DESK_CHAIR_MANGROVE_LIME.get(), "minecraft", "mangrove");
        processChairVariants(TBABlocks.DESK_CHAIR_MANGROVE_PINK.get(), "minecraft", "mangrove");
        processChairVariants(TBABlocks.DESK_CHAIR_MANGROVE_GRAY.get(), "minecraft", "mangrove");
        processChairVariants(TBABlocks.DESK_CHAIR_MANGROVE_LIGHT_GRAY.get(), "minecraft", "mangrove");
        processChairVariants(TBABlocks.DESK_CHAIR_MANGROVE_CYAN.get(), "minecraft", "mangrove");
        processChairVariants(TBABlocks.DESK_CHAIR_MANGROVE_PURPLE.get(), "minecraft", "mangrove");
        processChairVariants(TBABlocks.DESK_CHAIR_MANGROVE_BLUE.get(), "minecraft", "mangrove");
        processChairVariants(TBABlocks.DESK_CHAIR_MANGROVE_BROWN.get(), "minecraft", "mangrove");
        processChairVariants(TBABlocks.DESK_CHAIR_MANGROVE_GREEN.get(), "minecraft", "mangrove");
        processChairVariants(TBABlocks.DESK_CHAIR_MANGROVE_RED.get(), "minecraft", "mangrove");
        processChairVariants(TBABlocks.DESK_CHAIR_MANGROVE_BLACK.get(), "minecraft", "mangrove");
        processTableVariants(TBABlocks.TABLE_MANGROVE.get(), "minecraft", "mangrove");
        processLockerVariants(TBABlocks.LOCKER_MANGROVE.get(), "minecraft", "mangrove");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_MANGROVE.get(), "minecraft", "mangrove");
        processDeskVariants(TBABlocks.SCHOOL_DESK_MANGROVE.get(), "minecraft", "mangrove");
        processBenchVariants(TBABlocks.PARK_BENCH_MANGROVE.get(), "minecraft", "mangrove");
        processBookcaseVariants(TBABlocks.BOOKCASE_MANGROVE.get(), "minecraft", "mangrove");

        processChairVariants(TBABlocks.DESK_CHAIR_OAK.get(), "minecraft", "oak");
        processChairVariants(TBABlocks.DESK_CHAIR_OAK_WHITE.get(), "minecraft", "oak");
        processChairVariants(TBABlocks.DESK_CHAIR_OAK_ORANGE.get(), "minecraft", "oak");
        processChairVariants(TBABlocks.DESK_CHAIR_OAK_MAGENTA.get(), "minecraft", "oak");
        processChairVariants(TBABlocks.DESK_CHAIR_OAK_LIGHT_BLUE.get(), "minecraft", "oak");
        processChairVariants(TBABlocks.DESK_CHAIR_OAK_YELLOW.get(), "minecraft", "oak");
        processChairVariants(TBABlocks.DESK_CHAIR_OAK_LIME.get(), "minecraft", "oak");
        processChairVariants(TBABlocks.DESK_CHAIR_OAK_PINK.get(), "minecraft", "oak");
        processChairVariants(TBABlocks.DESK_CHAIR_OAK_GRAY.get(), "minecraft", "oak");
        processChairVariants(TBABlocks.DESK_CHAIR_OAK_LIGHT_GRAY.get(), "minecraft", "oak");
        processChairVariants(TBABlocks.DESK_CHAIR_OAK_CYAN.get(), "minecraft", "oak");
        processChairVariants(TBABlocks.DESK_CHAIR_OAK_PURPLE.get(), "minecraft", "oak");
        processChairVariants(TBABlocks.DESK_CHAIR_OAK_BLUE.get(), "minecraft", "oak");
        processChairVariants(TBABlocks.DESK_CHAIR_OAK_BROWN.get(), "minecraft", "oak");
        processChairVariants(TBABlocks.DESK_CHAIR_OAK_GREEN.get(), "minecraft", "oak");
        processChairVariants(TBABlocks.DESK_CHAIR_OAK_RED.get(), "minecraft", "oak");
        processChairVariants(TBABlocks.DESK_CHAIR_OAK_BLACK.get(), "minecraft", "oak");
        processTableVariants(TBABlocks.TABLE_OAK.get(), "minecraft", "oak");
        processLockerVariants(TBABlocks.LOCKER_OAK.get(), "minecraft", "oak");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_OAK.get(), "minecraft", "oak");
        processDeskVariants(TBABlocks.SCHOOL_DESK_OAK.get(), "minecraft", "oak");
        processBenchVariants(TBABlocks.PARK_BENCH_OAK.get(), "minecraft", "oak");
        processBookcaseVariants(TBABlocks.BOOKCASE_OAK.get(), "minecraft", "oak");

        processChairVariants(TBABlocks.DESK_CHAIR_WARPED.get(), "minecraft", "warped");
        processChairVariants(TBABlocks.DESK_CHAIR_WARPED_WHITE.get(), "minecraft", "warped");
        processChairVariants(TBABlocks.DESK_CHAIR_WARPED_ORANGE.get(), "minecraft", "warped");
        processChairVariants(TBABlocks.DESK_CHAIR_WARPED_MAGENTA.get(), "minecraft", "warped");
        processChairVariants(TBABlocks.DESK_CHAIR_WARPED_LIGHT_BLUE.get(), "minecraft", "warped");
        processChairVariants(TBABlocks.DESK_CHAIR_WARPED_YELLOW.get(), "minecraft", "warped");
        processChairVariants(TBABlocks.DESK_CHAIR_WARPED_LIME.get(), "minecraft", "warped");
        processChairVariants(TBABlocks.DESK_CHAIR_WARPED_PINK.get(), "minecraft", "warped");
        processChairVariants(TBABlocks.DESK_CHAIR_WARPED_GRAY.get(), "minecraft", "warped");
        processChairVariants(TBABlocks.DESK_CHAIR_WARPED_LIGHT_GRAY.get(), "minecraft", "warped");
        processChairVariants(TBABlocks.DESK_CHAIR_WARPED_CYAN.get(), "minecraft", "warped");
        processChairVariants(TBABlocks.DESK_CHAIR_WARPED_PURPLE.get(), "minecraft", "warped");
        processChairVariants(TBABlocks.DESK_CHAIR_WARPED_BLUE.get(), "minecraft", "warped");
        processChairVariants(TBABlocks.DESK_CHAIR_WARPED_BROWN.get(), "minecraft", "warped");
        processChairVariants(TBABlocks.DESK_CHAIR_WARPED_GREEN.get(), "minecraft", "warped");
        processChairVariants(TBABlocks.DESK_CHAIR_WARPED_RED.get(), "minecraft", "warped");
        processChairVariants(TBABlocks.DESK_CHAIR_WARPED_BLACK.get(), "minecraft", "warped");
        processTableVariants(TBABlocks.TABLE_WARPED.get(), "minecraft", "warped");
        processLockerVariants(TBABlocks.LOCKER_WARPED.get(), "minecraft", "warped");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_WARPED.get(), "minecraft", "warped");
        processDeskVariants(TBABlocks.SCHOOL_DESK_WARPED.get(), "minecraft", "warped");
        processBenchVariants(TBABlocks.PARK_BENCH_WARPED.get(), "minecraft", "warped");
        processBookcaseVariants(TBABlocks.BOOKCASE_WARPED.get(), "minecraft", "warped");

        processChairVariants(TBABlocks.DESK_CHAIR_FIR.get(), "biomesoplenty", "fir");
        processChairVariants(TBABlocks.DESK_CHAIR_FIR_WHITE.get(), "biomesoplenty", "fir");
        processChairVariants(TBABlocks.DESK_CHAIR_FIR_ORANGE.get(), "biomesoplenty", "fir");
        processChairVariants(TBABlocks.DESK_CHAIR_FIR_MAGENTA.get(), "biomesoplenty", "fir");
        processChairVariants(TBABlocks.DESK_CHAIR_FIR_LIGHT_BLUE.get(), "biomesoplenty", "fir");
        processChairVariants(TBABlocks.DESK_CHAIR_FIR_YELLOW.get(), "biomesoplenty", "fir");
        processChairVariants(TBABlocks.DESK_CHAIR_FIR_LIME.get(), "biomesoplenty", "fir");
        processChairVariants(TBABlocks.DESK_CHAIR_FIR_PINK.get(), "biomesoplenty", "fir");
        processChairVariants(TBABlocks.DESK_CHAIR_FIR_GRAY.get(), "biomesoplenty", "fir");
        processChairVariants(TBABlocks.DESK_CHAIR_FIR_LIGHT_GRAY.get(), "biomesoplenty", "fir");
        processChairVariants(TBABlocks.DESK_CHAIR_FIR_CYAN.get(), "biomesoplenty", "fir");
        processChairVariants(TBABlocks.DESK_CHAIR_FIR_PURPLE.get(), "biomesoplenty", "fir");
        processChairVariants(TBABlocks.DESK_CHAIR_FIR_BLUE.get(), "biomesoplenty", "fir");
        processChairVariants(TBABlocks.DESK_CHAIR_FIR_BROWN.get(), "biomesoplenty", "fir");
        processChairVariants(TBABlocks.DESK_CHAIR_FIR_GREEN.get(), "biomesoplenty", "fir");
        processChairVariants(TBABlocks.DESK_CHAIR_FIR_RED.get(), "biomesoplenty", "fir");
        processChairVariants(TBABlocks.DESK_CHAIR_FIR_BLACK.get(), "biomesoplenty", "fir");
        processTableVariants(TBABlocks.TABLE_FIR.get(), "biomesoplenty", "fir");
        processLockerVariants(TBABlocks.LOCKER_FIR.get(), "biomesoplenty", "fir");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_FIR.get(), "biomesoplenty", "fir");
        processDeskVariants(TBABlocks.SCHOOL_DESK_FIR.get(), "biomesoplenty", "fir");
        processBenchVariants(TBABlocks.PARK_BENCH_FIR.get(), "biomesoplenty", "fir");
        processBookcaseVariants(TBABlocks.BOOKCASE_FIR.get(), "biomesoplenty", "fir");

        processChairVariants(TBABlocks.DESK_CHAIR_REDWOOD.get(), "biomesoplenty", "redwood");
        processChairVariants(TBABlocks.DESK_CHAIR_REDWOOD_WHITE.get(), "biomesoplenty", "redwood");
        processChairVariants(TBABlocks.DESK_CHAIR_REDWOOD_ORANGE.get(), "biomesoplenty", "redwood");
        processChairVariants(TBABlocks.DESK_CHAIR_REDWOOD_MAGENTA.get(), "biomesoplenty", "redwood");
        processChairVariants(TBABlocks.DESK_CHAIR_REDWOOD_LIGHT_BLUE.get(), "biomesoplenty", "redwood");
        processChairVariants(TBABlocks.DESK_CHAIR_REDWOOD_YELLOW.get(), "biomesoplenty", "redwood");
        processChairVariants(TBABlocks.DESK_CHAIR_REDWOOD_LIME.get(), "biomesoplenty", "redwood");
        processChairVariants(TBABlocks.DESK_CHAIR_REDWOOD_PINK.get(), "biomesoplenty", "redwood");
        processChairVariants(TBABlocks.DESK_CHAIR_REDWOOD_GRAY.get(), "biomesoplenty", "redwood");
        processChairVariants(TBABlocks.DESK_CHAIR_REDWOOD_LIGHT_GRAY.get(), "biomesoplenty", "redwood");
        processChairVariants(TBABlocks.DESK_CHAIR_REDWOOD_CYAN.get(), "biomesoplenty", "redwood");
        processChairVariants(TBABlocks.DESK_CHAIR_REDWOOD_PURPLE.get(), "biomesoplenty", "redwood");
        processChairVariants(TBABlocks.DESK_CHAIR_REDWOOD_BLUE.get(), "biomesoplenty", "redwood");
        processChairVariants(TBABlocks.DESK_CHAIR_REDWOOD_BROWN.get(), "biomesoplenty", "redwood");
        processChairVariants(TBABlocks.DESK_CHAIR_REDWOOD_GREEN.get(), "biomesoplenty", "redwood");
        processChairVariants(TBABlocks.DESK_CHAIR_REDWOOD_RED.get(), "biomesoplenty", "redwood");
        processChairVariants(TBABlocks.DESK_CHAIR_REDWOOD_BLACK.get(), "biomesoplenty", "redwood");
        processTableVariants(TBABlocks.TABLE_REDWOOD.get(), "biomesoplenty", "redwood");
        processLockerVariants(TBABlocks.LOCKER_REDWOOD.get(), "biomesoplenty", "redwood");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_REDWOOD.get(), "biomesoplenty", "redwood");
        processDeskVariants(TBABlocks.SCHOOL_DESK_REDWOOD.get(), "biomesoplenty", "redwood");
        processBenchVariants(TBABlocks.PARK_BENCH_REDWOOD.get(), "biomesoplenty", "redwood");
        processBookcaseVariants(TBABlocks.BOOKCASE_REDWOOD.get(), "biomesoplenty", "redwood");

        processChairVariants(TBABlocks.DESK_CHAIR_CHERRY.get(), "biomesoplenty", "cherry");
        processChairVariants(TBABlocks.DESK_CHAIR_CHERRY_WHITE.get(), "biomesoplenty", "cherry");
        processChairVariants(TBABlocks.DESK_CHAIR_CHERRY_ORANGE.get(), "biomesoplenty", "cherry");
        processChairVariants(TBABlocks.DESK_CHAIR_CHERRY_MAGENTA.get(), "biomesoplenty", "cherry");
        processChairVariants(TBABlocks.DESK_CHAIR_CHERRY_LIGHT_BLUE.get(), "biomesoplenty", "cherry");
        processChairVariants(TBABlocks.DESK_CHAIR_CHERRY_YELLOW.get(), "biomesoplenty", "cherry");
        processChairVariants(TBABlocks.DESK_CHAIR_CHERRY_LIME.get(), "biomesoplenty", "cherry");
        processChairVariants(TBABlocks.DESK_CHAIR_CHERRY_PINK.get(), "biomesoplenty", "cherry");
        processChairVariants(TBABlocks.DESK_CHAIR_CHERRY_GRAY.get(), "biomesoplenty", "cherry");
        processChairVariants(TBABlocks.DESK_CHAIR_CHERRY_LIGHT_GRAY.get(), "biomesoplenty", "cherry");
        processChairVariants(TBABlocks.DESK_CHAIR_CHERRY_CYAN.get(), "biomesoplenty", "cherry");
        processChairVariants(TBABlocks.DESK_CHAIR_CHERRY_PURPLE.get(), "biomesoplenty", "cherry");
        processChairVariants(TBABlocks.DESK_CHAIR_CHERRY_BLUE.get(), "biomesoplenty", "cherry");
        processChairVariants(TBABlocks.DESK_CHAIR_CHERRY_BROWN.get(), "biomesoplenty", "cherry");
        processChairVariants(TBABlocks.DESK_CHAIR_CHERRY_GREEN.get(), "biomesoplenty", "cherry");
        processChairVariants(TBABlocks.DESK_CHAIR_CHERRY_RED.get(), "biomesoplenty", "cherry");
        processChairVariants(TBABlocks.DESK_CHAIR_CHERRY_BLACK.get(), "biomesoplenty", "cherry");
        processTableVariants(TBABlocks.TABLE_CHERRY.get(), "biomesoplenty", "cherry");
        processLockerVariants(TBABlocks.LOCKER_CHERRY.get(), "biomesoplenty", "cherry");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_CHERRY.get(), "biomesoplenty", "cherry");
        processDeskVariants(TBABlocks.SCHOOL_DESK_CHERRY.get(), "biomesoplenty", "cherry");
        processBenchVariants(TBABlocks.PARK_BENCH_CHERRY.get(), "biomesoplenty", "cherry");
        processBookcaseVariants(TBABlocks.BOOKCASE_CHERRY.get(), "biomesoplenty", "cherry");

        processChairVariants(TBABlocks.DESK_CHAIR_MAHOGANY.get(), "biomesoplenty", "mahogany");
        processChairVariants(TBABlocks.DESK_CHAIR_MAHOGANY_WHITE.get(), "biomesoplenty", "mahogany");
        processChairVariants(TBABlocks.DESK_CHAIR_MAHOGANY_ORANGE.get(), "biomesoplenty", "mahogany");
        processChairVariants(TBABlocks.DESK_CHAIR_MAHOGANY_MAGENTA.get(), "biomesoplenty", "mahogany");
        processChairVariants(TBABlocks.DESK_CHAIR_MAHOGANY_LIGHT_BLUE.get(), "biomesoplenty", "mahogany");
        processChairVariants(TBABlocks.DESK_CHAIR_MAHOGANY_YELLOW.get(), "biomesoplenty", "mahogany");
        processChairVariants(TBABlocks.DESK_CHAIR_MAHOGANY_LIME.get(), "biomesoplenty", "mahogany");
        processChairVariants(TBABlocks.DESK_CHAIR_MAHOGANY_PINK.get(), "biomesoplenty", "mahogany");
        processChairVariants(TBABlocks.DESK_CHAIR_MAHOGANY_GRAY.get(), "biomesoplenty", "mahogany");
        processChairVariants(TBABlocks.DESK_CHAIR_MAHOGANY_LIGHT_GRAY.get(), "biomesoplenty", "mahogany");
        processChairVariants(TBABlocks.DESK_CHAIR_MAHOGANY_CYAN.get(), "biomesoplenty", "mahogany");
        processChairVariants(TBABlocks.DESK_CHAIR_MAHOGANY_PURPLE.get(), "biomesoplenty", "mahogany");
        processChairVariants(TBABlocks.DESK_CHAIR_MAHOGANY_BLUE.get(), "biomesoplenty", "mahogany");
        processChairVariants(TBABlocks.DESK_CHAIR_MAHOGANY_BROWN.get(), "biomesoplenty", "mahogany");
        processChairVariants(TBABlocks.DESK_CHAIR_MAHOGANY_GREEN.get(), "biomesoplenty", "mahogany");
        processChairVariants(TBABlocks.DESK_CHAIR_MAHOGANY_RED.get(), "biomesoplenty", "mahogany");
        processChairVariants(TBABlocks.DESK_CHAIR_MAHOGANY_BLACK.get(), "biomesoplenty", "mahogany");
        processTableVariants(TBABlocks.TABLE_MAHOGANY.get(), "biomesoplenty", "mahogany");
        processLockerVariants(TBABlocks.LOCKER_MAHOGANY.get(), "biomesoplenty", "mahogany");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_MAHOGANY.get(), "biomesoplenty", "mahogany");
        processDeskVariants(TBABlocks.SCHOOL_DESK_MAHOGANY.get(), "biomesoplenty", "mahogany");
        processBenchVariants(TBABlocks.PARK_BENCH_MAHOGANY.get(), "biomesoplenty", "mahogany");
        processBookcaseVariants(TBABlocks.BOOKCASE_MAHOGANY.get(), "biomesoplenty", "mahogany");

        processChairVariants(TBABlocks.DESK_CHAIR_JACARANDA.get(), "biomesoplenty", "jacaranda");
        processChairVariants(TBABlocks.DESK_CHAIR_JACARANDA_WHITE.get(), "biomesoplenty", "jacaranda");
        processChairVariants(TBABlocks.DESK_CHAIR_JACARANDA_ORANGE.get(), "biomesoplenty", "jacaranda");
        processChairVariants(TBABlocks.DESK_CHAIR_JACARANDA_MAGENTA.get(), "biomesoplenty", "jacaranda");
        processChairVariants(TBABlocks.DESK_CHAIR_JACARANDA_LIGHT_BLUE.get(), "biomesoplenty", "jacaranda");
        processChairVariants(TBABlocks.DESK_CHAIR_JACARANDA_YELLOW.get(), "biomesoplenty", "jacaranda");
        processChairVariants(TBABlocks.DESK_CHAIR_JACARANDA_LIME.get(), "biomesoplenty", "jacaranda");
        processChairVariants(TBABlocks.DESK_CHAIR_JACARANDA_PINK.get(), "biomesoplenty", "jacaranda");
        processChairVariants(TBABlocks.DESK_CHAIR_JACARANDA_GRAY.get(), "biomesoplenty", "jacaranda");
        processChairVariants(TBABlocks.DESK_CHAIR_JACARANDA_LIGHT_GRAY.get(), "biomesoplenty", "jacaranda");
        processChairVariants(TBABlocks.DESK_CHAIR_JACARANDA_CYAN.get(), "biomesoplenty", "jacaranda");
        processChairVariants(TBABlocks.DESK_CHAIR_JACARANDA_PURPLE.get(), "biomesoplenty", "jacaranda");
        processChairVariants(TBABlocks.DESK_CHAIR_JACARANDA_BLUE.get(), "biomesoplenty", "jacaranda");
        processChairVariants(TBABlocks.DESK_CHAIR_JACARANDA_BROWN.get(), "biomesoplenty", "jacaranda");
        processChairVariants(TBABlocks.DESK_CHAIR_JACARANDA_GREEN.get(), "biomesoplenty", "jacaranda");
        processChairVariants(TBABlocks.DESK_CHAIR_JACARANDA_RED.get(), "biomesoplenty", "jacaranda");
        processChairVariants(TBABlocks.DESK_CHAIR_JACARANDA_BLACK.get(), "biomesoplenty", "jacaranda");
        processTableVariants(TBABlocks.TABLE_JACARANDA.get(), "biomesoplenty", "jacaranda");
        processLockerVariants(TBABlocks.LOCKER_JACARANDA.get(), "biomesoplenty", "jacaranda");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_JACARANDA.get(), "biomesoplenty", "jacaranda");
        processDeskVariants(TBABlocks.SCHOOL_DESK_JACARANDA.get(), "biomesoplenty", "jacaranda");
        processBenchVariants(TBABlocks.PARK_BENCH_JACARANDA.get(), "biomesoplenty", "jacaranda");
        processBookcaseVariants(TBABlocks.BOOKCASE_JACARANDA.get(), "biomesoplenty", "jacaranda");

        processChairVariants(TBABlocks.DESK_CHAIR_PALM.get(), "biomesoplenty", "palm");
        processChairVariants(TBABlocks.DESK_CHAIR_PALM_WHITE.get(), "biomesoplenty", "palm");
        processChairVariants(TBABlocks.DESK_CHAIR_PALM_ORANGE.get(), "biomesoplenty", "palm");
        processChairVariants(TBABlocks.DESK_CHAIR_PALM_MAGENTA.get(), "biomesoplenty", "palm");
        processChairVariants(TBABlocks.DESK_CHAIR_PALM_LIGHT_BLUE.get(), "biomesoplenty", "palm");
        processChairVariants(TBABlocks.DESK_CHAIR_PALM_YELLOW.get(), "biomesoplenty", "palm");
        processChairVariants(TBABlocks.DESK_CHAIR_PALM_LIME.get(), "biomesoplenty", "palm");
        processChairVariants(TBABlocks.DESK_CHAIR_PALM_PINK.get(), "biomesoplenty", "palm");
        processChairVariants(TBABlocks.DESK_CHAIR_PALM_GRAY.get(), "biomesoplenty", "palm");
        processChairVariants(TBABlocks.DESK_CHAIR_PALM_LIGHT_GRAY.get(), "biomesoplenty", "palm");
        processChairVariants(TBABlocks.DESK_CHAIR_PALM_CYAN.get(), "biomesoplenty", "palm");
        processChairVariants(TBABlocks.DESK_CHAIR_PALM_PURPLE.get(), "biomesoplenty", "palm");
        processChairVariants(TBABlocks.DESK_CHAIR_PALM_BLUE.get(), "biomesoplenty", "palm");
        processChairVariants(TBABlocks.DESK_CHAIR_PALM_BROWN.get(), "biomesoplenty", "palm");
        processChairVariants(TBABlocks.DESK_CHAIR_PALM_GREEN.get(), "biomesoplenty", "palm");
        processChairVariants(TBABlocks.DESK_CHAIR_PALM_RED.get(), "biomesoplenty", "palm");
        processChairVariants(TBABlocks.DESK_CHAIR_PALM_BLACK.get(), "biomesoplenty", "palm");
        processTableVariants(TBABlocks.TABLE_PALM.get(), "biomesoplenty", "palm");
        processLockerVariants(TBABlocks.LOCKER_PALM.get(), "biomesoplenty", "palm");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_PALM.get(), "biomesoplenty", "palm");
        processDeskVariants(TBABlocks.SCHOOL_DESK_PALM.get(), "biomesoplenty", "palm");
        processBenchVariants(TBABlocks.PARK_BENCH_PALM.get(), "biomesoplenty", "palm");
        processBookcaseVariants(TBABlocks.BOOKCASE_PALM.get(), "biomesoplenty", "palm");

        processChairVariants(TBABlocks.DESK_CHAIR_WILLOW.get(), "biomesoplenty", "willow");
        processChairVariants(TBABlocks.DESK_CHAIR_WILLOW_WHITE.get(), "biomesoplenty", "willow");
        processChairVariants(TBABlocks.DESK_CHAIR_WILLOW_ORANGE.get(), "biomesoplenty", "willow");
        processChairVariants(TBABlocks.DESK_CHAIR_WILLOW_MAGENTA.get(), "biomesoplenty", "willow");
        processChairVariants(TBABlocks.DESK_CHAIR_WILLOW_LIGHT_BLUE.get(), "biomesoplenty", "willow");
        processChairVariants(TBABlocks.DESK_CHAIR_WILLOW_YELLOW.get(), "biomesoplenty", "willow");
        processChairVariants(TBABlocks.DESK_CHAIR_WILLOW_LIME.get(), "biomesoplenty", "willow");
        processChairVariants(TBABlocks.DESK_CHAIR_WILLOW_PINK.get(), "biomesoplenty", "willow");
        processChairVariants(TBABlocks.DESK_CHAIR_WILLOW_GRAY.get(), "biomesoplenty", "willow");
        processChairVariants(TBABlocks.DESK_CHAIR_WILLOW_LIGHT_GRAY.get(), "biomesoplenty", "willow");
        processChairVariants(TBABlocks.DESK_CHAIR_WILLOW_CYAN.get(), "biomesoplenty", "willow");
        processChairVariants(TBABlocks.DESK_CHAIR_WILLOW_PURPLE.get(), "biomesoplenty", "willow");
        processChairVariants(TBABlocks.DESK_CHAIR_WILLOW_BLUE.get(), "biomesoplenty", "willow");
        processChairVariants(TBABlocks.DESK_CHAIR_WILLOW_BROWN.get(), "biomesoplenty", "willow");
        processChairVariants(TBABlocks.DESK_CHAIR_WILLOW_GREEN.get(), "biomesoplenty", "willow");
        processChairVariants(TBABlocks.DESK_CHAIR_WILLOW_RED.get(), "biomesoplenty", "willow");
        processChairVariants(TBABlocks.DESK_CHAIR_WILLOW_BLACK.get(), "biomesoplenty", "willow");
        processTableVariants(TBABlocks.TABLE_WILLOW.get(), "biomesoplenty", "willow");
        processLockerVariants(TBABlocks.LOCKER_WILLOW.get(), "biomesoplenty", "willow");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_WILLOW.get(), "biomesoplenty", "willow");
        processDeskVariants(TBABlocks.SCHOOL_DESK_WILLOW.get(), "biomesoplenty", "willow");
        processBenchVariants(TBABlocks.PARK_BENCH_WILLOW.get(), "biomesoplenty", "willow");
        processBookcaseVariants(TBABlocks.BOOKCASE_WILLOW.get(), "biomesoplenty", "willow");

        processChairVariants(TBABlocks.DESK_CHAIR_DEAD.get(), "biomesoplenty", "dead");
        processChairVariants(TBABlocks.DESK_CHAIR_DEAD_WHITE.get(), "biomesoplenty", "dead");
        processChairVariants(TBABlocks.DESK_CHAIR_DEAD_ORANGE.get(), "biomesoplenty", "dead");
        processChairVariants(TBABlocks.DESK_CHAIR_DEAD_MAGENTA.get(), "biomesoplenty", "dead");
        processChairVariants(TBABlocks.DESK_CHAIR_DEAD_LIGHT_BLUE.get(), "biomesoplenty", "dead");
        processChairVariants(TBABlocks.DESK_CHAIR_DEAD_YELLOW.get(), "biomesoplenty", "dead");
        processChairVariants(TBABlocks.DESK_CHAIR_DEAD_LIME.get(), "biomesoplenty", "dead");
        processChairVariants(TBABlocks.DESK_CHAIR_DEAD_PINK.get(), "biomesoplenty", "dead");
        processChairVariants(TBABlocks.DESK_CHAIR_DEAD_GRAY.get(), "biomesoplenty", "dead");
        processChairVariants(TBABlocks.DESK_CHAIR_DEAD_LIGHT_GRAY.get(), "biomesoplenty", "dead");
        processChairVariants(TBABlocks.DESK_CHAIR_DEAD_CYAN.get(), "biomesoplenty", "dead");
        processChairVariants(TBABlocks.DESK_CHAIR_DEAD_PURPLE.get(), "biomesoplenty", "dead");
        processChairVariants(TBABlocks.DESK_CHAIR_DEAD_BLUE.get(), "biomesoplenty", "dead");
        processChairVariants(TBABlocks.DESK_CHAIR_DEAD_BROWN.get(), "biomesoplenty", "dead");
        processChairVariants(TBABlocks.DESK_CHAIR_DEAD_GREEN.get(), "biomesoplenty", "dead");
        processChairVariants(TBABlocks.DESK_CHAIR_DEAD_RED.get(), "biomesoplenty", "dead");
        processChairVariants(TBABlocks.DESK_CHAIR_DEAD_BLACK.get(), "biomesoplenty", "dead");
        processTableVariants(TBABlocks.TABLE_DEAD.get(), "biomesoplenty", "dead");
        processLockerVariants(TBABlocks.LOCKER_DEAD.get(), "biomesoplenty", "dead");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_DEAD.get(), "biomesoplenty", "dead");
        processDeskVariants(TBABlocks.SCHOOL_DESK_DEAD.get(), "biomesoplenty", "dead");
        processBenchVariants(TBABlocks.PARK_BENCH_DEAD.get(), "biomesoplenty", "dead");
        processBookcaseVariants(TBABlocks.BOOKCASE_DEAD.get(), "biomesoplenty", "dead");

        processChairVariants(TBABlocks.DESK_CHAIR_MAGIC.get(), "biomesoplenty", "magic");
        processChairVariants(TBABlocks.DESK_CHAIR_MAGIC_WHITE.get(), "biomesoplenty", "magic");
        processChairVariants(TBABlocks.DESK_CHAIR_MAGIC_ORANGE.get(), "biomesoplenty", "magic");
        processChairVariants(TBABlocks.DESK_CHAIR_MAGIC_MAGENTA.get(), "biomesoplenty", "magic");
        processChairVariants(TBABlocks.DESK_CHAIR_MAGIC_LIGHT_BLUE.get(), "biomesoplenty", "magic");
        processChairVariants(TBABlocks.DESK_CHAIR_MAGIC_YELLOW.get(), "biomesoplenty", "magic");
        processChairVariants(TBABlocks.DESK_CHAIR_MAGIC_LIME.get(), "biomesoplenty", "magic");
        processChairVariants(TBABlocks.DESK_CHAIR_MAGIC_PINK.get(), "biomesoplenty", "magic");
        processChairVariants(TBABlocks.DESK_CHAIR_MAGIC_GRAY.get(), "biomesoplenty", "magic");
        processChairVariants(TBABlocks.DESK_CHAIR_MAGIC_LIGHT_GRAY.get(), "biomesoplenty", "magic");
        processChairVariants(TBABlocks.DESK_CHAIR_MAGIC_CYAN.get(), "biomesoplenty", "magic");
        processChairVariants(TBABlocks.DESK_CHAIR_MAGIC_PURPLE.get(), "biomesoplenty", "magic");
        processChairVariants(TBABlocks.DESK_CHAIR_MAGIC_BLUE.get(), "biomesoplenty", "magic");
        processChairVariants(TBABlocks.DESK_CHAIR_MAGIC_BROWN.get(), "biomesoplenty", "magic");
        processChairVariants(TBABlocks.DESK_CHAIR_MAGIC_GREEN.get(), "biomesoplenty", "magic");
        processChairVariants(TBABlocks.DESK_CHAIR_MAGIC_RED.get(), "biomesoplenty", "magic");
        processChairVariants(TBABlocks.DESK_CHAIR_MAGIC_BLACK.get(), "biomesoplenty", "magic");
        processTableVariants(TBABlocks.TABLE_MAGIC.get(), "biomesoplenty", "magic");
        processLockerVariants(TBABlocks.LOCKER_MAGIC.get(), "biomesoplenty", "magic");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_MAGIC.get(), "biomesoplenty", "magic");
        processDeskVariants(TBABlocks.SCHOOL_DESK_MAGIC.get(), "biomesoplenty", "magic");
        processBenchVariants(TBABlocks.PARK_BENCH_MAGIC.get(), "biomesoplenty", "magic");
        processBookcaseVariants(TBABlocks.BOOKCASE_MAGIC.get(), "biomesoplenty", "magic");

        processChairVariants(TBABlocks.DESK_CHAIR_UMBRAN.get(), "biomesoplenty", "umbran");
        processChairVariants(TBABlocks.DESK_CHAIR_UMBRAN_WHITE.get(), "biomesoplenty", "umbran");
        processChairVariants(TBABlocks.DESK_CHAIR_UMBRAN_ORANGE.get(), "biomesoplenty", "umbran");
        processChairVariants(TBABlocks.DESK_CHAIR_UMBRAN_MAGENTA.get(), "biomesoplenty", "umbran");
        processChairVariants(TBABlocks.DESK_CHAIR_UMBRAN_LIGHT_BLUE.get(), "biomesoplenty", "umbran");
        processChairVariants(TBABlocks.DESK_CHAIR_UMBRAN_YELLOW.get(), "biomesoplenty", "umbran");
        processChairVariants(TBABlocks.DESK_CHAIR_UMBRAN_LIME.get(), "biomesoplenty", "umbran");
        processChairVariants(TBABlocks.DESK_CHAIR_UMBRAN_PINK.get(), "biomesoplenty", "umbran");
        processChairVariants(TBABlocks.DESK_CHAIR_UMBRAN_GRAY.get(), "biomesoplenty", "umbran");
        processChairVariants(TBABlocks.DESK_CHAIR_UMBRAN_LIGHT_GRAY.get(), "biomesoplenty", "umbran");
        processChairVariants(TBABlocks.DESK_CHAIR_UMBRAN_CYAN.get(), "biomesoplenty", "umbran");
        processChairVariants(TBABlocks.DESK_CHAIR_UMBRAN_PURPLE.get(), "biomesoplenty", "umbran");
        processChairVariants(TBABlocks.DESK_CHAIR_UMBRAN_BLUE.get(), "biomesoplenty", "umbran");
        processChairVariants(TBABlocks.DESK_CHAIR_UMBRAN_BROWN.get(), "biomesoplenty", "umbran");
        processChairVariants(TBABlocks.DESK_CHAIR_UMBRAN_GREEN.get(), "biomesoplenty", "umbran");
        processChairVariants(TBABlocks.DESK_CHAIR_UMBRAN_RED.get(), "biomesoplenty", "umbran");
        processChairVariants(TBABlocks.DESK_CHAIR_UMBRAN_BLACK.get(), "biomesoplenty", "umbran");
        processTableVariants(TBABlocks.TABLE_UMBRAN.get(), "biomesoplenty", "umbran");
        processLockerVariants(TBABlocks.LOCKER_UMBRAN.get(), "biomesoplenty", "umbran");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_UMBRAN.get(), "biomesoplenty", "umbran");
        processDeskVariants(TBABlocks.SCHOOL_DESK_UMBRAN.get(), "biomesoplenty", "umbran");
        processBenchVariants(TBABlocks.PARK_BENCH_UMBRAN.get(), "biomesoplenty", "umbran");
        processBookcaseVariants(TBABlocks.BOOKCASE_UMBRAN.get(), "biomesoplenty", "umbran");

        processChairVariants(TBABlocks.DESK_CHAIR_HELLBARK.get(), "biomesoplenty", "hellbark");
        processChairVariants(TBABlocks.DESK_CHAIR_HELLBARK_WHITE.get(), "biomesoplenty", "hellbark");
        processChairVariants(TBABlocks.DESK_CHAIR_HELLBARK_ORANGE.get(), "biomesoplenty", "hellbark");
        processChairVariants(TBABlocks.DESK_CHAIR_HELLBARK_MAGENTA.get(), "biomesoplenty", "hellbark");
        processChairVariants(TBABlocks.DESK_CHAIR_HELLBARK_LIGHT_BLUE.get(), "biomesoplenty", "hellbark");
        processChairVariants(TBABlocks.DESK_CHAIR_HELLBARK_YELLOW.get(), "biomesoplenty", "hellbark");
        processChairVariants(TBABlocks.DESK_CHAIR_HELLBARK_LIME.get(), "biomesoplenty", "hellbark");
        processChairVariants(TBABlocks.DESK_CHAIR_HELLBARK_PINK.get(), "biomesoplenty", "hellbark");
        processChairVariants(TBABlocks.DESK_CHAIR_HELLBARK_GRAY.get(), "biomesoplenty", "hellbark");
        processChairVariants(TBABlocks.DESK_CHAIR_HELLBARK_LIGHT_GRAY.get(), "biomesoplenty", "hellbark");
        processChairVariants(TBABlocks.DESK_CHAIR_HELLBARK_CYAN.get(), "biomesoplenty", "hellbark");
        processChairVariants(TBABlocks.DESK_CHAIR_HELLBARK_PURPLE.get(), "biomesoplenty", "hellbark");
        processChairVariants(TBABlocks.DESK_CHAIR_HELLBARK_BLUE.get(), "biomesoplenty", "hellbark");
        processChairVariants(TBABlocks.DESK_CHAIR_HELLBARK_BROWN.get(), "biomesoplenty", "hellbark");
        processChairVariants(TBABlocks.DESK_CHAIR_HELLBARK_GREEN.get(), "biomesoplenty", "hellbark");
        processChairVariants(TBABlocks.DESK_CHAIR_HELLBARK_RED.get(), "biomesoplenty", "hellbark");
        processChairVariants(TBABlocks.DESK_CHAIR_HELLBARK_BLACK.get(), "biomesoplenty", "hellbark");
        processTableVariants(TBABlocks.TABLE_HELLBARK.get(), "biomesoplenty", "hellbark");
        processLockerVariants(TBABlocks.LOCKER_HELLBARK.get(), "biomesoplenty", "hellbark");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_HELLBARK.get(), "biomesoplenty", "hellbark");
        processDeskVariants(TBABlocks.SCHOOL_DESK_HELLBARK.get(), "biomesoplenty", "hellbark");
        processBenchVariants(TBABlocks.PARK_BENCH_HELLBARK.get(), "biomesoplenty", "hellbark");
        processBookcaseVariants(TBABlocks.BOOKCASE_HELLBARK.get(), "biomesoplenty", "hellbark");

        processChairVariants(TBABlocks.DESK_CHAIR_COCONUT.get(), "ecologics", "coconut");
        processChairVariants(TBABlocks.DESK_CHAIR_COCONUT_WHITE.get(), "ecologics", "coconut");
        processChairVariants(TBABlocks.DESK_CHAIR_COCONUT_ORANGE.get(), "ecologics", "coconut");
        processChairVariants(TBABlocks.DESK_CHAIR_COCONUT_MAGENTA.get(), "ecologics", "coconut");
        processChairVariants(TBABlocks.DESK_CHAIR_COCONUT_LIGHT_BLUE.get(), "ecologics", "coconut");
        processChairVariants(TBABlocks.DESK_CHAIR_COCONUT_YELLOW.get(), "ecologics", "coconut");
        processChairVariants(TBABlocks.DESK_CHAIR_COCONUT_LIME.get(), "ecologics", "coconut");
        processChairVariants(TBABlocks.DESK_CHAIR_COCONUT_PINK.get(), "ecologics", "coconut");
        processChairVariants(TBABlocks.DESK_CHAIR_COCONUT_GRAY.get(), "ecologics", "coconut");
        processChairVariants(TBABlocks.DESK_CHAIR_COCONUT_LIGHT_GRAY.get(), "ecologics", "coconut");
        processChairVariants(TBABlocks.DESK_CHAIR_COCONUT_CYAN.get(), "ecologics", "coconut");
        processChairVariants(TBABlocks.DESK_CHAIR_COCONUT_PURPLE.get(), "ecologics", "coconut");
        processChairVariants(TBABlocks.DESK_CHAIR_COCONUT_BLUE.get(), "ecologics", "coconut");
        processChairVariants(TBABlocks.DESK_CHAIR_COCONUT_BROWN.get(), "ecologics", "coconut");
        processChairVariants(TBABlocks.DESK_CHAIR_COCONUT_GREEN.get(), "ecologics", "coconut");
        processChairVariants(TBABlocks.DESK_CHAIR_COCONUT_RED.get(), "ecologics", "coconut");
        processChairVariants(TBABlocks.DESK_CHAIR_COCONUT_BLACK.get(), "ecologics", "coconut");
        processTableVariants(TBABlocks.TABLE_COCONUT.get(), "ecologics", "coconut");
        processLockerVariants(TBABlocks.LOCKER_COCONUT.get(), "ecologics", "coconut");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_COCONUT.get(), "ecologics", "coconut");
        processDeskVariants(TBABlocks.SCHOOL_DESK_COCONUT.get(), "ecologics", "coconut");
        processBenchVariants(TBABlocks.PARK_BENCH_COCONUT.get(), "ecologics", "coconut");
        processBookcaseVariants(TBABlocks.BOOKCASE_COCONUT.get(), "ecologics", "coconut");

        processChairVariants(TBABlocks.DESK_CHAIR_WALNUT.get(), "ecologics", "walnut");
        processChairVariants(TBABlocks.DESK_CHAIR_WALNUT_WHITE.get(), "ecologics", "walnut");
        processChairVariants(TBABlocks.DESK_CHAIR_WALNUT_ORANGE.get(), "ecologics", "walnut");
        processChairVariants(TBABlocks.DESK_CHAIR_WALNUT_MAGENTA.get(), "ecologics", "walnut");
        processChairVariants(TBABlocks.DESK_CHAIR_WALNUT_LIGHT_BLUE.get(), "ecologics", "walnut");
        processChairVariants(TBABlocks.DESK_CHAIR_WALNUT_YELLOW.get(), "ecologics", "walnut");
        processChairVariants(TBABlocks.DESK_CHAIR_WALNUT_LIME.get(), "ecologics", "walnut");
        processChairVariants(TBABlocks.DESK_CHAIR_WALNUT_PINK.get(), "ecologics", "walnut");
        processChairVariants(TBABlocks.DESK_CHAIR_WALNUT_GRAY.get(), "ecologics", "walnut");
        processChairVariants(TBABlocks.DESK_CHAIR_WALNUT_LIGHT_GRAY.get(), "ecologics", "walnut");
        processChairVariants(TBABlocks.DESK_CHAIR_WALNUT_CYAN.get(), "ecologics", "walnut");
        processChairVariants(TBABlocks.DESK_CHAIR_WALNUT_PURPLE.get(), "ecologics", "walnut");
        processChairVariants(TBABlocks.DESK_CHAIR_WALNUT_BLUE.get(), "ecologics", "walnut");
        processChairVariants(TBABlocks.DESK_CHAIR_WALNUT_BROWN.get(), "ecologics", "walnut");
        processChairVariants(TBABlocks.DESK_CHAIR_WALNUT_GREEN.get(), "ecologics", "walnut");
        processChairVariants(TBABlocks.DESK_CHAIR_WALNUT_RED.get(), "ecologics", "walnut");
        processChairVariants(TBABlocks.DESK_CHAIR_WALNUT_BLACK.get(), "ecologics", "walnut");
        processTableVariants(TBABlocks.TABLE_WALNUT.get(), "ecologics", "walnut");
        processLockerVariants(TBABlocks.LOCKER_WALNUT.get(), "ecologics", "walnut");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_WALNUT.get(), "ecologics", "walnut");
        processDeskVariants(TBABlocks.SCHOOL_DESK_WALNUT.get(), "ecologics", "walnut");
        processBenchVariants(TBABlocks.PARK_BENCH_WALNUT.get(), "ecologics", "walnut");
        processBookcaseVariants(TBABlocks.BOOKCASE_WALNUT.get(), "ecologics", "walnut");

        processChairVariants(TBABlocks.DESK_CHAIR_AZALEA.get(), "ecologics", "azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_AZALEA_WHITE.get(), "ecologics", "azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_AZALEA_ORANGE.get(), "ecologics", "azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_AZALEA_MAGENTA.get(), "ecologics", "azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_AZALEA_LIGHT_BLUE.get(), "ecologics", "azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_AZALEA_YELLOW.get(), "ecologics", "azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_AZALEA_LIME.get(), "ecologics", "azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_AZALEA_PINK.get(), "ecologics", "azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_AZALEA_GRAY.get(), "ecologics", "azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_AZALEA_LIGHT_GRAY.get(), "ecologics", "azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_AZALEA_CYAN.get(), "ecologics", "azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_AZALEA_PURPLE.get(), "ecologics", "azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_AZALEA_BLUE.get(), "ecologics", "azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_AZALEA_BROWN.get(), "ecologics", "azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_AZALEA_GREEN.get(), "ecologics", "azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_AZALEA_RED.get(), "ecologics", "azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_AZALEA_BLACK.get(), "ecologics", "azalea");
        processTableVariants(TBABlocks.TABLE_AZALEA.get(), "ecologics", "azalea");
        processLockerVariants(TBABlocks.LOCKER_AZALEA.get(), "ecologics", "azalea");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_AZALEA.get(), "ecologics", "azalea");
        processDeskVariants(TBABlocks.SCHOOL_DESK_AZALEA.get(), "ecologics", "azalea");
        processBenchVariants(TBABlocks.PARK_BENCH_AZALEA.get(), "ecologics", "azalea");
        processBookcaseVariants(TBABlocks.BOOKCASE_AZALEA.get(), "ecologics", "azalea");

        processChairVariants(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA.get(), "ecologics", "flowering_azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_WHITE.get(), "ecologics", "flowering_azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_ORANGE.get(), "ecologics", "flowering_azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_MAGENTA.get(), "ecologics", "flowering_azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_LIGHT_BLUE.get(), "ecologics", "flowering_azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_YELLOW.get(), "ecologics", "flowering_azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_LIME.get(), "ecologics", "flowering_azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_PINK.get(), "ecologics", "flowering_azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_GRAY.get(), "ecologics", "flowering_azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_LIGHT_GRAY.get(), "ecologics", "flowering_azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_CYAN.get(), "ecologics", "flowering_azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_PURPLE.get(), "ecologics", "flowering_azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_BLUE.get(), "ecologics", "flowering_azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_BROWN.get(), "ecologics", "flowering_azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_GREEN.get(), "ecologics", "flowering_azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_RED.get(), "ecologics", "flowering_azalea");
        processChairVariants(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_BLACK.get(), "ecologics", "flowering_azalea");
        processTableVariants(TBABlocks.TABLE_FLOWERING_AZALEA.get(), "ecologics", "flowering_azalea");
        processLockerVariants(TBABlocks.LOCKER_FLOWERING_AZALEA.get(), "ecologics", "flowering_azalea");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_FLOWERING_AZALEA.get(), "ecologics", "flowering_azalea");
        processDeskVariants(TBABlocks.SCHOOL_DESK_FLOWERING_AZALEA.get(), "ecologics", "flowering_azalea");
        processBenchVariants(TBABlocks.PARK_BENCH_FLOWERING_AZALEA.get(), "ecologics", "flowering_azalea");
        processBookcaseVariants(TBABlocks.BOOKCASE_FLOWERING_AZALEA.get(), "ecologics", "flowering_azalea");

        processChairVariants(TBABlocks.DESK_CHAIR_GOLDEN_OAK.get(), "aether", "golden_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_GOLDEN_OAK_WHITE.get(), "aether", "golden_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_GOLDEN_OAK_ORANGE.get(), "aether", "golden_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_GOLDEN_OAK_MAGENTA.get(), "aether", "golden_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_GOLDEN_OAK_LIGHT_BLUE.get(), "aether", "golden_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_GOLDEN_OAK_YELLOW.get(), "aether", "golden_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_GOLDEN_OAK_LIME.get(), "aether", "golden_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_GOLDEN_OAK_PINK.get(), "aether", "golden_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_GOLDEN_OAK_GRAY.get(), "aether", "golden_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_GOLDEN_OAK_LIGHT_GRAY.get(), "aether", "golden_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_GOLDEN_OAK_CYAN.get(), "aether", "golden_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_GOLDEN_OAK_PURPLE.get(), "aether", "golden_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_GOLDEN_OAK_BLUE.get(), "aether", "golden_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_GOLDEN_OAK_BROWN.get(), "aether", "golden_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_GOLDEN_OAK_GREEN.get(), "aether", "golden_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_GOLDEN_OAK_RED.get(), "aether", "golden_oak");
        processChairVariants(TBABlocks.DESK_CHAIR_GOLDEN_OAK_BLACK.get(), "aether", "golden_oak");
        processTableVariants(TBABlocks.TABLE_GOLDEN_OAK.get(), "aether", "golden_oak");
        processLockerVariants(TBABlocks.LOCKER_GOLDEN_OAK.get(), "aether", "golden_oak");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_GOLDEN_OAK.get(), "aether", "golden_oak");
        processDeskVariants(TBABlocks.SCHOOL_DESK_GOLDEN_OAK.get(), "aether", "golden_oak");
        processBenchVariants(TBABlocks.PARK_BENCH_GOLDEN_OAK.get(), "aether", "golden_oak");
        processBookcaseVariants(TBABlocks.BOOKCASE_GOLDEN_OAK.get(), "aether", "golden_oak");

        processChairVariants(TBABlocks.DESK_CHAIR_AETHER_SKYROOT.get(), "aether", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_WHITE.get(), "aether", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_ORANGE.get(), "aether", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_MAGENTA.get(), "aether", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_LIGHT_BLUE.get(), "aether", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_YELLOW.get(), "aether", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_LIME.get(), "aether", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_PINK.get(), "aether", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_GRAY.get(), "aether", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_LIGHT_GRAY.get(), "aether", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_CYAN.get(), "aether", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_PURPLE.get(), "aether", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_BLUE.get(), "aether", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_BROWN.get(), "aether", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_GREEN.get(), "aether", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_RED.get(), "aether", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_BLACK.get(), "aether", "skyroot");
        processTableVariants(TBABlocks.TABLE_AETHER_SKYROOT.get(), "aether", "skyroot");
        processLockerVariants(TBABlocks.LOCKER_AETHER_SKYROOT.get(), "aether", "skyroot");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_AETHER_SKYROOT.get(), "aether", "skyroot");
        processDeskVariants(TBABlocks.SCHOOL_DESK_AETHER_SKYROOT.get(), "aether", "skyroot");
        processBenchVariants(TBABlocks.PARK_BENCH_AETHER_SKYROOT.get(), "aether", "skyroot");
        processBookcaseVariants(TBABlocks.BOOKCASE_AETHER_SKYROOT.get(), "aether", "skyroot");

        processChairVariants(TBABlocks.DESK_CHAIR_PREAM.get(), "phantasm", "pream");
        processChairVariants(TBABlocks.DESK_CHAIR_PREAM_WHITE.get(), "phantasm", "pream");
        processChairVariants(TBABlocks.DESK_CHAIR_PREAM_ORANGE.get(), "phantasm", "pream");
        processChairVariants(TBABlocks.DESK_CHAIR_PREAM_MAGENTA.get(), "phantasm", "pream");
        processChairVariants(TBABlocks.DESK_CHAIR_PREAM_LIGHT_BLUE.get(), "phantasm", "pream");
        processChairVariants(TBABlocks.DESK_CHAIR_PREAM_YELLOW.get(), "phantasm", "pream");
        processChairVariants(TBABlocks.DESK_CHAIR_PREAM_LIME.get(), "phantasm", "pream");
        processChairVariants(TBABlocks.DESK_CHAIR_PREAM_PINK.get(), "phantasm", "pream");
        processChairVariants(TBABlocks.DESK_CHAIR_PREAM_GRAY.get(), "phantasm", "pream");
        processChairVariants(TBABlocks.DESK_CHAIR_PREAM_LIGHT_GRAY.get(), "phantasm", "pream");
        processChairVariants(TBABlocks.DESK_CHAIR_PREAM_CYAN.get(), "phantasm", "pream");
        processChairVariants(TBABlocks.DESK_CHAIR_PREAM_PURPLE.get(), "phantasm", "pream");
        processChairVariants(TBABlocks.DESK_CHAIR_PREAM_BLUE.get(), "phantasm", "pream");
        processChairVariants(TBABlocks.DESK_CHAIR_PREAM_BROWN.get(), "phantasm", "pream");
        processChairVariants(TBABlocks.DESK_CHAIR_PREAM_GREEN.get(), "phantasm", "pream");
        processChairVariants(TBABlocks.DESK_CHAIR_PREAM_RED.get(), "phantasm", "pream");
        processChairVariants(TBABlocks.DESK_CHAIR_PREAM_BLACK.get(), "phantasm", "pream");
        processTableVariants(TBABlocks.TABLE_PREAM.get(), "phantasm", "pream");
        processLockerVariants(TBABlocks.LOCKER_PREAM.get(), "phantasm", "pream");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_PREAM.get(), "phantasm", "pream");
        processDeskVariants(TBABlocks.SCHOOL_DESK_PREAM.get(), "phantasm", "pream");
        processBenchVariants(TBABlocks.PARK_BENCH_PREAM.get(), "phantasm", "pream");
        processBookcaseVariants(TBABlocks.BOOKCASE_PREAM.get(), "phantasm", "pream");

        processChairVariants(TBABlocks.DESK_CHAIR_EBONY.get(), "phantasm", "ebony");
        processChairVariants(TBABlocks.DESK_CHAIR_EBONY_WHITE.get(), "phantasm", "ebony");
        processChairVariants(TBABlocks.DESK_CHAIR_EBONY_ORANGE.get(), "phantasm", "ebony");
        processChairVariants(TBABlocks.DESK_CHAIR_EBONY_MAGENTA.get(), "phantasm", "ebony");
        processChairVariants(TBABlocks.DESK_CHAIR_EBONY_LIGHT_BLUE.get(), "phantasm", "ebony");
        processChairVariants(TBABlocks.DESK_CHAIR_EBONY_YELLOW.get(), "phantasm", "ebony");
        processChairVariants(TBABlocks.DESK_CHAIR_EBONY_LIME.get(), "phantasm", "ebony");
        processChairVariants(TBABlocks.DESK_CHAIR_EBONY_PINK.get(), "phantasm", "ebony");
        processChairVariants(TBABlocks.DESK_CHAIR_EBONY_GRAY.get(), "phantasm", "ebony");
        processChairVariants(TBABlocks.DESK_CHAIR_EBONY_LIGHT_GRAY.get(), "phantasm", "ebony");
        processChairVariants(TBABlocks.DESK_CHAIR_EBONY_CYAN.get(), "phantasm", "ebony");
        processChairVariants(TBABlocks.DESK_CHAIR_EBONY_PURPLE.get(), "phantasm", "ebony");
        processChairVariants(TBABlocks.DESK_CHAIR_EBONY_BLUE.get(), "phantasm", "ebony");
        processChairVariants(TBABlocks.DESK_CHAIR_EBONY_BROWN.get(), "phantasm", "ebony");
        processChairVariants(TBABlocks.DESK_CHAIR_EBONY_GREEN.get(), "phantasm", "ebony");
        processChairVariants(TBABlocks.DESK_CHAIR_EBONY_RED.get(), "phantasm", "ebony");
        processChairVariants(TBABlocks.DESK_CHAIR_EBONY_BLACK.get(), "phantasm", "ebony");
        processTableVariants(TBABlocks.TABLE_EBONY.get(), "phantasm", "ebony");
        processLockerVariants(TBABlocks.LOCKER_EBONY.get(), "phantasm", "ebony");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_EBONY.get(), "phantasm", "ebony");
        processDeskVariants(TBABlocks.SCHOOL_DESK_EBONY.get(), "phantasm", "ebony");
        processBenchVariants(TBABlocks.PARK_BENCH_EBONY.get(), "phantasm", "ebony");
        processBookcaseVariants(TBABlocks.BOOKCASE_EBONY.get(), "phantasm", "ebony");

        processChairVariants(TBABlocks.DESK_CHAIR_CHORUS_NEST.get(), "unusualend", "chorus_nest");
        processChairVariants(TBABlocks.DESK_CHAIR_CHORUS_NEST_WHITE.get(), "unusualend", "chorus_nest");
        processChairVariants(TBABlocks.DESK_CHAIR_CHORUS_NEST_ORANGE.get(), "unusualend", "chorus_nest");
        processChairVariants(TBABlocks.DESK_CHAIR_CHORUS_NEST_MAGENTA.get(), "unusualend", "chorus_nest");
        processChairVariants(TBABlocks.DESK_CHAIR_CHORUS_NEST_LIGHT_BLUE.get(), "unusualend", "chorus_nest");
        processChairVariants(TBABlocks.DESK_CHAIR_CHORUS_NEST_YELLOW.get(), "unusualend", "chorus_nest");
        processChairVariants(TBABlocks.DESK_CHAIR_CHORUS_NEST_LIME.get(), "unusualend", "chorus_nest");
        processChairVariants(TBABlocks.DESK_CHAIR_CHORUS_NEST_PINK.get(), "unusualend", "chorus_nest");
        processChairVariants(TBABlocks.DESK_CHAIR_CHORUS_NEST_GRAY.get(), "unusualend", "chorus_nest");
        processChairVariants(TBABlocks.DESK_CHAIR_CHORUS_NEST_LIGHT_GRAY.get(), "unusualend", "chorus_nest");
        processChairVariants(TBABlocks.DESK_CHAIR_CHORUS_NEST_CYAN.get(), "unusualend", "chorus_nest");
        processChairVariants(TBABlocks.DESK_CHAIR_CHORUS_NEST_PURPLE.get(), "unusualend", "chorus_nest");
        processChairVariants(TBABlocks.DESK_CHAIR_CHORUS_NEST_BLUE.get(), "unusualend", "chorus_nest");
        processChairVariants(TBABlocks.DESK_CHAIR_CHORUS_NEST_BROWN.get(), "unusualend", "chorus_nest");
        processChairVariants(TBABlocks.DESK_CHAIR_CHORUS_NEST_GREEN.get(), "unusualend", "chorus_nest");
        processChairVariants(TBABlocks.DESK_CHAIR_CHORUS_NEST_RED.get(), "unusualend", "chorus_nest");
        processChairVariants(TBABlocks.DESK_CHAIR_CHORUS_NEST_BLACK.get(), "unusualend", "chorus_nest");
        processTableVariants(TBABlocks.TABLE_CHORUS_NEST.get(), "unusualend", "chorus_nest");
        processLockerVariants(TBABlocks.LOCKER_CHORUS_NEST.get(), "unusualend", "chorus_nest");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_CHORUS_NEST.get(), "unusualend", "chorus_nest");
        processDeskVariants(TBABlocks.SCHOOL_DESK_CHORUS_NEST.get(), "unusualend", "chorus_nest");
        processBenchVariants(TBABlocks.PARK_BENCH_CHORUS_NEST.get(), "unusualend", "chorus_nest");
        processBookcaseVariants(TBABlocks.BOOKCASE_CHORUS_NEST.get(), "unusualend", "chorus_nest");

        processChairVariants(TBABlocks.DESK_CHAIR_BLOODSHROOM.get(), "tconstruct", "bloodshroom");
        processChairVariants(TBABlocks.DESK_CHAIR_BLOODSHROOM_WHITE.get(), "tconstruct", "bloodshroom");
        processChairVariants(TBABlocks.DESK_CHAIR_BLOODSHROOM_ORANGE.get(), "tconstruct", "bloodshroom");
        processChairVariants(TBABlocks.DESK_CHAIR_BLOODSHROOM_MAGENTA.get(), "tconstruct", "bloodshroom");
        processChairVariants(TBABlocks.DESK_CHAIR_BLOODSHROOM_LIGHT_BLUE.get(), "tconstruct", "bloodshroom");
        processChairVariants(TBABlocks.DESK_CHAIR_BLOODSHROOM_YELLOW.get(), "tconstruct", "bloodshroom");
        processChairVariants(TBABlocks.DESK_CHAIR_BLOODSHROOM_LIME.get(), "tconstruct", "bloodshroom");
        processChairVariants(TBABlocks.DESK_CHAIR_BLOODSHROOM_PINK.get(), "tconstruct", "bloodshroom");
        processChairVariants(TBABlocks.DESK_CHAIR_BLOODSHROOM_GRAY.get(), "tconstruct", "bloodshroom");
        processChairVariants(TBABlocks.DESK_CHAIR_BLOODSHROOM_LIGHT_GRAY.get(), "tconstruct", "bloodshroom");
        processChairVariants(TBABlocks.DESK_CHAIR_BLOODSHROOM_CYAN.get(), "tconstruct", "bloodshroom");
        processChairVariants(TBABlocks.DESK_CHAIR_BLOODSHROOM_PURPLE.get(), "tconstruct", "bloodshroom");
        processChairVariants(TBABlocks.DESK_CHAIR_BLOODSHROOM_BLUE.get(), "tconstruct", "bloodshroom");
        processChairVariants(TBABlocks.DESK_CHAIR_BLOODSHROOM_BROWN.get(), "tconstruct", "bloodshroom");
        processChairVariants(TBABlocks.DESK_CHAIR_BLOODSHROOM_GREEN.get(), "tconstruct", "bloodshroom");
        processChairVariants(TBABlocks.DESK_CHAIR_BLOODSHROOM_RED.get(), "tconstruct", "bloodshroom");
        processChairVariants(TBABlocks.DESK_CHAIR_BLOODSHROOM_BLACK.get(), "tconstruct", "bloodshroom");
        processTableVariants(TBABlocks.TABLE_BLOODSHROOM.get(), "tconstruct", "bloodshroom");
        processLockerVariants(TBABlocks.LOCKER_BLOODSHROOM.get(), "tconstruct", "bloodshroom");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_BLOODSHROOM.get(), "tconstruct", "bloodshroom");
        processDeskVariants(TBABlocks.SCHOOL_DESK_BLOODSHROOM.get(), "tconstruct", "bloodshroom");
        processBenchVariants(TBABlocks.PARK_BENCH_BLOODSHROOM.get(), "tconstruct", "bloodshroom");
        processBookcaseVariants(TBABlocks.BOOKCASE_BLOODSHROOM.get(), "tconstruct", "bloodshroom");

        processChairVariants(TBABlocks.DESK_CHAIR_ENDERBARK.get(), "tconstruct", "enderbark");
        processChairVariants(TBABlocks.DESK_CHAIR_ENDERBARK_WHITE.get(), "tconstruct", "enderbark");
        processChairVariants(TBABlocks.DESK_CHAIR_ENDERBARK_ORANGE.get(), "tconstruct", "enderbark");
        processChairVariants(TBABlocks.DESK_CHAIR_ENDERBARK_MAGENTA.get(), "tconstruct", "enderbark");
        processChairVariants(TBABlocks.DESK_CHAIR_ENDERBARK_LIGHT_BLUE.get(), "tconstruct", "enderbark");
        processChairVariants(TBABlocks.DESK_CHAIR_ENDERBARK_YELLOW.get(), "tconstruct", "enderbark");
        processChairVariants(TBABlocks.DESK_CHAIR_ENDERBARK_LIME.get(), "tconstruct", "enderbark");
        processChairVariants(TBABlocks.DESK_CHAIR_ENDERBARK_PINK.get(), "tconstruct", "enderbark");
        processChairVariants(TBABlocks.DESK_CHAIR_ENDERBARK_GRAY.get(), "tconstruct", "enderbark");
        processChairVariants(TBABlocks.DESK_CHAIR_ENDERBARK_LIGHT_GRAY.get(), "tconstruct", "enderbark");
        processChairVariants(TBABlocks.DESK_CHAIR_ENDERBARK_CYAN.get(), "tconstruct", "enderbark");
        processChairVariants(TBABlocks.DESK_CHAIR_ENDERBARK_PURPLE.get(), "tconstruct", "enderbark");
        processChairVariants(TBABlocks.DESK_CHAIR_ENDERBARK_BLUE.get(), "tconstruct", "enderbark");
        processChairVariants(TBABlocks.DESK_CHAIR_ENDERBARK_BROWN.get(), "tconstruct", "enderbark");
        processChairVariants(TBABlocks.DESK_CHAIR_ENDERBARK_GREEN.get(), "tconstruct", "enderbark");
        processChairVariants(TBABlocks.DESK_CHAIR_ENDERBARK_RED.get(), "tconstruct", "enderbark");
        processChairVariants(TBABlocks.DESK_CHAIR_ENDERBARK_BLACK.get(), "tconstruct", "enderbark");
        processTableVariants(TBABlocks.TABLE_ENDERBARK.get(), "tconstruct", "enderbark");
        processLockerVariants(TBABlocks.LOCKER_ENDERBARK.get(), "tconstruct", "enderbark");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_ENDERBARK.get(), "tconstruct", "enderbark");
        processDeskVariants(TBABlocks.SCHOOL_DESK_ENDERBARK.get(), "tconstruct", "enderbark");
        processBenchVariants(TBABlocks.PARK_BENCH_ENDERBARK.get(), "tconstruct", "enderbark");
        processBookcaseVariants(TBABlocks.BOOKCASE_ENDERBARK.get(), "tconstruct", "enderbark");

        processChairVariants(TBABlocks.DESK_CHAIR_GREENHEART.get(), "tconstruct", "greenheart");
        processChairVariants(TBABlocks.DESK_CHAIR_GREENHEART_WHITE.get(), "tconstruct", "greenheart");
        processChairVariants(TBABlocks.DESK_CHAIR_GREENHEART_ORANGE.get(), "tconstruct", "greenheart");
        processChairVariants(TBABlocks.DESK_CHAIR_GREENHEART_MAGENTA.get(), "tconstruct", "greenheart");
        processChairVariants(TBABlocks.DESK_CHAIR_GREENHEART_LIGHT_BLUE.get(), "tconstruct", "greenheart");
        processChairVariants(TBABlocks.DESK_CHAIR_GREENHEART_YELLOW.get(), "tconstruct", "greenheart");
        processChairVariants(TBABlocks.DESK_CHAIR_GREENHEART_LIME.get(), "tconstruct", "greenheart");
        processChairVariants(TBABlocks.DESK_CHAIR_GREENHEART_PINK.get(), "tconstruct", "greenheart");
        processChairVariants(TBABlocks.DESK_CHAIR_GREENHEART_GRAY.get(), "tconstruct", "greenheart");
        processChairVariants(TBABlocks.DESK_CHAIR_GREENHEART_LIGHT_GRAY.get(), "tconstruct", "greenheart");
        processChairVariants(TBABlocks.DESK_CHAIR_GREENHEART_CYAN.get(), "tconstruct", "greenheart");
        processChairVariants(TBABlocks.DESK_CHAIR_GREENHEART_PURPLE.get(), "tconstruct", "greenheart");
        processChairVariants(TBABlocks.DESK_CHAIR_GREENHEART_BLUE.get(), "tconstruct", "greenheart");
        processChairVariants(TBABlocks.DESK_CHAIR_GREENHEART_BROWN.get(), "tconstruct", "greenheart");
        processChairVariants(TBABlocks.DESK_CHAIR_GREENHEART_GREEN.get(), "tconstruct", "greenheart");
        processChairVariants(TBABlocks.DESK_CHAIR_GREENHEART_RED.get(), "tconstruct", "greenheart");
        processChairVariants(TBABlocks.DESK_CHAIR_GREENHEART_BLACK.get(), "tconstruct", "greenheart");
        processTableVariants(TBABlocks.TABLE_GREENHEART.get(), "tconstruct", "greenheart");
        processLockerVariants(TBABlocks.LOCKER_GREENHEART.get(), "tconstruct", "greenheart");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_GREENHEART.get(), "tconstruct", "greenheart");
        processDeskVariants(TBABlocks.SCHOOL_DESK_GREENHEART.get(), "tconstruct", "greenheart");
        processBenchVariants(TBABlocks.PARK_BENCH_GREENHEART.get(), "tconstruct", "greenheart");
        processBookcaseVariants(TBABlocks.BOOKCASE_GREENHEART.get(), "tconstruct", "greenheart");

        processChairVariants(TBABlocks.DESK_CHAIR_TINKER_SKYROOT.get(), "tconstruct", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_WHITE.get(), "tconstruct", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_ORANGE.get(), "tconstruct", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_MAGENTA.get(), "tconstruct", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_LIGHT_BLUE.get(), "tconstruct", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_YELLOW.get(), "tconstruct", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_LIME.get(), "tconstruct", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_PINK.get(), "tconstruct", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_GRAY.get(), "tconstruct", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_LIGHT_GRAY.get(), "tconstruct", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_CYAN.get(), "tconstruct", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_PURPLE.get(), "tconstruct", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_BLUE.get(), "tconstruct", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_BROWN.get(), "tconstruct", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_GREEN.get(), "tconstruct", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_RED.get(), "tconstruct", "skyroot");
        processChairVariants(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_BLACK.get(), "tconstruct", "skyroot");
        processTableVariants(TBABlocks.TABLE_TINKER_SKYROOT.get(), "tconstruct", "skyroot");
        processLockerVariants(TBABlocks.LOCKER_TINKER_SKYROOT.get(), "tconstruct", "skyroot");
        processCabinetVariants(TBABlocks.SCHOOL_DESK_CABINET_TINKER_SKYROOT.get(), "tconstruct", "skyroot");
        processDeskVariants(TBABlocks.SCHOOL_DESK_TINKER_SKYROOT.get(), "tconstruct", "skyroot");
        processBenchVariants(TBABlocks.PARK_BENCH_TINKER_SKYROOT.get(), "tconstruct", "skyroot");
        processBookcaseVariants(TBABlocks.BOOKCASE_TINKER_SKYROOT.get(), "tconstruct", "skyroot");

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

        PICNIC_BLANKET_LIST.forEach(picnicBlanket ->
                processPicnicBlanketVariants(picnicBlanket.defaultBlockState().getBlock())
        );
    }

    @SuppressWarnings("SameParameterValue")
    protected void processPicnicBlanketVariants(Block result) {
        picnicBlanketTemplate(result, MODID + ":" + "block/template_picnic_blanket");
    }

    @SuppressWarnings("SameParameterValue")
    protected void picnicBlanketTemplate(Block result, String parent) {
        ModelFile parentModel = new ModelFile.UncheckedModelFile(modLoc("block/template_picnic_blanket"));
        ResourceLocation existingTexture = new ResourceLocation(MODID, "block/checkered_cloth");

        this.helper.trackGenerated(existingTexture, TEXTURE);

        final var model = models()
                .getBuilder(blockName(result)).parent(parentModel)
                .texture("0", existingTexture)
                .texture("particle", existingTexture);

        simpleBlock(result, model);
        simpleBlockItem(result, model);
    }

    @SuppressWarnings("SameParameterValue")
    protected void processPlateVariants(Block result, String modid, String path) {
        processPlateVariants(result, MODID + ":" + "block/plate_block", modid, path);
    }

    protected String getPlanksTexture(String modid, String woodType) {
        String planksTexture;

        if (Objects.equals(woodType, "golden_oak")) {
            planksTexture = "block/construction/skyroot_planks";
        }
        else if (Objects.equals(modid, "aether") && Objects.equals(woodType, "skyroot")) {
            planksTexture = "block/construction/skyroot_planks";
        }
        else if (Objects.equals(woodType, "pream")) {
            planksTexture = "blocks/" + woodType + "_planks";
        }
        else if (Objects.equals(woodType, "ebony")) {
            planksTexture = "blocks/" + woodType + "_planks";
        }
        else if (Objects.equals(woodType, "chorus_nest")) {
            planksTexture = "blocks/" + woodType + "_planks";
        }
        else if (Objects.equals(modid, "tconstruct")) {
            planksTexture = "block/wood/" + woodType + "/planks";
        }
        else {
            planksTexture = "block/" + woodType + "_planks";
        }

        return planksTexture;
    }

    protected String getStrippedLogTexture(String modid, String woodType) {
        String strippedLogTexture;

        if (Objects.equals(woodType, "crimson") || Objects.equals(woodType, "warped")) {
            strippedLogTexture = "block/stripped_" + woodType + "_stem";
        }
        else if (Objects.equals(woodType, "flowering_azalea")) {
            strippedLogTexture = "block/stripped_azalea_log";
        }
        else {
            strippedLogTexture = "block/stripped_" + woodType + "_log";
        }

        if (Objects.equals(woodType, "golden_oak")) {
            strippedLogTexture = "block/natural/stripped_skyroot_log";
        }
        else if (Objects.equals(modid, "aether") && Objects.equals(woodType, "skyroot")) {
            strippedLogTexture = "block/natural/stripped_skyroot_log";
        }
        else if (Objects.equals(woodType, "pream")) {
            strippedLogTexture = "blocks/stripped_" + woodType + "_log_side";
        }
        else if (Objects.equals(woodType, "ebony")) {
            strippedLogTexture = "blocks/" + woodType + "_stems_side_stripped";
        }
        else if (Objects.equals(woodType, "chorus_nest")) {
            strippedLogTexture = "blocks/stripped_" + woodType + "_planks";
        }
        else if (Objects.equals(modid, "tconstruct")) {
            strippedLogTexture = "block/wood/" + woodType + "/stripped_log";
        }

        return strippedLogTexture;
    }

    protected String getLogTexture(String modid, String woodType) {
        String logTexture;

        if (Objects.equals(woodType, "crimson") || Objects.equals(woodType, "warped")) {
            logTexture = "block/" + woodType + "_stem";
        }
        else if (Objects.equals(woodType, "flowering_azalea")) {
            logTexture = "block/" + woodType + "_log";
        }
        else {
            logTexture = "block/" + woodType + "_log";
        }

        if (Objects.equals(woodType, "golden_oak")) {
            logTexture = "block/natural/" + woodType + "_log";
        }
        else if (Objects.equals(modid, "aether") && Objects.equals(woodType, "skyroot")) {
            logTexture = "block/natural/" + woodType + "_log";
        }
        else if (Objects.equals(woodType, "pream")) {
            logTexture = "blocks/" + woodType + "_log_side";
        }
        else if (Objects.equals(woodType, "ebony")) {
            logTexture = "blocks/" + woodType + "_stems_side";
        }
        else if (Objects.equals(woodType, "chorus_nest")) {
            logTexture = "blocks/" + woodType + "_mosaic";
        }
        else if (Objects.equals(modid, "tconstruct")) {
            logTexture = "block/wood/" + woodType + "/log";
        }

        return logTexture;
    }

    protected void processBasketVariants(Block result, String modid, String woodType, @NotNull String color) {
        String clothTexture = "block/" + color + "_wool";

        ModelFile parentModel = new ModelFile.UncheckedModelFile("turtleblockacademy:block/basket");

        ResourceLocation existingTexture1 = new ResourceLocation(modid, getPlanksTexture(modid, woodType));
        ResourceLocation existingTexture2 = new ResourceLocation("minecraft", clothTexture);

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

    protected void processDeskVariants(Block result, String modid, String woodType) {
        twoTextureHorizontalVariant(result, MODID + ":" + "block/school_desk", modid,
                getPlanksTexture(modid, woodType),
                getStrippedLogTexture(modid, woodType));
    }

    protected void processBenchVariants(Block result, String modid, String woodType) {
        twoTextureHorizontalVariant(result, MODID + ":" + "block/park_bench", modid,
                getPlanksTexture(modid, woodType),
                getStrippedLogTexture(modid, woodType));
    }

    protected void processBookcaseVariants(Block result, String modid, String woodType) {
        ModelFile parentModel = new ModelFile.UncheckedModelFile(MODID + ":" + "block/bookcase");

        ResourceLocation existingTexture1 = new ResourceLocation(modid, getPlanksTexture(modid, woodType));
        ResourceLocation existingTexture2 = new ResourceLocation(modid, getLogTexture(modid, woodType));
        ResourceLocation existingTexture3 = new ResourceLocation(modid, getStrippedLogTexture(modid, woodType));

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

    protected void processCabinetVariants(Block result, String modid, String woodType) {
        threeTextureHorizontalVariant(result, MODID + ":" + "block/school_desk_cabinet", modid,
                getPlanksTexture(modid, woodType),
                getStrippedLogTexture(modid, woodType),
                getLogTexture(modid, woodType));
    }

    protected void processLockerVariants(Block result, String modid, String woodType) {
        threeTextureHorizontalVariant(result, MODID + ":" + "block/locker", modid,
                getPlanksTexture(modid, woodType),
                getStrippedLogTexture(modid, woodType),
                getLogTexture(modid, woodType));
    }

    protected void processTableVariants(Block result, String modid, String woodType) {
        ModelFile tableModel = new ModelFile.UncheckedModelFile(MODID + ":" + "block/table");
        ModelFile tableCenterModel = new ModelFile.UncheckedModelFile(MODID + ":" + "block/table_center");

        ResourceLocation existingTexture1 = new ResourceLocation(modid, getPlanksTexture(modid, woodType));
        ResourceLocation existingTexture2 = new ResourceLocation(modid, getStrippedLogTexture(modid, woodType));
        ResourceLocation existingTexture3 = new ResourceLocation(modid, getLogTexture(modid, woodType));

        this.helper.trackGenerated(existingTexture1, TEXTURE);
        this.helper.trackGenerated(existingTexture2, TEXTURE);
        this.helper.trackGenerated(existingTexture3, TEXTURE);

        final var table = models()
                .getBuilder(blockName(result)).parent(tableModel)
                .texture("1", existingTexture1)
                .texture("2", existingTexture2)
                .texture("3", existingTexture3)
                .texture("particle", existingTexture1);

        final var tableCenter = models()
                .getBuilder(blockName(result) + "_center").parent(tableCenterModel)
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

    @SuppressWarnings("SameParameterValue")
    protected void processPlateVariants(Block result, String parent, String modid, String path) {
        ModelFile parentModel = new ModelFile.UncheckedModelFile(parent);
        ResourceLocation existingTexture = new ResourceLocation(modid, path);

        this.helper.trackGenerated(existingTexture, TEXTURE);

        final var model = models()
                .getBuilder(blockName(result)).parent(parentModel)
                .texture("1", existingTexture)
                .texture("particle", existingTexture);

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

    protected void processChairVariants(Block result, String modid, String woodType) {
        ModelFile parentModel = new ModelFile.UncheckedModelFile(MODID + ":" + "block/desk_chair");

        ResourceLocation existingTexture1 = new ResourceLocation(modid, getPlanksTexture(modid, woodType));
        ResourceLocation existingTexture2 = getChairPaddingTexture(result, modid, getStrippedLogTexture(modid, woodType));
        ResourceLocation existingTexture3 = new ResourceLocation(modid, getLogTexture(modid, woodType));

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

    private ResourceLocation getChairPaddingTexture(Block result, String modid, String strippedLogTexture) {
        ResourceLocation chairPaddingTexture = new ResourceLocation("minecraft", "block/white_wool");
        if (result instanceof DeskChairBlock chairBlock) {
            if (chairBlock.getClothColor() == null) {
                chairPaddingTexture = new ResourceLocation(modid, strippedLogTexture);
            }
        }
        else {
            chairPaddingTexture = new ResourceLocation("minecraft", "block/white_wool");
        }
        return chairPaddingTexture;
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
}