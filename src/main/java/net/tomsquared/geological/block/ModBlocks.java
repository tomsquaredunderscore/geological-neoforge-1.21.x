package net.tomsquared.geological.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tomsquared.geological.Geological;
import net.tomsquared.geological.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Geological.MOD_ID);

    public static final DeferredBlock<Block> PYRITE_BLOCK = registerBlock("pyrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).instrument(NoteBlockInstrument.BELL).sound(SoundType.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> RAW_PYRITE_BLOCK = registerBlock("raw_pyrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).instrument(NoteBlockInstrument.BELL).sound(SoundType.STONE).requiresCorrectToolForDrops()));



    public static final DeferredBlock<Block> GOLDEN_ANETHST_BLOCK = registerBlock("golden_amethyst_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).instrument(NoteBlockInstrument.BELL).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));



    public static final DeferredBlock<Block> PUMICE = registerBlock("pumice",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).requiresCorrectToolForDrops()));
// Oak
public static final DeferredBlock<StairBlock> OAK_LOG_STARS = registerBlock("oak_log_stairs",
        () -> new StairBlock(Blocks.OAK_WOOD.defaultBlockState(),
                BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

public static final DeferredBlock<FenceBlock> OAK_LOG_FENCE = registerBlock("oak_log_fence",
        () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

public static final DeferredBlock<WallBlock> OAK_LOG_WALL = registerBlock("oak_log_wall",
        () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));


    public static final DeferredBlock<SlabBlock> OAK_LOG_SLAB = registerBlock("oak_log_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));



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
