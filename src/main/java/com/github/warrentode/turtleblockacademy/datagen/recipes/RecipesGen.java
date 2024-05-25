package com.github.warrentode.turtleblockacademy.datagen.recipes;

import biomesoplenty.api.block.BOPBlocks;
import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherItems;
import com.catastrophe573.dimdungeons.block.BlockRegistrar;
import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.datagen.recipes.builder.BrewingRecipeBuilder;
import com.github.warrentode.turtleblockacademy.datagen.recipes.builder.FermentingPotRecipeBuilder;
import com.github.warrentode.turtleblockacademy.datagen.recipes.builder.PatchouliShapelessBookRecipeBuilder;
import com.github.warrentode.turtleblockacademy.datagen.recipes.recipe.CuttingRecipesGen;
import com.github.warrentode.turtleblockacademy.datagen.recipes.recipe.LootBagRecipesGen;
import com.github.warrentode.turtleblockacademy.items.TBAItems;
import com.github.warrentode.turtleblockacademy.recipe.fermenting.FermentingRecipeBookTab;
import com.github.warrentode.turtleblockacademy.util.TBATags;
import com.mcwlights.kikoz.init.BlockInit;
import decor.delight.init.DecorationDelightModBlocks;
import net.akaneo.fastfooddelight.common.registry.FFItems;
import net.brnbrd.delightful.common.item.DelightfulItems;
import net.mcreator.festivedelight.init.FestiveDelightModItems;
import net.mcreator.phantasm.init.PhantasmModBlocks;
import net.mcreator.unusualend.init.UnusualendModBlocks;
import net.mcreator.unusualend.init.UnusualendModItems;
import net.mehvahdjukaar.supplementaries.reg.ModRegistry;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.fluids.TinkerFluids;
import umpaz.farmersrespite.common.registry.FRItems;
import umpaz.farmersrespite.data.builder.KettleRecipeBuilder;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static com.catastrophe573.dimdungeons.item.ItemRegistrar.ITEM_HOMEWARD_PEARL;
import static com.catastrophe573.dimdungeons.item.ItemRegistrar.ITEM_PORTAL_KEY;
import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;
import static net.brnbrd.delightful.common.item.DelightfulItems.GREEN_TEA_LEAF;
import static net.brnbrd.delightful.common.item.DelightfulItems.MATCHA;
import static net.minecraft.world.item.Items.MUSHROOM_STEW;
import static samebutdifferent.ecologics.registry.ModBlocks.SEASHELL;
import static samebutdifferent.ecologics.registry.ModBlocks.SEASHELL_TILES;
import static umpaz.farmersrespite.common.registry.FRItems.GREEN_TEA;
import static vectorwing.farmersdelight.common.registry.ModItems.*;

public class RecipesGen extends RecipeProvider implements IConditionBuilder {
    public RecipesGen(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        schoolSupplyRecipes(consumer);
        brewingRecipes(consumer);
        cookingPotRecipes(consumer);
        kettleRecipes(consumer);
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
        patchouliBooksRecipes(consumer);
        fermentingRecipes(consumer);

        LootBagRecipesGen.register(consumer);
        CuttingRecipesGen.register(consumer);
    }

    private void fermentingRecipes(Consumer<FinishedRecipe> consumer) {
        FermentingPotRecipeBuilder.fermentingPotRecipe(TBAItems.BEET_PICKLES.get(),
                        1, 300, 0.35F, Items.SMOOTH_STONE_SLAB,
                        Items.BOWL)
                .setRecipeBookTab(FermentingRecipeBookTab.PICKLES)
                .addIngredient(Items.BEETROOT)
                .addIngredient(TBAItems.VINEGAR_BOTTLE.get())
                .addIngredient(TBATags.Items.SUGAR)
                .addIngredient(TBATags.Items.SUGAR)
                .addIngredient(TBATags.Items.SALT_INGREDIENTS)
                .addIngredient(TBAItems.GROUND_CLOVES.get())
                .unlockedBy("has_beets", has(Items.BEETROOT))
                .build(consumer, new ResourceLocation(MODID,
                        TBAItems.BEET_PICKLES.get().asItem().toString()));

        FermentingPotRecipeBuilder.fermentingPotRecipe(TBAItems.BEET_WINE.get(),
                        1, 300, 0.35F, Items.WHITE_CARPET,
                        Items.GLASS_BOTTLE)
                .setRecipeBookTab(FermentingRecipeBookTab.LIQUIDS)
                .setGroup("beet_wine")
                .addIngredient(Items.BEETROOT_SOUP)
                .addIngredient(Items.BEETROOT_SOUP)
                .addIngredient(Items.BEETROOT_SOUP)
                .addIngredient(Items.BEETROOT_SOUP)
                .addIngredient(TBATags.Items.SUGAR)
                .addIngredient(TBAItems.YEAST.get())
                .unlockedBy("has_beets", has(Items.BEETROOT))
                .build(consumer, new ResourceLocation(MODID,
                        TBAItems.BEET_WINE.get() + "_from_yeast"));

        FermentingPotRecipeBuilder.fermentingPotRecipe(TBAItems.BEET_WINE.get(),
                        1, 300, 0.35F, Items.WHITE_CARPET,
                        Items.GLASS_BOTTLE)
                .setRecipeBookTab(FermentingRecipeBookTab.LIQUIDS)
                .setGroup("beet_wine")
                .addIngredient(Items.BEETROOT_SOUP)
                .addIngredient(Items.BEETROOT_SOUP)
                .addIngredient(Items.BEETROOT_SOUP)
                .addIngredient(Items.BEETROOT_SOUP)
                .addIngredient(TBATags.Items.SUGAR)
                .addIngredient(TBATags.Items.BREAD)
                .unlockedBy("has_beets", has(Items.BEETROOT))
                .build(consumer, new ResourceLocation(MODID,
                        TBAItems.BEET_WINE.get() + "_from_bread"));

        FermentingPotRecipeBuilder.fermentingPotRecipe(TBAItems.HARD_APPLE_CIDER.get(),
                        1, 300, 0.35F, Items.WHITE_CARPET,
                        Items.GLASS_BOTTLE)
                .setRecipeBookTab(FermentingRecipeBookTab.LIQUIDS)
                .setGroup("hard_cider")
                .addIngredient(TBATags.Items.APPLE_CIDERS)
                .addIngredient(TBATags.Items.APPLE_CIDERS)
                .addIngredient(TBATags.Items.APPLE_CIDERS)
                .addIngredient(TBATags.Items.APPLE_CIDERS)
                .addIngredient(TBATags.Items.SUGAR)
                .addIngredient(TBAItems.YEAST.get())
                .unlockedBy("has_apple_cider", has(TBATags.Items.APPLE_CIDERS))
                .build(consumer, new ResourceLocation(MODID,
                        TBAItems.HARD_APPLE_CIDER.get() + "_from_yeast"));

        ConditionalRecipe.builder()
                .addCondition(modLoaded("tconstruct"))
                .addRecipe(finishedRecipeConsumer ->
                        FermentingPotRecipeBuilder.fermentingPotRecipe(TBAItems.BEET_WINE.get(),
                                        1, 300, 0.35F, Items.WHITE_CARPET,
                                        Items.GLASS_BOTTLE)
                                .setRecipeBookTab(FermentingRecipeBookTab.LIQUIDS)
                                .setGroup("beet_wine")
                                .addIngredient(TinkerFluids.beetrootSoup)
                                .addIngredient(TBATags.Items.SUGAR)
                                .addIngredient(TBAItems.YEAST.get())
                                .unlockedBy("has_beets", has(Items.BEETROOT))
                                .build(consumer, new ResourceLocation(MODID,
                                        TBAItems.BEET_WINE.get() + "_from_tconstruct_beetroot_soup_bucket"))
                );

        FermentingPotRecipeBuilder.fermentingPotRecipe(TBAItems.VINEGAR_BOTTLE.get(),
                        1, 300, 0.35F, Items.WHITE_CARPET,
                        Items.GLASS_BOTTLE)
                .setRecipeBookTab(FermentingRecipeBookTab.LIQUIDS)
                .setGroup("vinegar")
                .addIngredient(TBATags.Items.ALCOHOL)
                .addIngredient(TBATags.Items.ALCOHOL)
                .addIngredient(TBATags.Items.ALCOHOL)
                .addIngredient(TBATags.Items.ALCOHOL)
                .unlockedBy("has_alcohol", has(TBATags.Items.ALCOHOL))
                .build(consumer, new ResourceLocation(MODID,
                        TBAItems.VINEGAR_BOTTLE.get().asItem().toString()));

        FermentingPotRecipeBuilder.fermentingPotRecipe(TBAItems.YEAST.get(),
                4,300, 0.35F, Items.WHITE_CARPET)
                .setRecipeBookTab(FermentingRecipeBookTab.AGENTS)
                .addIngredient(TBATags.Items.WHEAT_FLOUR)
                .addIngredient(TBATags.Items.WHEAT_FLOUR)
                .addIngredient(TBATags.Items.WHEAT_FLOUR)
                .addIngredient(TBATags.Items.WHEAT_FLOUR)
                .addIngredient(Items.WATER_BUCKET)
                .unlockedBy("has_wheat", has(Items.WHEAT))
                .build(consumer, new ResourceLocation(MODID,
                        TBAItems.YEAST.get().asItem().toString()));
    }

    private void brewingRecipes(Consumer<FinishedRecipe> consumer) {
        // remove this recipe once the fermenting pot is up and running correctly
        ConditionalRecipe.builder()
                .addCondition(modLoaded("drinkbeer"))
                .addRecipe(finishedRecipeConsumer ->
                        BrewingRecipeBuilder.brewingRecipe(TBAItems.BEET_WINE.get(),
                                        24000, Items.GLASS_BOTTLE, 4)
                                .addIngredient(Items.BEETROOT_SOUP)
                                .addIngredient(Items.BEETROOT_SOUP)
                                .addIngredient(TBATags.Items.SUGAR)
                                .addIngredient(TBATags.Items.BREAD)
                                .build(consumer, new ResourceLocation("drinkbeer",
                                        TBAItems.BEET_WINE.get().asItem().toString()))
                );
        // keep this one for bonus mass production
        ConditionalRecipe.builder()
                .addCondition(modLoaded("drinkbeer"))
                .addCondition(modLoaded("tconstruct"))
                .addRecipe(finishedRecipeConsumer ->
                        BrewingRecipeBuilder.brewingRecipe(TBAItems.BEET_WINE.get(),
                                        24000, Items.GLASS_BOTTLE, 4)
                                .addIngredient(TinkerFluids.beetrootSoup)
                                .addIngredient(TBATags.Items.SUGAR)
                                .addIngredient(TBATags.Items.SUGAR)
                                .addIngredient(TBATags.Items.BREAD)
                                .build(consumer, new ResourceLocation("drinkbeer",
                                        TBAItems.BEET_WINE.get() + "_from_beetroot_soup_bucket"))
                );
        // keep this one for bonus mass production
        ConditionalRecipe.builder()
                .addCondition(modLoaded("drinkbeer"))
                .addRecipe(finishedRecipeConsumer ->
                        BrewingRecipeBuilder.brewingRecipe(TBAItems.VINEGAR_BOTTLE.get(),
                                        24000, Items.GLASS_BOTTLE, 4)
                                .addIngredient(TBATags.Items.ALCOHOL)
                                .addIngredient(TBATags.Items.ALCOHOL)
                                .addIngredient(TBATags.Items.ALCOHOL)
                                .addIngredient(TBATags.Items.ALCOHOL)
                                .build(consumer, new ResourceLocation("drinkbeer",
                                        TBAItems.VINEGAR_BOTTLE.get().asItem().toString()))
                );
        // keep this one for bonus mass production
        ConditionalRecipe.builder()
                .addCondition(modLoaded("drinkbeer"))
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(finishedRecipeConsumer ->
                        BrewingRecipeBuilder.brewingRecipe(TBAItems.VINEGAR_BOTTLE.get(),
                                        24000, Items.GLASS_BOTTLE, 4)
                                .addIngredient(APPLE_CIDER.get())
                                .addIngredient(APPLE_CIDER.get())
                                .addIngredient(APPLE_CIDER.get())
                                .addIngredient(APPLE_CIDER.get())
                                .build(consumer, new ResourceLocation("drinkbeer",
                                        TBAItems.VINEGAR_BOTTLE.get() + "_from_apple_cider"))
                );
    }

    private void patchouliBooksRecipes(Consumer<FinishedRecipe> consumer) {
        PatchouliShapelessBookRecipeBuilder
                .writeRecipe("turtleblockacademy:kitchen_textbook", 1)
                .addIngredient(Items.BOOK)
                .addIngredient(Items.EGG)
                .finish(consumer, new ResourceLocation(MODID, "kitchen_textbook"));
        PatchouliShapelessBookRecipeBuilder
                .writeRecipe("turtleblockacademy:brewingguide", 1)
                .addIngredient(Items.BOOK)
                .addIngredient(Items.GLASS_BOTTLE)
                .finish(consumer, new ResourceLocation(MODID, "brewingguide"));
    }

    private void kettleRecipes(Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersrespite"))
                .addCondition(modLoaded("delightful"))
                .addRecipe(KettleRecipeBuilder.kettleRecipe(GREEN_TEA.get(),
                                1, 2400, true, 0.35F, Items.GLASS_BOTTLE)
                        .group("green_tea")
                        .addIngredient(DelightfulItems.MATCHA.get())
                        .addIngredient(DelightfulItems.MATCHA.get())
                        .unlockedBy("has_matcha",
                                has(DelightfulItems.MATCHA.get()))
                        ::build)
                .build(consumer, new ResourceLocation("farmersrespite", "brewing/" +
                        GREEN_TEA.get() + "_from_" + DelightfulItems.MATCHA.get()));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersrespite"))
                .addCondition(modLoaded("delightful"))
                .addRecipe(KettleRecipeBuilder.kettleRecipe(GREEN_TEA.get(),
                                1, 2400, true, 0.35F, Items.GLASS_BOTTLE)
                        .group("green_tea")
                        .addIngredient(GREEN_TEA_LEAF.get())
                        .addIngredient(GREEN_TEA_LEAF.get())
                        .unlockedBy("has_green_tea_leaf",
                                has(GREEN_TEA_LEAF.get()))
                        ::build)
                .build(consumer, new ResourceLocation("farmersrespite", "brewing/" +
                        GREEN_TEA.get() + "_from_" + GREEN_TEA_LEAF.get()));
    }

    private void minecraftRecipes(Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TBAItems.CLOVES.get()),
                        TBAItems.DRIED_CLOVES.get(), 0.15F, 200)
                .unlockedBy("has_cloves", has(TBAItems.CLOVES.get()))
                .save(consumer, new ResourceLocation(MODID,
                        TBAItems.DRIED_CLOVES.get() + "_from_smelting"));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(TBAItems.CLOVES.get()),
                        TBAItems.DRIED_CLOVES.get(), 0.15F, 200)
                .unlockedBy("has_cloves", has(TBAItems.CLOVES.get()))
                .save(consumer, new ResourceLocation(MODID,
                        TBAItems.DRIED_CLOVES.get() + "_from_campfire"));
        ShapelessRecipeBuilder.shapeless(TBAItems.CLOVE_SEEDS.get(), 1)
                .requires(TBAItems.CLOVES.get())
                .unlockedBy("has_cloves", has(TBAItems.CLOVES.get()))
                .save(consumer, new ResourceLocation(MODID,
                        TBAItems.CLOVE_SEEDS.get().asItem().toString()));
        ShapelessRecipeBuilder.shapeless(TBAItems.GROUND_CLOVES.get(), 1)
                .requires(TBAItems.DRIED_CLOVES.get())
                .unlockedBy("has_dried_cloves", has(TBAItems.DRIED_CLOVES.get()))
                .save(consumer, new ResourceLocation(MODID,
                        TBAItems.GROUND_CLOVES.get().asItem().toString()));
        ShapelessRecipeBuilder.shapeless(Items.SUGAR, 1)
                .requires(Items.BEETROOT)
                .requires(Items.BEETROOT)
                .unlockedBy("has_beetroot", has(Items.BEETROOT))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.SUGAR + "_from_beetroot"));
        ShapelessRecipeBuilder.shapeless(Items.LIME_DYE, 2)
                .requires(Items.YELLOW_DYE)
                .requires(Items.GREEN_DYE)
                .unlockedBy("has_dye", has(Tags.Items.DYES))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.LIME_DYE + "_from_mixed_dye"));
        ShapelessRecipeBuilder.shapeless(Items.CYAN_DYE, 2)
                .requires(Items.BLUE_DYE)
                .requires(Items.GREEN_DYE)
                .unlockedBy("has_dye", has(Tags.Items.DYES))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.CYAN_DYE + "_from_mixed_dye"));
        ShapelessRecipeBuilder.shapeless(Items.GREEN_DYE, 2)
                .requires(Items.BLUE_DYE)
                .requires(Items.YELLOW_DYE)
                .unlockedBy("has_dye", has(Tags.Items.DYES))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.GREEN_DYE + "_from_mixed_dye"));
        ShapelessRecipeBuilder.shapeless(Items.PURPLE_DYE, 2)
                .requires(Items.BLUE_DYE)
                .requires(Items.RED_DYE)
                .unlockedBy("has_dye", has(Tags.Items.DYES))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.PURPLE_DYE + "_from_mixed_dye"));
        ShapelessRecipeBuilder.shapeless(Items.BROWN_DYE, 2)
                .requires(Items.BLUE_DYE)
                .requires(Items.ORANGE_DYE)
                .unlockedBy("has_dye", has(Tags.Items.DYES))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.BROWN_DYE + "_from_mixed_dye_1"));
        ShapelessRecipeBuilder.shapeless(Items.BROWN_DYE, 2)
                .requires(Items.RED_DYE)
                .requires(Items.GREEN_DYE)
                .unlockedBy("has_dye", has(Tags.Items.DYES))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.BROWN_DYE + "_from_mixed_dye_2"));
        ShapelessRecipeBuilder.shapeless(Items.BROWN_DYE, 2)
                .requires(Items.PURPLE_DYE)
                .requires(Items.YELLOW_DYE)
                .unlockedBy("has_dye", has(Tags.Items.DYES))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.BROWN_DYE + "_from_mixed_dye_3"));
        ShapelessRecipeBuilder.shapeless(Items.BROWN_DYE, 3)
                .requires(Items.RED_DYE)
                .requires(Items.BLUE_DYE)
                .requires(Items.YELLOW_DYE)
                .unlockedBy("has_dye", has(Tags.Items.DYES))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.BROWN_DYE + "_from_mixed_dye_4"));
        ShapelessRecipeBuilder.shapeless(Items.BROWN_DYE, 3)
                .requires(Items.ORANGE_DYE)
                .requires(Items.GREEN_DYE)
                .requires(Items.PURPLE_DYE)
                .unlockedBy("has_dye", has(Tags.Items.DYES))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.BROWN_DYE + "_from_mixed_dye_5"));
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
                .define('S', TBATags.Items.STRING)
                .define('I', TBATags.Items.IRON_NUGGET)
                .define('L', Tags.Items.LEATHER)
                .pattern("LLL")
                .pattern("S S")
                .pattern("I I")
                .unlockedBy("has_iron_nugget", has(TBATags.Items.IRON_NUGGET))
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
                .define('S', TBATags.Items.STRING)
                .define('I', TBATags.Items.IRON_INGOT)
                .define('P', Items.PAPER)
                .pattern("S  ")
                .pattern(" I ")
                .pattern("  P")
                .unlockedBy("has_iron_ingot", has(TBATags.Items.IRON_INGOT))
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
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(TBATags.Items.SAND),
                        Items.GLASS, 0.1F, 100)
                .unlockedBy("has_any_sand", has(TBATags.Items.SAND))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.GLASS + "_from_blasting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(TBATags.Items.GLASS),
                        Items.GLASS_BOTTLE, 0.1F, 100)
                .unlockedBy("has_any_glass", has(TBATags.Items.GLASS))
                .save(consumer, new ResourceLocation("minecraft",
                        Items.GLASS_BOTTLE + "_from_blasting"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TBATags.Items.GLASS),
                        Items.GLASS_BOTTLE, 0.1F, 200)
                .unlockedBy("has_any_glass", has(TBATags.Items.GLASS))
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
                .unlockedBy("has_carpet", has(TBATags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.WHITE_WOOL, Items.WHITE_CARPET)));
        ShapedRecipeBuilder.shaped(Items.LIGHT_GRAY_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.LIGHT_GRAY_CARPET)
                .unlockedBy("has_carpet", has(TBATags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.LIGHT_GRAY_WOOL, Items.LIGHT_GRAY_CARPET)));
        ShapedRecipeBuilder.shaped(Items.GRAY_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.GRAY_CARPET)
                .unlockedBy("has_carpet", has(TBATags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.GRAY_WOOL, Items.GRAY_CARPET)));
        ShapedRecipeBuilder.shaped(Items.BLACK_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.BLACK_CARPET)
                .unlockedBy("has_carpet", has(TBATags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.BLACK_WOOL, Items.BLACK_CARPET)));
        ShapedRecipeBuilder.shaped(Items.BROWN_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.BROWN_CARPET)
                .unlockedBy("has_carpet", has(TBATags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.BROWN_WOOL, Items.BROWN_CARPET)));
        ShapedRecipeBuilder.shaped(Items.RED_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.RED_CARPET)
                .unlockedBy("has_carpet", has(TBATags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.RED_WOOL, Items.RED_CARPET)));
        ShapedRecipeBuilder.shaped(Items.ORANGE_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.ORANGE_CARPET)
                .unlockedBy("has_carpet", has(TBATags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.ORANGE_WOOL, Items.ORANGE_CARPET)));
        ShapedRecipeBuilder.shaped(Items.YELLOW_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.YELLOW_CARPET)
                .unlockedBy("has_carpet", has(TBATags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.YELLOW_WOOL, Items.YELLOW_CARPET)));
        ShapedRecipeBuilder.shaped(Items.LIME_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.LIME_CARPET)
                .unlockedBy("has_carpet", has(TBATags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.LIME_WOOL, Items.LIME_CARPET)));
        ShapedRecipeBuilder.shaped(Items.GREEN_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.GREEN_CARPET)
                .unlockedBy("has_carpet", has(TBATags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.GREEN_WOOL, Items.GREEN_CARPET)));
        ShapedRecipeBuilder.shaped(Items.LIGHT_BLUE_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.LIGHT_BLUE_CARPET)
                .unlockedBy("has_carpet", has(TBATags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.LIGHT_BLUE_WOOL, Items.LIGHT_BLUE_CARPET)));
        ShapedRecipeBuilder.shaped(Items.CYAN_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.CYAN_CARPET)
                .unlockedBy("has_carpet", has(TBATags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.CYAN_WOOL, Items.CYAN_CARPET)));
        ShapedRecipeBuilder.shaped(Items.BLUE_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.BLUE_CARPET)
                .unlockedBy("has_carpet", has(TBATags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.BLUE_WOOL, Items.BLUE_CARPET)));
        ShapedRecipeBuilder.shaped(Items.PURPLE_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.PURPLE_CARPET)
                .unlockedBy("has_carpet", has(TBATags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.PURPLE_WOOL, Items.PURPLE_CARPET)));
        ShapedRecipeBuilder.shaped(Items.PINK_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.PINK_CARPET)
                .unlockedBy("has_carpet", has(TBATags.Items.CARPETS))
                .save(consumer, new ResourceLocation("minecraft",
                        getConversionRecipeName(Items.PINK_WOOL, Items.PINK_CARPET)));
        ShapedRecipeBuilder.shaped(Items.MAGENTA_WOOL, 2)
                .pattern("XXX")
                .define('X', Items.MAGENTA_CARPET)
                .unlockedBy("has_carpet", has(TBATags.Items.CARPETS))
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
                        .requires(TBATags.Items.WEBBING)
                        .unlockedBy("has_webbing", has(TBATags.Items.WEBBING))
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
                        .define('I', TBATags.Items.IRON_INGOT)
                        .define('B', Blocks.BRICKS)
                        .define('C', Blocks.CAULDRON)
                        .unlockedBy("has_cauldron", has(Blocks.CAULDRON))
                        ::save)
                .build(consumer, new ResourceLocation("decoration_delight",
                        DecorationDelightModBlocks.SINK.get().asItem() + "_alt"));
    }

    private void dimdungeonsRecipes(Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("dimdungeons"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(ITEM_HOMEWARD_PEARL.get())
                        .requires(ITEM_PORTAL_KEY.get())
                        .requires(Items.ENDER_PEARL)
                        .requires(Items.EXPERIENCE_BOTTLE)
                        .unlockedBy("has_portal_key", has(ITEM_PORTAL_KEY.get()))
                        ::save)
                .build(consumer, new ResourceLocation("dimdungeons",
                        ITEM_HOMEWARD_PEARL.get().asItem().toString()));
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
                        .define('I', TBATags.Items.IRON_INGOT)
                        .define('R', Items.REDSTONE)
                        .define('G', TBATags.Items.GOLD_NUGGET)
                        .unlockedBy("has_gold_nugget", has(TBATags.Items.GOLD_NUGGET))
                        ::save)
                .build(consumer, new ResourceLocation("fastfooddelight",
                        FFItems.CHECKOUT_MACHINE.get().toString()));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("fastfooddelight"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(FFItems.CHICKEN_CHEESE_SANDWICH.get())
                        .requires(TBATags.Items.BREAD)
                        .requires(TBATags.Items.COOKED_CHICKEN)
                        .requires(TBATags.Items.GREENS)
                        .requires(TBATags.Items.VEGETABLES)
                        .requires(TBATags.Items.CHEESE_SLICES)
                        .unlockedBy("has_cooked_chicken", has(TBATags.Items.COOKED_CHICKEN))
                        ::save)
                .build(consumer, new ResourceLocation("fastfooddelight",
                        FFItems.CHICKEN_CHEESE_SANDWICH.get() + "_alt"));
    }

    private void farmersdelightRecipes(Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(ShapedRecipeBuilder.shaped(ModBlocks.COOKING_POT.get())
                        .pattern("BSB")
                        .pattern("#C#")
                        .pattern("###")
                        .define('B', TBATags.Items.BRICK)
                        .define('S', Tags.Items.LEATHER)
                        .define('#', TBATags.Items.COPPER_INGOT)
                        .define('C', TBATags.Items.WATER_BUCKETS)
                        .unlockedBy("has_copper_ingot",
                                has(TBATags.Items.COPPER_INGOT))
                        ::save)
                .build(consumer, new ResourceLocation("farmersdelight",
                        ModBlocks.COOKING_POT.get().asItem() + "_alt"));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(ModBlocks.SHEPHERDS_PIE_BLOCK.get())
                        .requires(Items.BAKED_POTATO)
                        .requires(Items.BAKED_POTATO)
                        .requires(TBATags.Items.MILK)
                        .requires(TBATags.Items.COOKED_MUTTON)
                        .requires(TBATags.Items.COOKED_MUTTON)
                        .requires(TBATags.Items.COOKED_MUTTON)
                        .requires(TBATags.Items.ONION_INGREDIENTS)
                        .requires(TBATags.Items.ONION_INGREDIENTS)
                        .requires(Items.BOWL)
                        .unlockedBy("has_cooked_mutton",
                                has(TBATags.Items.COOKED_MUTTON))
                        ::save)
                .build(consumer, new ResourceLocation("farmersdelight",
                        ModBlocks.SHEPHERDS_PIE_BLOCK.get().asItem() + "_alt"));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(ModBlocks.ROAST_CHICKEN_BLOCK.get())
                        .requires(TBATags.Items.EGGS)
                        .requires(TBATags.Items.BREAD)
                        .requires(TBATags.Items.VEGETABLES)
                        .requires(TBATags.Items.VEGETABLES)
                        .requires(TBATags.Items.VEGETABLES)
                        .requires(TBATags.Items.VEGETABLES)
                        .requires(TBATags.Items.VEGETABLES)
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
                        .requires(TBATags.Items.STRAW_FIBERS)
                        .requires(TBATags.Items.STRAW_FIBERS)
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
                        .requires(TBATags.Items.BERRIES)
                        .requires(TBATags.Items.BERRIES)
                        .requires(TBATags.Items.BERRIES)
                        .requires(TBATags.Items.BERRIES)
                        .requires(TBATags.Items.GLAZES)
                        .requires(vectorwing.farmersdelight.common.registry.ModItems.SMOKED_HAM.get())
                        .requires(TBATags.Items.COOKED_RICE)
                        .requires(TBATags.Items.COOKED_RICE)
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
                .addCondition(modLoaded("miners_delight"))
                .addRecipe(ShapedRecipeBuilder.shaped(FRItems.KETTLE.get())
                        .pattern("SLS")
                        .pattern("#C#")
                        .pattern("###")
                        .define('S', TBATags.Items.STICKS)
                        .define('L', Tags.Items.LEATHER)
                        .define('#', TBATags.Items.COPPER_INGOT)
                        .define('C', TBATags.Items.WATER_BUCKETS)
                        .unlockedBy("has_copper_ingot",
                                has(TBATags.Items.COPPER_INGOT))
                        ::save)
                .build(consumer, new ResourceLocation("farmersrespite",
                        FRItems.KETTLE.get().asItem() + "_alt"));
    }

    private void festive_delightRecipes(Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("festive_delight"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(FestiveDelightModItems.FESTIVE_CHICKEN_BLOCK.get())
                        .requires(TBATags.Items.BERRIES)
                        .requires(TBATags.Items.BERRIES)
                        .requires(TBATags.Items.BERRIES)
                        .requires(TBATags.Items.BERRIES)
                        .requires(TBATags.Items.GLAZES)
                        .requires(TBATags.Items.COOKED_CHICKEN)
                        .requires(TBATags.Items.COOKED_RICE)
                        .requires(TBATags.Items.COOKED_RICE)
                        .requires(Items.BOWL)
                        .unlockedBy("has_cooked_chicken",
                                has(TBATags.Items.COOKED_CHICKEN))
                        ::save)
                .build(consumer, new ResourceLocation("festive_delight",
                        FestiveDelightModItems.FESTIVE_CHICKEN_BLOCK.get() + "_alt"));
    }

    private void supplementariesRecipes(Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("supplementaries"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(ModRegistry.SOAP.get(), 6)
                        .requires(Items.WATER_BUCKET)
                        .requires(TBATags.Items.ASH)
                        .requires(TBATags.Items.ASH)
                        .requires(TBATags.Items.ASH)
                        .requires(TBATags.Items.ASH)
                        .requires(TBATags.Items.FATS)
                        .unlockedBy("has_ash", has(TBATags.Items.ASH))
                        ::save)
                .build(consumer, new ResourceLocation("supplementaries", "items/soap_alt"));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("supplementaries"))
                .addRecipe(ShapedRecipeBuilder.shaped(ModRegistry.QUIVER_ITEM.get(), 1)
                        .pattern(" SL")
                        .pattern("SL ")
                        .pattern("L  ")
                        .define('S', TBATags.Items.STRING)
                        .define('L', Items.LEATHER)
                        .unlockedBy("has_leather", has(Items.LEATHER))
                        ::save)
                .build(consumer, new ResourceLocation("supplementaries", "items/" + ModRegistry.QUIVER_ITEM.get()));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("supplementaries"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.LAPIS_LAZULI, 4)
                        .requires(TBATags.Items.LAPIS_BRICKS)
                        .unlockedBy("has_lapis_bricks",
                                has(TBATags.Items.LAPIS_BRICKS))
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
                        .define('L', TBATags.Items.LANTERNS)
                        .define('F', Tags.Items.FENCES)
                        .define('W', TBATags.Items.WALLS)
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
                        .define('W', TBATags.Items.WALLS)
                        .unlockedBy("has_soul_lantern", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SOUL_LANTERN))
                        ::save)
                .build(consumer, new ResourceLocation("mcwlights", "soul_classic_street_lamp_alt"));
        ConditionalRecipe.builder()
                .addCondition(modLoaded("mcwlights"))
                .addRecipe(ShapedRecipeBuilder.shaped(BlockInit.DOUBLE_STREET_LAMP.get(), 3)
                        .pattern("L L")
                        .pattern(" F ")
                        .pattern(" W ")
                        .define('L', TBATags.Items.LANTERNS)
                        .define('F', Tags.Items.FENCES)
                        .define('W', TBATags.Items.WALLS)
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
                        .define('W', TBATags.Items.WALLS)
                        .unlockedBy("can_craft_soul_classic_street_lamp", RecipeUnlockedTrigger
                                .unlocked(Objects.requireNonNull(ResourceLocation.tryParse("mcwlights/recipes/soul_classic_street_lamp_alt"))))
                        ::save)
                .build(consumer, new ResourceLocation("mcwlights", "soul_double_street_lamp_alt"));
    }

    private void cookingPotRecipes(Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(TBAItems.BEET_RISOTTO.get(),
                                        1, 200, 1.0F, Items.BOWL)
                                .addIngredient(COOKED_RICE.get())
                                .addIngredient(Items.BEETROOT_SOUP)
                                .addIngredient(BONE_BROTH.get())
                                .addIngredient(TBATags.Items.ONION_INGREDIENTS)
                                .addIngredient(TBAItems.BEET_WINE.get())
                                .addIngredient(TBAItems.VINEGAR_BOTTLE.get())
                                .unlockedBy("has_beets",
                                        has(Items.BEETROOT))
                                .build(consumer, new ResourceLocation("farmersdelight",
                                        "cooking/" + TBAItems.BEET_RISOTTO.get()))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(TBAItems.BEET_SALAD.get(),
                                        1, 200, 1.0F, Items.BOWL)
                                .addIngredient(Items.BEETROOT)
                                .addIngredient(Items.BEETROOT)
                                .addIngredient(Items.BEETROOT)
                                .addIngredient(TBATags.Items.ONION_INGREDIENTS)
                                .addIngredient(TBATags.Items.SUGAR)
                                .addIngredient(TBAItems.VINEGAR_BOTTLE.get())
                                .unlockedBy("has_beets",
                                        has(Items.BEETROOT))
                                .build(consumer, new ResourceLocation("farmersdelight",
                                        "cooking/" + TBAItems.BEET_SALAD.get()))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addCondition(modLoaded("farmersrespite"))
                .addCondition(modLoaded("delightful"))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(GREEN_TEA.get(),
                                        1, 200, 1.0F)
                                .addIngredient(MATCHA.get())
                                .addIngredient(MATCHA.get())
                                .unlockedBy("has_matcha",
                                        has(MATCHA.get()))
                                .build(consumer, new ResourceLocation("farmersdelight",
                                        "cooking/" + GREEN_TEA.get() + "_from_matcha"))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addCondition(modLoaded("farmersrespite"))
                .addCondition(modLoaded("delightful"))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(GREEN_TEA.get(),
                                        1, 200, 1.0F)
                                .addIngredient(GREEN_TEA_LEAF.get())
                                .addIngredient(GREEN_TEA_LEAF.get())
                                .unlockedBy("has_green_tea_leaf",
                                        has(GREEN_TEA_LEAF.get()))
                                .build(consumer, new ResourceLocation("farmersdelight",
                                        "cooking/" + GREEN_TEA.get()))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(FISH_STEW.get(),
                                        1, 200, 1.0F)
                                .addIngredient(TBATags.Items.RAW_FISHES)
                                .addIngredient(TOMATO_SAUCE.get())
                                .addIngredient(TBATags.Items.ONION_INGREDIENTS)
                                .unlockedBy("has_raw_fish",
                                        has(TBATags.Items.RAW_FISHES))
                                .build(consumer, new ResourceLocation("farmersdelight",
                                        "cooking/" + FISH_STEW.get() + "_from_tagged_ingredients"))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(DUMPLINGS.get(),
                                        2, 200, 1.0F)
                                .addIngredient(ForgeTags.DOUGH)
                                .addIngredient(TBATags.Items.CABBAGE_INGREDIENTS)
                                .addIngredient(TBATags.Items.ONION_INGREDIENTS)
                                .addIngredient(Ingredient.fromValues(
                                        Stream.of(new Ingredient.TagValue(TBATags.Items.RAW_MEATS),
                                                new Ingredient.TagValue(TBATags.Items.SHROOMS))))
                                .unlockedBy("has_dough", has(ForgeTags.DOUGH))
                                .build(consumer, new ResourceLocation("farmersdelight",
                                        "cooking/" + DUMPLINGS.get() + "_from_tagged_ingredients"))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(FRIED_RICE.get(),
                                        2, 200, 1.0F, Items.BOWL)
                                .addIngredient(TBATags.Items.RICE)
                                .addIngredient(TBATags.Items.EGGS)
                                .addIngredient(TBATags.Items.VEGETABLES)
                                .addIngredient(TBATags.Items.VEGETABLES)
                                .unlockedBy("has_rice", has(TBATags.Items.RICE))
                                .build(consumer, new ResourceLocation("farmersdelight",
                                        "cooking/" + FRIED_RICE.get() + "_from_tagged_ingredients"))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(NOODLE_SOUP.get(),
                                        1, 200, 1.0F)
                                .addIngredient(ForgeTags.PASTA)
                                .addIngredient(ForgeTags.COOKED_EGGS)
                                .addIngredient(Items.DRIED_KELP)
                                .addIngredient(TBATags.Items.RAW_MEATS)
                                .unlockedBy("has_pasta", has(ForgeTags.PASTA))
                                .build(consumer, new ResourceLocation("farmersdelight",
                                        "cooking/" + NOODLE_SOUP.get() + "_from_tagged_ingredients"))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(VEGETABLE_NOODLES.get(),
                                        1, 200, 1.0F)
                                .addIngredient(TBATags.Items.CARROT_INGREDIENTS)
                                .addIngredient(TBATags.Items.SHROOMS)
                                .addIngredient(ForgeTags.PASTA)
                                .addIngredient(TBATags.Items.SALAD_INGREDIENTS)
                                .addIngredient(TBATags.Items.VEGETABLES)
                                .unlockedBy("has_pasta", has(ForgeTags.PASTA))
                                .build(consumer, new ResourceLocation("farmersdelight",
                                        "cooking/" + VEGETABLE_NOODLES.get() + "_from_tagged_ingredients"))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(VEGETABLE_SOUP.get(),
                                        1, 200, 1.0F)
                                .addIngredient(TBATags.Items.CARROT_INGREDIENTS)
                                .addIngredient(TBATags.Items.STARCH_INGREDIENTS)
                                .addIngredient(TBATags.Items.SALAD_INGREDIENTS)
                                .addIngredient(TBATags.Items.VEGETABLES)
                                .unlockedBy("has_pasta", has(ForgeTags.PASTA))
                                .build(consumer, new ResourceLocation("farmersdelight",
                                        "cooking/" + VEGETABLE_SOUP.get() + "_from_tagged_ingredients"))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(MUSHROOM_STEW,
                                        1, 200, 1.0F)
                                .addIngredient(TBATags.Items.SHROOMS)
                                .addIngredient(TBATags.Items.SHROOMS)
                                .unlockedBy("has_shrooms", has(TBATags.Items.SHROOMS))
                                .build(consumer, new ResourceLocation("farmersdelight",
                                        "cooking/" + MUSHROOM_STEW + "_from_tagged_ingredients"))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(MUSHROOM_RICE.get(),
                                        1, 200, 1.0F)
                                .addIngredient(TBATags.Items.SHROOMS)
                                .addIngredient(TBATags.Items.SHROOMS)
                                .addIngredient(TBATags.Items.RICE)
                                .addIngredient(TBATags.Items.VEGETABLES)
                                .unlockedBy("has_shrooms", has(TBATags.Items.SHROOMS))
                                .build(consumer, new ResourceLocation("farmersdelight",
                                        "cooking/" + MUSHROOM_RICE.get() + "_from_tagged_ingredients"))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(STUFFED_PUMPKIN_BLOCK.get(),
                                        1, 400, 2.0F, Items.PUMPKIN)
                                .addIngredient(TBATags.Items.STARCH_INGREDIENTS)
                                .addIngredient(TBATags.Items.ONION_INGREDIENTS)
                                .addIngredient(TBATags.Items.SHROOMS)
                                .addIngredient(TBATags.Items.STARCH_INGREDIENTS)
                                .addIngredient(TBATags.Items.BERRIES)
                                .addIngredient(TBATags.Items.VEGETABLES)
                                .unlockedByItems("has_pumpkin", Blocks.PUMPKIN)
                                .build(consumer, new ResourceLocation("farmersdelight",
                                        "cooking/" + STUFFED_PUMPKIN_BLOCK.get() + "_from_tagged_ingredients"))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addCondition(modLoaded("delightful"))
                .addCondition(this.itemExists(DelightfulItems.ROCK_CANDY.getId().getNamespace(), DelightfulItems.ROCK_CANDY.getId().getPath()))
                .addCondition(this.not(this.tagEmpty(TBATags.Items.GEM_SHARDS)))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(DelightfulItems.ROCK_CANDY.get(), 1, 200, 0.35F, Items.STICK)
                                .addIngredient(Ingredient.of(TBATags.Items.GEM_SHARDS), 2)
                                .addIngredient(TBATags.Items.SUGAR)
                                .unlockedBy("has_gem_shards", has(TBATags.Items.GEM_SHARDS))
                                .build(consumer, new ResourceLocation("delightful", "cooking/rock_candy_alt_1"))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addCondition(modLoaded("delightful"))
                .addCondition(modLoaded("aether"))
                .addCondition(this.itemExists(DelightfulItems.ROCK_CANDY.getId().getNamespace(), DelightfulItems.ROCK_CANDY.getId().getPath()))
                .addCondition(this.not(this.tagEmpty(TBATags.Items.GEM_SHARDS)))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(DelightfulItems.ROCK_CANDY.get(), 1, 200, 0.35F, AetherItems.SKYROOT_STICK.get())
                                .addIngredient(Ingredient.of(TBATags.Items.GEM_SHARDS), 2)
                                .addIngredient(TBATags.Items.SUGAR)
                                .unlockedBy("has_gem_shards", has(TBATags.Items.GEM_SHARDS))
                                .build(consumer, new ResourceLocation("delightful", "cooking/rock_candy_alt_2"))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(CHICKEN_SOUP.get(), 1, 200, 1.0F)
                                .addIngredient(Ingredient.of(TBATags.Items.RAW_CHICKEN))
                                .addIngredient(Ingredient.of(TBATags.Items.CARROT_INGREDIENTS))
                                .addIngredient(Ingredient.of(TBATags.Items.VEGETABLES))
                                .addIngredient(Ingredient.of(TBATags.Items.SALAD_INGREDIENTS))
                                .unlockedBy("has_chicken", has(TBATags.Items.RAW_CHICKEN))
                                .build(consumer, new ResourceLocation("farmersdelight", "cooking/" + CHICKEN_SOUP.get() + "_from_tagged_ingredients"))
                );
    }

    private void schoolSupplyRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(TBABlocks.FERMENTING_POT_BLOCK.get(), 1)
                .pattern("# #")
                .pattern("SSS")
                .define('#', Items.BRICK)
                .define('S', Items.STONE)
                .unlockedBy("has_brick", has(Items.BRICK))
                .save(consumer, new ResourceLocation(MODID,
                        TBABlocks.FERMENTING_POT_BLOCK.get().asItem().toString()));

        ShapedRecipeBuilder.shaped(TBAItems.STUDENT_CARD.get(), 1)
                .pattern("###")
                .pattern("#T#")
                .pattern("###")
                .define('#', Items.PAPER)
                .define('T', Items.NAME_TAG)
                .unlockedBy("has_name_tag", has(Items.NAME_TAG))
                .save(consumer, new ResourceLocation(MODID,
                        TBAItems.STUDENT_CARD.get().toString()));

        plateRecipe(consumer, TBABlocks.PLATE_WHITE.get().asItem().getDefaultInstance(),
                Items.WHITE_GLAZED_TERRACOTTA);
        plateRecipe(consumer, TBABlocks.PLATE_ORANGE.get().asItem().getDefaultInstance(),
                Items.ORANGE_GLAZED_TERRACOTTA);
        plateRecipe(consumer, TBABlocks.PLATE_MAGENTA.get().asItem().getDefaultInstance(),
                Items.MAGENTA_GLAZED_TERRACOTTA);
        plateRecipe(consumer, TBABlocks.PLATE_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                Items.LIGHT_BLUE_GLAZED_TERRACOTTA);
        plateRecipe(consumer, TBABlocks.PLATE_YELLOW.get().asItem().getDefaultInstance(),
                Items.YELLOW_GLAZED_TERRACOTTA);
        plateRecipe(consumer, TBABlocks.PLATE_LIME.get().asItem().getDefaultInstance(),
                Items.LIME_GLAZED_TERRACOTTA);
        plateRecipe(consumer, TBABlocks.PLATE_PINK.get().asItem().getDefaultInstance(),
                Items.PINK_GLAZED_TERRACOTTA);
        plateRecipe(consumer, TBABlocks.PLATE_GRAY.get().asItem().getDefaultInstance(),
                Items.GRAY_GLAZED_TERRACOTTA);
        plateRecipe(consumer, TBABlocks.PLATE_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                Items.LIGHT_GRAY_GLAZED_TERRACOTTA);
        plateRecipe(consumer, TBABlocks.PLATE_CYAN.get().asItem().getDefaultInstance(),
                Items.CYAN_GLAZED_TERRACOTTA);
        plateRecipe(consumer, TBABlocks.PLATE_PURPLE.get().asItem().getDefaultInstance(),
                Items.PURPLE_GLAZED_TERRACOTTA);
        plateRecipe(consumer, TBABlocks.PLATE_BLUE.get().asItem().getDefaultInstance(),
                Items.BLUE_GLAZED_TERRACOTTA);
        plateRecipe(consumer, TBABlocks.PLATE_BROWN.get().asItem().getDefaultInstance(),
                Items.BROWN_GLAZED_TERRACOTTA);
        plateRecipe(consumer, TBABlocks.PLATE_GREEN.get().asItem().getDefaultInstance(),
                Items.GREEN_GLAZED_TERRACOTTA);
        plateRecipe(consumer, TBABlocks.PLATE_RED.get().asItem().getDefaultInstance(),
                Items.RED_GLAZED_TERRACOTTA);
        plateRecipe(consumer, TBABlocks.PLATE_BLACK.get().asItem().getDefaultInstance(),
                Items.BLACK_GLAZED_TERRACOTTA);

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_ACACIA.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_SLAB);
        benchRecipe(consumer, TBABlocks.PARK_BENCH_ACACIA.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.ACACIA_SLAB);
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_ACACIA.get().asItem().getDefaultInstance(),
                Items.ACACIA_PLANKS, Items.ACACIA_SLAB);
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_ACACIA.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.ACACIA_PLANKS);
        lockerRecipe(consumer, TBABlocks.LOCKER_ACACIA.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.ACACIA_SLAB);
        tableRecipe(consumer, TBABlocks.TABLE_ACACIA.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_SLAB);
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_ACACIA.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_SLAB);

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_BIRCH.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_SLAB);
        benchRecipe(consumer, TBABlocks.PARK_BENCH_BIRCH.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.BIRCH_SLAB);
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_BIRCH.get().asItem().getDefaultInstance(),
                Items.BIRCH_PLANKS, Items.BIRCH_SLAB);
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_BIRCH.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.BIRCH_PLANKS);
        lockerRecipe(consumer, TBABlocks.LOCKER_BIRCH.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.BIRCH_SLAB);
        tableRecipe(consumer, TBABlocks.TABLE_BIRCH.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_SLAB);
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_BIRCH.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_SLAB);

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_DARK_OAK.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_SLAB);
        benchRecipe(consumer, TBABlocks.PARK_BENCH_DARK_OAK.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.DARK_OAK_SLAB);
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_DARK_OAK.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_PLANKS, Items.DARK_OAK_SLAB);
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_DARK_OAK.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.DARK_OAK_PLANKS);
        lockerRecipe(consumer, TBABlocks.LOCKER_DARK_OAK.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.DARK_OAK_SLAB);
        tableRecipe(consumer, TBABlocks.TABLE_DARK_OAK.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_SLAB);
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_DARK_OAK.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_SLAB);

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_JUNGLE.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_SLAB);
        benchRecipe(consumer, TBABlocks.PARK_BENCH_JUNGLE.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.JUNGLE_SLAB);
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_JUNGLE.get().asItem().getDefaultInstance(),
                Items.JUNGLE_PLANKS, Items.JUNGLE_SLAB);
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_JUNGLE.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.JUNGLE_PLANKS);
        lockerRecipe(consumer, TBABlocks.LOCKER_JUNGLE.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.JUNGLE_SLAB);
        tableRecipe(consumer, TBABlocks.TABLE_JUNGLE.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_SLAB);
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_JUNGLE.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_SLAB);

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_MANGROVE.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_SLAB);
        benchRecipe(consumer, TBABlocks.PARK_BENCH_MANGROVE.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.MANGROVE_SLAB);
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_MANGROVE.get().asItem().getDefaultInstance(),
                Items.MANGROVE_PLANKS, Items.MANGROVE_SLAB);
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_MANGROVE.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.MANGROVE_PLANKS);
        lockerRecipe(consumer, TBABlocks.LOCKER_MANGROVE.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.MANGROVE_SLAB);
        tableRecipe(consumer, TBABlocks.TABLE_MANGROVE.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_SLAB);
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_MANGROVE.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_SLAB);

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_OAK.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.STRIPPED_OAK_LOG, Items.OAK_SLAB);
        benchRecipe(consumer, TBABlocks.PARK_BENCH_OAK.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.OAK_SLAB);
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_OAK.get().asItem().getDefaultInstance(),
                Items.OAK_PLANKS, Items.OAK_SLAB);
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_OAK.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.OAK_PLANKS);
        lockerRecipe(consumer, TBABlocks.LOCKER_OAK.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.OAK_SLAB);
        tableRecipe(consumer, TBABlocks.TABLE_OAK.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.STRIPPED_OAK_LOG, Items.OAK_SLAB);
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_OAK.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.STRIPPED_OAK_LOG, Items.OAK_SLAB);

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_SPRUCE.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_SLAB);
        benchRecipe(consumer, TBABlocks.PARK_BENCH_SPRUCE.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.SPRUCE_SLAB);
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_SPRUCE.get().asItem().getDefaultInstance(),
                Items.SPRUCE_PLANKS, Items.SPRUCE_SLAB);
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_SPRUCE.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.SPRUCE_PLANKS);
        lockerRecipe(consumer, TBABlocks.LOCKER_SPRUCE.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.SPRUCE_SLAB);
        tableRecipe(consumer, TBABlocks.TABLE_SPRUCE.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_SLAB);
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_SPRUCE.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_SLAB);

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_CRIMSON.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_SLAB);
        benchRecipe(consumer, TBABlocks.PARK_BENCH_CRIMSON.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.CRIMSON_SLAB);
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_CRIMSON.get().asItem().getDefaultInstance(),
                Items.CRIMSON_PLANKS, Items.CRIMSON_SLAB);
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_CRIMSON.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.CRIMSON_PLANKS);
        lockerRecipe(consumer, TBABlocks.LOCKER_CRIMSON.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.CRIMSON_SLAB);
        tableRecipe(consumer, TBABlocks.TABLE_CRIMSON.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_SLAB);
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_CRIMSON.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_SLAB);

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_WARPED.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.STRIPPED_WARPED_STEM, Items.WARPED_SLAB);
        benchRecipe(consumer, TBABlocks.PARK_BENCH_WARPED.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.WARPED_SLAB);
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_WARPED.get().asItem().getDefaultInstance(),
                Items.WARPED_PLANKS, Items.WARPED_SLAB);
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_WARPED.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.WARPED_PLANKS);
        lockerRecipe(consumer, TBABlocks.LOCKER_WARPED.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.WARPED_SLAB);
        tableRecipe(consumer, TBABlocks.TABLE_WARPED.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.STRIPPED_WARPED_STEM, Items.WARPED_SLAB);
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_WARPED.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.STRIPPED_WARPED_STEM, Items.WARPED_SLAB);

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_FIR.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());
        benchRecipe(consumer, TBABlocks.PARK_BENCH_FIR.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_FIR.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_PLANKS.get(), BOPBlocks.FIR_SLAB.get());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_FIR.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.FIR_PLANKS.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_FIR.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());
        tableRecipe(consumer, TBABlocks.TABLE_FIR.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_FIR.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_REDWOOD.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());
        benchRecipe(consumer, TBABlocks.PARK_BENCH_REDWOOD.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_REDWOOD.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_PLANKS.get(), BOPBlocks.REDWOOD_SLAB.get());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_REDWOOD.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.REDWOOD_PLANKS.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_REDWOOD.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());
        tableRecipe(consumer, TBABlocks.TABLE_REDWOOD.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_REDWOOD.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_CHERRY.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());
        benchRecipe(consumer, TBABlocks.PARK_BENCH_CHERRY.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_CHERRY.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_PLANKS.get(), BOPBlocks.CHERRY_SLAB.get());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_CHERRY.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.CHERRY_PLANKS.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_CHERRY.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());
        tableRecipe(consumer, TBABlocks.TABLE_CHERRY.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_CHERRY.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_MAHOGANY.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());
        benchRecipe(consumer, TBABlocks.PARK_BENCH_MAHOGANY.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_MAHOGANY.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_PLANKS.get(), BOPBlocks.MAHOGANY_SLAB.get());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_MAHOGANY.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_PLANKS.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_MAHOGANY.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());
        tableRecipe(consumer, TBABlocks.TABLE_MAHOGANY.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_MAHOGANY.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_JACARANDA.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());
        benchRecipe(consumer, TBABlocks.PARK_BENCH_JACARANDA.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_JACARANDA.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_PLANKS.get(), BOPBlocks.JACARANDA_SLAB.get());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_JACARANDA.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.JACARANDA_PLANKS.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_JACARANDA.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());
        tableRecipe(consumer, TBABlocks.TABLE_JACARANDA.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_JACARANDA.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_PALM.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());
        benchRecipe(consumer, TBABlocks.PARK_BENCH_PALM.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_PALM.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_PLANKS.get(), BOPBlocks.PALM_SLAB.get());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_PALM.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.PALM_PLANKS.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_PALM.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());
        tableRecipe(consumer, TBABlocks.TABLE_PALM.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_PALM.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_WILLOW.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());
        benchRecipe(consumer, TBABlocks.PARK_BENCH_WILLOW.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_WILLOW.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_PLANKS.get(), BOPBlocks.WILLOW_SLAB.get());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_WILLOW.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.WILLOW_PLANKS.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_WILLOW.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());
        tableRecipe(consumer, TBABlocks.TABLE_WILLOW.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_WILLOW.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_DEAD.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());
        benchRecipe(consumer, TBABlocks.PARK_BENCH_DEAD.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_DEAD.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_PLANKS.get(), BOPBlocks.DEAD_SLAB.get());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_DEAD.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.DEAD_PLANKS.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_DEAD.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());
        tableRecipe(consumer, TBABlocks.TABLE_DEAD.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_DEAD.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_MAGIC.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());
        benchRecipe(consumer, TBABlocks.PARK_BENCH_MAGIC.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_MAGIC.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_PLANKS.get(), BOPBlocks.MAGIC_SLAB.get());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_MAGIC.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.MAGIC_PLANKS.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_MAGIC.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());
        tableRecipe(consumer, TBABlocks.TABLE_MAGIC.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_MAGIC.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_UMBRAN.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());
        benchRecipe(consumer, TBABlocks.PARK_BENCH_UMBRAN.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_UMBRAN.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_PLANKS.get(), BOPBlocks.UMBRAN_SLAB.get());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_UMBRAN.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.UMBRAN_PLANKS.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_UMBRAN.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());
        tableRecipe(consumer, TBABlocks.TABLE_UMBRAN.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_UMBRAN.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_HELLBARK.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());
        benchRecipe(consumer, TBABlocks.PARK_BENCH_HELLBARK.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_HELLBARK.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_PLANKS.get(), BOPBlocks.HELLBARK_SLAB.get());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_HELLBARK.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.HELLBARK_PLANKS.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_HELLBARK.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());
        tableRecipe(consumer, TBABlocks.TABLE_HELLBARK.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_HELLBARK.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_COCONUT.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        benchRecipe(consumer, TBABlocks.PARK_BENCH_COCONUT.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_COCONUT.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_PLANKS.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_COCONUT.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_PLANKS.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_COCONUT.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        tableRecipe(consumer, TBABlocks.TABLE_COCONUT.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_COCONUT.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_WALNUT.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        benchRecipe(consumer, TBABlocks.PARK_BENCH_WALNUT.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_WALNUT.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_PLANKS.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_WALNUT.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_PLANKS.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_WALNUT.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        tableRecipe(consumer, TBABlocks.TABLE_WALNUT.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_WALNUT.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_AZALEA.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        benchRecipe(consumer, TBABlocks.PARK_BENCH_AZALEA.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_AZALEA.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_PLANKS.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_AZALEA.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_PLANKS.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_AZALEA.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        tableRecipe(consumer, TBABlocks.TABLE_AZALEA.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_AZALEA.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_FLOWERING_AZALEA.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        benchRecipe(consumer, TBABlocks.PARK_BENCH_FLOWERING_AZALEA.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_FLOWERING_AZALEA.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_PLANKS.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_FLOWERING_AZALEA.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_PLANKS.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_FLOWERING_AZALEA.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        tableRecipe(consumer, TBABlocks.TABLE_FLOWERING_AZALEA.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_FLOWERING_AZALEA.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_GOLDEN_OAK.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        benchRecipe(consumer, TBABlocks.PARK_BENCH_GOLDEN_OAK.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_GOLDEN_OAK.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_PLANKS.get(), AetherBlocks.SKYROOT_SLAB.get());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_GOLDEN_OAK.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.SKYROOT_PLANKS.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_GOLDEN_OAK.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        tableRecipe(consumer, TBABlocks.TABLE_GOLDEN_OAK.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_GOLDEN_OAK.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_AETHER_SKYROOT.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        benchRecipe(consumer, TBABlocks.PARK_BENCH_AETHER_SKYROOT.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_AETHER_SKYROOT.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_PLANKS.get(), AetherBlocks.SKYROOT_SLAB.get());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_AETHER_SKYROOT.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.SKYROOT_PLANKS.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_AETHER_SKYROOT.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        tableRecipe(consumer, TBABlocks.TABLE_AETHER_SKYROOT.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_AETHER_SKYROOT.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_PREAM.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.STRIPPED_PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());
        benchRecipe(consumer, TBABlocks.PARK_BENCH_PREAM.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_PREAM.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_PLANKS.get(), PhantasmModBlocks.PREAM_SLAB.get());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_PREAM.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.PREAM_PLANKS.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_PREAM.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());
        tableRecipe(consumer, TBABlocks.TABLE_PREAM.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.STRIPPED_PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_PREAM.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.STRIPPED_PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_EBONY.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.STRIPPED_EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());
        benchRecipe(consumer, TBABlocks.PARK_BENCH_EBONY.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_EBONY.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_PLANKS.get(), PhantasmModBlocks.EBONY_SLAB.get());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_EBONY.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.EBONY_PLANKS.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_EBONY.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());
        tableRecipe(consumer, TBABlocks.TABLE_EBONY.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.STRIPPED_EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_EBONY.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.STRIPPED_EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());

        chairRecipe(consumer, TBABlocks.DESK_CHAIR_CHORUS_NEST.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        benchRecipe(consumer, TBABlocks.PARK_BENCH_CHORUS_NEST.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_CHORUS_NEST.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_CHORUS_NEST.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_PLANKS.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_CHORUS_NEST.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        tableRecipe(consumer, TBABlocks.TABLE_CHORUS_NEST.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_CHORUS_NEST.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());

        chairTagRecipe(consumer, TBABlocks.DESK_CHAIR_BLOODSHROOM.get().asItem().getDefaultInstance(),
                TBATags.Items.BLOODSHROOM_LOG, TBATags.Items.BLOODSHROOM_STRIPPED_LOG, TBATags.Items.BLOODSHROOM_SLAB);
        benchTagRecipe(consumer, TBABlocks.PARK_BENCH_BLOODSHROOM.get().asItem().getDefaultInstance(),
                TBATags.Items.BLOODSHROOM_LOG, TBATags.Items.BLOODSHROOM_SLAB);
        deskTagRecipe(consumer, TBABlocks.SCHOOL_DESK_BLOODSHROOM.get().asItem().getDefaultInstance(),
                TBATags.Items.BLOODSHROOM_PLANKS, TBATags.Items.BLOODSHROOM_SLAB);
        deskTagCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_BLOODSHROOM.get().asItem().getDefaultInstance(),
                TBATags.Items.BLOODSHROOM_LOG, TBATags.Items.BLOODSHROOM_PLANKS);
        lockerTagRecipe(consumer, TBABlocks.LOCKER_BLOODSHROOM.get().asItem().getDefaultInstance(),
                TBATags.Items.BLOODSHROOM_LOG, TBATags.Items.BLOODSHROOM_SLAB);
        tableTagRecipe(consumer, TBABlocks.TABLE_BLOODSHROOM.get().asItem().getDefaultInstance(),
                TBATags.Items.BLOODSHROOM_LOG, TBATags.Items.BLOODSHROOM_STRIPPED_LOG, TBATags.Items.BLOODSHROOM_SLAB);
        bookcaseTagRecipe(consumer, TBABlocks.BOOKCASE_BLOODSHROOM.get().asItem().getDefaultInstance(),
                TBATags.Items.BLOODSHROOM_LOG, TBATags.Items.BLOODSHROOM_STRIPPED_LOG, TBATags.Items.BLOODSHROOM_SLAB);

        chairTagRecipe(consumer, TBABlocks.DESK_CHAIR_ENDERBARK.get().asItem().getDefaultInstance(),
                TBATags.Items.ENDERBARK_LOG, TBATags.Items.ENDERBARK_STRIPPED_LOG, TBATags.Items.ENDERBARK_SLAB);
        benchTagRecipe(consumer, TBABlocks.PARK_BENCH_ENDERBARK.get().asItem().getDefaultInstance(),
                TBATags.Items.ENDERBARK_LOG, TBATags.Items.ENDERBARK_SLAB);
        deskTagRecipe(consumer, TBABlocks.SCHOOL_DESK_ENDERBARK.get().asItem().getDefaultInstance(),
                TBATags.Items.ENDERBARK_PLANKS, TBATags.Items.ENDERBARK_SLAB);
        deskTagCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_ENDERBARK.get().asItem().getDefaultInstance(),
                TBATags.Items.ENDERBARK_LOG, TBATags.Items.ENDERBARK_PLANKS);
        lockerTagRecipe(consumer, TBABlocks.LOCKER_ENDERBARK.get().asItem().getDefaultInstance(),
                TBATags.Items.ENDERBARK_LOG, TBATags.Items.ENDERBARK_SLAB);
        tableTagRecipe(consumer, TBABlocks.TABLE_ENDERBARK.get().asItem().getDefaultInstance(),
                TBATags.Items.ENDERBARK_LOG, TBATags.Items.ENDERBARK_STRIPPED_LOG, TBATags.Items.ENDERBARK_SLAB);
        bookcaseTagRecipe(consumer, TBABlocks.BOOKCASE_ENDERBARK.get().asItem().getDefaultInstance(),
                TBATags.Items.ENDERBARK_LOG, TBATags.Items.ENDERBARK_STRIPPED_LOG, TBATags.Items.ENDERBARK_SLAB);

        chairTagRecipe(consumer, TBABlocks.DESK_CHAIR_GREENHEART.get().asItem().getDefaultInstance(),
                TBATags.Items.GREENHEART_LOG, TBATags.Items.GREENHEART_STRIPPED_LOG, TBATags.Items.GREENHEART_SLAB);
        benchTagRecipe(consumer, TBABlocks.PARK_BENCH_GREENHEART.get().asItem().getDefaultInstance(),
                TBATags.Items.GREENHEART_LOG, TBATags.Items.GREENHEART_SLAB);
        deskTagRecipe(consumer, TBABlocks.SCHOOL_DESK_GREENHEART.get().asItem().getDefaultInstance(),
                TBATags.Items.GREENHEART_PLANKS, TBATags.Items.GREENHEART_SLAB);
        deskTagCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_GREENHEART.get().asItem().getDefaultInstance(),
                TBATags.Items.GREENHEART_LOG, TBATags.Items.GREENHEART_PLANKS);
        lockerTagRecipe(consumer, TBABlocks.LOCKER_GREENHEART.get().asItem().getDefaultInstance(),
                TBATags.Items.GREENHEART_LOG, TBATags.Items.GREENHEART_SLAB);
        tableTagRecipe(consumer, TBABlocks.TABLE_GREENHEART.get().asItem().getDefaultInstance(),
                TBATags.Items.GREENHEART_LOG, TBATags.Items.GREENHEART_STRIPPED_LOG, TBATags.Items.GREENHEART_SLAB);
        bookcaseTagRecipe(consumer, TBABlocks.BOOKCASE_GREENHEART.get().asItem().getDefaultInstance(),
                TBATags.Items.GREENHEART_LOG, TBATags.Items.GREENHEART_STRIPPED_LOG, TBATags.Items.GREENHEART_SLAB);

        chairTagRecipe(consumer, TBABlocks.DESK_CHAIR_TINKER_SKYROOT.get().asItem().getDefaultInstance(),
                TBATags.Items.TINKER_SKYROOT_LOG, TBATags.Items.TINKER_SKYROOT_STRIPPED_LOG, TBATags.Items.TINKER_SKYROOT_SLAB);
        benchTagRecipe(consumer, TBABlocks.PARK_BENCH_TINKER_SKYROOT.get().asItem().getDefaultInstance(),
                TBATags.Items.TINKER_SKYROOT_LOG, TBATags.Items.TINKER_SKYROOT_SLAB);
        deskTagRecipe(consumer, TBABlocks.SCHOOL_DESK_TINKER_SKYROOT.get().asItem().getDefaultInstance(),
                TBATags.Items.TINKER_SKYROOT_PLANKS, TBATags.Items.TINKER_SKYROOT_SLAB);
        deskTagCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_TINKER_SKYROOT.get().asItem().getDefaultInstance(),
                TBATags.Items.TINKER_SKYROOT_LOG, TBATags.Items.TINKER_SKYROOT_PLANKS);
        lockerTagRecipe(consumer, TBABlocks.LOCKER_TINKER_SKYROOT.get().asItem().getDefaultInstance(),
                TBATags.Items.TINKER_SKYROOT_LOG, TBATags.Items.TINKER_SKYROOT_SLAB);
        tableTagRecipe(consumer, TBABlocks.TABLE_TINKER_SKYROOT.get().asItem().getDefaultInstance(),
                TBATags.Items.TINKER_SKYROOT_LOG, TBATags.Items.TINKER_SKYROOT_STRIPPED_LOG, TBATags.Items.TINKER_SKYROOT_SLAB);
        bookcaseTagRecipe(consumer, TBABlocks.BOOKCASE_TINKER_SKYROOT.get().asItem().getDefaultInstance(),
                TBATags.Items.TINKER_SKYROOT_LOG, TBATags.Items.TINKER_SKYROOT_STRIPPED_LOG, TBATags.Items.TINKER_SKYROOT_SLAB);
    }

    private void plateRecipe(Consumer<FinishedRecipe> consumer, ItemStack result, Item ingredient) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), result.getItem(), 4)
                .unlockedBy("has_terracotta",
                        has(ItemTags.TERRACOTTA))
                .save(consumer, new ResourceLocation(MODID, "plates/" + result.getItem()));
    }

    private void bookcaseTagRecipe(Consumer<FinishedRecipe> consumer, @NotNull ItemStack result, TagKey<Item> log, TagKey<Item> strippedLog, TagKey<Item> slab) {
        ShapedRecipeBuilder.shaped(result.getItem(), 1)
                .group("bookcases")
                .pattern("SSS")
                .pattern("#B#")
                .pattern("LLL")
                .define('#', Ingredient.of(slab))
                .define('B', Items.BOOK)
                .define('L', Ingredient.of(log))
                .define('S', Ingredient.of(strippedLog))
                .unlockedBy("has_book", has(Items.BOOK))
                .save(consumer, new ResourceLocation(MODID,
                        "bookcases/" + result.getItem()));
    }

    private void bookcaseRecipe(Consumer<FinishedRecipe> consumer, @NotNull ItemStack result, ItemLike log, ItemLike strippedLog, ItemLike slab) {
        ShapedRecipeBuilder.shaped(result.getItem(), 1)
                .group("bookcases")
                .pattern("SSS")
                .pattern("#B#")
                .pattern("LLL")
                .define('#', Ingredient.of(slab))
                .define('B', Items.BOOK)
                .define('L', Ingredient.of(log))
                .define('S', Ingredient.of(strippedLog))
                .unlockedBy("has_book", has(Items.BOOK))
                .save(consumer, new ResourceLocation(MODID,
                        "bookcases/" + result.getItem()));
    }

    private void chairTagRecipe(Consumer<FinishedRecipe> consumer, @NotNull ItemStack result, TagKey<Item> log, TagKey<Item> strippedLog, TagKey<Item> slab) {
        ShapedRecipeBuilder.shaped(result.getItem(), 2)
                .group("chairs")
                .pattern("  #")
                .pattern("#S#")
                .pattern("L L")
                .define('#', Ingredient.of(slab))
                .define('S', Ingredient.of(strippedLog))
                .define('L', Ingredient.of(log))
                .unlockedBy("has_log", has(log))
                .save(consumer, new ResourceLocation(MODID,
                        "chairs/" + result.getItem()));
    }

    private void chairRecipe(Consumer<FinishedRecipe> consumer, @NotNull ItemStack result, ItemLike log, ItemLike strippedLog, ItemLike slab) {
        ShapedRecipeBuilder.shaped(result.getItem(), 2)
                .group("chairs")
                .pattern("  #")
                .pattern("#S#")
                .pattern("L L")
                .define('#', Ingredient.of(slab))
                .define('S', Ingredient.of(strippedLog))
                .define('L', Ingredient.of(log))
                .unlockedBy("has_log", has(log))
                .save(consumer, new ResourceLocation(MODID,
                        "chairs/" + result.getItem()));
    }

    private void benchTagRecipe(Consumer<FinishedRecipe> consumer, @NotNull ItemStack result, TagKey<Item> log, TagKey<Item> slab) {
        ShapedRecipeBuilder.shaped(result.getItem(), 2)
                .group("benches")
                .pattern("  #")
                .pattern("###")
                .pattern("L L")
                .define('#', Ingredient.of(slab))
                .define('L', Ingredient.of(log))
                .unlockedBy("has_log", has(log))
                .save(consumer, new ResourceLocation(MODID,
                        "benches/" + result.getItem()));
    }

    private void benchRecipe(Consumer<FinishedRecipe> consumer, @NotNull ItemStack result, ItemLike log, ItemLike slab) {
        ShapedRecipeBuilder.shaped(result.getItem(), 2)
                .group("benches")
                .pattern("  #")
                .pattern("###")
                .pattern("L L")
                .define('#', Ingredient.of(slab))
                .define('L', Ingredient.of(log))
                .unlockedBy("has_log", has(log))
                .save(consumer, new ResourceLocation(MODID,
                        "benches/" + result.getItem()));
    }

    private void deskTagRecipe(Consumer<FinishedRecipe> consumer, @NotNull ItemStack result, TagKey<Item> planks, TagKey<Item> slab) {
        ShapedRecipeBuilder.shaped(result.getItem(), 2)
                .group("desks")
                .pattern("###")
                .pattern("P P")
                .define('#', Ingredient.of(slab))
                .define('P', Ingredient.of(planks))
                .unlockedBy("has_planks", has(planks))
                .save(consumer, new ResourceLocation(MODID,
                        "desks/" + result.getItem()));
    }

    private void deskRecipe(Consumer<FinishedRecipe> consumer, @NotNull ItemStack result, ItemLike planks, ItemLike slab) {
        ShapedRecipeBuilder.shaped(result.getItem(), 2)
                .group("desks")
                .pattern("###")
                .pattern("P P")
                .define('#', Ingredient.of(slab))
                .define('P', Ingredient.of(planks))
                .unlockedBy("has_planks", has(planks))
                .save(consumer, new ResourceLocation(MODID,
                        "desks/" + result.getItem()));
    }

    private void deskTagCabinetRecipe(Consumer<FinishedRecipe> consumer, @NotNull ItemStack result, TagKey<Item> log, TagKey<Item> planks) {
        ShapedRecipeBuilder.shaped(result.getItem(), 1)
                .group("desk_cabinets")
                .pattern("PPP")
                .pattern("LCL")
                .pattern("PPP")
                .define('P', Ingredient.of(planks))
                .define('C', Items.CHEST)
                .define('L', Ingredient.of(log))
                .unlockedBy("has_chest", has(Items.CHEST))
                .save(consumer, new ResourceLocation(MODID,
                        "desk_cabinets/" + result.getItem()));
    }

    private void deskCabinetRecipe(Consumer<FinishedRecipe> consumer, @NotNull ItemStack result, ItemLike log, ItemLike planks) {
        ShapedRecipeBuilder.shaped(result.getItem(), 1)
                .group("desk_cabinets")
                .pattern("PPP")
                .pattern("LCL")
                .pattern("PPP")
                .define('P', Ingredient.of(planks))
                .define('C', Items.CHEST)
                .define('L', Ingredient.of(log))
                .unlockedBy("has_chest", has(Items.CHEST))
                .save(consumer, new ResourceLocation(MODID,
                        "desk_cabinets/" + result.getItem()));
    }

    private void lockerTagRecipe(Consumer<FinishedRecipe> consumer, @NotNull ItemStack result, TagKey<Item> log, TagKey<Item> slab) {
        ShapedRecipeBuilder.shaped(result.getItem(), 1)
                .group("lockers")
                .pattern("###")
                .pattern("LCL")
                .pattern("###")
                .define('#', Ingredient.of(slab))
                .define('C', Items.CHEST)
                .define('L', Ingredient.of(log))
                .unlockedBy("has_chest", has(Items.CHEST))
                .save(consumer, new ResourceLocation(MODID,
                        "lockers/" + result.getItem()));
    }

    private void lockerRecipe(Consumer<FinishedRecipe> consumer, @NotNull ItemStack result, ItemLike log, ItemLike slab) {
        ShapedRecipeBuilder.shaped(result.getItem(), 1)
                .group("lockers")
                .pattern("###")
                .pattern("LCL")
                .pattern("###")
                .define('#', Ingredient.of(slab))
                .define('C', Items.CHEST)
                .define('L', Ingredient.of(log))
                .unlockedBy("has_chest", has(Items.CHEST))
                .save(consumer, new ResourceLocation(MODID,
                        "lockers/" + result.getItem()));
    }

    private void tableTagRecipe(Consumer<FinishedRecipe> consumer, @NotNull ItemStack result, TagKey<Item> log, TagKey<Item> strippedLog, TagKey<Item> slab) {
        ShapedRecipeBuilder.shaped(result.getItem(), 2)
                .group("tables")
                .pattern("###")
                .pattern(" S ")
                .pattern(" L ")
                .define('#', Ingredient.of(slab))
                .define('S', Ingredient.of(strippedLog))
                .define('L', Ingredient.of(log))
                .unlockedBy("has_slab", has(slab))
                .save(consumer, new ResourceLocation(MODID,
                        "tables/" + result.getItem()));
    }

    private void tableRecipe(Consumer<FinishedRecipe> consumer, @NotNull ItemStack result, ItemLike log, ItemLike strippedLog, ItemLike slab) {
        ShapedRecipeBuilder.shaped(result.getItem(), 2)
                .group("tables")
                .pattern("###")
                .pattern(" S ")
                .pattern(" L ")
                .define('#', Ingredient.of(slab))
                .define('S', Ingredient.of(strippedLog))
                .define('L', Ingredient.of(log))
                .unlockedBy("has_slab", has(slab))
                .save(consumer, new ResourceLocation(MODID,
                        "tables/" + result.getItem()));
    }
}
