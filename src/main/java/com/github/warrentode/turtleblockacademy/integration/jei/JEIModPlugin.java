package com.github.warrentode.turtleblockacademy.integration.jei;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.blocks.entity.gui.fermentingpot.FermentingPotMenu;
import com.github.warrentode.turtleblockacademy.blocks.entity.gui.TBAMenuTypes;
import com.github.warrentode.turtleblockacademy.recipe.fermenting.FermentingPotRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

@JeiPlugin
public class JEIModPlugin implements IModPlugin {
    public static final RecipeType<FermentingPotRecipe> FERMENTING_TYPE =
            new RecipeType<>(FermentingCategory.UID, FermentingPotRecipe.class);

    public JEIModPlugin() {}

    @Override
    public void registerCategories(@NotNull IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new FermentingCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        TBARecipeManager tbaRecipeManager = new TBARecipeManager();
        registration.addRecipes(FERMENTING_TYPE, tbaRecipeManager.getFermentingPotRecipes());
    }

    @Override
    public void registerRecipeCatalysts(@NotNull IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(TBABlocks.FERMENTING_POT_BLOCK.get()), FERMENTING_TYPE);
    }

    public void registerRecipeTransferHandlers(@NotNull IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(FermentingPotMenu.class, TBAMenuTypes.FERMENTING_POT_MENU.get(), FERMENTING_TYPE, 0, 6, 9, 36);
    }

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(MODID, "jei_plugin");
    }
}