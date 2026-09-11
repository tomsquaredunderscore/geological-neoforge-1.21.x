package net.tomsquared.geological.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tomsquared.geological.Geological;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Geological.MOD_ID);


    public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
    }


}
