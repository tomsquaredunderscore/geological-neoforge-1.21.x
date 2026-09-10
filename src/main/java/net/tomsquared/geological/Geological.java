package net.tomsquared.geological;

import net.minecraft.world.item.CreativeModeTabs;
import net.tomsquared.geological.block.ModBlocks;
import net.tomsquared.geological.item.ModCreativeModeTabs;
import net.tomsquared.geological.item.ModItems;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;


@Mod(Geological.MOD_ID)
public class Geological {
    public static final String MOD_ID = "geological";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Geological(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);


        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);


        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.PYRITE_INGOT);
            event.accept(ModItems.RAW_PYRITE);
            event.accept(ModItems.PUMICE_STONE);

        }

        if ((event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)) {
            event.accept(ModBlocks.PYRITE_BLOCK);
            event.accept(ModBlocks.RAW_PYRITE_BLOCK);
            event.accept(ModBlocks.GOLDEN_ANETHST_BLOCK);
            event.accept(ModBlocks.PUMICE);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}