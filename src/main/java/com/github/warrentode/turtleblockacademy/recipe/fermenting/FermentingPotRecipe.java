package com.github.warrentode.turtleblockacademy.recipe.fermenting;

import com.github.warrentode.turtleblockacademy.items.TBAItems;
import com.github.warrentode.turtleblockacademy.util.LogUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.util.RecipeMatcher;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class FermentingPotRecipe implements Recipe<RecipeWrapper> {
    public static final int INPUT_SLOTS = 6;
    private final ResourceLocation id;
    private final String group;
    private final FermentingRecipeBookTab tab;
    private final NonNullList<Ingredient> inputItems;
    private final ItemStack result;
    private final ItemStack cover;
    private final ItemStack container;
    private final float experience;
    private final int fermentingTime;

    public FermentingPotRecipe(ResourceLocation id, String group, FermentingRecipeBookTab tab,
                               int fermentingTime, float experience, NonNullList<Ingredient> inputItems,
                               ItemStack cover, @Nullable ItemStack container, ItemStack result) {
        this.id = id;
        this.group = group;
        this.tab = tab;
        this.inputItems = inputItems;
        this.result = result;
        this.cover = cover;
        this.container = container;
        this.experience = experience;
        this.fermentingTime = fermentingTime;
    }

    @Override
    public boolean matches(@NotNull RecipeWrapper wrapper, @NotNull Level level) {
        if (level.isClientSide()) {
            return false;
        }
        List<ItemStack> inputs = new ArrayList<>();
        int i = 0;

        for (int j = 0; j < INPUT_SLOTS; ++j) {
            ItemStack itemstack = wrapper.getItem(j);
            if (!itemstack.isEmpty()) {
                ++i;
                inputs.add(itemstack);
            }
        }

        return i == this.inputItems.size() && RecipeMatcher.findMatches(inputs, this.inputItems) != null;
    }

    public float getExperience() {
        return this.experience;
    }

    public @NotNull NonNullList<Ingredient> getIngredients() {
        return this.inputItems;
    }

    public int getFermentingTime() {
        return this.fermentingTime;
    }

    public ItemStack getOutputContainer() {
        return this.container;
    }

    public ItemStack getCoverStack() {
        return this.cover;
    }

    @Override
    public @NotNull ItemStack getResultItem() {
        return this.result;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull RecipeWrapper wrapper) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.inputItems.size();
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return id;
    }

    public @NotNull String getGroup() {
        return this.group;
    }

    @Nullable
    public FermentingRecipeBookTab getRecipeBookTab() {
        return this.tab;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public @NotNull ItemStack getToastSymbol() {
        return new ItemStack(TBAItems.BEET_WINE.get());
    }

    public static class Type implements RecipeType<FermentingPotRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "fermenting";
    }

    public static class Serializer implements RecipeSerializer<FermentingPotRecipe> {
        public Serializer() {}
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "fermenting";

        @Override
        public @NotNull FermentingPotRecipe fromJson(@NotNull ResourceLocation recipeId, @NotNull JsonObject serializedRecipe) {
            String groupIn = GsonHelper.getAsString(serializedRecipe, "group", "");
            NonNullList<Ingredient> inputItemsIn = readIngredients(GsonHelper.getAsJsonArray(serializedRecipe, "ingredients"));
            if (inputItemsIn.isEmpty()) {
                throw new JsonParseException("No ingredients for fermenting recipe");
            }
            else if (inputItemsIn.size() > INPUT_SLOTS) {
                throw new JsonParseException("Too many ingredients for fermenting recipe! The max is " + INPUT_SLOTS);
            }
            else {
                String tabKeyIn = GsonHelper.getAsString(serializedRecipe, "recipe_book_tab", null);
                FermentingRecipeBookTab tabIn = FermentingRecipeBookTab.findByName(tabKeyIn);
                if (tabKeyIn != null && tabIn == null) {
                    LogUtil.warn("Optional field 'recipe_book_tab' does not match any valid tab. If defined, must be one of the following: {}", EnumSet.allOf(FermentingRecipeBookTab.class));
                }

                ItemStack resultIn = CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(serializedRecipe, "result"), true);
                ItemStack containerIn = GsonHelper.isValidNode(serializedRecipe, "container") ?
                        CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(serializedRecipe, "container"), true) :
                        ItemStack.EMPTY;
                ItemStack coverIn = GsonHelper.isValidNode(serializedRecipe, "cover") ?
                        CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(serializedRecipe, "cover"), true) :
                        ItemStack.EMPTY;
                float experienceIn = GsonHelper.getAsFloat(serializedRecipe, "experience", 0.0F);
                int fermentingTimeIn = GsonHelper.getAsInt(serializedRecipe, "fermenting_time", 24000);
                return new FermentingPotRecipe(recipeId, groupIn, tabIn, fermentingTimeIn, experienceIn, inputItemsIn, coverIn, containerIn, resultIn);
            }
        }

        private static @NotNull NonNullList<Ingredient> readIngredients(@NotNull JsonArray ingredientArray) {
            NonNullList<Ingredient> ingredientList = NonNullList.create();

            for (int i = 0; i < ingredientArray.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(ingredientArray.get(i));
                if (!ingredient.isEmpty()) {
                    ingredientList.add(ingredient);
                }
            }

            return ingredientList;
        }

        // from = read/load
        @Override
        public FermentingPotRecipe fromNetwork(@NotNull ResourceLocation recipeId, @NotNull FriendlyByteBuf buffer) {
            String groupIn = buffer.readUtf();
            FermentingRecipeBookTab tabIn = FermentingRecipeBookTab.findByName(buffer.readUtf());
            int fermentingTimeIn = buffer.readVarInt();
            float experienceIn = buffer.readFloat();

            int i = buffer.readVarInt();
            NonNullList<Ingredient> inputItemsIn = NonNullList.withSize(i, Ingredient.EMPTY);
            inputItemsIn.replaceAll(ignored -> Ingredient.fromNetwork(buffer));

            ItemStack coverIn = buffer.readItem();
            ItemStack containerIn = buffer.readItem();
            ItemStack resultIn = buffer.readItem();

            return new FermentingPotRecipe(recipeId, groupIn, tabIn, fermentingTimeIn, experienceIn, inputItemsIn, coverIn, containerIn, resultIn);
        }

        // to = save/save
        @Override
        public void toNetwork(@NotNull FriendlyByteBuf buffer, @NotNull FermentingPotRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeUtf(recipe.tab != null ? recipe.tab.toString() : "");

            buffer.writeVarInt(recipe.fermentingTime);
            buffer.writeFloat(recipe.experience);

            buffer.writeVarInt(recipe.inputItems.size());
            for (Ingredient ingredient : recipe.inputItems) {
                ingredient.toNetwork(buffer);
            }

            if (recipe.cover != null) {
                buffer.writeItem(recipe.cover);
            }
            if (recipe.container != null) {
                buffer.writeItem(recipe.container);
            }
            buffer.writeItem(recipe.result);
        }
    }
}