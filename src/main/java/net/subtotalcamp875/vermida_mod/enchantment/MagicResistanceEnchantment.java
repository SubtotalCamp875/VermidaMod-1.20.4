package net.subtotalcamp875.vermida_mod.enchantment;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.ProtectionEnchantment;

public class MagicResistanceEnchantment extends Enchantment {
    public final MagicResistanceEnchantment.Type type;


    protected MagicResistanceEnchantment(Enchantment.Rarity pRarity, MagicResistanceEnchantment.Type pType, EquipmentSlot... pApplicableSlots) {
        super(pRarity, EnchantmentCategory.ARMOR, pApplicableSlots);
        this.type = pType;
    }

    @Override
    public int getDamageProtection(int pLevel, DamageSource pSource) {
        if (this.type == MagicResistanceEnchantment.Type.MAGIC && pSource.is(DamageTypeTags.IS_LIGHTNING)) {
            return pLevel;
        } else {
            return 0;
        }
    }

    @Override
    public int getMaxLevel() {
        return 10;
    }

    @Override
    public int getMinCost(int pEnchantmentLevel) {
        return this.type.getMinCost() + (pEnchantmentLevel - 1) * this.type.getLevelCost();
    }

    @Override
    public boolean checkCompatibility(Enchantment pEnch) {
        if (pEnch instanceof MagicResistanceEnchantment magicResistanceEnchantment) {
            if (this.type == magicResistanceEnchantment.type.MAGIC) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + this.type.getLevelCost();
    }

    public static enum Type {
        MAGIC(1, 11);

        private final int minCost;
        private final int levelCost;

        private Type(int pMinCost, int pLevelCost) {
            this.minCost = pMinCost;
            this.levelCost = pLevelCost;
        }

        public int getMinCost() {
            return this.minCost;
        }

        public int getLevelCost() {
            return this.levelCost;
        }
    }
}
