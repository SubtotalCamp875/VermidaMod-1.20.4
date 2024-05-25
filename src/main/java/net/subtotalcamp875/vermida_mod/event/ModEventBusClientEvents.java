package net.subtotalcamp875.vermida_mod.event;


import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.subtotalcamp875.vermida_mod.VermidaMod;
import net.subtotalcamp875.vermida_mod.entity.client.BronzeShamanModel;
import net.subtotalcamp875.vermida_mod.entity.client.LeatherSummonModel;
import net.subtotalcamp875.vermida_mod.entity.client.ModModelLayers;
import net.subtotalcamp875.vermida_mod.entity.custom.BronzeShamanEntity;

@Mod.EventBusSubscriber(modid = VermidaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerlayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.LEATHER_SUMMON_LAYER, LeatherSummonModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.BRONZE_SHAMAN_LAYER, BronzeShamanModel::createBodyLayer);
    }
}
