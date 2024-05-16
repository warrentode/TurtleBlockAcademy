package com.github.warrentode.turtleblockacademy.entity.client;

import com.github.warrentode.turtleblockacademy.entity.custom.Herobrine;
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
public class HerobrineRenderer extends MobRenderer<Herobrine, HerobrineModel<Herobrine>> {
    public HerobrineRenderer(EntityRendererProvider.Context context) {
        super(context, new HerobrineModel<>(context.bakeLayer(TBAModelLayers.HEROBRINE_LAYER)), 0.8F);
        this.addLayer(new HerobrineEyesLayer(this));
    }

    public @NotNull ResourceLocation getTextureLocation(@NotNull Herobrine entity) {
        return new ResourceLocation(MODID,"textures/entity/herobrine.png");
    }

    @Override
    public void render(@NotNull Herobrine entity, float entityYaw, float partialTicks, @NotNull PoseStack matrixStack, @NotNull MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
    }
}