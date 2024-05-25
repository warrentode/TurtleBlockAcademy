package com.github.warrentode.turtleblockacademy.integration.jei;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.recipe.fermenting.FermentingPotRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class FermentingCategory implements IRecipeCategory<FermentingPotRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(MODID, "fermenting");
    public static final ResourceLocation TEXTURE = new ResourceLocation(MODID, "textures/gui/fermenting_pot_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public FermentingCategory(@NotNull IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 23, 4, 125, 70);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(TBABlocks.FERMENTING_POT_BLOCK.get()));
    }

    @Override
    public @NotNull RecipeType<FermentingPotRecipe> getRecipeType() {
        return JEIModPlugin.FERMENTING_TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.translatable("container.turtleblockacademy.fermenting_pot");
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull FermentingPotRecipe recipe, @NotNull IFocusGroup group) {
        NonNullList<Ingredient> recipeIngredients = recipe.getIngredients();
        ItemStack coverStack = recipe.getCoverStack();
        ItemStack containerStack = recipe.getOutputContainer();
        int borderSlotSize = 18;
        int inputStartX = 7;
        int inputStartY = 13;

        for (int row = 0; row < 2; ++row) {
            for (int column = 0; column < 3; ++column) {
                int inputIndex = row * 3 + column;
                if (inputIndex < recipeIngredients.size()) {
                    builder.addSlot(RecipeIngredientRole.INPUT, inputStartX + column * borderSlotSize + 1, inputStartY + row * borderSlotSize + 1).addItemStacks(Arrays.asList(recipeIngredients.get(inputIndex).getItems()));
                }
            }
        }

        if (!recipe.getCoverStack().isEmpty()) {
            // cover slot
            builder.addSlot(RecipeIngredientRole.CATALYST, 101, 3).addItemStack(coverStack);
        }
        if (!recipe.getOutputContainer().isEmpty()) {
            // container slot
            builder.addSlot(RecipeIngredientRole.CATALYST, 101, 23).addItemStack(containerStack);
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, 101, 51).addItemStack(recipe.getResultItem());
    }
}