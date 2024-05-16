package com.github.warrentode.turtleblockacademy;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.blocks.entity.TBABlockEntities;
import com.github.warrentode.turtleblockacademy.blocks.gui.ModMenuTypes;
import com.github.warrentode.turtleblockacademy.blocks.gui.SchoolDeskScreen;
import com.github.warrentode.turtleblockacademy.config.AcademyConfig;
import com.github.warrentode.turtleblockacademy.entity.TBAEntityTypes;
import com.github.warrentode.turtleblockacademy.entity.TBAPOIs;
import com.github.warrentode.turtleblockacademy.entity.client.HerobrineRenderer;
import com.github.warrentode.turtleblockacademy.entity.client.SeatEntityRenderer;
import com.github.warrentode.turtleblockacademy.entity.client.TreasureBeetleRenderer;
import com.github.warrentode.turtleblockacademy.items.TBAItems;
import com.github.warrentode.turtleblockacademy.loot.serializers.ModLootItemConditions;
import com.github.warrentode.turtleblockacademy.loot.serializers.ModLootModifiers;
import com.github.warrentode.turtleblockacademy.util.TBASounds;
import com.github.warrentode.turtleblockacademy.world.biome.TBABiomes;
import com.github.warrentode.turtleblockacademy.world.dimension.TBADimensions;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Mod(TurtleBlockAcademy.MODID)
public class TurtleBlockAcademy {
    public static final String MODID = "turtleblockacademy";
    public static final Logger LOGGER = LogManager.getLogger();

    public TurtleBlockAcademy() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, AcademyConfig.SPEC,
                MODID + "-common.toml");
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::commonSetup);

        TBASounds.SOUNDS.register(modEventBus);

        TBABlocks.register(modEventBus);
        TBABlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        TBAEntityTypes.register(modEventBus);

        TBAItems.register(modEventBus);

        ModLootModifiers.register(modEventBus);
        ModLootItemConditions.register(modEventBus);

        TBADimensions.register();
        TBABiomes.TBA_BIOMES.register(modEventBus);
    }

    @SuppressWarnings("deprecation")
    public static final SoundType CERTIFICATE = new SoundType(1.0F, 1.0F,
            SoundEvents.ITEM_FRAME_BREAK, SoundEvents.ITEM_FRAME_ADD_ITEM,
            SoundEvents.ITEM_FRAME_PLACE, SoundEvents.ITEM_FRAME_BREAK,
            SoundEvents.ITEM_FRAME_BREAK);

    public static final CreativeModeTab TAB = new CreativeModeTab(MODID) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return TBABlocks.CERTIFICATE_BLOCK.get().asItem().getDefaultInstance();
        }
    };

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(TBAPOIs::registerPOIs);
        event.enqueueWork(()-> {
            //noinspection deprecation
            SpawnPlacements.register(TBAEntityTypes.TREASURE_BEETLE.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
        });
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // reserved for later use
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(@NotNull FMLClientSetupEvent event) {
            event.enqueueWork(() ->
                    MenuScreens.register(ModMenuTypes.SCHOOL_DESK_MENU.get(),
                            SchoolDeskScreen::new));

            EntityRenderers.register(TBAEntityTypes.SEAT_ENTITY.get(),
                    SeatEntityRenderer::new);

            EntityRenderers.register(TBAEntityTypes.TREASURE_BEETLE.get(),
                    TreasureBeetleRenderer::new);

            EntityRenderers.register(TBAEntityTypes.HEROBRINE.get(),
                    HerobrineRenderer::new);
        }
    }
}
