package net.tomsquared.geological.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.tomsquared.geological.block.ModBlocks;
import net.tomsquared.geological.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.PUMICE.get());
        dropSelf(ModBlocks.PYRITE_BLOCK.get());
        dropSelf(ModBlocks.RAW_PYRITE_BLOCK.get());
        dropSelf(ModBlocks.GOLDEN_AMETHYST_BLOCK.get());
        dropSelf(ModBlocks.RAW_QUARTZ.get());

        add(ModBlocks.PYRITE_ORE.get(),
                block -> createOreDrop(ModBlocks.PYRITE_ORE.get(), ModItems.RAW_PYRITE.get()));

        add(ModBlocks.DEEPSLATE_PYRITE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_PYRITE_ORE.get(), ModItems.RAW_PYRITE.get()));

        // Oak WOOD STUFF
        add(ModBlocks.OAK_WOOD_STAIRS.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.OAK_LOG))));

        add(ModBlocks.OAK_WOOD_WALL.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.OAK_LOG))));

        add(ModBlocks.OAK_WOOD_FENCE.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.OAK_LOG))));

        add(ModBlocks.OAK_WOOD_SLAB.get(),
                block -> LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(block)
                                        .when(this.hasSilkTouch())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))))
                                .add(LootItem.lootTableItem(Blocks.OAK_LOG)
                                        .when(this.hasSilkTouch().invert())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))))
                        ));
       // Spruce WOOD STUFF
        add(ModBlocks.SPRUCE_WOOD_STAIRS.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.SPRUCE_LOG))));

        add(ModBlocks.SPRUCE_WOOD_WALL.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.SPRUCE_LOG))));

        add(ModBlocks.SPRUCE_WOOD_FENCE.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.SPRUCE_LOG))));

        add(ModBlocks.SPRUCE_WOOD_SLAB.get(),
                block -> LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(block)
                                        .when(this.hasSilkTouch())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))))
                                .add(LootItem.lootTableItem(Blocks.SPRUCE_LOG)
                                        .when(this.hasSilkTouch().invert())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))))
                        )
        );
        // birch WOOD STUFF
        add(ModBlocks.BIRCH_WOOD_STAIRS.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.BIRCH_LOG))));

        add(ModBlocks.BIRCH_WOOD_WALL.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.BIRCH_LOG))));

        add(ModBlocks.BIRCH_WOOD_FENCE.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.BIRCH_LOG))));

        add(ModBlocks.BIRCH_WOOD_SLAB.get(),
                block -> LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(block)
                                        .when(this.hasSilkTouch())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))))
                                .add(LootItem.lootTableItem(Blocks.BIRCH_LOG)
                                        .when(this.hasSilkTouch().invert())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))))
                        )
        );    // jungle WOOD STUFF
        add(ModBlocks.JUNGLE_WOOD_STAIRS.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.JUNGLE_LOG))));

        add(ModBlocks.JUNGLE_WOOD_WALL.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.JUNGLE_LOG))));

        add(ModBlocks.JUNGLE_WOOD_FENCE.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.JUNGLE_LOG))));

        add(ModBlocks.JUNGLE_WOOD_SLAB.get(),
                block -> LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(block)
                                        .when(this.hasSilkTouch())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))))
                                .add(LootItem.lootTableItem(Blocks.JUNGLE_LOG)
                                        .when(this.hasSilkTouch().invert())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))))
                        )
        );  add(ModBlocks.ACACIA_WOOD_STAIRS.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.ACACIA_LOG))));

        add(ModBlocks.ACACIA_WOOD_WALL.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.ACACIA_LOG))));

        add(ModBlocks.ACACIA_WOOD_FENCE.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.ACACIA_LOG))));

        add(ModBlocks.ACACIA_WOOD_SLAB.get(),
                block -> LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(block)
                                        .when(this.hasSilkTouch())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))))
                                .add(LootItem.lootTableItem(Blocks.ACACIA_LOG)
                                        .when(this.hasSilkTouch().invert())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))))
                        )
        );

        // Dark Oak WOOD STUFF
        add(ModBlocks.DARK_OAK_WOOD_STAIRS.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.DARK_OAK_LOG))));

        add(ModBlocks.DARK_OAK_WOOD_WALL.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.DARK_OAK_LOG))));

        add(ModBlocks.DARK_OAK_WOOD_FENCE.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.DARK_OAK_LOG))));

        add(ModBlocks.DARK_OAK_WOOD_SLAB.get(),
                block -> LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(block)
                                        .when(this.hasSilkTouch())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))))
                                .add(LootItem.lootTableItem(Blocks.DARK_OAK_LOG)
                                        .when(this.hasSilkTouch().invert())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))))
                        )
        );

        // Mangrove WOOD STUFF
        add(ModBlocks.MANGROVE_WOOD_STAIRS.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.MANGROVE_LOG))));

        add(ModBlocks.MANGROVE_WOOD_WALL.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.MANGROVE_LOG))));

        add(ModBlocks.MANGROVE_WOOD_FENCE.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.MANGROVE_LOG))));

        add(ModBlocks.MANGROVE_WOOD_SLAB.get(),
                block -> LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(block)
                                        .when(this.hasSilkTouch())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))))
                                .add(LootItem.lootTableItem(Blocks.MANGROVE_LOG)
                                        .when(this.hasSilkTouch().invert())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))))
                        )
        );

        // Cherry WOOD STUFF
        add(ModBlocks.CHERRY_WOOD_STAIRS.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.CHERRY_LOG))));

        add(ModBlocks.CHERRY_WOOD_WALL.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.CHERRY_LOG))));

        add(ModBlocks.CHERRY_WOOD_FENCE.get(),
                block -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Blocks.CHERRY_LOG))));

        add(ModBlocks.CHERRY_WOOD_SLAB.get(),
                block -> LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(block)
                                        .when(this.hasSilkTouch())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))))
                                .add(LootItem.lootTableItem(Blocks.CHERRY_LOG)
                                        .when(this.hasSilkTouch().invert())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))))
                        )
        );


        dropSelf(ModBlocks.PINK_DOGWOOD_LOG.get());
        dropSelf(ModBlocks.STRIPPED_PINK_DOGWOOD_LOG.get());
        dropSelf(ModBlocks.PINK_DOGWOOD_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_PINK_DOGWOOD_WOOD.get());
        dropSelf(ModBlocks.PINK_DOGWOOD_PLANKS.get());
        dropSelf(ModBlocks.PINK_DOGWOOD_SAPLING.get());
        add(ModBlocks.PINK_DOGWOOD_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.PINK_DOGWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));


        dropSelf(ModBlocks.PINK_DOGWOOD_STAIRS.get());
        dropSelf(ModBlocks.PINK_DOGWOOD_FENCE.get());
        add(ModBlocks.PINK_DOGWOOD_SLAB.get(), block -> createSlabItemTable(block));


    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}