package net.subtotalcamp875.vermida_mod.damagesource;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;


public interface ModDamageTypes {
    ResourceKey<DamageType> MAGIC_DAMAGE =
            ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("magic_damage"));

    static void bootstrap(BootstapContext<DamageType> pContext) {
        pContext.register(MAGIC_DAMAGE, new DamageType("magicDamage", 0.1F));
    }
}