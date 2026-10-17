package net.tomsquared.geological.item;

import net.minecraft.server.level.ServerLevel;
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

        if (!level.isClientSide && level instanceof ServerLevel serverLevel) {

            int totalParticles = serverLevel.random.nextInt(144) + 6; // Mimics your 6 to 150 logic smoothly
            for (int i = 0; i < totalParticles; i++) {
                double velocityX = (serverLevel.random.nextDouble() - 0.5) * 0.5;
                double velocityY = (serverLevel.random.nextDouble() - 0.2) * 0.4;
                double velocityZ = (serverLevel.random.nextDouble() - 0.5) * 0.5;

                serverLevel.sendParticles(
                        ModParticles.FLUFF.get(),
                        pos.x, pos.y, pos.z,
                        0,
                        velocityX, velocityY, velocityZ,
                        1.0
                );
            }

            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.BUNDLE_INSERT, SoundSource.PLAYERS, 0.6F, 1.3F + level.random.nextFloat() * 0.3F);

            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }

            player.getCooldowns().addCooldown(this, 5);
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}