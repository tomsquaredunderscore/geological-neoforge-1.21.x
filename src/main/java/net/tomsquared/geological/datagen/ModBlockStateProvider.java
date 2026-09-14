package net.tomsquared.geological.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.tomsquared.geological.Geological;
import net.tomsquared.geological.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Geological.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.PUMICE);
        blockWithItem(ModBlocks.PYRITE_BLOCK);
        blockWithItem(ModBlocks.RAW_PYRITE_BLOCK);
        blockWithItem(ModBlocks.GOLDEN_AMETHYST_BLOCK);

        pillarBlockWithItem(
                ModBlocks.RAW_QUARTZ,
                modLoc("block/raw_quartz"),
                modLoc("block/raw_quartz_top")
        );



        blockWithItem(ModBlocks.PYRITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_PYRITE_ORE);


    }
    private void pillarBlockWithItem(DeferredBlock<?> deferredBlock, ResourceLocation endTexture, ResourceLocation sideTexture) {

        BlockModelBuilder model = models().cubeColumn(
                deferredBlock.getId().getPath(),
                endTexture,
                sideTexture
        );

        logBlock((RotatedPillarBlock) deferredBlock.get());

        simpleBlockItem(deferredBlock.get(), model);
    }



    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
