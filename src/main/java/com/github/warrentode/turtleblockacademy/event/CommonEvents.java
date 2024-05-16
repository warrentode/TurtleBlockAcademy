package com.github.warrentode.turtleblockacademy.event;

import com.aetherteam.aether.data.resources.registries.AetherDimensions;
import com.github.warrentode.turtleblockacademy.commands.AcademyCommands;
import com.github.warrentode.turtleblockacademy.entity.TBAEntityTypes;
import com.github.warrentode.turtleblockacademy.world.dimension.TBADimensions;
import com.github.warrentode.turtleblockacademy.world.spawner.herobrine.HerobrineSpawner;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStoppedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

// all of these events occur on both logical sides
public class CommonEvents {
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeBus {
        @SubscribeEvent
        public static void registerCommands(@NotNull RegisterCommandsEvent event) {
            AcademyCommands.register(event.getDispatcher());
        }
    }

    @Mod.EventBusSubscriber(modid = MODID)
    public static class CustomSpawnerHandler {
        private static final Map<ResourceLocation, HerobrineSpawner> herobrineSpawner = new HashMap<>();

        @SubscribeEvent
        public static void onWorldLoad(@NotNull ServerStartingEvent event) {
            MinecraftServer server = event.getServer();
            herobrineSpawner.put(BuiltinDimensionTypes.OVERWORLD.location(),
                    new HerobrineSpawner(server, "Herobrine", TBAEntityTypes.HEROBRINE.get()));
            herobrineSpawner.put(BuiltinDimensionTypes.NETHER.location(),
                    new HerobrineSpawner(server, "Herobrine", TBAEntityTypes.HEROBRINE.get()));
            herobrineSpawner.put(BuiltinDimensionTypes.END.location(),
                    new HerobrineSpawner(server, "Herobrine", TBAEntityTypes.HEROBRINE.get()));

            herobrineSpawner.put(AetherDimensions.AETHER_DIMENSION_TYPE.location(),
                    new HerobrineSpawner(server, "Herobrine", TBAEntityTypes.HEROBRINE.get()));
            herobrineSpawner.put(TBADimensions.TDA_MINING_TYPE.location(),
                    new HerobrineSpawner(server, "Herobrine", TBAEntityTypes.HEROBRINE.get()));
        }

        @SubscribeEvent
        public static void onServerStopped(ServerStoppedEvent event) {
            herobrineSpawner.clear();
        }

        @SubscribeEvent
        public static void onWorldTick(@NotNull TickEvent.LevelTickEvent event) {
            if (event.phase != TickEvent.Phase.START) {
                return;
            }

            if (event.side != LogicalSide.SERVER) {
                return;
            }

            HerobrineSpawner spawner = herobrineSpawner.get(event.level.dimension().location());
            if (spawner != null) {
                spawner.tick((ServerLevel) event.level, true, true);
            }
        }
    }
}