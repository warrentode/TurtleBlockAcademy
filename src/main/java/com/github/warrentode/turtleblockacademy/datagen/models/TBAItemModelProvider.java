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

        spawnEggItem(TBAItems.HEROBRINE_SPAWN_EGG.get());
        spawnEggItem(TBAItems.TREASURE_BEETLE_SPAWN_EGG.get());

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


        checkeredStampEgg(TBAItems.COLORED_EGG_WHITE_CHECKERED_BLACK.get(),
                "white", "black");
        checkeredStampEgg(TBAItems.COLORED_EGG_WHITE_CHECKERED_RED.get(),
                "white", "red");
        checkeredStampEgg(TBAItems.COLORED_EGG_WHITE_CHECKERED_GREEN.get(),
                "white", "green");
        checkeredStampEgg(TBAItems.COLORED_EGG_WHITE_CHECKERED_BROWN.get(),
                "white", "brown");
        checkeredStampEgg(TBAItems.COLORED_EGG_WHITE_CHECKERED_BLUE.get(),
                "white", "blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_WHITE_CHECKERED_PURPLE.get(),
                "white", "purple");
        checkeredStampEgg(TBAItems.COLORED_EGG_WHITE_CHECKERED_CYAN.get(),
                "white", "cyan");
        checkeredStampEgg(TBAItems.COLORED_EGG_WHITE_CHECKERED_LIGHT_GRAY.get(),
                "white", "light_gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_WHITE_CHECKERED_GRAY.get(),
                "white", "gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_WHITE_CHECKERED_PINK.get(),
                "white", "pink");
        checkeredStampEgg(TBAItems.COLORED_EGG_WHITE_CHECKERED_LIME.get(),
                "white", "lime");
        checkeredStampEgg(TBAItems.COLORED_EGG_WHITE_CHECKERED_YELLOW.get(),
                "white", "yellow");
        checkeredStampEgg(TBAItems.COLORED_EGG_WHITE_CHECKERED_LIGHT_BLUE.get(),
                "white", "light_blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_WHITE_CHECKERED_MAGENTA.get(),
                "white", "magenta");
        checkeredStampEgg(TBAItems.COLORED_EGG_WHITE_CHECKERED_ORANGE.get(),
                "white", "orange");
        checkeredStampEgg(TBAItems.COLORED_EGG_WHITE_CHECKERED_WHITE.get(),
                "white", "white");

        checkeredStampEgg(TBAItems.COLORED_EGG_ORANGE_CHECKERED_BLACK.get(),
                "orange", "black");
        checkeredStampEgg(TBAItems.COLORED_EGG_ORANGE_CHECKERED_RED.get(),
                "orange", "red");
        checkeredStampEgg(TBAItems.COLORED_EGG_ORANGE_CHECKERED_GREEN.get(),
                "orange", "green");
        checkeredStampEgg(TBAItems.COLORED_EGG_ORANGE_CHECKERED_BROWN.get(),
                "orange", "brown");
        checkeredStampEgg(TBAItems.COLORED_EGG_ORANGE_CHECKERED_BLUE.get(),
                "orange", "blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_ORANGE_CHECKERED_PURPLE.get(),
                "orange", "purple");
        checkeredStampEgg(TBAItems.COLORED_EGG_ORANGE_CHECKERED_CYAN.get(),
                "orange", "cyan");
        checkeredStampEgg(TBAItems.COLORED_EGG_ORANGE_CHECKERED_LIGHT_GRAY.get(),
                "orange", "light_gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_ORANGE_CHECKERED_GRAY.get(),
                "orange", "gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_ORANGE_CHECKERED_PINK.get(),
                "orange", "pink");
        checkeredStampEgg(TBAItems.COLORED_EGG_ORANGE_CHECKERED_LIME.get(),
                "orange", "lime");
        checkeredStampEgg(TBAItems.COLORED_EGG_ORANGE_CHECKERED_YELLOW.get(),
                "orange", "yellow");
        checkeredStampEgg(TBAItems.COLORED_EGG_ORANGE_CHECKERED_LIGHT_BLUE.get(),
                "orange", "light_blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_ORANGE_CHECKERED_MAGENTA.get(),
                "orange", "magenta");
        checkeredStampEgg(TBAItems.COLORED_EGG_ORANGE_CHECKERED_ORANGE.get(),
                "orange", "orange");
        checkeredStampEgg(TBAItems.COLORED_EGG_ORANGE_CHECKERED_WHITE.get(),
                "orange", "white");

        checkeredStampEgg(TBAItems.COLORED_EGG_MAGENTA_CHECKERED_BLACK.get(),
                "magenta", "black");
        checkeredStampEgg(TBAItems.COLORED_EGG_MAGENTA_CHECKERED_RED.get(),
                "magenta", "red");
        checkeredStampEgg(TBAItems.COLORED_EGG_MAGENTA_CHECKERED_GREEN.get(),
                "magenta", "green");
        checkeredStampEgg(TBAItems.COLORED_EGG_MAGENTA_CHECKERED_BROWN.get(),
                "magenta", "brown");
        checkeredStampEgg(TBAItems.COLORED_EGG_MAGENTA_CHECKERED_BLUE.get(),
                "magenta", "blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_MAGENTA_CHECKERED_PURPLE.get(),
                "magenta", "purple");
        checkeredStampEgg(TBAItems.COLORED_EGG_MAGENTA_CHECKERED_CYAN.get(),
                "magenta", "cyan");
        checkeredStampEgg(TBAItems.COLORED_EGG_MAGENTA_CHECKERED_LIGHT_GRAY.get(),
                "magenta", "light_gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_MAGENTA_CHECKERED_GRAY.get(),
                "magenta", "gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_MAGENTA_CHECKERED_PINK.get(),
                "magenta", "pink");
        checkeredStampEgg(TBAItems.COLORED_EGG_MAGENTA_CHECKERED_LIME.get(),
                "magenta", "lime");
        checkeredStampEgg(TBAItems.COLORED_EGG_MAGENTA_CHECKERED_YELLOW.get(),
                "magenta", "yellow");
        checkeredStampEgg(TBAItems.COLORED_EGG_MAGENTA_CHECKERED_LIGHT_BLUE.get(),
                "magenta", "light_blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_MAGENTA_CHECKERED_MAGENTA.get(),
                "magenta", "magenta");
        checkeredStampEgg(TBAItems.COLORED_EGG_MAGENTA_CHECKERED_ORANGE.get(),
                "magenta", "orange");
        checkeredStampEgg(TBAItems.COLORED_EGG_MAGENTA_CHECKERED_WHITE.get(),
                "magenta", "white");

        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CHECKERED_BLACK.get(),
                "light_blue", "black");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CHECKERED_RED.get(),
                "light_blue", "red");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CHECKERED_GREEN.get(),
                "light_blue", "green");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CHECKERED_BROWN.get(),
                "light_blue", "brown");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CHECKERED_BLUE.get(),
                "light_blue", "blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CHECKERED_PURPLE.get(),
                "light_blue", "purple");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CHECKERED_CYAN.get(),
                "light_blue", "cyan");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CHECKERED_LIGHT_GRAY.get(),
                "light_blue", "light_gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CHECKERED_GRAY.get(),
                "light_blue", "gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CHECKERED_PINK.get(),
                "light_blue", "pink");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CHECKERED_LIME.get(),
                "light_blue", "lime");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CHECKERED_YELLOW.get(),
                "light_blue", "yellow");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CHECKERED_LIGHT_BLUE.get(),
                "light_blue", "light_blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CHECKERED_MAGENTA.get(),
                "light_blue", "magenta");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CHECKERED_ORANGE.get(),
                "light_blue", "orange");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_BLUE_CHECKERED_WHITE.get(),
                "light_blue", "white");

        checkeredStampEgg(TBAItems.COLORED_EGG_YELLOW_CHECKERED_BLACK.get(),
                "yellow", "black");
        checkeredStampEgg(TBAItems.COLORED_EGG_YELLOW_CHECKERED_RED.get(),
                "yellow", "red");
        checkeredStampEgg(TBAItems.COLORED_EGG_YELLOW_CHECKERED_GREEN.get(),
                "yellow", "green");
        checkeredStampEgg(TBAItems.COLORED_EGG_YELLOW_CHECKERED_BROWN.get(),
                "yellow", "brown");
        checkeredStampEgg(TBAItems.COLORED_EGG_YELLOW_CHECKERED_BLUE.get(),
                "yellow", "blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_YELLOW_CHECKERED_PURPLE.get(),
                "yellow", "purple");
        checkeredStampEgg(TBAItems.COLORED_EGG_YELLOW_CHECKERED_CYAN.get(),
                "yellow", "cyan");
        checkeredStampEgg(TBAItems.COLORED_EGG_YELLOW_CHECKERED_LIGHT_GRAY.get(),
                "yellow", "light_gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_YELLOW_CHECKERED_GRAY.get(),
                "yellow", "gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_YELLOW_CHECKERED_PINK.get(),
                "yellow", "pink");
        checkeredStampEgg(TBAItems.COLORED_EGG_YELLOW_CHECKERED_LIME.get(),
                "yellow", "lime");
        checkeredStampEgg(TBAItems.COLORED_EGG_YELLOW_CHECKERED_YELLOW.get(),
                "yellow", "yellow");
        checkeredStampEgg(TBAItems.COLORED_EGG_YELLOW_CHECKERED_LIGHT_BLUE.get(),
                "yellow", "light_blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_YELLOW_CHECKERED_MAGENTA.get(),
                "yellow", "magenta");
        checkeredStampEgg(TBAItems.COLORED_EGG_YELLOW_CHECKERED_ORANGE.get(),
                "yellow", "orange");
        checkeredStampEgg(TBAItems.COLORED_EGG_YELLOW_CHECKERED_WHITE.get(),
                "yellow", "white");

        checkeredStampEgg(TBAItems.COLORED_EGG_LIME_CHECKERED_BLACK.get(),
                "lime", "black");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIME_CHECKERED_RED.get(),
                "lime", "red");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIME_CHECKERED_GREEN.get(),
                "lime", "green");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIME_CHECKERED_BROWN.get(),
                "lime", "brown");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIME_CHECKERED_BLUE.get(),
                "lime", "blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIME_CHECKERED_PURPLE.get(),
                "lime", "purple");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIME_CHECKERED_CYAN.get(),
                "lime", "cyan");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIME_CHECKERED_LIGHT_GRAY.get(),
                "lime", "light_gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIME_CHECKERED_GRAY.get(),
                "lime", "gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIME_CHECKERED_PINK.get(),
                "lime", "pink");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIME_CHECKERED_LIME.get(),
                "lime", "lime");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIME_CHECKERED_YELLOW.get(),
                "lime", "yellow");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIME_CHECKERED_LIGHT_BLUE.get(),
                "lime", "light_blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIME_CHECKERED_MAGENTA.get(),
                "lime", "magenta");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIME_CHECKERED_ORANGE.get(),
                "lime", "orange");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIME_CHECKERED_WHITE.get(),
                "lime", "white");

        checkeredStampEgg(TBAItems.COLORED_EGG_PINK_CHECKERED_BLACK.get(),
                "pink", "black");
        checkeredStampEgg(TBAItems.COLORED_EGG_PINK_CHECKERED_RED.get(),
                "pink", "red");
        checkeredStampEgg(TBAItems.COLORED_EGG_PINK_CHECKERED_GREEN.get(),
                "pink", "green");
        checkeredStampEgg(TBAItems.COLORED_EGG_PINK_CHECKERED_BROWN.get(),
                "pink", "brown");
        checkeredStampEgg(TBAItems.COLORED_EGG_PINK_CHECKERED_BLUE.get(),
                "pink", "blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_PINK_CHECKERED_PURPLE.get(),
                "pink", "purple");
        checkeredStampEgg(TBAItems.COLORED_EGG_PINK_CHECKERED_CYAN.get(),
                "pink", "cyan");
        checkeredStampEgg(TBAItems.COLORED_EGG_PINK_CHECKERED_LIGHT_GRAY.get(),
                "pink", "light_gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_PINK_CHECKERED_GRAY.get(),
                "pink", "gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_PINK_CHECKERED_PINK.get(),
                "pink", "pink");
        checkeredStampEgg(TBAItems.COLORED_EGG_PINK_CHECKERED_LIME.get(),
                "pink", "lime");
        checkeredStampEgg(TBAItems.COLORED_EGG_PINK_CHECKERED_YELLOW.get(),
                "pink", "yellow");
        checkeredStampEgg(TBAItems.COLORED_EGG_PINK_CHECKERED_LIGHT_BLUE.get(),
                "pink", "light_blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_PINK_CHECKERED_MAGENTA.get(),
                "pink", "magenta");
        checkeredStampEgg(TBAItems.COLORED_EGG_PINK_CHECKERED_ORANGE.get(),
                "pink", "orange");
        checkeredStampEgg(TBAItems.COLORED_EGG_PINK_CHECKERED_WHITE.get(),
                "pink", "white");

        checkeredStampEgg(TBAItems.COLORED_EGG_GRAY_CHECKERED_BLACK.get(),
                "gray", "black");
        checkeredStampEgg(TBAItems.COLORED_EGG_GRAY_CHECKERED_RED.get(),
                "gray", "red");
        checkeredStampEgg(TBAItems.COLORED_EGG_GRAY_CHECKERED_GREEN.get(),
                "gray", "green");
        checkeredStampEgg(TBAItems.COLORED_EGG_GRAY_CHECKERED_BROWN.get(),
                "gray", "brown");
        checkeredStampEgg(TBAItems.COLORED_EGG_GRAY_CHECKERED_BLUE.get(),
                "gray", "blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_GRAY_CHECKERED_PURPLE.get(),
                "gray", "purple");
        checkeredStampEgg(TBAItems.COLORED_EGG_GRAY_CHECKERED_CYAN.get(),
                "gray", "cyan");
        checkeredStampEgg(TBAItems.COLORED_EGG_GRAY_CHECKERED_LIGHT_GRAY.get(),
                "gray", "light_gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_GRAY_CHECKERED_GRAY.get(),
                "gray", "gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_GRAY_CHECKERED_PINK.get(),
                "gray", "pink");
        checkeredStampEgg(TBAItems.COLORED_EGG_GRAY_CHECKERED_LIME.get(),
                "gray", "lime");
        checkeredStampEgg(TBAItems.COLORED_EGG_GRAY_CHECKERED_YELLOW.get(),
                "gray", "yellow");
        checkeredStampEgg(TBAItems.COLORED_EGG_GRAY_CHECKERED_LIGHT_BLUE.get(),
                "gray", "light_blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_GRAY_CHECKERED_MAGENTA.get(),
                "gray", "magenta");
        checkeredStampEgg(TBAItems.COLORED_EGG_GRAY_CHECKERED_ORANGE.get(),
                "gray", "orange");
        checkeredStampEgg(TBAItems.COLORED_EGG_GRAY_CHECKERED_WHITE.get(),
                "gray", "white");

        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CHECKERED_BLACK.get(),
                "light_gray", "black");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CHECKERED_RED.get(),
                "light_gray", "red");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CHECKERED_GREEN.get(),
                "light_gray", "green");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CHECKERED_BROWN.get(),
                "light_gray", "brown");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CHECKERED_BLUE.get(),
                "light_gray", "blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CHECKERED_PURPLE.get(),
                "light_gray", "purple");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CHECKERED_CYAN.get(),
                "light_gray", "cyan");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CHECKERED_LIGHT_GRAY.get(),
                "light_gray", "light_gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CHECKERED_GRAY.get(),
                "light_gray", "gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CHECKERED_PINK.get(),
                "light_gray", "pink");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CHECKERED_LIME.get(),
                "light_gray", "lime");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CHECKERED_YELLOW.get(),
                "light_gray", "yellow");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CHECKERED_LIGHT_BLUE.get(),
                "light_gray", "light_blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CHECKERED_MAGENTA.get(),
                "light_gray", "magenta");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CHECKERED_ORANGE.get(),
                "light_gray", "orange");
        checkeredStampEgg(TBAItems.COLORED_EGG_LIGHT_GRAY_CHECKERED_WHITE.get(),
                "light_gray", "white");

        checkeredStampEgg(TBAItems.COLORED_EGG_CYAN_CHECKERED_BLACK.get(),
                "cyan", "black");
        checkeredStampEgg(TBAItems.COLORED_EGG_CYAN_CHECKERED_RED.get(),
                "cyan", "red");
        checkeredStampEgg(TBAItems.COLORED_EGG_CYAN_CHECKERED_GREEN.get(),
                "cyan", "green");
        checkeredStampEgg(TBAItems.COLORED_EGG_CYAN_CHECKERED_BROWN.get(),
                "cyan", "brown");
        checkeredStampEgg(TBAItems.COLORED_EGG_CYAN_CHECKERED_BLUE.get(),
                "cyan", "blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_CYAN_CHECKERED_PURPLE.get(),
                "cyan", "purple");
        checkeredStampEgg(TBAItems.COLORED_EGG_CYAN_CHECKERED_CYAN.get(),
                "cyan", "cyan");
        checkeredStampEgg(TBAItems.COLORED_EGG_CYAN_CHECKERED_LIGHT_GRAY.get(),
                "cyan", "light_gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_CYAN_CHECKERED_GRAY.get(),
                "cyan", "gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_CYAN_CHECKERED_PINK.get(),
                "cyan", "pink");
        checkeredStampEgg(TBAItems.COLORED_EGG_CYAN_CHECKERED_LIME.get(),
                "cyan", "lime");
        checkeredStampEgg(TBAItems.COLORED_EGG_CYAN_CHECKERED_YELLOW.get(),
                "cyan", "yellow");
        checkeredStampEgg(TBAItems.COLORED_EGG_CYAN_CHECKERED_LIGHT_BLUE.get(),
                "cyan", "light_blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_CYAN_CHECKERED_MAGENTA.get(),
                "cyan", "magenta");
        checkeredStampEgg(TBAItems.COLORED_EGG_CYAN_CHECKERED_ORANGE.get(),
                "cyan", "orange");
        checkeredStampEgg(TBAItems.COLORED_EGG_CYAN_CHECKERED_WHITE.get(),
                "cyan", "white");

        checkeredStampEgg(TBAItems.COLORED_EGG_PURPLE_CHECKERED_BLACK.get(),
                "purple", "black");
        checkeredStampEgg(TBAItems.COLORED_EGG_PURPLE_CHECKERED_RED.get(),
                "purple", "red");
        checkeredStampEgg(TBAItems.COLORED_EGG_PURPLE_CHECKERED_GREEN.get(),
                "purple", "green");
        checkeredStampEgg(TBAItems.COLORED_EGG_PURPLE_CHECKERED_BROWN.get(),
                "purple", "brown");
        checkeredStampEgg(TBAItems.COLORED_EGG_PURPLE_CHECKERED_BLUE.get(),
                "purple", "blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_PURPLE_CHECKERED_PURPLE.get(),
                "purple", "purple");
        checkeredStampEgg(TBAItems.COLORED_EGG_PURPLE_CHECKERED_CYAN.get(),
                "purple", "cyan");
        checkeredStampEgg(TBAItems.COLORED_EGG_PURPLE_CHECKERED_LIGHT_GRAY.get(),
                "purple", "light_gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_PURPLE_CHECKERED_GRAY.get(),
                "purple", "gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_PURPLE_CHECKERED_PINK.get(),
                "purple", "pink");
        checkeredStampEgg(TBAItems.COLORED_EGG_PURPLE_CHECKERED_LIME.get(),
                "purple", "lime");
        checkeredStampEgg(TBAItems.COLORED_EGG_PURPLE_CHECKERED_YELLOW.get(),
                "purple", "yellow");
        checkeredStampEgg(TBAItems.COLORED_EGG_PURPLE_CHECKERED_LIGHT_BLUE.get(),
                "purple", "light_blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_PURPLE_CHECKERED_MAGENTA.get(),
                "purple", "magenta");
        checkeredStampEgg(TBAItems.COLORED_EGG_PURPLE_CHECKERED_ORANGE.get(),
                "purple", "orange");
        checkeredStampEgg(TBAItems.COLORED_EGG_PURPLE_CHECKERED_WHITE.get(),
                "purple", "white");

        checkeredStampEgg(TBAItems.COLORED_EGG_BLUE_CHECKERED_BLACK.get(),
                "blue", "black");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLUE_CHECKERED_RED.get(),
                "blue", "red");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLUE_CHECKERED_GREEN.get(),
                "blue", "green");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLUE_CHECKERED_BROWN.get(),
                "blue", "brown");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLUE_CHECKERED_BLUE.get(),
                "blue", "blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLUE_CHECKERED_PURPLE.get(),
                "blue", "purple");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLUE_CHECKERED_CYAN.get(),
                "blue", "cyan");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLUE_CHECKERED_LIGHT_GRAY.get(),
                "blue", "light_gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLUE_CHECKERED_GRAY.get(),
                "blue", "gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLUE_CHECKERED_PINK.get(),
                "blue", "pink");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLUE_CHECKERED_LIME.get(),
                "blue", "lime");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLUE_CHECKERED_YELLOW.get(),
                "blue", "yellow");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLUE_CHECKERED_LIGHT_BLUE.get(),
                "blue", "light_blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLUE_CHECKERED_MAGENTA.get(),
                "blue", "magenta");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLUE_CHECKERED_ORANGE.get(),
                "blue", "orange");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLUE_CHECKERED_WHITE.get(),
                "blue", "white");

        checkeredStampEgg(TBAItems.COLORED_EGG_BROWN_CHECKERED_BLACK.get(),
                "brown", "black");
        checkeredStampEgg(TBAItems.COLORED_EGG_BROWN_CHECKERED_RED.get(),
                "brown", "red");
        checkeredStampEgg(TBAItems.COLORED_EGG_BROWN_CHECKERED_GREEN.get(),
                "brown", "green");
        checkeredStampEgg(TBAItems.COLORED_EGG_BROWN_CHECKERED_BROWN.get(),
                "brown", "brown");
        checkeredStampEgg(TBAItems.COLORED_EGG_BROWN_CHECKERED_BLUE.get(),
                "brown", "blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_BROWN_CHECKERED_PURPLE.get(),
                "brown", "purple");
        checkeredStampEgg(TBAItems.COLORED_EGG_BROWN_CHECKERED_CYAN.get(),
                "brown", "cyan");
        checkeredStampEgg(TBAItems.COLORED_EGG_BROWN_CHECKERED_LIGHT_GRAY.get(),
                "brown", "light_gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_BROWN_CHECKERED_GRAY.get(),
                "brown", "gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_BROWN_CHECKERED_PINK.get(),
                "brown", "pink");
        checkeredStampEgg(TBAItems.COLORED_EGG_BROWN_CHECKERED_LIME.get(),
                "brown", "lime");
        checkeredStampEgg(TBAItems.COLORED_EGG_BROWN_CHECKERED_YELLOW.get(),
                "brown", "yellow");
        checkeredStampEgg(TBAItems.COLORED_EGG_BROWN_CHECKERED_LIGHT_BLUE.get(),
                "brown", "light_blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_BROWN_CHECKERED_MAGENTA.get(),
                "brown", "magenta");
        checkeredStampEgg(TBAItems.COLORED_EGG_BROWN_CHECKERED_ORANGE.get(),
                "brown", "orange");
        checkeredStampEgg(TBAItems.COLORED_EGG_BROWN_CHECKERED_WHITE.get(),
                "brown", "white");

        checkeredStampEgg(TBAItems.COLORED_EGG_GREEN_CHECKERED_BLACK.get(),
                "green", "black");
        checkeredStampEgg(TBAItems.COLORED_EGG_GREEN_CHECKERED_RED.get(),
                "green", "red");
        checkeredStampEgg(TBAItems.COLORED_EGG_GREEN_CHECKERED_GREEN.get(),
                "green", "green");
        checkeredStampEgg(TBAItems.COLORED_EGG_GREEN_CHECKERED_BROWN.get(),
                "green", "brown");
        checkeredStampEgg(TBAItems.COLORED_EGG_GREEN_CHECKERED_BLUE.get(),
                "green", "blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_GREEN_CHECKERED_PURPLE.get(),
                "green", "purple");
        checkeredStampEgg(TBAItems.COLORED_EGG_GREEN_CHECKERED_CYAN.get(),
                "green", "cyan");
        checkeredStampEgg(TBAItems.COLORED_EGG_GREEN_CHECKERED_LIGHT_GRAY.get(),
                "green", "light_gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_GREEN_CHECKERED_GRAY.get(),
                "green", "gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_GREEN_CHECKERED_PINK.get(),
                "green", "pink");
        checkeredStampEgg(TBAItems.COLORED_EGG_GREEN_CHECKERED_LIME.get(),
                "green", "lime");
        checkeredStampEgg(TBAItems.COLORED_EGG_GREEN_CHECKERED_YELLOW.get(),
                "green", "yellow");
        checkeredStampEgg(TBAItems.COLORED_EGG_GREEN_CHECKERED_LIGHT_BLUE.get(),
                "green", "light_blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_GREEN_CHECKERED_MAGENTA.get(),
                "green", "magenta");
        checkeredStampEgg(TBAItems.COLORED_EGG_GREEN_CHECKERED_ORANGE.get(),
                "green", "orange");
        checkeredStampEgg(TBAItems.COLORED_EGG_GREEN_CHECKERED_WHITE.get(),
                "green", "white");

        checkeredStampEgg(TBAItems.COLORED_EGG_RED_CHECKERED_BLACK.get(),
                "red", "black");
        checkeredStampEgg(TBAItems.COLORED_EGG_RED_CHECKERED_RED.get(),
                "red", "red");
        checkeredStampEgg(TBAItems.COLORED_EGG_RED_CHECKERED_GREEN.get(),
                "red", "green");
        checkeredStampEgg(TBAItems.COLORED_EGG_RED_CHECKERED_BROWN.get(),
                "red", "brown");
        checkeredStampEgg(TBAItems.COLORED_EGG_RED_CHECKERED_BLUE.get(),
                "red", "blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_RED_CHECKERED_PURPLE.get(),
                "red", "purple");
        checkeredStampEgg(TBAItems.COLORED_EGG_RED_CHECKERED_CYAN.get(),
                "red", "cyan");
        checkeredStampEgg(TBAItems.COLORED_EGG_RED_CHECKERED_LIGHT_GRAY.get(),
                "red", "light_gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_RED_CHECKERED_GRAY.get(),
                "red", "gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_RED_CHECKERED_PINK.get(),
                "red", "pink");
        checkeredStampEgg(TBAItems.COLORED_EGG_RED_CHECKERED_LIME.get(),
                "red", "lime");
        checkeredStampEgg(TBAItems.COLORED_EGG_RED_CHECKERED_YELLOW.get(),
                "red", "yellow");
        checkeredStampEgg(TBAItems.COLORED_EGG_RED_CHECKERED_LIGHT_BLUE.get(),
                "red", "light_blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_RED_CHECKERED_MAGENTA.get(),
                "red", "magenta");
        checkeredStampEgg(TBAItems.COLORED_EGG_RED_CHECKERED_ORANGE.get(),
                "red", "orange");
        checkeredStampEgg(TBAItems.COLORED_EGG_RED_CHECKERED_WHITE.get(),
                "red", "white");

        checkeredStampEgg(TBAItems.COLORED_EGG_BLACK_CHECKERED_BLACK.get(),
                "black", "black");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLACK_CHECKERED_RED.get(),
                "black", "red");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLACK_CHECKERED_GREEN.get(),
                "black", "green");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLACK_CHECKERED_BROWN.get(),
                "black", "brown");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLACK_CHECKERED_BLUE.get(),
                "black", "blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLACK_CHECKERED_PURPLE.get(),
                "black", "purple");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLACK_CHECKERED_CYAN.get(),
                "black", "cyan");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLACK_CHECKERED_LIGHT_GRAY.get(),
                "black", "light_gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLACK_CHECKERED_GRAY.get(),
                "black", "gray");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLACK_CHECKERED_PINK.get(),
                "black", "pink");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLACK_CHECKERED_LIME.get(),
                "black", "lime");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLACK_CHECKERED_YELLOW.get(),
                "black", "yellow");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLACK_CHECKERED_LIGHT_BLUE.get(),
                "black", "light_blue");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLACK_CHECKERED_MAGENTA.get(),
                "black", "magenta");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLACK_CHECKERED_ORANGE.get(),
                "black", "orange");
        checkeredStampEgg(TBAItems.COLORED_EGG_BLACK_CHECKERED_WHITE.get(),
                "black", "white");
    }

    private void checkeredStampEgg(Item easterEgg, String eggColor, String stampColor) {
        ModelFile eggModel = new ModelFile.UncheckedModelFile(MODID + ":" + "item/template_colored_egg");
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
        ModelFile eggModel = new ModelFile.UncheckedModelFile(MODID + ":" + "item/template_colored_egg");
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
        withExistingParent(String.valueOf(item), mcLoc("template_spawn_egg"));
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
