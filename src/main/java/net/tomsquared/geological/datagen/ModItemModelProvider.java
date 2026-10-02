package net.tomsquared.geological.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.tomsquared.geological.Geological;
import net.tomsquared.geological.block.ModBlocks;
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

        fenceItem(ModBlocks.OAK_WOOD_FENCE, "block/oak_log");
        wallItem(ModBlocks.OAK_WOOD_WALL, "block/oak_log");

        fenceItem(ModBlocks.BIRCH_WOOD_FENCE, "block/birch_log");
        wallItem(ModBlocks.BIRCH_WOOD_WALL, "block/birch_log");

        fenceItem(ModBlocks.SPRUCE_WOOD_FENCE, "block/spruce_log");
        wallItem(ModBlocks.SPRUCE_WOOD_WALL, "block/spruce_log");

        fenceItem(ModBlocks.JUNGLE_WOOD_FENCE, "block/jungle_log");
        wallItem(ModBlocks.JUNGLE_WOOD_WALL, "block/jungle_log");

        fenceItem(ModBlocks.ACACIA_WOOD_FENCE, "block/acacia_log");
        wallItem(ModBlocks.ACACIA_WOOD_WALL, "block/acacia_log");

        fenceItem(ModBlocks.DARK_OAK_WOOD_FENCE, "block/dark_oak_log");
        wallItem(ModBlocks.DARK_OAK_WOOD_WALL, "block/dark_oak_log");

        fenceItem(ModBlocks.MANGROVE_WOOD_FENCE, "block/mangrove_log");
        wallItem(ModBlocks.MANGROVE_WOOD_WALL, "block/mangrove_log");

        fenceItem(ModBlocks.CHERRY_WOOD_FENCE, "block/cherry_log");
        wallItem(ModBlocks.CHERRY_WOOD_WALL, "block/cherry_log");


    }

    // Two clean, reused helper methods for every wood type
    public void fenceItem(DeferredBlock<?> block, String vanillaTexturePath) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", mcLoc(vanillaTexturePath));
    }

    public void wallItem(DeferredBlock<?> block, String vanillaTexturePath) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", mcLoc(vanillaTexturePath));
    }
}