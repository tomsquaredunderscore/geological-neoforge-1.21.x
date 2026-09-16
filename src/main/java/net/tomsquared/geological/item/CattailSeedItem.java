package net.tomsquared.geological.item;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class CattailSeedItem extends Item {
    public CattailSeedItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        BlockHitResult blockhitresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);

        if (blockhitresult.getType() == HitResult.Type.BLOCK) {
            BlockPos plantPos = blockhitresult.getBlockPos();
            BlockPos hitPos = plantPos.below();
            BlockPos airCheckPos = plantPos.above();

            BlockState targetState = level.getBlockState(hitPos);
            BlockState plantState = level.getBlockState(plantPos);
            BlockState abovePlantState = level.getBlockState(airCheckPos);

            boolean isValidSoil = targetState.is(BlockTags.DIRT) || targetState.is(Blocks.GRAVEL);
            boolean isWaterSource = plantState.getFluidState().is(Fluids.WATER) && plantState.getFluidState().isSource();
            boolean isOneBlockDeep = abovePlantState.isAir();

            if (isValidSoil && isWaterSource && isOneBlockDeep) {
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(plantPos, Blocks.KELP.defaultBlockState());

                    if (!player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }
                }
                return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
            }
        }

        return InteractionResultHolder.pass(itemstack);
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        return InteractionResult.PASS;
    }
}