package com.github.warrentode.turtleblockacademy.entity;

import com.github.warrentode.turtleblockacademy.blocks.entity.SeatEntity;
import com.github.warrentode.turtleblockacademy.items.entity.PlateEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.Keys.ENTITY_TYPES, MODID);

    public static final RegistryObject<EntityType<SeatEntity>> SEAT_ENTITY =
            register("seat_entity", EntityType.Builder.<SeatEntity>of((type, level) ->
                            new SeatEntity(level), MobCategory.MISC).sized(0.0F, 0.0F)
                    .setCustomClientFactory((spawnEntity, level) -> new SeatEntity(level)));

    public static final RegistryObject<EntityType<PlateEntity>> PLATE_ENTITY =
            register("plate_entity", EntityType.Builder.<PlateEntity>of(PlateEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(10)
                    .updateInterval(Integer.MAX_VALUE));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        return ENTITY_TYPES.register(name, () -> builder.build(name));
    }

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}