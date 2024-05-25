package net.subtotalcamp875.vermida_mod.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.subtotalcamp875.vermida_mod.VermidaMod;
import net.subtotalcamp875.vermida_mod.entity.ModEntities;
import net.subtotalcamp875.vermida_mod.entity.custom.BronzeShamanEntity;
import net.subtotalcamp875.vermida_mod.entity.custom.LeatherSummonEntity;

import javax.swing.text.html.parser.Entity;

@Mod.EventBusSubscriber(modid = VermidaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.LEATHER_SUMMON.get(), LeatherSummonEntity.createAttributes().build());
        event.put(ModEntities.BRONZE_SHAMAN.get(), BronzeShamanEntity.createAttributes().build());
    }
}
