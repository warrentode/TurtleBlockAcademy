package com.github.warrentode.turtleblockacademy.datagen.recipes.recipe;

import com.github.warrentode.turtleblockacademy.datagen.recipes.builder.ShapelessRemainderRecipeBuilder;
import com.github.warrentode.turtleblockacademy.items.TBAItems;
import com.github.warrentode.turtleblockacademy.items.food.eastereggs.EasterEggItem;
import com.github.warrentode.turtleblockacademy.items.food.eastereggs.EasterEggProperties;
import com.github.warrentode.turtleblockacademy.util.TBATags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Consumer;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class EasterEggRecipes extends RecipeProvider implements IConditionBuilder {
    public EasterEggRecipes(DataGenerator generator) {
        super(generator);
    }

    private static @NotNull String itemName(Item item) {
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
    }

    private static @Nullable Item getStampItem(@NotNull String eggStamp) {
        return switch (eggStamp) {
            case "creeper" -> TBAItems.EGG_STAMP_CREEPER.get();
            case "flower" -> TBAItems.EGG_STAMP_FLOWER.get();
            // expand as needed
            default -> null;
        };
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        easterEggs(consumer);
    }

    private static void easterEggs(Consumer<FinishedRecipe> consumer) {
        ItemStack stack = ItemStack.EMPTY;
        for (DyeColor baseEggColor : DyeColor.values()) {
            // sets up the blank colored egg result from the Easter Egg Item class
            Item eggItem = EasterEggItem.getBaseEggByColor(baseEggColor).getItem();

            // generate the blank colored egg recipes
            blankColoredEggRecipeTemplate(consumer,eggItem, baseEggColor.getTag());

            for (EasterEggProperties.Layer eggLayer: EasterEggProperties.Layer.values()) {
                for (DyeColor eggLayerColor : DyeColor.values()) {
                    // set up egg layer name from the Easter Egg Properties class
                    String eggLayerName = eggLayer.getLayerName().toLowerCase();

                    // sets up the dye item from the DyeItem class using the egg layer color
                    DyeItem dyeItem = DyeItem.byColor(eggLayerColor);

                    // sets up the stamped colored egg result from the Easter Egg Item class
                    Item stampedEggItem = EasterEggItem.getStampedEggByColor(eggLayer,baseEggColor, eggLayerColor).getItem();

                    // generate the stamped colored egg recipes
                    stampedColoredEggRecipeTemplate(consumer, stampedEggItem, eggItem, eggLayerName, dyeItem);
                }
            }
        }
    }

    private static void blankColoredEggRecipeTemplate(Consumer<FinishedRecipe> consumer, Item coloredEgg, TagKey<Item> dye) {
        // blank colored egg recipes for the crafting table
        ShapelessRecipeBuilder.shapeless(coloredEgg, 6)
                .requires(Ingredient.of(TBATags.Items.BOILED_EGGS), 6)
                .requires(dye)
                .requires(TBAItems.VINEGAR_BOTTLE.get())
                .requires(TBATags.Items.WATER_BUCKETS)
                .unlockedBy("has_boiled_eggs", has(TBATags.Items.BOILED_EGGS))
                .save(consumer, new ResourceLocation(MODID,
                        "easter_eggs/blank/" + coloredEgg.asItem()));
    }

    private static void stampedColoredEggRecipeTemplate(Consumer<FinishedRecipe> consumer, Item stampedEgg, Item coloredEgg, String eggStamp, DyeItem dyeItem) {
        Item stampItem = getStampItem(eggStamp);

        if (stampItem != null) {
            ShapelessRemainderRecipeBuilder.recipe(stampedEgg, 6)
                    .addIngredient(coloredEgg, 6)
                    .addIngredient(stampItem)
                    .addIngredient(dyeItem)
                    .unlockedBy("has_" + stampItem, has(stampItem))
                    .build(consumer, new ResourceLocation(MODID,
                            "easter_eggs/" + eggStamp + "_stamped/" + itemName(stampedEgg)));
        }
    }
}