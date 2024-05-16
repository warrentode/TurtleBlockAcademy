package com.github.warrentode.turtleblockacademy.event;

import com.github.warrentode.turtleblockacademy.entity.TBAEntityTypes;
import com.github.warrentode.turtleblockacademy.entity.custom.TreasureBeetle;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class ServerSideEvents {
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void onEntityAttributeEvent(@NotNull EntityAttributeCreationEvent event) {
            event.put(TBAEntityTypes.TREASURE_BEETLE.get(), TreasureBeetle.setAttributes());
        }
    }
}