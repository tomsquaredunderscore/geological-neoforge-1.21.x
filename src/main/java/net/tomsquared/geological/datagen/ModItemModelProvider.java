package net.tomsquared.geological.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.tomsquared.geological.Geological;
import net.tomsquared.geological.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Geological.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.PUMICE_STONE.get());
        basicItem(ModItems.RAW_PYRITE.get());
        basicItem(ModItems.PYRITE_INGOT.get());
        basicItem(ModItems.VIGOROUS_SAPLING_OAK.get());
        basicItem(ModItems.GOLDEN_AMETHYST_SHARD.get());
        basicItem(ModItems.WILD_CARROT.get());
        basicItem(ModItems.CATTAIL.get());
        basicItem(ModItems.PEELED_CATTAIL_STALK.get());
        basicItem(ModItems.COOKED_CATTAIL_STALK.get());
        basicItem(ModItems.CATTAIL_STALK.get());
        basicItem(ModItems.PLUMP_SWEET_BERRIES.get());
        basicItem(ModItems.VENUS_FLY_TRAP_SEEDS.get());


    }
}
