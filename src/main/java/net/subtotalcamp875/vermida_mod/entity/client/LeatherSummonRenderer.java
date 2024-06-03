package net.subtotalcamp875.vermida_mod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.subtotalcamp875.vermida_mod.VermidaMod;
import net.subtotalcamp875.vermida_mod.entity.custom.LeatherSummonEntity;

public class LeatherSummonRenderer extends MobRenderer<LeatherSummonEntity, LeatherSummonModel<LeatherSummonEntity>> {

    public LeatherSummonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new LeatherSummonModel<>(pContext.bakeLayer(ModModelLayers.LEATHER_SUMMON_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(LeatherSummonEntity leatherSummonEntity) {
        return new ResourceLocation(VermidaMod.MOD_ID, "textures/entity/leather_summon.png");
    }

    @Override
    public void render(LeatherSummonEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.scale(1.5f,1.5f,1.5f);

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
