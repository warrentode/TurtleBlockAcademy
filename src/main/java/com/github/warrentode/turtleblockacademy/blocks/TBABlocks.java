package com.github.warrentode.turtleblockacademy.blocks;

import com.github.warrentode.turtleblockacademy.TurtleBlockAcademy;
import com.github.warrentode.turtleblockacademy.blocks.crop.CloveBushBlock;
import com.github.warrentode.turtleblockacademy.blocks.crop.CucumberBushBlock;
import com.github.warrentode.turtleblockacademy.blocks.crop.DillBushBlock;
import com.github.warrentode.turtleblockacademy.blocks.furniture.*;
import com.github.warrentode.turtleblockacademy.items.TBAItems;
import com.github.warrentode.turtleblockacademy.util.TBATab;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TBABlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> CERTIFICATE_BLOCK = registerBlock("certificate_block",
            () -> new CertificateBlock(BlockBehaviour.Properties.of(Material.PLANT)
                    .sound(TurtleBlockAcademy.CERTIFICATE).strength(1).noOcclusion()));

    public static final RegistryObject<Block> FERMENTING_POT_BLOCK = registerBlock("fermenting_pot",
            () -> new FermentingPotBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.STONE).strength(1).noOcclusion()));

    public static final RegistryObject<Block> CLOVE_BUSH = BLOCKS.register("clove_bush",
            () -> new CloveBushBlock(BlockBehaviour.Properties.of(Material.PLANT)
                    .randomTicks().instabreak().sound(SoundType.SWEET_BERRY_BUSH)
                    .noCollission().noOcclusion()));

    public static final RegistryObject<Block> CUCUMBER_BUSH = BLOCKS.register("cucumber_bush",
            () -> new CucumberBushBlock(BlockBehaviour.Properties.of(Material.PLANT)
                    .randomTicks().instabreak().sound(SoundType.SWEET_BERRY_BUSH)
                    .noCollission().noOcclusion()));

    public static final RegistryObject<Block> DILL_BUSH = BLOCKS.register("dill_bush",
            () -> new DillBushBlock(BlockBehaviour.Properties.of(Material.PLANT)
                    .randomTicks().instabreak().sound(SoundType.CROP)
                    .noCollission().noOcclusion()));

    public static final RegistryObject<Block> TBA_MINING_PORTAL_BLOCK =
            registerBlockWithoutBlockItem("mining_portal", TBAMiningPortalBlock::new);

    public static final RegistryObject<Block> QUARTZ_CLUSTER = registerBlock("quartz_cluster",
            () -> new QuartzClusterBlock(7, 3,
                    BlockBehaviour.Properties.of(Material.AMETHYST)
                            .sound(SoundType.AMETHYST_CLUSTER).strength(1.5F)
                            .lightLevel((state) -> 5)));

    public static final RegistryObject<Block> PLATE_WHITE = registerBlock("plate_white",
            () -> new PlateBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_ORANGE = registerBlock("plate_orange",
            () -> new PlateBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_MAGENTA = registerBlock("plate_magenta",
            () -> new PlateBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_LIGHT_BLUE = registerBlock("plate_light_blue",
            () -> new PlateBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_YELLOW = registerBlock("plate_yellow",
            () -> new PlateBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_LIME = registerBlock("plate_lime",
            () -> new PlateBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_PINK = registerBlock("plate_pink",
            () -> new PlateBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_GRAY = registerBlock("plate_gray",
            () -> new PlateBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_LIGHT_GRAY = registerBlock("plate_light_gray",
            () -> new PlateBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_CYAN = registerBlock("plate_cyan",
            () -> new PlateBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_PURPLE = registerBlock("plate_purple",
            () -> new PlateBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_BLUE = registerBlock("plate_blue",
            () -> new PlateBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_BROWN = registerBlock("plate_brown",
            () -> new PlateBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_GREEN = registerBlock("plate_green",
            () -> new PlateBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_RED = registerBlock("plate_red",
            () -> new PlateBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_BLACK = registerBlock("plate_black",
            () -> new PlateBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .sound(SoundType.BONE_BLOCK).strength(1)));

    public static final RegistryObject<Block> SCHOOL_DESK_OAK = registerBlock("school_desk_oak",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_BIRCH = registerBlock("school_desk_birch",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_SPRUCE = registerBlock("school_desk_spruce",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_JUNGLE = registerBlock("school_desk_jungle",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_ACACIA = registerBlock("school_desk_acacia",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_DARK_OAK = registerBlock("school_desk_dark_oak",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_MANGROVE = registerBlock("school_desk_mangrove",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CRIMSON = registerBlock("school_desk_crimson",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_WARPED = registerBlock("school_desk_warped",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_OAK = registerBlock("school_desk_cabinet_oak",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_BIRCH = registerBlock("school_desk_cabinet_birch",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_SPRUCE = registerBlock("school_desk_cabinet_spruce",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_JUNGLE = registerBlock("school_desk_cabinet_jungle",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_ACACIA = registerBlock("school_desk_cabinet_acacia",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_DARK_OAK = registerBlock("school_desk_cabinet_dark_oak",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_MANGROVE = registerBlock("school_desk_cabinet_mangrove",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_CRIMSON = registerBlock("school_desk_cabinet_crimson",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_WARPED = registerBlock("school_desk_cabinet_warped",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> DESK_CHAIR_OAK = registerBlock("desk_chair_oak",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_BIRCH = registerBlock("desk_chair_birch",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_SPRUCE = registerBlock("desk_chair_spruce",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_JUNGLE = registerBlock("desk_chair_jungle",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_ACACIA = registerBlock("desk_chair_acacia",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_DARK_OAK = registerBlock("desk_chair_dark_oak",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_MANGROVE = registerBlock("desk_chair_mangrove",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_CRIMSON = registerBlock("desk_chair_crimson",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_WARPED = registerBlock("desk_chair_warped",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> LOCKER_OAK = registerBlock("locker_oak",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_BIRCH = registerBlock("locker_birch",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_SPRUCE = registerBlock("locker_spruce",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_JUNGLE = registerBlock("locker_jungle",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_ACACIA = registerBlock("locker_acacia",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_DARK_OAK = registerBlock("locker_dark_oak",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_MANGROVE = registerBlock("locker_mangrove",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_CRIMSON = registerBlock("locker_crimson",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_WARPED = registerBlock("locker_warped",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> PARK_BENCH_OAK = registerBlock("park_bench_oak",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_BIRCH = registerBlock("park_bench_birch",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_SPRUCE = registerBlock("park_bench_spruce",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_JUNGLE = registerBlock("park_bench_jungle",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_ACACIA = registerBlock("park_bench_acacia",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_DARK_OAK = registerBlock("park_bench_dark_oak",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_MANGROVE = registerBlock("park_bench_mangrove",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_CRIMSON = registerBlock("park_bench_crimson",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_WARPED = registerBlock("park_bench_warped",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> TABLE_OAK = registerBlock("table_oak",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_BIRCH = registerBlock("table_birch",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_SPRUCE = registerBlock("table_spruce",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_JUNGLE = registerBlock("table_jungle",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_ACACIA = registerBlock("table_acacia",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_DARK_OAK = registerBlock("table_dark_oak",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_MANGROVE = registerBlock("table_mangrove",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_CRIMSON = registerBlock("table_crimson",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_WARPED = registerBlock("table_warped",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_FIR = registerBlock("school_desk_fir",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_FIR = registerBlock("school_desk_cabinet_fir",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_FIR = registerBlock("desk_chair_fir",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_FIR = registerBlock("locker_fir",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_FIR = registerBlock("park_bench_fir",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_FIR = registerBlock("table_fir",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_REDWOOD = registerBlock("school_desk_redwood",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_REDWOOD = registerBlock("school_desk_cabinet_redwood",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_REDWOOD = registerBlock("desk_chair_redwood",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_REDWOOD = registerBlock("locker_redwood",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_REDWOOD = registerBlock("park_bench_redwood",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_REDWOOD = registerBlock("table_redwood",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_CHERRY = registerBlock("school_desk_cherry",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_CHERRY = registerBlock("school_desk_cabinet_cherry",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_CHERRY = registerBlock("desk_chair_cherry",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_CHERRY = registerBlock("locker_cherry",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_CHERRY = registerBlock("park_bench_cherry",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_CHERRY = registerBlock("table_cherry",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_MAHOGANY = registerBlock("school_desk_mahogany",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_MAHOGANY = registerBlock("school_desk_cabinet_mahogany",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_MAHOGANY = registerBlock("desk_chair_mahogany",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_MAHOGANY = registerBlock("locker_mahogany",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_MAHOGANY = registerBlock("park_bench_mahogany",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_MAHOGANY = registerBlock("table_mahogany",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_JACARANDA = registerBlock("school_desk_jacaranda",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_JACARANDA = registerBlock("school_desk_cabinet_jacaranda",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_JACARANDA = registerBlock("desk_chair_jacaranda",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_JACARANDA = registerBlock("locker_jacaranda",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_JACARANDA = registerBlock("park_bench_jacaranda",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_JACARANDA = registerBlock("table_jacaranda",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_PALM = registerBlock("school_desk_palm",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_PALM = registerBlock("school_desk_cabinet_palm",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_PALM = registerBlock("desk_chair_palm",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_PALM = registerBlock("locker_palm",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_PALM = registerBlock("park_bench_palm",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_PALM = registerBlock("table_palm",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_WILLOW = registerBlock("school_desk_willow",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_WILLOW = registerBlock("school_desk_cabinet_willow",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_WILLOW = registerBlock("desk_chair_willow",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_WILLOW = registerBlock("locker_willow",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_WILLOW = registerBlock("park_bench_willow",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_WILLOW = registerBlock("table_willow",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_DEAD = registerBlock("school_desk_dead",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_DEAD = registerBlock("school_desk_cabinet_dead",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_DEAD = registerBlock("desk_chair_dead",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_DEAD = registerBlock("locker_dead",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_DEAD = registerBlock("park_bench_dead",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_DEAD = registerBlock("table_dead",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_MAGIC = registerBlock("school_desk_magic",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_MAGIC = registerBlock("school_desk_cabinet_magic",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_MAGIC = registerBlock("desk_chair_magic",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_MAGIC = registerBlock("locker_magic",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_MAGIC = registerBlock("park_bench_magic",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_MAGIC = registerBlock("table_magic",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_UMBRAN = registerBlock("school_desk_umbran",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_UMBRAN = registerBlock("school_desk_cabinet_umbran",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_UMBRAN = registerBlock("desk_chair_umbran",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_UMBRAN = registerBlock("locker_umbran",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_UMBRAN = registerBlock("park_bench_umbran",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_UMBRAN = registerBlock("table_umbran",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_HELLBARK = registerBlock("school_desk_hellbark",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_HELLBARK = registerBlock("school_desk_cabinet_hellbark",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_HELLBARK = registerBlock("desk_chair_hellbark",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_HELLBARK = registerBlock("locker_hellbark",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_HELLBARK = registerBlock("park_bench_hellbark",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_HELLBARK = registerBlock("table_hellbark",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_COCONUT = registerBlock("school_desk_coconut",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_COCONUT = registerBlock("school_desk_cabinet_coconut",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_COCONUT = registerBlock("desk_chair_coconut",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_COCONUT = registerBlock("locker_coconut",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_COCONUT = registerBlock("park_bench_coconut",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_COCONUT = registerBlock("table_coconut",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_WALNUT = registerBlock("school_desk_walnut",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_WALNUT = registerBlock("school_desk_cabinet_walnut",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_WALNUT = registerBlock("desk_chair_walnut",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_WALNUT = registerBlock("locker_walnut",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_WALNUT = registerBlock("park_bench_walnut",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_WALNUT = registerBlock("table_walnut",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_AZALEA = registerBlock("school_desk_azalea",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_AZALEA = registerBlock("school_desk_cabinet_azalea",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_AZALEA = registerBlock("desk_chair_azalea",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_AZALEA = registerBlock("locker_azalea",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_AZALEA = registerBlock("park_bench_azalea",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_AZALEA = registerBlock("table_azalea",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_FLOWERING_AZALEA = registerBlock("school_desk_flowering_azalea",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_FLOWERING_AZALEA = registerBlock("school_desk_cabinet_flowering_azalea",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_FLOWERING_AZALEA = registerBlock("desk_chair_flowering_azalea",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_FLOWERING_AZALEA = registerBlock("locker_flowering_azalea",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_FLOWERING_AZALEA = registerBlock("park_bench_flowering_azalea",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_FLOWERING_AZALEA = registerBlock("table_flowering_azalea",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_GOLDEN_OAK = registerBlock("school_desk_golden_oak",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_GOLDEN_OAK = registerBlock("school_desk_cabinet_golden_oak",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_GOLDEN_OAK = registerBlock("desk_chair_golden_oak",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_GOLDEN_OAK = registerBlock("locker_golden_oak",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_GOLDEN_OAK = registerBlock("park_bench_golden_oak",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_GOLDEN_OAK = registerBlock("table_golden_oak",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_AETHER_SKYROOT = registerBlock("school_desk_aether_skyroot",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_AETHER_SKYROOT = registerBlock("school_desk_cabinet_aether_skyroot",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_AETHER_SKYROOT = registerBlock("desk_chair_aether_skyroot",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_AETHER_SKYROOT = registerBlock("locker_aether_skyroot",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_AETHER_SKYROOT = registerBlock("park_bench_aether_skyroot",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_AETHER_SKYROOT = registerBlock("table_aether_skyroot",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_PREAM = registerBlock("school_desk_pream",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_PREAM = registerBlock("school_desk_cabinet_pream",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_PREAM = registerBlock("desk_chair_pream",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_PREAM = registerBlock("locker_pream",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_PREAM = registerBlock("park_bench_pream",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_PREAM = registerBlock("table_pream",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_EBONY = registerBlock("school_desk_ebony",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_EBONY = registerBlock("school_desk_cabinet_ebony",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_EBONY = registerBlock("desk_chair_ebony",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_EBONY = registerBlock("locker_ebony",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_EBONY = registerBlock("park_bench_ebony",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_EBONY = registerBlock("table_ebony",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_CHORUS_NEST = registerBlock("school_desk_chorus_nest",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_CHORUS_NEST = registerBlock("school_desk_cabinet_chorus_nest",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_CHORUS_NEST = registerBlock("desk_chair_chorus_nest",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_CHORUS_NEST = registerBlock("locker_chorus_nest",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_CHORUS_NEST = registerBlock("park_bench_chorus_nest",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_CHORUS_NEST = registerBlock("table_chorus_nest",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_BLOODSHROOM = registerBlock("school_desk_bloodshroom",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_BLOODSHROOM = registerBlock("school_desk_cabinet_bloodshroom",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_BLOODSHROOM = registerBlock("desk_chair_bloodshroom",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_BLOODSHROOM = registerBlock("locker_bloodshroom",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_BLOODSHROOM = registerBlock("park_bench_bloodshroom",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_BLOODSHROOM = registerBlock("table_bloodshroom",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_ENDERBARK = registerBlock("school_desk_enderbark",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_ENDERBARK = registerBlock("school_desk_cabinet_enderbark",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_ENDERBARK = registerBlock("desk_chair_enderbark",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_ENDERBARK = registerBlock("locker_enderbark",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_ENDERBARK = registerBlock("park_bench_enderbark",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_ENDERBARK = registerBlock("table_enderbark",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_GREENHEART = registerBlock("school_desk_greenheart",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_GREENHEART = registerBlock("school_desk_cabinet_greenheart",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_GREENHEART = registerBlock("desk_chair_greenheart",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_GREENHEART = registerBlock("locker_greenheart",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_GREENHEART = registerBlock("park_bench_greenheart",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_GREENHEART = registerBlock("table_greenheart",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_TINKER_SKYROOT = registerBlock("school_desk_tinker_skyroot",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_TINKER_SKYROOT = registerBlock("school_desk_cabinet_tinker_skyroot",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> DESK_CHAIR_TINKER_SKYROOT = registerBlock("desk_chair_tinker_skyroot",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> LOCKER_TINKER_SKYROOT = registerBlock("locker_tinker_skyroot",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> PARK_BENCH_TINKER_SKYROOT = registerBlock("park_bench_tinker_skyroot",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> TABLE_TINKER_SKYROOT = registerBlock("table_tinker_skyroot",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> BOOKCASE_OAK = registerBlock("bookcase_oak",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_BIRCH = registerBlock("bookcase_birch",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_SPRUCE = registerBlock("bookcase_spruce",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_JUNGLE = registerBlock("bookcase_jungle",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_ACACIA = registerBlock("bookcase_acacia",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_DARK_OAK = registerBlock("bookcase_dark_oak",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_MANGROVE = registerBlock("bookcase_mangrove",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_CRIMSON = registerBlock("bookcase_crimson",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_WARPED = registerBlock("bookcase_warped",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_FIR = registerBlock("bookcase_fir",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_REDWOOD = registerBlock("bookcase_redwood",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_CHERRY = registerBlock("bookcase_cherry",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_MAHOGANY = registerBlock("bookcase_mahogany",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_JACARANDA = registerBlock("bookcase_jacaranda",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_PALM = registerBlock("bookcase_palm",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_WILLOW = registerBlock("bookcase_willow",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_DEAD = registerBlock("bookcase_dead",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_MAGIC = registerBlock("bookcase_magic",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_UMBRAN = registerBlock("bookcase_umbran",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_HELLBARK = registerBlock("bookcase_hellbark",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_COCONUT = registerBlock("bookcase_coconut",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_WALNUT = registerBlock("bookcase_walnut",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_AZALEA = registerBlock("bookcase_azalea",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_FLOWERING_AZALEA = registerBlock("bookcase_flowering_azalea",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_GOLDEN_OAK = registerBlock("bookcase_golden_oak",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_AETHER_SKYROOT = registerBlock("bookcase_aether_skyroot",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_PREAM = registerBlock("bookcase_pream",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_EBONY = registerBlock("bookcase_ebony",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_CHORUS_NEST = registerBlock("bookcase_chorus_nest",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_BLOODSHROOM = registerBlock("bookcase_bloodshroom",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_ENDERBARK = registerBlock("bookcase_enderbark",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_GREENHEART = registerBlock("bookcase_greenheart",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));
    public static final RegistryObject<Block> BOOKCASE_TINKER_SKYROOT = registerBlock("bookcase_tinker_skyroot",
            () -> new BookCaseBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).strength(1).noOcclusion()));

    public static final RegistryObject<Block> BASKET_OAK_WHITE =
            registerBlockWithoutBlockItem("basket_oak_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_OAK_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_oak_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_OAK_GRAY =
            registerBlockWithoutBlockItem("basket_oak_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_OAK_BLACK =
            registerBlockWithoutBlockItem("basket_oak_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_OAK_BROWN =
            registerBlockWithoutBlockItem("basket_oak_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_OAK_RED =
            registerBlockWithoutBlockItem("basket_oak_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_OAK_ORANGE =
            registerBlockWithoutBlockItem("basket_oak_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_OAK_YELLOW =
            registerBlockWithoutBlockItem("basket_oak_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_OAK_LIME =
            registerBlockWithoutBlockItem("basket_oak_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_OAK_GREEN =
            registerBlockWithoutBlockItem("basket_oak_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_OAK_CYAN =
            registerBlockWithoutBlockItem("basket_oak_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_OAK_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_oak_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_OAK_BLUE =
            registerBlockWithoutBlockItem("basket_oak_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_OAK_PURPLE =
            registerBlockWithoutBlockItem("basket_oak_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_OAK_MAGENTA =
            registerBlockWithoutBlockItem("basket_oak_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_OAK_PINK =
            registerBlockWithoutBlockItem("basket_oak_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_BIRCH_WHITE =
            registerBlockWithoutBlockItem("basket_birch_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_BIRCH_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_birch_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_BIRCH_GRAY =
            registerBlockWithoutBlockItem("basket_birch_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_BIRCH_BLACK =
            registerBlockWithoutBlockItem("basket_birch_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_BIRCH_BROWN =
            registerBlockWithoutBlockItem("basket_birch_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_BIRCH_RED =
            registerBlockWithoutBlockItem("basket_birch_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_BIRCH_ORANGE =
            registerBlockWithoutBlockItem("basket_birch_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_BIRCH_YELLOW =
            registerBlockWithoutBlockItem("basket_birch_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_BIRCH_LIME =
            registerBlockWithoutBlockItem("basket_birch_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_BIRCH_GREEN =
            registerBlockWithoutBlockItem("basket_birch_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_BIRCH_CYAN =
            registerBlockWithoutBlockItem("basket_birch_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_BIRCH_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_birch_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_BIRCH_BLUE =
            registerBlockWithoutBlockItem("basket_birch_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_BIRCH_PURPLE =
            registerBlockWithoutBlockItem("basket_birch_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_BIRCH_MAGENTA =
            registerBlockWithoutBlockItem("basket_birch_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_BIRCH_PINK =
            registerBlockWithoutBlockItem("basket_birch_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_SPRUCE_WHITE =
            registerBlockWithoutBlockItem("basket_spruce_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_SPRUCE_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_spruce_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_SPRUCE_GRAY =
            registerBlockWithoutBlockItem("basket_spruce_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_SPRUCE_BLACK =
            registerBlockWithoutBlockItem("basket_spruce_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_SPRUCE_BROWN =
            registerBlockWithoutBlockItem("basket_spruce_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_SPRUCE_RED =
            registerBlockWithoutBlockItem("basket_spruce_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_SPRUCE_ORANGE =
            registerBlockWithoutBlockItem("basket_spruce_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_SPRUCE_YELLOW =
            registerBlockWithoutBlockItem("basket_spruce_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_SPRUCE_LIME =
            registerBlockWithoutBlockItem("basket_spruce_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_SPRUCE_GREEN =
            registerBlockWithoutBlockItem("basket_spruce_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_SPRUCE_CYAN =
            registerBlockWithoutBlockItem("basket_spruce_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_SPRUCE_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_spruce_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_SPRUCE_BLUE =
            registerBlockWithoutBlockItem("basket_spruce_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_SPRUCE_PURPLE =
            registerBlockWithoutBlockItem("basket_spruce_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_SPRUCE_MAGENTA =
            registerBlockWithoutBlockItem("basket_spruce_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_SPRUCE_PINK =
            registerBlockWithoutBlockItem("basket_spruce_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_JUNGLE_WHITE =
            registerBlockWithoutBlockItem("basket_jungle_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_JUNGLE_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_jungle_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_JUNGLE_GRAY =
            registerBlockWithoutBlockItem("basket_jungle_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_JUNGLE_BLACK =
            registerBlockWithoutBlockItem("basket_jungle_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_JUNGLE_BROWN =
            registerBlockWithoutBlockItem("basket_jungle_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_JUNGLE_RED =
            registerBlockWithoutBlockItem("basket_jungle_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_JUNGLE_ORANGE =
            registerBlockWithoutBlockItem("basket_jungle_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_JUNGLE_YELLOW =
            registerBlockWithoutBlockItem("basket_jungle_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_JUNGLE_LIME =
            registerBlockWithoutBlockItem("basket_jungle_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_JUNGLE_GREEN =
            registerBlockWithoutBlockItem("basket_jungle_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_JUNGLE_CYAN =
            registerBlockWithoutBlockItem("basket_jungle_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_JUNGLE_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_jungle_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_JUNGLE_BLUE =
            registerBlockWithoutBlockItem("basket_jungle_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_JUNGLE_PURPLE =
            registerBlockWithoutBlockItem("basket_jungle_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_JUNGLE_MAGENTA =
            registerBlockWithoutBlockItem("basket_jungle_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_JUNGLE_PINK =
            registerBlockWithoutBlockItem("basket_jungle_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_ACACIA_WHITE =
            registerBlockWithoutBlockItem("basket_acacia_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_ACACIA_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_acacia_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_ACACIA_GRAY =
            registerBlockWithoutBlockItem("basket_acacia_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_ACACIA_BLACK =
            registerBlockWithoutBlockItem("basket_acacia_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_ACACIA_BROWN =
            registerBlockWithoutBlockItem("basket_acacia_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_ACACIA_RED =
            registerBlockWithoutBlockItem("basket_acacia_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_ACACIA_ORANGE =
            registerBlockWithoutBlockItem("basket_acacia_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_ACACIA_YELLOW =
            registerBlockWithoutBlockItem("basket_acacia_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_ACACIA_LIME =
            registerBlockWithoutBlockItem("basket_acacia_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_ACACIA_GREEN =
            registerBlockWithoutBlockItem("basket_acacia_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_ACACIA_CYAN =
            registerBlockWithoutBlockItem("basket_acacia_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_ACACIA_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_acacia_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_ACACIA_BLUE =
            registerBlockWithoutBlockItem("basket_acacia_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_ACACIA_PURPLE =
            registerBlockWithoutBlockItem("basket_acacia_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_ACACIA_MAGENTA =
            registerBlockWithoutBlockItem("basket_acacia_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_ACACIA_PINK =
            registerBlockWithoutBlockItem("basket_acacia_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_DARK_OAK_WHITE =
            registerBlockWithoutBlockItem("basket_dark_oak_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_DARK_OAK_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_dark_oak_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_DARK_OAK_GRAY =
            registerBlockWithoutBlockItem("basket_dark_oak_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_DARK_OAK_BLACK =
            registerBlockWithoutBlockItem("basket_dark_oak_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_DARK_OAK_BROWN =
            registerBlockWithoutBlockItem("basket_dark_oak_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_DARK_OAK_RED =
            registerBlockWithoutBlockItem("basket_dark_oak_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_DARK_OAK_ORANGE =
            registerBlockWithoutBlockItem("basket_dark_oak_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_DARK_OAK_YELLOW =
            registerBlockWithoutBlockItem("basket_dark_oak_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_DARK_OAK_LIME =
            registerBlockWithoutBlockItem("basket_dark_oak_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_DARK_OAK_GREEN =
            registerBlockWithoutBlockItem("basket_dark_oak_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_DARK_OAK_CYAN =
            registerBlockWithoutBlockItem("basket_dark_oak_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_DARK_OAK_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_dark_oak_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_DARK_OAK_BLUE =
            registerBlockWithoutBlockItem("basket_dark_oak_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_DARK_OAK_PURPLE =
            registerBlockWithoutBlockItem("basket_dark_oak_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_DARK_OAK_MAGENTA =
            registerBlockWithoutBlockItem("basket_dark_oak_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_DARK_OAK_PINK =
            registerBlockWithoutBlockItem("basket_dark_oak_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_MANGROVE_WHITE =
            registerBlockWithoutBlockItem("basket_mangrove_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_MANGROVE_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_mangrove_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_MANGROVE_GRAY =
            registerBlockWithoutBlockItem("basket_mangrove_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_MANGROVE_BLACK =
            registerBlockWithoutBlockItem("basket_mangrove_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_MANGROVE_BROWN =
            registerBlockWithoutBlockItem("basket_mangrove_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_MANGROVE_RED =
            registerBlockWithoutBlockItem("basket_mangrove_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_MANGROVE_ORANGE =
            registerBlockWithoutBlockItem("basket_mangrove_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_MANGROVE_YELLOW =
            registerBlockWithoutBlockItem("basket_mangrove_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_MANGROVE_LIME =
            registerBlockWithoutBlockItem("basket_mangrove_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_MANGROVE_GREEN =
            registerBlockWithoutBlockItem("basket_mangrove_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_MANGROVE_CYAN =
            registerBlockWithoutBlockItem("basket_mangrove_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_MANGROVE_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_mangrove_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_MANGROVE_BLUE =
            registerBlockWithoutBlockItem("basket_mangrove_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_MANGROVE_PURPLE =
            registerBlockWithoutBlockItem("basket_mangrove_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_MANGROVE_MAGENTA =
            registerBlockWithoutBlockItem("basket_mangrove_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_MANGROVE_PINK =
            registerBlockWithoutBlockItem("basket_mangrove_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_CRIMSON_WHITE =
            registerBlockWithoutBlockItem("basket_crimson_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_CRIMSON_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_crimson_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_CRIMSON_GRAY =
            registerBlockWithoutBlockItem("basket_crimson_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_CRIMSON_BLACK =
            registerBlockWithoutBlockItem("basket_crimson_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_CRIMSON_BROWN =
            registerBlockWithoutBlockItem("basket_crimson_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_CRIMSON_RED =
            registerBlockWithoutBlockItem("basket_crimson_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_CRIMSON_ORANGE =
            registerBlockWithoutBlockItem("basket_crimson_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_CRIMSON_YELLOW =
            registerBlockWithoutBlockItem("basket_crimson_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_CRIMSON_LIME =
            registerBlockWithoutBlockItem("basket_crimson_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_CRIMSON_GREEN =
            registerBlockWithoutBlockItem("basket_crimson_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_CRIMSON_CYAN =
            registerBlockWithoutBlockItem("basket_crimson_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_CRIMSON_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_crimson_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_CRIMSON_BLUE =
            registerBlockWithoutBlockItem("basket_crimson_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_CRIMSON_PURPLE =
            registerBlockWithoutBlockItem("basket_crimson_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_CRIMSON_MAGENTA =
            registerBlockWithoutBlockItem("basket_crimson_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_CRIMSON_PINK =
            registerBlockWithoutBlockItem("basket_crimson_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_WARPED_WHITE =
            registerBlockWithoutBlockItem("basket_warped_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_WARPED_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_warped_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_WARPED_GRAY =
            registerBlockWithoutBlockItem("basket_warped_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_WARPED_BLACK =
            registerBlockWithoutBlockItem("basket_warped_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_WARPED_BROWN =
            registerBlockWithoutBlockItem("basket_warped_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_WARPED_RED =
            registerBlockWithoutBlockItem("basket_warped_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_WARPED_ORANGE =
            registerBlockWithoutBlockItem("basket_warped_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_WARPED_YELLOW =
            registerBlockWithoutBlockItem("basket_warped_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_WARPED_LIME =
            registerBlockWithoutBlockItem("basket_warped_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_WARPED_GREEN =
            registerBlockWithoutBlockItem("basket_warped_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_WARPED_CYAN =
            registerBlockWithoutBlockItem("basket_warped_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_WARPED_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_warped_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_WARPED_BLUE =
            registerBlockWithoutBlockItem("basket_warped_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_WARPED_PURPLE =
            registerBlockWithoutBlockItem("basket_warped_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_WARPED_MAGENTA =
            registerBlockWithoutBlockItem("basket_warped_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_WARPED_PINK =
            registerBlockWithoutBlockItem("basket_warped_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_FIR_WHITE =
            registerBlockWithoutBlockItem("basket_fir_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_FIR_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_fir_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_FIR_GRAY =
            registerBlockWithoutBlockItem("basket_fir_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_FIR_BLACK =
            registerBlockWithoutBlockItem("basket_fir_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_FIR_BROWN =
            registerBlockWithoutBlockItem("basket_fir_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_FIR_RED =
            registerBlockWithoutBlockItem("basket_fir_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_FIR_ORANGE =
            registerBlockWithoutBlockItem("basket_fir_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_FIR_YELLOW =
            registerBlockWithoutBlockItem("basket_fir_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_FIR_LIME =
            registerBlockWithoutBlockItem("basket_fir_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_FIR_GREEN =
            registerBlockWithoutBlockItem("basket_fir_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_FIR_CYAN =
            registerBlockWithoutBlockItem("basket_fir_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_FIR_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_fir_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_FIR_BLUE =
            registerBlockWithoutBlockItem("basket_fir_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_FIR_PURPLE =
            registerBlockWithoutBlockItem("basket_fir_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_FIR_MAGENTA =
            registerBlockWithoutBlockItem("basket_fir_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_FIR_PINK =
            registerBlockWithoutBlockItem("basket_fir_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_REDWOOD_WHITE =
            registerBlockWithoutBlockItem("basket_redwood_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_REDWOOD_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_redwood_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_REDWOOD_GRAY =
            registerBlockWithoutBlockItem("basket_redwood_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_REDWOOD_BLACK =
            registerBlockWithoutBlockItem("basket_redwood_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_REDWOOD_BROWN =
            registerBlockWithoutBlockItem("basket_redwood_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_REDWOOD_RED =
            registerBlockWithoutBlockItem("basket_redwood_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_REDWOOD_ORANGE =
            registerBlockWithoutBlockItem("basket_redwood_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_REDWOOD_YELLOW =
            registerBlockWithoutBlockItem("basket_redwood_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_REDWOOD_LIME =
            registerBlockWithoutBlockItem("basket_redwood_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_REDWOOD_GREEN =
            registerBlockWithoutBlockItem("basket_redwood_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_REDWOOD_CYAN =
            registerBlockWithoutBlockItem("basket_redwood_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_REDWOOD_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_redwood_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_REDWOOD_BLUE =
            registerBlockWithoutBlockItem("basket_redwood_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_REDWOOD_PURPLE =
            registerBlockWithoutBlockItem("basket_redwood_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_REDWOOD_MAGENTA =
            registerBlockWithoutBlockItem("basket_redwood_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_REDWOOD_PINK =
            registerBlockWithoutBlockItem("basket_redwood_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_CHERRY_WHITE =
            registerBlockWithoutBlockItem("basket_cherry_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_CHERRY_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_cherry_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_CHERRY_GRAY =
            registerBlockWithoutBlockItem("basket_cherry_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_CHERRY_BLACK =
            registerBlockWithoutBlockItem("basket_cherry_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_CHERRY_BROWN =
            registerBlockWithoutBlockItem("basket_cherry_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_CHERRY_RED =
            registerBlockWithoutBlockItem("basket_cherry_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_CHERRY_ORANGE =
            registerBlockWithoutBlockItem("basket_cherry_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_CHERRY_YELLOW =
            registerBlockWithoutBlockItem("basket_cherry_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_CHERRY_LIME =
            registerBlockWithoutBlockItem("basket_cherry_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_CHERRY_GREEN =
            registerBlockWithoutBlockItem("basket_cherry_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_CHERRY_CYAN =
            registerBlockWithoutBlockItem("basket_cherry_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_CHERRY_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_cherry_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_CHERRY_BLUE =
            registerBlockWithoutBlockItem("basket_cherry_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_CHERRY_PURPLE =
            registerBlockWithoutBlockItem("basket_cherry_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_CHERRY_MAGENTA =
            registerBlockWithoutBlockItem("basket_cherry_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_CHERRY_PINK =
            registerBlockWithoutBlockItem("basket_cherry_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_MAHOGANY_WHITE =
            registerBlockWithoutBlockItem("basket_mahogany_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_MAHOGANY_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_mahogany_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_MAHOGANY_GRAY =
            registerBlockWithoutBlockItem("basket_mahogany_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_MAHOGANY_BLACK =
            registerBlockWithoutBlockItem("basket_mahogany_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_MAHOGANY_BROWN =
            registerBlockWithoutBlockItem("basket_mahogany_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_MAHOGANY_RED =
            registerBlockWithoutBlockItem("basket_mahogany_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_MAHOGANY_ORANGE =
            registerBlockWithoutBlockItem("basket_mahogany_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_MAHOGANY_YELLOW =
            registerBlockWithoutBlockItem("basket_mahogany_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_MAHOGANY_LIME =
            registerBlockWithoutBlockItem("basket_mahogany_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_MAHOGANY_GREEN =
            registerBlockWithoutBlockItem("basket_mahogany_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_MAHOGANY_CYAN =
            registerBlockWithoutBlockItem("basket_mahogany_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_MAHOGANY_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_mahogany_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_MAHOGANY_BLUE =
            registerBlockWithoutBlockItem("basket_mahogany_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_MAHOGANY_PURPLE =
            registerBlockWithoutBlockItem("basket_mahogany_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_MAHOGANY_MAGENTA =
            registerBlockWithoutBlockItem("basket_mahogany_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_MAHOGANY_PINK =
            registerBlockWithoutBlockItem("basket_mahogany_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_JACARANDA_WHITE =
            registerBlockWithoutBlockItem("basket_jacaranda_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_JACARANDA_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_jacaranda_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_JACARANDA_GRAY =
            registerBlockWithoutBlockItem("basket_jacaranda_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_JACARANDA_BLACK =
            registerBlockWithoutBlockItem("basket_jacaranda_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_JACARANDA_BROWN =
            registerBlockWithoutBlockItem("basket_jacaranda_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_JACARANDA_RED =
            registerBlockWithoutBlockItem("basket_jacaranda_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_JACARANDA_ORANGE =
            registerBlockWithoutBlockItem("basket_jacaranda_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_JACARANDA_YELLOW =
            registerBlockWithoutBlockItem("basket_jacaranda_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_JACARANDA_LIME =
            registerBlockWithoutBlockItem("basket_jacaranda_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_JACARANDA_GREEN =
            registerBlockWithoutBlockItem("basket_jacaranda_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_JACARANDA_CYAN =
            registerBlockWithoutBlockItem("basket_jacaranda_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_JACARANDA_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_jacaranda_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_JACARANDA_BLUE =
            registerBlockWithoutBlockItem("basket_jacaranda_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_JACARANDA_PURPLE =
            registerBlockWithoutBlockItem("basket_jacaranda_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_JACARANDA_MAGENTA =
            registerBlockWithoutBlockItem("basket_jacaranda_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_JACARANDA_PINK =
            registerBlockWithoutBlockItem("basket_jacaranda_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_PALM_WHITE =
            registerBlockWithoutBlockItem("basket_palm_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_PALM_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_palm_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_PALM_GRAY =
            registerBlockWithoutBlockItem("basket_palm_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_PALM_BLACK =
            registerBlockWithoutBlockItem("basket_palm_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_PALM_BROWN =
            registerBlockWithoutBlockItem("basket_palm_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_PALM_RED =
            registerBlockWithoutBlockItem("basket_palm_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_PALM_ORANGE =
            registerBlockWithoutBlockItem("basket_palm_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_PALM_YELLOW =
            registerBlockWithoutBlockItem("basket_palm_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_PALM_LIME =
            registerBlockWithoutBlockItem("basket_palm_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_PALM_GREEN =
            registerBlockWithoutBlockItem("basket_palm_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_PALM_CYAN =
            registerBlockWithoutBlockItem("basket_palm_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_PALM_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_palm_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_PALM_BLUE =
            registerBlockWithoutBlockItem("basket_palm_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_PALM_PURPLE =
            registerBlockWithoutBlockItem("basket_palm_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_PALM_MAGENTA =
            registerBlockWithoutBlockItem("basket_palm_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_PALM_PINK =
            registerBlockWithoutBlockItem("basket_palm_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_WILLOW_WHITE =
            registerBlockWithoutBlockItem("basket_willow_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_WILLOW_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_willow_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_WILLOW_GRAY =
            registerBlockWithoutBlockItem("basket_willow_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_WILLOW_BLACK =
            registerBlockWithoutBlockItem("basket_willow_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_WILLOW_BROWN =
            registerBlockWithoutBlockItem("basket_willow_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_WILLOW_RED =
            registerBlockWithoutBlockItem("basket_willow_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_WILLOW_ORANGE =
            registerBlockWithoutBlockItem("basket_willow_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_WILLOW_YELLOW =
            registerBlockWithoutBlockItem("basket_willow_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_WILLOW_LIME =
            registerBlockWithoutBlockItem("basket_willow_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_WILLOW_GREEN =
            registerBlockWithoutBlockItem("basket_willow_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_WILLOW_CYAN =
            registerBlockWithoutBlockItem("basket_willow_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_WILLOW_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_willow_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_WILLOW_BLUE =
            registerBlockWithoutBlockItem("basket_willow_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_WILLOW_PURPLE =
            registerBlockWithoutBlockItem("basket_willow_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_WILLOW_MAGENTA =
            registerBlockWithoutBlockItem("basket_willow_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_WILLOW_PINK =
            registerBlockWithoutBlockItem("basket_willow_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_DEAD_WHITE =
            registerBlockWithoutBlockItem("basket_dead_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_DEAD_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_dead_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_DEAD_GRAY =
            registerBlockWithoutBlockItem("basket_dead_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_DEAD_BLACK =
            registerBlockWithoutBlockItem("basket_dead_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_DEAD_BROWN =
            registerBlockWithoutBlockItem("basket_dead_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_DEAD_RED =
            registerBlockWithoutBlockItem("basket_dead_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_DEAD_ORANGE =
            registerBlockWithoutBlockItem("basket_dead_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_DEAD_YELLOW =
            registerBlockWithoutBlockItem("basket_dead_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_DEAD_LIME =
            registerBlockWithoutBlockItem("basket_dead_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_DEAD_GREEN =
            registerBlockWithoutBlockItem("basket_dead_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_DEAD_CYAN =
            registerBlockWithoutBlockItem("basket_dead_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_DEAD_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_dead_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_DEAD_BLUE =
            registerBlockWithoutBlockItem("basket_dead_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_DEAD_PURPLE =
            registerBlockWithoutBlockItem("basket_dead_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_DEAD_MAGENTA =
            registerBlockWithoutBlockItem("basket_dead_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_DEAD_PINK =
            registerBlockWithoutBlockItem("basket_dead_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_MAGIC_WHITE =
            registerBlockWithoutBlockItem("basket_magic_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_MAGIC_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_magic_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_MAGIC_GRAY =
            registerBlockWithoutBlockItem("basket_magic_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_MAGIC_BLACK =
            registerBlockWithoutBlockItem("basket_magic_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_MAGIC_BROWN =
            registerBlockWithoutBlockItem("basket_magic_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_MAGIC_RED =
            registerBlockWithoutBlockItem("basket_magic_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_MAGIC_ORANGE =
            registerBlockWithoutBlockItem("basket_magic_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_MAGIC_YELLOW =
            registerBlockWithoutBlockItem("basket_magic_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_MAGIC_LIME =
            registerBlockWithoutBlockItem("basket_magic_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_MAGIC_GREEN =
            registerBlockWithoutBlockItem("basket_magic_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_MAGIC_CYAN =
            registerBlockWithoutBlockItem("basket_magic_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_MAGIC_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_magic_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_MAGIC_BLUE =
            registerBlockWithoutBlockItem("basket_magic_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_MAGIC_PURPLE =
            registerBlockWithoutBlockItem("basket_magic_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_MAGIC_MAGENTA =
            registerBlockWithoutBlockItem("basket_magic_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_MAGIC_PINK =
            registerBlockWithoutBlockItem("basket_magic_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_UMBRAN_WHITE =
            registerBlockWithoutBlockItem("basket_umbran_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_UMBRAN_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_umbran_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_UMBRAN_GRAY =
            registerBlockWithoutBlockItem("basket_umbran_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_UMBRAN_BLACK =
            registerBlockWithoutBlockItem("basket_umbran_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_UMBRAN_BROWN =
            registerBlockWithoutBlockItem("basket_umbran_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_UMBRAN_RED =
            registerBlockWithoutBlockItem("basket_umbran_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_UMBRAN_ORANGE =
            registerBlockWithoutBlockItem("basket_umbran_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_UMBRAN_YELLOW =
            registerBlockWithoutBlockItem("basket_umbran_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_UMBRAN_LIME =
            registerBlockWithoutBlockItem("basket_umbran_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_UMBRAN_GREEN =
            registerBlockWithoutBlockItem("basket_umbran_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_UMBRAN_CYAN =
            registerBlockWithoutBlockItem("basket_umbran_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_UMBRAN_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_umbran_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_UMBRAN_BLUE =
            registerBlockWithoutBlockItem("basket_umbran_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_UMBRAN_PURPLE =
            registerBlockWithoutBlockItem("basket_umbran_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_UMBRAN_MAGENTA =
            registerBlockWithoutBlockItem("basket_umbran_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_UMBRAN_PINK =
            registerBlockWithoutBlockItem("basket_umbran_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_HELLBARK_WHITE =
            registerBlockWithoutBlockItem("basket_hellbark_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_HELLBARK_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_hellbark_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_HELLBARK_GRAY =
            registerBlockWithoutBlockItem("basket_hellbark_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_HELLBARK_BLACK =
            registerBlockWithoutBlockItem("basket_hellbark_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_HELLBARK_BROWN =
            registerBlockWithoutBlockItem("basket_hellbark_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_HELLBARK_RED =
            registerBlockWithoutBlockItem("basket_hellbark_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_HELLBARK_ORANGE =
            registerBlockWithoutBlockItem("basket_hellbark_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_HELLBARK_YELLOW =
            registerBlockWithoutBlockItem("basket_hellbark_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_HELLBARK_LIME =
            registerBlockWithoutBlockItem("basket_hellbark_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_HELLBARK_GREEN =
            registerBlockWithoutBlockItem("basket_hellbark_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_HELLBARK_CYAN =
            registerBlockWithoutBlockItem("basket_hellbark_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_HELLBARK_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_hellbark_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_HELLBARK_BLUE =
            registerBlockWithoutBlockItem("basket_hellbark_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_HELLBARK_PURPLE =
            registerBlockWithoutBlockItem("basket_hellbark_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_HELLBARK_MAGENTA =
            registerBlockWithoutBlockItem("basket_hellbark_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_HELLBARK_PINK =
            registerBlockWithoutBlockItem("basket_hellbark_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_COCONUT_WHITE =
            registerBlockWithoutBlockItem("basket_coconut_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_COCONUT_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_coconut_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_COCONUT_GRAY =
            registerBlockWithoutBlockItem("basket_coconut_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_COCONUT_BLACK =
            registerBlockWithoutBlockItem("basket_coconut_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_COCONUT_BROWN =
            registerBlockWithoutBlockItem("basket_coconut_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_COCONUT_RED =
            registerBlockWithoutBlockItem("basket_coconut_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_COCONUT_ORANGE =
            registerBlockWithoutBlockItem("basket_coconut_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_COCONUT_YELLOW =
            registerBlockWithoutBlockItem("basket_coconut_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_COCONUT_LIME =
            registerBlockWithoutBlockItem("basket_coconut_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_COCONUT_GREEN =
            registerBlockWithoutBlockItem("basket_coconut_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_COCONUT_CYAN =
            registerBlockWithoutBlockItem("basket_coconut_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_COCONUT_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_coconut_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_COCONUT_BLUE =
            registerBlockWithoutBlockItem("basket_coconut_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_COCONUT_PURPLE =
            registerBlockWithoutBlockItem("basket_coconut_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_COCONUT_MAGENTA =
            registerBlockWithoutBlockItem("basket_coconut_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_COCONUT_PINK =
            registerBlockWithoutBlockItem("basket_coconut_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_WALNUT_WHITE =
            registerBlockWithoutBlockItem("basket_walnut_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_WALNUT_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_walnut_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_WALNUT_GRAY =
            registerBlockWithoutBlockItem("basket_walnut_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_WALNUT_BLACK =
            registerBlockWithoutBlockItem("basket_walnut_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_WALNUT_BROWN =
            registerBlockWithoutBlockItem("basket_walnut_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_WALNUT_RED =
            registerBlockWithoutBlockItem("basket_walnut_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_WALNUT_ORANGE =
            registerBlockWithoutBlockItem("basket_walnut_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_WALNUT_YELLOW =
            registerBlockWithoutBlockItem("basket_walnut_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_WALNUT_LIME =
            registerBlockWithoutBlockItem("basket_walnut_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_WALNUT_GREEN =
            registerBlockWithoutBlockItem("basket_walnut_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_WALNUT_CYAN =
            registerBlockWithoutBlockItem("basket_walnut_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_WALNUT_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_walnut_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_WALNUT_BLUE =
            registerBlockWithoutBlockItem("basket_walnut_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_WALNUT_PURPLE =
            registerBlockWithoutBlockItem("basket_walnut_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_WALNUT_MAGENTA =
            registerBlockWithoutBlockItem("basket_walnut_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_WALNUT_PINK =
            registerBlockWithoutBlockItem("basket_walnut_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_AZALEA_WHITE =
            registerBlockWithoutBlockItem("basket_azalea_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_AZALEA_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_azalea_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_AZALEA_GRAY =
            registerBlockWithoutBlockItem("basket_azalea_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_AZALEA_BLACK =
            registerBlockWithoutBlockItem("basket_azalea_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_AZALEA_BROWN =
            registerBlockWithoutBlockItem("basket_azalea_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_AZALEA_RED =
            registerBlockWithoutBlockItem("basket_azalea_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_AZALEA_ORANGE =
            registerBlockWithoutBlockItem("basket_azalea_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_AZALEA_YELLOW =
            registerBlockWithoutBlockItem("basket_azalea_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_AZALEA_LIME =
            registerBlockWithoutBlockItem("basket_azalea_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_AZALEA_GREEN =
            registerBlockWithoutBlockItem("basket_azalea_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_AZALEA_CYAN =
            registerBlockWithoutBlockItem("basket_azalea_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_AZALEA_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_azalea_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_AZALEA_BLUE =
            registerBlockWithoutBlockItem("basket_azalea_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_AZALEA_PURPLE =
            registerBlockWithoutBlockItem("basket_azalea_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_AZALEA_MAGENTA =
            registerBlockWithoutBlockItem("basket_azalea_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_AZALEA_PINK =
            registerBlockWithoutBlockItem("basket_azalea_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_WHITE =
            registerBlockWithoutBlockItem("basket_flowering_azalea_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_flowering_azalea_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_GRAY =
            registerBlockWithoutBlockItem("basket_flowering_azalea_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_BLACK =
            registerBlockWithoutBlockItem("basket_flowering_azalea_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_BROWN =
            registerBlockWithoutBlockItem("basket_flowering_azalea_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_RED =
            registerBlockWithoutBlockItem("basket_flowering_azalea_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_ORANGE =
            registerBlockWithoutBlockItem("basket_flowering_azalea_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_YELLOW =
            registerBlockWithoutBlockItem("basket_flowering_azalea_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_LIME =
            registerBlockWithoutBlockItem("basket_flowering_azalea_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_GREEN =
            registerBlockWithoutBlockItem("basket_flowering_azalea_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_CYAN =
            registerBlockWithoutBlockItem("basket_flowering_azalea_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_flowering_azalea_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_BLUE =
            registerBlockWithoutBlockItem("basket_flowering_azalea_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_PURPLE =
            registerBlockWithoutBlockItem("basket_flowering_azalea_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_MAGENTA =
            registerBlockWithoutBlockItem("basket_flowering_azalea_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_PINK =
            registerBlockWithoutBlockItem("basket_flowering_azalea_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_WHITE =
            registerBlockWithoutBlockItem("basket_aether_skyroot_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_aether_skyroot_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_GRAY =
            registerBlockWithoutBlockItem("basket_aether_skyroot_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_BLACK =
            registerBlockWithoutBlockItem("basket_aether_skyroot_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_BROWN =
            registerBlockWithoutBlockItem("basket_aether_skyroot_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_RED =
            registerBlockWithoutBlockItem("basket_aether_skyroot_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_ORANGE =
            registerBlockWithoutBlockItem("basket_aether_skyroot_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_YELLOW =
            registerBlockWithoutBlockItem("basket_aether_skyroot_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_LIME =
            registerBlockWithoutBlockItem("basket_aether_skyroot_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_GREEN =
            registerBlockWithoutBlockItem("basket_aether_skyroot_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_CYAN =
            registerBlockWithoutBlockItem("basket_aether_skyroot_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_aether_skyroot_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_BLUE =
            registerBlockWithoutBlockItem("basket_aether_skyroot_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_PURPLE =
            registerBlockWithoutBlockItem("basket_aether_skyroot_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_MAGENTA =
            registerBlockWithoutBlockItem("basket_aether_skyroot_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_PINK =
            registerBlockWithoutBlockItem("basket_aether_skyroot_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_PREAM_WHITE =
            registerBlockWithoutBlockItem("basket_pream_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_PREAM_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_pream_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_PREAM_GRAY =
            registerBlockWithoutBlockItem("basket_pream_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_PREAM_BLACK =
            registerBlockWithoutBlockItem("basket_pream_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_PREAM_BROWN =
            registerBlockWithoutBlockItem("basket_pream_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_PREAM_RED =
            registerBlockWithoutBlockItem("basket_pream_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_PREAM_ORANGE =
            registerBlockWithoutBlockItem("basket_pream_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_PREAM_YELLOW =
            registerBlockWithoutBlockItem("basket_pream_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_PREAM_LIME =
            registerBlockWithoutBlockItem("basket_pream_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_PREAM_GREEN =
            registerBlockWithoutBlockItem("basket_pream_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_PREAM_CYAN =
            registerBlockWithoutBlockItem("basket_pream_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_PREAM_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_pream_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_PREAM_BLUE =
            registerBlockWithoutBlockItem("basket_pream_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_PREAM_PURPLE =
            registerBlockWithoutBlockItem("basket_pream_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_PREAM_MAGENTA =
            registerBlockWithoutBlockItem("basket_pream_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_PREAM_PINK =
            registerBlockWithoutBlockItem("basket_pream_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_EBONY_WHITE =
            registerBlockWithoutBlockItem("basket_ebony_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_EBONY_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_ebony_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_EBONY_GRAY =
            registerBlockWithoutBlockItem("basket_ebony_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_EBONY_BLACK =
            registerBlockWithoutBlockItem("basket_ebony_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_EBONY_BROWN =
            registerBlockWithoutBlockItem("basket_ebony_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_EBONY_RED =
            registerBlockWithoutBlockItem("basket_ebony_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_EBONY_ORANGE =
            registerBlockWithoutBlockItem("basket_ebony_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_EBONY_YELLOW =
            registerBlockWithoutBlockItem("basket_ebony_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_EBONY_LIME =
            registerBlockWithoutBlockItem("basket_ebony_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_EBONY_GREEN =
            registerBlockWithoutBlockItem("basket_ebony_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_EBONY_CYAN =
            registerBlockWithoutBlockItem("basket_ebony_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_EBONY_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_ebony_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_EBONY_BLUE =
            registerBlockWithoutBlockItem("basket_ebony_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_EBONY_PURPLE =
            registerBlockWithoutBlockItem("basket_ebony_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_EBONY_MAGENTA =
            registerBlockWithoutBlockItem("basket_ebony_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_EBONY_PINK =
            registerBlockWithoutBlockItem("basket_ebony_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_WHITE =
            registerBlockWithoutBlockItem("basket_chorus_nest_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_chorus_nest_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_GRAY =
            registerBlockWithoutBlockItem("basket_chorus_nest_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_BLACK =
            registerBlockWithoutBlockItem("basket_chorus_nest_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_BROWN =
            registerBlockWithoutBlockItem("basket_chorus_nest_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_RED =
            registerBlockWithoutBlockItem("basket_chorus_nest_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_ORANGE =
            registerBlockWithoutBlockItem("basket_chorus_nest_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_YELLOW =
            registerBlockWithoutBlockItem("basket_chorus_nest_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_LIME =
            registerBlockWithoutBlockItem("basket_chorus_nest_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_GREEN =
            registerBlockWithoutBlockItem("basket_chorus_nest_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_CYAN =
            registerBlockWithoutBlockItem("basket_chorus_nest_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_chorus_nest_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_BLUE =
            registerBlockWithoutBlockItem("basket_chorus_nest_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_PURPLE =
            registerBlockWithoutBlockItem("basket_chorus_nest_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_MAGENTA =
            registerBlockWithoutBlockItem("basket_chorus_nest_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_PINK =
            registerBlockWithoutBlockItem("basket_chorus_nest_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_WHITE =
            registerBlockWithoutBlockItem("basket_bloodshroom_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_bloodshroom_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_GRAY =
            registerBlockWithoutBlockItem("basket_bloodshroom_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_BLACK =
            registerBlockWithoutBlockItem("basket_bloodshroom_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_BROWN =
            registerBlockWithoutBlockItem("basket_bloodshroom_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_RED =
            registerBlockWithoutBlockItem("basket_bloodshroom_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_ORANGE =
            registerBlockWithoutBlockItem("basket_bloodshroom_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_YELLOW =
            registerBlockWithoutBlockItem("basket_bloodshroom_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_LIME =
            registerBlockWithoutBlockItem("basket_bloodshroom_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_GREEN =
            registerBlockWithoutBlockItem("basket_bloodshroom_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_CYAN =
            registerBlockWithoutBlockItem("basket_bloodshroom_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_bloodshroom_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_BLUE =
            registerBlockWithoutBlockItem("basket_bloodshroom_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_PURPLE =
            registerBlockWithoutBlockItem("basket_bloodshroom_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_MAGENTA =
            registerBlockWithoutBlockItem("basket_bloodshroom_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_PINK =
            registerBlockWithoutBlockItem("basket_bloodshroom_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_ENDERBARK_WHITE =
            registerBlockWithoutBlockItem("basket_enderbark_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_ENDERBARK_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_enderbark_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_ENDERBARK_GRAY =
            registerBlockWithoutBlockItem("basket_enderbark_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_ENDERBARK_BLACK =
            registerBlockWithoutBlockItem("basket_enderbark_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_ENDERBARK_BROWN =
            registerBlockWithoutBlockItem("basket_enderbark_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_ENDERBARK_RED =
            registerBlockWithoutBlockItem("basket_enderbark_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_ENDERBARK_ORANGE =
            registerBlockWithoutBlockItem("basket_enderbark_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_ENDERBARK_YELLOW =
            registerBlockWithoutBlockItem("basket_enderbark_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_ENDERBARK_LIME =
            registerBlockWithoutBlockItem("basket_enderbark_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_ENDERBARK_GREEN =
            registerBlockWithoutBlockItem("basket_enderbark_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_ENDERBARK_CYAN =
            registerBlockWithoutBlockItem("basket_enderbark_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_ENDERBARK_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_enderbark_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_ENDERBARK_BLUE =
            registerBlockWithoutBlockItem("basket_enderbark_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_ENDERBARK_PURPLE =
            registerBlockWithoutBlockItem("basket_enderbark_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_ENDERBARK_MAGENTA =
            registerBlockWithoutBlockItem("basket_enderbark_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_ENDERBARK_PINK =
            registerBlockWithoutBlockItem("basket_enderbark_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_GREENHEART_WHITE =
            registerBlockWithoutBlockItem("basket_greenheart_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_GREENHEART_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_greenheart_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_GREENHEART_GRAY =
            registerBlockWithoutBlockItem("basket_greenheart_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_GREENHEART_BLACK =
            registerBlockWithoutBlockItem("basket_greenheart_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_GREENHEART_BROWN =
            registerBlockWithoutBlockItem("basket_greenheart_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_GREENHEART_RED =
            registerBlockWithoutBlockItem("basket_greenheart_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_GREENHEART_ORANGE =
            registerBlockWithoutBlockItem("basket_greenheart_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_GREENHEART_YELLOW =
            registerBlockWithoutBlockItem("basket_greenheart_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_GREENHEART_LIME =
            registerBlockWithoutBlockItem("basket_greenheart_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_GREENHEART_GREEN =
            registerBlockWithoutBlockItem("basket_greenheart_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_GREENHEART_CYAN =
            registerBlockWithoutBlockItem("basket_greenheart_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_GREENHEART_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_greenheart_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_GREENHEART_BLUE =
            registerBlockWithoutBlockItem("basket_greenheart_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_GREENHEART_PURPLE =
            registerBlockWithoutBlockItem("basket_greenheart_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_GREENHEART_MAGENTA =
            registerBlockWithoutBlockItem("basket_greenheart_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_GREENHEART_PINK =
            registerBlockWithoutBlockItem("basket_greenheart_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_WHITE =
            registerBlockWithoutBlockItem("basket_tinker_skyroot_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_LIGHT_GRAY =
            registerBlockWithoutBlockItem("basket_tinker_skyroot_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_GRAY =
            registerBlockWithoutBlockItem("basket_tinker_skyroot_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_BLACK =
            registerBlockWithoutBlockItem("basket_tinker_skyroot_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_BROWN =
            registerBlockWithoutBlockItem("basket_tinker_skyroot_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_RED =
            registerBlockWithoutBlockItem("basket_tinker_skyroot_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_ORANGE =
            registerBlockWithoutBlockItem("basket_tinker_skyroot_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_YELLOW =
            registerBlockWithoutBlockItem("basket_tinker_skyroot_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_LIME =
            registerBlockWithoutBlockItem("basket_tinker_skyroot_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_GREEN =
            registerBlockWithoutBlockItem("basket_tinker_skyroot_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_CYAN =
            registerBlockWithoutBlockItem("basket_tinker_skyroot_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_LIGHT_BLUE =
            registerBlockWithoutBlockItem("basket_tinker_skyroot_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_BLUE =
            registerBlockWithoutBlockItem("basket_tinker_skyroot_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_PURPLE =
            registerBlockWithoutBlockItem("basket_tinker_skyroot_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_MAGENTA =
            registerBlockWithoutBlockItem("basket_tinker_skyroot_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_PINK =
            registerBlockWithoutBlockItem("basket_tinker_skyroot_pink", () -> basket(DyeColor.PINK));


    private static @NotNull BasketBlock basket(DyeColor clothColor) {
        return new BasketBlock(clothColor,  BlockBehaviour.Properties.of(Material.WOOD)
                .sound(SoundType.WOOD).strength(1)
                .lightLevel((state) -> BasketBlock.lightLvl).noOcclusion());
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    @SuppressWarnings({"SameParameterValue", "unused"})
    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    @SuppressWarnings("UnusedReturnValue")
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return TBAItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(TBATab.TAB)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}