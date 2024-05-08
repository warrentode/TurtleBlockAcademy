package com.github.warrentode.turtleblockacademy.event;

import com.github.warrentode.turtleblockacademy.blocks.entity.ModBlockEntities;
import com.github.warrentode.turtleblockacademy.blocks.renderer.PlateEntityRenderer;
import com.github.warrentode.turtleblockacademy.blocks.renderer.SchoolDeskRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class ClientEvents {

    @Mod.EventBusSubscriber(modid = MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {

        @SubscribeEvent
        public static void registerRenderers(@NotNull final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.SCHOOL_DESK_ENTITY.get(),
                    SchoolDeskRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.PLATE_BLOCK_ENTITY.get(),
                    PlateEntityRenderer::new);
        }
    }
}
