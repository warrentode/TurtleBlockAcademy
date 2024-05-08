package com.github.warrentode.turtleblockacademy.blocks.entity;

import com.github.warrentode.turtleblockacademy.blocks.ModBlockRegistry;
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
    public static final RegistryObject<BlockEntityType<PlateBlockEntity>> PLATE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("plate_block_entity",
                    () -> BlockEntityType.Builder.of(PlateBlockEntity::new,
                                    ModBlockRegistry.PLATE_WHITE.get(),
                                    ModBlockRegistry.PLATE_ORANGE.get(),
                                    ModBlockRegistry.PLATE_MAGENTA.get(),
                                    ModBlockRegistry.PLATE_LIGHT_BLUE.get(),
                                    ModBlockRegistry.PLATE_YELLOW.get(),
                                    ModBlockRegistry.PLATE_LIME.get(),
                                    ModBlockRegistry.PLATE_PINK.get(),
                                    ModBlockRegistry.PLATE_GRAY.get(),
                                    ModBlockRegistry.PLATE_LIGHT_GRAY.get(),
                                    ModBlockRegistry.PLATE_CYAN.get(),
                                    ModBlockRegistry.PLATE_PURPLE.get(),
                                    ModBlockRegistry.PLATE_BLUE.get(),
                                    ModBlockRegistry.PLATE_BROWN.get(),
                                    ModBlockRegistry.PLATE_GREEN.get(),
                                    ModBlockRegistry.PLATE_RED.get(),
                                    ModBlockRegistry.PLATE_BLACK.get()
                            )
                            .build(null));

    @SuppressWarnings("DataFlowIssue")
    public static final RegistryObject<BlockEntityType<SchoolDeskBlockEntity>> SCHOOL_DESK_ENTITY =
            BLOCK_ENTITIES.register("school_desk_entity",
                    () -> BlockEntityType.Builder.of(SchoolDeskBlockEntity::new,
                                    ModBlockRegistry.SCHOOL_DESK_OAK.get(),
                                    ModBlockRegistry.SCHOOL_DESK_BIRCH.get(),
                                    ModBlockRegistry.SCHOOL_DESK_SPRUCE.get(),
                                    ModBlockRegistry.SCHOOL_DESK_JUNGLE.get(),
                                    ModBlockRegistry.SCHOOL_DESK_ACACIA.get(),
                                    ModBlockRegistry.SCHOOL_DESK_DARK_OAK.get(),
                                    ModBlockRegistry.SCHOOL_DESK_MANGROVE.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CRIMSON.get(),
                                    ModBlockRegistry.SCHOOL_DESK_WARPED.get(),
                                    ModBlockRegistry.SCHOOL_DESK_FIR.get(),
                                    ModBlockRegistry.SCHOOL_DESK_REDWOOD.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CHERRY.get(),
                                    ModBlockRegistry.SCHOOL_DESK_MAHOGANY.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_MAHOGANY.get(),
                                    ModBlockRegistry.LOCKER_MAHOGANY.get(),
                                    ModBlockRegistry.SCHOOL_DESK_JACARANDA.get(),
                                    ModBlockRegistry.SCHOOL_DESK_PALM.get(),
                                    ModBlockRegistry.SCHOOL_DESK_WILLOW.get(),
                                    ModBlockRegistry.SCHOOL_DESK_DEAD.get(),
                                    ModBlockRegistry.SCHOOL_DESK_MAGIC.get(),
                                    ModBlockRegistry.SCHOOL_DESK_UMBRAN.get(),
                                    ModBlockRegistry.SCHOOL_DESK_HELLBARK.get(),
                                    ModBlockRegistry.SCHOOL_DESK_COCONUT.get(),
                                    ModBlockRegistry.SCHOOL_DESK_WALNUT.get(),
                                    ModBlockRegistry.SCHOOL_DESK_AZALEA.get(),
                                    ModBlockRegistry.SCHOOL_DESK_FLOWERING_AZALEA.get(),
                                    ModBlockRegistry.SCHOOL_DESK_GOLDEN_OAK.get(),
                                    ModBlockRegistry.SCHOOL_DESK_AETHER_SKYROOT.get(),
                                    ModBlockRegistry.SCHOOL_DESK_PREAM.get(),
                                    ModBlockRegistry.SCHOOL_DESK_EBONY.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CHORUS_NEST.get(),
                                    ModBlockRegistry.SCHOOL_DESK_BLOODSHROOM.get(),
                                    ModBlockRegistry.SCHOOL_DESK_ENDERBARK.get(),
                                    ModBlockRegistry.SCHOOL_DESK_GREENHEART.get(),
                                    ModBlockRegistry.SCHOOL_DESK_TINKER_SKYROOT.get()
                            )
                            .build(null));

    @SuppressWarnings("DataFlowIssue")
    public static final RegistryObject<BlockEntityType<SchoolStorageEntity>> SCHOOL_STORAGE_ENTITY =
            BLOCK_ENTITIES.register("school_storage_entity",
                    () -> BlockEntityType.Builder.of(SchoolStorageEntity::new,
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_GREENHEART.get(),
                                    ModBlockRegistry.LOCKER_GREENHEART.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_TINKER_SKYROOT.get(),
                                    ModBlockRegistry.LOCKER_TINKER_SKYROOT.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_BLOODSHROOM.get(),
                                    ModBlockRegistry.LOCKER_BLOODSHROOM.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_ENDERBARK.get(),
                                    ModBlockRegistry.LOCKER_ENDERBARK.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_CHORUS_NEST.get(),
                                    ModBlockRegistry.LOCKER_CHORUS_NEST.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_EBONY.get(),
                                    ModBlockRegistry.LOCKER_EBONY.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_PREAM.get(),
                                    ModBlockRegistry.LOCKER_PREAM.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_AETHER_SKYROOT.get(),
                                    ModBlockRegistry.LOCKER_AETHER_SKYROOT.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_GOLDEN_OAK.get(),
                                    ModBlockRegistry.LOCKER_GOLDEN_OAK.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_OAK.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_BIRCH.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_SPRUCE.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_JUNGLE.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_ACACIA.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_DARK_OAK.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_MANGROVE.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_CRIMSON.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_WARPED.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_FIR.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_REDWOOD.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_CHERRY.get(),
                                    ModBlockRegistry.LOCKER_OAK.get(),
                                    ModBlockRegistry.LOCKER_BIRCH.get(),
                                    ModBlockRegistry.LOCKER_SPRUCE.get(),
                                    ModBlockRegistry.LOCKER_JUNGLE.get(),
                                    ModBlockRegistry.LOCKER_ACACIA.get(),
                                    ModBlockRegistry.LOCKER_DARK_OAK.get(),
                                    ModBlockRegistry.LOCKER_MANGROVE.get(),
                                    ModBlockRegistry.LOCKER_CRIMSON.get(),
                                    ModBlockRegistry.LOCKER_WARPED.get(),
                                    ModBlockRegistry.LOCKER_FIR.get(),
                                    ModBlockRegistry.LOCKER_REDWOOD.get(),
                                    ModBlockRegistry.LOCKER_CHERRY.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_JACARANDA.get(),
                                    ModBlockRegistry.LOCKER_JACARANDA.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_PALM.get(),
                                    ModBlockRegistry.LOCKER_PALM.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_WILLOW.get(),
                                    ModBlockRegistry.LOCKER_WILLOW.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_DEAD.get(),
                                    ModBlockRegistry.LOCKER_DEAD.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_MAGIC.get(),
                                    ModBlockRegistry.LOCKER_MAGIC.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_UMBRAN.get(),
                                    ModBlockRegistry.LOCKER_UMBRAN.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_HELLBARK.get(),
                                    ModBlockRegistry.LOCKER_HELLBARK.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_COCONUT.get(),
                                    ModBlockRegistry.LOCKER_COCONUT.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_WALNUT.get(),
                                    ModBlockRegistry.LOCKER_WALNUT.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_AZALEA.get(),
                                    ModBlockRegistry.LOCKER_AZALEA.get(),
                                    ModBlockRegistry.SCHOOL_DESK_CABINET_FLOWERING_AZALEA.get(),
                                    ModBlockRegistry.LOCKER_FLOWERING_AZALEA.get()
                            )
                            .build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
