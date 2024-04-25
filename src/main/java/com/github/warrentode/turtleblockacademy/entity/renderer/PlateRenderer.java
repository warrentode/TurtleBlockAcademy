package com.github.warrentode.turtleblockacademy.entity.renderer;

import com.github.warrentode.turtleblockacademy.items.ModItems;
import com.github.warrentode.turtleblockacademy.items.entity.PlateEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class PlateRenderer<T extends PlateEntity> extends EntityRenderer<T> {
    private static final ModelResourceLocation FRAME_LOCATION = new ModelResourceLocation("plate", "map=false");
    private static final ModelResourceLocation MAP_FRAME_LOCATION = new ModelResourceLocation("plate", "map=true");
    private final ItemRenderer itemRenderer;
    private final BlockRenderDispatcher blockRenderer;

    public PlateRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
        this.blockRenderer = context.getBlockRenderDispatcher();
    }

    public void render(@NotNull T entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource source, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, source, packedLight);
        poseStack.pushPose();
        Direction direction = entity.getDirection();
        Vec3 vec3 = this.getRenderOffset(entity, partialTicks);
        poseStack.translate(-vec3.x(), -vec3.y(), -vec3.z());
        //noinspection unused
        double d0 = 0.46875D;
        poseStack.translate((double) direction.getStepX() * 0.46875D, (double) direction.getStepY() * 0.46875D, (double) direction.getStepZ() * 0.46875D);
        poseStack.mulPose(Vector3f.XP.rotationDegrees(entity.getXRot()));
        poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - entity.getYRot()));
        boolean flag = entity.isInvisible();
        ItemStack itemSavedData = entity.getItem();
        if (!flag) {
            ModelManager modelManager = this.blockRenderer.getBlockModelShaper().getModelManager();
            ModelResourceLocation modelResourceLocation =
                    entity.getItem().getItem() instanceof MapItem ? MAP_FRAME_LOCATION : FRAME_LOCATION;
            poseStack.pushPose();
            poseStack.translate(-0.5D, -0.5D, -0.5D);
            //noinspection deprecation
            this.blockRenderer.getModelRenderer().renderModel(poseStack.last(),
                    source.getBuffer(Sheets.solidBlockSheet()),
                    null, modelManager.getModel(modelResourceLocation),
                    1.0F, 1.0F, 1.0F, packedLight, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();
        }

        if (!itemSavedData.isEmpty()) {
            MapItemSavedData mapItemSavedData = MapItem.getSavedData(itemSavedData, entity.level);
            if (flag) {
                poseStack.translate(0.0D, 0.0D, 0.5D);
            }
            else {
                poseStack.translate(0.0D, 0.0D, 0.4375D);
            }

            int j = mapItemSavedData != null ? entity.getRotation() % 4 * 2 : entity.getRotation();
            poseStack.mulPose(Vector3f.ZP.rotationDegrees((float) j * 360.0F / 8.0F));

            if (mapItemSavedData != null) {
                poseStack.mulPose(Vector3f.ZP.rotationDegrees(180.0F));
                //noinspection unused
                float f = 0.0078125F;
                poseStack.scale(0.0078125F, 0.0078125F, 0.0078125F);
                poseStack.translate(-64.0D, -64.0D, 0.0D);
                poseStack.translate(0.0D, 0.0D, -1.0D);
                if (entity.getFramedMapId().isPresent()) {
                    Minecraft.getInstance().gameRenderer.getMapRenderer()
                            .render(poseStack, source, entity.getFramedMapId().getAsInt(),
                                    mapItemSavedData, true, packedLight);
                }
            }
            else {
                poseStack.scale(0.5F, 0.5F, 0.5F);
                this.itemRenderer.renderStatic(itemSavedData,
                        ItemTransforms.TransformType.FIXED, packedLight,
                        OverlayTexture.NO_OVERLAY, poseStack, source,
                        entity.getId());
            }
        }

        poseStack.popPose();
    }

    public @NotNull Vec3 getRenderOffset(@NotNull T entity, float ignoredPartialTicks) {
        return new Vec3((float) entity.getDirection().getStepX() * 0.3F, -0.25D,
                (float) entity.getDirection().getStepZ() * 0.3F);
    }

    /** Returns the location of an entity's texture. */
    public @NotNull ResourceLocation getTextureLocation(@NotNull T entity) {
        if (entity.getItem() == ModItems.PLATE_WHITE.get().getDefaultInstance()) {
            return ModItems.PLATE_WHITE.getId();
        }
        else {
            return ModItems.PLATE_ITEM.getId();
        }
    }

    protected boolean shouldShowName(@NotNull T entity) {
        if (Minecraft.renderNames() && !entity.getItem().isEmpty() &&
                entity.getItem().hasCustomHoverName() &&
                this.entityRenderDispatcher.crosshairPickEntity == entity) {
            double d0 = this.entityRenderDispatcher.distanceToSqr(entity);
            float f = entity.isDiscrete() ? 32.0F : 64.0F;
            return d0 < (double) (f * f);
        }
        else {
            return false;
        }
    }

    protected void renderNameTag(@NotNull T entity, @NotNull Component displayName, @NotNull PoseStack poseStack, @NotNull MultiBufferSource source, int packedLight) {
        super.renderNameTag(entity, entity.getItem().getHoverName(), poseStack, source, packedLight);
    }
}
