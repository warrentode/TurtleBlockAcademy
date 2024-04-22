package com.github.warrentode.turtleblockacademy.datagen;

import com.github.warrentode.turtleblockacademy.datagen.advancements.AcademyAdvancementsGen;
import com.github.warrentode.turtleblockacademy.datagen.lang.ModLangGen;
import com.github.warrentode.turtleblockacademy.datagen.loot.ModLootProviders;
import com.github.warrentode.turtleblockacademy.datagen.models.ModItemModelProvider;
import com.github.warrentode.turtleblockacademy.datagen.recipes.RecipesGen;
import com.github.warrentode.turtleblockacademy.datagen.recipes.recipe.SpawnEggRecipesGen;
import com.github.warrentode.turtleblockacademy.datagen.tags.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(@NotNull GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        BlockTagsGen blockTagsGen = new BlockTagsGen(generator, MODID, helper);
        generator.addProvider(event.includeServer(), blockTagsGen);

        generator.addProvider(event.includeServer(), new ItemTagsGen(generator, blockTagsGen, MODID, helper));
        generator.addProvider(event.includeServer(), new EntityTypeTagsGen(generator, MODID, helper));
        generator.addProvider(event.includeServer(), new StructureTagsGen(generator, MODID, helper));
        generator.addProvider(event.includeServer(), new BiomeTagGen(generator, MODID, helper));

        generator.addProvider(event.includeServer(), new SpawnEggRecipesGen(generator));
        generator.addProvider(event.includeServer(), new RecipesGen(generator));

        generator.addProvider(event.includeServer(), new ModItemModelProvider(generator, MODID, helper));
        generator.addProvider(event.includeServer(), new AcademyAdvancementsGen(generator, helper));
        generator.addProvider(event.includeClient(), new ModLangGen(generator, MODID, "en_us"));
        generator.addProvider(event.includeServer(), new ModLootProviders(generator));
    }
}