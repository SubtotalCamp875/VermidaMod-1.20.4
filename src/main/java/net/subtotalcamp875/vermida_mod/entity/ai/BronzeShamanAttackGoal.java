package net.subtotalcamp875.vermida_mod.entity.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import net.minecraft.world.entity.projectile.EvokerFangs;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.subtotalcamp875.vermida_mod.entity.custom.BronzeShamanEntity;
import net.subtotalcamp875.vermida_mod.entity.custom.LeatherSummonEntity;

/***
public class BronzeShamanAttackGoal extends SpellcasterIllager.SpellcasterUseSpellGoal {
    private static final int ATTACK_RANGE = ;
    private final BronzeShamanEntity entity;
    private int attackDelay = ;
    private int ticksUntilNextAttack = ;
    private boolean shouldCountTillNextAttack = false;


    public BronzeShamanAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        protected int getCastingTime () {
            return 40;
        }

        protected int getCastingInterval () {
            return 100;
        }

        protected void performSpellCasting () {
            LivingEntity livingentity = Evoker.this.getTarget();
            double d0 = Math.min(livingentity.getY(), Evoker.this.getY());
            double d1 = Math.max(livingentity.getY(), Evoker.this.getY()) + 1.0D;
            float f = (float) Mth.atan2(livingentity.getZ() - Evoker.this.getZ(), livingentity.getX() - Evoker.this.getX());
            if (Evoker.this.distanceToSqr(livingentity) < 9.0D) {
                for (int i = 0; i < 5; ++i) {
                    float f1 = f + (float) i * (float) Math.PI * 0.4F;
                    this.createSpellEntity(Evoker.this.getX() + (double) Mth.cos(f1) * 1.5D, Evoker.this.getZ() + (double) Mth.sin(f1) * 1.5D, d0, d1, f1, 0);
                }

                for (int k = 0; k < 8; ++k) {
                    float f2 = f + (float) k * (float) Math.PI * 2.0F / 8.0F + 1.2566371F;
                    this.createSpellEntity(Evoker.this.getX() + (double) Mth.cos(f2) * 2.5D, Evoker.this.getZ() + (double) Mth.sin(f2) * 2.5D, d0, d1, f2, 3);
                }
            } else {
                for (int l = 0; l < 16; ++l) {
                    double d2 = 1.25D * (double) (l + 1);
                    int j = 1 * l;
                    this.createSpellEntity(Evoker.this.getX() + (double) Mth.cos(f) * d2, Evoker.this.getZ() + (double) Mth.sin(f) * d2, d0, d1, f, j);
                }
            }

        }


        private void createSpellEntity(double pX, double pZ, double pMinY, double pMaxY, float pYRot, int pWarmupDelay) {
            BlockPos blockpos = BlockPos.containing(pX, pMaxY, pZ);
            boolean flag = false;
            double d0 = 0.0D;

            do {
                BlockPos blockpos1 = blockpos.below();
                BlockState blockstate = Evoker.this.level().getBlockState(blockpos1);
                if (blockstate.isFaceSturdy(Evoker.this.level(), blockpos1, Direction.UP)) {
                    if (!Evoker.this.level().isEmptyBlock(blockpos)) {
                        BlockState blockstate1 = Evoker.this.level().getBlockState(blockpos);
                        VoxelShape voxelshape = blockstate1.getCollisionShape(Evoker.this.level(), blockpos);
                        if (!voxelshape.isEmpty()) {
                            d0 = voxelshape.max(Direction.Axis.Y);
                        }
                    }

                    flag = true;
                    break;
                }

                blockpos = blockpos.below();
            } while(blockpos.getY() >= Mth.floor(pMinY) - 1);

            if (flag) {
                Evoker.this.level().addFreshEntity(new EvokerFangs(Evoker.this.level(), pX, (double)blockpos.getY() + d0, pZ, pYRot, pWarmupDelay, Evoker.this));
                Evoker.this.level().gameEvent(GameEvent.ENTITY_PLACE, new Vec3(pX, (double)blockpos.getY() + d0, pZ), GameEvent.Context.of(Evoker.this));
            }

        }

        protected SoundEvent getSpellPrepareSound() {
            return SoundEvents.EVOKER_PREPARE_ATTACK;
        }

        protected SpellcasterIllager.IllagerSpell getSpell() {
            return SpellcasterIllager.IllagerSpell.FANGS;
        }
    }

    protected int getCastingTime() {
        return 100;
    }

    protected int getCastingInterval() {
        return 340;
    }

    @Override
    public void start() {
        super.start();
        attackDelay = ;
        ticksUntilNextAttack = ;
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
        this.ticksUntilNextAttack = this.adjustedTickDelay(attackDelay * 2);
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected int getTicksUntilNextAttack() {
        return this.ticksUntilNextAttack;
    }


    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.swing(InteractionHand.MAIN_HAND);
        this.mob.doHurtTarget(pEnemy);
        -
    }

    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }

}
        ***/