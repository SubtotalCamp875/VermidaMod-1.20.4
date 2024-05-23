package net.subtotalcamp875.vermida_mod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.subtotalcamp875.vermida_mod.entity.animations.ModAnimationDefinisions;
import net.subtotalcamp875.vermida_mod.entity.custom.LeatherSummonEntity;

public class LeatherSummonModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart leather_summon;
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart left_arm;
	private final ModelPart right_leg;
	private final ModelPart left_leg;
	private final ModelPart right_arm;

	public LeatherSummonModel(ModelPart root) {
		this.leather_summon = root.getChild("leather_summon");
		this.head = leather_summon.getChild("head");
		this.body = leather_summon.getChild("body");
		this.left_arm = leather_summon.getChild("left_arm");
		this.right_leg = leather_summon.getChild("right_leg");
		this.left_leg = leather_summon.getChild("left_leg");
		this.right_arm = leather_summon.getChild("right_arm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition leather_summon = partdefinition.addOrReplaceChild("leather_summon", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = leather_summon.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition body = leather_summon.addOrReplaceChild("body", CubeListBuilder.create().texOffs(28, 28).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition left_arm = leather_summon.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, -22.0F, 0.0F));

		PartDefinition right_leg = leather_summon.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 32).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, -12.0F, 0.0F));

		PartDefinition left_leg = leather_summon.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.9F, -12.0F, 0.0F));

		PartDefinition right_arm = leather_summon.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(32, 0).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -22.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinisions.WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((LeatherSummonEntity) entity).idleAnimationState, ModAnimationDefinisions.IDLE, ageInTicks, 1f);
		this.animate(((LeatherSummonEntity) entity).attackAnimationState, ModAnimationDefinisions.MELEE_LAUNCH_ATTACK, ageInTicks, 1f);
	}


	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0f, 30.0f);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0f, 45.0f);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180f);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180f);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		leather_summon.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return leather_summon;
	}
}