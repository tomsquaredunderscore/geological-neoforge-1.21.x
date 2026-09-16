package net.tomsquared.geological;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.tomsquared.geological.item.ModItems;

public class CattailSeedProjectile extends ThrowableItemProjectile {

    public CattailSeedProjectile(EntityType<? extends ThrowableItemProjectile> type, Level level) {
        super(type, level);
    }

    public CattailSeedProjectile(Level level, LivingEntity shooter) {
        super(ModEntities.CATTAIL_SEED_PROJECTILE.get(), shooter, level);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.CATTAIL_SEED.get();
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            boolean successfullyPlanted = false;

            if (result.getType() == HitResult.Type.BLOCK) {
                BlockHitResult blockHit = (BlockHitResult) result;
                BlockPos hitPos = blockHit.getBlockPos();
                BlockPos plantPos = hitPos.relative(blockHit.getDirection());

                BlockPos airCheckPos = plantPos.above();

                BlockState targetState = this.level().getBlockState(hitPos);
                BlockState plantState = this.level().getBlockState(plantPos);
                BlockState abovePlantState = this.level().getBlockState(airCheckPos);

                boolean isValidSoil = targetState.is(BlockTags.DIRT) || targetState.is(BlockTags.SAND) || targetState.is(Blocks.GRAVEL);

                boolean isWaterSource = plantState.getFluidState().is(Fluids.WATER) && plantState.getFluidState().isSource();

                boolean isOneBlockDeep = abovePlantState.isAir();

                if (isValidSoil && isWaterSource && isOneBlockDeep) {
                    this.level().setBlockAndUpdate(plantPos, Blocks.KELP.defaultBlockState());
                    successfullyPlanted = true;
                }
            }

            if (!successfullyPlanted) {
                ItemStack dropStack = new ItemStack(ModItems.CATTAIL_SEED.get());
                ItemEntity itemEntity = new ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), dropStack);
                this.level().addFreshEntity(itemEntity);
            }

            this.discard();
        }
    }

    @Override
    public void tick() {
        super.tick();

        net.minecraft.world.phys.Vec3 deltaMovement = this.getDeltaMovement();
        double horizontalDistance = deltaMovement.horizontalDistance();

        this.setXRot((float)(Mth.atan2(deltaMovement.y, horizontalDistance) * (180F / (float)Math.PI)));
        this.setYRot((float)(Mth.atan2(deltaMovement.x, deltaMovement.z) * (180F / (float)Math.PI)));
    }
}