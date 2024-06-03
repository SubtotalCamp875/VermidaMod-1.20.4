package net.subtotalcamp875.vermida_mod.entity.custom;

import net.minecraft.client.player.inventory.Hotbar;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.subtotalcamp875.vermida_mod.entity.ModEntities;
import net.subtotalcamp875.vermida_mod.entity.ai.BronzeShamanAttackSpellGoal;
import net.subtotalcamp875.vermida_mod.entity.ai.BronzeShamanHealSpellGoal;
import net.subtotalcamp875.vermida_mod.item.ModItems;
import org.jetbrains.annotations.Nullable;

public class BronzeShamanEntity extends Monster implements RangedAttackMob {
    public static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(BronzeShamanEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> HEALING =
            SynchedEntityData.defineId(BronzeShamanEntity.class, EntityDataSerializers.BOOLEAN);

    public BronzeShamanEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.isInvulnerableTo(damageSources().lightningBolt());
        this.xpReward = 10;
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public final AnimationState healAnimationState = new AnimationState();
    public int healAnimationTimeout = 0;

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.IsAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 80;
            attackAnimationState.start(this.tickCount);
            this.setPose(Pose.SHOOTING);
            this.idleAnimationState.stop();
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
        } else {
            --this.attackAnimationTimeout;
        }

        if(!this.IsAttacking()) {
            attackAnimationState.stop();
            this.setPose(Pose.STANDING);
        }

        if (this.IsHealing() && healAnimationTimeout <= 0) {
            healAnimationTimeout = 80;
            healAnimationState.start(this.tickCount);
            this.setPose(Pose.SHOOTING);
            this.idleAnimationState.stop();
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
        } else {
            --this.healAnimationTimeout;
        }

        if(!this.IsHealing()) {
            healAnimationState.stop();
            this.setPose(Pose.STANDING);
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public void setHealing(boolean healing) {
        this.entityData.set(HEALING, healing);
    }

    public boolean IsAttacking() {
        return this.entityData.get(ATTACKING);
    }
    public boolean IsHealing() {
        return this.entityData.get(HEALING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
        this.entityData.define(HEALING, false);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 2.0F, 2.0D, 2.0D));
        this.goalSelector.addGoal(2, new BronzeShamanHealSpellGoal(this, 1.0, 80, 25));
        this.goalSelector.addGoal(3, new BronzeShamanAttackSpellGoal(this, 1.0, 80, 35));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 5.0F, 1.0F));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Mob.class, 8.0F));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, ModEntities.BRONZE_SHAMAN.getClass())).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true).setUnseenMemoryTicks(300));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 40)
                .add(Attributes.ATTACK_DAMAGE, 0)
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.1)
                .add(Attributes.ATTACK_SPEED, 0.5)
                .add(Attributes.FOLLOW_RANGE, 15.0F);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.EVOKER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.EVOKER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.EVOKER_DEATH;
    }

    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.MAGIC_ORB.get()));
    }

    @Override
    public void performRangedAttack(LivingEntity pTarget, float pVelocity) {}
}
