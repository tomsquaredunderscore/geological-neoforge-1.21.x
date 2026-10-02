package net.tomsquared.geological.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.tomsquared.geological.Geological;
import net.tomsquared.geological.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Geological.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.GOLDEN_AMETHYST_BLOCK.get())
                .add(ModBlocks.PUMICE.get())
                .add(ModBlocks.PYRITE_BLOCK.get())
                .add(ModBlocks.RAW_PYRITE_BLOCK.get())
                .add(ModBlocks.DEEPSLATE_PYRITE_ORE.get())
                .add(ModBlocks.PYRITE_ORE.get())
                .add(ModBlocks.RAW_QUARTZ.get())

        ;



        this.tag(BlockTags.LOGS_THAT_BURN)
                        .add(ModBlocks.PINK_DOGWOOD_LOG.get())
                        .add(ModBlocks.PINK_DOGWOOD_WOOD.get())
                        .add(ModBlocks.STRIPPED_PINK_DOGWOOD_LOG.get())
                        .add(ModBlocks.STRIPPED_PINK_DOGWOOD_LOG.get())
                        .add(ModBlocks.OAK_WOOD_FENCE.get())
                        .add(ModBlocks.OAK_WOOD_STAIRS.get())
                .add(ModBlocks.OAK_WOOD_WALL.get())
                .add(ModBlocks.OAK_WOOD_SLAB.get())

                .add(ModBlocks.BIRCH_WOOD_FENCE.get())
                .add(ModBlocks.BIRCH_WOOD_STAIRS.get())
                .add(ModBlocks.BIRCH_WOOD_WALL.get())
                .add(ModBlocks.BIRCH_WOOD_SLAB.get())

                .add(ModBlocks.SPRUCE_WOOD_FENCE.get())
                .add(ModBlocks.SPRUCE_WOOD_SLAB.get())
                .add(ModBlocks.SPRUCE_WOOD_STAIRS.get())
                .add(ModBlocks.SPRUCE_WOOD_WALL.get())

                .add(ModBlocks.JUNGLE_WOOD_FENCE.get())
                .add(ModBlocks.JUNGLE_WOOD_SLAB.get())
                .add(ModBlocks.JUNGLE_WOOD_STAIRS.get())
                .add(ModBlocks.JUNGLE_WOOD_WALL.get())

                .add(ModBlocks.ACACIA_WOOD_FENCE.get())
                .add(ModBlocks.ACACIA_WOOD_SLAB.get())
                .add(ModBlocks.ACACIA_WOOD_STAIRS.get())
                .add(ModBlocks.ACACIA_WOOD_WALL.get())

                .add(ModBlocks.DARK_OAK_WOOD_FENCE.get())
                .add(ModBlocks.DARK_OAK_WOOD_SLAB.get())
                .add(ModBlocks.DARK_OAK_WOOD_STAIRS.get())
                .add(ModBlocks.DARK_OAK_WOOD_WALL.get())

                .add(ModBlocks.PINK_DOGWOOD_WOOD.get())
                .add(ModBlocks.PINK_DOGWOOD_SLAB.get())
                .add(ModBlocks.PINK_DOGWOOD_STAIRS.get())
                .add(ModBlocks.MANGROVE_WOOD_FENCE.get())
                .add(ModBlocks.MANGROVE_WOOD_SLAB.get())
                .add(ModBlocks.MANGROVE_WOOD_STAIRS.get())
                .add(ModBlocks.MANGROVE_WOOD_WALL.get())
                .add(ModBlocks.PINK_DOGWOOD_FENCE.get())

                .add(ModBlocks.CHERRY_WOOD_FENCE.get())
                .add(ModBlocks.CHERRY_WOOD_SLAB.get())
                .add(ModBlocks.CHERRY_WOOD_STAIRS.get())
                .add(ModBlocks.CHERRY_WOOD_WALL.get());



        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.OAK_WOOD_FENCE.get())
                .add(ModBlocks.OAK_WOOD_STAIRS.get())
                .add(ModBlocks.OAK_WOOD_WALL.get())
                .add(ModBlocks.OAK_WOOD_SLAB.get())

                .add(ModBlocks.BIRCH_WOOD_FENCE.get())
                .add(ModBlocks.BIRCH_WOOD_STAIRS.get())
                .add(ModBlocks.BIRCH_WOOD_WALL.get())
                .add(ModBlocks.BIRCH_WOOD_SLAB.get())

                .add(ModBlocks.SPRUCE_WOOD_FENCE.get())
                .add(ModBlocks.SPRUCE_WOOD_SLAB.get())
                .add(ModBlocks.SPRUCE_WOOD_STAIRS.get())
                .add(ModBlocks.SPRUCE_WOOD_WALL.get())

                .add(ModBlocks.JUNGLE_WOOD_FENCE.get())
                .add(ModBlocks.JUNGLE_WOOD_SLAB.get())
                .add(ModBlocks.JUNGLE_WOOD_STAIRS.get())
                .add(ModBlocks.JUNGLE_WOOD_WALL.get())

                .add(ModBlocks.ACACIA_WOOD_FENCE.get())
                .add(ModBlocks.ACACIA_WOOD_SLAB.get())
                .add(ModBlocks.ACACIA_WOOD_STAIRS.get())
                .add(ModBlocks.ACACIA_WOOD_WALL.get())

                .add(ModBlocks.DARK_OAK_WOOD_FENCE.get())
                .add(ModBlocks.DARK_OAK_WOOD_SLAB.get())
                .add(ModBlocks.DARK_OAK_WOOD_STAIRS.get())
                .add(ModBlocks.DARK_OAK_WOOD_WALL.get())


                .add(ModBlocks.PINK_DOGWOOD_WOOD.get())


                .add(ModBlocks.PINK_DOGWOOD_SLAB.get())
                .add(ModBlocks.PINK_DOGWOOD_STAIRS.get())

                .add(ModBlocks.MANGROVE_WOOD_FENCE.get())
                .add(ModBlocks.PINK_DOGWOOD_LOG.get())

                .add(ModBlocks.MANGROVE_WOOD_SLAB.get())
                .add(ModBlocks.MANGROVE_WOOD_STAIRS.get())
                .add(ModBlocks.MANGROVE_WOOD_WALL.get())
                .add(ModBlocks.PINK_DOGWOOD_FENCE.get())

                .add(ModBlocks.CHERRY_WOOD_FENCE.get())
                .add(ModBlocks.CHERRY_WOOD_SLAB.get())
                .add(ModBlocks.CHERRY_WOOD_STAIRS.get())
                .add(ModBlocks.PINK_DOGWOOD_PLANKS.get())
                .add(ModBlocks.CHERRY_WOOD_WALL.get());

       tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.OAK_WOOD_FENCE.get())
                .add(ModBlocks.BIRCH_WOOD_FENCE.get())
                .add(ModBlocks.SPRUCE_WOOD_FENCE.get())
                .add(ModBlocks.JUNGLE_WOOD_FENCE.get())
                .add(ModBlocks.ACACIA_WOOD_FENCE.get())
                .add(ModBlocks.DARK_OAK_WOOD_FENCE.get())
                .add(ModBlocks.MANGROVE_WOOD_FENCE.get())
                .add(ModBlocks.CHERRY_WOOD_FENCE.get())
                .add(ModBlocks.PINK_DOGWOOD_FENCE.get());


        tag(BlockTags.PLANKS)
                .add(ModBlocks.PINK_DOGWOOD_PLANKS.get());



        // WALLS
        tag(BlockTags.WALLS)
                .add(ModBlocks.OAK_WOOD_WALL.get())
                .add(ModBlocks.SPRUCE_WOOD_WALL.get())
                .add(ModBlocks.BIRCH_WOOD_WALL.get())
                .add(ModBlocks.JUNGLE_WOOD_WALL.get())
                .add(ModBlocks.ACACIA_WOOD_WALL.get())
                .add(ModBlocks.DARK_OAK_WOOD_WALL.get())
                .add(ModBlocks.MANGROVE_WOOD_WALL.get())
                .add(ModBlocks.CHERRY_WOOD_WALL.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.GOLDEN_AMETHYST_BLOCK.get())
                .add(ModBlocks.PUMICE.get())
                .add(ModBlocks.PYRITE_BLOCK.get())
                .add(ModBlocks.RAW_QUARTZ.get())
                .add(ModBlocks.RAW_PYRITE_BLOCK.get());





    }
}

