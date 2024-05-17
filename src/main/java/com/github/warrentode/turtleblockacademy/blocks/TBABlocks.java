package com.github.warrentode.turtleblockacademy.blocks;

import com.github.warrentode.turtleblockacademy.TurtleBlockAcademy;
import com.github.warrentode.turtleblockacademy.items.TBAItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TBABlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> CERTIFICATE_BLOCK = registerBlock("certificate_block",
            () -> new CertificateBlock(BlockBehaviour.Properties.of(Material.PLANT)
                    .sound(TurtleBlockAcademy.CERTIFICATE).strength(1).noOcclusion()));

   /* removed until I can fix portal for production environment
   public static final RegistryObject<Block> TBA_MINING_PORTAL =
            registerBlockWithoutBlockItem("mining_portal", TBAMiningPortalBlock::new); */

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

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    @SuppressWarnings("SameParameterValue")
    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    @SuppressWarnings("UnusedReturnValue")
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return TBAItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(TurtleBlockAcademy.TAB)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
