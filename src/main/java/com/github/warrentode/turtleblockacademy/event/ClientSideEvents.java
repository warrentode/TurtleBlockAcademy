package com.github.warrentode.turtleblockacademy.event;

import com.github.warrentode.turtleblockacademy.blocks.entity.TBABlockEntities;
import com.github.warrentode.turtleblockacademy.blocks.entity.renderer.BasketEntityRenderer;
import com.github.warrentode.turtleblockacademy.blocks.entity.renderer.PlateEntityRenderer;
import com.github.warrentode.turtleblockacademy.blocks.entity.renderer.SchoolDeskRenderer;
import com.github.warrentode.turtleblockacademy.entity.client.HerobrineModel;
import com.github.warrentode.turtleblockacademy.entity.client.TBAModelLayers;
import com.github.warrentode.turtleblockacademy.entity.client.TreasureBeetleModel;
import com.github.warrentode.turtleblockacademy.items.TBAItems;
import com.github.warrentode.turtleblockacademy.items.food.eastereggs.EasterEggItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;
import static com.github.warrentode.turtleblockacademy.blocks.furniture.DeskChairBlock.DESK_CHAIR_LIST;
import static com.github.warrentode.turtleblockacademy.blocks.furniture.PicnicBlanket.PICNIC_BLANKET_LIST;
import static com.github.warrentode.turtleblockacademy.items.food.eastereggs.EasterEggItem.EASTER_EGGS;

public class ClientSideEvents {
    @Mod.EventBusSubscriber(modid = MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void registerRenderers(@NotNull final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(TBABlockEntities.SCHOOL_DESK_ENTITY.get(),
                    SchoolDeskRenderer::new);
            event.registerBlockEntityRenderer(TBABlockEntities.PLATE_BLOCK_ENTITY.get(),
                    PlateEntityRenderer::new);
            event.registerBlockEntityRenderer(TBABlockEntities.BASKET_BLOCK_ENTITY.get(),
                    BasketEntityRenderer::new);
        }

        @SubscribeEvent
        public static void onRegisterLayersEvent(EntityRenderersEvent.@NotNull RegisterLayerDefinitions event) {
            event.registerLayerDefinition(TBAModelLayers.TREASURE_BEETLE_LAYER,
                    TreasureBeetleModel::createBodyLayer);
            event.registerLayerDefinition(TBAModelLayers.HEROBRINE_LAYER,
                    HerobrineModel::createBodyLayer);
        }

        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public static void registerItemColors(@NotNull RegisterColorHandlersEvent.Item event) {
            //noinspection deprecation
            EASTER_EGGS.forEach(egg -> event.getItemColors().register((stack, tintIndex) -> {
                if (stack.getItem() instanceof EasterEggItem easterEggItem) {
                    if (tintIndex == 0) {
                        return easterEggItem.getBaseTint();
                    }
                    else if (tintIndex == 1) {
                        return easterEggItem.getStampTint();
                    }
                }
                return -1; // No tint for other layers
            }, egg));

            event.getItemColors().getColor(TBAItems.BOILED_EGG.get()
                    .getDefaultInstance(), 0xFFF5EE);
            event.getItemColors().getColor(TBAItems.PEELED_EGG.get()
                    .getDefaultInstance(), 0xFAEBD7);

            // Register block colors
            PICNIC_BLANKET_LIST.forEach(picnicBlanket -> {
                //noinspection deprecation
                event.getBlockColors().register((state, world, pos, tintIndex) -> {
                    // return the appropriate color from block class
                    return picnicBlanket.getTintIndex();
                }, picnicBlanket);
            });

            // Register item colors
            PICNIC_BLANKET_LIST.forEach(picnicBlanket -> {
                //noinspection deprecation
                event.getItemColors().register((stack, tintIndex) -> {
                    // return the appropriate color from block class
                    return picnicBlanket.getTintIndex();
                }, picnicBlanket);
            });

            // Register block colors
            DESK_CHAIR_LIST.forEach(deskChairBlock -> {
                if (deskChairBlock.getClothColor() != null) {
                    //noinspection deprecation
                    event.getBlockColors().register((state, world, pos, tintIndex) -> {
                        // return the appropriate color from block class
                        return deskChairBlock.getTintIndex();
                    }, deskChairBlock);
                }
            });

            // Register item colors
            DESK_CHAIR_LIST.forEach(deskChairBlock -> {
                if (deskChairBlock.getClothColor() != null) {
                    //noinspection deprecation
                    event.getItemColors().register((stack, tintIndex) -> {
                        // return the appropriate color from block class
                        return deskChairBlock.getTintIndex();
                    }, deskChairBlock);
                }
            });
        }
    }
}