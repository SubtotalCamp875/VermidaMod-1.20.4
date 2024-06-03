package net.subtotalcamp875.vermida_mod.entity.ai;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.subtotalcamp875.vermida_mod.entity.custom.BronzeShamanEntity;
import net.subtotalcamp875.vermida_mod.entity.custom.MagicOrbProjectileEntity;
import org.apache.commons.lang3.ObjectUtils;

public class BronzeShamanAttackSpellGoal extends RangedAttackGoal {
    private static final int ATTACK_RANGE = 25;
    private final BronzeShamanEntity entity;
    private int attackDelay = 20;
    private int attackTick = 0;

    private int ticksUntilNextAttack = 80;
    private boolean shouldCountTillNextAttack = false;

    public BronzeShamanAttackSpellGoal(RangedAttackMob pRangedAttackMob, double pSpeedModifier, int pAttackInterval, float pAttackRadius) {
        super(pRangedAttackMob, pSpeedModifier, pAttackInterval, pAttackRadius);
        this.entity = ((BronzeShamanEntity) pRangedAttackMob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 20;
        attackTick = 0;
        ticksUntilNextAttack = 80;
    }

    @Override
    public void stop() {
        this.entity.setAttacking(false);
        super.stop();
    }

    protected void checkAndPerformAttack(LivingEntity pEnemy) {
        if (isEnemyWithinAttackDistance(pEnemy)) {
            shouldCountTillNextAttack = true;

            if(isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }

            if(isTimeToAttack()) {
                this.entity.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performRangedAttack(pEnemy);
            }
        } else {
            attackTick = 0;
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy) {
        if (pEnemy == null) {
            return false;
        }
        int diffX = Math.abs(pEnemy.getBlockX() - entity.getBlockX());
        int diffY = Math.abs(pEnemy.getBlockY() - entity.getBlockY());;
        int diffZ = Math.abs(pEnemy.getBlockZ() - entity.getBlockZ());;

        return diffX + diffY + diffZ <= this.ATTACK_RANGE; // Make a private int called attack range (I have mine set to 5 and it works alright)
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.adjustedTickDelay(attackDelay * 2);
    }


    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected void performRangedAttack(LivingEntity pEnemy) {
        ++attackTick;
        if (attackTick <= 40) {
            if (attackTick == 40 || attackTick == 30 || attackTick == 20 || attackTick == 10) {
                MagicOrbProjectileEntity magicOrbProjectile = new MagicOrbProjectileEntity(this.entity.level(), this.entity);
                double d0 = pEnemy.getX() - this.entity.getX();
                double d1 = pEnemy.getY(0.3333333333333333D) - magicOrbProjectile.getY();
                double d2 = pEnemy.getZ() - this.entity.getZ();
                double d3 = Math.sqrt(d0 * d0 + d2 * d2);
                magicOrbProjectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.entity.level().getDifficulty().getId() * 4));
                this.entity.playSound(SoundEvents.FIRECHARGE_USE, 1.0F, 1.0F / (this.entity.getRandom().nextFloat() * 0.4F + 0.8F));
                this.entity.level().addFreshEntity(magicOrbProjectile);
            }
        } else {
            this.resetAttackCooldown();
            attackTick = 0;
        }
    }

    protected int getTicksUntilNextAttack() {
        return this.ticksUntilNextAttack;
    }


    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
        this.checkAndPerformAttack(this.entity.getTarget());
    }
}