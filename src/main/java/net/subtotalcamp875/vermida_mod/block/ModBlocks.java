package net.subtotalcamp875.vermida_mod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.subtotalcamp875.vermida_mod.VermidaMod;
import net.subtotalcamp875.vermida_mod.block.custom.BloodCondensingStationBlock;
import net.subtotalcamp875.vermida_mod.block.custom.bronze_refiner_block;
import net.subtotalcamp875.vermida_mod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, VermidaMod.MOD_ID);

    public static final RegistryObject<Block> SUMMONING_CRYSTAL_BLOCK = registerBlock("summoning_crystal_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.LODESTONE)));
    public static final RegistryObject<Block> SEAL_BREAKER_BLOCK = registerBlock("seal_breaker_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.CHAIN)));
    public static final RegistryObject<Block> BRONZE_REFINER_BLOCK = registerBlock("bronze_refiner_block",
            () -> new bronze_refiner_block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> BLOOD_CONDENSING_STATION_BLOCK = registerBlock("blood_condensing_station_block",
            () -> new BloodCondensingStationBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion().sound(SoundType.ANVIL)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
