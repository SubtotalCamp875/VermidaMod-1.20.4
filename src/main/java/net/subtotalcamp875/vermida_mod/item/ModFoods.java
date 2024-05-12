package net.subtotalcamp875.vermida_mod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static  final FoodProperties SHAMAN_BLOOD = new FoodProperties.Builder().alwaysEat()
            .nutrition(1)
            .effect(()-> new MobEffectInstance(MobEffects.POISON, 200), 0.25f).build();
    public static  final FoodProperties SLIGHTLY_CONDENSED_SHAMAN_BLOOD = new FoodProperties.Builder().alwaysEat()
            .nutrition(3)
            .effect(()-> new MobEffectInstance(MobEffects.POISON, 200), 0.50f).build();
    public static  final FoodProperties LIGHTLY_CONDENSED_SHAMAN_BLOOD = new FoodProperties.Builder().alwaysEat()
            .nutrition(4)
            .effect(()-> new MobEffectInstance(MobEffects.POISON, 600), 0.75f).build();
    public static  final FoodProperties CONDENSED_SHAMAN_BLOOD = new FoodProperties.Builder().alwaysEat()
            .nutrition(8)
            .effect(()-> new MobEffectInstance(MobEffects.POISON, 1200), 1f).build();
    public static  final FoodProperties VERY_CONDENSED_SHAMAN_BLOOD = new FoodProperties.Builder().alwaysEat()
            .nutrition(10)
            .effect(()-> new MobEffectInstance(MobEffects.POISON, 2400), 1f).build();
    public static  final FoodProperties EXTREMELY_CONDENSED_SHAMAN_BLOOD = new FoodProperties.Builder().alwaysEat()
            .nutrition(16)
            .effect(()-> new MobEffectInstance(MobEffects.POISON, 6000), 1f).build();


}
