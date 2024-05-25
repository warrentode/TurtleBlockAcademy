package com.github.warrentode.turtleblockacademy.recipe.fermenting;

import com.github.warrentode.turtleblockacademy.blocks.entity.FermentingPotBlockEntity;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.List;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class FermentingRecipeBookComponent extends RecipeBookComponent {
    protected static final ResourceLocation RECIPE_BOOK_BUTTONS = new ResourceLocation(MODID, "textures/gui/fermenting_recipe_book_buttons.png");

    public FermentingRecipeBookComponent() {}

    @Override
    protected void initFilterButtonTextures() {
        this.filterButton.initTextureValues(0, 0, 28, 18, RECIPE_BOOK_BUTTONS);
    }

    @Override
    @Nonnull
    protected Component getRecipeFilterName() {
        return Component.translatable("container.turtleblockacademy.recipe_book.fermenting");
    }

    @Override
    public void setupGhostRecipe(@NotNull Recipe<?> recipe, @NotNull List<Slot> slots) {
        ItemStack resultStack = recipe.getResultItem();
        this.ghostRecipe.setRecipe(recipe);

        //result slot
        if (slots.get(FermentingPotBlockEntity.RESULT_SLOT).getItem().isEmpty()) {
            this.ghostRecipe.addIngredient(Ingredient.of(resultStack),
                    (slots.get(FermentingPotBlockEntity.RESULT_SLOT)).x,
                    (slots.get(FermentingPotBlockEntity.RESULT_SLOT)).y);
        }

        //container slot
        if (slots.get(FermentingPotBlockEntity.CONTAINER_SLOT).getItem().isEmpty()) {
            if (recipe instanceof FermentingPotRecipe fermentingRecipe) {
                ItemStack containerStack = fermentingRecipe.getOutputContainer();
                if (!containerStack.isEmpty()) {
                    this.ghostRecipe.addIngredient(Ingredient.of(containerStack),
                            slots.get(FermentingPotBlockEntity.CONTAINER_SLOT).x,
                            slots.get(FermentingPotBlockEntity.CONTAINER_SLOT).y);
                }
            }
        }

        //cover slot
        if (slots.get(FermentingPotBlockEntity.COVER_SLOT).getItem().isEmpty()) {
            if (recipe instanceof FermentingPotRecipe fermentingRecipe) {
                ItemStack coverStack = fermentingRecipe.getCoverStack();
                if (!coverStack.isEmpty()) {
                    this.ghostRecipe.addIngredient(Ingredient.of(coverStack),
                            slots.get(FermentingPotBlockEntity.COVER_SLOT).x,
                            slots.get(FermentingPotBlockEntity.COVER_SLOT).y);
                }
            }
        }

        this.placeRecipe(this.menu.getGridWidth(), this.menu.getGridHeight(),
                this.menu.getResultSlotIndex(), recipe,
                recipe.getIngredients().iterator(), 0);
    }
}