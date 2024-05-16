package com.github.warrentode.turtleblockacademy.entity.client;

import com.github.warrentode.turtleblockacademy.entity.custom.TreasureBeetle;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

@OnlyIn(Dist.CLIENT)
public class TreasureBeetleRenderer extends MobRenderer<TreasureBeetle, TreasureBeetleModel<TreasureBeetle>> {
    public TreasureBeetleRenderer(EntityRendererProvider.Context context) {
        super(context, new TreasureBeetleModel<>(context.bakeLayer(TBAModelLayers.TREASURE_BEETLE_LAYER)), 0.8F);
    }

    public @NotNull ResourceLocation getTextureLocation(@NotNull TreasureBeetle entity) {
        return new ResourceLocation(MODID,"textures/entity/treasure_beetle.png");
    }

    @Override
    public void render(@NotNull TreasureBeetle entity, float entityYaw, float partialTicks, @NotNull PoseStack matrixStack, @NotNull MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
    }
}