package net.subtotalcamp875.vermida_mod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.subtotalcamp875.vermida_mod.VermidaMod;
import net.subtotalcamp875.vermida_mod.block.ModBlocks;

public class ModBlockStateProviders extends BlockStateProvider {
    public ModBlockStateProviders(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VermidaMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BRONZE_REFINER_BLOCK);
        blockWithItem(ModBlocks.SUMMONING_CRYSTAL_BLOCK);

        simpleBlockWithItem(ModBlocks.BLOOD_CONDENSING_STATION_BLOCK.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/gem_polishing_station")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
