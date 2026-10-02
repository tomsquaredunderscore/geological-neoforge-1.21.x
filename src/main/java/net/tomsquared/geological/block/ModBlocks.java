package net.tomsquared.geological.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tomsquared.geological.Geological;
import net.tomsquared.geological.block.custom.ModFlammableRotatedPillarBlock;
import net.tomsquared.geological.item.ModItems;
import net.tomsquared.geological.sound.ModSounds;
import net.tomsquared.geological.worldgen.tree.ModTreeGrowers;

import java.util.Optional;
import java.util.function.Supplier;


public class ModBlocks {


    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Geological.MOD_ID);


    public static final SoundType RAW_QUARTZ_SOUNDS = new SoundType(1.0f, 1.0f, null, null, null, null, null) {
        @Override
        public net.minecraft.sounds.SoundEvent getBreakSound() {
            return ModSounds.RAW_QUARTZ_BREAK.get(); // Triggers breaking pool
        }

        @Override
        public net.minecraft.sounds.SoundEvent getStepSound() {
            return ModSounds.RAW_QUARTZ_STEP.get();  // Triggers stepping pool
        }

        @Override
        public net.minecraft.sounds.SoundEvent getPlaceSound() {
            return ModSounds.RAW_QUARTZ_SOUNDS.get(); // Triggers base pool
        }

        @Override
        public net.minecraft.sounds.SoundEvent getHitSound() {
            return ModSounds.RAW_QUARTZ_SOUNDS.get();  // Triggers base pool
        }

        @Override
        public net.minecraft.sounds.SoundEvent getFallSound() {
            return ModSounds.RAW_QUARTZ_SOUNDS.get();  // Triggers base pool
        }
    };
    public static final DeferredBlock<Block> PUMICE = registerBlock("pumice",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.CORAL_BLOCK)));

    public static final DeferredBlock<Block> GOLDEN_AMETHYST_BLOCK = registerBlock("golden_amethyst_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> PYRITE_BLOCK = registerBlock("pyrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> RAW_QUARTZ = registerBlock("raw_quartz",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> PYRITE_ORE = registerBlock("pyrite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DEEPSLATE_PYRITE_ORE = registerBlock("deepslate_pyrite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> RAW_PYRITE_BLOCK = registerBlock("raw_pyrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));


    // OAK
    public static final DeferredBlock<StairBlock> OAK_WOOD_STAIRS = registerBlock("oak_wood_stairs",
            () -> new StairBlock(Blocks.OAK_WOOD.defaultBlockState(), BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<SlabBlock> OAK_WOOD_SLAB = registerBlock("oak_wood_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<WallBlock> OAK_WOOD_WALL = registerBlock("oak_wood_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<FenceBlock> OAK_WOOD_FENCE = registerBlock("oak_wood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));

    // SPRUCE
    public static final DeferredBlock<StairBlock> SPRUCE_WOOD_STAIRS = registerBlock("spruce_wood_stairs",
            () -> new StairBlock(Blocks.SPRUCE_WOOD.defaultBlockState(), BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<SlabBlock> SPRUCE_WOOD_SLAB = registerBlock("spruce_wood_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<WallBlock> SPRUCE_WOOD_WALL = registerBlock("spruce_wood_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<FenceBlock> SPRUCE_WOOD_FENCE = registerBlock("spruce_wood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));

    // JUNGLE
    public static final DeferredBlock<StairBlock> JUNGLE_WOOD_STAIRS = registerBlock("jungle_wood_stairs",
            () -> new StairBlock(Blocks.JUNGLE_WOOD.defaultBlockState(), BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<SlabBlock> JUNGLE_WOOD_SLAB = registerBlock("jungle_wood_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<WallBlock> JUNGLE_WOOD_WALL = registerBlock("jungle_wood_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<FenceBlock> JUNGLE_WOOD_FENCE = registerBlock("jungle_wood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));

    // BIRCH
    public static final DeferredBlock<StairBlock> BIRCH_WOOD_STAIRS = registerBlock("birch_wood_stairs",
            () -> new StairBlock(Blocks.BIRCH_WOOD.defaultBlockState(), BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<SlabBlock> BIRCH_WOOD_SLAB = registerBlock("birch_wood_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<WallBlock> BIRCH_WOOD_WALL = registerBlock("birch_wood_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<FenceBlock> BIRCH_WOOD_FENCE = registerBlock("birch_wood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));

    // ACACIA
    public static final DeferredBlock<StairBlock> ACACIA_WOOD_STAIRS = registerBlock("acacia_wood_stairs",
            () -> new StairBlock(Blocks.ACACIA_WOOD.defaultBlockState(), BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<SlabBlock> ACACIA_WOOD_SLAB = registerBlock("acacia_wood_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<WallBlock> ACACIA_WOOD_WALL = registerBlock("acacia_wood_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<FenceBlock> ACACIA_WOOD_FENCE = registerBlock("acacia_wood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));

    // DARK OAK
    public static final DeferredBlock<StairBlock> DARK_OAK_WOOD_STAIRS = registerBlock("dark_oak_wood_stairs",
            () -> new StairBlock(Blocks.DARK_OAK_WOOD.defaultBlockState(), BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<SlabBlock> DARK_OAK_WOOD_SLAB = registerBlock("dark_oak_wood_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<WallBlock> DARK_OAK_WOOD_WALL = registerBlock("dark_oak_wood_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<FenceBlock> DARK_OAK_WOOD_FENCE = registerBlock("dark_oak_wood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));

    // MANGROVE
    public static final DeferredBlock<StairBlock> MANGROVE_WOOD_STAIRS = registerBlock("mangrove_wood_stairs",
            () -> new StairBlock(Blocks.MANGROVE_WOOD.defaultBlockState(), BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<SlabBlock> MANGROVE_WOOD_SLAB = registerBlock("mangrove_wood_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<WallBlock> MANGROVE_WOOD_WALL = registerBlock("mangrove_wood_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<FenceBlock> MANGROVE_WOOD_FENCE = registerBlock("mangrove_wood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));

    // CHERRY
    public static final DeferredBlock<StairBlock> CHERRY_WOOD_STAIRS = registerBlock("cherry_wood_stairs",
            () -> new StairBlock(Blocks.CHERRY_WOOD.defaultBlockState(), BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<SlabBlock> CHERRY_WOOD_SLAB = registerBlock("cherry_wood_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<WallBlock> CHERRY_WOOD_WALL = registerBlock("cherry_wood_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<FenceBlock> CHERRY_WOOD_FENCE = registerBlock("cherry_wood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> PINK_DOGWOOD_LOG = registerBlock("pink_dogwood_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_PINK_DOGWOOD_LOG = registerBlock("stripped_pink_dogwood_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> PINK_DOGWOOD_WOOD = registerBlock("pink_dogwood_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PINK_DOGWOOD_WOOD = registerBlock("stripped_pink_dogwood_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> PINK_DOGWOOD_PLANKS = registerBlock("pink_dogwood_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });


    public static final DeferredBlock<Block> PINK_DOGWOOD_LEAVES = registerBlock("pink_dogwood_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> PINK_DOGWOOD_SAPLING = registerBlock("pink_dogwood_sapling",
            () -> new SaplingBlock(ModTreeGrowers.PINK_DOGWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));


    public static final DeferredBlock<StairBlock> PINK_DOGWOOD_STAIRS = registerBlock("pink_dogwood_stairs",
            () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).sound(SoundType.WOOD)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });
    public static final DeferredBlock<SlabBlock> PINK_DOGWOOD_SLAB = registerBlock("pink_dogwood_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).sound(SoundType.WOOD)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });
    public static final DeferredBlock<FenceBlock> PINK_DOGWOOD_FENCE = registerBlock("pink_dogwood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }




    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);

    }

}
