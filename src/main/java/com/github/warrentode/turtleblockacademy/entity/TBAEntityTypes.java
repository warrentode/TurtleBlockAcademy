package com.github.warrentode.turtleblockacademy.entity;

import com.github.warrentode.turtleblockacademy.entity.custom.Herobrine;
import com.github.warrentode.turtleblockacademy.entity.custom.TreasureBeetle;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TBAEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);

    public static final RegistryObject<EntityType<SeatEntity>> SEAT_ENTITY =
            ENTITY_TYPES.register("seat_entity",
                    () -> EntityType.Builder.of(SeatEntity::new, MobCategory.MISC)
                            .sized(0f, 0f).build("seat_entity"));

    public static final RegistryObject<EntityType<TreasureBeetle>> TREASURE_BEETLE =
            ENTITY_TYPES.register("treasure_beetle",
                    () -> EntityType.Builder.of(TreasureBeetle::new, MobCategory.MONSTER)
                            .sized(1.0f, 1.0f).build("treasure_beetle"));

    public static final RegistryObject<EntityType<Herobrine>> HEROBRINE =
            ENTITY_TYPES.register("herobrine",
                    () -> EntityType.Builder.of(Herobrine::new, MobCategory.CREATURE)
                            .sized(1.0f, 2.0f).build("herobrine"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}