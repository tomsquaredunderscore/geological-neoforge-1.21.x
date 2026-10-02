package net.tomsquared.geological.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.tomsquared.geological.Geological;
import net.tomsquared.geological.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {


    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Geological.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {



        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.PINK_DOGWOOD_PLANKS.asItem());


        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.PINK_DOGWOOD_LOG.get().asItem())
                .add(ModBlocks.PINK_DOGWOOD_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_PINK_DOGWOOD_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_PINK_DOGWOOD_LOG.get().asItem())
                .add(ModBlocks.OAK_WOOD_WALL.get().asItem())
                .add(ModBlocks.OAK_WOOD_SLAB.get().asItem())

                .add(ModBlocks.BIRCH_WOOD_FENCE.get().asItem())
                .add(ModBlocks.BIRCH_WOOD_STAIRS.get().asItem())
                .add(ModBlocks.BIRCH_WOOD_WALL.get().asItem())
                .add(ModBlocks.BIRCH_WOOD_SLAB.get().asItem())

                .add(ModBlocks.SPRUCE_WOOD_FENCE.get().asItem())
                .add(ModBlocks.SPRUCE_WOOD_SLAB.get().asItem())
                .add(ModBlocks.SPRUCE_WOOD_STAIRS.get().asItem())
                .add(ModBlocks.SPRUCE_WOOD_WALL.get().asItem())

                .add(ModBlocks.JUNGLE_WOOD_FENCE.get().asItem())
                .add(ModBlocks.JUNGLE_WOOD_SLAB.get().asItem())
                .add(ModBlocks.JUNGLE_WOOD_STAIRS.get().asItem())
                .add(ModBlocks.JUNGLE_WOOD_WALL.get().asItem())

                .add(ModBlocks.ACACIA_WOOD_FENCE.get().asItem())
                .add(ModBlocks.ACACIA_WOOD_SLAB.get().asItem())
                .add(ModBlocks.ACACIA_WOOD_STAIRS.get().asItem())
                .add(ModBlocks.ACACIA_WOOD_WALL.get().asItem())

                .add(ModBlocks.DARK_OAK_WOOD_FENCE.get().asItem())
                .add(ModBlocks.DARK_OAK_WOOD_SLAB.get().asItem())
                .add(ModBlocks.DARK_OAK_WOOD_STAIRS.get().asItem())
                .add(ModBlocks.DARK_OAK_WOOD_WALL.get().asItem())

                .add(ModBlocks.PINK_DOGWOOD_WOOD.get().asItem())
                .add(ModBlocks.PINK_DOGWOOD_SLAB.get().asItem())
                .add(ModBlocks.PINK_DOGWOOD_STAIRS.get().asItem())
                .add(ModBlocks.MANGROVE_WOOD_FENCE.get().asItem())
                .add(ModBlocks.MANGROVE_WOOD_SLAB.get().asItem())
                .add(ModBlocks.MANGROVE_WOOD_STAIRS.get().asItem())
                .add(ModBlocks.MANGROVE_WOOD_WALL.get().asItem())
                .add(ModBlocks.PINK_DOGWOOD_FENCE.get().asItem())
                .add(ModBlocks.CHERRY_WOOD_FENCE.get().asItem())
                .add(ModBlocks.CHERRY_WOOD_SLAB.get().asItem())
                .add(ModBlocks.CHERRY_WOOD_STAIRS.get().asItem())
                .add(ModBlocks.CHERRY_WOOD_WALL.get().asItem());


    }

}