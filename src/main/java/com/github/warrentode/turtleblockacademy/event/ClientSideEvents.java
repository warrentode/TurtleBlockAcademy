package com.github.warrentode.turtleblockacademy.event;

import com.github.warrentode.turtleblockacademy.blocks.entity.TBABlockEntities;
import com.github.warrentode.turtleblockacademy.blocks.renderer.PlateEntityRenderer;
import com.github.warrentode.turtleblockacademy.blocks.renderer.SchoolDeskRenderer;
import com.github.warrentode.turtleblockacademy.entity.client.HerobrineModel;
import com.github.warrentode.turtleblockacademy.entity.client.TBAModelLayers;
import com.github.warrentode.turtleblockacademy.entity.client.TreasureBeetleModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class ClientSideEvents {
    @Mod.EventBusSubscriber(modid = MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void registerRenderers(@NotNull final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(TBABlockEntities.SCHOOL_DESK_ENTITY.get(),
                    SchoolDeskRenderer::new);
            event.registerBlockEntityRenderer(TBABlockEntities.PLATE_BLOCK_ENTITY.get(),
                    PlateEntityRenderer::new);
        }
        @SubscribeEvent
        public static void onRegisterLayersEvent(EntityRenderersEvent.@NotNull RegisterLayerDefinitions event) {
            event.registerLayerDefinition(TBAModelLayers.TREASURE_BEETLE_LAYER,
                    TreasureBeetleModel::createBodyLayer);
            event.registerLayerDefinition(TBAModelLayers.HEROBRINE_LAYER,
                    HerobrineModel::createBodyLayer);
        }
    }
}
