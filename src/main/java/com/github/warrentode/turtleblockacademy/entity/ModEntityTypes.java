package com.github.warrentode.turtleblockacademy.entity;

import com.github.warrentode.turtleblockacademy.blocks.entity.SeatEntity;
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
            register(EntityType.Builder.<SeatEntity>of((type, level) ->
                            new SeatEntity(level), MobCategory.MISC).sized(0.0F, 0.0F)
                    .setCustomClientFactory((spawnEntity, level) -> new SeatEntity(level)));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(EntityType.Builder<T> builder) {
        return ENTITY_TYPES.register("seat_entity", () -> builder.build("seat_entity"));
    }

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}