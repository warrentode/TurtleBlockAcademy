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
            registerBlock("basket_oak_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_OAK_LIGHT_GRAY =
            registerBlock("basket_oak_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_OAK_GRAY =
            registerBlock("basket_oak_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_OAK_BLACK =
            registerBlock("basket_oak_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_OAK_BROWN =
            registerBlock("basket_oak_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_OAK_RED =
            registerBlock("basket_oak_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_OAK_ORANGE =
            registerBlock("basket_oak_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_OAK_YELLOW =
            registerBlock("basket_oak_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_OAK_LIME =
            registerBlock("basket_oak_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_OAK_GREEN =
            registerBlock("basket_oak_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_OAK_CYAN =
            registerBlock("basket_oak_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_OAK_LIGHT_BLUE =
            registerBlock("basket_oak_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_OAK_BLUE =
            registerBlock("basket_oak_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_OAK_PURPLE =
            registerBlock("basket_oak_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_OAK_MAGENTA =
            registerBlock("basket_oak_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_OAK_PINK =
            registerBlock("basket_oak_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_BIRCH_WHITE =
            registerBlock("basket_birch_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_BIRCH_LIGHT_GRAY =
            registerBlock("basket_birch_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_BIRCH_GRAY =
            registerBlock("basket_birch_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_BIRCH_BLACK =
            registerBlock("basket_birch_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_BIRCH_BROWN =
            registerBlock("basket_birch_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_BIRCH_RED =
            registerBlock("basket_birch_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_BIRCH_ORANGE =
            registerBlock("basket_birch_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_BIRCH_YELLOW =
            registerBlock("basket_birch_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_BIRCH_LIME =
            registerBlock("basket_birch_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_BIRCH_GREEN =
            registerBlock("basket_birch_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_BIRCH_CYAN =
            registerBlock("basket_birch_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_BIRCH_LIGHT_BLUE =
            registerBlock("basket_birch_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_BIRCH_BLUE =
            registerBlock("basket_birch_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_BIRCH_PURPLE =
            registerBlock("basket_birch_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_BIRCH_MAGENTA =
            registerBlock("basket_birch_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_BIRCH_PINK =
            registerBlock("basket_birch_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_SPRUCE_WHITE =
            registerBlock("basket_spruce_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_SPRUCE_LIGHT_GRAY =
            registerBlock("basket_spruce_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_SPRUCE_GRAY =
            registerBlock("basket_spruce_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_SPRUCE_BLACK =
            registerBlock("basket_spruce_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_SPRUCE_BROWN =
            registerBlock("basket_spruce_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_SPRUCE_RED =
            registerBlock("basket_spruce_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_SPRUCE_ORANGE =
            registerBlock("basket_spruce_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_SPRUCE_YELLOW =
            registerBlock("basket_spruce_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_SPRUCE_LIME =
            registerBlock("basket_spruce_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_SPRUCE_GREEN =
            registerBlock("basket_spruce_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_SPRUCE_CYAN =
            registerBlock("basket_spruce_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_SPRUCE_LIGHT_BLUE =
            registerBlock("basket_spruce_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_SPRUCE_BLUE =
            registerBlock("basket_spruce_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_SPRUCE_PURPLE =
            registerBlock("basket_spruce_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_SPRUCE_MAGENTA =
            registerBlock("basket_spruce_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_SPRUCE_PINK =
            registerBlock("basket_spruce_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_JUNGLE_WHITE =
            registerBlock("basket_jungle_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_JUNGLE_LIGHT_GRAY =
            registerBlock("basket_jungle_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_JUNGLE_GRAY =
            registerBlock("basket_jungle_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_JUNGLE_BLACK =
            registerBlock("basket_jungle_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_JUNGLE_BROWN =
            registerBlock("basket_jungle_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_JUNGLE_RED =
            registerBlock("basket_jungle_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_JUNGLE_ORANGE =
            registerBlock("basket_jungle_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_JUNGLE_YELLOW =
            registerBlock("basket_jungle_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_JUNGLE_LIME =
            registerBlock("basket_jungle_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_JUNGLE_GREEN =
            registerBlock("basket_jungle_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_JUNGLE_CYAN =
            registerBlock("basket_jungle_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_JUNGLE_LIGHT_BLUE =
            registerBlock("basket_jungle_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_JUNGLE_BLUE =
            registerBlock("basket_jungle_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_JUNGLE_PURPLE =
            registerBlock("basket_jungle_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_JUNGLE_MAGENTA =
            registerBlock("basket_jungle_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_JUNGLE_PINK =
            registerBlock("basket_jungle_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_ACACIA_WHITE =
            registerBlock("basket_acacia_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_ACACIA_LIGHT_GRAY =
            registerBlock("basket_acacia_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_ACACIA_GRAY =
            registerBlock("basket_acacia_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_ACACIA_BLACK =
            registerBlock("basket_acacia_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_ACACIA_BROWN =
            registerBlock("basket_acacia_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_ACACIA_RED =
            registerBlock("basket_acacia_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_ACACIA_ORANGE =
            registerBlock("basket_acacia_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_ACACIA_YELLOW =
            registerBlock("basket_acacia_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_ACACIA_LIME =
            registerBlock("basket_acacia_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_ACACIA_GREEN =
            registerBlock("basket_acacia_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_ACACIA_CYAN =
            registerBlock("basket_acacia_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_ACACIA_LIGHT_BLUE =
            registerBlock("basket_acacia_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_ACACIA_BLUE =
            registerBlock("basket_acacia_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_ACACIA_PURPLE =
            registerBlock("basket_acacia_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_ACACIA_MAGENTA =
            registerBlock("basket_acacia_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_ACACIA_PINK =
            registerBlock("basket_acacia_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_DARK_OAK_WHITE =
            registerBlock("basket_dark_oak_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_DARK_OAK_LIGHT_GRAY =
            registerBlock("basket_dark_oak_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_DARK_OAK_GRAY =
            registerBlock("basket_dark_oak_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_DARK_OAK_BLACK =
            registerBlock("basket_dark_oak_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_DARK_OAK_BROWN =
            registerBlock("basket_dark_oak_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_DARK_OAK_RED =
            registerBlock("basket_dark_oak_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_DARK_OAK_ORANGE =
            registerBlock("basket_dark_oak_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_DARK_OAK_YELLOW =
            registerBlock("basket_dark_oak_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_DARK_OAK_LIME =
            registerBlock("basket_dark_oak_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_DARK_OAK_GREEN =
            registerBlock("basket_dark_oak_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_DARK_OAK_CYAN =
            registerBlock("basket_dark_oak_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_DARK_OAK_LIGHT_BLUE =
            registerBlock("basket_dark_oak_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_DARK_OAK_BLUE =
            registerBlock("basket_dark_oak_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_DARK_OAK_PURPLE =
            registerBlock("basket_dark_oak_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_DARK_OAK_MAGENTA =
            registerBlock("basket_dark_oak_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_DARK_OAK_PINK =
            registerBlock("basket_dark_oak_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_MANGROVE_WHITE =
            registerBlock("basket_mangrove_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_MANGROVE_LIGHT_GRAY =
            registerBlock("basket_mangrove_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_MANGROVE_GRAY =
            registerBlock("basket_mangrove_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_MANGROVE_BLACK =
            registerBlock("basket_mangrove_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_MANGROVE_BROWN =
            registerBlock("basket_mangrove_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_MANGROVE_RED =
            registerBlock("basket_mangrove_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_MANGROVE_ORANGE =
            registerBlock("basket_mangrove_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_MANGROVE_YELLOW =
            registerBlock("basket_mangrove_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_MANGROVE_LIME =
            registerBlock("basket_mangrove_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_MANGROVE_GREEN =
            registerBlock("basket_mangrove_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_MANGROVE_CYAN =
            registerBlock("basket_mangrove_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_MANGROVE_LIGHT_BLUE =
            registerBlock("basket_mangrove_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_MANGROVE_BLUE =
            registerBlock("basket_mangrove_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_MANGROVE_PURPLE =
            registerBlock("basket_mangrove_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_MANGROVE_MAGENTA =
            registerBlock("basket_mangrove_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_MANGROVE_PINK =
            registerBlock("basket_mangrove_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_CRIMSON_WHITE =
            registerBlock("basket_crimson_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_CRIMSON_LIGHT_GRAY =
            registerBlock("basket_crimson_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_CRIMSON_GRAY =
            registerBlock("basket_crimson_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_CRIMSON_BLACK =
            registerBlock("basket_crimson_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_CRIMSON_BROWN =
            registerBlock("basket_crimson_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_CRIMSON_RED =
            registerBlock("basket_crimson_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_CRIMSON_ORANGE =
            registerBlock("basket_crimson_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_CRIMSON_YELLOW =
            registerBlock("basket_crimson_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_CRIMSON_LIME =
            registerBlock("basket_crimson_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_CRIMSON_GREEN =
            registerBlock("basket_crimson_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_CRIMSON_CYAN =
            registerBlock("basket_crimson_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_CRIMSON_LIGHT_BLUE =
            registerBlock("basket_crimson_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_CRIMSON_BLUE =
            registerBlock("basket_crimson_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_CRIMSON_PURPLE =
            registerBlock("basket_crimson_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_CRIMSON_MAGENTA =
            registerBlock("basket_crimson_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_CRIMSON_PINK =
            registerBlock("basket_crimson_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_WARPED_WHITE =
            registerBlock("basket_warped_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_WARPED_LIGHT_GRAY =
            registerBlock("basket_warped_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_WARPED_GRAY =
            registerBlock("basket_warped_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_WARPED_BLACK =
            registerBlock("basket_warped_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_WARPED_BROWN =
            registerBlock("basket_warped_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_WARPED_RED =
            registerBlock("basket_warped_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_WARPED_ORANGE =
            registerBlock("basket_warped_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_WARPED_YELLOW =
            registerBlock("basket_warped_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_WARPED_LIME =
            registerBlock("basket_warped_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_WARPED_GREEN =
            registerBlock("basket_warped_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_WARPED_CYAN =
            registerBlock("basket_warped_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_WARPED_LIGHT_BLUE =
            registerBlock("basket_warped_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_WARPED_BLUE =
            registerBlock("basket_warped_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_WARPED_PURPLE =
            registerBlock("basket_warped_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_WARPED_MAGENTA =
            registerBlock("basket_warped_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_WARPED_PINK =
            registerBlock("basket_warped_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_FIR_WHITE =
            registerBlock("basket_fir_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_FIR_LIGHT_GRAY =
            registerBlock("basket_fir_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_FIR_GRAY =
            registerBlock("basket_fir_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_FIR_BLACK =
            registerBlock("basket_fir_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_FIR_BROWN =
            registerBlock("basket_fir_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_FIR_RED =
            registerBlock("basket_fir_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_FIR_ORANGE =
            registerBlock("basket_fir_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_FIR_YELLOW =
            registerBlock("basket_fir_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_FIR_LIME =
            registerBlock("basket_fir_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_FIR_GREEN =
            registerBlock("basket_fir_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_FIR_CYAN =
            registerBlock("basket_fir_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_FIR_LIGHT_BLUE =
            registerBlock("basket_fir_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_FIR_BLUE =
            registerBlock("basket_fir_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_FIR_PURPLE =
            registerBlock("basket_fir_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_FIR_MAGENTA =
            registerBlock("basket_fir_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_FIR_PINK =
            registerBlock("basket_fir_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_REDWOOD_WHITE =
            registerBlock("basket_redwood_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_REDWOOD_LIGHT_GRAY =
            registerBlock("basket_redwood_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_REDWOOD_GRAY =
            registerBlock("basket_redwood_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_REDWOOD_BLACK =
            registerBlock("basket_redwood_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_REDWOOD_BROWN =
            registerBlock("basket_redwood_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_REDWOOD_RED =
            registerBlock("basket_redwood_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_REDWOOD_ORANGE =
            registerBlock("basket_redwood_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_REDWOOD_YELLOW =
            registerBlock("basket_redwood_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_REDWOOD_LIME =
            registerBlock("basket_redwood_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_REDWOOD_GREEN =
            registerBlock("basket_redwood_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_REDWOOD_CYAN =
            registerBlock("basket_redwood_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_REDWOOD_LIGHT_BLUE =
            registerBlock("basket_redwood_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_REDWOOD_BLUE =
            registerBlock("basket_redwood_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_REDWOOD_PURPLE =
            registerBlock("basket_redwood_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_REDWOOD_MAGENTA =
            registerBlock("basket_redwood_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_REDWOOD_PINK =
            registerBlock("basket_redwood_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_CHERRY_WHITE =
            registerBlock("basket_cherry_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_CHERRY_LIGHT_GRAY =
            registerBlock("basket_cherry_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_CHERRY_GRAY =
            registerBlock("basket_cherry_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_CHERRY_BLACK =
            registerBlock("basket_cherry_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_CHERRY_BROWN =
            registerBlock("basket_cherry_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_CHERRY_RED =
            registerBlock("basket_cherry_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_CHERRY_ORANGE =
            registerBlock("basket_cherry_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_CHERRY_YELLOW =
            registerBlock("basket_cherry_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_CHERRY_LIME =
            registerBlock("basket_cherry_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_CHERRY_GREEN =
            registerBlock("basket_cherry_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_CHERRY_CYAN =
            registerBlock("basket_cherry_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_CHERRY_LIGHT_BLUE =
            registerBlock("basket_cherry_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_CHERRY_BLUE =
            registerBlock("basket_cherry_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_CHERRY_PURPLE =
            registerBlock("basket_cherry_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_CHERRY_MAGENTA =
            registerBlock("basket_cherry_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_CHERRY_PINK =
            registerBlock("basket_cherry_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_MAHOGANY_WHITE =
            registerBlock("basket_mahogany_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_MAHOGANY_LIGHT_GRAY =
            registerBlock("basket_mahogany_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_MAHOGANY_GRAY =
            registerBlock("basket_mahogany_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_MAHOGANY_BLACK =
            registerBlock("basket_mahogany_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_MAHOGANY_BROWN =
            registerBlock("basket_mahogany_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_MAHOGANY_RED =
            registerBlock("basket_mahogany_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_MAHOGANY_ORANGE =
            registerBlock("basket_mahogany_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_MAHOGANY_YELLOW =
            registerBlock("basket_mahogany_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_MAHOGANY_LIME =
            registerBlock("basket_mahogany_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_MAHOGANY_GREEN =
            registerBlock("basket_mahogany_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_MAHOGANY_CYAN =
            registerBlock("basket_mahogany_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_MAHOGANY_LIGHT_BLUE =
            registerBlock("basket_mahogany_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_MAHOGANY_BLUE =
            registerBlock("basket_mahogany_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_MAHOGANY_PURPLE =
            registerBlock("basket_mahogany_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_MAHOGANY_MAGENTA =
            registerBlock("basket_mahogany_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_MAHOGANY_PINK =
            registerBlock("basket_mahogany_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_JACARANDA_WHITE =
            registerBlock("basket_jacaranda_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_JACARANDA_LIGHT_GRAY =
            registerBlock("basket_jacaranda_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_JACARANDA_GRAY =
            registerBlock("basket_jacaranda_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_JACARANDA_BLACK =
            registerBlock("basket_jacaranda_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_JACARANDA_BROWN =
            registerBlock("basket_jacaranda_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_JACARANDA_RED =
            registerBlock("basket_jacaranda_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_JACARANDA_ORANGE =
            registerBlock("basket_jacaranda_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_JACARANDA_YELLOW =
            registerBlock("basket_jacaranda_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_JACARANDA_LIME =
            registerBlock("basket_jacaranda_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_JACARANDA_GREEN =
            registerBlock("basket_jacaranda_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_JACARANDA_CYAN =
            registerBlock("basket_jacaranda_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_JACARANDA_LIGHT_BLUE =
            registerBlock("basket_jacaranda_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_JACARANDA_BLUE =
            registerBlock("basket_jacaranda_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_JACARANDA_PURPLE =
            registerBlock("basket_jacaranda_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_JACARANDA_MAGENTA =
            registerBlock("basket_jacaranda_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_JACARANDA_PINK =
            registerBlock("basket_jacaranda_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_PALM_WHITE =
            registerBlock("basket_palm_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_PALM_LIGHT_GRAY =
            registerBlock("basket_palm_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_PALM_GRAY =
            registerBlock("basket_palm_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_PALM_BLACK =
            registerBlock("basket_palm_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_PALM_BROWN =
            registerBlock("basket_palm_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_PALM_RED =
            registerBlock("basket_palm_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_PALM_ORANGE =
            registerBlock("basket_palm_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_PALM_YELLOW =
            registerBlock("basket_palm_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_PALM_LIME =
            registerBlock("basket_palm_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_PALM_GREEN =
            registerBlock("basket_palm_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_PALM_CYAN =
            registerBlock("basket_palm_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_PALM_LIGHT_BLUE =
            registerBlock("basket_palm_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_PALM_BLUE =
            registerBlock("basket_palm_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_PALM_PURPLE =
            registerBlock("basket_palm_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_PALM_MAGENTA =
            registerBlock("basket_palm_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_PALM_PINK =
            registerBlock("basket_palm_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_WILLOW_WHITE =
            registerBlock("basket_willow_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_WILLOW_LIGHT_GRAY =
            registerBlock("basket_willow_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_WILLOW_GRAY =
            registerBlock("basket_willow_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_WILLOW_BLACK =
            registerBlock("basket_willow_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_WILLOW_BROWN =
            registerBlock("basket_willow_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_WILLOW_RED =
            registerBlock("basket_willow_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_WILLOW_ORANGE =
            registerBlock("basket_willow_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_WILLOW_YELLOW =
            registerBlock("basket_willow_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_WILLOW_LIME =
            registerBlock("basket_willow_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_WILLOW_GREEN =
            registerBlock("basket_willow_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_WILLOW_CYAN =
            registerBlock("basket_willow_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_WILLOW_LIGHT_BLUE =
            registerBlock("basket_willow_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_WILLOW_BLUE =
            registerBlock("basket_willow_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_WILLOW_PURPLE =
            registerBlock("basket_willow_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_WILLOW_MAGENTA =
            registerBlock("basket_willow_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_WILLOW_PINK =
            registerBlock("basket_willow_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_DEAD_WHITE =
            registerBlock("basket_dead_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_DEAD_LIGHT_GRAY =
            registerBlock("basket_dead_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_DEAD_GRAY =
            registerBlock("basket_dead_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_DEAD_BLACK =
            registerBlock("basket_dead_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_DEAD_BROWN =
            registerBlock("basket_dead_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_DEAD_RED =
            registerBlock("basket_dead_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_DEAD_ORANGE =
            registerBlock("basket_dead_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_DEAD_YELLOW =
            registerBlock("basket_dead_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_DEAD_LIME =
            registerBlock("basket_dead_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_DEAD_GREEN =
            registerBlock("basket_dead_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_DEAD_CYAN =
            registerBlock("basket_dead_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_DEAD_LIGHT_BLUE =
            registerBlock("basket_dead_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_DEAD_BLUE =
            registerBlock("basket_dead_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_DEAD_PURPLE =
            registerBlock("basket_dead_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_DEAD_MAGENTA =
            registerBlock("basket_dead_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_DEAD_PINK =
            registerBlock("basket_dead_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_MAGIC_WHITE =
            registerBlock("basket_magic_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_MAGIC_LIGHT_GRAY =
            registerBlock("basket_magic_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_MAGIC_GRAY =
            registerBlock("basket_magic_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_MAGIC_BLACK =
            registerBlock("basket_magic_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_MAGIC_BROWN =
            registerBlock("basket_magic_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_MAGIC_RED =
            registerBlock("basket_magic_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_MAGIC_ORANGE =
            registerBlock("basket_magic_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_MAGIC_YELLOW =
            registerBlock("basket_magic_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_MAGIC_LIME =
            registerBlock("basket_magic_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_MAGIC_GREEN =
            registerBlock("basket_magic_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_MAGIC_CYAN =
            registerBlock("basket_magic_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_MAGIC_LIGHT_BLUE =
            registerBlock("basket_magic_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_MAGIC_BLUE =
            registerBlock("basket_magic_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_MAGIC_PURPLE =
            registerBlock("basket_magic_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_MAGIC_MAGENTA =
            registerBlock("basket_magic_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_MAGIC_PINK =
            registerBlock("basket_magic_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_UMBRAN_WHITE =
            registerBlock("basket_umbran_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_UMBRAN_LIGHT_GRAY =
            registerBlock("basket_umbran_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_UMBRAN_GRAY =
            registerBlock("basket_umbran_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_UMBRAN_BLACK =
            registerBlock("basket_umbran_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_UMBRAN_BROWN =
            registerBlock("basket_umbran_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_UMBRAN_RED =
            registerBlock("basket_umbran_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_UMBRAN_ORANGE =
            registerBlock("basket_umbran_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_UMBRAN_YELLOW =
            registerBlock("basket_umbran_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_UMBRAN_LIME =
            registerBlock("basket_umbran_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_UMBRAN_GREEN =
            registerBlock("basket_umbran_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_UMBRAN_CYAN =
            registerBlock("basket_umbran_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_UMBRAN_LIGHT_BLUE =
            registerBlock("basket_umbran_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_UMBRAN_BLUE =
            registerBlock("basket_umbran_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_UMBRAN_PURPLE =
            registerBlock("basket_umbran_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_UMBRAN_MAGENTA =
            registerBlock("basket_umbran_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_UMBRAN_PINK =
            registerBlock("basket_umbran_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_HELLBARK_WHITE =
            registerBlock("basket_hellbark_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_HELLBARK_LIGHT_GRAY =
            registerBlock("basket_hellbark_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_HELLBARK_GRAY =
            registerBlock("basket_hellbark_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_HELLBARK_BLACK =
            registerBlock("basket_hellbark_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_HELLBARK_BROWN =
            registerBlock("basket_hellbark_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_HELLBARK_RED =
            registerBlock("basket_hellbark_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_HELLBARK_ORANGE =
            registerBlock("basket_hellbark_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_HELLBARK_YELLOW =
            registerBlock("basket_hellbark_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_HELLBARK_LIME =
            registerBlock("basket_hellbark_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_HELLBARK_GREEN =
            registerBlock("basket_hellbark_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_HELLBARK_CYAN =
            registerBlock("basket_hellbark_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_HELLBARK_LIGHT_BLUE =
            registerBlock("basket_hellbark_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_HELLBARK_BLUE =
            registerBlock("basket_hellbark_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_HELLBARK_PURPLE =
            registerBlock("basket_hellbark_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_HELLBARK_MAGENTA =
            registerBlock("basket_hellbark_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_HELLBARK_PINK =
            registerBlock("basket_hellbark_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_COCONUT_WHITE =
            registerBlock("basket_coconut_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_COCONUT_LIGHT_GRAY =
            registerBlock("basket_coconut_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_COCONUT_GRAY =
            registerBlock("basket_coconut_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_COCONUT_BLACK =
            registerBlock("basket_coconut_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_COCONUT_BROWN =
            registerBlock("basket_coconut_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_COCONUT_RED =
            registerBlock("basket_coconut_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_COCONUT_ORANGE =
            registerBlock("basket_coconut_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_COCONUT_YELLOW =
            registerBlock("basket_coconut_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_COCONUT_LIME =
            registerBlock("basket_coconut_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_COCONUT_GREEN =
            registerBlock("basket_coconut_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_COCONUT_CYAN =
            registerBlock("basket_coconut_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_COCONUT_LIGHT_BLUE =
            registerBlock("basket_coconut_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_COCONUT_BLUE =
            registerBlock("basket_coconut_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_COCONUT_PURPLE =
            registerBlock("basket_coconut_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_COCONUT_MAGENTA =
            registerBlock("basket_coconut_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_COCONUT_PINK =
            registerBlock("basket_coconut_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_WALNUT_WHITE =
            registerBlock("basket_walnut_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_WALNUT_LIGHT_GRAY =
            registerBlock("basket_walnut_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_WALNUT_GRAY =
            registerBlock("basket_walnut_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_WALNUT_BLACK =
            registerBlock("basket_walnut_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_WALNUT_BROWN =
            registerBlock("basket_walnut_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_WALNUT_RED =
            registerBlock("basket_walnut_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_WALNUT_ORANGE =
            registerBlock("basket_walnut_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_WALNUT_YELLOW =
            registerBlock("basket_walnut_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_WALNUT_LIME =
            registerBlock("basket_walnut_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_WALNUT_GREEN =
            registerBlock("basket_walnut_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_WALNUT_CYAN =
            registerBlock("basket_walnut_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_WALNUT_LIGHT_BLUE =
            registerBlock("basket_walnut_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_WALNUT_BLUE =
            registerBlock("basket_walnut_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_WALNUT_PURPLE =
            registerBlock("basket_walnut_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_WALNUT_MAGENTA =
            registerBlock("basket_walnut_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_WALNUT_PINK =
            registerBlock("basket_walnut_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_AZALEA_WHITE =
            registerBlock("basket_azalea_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_AZALEA_LIGHT_GRAY =
            registerBlock("basket_azalea_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_AZALEA_GRAY =
            registerBlock("basket_azalea_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_AZALEA_BLACK =
            registerBlock("basket_azalea_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_AZALEA_BROWN =
            registerBlock("basket_azalea_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_AZALEA_RED =
            registerBlock("basket_azalea_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_AZALEA_ORANGE =
            registerBlock("basket_azalea_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_AZALEA_YELLOW =
            registerBlock("basket_azalea_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_AZALEA_LIME =
            registerBlock("basket_azalea_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_AZALEA_GREEN =
            registerBlock("basket_azalea_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_AZALEA_CYAN =
            registerBlock("basket_azalea_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_AZALEA_LIGHT_BLUE =
            registerBlock("basket_azalea_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_AZALEA_BLUE =
            registerBlock("basket_azalea_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_AZALEA_PURPLE =
            registerBlock("basket_azalea_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_AZALEA_MAGENTA =
            registerBlock("basket_azalea_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_AZALEA_PINK =
            registerBlock("basket_azalea_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_WHITE =
            registerBlock("basket_flowering_azalea_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_LIGHT_GRAY =
            registerBlock("basket_flowering_azalea_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_GRAY =
            registerBlock("basket_flowering_azalea_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_BLACK =
            registerBlock("basket_flowering_azalea_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_BROWN =
            registerBlock("basket_flowering_azalea_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_RED =
            registerBlock("basket_flowering_azalea_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_ORANGE =
            registerBlock("basket_flowering_azalea_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_YELLOW =
            registerBlock("basket_flowering_azalea_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_LIME =
            registerBlock("basket_flowering_azalea_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_GREEN =
            registerBlock("basket_flowering_azalea_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_CYAN =
            registerBlock("basket_flowering_azalea_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_LIGHT_BLUE =
            registerBlock("basket_flowering_azalea_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_BLUE =
            registerBlock("basket_flowering_azalea_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_PURPLE =
            registerBlock("basket_flowering_azalea_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_MAGENTA =
            registerBlock("basket_flowering_azalea_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_FLOWERING_AZALEA_PINK =
            registerBlock("basket_flowering_azalea_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_WHITE =
            registerBlock("basket_aether_skyroot_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_LIGHT_GRAY =
            registerBlock("basket_aether_skyroot_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_GRAY =
            registerBlock("basket_aether_skyroot_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_BLACK =
            registerBlock("basket_aether_skyroot_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_BROWN =
            registerBlock("basket_aether_skyroot_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_RED =
            registerBlock("basket_aether_skyroot_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_ORANGE =
            registerBlock("basket_aether_skyroot_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_YELLOW =
            registerBlock("basket_aether_skyroot_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_LIME =
            registerBlock("basket_aether_skyroot_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_GREEN =
            registerBlock("basket_aether_skyroot_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_CYAN =
            registerBlock("basket_aether_skyroot_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_LIGHT_BLUE =
            registerBlock("basket_aether_skyroot_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_BLUE =
            registerBlock("basket_aether_skyroot_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_PURPLE =
            registerBlock("basket_aether_skyroot_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_MAGENTA =
            registerBlock("basket_aether_skyroot_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_AETHER_SKYROOT_PINK =
            registerBlock("basket_aether_skyroot_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_PREAM_WHITE =
            registerBlock("basket_pream_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_PREAM_LIGHT_GRAY =
            registerBlock("basket_pream_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_PREAM_GRAY =
            registerBlock("basket_pream_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_PREAM_BLACK =
            registerBlock("basket_pream_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_PREAM_BROWN =
            registerBlock("basket_pream_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_PREAM_RED =
            registerBlock("basket_pream_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_PREAM_ORANGE =
            registerBlock("basket_pream_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_PREAM_YELLOW =
            registerBlock("basket_pream_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_PREAM_LIME =
            registerBlock("basket_pream_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_PREAM_GREEN =
            registerBlock("basket_pream_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_PREAM_CYAN =
            registerBlock("basket_pream_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_PREAM_LIGHT_BLUE =
            registerBlock("basket_pream_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_PREAM_BLUE =
            registerBlock("basket_pream_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_PREAM_PURPLE =
            registerBlock("basket_pream_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_PREAM_MAGENTA =
            registerBlock("basket_pream_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_PREAM_PINK =
            registerBlock("basket_pream_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_EBONY_WHITE =
            registerBlock("basket_ebony_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_EBONY_LIGHT_GRAY =
            registerBlock("basket_ebony_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_EBONY_GRAY =
            registerBlock("basket_ebony_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_EBONY_BLACK =
            registerBlock("basket_ebony_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_EBONY_BROWN =
            registerBlock("basket_ebony_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_EBONY_RED =
            registerBlock("basket_ebony_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_EBONY_ORANGE =
            registerBlock("basket_ebony_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_EBONY_YELLOW =
            registerBlock("basket_ebony_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_EBONY_LIME =
            registerBlock("basket_ebony_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_EBONY_GREEN =
            registerBlock("basket_ebony_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_EBONY_CYAN =
            registerBlock("basket_ebony_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_EBONY_LIGHT_BLUE =
            registerBlock("basket_ebony_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_EBONY_BLUE =
            registerBlock("basket_ebony_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_EBONY_PURPLE =
            registerBlock("basket_ebony_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_EBONY_MAGENTA =
            registerBlock("basket_ebony_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_EBONY_PINK =
            registerBlock("basket_ebony_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_WHITE =
            registerBlock("basket_chorus_nest_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_LIGHT_GRAY =
            registerBlock("basket_chorus_nest_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_GRAY =
            registerBlock("basket_chorus_nest_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_BLACK =
            registerBlock("basket_chorus_nest_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_BROWN =
            registerBlock("basket_chorus_nest_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_RED =
            registerBlock("basket_chorus_nest_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_ORANGE =
            registerBlock("basket_chorus_nest_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_YELLOW =
            registerBlock("basket_chorus_nest_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_LIME =
            registerBlock("basket_chorus_nest_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_GREEN =
            registerBlock("basket_chorus_nest_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_CYAN =
            registerBlock("basket_chorus_nest_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_LIGHT_BLUE =
            registerBlock("basket_chorus_nest_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_BLUE =
            registerBlock("basket_chorus_nest_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_PURPLE =
            registerBlock("basket_chorus_nest_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_MAGENTA =
            registerBlock("basket_chorus_nest_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_CHORUS_NEST_PINK =
            registerBlock("basket_chorus_nest_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_WHITE =
            registerBlock("basket_bloodshroom_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_LIGHT_GRAY =
            registerBlock("basket_bloodshroom_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_GRAY =
            registerBlock("basket_bloodshroom_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_BLACK =
            registerBlock("basket_bloodshroom_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_BROWN =
            registerBlock("basket_bloodshroom_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_RED =
            registerBlock("basket_bloodshroom_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_ORANGE =
            registerBlock("basket_bloodshroom_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_YELLOW =
            registerBlock("basket_bloodshroom_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_LIME =
            registerBlock("basket_bloodshroom_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_GREEN =
            registerBlock("basket_bloodshroom_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_CYAN =
            registerBlock("basket_bloodshroom_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_LIGHT_BLUE =
            registerBlock("basket_bloodshroom_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_BLUE =
            registerBlock("basket_bloodshroom_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_PURPLE =
            registerBlock("basket_bloodshroom_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_MAGENTA =
            registerBlock("basket_bloodshroom_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_BLOODSHROOM_PINK =
            registerBlock("basket_bloodshroom_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_ENDERBARK_WHITE =
            registerBlock("basket_enderbark_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_ENDERBARK_LIGHT_GRAY =
            registerBlock("basket_enderbark_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_ENDERBARK_GRAY =
            registerBlock("basket_enderbark_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_ENDERBARK_BLACK =
            registerBlock("basket_enderbark_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_ENDERBARK_BROWN =
            registerBlock("basket_enderbark_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_ENDERBARK_RED =
            registerBlock("basket_enderbark_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_ENDERBARK_ORANGE =
            registerBlock("basket_enderbark_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_ENDERBARK_YELLOW =
            registerBlock("basket_enderbark_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_ENDERBARK_LIME =
            registerBlock("basket_enderbark_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_ENDERBARK_GREEN =
            registerBlock("basket_enderbark_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_ENDERBARK_CYAN =
            registerBlock("basket_enderbark_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_ENDERBARK_LIGHT_BLUE =
            registerBlock("basket_enderbark_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_ENDERBARK_BLUE =
            registerBlock("basket_enderbark_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_ENDERBARK_PURPLE =
            registerBlock("basket_enderbark_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_ENDERBARK_MAGENTA =
            registerBlock("basket_enderbark_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_ENDERBARK_PINK =
            registerBlock("basket_enderbark_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_GREENHEART_WHITE =
            registerBlock("basket_greenheart_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_GREENHEART_LIGHT_GRAY =
            registerBlock("basket_greenheart_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_GREENHEART_GRAY =
            registerBlock("basket_greenheart_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_GREENHEART_BLACK =
            registerBlock("basket_greenheart_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_GREENHEART_BROWN =
            registerBlock("basket_greenheart_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_GREENHEART_RED =
            registerBlock("basket_greenheart_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_GREENHEART_ORANGE =
            registerBlock("basket_greenheart_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_GREENHEART_YELLOW =
            registerBlock("basket_greenheart_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_GREENHEART_LIME =
            registerBlock("basket_greenheart_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_GREENHEART_GREEN =
            registerBlock("basket_greenheart_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_GREENHEART_CYAN =
            registerBlock("basket_greenheart_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_GREENHEART_LIGHT_BLUE =
            registerBlock("basket_greenheart_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_GREENHEART_BLUE =
            registerBlock("basket_greenheart_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_GREENHEART_PURPLE =
            registerBlock("basket_greenheart_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_GREENHEART_MAGENTA =
            registerBlock("basket_greenheart_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_GREENHEART_PINK =
            registerBlock("basket_greenheart_pink", () -> basket(DyeColor.PINK));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_WHITE =
            registerBlock("basket_tinker_skyroot_white", () -> basket(DyeColor.WHITE));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_LIGHT_GRAY =
            registerBlock("basket_tinker_skyroot_light_gray", () -> basket(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_GRAY =
            registerBlock("basket_tinker_skyroot_gray", () -> basket(DyeColor.GRAY));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_BLACK =
            registerBlock("basket_tinker_skyroot_black", () -> basket(DyeColor.BLACK));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_BROWN =
            registerBlock("basket_tinker_skyroot_brown", () -> basket(DyeColor.BROWN));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_RED =
            registerBlock("basket_tinker_skyroot_red", () -> basket(DyeColor.RED));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_ORANGE =
            registerBlock("basket_tinker_skyroot_orange", () -> basket(DyeColor.ORANGE));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_YELLOW =
            registerBlock("basket_tinker_skyroot_yellow", () -> basket(DyeColor.YELLOW));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_LIME =
            registerBlock("basket_tinker_skyroot_lime", () -> basket(DyeColor.LIME));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_GREEN =
            registerBlock("basket_tinker_skyroot_green", () -> basket(DyeColor.GREEN));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_CYAN =
            registerBlock("basket_tinker_skyroot_cyan", () -> basket(DyeColor.CYAN));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_LIGHT_BLUE =
            registerBlock("basket_tinker_skyroot_light_blue", () -> basket(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_BLUE =
            registerBlock("basket_tinker_skyroot_blue", () -> basket(DyeColor.BLUE));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_PURPLE =
            registerBlock("basket_tinker_skyroot_purple", () -> basket(DyeColor.PURPLE));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_MAGENTA =
            registerBlock("basket_tinker_skyroot_magenta", () -> basket(DyeColor.MAGENTA));
    public static final RegistryObject<Block> BASKET_TINKER_SKYROOT_PINK =
            registerBlock("basket_tinker_skyroot_pink", () -> basket(DyeColor.PINK));


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