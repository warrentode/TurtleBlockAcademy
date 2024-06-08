package com.github.warrentode.turtleblockacademy.blocks.entity.renderer;

import com.github.warrentode.turtleblockacademy.blocks.entity.PlateBlockEntity;
import com.github.warrentode.turtleblockacademy.blocks.furniture.PlateBlock;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PlateEntityRenderer implements BlockEntityRenderer<PlateBlockEntity> {
    private final ItemRenderer itemRenderer;

    public PlateEntityRenderer(@NotNull BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(@NotNull PlateBlockEntity plateBlockEntity, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight, int packedOverlay) {
        Direction direction = plateBlockEntity.getBlockState().getValue(PlateBlock.FACING);
        NonNullList<ItemStack> inventory = plateBlockEntity.getItems();
        int i = (int) plateBlockEntity.getBlockPos().asLong();

        for (int j = 0; j < inventory.size(); ++j) {
            ItemStack plateStack = inventory.get(j);

            if (plateStack != ItemStack.EMPTY) {
                poseStack.pushPose();
                poseStack.translate(0.5D, 0.06F, 0.5D);
                float f = direction.getClockWise().getClockWise().toYRot();
                poseStack.mulPose(Vector3f.YP.rotationDegrees(-f));
                poseStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
                poseStack.translate(0.0D, 0.0D, 0.0D);
                poseStack.scale(0.5F, 0.5F, 0.5F);

                if (plateBlockEntity.getLevel() != null) {
                    this.itemRenderer.renderStatic(plateStack,
                            ItemTransforms.TransformType.FIXED,
                            packedLight, packedOverlay,
                            poseStack, buffer, i + j);
                }
                poseStack.popPose();
            }
        }
    }
}