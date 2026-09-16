package net.tomsquared.geological.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.tomsquared.geological.ModParticles;


public class CattailItem extends Item {
    public CattailItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (player.getCooldowns().isOnCooldown(this)) {
            return InteractionResultHolder.fail(stack);
        }

        Vec3 pos = player.getEyePosition(1.0F).add(player.getLookAngle().scale(0.5));

        if (level.isClientSide) {
            for (int i = 0; i < 15; i++) {
                double velocityX = (level.random.nextDouble() - 0.5) * 0.5;
                double velocityY = (level.random.nextDouble() - 0.2) * 0.4;
                double velocityZ = (level.random.nextDouble() - 0.5) * 0.5;

                level.addParticle(ModParticles.FLUFF.get(),
                        pos.x, pos.y, pos.z,
                        velocityX, velocityY, velocityZ);
            }
        }

        if (!level.isClientSide) {
            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.BUNDLE_INSERT, SoundSource.PLAYERS, 0.6F, 1.3F + level.random.nextFloat() * 0.3F);


            int seedCount = 2 + level.random.nextInt(3);
            for (int i = 0; i < seedCount; i++) {
                net.tomsquared.geological.CattailSeedProjectile seed = new net.tomsquared.geological.CattailSeedProjectile(level, player);

                double rx = (level.random.nextDouble() - 0.5) * 0.8;
                double ry = (level.random.nextDouble() - 0.5) * 0.8;
                double rz = (level.random.nextDouble() - 0.5) * 0.8;

                seed.shoot(player.getLookAngle().x + rx, player.getLookAngle().y + ry, player.getLookAngle().z + rz, 0.6F, 1.0F);
                level.addFreshEntity(seed);
            }

            // Consume Item
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }

            player.getCooldowns().addCooldown(this, 10); // 1.5-second cooldown
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}