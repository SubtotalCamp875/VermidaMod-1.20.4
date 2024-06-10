package net.subtotalcamp875.vermida_mod.datagen;

import net.minecraft.client.Minecraft;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TintedGlassBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.subtotalcamp875.vermida_mod.VermidaMod;
import net.subtotalcamp875.vermida_mod.block.ModBlocks;
import net.subtotalcamp875.vermida_mod.item.ModItems;

import java.util.List;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SUMMONING_CRYSTAL_BLOCK.get())
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', ModItems.SUMMONING_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.SUMMONING_ESSENCE.get()), has(ModItems.SUMMONING_ESSENCE.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SUMMONING_CRYSTAL.get(), 9)
                .requires(ModBlocks.SUMMONING_CRYSTAL_BLOCK.get())
                .unlockedBy(getHasName(ModItems.SUMMONING_ESSENCE.get()), has(ModItems.SUMMONING_ESSENCE.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SUMMONING_ESSENCE.get(), 9)
                .requires(ModItems.SUMMONING_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.SUMMONING_ESSENCE.get()), has(ModItems.SUMMONING_ESSENCE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SUMMONING_CRYSTAL.get(), 2)
                .pattern("GEG")
                .pattern("EBE")
                .pattern("GEG")
                .define('E', ModItems.SUMMONING_ESSENCE.get())
                .define('B', ModItems.CONDENSED_SHAMAN_BLOOD.get())
                .define('G', Blocks.GLASS)
                .unlockedBy(getHasName(ModItems.SUMMONING_CRYSTAL.get()), has(ModItems.SUMMONING_CRYSTAL.get()))
                .save(pRecipeOutput, "summoning_crystal_from_essence_and_blood");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SUMMONING_CRYSTAL.get(), 8)
                .pattern(" G ")
                .pattern("GBG")
                .pattern(" G ")
                .define('B', ModItems.EXTREMELY_CONDENSED_SHAMAN_BLOOD.get())
                .define('G', Blocks.GLASS)
                .unlockedBy(getHasName(ModItems.SUMMONING_CRYSTAL.get()), has(ModItems.SUMMONING_CRYSTAL.get()))
                .save(pRecipeOutput, "summoning_crystal_from_glass_and_blood");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GLASS_DUST.get(), 1)
                .pattern(" BB")
                .pattern(" BB")
                .define('B', Items.GLASS_BOTTLE)
                .unlockedBy(getHasName(ModItems.SHAMAN_BLOOD.get()), has(ModItems.SHAMAN_BLOOD.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.GLASS, 1)
                .pattern(" BB")
                .pattern(" BB")
                .define('B', ModItems.GLASS_DUST.get())
                .unlockedBy(getHasName(ModItems.GLASS_DUST.get()), has(ModItems.GLASS_DUST.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SUMMONING_CRYSTAL.get())
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .define('E', ModItems.SUMMONING_ESSENCE.get())
                .unlockedBy(getHasName(ModItems.SUMMONING_ESSENCE.get()), has(ModItems.SUMMONING_ESSENCE.get()))
                .save(pRecipeOutput, "summoning_crystal_from_essence");



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MAGIC_HELMET.get())
                .pattern("CCC")
                .pattern("C C")
                .define('C', ModItems.SUMMONING_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.SUMMONING_CRYSTAL.get()), has(ModItems.SUMMONING_CRYSTAL.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MAGIC_CHESTPLATE.get())
                .pattern("C C")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', ModItems.SUMMONING_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.SUMMONING_CRYSTAL.get()), has(ModItems.SUMMONING_CRYSTAL.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MAGIC_LEGGINGS.get())
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                .define('C', ModItems.SUMMONING_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.SUMMONING_CRYSTAL.get()), has(ModItems.SUMMONING_CRYSTAL.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MAGIC_BOOTS.get())
                .pattern("C C")
                .pattern("C C")
                .define('C', ModItems.SUMMONING_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.SUMMONING_CRYSTAL.get()), has(ModItems.SUMMONING_CRYSTAL.get()))
                .save(pRecipeOutput);



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BRONZE_REFINER_BLOCK.get())
                .pattern("CCC")
                .pattern("CBC")
                .pattern("CCC")
                .define('C', Blocks.COPPER_BLOCK)
                .define('B', ModItems.COMPACT_BRONZE_CORE.get())
                .unlockedBy(getHasName(ModItems.BRONZE_CORE.get()), has(ModItems.BRONZE_CORE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BRONZE_CORE.get())
                .pattern(" C ")
                .pattern("CBC")
                .pattern(" C ")
                .define('B', ModItems.EXTREMELY_CONDENSED_SHAMAN_BLOOD.get())
                .define('C', Blocks.COPPER_BLOCK)
                .unlockedBy(getHasName(ModItems.SHAMAN_BLOOD.get()), has(ModItems.SHAMAN_BLOOD.get()));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COMPACT_BRONZE_CORE.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BRONZE_CORE.get())
                .unlockedBy(getHasName(ModItems.BRONZE_CORE.get()), has(ModItems.BRONZE_CORE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.REINFORCED_BRONZE_CORE.get())
                .pattern("BBB")
                .pattern("BCB")
                .pattern("BBB")
                .define('C', ModItems.BRONZE_CORE.get())
                .define('B', ModBlocks.SUMMONING_CRYSTAL_BLOCK.get())
                .unlockedBy(getHasName(ModItems.BRONZE_CORE.get()), has(ModItems.BRONZE_CORE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.REINFORCED_COMPACT_BRONZE_CORE.get())
                .pattern("BBB")
                .pattern("BCB")
                .pattern("BBB")
                .define('C', ModItems.COMPACT_BRONZE_CORE.get())
                .define('B', ModBlocks.SUMMONING_CRYSTAL_BLOCK.get())
                .unlockedBy(getHasName(ModItems.BRONZE_CORE.get()), has(ModItems.BRONZE_CORE.get()))
                .save(pRecipeOutput, "reinforced_compact_bronze_core_from_compact_bronze_core_and_crystal_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.REINFORCED_COMPACT_BRONZE_CORE.get())
                .pattern("CCC")
                .pattern("CRC")
                .pattern("CCC")
                .define('C', ModItems.BRONZE_CORE.get())
                .define('R', ModItems.REINFORCED_BRONZE_CORE.get())
                .unlockedBy(getHasName(ModItems.BRONZE_CORE.get()), has(ModItems.BRONZE_CORE.get()))
                .save(pRecipeOutput, "reinforced_compact_bronze_core_from_bronze_core_and_reinforced_bronze_core");



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SLIGHTLY_CONDENSED_SHAMAN_BLOOD.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.SHAMAN_BLOOD.get())
                .unlockedBy(getHasName(ModItems.SHAMAN_BLOOD.get()), has(ModItems.SHAMAN_BLOOD.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LIGHTLY_CONDENSED_SHAMAN_BLOOD.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.SLIGHTLY_CONDENSED_SHAMAN_BLOOD.get())
                .unlockedBy(getHasName(ModItems.SHAMAN_BLOOD.get()), has(ModItems.SHAMAN_BLOOD.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CONDENSED_SHAMAN_BLOOD.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.LIGHTLY_CONDENSED_SHAMAN_BLOOD.get())
                .unlockedBy(getHasName(ModItems.SHAMAN_BLOOD.get()), has(ModItems.SHAMAN_BLOOD.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.VERY_CONDENSED_SHAMAN_BLOOD.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.CONDENSED_SHAMAN_BLOOD.get())
                .unlockedBy(getHasName(ModItems.SHAMAN_BLOOD.get()), has(ModItems.SHAMAN_BLOOD.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EXTREMELY_CONDENSED_SHAMAN_BLOOD.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.VERY_CONDENSED_SHAMAN_BLOOD.get())
                .unlockedBy(getHasName(ModItems.SHAMAN_BLOOD.get()), has(ModItems.SHAMAN_BLOOD.get()))
                .save(pRecipeOutput);



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOOD_CONDENSING_STATION_BLOCK.get())
                .pattern("CBC")
                .pattern("S#S")
                .define('B', ModItems.COMPACT_BRONZE_CORE.get())
                .define('C', ModItems.SUMMONING_CRYSTAL.get())
                .define('#', ModItems.SHAMAN_BLOOD.get())
                .define('S', Blocks.SMOOTH_STONE)
                .unlockedBy(getHasName(ModItems.SHAMAN_BLOOD.get()), has(ModItems.SHAMAN_BLOOD.get()))
                .save(pRecipeOutput);
    }

    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pSerializer, AbstractCookingRecipe.Factory<T> pRecipeFactory, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pSerializer, pRecipeFactory)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, VermidaMod.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }

    }

}
