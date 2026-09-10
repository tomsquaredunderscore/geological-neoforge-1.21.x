package net.tomsquared.geological.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tomsquared.geological.Geological;
import net.tomsquared.geological.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Geological.MOD_ID);


    public static final Supplier<CreativeModeTab> GEOLOGICAL_TAB = CREATIVE_MODE_TAB.register("geological_tab",
            () -> CreativeModeTab.builder()



                    .icon(() -> new ItemStack(ModItems.PUMICE_STONE.get()))
                    .title(Component.translatable("creativetab.geological.geological_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.PUMICE_STONE);
                        output.accept(ModItems.PYRITE_INGOT);
                        output.accept(ModItems.RAW_PYRITE);


                        output.accept(ModBlocks.PUMICE);
                        output.accept(ModBlocks.PYRITE_BLOCK);
                        output.accept(ModBlocks.RAW_PYRITE_BLOCK);

                    })






                    .build());

    public static final Supplier<CreativeModeTab> GEOLOGICAL_TREES_TAB = CREATIVE_MODE_TAB.register("geological_trees_tab",
            () -> CreativeModeTab.builder()





                    .icon(() -> new ItemStack(ModItems.PUMICE_STONE.get()))
                    .title(Component.translatable("creativetab.geological.geological_trees_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.VIGOROUS_SAPLING_OAK);

                        output.accept(ModBlocks.OAK_LOG_STARS);
                        output.accept(ModBlocks.OAK_LOG_FENCE);
                        output.accept(ModBlocks.OAK_LOG_SLAB);
                        output.accept(ModBlocks.OAK_LOG_WALL);



                    })






                    .build());





    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
