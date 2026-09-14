package net.tomsquared.geological.item;

import net.minecraft.world.item.Item;
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


    public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
    }


}
