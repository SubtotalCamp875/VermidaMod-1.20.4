package net.subtotalcamp875.vermida_mod.item.custom;

import net.subtotalcamp875.vermida_mod.entity.custom.MagicOrbProjectileEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MagicOrbProjectileItem extends Item {
    public MagicOrbProjectileItem(Properties pProperties) {
        super(pProperties);
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
                SoundEvents.FIRECHARGE_USE, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));

        if (!pLevel.isClientSide) {
            MagicOrbProjectileEntity magicOrb = new MagicOrbProjectileEntity(pLevel, pPlayer);
            magicOrb.setItem(itemstack);
            magicOrb.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 0.5F);
            pLevel.addFreshEntity(magicOrb);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }
}