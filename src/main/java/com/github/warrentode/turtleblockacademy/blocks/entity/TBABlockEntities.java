package com.github.warrentode.turtleblockacademy.blocks.entity;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TBABlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);

    @SuppressWarnings("DataFlowIssue")
    public static final RegistryObject<BlockEntityType<FermentingPotBlockEntity>> FERMENTING_POT_ENTITY =
            BLOCK_ENTITIES.register("fermenting_pot_entity",
                    () -> BlockEntityType.Builder.of(FermentingPotBlockEntity::new,
                                    TBABlocks.FERMENTING_POT_BLOCK.get())
                            .build(null));

    @SuppressWarnings("DataFlowIssue")
    public static final RegistryObject<BlockEntityType<PlateBlockEntity>> PLATE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("plate_block_entity",
                    () -> BlockEntityType.Builder.of(PlateBlockEntity::new,
                                    TBABlocks.PLATE_WHITE.get(),
                                    TBABlocks.PLATE_ORANGE.get(),
                                    TBABlocks.PLATE_MAGENTA.get(),
                                    TBABlocks.PLATE_LIGHT_BLUE.get(),
                                    TBABlocks.PLATE_YELLOW.get(),
                                    TBABlocks.PLATE_LIME.get(),
                                    TBABlocks.PLATE_PINK.get(),
                                    TBABlocks.PLATE_GRAY.get(),
                                    TBABlocks.PLATE_LIGHT_GRAY.get(),
                                    TBABlocks.PLATE_CYAN.get(),
                                    TBABlocks.PLATE_PURPLE.get(),
                                    TBABlocks.PLATE_BLUE.get(),
                                    TBABlocks.PLATE_BROWN.get(),
                                    TBABlocks.PLATE_GREEN.get(),
                                    TBABlocks.PLATE_RED.get(),
                                    TBABlocks.PLATE_BLACK.get()
                            )
                            .build(null));

    @SuppressWarnings("DataFlowIssue")
    public static final RegistryObject<BlockEntityType<SchoolDeskBlockEntity>> SCHOOL_DESK_ENTITY =
            BLOCK_ENTITIES.register("school_desk_entity",
                    () -> BlockEntityType.Builder.of(SchoolDeskBlockEntity::new,
                                    TBABlocks.SCHOOL_DESK_OAK.get(),
                                    TBABlocks.SCHOOL_DESK_BIRCH.get(),
                                    TBABlocks.SCHOOL_DESK_SPRUCE.get(),
                                    TBABlocks.SCHOOL_DESK_JUNGLE.get(),
                                    TBABlocks.SCHOOL_DESK_ACACIA.get(),
                                    TBABlocks.SCHOOL_DESK_DARK_OAK.get(),
                                    TBABlocks.SCHOOL_DESK_MANGROVE.get(),
                                    TBABlocks.SCHOOL_DESK_CRIMSON.get(),
                                    TBABlocks.SCHOOL_DESK_WARPED.get(),
                                    TBABlocks.SCHOOL_DESK_FIR.get(),
                                    TBABlocks.SCHOOL_DESK_REDWOOD.get(),
                                    TBABlocks.SCHOOL_DESK_CHERRY.get(),
                                    TBABlocks.SCHOOL_DESK_MAHOGANY.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_MAHOGANY.get(),
                                    TBABlocks.LOCKER_MAHOGANY.get(),
                                    TBABlocks.SCHOOL_DESK_JACARANDA.get(),
                                    TBABlocks.SCHOOL_DESK_PALM.get(),
                                    TBABlocks.SCHOOL_DESK_WILLOW.get(),
                                    TBABlocks.SCHOOL_DESK_DEAD.get(),
                                    TBABlocks.SCHOOL_DESK_MAGIC.get(),
                                    TBABlocks.SCHOOL_DESK_UMBRAN.get(),
                                    TBABlocks.SCHOOL_DESK_HELLBARK.get(),
                                    TBABlocks.SCHOOL_DESK_COCONUT.get(),
                                    TBABlocks.SCHOOL_DESK_WALNUT.get(),
                                    TBABlocks.SCHOOL_DESK_AZALEA.get(),
                                    TBABlocks.SCHOOL_DESK_FLOWERING_AZALEA.get(),
                                    TBABlocks.SCHOOL_DESK_GOLDEN_OAK.get(),
                                    TBABlocks.SCHOOL_DESK_AETHER_SKYROOT.get(),
                                    TBABlocks.SCHOOL_DESK_PREAM.get(),
                                    TBABlocks.SCHOOL_DESK_EBONY.get(),
                                    TBABlocks.SCHOOL_DESK_CHORUS_NEST.get(),
                                    TBABlocks.SCHOOL_DESK_BLOODSHROOM.get(),
                                    TBABlocks.SCHOOL_DESK_ENDERBARK.get(),
                                    TBABlocks.SCHOOL_DESK_GREENHEART.get(),
                                    TBABlocks.SCHOOL_DESK_TINKER_SKYROOT.get()
                            )
                            .build(null));

    @SuppressWarnings("DataFlowIssue")
    public static final RegistryObject<BlockEntityType<SchoolStorageEntity>> SCHOOL_STORAGE_ENTITY =
            BLOCK_ENTITIES.register("school_storage_entity",
                    () -> BlockEntityType.Builder.of(SchoolStorageEntity::new,
                                    TBABlocks.SCHOOL_DESK_CABINET_GREENHEART.get(),
                                    TBABlocks.LOCKER_GREENHEART.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_TINKER_SKYROOT.get(),
                                    TBABlocks.LOCKER_TINKER_SKYROOT.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_BLOODSHROOM.get(),
                                    TBABlocks.LOCKER_BLOODSHROOM.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_ENDERBARK.get(),
                                    TBABlocks.LOCKER_ENDERBARK.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_CHORUS_NEST.get(),
                                    TBABlocks.LOCKER_CHORUS_NEST.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_EBONY.get(),
                                    TBABlocks.LOCKER_EBONY.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_PREAM.get(),
                                    TBABlocks.LOCKER_PREAM.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_AETHER_SKYROOT.get(),
                                    TBABlocks.LOCKER_AETHER_SKYROOT.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_GOLDEN_OAK.get(),
                                    TBABlocks.LOCKER_GOLDEN_OAK.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_OAK.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_BIRCH.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_SPRUCE.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_JUNGLE.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_ACACIA.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_DARK_OAK.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_MANGROVE.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_CRIMSON.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_WARPED.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_FIR.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_REDWOOD.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_CHERRY.get(),
                                    TBABlocks.LOCKER_OAK.get(),
                                    TBABlocks.LOCKER_BIRCH.get(),
                                    TBABlocks.LOCKER_SPRUCE.get(),
                                    TBABlocks.LOCKER_JUNGLE.get(),
                                    TBABlocks.LOCKER_ACACIA.get(),
                                    TBABlocks.LOCKER_DARK_OAK.get(),
                                    TBABlocks.LOCKER_MANGROVE.get(),
                                    TBABlocks.LOCKER_CRIMSON.get(),
                                    TBABlocks.LOCKER_WARPED.get(),
                                    TBABlocks.LOCKER_FIR.get(),
                                    TBABlocks.LOCKER_REDWOOD.get(),
                                    TBABlocks.LOCKER_CHERRY.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_JACARANDA.get(),
                                    TBABlocks.LOCKER_JACARANDA.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_PALM.get(),
                                    TBABlocks.LOCKER_PALM.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_WILLOW.get(),
                                    TBABlocks.LOCKER_WILLOW.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_DEAD.get(),
                                    TBABlocks.LOCKER_DEAD.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_MAGIC.get(),
                                    TBABlocks.LOCKER_MAGIC.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_UMBRAN.get(),
                                    TBABlocks.LOCKER_UMBRAN.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_HELLBARK.get(),
                                    TBABlocks.LOCKER_HELLBARK.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_COCONUT.get(),
                                    TBABlocks.LOCKER_COCONUT.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_WALNUT.get(),
                                    TBABlocks.LOCKER_WALNUT.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_AZALEA.get(),
                                    TBABlocks.LOCKER_AZALEA.get(),
                                    TBABlocks.SCHOOL_DESK_CABINET_FLOWERING_AZALEA.get(),
                                    TBABlocks.LOCKER_FLOWERING_AZALEA.get()
                            )
                            .build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
