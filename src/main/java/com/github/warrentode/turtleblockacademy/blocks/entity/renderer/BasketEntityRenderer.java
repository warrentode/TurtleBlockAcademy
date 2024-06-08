package com.github.warrentode.turtleblockacademy.blocks.entity.renderer;

import com.github.warrentode.turtleblockacademy.blocks.entity.BasketBlockEntity;
import com.github.warrentode.turtleblockacademy.blocks.furniture.BasketBlock;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class BasketEntityRenderer implements BlockEntityRenderer<BasketBlockEntity> {
    private static final float ITEM_SIZE = 0.40F;
    private static final float BASKET_BOTTOM = 0.3F;
    private static final double X_START = 0.25D;
    private static final double Z_START = 0.23D;

    private final ItemRenderer itemRenderer;

    public BasketEntityRenderer(@NotNull BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(@NotNull BasketBlockEntity basketEntity, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight, int packedOverlay) {
        int pos = (int) basketEntity.getBlockPos().asLong();
        Direction direction = basketEntity.getBlockState().getValue(BasketBlock.FACING);
        Quaternion ITEM_Y_AXIS_ROTATION_SETUP = Vector3f.YP.rotationDegrees(-direction.getClockWise().getClockWise().toYRot());
        Quaternion ITEM_X_AXIS_ROTATION_SETUP = Vector3f.XP.rotationDegrees(90.0F);
        Quaternion ITEM_X_AXIS_ROTATION_ADJUSTMENT = Vector3f.XP.rotationDegrees(-50.0F);
        ItemTransforms.TransformType TRANSFORMS = ItemTransforms.TransformType.FIXED;
        int overlay = OverlayTexture.NO_OVERLAY;
        int light = addLight(Objects.requireNonNull(basketEntity.getLevel()), BlockPos.of(pos));

        ItemStackHandler inventory = basketEntity.getItems();

        for (int j = 0; j < inventory.getSlots(); ++j) {
            ItemStack renderStack = inventory.getStackInSlot(j);

            if (renderStack != ItemStack.EMPTY) {
                poseStack.pushPose();

                int ITEMS_PER_ROW = 3;
                int row = j / ITEMS_PER_ROW;
                int column = j % ITEMS_PER_ROW;
                double ITEM_HORIZONTAL_SPACING = 0.25D;
                double offsetX = X_START + column * ITEM_HORIZONTAL_SPACING;
                double ITEM_VERTICAL_SPACING = 0.23D;
                double offsetZ = Z_START + row * ITEM_VERTICAL_SPACING;

                poseStack.translate(offsetX, BASKET_BOTTOM, offsetZ);
                poseStack.mulPose(ITEM_Y_AXIS_ROTATION_SETUP);
                poseStack.mulPose(ITEM_X_AXIS_ROTATION_SETUP);
                poseStack.translate(0.0D, 0.0D, 0.0D);
                poseStack.scale(ITEM_SIZE, ITEM_SIZE, ITEM_SIZE);
                poseStack.mulPose(ITEM_X_AXIS_ROTATION_ADJUSTMENT);

                if (basketEntity.getLevel() != null) {
                    this.itemRenderer.renderStatic(renderStack,
                            TRANSFORMS, light, overlay,
                            poseStack, buffer, pos + j);
                }
                poseStack.popPose();
            }
        }
    }

    private static int addLight(@NotNull Level level, BlockPos pos) {
        int blockLight = level.getBrightness(LightLayer.BLOCK, pos);
        int skyLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(blockLight, skyLight);
    }
}