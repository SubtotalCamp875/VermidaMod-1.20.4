package net.subtotalcamp875.vermida_mod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.subtotalcamp875.vermida_mod.item.ModItems;
import net.subtotalcamp875.vermida_mod.screen.BloodCondensingStationMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BloodCondensingStationBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(9);

    private static final int INPUT_SLOT = 2;
    private static final int OUTPUT_SLOT = 8;
    private static final int FUEL_OUTPUT_SLOT = 5;
    private static final int FUEL_INPUT_SLOT_1 = 0;
    private static final int FUEL_INPUT_SLOT_2 = 1;
    private static final int FUEL_INPUT_SLOT_3 = 3;
    private static final int FUEL_INPUT_SLOT_4 = 4;
    private static final int FUEL_INPUT_SLOT_5 = 6;
    private static final int FUEL_INPUT_SLOT_6 = 7;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 160;

    public BloodCondensingStationBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.BLOOD_CONDENSING_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> BloodCondensingStationBlockEntity.this.progress;
                    case 1 -> BloodCondensingStationBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> BloodCondensingStationBlockEntity.this.progress = pValue;
                    case 1 -> BloodCondensingStationBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 9;
            }
        };
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.vermida_mod.blood_condensing_station_block");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new BloodCondensingStationMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("blood_condensing_station_block.progress", progress);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("blood_condensing_station_block.progress");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if(hasRecipe()) {
            increaseCraftingProgress();
            setChanged(pLevel, pPos, pState);

            if(hasProgressFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void resetProgress() {
        progress = 0;
    }

    private void increaseCraftingProgress() {
        progress ++;
    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }



    private boolean hasRecipe() {
        boolean hasCraftingItem = this.itemHandler.getStackInSlot(INPUT_SLOT).getItem() == ModItems.SHAMAN_BLOOD.get() && hasFuel();

        ItemStack result = new ItemStack(ModItems.SLIGHTLY_CONDENSED_SHAMAN_BLOOD.get());

        return hasCraftingItem && canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private boolean hasFuel() {
        boolean hasFuelItem = this.itemHandler.getStackInSlot(FUEL_INPUT_SLOT_1).getItem() == ModItems.SHAMAN_BLOOD.get() &&
                this.itemHandler.getStackInSlot(FUEL_INPUT_SLOT_2).getItem() == ModItems.SHAMAN_BLOOD.get() &&
                this.itemHandler.getStackInSlot(FUEL_INPUT_SLOT_3).getItem() == ModItems.SHAMAN_BLOOD.get() &&
                this.itemHandler.getStackInSlot(FUEL_INPUT_SLOT_4).getItem() == ModItems.SHAMAN_BLOOD.get() &&
                this.itemHandler.getStackInSlot(FUEL_INPUT_SLOT_5).getItem() == ModItems.SHAMAN_BLOOD.get() &&
                this.itemHandler.getStackInSlot(FUEL_INPUT_SLOT_6).getItem() == ModItems.SHAMAN_BLOOD.get();

        return hasFuelItem;
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();

    }


    private void craftItem() {
        ItemStack result = new ItemStack(ModItems.SLIGHTLY_CONDENSED_SHAMAN_BLOOD.get(), 1);
        ItemStack fuelOutput = new ItemStack(Items.GLASS_BOTTLE, 6);
        this.itemHandler.extractItem(INPUT_SLOT, 1, false);
        this.itemHandler.extractItem(FUEL_INPUT_SLOT_1, 1, false);
        this.itemHandler.extractItem(FUEL_INPUT_SLOT_2, 1, false);
        this.itemHandler.extractItem(FUEL_INPUT_SLOT_3, 1, false);
        this.itemHandler.extractItem(FUEL_INPUT_SLOT_4, 1, false);
        this.itemHandler.extractItem(FUEL_INPUT_SLOT_5, 1, false);
        this.itemHandler.extractItem(FUEL_INPUT_SLOT_6, 1, false);

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
        this.itemHandler.setStackInSlot(FUEL_OUTPUT_SLOT, new ItemStack(fuelOutput.getItem(),
                this.itemHandler.getStackInSlot(FUEL_OUTPUT_SLOT).getCount() + fuelOutput.getCount()));
    }
}
