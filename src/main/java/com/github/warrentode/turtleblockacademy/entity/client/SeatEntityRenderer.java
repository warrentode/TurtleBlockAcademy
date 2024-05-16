package com.github.warrentode.turtleblockacademy.entity.client;

import com.github.warrentode.turtleblockacademy.blocks.entity.SeatEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class SeatEntityRenderer extends EntityRenderer<SeatEntity> {
    public SeatEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull SeatEntity seatEntity) {
        //noinspection DataFlowIssue
        return null;
    }

    @Override
    protected void renderNameTag(@NotNull SeatEntity entity, @NotNull Component component, @NotNull PoseStack stack, @NotNull MultiBufferSource source, int light) {
    }
}