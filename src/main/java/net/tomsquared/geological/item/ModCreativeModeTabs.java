package net.tomsquared.geological.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tomsquared.geological.Geological;
import net.tomsquared.geological.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "geological");

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GEOLOGICAL_TAB =
            CREATIVE_MODE_TABS.register("geological_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.geological.tab"))
                    .icon(() -> new ItemStack(ModItems.WILD_CARROT.get()))
                    .displayItems((parameters, output) -> {
                        // Ores & Rocks
                        output.accept(ModBlocks.PYRITE_ORE.get().asItem());
                        output.accept(ModBlocks.DEEPSLATE_PYRITE_ORE.get().asItem());
                        output.accept(ModBlocks.PUMICE.get().asItem());
                        output.accept(ModBlocks.RAW_QUARTZ.get().asItem());

                        // Storage Blocks
                        output.accept(ModBlocks.PYRITE_BLOCK.get().asItem());
                        output.accept(ModBlocks.RAW_PYRITE_BLOCK.get().asItem());
                        output.accept(ModBlocks.GOLDEN_AMETHYST_BLOCK.get().asItem());

                        // Materials & Resource Items
                        output.accept(ModItems.RAW_PYRITE.get());
                        output.accept(ModItems.PYRITE_INGOT.get());
                        output.accept(ModItems.GOLDEN_AMETHYST_SHARD.get());
                        output.accept(ModItems.PUMICE_STONE.get());

                        // Plants, Seeds & Vegetation
                        output.accept(ModItems.CATTAIL.get());
                        output.accept(ModItems.VIGOROUS_SAPLING_OAK.get());
                        output.accept(ModItems.VENUS_FLY_TRAP_SEEDS.get());

                        // Food & Edibles
                        output.accept(ModItems.WILD_CARROT.get());
                        output.accept(ModItems.CATTAIL_STALK.get());
                        output.accept(ModItems.PEELED_CATTAIL_STALK.get());
                        output.accept(ModItems.COOKED_CATTAIL_STALK.get());
                        output.accept(ModItems.PLUMP_SWEET_BERRIES.get());
                    })
                    .build()
            );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GEOLOGICAL_WOODS =
            CREATIVE_MODE_TABS.register("geological_woods", () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.geological.woods"))
                    .icon(() -> new ItemStack(ModBlocks.OAK_WOOD_STAIRS))
                    .displayItems((parameters, output) -> {
                        // Oak
                        output.accept(ModBlocks.OAK_WOOD_STAIRS.get());
                        output.accept(ModBlocks.OAK_WOOD_SLAB.get());
                        output.accept(ModBlocks.OAK_WOOD_WALL.get());
                        output.accept(ModBlocks.OAK_WOOD_FENCE.get());

                        // SPRUCE
                        output.accept(ModBlocks.SPRUCE_WOOD_STAIRS.get());
                        output.accept(ModBlocks.SPRUCE_WOOD_SLAB.get());
                        output.accept(ModBlocks.SPRUCE_WOOD_WALL.get());
                        output.accept(ModBlocks.SPRUCE_WOOD_FENCE.get());

                        // BIRCH
                        output.accept(ModBlocks.BIRCH_WOOD_STAIRS.get());
                        output.accept(ModBlocks.BIRCH_WOOD_SLAB.get());
                        output.accept(ModBlocks.BIRCH_WOOD_WALL.get());
                        output.accept(ModBlocks.BIRCH_WOOD_FENCE.get());

                        // JUNGLE
                        output.accept(ModBlocks.JUNGLE_WOOD_STAIRS.get());
                        output.accept(ModBlocks.JUNGLE_WOOD_SLAB.get());
                        output.accept(ModBlocks.JUNGLE_WOOD_WALL.get());
                        output.accept(ModBlocks.JUNGLE_WOOD_FENCE.get());

                        // ACACIA
                        output.accept(ModBlocks.ACACIA_WOOD_STAIRS.get());
                        output.accept(ModBlocks.ACACIA_WOOD_SLAB.get());
                        output.accept(ModBlocks.ACACIA_WOOD_WALL.get());
                        output.accept(ModBlocks.ACACIA_WOOD_FENCE.get());

                        // DARK OAK
                        output.accept(ModBlocks.DARK_OAK_WOOD_STAIRS.get());
                        output.accept(ModBlocks.DARK_OAK_WOOD_SLAB.get());
                        output.accept(ModBlocks.DARK_OAK_WOOD_WALL.get());
                        output.accept(ModBlocks.DARK_OAK_WOOD_FENCE.get());

                        // MANGROVE
                        output.accept(ModBlocks.MANGROVE_WOOD_STAIRS.get());
                        output.accept(ModBlocks.MANGROVE_WOOD_SLAB.get());
                        output.accept(ModBlocks.MANGROVE_WOOD_WALL.get());
                        output.accept(ModBlocks.MANGROVE_WOOD_FENCE.get());

                        // CHERRY
                        output.accept(ModBlocks.CHERRY_WOOD_STAIRS.get());
                        output.accept(ModBlocks.CHERRY_WOOD_SLAB.get());
                        output.accept(ModBlocks.CHERRY_WOOD_WALL.get());
                        output.accept(ModBlocks.CHERRY_WOOD_FENCE.get());



                        // Dogwood Tree Blocks

                        output.accept(ModBlocks.PINK_DOGWOOD_LOG.get());
                        output.accept(ModBlocks.PINK_DOGWOOD_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_PINK_DOGWOOD_LOG.get());
                        output.accept(ModBlocks.STRIPPED_PINK_DOGWOOD_WOOD.get());
                        output.accept(ModBlocks.PINK_DOGWOOD_LEAVES.get());
                        output.accept(ModBlocks.PINK_DOGWOOD_SAPLING.get());
                        output.accept(ModBlocks.PINK_DOGWOOD_PLANKS.get());
                        output.accept(ModBlocks.PINK_DOGWOOD_STAIRS.get());
                        output.accept(ModBlocks.PINK_DOGWOOD_SLAB.get());
                        output.accept(ModBlocks.PINK_DOGWOOD_FENCE.get());


                    })
                    .build()
            );
}