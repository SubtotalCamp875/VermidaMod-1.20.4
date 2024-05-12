package net.subtotalcamp875.vermida_mod.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.subtotalcamp875.vermida_mod.VermidaMod;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    SUMMONING_CRYSTAL("summoning_crystal", 26, new int[]{ 5, 7, 5, 4 }, 25,
            SoundEvents.ARMOR_EQUIP_GOLD, 1f, 0f, () -> Ingredient.of(ModItems.SUMMONING_CRYSTAL.get()));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmoutns;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbaclResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 16, 13 }
;

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmoutns, int enchantmentValue, SoundEvent equipSound,
                      float toughness, float knockbaclResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmoutns = protectionAmoutns;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbaclResistance = knockbaclResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmoutns[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return VermidaMod.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbaclResistance;
    }
}