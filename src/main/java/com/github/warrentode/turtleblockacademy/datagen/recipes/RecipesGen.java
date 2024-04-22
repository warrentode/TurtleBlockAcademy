package com.github.warrentode.turtleblockacademy.datagen.recipes;

import biomesoplenty.api.block.BOPBlocks;
import com.catastrophe573.dimdungeons.block.BlockRegistrar;
import com.github.warrentode.turtleblockacademy.datagen.recipes.recipe.CuttingRecipesGen;
import com.github.warrentode.turtleblockacademy.datagen.recipes.recipe.LootBagRecipesGen;
import com.github.warrentode.turtleblockacademy.items.ModItems;
import com.github.warrentode.turtleblockacademy.util.PackTags;
import com.mcwlights.kikoz.init.BlockInit;
import decor.delight.init.DecorationDelightModBlocks;
import net.akaneo.fastfooddelight.common.registry.FFItems;
import net.brnbrd.delightful.common.item.DelightfulItems;
import net.mcreator.festivedelight.init.FestiveDelightModItems;
import net.mcreator.unusualend.init.UnusualendModItems;
import net.mehvahdjukaar.supplementaries.reg.ModRegistry;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;
import umpaz.farmersrespite.common.registry.FRItems;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

import java.util.Objects;
import java.util.function.Consumer;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;
import static samebutdifferent.ecologics.registry.ModBlocks.SEASHELL;
import static samebutdifferent.ecologics.registry.ModBlocks.SEASHELL_TILES;

public class RecipesGen extends RecipeProvider implements IConditionBuilder {
    public RecipesGen(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        schoolSupplyRecipes(consumer);
        cookingPotRecipes(consumer);
        mcwlightsRecipes(consumer);
        supplementariesRecipes(consumer);
        festive_delightRecipes(consumer);
        farmersrespiteRecipes(consumer);
        farmersdelightRecipes(consumer);
        fastfooddelightRecipes(consumer);
        decoration_delightRecipes(consumer);
        dimdungeonsRecipes(consumer);
        unusualendRecipes(consumer);
        biomesoplentyRecipes(consumer);
        ecologicsRecipes(consumer);
        minecraftRecipes(consumer);

        LootBagRecipesGen.register(consumer);
        CuttingRecipesGen.register(consumer);
    }

    private void minecraftRecipes(Consumer<FinishedRecipe> consumer) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.YELLOW_STAINED_GLASS),
                        Items.YELLOW_STAINED_GLASS_PANE, 4)
                .unlockedBy("has_" + Items.YELLOW_STAINED_GLASS, has(Items.YELLOW_STAINED_GLASS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.YELLOW_STAINED_GLASS_PANE + "_from_stonecutting"));
        ShapelessRecipeBuilder.shapeless(Items.YELLOW_WOOL)
                .requires(ItemTags.WOOL)
                .requires(Items.YELLOW_DYE)
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.YELLOW_WOOL + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.YELLOW_CARPET)
                .requires(ItemTags.WOOL_CARPETS)
                .requires(Items.YELLOW_DYE)
                .unlockedBy("has_carpet", has(ItemTags.WOOL_CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.YELLOW_CARPET + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.YELLOW_BED)
                .requires(ItemTags.BEDS)
                .requires(Items.YELLOW_DYE)
                .unlockedBy("has_bed", has(ItemTags.BEDS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.YELLOW_BED + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.YELLOW_BANNER)
                .requires(ItemTags.BANNERS)
                .requires(Items.YELLOW_DYE)
                .unlockedBy("has_banner", has(ItemTags.BANNERS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.YELLOW_BANNER + "_from_any_color"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.WHITE_STAINED_GLASS),
                        Items.WHITE_STAINED_GLASS_PANE, 4)
                .unlockedBy("has_" + Items.WHITE_STAINED_GLASS, has(Items.WHITE_STAINED_GLASS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.WHITE_STAINED_GLASS_PANE + "_from_stonecutting"));
        ShapelessRecipeBuilder.shapeless(Items.WHITE_WOOL)
                .requires(ItemTags.WOOL)
                .requires(Items.WHITE_DYE)
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.WHITE_WOOL + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.WHITE_CARPET)
                .requires(ItemTags.WOOL_CARPETS)
                .requires(Items.WHITE_DYE)
                .unlockedBy("has_carpet", has(ItemTags.WOOL_CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.WHITE_CARPET + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.WHITE_BED)
                .requires(ItemTags.BEDS)
                .requires(Items.WHITE_DYE)
                .unlockedBy("has_bed", has(ItemTags.BEDS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.WHITE_BED + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.WHITE_BANNER)
                .requires(ItemTags.BANNERS)
                .requires(Items.WHITE_DYE)
                .unlockedBy("has_banner", has(ItemTags.BANNERS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.WHITE_BANNER + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.STRING)
                .requires(Items.COBWEB)
                .unlockedBy("has_" + Items.COBWEB, has(Items.COBWEB))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.STRING + "_from_" + Items.COBWEB));
        ShapelessRecipeBuilder.shapeless(Items.STRING, 4)
                .requires(ItemTags.WOOL)
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.STRING + "_from_any_wool"));
        ShapedRecipeBuilder.shaped(Items.SADDLE)
                .define('S', PackTags.Items.STRING)
                .define('I', PackTags.Items.IRON_NUGGET)
                .define('L', Tags.Items.LEATHER)
                .pattern("LLL")
                .pattern("S S")
                .pattern("I I")
                .unlockedBy("has_iron_nugget", has(PackTags.Items.IRON_NUGGET))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.SADDLE.toString()));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.RED_STAINED_GLASS),
                        Items.RED_STAINED_GLASS_PANE, 4)
                .unlockedBy("has_" + Items.RED_STAINED_GLASS, has(Items.RED_STAINED_GLASS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.RED_STAINED_GLASS_PANE + "_from_stonecutting"));
        ShapelessRecipeBuilder.shapeless(Items.RED_WOOL)
                .requires(ItemTags.WOOL)
                .requires(Items.RED_DYE)
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.RED_WOOL + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.RED_CARPET)
                .requires(ItemTags.WOOL_CARPETS)
                .requires(Items.RED_DYE)
                .unlockedBy("has_carpet", has(ItemTags.WOOL_CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.RED_CARPET + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.RED_BED)
                .requires(ItemTags.BEDS)
                .requires(Items.RED_DYE)
                .unlockedBy("has_bed", has(ItemTags.BEDS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.RED_BED + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.RED_BANNER)
                .requires(ItemTags.BANNERS)
                .requires(Items.RED_DYE)
                .unlockedBy("has_banner", has(ItemTags.BANNERS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.RED_BANNER + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.QUARTZ, 4)
                .requires(Blocks.QUARTZ_BLOCK)
                .unlockedBy("has_" + Blocks.QUARTZ_BLOCK.asItem(), has(Blocks.QUARTZ_BLOCK))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.QUARTZ.toString()));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.PURPLE_STAINED_GLASS),
                        Items.PURPLE_STAINED_GLASS_PANE, 4)
                .unlockedBy("has_" + Items.PURPLE_STAINED_GLASS, has(Items.PURPLE_STAINED_GLASS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.PURPLE_STAINED_GLASS_PANE + "_from_stonecutting"));
        ShapelessRecipeBuilder.shapeless(Items.PURPLE_WOOL)
                .requires(ItemTags.WOOL)
                .requires(Items.PURPLE_DYE)
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.PURPLE_WOOL + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.PURPLE_CARPET)
                .requires(ItemTags.WOOL_CARPETS)
                .requires(Items.PURPLE_DYE)
                .unlockedBy("has_carpet", has(ItemTags.WOOL_CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.PURPLE_CARPET + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.PURPLE_BED)
                .requires(ItemTags.BEDS)
                .requires(Items.PURPLE_DYE)
                .unlockedBy("has_bed", has(ItemTags.BEDS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.PURPLE_BED + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.PURPLE_BANNER)
                .requires(ItemTags.BANNERS)
                .requires(Items.PURPLE_DYE)
                .unlockedBy("has_banner", has(ItemTags.BANNERS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.PURPLE_BANNER + "_from_any_color"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.PINK_STAINED_GLASS),
                        Items.PINK_STAINED_GLASS_PANE, 4)
                .unlockedBy("has_" + Items.PINK_STAINED_GLASS, has(Items.PINK_STAINED_GLASS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.PINK_STAINED_GLASS_PANE + "_from_stonecutting"));
        ShapelessRecipeBuilder.shapeless(Items.PINK_WOOL)
                .requires(ItemTags.WOOL)
                .requires(Items.PINK_DYE)
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.PINK_WOOL + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.PINK_CARPET)
                .requires(ItemTags.WOOL_CARPETS)
                .requires(Items.PINK_DYE)
                .unlockedBy("has_carpet", has(ItemTags.WOOL_CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.PINK_CARPET + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.PINK_BED)
                .requires(ItemTags.BEDS)
                .requires(Items.PINK_DYE)
                .unlockedBy("has_bed", has(ItemTags.BEDS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.PINK_BED + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.PINK_BANNER)
                .requires(ItemTags.BANNERS)
                .requires(Items.PINK_DYE)
                .unlockedBy("has_banner", has(ItemTags.BANNERS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.PINK_BANNER + "_from_any_color"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.ORANGE_STAINED_GLASS),
                        Items.ORANGE_STAINED_GLASS_PANE, 4)
                .unlockedBy("has_" + Items.ORANGE_STAINED_GLASS, has(Items.ORANGE_STAINED_GLASS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.ORANGE_STAINED_GLASS_PANE + "_from_stonecutting"));
        ShapelessRecipeBuilder.shapeless(Items.ORANGE_WOOL)
                .requires(ItemTags.WOOL)
                .requires(Items.ORANGE_DYE)
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.ORANGE_WOOL + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.ORANGE_CARPET)
                .requires(ItemTags.WOOL_CARPETS)
                .requires(Items.ORANGE_DYE)
                .unlockedBy("has_carpet", has(ItemTags.WOOL_CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.ORANGE_CARPET + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.ORANGE_BED)
                .requires(ItemTags.BEDS)
                .requires(Items.ORANGE_DYE)
                .unlockedBy("has_bed", has(ItemTags.BEDS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.ORANGE_BED + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.ORANGE_BANNER)
                .requires(ItemTags.BANNERS)
                .requires(Items.ORANGE_DYE)
                .unlockedBy("has_banner", has(ItemTags.BANNERS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.ORANGE_BANNER + "_from_any_color"));
        ShapedRecipeBuilder.shaped(Items.NAME_TAG)
                .define('S', PackTags.Items.STRING)
                .define('I', PackTags.Items.IRON_INGOT)
                .define('P', Items.PAPER)
                .pattern("S  ")
                .pattern(" I ")
                .pattern("  P")
                .unlockedBy("has_iron_ingot", has(PackTags.Items.IRON_INGOT))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.NAME_TAG.toString()));
        ShapelessRecipeBuilder.shapeless(Items.MELON_SLICE, 9)
                .requires(Blocks.MELON)
                .unlockedBy("has_" + Blocks.MELON.asItem(), has(Blocks.MELON))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.MELON_SLICE.toString()));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.MAGENTA_STAINED_GLASS),
                        Items.MAGENTA_STAINED_GLASS_PANE, 4)
                .unlockedBy("has_" + Items.MAGENTA_STAINED_GLASS, has(Items.MAGENTA_STAINED_GLASS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.MAGENTA_STAINED_GLASS_PANE + "_from_stonecutting"));
        ShapelessRecipeBuilder.shapeless(Items.MAGENTA_WOOL)
                .requires(ItemTags.WOOL)
                .requires(Items.MAGENTA_DYE)
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.MAGENTA_WOOL + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.MAGENTA_CARPET)
                .requires(ItemTags.WOOL_CARPETS)
                .requires(Items.MAGENTA_DYE)
                .unlockedBy("has_carpet", has(ItemTags.WOOL_CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.MAGENTA_CARPET + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.MAGENTA_BED)
                .requires(ItemTags.BEDS)
                .requires(Items.MAGENTA_DYE)
                .unlockedBy("has_bed", has(ItemTags.BEDS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.MAGENTA_BED + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.MAGENTA_BANNER)
                .requires(ItemTags.BANNERS)
                .requires(Items.MAGENTA_DYE)
                .unlockedBy("has_banner", has(ItemTags.BANNERS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.MAGENTA_BANNER + "_from_any_color"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.LIME_STAINED_GLASS),
                        Items.LIME_STAINED_GLASS_PANE, 4)
                .unlockedBy("has_" + Items.LIME_STAINED_GLASS, has(Items.LIME_STAINED_GLASS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.LIME_STAINED_GLASS_PANE + "_from_stonecutting"));
        ShapelessRecipeBuilder.shapeless(Items.LIME_WOOL)
                .requires(ItemTags.WOOL)
                .requires(Items.LIME_DYE)
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.LIME_WOOL + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.LIME_CARPET)
                .requires(ItemTags.WOOL_CARPETS)
                .requires(Items.LIME_DYE)
                .unlockedBy("has_carpet", has(ItemTags.WOOL_CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.LIME_CARPET + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.LIME_BED)
                .requires(ItemTags.BEDS)
                .requires(Items.LIME_DYE)
                .unlockedBy("has_bed", has(ItemTags.BEDS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.LIME_BED + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.LIME_BANNER)
                .requires(ItemTags.BANNERS)
                .requires(Items.LIME_DYE)
                .unlockedBy("has_banner", has(ItemTags.BANNERS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.LIME_BANNER + "_from_any_color"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.LIGHT_GRAY_STAINED_GLASS),
                        Items.LIGHT_GRAY_STAINED_GLASS_PANE, 4)
                .unlockedBy("has_" + Items.LIGHT_GRAY_STAINED_GLASS, has(Items.LIGHT_GRAY_STAINED_GLASS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.LIGHT_GRAY_STAINED_GLASS_PANE + "_from_stonecutting"));
        ShapelessRecipeBuilder.shapeless(Items.LIGHT_GRAY_WOOL)
                .requires(ItemTags.WOOL)
                .requires(Items.LIGHT_GRAY_DYE)
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.LIGHT_GRAY_WOOL + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.LIGHT_GRAY_CARPET)
                .requires(ItemTags.WOOL_CARPETS)
                .requires(Items.LIGHT_GRAY_DYE)
                .unlockedBy("has_carpet", has(ItemTags.WOOL_CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.LIGHT_GRAY_CARPET + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.LIGHT_GRAY_BED)
                .requires(ItemTags.BEDS)
                .requires(Items.LIGHT_GRAY_DYE)
                .unlockedBy("has_bed", has(ItemTags.BEDS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.LIGHT_GRAY_BED + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.LIGHT_GRAY_BANNER)
                .requires(ItemTags.BANNERS)
                .requires(Items.LIGHT_GRAY_DYE)
                .unlockedBy("has_banner", has(ItemTags.BANNERS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.LIGHT_GRAY_BANNER + "_from_any_color"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.LIGHT_BLUE_STAINED_GLASS),
                        Items.LIGHT_BLUE_STAINED_GLASS_PANE, 4)
                .unlockedBy("has_" + Items.LIGHT_BLUE_STAINED_GLASS, has(Items.LIGHT_BLUE_STAINED_GLASS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.LIGHT_BLUE_STAINED_GLASS_PANE + "_from_stonecutting"));
        ShapelessRecipeBuilder.shapeless(Items.LIGHT_BLUE_WOOL)
                .requires(ItemTags.WOOL)
                .requires(Items.LIGHT_BLUE_DYE)
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.LIGHT_BLUE_WOOL + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.LIGHT_BLUE_CARPET)
                .requires(ItemTags.WOOL_CARPETS)
                .requires(Items.LIGHT_BLUE_DYE)
                .unlockedBy("has_carpet", has(ItemTags.WOOL_CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.LIGHT_BLUE_CARPET + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.LIGHT_BLUE_BED)
                .requires(ItemTags.BEDS)
                .requires(Items.LIGHT_BLUE_DYE)
                .unlockedBy("has_bed", has(ItemTags.BEDS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.LIGHT_BLUE_BED + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.LIGHT_BLUE_BANNER)
                .requires(ItemTags.BANNERS)
                .requires(Items.LIGHT_BLUE_DYE)
                .unlockedBy("has_banner", has(ItemTags.BANNERS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.LIGHT_BLUE_BANNER + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.HONEYCOMB, 4)
                .requires(Blocks.HONEYCOMB_BLOCK)
                .unlockedBy("has_" + Blocks.HONEYCOMB_BLOCK.asItem(), has(Blocks.HONEYCOMB_BLOCK))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.HONEYCOMB.toString()));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.GREEN_STAINED_GLASS),
                        Items.GREEN_STAINED_GLASS_PANE, 4)
                .unlockedBy("has_" + Items.GREEN_STAINED_GLASS, has(Items.GREEN_STAINED_GLASS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.GREEN_STAINED_GLASS_PANE + "_from_stonecutting"));
        ShapelessRecipeBuilder.shapeless(Items.GREEN_WOOL)
                .requires(ItemTags.WOOL)
                .requires(Items.GREEN_DYE)
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.GREEN_WOOL + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.GREEN_CARPET)
                .requires(ItemTags.WOOL_CARPETS)
                .requires(Items.GREEN_DYE)
                .unlockedBy("has_carpet", has(ItemTags.WOOL_CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.GREEN_CARPET + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.GREEN_BED)
                .requires(ItemTags.BEDS)
                .requires(Items.GREEN_DYE)
                .unlockedBy("has_bed", has(ItemTags.BEDS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.GREEN_BED + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.GREEN_BANNER)
                .requires(ItemTags.BANNERS)
                .requires(Items.GREEN_DYE)
                .unlockedBy("has_banner", has(ItemTags.BANNERS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.GREEN_BANNER + "_from_any_color"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.GRAY_STAINED_GLASS),
                        Items.GRAY_STAINED_GLASS_PANE, 4)
                .unlockedBy("has_" + Items.GRAY_STAINED_GLASS, has(Items.GRAY_STAINED_GLASS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.GRAY_STAINED_GLASS_PANE + "_from_stonecutting"));
        ShapelessRecipeBuilder.shapeless(Items.GRAY_WOOL)
                .requires(ItemTags.WOOL)
                .requires(Items.GRAY_DYE)
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.GRAY_WOOL + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.GRAY_CARPET)
                .requires(ItemTags.WOOL_CARPETS)
                .requires(Items.GRAY_DYE)
                .unlockedBy("has_carpet", has(ItemTags.WOOL_CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.GRAY_CARPET + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.GRAY_BED)
                .requires(ItemTags.BEDS)
                .requires(Items.GRAY_DYE)
                .unlockedBy("has_bed", has(ItemTags.BEDS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.GRAY_BED + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.GRAY_BANNER)
                .requires(ItemTags.BANNERS)
                .requires(Items.GRAY_DYE)
                .unlockedBy("has_banner", has(ItemTags.BANNERS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.GRAY_BANNER + "_from_any_color"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.GLASS),
                        Items.GLASS_PANE, 4)
                .unlockedBy("has_" + Items.GLASS, has(Items.GLASS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.GLASS_PANE + "_from_stonecutting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(PackTags.Items.SAND),
                        Items.GLASS, 0.1F, 100)
                .unlockedBy("has_any_sand", has(PackTags.Items.SAND))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.GLASS + "_from_blasting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(PackTags.Items.GLASS),
                        Items.GLASS_BOTTLE, 0.1F, 100)
                .unlockedBy("has_any_glass", has(PackTags.Items.GLASS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.GLASS_BOTTLE + "_from_blasting"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(PackTags.Items.GLASS),
                        Items.GLASS_BOTTLE, 0.1F, 200)
                .unlockedBy("has_any_glass", has(PackTags.Items.GLASS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.GLASS_BOTTLE + "_from_smelting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.CYAN_STAINED_GLASS),
                        Items.CYAN_STAINED_GLASS_PANE, 4)
                .unlockedBy("has_" + Items.CYAN_STAINED_GLASS, has(Items.CYAN_STAINED_GLASS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.CYAN_STAINED_GLASS_PANE + "_from_stonecutting"));
        ShapelessRecipeBuilder.shapeless(Items.CYAN_WOOL)
                .requires(ItemTags.WOOL)
                .requires(Items.CYAN_DYE)
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.CYAN_WOOL + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.CYAN_CARPET)
                .requires(ItemTags.WOOL_CARPETS)
                .requires(Items.CYAN_DYE)
                .unlockedBy("has_carpet", has(ItemTags.WOOL_CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.CYAN_CARPET + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.CYAN_BED)
                .requires(ItemTags.BEDS)
                .requires(Items.CYAN_DYE)
                .unlockedBy("has_bed", has(ItemTags.BEDS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.CYAN_BED + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.CYAN_BANNER)
                .requires(ItemTags.BANNERS)
                .requires(Items.CYAN_DYE)
                .unlockedBy("has_banner", has(ItemTags.BANNERS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.CYAN_BANNER + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.CLAY_BALL, 4)
                .requires(Items.CLAY)
                .unlockedBy("has_" + Items.CLAY, has(Items.CLAY))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.CLAY_BALL.toString()));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.POISONOUS_POTATO),
                        Items.CHARCOAL, 0.15F, 200)
                .unlockedBy("has_poisonous_potato", has(Items.POISONOUS_POTATO))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.CHARCOAL + "_from_" + Items.POISONOUS_POTATO));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.BROWN_STAINED_GLASS),
                        Items.BROWN_STAINED_GLASS_PANE, 4)
                .unlockedBy("has_" + Items.BROWN_STAINED_GLASS, has(Items.BROWN_STAINED_GLASS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.BROWN_STAINED_GLASS_PANE + "_from_stonecutting"));
        ShapelessRecipeBuilder.shapeless(Items.BROWN_WOOL)
                .requires(ItemTags.WOOL)
                .requires(Items.BROWN_DYE)
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.BROWN_WOOL + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.BROWN_CARPET)
                .requires(ItemTags.WOOL_CARPETS)
                .requires(Items.BROWN_DYE)
                .unlockedBy("has_carpet", has(ItemTags.WOOL_CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.BROWN_CARPET + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.BROWN_BED)
                .requires(ItemTags.BEDS)
                .requires(Items.BROWN_DYE)
                .unlockedBy("has_bed", has(ItemTags.BEDS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.BROWN_BED + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.BROWN_BANNER)
                .requires(ItemTags.BANNERS)
                .requires(Items.BROWN_DYE)
                .unlockedBy("has_banner", has(ItemTags.BANNERS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.BROWN_BANNER + "_from_any_color"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.BLUE_STAINED_GLASS),
                        Items.BLUE_STAINED_GLASS_PANE, 4)
                .unlockedBy("has_" + Items.BLUE_STAINED_GLASS, has(Items.BLUE_STAINED_GLASS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.BLUE_STAINED_GLASS + "_from_stonecutting"));
        ShapelessRecipeBuilder.shapeless(Items.BLUE_WOOL)
                .requires(ItemTags.WOOL)
                .requires(Items.BLUE_DYE)
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.BLUE_WOOL + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.BLUE_CARPET)
                .requires(ItemTags.WOOL_CARPETS)
                .requires(Items.BLUE_DYE)
                .unlockedBy("has_carpet", has(ItemTags.WOOL_CARPETS)).save(consumer, new ResourceLocation("minecraft",
                        Items.BLUE_CARPET + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.BLUE_BED)
                .requires(ItemTags.BEDS)
                .requires(Items.BLUE_DYE)
                .unlockedBy("has_bed", has(ItemTags.BEDS)).save(consumer, new ResourceLocation("minecraft",
                        Items.BLUE_BED + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.BLUE_BANNER)
                .requires(ItemTags.BANNERS)
                .requires(Items.BLUE_DYE)
                .unlockedBy("has_banner", has(ItemTags.BANNERS)).save(consumer, new ResourceLocation("minecraft",
                        Items.BLUE_BANNER + "_from_any_color"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.BLACK_STAINED_GLASS),
                        Items.BLACK_STAINED_GLASS_PANE, 4)
                .unlockedBy("has_" + Items.BLACK_STAINED_GLASS, has(Items.BLACK_STAINED_GLASS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.BLACK_STAINED_GLASS + "_from_stonecutting"));
        ShapelessRecipeBuilder.shapeless(Items.BLACK_WOOL)
                .requires(ItemTags.WOOL)
                .requires(Items.BLACK_DYE)
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.BLACK_WOOL + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.BLACK_CARPET)
                .requires(ItemTags.WOOL_CARPETS)
                .requires(Items.BLACK_DYE)
                .unlockedBy("has_carpet", has(ItemTags.WOOL_CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.BLACK_CARPET + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.BLACK_BED)
                .requires(ItemTags.BEDS)
                .requires(Items.BLACK_DYE)
                .unlockedBy("has_bed", has(ItemTags.BEDS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.BLACK_BED + "_from_any_color"));
        ShapelessRecipeBuilder.shapeless(Items.BLACK_BANNER)
                .requires(ItemTags.BANNERS)
                .requires(Items.BLACK_DYE)
                .unlockedBy("has_banner", has(ItemTags.BANNERS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.BLACK_BANNER + "_from_any_color"));
        ShapedRecipeBuilder.shaped(Items.BELL)
                .define('W', ItemTags.LOGS)
                .define('S', Blocks.STONE)
                .define('G', Blocks.GOLD_BLOCK)
                .pattern("WWW")
                .pattern("SGS")
                .pattern("S S")
                .unlockedBy("has_gold_block", has(Blocks.GOLD_BLOCK))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.BELL.toString()));
        ShapelessRecipeBuilder.shapeless(Items.AMETHYST_SHARD, 4)
                .requires(Blocks.AMETHYST_BLOCK)
                .unlockedBy("has_" + Blocks.AMETHYST_BLOCK.asItem(), has(Blocks.AMETHYST_BLOCK))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.AMETHYST_SHARD.toString()));
        ShapedRecipeBuilder.shaped(Items.WHITE_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.WHITE_CARPET)
                .unlockedBy("has_carpet", has(PackTags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.WHITE_WOOL, Items.WHITE_CARPET)));
        ShapedRecipeBuilder.shaped(Items.LIGHT_GRAY_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.LIGHT_GRAY_CARPET)
                .unlockedBy("has_carpet", has(PackTags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.LIGHT_GRAY_WOOL, Items.LIGHT_GRAY_CARPET)));
        ShapedRecipeBuilder.shaped(Items.GRAY_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.GRAY_CARPET)
                .unlockedBy("has_carpet", has(PackTags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.GRAY_WOOL, Items.GRAY_CARPET)));
        ShapedRecipeBuilder.shaped(Items.BLACK_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.BLACK_CARPET)
                .unlockedBy("has_carpet", has(PackTags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.BLACK_WOOL, Items.BLACK_CARPET)));
        ShapedRecipeBuilder.shaped(Items.BROWN_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.BROWN_CARPET)
                .unlockedBy("has_carpet", has(PackTags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.BROWN_WOOL, Items.BROWN_CARPET)));
        ShapedRecipeBuilder.shaped(Items.RED_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.RED_CARPET)
                .unlockedBy("has_carpet", has(PackTags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.RED_WOOL, Items.RED_CARPET)));
        ShapedRecipeBuilder.shaped(Items.ORANGE_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.ORANGE_CARPET)
                .unlockedBy("has_carpet", has(PackTags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.ORANGE_WOOL, Items.ORANGE_CARPET)));
        ShapedRecipeBuilder.shaped(Items.YELLOW_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.YELLOW_CARPET)
                .unlockedBy("has_carpet", has(PackTags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.YELLOW_WOOL, Items.YELLOW_CARPET)));
        ShapedRecipeBuilder.shaped(Items.LIME_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.LIME_CARPET)
                .unlockedBy("has_carpet", has(PackTags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.LIME_WOOL, Items.LIME_CARPET)));
        ShapedRecipeBuilder.shaped(Items.GREEN_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.GREEN_CARPET)
                .unlockedBy("has_carpet", has(PackTags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.GREEN_WOOL, Items.GREEN_CARPET)));
        ShapedRecipeBuilder.shaped(Items.LIGHT_BLUE_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.LIGHT_BLUE_CARPET)
                .unlockedBy("has_carpet", has(PackTags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.LIGHT_BLUE_WOOL, Items.LIGHT_BLUE_CARPET)));
        ShapedRecipeBuilder.shaped(Items.CYAN_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.CYAN_CARPET)
                .unlockedBy("has_carpet", has(PackTags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.CYAN_WOOL, Items.CYAN_CARPET)));
        ShapedRecipeBuilder.shaped(Items.BLUE_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.BLUE_CARPET)
                .unlockedBy("has_carpet", has(PackTags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.BLUE_WOOL, Items.BLUE_CARPET)));
        ShapedRecipeBuilder.shaped(Items.PURPLE_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.PURPLE_CARPET)
                .unlockedBy("has_carpet", has(PackTags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.PURPLE_WOOL, Items.PURPLE_CARPET)));
        ShapedRecipeBuilder.shaped(Items.PINK_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.PINK_CARPET)
                .unlockedBy("has_carpet", has(PackTags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.PINK_WOOL, Items.PINK_CARPET)));
        ShapedRecipeBuilder.shaped(Items.MAGENTA_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.MAGENTA_CARPET)
                .unlockedBy("has_carpet", has(PackTags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.MAGENTA_WOOL, Items.MAGENTA_CARPET)));
        ShapedRecipeBuilder.shaped(Items.MOSS_BLOCK, 2)
                .pattern("XXX")
                .define('X', Items.MOSS_CARPET)
                .unlockedBy("has_moss_carpet", has(Items.MOSS_CARPET))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.MOSS_BLOCK, Items.MOSS_CARPET)));
        ShapelessRecipeBuilder.shapeless(Items.NETHER_WART, 9)
                .requires(Items.NETHER_WART_BLOCK, 1)
                .unlockedBy("has_nether_wart_block", has(Items.NETHER_WART_BLOCK))
                .save(consumer, new ResourceLocation("minecraft", Items.NETHER_WART.toString()));
    }

    private void ecologicsRecipes(Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("ecologics"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(SEASHELL.get(), 4)
                        .requires(SEASHELL_TILES.get())
                        .unlockedBy("has_seashell_tiles", has(SEASHELL_TILES.get()))
                        ::save)
                .build(consumer, new ResourceLocation("ecologics", "items/seashell_from_tiles"));
    }

    private void biomesoplentyRecipes(Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("biomesoplenty"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.STRING, 1)
                        .requires(PackTags.Items.WEBBING)
                        .unlockedBy("has_webbing", has(PackTags.Items.WEBBING))
                        ::save)
                .build(consumer, new ResourceLocation("minecraft", "string_from_webbing"));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("biomesoplenty"))
                .addRecipe(ShapedRecipeBuilder.shaped(BOPBlocks.GLOWING_MOSS_BLOCK.get(), 2)
                        .pattern("XXX")
                        .define('X', BOPBlocks.GLOWING_MOSS_CARPET.get())
                        .unlockedBy("has_glowing_moss_carpet", has(BOPBlocks.GLOWING_MOSS_CARPET.get()))
                        ::save)
                .build(consumer, new ResourceLocation("biomesoplenty", "blocks/glowing_moss_block_from_glowing_moss_carpet"));
    }

    private void unusualendRecipes(Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("unusualend"))
                .addRecipe(ShapedRecipeBuilder.shaped(Items.WARPED_WART_BLOCK, 1)
                        .pattern("XXX")
                        .pattern("XXX")
                        .pattern("XXX")
                        .define('X', UnusualendModItems.WARPED_WART.get())
                        .unlockedBy("has_warped_wart", has(UnusualendModItems.WARPED_WART.get()))
                        ::save)
                .build(consumer, new ResourceLocation("unusualend", "blocks/" + Items.WARPED_WART_BLOCK));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("unusualend"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(UnusualendModItems.WANDERING_STEW.get(), 1)
                        .requires(Items.CRIMSON_FUNGUS, 1)
                        .requires(UnusualendModItems.CHORUS_FUNGUS.get(), 1)
                        .requires(Items.BOWL, 1)
                        .unlockedBy("has_chorus_fungus", has(UnusualendModItems.CHORUS_FUNGUS.get()))
                        ::save)
                .build(consumer, new ResourceLocation("unusualend", "items/" + UnusualendModItems.WANDERING_STEW.get()));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("unusualend"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(UnusualendModItems.WARPED_WART.get(), 9)
                        .requires(Items.WARPED_WART_BLOCK, 1)
                        .unlockedBy("has_warped_wart_block", has(Items.WARPED_WART_BLOCK))
                        ::save)
                .build(consumer, new ResourceLocation("unusualend", "items/" + UnusualendModItems.WARPED_WART.get()));
    }

    private void decoration_delightRecipes(Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("decoration_delight"))
                .addRecipe(ShapedRecipeBuilder.shaped(DecorationDelightModBlocks.SINK.get())
                        .pattern("I I")
                        .pattern("BCB")
                        .pattern("BBB")
                        .define('I', PackTags.Items.IRON_INGOT)
                        .define('B', Blocks.BRICKS)
                        .define('C', Blocks.CAULDRON)
                        .unlockedBy("has_cauldron", has(Blocks.CAULDRON))
                        ::save)
                .build(consumer, new ResourceLocation("decoration_delight",
                        DecorationDelightModBlocks.SINK.get().asItem().toString()));
    }

    private void dimdungeonsRecipes(Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("dimdungeons"))
                .addRecipe(ShapedRecipeBuilder.shaped(BlockRegistrar.BLOCK_CHARGER_FULL.get())
                        .pattern("PPP")
                        .pattern("EGE")
                        .pattern("PPP")
                        .define('P', Items.ENDER_EYE)
                        .define('E', Blocks.END_STONE)
                        .define('G', BlockRegistrar.BLOCK_GILDED_PORTAL.get())
                        .unlockedBy("has_end_stone", has(Blocks.END_STONE))
                        ::save)
                .build(consumer, new ResourceLocation("dimdungeons",
                        BlockRegistrar.BLOCK_CHARGER_FULL.get().asItem().toString()));
    }

    private void fastfooddelightRecipes(Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("fastfooddelight"))
                .addRecipe(ShapedRecipeBuilder.shaped(FFItems.CHECKOUT_MACHINE.get())
                        .pattern(" I ")
                        .pattern("IRI")
                        .pattern("GGG")
                        .define('I', PackTags.Items.IRON_INGOT)
                        .define('R', Items.REDSTONE)
                        .define('G', PackTags.Items.GOLD_NUGGET)
                        .unlockedBy("has_gold_nugget", has(PackTags.Items.GOLD_NUGGET))
                        ::save)
                .build(consumer, new ResourceLocation("fastfooddelight",
                        FFItems.CHECKOUT_MACHINE.get().toString()));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("fastfooddelight"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(FFItems.CHICKEN_CHEESE_SANDWICH.get())
                        .requires(PackTags.Items.BREAD)
                        .requires(PackTags.Items.COOKED_CHICKEN)
                        .requires(PackTags.Items.GREENS)
                        .requires(PackTags.Items.VEGETABLES)
                        .requires(PackTags.Items.CHEESE_SLICES)
                        .unlockedBy("has_cooked_chicken", has(PackTags.Items.COOKED_CHICKEN))
                        ::save)
                .build(consumer, new ResourceLocation("fastfooddelight",
                        FFItems.CHICKEN_CHEESE_SANDWICH.get() + "_alt"));
    }

    private void farmersdelightRecipes(Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(ModBlocks.SHEPHERDS_PIE_BLOCK.get())
                        .requires(Items.BAKED_POTATO)
                        .requires(Items.BAKED_POTATO)
                        .requires(PackTags.Items.MILK)
                        .requires(PackTags.Items.COOKED_MUTTON)
                        .requires(PackTags.Items.COOKED_MUTTON)
                        .requires(PackTags.Items.COOKED_MUTTON)
                        .requires(PackTags.Items.ONION_INGREDIENTS)
                        .requires(PackTags.Items.ONION_INGREDIENTS)
                        .requires(Items.BOWL)
                        .unlockedBy("has_cooked_mutton",
                                has(PackTags.Items.COOKED_MUTTON))
                        ::save)
                .build(consumer, new ResourceLocation("farmersdelight",
                        ModBlocks.SHEPHERDS_PIE_BLOCK.get().asItem() + "_alt"));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(ModBlocks.ROAST_CHICKEN_BLOCK.get())
                        .requires(PackTags.Items.EGGS)
                        .requires(PackTags.Items.BREAD)
                        .requires(PackTags.Items.VEGETABLES)
                        .requires(PackTags.Items.VEGETABLES)
                        .requires(PackTags.Items.VEGETABLES)
                        .requires(PackTags.Items.VEGETABLES)
                        .requires(PackTags.Items.VEGETABLES)
                        .requires(Items.COOKED_CHICKEN)
                        .requires(Items.BOWL)
                        .unlockedBy("has_cooked_chicken",
                                has(Items.COOKED_CHICKEN))
                        ::save)
                .build(consumer, new ResourceLocation("farmersdelight",
                        ModBlocks.ROAST_CHICKEN_BLOCK.get().asItem() + "_alt"));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(ModBlocks.ORGANIC_COMPOST.get())
                        .requires(Blocks.DIRT)
                        .requires(Items.ROTTEN_FLESH)
                        .requires(Items.ROTTEN_FLESH)
                        .requires(Items.BONE_MEAL)
                        .requires(Items.BONE_MEAL)
                        .requires(Items.BONE_MEAL)
                        .requires(Items.BONE_MEAL)
                        .requires(vectorwing.farmersdelight.common.registry.ModItems.TREE_BARK.get())
                        .requires(vectorwing.farmersdelight.common.registry.ModItems.TREE_BARK.get())
                        .unlockedBy("has_rotten_flesh",
                                has(Items.ROTTEN_FLESH))
                        ::save)
                .build(consumer, new ResourceLocation("farmersdelight",
                        ModBlocks.ORGANIC_COMPOST.get().asItem() + "_from_rotten_flesh"));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(ModBlocks.ORGANIC_COMPOST.get())
                        .requires(Blocks.DIRT)
                        .requires(PackTags.Items.STRAW_FIBERS)
                        .requires(PackTags.Items.STRAW_FIBERS)
                        .requires(Items.BONE_MEAL)
                        .requires(Items.BONE_MEAL)
                        .requires(vectorwing.farmersdelight.common.registry.ModItems.TREE_BARK.get())
                        .requires(vectorwing.farmersdelight.common.registry.ModItems.TREE_BARK.get())
                        .requires(vectorwing.farmersdelight.common.registry.ModItems.TREE_BARK.get())
                        .requires(vectorwing.farmersdelight.common.registry.ModItems.TREE_BARK.get())
                        .unlockedBy("has_tree_bark",
                                has(vectorwing.farmersdelight.common.registry.ModItems.TREE_BARK.get()))
                        ::save)
                .build(consumer, new ResourceLocation("farmersdelight",
                        ModBlocks.ORGANIC_COMPOST.get().asItem() + "_from_straw_fibers"));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(ModBlocks.HONEY_GLAZED_HAM_BLOCK.get())
                        .requires(PackTags.Items.BERRIES)
                        .requires(PackTags.Items.BERRIES)
                        .requires(PackTags.Items.BERRIES)
                        .requires(PackTags.Items.BERRIES)
                        .requires(PackTags.Items.GLAZES)
                        .requires(vectorwing.farmersdelight.common.registry.ModItems.SMOKED_HAM.get())
                        .requires(PackTags.Items.COOKED_RICE)
                        .requires(PackTags.Items.COOKED_RICE)
                        .requires(Items.BOWL)
                        .unlockedBy("has_smoked_ham",
                                has(vectorwing.farmersdelight.common.registry.ModItems.SMOKED_HAM.get()))
                        ::save)
                .build(consumer, new ResourceLocation("farmersdelight",
                        ModBlocks.HONEY_GLAZED_HAM_BLOCK.get().asItem() + "_alt"));
    }

    private void farmersrespiteRecipes(Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersrespite"))
                .addCondition(modLoaded("delightful"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(FRItems.GREEN_TEA.get())
                        .group("green_tea")
                        .requires(DelightfulItems.MATCHA.get())
                        .requires(DelightfulItems.MATCHA.get())
                        .unlockedBy("has_matcha",
                                has(DelightfulItems.MATCHA.get()))
                        ::save)
                .build(consumer, new ResourceLocation("farmersrespite", "brewing/" +
                        FRItems.GREEN_TEA.get() + "_from_" + DelightfulItems.MATCHA.get()));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersrespite"))
                .addCondition(modLoaded("delightful"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(FRItems.GREEN_TEA.get())
                        .group("green_tea")
                        .requires(DelightfulItems.GREEN_TEA_LEAF.get())
                        .requires(DelightfulItems.GREEN_TEA_LEAF.get())
                        .unlockedBy("has_green_tea_leaf",
                                has(DelightfulItems.GREEN_TEA_LEAF.get()))
                        ::save)
                .build(consumer, new ResourceLocation("farmersrespite", "brewing/" +
                        FRItems.GREEN_TEA.get() + "_from_" + DelightfulItems.GREEN_TEA_LEAF.get()));
    }

    private void festive_delightRecipes(Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("festive_delight"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(FestiveDelightModItems.FESTIVE_CHICKEN_BLOCK.get())
                        .requires(PackTags.Items.BERRIES)
                        .requires(PackTags.Items.BERRIES)
                        .requires(PackTags.Items.BERRIES)
                        .requires(PackTags.Items.BERRIES)
                        .requires(PackTags.Items.GLAZES)
                        .requires(PackTags.Items.COOKED_CHICKEN)
                        .requires(PackTags.Items.COOKED_RICE)
                        .requires(PackTags.Items.COOKED_RICE)
                        .requires(Items.BOWL)
                        .unlockedBy("has_cooked_chicken",
                                has(PackTags.Items.COOKED_CHICKEN))
                        ::save)
                .build(consumer, new ResourceLocation("festive_delight",
                        FestiveDelightModItems.FESTIVE_CHICKEN_BLOCK.get() + "_alt"));
    }

    private void supplementariesRecipes(Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("supplementaries"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(ModRegistry.SOAP.get(), 6)
                        .requires(Items.WATER_BUCKET)
                        .requires(PackTags.Items.ASH)
                        .requires(PackTags.Items.ASH)
                        .requires(PackTags.Items.ASH)
                        .requires(PackTags.Items.ASH)
                        .requires(PackTags.Items.FATS)
                        .unlockedBy("has_ash", has(PackTags.Items.ASH))
                        ::save)
                .build(consumer, new ResourceLocation("supplementaries", "items/soap_alt"));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("supplementaries"))
                .addRecipe(ShapedRecipeBuilder.shaped(ModRegistry.QUIVER_ITEM.get(), 1)
                        .pattern(" SL")
                        .pattern("SL ")
                        .pattern("L  ")
                        .define('S', PackTags.Items.STRING)
                        .define('L', Items.LEATHER)
                        .unlockedBy("has_leather", has(Items.LEATHER))
                        ::save)
                .build(consumer, new ResourceLocation("supplementaries", "items/" + ModRegistry.QUIVER_ITEM.get()));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("supplementaries"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.LAPIS_LAZULI, 4)
                        .requires(PackTags.Items.LAPIS_BRICKS)
                        .unlockedBy("has_lapis_bricks",
                                has(PackTags.Items.LAPIS_BRICKS))
                        ::save)
                .build(consumer, new ResourceLocation("supplementaries",
                        Items.LAPIS_LAZULI + "_from_" + "lapis_bricks"));
    }

    private void mcwlightsRecipes(Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("mcwlights"))
                .addRecipe(ShapedRecipeBuilder.shaped(BlockInit.CLASSIC_STREET_LAMP.get(), 3)
                        .pattern(" L ")
                        .pattern(" F ")
                        .pattern(" W ")
                        .define('L', PackTags.Items.LANTERNS)
                        .define('F', Tags.Items.FENCES)
                        .define('W', PackTags.Items.WALLS)
                        .unlockedBy("can_craft_lantern", RecipeUnlockedTrigger
                                .unlocked(Objects.requireNonNull(ResourceLocation.tryParse("minecraft/recipes/lantern"))))
                        ::save)
                .build(consumer, new ResourceLocation("mcwlights", "classic_street_lamp_alt"));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("mcwlights"))
                .addRecipe(ShapedRecipeBuilder.shaped(BlockInit.SOUL_CLASSIC_STREET_LAMP.get(), 3)
                        .pattern(" S ")
                        .pattern(" F ")
                        .pattern(" W ")
                        .define('S', Items.SOUL_LANTERN)
                        .define('F', Tags.Items.FENCES)
                        .define('W', PackTags.Items.WALLS)
                        .unlockedBy("has_soul_lantern", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SOUL_LANTERN))
                        ::save)
                .build(consumer, new ResourceLocation("mcwlights", "soul_classic_street_lamp_alt"));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("mcwlights"))
                .addRecipe(ShapedRecipeBuilder.shaped(BlockInit.DOUBLE_STREET_LAMP.get(), 3)
                        .pattern("L L")
                        .pattern(" F ")
                        .pattern(" W ")
                        .define('L', PackTags.Items.LANTERNS)
                        .define('F', Tags.Items.FENCES)
                        .define('W', PackTags.Items.WALLS)
                        .unlockedBy("can_craft_classic_street_lamp", RecipeUnlockedTrigger
                                .unlocked(Objects.requireNonNull(ResourceLocation.tryParse("mcwlights/recipes/classic_street_lamp_alt"))))
                        ::save)
                .build(consumer, new ResourceLocation("mcwlights", "double_street_lamp_alt"));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("mcwlights"))
                .addRecipe(ShapedRecipeBuilder.shaped(BlockInit.SOUL_DOUBLE_STREET_LAMP.get(), 3)
                        .pattern("S S")
                        .pattern(" F ")
                        .pattern(" W ")
                        .define('S', Items.SOUL_LANTERN)
                        .define('F', Tags.Items.FENCES)
                        .define('W', PackTags.Items.WALLS)
                        .unlockedBy("can_craft_soul_classic_street_lamp", RecipeUnlockedTrigger
                                .unlocked(Objects.requireNonNull(ResourceLocation.tryParse("mcwlights/recipes/soul_classic_street_lamp_alt"))))
                        ::save)
                .build(consumer, new ResourceLocation("mcwlights", "soul_double_street_lamp_alt"));
    }

    private void cookingPotRecipes(Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("delightful"))
                .addCondition(this.itemExists(DelightfulItems.ROCK_CANDY.getId().getNamespace(), DelightfulItems.ROCK_CANDY.getId().getPath()))
                .addCondition(this.not(this.tagEmpty(PackTags.Items.GEM_SHARDS)))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(DelightfulItems.ROCK_CANDY.get(), 1, 200, 0.35F, Items.STICK)
                                .addIngredient(Ingredient.of(PackTags.Items.GEM_SHARDS), 2)
                                .addIngredient(PackTags.Items.SUGAR)
                                .unlockedBy("has_gem_shards", has(PackTags.Items.GEM_SHARDS))
                                .build(consumer, new ResourceLocation("delightful", "cooking/rock_candy"))
                );
    }

    private void schoolSupplyRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ModItems.STUDENT_CARD.get(), 1)
                .pattern("###")
                .pattern("#T#")
                .pattern("###")
                .define('#', Items.PAPER)
                .define('T', Items.NAME_TAG)
                .unlockedBy("has_name_tag", has(Items.NAME_TAG))
                .save(consumer, new ResourceLocation(MODID,
                        ModItems.STUDENT_CARD.get().toString()));
    }
}
