package com.github.warrentode.turtleblockacademy.blocks.renderer;

import com.github.warrentode.turtleblockacademy.blocks.SchoolDeskBlock;
import com.github.warrentode.turtleblockacademy.blocks.entity.SchoolDeskBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.BookModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.EnchantTableRenderer;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class SchoolDeskRenderer implements BlockEntityRenderer<SchoolDeskBlockEntity> {
    private final BookModel bookModel;

    public SchoolDeskRenderer(@NotNull BlockEntityRendererProvider.Context context) {
        this.bookModel = new BookModel(context.bakeLayer(ModelLayers.BOOK));
    }

    @Override
    public void render(@NotNull SchoolDeskBlockEntity schoolDeskBlockEntity, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        BlockState state = schoolDeskBlockEntity.getBlockState();
        if (state.getValue(SchoolDeskBlock.HAS_BOOK)) {
            poseStack.pushPose();
            poseStack.translate(0.5D, 1.0D, 0.5D);
            float f = state.getValue(SchoolDeskBlock.FACING).getClockWise().toYRot();
            poseStack.mulPose(Vector3f.YP.rotationDegrees(-f));
            poseStack.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
            poseStack.translate(0.0D, 0.0D, 0.0D);
            this.bookModel.setupAnim(0.0F, 0.1F, 0.9F, 1.2F);
            VertexConsumer consumer = EnchantTableRenderer.BOOK_LOCATION.buffer(bufferSource, RenderType::entitySolid);
            this.bookModel.render(poseStack, consumer, packedLight, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
            poseStack.popPose();
        }
    }
}
