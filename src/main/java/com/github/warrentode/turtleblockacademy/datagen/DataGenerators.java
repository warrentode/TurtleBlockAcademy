package com.github.warrentode.turtleblockacademy.datagen;

import com.github.warrentode.turtleblockacademy.datagen.advancements.TBAAdvancementsGen;
import com.github.warrentode.turtleblockacademy.datagen.lang.TBALangGen;
import com.github.warrentode.turtleblockacademy.datagen.loot.TBALootModifierGenProvider;
import com.github.warrentode.turtleblockacademy.datagen.loot.TBALootProviders;
import com.github.warrentode.turtleblockacademy.datagen.models.TBABlockStatesProvider;
import com.github.warrentode.turtleblockacademy.datagen.models.TBAItemModelProvider;
import com.github.warrentode.turtleblockacademy.datagen.recipes.RecipesGen;
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
        generator.addProvider(event.includeServer(), new BiomeTagsGen(generator, MODID, helper));

        generator.addProvider(event.includeServer(), new RecipesGen(generator));

        generator.addProvider(event.includeClient(), new SoundsFileGen(generator, helper));
        generator.addProvider(event.includeServer(), new TBABlockStatesProvider(generator, MODID, helper));
        generator.addProvider(event.includeServer(), new TBAItemModelProvider(generator, MODID, helper));
        generator.addProvider(event.includeServer(), new TBAAdvancementsGen(generator, helper));
        generator.addProvider(event.includeClient(), new TBALangGen(generator, MODID, "en_us"));
        generator.addProvider(event.includeServer(), new TBALootProviders(generator));
        generator.addProvider(event.includeServer(), new TBALootModifierGenProvider(generator, MODID));
    }
}