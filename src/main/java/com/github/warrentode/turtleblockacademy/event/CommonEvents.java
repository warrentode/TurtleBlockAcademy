package com.github.warrentode.turtleblockacademy.event;

import com.aetherteam.aether.data.resources.registries.AetherDimensions;
import com.github.warrentode.turtleblockacademy.commands.AcademyCommands;
import com.github.warrentode.turtleblockacademy.config.AcademyConfig;
import com.github.warrentode.turtleblockacademy.entity.TBAEntityTypes;
import com.github.warrentode.turtleblockacademy.items.TBAItems;
import com.github.warrentode.turtleblockacademy.util.CalendarUtil;
import com.github.warrentode.turtleblockacademy.world.dimension.TBADimensions;
import com.github.warrentode.turtleblockacademy.world.spawner.herobrine.HerobrineSpawner;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
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

        @SubscribeEvent
        public static void easterRabbitEggs(LivingEvent.@NotNull LivingTickEvent event) {
            LivingEntity entity = event.getEntity();
            RandomSource random = RandomSource.create();
            int easterEggChance = random.nextInt(AcademyConfig.getColoredEggChance());

            if (CalendarUtil.check("EASTER") && entity instanceof Rabbit rabbit) {
                if (easterEggChance <= 1) {
                    ItemStack easterEgg;
                    int easterEggSelection = random.nextInt( 15) + 1;
                    switch (easterEggSelection) {
                        case 1 -> easterEgg = TBAItems.COLORED_EGG_ORANGE.get().getDefaultInstance();
                        case 2 -> easterEgg = TBAItems.COLORED_EGG_MAGENTA.get().getDefaultInstance();
                        case 3 -> easterEgg = TBAItems.COLORED_EGG_LIGHT_BLUE.get().getDefaultInstance();
                        case 4 -> easterEgg = TBAItems.COLORED_EGG_YELLOW.get().getDefaultInstance();
                        case 5 -> easterEgg = TBAItems.COLORED_EGG_LIME.get().getDefaultInstance();
                        case 6 -> easterEgg = TBAItems.COLORED_EGG_PINK.get().getDefaultInstance();
                        case 7 -> easterEgg = TBAItems.COLORED_EGG_GRAY.get().getDefaultInstance();
                        case 8 -> easterEgg = TBAItems.COLORED_EGG_LIGHT_GRAY.get().getDefaultInstance();
                        case 9 -> easterEgg = TBAItems.COLORED_EGG_CYAN.get().getDefaultInstance();
                        case 10 -> easterEgg = TBAItems.COLORED_EGG_PURPLE.get().getDefaultInstance();
                        case 11 -> easterEgg = TBAItems.COLORED_EGG_BLUE.get().getDefaultInstance();
                        case 12 -> easterEgg = TBAItems.COLORED_EGG_BROWN.get().getDefaultInstance();
                        case 13 -> easterEgg = TBAItems.COLORED_EGG_GREEN.get().getDefaultInstance();
                        case 14 -> easterEgg = TBAItems.COLORED_EGG_RED.get().getDefaultInstance();
                        case 15 -> easterEgg = TBAItems.COLORED_EGG_BLACK.get().getDefaultInstance();
                        default -> easterEgg = TBAItems.COLORED_EGG_WHITE.get().getDefaultInstance();
                    }

                    ItemStack selectedEasterEgg = new ItemStack(easterEgg.getItem());

                    rabbit.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
                    rabbit.spawnAtLocation(easterEgg);
                    rabbit.gameEvent(GameEvent.ENTITY_PLACE);
                }
            }
        }
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class PlayerLoginHandler {
        @SubscribeEvent
        public static void onPlayerLogin(@NotNull PlayerEvent.PlayerLoggedInEvent event) {
            ServerPlayer player = (ServerPlayer) event.getEntity();
            if (player != null) {
                if (CalendarUtil.check("BIRTHDAY")) {
                    player.sendSystemMessage(Component.translatable("message." + MODID + ".birthday_message"));
                }
            }
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