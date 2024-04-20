package com.github.warrentode.turtleblockacademy.datagen;

import com.github.warrentode.turtleblockacademy.datagen.advancements.AcademyAdvancementsGen;
import com.github.warrentode.turtleblockacademy.datagen.lang.ModLangGen;
import com.github.warrentode.turtleblockacademy.datagen.loot.ModLootProviders;
import com.github.warrentode.turtleblockacademy.datagen.models.ModItemModelProvider;
import com.github.warrentode.turtleblockacademy.datagen.recipes.RecipesGen;
import com.github.warrentode.turtleblockacademy.datagen.tags.BiomeTagGen;
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

        generator.addProvider(event.includeServer(), new BiomeTagGen(generator, MODID, helper));

        generator.addProvider(event.includeServer(), new RecipesGen(generator));
        generator.addProvider(event.includeServer(), new ModItemModelProvider(generator, MODID, helper));
        generator.addProvider(event.includeServer(), new AcademyAdvancementsGen(generator, helper));
        generator.addProvider(event.includeClient(), new ModLangGen(generator, MODID, "en_us"));
        generator.addProvider(event.includeServer(), new ModLootProviders(generator));
    }
}