package net.subtotalcamp875.vermida_mod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.subtotalcamp875.vermida_mod.VermidaMod;
import net.subtotalcamp875.vermida_mod.entity.custom.BronzeShamanEntity;

public class BronzeShamanRenderer extends MobRenderer<BronzeShamanEntity, BronzeShamanModel<BronzeShamanEntity>> {

    public BronzeShamanRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BronzeShamanModel(pContext.bakeLayer(ModModelLayers.BRONZE_SHAMAN_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(BronzeShamanEntity bronzeShamanEntity) {
        return new ResourceLocation(VermidaMod.MOD_ID, "textures/entity/bronze_shaman.png");
    }

    @Override
    public void render(BronzeShamanEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.scale(1f,1f,1f);

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
