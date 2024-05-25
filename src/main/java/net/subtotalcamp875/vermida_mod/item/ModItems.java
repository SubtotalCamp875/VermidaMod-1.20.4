package net.subtotalcamp875.vermida_mod.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.subtotalcamp875.vermida_mod.VermidaMod;
import net.subtotalcamp875.vermida_mod.entity.ModEntities;
import net.subtotalcamp875.vermida_mod.item.custom.MagicOrbProjectileItem;
import net.subtotalcamp875.vermida_mod.item.custom.MetalDetectorItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VermidaMod.MOD_ID);


    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            ()-> new MetalDetectorItem(new Item.Properties().durability(100)));


    public static final RegistryObject<Item> SUMMONING_ESSENCE = ITEMS.register("summoning_essence",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SUMMONING_CRYSTAL = ITEMS.register("summoning_crystal",
            ()-> new Item(new Item.Properties()));


    public static final RegistryObject<Item> BRONZE_KEY = ITEMS.register("bronze_key",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BRONZE_CORE = ITEMS.register("bronze_core",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> COMPACT_BRONZE_CORE = ITEMS.register("compact_bronze_core",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> REINFORCED_BRONZE_CORE = ITEMS.register("reinforced_bronze_core",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> REINFORCED_COMPACT_BRONZE_CORE = ITEMS.register("reinforced_compact_bronze_core",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> MAGIC_HELMET = ITEMS.register("magic_helmet",
            ()-> new ArmorItem(ModArmorMaterials.SUMMONING_CRYSTAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> MAGIC_CHESTPLATE = ITEMS.register("magic_chestplate",
            ()-> new ArmorItem(ModArmorMaterials.SUMMONING_CRYSTAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> MAGIC_LEGGINGS = ITEMS.register("magic_leggings",
            ()-> new ArmorItem(ModArmorMaterials.SUMMONING_CRYSTAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> MAGIC_BOOTS = ITEMS.register("magic_boots",
            ()-> new ArmorItem(ModArmorMaterials.SUMMONING_CRYSTAL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> MAGIC_ORB = ITEMS.register("magic_orb",
            ()-> new MagicOrbProjectileItem(new Item.Properties()));


    public static final RegistryObject<Item> SHAMAN_BLOOD = ITEMS.register("shaman_blood",
            ()-> new Item(new Item.Properties().food(ModFoods.SHAMAN_BLOOD).stacksTo(16)));
    public static final RegistryObject<Item> SLIGHTLY_CONDENSED_SHAMAN_BLOOD = ITEMS.register("slightly_condensed_shaman_blood",
            ()-> new Item(new Item.Properties().food(ModFoods.SLIGHTLY_CONDENSED_SHAMAN_BLOOD).stacksTo(16)));
    public static final RegistryObject<Item> LIGHTLY_CONDENSED_SHAMAN_BLOOD = ITEMS.register("lightly_condensed_shaman_blood",
            ()-> new Item(new Item.Properties().food(ModFoods.LIGHTLY_CONDENSED_SHAMAN_BLOOD).stacksTo(16)));
    public static final RegistryObject<Item> CONDENSED_SHAMAN_BLOOD = ITEMS.register("condensed_shaman_blood",
            ()-> new Item(new Item.Properties().food(ModFoods.CONDENSED_SHAMAN_BLOOD).stacksTo(16)));
    public static final RegistryObject<Item> VERY_CONDENSED_SHAMAN_BLOOD = ITEMS.register("very_condensed_shaman_blood",
            ()-> new Item(new Item.Properties().food(ModFoods.VERY_CONDENSED_SHAMAN_BLOOD).stacksTo(16)));
    public static final RegistryObject<Item> EXTREMELY_CONDENSED_SHAMAN_BLOOD = ITEMS.register("extremely_condensed_shaman_blood",
            ()-> new Item(new Item.Properties().food(ModFoods.EXTREMELY_CONDENSED_SHAMAN_BLOOD).stacksTo(16)));


    public static final RegistryObject<Item> LEATHER_SUMMON_SPAWN_EGG = ITEMS.register("leather_summon_spawn_egg",
            ()-> new ForgeSpawnEggItem(ModEntities.LEATHER_SUMMON, 0x7e9680, 0xc5d1c5,
                    new Item.Properties()));

    public static final RegistryObject<Item> BRONZE_SHAMAN_SPAWN_EGG = ITEMS.register("bronze_shaman_spawn_egg",
            ()-> new ForgeSpawnEggItem(ModEntities.BRONZE_SHAMAN, 0x7e9680, 0xc5d1c5,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
