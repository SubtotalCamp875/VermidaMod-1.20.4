package net.subtotalcamp875.vermida_mod.entity.ai;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.subtotalcamp875.vermida_mod.entity.custom.BronzeShamanEntity;

public class BronzeShamanHealSpellGoal extends RangedAttackGoal { ;
    private final BronzeShamanEntity entity;
    private int healDelay = 70;

    private int ticksUntilNextHeal = 80;
    private boolean shouldCountTillNextHeal = false;

    public BronzeShamanHealSpellGoal(RangedAttackMob pRangedAttackMob, double pSpeedModifier, int pAttackInterval, float pAttackRadius) {
        super(pRangedAttackMob, pSpeedModifier, pAttackInterval, pAttackRadius);
        this.entity = ((BronzeShamanEntity) pRangedAttackMob);
    }


    @Override
    public boolean canUse() {
        if (!super.canUse()) {
            return false;
        } else {
            return this.entity.getHealth() < this.entity.getMaxHealth() / 2;
        }
    }

    @Override
    public void start() {
        super.start();
        healDelay = 70;
        ticksUntilNextHeal = 80;
    }

    @Override
    public void stop() {
        this.entity.setHealing(false);
        super.stop();
    }

    protected void checkAndPerformHeal(LivingEntity pEntity) {
        if (isHealthBelowHalf(pEntity)) {
            shouldCountTillNextHeal = true;

            if(isTimeToStartHealAnimation()) {
                entity.setHealing(true);
            }

            if(isTimeToHeal()) {
                performHeal(pEntity);
            }
        } else {
            resetHealCooldown();
            shouldCountTillNextHeal = false;
            entity.setHealing(false);
            entity.healAnimationTimeout = 0;
        }
    }

    private boolean isHealthBelowHalf(LivingEntity pEntity) {
        return this.entity.getHealth() < this.entity.getMaxHealth() / 2;
    }


    protected void resetHealCooldown() {
        this.ticksUntilNextHeal = this.adjustedTickDelay(healDelay * 4);
    }

    protected boolean isTimeToStartHealAnimation() {
        return this.ticksUntilNextHeal <= healDelay;
    }

    protected boolean isTimeToHeal() {
        return this.ticksUntilNextHeal <= 0;
    }

    protected void performHeal(LivingEntity pEntity) {
        this.resetHealCooldown();
        this.entity.setHealth(this.entity.getHealth() + 20);
    }

    protected int getTicksUntilNextheal() {
        return this.ticksUntilNextHeal;
    }


    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextHeal) {
            this.ticksUntilNextHeal = Math.max(this.ticksUntilNextHeal - 1, 0);
        }
        this.checkAndPerformHeal(this.entity);
    }
}