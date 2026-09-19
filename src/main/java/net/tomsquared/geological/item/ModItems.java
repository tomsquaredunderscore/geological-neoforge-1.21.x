package net.tomsquared.geological.item;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tomsquared.geological.Geological;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Geological.MOD_ID);

    public static final DeferredItem<Item> PUMICE_STONE = ITEMS.register("pumice_stone",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PYRITE_INGOT = ITEMS.register("pyrite_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_PYRITE = ITEMS.register("raw_pyrite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> VIGOROUS_SAPLING_OAK = ITEMS.register("vigorous_sapling_oak",
            () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> GOLDEN_AMETHYST_SHARD = ITEMS.register("golden_amethyst_shard",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CATTAIL = ITEMS.register("cattail",
            () -> new CattailItem(new Item.Properties()));




    public static final DeferredItem<Item> VENUS_FLY_TRAP_SEEDS = ITEMS.register("venus_fly_trap_seeds",
            () -> new Item(new Item.Properties()));




    public static final DeferredItem<Item> WILD_CARROT = ITEMS.register("wild_carrot",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(1)
                            .saturationModifier(1)
                    .build())));

    public static final DeferredItem<Item> PLUMP_SWEET_BERRIES = ITEMS.register("plump_sweet_berries",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(4)
                            .saturationModifier(7)
                    .build())));

    public static final DeferredItem<Item> CATTAIL_STALK = ITEMS.register("cattail_stalk",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(2)
                            .saturationModifier(3)
                            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 60, 1), 0.9f)
                    .build())));

    public static final DeferredItem<Item> COOKED_CATTAIL_STALK = ITEMS.register("cooked_cattail_stalk",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(5)
                            .saturationModifier(6)

                    .build())));

    public static final DeferredItem<Item> PEELED_CATTAIL_STALK = ITEMS.register("peeled_cattail_stalk",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(1)
                            .saturationModifier(2)
                            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 60, 1), 0.5f)
                    .build())));

    public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
    }

    public net.minecraft.world.InteractionResult useOn(net.minecraft.world.item.context.UseOnContext context) {
        Level level = context.getLevel();
        BlockPos hitPos = context.getClickedPos();
        BlockPos plantPos = hitPos.relative(context.getClickedFace());

        BlockState targetState = level.getBlockState(hitPos);
        BlockState plantState = level.getBlockState(plantPos);

        boolean isValidSoil = targetState.is(BlockTags.DIRT) || targetState.is(Blocks.GRAVEL);
        boolean isUnderwater = plantState.getFluidState().is(Fluids.WATER);

        if (isValidSoil && isUnderwater) {
            if (!level.isClientSide) {
                // Place your placeholder block manually
                level.setBlockAndUpdate(plantPos, Blocks.KELP.defaultBlockState());
                if (context.getPlayer() != null && !context.getPlayer().getAbilities().instabuild) {
                    context.getItemInHand().shrink(1);
                }
            }
            return net.minecraft.world.InteractionResult.sidedSuccess(level.isClientSide());
        }

        return net.minecraft.world.InteractionResult.PASS;
    }

}
