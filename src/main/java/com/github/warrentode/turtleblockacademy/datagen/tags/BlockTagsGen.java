package com.github.warrentode.turtleblockacademy.datagen.tags;

import biomesoplenty.api.block.BOPBlocks;
import com.github.warrentode.turtleblockacademy.util.PackTags;
import net.mcreator.festivedelight.init.FestiveDelightModBlocks;
import net.mcreator.moadecorcookery.init.MoaDecorCookeryModItems;
import net.mcreator.phantasm.init.PhantasmModBlocks;
import net.mcreator.phantasm.init.PhantasmModItems;
import net.mcreator.unusualend.init.UnusualendModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

import static net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL;

public class BlockTagsGen extends BlockTagsProvider {
    public BlockTagsGen(DataGenerator generator, String modid, @Nullable ExistingFileHelper helper) {
        super(generator, modid, helper);
    }

    @Override
    protected void addTags() {
        this.registerPackTags();
        this.registerMinecraftTags();
        this.registerBlockMineables();
    }

    private void registerMinecraftTags() {
        tag(PackTags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(Blocks.REINFORCED_DEEPSLATE);
        tag(NEEDS_STONE_TOOL)
                .add(Blocks.BUDDING_AMETHYST);
    }

    private void registerBlockMineables() {
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Blocks.BUDDING_AMETHYST)
                .add(Blocks.REINFORCED_DEEPSLATE);
    }

    protected void registerPackTags() {
        tag(PackTags.Blocks.DROPS_FOUR_LEAF_CLOVER)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("biomesoplenty:clover")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("biomesoplenty:huge_clover_petal")))
                .addOptional(PhantasmModBlocks.ENDER_CLOVER.getId())
                .add(Blocks.GRASS)
                .add(Blocks.TALL_GRASS);
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Blocks.REINFORCED_DEEPSLATE);
        tag(PackTags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(Blocks.REINFORCED_DEEPSLATE);
        tag(PackTags.Blocks.FD_HEAT_CONDUCTORS)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("create:chute")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("goldenhopper:golden_hopper")));
        tag(PackTags.Blocks.FD_HEAT_SOURCES)
                .add(Blocks.MAGMA_BLOCK)
                .add(Blocks.LAVA_CAULDRON)
                .addTag(PackTags.Blocks.FD_TRAY_HEAT_SOURCES)
                .addOptional(MoaDecorCookeryModItems.ESTUFA.getId())
                .addOptional(MoaDecorCookeryModItems.ESTUFAABIERTA.getId())
                .addOptional(MoaDecorCookeryModItems.ESTUFAPAY.getId())
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("nfm:oven_light")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("nfm:oven_dark")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("handcrafted:oven")));
        tag(PackTags.Blocks.FD_TRAY_HEAT_SOURCES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("exlinefurniture:oven")));
        tag(PackTags.Blocks.FR_HEAT_CONDUCTORS).addTag(PackTags.Blocks.FD_HEAT_CONDUCTORS);
        tag(PackTags.Blocks.FR_HEAT_SOURCES).addTag(PackTags.Blocks.FD_HEAT_SOURCES);
        tag(PackTags.Blocks.FR_TRAY_HEAT_SOURCES).addTag(PackTags.Blocks.FD_TRAY_HEAT_SOURCES);
        tag(PackTags.Blocks.CARPETS)
                .add(Blocks.WHITE_CARPET)
                .add(Blocks.LIGHT_GRAY_CARPET)
                .add(Blocks.GRAY_CARPET)
                .add(Blocks.BLACK_CARPET)
                .add(Blocks.BROWN_CARPET)
                .add(Blocks.RED_CARPET)
                .add(Blocks.ORANGE_CARPET)
                .add(Blocks.YELLOW_CARPET)
                .add(Blocks.GREEN_CARPET)
                .add(Blocks.LIME_CARPET)
                .add(Blocks.CYAN_CARPET)
                .add(Blocks.BLUE_CARPET)
                .add(Blocks.LIGHT_BLUE_CARPET)
                .add(Blocks.PINK_CARPET)
                .add(Blocks.MAGENTA_CARPET)
                .add(Blocks.PURPLE_CARPET);
        tag(PackTags.Blocks.SAND)
                .addOptional(BOPBlocks.WHITE_SAND.getId())
                .addOptional(BOPBlocks.ROOTED_SAND.getId())
                .addOptional(BOPBlocks.ORANGE_SAND.getId())
                .addOptional(BOPBlocks.BLACK_SAND.getId())
                .add(Blocks.SAND)
                .add(Blocks.RED_SAND);
        tag(PackTags.Blocks.GLASS)
                .addOptional(UnusualendModItems.CHISELED_GLASS.getId())
                .addOptional(PhantasmModItems.CRYSTAL_FRAMED_GLASS.getId())
                .addOptional(PhantasmModItems.VOID_CRYSTAL_FRAMED_GLASS.getId());
        tag(PackTags.Blocks.GINGERBREADS)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("snowyspirit:gingerbread_frosted")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("snowyspirit:gingerbread")))
                .addOptional(FestiveDelightModBlocks.GINGERBREAD_BLOCK.getId())
                .addOptional(FestiveDelightModBlocks.GINGERBREAD_BLOCK_CREEPER.getId())
                .addOptional(FestiveDelightModBlocks.GINGERBREAD_BLOCK_DIAMOND.getId())
                .addOptional(FestiveDelightModBlocks.GINGERBREAD_BLOCK_DECORATIONS.getId())
                .addOptional(FestiveDelightModBlocks.GINGERBREAD_BLOCK_SNOW.getId())
                .addOptional(FestiveDelightModBlocks.GINGERBREAD_PILLAR.getId())
                .addOptional(FestiveDelightModBlocks.POLISHED_GINGERBREAD_BLOCK.getId());
    }
}
