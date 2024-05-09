package net.subtotalcamp875.vermida_mod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.subtotalcamp875.vermida_mod.item.ModItems;

public class bronze_refiner_block extends Block {
    public bronze_refiner_block(Properties p_49795_) {
        super(p_49795_);
    }

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pPlayer.getItemInHand(pHand).is(Items.COPPER_BLOCK)) {
            ItemStack $$6 = pPlayer.getItemInHand(pHand);
            $$6.shrink(1);
            popResource(pLevel, pPos, new ItemStack(ModItems.BRONZE_KEY.get()));
            pLevel.playSound(pPlayer, pPos, SoundEvents.SMITHING_TABLE_USE, SoundSource.BLOCKS, 1f, 1f);
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
        else {
            pLevel.playSound(pPlayer, pPos, SoundEvents.REDSTONE_TORCH_BURNOUT, SoundSource.BLOCKS, 1f, 1f);
            return InteractionResult.SUCCESS;
        }
    }
}