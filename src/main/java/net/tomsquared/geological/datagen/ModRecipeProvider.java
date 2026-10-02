package net.tomsquared.geological.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.tomsquared.geological.Geological;
import net.tomsquared.geological.block.ModBlocks;
import net.tomsquared.geological.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }




    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_DOGWOOD_PLANKS.get(), 4)
                .requires(ModBlocks.PINK_DOGWOOD_LOG.get())
                .unlockedBy("has_log", has(ModBlocks.PINK_DOGWOOD_LOG.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Geological.MOD_ID, "pink_dogwood_planks_from_log"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_DOGWOOD_PLANKS.get(), 4)
                .requires(ModBlocks.PINK_DOGWOOD_WOOD.get())
                .unlockedBy("has_wood", has(ModBlocks.PINK_DOGWOOD_WOOD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Geological.MOD_ID, "pink_dogwood_planks_from_wood"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_DOGWOOD_PLANKS.get(), 4)
                .requires(ModBlocks.STRIPPED_PINK_DOGWOOD_LOG.get())
                .unlockedBy("has_stripped_log", has(ModBlocks.STRIPPED_PINK_DOGWOOD_LOG.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Geological.MOD_ID, "pink_dogwood_planks_from_stripped_log"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_DOGWOOD_PLANKS.get(), 4)
                .requires(ModBlocks.STRIPPED_PINK_DOGWOOD_WOOD.get())
                .unlockedBy("has_stripped_wood", has(ModBlocks.STRIPPED_PINK_DOGWOOD_WOOD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Geological.MOD_ID, "pink_dogwood_planks_from_stripped_wood"));

        stairBuilder(ModBlocks.PINK_DOGWOOD_STAIRS.get(), Ingredient.of(ModBlocks.PINK_DOGWOOD_PLANKS.get()))
                .group("wooden_stairs")
                .unlockedBy("has_planks", has(ModBlocks.PINK_DOGWOOD_PLANKS.get()))
                .save(recipeOutput);

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_DOGWOOD_SLAB.get(), Ingredient.of(ModBlocks.PINK_DOGWOOD_PLANKS.get()))
                .group("wooden_slab")
                .unlockedBy("has_planks", has(ModBlocks.PINK_DOGWOOD_PLANKS.get()))
                .save(recipeOutput);

        fenceBuilder(ModBlocks.PINK_DOGWOOD_FENCE.get(), Ingredient.of(ModBlocks.PINK_DOGWOOD_PLANKS.get()))
                .group("wooden_fence")
                .unlockedBy("has_planks", has(ModBlocks.PINK_DOGWOOD_PLANKS.get()))
                .save(recipeOutput);



        stairBuilder(ModBlocks.OAK_WOOD_STAIRS.get(), Ingredient.of(ModBlocks.PUMICE)).group("pumice")
                .unlockedBy("has_pumice", has(ModBlocks.PUMICE)).save(recipeOutput);

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAK_WOOD_SLAB.get(), ModBlocks.PUMICE.get());

        fenceBuilder(ModBlocks.OAK_WOOD_FENCE.get(), Ingredient.of(ModBlocks.PUMICE.get())).group("pumice")
                .unlockedBy("has_pumice", has(ModBlocks.PUMICE.get())).save(recipeOutput);
      wall(recipeOutput,RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAK_WOOD_WALL.get(), ModBlocks.PUMICE.get());



        List<ItemLike> PYRITE_SMELTABLES = List.of(ModItems.RAW_PYRITE, ModBlocks.DEEPSLATE_PYRITE_ORE, ModBlocks.PYRITE_ORE);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.PUMICE_STONE.get(), 9)
                .requires(ModBlocks.PUMICE)
                .unlockedBy("has_pumice_block", has(ModBlocks.PUMICE)).save(recipeOutput, "geological:pumice_stone_from_pumice");

        oreSmelting(recipeOutput, PYRITE_SMELTABLES, RecipeCategory.MISC, ModItems.PYRITE_INGOT.get(), 0.25f,200, "pyrite");
        oreBlasting(recipeOutput, PYRITE_SMELTABLES, RecipeCategory.MISC, ModItems.PYRITE_INGOT.get(), 0f,10, "pyrite");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Geological.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }



    }
}
