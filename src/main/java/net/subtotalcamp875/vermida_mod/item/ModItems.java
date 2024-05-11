package net.subtotalcamp875.vermida_mod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.subtotalcamp875.vermida_mod.VermidaMod;
import net.subtotalcamp875.vermida_mod.entity.ModEntities;
import net.subtotalcamp875.vermida_mod.item.custom.MetalDetectorItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VermidaMod.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SUMMONING_ESSENCE = ITEMS.register("summoning_essence",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SUMMONING_CRYSTAL = ITEMS.register("summoning_crystal",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BRONZE_KEY = ITEMS.register("bronze_key",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BRONZE_CORE = ITEMS.register("bronze_core",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            ()-> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> LEATHER_SUMMON_SPAWN_EGG = ITEMS.register("leather_summon_spawn_egg",
            ()-> new ForgeSpawnEggItem(ModEntities.LEATHER_SUMMON, 0x7e9680, 0xc5d1c5,
                    new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
