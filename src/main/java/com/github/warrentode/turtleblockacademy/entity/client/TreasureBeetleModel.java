package com.github.warrentode.turtleblockacademy.entity.client;// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.warrentode.turtleblockacademy.entity.animations.TBAAnimationDefinitions;
import com.github.warrentode.turtleblockacademy.entity.custom.TreasureBeetle;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class TreasureBeetleModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart shell;
	private final ModelPart head;
	@SuppressWarnings("unused")
    private final ModelPart leg_1;
	@SuppressWarnings("unused")
	private final ModelPart leg_2;
	@SuppressWarnings("unused")
	private final ModelPart leg_3;
	@SuppressWarnings("unused")
	private final ModelPart leg_4;
	@SuppressWarnings("unused")
	private final ModelPart leg_5;
	@SuppressWarnings("unused")
	private final ModelPart leg_6;

	public TreasureBeetleModel(@NotNull ModelPart part) {
		this.root = part.getChild("root");
		this.body = root.getChild("body");
		this.shell = body.getChild("shell");
		this.head = shell.getChild("head");
		this.leg_1 = body.getChild("leg_1");
		this.leg_2 = body.getChild("leg_2");
		this.leg_3 = body.getChild("leg_3");
		this.leg_4 = body.getChild("leg_4");
		this.leg_5 = body.getChild("leg_5");
		this.leg_6 = body.getChild("leg_6");
	}

	public static @NotNull LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 20.0F, 3.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition shell = body.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -3.0F, -5.0F, 10.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		@SuppressWarnings("unused")
		PartDefinition head = shell.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 6).addBox(1.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 3).addBox(1.0F, -4.0F, -6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 0).addBox(-2.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-2.0F, -4.0F, -6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -5.0F));

		@SuppressWarnings("unused")
		PartDefinition leg_1 = body.addOrReplaceChild("leg_1", CubeListBuilder.create().texOffs(0, 16).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 2.5F, -3.5F));

		@SuppressWarnings("unused")
		PartDefinition leg_2 = body.addOrReplaceChild("leg_2", CubeListBuilder.create().texOffs(6, 8).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 2.5F, -0.5F));

		@SuppressWarnings("unused")
		PartDefinition leg_3 = body.addOrReplaceChild("leg_3", CubeListBuilder.create().texOffs(0, 8).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 2.5F, 2.5F));

		@SuppressWarnings("unused")
		PartDefinition leg_4 = body.addOrReplaceChild("leg_4", CubeListBuilder.create().texOffs(3, 7).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 2.5F, 2.5F));

		@SuppressWarnings("unused")
		PartDefinition leg_5 = body.addOrReplaceChild("leg_5", CubeListBuilder.create().texOffs(6, 2).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 2.5F, -3.5F));

		@SuppressWarnings("unused")
		PartDefinition leg_6 = body.addOrReplaceChild("leg_6", CubeListBuilder.create().texOffs(6, 6).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 2.5F, -0.5F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(@NotNull Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		float min = Math.min((float)entity.getDeltaMovement().lengthSqr() * 200.0F, 8.0F);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);
		this.animate(TreasureBeetle.walkAnimationState, TBAAnimationDefinitions.TREASURE_BEETLE_WALK, ageInTicks, min);
		this.animate(TreasureBeetle.idleAnimationState, TBAAnimationDefinitions.TREASURE_BEETLE_IDLE, ageInTicks, min);
	}

	@SuppressWarnings("unused")
	private void applyHeadRotation(float netHeadYaw, float headPitch, float ageInTicks) {
		this.head.yRot = netHeadYaw * 0.017453292F;
		this.head.xRot = headPitch * 0.017453292F;
	}

	@Override
	public @NotNull ModelPart root() {
		return this.root;
	}

	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}