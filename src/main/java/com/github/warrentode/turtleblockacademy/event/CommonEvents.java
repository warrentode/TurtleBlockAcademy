package com.github.warrentode.turtleblockacademy.event;

import com.github.warrentode.turtleblockacademy.commands.AcademyCommands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class CommonEvents {
    @Mod.EventBusSubscriber(modid = MODID, bus = net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeBus {
        @SubscribeEvent
        public static void registerCommands(@NotNull RegisterCommandsEvent event) {
            AcademyCommands.register(event.getDispatcher());
        }
    }
}