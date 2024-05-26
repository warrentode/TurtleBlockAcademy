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

       /* @SubscribeEvent
        public void registerItemColors(@NotNull RegisterColorHandlersEvent.Item event){
            event.register((stack, tintIndex) ->
                            stack.getItem() instanceof EasterEggItem blankEggItem
                                    ? (blankEggItem).getColor(stack, tintIndex)
                                    : 0xFFFFFF,
                    TBAItems.COLORED_EGG_BLANK_BLACK.get(),
                    TBAItems.COLORED_EGG_BLANK_ORANGE.get(),
                    TBAItems.COLORED_EGG_BLANK_RED.get(),
                    TBAItems.COLORED_EGG_BLANK_MAGENTA.get(),
                    TBAItems.COLORED_EGG_BLANK_LIGHT_BLUE.get(),
                    TBAItems.COLORED_EGG_BLANK_YELLOW.get(),
                    TBAItems.COLORED_EGG_BLANK_LIME.get(),
                    TBAItems.COLORED_EGG_BLANK_PINK.get(),
                    TBAItems.COLORED_EGG_BLANK_LIGHT_GRAY.get(),
                    TBAItems.COLORED_EGG_BLANK_CYAN.get(),
                    TBAItems.COLORED_EGG_BLANK_PURPLE.get(),
                    TBAItems.COLORED_EGG_BLANK_BLUE.get(),
                    TBAItems.COLORED_EGG_BLANK_BROWN.get(),
                    TBAItems.COLORED_EGG_BLANK_GREEN.get());
        }

        */
    }
}
