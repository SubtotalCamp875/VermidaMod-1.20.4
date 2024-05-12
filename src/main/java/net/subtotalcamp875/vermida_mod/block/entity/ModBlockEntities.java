package net.subtotalcamp875.vermida_mod.block.entity;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.subtotalcamp875.vermida_mod.VermidaMod;
import net.subtotalcamp875.vermida_mod.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, VermidaMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<BloodCondensingStationBlockEntity>> BLOOD_CONDENSING_BE =
            BLOCK_ENTITIES.register("blood_condensing_be", () ->
                    BlockEntityType.Builder.of(BloodCondensingStationBlockEntity::new,
                            ModBlocks.BLOOD_CONDENSING_STATION_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
