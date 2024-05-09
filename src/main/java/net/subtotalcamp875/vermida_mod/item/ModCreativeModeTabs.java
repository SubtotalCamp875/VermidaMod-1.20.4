package net.subtotalcamp875.vermida_mod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.subtotalcamp875.vermida_mod.VermidaMod;
import net.subtotalcamp875.vermida_mod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VermidaMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> VERMIDA_TAB = CREATIVE_MODE_TABS.register("vermida_tab",
            ()-> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.vermida_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SAPPHIRE.get());
                        output.accept(ModItems.SUMMONING_ESSENCE.get());
                        output.accept(ModItems.BRONZE_KEY.get());
                        output.accept(ModItems.SUMMONING_CRYSTAL.get());

                        output.accept(ModItems.METAL_DETECTOR.get());


                        output.accept(ModBlocks.SUMMONING_CRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.BRONZE_REFINER_BLOCK.get());


                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
