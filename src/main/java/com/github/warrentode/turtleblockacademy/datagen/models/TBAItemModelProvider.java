package com.github.warrentode.turtleblockacademy.datagen.models;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.items.TBAItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TBAItemModelProvider extends ItemModelProvider {
    public final ExistingFileHelper helper;

    public TBAItemModelProvider(DataGenerator generator, String modid, ExistingFileHelper helper) {
        super(generator, modid, helper);
        this.helper = helper;
    }

    @Override
    protected void registerModels() {
        basicItem(TBAItems.STUDENT_CARD.get());

        boiledEgg(TBAItems.BOILED_EGG.get());
        peeledEgg(TBAItems.PEELED_EGG.get());

        spawnEggItem(TBAItems.HEROBRINE_SPAWN_EGG.get());
        spawnEggItem(TBAItems.TREASURE_BEETLE_SPAWN_EGG.get());

        eggStamp(TBAItems.EGG_STAMP_CREEPER.get(), "creeper");
        eggStamp(TBAItems.EGG_STAMP_FLOWER.get(), "flower");

        basicItem(TBAItems.BEET_WINE.get());
        basicItem(TBAItems.VINEGAR_BOTTLE.get());
        basicItem(TBAItems.BEET_RISOTTO.get());
        basicItem(TBAItems.BEET_SALAD.get());
        basicItem(TBAItems.BEET_PICKLES.get());

        basicItem(TBAItems.CLOVES.get());
        basicItem(TBAItems.CLOVE_SEEDS.get());
        basicItem(TBAItems.CUCUMBER_SEEDS.get());
        basicItem(TBAItems.CUCUMBER.get());
        basicItem(TBAItems.DILL_PICKLE.get());
        basicItem(TBAItems.DILL_SEEDS.get());
        basicItem(TBAItems.DILL_HERB.get());
        basicItem(TBAItems.DRIED_CLOVES.get());
        basicItem(TBAItems.GROUND_CLOVES.get());
        basicItem(TBAItems.PICKLING_SALT.get());
        basicItem(TBAItems.WHEAT_FLOUR.get());
        basicItem(TBAItems.YEAST.get());
        basicItem(TBAItems.HARD_APPLE_CIDER.get());

        blockBasedModel(TBABlocks.CERTIFICATE_BLOCK.get().asItem());
        blockBasedModel(TBABlocks.FERMENTING_POT_BLOCK.get().asItem());

        // blank easter eggs
        basicItem(TBAItems.COLORED_EGG_BLACK.get());
        basicItem(TBAItems.COLORED_EGG_RED.get());
        basicItem(TBAItems.COLORED_EGG_GREEN.get());
        basicItem(TBAItems.COLORED_EGG_BROWN.get());
        basicItem(TBAItems.COLORED_EGG_BLUE.get());
        basicItem(TBAItems.COLORED_EGG_PURPLE.get());
        basicItem(TBAItems.COLORED_EGG_CYAN.get());
        basicItem(TBAItems.COLORED_EGG_LIGHT_GRAY.get());
        basicItem(TBAItems.COLORED_EGG_GRAY.get());
        basicItem(TBAItems.COLORED_EGG_PINK.get());
        basicItem(TBAItems.COLORED_EGG_LIME.get());
        basicItem(TBAItems.COLORED_EGG_YELLOW.get());
        basicItem(TBAItems.COLORED_EGG_LIGHT_BLUE.get());
        basicItem(TBAItems.COLORED_EGG_MAGENTA.get());
        basicItem(TBAItems.COLORED_EGG_ORANGE.get());
        basicItem(TBAItems.COLORED_EGG_WHITE.get());

        creeperStampEgg(TBAItems.COLORED_EGG_WHITE_CREEPER_BLACK.get(),
                "white", "black");
        creeperStampEgg(TBAItems.COLORED_EGG_WHITE_CREEPER_RED.get(),
                "white", "red");
        creeperStampEgg(TBAItems.COLORED_EGG_WHITE_CREEPER_GREEN.get(),
                "white", "green");
        creeperStampEgg(TBAItems.COLORED_EGG_WHITE_CREEPER_BROWN.get(),
                "white", "brown");
        creeperStampEgg(TBAItems.COLORED_EGG_WHITE_CREEPER_BLUE.get(),
                "white", "blue");
        creeperStampEgg(TBAItems.COLORED_EGG_WHITE_CREEPER_PURPLE.get(),
                "white", "purple");
        creeperStampEgg(TBAItems.COLORED_EGG_WHITE_CREEPER_CYAN.get(),
                "white", "cyan");
        creeperStampEgg(TBAItems.COLORED_EGG_WHITE_CREEPER_LIGHT_GRAY.get(),
                "white", "light_gray");
        creeperStampEgg(TBAItems.COLORED_EGG_WHITE_CREEPER_GRAY.get(),
                "white", "gray");
        creeperStampEgg(TBAItems.COLORED_EGG_WHITE_CREEPER_PINK.get(),
                "white", "pink");
        creeperStampEgg(TBAItems.COLORED_EGG_WHITE_CREEPER_LIME.get(),
                "white", "lime");
        creeperStampEgg(TBAItems.COLORED_EGG_WHITE_CREEPER_YELLOW.get(),
                "white", "yellow");
        creeperStampEgg(TBAItems.COLORED_EGG_WHITE_CREEPER_LIGHT_BLUE.get(),
                "white", "light_blue");
        creeperStampEgg(TBAItems.COLORED_EGG_WHITE_CREEPER_MAGENTA.get(),
                "white", "magenta");
        creeperStampEgg(TBAItems.COLORED_EGG_WHITE_CREEPER_ORANGE.get(),
                "white", "orange");
        creeperStampEgg(TBAItems.COLORED_EGG_WHITE_CREEPER_WHITE.get(),
                "white", "white");

        creeperStampEgg(TBAItems.COLORED_EGG_ORANGE_CREEPER_BLACK.get(),
                "orange", "black");
        creeperStampEgg(TBAItems.COLORED_EGG_ORANGE_CREEPER_RED.get(),
                "orange", "red");
        creeperStampEgg(TBAItems.COLORED_EGG_ORANGE_CREEPER_GREEN.get(),
                "orange", "green");
        creeperStampEgg(TBAItems.COLORED_EGG_ORANGE_CREEPER_BROWN.get(),
                "orange", "brown");
        creeperStampEgg(TBAItems.COLORED_EGG_ORANGE_CREEPER_BLUE.get(),
                "orange", "blue");
        creeperStampEgg(TBAItems.COLORED_EGG_ORANGE_CREEPER_PURPLE.get(),
                "orange", "purple");
        creeperStampEgg(TBAItems.COLORED_EGG_ORANGE_CREEPER_CYAN.get(),
                "orange", "cyan");
        creeperStampEgg(TBAItems.COLORED_EGG_ORANGE_CREEPER_LIGHT_GRAY.get(),
                "orange", "light_gray");
        creeperStampEgg(TBAItems.COLORED_EGG_ORANGE_CREEPER_GRAY.get(),
                "orange", "gray");
        creeperStampEgg(TBAItems.COLORED_EGG_ORANGE_CREEPER_PINK.get(),
                "orange", "pink");
        creeperStampEgg(TBAItems.COLORED_EGG_ORANGE_CREEPER_LIME.get(),
                "orange", "lime");
        creeperStampEgg(TBAItems.COLORED_EGG_ORANGE_CREEPER_YELLOW.get(),
                "orange", "yellow");
        creeperStampEgg(TBAItems.COLORED_EGG_ORANGE_CREEPER_LIGHT_BLUE.get(),
                "orange", "light_blue");
        creeperStampEgg(TBAItems.COLORED_EGG_ORANGE_CREEPER_MAGENTA.get(),
                "orange", "magenta");
        creeperStampEgg(TBAItems.COLORED_EGG_ORANGE_CREEPER_ORANGE.get(),
                "orange", "orange");
        creeperStampEgg(TBAItems.COLORED_EGG_ORANGE_CREEPER_WHITE.get(),
                "orange", "white");

        creeperStampEgg(TBAItems.COLORED_EGG_MAGENTA_CREEPER_BLACK.get(),
                "magenta", "black");
        creeperStampEgg(TBAItems.COLORED_EGG_MAGENTA_CREEPER_RED.get(),
                "magenta", "red");
        creeperStampEgg(TBAItems.COLORED_EGG_MAGENTA_CREEPER_GREEN.get(),
                "magenta", "green");
        creeperStampEgg(TBAItems.COLORED_EGG_MAGENTA_CREEPER_BROWN.get(),
                "magenta", "brown");
        creeperStampEgg(TBAItems.COLORED_EGG_MAGENTA_CREEPER_BLUE.get(),
                "magenta", "blue");
        creeperStampEgg(TBAItems.COLORED_EGG_MAGENTA_CREEPER_PURPLE.get(),
                "magenta", "purple");
        creeperStampEgg(TBAItems.COLORED_EGG_MAGENTA_CREEPER_CYAN.get(),
                "magenta", "cyan");
        creeperStampEgg(TBAItems.COLORED_EGG_MAGENTA_CREEPER_LIGHT_GRAY.get(),
                "magenta", "light_gray");
        creeperStampEgg(TBAItems.COLORED_EGG_MAGENTA_CREEPER_GRAY.get(),
                "magenta", "gray");
        creeperStampEgg(TBAItems.COLORED_EGG_MAGENTA_CREEPER_PINK.get(),
                "magenta", "pink");
        creeperStampEgg(TBAItems.COLORED_EGG_MAGENTA_CREEPER_LIME.get(),
                "magenta", "lime");
        creeperStampEgg(TBAItems.COLORED_EGG_MAGENTA_CREEPER_YELLOW.get(),
                "magenta", "yellow");
        creeperStampEgg(TBAItems.COLORED_EGG_MAGENTA_CREEPER_LIGHT_BLUE.get(),
                "magenta", "light_blue");
        creeperStampEgg(TBAItems.COLORED_EGG_MAGENTA_CREEPER_MAGENTA.get(),
                "magenta", "magenta");
        creeperStampEgg(TBAItems.COLORED_EGG_MAGENTA_CREEPER_ORANGE.get(),
                "magenta", "orange");
        creeperStampEgg(TBAItems.COLORED_EGG_MAGENTA_CREEPER_WHITE.get(),
                "magenta", "white");

        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_BLACK.get(),
                "light_blue", "black");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_RED.get(),
                "light_blue", "red");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_GREEN.get(),
                "light_blue", "green");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_BROWN.get(),
                "light_blue", "brown");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_BLUE.get(),
                "light_blue", "blue");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_PURPLE.get(),
                "light_blue", "purple");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_CYAN.get(),
                "light_blue", "cyan");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_LIGHT_GRAY.get(),
                "light_blue", "light_gray");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_GRAY.get(),
                "light_blue", "gray");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_PINK.get(),
                "light_blue", "pink");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_LIME.get(),
                "light_blue", "lime");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_YELLOW.get(),
                "light_blue", "yellow");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_LIGHT_BLUE.get(),
                "light_blue", "light_blue");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_MAGENTA.get(),
                "light_blue", "magenta");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_ORANGE.get(),
                "light_blue", "orange");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_WHITE.get(),
                "light_blue", "white");

        creeperStampEgg(TBAItems.COLORED_EGG_YELLOW_CREEPER_BLACK.get(),
                "yellow", "black");
        creeperStampEgg(TBAItems.COLORED_EGG_YELLOW_CREEPER_RED.get(),
                "yellow", "red");
        creeperStampEgg(TBAItems.COLORED_EGG_YELLOW_CREEPER_GREEN.get(),
                "yellow", "green");
        creeperStampEgg(TBAItems.COLORED_EGG_YELLOW_CREEPER_BROWN.get(),
                "yellow", "brown");
        creeperStampEgg(TBAItems.COLORED_EGG_YELLOW_CREEPER_BLUE.get(),
                "yellow", "blue");
        creeperStampEgg(TBAItems.COLORED_EGG_YELLOW_CREEPER_PURPLE.get(),
                "yellow", "purple");
        creeperStampEgg(TBAItems.COLORED_EGG_YELLOW_CREEPER_CYAN.get(),
                "yellow", "cyan");
        creeperStampEgg(TBAItems.COLORED_EGG_YELLOW_CREEPER_LIGHT_GRAY.get(),
                "yellow", "light_gray");
        creeperStampEgg(TBAItems.COLORED_EGG_YELLOW_CREEPER_GRAY.get(),
                "yellow", "gray");
        creeperStampEgg(TBAItems.COLORED_EGG_YELLOW_CREEPER_PINK.get(),
                "yellow", "pink");
        creeperStampEgg(TBAItems.COLORED_EGG_YELLOW_CREEPER_LIME.get(),
                "yellow", "lime");
        creeperStampEgg(TBAItems.COLORED_EGG_YELLOW_CREEPER_YELLOW.get(),
                "yellow", "yellow");
        creeperStampEgg(TBAItems.COLORED_EGG_YELLOW_CREEPER_LIGHT_BLUE.get(),
                "yellow", "light_blue");
        creeperStampEgg(TBAItems.COLORED_EGG_YELLOW_CREEPER_MAGENTA.get(),
                "yellow", "magenta");
        creeperStampEgg(TBAItems.COLORED_EGG_YELLOW_CREEPER_ORANGE.get(),
                "yellow", "orange");
        creeperStampEgg(TBAItems.COLORED_EGG_YELLOW_CREEPER_WHITE.get(),
                "yellow", "white");

        creeperStampEgg(TBAItems.COLORED_EGG_LIME_CREEPER_BLACK.get(),
                "lime", "black");
        creeperStampEgg(TBAItems.COLORED_EGG_LIME_CREEPER_RED.get(),
                "lime", "red");
        creeperStampEgg(TBAItems.COLORED_EGG_LIME_CREEPER_GREEN.get(),
                "lime", "green");
        creeperStampEgg(TBAItems.COLORED_EGG_LIME_CREEPER_BROWN.get(),
                "lime", "brown");
        creeperStampEgg(TBAItems.COLORED_EGG_LIME_CREEPER_BLUE.get(),
                "lime", "blue");
        creeperStampEgg(TBAItems.COLORED_EGG_LIME_CREEPER_PURPLE.get(),
                "lime", "purple");
        creeperStampEgg(TBAItems.COLORED_EGG_LIME_CREEPER_CYAN.get(),
                "lime", "cyan");
        creeperStampEgg(TBAItems.COLORED_EGG_LIME_CREEPER_LIGHT_GRAY.get(),
                "lime", "light_gray");
        creeperStampEgg(TBAItems.COLORED_EGG_LIME_CREEPER_GRAY.get(),
                "lime", "gray");
        creeperStampEgg(TBAItems.COLORED_EGG_LIME_CREEPER_PINK.get(),
                "lime", "pink");
        creeperStampEgg(TBAItems.COLORED_EGG_LIME_CREEPER_LIME.get(),
                "lime", "lime");
        creeperStampEgg(TBAItems.COLORED_EGG_LIME_CREEPER_YELLOW.get(),
                "lime", "yellow");
        creeperStampEgg(TBAItems.COLORED_EGG_LIME_CREEPER_LIGHT_BLUE.get(),
                "lime", "light_blue");
        creeperStampEgg(TBAItems.COLORED_EGG_LIME_CREEPER_MAGENTA.get(),
                "lime", "magenta");
        creeperStampEgg(TBAItems.COLORED_EGG_LIME_CREEPER_ORANGE.get(),
                "lime", "orange");
        creeperStampEgg(TBAItems.COLORED_EGG_LIME_CREEPER_WHITE.get(),
                "lime", "white");

        creeperStampEgg(TBAItems.COLORED_EGG_PINK_CREEPER_BLACK.get(),
                "pink", "black");
        creeperStampEgg(TBAItems.COLORED_EGG_PINK_CREEPER_RED.get(),
                "pink", "red");
        creeperStampEgg(TBAItems.COLORED_EGG_PINK_CREEPER_GREEN.get(),
                "pink", "green");
        creeperStampEgg(TBAItems.COLORED_EGG_PINK_CREEPER_BROWN.get(),
                "pink", "brown");
        creeperStampEgg(TBAItems.COLORED_EGG_PINK_CREEPER_BLUE.get(),
                "pink", "blue");
        creeperStampEgg(TBAItems.COLORED_EGG_PINK_CREEPER_PURPLE.get(),
                "pink", "purple");
        creeperStampEgg(TBAItems.COLORED_EGG_PINK_CREEPER_CYAN.get(),
                "pink", "cyan");
        creeperStampEgg(TBAItems.COLORED_EGG_PINK_CREEPER_LIGHT_GRAY.get(),
                "pink", "light_gray");
        creeperStampEgg(TBAItems.COLORED_EGG_PINK_CREEPER_GRAY.get(),
                "pink", "gray");
        creeperStampEgg(TBAItems.COLORED_EGG_PINK_CREEPER_PINK.get(),
                "pink", "pink");
        creeperStampEgg(TBAItems.COLORED_EGG_PINK_CREEPER_LIME.get(),
                "pink", "lime");
        creeperStampEgg(TBAItems.COLORED_EGG_PINK_CREEPER_YELLOW.get(),
                "pink", "yellow");
        creeperStampEgg(TBAItems.COLORED_EGG_PINK_CREEPER_LIGHT_BLUE.get(),
                "pink", "light_blue");
        creeperStampEgg(TBAItems.COLORED_EGG_PINK_CREEPER_MAGENTA.get(),
                "pink", "magenta");
        creeperStampEgg(TBAItems.COLORED_EGG_PINK_CREEPER_ORANGE.get(),
                "pink", "orange");
        creeperStampEgg(TBAItems.COLORED_EGG_PINK_CREEPER_WHITE.get(),
                "pink", "white");

        creeperStampEgg(TBAItems.COLORED_EGG_GRAY_CREEPER_BLACK.get(),
                "gray", "black");
        creeperStampEgg(TBAItems.COLORED_EGG_GRAY_CREEPER_RED.get(),
                "gray", "red");
        creeperStampEgg(TBAItems.COLORED_EGG_GRAY_CREEPER_GREEN.get(),
                "gray", "green");
        creeperStampEgg(TBAItems.COLORED_EGG_GRAY_CREEPER_BROWN.get(),
                "gray", "brown");
        creeperStampEgg(TBAItems.COLORED_EGG_GRAY_CREEPER_BLUE.get(),
                "gray", "blue");
        creeperStampEgg(TBAItems.COLORED_EGG_GRAY_CREEPER_PURPLE.get(),
                "gray", "purple");
        creeperStampEgg(TBAItems.COLORED_EGG_GRAY_CREEPER_CYAN.get(),
                "gray", "cyan");
        creeperStampEgg(TBAItems.COLORED_EGG_GRAY_CREEPER_LIGHT_GRAY.get(),
                "gray", "light_gray");
        creeperStampEgg(TBAItems.COLORED_EGG_GRAY_CREEPER_GRAY.get(),
                "gray", "gray");
        creeperStampEgg(TBAItems.COLORED_EGG_GRAY_CREEPER_PINK.get(),
                "gray", "pink");
        creeperStampEgg(TBAItems.COLORED_EGG_GRAY_CREEPER_LIME.get(),
                "gray", "lime");
        creeperStampEgg(TBAItems.COLORED_EGG_GRAY_CREEPER_YELLOW.get(),
                "gray", "yellow");
        creeperStampEgg(TBAItems.COLORED_EGG_GRAY_CREEPER_LIGHT_BLUE.get(),
                "gray", "light_blue");
        creeperStampEgg(TBAItems.COLORED_EGG_GRAY_CREEPER_MAGENTA.get(),
                "gray", "magenta");
        creeperStampEgg(TBAItems.COLORED_EGG_GRAY_CREEPER_ORANGE.get(),
                "gray", "orange");
        creeperStampEgg(TBAItems.COLORED_EGG_GRAY_CREEPER_WHITE.get(),
                "gray", "white");

        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_BLACK.get(),
                "light_gray", "black");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_RED.get(),
                "light_gray", "red");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_GREEN.get(),
                "light_gray", "green");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_BROWN.get(),
                "light_gray", "brown");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_BLUE.get(),
                "light_gray", "blue");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_PURPLE.get(),
                "light_gray", "purple");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_CYAN.get(),
                "light_gray", "cyan");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_LIGHT_GRAY.get(),
                "light_gray", "light_gray");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_GRAY.get(),
                "light_gray", "gray");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_PINK.get(),
                "light_gray", "pink");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_LIME.get(),
                "light_gray", "lime");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_YELLOW.get(),
                "light_gray", "yellow");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_LIGHT_BLUE.get(),
                "light_gray", "light_blue");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_MAGENTA.get(),
                "light_gray", "magenta");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_ORANGE.get(),
                "light_gray", "orange");
        creeperStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_WHITE.get(),
                "light_gray", "white");

        creeperStampEgg(TBAItems.COLORED_EGG_CYAN_CREEPER_BLACK.get(),
                "cyan", "black");
        creeperStampEgg(TBAItems.COLORED_EGG_CYAN_CREEPER_RED.get(),
                "cyan", "red");
        creeperStampEgg(TBAItems.COLORED_EGG_CYAN_CREEPER_GREEN.get(),
                "cyan", "green");
        creeperStampEgg(TBAItems.COLORED_EGG_CYAN_CREEPER_BROWN.get(),
                "cyan", "brown");
        creeperStampEgg(TBAItems.COLORED_EGG_CYAN_CREEPER_BLUE.get(),
                "cyan", "blue");
        creeperStampEgg(TBAItems.COLORED_EGG_CYAN_CREEPER_PURPLE.get(),
                "cyan", "purple");
        creeperStampEgg(TBAItems.COLORED_EGG_CYAN_CREEPER_CYAN.get(),
                "cyan", "cyan");
        creeperStampEgg(TBAItems.COLORED_EGG_CYAN_CREEPER_LIGHT_GRAY.get(),
                "cyan", "light_gray");
        creeperStampEgg(TBAItems.COLORED_EGG_CYAN_CREEPER_GRAY.get(),
                "cyan", "gray");
        creeperStampEgg(TBAItems.COLORED_EGG_CYAN_CREEPER_PINK.get(),
                "cyan", "pink");
        creeperStampEgg(TBAItems.COLORED_EGG_CYAN_CREEPER_LIME.get(),
                "cyan", "lime");
        creeperStampEgg(TBAItems.COLORED_EGG_CYAN_CREEPER_YELLOW.get(),
                "cyan", "yellow");
        creeperStampEgg(TBAItems.COLORED_EGG_CYAN_CREEPER_LIGHT_BLUE.get(),
                "cyan", "light_blue");
        creeperStampEgg(TBAItems.COLORED_EGG_CYAN_CREEPER_MAGENTA.get(),
                "cyan", "magenta");
        creeperStampEgg(TBAItems.COLORED_EGG_CYAN_CREEPER_ORANGE.get(),
                "cyan", "orange");
        creeperStampEgg(TBAItems.COLORED_EGG_CYAN_CREEPER_WHITE.get(),
                "cyan", "white");

        creeperStampEgg(TBAItems.COLORED_EGG_PURPLE_CREEPER_BLACK.get(),
                "purple", "black");
        creeperStampEgg(TBAItems.COLORED_EGG_PURPLE_CREEPER_RED.get(),
                "purple", "red");
        creeperStampEgg(TBAItems.COLORED_EGG_PURPLE_CREEPER_GREEN.get(),
                "purple", "green");
        creeperStampEgg(TBAItems.COLORED_EGG_PURPLE_CREEPER_BROWN.get(),
                "purple", "brown");
        creeperStampEgg(TBAItems.COLORED_EGG_PURPLE_CREEPER_BLUE.get(),
                "purple", "blue");
        creeperStampEgg(TBAItems.COLORED_EGG_PURPLE_CREEPER_PURPLE.get(),
                "purple", "purple");
        creeperStampEgg(TBAItems.COLORED_EGG_PURPLE_CREEPER_CYAN.get(),
                "purple", "cyan");
        creeperStampEgg(TBAItems.COLORED_EGG_PURPLE_CREEPER_LIGHT_GRAY.get(),
                "purple", "light_gray");
        creeperStampEgg(TBAItems.COLORED_EGG_PURPLE_CREEPER_GRAY.get(),
                "purple", "gray");
        creeperStampEgg(TBAItems.COLORED_EGG_PURPLE_CREEPER_PINK.get(),
                "purple", "pink");
        creeperStampEgg(TBAItems.COLORED_EGG_PURPLE_CREEPER_LIME.get(),
                "purple", "lime");
        creeperStampEgg(TBAItems.COLORED_EGG_PURPLE_CREEPER_YELLOW.get(),
                "purple", "yellow");
        creeperStampEgg(TBAItems.COLORED_EGG_PURPLE_CREEPER_LIGHT_BLUE.get(),
                "purple", "light_blue");
        creeperStampEgg(TBAItems.COLORED_EGG_PURPLE_CREEPER_MAGENTA.get(),
                "purple", "magenta");
        creeperStampEgg(TBAItems.COLORED_EGG_PURPLE_CREEPER_ORANGE.get(),
                "purple", "orange");
        creeperStampEgg(TBAItems.COLORED_EGG_PURPLE_CREEPER_WHITE.get(),
                "purple", "white");

        creeperStampEgg(TBAItems.COLORED_EGG_BLUE_CREEPER_BLACK.get(),
                "blue", "black");
        creeperStampEgg(TBAItems.COLORED_EGG_BLUE_CREEPER_RED.get(),
                "blue", "red");
        creeperStampEgg(TBAItems.COLORED_EGG_BLUE_CREEPER_GREEN.get(),
                "blue", "green");
        creeperStampEgg(TBAItems.COLORED_EGG_BLUE_CREEPER_BROWN.get(),
                "blue", "brown");
        creeperStampEgg(TBAItems.COLORED_EGG_BLUE_CREEPER_BLUE.get(),
                "blue", "blue");
        creeperStampEgg(TBAItems.COLORED_EGG_BLUE_CREEPER_PURPLE.get(),
                "blue", "purple");
        creeperStampEgg(TBAItems.COLORED_EGG_BLUE_CREEPER_CYAN.get(),
                "blue", "cyan");
        creeperStampEgg(TBAItems.COLORED_EGG_BLUE_CREEPER_LIGHT_GRAY.get(),
                "blue", "light_gray");
        creeperStampEgg(TBAItems.COLORED_EGG_BLUE_CREEPER_GRAY.get(),
                "blue", "gray");
        creeperStampEgg(TBAItems.COLORED_EGG_BLUE_CREEPER_PINK.get(),
                "blue", "pink");
        creeperStampEgg(TBAItems.COLORED_EGG_BLUE_CREEPER_LIME.get(),
                "blue", "lime");
        creeperStampEgg(TBAItems.COLORED_EGG_BLUE_CREEPER_YELLOW.get(),
                "blue", "yellow");
        creeperStampEgg(TBAItems.COLORED_EGG_BLUE_CREEPER_LIGHT_BLUE.get(),
                "blue", "light_blue");
        creeperStampEgg(TBAItems.COLORED_EGG_BLUE_CREEPER_MAGENTA.get(),
                "blue", "magenta");
        creeperStampEgg(TBAItems.COLORED_EGG_BLUE_CREEPER_ORANGE.get(),
                "blue", "orange");
        creeperStampEgg(TBAItems.COLORED_EGG_BLUE_CREEPER_WHITE.get(),
                "blue", "white");

        creeperStampEgg(TBAItems.COLORED_EGG_BROWN_CREEPER_BLACK.get(),
                "brown", "black");
        creeperStampEgg(TBAItems.COLORED_EGG_BROWN_CREEPER_RED.get(),
                "brown", "red");
        creeperStampEgg(TBAItems.COLORED_EGG_BROWN_CREEPER_GREEN.get(),
                "brown", "green");
        creeperStampEgg(TBAItems.COLORED_EGG_BROWN_CREEPER_BROWN.get(),
                "brown", "brown");
        creeperStampEgg(TBAItems.COLORED_EGG_BROWN_CREEPER_BLUE.get(),
                "brown", "blue");
        creeperStampEgg(TBAItems.COLORED_EGG_BROWN_CREEPER_PURPLE.get(),
                "brown", "purple");
        creeperStampEgg(TBAItems.COLORED_EGG_BROWN_CREEPER_CYAN.get(),
                "brown", "cyan");
        creeperStampEgg(TBAItems.COLORED_EGG_BROWN_CREEPER_LIGHT_GRAY.get(),
                "brown", "light_gray");
        creeperStampEgg(TBAItems.COLORED_EGG_BROWN_CREEPER_GRAY.get(),
                "brown", "gray");
        creeperStampEgg(TBAItems.COLORED_EGG_BROWN_CREEPER_PINK.get(),
                "brown", "pink");
        creeperStampEgg(TBAItems.COLORED_EGG_BROWN_CREEPER_LIME.get(),
                "brown", "lime");
        creeperStampEgg(TBAItems.COLORED_EGG_BROWN_CREEPER_YELLOW.get(),
                "brown", "yellow");
        creeperStampEgg(TBAItems.COLORED_EGG_BROWN_CREEPER_LIGHT_BLUE.get(),
                "brown", "light_blue");
        creeperStampEgg(TBAItems.COLORED_EGG_BROWN_CREEPER_MAGENTA.get(),
                "brown", "magenta");
        creeperStampEgg(TBAItems.COLORED_EGG_BROWN_CREEPER_ORANGE.get(),
                "brown", "orange");
        creeperStampEgg(TBAItems.COLORED_EGG_BROWN_CREEPER_WHITE.get(),
                "brown", "white");

        creeperStampEgg(TBAItems.COLORED_EGG_GREEN_CREEPER_BLACK.get(),
                "green", "black");
        creeperStampEgg(TBAItems.COLORED_EGG_GREEN_CREEPER_RED.get(),
                "green", "red");
        creeperStampEgg(TBAItems.COLORED_EGG_GREEN_CREEPER_GREEN.get(),
                "green", "green");
        creeperStampEgg(TBAItems.COLORED_EGG_GREEN_CREEPER_BROWN.get(),
                "green", "brown");
        creeperStampEgg(TBAItems.COLORED_EGG_GREEN_CREEPER_BLUE.get(),
                "green", "blue");
        creeperStampEgg(TBAItems.COLORED_EGG_GREEN_CREEPER_PURPLE.get(),
                "green", "purple");
        creeperStampEgg(TBAItems.COLORED_EGG_GREEN_CREEPER_CYAN.get(),
                "green", "cyan");
        creeperStampEgg(TBAItems.COLORED_EGG_GREEN_CREEPER_LIGHT_GRAY.get(),
                "green", "light_gray");
        creeperStampEgg(TBAItems.COLORED_EGG_GREEN_CREEPER_GRAY.get(),
                "green", "gray");
        creeperStampEgg(TBAItems.COLORED_EGG_GREEN_CREEPER_PINK.get(),
                "green", "pink");
        creeperStampEgg(TBAItems.COLORED_EGG_GREEN_CREEPER_LIME.get(),
                "green", "lime");
        creeperStampEgg(TBAItems.COLORED_EGG_GREEN_CREEPER_YELLOW.get(),
                "green", "yellow");
        creeperStampEgg(TBAItems.COLORED_EGG_GREEN_CREEPER_LIGHT_BLUE.get(),
                "green", "light_blue");
        creeperStampEgg(TBAItems.COLORED_EGG_GREEN_CREEPER_MAGENTA.get(),
                "green", "magenta");
        creeperStampEgg(TBAItems.COLORED_EGG_GREEN_CREEPER_ORANGE.get(),
                "green", "orange");
        creeperStampEgg(TBAItems.COLORED_EGG_GREEN_CREEPER_WHITE.get(),
                "green", "white");

        creeperStampEgg(TBAItems.COLORED_EGG_RED_CREEPER_BLACK.get(),
                "red", "black");
        creeperStampEgg(TBAItems.COLORED_EGG_RED_CREEPER_RED.get(),
                "red", "red");
        creeperStampEgg(TBAItems.COLORED_EGG_RED_CREEPER_GREEN.get(),
                "red", "green");
        creeperStampEgg(TBAItems.COLORED_EGG_RED_CREEPER_BROWN.get(),
                "red", "brown");
        creeperStampEgg(TBAItems.COLORED_EGG_RED_CREEPER_BLUE.get(),
                "red", "blue");
        creeperStampEgg(TBAItems.COLORED_EGG_RED_CREEPER_PURPLE.get(),
                "red", "purple");
        creeperStampEgg(TBAItems.COLORED_EGG_RED_CREEPER_CYAN.get(),
                "red", "cyan");
        creeperStampEgg(TBAItems.COLORED_EGG_RED_CREEPER_LIGHT_GRAY.get(),
                "red", "light_gray");
        creeperStampEgg(TBAItems.COLORED_EGG_RED_CREEPER_GRAY.get(),
                "red", "gray");
        creeperStampEgg(TBAItems.COLORED_EGG_RED_CREEPER_PINK.get(),
                "red", "pink");
        creeperStampEgg(TBAItems.COLORED_EGG_RED_CREEPER_LIME.get(),
                "red", "lime");
        creeperStampEgg(TBAItems.COLORED_EGG_RED_CREEPER_YELLOW.get(),
                "red", "yellow");
        creeperStampEgg(TBAItems.COLORED_EGG_RED_CREEPER_LIGHT_BLUE.get(),
                "red", "light_blue");
        creeperStampEgg(TBAItems.COLORED_EGG_RED_CREEPER_MAGENTA.get(),
                "red", "magenta");
        creeperStampEgg(TBAItems.COLORED_EGG_RED_CREEPER_ORANGE.get(),
                "red", "orange");
        creeperStampEgg(TBAItems.COLORED_EGG_RED_CREEPER_WHITE.get(),
                "red", "white");

        creeperStampEgg(TBAItems.COLORED_EGG_BLACK_CREEPER_BLACK.get(),
                "black", "black");
        creeperStampEgg(TBAItems.COLORED_EGG_BLACK_CREEPER_RED.get(),
                "black", "red");
        creeperStampEgg(TBAItems.COLORED_EGG_BLACK_CREEPER_GREEN.get(),
                "black", "green");
        creeperStampEgg(TBAItems.COLORED_EGG_BLACK_CREEPER_BROWN.get(),
                "black", "brown");
        creeperStampEgg(TBAItems.COLORED_EGG_BLACK_CREEPER_BLUE.get(),
                "black", "blue");
        creeperStampEgg(TBAItems.COLORED_EGG_BLACK_CREEPER_PURPLE.get(),
                "black", "purple");
        creeperStampEgg(TBAItems.COLORED_EGG_BLACK_CREEPER_CYAN.get(),
                "black", "cyan");
        creeperStampEgg(TBAItems.COLORED_EGG_BLACK_CREEPER_LIGHT_GRAY.get(),
                "black", "light_gray");
        creeperStampEgg(TBAItems.COLORED_EGG_BLACK_CREEPER_GRAY.get(),
                "black", "gray");
        creeperStampEgg(TBAItems.COLORED_EGG_BLACK_CREEPER_PINK.get(),
                "black", "pink");
        creeperStampEgg(TBAItems.COLORED_EGG_BLACK_CREEPER_LIME.get(),
                "black", "lime");
        creeperStampEgg(TBAItems.COLORED_EGG_BLACK_CREEPER_YELLOW.get(),
                "black", "yellow");
        creeperStampEgg(TBAItems.COLORED_EGG_BLACK_CREEPER_LIGHT_BLUE.get(),
                "black", "light_blue");
        creeperStampEgg(TBAItems.COLORED_EGG_BLACK_CREEPER_MAGENTA.get(),
                "black", "magenta");
        creeperStampEgg(TBAItems.COLORED_EGG_BLACK_CREEPER_ORANGE.get(),
                "black", "orange");
        creeperStampEgg(TBAItems.COLORED_EGG_BLACK_CREEPER_WHITE.get(),
                "black", "white");


        flowerStampEgg(TBAItems.COLORED_EGG_WHITE_FLOWER_BLACK.get(),
                "white", "black");
        flowerStampEgg(TBAItems.COLORED_EGG_WHITE_FLOWER_RED.get(),
                "white", "red");
        flowerStampEgg(TBAItems.COLORED_EGG_WHITE_FLOWER_GREEN.get(),
                "white", "green");
        flowerStampEgg(TBAItems.COLORED_EGG_WHITE_FLOWER_BROWN.get(),
                "white", "brown");
        flowerStampEgg(TBAItems.COLORED_EGG_WHITE_FLOWER_BLUE.get(),
                "white", "blue");
        flowerStampEgg(TBAItems.COLORED_EGG_WHITE_FLOWER_PURPLE.get(),
                "white", "purple");
        flowerStampEgg(TBAItems.COLORED_EGG_WHITE_FLOWER_CYAN.get(),
                "white", "cyan");
        flowerStampEgg(TBAItems.COLORED_EGG_WHITE_FLOWER_LIGHT_GRAY.get(),
                "white", "light_gray");
        flowerStampEgg(TBAItems.COLORED_EGG_WHITE_FLOWER_GRAY.get(),
                "white", "gray");
        flowerStampEgg(TBAItems.COLORED_EGG_WHITE_FLOWER_PINK.get(),
                "white", "pink");
        flowerStampEgg(TBAItems.COLORED_EGG_WHITE_FLOWER_LIME.get(),
                "white", "lime");
        flowerStampEgg(TBAItems.COLORED_EGG_WHITE_FLOWER_YELLOW.get(),
                "white", "yellow");
        flowerStampEgg(TBAItems.COLORED_EGG_WHITE_FLOWER_LIGHT_BLUE.get(),
                "white", "light_blue");
        flowerStampEgg(TBAItems.COLORED_EGG_WHITE_FLOWER_MAGENTA.get(),
                "white", "magenta");
        flowerStampEgg(TBAItems.COLORED_EGG_WHITE_FLOWER_ORANGE.get(),
                "white", "orange");
        flowerStampEgg(TBAItems.COLORED_EGG_WHITE_FLOWER_WHITE.get(),
                "white", "white");

        flowerStampEgg(TBAItems.COLORED_EGG_ORANGE_FLOWER_BLACK.get(),
                "orange", "black");
        flowerStampEgg(TBAItems.COLORED_EGG_ORANGE_FLOWER_RED.get(),
                "orange", "red");
        flowerStampEgg(TBAItems.COLORED_EGG_ORANGE_FLOWER_GREEN.get(),
                "orange", "green");
        flowerStampEgg(TBAItems.COLORED_EGG_ORANGE_FLOWER_BROWN.get(),
                "orange", "brown");
        flowerStampEgg(TBAItems.COLORED_EGG_ORANGE_FLOWER_BLUE.get(),
                "orange", "blue");
        flowerStampEgg(TBAItems.COLORED_EGG_ORANGE_FLOWER_PURPLE.get(),
                "orange", "purple");
        flowerStampEgg(TBAItems.COLORED_EGG_ORANGE_FLOWER_CYAN.get(),
                "orange", "cyan");
        flowerStampEgg(TBAItems.COLORED_EGG_ORANGE_FLOWER_LIGHT_GRAY.get(),
                "orange", "light_gray");
        flowerStampEgg(TBAItems.COLORED_EGG_ORANGE_FLOWER_GRAY.get(),
                "orange", "gray");
        flowerStampEgg(TBAItems.COLORED_EGG_ORANGE_FLOWER_PINK.get(),
                "orange", "pink");
        flowerStampEgg(TBAItems.COLORED_EGG_ORANGE_FLOWER_LIME.get(),
                "orange", "lime");
        flowerStampEgg(TBAItems.COLORED_EGG_ORANGE_FLOWER_YELLOW.get(),
                "orange", "yellow");
        flowerStampEgg(TBAItems.COLORED_EGG_ORANGE_FLOWER_LIGHT_BLUE.get(),
                "orange", "light_blue");
        flowerStampEgg(TBAItems.COLORED_EGG_ORANGE_FLOWER_MAGENTA.get(),
                "orange", "magenta");
        flowerStampEgg(TBAItems.COLORED_EGG_ORANGE_FLOWER_ORANGE.get(),
                "orange", "orange");
        flowerStampEgg(TBAItems.COLORED_EGG_ORANGE_FLOWER_WHITE.get(),
                "orange", "white");

        flowerStampEgg(TBAItems.COLORED_EGG_MAGENTA_FLOWER_BLACK.get(),
                "magenta", "black");
        flowerStampEgg(TBAItems.COLORED_EGG_MAGENTA_FLOWER_RED.get(),
                "magenta", "red");
        flowerStampEgg(TBAItems.COLORED_EGG_MAGENTA_FLOWER_GREEN.get(),
                "magenta", "green");
        flowerStampEgg(TBAItems.COLORED_EGG_MAGENTA_FLOWER_BROWN.get(),
                "magenta", "brown");
        flowerStampEgg(TBAItems.COLORED_EGG_MAGENTA_FLOWER_BLUE.get(),
                "magenta", "blue");
        flowerStampEgg(TBAItems.COLORED_EGG_MAGENTA_FLOWER_PURPLE.get(),
                "magenta", "purple");
        flowerStampEgg(TBAItems.COLORED_EGG_MAGENTA_FLOWER_CYAN.get(),
                "magenta", "cyan");
        flowerStampEgg(TBAItems.COLORED_EGG_MAGENTA_FLOWER_LIGHT_GRAY.get(),
                "magenta", "light_gray");
        flowerStampEgg(TBAItems.COLORED_EGG_MAGENTA_FLOWER_GRAY.get(),
                "magenta", "gray");
        flowerStampEgg(TBAItems.COLORED_EGG_MAGENTA_FLOWER_PINK.get(),
                "magenta", "pink");
        flowerStampEgg(TBAItems.COLORED_EGG_MAGENTA_FLOWER_LIME.get(),
                "magenta", "lime");
        flowerStampEgg(TBAItems.COLORED_EGG_MAGENTA_FLOWER_YELLOW.get(),
                "magenta", "yellow");
        flowerStampEgg(TBAItems.COLORED_EGG_MAGENTA_FLOWER_LIGHT_BLUE.get(),
                "magenta", "light_blue");
        flowerStampEgg(TBAItems.COLORED_EGG_MAGENTA_FLOWER_MAGENTA.get(),
                "magenta", "magenta");
        flowerStampEgg(TBAItems.COLORED_EGG_MAGENTA_FLOWER_ORANGE.get(),
                "magenta", "orange");
        flowerStampEgg(TBAItems.COLORED_EGG_MAGENTA_FLOWER_WHITE.get(),
                "magenta", "white");

        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_BLACK.get(),
                "light_blue", "black");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_RED.get(),
                "light_blue", "red");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_GREEN.get(),
                "light_blue", "green");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_BROWN.get(),
                "light_blue", "brown");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_BLUE.get(),
                "light_blue", "blue");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_PURPLE.get(),
                "light_blue", "purple");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_CYAN.get(),
                "light_blue", "cyan");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_LIGHT_GRAY.get(),
                "light_blue", "light_gray");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_GRAY.get(),
                "light_blue", "gray");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_PINK.get(),
                "light_blue", "pink");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_LIME.get(),
                "light_blue", "lime");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_YELLOW.get(),
                "light_blue", "yellow");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_LIGHT_BLUE.get(),
                "light_blue", "light_blue");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_MAGENTA.get(),
                "light_blue", "magenta");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_ORANGE.get(),
                "light_blue", "orange");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_WHITE.get(),
                "light_blue", "white");

        flowerStampEgg(TBAItems.COLORED_EGG_YELLOW_FLOWER_BLACK.get(),
                "yellow", "black");
        flowerStampEgg(TBAItems.COLORED_EGG_YELLOW_FLOWER_RED.get(),
                "yellow", "red");
        flowerStampEgg(TBAItems.COLORED_EGG_YELLOW_FLOWER_GREEN.get(),
                "yellow", "green");
        flowerStampEgg(TBAItems.COLORED_EGG_YELLOW_FLOWER_BROWN.get(),
                "yellow", "brown");
        flowerStampEgg(TBAItems.COLORED_EGG_YELLOW_FLOWER_BLUE.get(),
                "yellow", "blue");
        flowerStampEgg(TBAItems.COLORED_EGG_YELLOW_FLOWER_PURPLE.get(),
                "yellow", "purple");
        flowerStampEgg(TBAItems.COLORED_EGG_YELLOW_FLOWER_CYAN.get(),
                "yellow", "cyan");
        flowerStampEgg(TBAItems.COLORED_EGG_YELLOW_FLOWER_LIGHT_GRAY.get(),
                "yellow", "light_gray");
        flowerStampEgg(TBAItems.COLORED_EGG_YELLOW_FLOWER_GRAY.get(),
                "yellow", "gray");
        flowerStampEgg(TBAItems.COLORED_EGG_YELLOW_FLOWER_PINK.get(),
                "yellow", "pink");
        flowerStampEgg(TBAItems.COLORED_EGG_YELLOW_FLOWER_LIME.get(),
                "yellow", "lime");
        flowerStampEgg(TBAItems.COLORED_EGG_YELLOW_FLOWER_YELLOW.get(),
                "yellow", "yellow");
        flowerStampEgg(TBAItems.COLORED_EGG_YELLOW_FLOWER_LIGHT_BLUE.get(),
                "yellow", "light_blue");
        flowerStampEgg(TBAItems.COLORED_EGG_YELLOW_FLOWER_MAGENTA.get(),
                "yellow", "magenta");
        flowerStampEgg(TBAItems.COLORED_EGG_YELLOW_FLOWER_ORANGE.get(),
                "yellow", "orange");
        flowerStampEgg(TBAItems.COLORED_EGG_YELLOW_FLOWER_WHITE.get(),
                "yellow", "white");

        flowerStampEgg(TBAItems.COLORED_EGG_LIME_FLOWER_BLACK.get(),
                "lime", "black");
        flowerStampEgg(TBAItems.COLORED_EGG_LIME_FLOWER_RED.get(),
                "lime", "red");
        flowerStampEgg(TBAItems.COLORED_EGG_LIME_FLOWER_GREEN.get(),
                "lime", "green");
        flowerStampEgg(TBAItems.COLORED_EGG_LIME_FLOWER_BROWN.get(),
                "lime", "brown");
        flowerStampEgg(TBAItems.COLORED_EGG_LIME_FLOWER_BLUE.get(),
                "lime", "blue");
        flowerStampEgg(TBAItems.COLORED_EGG_LIME_FLOWER_PURPLE.get(),
                "lime", "purple");
        flowerStampEgg(TBAItems.COLORED_EGG_LIME_FLOWER_CYAN.get(),
                "lime", "cyan");
        flowerStampEgg(TBAItems.COLORED_EGG_LIME_FLOWER_LIGHT_GRAY.get(),
                "lime", "light_gray");
        flowerStampEgg(TBAItems.COLORED_EGG_LIME_FLOWER_GRAY.get(),
                "lime", "gray");
        flowerStampEgg(TBAItems.COLORED_EGG_LIME_FLOWER_PINK.get(),
                "lime", "pink");
        flowerStampEgg(TBAItems.COLORED_EGG_LIME_FLOWER_LIME.get(),
                "lime", "lime");
        flowerStampEgg(TBAItems.COLORED_EGG_LIME_FLOWER_YELLOW.get(),
                "lime", "yellow");
        flowerStampEgg(TBAItems.COLORED_EGG_LIME_FLOWER_LIGHT_BLUE.get(),
                "lime", "light_blue");
        flowerStampEgg(TBAItems.COLORED_EGG_LIME_FLOWER_MAGENTA.get(),
                "lime", "magenta");
        flowerStampEgg(TBAItems.COLORED_EGG_LIME_FLOWER_ORANGE.get(),
                "lime", "orange");
        flowerStampEgg(TBAItems.COLORED_EGG_LIME_FLOWER_WHITE.get(),
                "lime", "white");

        flowerStampEgg(TBAItems.COLORED_EGG_PINK_FLOWER_BLACK.get(),
                "pink", "black");
        flowerStampEgg(TBAItems.COLORED_EGG_PINK_FLOWER_RED.get(),
                "pink", "red");
        flowerStampEgg(TBAItems.COLORED_EGG_PINK_FLOWER_GREEN.get(),
                "pink", "green");
        flowerStampEgg(TBAItems.COLORED_EGG_PINK_FLOWER_BROWN.get(),
                "pink", "brown");
        flowerStampEgg(TBAItems.COLORED_EGG_PINK_FLOWER_BLUE.get(),
                "pink", "blue");
        flowerStampEgg(TBAItems.COLORED_EGG_PINK_FLOWER_PURPLE.get(),
                "pink", "purple");
        flowerStampEgg(TBAItems.COLORED_EGG_PINK_FLOWER_CYAN.get(),
                "pink", "cyan");
        flowerStampEgg(TBAItems.COLORED_EGG_PINK_FLOWER_LIGHT_GRAY.get(),
                "pink", "light_gray");
        flowerStampEgg(TBAItems.COLORED_EGG_PINK_FLOWER_GRAY.get(),
                "pink", "gray");
        flowerStampEgg(TBAItems.COLORED_EGG_PINK_FLOWER_PINK.get(),
                "pink", "pink");
        flowerStampEgg(TBAItems.COLORED_EGG_PINK_FLOWER_LIME.get(),
                "pink", "lime");
        flowerStampEgg(TBAItems.COLORED_EGG_PINK_FLOWER_YELLOW.get(),
                "pink", "yellow");
        flowerStampEgg(TBAItems.COLORED_EGG_PINK_FLOWER_LIGHT_BLUE.get(),
                "pink", "light_blue");
        flowerStampEgg(TBAItems.COLORED_EGG_PINK_FLOWER_MAGENTA.get(),
                "pink", "magenta");
        flowerStampEgg(TBAItems.COLORED_EGG_PINK_FLOWER_ORANGE.get(),
                "pink", "orange");
        flowerStampEgg(TBAItems.COLORED_EGG_PINK_FLOWER_WHITE.get(),
                "pink", "white");

        flowerStampEgg(TBAItems.COLORED_EGG_GRAY_FLOWER_BLACK.get(),
                "gray", "black");
        flowerStampEgg(TBAItems.COLORED_EGG_GRAY_FLOWER_RED.get(),
                "gray", "red");
        flowerStampEgg(TBAItems.COLORED_EGG_GRAY_FLOWER_GREEN.get(),
                "gray", "green");
        flowerStampEgg(TBAItems.COLORED_EGG_GRAY_FLOWER_BROWN.get(),
                "gray", "brown");
        flowerStampEgg(TBAItems.COLORED_EGG_GRAY_FLOWER_BLUE.get(),
                "gray", "blue");
        flowerStampEgg(TBAItems.COLORED_EGG_GRAY_FLOWER_PURPLE.get(),
                "gray", "purple");
        flowerStampEgg(TBAItems.COLORED_EGG_GRAY_FLOWER_CYAN.get(),
                "gray", "cyan");
        flowerStampEgg(TBAItems.COLORED_EGG_GRAY_FLOWER_LIGHT_GRAY.get(),
                "gray", "light_gray");
        flowerStampEgg(TBAItems.COLORED_EGG_GRAY_FLOWER_GRAY.get(),
                "gray", "gray");
        flowerStampEgg(TBAItems.COLORED_EGG_GRAY_FLOWER_PINK.get(),
                "gray", "pink");
        flowerStampEgg(TBAItems.COLORED_EGG_GRAY_FLOWER_LIME.get(),
                "gray", "lime");
        flowerStampEgg(TBAItems.COLORED_EGG_GRAY_FLOWER_YELLOW.get(),
                "gray", "yellow");
        flowerStampEgg(TBAItems.COLORED_EGG_GRAY_FLOWER_LIGHT_BLUE.get(),
                "gray", "light_blue");
        flowerStampEgg(TBAItems.COLORED_EGG_GRAY_FLOWER_MAGENTA.get(),
                "gray", "magenta");
        flowerStampEgg(TBAItems.COLORED_EGG_GRAY_FLOWER_ORANGE.get(),
                "gray", "orange");
        flowerStampEgg(TBAItems.COLORED_EGG_GRAY_FLOWER_WHITE.get(),
                "gray", "white");

        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_BLACK.get(),
                "light_gray", "black");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_RED.get(),
                "light_gray", "red");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_GREEN.get(),
                "light_gray", "green");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_BROWN.get(),
                "light_gray", "brown");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_BLUE.get(),
                "light_gray", "blue");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_PURPLE.get(),
                "light_gray", "purple");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_CYAN.get(),
                "light_gray", "cyan");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_LIGHT_GRAY.get(),
                "light_gray", "light_gray");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_GRAY.get(),
                "light_gray", "gray");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_PINK.get(),
                "light_gray", "pink");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_LIME.get(),
                "light_gray", "lime");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_YELLOW.get(),
                "light_gray", "yellow");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_LIGHT_BLUE.get(),
                "light_gray", "light_blue");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_MAGENTA.get(),
                "light_gray", "magenta");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_ORANGE.get(),
                "light_gray", "orange");
        flowerStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_WHITE.get(),
                "light_gray", "white");

        flowerStampEgg(TBAItems.COLORED_EGG_CYAN_FLOWER_BLACK.get(),
                "cyan", "black");
        flowerStampEgg(TBAItems.COLORED_EGG_CYAN_FLOWER_RED.get(),
                "cyan", "red");
        flowerStampEgg(TBAItems.COLORED_EGG_CYAN_FLOWER_GREEN.get(),
                "cyan", "green");
        flowerStampEgg(TBAItems.COLORED_EGG_CYAN_FLOWER_BROWN.get(),
                "cyan", "brown");
        flowerStampEgg(TBAItems.COLORED_EGG_CYAN_FLOWER_BLUE.get(),
                "cyan", "blue");
        flowerStampEgg(TBAItems.COLORED_EGG_CYAN_FLOWER_PURPLE.get(),
                "cyan", "purple");
        flowerStampEgg(TBAItems.COLORED_EGG_CYAN_FLOWER_CYAN.get(),
                "cyan", "cyan");
        flowerStampEgg(TBAItems.COLORED_EGG_CYAN_FLOWER_LIGHT_GRAY.get(),
                "cyan", "light_gray");
        flowerStampEgg(TBAItems.COLORED_EGG_CYAN_FLOWER_GRAY.get(),
                "cyan", "gray");
        flowerStampEgg(TBAItems.COLORED_EGG_CYAN_FLOWER_PINK.get(),
                "cyan", "pink");
        flowerStampEgg(TBAItems.COLORED_EGG_CYAN_FLOWER_LIME.get(),
                "cyan", "lime");
        flowerStampEgg(TBAItems.COLORED_EGG_CYAN_FLOWER_YELLOW.get(),
                "cyan", "yellow");
        flowerStampEgg(TBAItems.COLORED_EGG_CYAN_FLOWER_LIGHT_BLUE.get(),
                "cyan", "light_blue");
        flowerStampEgg(TBAItems.COLORED_EGG_CYAN_FLOWER_MAGENTA.get(),
                "cyan", "magenta");
        flowerStampEgg(TBAItems.COLORED_EGG_CYAN_FLOWER_ORANGE.get(),
                "cyan", "orange");
        flowerStampEgg(TBAItems.COLORED_EGG_CYAN_FLOWER_WHITE.get(),
                "cyan", "white");

        flowerStampEgg(TBAItems.COLORED_EGG_PURPLE_FLOWER_BLACK.get(),
                "purple", "black");
        flowerStampEgg(TBAItems.COLORED_EGG_PURPLE_FLOWER_RED.get(),
                "purple", "red");
        flowerStampEgg(TBAItems.COLORED_EGG_PURPLE_FLOWER_GREEN.get(),
                "purple", "green");
        flowerStampEgg(TBAItems.COLORED_EGG_PURPLE_FLOWER_BROWN.get(),
                "purple", "brown");
        flowerStampEgg(TBAItems.COLORED_EGG_PURPLE_FLOWER_BLUE.get(),
                "purple", "blue");
        flowerStampEgg(TBAItems.COLORED_EGG_PURPLE_FLOWER_PURPLE.get(),
                "purple", "purple");
        flowerStampEgg(TBAItems.COLORED_EGG_PURPLE_FLOWER_CYAN.get(),
                "purple", "cyan");
        flowerStampEgg(TBAItems.COLORED_EGG_PURPLE_FLOWER_LIGHT_GRAY.get(),
                "purple", "light_gray");
        flowerStampEgg(TBAItems.COLORED_EGG_PURPLE_FLOWER_GRAY.get(),
                "purple", "gray");
        flowerStampEgg(TBAItems.COLORED_EGG_PURPLE_FLOWER_PINK.get(),
                "purple", "pink");
        flowerStampEgg(TBAItems.COLORED_EGG_PURPLE_FLOWER_LIME.get(),
                "purple", "lime");
        flowerStampEgg(TBAItems.COLORED_EGG_PURPLE_FLOWER_YELLOW.get(),
                "purple", "yellow");
        flowerStampEgg(TBAItems.COLORED_EGG_PURPLE_FLOWER_LIGHT_BLUE.get(),
                "purple", "light_blue");
        flowerStampEgg(TBAItems.COLORED_EGG_PURPLE_FLOWER_MAGENTA.get(),
                "purple", "magenta");
        flowerStampEgg(TBAItems.COLORED_EGG_PURPLE_FLOWER_ORANGE.get(),
                "purple", "orange");
        flowerStampEgg(TBAItems.COLORED_EGG_PURPLE_FLOWER_WHITE.get(),
                "purple", "white");

        flowerStampEgg(TBAItems.COLORED_EGG_BLUE_FLOWER_BLACK.get(),
                "blue", "black");
        flowerStampEgg(TBAItems.COLORED_EGG_BLUE_FLOWER_RED.get(),
                "blue", "red");
        flowerStampEgg(TBAItems.COLORED_EGG_BLUE_FLOWER_GREEN.get(),
                "blue", "green");
        flowerStampEgg(TBAItems.COLORED_EGG_BLUE_FLOWER_BROWN.get(),
                "blue", "brown");
        flowerStampEgg(TBAItems.COLORED_EGG_BLUE_FLOWER_BLUE.get(),
                "blue", "blue");
        flowerStampEgg(TBAItems.COLORED_EGG_BLUE_FLOWER_PURPLE.get(),
                "blue", "purple");
        flowerStampEgg(TBAItems.COLORED_EGG_BLUE_FLOWER_CYAN.get(),
                "blue", "cyan");
        flowerStampEgg(TBAItems.COLORED_EGG_BLUE_FLOWER_LIGHT_GRAY.get(),
                "blue", "light_gray");
        flowerStampEgg(TBAItems.COLORED_EGG_BLUE_FLOWER_GRAY.get(),
                "blue", "gray");
        flowerStampEgg(TBAItems.COLORED_EGG_BLUE_FLOWER_PINK.get(),
                "blue", "pink");
        flowerStampEgg(TBAItems.COLORED_EGG_BLUE_FLOWER_LIME.get(),
                "blue", "lime");
        flowerStampEgg(TBAItems.COLORED_EGG_BLUE_FLOWER_YELLOW.get(),
                "blue", "yellow");
        flowerStampEgg(TBAItems.COLORED_EGG_BLUE_FLOWER_LIGHT_BLUE.get(),
                "blue", "light_blue");
        flowerStampEgg(TBAItems.COLORED_EGG_BLUE_FLOWER_MAGENTA.get(),
                "blue", "magenta");
        flowerStampEgg(TBAItems.COLORED_EGG_BLUE_FLOWER_ORANGE.get(),
                "blue", "orange");
        flowerStampEgg(TBAItems.COLORED_EGG_BLUE_FLOWER_WHITE.get(),
                "blue", "white");

        flowerStampEgg(TBAItems.COLORED_EGG_BROWN_FLOWER_BLACK.get(),
                "brown", "black");
        flowerStampEgg(TBAItems.COLORED_EGG_BROWN_FLOWER_RED.get(),
                "brown", "red");
        flowerStampEgg(TBAItems.COLORED_EGG_BROWN_FLOWER_GREEN.get(),
                "brown", "green");
        flowerStampEgg(TBAItems.COLORED_EGG_BROWN_FLOWER_BROWN.get(),
                "brown", "brown");
        flowerStampEgg(TBAItems.COLORED_EGG_BROWN_FLOWER_BLUE.get(),
                "brown", "blue");
        flowerStampEgg(TBAItems.COLORED_EGG_BROWN_FLOWER_PURPLE.get(),
                "brown", "purple");
        flowerStampEgg(TBAItems.COLORED_EGG_BROWN_FLOWER_CYAN.get(),
                "brown", "cyan");
        flowerStampEgg(TBAItems.COLORED_EGG_BROWN_FLOWER_LIGHT_GRAY.get(),
                "brown", "light_gray");
        flowerStampEgg(TBAItems.COLORED_EGG_BROWN_FLOWER_GRAY.get(),
                "brown", "gray");
        flowerStampEgg(TBAItems.COLORED_EGG_BROWN_FLOWER_PINK.get(),
                "brown", "pink");
        flowerStampEgg(TBAItems.COLORED_EGG_BROWN_FLOWER_LIME.get(),
                "brown", "lime");
        flowerStampEgg(TBAItems.COLORED_EGG_BROWN_FLOWER_YELLOW.get(),
                "brown", "yellow");
        flowerStampEgg(TBAItems.COLORED_EGG_BROWN_FLOWER_LIGHT_BLUE.get(),
                "brown", "light_blue");
        flowerStampEgg(TBAItems.COLORED_EGG_BROWN_FLOWER_MAGENTA.get(),
                "brown", "magenta");
        flowerStampEgg(TBAItems.COLORED_EGG_BROWN_FLOWER_ORANGE.get(),
                "brown", "orange");
        flowerStampEgg(TBAItems.COLORED_EGG_BROWN_FLOWER_WHITE.get(),
                "brown", "white");

        flowerStampEgg(TBAItems.COLORED_EGG_GREEN_FLOWER_BLACK.get(),
                "green", "black");
        flowerStampEgg(TBAItems.COLORED_EGG_GREEN_FLOWER_RED.get(),
                "green", "red");
        flowerStampEgg(TBAItems.COLORED_EGG_GREEN_FLOWER_GREEN.get(),
                "green", "green");
        flowerStampEgg(TBAItems.COLORED_EGG_GREEN_FLOWER_BROWN.get(),
                "green", "brown");
        flowerStampEgg(TBAItems.COLORED_EGG_GREEN_FLOWER_BLUE.get(),
                "green", "blue");
        flowerStampEgg(TBAItems.COLORED_EGG_GREEN_FLOWER_PURPLE.get(),
                "green", "purple");
        flowerStampEgg(TBAItems.COLORED_EGG_GREEN_FLOWER_CYAN.get(),
                "green", "cyan");
        flowerStampEgg(TBAItems.COLORED_EGG_GREEN_FLOWER_LIGHT_GRAY.get(),
                "green", "light_gray");
        flowerStampEgg(TBAItems.COLORED_EGG_GREEN_FLOWER_GRAY.get(),
                "green", "gray");
        flowerStampEgg(TBAItems.COLORED_EGG_GREEN_FLOWER_PINK.get(),
                "green", "pink");
        flowerStampEgg(TBAItems.COLORED_EGG_GREEN_FLOWER_LIME.get(),
                "green", "lime");
        flowerStampEgg(TBAItems.COLORED_EGG_GREEN_FLOWER_YELLOW.get(),
                "green", "yellow");
        flowerStampEgg(TBAItems.COLORED_EGG_GREEN_FLOWER_LIGHT_BLUE.get(),
                "green", "light_blue");
        flowerStampEgg(TBAItems.COLORED_EGG_GREEN_FLOWER_MAGENTA.get(),
                "green", "magenta");
        flowerStampEgg(TBAItems.COLORED_EGG_GREEN_FLOWER_ORANGE.get(),
                "green", "orange");
        flowerStampEgg(TBAItems.COLORED_EGG_GREEN_FLOWER_WHITE.get(),
                "green", "white");

        flowerStampEgg(TBAItems.COLORED_EGG_RED_FLOWER_BLACK.get(),
                "red", "black");
        flowerStampEgg(TBAItems.COLORED_EGG_RED_FLOWER_RED.get(),
                "red", "red");
        flowerStampEgg(TBAItems.COLORED_EGG_RED_FLOWER_GREEN.get(),
                "red", "green");
        flowerStampEgg(TBAItems.COLORED_EGG_RED_FLOWER_BROWN.get(),
                "red", "brown");
        flowerStampEgg(TBAItems.COLORED_EGG_RED_FLOWER_BLUE.get(),
                "red", "blue");
        flowerStampEgg(TBAItems.COLORED_EGG_RED_FLOWER_PURPLE.get(),
                "red", "purple");
        flowerStampEgg(TBAItems.COLORED_EGG_RED_FLOWER_CYAN.get(),
                "red", "cyan");
        flowerStampEgg(TBAItems.COLORED_EGG_RED_FLOWER_LIGHT_GRAY.get(),
                "red", "light_gray");
        flowerStampEgg(TBAItems.COLORED_EGG_RED_FLOWER_GRAY.get(),
                "red", "gray");
        flowerStampEgg(TBAItems.COLORED_EGG_RED_FLOWER_PINK.get(),
                "red", "pink");
        flowerStampEgg(TBAItems.COLORED_EGG_RED_FLOWER_LIME.get(),
                "red", "lime");
        flowerStampEgg(TBAItems.COLORED_EGG_RED_FLOWER_YELLOW.get(),
                "red", "yellow");
        flowerStampEgg(TBAItems.COLORED_EGG_RED_FLOWER_LIGHT_BLUE.get(),
                "red", "light_blue");
        flowerStampEgg(TBAItems.COLORED_EGG_RED_FLOWER_MAGENTA.get(),
                "red", "magenta");
        flowerStampEgg(TBAItems.COLORED_EGG_RED_FLOWER_ORANGE.get(),
                "red", "orange");
        flowerStampEgg(TBAItems.COLORED_EGG_RED_FLOWER_WHITE.get(),
                "red", "white");

        flowerStampEgg(TBAItems.COLORED_EGG_BLACK_FLOWER_BLACK.get(),
                "black", "black");
        flowerStampEgg(TBAItems.COLORED_EGG_BLACK_FLOWER_RED.get(),
                "black", "red");
        flowerStampEgg(TBAItems.COLORED_EGG_BLACK_FLOWER_GREEN.get(),
                "black", "green");
        flowerStampEgg(TBAItems.COLORED_EGG_BLACK_FLOWER_BROWN.get(),
                "black", "brown");
        flowerStampEgg(TBAItems.COLORED_EGG_BLACK_FLOWER_BLUE.get(),
                "black", "blue");
        flowerStampEgg(TBAItems.COLORED_EGG_BLACK_FLOWER_PURPLE.get(),
                "black", "purple");
        flowerStampEgg(TBAItems.COLORED_EGG_BLACK_FLOWER_CYAN.get(),
                "black", "cyan");
        flowerStampEgg(TBAItems.COLORED_EGG_BLACK_FLOWER_LIGHT_GRAY.get(),
                "black", "light_gray");
        flowerStampEgg(TBAItems.COLORED_EGG_BLACK_FLOWER_GRAY.get(),
                "black", "gray");
        flowerStampEgg(TBAItems.COLORED_EGG_BLACK_FLOWER_PINK.get(),
                "black", "pink");
        flowerStampEgg(TBAItems.COLORED_EGG_BLACK_FLOWER_LIME.get(),
                "black", "lime");
        flowerStampEgg(TBAItems.COLORED_EGG_BLACK_FLOWER_YELLOW.get(),
                "black", "yellow");
        flowerStampEgg(TBAItems.COLORED_EGG_BLACK_FLOWER_LIGHT_BLUE.get(),
                "black", "light_blue");
        flowerStampEgg(TBAItems.COLORED_EGG_BLACK_FLOWER_MAGENTA.get(),
                "black", "magenta");
        flowerStampEgg(TBAItems.COLORED_EGG_BLACK_FLOWER_ORANGE.get(),
                "black", "orange");
        flowerStampEgg(TBAItems.COLORED_EGG_BLACK_FLOWER_WHITE.get(),
                "black", "white");
    }

    private void eggStamp(Item eggStamp, String stampDesign) {
        ModelFile eggStampModel = new ModelFile.UncheckedModelFile(MODID + ":" + "item/template_egg_stamp");
        ResourceLocation eggTexture = new ResourceLocation("minecraft", "block/oak_planks");
        ResourceLocation stampTexture = new ResourceLocation("minecraft", "block/honeycomb_block");
        ResourceLocation stampDesignTexture = new ResourceLocation(MODID,
                "item/stamp_design_" + stampDesign);

        withExistingParent(itemName(eggStamp), eggStampModel.getLocation());

        getBuilder(String.valueOf(eggStamp))
                .parent(eggStampModel)
                .texture("layer0", eggTexture)
                .texture("layer1", stampTexture)
                .texture("layer2", stampDesignTexture);
    }

    private void flowerStampEgg(Item easterEgg, String eggColor, String stampColor) {
        ModelFile eggModel = new ModelFile.UncheckedModelFile(MODID + ":" + "item/template_stamped_egg");
        ResourceLocation eggTexture = new ResourceLocation(MODID,
                "item/colored_egg_" + eggColor);
        ResourceLocation stampTexture = new ResourceLocation(MODID,
                "item/checkered_stamp_" + stampColor);

        withExistingParent(itemName(easterEgg), eggModel.getLocation())
                .texture("layer0", eggTexture);

        getBuilder(String.valueOf(easterEgg))
                .parent(eggModel)
                .texture("layer0", eggTexture)
                .texture("layer1", stampTexture);
    }

    private void creeperStampEgg(Item easterEgg, String eggColor, String stampColor) {
        ModelFile eggModel = new ModelFile.UncheckedModelFile(MODID + ":" + "item/template_stamped_egg");
        ResourceLocation eggTexture = new ResourceLocation(MODID,
                "item/colored_egg_" + eggColor);
        ResourceLocation stampTexture = new ResourceLocation(MODID,
                "item/creeper_stamp_" + stampColor);

        withExistingParent(itemName(easterEgg), eggModel.getLocation())
                .texture("layer0", eggTexture);

        getBuilder(String.valueOf(easterEgg))
                .parent(eggModel)
                .texture("layer0", eggTexture)
                .texture("layer1", stampTexture);
    }

    private void spawnEggItem(ForgeSpawnEggItem item) {
        withExistingParent(itemName(item), mcLoc("template_spawn_egg"));
    }

    private void boiledEgg(Item item) {
        ModelFile eggModel = new ModelFile.UncheckedModelFile(MODID + ":" + "item/template_colored_egg");
        ResourceLocation eggTexture = new ResourceLocation(MODID, "item/colored_egg_light_gray");

        withExistingParent(itemName(item), eggModel.getLocation()).texture("layer0", eggTexture);
    }

    private void peeledEgg(Item item) {
        ModelFile eggModel = new ModelFile.UncheckedModelFile(MODID + ":" + "item/template_colored_egg");
        ResourceLocation eggTexture = new ResourceLocation(MODID, "item/colored_egg_white");

        withExistingParent(itemName(item), eggModel.getLocation()).texture("layer0", eggTexture);
    }

    public void blockBasedModel(Item item) {
        withExistingParent(itemName(item), resourceBlock(itemName(item)));
    }

    private @NotNull String itemName(Item item) {
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
    }

    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation(MODID, "block/" + path);
    }
}