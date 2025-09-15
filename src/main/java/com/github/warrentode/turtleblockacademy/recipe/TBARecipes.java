package com.github.warrentode.turtleblockacademy.recipe;

import com.github.warrentode.turtleblockacademy.recipe.fermenting.FermentingPotRecipe;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TBARecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MODID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPE =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, MODID);

    public static final RegistryObject<RecipeSerializer<FermentingPotRecipe>> FERMENTING_SERIALIZER =
            SERIALIZERS.register(FermentingPotRecipe.Serializer.ID,
                    () -> FermentingPotRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeType<FermentingPotRecipe>> RECIPE_TYPE_FERMENTING =
            RECIPE_TYPE.register(FermentingPotRecipe.Type.ID,
                    () -> FermentingPotRecipe.Type.INSTANCE);

    public static final RecipeBookType RECIPE_BOOK_FERMENTING = RecipeBookType.create("FERMENTING_BOOK");

    public static final RegistryObject<RecipeSerializer<?>>
            SHAPELESS_REMAINDER_SERIALIZER = SERIALIZERS.register("shapeless_remainder",
            ShapelessRemainderRecipe.Serializer::new);

    public static final RegistryObject<RecipeSerializer<?>>
            SHAPED_REMAINDER_SERIALIZER = SERIALIZERS.register("shaped_remainder",
            ShapedRemainderRecipe.Serializer::new);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        RECIPE_TYPE.register(eventBus);
    }
}