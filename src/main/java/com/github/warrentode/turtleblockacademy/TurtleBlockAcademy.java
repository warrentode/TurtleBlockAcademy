package com.github.warrentode.turtleblockacademy;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.blocks.entity.TBABlockEntities;
import com.github.warrentode.turtleblockacademy.blocks.entity.gui.FermentingPotScreen;
import com.github.warrentode.turtleblockacademy.blocks.entity.gui.SchoolDeskScreen;
import com.github.warrentode.turtleblockacademy.blocks.entity.gui.TBAMenuTypes;
import com.github.warrentode.turtleblockacademy.config.AcademyConfig;
import com.github.warrentode.turtleblockacademy.entity.TBAEntityTypes;
import com.github.warrentode.turtleblockacademy.entity.TBAPOIs;
import com.github.warrentode.turtleblockacademy.entity.client.HerobrineRenderer;
import com.github.warrentode.turtleblockacademy.entity.client.SeatEntityRenderer;
import com.github.warrentode.turtleblockacademy.entity.client.TreasureBeetleRenderer;
import com.github.warrentode.turtleblockacademy.items.TBAItems;
import com.github.warrentode.turtleblockacademy.loot.serializers.TBALootItemConditions;
import com.github.warrentode.turtleblockacademy.loot.serializers.TBALootModifiers;
import com.github.warrentode.turtleblockacademy.recipe.TBARecipes;
import com.github.warrentode.turtleblockacademy.recipe.fermenting.FermentingRecipeCategories;
import com.github.warrentode.turtleblockacademy.util.TBASounds;
import com.github.warrentode.turtleblockacademy.world.biome.TBABiomes;
import com.github.warrentode.turtleblockacademy.world.dimension.TBADimensions;
import com.github.warrentode.turtleblockacademy.world.feature.TBAConfiguredFeatures;
import com.github.warrentode.turtleblockacademy.world.feature.TBAPlacedFeatures;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent;
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
        TBAMenuTypes.register(modEventBus);
        TBARecipes.register(modEventBus);

        TBAEntityTypes.register(modEventBus);

        TBAItems.register(modEventBus);

        TBALootModifiers.register(modEventBus);
        TBALootItemConditions.register(modEventBus);

        TBADimensions.register();
        TBABiomes.TBA_BIOMES.register(modEventBus);
        TBAConfiguredFeatures.CONFIGURED_FEATURES.register(modEventBus);
        TBAPlacedFeatures.PLACED_FEATURES.register(modEventBus);
        TBAPOIs.register(modEventBus);
    }

    @SuppressWarnings("deprecation")
    public static final SoundType CERTIFICATE = new SoundType(1.0F, 1.0F,
            SoundEvents.ITEM_FRAME_BREAK, SoundEvents.ITEM_FRAME_ADD_ITEM,
            SoundEvents.ITEM_FRAME_PLACE, SoundEvents.ITEM_FRAME_BREAK,
            SoundEvents.ITEM_FRAME_BREAK);

    private void commonSetup(final @NotNull FMLCommonSetupEvent event) {
        event.enqueueWork(()-> {
            //noinspection deprecation
            SpawnPlacements.register(TBAEntityTypes.TREASURE_BEETLE.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
        });
    }

    @SubscribeEvent
    @SuppressWarnings("EmptyMethod")
    public void onServerStarting(ServerStartingEvent event) {
        // reserved for later use
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(@NotNull FMLClientSetupEvent event) {
            event.enqueueWork(() -> MenuScreens.register(
                    TBAMenuTypes.SCHOOL_DESK_MENU.get(), SchoolDeskScreen::new));
            event.enqueueWork(() -> MenuScreens.register(
                    TBAMenuTypes.FERMENTING_POT_MENU.get(), FermentingPotScreen::new));

            EntityRenderers.register(TBAEntityTypes.SEAT_ENTITY.get(),
                    SeatEntityRenderer::new);

            EntityRenderers.register(TBAEntityTypes.TREASURE_BEETLE.get(),
                    TreasureBeetleRenderer::new);
            EntityRenderers.register(TBAEntityTypes.HEROBRINE.get(),
                    HerobrineRenderer::new);
        }

        @SubscribeEvent
        public static void onRegisterRecipeBookCategories(RegisterRecipeBookCategoriesEvent event) {
            FermentingRecipeCategories.init(event);
        }
    }
}
