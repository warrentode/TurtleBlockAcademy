package com.github.warrentode.turtleblockacademy.datagen.recipes.recipe;

import biomesoplenty.api.block.BOPBlocks;
import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherItems;
import com.github.warrentode.turtleblockacademy.util.TBATags;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.registries.ForgeRegistries;
import samebutdifferent.ecologics.registry.ModBlocks;
import vectorwing.farmersdelight.common.crafting.ingredient.ToolActionIngredient;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.Objects;
import java.util.function.Consumer;

import static samebutdifferent.ecologics.registry.ModBlocks.SEASHELL;

public class CuttingRecipesGen {
    public static void register(Consumer<FinishedRecipe> consumer) {
        // axe
        stripLogForBark(consumer, BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get());
        stripLogForBark(consumer, BOPBlocks.PALM_WOOD.get(), BOPBlocks.STRIPPED_PALM_WOOD.get());

        stripLogForBark(consumer, BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get());
        stripLogForBark(consumer, BOPBlocks.REDWOOD_WOOD.get(), BOPBlocks.STRIPPED_REDWOOD_WOOD.get());

        stripLogForBark(consumer, BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get());
        stripLogForBark(consumer, BOPBlocks.CHERRY_WOOD.get(), BOPBlocks.STRIPPED_CHERRY_WOOD.get());

        stripLogForBark(consumer, BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get());
        stripLogForBark(consumer, BOPBlocks.MAHOGANY_WOOD.get(), BOPBlocks.STRIPPED_MAHOGANY_WOOD.get());

        stripLogForBark(consumer, BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get());
        stripLogForBark(consumer, BOPBlocks.JACARANDA_WOOD.get(), BOPBlocks.STRIPPED_JACARANDA_WOOD.get());

        stripLogForBark(consumer, BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get());
        stripLogForBark(consumer, BOPBlocks.WILLOW_WOOD.get(), BOPBlocks.STRIPPED_WILLOW_WOOD.get());

        stripLogForBark(consumer, BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get());
        stripLogForBark(consumer, BOPBlocks.DEAD_WOOD.get(), BOPBlocks.STRIPPED_DEAD_WOOD.get());

        stripLogForBark(consumer, BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get());
        stripLogForBark(consumer, BOPBlocks.MAGIC_WOOD.get(), BOPBlocks.STRIPPED_MAGIC_WOOD.get());

        stripLogForBark(consumer, BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get());
        stripLogForBark(consumer, BOPBlocks.UMBRAN_WOOD.get(), BOPBlocks.STRIPPED_UMBRAN_WOOD.get());

        stripLogForBark(consumer, BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get());
        stripLogForBark(consumer, BOPBlocks.HELLBARK_WOOD.get(), BOPBlocks.STRIPPED_HELLBARK_WOOD.get());

        stripLogForBark(consumer, BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get());
        stripLogForBark(consumer, BOPBlocks.FIR_WOOD.get(), BOPBlocks.STRIPPED_FIR_WOOD.get());

        stripLogForBark(consumer, ModBlocks.WALNUT_LOG.get(), ModBlocks.STRIPPED_WALNUT_LOG.get());
        stripLogForBark(consumer, ModBlocks.WALNUT_WOOD.get(), ModBlocks.STRIPPED_WALNUT_WOOD.get());

        stripLogForBark(consumer, ModBlocks.COCONUT_LOG.get(), ModBlocks.STRIPPED_COCONUT_LOG.get());
        stripLogForBark(consumer, ModBlocks.COCONUT_WOOD.get(), ModBlocks.STRIPPED_COCONUT_WOOD.get());

        stripLogForBark(consumer, ModBlocks.AZALEA_LOG.get(), ModBlocks.STRIPPED_AZALEA_LOG.get());
        stripLogForBark(consumer, ModBlocks.AZALEA_WOOD.get(), ModBlocks.STRIPPED_AZALEA_WOOD.get());

        stripLogForBark(consumer, ModBlocks.FLOWERING_AZALEA_LOG.get(), ModBlocks.STRIPPED_AZALEA_LOG.get());
        stripLogForBark(consumer, ModBlocks.FLOWERING_AZALEA_WOOD.get(), ModBlocks.STRIPPED_AZALEA_WOOD.get());

        stripLogForBark(consumer, AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get());
        stripLogForBark(consumer, AetherBlocks.SKYROOT_WOOD.get(), AetherBlocks.STRIPPED_SKYROOT_WOOD.get());

        stripGoldenOakLogForBark(consumer, AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get());
        stripGoldenOakLogForBark(consumer, AetherBlocks.GOLDEN_OAK_WOOD.get(), AetherBlocks.STRIPPED_SKYROOT_WOOD.get());

        // Shovel
        shovelCutting(consumer);
    }

    private static void shovelCutting(Consumer<FinishedRecipe> consumer) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.GRAVEL), new ToolActionIngredient(ToolActions.SHOVEL_DIG), Items.GRAVEL, 1)
                .addResultWithChance(Items.FLINT, 0.2F)
                .addResultWithChance(Items.QUARTZ, 0.1F)
                .addResultWithChance(Items.BONE, 0.05F)
                .addResultWithChance(SEASHELL.get(), 0.05F)
                .build(consumer, "farmersdelight:cutting/gravel_alt");
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(TBATags.Items.SAND), new ToolActionIngredient(ToolActions.SHOVEL_DIG), Items.SAND, 1)
                .addResultWithChance(Items.QUARTZ, 0.1F)
                .addResultWithChance(Items.BONE, 0.05F)
                .addResultWithChance(SEASHELL.get(), 0.05F)
                .build(consumer, "farmersdelight:cutting/sand");
    }

    private static void stripLogForBark(Consumer<FinishedRecipe> consumer, ItemLike log, ItemLike strippedLog) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(log), new ToolActionIngredient(ToolActions.AXE_STRIP), strippedLog)
                .addResult(ModItems.TREE_BARK.get())
                .addSound(Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getKey(SoundEvents.AXE_STRIP)).toString())
                .build(consumer);
    }

    private static void stripGoldenOakLogForBark(Consumer<FinishedRecipe> consumer, ItemLike log, ItemLike strippedLog) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(log), new ToolActionIngredient(ToolActions.AXE_STRIP), strippedLog)
                .addResult(ModItems.TREE_BARK.get())
                .addResultWithChance(AetherItems.AMBROSIUM_SHARD.get(), 0.1F)
                .addSound(Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getKey(SoundEvents.AXE_STRIP)).toString())
                .build(consumer);
    }
}