package net.subtotalcamp875.vermida_mod.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.subtotalcamp875.vermida_mod.VermidaMod;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, VermidaMod.MOD_ID);

    public static final RegistryObject<SoundEvent> ECHOS_OF_SUMMONS = registerSoundEvents("echos_of_summons");
    public static final RegistryObject<SoundEvent> BRONZE_SHAMAN_CAMP_AMBIENCE = registerSoundEvents("bronze_shaman_camp_ambience");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(VermidaMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}