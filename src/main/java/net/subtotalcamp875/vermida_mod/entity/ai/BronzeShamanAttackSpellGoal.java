package net.subtotalcamp875.vermida_mod.entity.ai;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.subtotalcamp875.vermida_mod.entity.custom.BronzeShamanEntity;
import net.subtotalcamp875.vermida_mod.entity.custom.MagicOrbProjectileEntity;


import java.util.EnumSet;

public class BronzeShamanAttackSpellGoal extends MeleeAttackGoal {
    private static final int ATTACK_RANGE = 15;
    private final BronzeShamanEntity entity;
    private int attackDelay = 20;
    private int attackPhase = 40;
    private int ticksUntilNextAttack = 60;
    private boolean shouldCountTillNextAttack = false;

    public BronzeShamanAttackSpellGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        this.entity = ((BronzeShamanEntity) pMob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 20;
        attackPhase = 40;
        ticksUntilNextAttack = 80;
    }

    @Override
    public void stop() {
        this.entity.setAttacking(false);
        super.stop();
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy) {
        if (isEnemyWithinAttackDistance(pEnemy)) {
            shouldCountTillNextAttack = true;

            if(isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }

            if(isTimeToAttack()) {
                this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performAttack(pEnemy);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy) {
        int diffX = Math.abs(pEnemy.getBlockX() - entity.getBlockX());
        int diffY = Math.abs(pEnemy.getBlockY() - entity.getBlockY());;
        int diffZ = Math.abs(pEnemy.getBlockZ() - entity.getBlockZ());;

        return diffX + diffY + diffZ <= this.ATTACK_RANGE; // Make a private int called attack range (I have mine set to 5 and it works alright)
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.adjustedTickDelay(attackDelay * 4);
    }


    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();

        //if (this.ticksUntilNextAttack == 80 || this.ticksUntilNextAttack == 70 || this.ticksUntilNextAttack == 60 || this.ticksUntilNextAttack == 50) {
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
    }
}