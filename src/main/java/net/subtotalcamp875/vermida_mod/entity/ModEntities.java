package net.subtotalcamp875.vermida_mod.entity;

import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.subtotalcamp875.vermida_mod.VermidaMod;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.subtotalcamp875.vermida_mod.entity.custom.LeatherSummonEntity;

public class ModEntities {
    public static  final DeferredRegister<EntityType<?>> ENTITY_TYPE =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, VermidaMod.MOD_ID);

    public static final RegistryObject<EntityType<LeatherSummonEntity>> LEATHER_SUMMON =
            ENTITY_TYPE.register("leather_summon", () -> EntityType.Builder.of(LeatherSummonEntity::new, MobCategory.CREATURE)
                    .sized(1f, 2f).build("leather_summon"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPE.register(eventBus);
    }
}
