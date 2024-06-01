package net.subtotalcamp875.vermida_mod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.subtotalcamp875.vermida_mod.VermidaMod;
import net.subtotalcamp875.vermida_mod.item.ModItems;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, VermidaMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.METAL_DETECTOR);

        simpleItem(ModItems.SUMMONING_ESSENCE);
        simpleItem(ModItems.SUMMONING_CRYSTAL);

        simpleItem(ModItems.BRONZE_KEY);
        simpleItem(ModItems.BRONZE_CORE);
        simpleItem(ModItems.COMPACT_BRONZE_CORE);
        simpleItem(ModItems.REINFORCED_BRONZE_CORE);
        simpleItem(ModItems.REINFORCED_COMPACT_BRONZE_CORE);

        simpleItem(ModItems.MAGIC_HELMET);
        simpleItem(ModItems.MAGIC_CHESTPLATE);
        simpleItem(ModItems.MAGIC_LEGGINGS);
        simpleItem(ModItems.MAGIC_BOOTS);

        simpleItem(ModItems.SHAMAN_BLOOD);
        simpleItem(ModItems.SLIGHTLY_CONDENSED_SHAMAN_BLOOD);
        simpleItem(ModItems.LIGHTLY_CONDENSED_SHAMAN_BLOOD);
        simpleItem(ModItems.CONDENSED_SHAMAN_BLOOD);
        simpleItem(ModItems.VERY_CONDENSED_SHAMAN_BLOOD);
        simpleItem(ModItems.EXTREMELY_CONDENSED_SHAMAN_BLOOD);

        trimmedArmorItem(ModItems.MAGIC_HELMET);
        trimmedArmorItem(ModItems.MAGIC_CHESTPLATE);
        trimmedArmorItem(ModItems.MAGIC_LEGGINGS);
        trimmedArmorItem(ModItems.MAGIC_BOOTS);
        simpleItem(ModItems.MAGIC_ORB);
        simpleItem(ModItems.ECHOS_OF_SUMMONS_MUSIC_DISC);
        simpleItem(ModItems.BRONZE_SHAMAN_CAMP_AMBIENCE_MUSIC_DISC);
        simpleItem(ModItems.SCROLL);

        withExistingParent(ModItems.LEATHER_SUMMON_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.BRONZE_SHAMAN_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = VermidaMod.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(VermidaMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
