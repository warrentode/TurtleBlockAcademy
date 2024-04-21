package com.github.warrentode.turtleblockacademy.datagen.recipes.builder;

import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.thatgravyboat.lootbags.common.registry.McRegistry;

import java.util.function.Consumer;

public class LootBagRecipeBuilder {
    private final String saveName;
    private final String displayName;
    private final String color;
    private final String rarity;
    private final ResourceLocation output;

    public LootBagRecipeBuilder(String saveName, String displayName, String color, String rarity, ResourceLocation output) {
        this.saveName = saveName;
        this.displayName = displayName;
        this.color = color;
        this.rarity = rarity;
        this.output = output;
    }

    public static LootBagRecipeBuilder writeRecipe(String saveName, String displayName, String color, String rarity, ResourceLocation output) {
        return new LootBagRecipeBuilder(saveName, displayName, color, rarity, output);
    }

    public void build(Consumer<FinishedRecipe> consumerIn) {
        ResourceLocation save = new ResourceLocation("lootbags", saveName);
        finish(consumerIn, save);
    }

    public void finish(Consumer<FinishedRecipe> consumerIn, ResourceLocation id) {
        consumerIn.accept(new Result(id, displayName, color, rarity, output));
    }

    @SuppressWarnings("unused")
    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final String displayName;
        private final String color;
        private final String rarity;
        private final ResourceLocation output;

        public Result(ResourceLocation id, String displayName, String color, String rarity, ResourceLocation output, @Nullable Advancement.Builder advancement, @Nullable ResourceLocation advancementId) {
            this.id = id;
            this.displayName = displayName;
            this.color = color;
            this.rarity = rarity;
            this.output = output;
        }

        public Result(ResourceLocation id, String displayName, String color, String rarity, ResourceLocation output) {
            this(id, displayName, color, rarity, output, null, null);
        }

        @Override
        public void serializeRecipeData(@NotNull JsonObject json) {
            json.addProperty("name", displayName);
            json.addProperty("color", color);
            json.addProperty("rarity", rarity);

            JsonObject objectResult = new JsonObject();
            json.add("output", objectResult);
            objectResult.addProperty("table", String.valueOf(output));
        }

        @Override
        public @NotNull ResourceLocation getId() {
            return id;
        }

        @Override
        public @NotNull RecipeSerializer<?> getType() {
            return McRegistry.LOOT_SERIALIZER.get();
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }
}
