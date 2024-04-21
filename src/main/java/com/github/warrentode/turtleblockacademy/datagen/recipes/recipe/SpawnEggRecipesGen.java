package com.github.warrentode.turtleblockacademy.datagen.recipes.recipe;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherItems;
import com.github.warrentode.turtleblockacademy.util.PackTags;
import net.mcreator.phantasm.init.PhantasmModItems;
import net.mcreator.unusualend.init.UnusualendModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class SpawnEggRecipesGen extends RecipeProvider implements IConditionBuilder {
    public SpawnEggRecipesGen(DataGenerator pGenerator) {
        super(pGenerator);
    }

    //TODO add tconstruct mobs

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        // spawn eggs for mods that do not have collectible coin sets

        // unusual end
        recipeTemplate(consumer, "unusualend", UnusualendModItems.ENDSTONE_TRAPPER_SPAWN_EGG.get(),
                UnusualendModItems.WARPED_WART.get(), UnusualendModItems.INFESTED_END_STONE.get());
        recipeTemplate(consumer, "unusualend", UnusualendModItems.UNDEAD_ENDERLING_SPAWN_EGG.get(),
                UnusualendModItems.WARPED_WART.get(), UnusualendModItems.ENDERLING_SCRAP.get());
        recipeTemplate(consumer, "unusualend", UnusualendModItems.ENDER_BLOB_SPAWN_EGG.get(),
                UnusualendModItems.WARPED_WART.get(), UnusualendModItems.ENDERBLOB_MOULT.get());
        recipeTemplate(consumer, "unusualend", UnusualendModItems.ENDSTONE_GOLEM_SPAWN_EGG.get(),
                UnusualendModItems.WARPED_WART.get(), UnusualendModItems.GOLEM_ORB.get());
        recipeTemplate(consumer, "unusualend", UnusualendModItems.DRAGLING_SPAWN_EGG.get(),
                UnusualendModItems.WARPED_WART.get(), UnusualendModItems.SCRAPE_CLOTH.get());
        recipeTemplate(consumer, "unusualend", UnusualendModItems.ENDER_FIREFLY_SPAWN_EGG.get(),
                UnusualendModItems.WARPED_WART.get(), UnusualendModItems.FIREFLY_BULB.get());
        recipeTemplate(consumer, "unusualend", UnusualendModItems.BOLOK_SPAWN_EGG.get(),
                UnusualendModItems.WARPED_WART.get(), UnusualendModItems.BOLOK_SCALE.get());

        // phantasm
        recipeTemplate(consumer, "phantasm", PhantasmModItems.CRYSTIE.get(), PhantasmModItems.STARDUST.get(),
                PhantasmModItems.CRYSTALILY.get());

        // aether
        recipeTemplate(consumer, "aether", AetherItems.AECHOR_PLANT_SPAWN_EGG.get(),
                AetherItems.ZANITE_GEMSTONE.get(), AetherItems.AECHOR_PETAL.get());
        recipeTemplate(consumer, "aether", AetherItems.AERBUNNY_SPAWN_EGG.get(), AetherItems.ZANITE_GEMSTONE.get(),
                AetherItems.WHITE_APPLE.get());
        recipeTemplate(consumer, "aether", AetherItems.AERWHALE_SPAWN_EGG.get(), AetherItems.ZANITE_GEMSTONE.get(),
                AetherItems.SKYROOT_COD_BUCKET.get());
        recipeTemplate(consumer, "aether", AetherItems.COCKATRICE_SPAWN_EGG.get(), AetherItems.ZANITE_GEMSTONE.get(),
                AetherBlocks.CARVED_STONE.get().asItem());
        recipeTemplate(consumer, "aether", AetherItems.FIRE_MINION_SPAWN_EGG.get(), AetherItems.ZANITE_GEMSTONE.get()
                , Items.FLINT_AND_STEEL);
        recipeTemplate(consumer, "aether", AetherItems.FLYING_COW_SPAWN_EGG.get(), AetherItems.ZANITE_GEMSTONE.get(),
                AetherItems.SKYROOT_MILK_BUCKET.get());
        recipeTemplate(consumer, "aether", AetherItems.MIMIC_SPAWN_EGG.get(), AetherItems.ZANITE_GEMSTONE.get(),
                Items.CHEST);
        recipeTemplate(consumer, "aether", AetherItems.MOA_SPAWN_EGG.get(), AetherItems.ZANITE_GEMSTONE.get(),
                AetherItems.GOLDEN_FEATHER.get());
        recipeTemplate(consumer, "aether", AetherItems.PHYG_SPAWN_EGG.get(), AetherItems.ZANITE_GEMSTONE.get(),
                Items.BEETROOT);
        recipeTemplate(consumer, "aether", AetherItems.SENTRY_SPAWN_EGG.get(), AetherItems.ZANITE_GEMSTONE.get(),
                AetherBlocks.SENTRY_STONE.get().asItem());
        recipeTemplate(consumer, "aether", AetherItems.SHEEPUFF_SPAWN_EGG.get(), AetherItems.ZANITE_GEMSTONE.get(),
                AetherBlocks.COLD_AERCLOUD.get().asItem());
        recipeTemplate(consumer, "aether", AetherItems.BLUE_SWET_SPAWN_EGG.get(), AetherItems.ZANITE_GEMSTONE.get(),
                AetherItems.SWET_BALL.get());
        recipeTemplate(consumer, "aether", AetherItems.GOLDEN_SWET_SPAWN_EGG.get(), AetherItems.AMBROSIUM_SHARD.get()
                , AetherItems.SWET_BALL.get());
        recipeTemplate(consumer, "aether", AetherItems.WHIRLWIND_SPAWN_EGG.get(), AetherItems.ZANITE_GEMSTONE.get(),
                Items.PHANTOM_MEMBRANE);
        recipeTemplate(consumer, "aether", AetherItems.EVIL_WHIRLWIND_SPAWN_EGG.get(),
                AetherItems.AMBROSIUM_SHARD.get(), Items.PHANTOM_MEMBRANE);
        recipeTemplate(consumer, "aether", AetherItems.VALKYRIE_SPAWN_EGG.get(), AetherItems.ZANITE_GEMSTONE.get(),
                AetherItems.VALKYRIE_LANCE.get());
        recipeTemplate(consumer, "aether", AetherItems.VALKYRIE_QUEEN_SPAWN_EGG.get(),
                AetherItems.AMBROSIUM_SHARD.get(), AetherItems.VALKYRIE_HELMET.get());
        recipeTemplate(consumer, "aether", AetherItems.SLIDER_SPAWN_EGG.get(), AetherItems.ZANITE_GEMSTONE.get(),
                AetherItems.AMBROSIUM_SHARD.get());
        recipeTemplate(consumer, "aether", AetherItems.SUN_SPIRIT_SPAWN_EGG.get(), AetherItems.GOLDEN_AMBER.get(),
                AetherItems.AMBROSIUM_SHARD.get());
        recipeTemplate(consumer, "aether", AetherItems.ZEPHYR_SPAWN_EGG.get(), AetherItems.ZANITE_GEMSTONE.get(),
                AetherBlocks.BLUE_AERCLOUD.get().asItem());

    }

    protected void recipeTemplate(Consumer<FinishedRecipe> consumer, String modid, Item result, Item namespaceItem,
                                  Item entityIdentifierItem) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("cagerium"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(result, 1)
                        .group("spawn_eggs")
                        // egg base
                        .requires(Tags.Items.EGGS)
                        // soul activator
                        .requires(PackTags.Items.SOUL_BINDER)
                        // material item cost
                        .requires(PackTags.Items.NETHERITE_NUGGET)
                        // life bringer item
                        .requires(Items.HEART_OF_THE_SEA)
                        // namespace identifier item
                        .requires(namespaceItem)
                        // entity identifier item
                        .requires(entityIdentifierItem)
                        .unlockedBy("has_soul_binder",
                                has(PackTags.Items.SOUL_BINDER))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + modid + "/" + result));
    }
}