package net.subtotalcamp875.vermida_mod.damagesource;

import com.mojang.serialization.Codec;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.damagesource.DamageEffects;

public enum ModDamageEffects implements StringRepresentable {
    MAGIC("magic", SoundEvents.PLAYER_TELEPORT);

    public static final Codec<DamageEffects> CODEC = StringRepresentable.fromEnum(DamageEffects::values);
    private final String id;
    private final SoundEvent sound;

    private ModDamageEffects(String pId, SoundEvent pSound) {
        this.id = pId;
        this.sound = pSound;
    }

    public String getSerializedName() {
        return this.id;
    }

    public SoundEvent sound() {
        return this.sound;
    }
}
