package com.github.warrentode.turtleblockacademy.entity.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class TBAModelLayers {
    public static final ModelLayerLocation TREASURE_BEETLE_LAYER =
            new ModelLayerLocation(new ResourceLocation("treasure_beetle"), "main");

    public static final ModelLayerLocation HEROBRINE_LAYER =
            new ModelLayerLocation(new ResourceLocation("herobrine"), "main");
    @SuppressWarnings("unused")
    public static final ModelLayerLocation HEROBRINE_EYES_LAYER =
            new ModelLayerLocation(new ResourceLocation("herobrine_eyes"), "eyes");
}