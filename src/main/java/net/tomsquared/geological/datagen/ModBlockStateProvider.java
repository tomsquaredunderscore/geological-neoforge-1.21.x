package net.tomsquared.geological.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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

        // OAK
        stairsBlock(ModBlocks.OAK_WOOD_STAIRS.get(), mcLoc("block/oak_log"));
        slabBlock(ModBlocks.OAK_WOOD_SLAB.get(),
                models().slab(ModBlocks.OAK_WOOD_SLAB.getId().getPath(), mcLoc("block/oak_log"), mcLoc("block/oak_log"), mcLoc("block/oak_log")),
                models().slabTop(ModBlocks.OAK_WOOD_SLAB.getId().getPath() + "_top", mcLoc("block/oak_log"), mcLoc("block/oak_log"), mcLoc("block/oak_log")),
                models().cubeAll(ModBlocks.OAK_WOOD_SLAB.getId().getPath() + "_double", mcLoc("block/oak_log")));
        wallBlock(ModBlocks.OAK_WOOD_WALL.get(), mcLoc("block/oak_log"));
        fenceBlock(ModBlocks.OAK_WOOD_FENCE.get(), mcLoc("block/oak_log"));
        blockItem(ModBlocks.OAK_WOOD_STAIRS);
        blockItem(ModBlocks.OAK_WOOD_SLAB);
        models().withExistingParent(ModBlocks.OAK_WOOD_FENCE.getId().getPath(), mcLoc("block/fence_inventory")).texture("texture", mcLoc("block/oak_log"));
        models().withExistingParent(ModBlocks.OAK_WOOD_WALL.getId().getPath(), mcLoc("block/wall_inventory")).texture("wall", mcLoc("block/oak_log"));

        // SPRUCE
        stairsBlock(ModBlocks.SPRUCE_WOOD_STAIRS.get(), mcLoc("block/spruce_log"));
        slabBlock(ModBlocks.SPRUCE_WOOD_SLAB.get(),
                models().slab(ModBlocks.SPRUCE_WOOD_SLAB.getId().getPath(), mcLoc("block/spruce_log"), mcLoc("block/spruce_log"), mcLoc("block/spruce_log")),
                models().slabTop(ModBlocks.SPRUCE_WOOD_SLAB.getId().getPath() + "_top", mcLoc("block/spruce_log"), mcLoc("block/spruce_log"), mcLoc("block/spruce_log")),
                models().cubeAll(ModBlocks.SPRUCE_WOOD_SLAB.getId().getPath() + "_double", mcLoc("block/spruce_log")));
        wallBlock(ModBlocks.SPRUCE_WOOD_WALL.get(), mcLoc("block/spruce_log"));
        fenceBlock(ModBlocks.SPRUCE_WOOD_FENCE.get(), mcLoc("block/spruce_log"));
        blockItem(ModBlocks.SPRUCE_WOOD_STAIRS);
        blockItem(ModBlocks.SPRUCE_WOOD_SLAB);
        models().withExistingParent(ModBlocks.SPRUCE_WOOD_FENCE.getId().getPath(), mcLoc("block/fence_inventory")).texture("texture", mcLoc("block/spruce_log"));
        models().withExistingParent(ModBlocks.SPRUCE_WOOD_WALL.getId().getPath(), mcLoc("block/wall_inventory")).texture("wall", mcLoc("block/spruce_log"));

        // BIRCH
        stairsBlock(ModBlocks.BIRCH_WOOD_STAIRS.get(), mcLoc("block/birch_log"));
        slabBlock(ModBlocks.BIRCH_WOOD_SLAB.get(),
                models().slab(ModBlocks.BIRCH_WOOD_SLAB.getId().getPath(), mcLoc("block/birch_log"), mcLoc("block/birch_log"), mcLoc("block/birch_log")),
                models().slabTop(ModBlocks.BIRCH_WOOD_SLAB.getId().getPath() + "_top", mcLoc("block/birch_log"), mcLoc("block/birch_log"), mcLoc("block/birch_log")),
                models().cubeAll(ModBlocks.BIRCH_WOOD_SLAB.getId().getPath() + "_double", mcLoc("block/birch_log")));
        wallBlock(ModBlocks.BIRCH_WOOD_WALL.get(), mcLoc("block/birch_log"));
        fenceBlock(ModBlocks.BIRCH_WOOD_FENCE.get(), mcLoc("block/birch_log"));
        blockItem(ModBlocks.BIRCH_WOOD_STAIRS);
        blockItem(ModBlocks.BIRCH_WOOD_SLAB);
        models().withExistingParent(ModBlocks.BIRCH_WOOD_FENCE.getId().getPath(), mcLoc("block/fence_inventory")).texture("texture", mcLoc("block/birch_log"));
        models().withExistingParent(ModBlocks.BIRCH_WOOD_WALL.getId().getPath(), mcLoc("block/wall_inventory")).texture("wall", mcLoc("block/birch_log"));

        // JUNGLE
        stairsBlock(ModBlocks.JUNGLE_WOOD_STAIRS.get(), mcLoc("block/jungle_log"));
        slabBlock(ModBlocks.JUNGLE_WOOD_SLAB.get(),
                models().slab(ModBlocks.JUNGLE_WOOD_SLAB.getId().getPath(), mcLoc("block/jungle_log"), mcLoc("block/jungle_log"), mcLoc("block/jungle_log")),
                models().slabTop(ModBlocks.JUNGLE_WOOD_SLAB.getId().getPath() + "_top", mcLoc("block/jungle_log"), mcLoc("block/jungle_log"), mcLoc("block/jungle_log")),
                models().cubeAll(ModBlocks.JUNGLE_WOOD_SLAB.getId().getPath() + "_double", mcLoc("block/jungle_log")));
        wallBlock(ModBlocks.JUNGLE_WOOD_WALL.get(), mcLoc("block/jungle_log"));
        fenceBlock(ModBlocks.JUNGLE_WOOD_FENCE.get(), mcLoc("block/jungle_log"));
        blockItem(ModBlocks.JUNGLE_WOOD_STAIRS);
        blockItem(ModBlocks.JUNGLE_WOOD_SLAB);
        models().withExistingParent(ModBlocks.JUNGLE_WOOD_FENCE.getId().getPath(), mcLoc("block/fence_inventory")).texture("texture", mcLoc("block/jungle_log"));
        models().withExistingParent(ModBlocks.JUNGLE_WOOD_WALL.getId().getPath(), mcLoc("block/wall_inventory")).texture("wall", mcLoc("block/jungle_log"));

        stairsBlock(ModBlocks.ACACIA_WOOD_STAIRS.get(), mcLoc("block/acacia_log"));
        slabBlock(ModBlocks.ACACIA_WOOD_SLAB.get(),
                models().slab(ModBlocks.ACACIA_WOOD_SLAB.getId().getPath(), mcLoc("block/acacia_log"), mcLoc("block/acacia_log"), mcLoc("block/acacia_log")),
                models().slabTop(ModBlocks.ACACIA_WOOD_SLAB.getId().getPath() + "_top", mcLoc("block/acacia_log"), mcLoc("block/acacia_log"), mcLoc("block/acacia_log")),
                models().cubeAll(ModBlocks.ACACIA_WOOD_SLAB.getId().getPath() + "_double", mcLoc("block/acacia_log")));
        wallBlock(ModBlocks.ACACIA_WOOD_WALL.get(), mcLoc("block/acacia_log"));
        fenceBlock(ModBlocks.ACACIA_WOOD_FENCE.get(), mcLoc("block/acacia_log"));
        blockItem(ModBlocks.ACACIA_WOOD_STAIRS);
        blockItem(ModBlocks.ACACIA_WOOD_SLAB);
        models().withExistingParent(ModBlocks.ACACIA_WOOD_FENCE.getId().getPath(), mcLoc("block/fence_inventory")).texture("texture", mcLoc("block/acacia_log"));
        models().withExistingParent(ModBlocks.ACACIA_WOOD_WALL.getId().getPath(), mcLoc("block/wall_inventory")).texture("wall", mcLoc("block/acacia_log"));

        stairsBlock(ModBlocks.DARK_OAK_WOOD_STAIRS.get(), mcLoc("block/dark_oak_log"));
        slabBlock(ModBlocks.DARK_OAK_WOOD_SLAB.get(),
                models().slab(ModBlocks.DARK_OAK_WOOD_SLAB.getId().getPath(), mcLoc("block/dark_oak_log"), mcLoc("block/dark_oak_log"), mcLoc("block/dark_oak_log")),
                models().slabTop(ModBlocks.DARK_OAK_WOOD_SLAB.getId().getPath() + "_top", mcLoc("block/dark_oak_log"), mcLoc("block/dark_oak_log"), mcLoc("block/dark_oak_log")),
                models().cubeAll(ModBlocks.DARK_OAK_WOOD_SLAB.getId().getPath() + "_double", mcLoc("block/dark_oak_log")));
        wallBlock(ModBlocks.DARK_OAK_WOOD_WALL.get(), mcLoc("block/dark_oak_log"));
        fenceBlock(ModBlocks.DARK_OAK_WOOD_FENCE.get(), mcLoc("block/dark_oak_log"));
        blockItem(ModBlocks.DARK_OAK_WOOD_STAIRS);
        blockItem(ModBlocks.DARK_OAK_WOOD_SLAB);
        models().withExistingParent(ModBlocks.DARK_OAK_WOOD_FENCE.getId().getPath(), mcLoc("block/fence_inventory")).texture("texture", mcLoc("block/dark_oak_log"));
        models().withExistingParent(ModBlocks.DARK_OAK_WOOD_WALL.getId().getPath(), mcLoc("block/wall_inventory")).texture("wall", mcLoc("block/dark_oak_log"));

        stairsBlock(ModBlocks.MANGROVE_WOOD_STAIRS.get(), mcLoc("block/mangrove_log"));
        slabBlock(ModBlocks.MANGROVE_WOOD_SLAB.get(),
                models().slab(ModBlocks.MANGROVE_WOOD_SLAB.getId().getPath(), mcLoc("block/mangrove_log"), mcLoc("block/mangrove_log"), mcLoc("block/mangrove_log")),
                models().slabTop(ModBlocks.MANGROVE_WOOD_SLAB.getId().getPath() + "_top", mcLoc("block/mangrove_log"), mcLoc("block/mangrove_log"), mcLoc("block/mangrove_log")),
                models().cubeAll(ModBlocks.MANGROVE_WOOD_SLAB.getId().getPath() + "_double", mcLoc("block/mangrove_log")));
        wallBlock(ModBlocks.MANGROVE_WOOD_WALL.get(), mcLoc("block/mangrove_log"));
        fenceBlock(ModBlocks.MANGROVE_WOOD_FENCE.get(), mcLoc("block/mangrove_log"));
        blockItem(ModBlocks.MANGROVE_WOOD_STAIRS);
        blockItem(ModBlocks.MANGROVE_WOOD_SLAB);
        models().withExistingParent(ModBlocks.MANGROVE_WOOD_FENCE.getId().getPath(), mcLoc("block/fence_inventory")).texture("texture", mcLoc("block/mangrove_log"));
        models().withExistingParent(ModBlocks.MANGROVE_WOOD_WALL.getId().getPath(), mcLoc("block/wall_inventory")).texture("wall", mcLoc("block/mangrove_log"));

        stairsBlock(ModBlocks.CHERRY_WOOD_STAIRS.get(), mcLoc("block/cherry_log"));
        slabBlock(ModBlocks.CHERRY_WOOD_SLAB.get(),
                models().slab(ModBlocks.CHERRY_WOOD_SLAB.getId().getPath(), mcLoc("block/cherry_log"), mcLoc("block/cherry_log"), mcLoc("block/cherry_log")),
                models().slabTop(ModBlocks.CHERRY_WOOD_SLAB.getId().getPath() + "_top", mcLoc("block/cherry_log"), mcLoc("block/cherry_log"), mcLoc("block/cherry_log")),
                models().cubeAll(ModBlocks.MANGROVE_WOOD_SLAB.getId().getPath() + "_double", mcLoc("block/cherry_log")));
        wallBlock(ModBlocks.CHERRY_WOOD_WALL.get(), mcLoc("block/cherry_log"));
        fenceBlock(ModBlocks.CHERRY_WOOD_FENCE.get(), mcLoc("block/cherry_log"));
        blockItem(ModBlocks.CHERRY_WOOD_STAIRS);
        blockItem(ModBlocks.CHERRY_WOOD_SLAB);
        models().withExistingParent(ModBlocks.CHERRY_WOOD_FENCE.getId().getPath(), mcLoc("block/fence_inventory")).texture("texture", mcLoc("block/cherry_log"));
        models().withExistingParent(ModBlocks.CHERRY_WOOD_WALL.getId().getPath(), mcLoc("block/wall_inventory")).texture("wall", mcLoc("block/cherry_log"));

        logBlock(((RotatedPillarBlock) ModBlocks.PINK_DOGWOOD_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.PINK_DOGWOOD_WOOD.get()), blockTexture(ModBlocks.PINK_DOGWOOD_LOG.get()), blockTexture(ModBlocks.PINK_DOGWOOD_LOG.get()));

        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_PINK_DOGWOOD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_PINK_DOGWOOD_WOOD.get()), blockTexture(ModBlocks.STRIPPED_PINK_DOGWOOD_LOG.get()), blockTexture(ModBlocks.STRIPPED_PINK_DOGWOOD_LOG.get()));


        blockItem(ModBlocks.PINK_DOGWOOD_LOG);
        blockItem(ModBlocks.PINK_DOGWOOD_WOOD);
        blockItem(ModBlocks.STRIPPED_PINK_DOGWOOD_LOG);
        blockItem(ModBlocks.STRIPPED_PINK_DOGWOOD_WOOD);

        blockItem(ModBlocks.PINK_DOGWOOD_PLANKS);

        leavesBlock(ModBlocks.PINK_DOGWOOD_LEAVES);
        saplingBlock(ModBlocks.PINK_DOGWOOD_SAPLING);




        stairsBlock(ModBlocks.PINK_DOGWOOD_STAIRS.get(), modLoc("block/pink_dogwood_planks"));
        fenceBlock(ModBlocks.PINK_DOGWOOD_FENCE.get(), modLoc("block/pink_dogwood_planks"));
        blockItem(ModBlocks.PINK_DOGWOOD_STAIRS);

        itemModels().fenceInventory(ModBlocks.PINK_DOGWOOD_FENCE.getId().getPath(), modLoc("block/pink_dogwood_planks"));

        slabBlock(
                ModBlocks.PINK_DOGWOOD_SLAB.get(),
                models().slab(ModBlocks.PINK_DOGWOOD_SLAB.getId().getPath(), modLoc("block/pink_dogwood_planks"), modLoc("block/pink_dogwood_planks"), modLoc("block/pink_dogwood_planks")),
                models().slabTop(ModBlocks.PINK_DOGWOOD_SLAB.getId().getPath() + "_top", modLoc("block/pink_dogwood_planks"), modLoc("block/pink_dogwood_planks"), modLoc("block/pink_dogwood_planks")),
                models().cubeAll(ModBlocks.PINK_DOGWOOD_SLAB.getId().getPath() + "_double", modLoc("block/pink_dogwood_planks"))
        );
        blockItem(ModBlocks.PINK_DOGWOOD_SLAB);





    }


    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
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

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("geological:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("geological:block/" + deferredBlock.getId().getPath() + appendix));
    }
}