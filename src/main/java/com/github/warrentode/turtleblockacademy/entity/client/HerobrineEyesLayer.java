package com.github.warrentode.turtleblockacademy.entity.client;

import com.github.warrentode.turtleblockacademy.entity.custom.Herobrine;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

@OnlyIn(Dist.CLIENT)
public class HerobrineEyesLayer extends EyesLayer<Herobrine, HerobrineModel<Herobrine>> {
    public HerobrineEyesLayer(RenderLayerParent<Herobrine, HerobrineModel<Herobrine>> parent) {
        super(parent);
    }

    @Override
    public @NotNull RenderType renderType() {
        return RenderType.eyes(new ResourceLocation(MODID, "textures/entity/herobrine_eyes.png"));
    }
}
