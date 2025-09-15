package com.github.warrentode.turtleblockacademy.datagen.recipes;

import biomesoplenty.api.block.BOPBlocks;
import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherItems;
import com.catastrophe573.dimdungeons.block.BlockRegistrar;
import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.datagen.recipes.builder.*;
import com.github.warrentode.turtleblockacademy.datagen.recipes.recipe.EasterEggRecipes;
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
import net.mcreator.hostiledelight.init.HostiledelightModItems;
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
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.world.TinkerWorld;
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
import static com.github.warrentode.turtleblockacademy.blocks.furniture.PicnicBlanket.PICNIC_BLANKET_LIST;
import static net.brnbrd.delightful.common.item.DelightfulItems.*;
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
        picnicBlanketRecipes(consumer);

        LootBagRecipesGen.register(consumer);
        CuttingRecipesGen.register(consumer);
        EasterEggRecipes.register(consumer);
    }

    private void picnicBlanketRecipes(Consumer<FinishedRecipe> consumer) {
        PICNIC_BLANKET_LIST.forEach(picnicBlanket ->
                picnicBlanketTemplate(consumer, picnicBlanket.asItem(),
                        picnicBlanket.getClothColor(picnicBlanket.asItem().getDefaultInstance()))
        );
    }

    private void picnicBlanketTemplate(Consumer<FinishedRecipe> consumer, @NotNull Item picnicBlanket, DyeColor woolColor) {
        ShapedRemainderRecipeBuilder.recipe(picnicBlanket.asItem(), 4)
                .define('C', getMatchingCarpet(woolColor))
                .define('N', TBATags.Items.NEEDLES)
                .define('T', TBATags.Items.STRING)
                .pattern("NCC")
                .pattern("TCC")
                .unlockedByAnyIngredient()
                .build(consumer,picnicBlanket.asItem().getDescriptionId() + "_with_string");

        ShapedRemainderRecipeBuilder.recipe(picnicBlanket.asItem(), 4)
                .define('C', getMatchingCarpet(woolColor))
                .define('N', TBATags.Items.NEEDLES)
                .define('T', TBATags.Items.THREAD)
                .pattern("NCC")
                .pattern("TCC")
                .unlockedByAnyIngredient()
                .build(consumer,picnicBlanket.asItem().getDescriptionId() + "_with_thread");
    }

    @Contract(pure = true)
    private Item getMatchingCarpet(@NotNull DyeColor color) {
        return switch (color) {
            case ORANGE -> Items.ORANGE_CARPET;
            case MAGENTA -> Items.MAGENTA_CARPET;
            case LIGHT_BLUE -> Items.LIGHT_BLUE_CARPET;
            case YELLOW -> Items.YELLOW_CARPET;
            case LIME -> Items.LIME_CARPET;
            case PINK -> Items.PINK_CARPET;
            case GRAY -> Items.GRAY_CARPET;
            case LIGHT_GRAY -> Items.LIGHT_GRAY_CARPET;
            case CYAN -> Items.CYAN_CARPET;
            case PURPLE -> Items.PURPLE_CARPET;
            case BLUE -> Items.BLUE_CARPET;
            case BROWN -> Items.BROWN_CARPET;
            case GREEN -> Items.GREEN_CARPET;
            case RED -> Items.RED_CARPET;
            case BLACK -> Items.BLACK_CARPET;
            default -> Items.WHITE_CARPET;
        };
    }

    private void fermentingRecipes(Consumer<FinishedRecipe> consumer) {
        FermentingPotRecipeBuilder.fermentingPotRecipe(TBAItems.DILL_PICKLE.get(),
                        2, 300, 0.35F, Items.SMOOTH_STONE_SLAB)
                .setRecipeBookTab(FermentingRecipeBookTab.PICKLES)
                .addIngredient(TBAItems.CUCUMBER.get())
                .addIngredient(TBAItems.CUCUMBER.get())
                .addIngredient(TBAItems.VINEGAR_BOTTLE.get())
                .addIngredient(TBATags.Items.SALT_INGREDIENTS)
                .addIngredient(TBATags.Items.ONION_INGREDIENTS)
                .addIngredient(TBAItems.DILL_HERB.get())
                .unlockedBy("has_cucumber", has(TBAItems.CUCUMBER.get()))
                .build(consumer, new ResourceLocation(MODID,
                        TBAItems.DILL_PICKLE.get().asItem().toString()));

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
                        4, 300, 0.35F, Items.WHITE_CARPET)
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
        ConditionalRecipe.builder()
                .addCondition(modLoaded("hostiledelight"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(HostiledelightModItems.CANDIEDSLIME.get(), 1)
                        .requires(TBATags.Items.SUGAR)
                        .requires(TBATags.Items.SUGAR)
                        .requires(TBATags.Items.SLIME_BALLS)
                        .unlockedBy("has_slime_balls", has(TBATags.Items.SLIME_BALLS))
                        ::save)
                .build(consumer, new ResourceLocation("hostiledelight",
                        HostiledelightModItems.CANDIEDSLIME.get().asItem() + "_alt"));
        ShapelessRecipeBuilder.shapeless(TBAItems.PEELED_EGG.get(), 1)
                .requires(TBATags.Items.BOILED_EGGS)
                .unlockedBy("has_boiled_eggs", has(TBATags.Items.BOILED_EGGS))
                .save(consumer, new ResourceLocation(MODID,
                                TBAItems.PEELED_EGG.get().asItem().toString()));
        ShapelessRecipeBuilder.shapeless(TBAItems.PEELED_EGG.get(), 1)
                .requires(TBATags.Items.EASTER_EGGS)
                .unlockedBy("has_easter_eggs", has(TBATags.Items.EASTER_EGGS))
                .save(consumer, new ResourceLocation(MODID,
                        TBAItems.PEELED_EGG.get().asItem() + "_from_easter_egg"));

        ShapelessRecipeBuilder.shapeless(TBAItems.CUCUMBER_SEEDS.get(), 1)
                .requires(TBAItems.CUCUMBER.get())
                .unlockedBy("has_cucumber", has(TBAItems.CUCUMBER.get()))
                .save(consumer, new ResourceLocation(MODID,
                        TBAItems.CUCUMBER_SEEDS.get().asItem().toString()));
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
                        .define('S', Items.WOODEN_SHOVEL)
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
                .addCondition(not(modLoaded("eggdelight")))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(TBAItems.BOILED_EGG.get(),
                                        1, 200, 0.35F, null)
                                .addIngredient(Items.EGG)
                                .addIngredient(Items.WATER_BUCKET)
                                .unlockedBy("has_eggs",
                                        has(Items.EGG))
                                .build(consumer, new ResourceLocation("farmersdelight",
                                        "cooking/" + TBAItems.BOILED_EGG.get()))
                );
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
        ConditionalRecipe.builder()
                .addCondition(not(this.tagEmpty(TBATags.Items.COPPER_NUGGET)))
                .addRecipe(finishedRecipeConsumer ->
                        ShapelessRemainderRecipeBuilder.recipe(TBAItems.COPPER_NEEDLE.get(), 1)
                                .setGroup("needles")
                                .addIngredient(TBATags.Items.COPPER_NUGGET)
                                .unlockedByAnyIngredient()
                                .build(consumer, TBAItems.COPPER_NEEDLE.getId() + "_from_nugget")
                );
        ShapelessRemainderRecipeBuilder.recipe(TBAItems.COPPER_NEEDLE.get(), 9)
                .setGroup("needles")
                .addIngredient(TBATags.Items.COPPER_INGOT)
                .unlockedByAnyIngredient()
                .build(consumer, TBAItems.COPPER_NEEDLE.getId() + "_from_ingot");
        ShapedRemainderRecipeBuilder.recipe(TBAItems.SILK_THREAD.get(), 1)
                .setGroup("thread")
                .pattern("FFF")
                .pattern("FFF")
                .define('F', TBATags.Items.WEBBING)
                .unlockedByAnyIngredient()
                .build(consumer, TBAItems.SILK_THREAD.getId());
        ShapedRemainderRecipeBuilder.recipe(TBAItems.WOOL_THREAD.get(), 1)
                .setGroup("thread")
                .pattern("FFF")
                .pattern("FFF")
                .define('F', Items.STRING)
                .unlockedByAnyIngredient()
                .build(consumer, TBAItems.WOOL_THREAD.getId());
        ShapelessRecipeBuilder.shapeless(TBAItems.EGG_STAMP_CREEPER.get(), 1)
                .requires(ItemTags.BUTTONS)
                .requires(Items.HONEYCOMB)
                .requires(Items.HONEY_BOTTLE)
                .requires(Items.CREEPER_BANNER_PATTERN)
                .unlockedBy("has_creeper_banner_pattern",
                        has(Items.CREEPER_BANNER_PATTERN))
                .save(consumer, new ResourceLocation(MODID,
                        TBAItems.EGG_STAMP_CREEPER.get() + "_using_honey"));
        ShapelessRecipeBuilder.shapeless(TBAItems.EGG_STAMP_CREEPER.get(), 1)
                .requires(ItemTags.BUTTONS)
                .requires(Items.HONEYCOMB)
                .requires(TBATags.Items.SLIME_BALLS)
                .requires(Items.CREEPER_BANNER_PATTERN)
                .unlockedBy("has_creeper_banner_pattern",
                        has(Items.CREEPER_BANNER_PATTERN))
                .save(consumer, new ResourceLocation(MODID,
                        TBAItems.EGG_STAMP_CREEPER.get() + "_using_slime"));

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

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_ACACIA.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_SLAB);
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_ACACIA_WHITE.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_SLAB);
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_ACACIA_ORANGE.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_SLAB);
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_ACACIA_MAGENTA.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_SLAB);
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_ACACIA_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_SLAB);
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_ACACIA_YELLOW.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_SLAB);
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_ACACIA_LIME.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_SLAB);
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_ACACIA_PINK.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_SLAB);
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_ACACIA_GRAY.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_SLAB);
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_ACACIA_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_SLAB);
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_ACACIA_CYAN.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_SLAB);
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_ACACIA_PURPLE.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_SLAB);
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_ACACIA_BLUE.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_SLAB);
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_ACACIA_BROWN.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_SLAB);
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_ACACIA_GREEN.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_SLAB);
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_ACACIA_RED.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_SLAB);
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_ACACIA_BLACK.get().asItem().getDefaultInstance(),
                Items.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_SLAB);

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_BIRCH.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_SLAB);
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_BIRCH_WHITE.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_SLAB);
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_BIRCH_ORANGE.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_SLAB);
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_BIRCH_MAGENTA.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_SLAB);
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_BIRCH_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_SLAB);
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_BIRCH_YELLOW.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_SLAB);
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_BIRCH_LIME.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_SLAB);
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_BIRCH_PINK.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_SLAB);
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_BIRCH_GRAY.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_SLAB);
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_BIRCH_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_SLAB);
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_BIRCH_CYAN.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_SLAB);
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_BIRCH_PURPLE.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_SLAB);
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_BIRCH_BLUE.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_SLAB);
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_BIRCH_BROWN.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_SLAB);
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_BIRCH_GREEN.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_SLAB);
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_BIRCH_RED.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_SLAB);
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_BIRCH_BLACK.get().asItem().getDefaultInstance(),
                Items.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_SLAB);

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_DARK_OAK.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_SLAB);
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_DARK_OAK_WHITE.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_SLAB);
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_DARK_OAK_ORANGE.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_SLAB);
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_DARK_OAK_MAGENTA.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_SLAB);
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_DARK_OAK_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_SLAB);
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_DARK_OAK_YELLOW.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_SLAB);
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_DARK_OAK_LIME.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_SLAB);
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_DARK_OAK_PINK.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_SLAB);
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_DARK_OAK_GRAY.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_SLAB);
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_DARK_OAK_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_SLAB);
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_DARK_OAK_CYAN.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_SLAB);
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_DARK_OAK_PURPLE.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_SLAB);
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_DARK_OAK_BLUE.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_SLAB);
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_DARK_OAK_BROWN.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_SLAB);
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_DARK_OAK_GREEN.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_SLAB);
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_DARK_OAK_RED.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_SLAB);
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_DARK_OAK_BLACK.get().asItem().getDefaultInstance(),
                Items.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_SLAB);

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_JUNGLE.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_SLAB);
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_JUNGLE_WHITE.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_SLAB);
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_JUNGLE_ORANGE.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_SLAB);
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_JUNGLE_MAGENTA.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_SLAB);
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_JUNGLE_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_SLAB);
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_JUNGLE_YELLOW.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_SLAB);
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_JUNGLE_LIME.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_SLAB);
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_JUNGLE_PINK.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_SLAB);
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_JUNGLE_GRAY.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_SLAB);
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_JUNGLE_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_SLAB);
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_JUNGLE_CYAN.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_SLAB);
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_JUNGLE_PURPLE.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_SLAB);
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_JUNGLE_BLUE.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_SLAB);
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_JUNGLE_BROWN.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_SLAB);
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_JUNGLE_GREEN.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_SLAB);
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_JUNGLE_RED.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_SLAB);
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_JUNGLE_BLACK.get().asItem().getDefaultInstance(),
                Items.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_SLAB);

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_MANGROVE.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_SLAB);
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_MANGROVE_WHITE.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_SLAB);
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_MANGROVE_ORANGE.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_SLAB);
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_MANGROVE_MAGENTA.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_SLAB);
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_MANGROVE_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_SLAB);
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_MANGROVE_YELLOW.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_SLAB);
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_MANGROVE_LIME.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_SLAB);
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_MANGROVE_PINK.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_SLAB);
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_MANGROVE_GRAY.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_SLAB);
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_MANGROVE_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_SLAB);
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_MANGROVE_CYAN.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_SLAB);
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_MANGROVE_PURPLE.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_SLAB);
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_MANGROVE_BLUE.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_SLAB);
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_MANGROVE_BROWN.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_SLAB);
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_MANGROVE_GREEN.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_SLAB);
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_MANGROVE_RED.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_SLAB);
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_MANGROVE_BLACK.get().asItem().getDefaultInstance(),
                Items.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_SLAB);

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_OAK.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.STRIPPED_OAK_LOG, Items.OAK_SLAB);
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_OAK_WHITE.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.STRIPPED_OAK_LOG, Items.OAK_SLAB);
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_OAK_ORANGE.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.STRIPPED_OAK_LOG, Items.OAK_SLAB);
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_OAK_MAGENTA.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.STRIPPED_OAK_LOG, Items.OAK_SLAB);
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_OAK_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.STRIPPED_OAK_LOG, Items.OAK_SLAB);
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_OAK_YELLOW.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.STRIPPED_OAK_LOG, Items.OAK_SLAB);
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_OAK_LIME.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.STRIPPED_OAK_LOG, Items.OAK_SLAB);
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_OAK_PINK.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.STRIPPED_OAK_LOG, Items.OAK_SLAB);
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_OAK_GRAY.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.STRIPPED_OAK_LOG, Items.OAK_SLAB);
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_OAK_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.STRIPPED_OAK_LOG, Items.OAK_SLAB);
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_OAK_CYAN.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.STRIPPED_OAK_LOG, Items.OAK_SLAB);
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_OAK_PURPLE.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.STRIPPED_OAK_LOG, Items.OAK_SLAB);
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_OAK_BLUE.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.STRIPPED_OAK_LOG, Items.OAK_SLAB);
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_OAK_BROWN.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.STRIPPED_OAK_LOG, Items.OAK_SLAB);
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_OAK_GREEN.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.STRIPPED_OAK_LOG, Items.OAK_SLAB);
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_OAK_RED.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.STRIPPED_OAK_LOG, Items.OAK_SLAB);
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_OAK_BLACK.get().asItem().getDefaultInstance(),
                Items.OAK_LOG, Items.STRIPPED_OAK_LOG, Items.OAK_SLAB);

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_SPRUCE.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_SLAB);
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_SPRUCE_WHITE.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_SLAB);
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_SPRUCE_ORANGE.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_SLAB);
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_SPRUCE_MAGENTA.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_SLAB);
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_SPRUCE_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_SLAB);
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_SPRUCE_YELLOW.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_SLAB);
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_SPRUCE_LIME.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_SLAB);
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_SPRUCE_PINK.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_SLAB);
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_SPRUCE_GRAY.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_SLAB);
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_SPRUCE_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_SLAB);
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_SPRUCE_CYAN.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_SLAB);
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_SPRUCE_PURPLE.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_SLAB);
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_SPRUCE_BLUE.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_SLAB);
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_SPRUCE_BROWN.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_SLAB);
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_SPRUCE_GREEN.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_SLAB);
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_SPRUCE_RED.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_SLAB);
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_SPRUCE_BLACK.get().asItem().getDefaultInstance(),
                Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_SLAB);

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_CRIMSON.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_SLAB);
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_CRIMSON_WHITE.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_SLAB);
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_CRIMSON_ORANGE.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_SLAB);
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_CRIMSON_MAGENTA.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_SLAB);
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_CRIMSON_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_SLAB);
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_CRIMSON_YELLOW.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_SLAB);
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_CRIMSON_LIME.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_SLAB);
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_CRIMSON_PINK.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_SLAB);
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_CRIMSON_GRAY.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_SLAB);
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_CRIMSON_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_SLAB);
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_CRIMSON_CYAN.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_SLAB);
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_CRIMSON_PURPLE.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_SLAB);
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_CRIMSON_BLUE.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_SLAB);
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_CRIMSON_BROWN.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_SLAB);
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_CRIMSON_GREEN.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_SLAB);
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_CRIMSON_RED.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_SLAB);
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_CRIMSON_BLACK.get().asItem().getDefaultInstance(),
                Items.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_SLAB);

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_WARPED.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.STRIPPED_WARPED_STEM, Items.WARPED_SLAB);
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_WARPED_WHITE.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.STRIPPED_WARPED_STEM, Items.WARPED_SLAB);
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_WARPED_ORANGE.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.STRIPPED_WARPED_STEM, Items.WARPED_SLAB);
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_WARPED_MAGENTA.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.STRIPPED_WARPED_STEM, Items.WARPED_SLAB);
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_WARPED_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.STRIPPED_WARPED_STEM, Items.WARPED_SLAB);
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_WARPED_YELLOW.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.STRIPPED_WARPED_STEM, Items.WARPED_SLAB);
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_WARPED_LIME.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.STRIPPED_WARPED_STEM, Items.WARPED_SLAB);
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_WARPED_PINK.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.STRIPPED_WARPED_STEM, Items.WARPED_SLAB);
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_WARPED_GRAY.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.STRIPPED_WARPED_STEM, Items.WARPED_SLAB);
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_WARPED_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.STRIPPED_WARPED_STEM, Items.WARPED_SLAB);
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_WARPED_CYAN.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.STRIPPED_WARPED_STEM, Items.WARPED_SLAB);
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_WARPED_PURPLE.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.STRIPPED_WARPED_STEM, Items.WARPED_SLAB);
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_WARPED_BLUE.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.STRIPPED_WARPED_STEM, Items.WARPED_SLAB);
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_WARPED_BROWN.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.STRIPPED_WARPED_STEM, Items.WARPED_SLAB);
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_WARPED_GREEN.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.STRIPPED_WARPED_STEM, Items.WARPED_SLAB);
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_WARPED_RED.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.STRIPPED_WARPED_STEM, Items.WARPED_SLAB);
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_WARPED_BLACK.get().asItem().getDefaultInstance(),
                Items.WARPED_STEM, Items.STRIPPED_WARPED_STEM, Items.WARPED_SLAB);

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_FIR.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_FIR_WHITE.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_FIR_ORANGE.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_FIR_MAGENTA.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_FIR_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_FIR_YELLOW.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_FIR_LIME.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_FIR_PINK.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_FIR_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_FIR_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_FIR_CYAN.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_FIR_PURPLE.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_FIR_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_FIR_BROWN.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_FIR_GREEN.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_FIR_RED.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_FIR_BLACK.get().asItem().getDefaultInstance(),
                BOPBlocks.FIR_LOG.get(), BOPBlocks.STRIPPED_FIR_LOG.get(), BOPBlocks.FIR_SLAB.get());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_REDWOOD.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_REDWOOD_WHITE.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_REDWOOD_ORANGE.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_REDWOOD_MAGENTA.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_REDWOOD_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_REDWOOD_YELLOW.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_REDWOOD_LIME.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_REDWOOD_PINK.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_REDWOOD_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_REDWOOD_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_REDWOOD_CYAN.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_REDWOOD_PURPLE.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_REDWOOD_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_REDWOOD_BROWN.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_REDWOOD_GREEN.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_REDWOOD_RED.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_REDWOOD_BLACK.get().asItem().getDefaultInstance(),
                BOPBlocks.REDWOOD_LOG.get(), BOPBlocks.STRIPPED_REDWOOD_LOG.get(), BOPBlocks.REDWOOD_SLAB.get());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_CHERRY.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_CHERRY_WHITE.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_CHERRY_ORANGE.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_CHERRY_MAGENTA.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_CHERRY_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_CHERRY_YELLOW.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_CHERRY_LIME.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_CHERRY_PINK.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_CHERRY_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_CHERRY_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_CHERRY_CYAN.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_CHERRY_PURPLE.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_CHERRY_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_CHERRY_BROWN.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_CHERRY_GREEN.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_CHERRY_RED.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_CHERRY_BLACK.get().asItem().getDefaultInstance(),
                BOPBlocks.CHERRY_LOG.get(), BOPBlocks.STRIPPED_CHERRY_LOG.get(), BOPBlocks.CHERRY_SLAB.get());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_MAHOGANY.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_MAHOGANY_WHITE.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_MAHOGANY_ORANGE.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_MAHOGANY_MAGENTA.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_MAHOGANY_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_MAHOGANY_YELLOW.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_MAHOGANY_LIME.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_MAHOGANY_PINK.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_MAHOGANY_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_MAHOGANY_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_MAHOGANY_CYAN.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_MAHOGANY_PURPLE.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_MAHOGANY_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_MAHOGANY_BROWN.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_MAHOGANY_GREEN.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_MAHOGANY_RED.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_MAHOGANY_BLACK.get().asItem().getDefaultInstance(),
                BOPBlocks.MAHOGANY_LOG.get(), BOPBlocks.STRIPPED_MAHOGANY_LOG.get(), BOPBlocks.MAHOGANY_SLAB.get());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_JACARANDA.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_JACARANDA_WHITE.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_JACARANDA_ORANGE.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_JACARANDA_MAGENTA.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_JACARANDA_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_JACARANDA_YELLOW.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_JACARANDA_LIME.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_JACARANDA_PINK.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_JACARANDA_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_JACARANDA_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_JACARANDA_CYAN.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_JACARANDA_PURPLE.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_JACARANDA_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_JACARANDA_BROWN.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_JACARANDA_GREEN.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_JACARANDA_RED.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_JACARANDA_BLACK.get().asItem().getDefaultInstance(),
                BOPBlocks.JACARANDA_LOG.get(), BOPBlocks.STRIPPED_JACARANDA_LOG.get(), BOPBlocks.JACARANDA_SLAB.get());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_PALM.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_PALM_WHITE.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_PALM_ORANGE.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_PALM_MAGENTA.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_PALM_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_PALM_YELLOW.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_PALM_LIME.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_PALM_PINK.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_PALM_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_PALM_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_PALM_CYAN.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_PALM_PURPLE.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_PALM_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_PALM_BROWN.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_PALM_GREEN.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_PALM_RED.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_PALM_BLACK.get().asItem().getDefaultInstance(),
                BOPBlocks.PALM_LOG.get(), BOPBlocks.STRIPPED_PALM_LOG.get(), BOPBlocks.PALM_SLAB.get());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_WILLOW.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_WILLOW_WHITE.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_WILLOW_ORANGE.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_WILLOW_MAGENTA.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_WILLOW_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_WILLOW_YELLOW.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_WILLOW_LIME.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_WILLOW_PINK.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_WILLOW_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_WILLOW_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_WILLOW_CYAN.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_WILLOW_PURPLE.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_WILLOW_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_WILLOW_BROWN.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_WILLOW_GREEN.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_WILLOW_RED.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_WILLOW_BLACK.get().asItem().getDefaultInstance(),
                BOPBlocks.WILLOW_LOG.get(), BOPBlocks.STRIPPED_WILLOW_LOG.get(), BOPBlocks.WILLOW_SLAB.get());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_DEAD.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_DEAD_WHITE.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_DEAD_ORANGE.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_DEAD_MAGENTA.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_DEAD_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_DEAD_YELLOW.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_DEAD_LIME.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_DEAD_PINK.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_DEAD_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_DEAD_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_DEAD_CYAN.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_DEAD_PURPLE.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_DEAD_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_DEAD_BROWN.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_DEAD_GREEN.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_DEAD_RED.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_DEAD_BLACK.get().asItem().getDefaultInstance(),
                BOPBlocks.DEAD_LOG.get(), BOPBlocks.STRIPPED_DEAD_LOG.get(), BOPBlocks.DEAD_SLAB.get());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_MAGIC.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_MAGIC_WHITE.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_MAGIC_ORANGE.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_MAGIC_MAGENTA.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_MAGIC_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_MAGIC_YELLOW.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_MAGIC_LIME.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_MAGIC_PINK.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_MAGIC_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_MAGIC_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_MAGIC_CYAN.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_MAGIC_PURPLE.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_MAGIC_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_MAGIC_BROWN.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_MAGIC_GREEN.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_MAGIC_RED.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_MAGIC_BLACK.get().asItem().getDefaultInstance(),
                BOPBlocks.MAGIC_LOG.get(), BOPBlocks.STRIPPED_MAGIC_LOG.get(), BOPBlocks.MAGIC_SLAB.get());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_UMBRAN.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_UMBRAN_WHITE.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_UMBRAN_ORANGE.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_UMBRAN_MAGENTA.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_UMBRAN_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_UMBRAN_YELLOW.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_UMBRAN_LIME.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_UMBRAN_PINK.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_UMBRAN_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_UMBRAN_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_UMBRAN_CYAN.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_UMBRAN_PURPLE.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_UMBRAN_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_UMBRAN_BROWN.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_UMBRAN_GREEN.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_UMBRAN_RED.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_UMBRAN_BLACK.get().asItem().getDefaultInstance(),
                BOPBlocks.UMBRAN_LOG.get(), BOPBlocks.STRIPPED_UMBRAN_LOG.get(), BOPBlocks.UMBRAN_SLAB.get());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_HELLBARK.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_HELLBARK_WHITE.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_HELLBARK_ORANGE.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_HELLBARK_MAGENTA.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_HELLBARK_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_HELLBARK_YELLOW.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_HELLBARK_LIME.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_HELLBARK_PINK.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_HELLBARK_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_HELLBARK_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_HELLBARK_CYAN.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_HELLBARK_PURPLE.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_HELLBARK_BLUE.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_HELLBARK_BROWN.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_HELLBARK_GREEN.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_HELLBARK_RED.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_HELLBARK_BLACK.get().asItem().getDefaultInstance(),
                BOPBlocks.HELLBARK_LOG.get(), BOPBlocks.STRIPPED_HELLBARK_LOG.get(), BOPBlocks.HELLBARK_SLAB.get());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_COCONUT.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_COCONUT_WHITE.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_COCONUT_ORANGE.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_COCONUT_MAGENTA.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_COCONUT_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_COCONUT_YELLOW.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_COCONUT_LIME.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_COCONUT_PINK.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_COCONUT_GRAY.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_COCONUT_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_COCONUT_CYAN.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_COCONUT_PURPLE.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_COCONUT_BLUE.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_COCONUT_BROWN.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_COCONUT_GREEN.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_COCONUT_RED.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_COCONUT_BLACK.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_COCONUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_WALNUT.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_WALNUT_WHITE.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_WALNUT_ORANGE.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_WALNUT_MAGENTA.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_WALNUT_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_WALNUT_YELLOW.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_WALNUT_LIME.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_WALNUT_PINK.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_WALNUT_GRAY.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_WALNUT_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_WALNUT_CYAN.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_WALNUT_PURPLE.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_WALNUT_BLUE.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_WALNUT_BROWN.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_WALNUT_GREEN.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_WALNUT_RED.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_WALNUT_BLACK.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_WALNUT_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_AZALEA.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_AZALEA_WHITE.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_AZALEA_ORANGE.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_AZALEA_MAGENTA.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_AZALEA_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_AZALEA_YELLOW.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_AZALEA_LIME.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_AZALEA_PINK.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_AZALEA_GRAY.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_AZALEA_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_AZALEA_CYAN.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_AZALEA_PURPLE.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_AZALEA_BLUE.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_AZALEA_BROWN.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_AZALEA_GREEN.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_AZALEA_RED.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_AZALEA_BLACK.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_FLOWERING_AZALEA.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_WHITE.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_ORANGE.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_MAGENTA.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_YELLOW.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_LIME.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_PINK.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_GRAY.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_CYAN.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_PURPLE.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_BLUE.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_BROWN.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_GREEN.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_RED.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_BLACK.get().asItem().getDefaultInstance(),
                samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.STRIPPED_AZALEA_LOG.get(), samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_GOLDEN_OAK.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_GOLDEN_OAK_WHITE.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_GOLDEN_OAK_ORANGE.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_GOLDEN_OAK_MAGENTA.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_GOLDEN_OAK_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_GOLDEN_OAK_YELLOW.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_GOLDEN_OAK_LIME.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_GOLDEN_OAK_PINK.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_GOLDEN_OAK_GRAY.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_GOLDEN_OAK_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_GOLDEN_OAK_CYAN.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_GOLDEN_OAK_PURPLE.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_GOLDEN_OAK_BLUE.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_GOLDEN_OAK_BROWN.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_GOLDEN_OAK_GREEN.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_GOLDEN_OAK_RED.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_GOLDEN_OAK_BLACK.get().asItem().getDefaultInstance(),
                AetherBlocks.GOLDEN_OAK_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_AETHER_SKYROOT.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_AETHER_SKYROOT_WHITE.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_AETHER_SKYROOT_ORANGE.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_AETHER_SKYROOT_MAGENTA.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_AETHER_SKYROOT_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_AETHER_SKYROOT_YELLOW.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_AETHER_SKYROOT_LIME.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_AETHER_SKYROOT_PINK.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_AETHER_SKYROOT_GRAY.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_AETHER_SKYROOT_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_AETHER_SKYROOT_CYAN.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_AETHER_SKYROOT_PURPLE.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_AETHER_SKYROOT_BLUE.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_AETHER_SKYROOT_BROWN.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_AETHER_SKYROOT_GREEN.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_AETHER_SKYROOT_RED.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_AETHER_SKYROOT_BLACK.get().asItem().getDefaultInstance(),
                AetherBlocks.SKYROOT_LOG.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get(), AetherBlocks.SKYROOT_SLAB.get());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_PREAM.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.STRIPPED_PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_PREAM_WHITE.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.STRIPPED_PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_PREAM_ORANGE.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.STRIPPED_PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_PREAM_MAGENTA.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.STRIPPED_PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_PREAM_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.STRIPPED_PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_PREAM_YELLOW.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.STRIPPED_PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_PREAM_LIME.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.STRIPPED_PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_PREAM_PINK.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.STRIPPED_PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_PREAM_GRAY.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.STRIPPED_PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_PREAM_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.STRIPPED_PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_PREAM_CYAN.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.STRIPPED_PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_PREAM_PURPLE.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.STRIPPED_PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_PREAM_BLUE.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.STRIPPED_PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_PREAM_BROWN.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.STRIPPED_PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_PREAM_GREEN.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.STRIPPED_PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_PREAM_RED.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.STRIPPED_PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_PREAM_BLACK.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.PREAM_LOG.get(), PhantasmModBlocks.STRIPPED_PREAM_LOG.get(), PhantasmModBlocks.PREAM_SLAB.get());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_EBONY.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.STRIPPED_EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_EBONY_WHITE.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.STRIPPED_EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_EBONY_ORANGE.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.STRIPPED_EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_EBONY_MAGENTA.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.STRIPPED_EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_EBONY_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.STRIPPED_EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_EBONY_YELLOW.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.STRIPPED_EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_EBONY_LIME.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.STRIPPED_EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_EBONY_PINK.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.STRIPPED_EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_EBONY_GRAY.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.STRIPPED_EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_EBONY_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.STRIPPED_EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_EBONY_CYAN.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.STRIPPED_EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_EBONY_PURPLE.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.STRIPPED_EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_EBONY_BLUE.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.STRIPPED_EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_EBONY_BROWN.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.STRIPPED_EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_EBONY_GREEN.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.STRIPPED_EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_EBONY_RED.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.STRIPPED_EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_EBONY_BLACK.get().asItem().getDefaultInstance(),
                PhantasmModBlocks.EBONY_WOOD.get(), PhantasmModBlocks.STRIPPED_EBONY_WOOD.get(), PhantasmModBlocks.EBONY_SLAB.get());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_CHORUS_NEST.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_CHORUS_NEST_WHITE.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_CHORUS_NEST_ORANGE.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_CHORUS_NEST_MAGENTA.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_CHORUS_NEST_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_CHORUS_NEST_YELLOW.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_CHORUS_NEST_LIME.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_CHORUS_NEST_PINK.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_CHORUS_NEST_GRAY.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_CHORUS_NEST_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_CHORUS_NEST_CYAN.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_CHORUS_NEST_PURPLE.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_CHORUS_NEST_BLUE.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_CHORUS_NEST_BROWN.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_CHORUS_NEST_GREEN.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_CHORUS_NEST_RED.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_CHORUS_NEST_BLACK.get().asItem().getDefaultInstance(),
                UnusualendModBlocks.CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get(), UnusualendModBlocks.CHORUS_NEST_SLAB.get());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_BLOODSHROOM.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getStrippedLog(), TinkerWorld.bloodshroom.getSlab());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_BLOODSHROOM_WHITE.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getStrippedLog(), TinkerWorld.bloodshroom.getSlab());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_BLOODSHROOM_ORANGE.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getStrippedLog(), TinkerWorld.bloodshroom.getSlab());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_BLOODSHROOM_MAGENTA.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getStrippedLog(), TinkerWorld.bloodshroom.getSlab());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_BLOODSHROOM_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getStrippedLog(), TinkerWorld.bloodshroom.getSlab());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_BLOODSHROOM_YELLOW.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getStrippedLog(), TinkerWorld.bloodshroom.getSlab());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_BLOODSHROOM_LIME.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getStrippedLog(), TinkerWorld.bloodshroom.getSlab());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_BLOODSHROOM_PINK.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getStrippedLog(), TinkerWorld.bloodshroom.getSlab());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_BLOODSHROOM_GRAY.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getStrippedLog(), TinkerWorld.bloodshroom.getSlab());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_BLOODSHROOM_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getStrippedLog(), TinkerWorld.bloodshroom.getSlab());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_BLOODSHROOM_CYAN.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getStrippedLog(), TinkerWorld.bloodshroom.getSlab());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_BLOODSHROOM_PURPLE.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getStrippedLog(), TinkerWorld.bloodshroom.getSlab());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_BLOODSHROOM_BLUE.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getStrippedLog(), TinkerWorld.bloodshroom.getSlab());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_BLOODSHROOM_BROWN.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getStrippedLog(), TinkerWorld.bloodshroom.getSlab());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_BLOODSHROOM_GREEN.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getStrippedLog(), TinkerWorld.bloodshroom.getSlab());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_BLOODSHROOM_RED.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getStrippedLog(), TinkerWorld.bloodshroom.getSlab());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_BLOODSHROOM_BLACK.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getStrippedLog(), TinkerWorld.bloodshroom.getSlab());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_ENDERBARK.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getStrippedLog(), TinkerWorld.enderbark.getSlab());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_ENDERBARK_WHITE.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getStrippedLog(), TinkerWorld.enderbark.getSlab());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_ENDERBARK_ORANGE.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getStrippedLog(), TinkerWorld.enderbark.getSlab());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_ENDERBARK_MAGENTA.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getStrippedLog(), TinkerWorld.enderbark.getSlab());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_ENDERBARK_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getStrippedLog(), TinkerWorld.enderbark.getSlab());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_ENDERBARK_YELLOW.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getStrippedLog(), TinkerWorld.enderbark.getSlab());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_ENDERBARK_LIME.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getStrippedLog(), TinkerWorld.enderbark.getSlab());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_ENDERBARK_PINK.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getStrippedLog(), TinkerWorld.enderbark.getSlab());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_ENDERBARK_GRAY.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getStrippedLog(), TinkerWorld.enderbark.getSlab());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_ENDERBARK_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getStrippedLog(), TinkerWorld.enderbark.getSlab());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_ENDERBARK_CYAN.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getStrippedLog(), TinkerWorld.enderbark.getSlab());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_ENDERBARK_PURPLE.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getStrippedLog(), TinkerWorld.enderbark.getSlab());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_ENDERBARK_BLUE.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getStrippedLog(), TinkerWorld.enderbark.getSlab());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_ENDERBARK_BROWN.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getStrippedLog(), TinkerWorld.enderbark.getSlab());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_ENDERBARK_GREEN.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getStrippedLog(), TinkerWorld.enderbark.getSlab());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_ENDERBARK_RED.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getStrippedLog(), TinkerWorld.enderbark.getSlab());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_ENDERBARK_BLACK.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getStrippedLog(), TinkerWorld.enderbark.getSlab());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_GREENHEART.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getStrippedLog(), TinkerWorld.greenheart.getSlab());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_GREENHEART_WHITE.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getStrippedLog(), TinkerWorld.greenheart.getSlab());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_GREENHEART_ORANGE.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getStrippedLog(), TinkerWorld.greenheart.getSlab());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_GREENHEART_MAGENTA.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getStrippedLog(), TinkerWorld.greenheart.getSlab());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_GREENHEART_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getStrippedLog(), TinkerWorld.greenheart.getSlab());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_GREENHEART_YELLOW.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getStrippedLog(), TinkerWorld.greenheart.getSlab());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_GREENHEART_LIME.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getStrippedLog(), TinkerWorld.greenheart.getSlab());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_GREENHEART_PINK.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getStrippedLog(), TinkerWorld.greenheart.getSlab());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_GREENHEART_GRAY.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getStrippedLog(), TinkerWorld.greenheart.getSlab());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_GREENHEART_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getStrippedLog(), TinkerWorld.greenheart.getSlab());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_GREENHEART_CYAN.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getStrippedLog(), TinkerWorld.greenheart.getSlab());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_GREENHEART_PURPLE.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getStrippedLog(), TinkerWorld.greenheart.getSlab());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_GREENHEART_BLUE.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getStrippedLog(), TinkerWorld.greenheart.getSlab());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_GREENHEART_BROWN.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getStrippedLog(), TinkerWorld.greenheart.getSlab());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_GREENHEART_GREEN.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getStrippedLog(), TinkerWorld.greenheart.getSlab());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_GREENHEART_RED.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getStrippedLog(), TinkerWorld.greenheart.getSlab());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_GREENHEART_BLACK.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getStrippedLog(), TinkerWorld.greenheart.getSlab());

        chairRecipe(consumer, null,TBABlocks.DESK_CHAIR_TINKER_SKYROOT.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getStrippedLog(), TinkerWorld.skyroot.getSlab());
        chairRecipe(consumer, DyeColor.WHITE,TBABlocks.DESK_CHAIR_TINKER_SKYROOT_WHITE.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getStrippedLog(), TinkerWorld.skyroot.getSlab());
        chairRecipe(consumer, DyeColor.ORANGE,TBABlocks.DESK_CHAIR_TINKER_SKYROOT_ORANGE.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getStrippedLog(), TinkerWorld.skyroot.getSlab());
        chairRecipe(consumer, DyeColor.MAGENTA,TBABlocks.DESK_CHAIR_TINKER_SKYROOT_MAGENTA.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getStrippedLog(), TinkerWorld.skyroot.getSlab());
        chairRecipe(consumer, DyeColor.LIGHT_BLUE,TBABlocks.DESK_CHAIR_TINKER_SKYROOT_LIGHT_BLUE.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getStrippedLog(), TinkerWorld.skyroot.getSlab());
        chairRecipe(consumer, DyeColor.YELLOW,TBABlocks.DESK_CHAIR_TINKER_SKYROOT_YELLOW.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getStrippedLog(), TinkerWorld.skyroot.getSlab());
        chairRecipe(consumer, DyeColor.LIME,TBABlocks.DESK_CHAIR_TINKER_SKYROOT_LIME.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getStrippedLog(), TinkerWorld.skyroot.getSlab());
        chairRecipe(consumer, DyeColor.PINK,TBABlocks.DESK_CHAIR_TINKER_SKYROOT_PINK.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getStrippedLog(), TinkerWorld.skyroot.getSlab());
        chairRecipe(consumer, DyeColor.GRAY,TBABlocks.DESK_CHAIR_TINKER_SKYROOT_GRAY.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getStrippedLog(), TinkerWorld.skyroot.getSlab());
        chairRecipe(consumer, DyeColor.LIGHT_GRAY,TBABlocks.DESK_CHAIR_TINKER_SKYROOT_LIGHT_GRAY.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getStrippedLog(), TinkerWorld.skyroot.getSlab());
        chairRecipe(consumer, DyeColor.CYAN,TBABlocks.DESK_CHAIR_TINKER_SKYROOT_CYAN.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getStrippedLog(), TinkerWorld.skyroot.getSlab());
        chairRecipe(consumer, DyeColor.PURPLE,TBABlocks.DESK_CHAIR_TINKER_SKYROOT_PURPLE.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getStrippedLog(), TinkerWorld.skyroot.getSlab());
        chairRecipe(consumer, DyeColor.BLUE,TBABlocks.DESK_CHAIR_TINKER_SKYROOT_BLUE.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getStrippedLog(), TinkerWorld.skyroot.getSlab());
        chairRecipe(consumer, DyeColor.BROWN,TBABlocks.DESK_CHAIR_TINKER_SKYROOT_BROWN.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getStrippedLog(), TinkerWorld.skyroot.getSlab());
        chairRecipe(consumer, DyeColor.GREEN,TBABlocks.DESK_CHAIR_TINKER_SKYROOT_GREEN.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getStrippedLog(), TinkerWorld.skyroot.getSlab());
        chairRecipe(consumer, DyeColor.RED,TBABlocks.DESK_CHAIR_TINKER_SKYROOT_RED.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getStrippedLog(), TinkerWorld.skyroot.getSlab());
        chairRecipe(consumer, DyeColor.BLACK,TBABlocks.DESK_CHAIR_TINKER_SKYROOT_BLACK.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getStrippedLog(), TinkerWorld.skyroot.getSlab());

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

        benchRecipe(consumer, TBABlocks.PARK_BENCH_BLOODSHROOM.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getSlab());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_BLOODSHROOM.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.get(), TinkerWorld.bloodshroom.getSlab());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_BLOODSHROOM.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_BLOODSHROOM.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getSlab());
        tableRecipe(consumer, TBABlocks.TABLE_BLOODSHROOM.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getStrippedLog(), TinkerWorld.bloodshroom.getSlab());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_BLOODSHROOM.get().asItem().getDefaultInstance(),
                TinkerWorld.bloodshroom.getLog(), TinkerWorld.bloodshroom.getStrippedLog(), TinkerWorld.bloodshroom.getSlab());

        benchRecipe(consumer, TBABlocks.PARK_BENCH_ENDERBARK.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getSlab());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_ENDERBARK.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.get(), TinkerWorld.enderbark.getSlab());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_ENDERBARK.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_ENDERBARK.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getSlab());
        tableRecipe(consumer, TBABlocks.TABLE_ENDERBARK.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getStrippedLog(), TinkerWorld.enderbark.getSlab());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_ENDERBARK.get().asItem().getDefaultInstance(),
                TinkerWorld.enderbark.getLog(), TinkerWorld.enderbark.getStrippedLog(), TinkerWorld.enderbark.getSlab());

        benchRecipe(consumer, TBABlocks.PARK_BENCH_GREENHEART.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getSlab());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_GREENHEART.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.get(), TinkerWorld.greenheart.getSlab());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_GREENHEART.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_GREENHEART.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getSlab());
        tableRecipe(consumer, TBABlocks.TABLE_GREENHEART.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getStrippedLog(), TinkerWorld.greenheart.getSlab());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_GREENHEART.get().asItem().getDefaultInstance(),
                TinkerWorld.greenheart.getLog(), TinkerWorld.greenheart.getStrippedLog(), TinkerWorld.greenheart.getSlab());

        benchRecipe(consumer, TBABlocks.PARK_BENCH_TINKER_SKYROOT.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getSlab());
        deskRecipe(consumer, TBABlocks.SCHOOL_DESK_TINKER_SKYROOT.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.get(), TinkerWorld.skyroot.getSlab());
        deskCabinetRecipe(consumer, TBABlocks.SCHOOL_DESK_CABINET_TINKER_SKYROOT.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.get());
        lockerRecipe(consumer, TBABlocks.LOCKER_TINKER_SKYROOT.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getSlab());
        tableRecipe(consumer, TBABlocks.TABLE_TINKER_SKYROOT.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getStrippedLog(), TinkerWorld.skyroot.getSlab());
        bookcaseRecipe(consumer, TBABlocks.BOOKCASE_TINKER_SKYROOT.get().asItem().getDefaultInstance(),
                TinkerWorld.skyroot.getLog(), TinkerWorld.skyroot.getStrippedLog(), TinkerWorld.skyroot.getSlab());

        basketRecipe(consumer, TBABlocks.BASKET_OAK_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, Items.OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_OAK_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, Items.OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_OAK_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, Items.OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_OAK_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, Items.OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_OAK_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, Items.OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_OAK_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, Items.OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_OAK_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, Items.OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_OAK_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, Items.OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_OAK_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, Items.OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_OAK_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, Items.OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_OAK_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, Items.OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_OAK_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, Items.OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_OAK_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, Items.OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_OAK_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, Items.OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_OAK_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, Items.OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_OAK_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, Items.OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_BIRCH_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, Items.BIRCH_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_BIRCH_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, Items.BIRCH_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_BIRCH_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, Items.BIRCH_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_BIRCH_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, Items.BIRCH_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_BIRCH_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, Items.BIRCH_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_BIRCH_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, Items.BIRCH_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_BIRCH_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, Items.BIRCH_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_BIRCH_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, Items.BIRCH_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_BIRCH_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, Items.BIRCH_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_BIRCH_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, Items.BIRCH_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_BIRCH_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, Items.BIRCH_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_BIRCH_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, Items.BIRCH_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_BIRCH_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, Items.BIRCH_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_BIRCH_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, Items.BIRCH_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_BIRCH_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, Items.BIRCH_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_BIRCH_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, Items.BIRCH_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_SPRUCE_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, Items.SPRUCE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_SPRUCE_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, Items.SPRUCE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_SPRUCE_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, Items.SPRUCE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_SPRUCE_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, Items.SPRUCE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_SPRUCE_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, Items.SPRUCE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_SPRUCE_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, Items.SPRUCE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_SPRUCE_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, Items.SPRUCE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_SPRUCE_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, Items.SPRUCE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_SPRUCE_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, Items.SPRUCE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_SPRUCE_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, Items.SPRUCE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_SPRUCE_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, Items.SPRUCE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_SPRUCE_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, Items.SPRUCE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_SPRUCE_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, Items.SPRUCE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_SPRUCE_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, Items.SPRUCE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_SPRUCE_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, Items.SPRUCE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_SPRUCE_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, Items.SPRUCE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_JUNGLE_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, Items.JUNGLE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_JUNGLE_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, Items.JUNGLE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_JUNGLE_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, Items.JUNGLE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_JUNGLE_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, Items.JUNGLE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_JUNGLE_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, Items.JUNGLE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_JUNGLE_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, Items.JUNGLE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_JUNGLE_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, Items.JUNGLE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_JUNGLE_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, Items.JUNGLE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_JUNGLE_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, Items.JUNGLE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_JUNGLE_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, Items.JUNGLE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_JUNGLE_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, Items.JUNGLE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_JUNGLE_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, Items.JUNGLE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_JUNGLE_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, Items.JUNGLE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_JUNGLE_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, Items.JUNGLE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_JUNGLE_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, Items.JUNGLE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_JUNGLE_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, Items.JUNGLE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_ACACIA_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, Items.ACACIA_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_ACACIA_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, Items.ACACIA_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_ACACIA_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, Items.ACACIA_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_ACACIA_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, Items.ACACIA_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_ACACIA_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, Items.ACACIA_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_ACACIA_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, Items.ACACIA_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_ACACIA_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, Items.ACACIA_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_ACACIA_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, Items.ACACIA_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_ACACIA_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, Items.ACACIA_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_ACACIA_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, Items.ACACIA_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_ACACIA_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, Items.ACACIA_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_ACACIA_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, Items.ACACIA_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_ACACIA_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, Items.ACACIA_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_ACACIA_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, Items.ACACIA_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_ACACIA_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, Items.ACACIA_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_ACACIA_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, Items.ACACIA_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_DARK_OAK_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, Items.DARK_OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_DARK_OAK_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, Items.DARK_OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_DARK_OAK_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, Items.DARK_OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_DARK_OAK_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, Items.DARK_OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_DARK_OAK_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, Items.DARK_OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_DARK_OAK_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, Items.DARK_OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_DARK_OAK_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, Items.DARK_OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_DARK_OAK_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, Items.DARK_OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_DARK_OAK_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, Items.DARK_OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_DARK_OAK_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, Items.DARK_OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_DARK_OAK_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, Items.DARK_OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_DARK_OAK_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, Items.DARK_OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_DARK_OAK_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, Items.DARK_OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_DARK_OAK_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, Items.DARK_OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_DARK_OAK_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, Items.DARK_OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_DARK_OAK_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, Items.DARK_OAK_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_MANGROVE_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, Items.MANGROVE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_MANGROVE_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, Items.MANGROVE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_MANGROVE_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, Items.MANGROVE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_MANGROVE_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, Items.MANGROVE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_MANGROVE_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, Items.MANGROVE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_MANGROVE_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, Items.MANGROVE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_MANGROVE_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, Items.MANGROVE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_MANGROVE_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, Items.MANGROVE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_MANGROVE_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, Items.MANGROVE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_MANGROVE_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, Items.MANGROVE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_MANGROVE_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, Items.MANGROVE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_MANGROVE_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, Items.MANGROVE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_MANGROVE_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, Items.MANGROVE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_MANGROVE_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, Items.MANGROVE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_MANGROVE_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, Items.MANGROVE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_MANGROVE_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, Items.MANGROVE_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_CRIMSON_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, Items.CRIMSON_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_CRIMSON_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, Items.CRIMSON_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_CRIMSON_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, Items.CRIMSON_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_CRIMSON_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, Items.CRIMSON_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_CRIMSON_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, Items.CRIMSON_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_CRIMSON_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, Items.CRIMSON_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_CRIMSON_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, Items.CRIMSON_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_CRIMSON_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, Items.CRIMSON_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_CRIMSON_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, Items.CRIMSON_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_CRIMSON_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, Items.CRIMSON_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_CRIMSON_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, Items.CRIMSON_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_CRIMSON_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, Items.CRIMSON_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_CRIMSON_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, Items.CRIMSON_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_CRIMSON_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, Items.CRIMSON_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_CRIMSON_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, Items.CRIMSON_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_CRIMSON_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, Items.CRIMSON_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_WARPED_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, Items.WARPED_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_WARPED_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, Items.WARPED_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_WARPED_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, Items.WARPED_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_WARPED_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, Items.WARPED_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_WARPED_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, Items.WARPED_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_WARPED_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, Items.WARPED_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_WARPED_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, Items.WARPED_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_WARPED_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, Items.WARPED_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_WARPED_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, Items.WARPED_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_WARPED_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, Items.WARPED_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_WARPED_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, Items.WARPED_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_WARPED_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, Items.WARPED_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_WARPED_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, Items.WARPED_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_WARPED_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, Items.WARPED_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_WARPED_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, Items.WARPED_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_WARPED_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, Items.WARPED_SLAB);
        basketRecipe(consumer, TBABlocks.BASKET_FIR_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, BOPBlocks.FIR_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FIR_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, BOPBlocks.FIR_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FIR_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, BOPBlocks.FIR_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FIR_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, BOPBlocks.FIR_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FIR_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, BOPBlocks.FIR_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FIR_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, BOPBlocks.FIR_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FIR_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, BOPBlocks.FIR_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FIR_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, BOPBlocks.FIR_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FIR_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, BOPBlocks.FIR_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FIR_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, BOPBlocks.FIR_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FIR_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, BOPBlocks.FIR_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FIR_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, BOPBlocks.FIR_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FIR_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, BOPBlocks.FIR_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FIR_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, BOPBlocks.FIR_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FIR_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, BOPBlocks.FIR_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FIR_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, BOPBlocks.FIR_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_REDWOOD_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, BOPBlocks.REDWOOD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_REDWOOD_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, BOPBlocks.REDWOOD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_REDWOOD_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, BOPBlocks.REDWOOD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_REDWOOD_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, BOPBlocks.REDWOOD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_REDWOOD_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, BOPBlocks.REDWOOD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_REDWOOD_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, BOPBlocks.REDWOOD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_REDWOOD_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, BOPBlocks.REDWOOD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_REDWOOD_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, BOPBlocks.REDWOOD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_REDWOOD_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, BOPBlocks.REDWOOD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_REDWOOD_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, BOPBlocks.REDWOOD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_REDWOOD_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, BOPBlocks.REDWOOD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_REDWOOD_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, BOPBlocks.REDWOOD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_REDWOOD_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, BOPBlocks.REDWOOD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_REDWOOD_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, BOPBlocks.REDWOOD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_REDWOOD_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, BOPBlocks.REDWOOD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_REDWOOD_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, BOPBlocks.REDWOOD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHERRY_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, BOPBlocks.CHERRY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHERRY_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, BOPBlocks.CHERRY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHERRY_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, BOPBlocks.CHERRY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHERRY_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, BOPBlocks.CHERRY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHERRY_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, BOPBlocks.CHERRY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHERRY_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, BOPBlocks.CHERRY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHERRY_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, BOPBlocks.CHERRY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHERRY_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, BOPBlocks.CHERRY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHERRY_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, BOPBlocks.CHERRY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHERRY_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, BOPBlocks.CHERRY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHERRY_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, BOPBlocks.CHERRY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHERRY_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, BOPBlocks.CHERRY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHERRY_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, BOPBlocks.CHERRY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHERRY_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, BOPBlocks.CHERRY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHERRY_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, BOPBlocks.CHERRY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHERRY_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, BOPBlocks.CHERRY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAHOGANY_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, BOPBlocks.MAHOGANY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAHOGANY_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, BOPBlocks.MAHOGANY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAHOGANY_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, BOPBlocks.MAHOGANY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAHOGANY_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, BOPBlocks.MAHOGANY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAHOGANY_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, BOPBlocks.MAHOGANY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAHOGANY_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, BOPBlocks.MAHOGANY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAHOGANY_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, BOPBlocks.MAHOGANY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAHOGANY_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, BOPBlocks.MAHOGANY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAHOGANY_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, BOPBlocks.MAHOGANY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAHOGANY_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, BOPBlocks.MAHOGANY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAHOGANY_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, BOPBlocks.MAHOGANY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAHOGANY_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, BOPBlocks.MAHOGANY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAHOGANY_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, BOPBlocks.MAHOGANY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAHOGANY_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, BOPBlocks.MAHOGANY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAHOGANY_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, BOPBlocks.MAHOGANY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAHOGANY_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, BOPBlocks.MAHOGANY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_JACARANDA_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, BOPBlocks.JACARANDA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_JACARANDA_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, BOPBlocks.JACARANDA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_JACARANDA_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, BOPBlocks.JACARANDA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_JACARANDA_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, BOPBlocks.JACARANDA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_JACARANDA_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, BOPBlocks.JACARANDA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_JACARANDA_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, BOPBlocks.JACARANDA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_JACARANDA_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, BOPBlocks.JACARANDA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_JACARANDA_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, BOPBlocks.JACARANDA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_JACARANDA_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, BOPBlocks.JACARANDA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_JACARANDA_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, BOPBlocks.JACARANDA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_JACARANDA_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, BOPBlocks.JACARANDA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_JACARANDA_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, BOPBlocks.JACARANDA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_JACARANDA_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, BOPBlocks.JACARANDA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_JACARANDA_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, BOPBlocks.JACARANDA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_JACARANDA_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, BOPBlocks.JACARANDA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_JACARANDA_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, BOPBlocks.JACARANDA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PALM_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, BOPBlocks.PALM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PALM_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, BOPBlocks.PALM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PALM_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, BOPBlocks.PALM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PALM_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, BOPBlocks.PALM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PALM_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, BOPBlocks.PALM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PALM_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, BOPBlocks.PALM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PALM_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, BOPBlocks.PALM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PALM_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, BOPBlocks.PALM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PALM_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, BOPBlocks.PALM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PALM_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, BOPBlocks.PALM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PALM_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, BOPBlocks.PALM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PALM_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, BOPBlocks.PALM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PALM_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, BOPBlocks.PALM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PALM_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, BOPBlocks.PALM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PALM_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, BOPBlocks.PALM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PALM_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, BOPBlocks.PALM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WILLOW_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, BOPBlocks.WILLOW_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WILLOW_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, BOPBlocks.WILLOW_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WILLOW_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, BOPBlocks.WILLOW_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WILLOW_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, BOPBlocks.WILLOW_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WILLOW_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, BOPBlocks.WILLOW_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WILLOW_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, BOPBlocks.WILLOW_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WILLOW_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, BOPBlocks.WILLOW_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WILLOW_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, BOPBlocks.WILLOW_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WILLOW_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, BOPBlocks.WILLOW_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WILLOW_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, BOPBlocks.WILLOW_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WILLOW_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, BOPBlocks.WILLOW_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WILLOW_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, BOPBlocks.WILLOW_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WILLOW_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, BOPBlocks.WILLOW_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WILLOW_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, BOPBlocks.WILLOW_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WILLOW_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, BOPBlocks.WILLOW_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WILLOW_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, BOPBlocks.WILLOW_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_DEAD_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, BOPBlocks.DEAD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_DEAD_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, BOPBlocks.DEAD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_DEAD_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, BOPBlocks.DEAD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_DEAD_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, BOPBlocks.DEAD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_DEAD_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, BOPBlocks.DEAD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_DEAD_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, BOPBlocks.DEAD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_DEAD_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, BOPBlocks.DEAD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_DEAD_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, BOPBlocks.DEAD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_DEAD_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, BOPBlocks.DEAD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_DEAD_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, BOPBlocks.DEAD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_DEAD_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, BOPBlocks.DEAD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_DEAD_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, BOPBlocks.DEAD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_DEAD_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, BOPBlocks.DEAD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_DEAD_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, BOPBlocks.DEAD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_DEAD_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, BOPBlocks.DEAD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_DEAD_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, BOPBlocks.DEAD_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAGIC_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, BOPBlocks.MAGIC_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAGIC_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, BOPBlocks.MAGIC_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAGIC_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, BOPBlocks.MAGIC_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAGIC_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, BOPBlocks.MAGIC_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAGIC_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, BOPBlocks.MAGIC_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAGIC_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, BOPBlocks.MAGIC_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAGIC_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, BOPBlocks.MAGIC_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAGIC_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, BOPBlocks.MAGIC_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAGIC_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, BOPBlocks.MAGIC_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAGIC_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, BOPBlocks.MAGIC_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAGIC_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, BOPBlocks.MAGIC_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAGIC_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, BOPBlocks.MAGIC_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAGIC_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, BOPBlocks.MAGIC_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAGIC_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, BOPBlocks.MAGIC_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAGIC_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, BOPBlocks.MAGIC_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_MAGIC_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, BOPBlocks.MAGIC_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_UMBRAN_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, BOPBlocks.UMBRAN_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_UMBRAN_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, BOPBlocks.UMBRAN_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_UMBRAN_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, BOPBlocks.UMBRAN_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_UMBRAN_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, BOPBlocks.UMBRAN_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_UMBRAN_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, BOPBlocks.UMBRAN_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_UMBRAN_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, BOPBlocks.UMBRAN_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_UMBRAN_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, BOPBlocks.UMBRAN_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_UMBRAN_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, BOPBlocks.UMBRAN_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_UMBRAN_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, BOPBlocks.UMBRAN_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_UMBRAN_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, BOPBlocks.UMBRAN_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_UMBRAN_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, BOPBlocks.UMBRAN_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_UMBRAN_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, BOPBlocks.UMBRAN_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_UMBRAN_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, BOPBlocks.UMBRAN_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_UMBRAN_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, BOPBlocks.UMBRAN_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_UMBRAN_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, BOPBlocks.UMBRAN_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_UMBRAN_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, BOPBlocks.UMBRAN_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_HELLBARK_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, BOPBlocks.HELLBARK_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_HELLBARK_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, BOPBlocks.HELLBARK_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_HELLBARK_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, BOPBlocks.HELLBARK_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_HELLBARK_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, BOPBlocks.HELLBARK_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_HELLBARK_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, BOPBlocks.HELLBARK_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_HELLBARK_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, BOPBlocks.HELLBARK_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_HELLBARK_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, BOPBlocks.HELLBARK_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_HELLBARK_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, BOPBlocks.HELLBARK_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_HELLBARK_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, BOPBlocks.HELLBARK_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_HELLBARK_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, BOPBlocks.HELLBARK_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_HELLBARK_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, BOPBlocks.HELLBARK_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_HELLBARK_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, BOPBlocks.HELLBARK_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_HELLBARK_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, BOPBlocks.HELLBARK_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_HELLBARK_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, BOPBlocks.HELLBARK_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_HELLBARK_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, BOPBlocks.HELLBARK_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_HELLBARK_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, BOPBlocks.HELLBARK_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_COCONUT_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_COCONUT_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_COCONUT_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_COCONUT_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_COCONUT_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_COCONUT_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_COCONUT_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_COCONUT_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_COCONUT_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_COCONUT_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_COCONUT_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_COCONUT_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_COCONUT_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_COCONUT_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_COCONUT_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_COCONUT_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, samebutdifferent.ecologics.registry.ModBlocks.COCONUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WALNUT_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WALNUT_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WALNUT_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WALNUT_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WALNUT_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WALNUT_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WALNUT_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WALNUT_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WALNUT_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WALNUT_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WALNUT_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WALNUT_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WALNUT_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WALNUT_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WALNUT_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_WALNUT_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, samebutdifferent.ecologics.registry.ModBlocks.WALNUT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AZALEA_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AZALEA_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AZALEA_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AZALEA_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AZALEA_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AZALEA_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AZALEA_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AZALEA_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AZALEA_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AZALEA_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AZALEA_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AZALEA_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AZALEA_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AZALEA_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AZALEA_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AZALEA_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, samebutdifferent.ecologics.registry.ModBlocks.AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FLOWERING_AZALEA_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FLOWERING_AZALEA_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FLOWERING_AZALEA_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FLOWERING_AZALEA_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FLOWERING_AZALEA_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FLOWERING_AZALEA_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FLOWERING_AZALEA_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FLOWERING_AZALEA_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FLOWERING_AZALEA_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FLOWERING_AZALEA_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FLOWERING_AZALEA_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FLOWERING_AZALEA_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FLOWERING_AZALEA_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FLOWERING_AZALEA_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FLOWERING_AZALEA_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_FLOWERING_AZALEA_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, samebutdifferent.ecologics.registry.ModBlocks.FLOWERING_AZALEA_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AETHER_SKYROOT_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, AetherBlocks.SKYROOT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AETHER_SKYROOT_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, AetherBlocks.SKYROOT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AETHER_SKYROOT_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, AetherBlocks.SKYROOT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AETHER_SKYROOT_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, AetherBlocks.SKYROOT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AETHER_SKYROOT_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, AetherBlocks.SKYROOT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AETHER_SKYROOT_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, AetherBlocks.SKYROOT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AETHER_SKYROOT_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, AetherBlocks.SKYROOT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AETHER_SKYROOT_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, AetherBlocks.SKYROOT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AETHER_SKYROOT_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, AetherBlocks.SKYROOT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AETHER_SKYROOT_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, AetherBlocks.SKYROOT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AETHER_SKYROOT_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, AetherBlocks.SKYROOT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AETHER_SKYROOT_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, AetherBlocks.SKYROOT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AETHER_SKYROOT_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, AetherBlocks.SKYROOT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AETHER_SKYROOT_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, AetherBlocks.SKYROOT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AETHER_SKYROOT_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, AetherBlocks.SKYROOT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_AETHER_SKYROOT_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, AetherBlocks.SKYROOT_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PREAM_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, PhantasmModBlocks.PREAM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PREAM_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, PhantasmModBlocks.PREAM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PREAM_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, PhantasmModBlocks.PREAM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PREAM_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, PhantasmModBlocks.PREAM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PREAM_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, PhantasmModBlocks.PREAM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PREAM_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, PhantasmModBlocks.PREAM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PREAM_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, PhantasmModBlocks.PREAM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PREAM_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, PhantasmModBlocks.PREAM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PREAM_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, PhantasmModBlocks.PREAM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PREAM_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, PhantasmModBlocks.PREAM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PREAM_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, PhantasmModBlocks.PREAM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PREAM_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, PhantasmModBlocks.PREAM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PREAM_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, PhantasmModBlocks.PREAM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PREAM_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, PhantasmModBlocks.PREAM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PREAM_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, PhantasmModBlocks.PREAM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_PREAM_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, PhantasmModBlocks.PREAM_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_EBONY_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, PhantasmModBlocks.EBONY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_EBONY_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, PhantasmModBlocks.EBONY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_EBONY_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, PhantasmModBlocks.EBONY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_EBONY_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, PhantasmModBlocks.EBONY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_EBONY_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, PhantasmModBlocks.EBONY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_EBONY_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, PhantasmModBlocks.EBONY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_EBONY_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, PhantasmModBlocks.EBONY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_EBONY_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, PhantasmModBlocks.EBONY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_EBONY_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, PhantasmModBlocks.EBONY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_EBONY_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, PhantasmModBlocks.EBONY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_EBONY_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, PhantasmModBlocks.EBONY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_EBONY_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, PhantasmModBlocks.EBONY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_EBONY_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, PhantasmModBlocks.EBONY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_EBONY_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, PhantasmModBlocks.EBONY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_EBONY_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, PhantasmModBlocks.EBONY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_EBONY_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, PhantasmModBlocks.EBONY_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHORUS_NEST_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHORUS_NEST_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHORUS_NEST_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHORUS_NEST_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHORUS_NEST_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHORUS_NEST_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHORUS_NEST_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHORUS_NEST_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHORUS_NEST_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHORUS_NEST_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHORUS_NEST_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHORUS_NEST_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHORUS_NEST_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHORUS_NEST_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHORUS_NEST_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_CHORUS_NEST_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, UnusualendModBlocks.CHORUS_NEST_SLAB.get());
        basketRecipe(consumer, TBABlocks.BASKET_BLOODSHROOM_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, TinkerWorld.bloodshroom.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_BLOODSHROOM_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, TinkerWorld.bloodshroom.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_BLOODSHROOM_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, TinkerWorld.bloodshroom.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_BLOODSHROOM_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, TinkerWorld.bloodshroom.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_BLOODSHROOM_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, TinkerWorld.bloodshroom.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_BLOODSHROOM_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, TinkerWorld.bloodshroom.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_BLOODSHROOM_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, TinkerWorld.bloodshroom.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_BLOODSHROOM_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, TinkerWorld.bloodshroom.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_BLOODSHROOM_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, TinkerWorld.bloodshroom.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_BLOODSHROOM_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, TinkerWorld.bloodshroom.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_BLOODSHROOM_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, TinkerWorld.bloodshroom.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_BLOODSHROOM_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, TinkerWorld.bloodshroom.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_BLOODSHROOM_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, TinkerWorld.bloodshroom.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_BLOODSHROOM_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, TinkerWorld.bloodshroom.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_BLOODSHROOM_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, TinkerWorld.bloodshroom.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_BLOODSHROOM_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, TinkerWorld.bloodshroom.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_ENDERBARK_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, TinkerWorld.enderbark.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_ENDERBARK_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, TinkerWorld.enderbark.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_ENDERBARK_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, TinkerWorld.enderbark.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_ENDERBARK_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, TinkerWorld.enderbark.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_ENDERBARK_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, TinkerWorld.enderbark.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_ENDERBARK_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, TinkerWorld.enderbark.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_ENDERBARK_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, TinkerWorld.enderbark.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_ENDERBARK_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, TinkerWorld.enderbark.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_ENDERBARK_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, TinkerWorld.enderbark.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_ENDERBARK_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, TinkerWorld.enderbark.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_ENDERBARK_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, TinkerWorld.enderbark.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_ENDERBARK_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, TinkerWorld.enderbark.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_ENDERBARK_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, TinkerWorld.enderbark.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_ENDERBARK_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, TinkerWorld.enderbark.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_ENDERBARK_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, TinkerWorld.enderbark.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_ENDERBARK_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, TinkerWorld.enderbark.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_GREENHEART_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, TinkerWorld.greenheart.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_GREENHEART_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, TinkerWorld.greenheart.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_GREENHEART_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, TinkerWorld.greenheart.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_GREENHEART_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, TinkerWorld.greenheart.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_GREENHEART_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, TinkerWorld.greenheart.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_GREENHEART_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, TinkerWorld.greenheart.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_GREENHEART_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, TinkerWorld.greenheart.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_GREENHEART_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, TinkerWorld.greenheart.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_GREENHEART_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, TinkerWorld.greenheart.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_GREENHEART_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, TinkerWorld.greenheart.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_GREENHEART_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, TinkerWorld.greenheart.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_GREENHEART_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, TinkerWorld.greenheart.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_GREENHEART_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, TinkerWorld.greenheart.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_GREENHEART_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, TinkerWorld.greenheart.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_GREENHEART_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, TinkerWorld.greenheart.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_GREENHEART_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, TinkerWorld.greenheart.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_TINKER_SKYROOT_WHITE.get().asItem().getDefaultInstance(), Items.WHITE_CARPET, TinkerWorld.skyroot.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_TINKER_SKYROOT_LIGHT_GRAY.get().asItem().getDefaultInstance(), Items.LIGHT_GRAY_CARPET, TinkerWorld.skyroot.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_TINKER_SKYROOT_GRAY.get().asItem().getDefaultInstance(), Items.GRAY_CARPET, TinkerWorld.skyroot.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_TINKER_SKYROOT_BLACK.get().asItem().getDefaultInstance(), Items.BLACK_CARPET, TinkerWorld.skyroot.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_TINKER_SKYROOT_BROWN.get().asItem().getDefaultInstance(), Items.BROWN_CARPET, TinkerWorld.skyroot.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_TINKER_SKYROOT_RED.get().asItem().getDefaultInstance(), Items.RED_CARPET, TinkerWorld.skyroot.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_TINKER_SKYROOT_ORANGE.get().asItem().getDefaultInstance(), Items.ORANGE_CARPET, TinkerWorld.skyroot.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_TINKER_SKYROOT_YELLOW.get().asItem().getDefaultInstance(), Items.YELLOW_CARPET, TinkerWorld.skyroot.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_TINKER_SKYROOT_LIME.get().asItem().getDefaultInstance(), Items.LIME_CARPET, TinkerWorld.skyroot.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_TINKER_SKYROOT_GREEN.get().asItem().getDefaultInstance(), Items.GREEN_CARPET, TinkerWorld.skyroot.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_TINKER_SKYROOT_CYAN.get().asItem().getDefaultInstance(), Items.CYAN_CARPET, TinkerWorld.skyroot.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_TINKER_SKYROOT_LIGHT_BLUE.get().asItem().getDefaultInstance(), Items.LIGHT_BLUE_CARPET, TinkerWorld.skyroot.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_TINKER_SKYROOT_BLUE.get().asItem().getDefaultInstance(), Items.BLUE_CARPET, TinkerWorld.skyroot.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_TINKER_SKYROOT_PURPLE.get().asItem().getDefaultInstance(), Items.PURPLE_CARPET, TinkerWorld.skyroot.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_TINKER_SKYROOT_MAGENTA.get().asItem().getDefaultInstance(), Items.MAGENTA_CARPET, TinkerWorld.skyroot.getSlab());
        basketRecipe(consumer, TBABlocks.BASKET_TINKER_SKYROOT_PINK.get().asItem().getDefaultInstance(), Items.PINK_CARPET, TinkerWorld.skyroot.getSlab());
    }

    private void plateRecipe(Consumer<FinishedRecipe> consumer, @NotNull ItemStack result, Item ingredient) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), result.getItem(), 4)
                .unlockedBy("has_terracotta",
                        has(ItemTags.TERRACOTTA))
                .save(consumer, new ResourceLocation(MODID, "plates/" + result.getItem()));
    }

    private void basketRecipe(Consumer<FinishedRecipe> consumer, @NotNull ItemStack result, ItemLike carpet, ItemLike slab) {
        ShapedRecipeBuilder.shaped(result.getItem(), 1)
                .group("baskets")
                .pattern("###")
                .pattern("SCS")
                .pattern("SSS")
                .define('#', Ingredient.of(TBATags.Items.STICKS))
                .define('C', Ingredient.of(carpet))
                .define('S', Ingredient.of(slab))
                .unlockedBy("has_logs", has(ItemTags.LOGS))
                .save(consumer, new ResourceLocation(MODID,
                        "baskets/" + result.getItem()));
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

    private void chairRecipe(Consumer<FinishedRecipe> consumer, @Nullable DyeColor color, @NotNull ItemStack result, ItemLike log, ItemLike strippedLog, ItemLike slab) {
        if (color == null) {
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
        else if (color == DyeColor.WHITE) {
            ShapedRecipeBuilder.shaped(result.getItem(), 2)
                    .group("chairs")
                    .pattern("WW#")
                    .pattern("#S#")
                    .pattern("L L")
                    .define('W', Ingredient.of(Items.WHITE_CARPET))
                    .define('#', Ingredient.of(slab))
                    .define('S', Ingredient.of(strippedLog))
                    .define('L', Ingredient.of(log))
                    .unlockedBy("has_log", has(log))
                    .save(consumer, new ResourceLocation(MODID,
                            "chairs/colored/white/" + result.getItem()));
        }
        else if (color == DyeColor.ORANGE) {
            ShapedRecipeBuilder.shaped(result.getItem(), 2)
                    .group("chairs")
                    .pattern("WW#")
                    .pattern("#S#")
                    .pattern("L L")
                    .define('W', Ingredient.of(Items.ORANGE_CARPET))
                    .define('#', Ingredient.of(slab))
                    .define('S', Ingredient.of(strippedLog))
                    .define('L', Ingredient.of(log))
                    .unlockedBy("has_log", has(log))
                    .save(consumer, new ResourceLocation(MODID,
                            "chairs/colored/orange/" + result.getItem()));
        }
        else if (color == DyeColor.MAGENTA) {
            ShapedRecipeBuilder.shaped(result.getItem(), 2)
                    .group("chairs")
                    .pattern("WW#")
                    .pattern("#S#")
                    .pattern("L L")
                    .define('W', Ingredient.of(Items.MAGENTA_CARPET))
                    .define('#', Ingredient.of(slab))
                    .define('S', Ingredient.of(strippedLog))
                    .define('L', Ingredient.of(log))
                    .unlockedBy("has_log", has(log))
                    .save(consumer, new ResourceLocation(MODID,
                            "chairs/colored/magenta/" + result.getItem()));
        }
        else if (color == DyeColor.LIGHT_BLUE) {
            ShapedRecipeBuilder.shaped(result.getItem(), 2)
                    .group("chairs")
                    .pattern("WW#")
                    .pattern("#S#")
                    .pattern("L L")
                    .define('W', Ingredient.of(Items.LIGHT_BLUE_CARPET))
                    .define('#', Ingredient.of(slab))
                    .define('S', Ingredient.of(strippedLog))
                    .define('L', Ingredient.of(log))
                    .unlockedBy("has_log", has(log))
                    .save(consumer, new ResourceLocation(MODID,
                            "chairs/colored/light_blue/" + result.getItem()));
        }
        else if (color == DyeColor.YELLOW) {
            ShapedRecipeBuilder.shaped(result.getItem(), 2)
                    .group("chairs")
                    .pattern("WW#")
                    .pattern("#S#")
                    .pattern("L L")
                    .define('W', Ingredient.of(Items.YELLOW_CARPET))
                    .define('#', Ingredient.of(slab))
                    .define('S', Ingredient.of(strippedLog))
                    .define('L', Ingredient.of(log))
                    .unlockedBy("has_log", has(log))
                    .save(consumer, new ResourceLocation(MODID,
                            "chairs/colored/yellow/" + result.getItem()));
        }
        else if (color == DyeColor.LIME) {
            ShapedRecipeBuilder.shaped(result.getItem(), 2)
                    .group("chairs")
                    .pattern("WW#")
                    .pattern("#S#")
                    .pattern("L L")
                    .define('W', Ingredient.of(Items.LIME_CARPET))
                    .define('#', Ingredient.of(slab))
                    .define('S', Ingredient.of(strippedLog))
                    .define('L', Ingredient.of(log))
                    .unlockedBy("has_log", has(log))
                    .save(consumer, new ResourceLocation(MODID,
                            "chairs/colored/lime/" + result.getItem()));
        }
        else if (color == DyeColor.PINK) {
            ShapedRecipeBuilder.shaped(result.getItem(), 2)
                    .group("chairs")
                    .pattern("WW#")
                    .pattern("#S#")
                    .pattern("L L")
                    .define('W', Ingredient.of(Items.PINK_CARPET))
                    .define('#', Ingredient.of(slab))
                    .define('S', Ingredient.of(strippedLog))
                    .define('L', Ingredient.of(log))
                    .unlockedBy("has_log", has(log))
                    .save(consumer, new ResourceLocation(MODID,
                            "chairs/colored/pink/" + result.getItem()));
        }
        else if (color == DyeColor.GRAY) {
            ShapedRecipeBuilder.shaped(result.getItem(), 2)
                    .group("chairs")
                    .pattern("WW#")
                    .pattern("#S#")
                    .pattern("L L")
                    .define('W', Ingredient.of(Items.GRAY_CARPET))
                    .define('#', Ingredient.of(slab))
                    .define('S', Ingredient.of(strippedLog))
                    .define('L', Ingredient.of(log))
                    .unlockedBy("has_log", has(log))
                    .save(consumer, new ResourceLocation(MODID,
                            "chairs/colored/gray/" + result.getItem()));
        }
        else if (color == DyeColor.LIGHT_GRAY) {
            ShapedRecipeBuilder.shaped(result.getItem(), 2)
                    .group("chairs")
                    .pattern("WW#")
                    .pattern("#S#")
                    .pattern("L L")
                    .define('W', Ingredient.of(Items.LIGHT_GRAY_CARPET))
                    .define('#', Ingredient.of(slab))
                    .define('S', Ingredient.of(strippedLog))
                    .define('L', Ingredient.of(log))
                    .unlockedBy("has_log", has(log))
                    .save(consumer, new ResourceLocation(MODID,
                            "chairs/colored/light_gray/" + result.getItem()));
        }
        else if (color == DyeColor.CYAN) {
            ShapedRecipeBuilder.shaped(result.getItem(), 2)
                    .group("chairs")
                    .pattern("WW#")
                    .pattern("#S#")
                    .pattern("L L")
                    .define('W', Ingredient.of(Items.CYAN_CARPET))
                    .define('#', Ingredient.of(slab))
                    .define('S', Ingredient.of(strippedLog))
                    .define('L', Ingredient.of(log))
                    .unlockedBy("has_log", has(log))
                    .save(consumer, new ResourceLocation(MODID,
                            "chairs/colored/cyan/" + result.getItem()));
        }
        else if (color == DyeColor.PURPLE) {
            ShapedRecipeBuilder.shaped(result.getItem(), 2)
                    .group("chairs")
                    .pattern("WW#")
                    .pattern("#S#")
                    .pattern("L L")
                    .define('W', Ingredient.of(Items.PURPLE_CARPET))
                    .define('#', Ingredient.of(slab))
                    .define('S', Ingredient.of(strippedLog))
                    .define('L', Ingredient.of(log))
                    .unlockedBy("has_log", has(log))
                    .save(consumer, new ResourceLocation(MODID,
                            "chairs/colored/purple/" + result.getItem()));
        }
        else if (color == DyeColor.BLUE) {
            ShapedRecipeBuilder.shaped(result.getItem(), 2)
                    .group("chairs")
                    .pattern("WW#")
                    .pattern("#S#")
                    .pattern("L L")
                    .define('W', Ingredient.of(Items.BLUE_CARPET))
                    .define('#', Ingredient.of(slab))
                    .define('S', Ingredient.of(strippedLog))
                    .define('L', Ingredient.of(log))
                    .unlockedBy("has_log", has(log))
                    .save(consumer, new ResourceLocation(MODID,
                            "chairs/colored/blue/" + result.getItem()));
        }
        else if (color == DyeColor.BROWN) {
            ShapedRecipeBuilder.shaped(result.getItem(), 2)
                    .group("chairs")
                    .pattern("WW#")
                    .pattern("#S#")
                    .pattern("L L")
                    .define('W', Ingredient.of(Items.BROWN_CARPET))
                    .define('#', Ingredient.of(slab))
                    .define('S', Ingredient.of(strippedLog))
                    .define('L', Ingredient.of(log))
                    .unlockedBy("has_log", has(log))
                    .save(consumer, new ResourceLocation(MODID,
                            "chairs/colored/brown/" + result.getItem()));
        }
        else if (color == DyeColor.GREEN) {
            ShapedRecipeBuilder.shaped(result.getItem(), 2)
                    .group("chairs")
                    .pattern("WW#")
                    .pattern("#S#")
                    .pattern("L L")
                    .define('W', Ingredient.of(Items.GREEN_CARPET))
                    .define('#', Ingredient.of(slab))
                    .define('S', Ingredient.of(strippedLog))
                    .define('L', Ingredient.of(log))
                    .unlockedBy("has_log", has(log))
                    .save(consumer, new ResourceLocation(MODID,
                            "chairs/colored/green/" + result.getItem()));
        }
        else if (color == DyeColor.RED) {
            ShapedRecipeBuilder.shaped(result.getItem(), 2)
                    .group("chairs")
                    .pattern("WW#")
                    .pattern("#S#")
                    .pattern("L L")
                    .define('W', Ingredient.of(Items.RED_CARPET))
                    .define('#', Ingredient.of(slab))
                    .define('S', Ingredient.of(strippedLog))
                    .define('L', Ingredient.of(log))
                    .unlockedBy("has_log", has(log))
                    .save(consumer, new ResourceLocation(MODID,
                            "chairs/colored/red/" + result.getItem()));
        }
        else if (color == DyeColor.BLACK) {
            ShapedRecipeBuilder.shaped(result.getItem(), 2)
                    .group("chairs")
                    .pattern("WW#")
                    .pattern("#S#")
                    .pattern("L L")
                    .define('W', Ingredient.of(Items.BLACK_CARPET))
                    .define('#', Ingredient.of(slab))
                    .define('S', Ingredient.of(strippedLog))
                    .define('L', Ingredient.of(log))
                    .unlockedBy("has_log", has(log))
                    .save(consumer, new ResourceLocation(MODID,
                            "chairs/colored/black/" + result.getItem()));
        }
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