package com.github.warrentode.turtleblockacademy.datagen.recipes.recipe;

import com.github.warrentode.turtleblockacademy.items.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class CraftingRecipesGen extends RecipeProvider implements IConditionBuilder {
    public CraftingRecipesGen(DataGenerator generator) {
        super(generator);
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        schoolSupplies(consumer);
    }

    private static void schoolSupplies(Consumer<FinishedRecipe> consumer) {
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
