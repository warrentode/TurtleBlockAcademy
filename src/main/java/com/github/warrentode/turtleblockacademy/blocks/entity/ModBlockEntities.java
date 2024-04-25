package com.github.warrentode.turtleblockacademy.blocks.entity;

import com.github.warrentode.turtleblockacademy.blocks.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);

    @SuppressWarnings("DataFlowIssue")
    public static final RegistryObject<BlockEntityType<SchoolDeskBlockEntity>> SCHOOL_DESK_ENTITY =
            BLOCK_ENTITIES.register("school_desk_entity",
                    () -> BlockEntityType.Builder.of(SchoolDeskBlockEntity::new,
                                    ModBlocks.SCHOOL_DESK_OAK.get(),
                                    ModBlocks.SCHOOL_DESK_BIRCH.get(),
                                    ModBlocks.SCHOOL_DESK_SPRUCE.get(),
                                    ModBlocks.SCHOOL_DESK_JUNGLE.get(),
                                    ModBlocks.SCHOOL_DESK_ACACIA.get(),
                                    ModBlocks.SCHOOL_DESK_DARK_OAK.get(),
                                    ModBlocks.SCHOOL_DESK_MANGROVE.get(),
                                    ModBlocks.SCHOOL_DESK_CRIMSON.get(),
                                    ModBlocks.SCHOOL_DESK_WARPED.get())
                            .build(null));

    @SuppressWarnings("DataFlowIssue")
    public static final RegistryObject<BlockEntityType<SchoolStorageEntity>> SCHOOL_STORAGE_ENTITY =
            BLOCK_ENTITIES.register("school_storage_entity",
                    () -> BlockEntityType.Builder.of(SchoolStorageEntity::new,
                                    ModBlocks.SCHOOL_DESK_CABINET_OAK.get(),
                                    ModBlocks.SCHOOL_DESK_CABINET_BIRCH.get(),
                                    ModBlocks.SCHOOL_DESK_CABINET_SPRUCE.get(),
                                    ModBlocks.SCHOOL_DESK_CABINET_JUNGLE.get(),
                                    ModBlocks.SCHOOL_DESK_CABINET_ACACIA.get(),
                                    ModBlocks.SCHOOL_DESK_CABINET_DARK_OAK.get(),
                                    ModBlocks.SCHOOL_DESK_CABINET_MANGROVE.get(),
                                    ModBlocks.SCHOOL_DESK_CABINET_CRIMSON.get(),
                                    ModBlocks.SCHOOL_DESK_CABINET_WARPED.get(),
                                    ModBlocks.LOCKER_OAK.get(),
                                    ModBlocks.LOCKER_BIRCH.get(),
                                    ModBlocks.LOCKER_SPRUCE.get(),
                                    ModBlocks.LOCKER_JUNGLE.get(),
                                    ModBlocks.LOCKER_ACACIA.get(),
                                    ModBlocks.LOCKER_DARK_OAK.get(),
                                    ModBlocks.LOCKER_MANGROVE.get(),
                                    ModBlocks.LOCKER_CRIMSON.get(),
                                    ModBlocks.LOCKER_WARPED.get())
                            .build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}