package net.subtotalcamp875.vermida_mod.entity.client;// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


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
import net.subtotalcamp875.vermida_mod.entity.animations.ModAnimationDefinitions;
import net.subtotalcamp875.vermida_mod.entity.custom.BronzeShamanEntity;

public class BronzeShamanModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "modded_entity"), "main");
	private final ModelPart bronze_shaman_entity;
	private final ModelPart head;
	private final ModelPart hat;
	private final ModelPart body;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart bronze_staff;
	private final ModelPart staff_arch;
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart healing;
	private final ModelPart circle;
	private final ModelPart circle_1;
	private final ModelPart circle_2;
	private final ModelPart circle_3;
	private final ModelPart circle_4;
	private final ModelPart circle_5;
	private final ModelPart circle_6;
	private final ModelPart circle_7;
	private final ModelPart circle_8;
	private final ModelPart healing_particles;
	private final ModelPart particle_1;
	private final ModelPart particle_2;
	private final ModelPart particle_3;
	private final ModelPart particle_4;
	private final ModelPart particle_5;
	private final ModelPart particle_6;
	private final ModelPart attacking;
	private final ModelPart attacking_particles;
	private final ModelPart particle_7;
	private final ModelPart particle_8;
	private final ModelPart particle_9;
	private final ModelPart particle_10;
	private final ModelPart particle_11;
	private final ModelPart particle_12;

	public BronzeShamanModel(ModelPart root) {
		this.bronze_shaman_entity = root.getChild("bronze_shaman_entity");
		this.head = bronze_shaman_entity.getChild("head");
		this.hat = head.getChild("hat");
		this.body = bronze_shaman_entity.getChild("body");
		this.left_arm = bronze_shaman_entity.getChild("left_arm");
		this.right_arm = bronze_shaman_entity.getChild("right_arm");
		this.bronze_staff = right_arm.getChild("bronze_staff");
		this.staff_arch = bronze_staff.getChild("staff_arch");
		this.left_leg = bronze_shaman_entity.getChild("left_leg");
		this.right_leg = bronze_shaman_entity.getChild("right_leg");
		this.healing = bronze_shaman_entity.getChild("healing");
		this.circle = healing.getChild("circle");
		this.circle_1 = circle.getChild("circle_1");
		this.circle_2 = circle.getChild("circle_2");
		this.circle_3 = circle.getChild("circle_3");
		this.circle_4 = circle.getChild("circle_4");
		this.circle_5 = circle.getChild("circle_5");
		this.circle_6 = circle.getChild("circle_6");
		this.circle_7 = circle.getChild("circle_7");
		this.circle_8 = circle.getChild("circle_8");
		this.healing_particles = healing.getChild("healing_particles");
		this.particle_1 = healing_particles.getChild("particle_1");
		this.particle_2 = healing_particles.getChild("particle_2");
		this.particle_3 = healing_particles.getChild("particle_3");
		this.particle_4 = healing_particles.getChild("particle_4");
		this.particle_5 = healing_particles.getChild("particle_5");
		this.particle_6 = healing_particles.getChild("particle_6");
		this.attacking = bronze_shaman_entity.getChild("attacking");
		this.attacking_particles = attacking.getChild("attacking_particles");
		this.particle_7 = attacking_particles.getChild("particle_7");
		this.particle_8 = attacking_particles.getChild("particle_8");
		this.particle_9 = attacking_particles.getChild("particle_9");
		this.particle_10 = attacking_particles.getChild("particle_10");
		this.particle_11 = attacking_particles.getChild("particle_11");
		this.particle_12 = attacking_particles.getChild("particle_12");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bronze_shaman_entity = partdefinition.addOrReplaceChild("bronze_shaman_entity", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = bronze_shaman_entity.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(24, 42).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition base4_r1 = hat.addOrReplaceChild("base4_r1", CubeListBuilder.create().texOffs(18, 45).addBox(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -16.0F, 3.0F, -0.1745F, 0.0F, 0.1745F));

		PartDefinition base3_r1 = hat.addOrReplaceChild("base3_r1", CubeListBuilder.create().texOffs(18, 44).addBox(-3.0F, -3.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -13.0F, 0.0F, -0.1309F, 0.0F, 0.0873F));

		PartDefinition base2_r1 = hat.addOrReplaceChild("base2_r1", CubeListBuilder.create().texOffs(34, 31).addBox(-7.0F, -4.0F, -1.0F, 8.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.0F, -2.0F, -0.0873F, 0.0F, 0.0436F));

		PartDefinition body = bronze_shaman_entity.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition left_arm = bronze_shaman_entity.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(24, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -22.0F, 0.0F));

		PartDefinition right_arm = bronze_shaman_entity.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, -22.0F, 0.0F));

		PartDefinition right_arm_r1 = right_arm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(24, 16).mirror().addBox(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 11.0F, -19.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition bronze_staff = right_arm.addOrReplaceChild("bronze_staff", CubeListBuilder.create(), PartPose.offset(-1.0F, 4.0F, -7.0F));

		PartDefinition staffbase_r1 = bronze_staff.addOrReplaceChild("staffbase_r1", CubeListBuilder.create().texOffs(0, 42).addBox(-1.0F, -16.0F, -1.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 3.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition orb_r1 = bronze_staff.addOrReplaceChild("orb_r1", CubeListBuilder.create().texOffs(0, 37).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, -2.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition staff_arch = bronze_staff.addOrReplaceChild("staff_arch", CubeListBuilder.create().texOffs(9, 43).addBox(-7.0F, -31.0F, -6.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 18.0F, 7.0F));

		PartDefinition arch6_r1 = staff_arch.addOrReplaceChild("arch6_r1", CubeListBuilder.create().texOffs(18, 52).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -34.0F, -9.0F, 1.4399F, 0.0F, 0.0F));

		PartDefinition arch5_r1 = staff_arch.addOrReplaceChild("arch5_r1", CubeListBuilder.create().texOffs(18, 58).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -32.0F, -6.0F, 0.9163F, 0.0F, 0.0F));

		PartDefinition arch4_r1 = staff_arch.addOrReplaceChild("arch4_r1", CubeListBuilder.create().texOffs(9, 36).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -30.0F, -5.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition arch2_r1 = staff_arch.addOrReplaceChild("arch2_r1", CubeListBuilder.create().texOffs(9, 50).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -26.0F, -6.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition arch1_r1 = staff_arch.addOrReplaceChild("arch1_r1", CubeListBuilder.create().texOffs(9, 57).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -24.0F, -10.0F, -1.1345F, 0.0F, 0.0F));

		PartDefinition left_leg = bronze_shaman_entity.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.9F, -12.0F, 0.0F));

		PartDefinition right_leg = bronze_shaman_entity.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(32, 0).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, -12.0F, 0.0F));

		PartDefinition healing = bronze_shaman_entity.addOrReplaceChild("healing", CubeListBuilder.create(), PartPose.offset(0.0F, -19.0F, 0.0F));

		PartDefinition circle = healing.addOrReplaceChild("circle", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition circle_1 = circle.addOrReplaceChild("circle_1", CubeListBuilder.create().texOffs(48, 0).addBox(-3.0F, -2.0F, 7.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition circle_2 = circle.addOrReplaceChild("circle_2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition circle2_r1 = circle_2.addOrReplaceChild("circle2_r1", CubeListBuilder.create().texOffs(50, 0).addBox(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.0F, 5.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition circle_3 = circle.addOrReplaceChild("circle_3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition circle3_r1 = circle_3.addOrReplaceChild("circle3_r1", CubeListBuilder.create().texOffs(48, 0).addBox(-4.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 1.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition circle_4 = circle.addOrReplaceChild("circle_4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition circle4_r1 = circle_4.addOrReplaceChild("circle4_r1", CubeListBuilder.create().texOffs(50, 0).addBox(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.0F, -5.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition circle_5 = circle.addOrReplaceChild("circle_5", CubeListBuilder.create().texOffs(48, 0).addBox(-3.0F, -2.0F, -9.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition circle_6 = circle.addOrReplaceChild("circle_6", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition circle6_r1 = circle_6.addOrReplaceChild("circle6_r1", CubeListBuilder.create().texOffs(50, 0).addBox(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.0F, -7.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition circle_7 = circle.addOrReplaceChild("circle_7", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition circle7_r1 = circle_7.addOrReplaceChild("circle7_r1", CubeListBuilder.create().texOffs(48, 0).addBox(-4.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, 1.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition circle_8 = circle.addOrReplaceChild("circle_8", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition circle8_r1 = circle_8.addOrReplaceChild("circle8_r1", CubeListBuilder.create().texOffs(50, 0).addBox(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.0F, 7.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition healing_particles = healing.addOrReplaceChild("healing_particles", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition particle_1 = healing_particles.addOrReplaceChild("particle_1", CubeListBuilder.create().texOffs(58, 1).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition particle_2 = healing_particles.addOrReplaceChild("particle_2", CubeListBuilder.create().texOffs(58, 1).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition particle_3 = healing_particles.addOrReplaceChild("particle_3", CubeListBuilder.create().texOffs(58, 1).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition particle_4 = healing_particles.addOrReplaceChild("particle_4", CubeListBuilder.create().texOffs(58, 1).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition particle_5 = healing_particles.addOrReplaceChild("particle_5", CubeListBuilder.create().texOffs(58, 1).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition particle_6 = healing_particles.addOrReplaceChild("particle_6", CubeListBuilder.create().texOffs(58, 1).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition attacking = bronze_shaman_entity.addOrReplaceChild("attacking", CubeListBuilder.create(), PartPose.offset(0.0F, -17.0F, 0.0F));

		PartDefinition attacking_particles = attacking.addOrReplaceChild("attacking_particles", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition particle_7 = attacking_particles.addOrReplaceChild("particle_7", CubeListBuilder.create().texOffs(60, 6).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition particle_8 = attacking_particles.addOrReplaceChild("particle_8", CubeListBuilder.create().texOffs(60, 6).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition particle_9 = attacking_particles.addOrReplaceChild("particle_9", CubeListBuilder.create().texOffs(60, 6).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition particle_10 = attacking_particles.addOrReplaceChild("particle_10", CubeListBuilder.create().texOffs(60, 6).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition particle_11 = attacking_particles.addOrReplaceChild("particle_11", CubeListBuilder.create().texOffs(60, 6).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition particle_12 = attacking_particles.addOrReplaceChild("particle_12", CubeListBuilder.create().texOffs(60, 6).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.BRONZE_SHAMAN_WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((BronzeShamanEntity) entity).idleAnimationState, ModAnimationDefinitions.BRONZE_SHAMAN_IDLE, ageInTicks, 1f);
		this.animate(((BronzeShamanEntity) entity).attackAnimationState, ModAnimationDefinitions.BRONZE_SHAMAN_ATTACKING, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0f, 30.0f);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0f, 45.0f);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180f);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bronze_shaman_entity.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return bronze_shaman_entity;
	}
}