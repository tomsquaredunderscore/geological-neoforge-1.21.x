package net.tomsquared.geological.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
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
}