package net.subtotalcamp875.vermida_mod.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.subtotalcamp875.vermida_mod.VermidaMod;

public class ModEnchantments {
    private static final EquipmentSlot[] ARMOR_SLOTS = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};

    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, VermidaMod.MOD_ID);

    public static RegistryObject<Enchantment> MAGIC_RESISTANCE =
            ENCHANTMENTS.register("magic_resistance",
                    () -> new MagicResistanceEnchantment(Enchantment.Rarity.VERY_RARE, MagicResistanceEnchantment.Type.MAGIC, ARMOR_SLOTS));


    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
