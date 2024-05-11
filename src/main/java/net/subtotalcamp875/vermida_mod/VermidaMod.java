package net.subtotalcamp875.vermida_mod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.CreativeModeTabRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.subtotalcamp875.vermida_mod.block.ModBlocks;
import net.subtotalcamp875.vermida_mod.entity.ModEntities;
import net.subtotalcamp875.vermida_mod.entity.client.LeatherSummonRenderer;
import net.subtotalcamp875.vermida_mod.item.ModCreativeModeTabs;
import net.subtotalcamp875.vermida_mod.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(VermidaMod.MOD_ID)
public class VermidaMod {
    public static final String MOD_ID = "vermida_mod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public VermidaMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register((modEventBus));

        ModEntities.register((modEventBus));

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {;
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.SAPPHIRE.get());
            event.accept(ModItems.SUMMONING_ESSENCE.get());
            event.accept(ModItems.SUMMONING_CRYSTAL.get());

            event.accept(ModItems.BRONZE_KEY.get());
            event.accept(ModItems.BRONZE_CORE.get());

            event.accept(ModItems.METAL_DETECTOR.get());

            event.accept(ModItems.LEATHER_SUMMON_SPAWN_EGG.get());


            event.accept(ModBlocks.SUMMONING_CRYSTAL_BLOCK.get());
            event.accept(ModBlocks.BRONZE_REFINER_BLOCK.get());
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.LEATHER_SUMMON.get(), LeatherSummonRenderer::new);
        }
    }
}
