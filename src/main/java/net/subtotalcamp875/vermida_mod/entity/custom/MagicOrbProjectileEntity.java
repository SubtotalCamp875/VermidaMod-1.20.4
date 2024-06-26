package net.subtotalcamp875.vermida_mod.entity.custom;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.subtotalcamp875.vermida_mod.entity.ModEntities;
import net.subtotalcamp875.vermida_mod.item.ModItems;

import java.util.Set;

public class MagicOrbProjectileEntity extends ThrowableItemProjectile {
    public MagicOrbProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public MagicOrbProjectileEntity(Level pLevel, LivingEntity pShooter) {
        super(ModEntities.MAGIC_ORB.get(), pShooter, pLevel);
    }

    public MagicOrbProjectileEntity(Level pLevel, double pX, double pY, double pZ) {
        super(ModEntities.MAGIC_ORB.get(), pX, pY, pZ, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.MAGIC_ORB.get();
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        Entity entity1 = this.getOwner();
        LivingEntity livingentity = entity1 instanceof LivingEntity ? (LivingEntity)entity1 : null;
        if (!(entity instanceof BronzeShamanEntity)) {
            boolean flag = entity.hurt(this.damageSources().lightningBolt(), 25.0F);
        }
    }


    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }
}