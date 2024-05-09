package net.subtotalcamp875.vermida_mod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.subtotalcamp875.vermida_mod.VermidaMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VermidaMod.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SUMMONING_ESSENCE = ITEMS.register("summoning_essence",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BRONZE_KEY = ITEMS.register("bronze_key",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SUMMONING_CRYSTAL = ITEMS.register("summoning_crystal",
            ()-> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
