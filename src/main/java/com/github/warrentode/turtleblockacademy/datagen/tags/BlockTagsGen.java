package com.github.warrentode.turtleblockacademy.datagen.tags;

import biomesoplenty.api.block.BOPBlocks;
import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.util.TBATags;
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
        this.registerTBATags();
        this.registerMinecraftTags();
        this.registerBlockMineables();
    }

    private void registerMinecraftTags() {
        tag(TBATags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(Blocks.REINFORCED_DEEPSLATE);
        tag(NEEDS_STONE_TOOL)
                .add(Blocks.BUDDING_AMETHYST);
    }

    private void registerBlockMineables() {
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Blocks.BUDDING_AMETHYST)
                .add(Blocks.REINFORCED_DEEPSLATE);
    }

    protected void registerTBATags() {
        tag(TBATags.Blocks.TBA_MINING_PORTAL_FRAME_BLOCKS)
                .add(Blocks.ANDESITE);
        tag(TBATags.Blocks.PLATES)
                .add(TBABlocks.PLATE_PURPLE.get())
                .add(TBABlocks.PLATE_PINK.get())
                .add(TBABlocks.PLATE_ORANGE.get())
                .add(TBABlocks.PLATE_MAGENTA.get())
                .add(TBABlocks.PLATE_LIME.get())
                .add(TBABlocks.PLATE_LIGHT_GRAY.get())
                .add(TBABlocks.PLATE_LIGHT_BLUE.get())
                .add(TBABlocks.PLATE_GREEN.get())
                .add(TBABlocks.PLATE_GRAY.get())
                .add(TBABlocks.PLATE_CYAN.get())
                .add(TBABlocks.PLATE_BROWN.get())
                .add(TBABlocks.PLATE_BLUE.get())
                .add(TBABlocks.PLATE_BLACK.get());
        tag(TBATags.Blocks.DESK_CABINETS)
                .add(TBABlocks.SCHOOL_DESK_CABINET_FIR.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_REDWOOD.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_CHERRY.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_MAHOGANY.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_JACARANDA.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_PALM.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_WILLOW.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_DEAD.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_MAGIC.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_UMBRAN.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_HELLBARK.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_COCONUT.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_WALNUT.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_AZALEA.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_FLOWERING_AZALEA.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_GOLDEN_OAK.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_AETHER_SKYROOT.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_PREAM.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_EBONY.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_CHORUS_NEST.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_BLOODSHROOM.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_ENDERBARK.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_GREENHEART.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_TINKER_SKYROOT.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_WARPED.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_CRIMSON.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_MANGROVE.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_OAK.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_BIRCH.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_SPRUCE.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_DARK_OAK.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_JUNGLE.get())
                .add(TBABlocks.SCHOOL_DESK_CABINET_ACACIA.get());
        tag(TBATags.Blocks.CHAIRS)
                .add(TBABlocks.DESK_CHAIR_FIR.get())
                .add(TBABlocks.DESK_CHAIR_REDWOOD.get())
                .add(TBABlocks.DESK_CHAIR_CHERRY.get())
                .add(TBABlocks.DESK_CHAIR_MAHOGANY.get())
                .add(TBABlocks.DESK_CHAIR_JACARANDA.get())
                .add(TBABlocks.DESK_CHAIR_PALM.get())
                .add(TBABlocks.DESK_CHAIR_WILLOW.get())
                .add(TBABlocks.DESK_CHAIR_DEAD.get())
                .add(TBABlocks.DESK_CHAIR_MAGIC.get())
                .add(TBABlocks.DESK_CHAIR_UMBRAN.get())
                .add(TBABlocks.DESK_CHAIR_HELLBARK.get())
                .add(TBABlocks.DESK_CHAIR_COCONUT.get())
                .add(TBABlocks.DESK_CHAIR_WALNUT.get())
                .add(TBABlocks.DESK_CHAIR_AZALEA.get())
                .add(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA.get())
                .add(TBABlocks.DESK_CHAIR_GOLDEN_OAK.get())
                .add(TBABlocks.DESK_CHAIR_AETHER_SKYROOT.get())
                .add(TBABlocks.DESK_CHAIR_PREAM.get())
                .add(TBABlocks.DESK_CHAIR_EBONY.get())
                .add(TBABlocks.DESK_CHAIR_CHORUS_NEST.get())
                .add(TBABlocks.DESK_CHAIR_BLOODSHROOM.get())
                .add(TBABlocks.DESK_CHAIR_ENDERBARK.get())
                .add(TBABlocks.DESK_CHAIR_GREENHEART.get())
                .add(TBABlocks.DESK_CHAIR_TINKER_SKYROOT.get())
                .add(TBABlocks.DESK_CHAIR_WARPED.get())
                .add(TBABlocks.DESK_CHAIR_CRIMSON.get())
                .add(TBABlocks.DESK_CHAIR_MANGROVE.get())
                .add(TBABlocks.DESK_CHAIR_OAK.get())
                .add(TBABlocks.DESK_CHAIR_BIRCH.get())
                .add(TBABlocks.DESK_CHAIR_SPRUCE.get())
                .add(TBABlocks.DESK_CHAIR_DARK_OAK.get())
                .add(TBABlocks.DESK_CHAIR_JUNGLE.get())
                .add(TBABlocks.DESK_CHAIR_ACACIA.get());
        tag(TBATags.Blocks.BOOKCASES)
                .add(TBABlocks.BOOKCASE_FIR.get())
                .add(TBABlocks.BOOKCASE_REDWOOD.get())
                .add(TBABlocks.BOOKCASE_CHERRY.get())
                .add(TBABlocks.BOOKCASE_MAHOGANY.get())
                .add(TBABlocks.BOOKCASE_JACARANDA.get())
                .add(TBABlocks.BOOKCASE_PALM.get())
                .add(TBABlocks.BOOKCASE_WILLOW.get())
                .add(TBABlocks.BOOKCASE_DEAD.get())
                .add(TBABlocks.BOOKCASE_MAGIC.get())
                .add(TBABlocks.BOOKCASE_UMBRAN.get())
                .add(TBABlocks.BOOKCASE_HELLBARK.get())
                .add(TBABlocks.BOOKCASE_COCONUT.get())
                .add(TBABlocks.BOOKCASE_WALNUT.get())
                .add(TBABlocks.BOOKCASE_AZALEA.get())
                .add(TBABlocks.BOOKCASE_FLOWERING_AZALEA.get())
                .add(TBABlocks.BOOKCASE_GOLDEN_OAK.get())
                .add(TBABlocks.BOOKCASE_AETHER_SKYROOT.get())
                .add(TBABlocks.BOOKCASE_PREAM.get())
                .add(TBABlocks.BOOKCASE_EBONY.get())
                .add(TBABlocks.BOOKCASE_CHORUS_NEST.get())
                .add(TBABlocks.BOOKCASE_BLOODSHROOM.get())
                .add(TBABlocks.BOOKCASE_ENDERBARK.get())
                .add(TBABlocks.BOOKCASE_GREENHEART.get())
                .add(TBABlocks.BOOKCASE_TINKER_SKYROOT.get())
                .add(TBABlocks.BOOKCASE_WARPED.get())
                .add(TBABlocks.BOOKCASE_CRIMSON.get())
                .add(TBABlocks.BOOKCASE_MANGROVE.get())
                .add(TBABlocks.BOOKCASE_OAK.get())
                .add(TBABlocks.BOOKCASE_BIRCH.get())
                .add(TBABlocks.BOOKCASE_SPRUCE.get())
                .add(TBABlocks.BOOKCASE_DARK_OAK.get())
                .add(TBABlocks.BOOKCASE_JUNGLE.get())
                .add(TBABlocks.BOOKCASE_ACACIA.get());
        tag(TBATags.Blocks.LOCKERS)
                .add(TBABlocks.LOCKER_FIR.get())
                .add(TBABlocks.LOCKER_REDWOOD.get())
                .add(TBABlocks.LOCKER_CHERRY.get())
                .add(TBABlocks.LOCKER_MAHOGANY.get())
                .add(TBABlocks.LOCKER_JACARANDA.get())
                .add(TBABlocks.LOCKER_PALM.get())
                .add(TBABlocks.LOCKER_WILLOW.get())
                .add(TBABlocks.LOCKER_DEAD.get())
                .add(TBABlocks.LOCKER_MAGIC.get())
                .add(TBABlocks.LOCKER_UMBRAN.get())
                .add(TBABlocks.LOCKER_HELLBARK.get())
                .add(TBABlocks.LOCKER_COCONUT.get())
                .add(TBABlocks.LOCKER_WALNUT.get())
                .add(TBABlocks.LOCKER_AZALEA.get())
                .add(TBABlocks.LOCKER_FLOWERING_AZALEA.get())
                .add(TBABlocks.LOCKER_GOLDEN_OAK.get())
                .add(TBABlocks.LOCKER_AETHER_SKYROOT.get())
                .add(TBABlocks.LOCKER_PREAM.get())
                .add(TBABlocks.LOCKER_EBONY.get())
                .add(TBABlocks.LOCKER_CHORUS_NEST.get())
                .add(TBABlocks.LOCKER_BLOODSHROOM.get())
                .add(TBABlocks.LOCKER_ENDERBARK.get())
                .add(TBABlocks.LOCKER_GREENHEART.get())
                .add(TBABlocks.LOCKER_TINKER_SKYROOT.get())
                .add(TBABlocks.LOCKER_WARPED.get())
                .add(TBABlocks.LOCKER_CRIMSON.get())
                .add(TBABlocks.LOCKER_MANGROVE.get())
                .add(TBABlocks.LOCKER_OAK.get())
                .add(TBABlocks.LOCKER_BIRCH.get())
                .add(TBABlocks.LOCKER_SPRUCE.get())
                .add(TBABlocks.LOCKER_DARK_OAK.get())
                .add(TBABlocks.LOCKER_JUNGLE.get())
                .add(TBABlocks.LOCKER_ACACIA.get());
        tag(TBATags.Blocks.BENCHES)
                .add(TBABlocks.PARK_BENCH_FIR.get())
                .add(TBABlocks.PARK_BENCH_REDWOOD.get())
                .add(TBABlocks.PARK_BENCH_CHERRY.get())
                .add(TBABlocks.PARK_BENCH_MAHOGANY.get())
                .add(TBABlocks.PARK_BENCH_JACARANDA.get())
                .add(TBABlocks.PARK_BENCH_PALM.get())
                .add(TBABlocks.PARK_BENCH_WILLOW.get())
                .add(TBABlocks.PARK_BENCH_DEAD.get())
                .add(TBABlocks.PARK_BENCH_MAGIC.get())
                .add(TBABlocks.PARK_BENCH_UMBRAN.get())
                .add(TBABlocks.PARK_BENCH_HELLBARK.get())
                .add(TBABlocks.PARK_BENCH_COCONUT.get())
                .add(TBABlocks.PARK_BENCH_WALNUT.get())
                .add(TBABlocks.PARK_BENCH_AZALEA.get())
                .add(TBABlocks.PARK_BENCH_FLOWERING_AZALEA.get())
                .add(TBABlocks.PARK_BENCH_GOLDEN_OAK.get())
                .add(TBABlocks.PARK_BENCH_AETHER_SKYROOT.get())
                .add(TBABlocks.PARK_BENCH_PREAM.get())
                .add(TBABlocks.PARK_BENCH_EBONY.get())
                .add(TBABlocks.PARK_BENCH_CHORUS_NEST.get())
                .add(TBABlocks.PARK_BENCH_BLOODSHROOM.get())
                .add(TBABlocks.PARK_BENCH_ENDERBARK.get())
                .add(TBABlocks.PARK_BENCH_GREENHEART.get())
                .add(TBABlocks.PARK_BENCH_TINKER_SKYROOT.get())
                .add(TBABlocks.PARK_BENCH_WARPED.get())
                .add(TBABlocks.PARK_BENCH_CRIMSON.get())
                .add(TBABlocks.PARK_BENCH_MANGROVE.get())
                .add(TBABlocks.PARK_BENCH_OAK.get())
                .add(TBABlocks.PARK_BENCH_BIRCH.get())
                .add(TBABlocks.PARK_BENCH_SPRUCE.get())
                .add(TBABlocks.PARK_BENCH_DARK_OAK.get())
                .add(TBABlocks.PARK_BENCH_JUNGLE.get())
                .add(TBABlocks.PARK_BENCH_ACACIA.get());
        tag(TBATags.Blocks.TABLES)
                .add(TBABlocks.TABLE_FIR.get())
                .add(TBABlocks.TABLE_REDWOOD.get())
                .add(TBABlocks.TABLE_CHERRY.get())
                .add(TBABlocks.TABLE_MAHOGANY.get())
                .add(TBABlocks.TABLE_JACARANDA.get())
                .add(TBABlocks.TABLE_PALM.get())
                .add(TBABlocks.TABLE_WILLOW.get())
                .add(TBABlocks.TABLE_DEAD.get())
                .add(TBABlocks.TABLE_MAGIC.get())
                .add(TBABlocks.TABLE_UMBRAN.get())
                .add(TBABlocks.TABLE_HELLBARK.get())
                .add(TBABlocks.TABLE_COCONUT.get())
                .add(TBABlocks.TABLE_WALNUT.get())
                .add(TBABlocks.TABLE_AZALEA.get())
                .add(TBABlocks.TABLE_FLOWERING_AZALEA.get())
                .add(TBABlocks.TABLE_GOLDEN_OAK.get())
                .add(TBABlocks.TABLE_AETHER_SKYROOT.get())
                .add(TBABlocks.TABLE_PREAM.get())
                .add(TBABlocks.TABLE_EBONY.get())
                .add(TBABlocks.TABLE_CHORUS_NEST.get())
                .add(TBABlocks.TABLE_BLOODSHROOM.get())
                .add(TBABlocks.TABLE_ENDERBARK.get())
                .add(TBABlocks.TABLE_GREENHEART.get())
                .add(TBABlocks.TABLE_TINKER_SKYROOT.get())
                .add(TBABlocks.TABLE_WARPED.get())
                .add(TBABlocks.TABLE_CRIMSON.get())
                .add(TBABlocks.TABLE_MANGROVE.get())
                .add(TBABlocks.TABLE_OAK.get())
                .add(TBABlocks.TABLE_BIRCH.get())
                .add(TBABlocks.TABLE_SPRUCE.get())
                .add(TBABlocks.TABLE_DARK_OAK.get())
                .add(TBABlocks.TABLE_JUNGLE.get())
                .add(TBABlocks.TABLE_ACACIA.get());
        tag(TBATags.Blocks.DESKS)
                .add(TBABlocks.SCHOOL_DESK_FIR.get())
                .add(TBABlocks.SCHOOL_DESK_REDWOOD.get())
                .add(TBABlocks.SCHOOL_DESK_CHERRY.get())
                .add(TBABlocks.SCHOOL_DESK_MAHOGANY.get())
                .add(TBABlocks.SCHOOL_DESK_JACARANDA.get())
                .add(TBABlocks.SCHOOL_DESK_PALM.get())
                .add(TBABlocks.SCHOOL_DESK_WILLOW.get())
                .add(TBABlocks.SCHOOL_DESK_DEAD.get())
                .add(TBABlocks.SCHOOL_DESK_MAGIC.get())
                .add(TBABlocks.SCHOOL_DESK_UMBRAN.get())
                .add(TBABlocks.SCHOOL_DESK_HELLBARK.get())
                .add(TBABlocks.SCHOOL_DESK_COCONUT.get())
                .add(TBABlocks.SCHOOL_DESK_WALNUT.get())
                .add(TBABlocks.SCHOOL_DESK_AZALEA.get())
                .add(TBABlocks.SCHOOL_DESK_FLOWERING_AZALEA.get())
                .add(TBABlocks.SCHOOL_DESK_GOLDEN_OAK.get())
                .add(TBABlocks.SCHOOL_DESK_AETHER_SKYROOT.get())
                .add(TBABlocks.SCHOOL_DESK_PREAM.get())
                .add(TBABlocks.SCHOOL_DESK_EBONY.get())
                .add(TBABlocks.SCHOOL_DESK_CHORUS_NEST.get())
                .add(TBABlocks.SCHOOL_DESK_BLOODSHROOM.get())
                .add(TBABlocks.SCHOOL_DESK_ENDERBARK.get())
                .add(TBABlocks.SCHOOL_DESK_GREENHEART.get())
                .add(TBABlocks.SCHOOL_DESK_TINKER_SKYROOT.get())
                .add(TBABlocks.SCHOOL_DESK_WARPED.get())
                .add(TBABlocks.SCHOOL_DESK_CRIMSON.get())
                .add(TBABlocks.SCHOOL_DESK_MANGROVE.get())
                .add(TBABlocks.SCHOOL_DESK_OAK.get())
                .add(TBABlocks.SCHOOL_DESK_BIRCH.get())
                .add(TBABlocks.SCHOOL_DESK_SPRUCE.get())
                .add(TBABlocks.SCHOOL_DESK_DARK_OAK.get())
                .add(TBABlocks.SCHOOL_DESK_JUNGLE.get())
                .add(TBABlocks.SCHOOL_DESK_ACACIA.get());
        tag(TBATags.Blocks.DROPS_FOUR_LEAF_CLOVER)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("biomesoplenty:clover")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("biomesoplenty:huge_clover_petal")))
                .addOptional(PhantasmModBlocks.ENDER_CLOVER.getId())
                .add(Blocks.GRASS)
                .add(Blocks.TALL_GRASS);
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Blocks.REINFORCED_DEEPSLATE);
        tag(TBATags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(Blocks.REINFORCED_DEEPSLATE);
        tag(TBATags.Blocks.FD_HEAT_CONDUCTORS)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("create:chute")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("goldenhopper:golden_hopper")));
        tag(TBATags.Blocks.FD_HEAT_SOURCES)
                .add(Blocks.MAGMA_BLOCK)
                .add(Blocks.LAVA_CAULDRON)
                .addTag(TBATags.Blocks.FD_TRAY_HEAT_SOURCES)
                .addOptional(MoaDecorCookeryModItems.ESTUFA.getId())
                .addOptional(MoaDecorCookeryModItems.ESTUFAABIERTA.getId())
                .addOptional(MoaDecorCookeryModItems.ESTUFAPAY.getId())
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("nfm:oven_light")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("nfm:oven_dark")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("handcrafted:oven")));
        tag(TBATags.Blocks.FD_TRAY_HEAT_SOURCES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("exlinefurniture:oven")));
        tag(TBATags.Blocks.FR_HEAT_CONDUCTORS).addTag(TBATags.Blocks.FD_HEAT_CONDUCTORS);
        tag(TBATags.Blocks.FR_HEAT_SOURCES).addTag(TBATags.Blocks.FD_HEAT_SOURCES);
        tag(TBATags.Blocks.FR_TRAY_HEAT_SOURCES).addTag(TBATags.Blocks.FD_TRAY_HEAT_SOURCES);
        tag(TBATags.Blocks.CARPETS)
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
        tag(TBATags.Blocks.SAND)
                .addOptional(BOPBlocks.WHITE_SAND.getId())
                .addOptional(BOPBlocks.ROOTED_SAND.getId())
                .addOptional(BOPBlocks.ORANGE_SAND.getId())
                .addOptional(BOPBlocks.BLACK_SAND.getId())
                .add(Blocks.SAND)
                .add(Blocks.RED_SAND);
        tag(TBATags.Blocks.GLASS)
                .addOptional(UnusualendModItems.CHISELED_GLASS.getId())
                .addOptional(PhantasmModItems.CRYSTAL_FRAMED_GLASS.getId())
                .addOptional(PhantasmModItems.VOID_CRYSTAL_FRAMED_GLASS.getId());
        tag(TBATags.Blocks.GINGERBREADS)
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
