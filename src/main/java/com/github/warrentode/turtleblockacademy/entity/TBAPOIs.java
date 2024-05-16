package com.github.warrentode.turtleblockacademy.entity;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TBAPOIs {
    public static final DeferredRegister<PoiType> TBA_POI =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, MODID);


    public static final RegistryObject<PoiType> MINING_PORTAL_POI = TBA_POI.register("mining_portal_poi",
            () -> new PoiType(ImmutableSet.copyOf(
                    TBABlocks.TBA_MINING_PORTAL.get().getStateDefinition().getPossibleStates()),
                    1, 1));


    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class)
                    .invoke(null, MINING_PORTAL_POI.get());
        }
        catch (InvocationTargetException | IllegalAccessException exception) {
            exception.getLocalizedMessage();
        }
    }

    public static void register(IEventBus eventBus) {
        TBA_POI.register(eventBus);
    }
}
