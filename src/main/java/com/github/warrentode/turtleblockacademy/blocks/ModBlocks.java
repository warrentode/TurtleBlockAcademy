package com.github.warrentode.turtleblockacademy.blocks;

import com.github.warrentode.turtleblockacademy.TurtleBlockAcademy;
import com.github.warrentode.turtleblockacademy.items.ModItems;
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

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> CERTIFICATE_BLOCK = registerBlock("certificate_block",
            () -> new CertificateBlock(BlockBehaviour.Properties.of(Material.PLANT)
                    .sound(TurtleBlockAcademy.CERTIFICATE).instabreak().noOcclusion()));


    public static final RegistryObject<Block> SCHOOL_DESK_OAK = registerBlock("school_desk_oak",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_BIRCH = registerBlock("school_desk_birch",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_SPRUCE = registerBlock("school_desk_spruce",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_JUNGLE = registerBlock("school_desk_jungle",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_ACACIA = registerBlock("school_desk_acacia",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_DARK_OAK = registerBlock("school_desk_dark_oak",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_MANGROVE = registerBlock("school_desk_mangrove",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_CRIMSON = registerBlock("school_desk_crimson",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_WARPED = registerBlock("school_desk_warped",
            () -> new SchoolDeskBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));


    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_OAK = registerBlock("school_desk_cabinet_oak",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_BIRCH = registerBlock("school_desk_cabinet_birch",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_SPRUCE = registerBlock("school_desk_cabinet_spruce",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_JUNGLE = registerBlock("school_desk_cabinet_jungle",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_ACACIA = registerBlock("school_desk_cabinet_acacia",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_DARK_OAK = registerBlock("school_desk_cabinet_dark_oak",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_MANGROVE = registerBlock("school_desk_cabinet_mangrove",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_CRIMSON = registerBlock("school_desk_cabinet_crimson",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> SCHOOL_DESK_CABINET_WARPED = registerBlock("school_desk_cabinet_warped",
            () -> new SchoolDeskCabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));


    public static final RegistryObject<Block> DESK_CHAIR_OAK = registerBlock("desk_chair_oak",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> DESK_CHAIR_BIRCH = registerBlock("desk_chair_birch",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> DESK_CHAIR_SPRUCE = registerBlock("desk_chair_spruce",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> DESK_CHAIR_JUNGLE = registerBlock("desk_chair_jungle",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> DESK_CHAIR_ACACIA = registerBlock("desk_chair_acacia",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> DESK_CHAIR_DARK_OAK = registerBlock("desk_chair_dark_oak",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> DESK_CHAIR_MANGROVE = registerBlock("desk_chair_mangrove",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> DESK_CHAIR_CRIMSON = registerBlock("desk_chair_crimson",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> DESK_CHAIR_WARPED = registerBlock("desk_chair_warped",
            () -> new DeskChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));


    public static final RegistryObject<Block> LOCKER_OAK = registerBlock("locker_oak",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> LOCKER_BIRCH = registerBlock("locker_birch",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> LOCKER_SPRUCE = registerBlock("locker_spruce",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> LOCKER_JUNGLE = registerBlock("locker_jungle",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> LOCKER_ACACIA = registerBlock("locker_acacia",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> LOCKER_DARK_OAK = registerBlock("locker_dark_oak",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> LOCKER_MANGROVE = registerBlock("locker_mangrove",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> LOCKER_CRIMSON = registerBlock("locker_crimson",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));

    public static final RegistryObject<Block> LOCKER_WARPED = registerBlock("locker_warped",
            () -> new SchoolLockerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD).instabreak().noOcclusion()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    @SuppressWarnings("UnusedReturnValue")
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(TurtleBlockAcademy.TAB)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
