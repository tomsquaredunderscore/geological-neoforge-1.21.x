package net.tomsquared.geological.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.tomsquared.geological.CattailSeedProjectile;

public class CattailSeedRenderer extends EntityRenderer<CattailSeedProjectile> {
    private final ItemRenderer itemRenderer;

    public CattailSeedRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(CattailSeedProjectile entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

        poseStack.scale(0.5F, 0.5F, 0.5F);

        float currentYaw = Mth.lerp(partialTicks, entity.yRotO, entity.getYRot());
        float currentPitch = Mth.lerp(partialTicks, entity.xRotO, entity.getXRot());

        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - currentYaw));
        poseStack.mulPose(Axis.XP.rotationDegrees(-currentPitch));

        this.itemRenderer.renderStatic(entity.getItem(), ItemDisplayContext.GROUND, packedLight,
                0, poseStack, buffer, entity.level(), entity.getId());

        poseStack.popPose();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(CattailSeedProjectile entity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}