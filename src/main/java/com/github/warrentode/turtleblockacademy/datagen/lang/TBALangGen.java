package com.github.warrentode.turtleblockacademy.datagen.lang;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.items.TBAItems;
import com.github.warrentode.turtleblockacademy.world.biome.TBABiomes;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TBALangGen extends LanguageProvider {
    public TBALangGen(DataGenerator generator, String modid, String locale) {
        super(generator, modid, locale);
    }

    @Override
    protected void addTranslations() {
        addItemGroups();
        addItems();
        addBlocks();
        addTooltips();
        addAdvancements();
        addMessages();
        addContainers();
        addSubtitles();
        addEntityTypes();
        addEasterEggs();
        addBiomeDimensionNames();
    }

    private void addBiomeDimensionNames() {
        add("biome." + MODID + "." + TBABiomes.TBA_UNDERDEEP.location().getPath(), "Under Deep");
        add("biome." + MODID + "." + TBABiomes.TBA_NETHER_CORRUPTION.location().getPath(), "Nether Corruption");
        add("biome." + MODID + "." + TBABiomes.TBA_ENDER_EROSION.location().getPath(), "Ender Erosion");
        add("biome." + MODID + "." + TBABiomes.TBA_AETHER_INCURSION.location().getPath(), "Aether Incursion");
        add("biome." + MODID + "." + TBABiomes.TBA_SLIME_CAVES.location().getPath(), "Slime Caves");
        add("biome.nomadictents.tent", "Tent");
    }

    private void addEntityTypes() {
        add("entity." + MODID + ".treasure_beetle", "Treasure Beetle");
        add("entity." + MODID + ".herobrine", "Herobrine");
    }

    private void addSubtitles() {
        add("subtitles." + MODID + ".desk_open", "Desk Drawer Opens");
        add("subtitles." + MODID + ".desk_close", "Desk Drawer Closes");
        add("subtitles." + MODID + ".locker_open", "Locker Opens");
        add("subtitles." + MODID + ".locker_close", "Locker Closes");
        add("subtitles." + MODID + ".bookcase_open", "Bookcase Opens");
        add("subtitles." + MODID + ".bookcase_close", "Bookcase Closes");
        add("subtitles." + MODID + ".treasure_beetle_hurts", "Treasure Beetle Hurts");
        add("subtitles." + MODID + ".treasure_beetle_ambient", "Treasure Beetle Hisses");
        add("subtitles." + MODID + ".treasure_beetle_death", "Treasure Beetle Dies");
        add("subtitles." + MODID + ".treasure_beetle_step", "Treasure Beetle Crawls");
        add("subtitles." + MODID + ".treasure_beetle_item_drop", "Treasure Beetle Drops Treasure");
        add("subtitles." + MODID + ".herobrine_ambient", "You feel you're being watched...");
    }

    private void addContainers() {
        add("container." + MODID + ".desk", "School Desk");
        add("container." + MODID + ".storage", "Storage");
        add("container." + MODID + ".fermenting_pot", "Fermenting Pot");
        add("container." + MODID + ".recipe_book.fermenting", "Showing Fermentable");
        add("container." + MODID + ".basket", "Basket");
        add("container." + MODID + ".basket.contents", "Basket Contents");
    }

    private void addMessages() {
        add("message." + MODID + ".registered", "You are now registered as a student of Turtle Block Academy");
        add("message." + MODID + ".birthday_message", "Today is someone's birthday! Let's celebrate!");
    }

    private void addAdvancements() {
        fillAdvancementKeys("root", "Turtle Block Academy", "Principal Herobrine welcomes you!");

        fillAdvancementKeys("exploration_track", "Gone Adventuring", "It's Tourist Season!");
        fillAdvancementKeys("enter_mining", "Underground World", "Enter the Mining Dimension");
        fillAdvancementKeys("explore_overworld", "Grand Tour of the World", "Visit All of the Overworld Biomes");
        fillAdvancementKeys("explore_nether", "Tour in the Hot Seat", "Visit All of the Nether Biomes");
        fillAdvancementKeys("explore_end", "Final Tour Before Retirement?", "Visit All of the End Biomes");
        fillAdvancementKeys("explore_aether", "Hostile Tour of the Heavens", "Visit All of the Aether Biomes");

        fillAdvancementKeys("curios_track", "Oh, How Very Curious this Curio", "A Strange or Interesting Collectible Object Indeed");
        fillAdvancementKeys("equip_light_source", "Let There Be Light", "Equip a Light Source");
        fillAdvancementKeys("equip_wallet", "Cash on Hand", "Equip a Wallet");
        fillAdvancementKeys("equip_quiver", "An Archer's Best Friend", "Equip a Quiver");

        fillAdvancementKeys("complete_food_safety", "Food Safety", "Learn the Basics");
        fillAdvancementKeys("complete_macronutrients", "Macronutrients", "Basic Nutrition 101");
    }

    private void fillAdvancementKeys(String name, String title, String subtitle) {
        add("advancement." + MODID + "." + name, title);
        add("advancement." + MODID + "." + name + ".desc", subtitle);
    }

    private void addTooltips() {
        add("tooltips.shift.hover", "Press SHIFT for more info...");
        fillTooltipKeys("student_card_blank", "Blank Student Card - Use to Register as Student");
        fillTooltipKeys("certificate_blank", "Blank Certificate");
        add("tooltip." + MODID + ".pickled_item_custom.beet_pickles",
                "Did you know that vinegar helps fabrics hold on to natural pigments longer?\nBe careful not to spill your pickled beets onto your clothes!");
        add("tooltip." + MODID + ".pickled_item_custom.dill_pickle",
                "Did you know that the United States has a national pickle day on November 14th?");
        add("tooltip." + MODID + ".pickled_item_effect",
                "Unpasteurized fermented foods are probiotic and when stored well,\nthey promote good gut bacterial health.\nTo reflect this, these pickles will remove one negative effect when consumed.");
        add("tooltip." + MODID + ".easter_egg_item_custom_tooltip",
                "In China, children celebrate the spring equinox by trying to balance their decorated eggs on their ends.\nSuccess is believed to bring good luck for the year.");
        add("tooltip." + MODID + ".easter_egg_item_custom_tooltip1",
                "The largest Easter egg ever made was over 25 feet high and weighed over 8,000 pounds.\nIt was built out of chocolate and marshmallow and supported by an internal steel frame.");
        add("tooltip." + MODID + ".easter_egg_item_custom_tooltip2",
                "In the United States, the White House Easter Egg Roll, is an annual event held the Monday after Easter.");
        add("tooltip." + MODID + ".easter_egg_item_custom_tooltip3",
                "Bosnia celebrates spring each year with Cimburijada, or the Festival of Scrambled Eggs.");
        add("tooltip." + MODID + ".easter_egg_item_custom_tooltip4",
                "Egypt celebrates spring each year with Sham el Nessim, which translates to \"smelling the breeze\",\nby decorating hard-boiled eggs and writing wishes on them.");
        add("tooltip." + MODID + ".easter_egg_item_custom_tooltip5",
                "The egg is considered to be an ancient symbol of fertility, which is associated with spring.");
        add("tooltip." + MODID + ".easter_egg_item_custom_tooltip6",
                "The general consensus is that eggs being used for celebrating spring stems from pagan origins.");
        add("tooltip." + MODID + ".easter_egg_item_custom_tooltip7",
                "Purim, a Jewish holiday, doesn't use eggs to celebrate but is held in spring to honor the day\ntheir people where spared from execution within the ancient Persian empire.");
        add("tooltip." + MODID + ".easter_egg_item_custom_tooltip8",
                "Passover, a Jewish holiday celebrated for seven to eight days, doesn't use eggs to celebrate but is held in spring to honor their people's\nfreedom from slavery in ancient Egypt.");
        add("tooltip." + MODID + ".easter_egg_item_custom_tooltip9",
                "Holi, a Hindu holiday known as the festival of colors, doesn't use eggs but uses bright colors instead to celebrate the end of winter, love, and the triumph of good over evil.");
        add("tooltip." + MODID + ".easter_egg_item_custom_tooltip10",
                "Nowruz, meaning \"New Day\", marks the Persian New Year and is celebrated by spring cleaning and feasting.");
        add("tooltip." + MODID + ".easter_egg_item_custom_tooltip11",
                "Songkran is the Thai New Year and is celebrated for three days with traditions that use water,\nsuch as cleaning, sprinkling Buddha statues with water, and even friendly water fights.");
        add("tooltip." + MODID + ".easter_egg_item_custom_tooltip12",
                "Las Fallas is held in Spain from March 1st to March 19th and is considered as an UNESCO World Heritage event since 2016.\nThey celebrate with parades, fireworks, and colorful sculptures.");
        add("tooltip." + MODID + ".easter_egg_item_custom_tooltip13",
                "Hola Mohalla is held the day after Holi by Sikh community in India to demonstrate martial skills and instill courage.");
        add("tooltip." + MODID + ".easter_egg_item_custom_tooltip14",
                "The National Cherry Blossom Festival is held every year in Washington D.C. to celebrate the blooming\nof the city's cherry blossom trees, which were a gift from Japan in 1912.");
        add("tooltip." + MODID + ".easter_egg_item_custom_tooltip15",
                "Walpurgis Night, also known as May Eve, is named after Saint Walpurga,\nan 8th-century abbess who was known for her healing powers.\nIt's celebrated in Germany with bonfires and Maypole dancing\nwhile in Sweden it's celebrated with feasting and bonfire dancing");
    }

    private void fillTooltipKeys(String key, String name) {
        add("tooltips." + MODID + "." + key, name);
    }

    private void addItems() {
        add(TBAItems.STUDENT_CARD.get(), "Turtle Block Academy Student ID");
        add(TBAItems.TREASURE_BEETLE_SPAWN_EGG.get(), "Treasure Beetle Spawn Egg");
        add(TBAItems.HEROBRINE_SPAWN_EGG.get(), "Herobrine Spawn Egg");
        add(TBAItems.BEET_WINE.get(), "Beet Wine");
        add(TBAItems.VINEGAR_BOTTLE.get(), "Vinegar");
        add(TBAItems.BEET_RISOTTO.get(), "Beet Risotto");
        add(TBAItems.BEET_SALAD.get(), "Beet Salad");
        add(TBAItems.CLOVES.get(), "Cloves");
        add(TBAItems.CLOVE_SEEDS.get(), "Clove Seeds");
        add(TBAItems.DRIED_CLOVES.get(), "Dried Cloves");
        add(TBAItems.GROUND_CLOVES.get(), "Ground Cloves");
        add(TBAItems.PICKLING_SALT.get(), "Pickling Salt");
        add(TBAItems.WHEAT_FLOUR.get(), "Wheat Flour");
        add(TBAItems.BEET_PICKLES.get(), "Pickled Beets");
        add(TBAItems.YEAST.get(), "Yeast");
        add(TBAItems.HARD_APPLE_CIDER.get(), "Hard Apple Cider");
        add(TBAItems.DILL_SEEDS.get(), "Dill Seeds");
        add(TBAItems.DILL_HERB.get(), "Dill Herb");
        add(TBAItems.CUCUMBER.get(), "Cucumber");
        add(TBAItems.CUCUMBER_SEEDS.get(), "Cucumber Seeds");
        add(TBAItems.DILL_PICKLE.get(), "Dill Pickle");
        add(TBAItems.BOILED_EGG.get(), "Boiled Egg");
        add(TBAItems.PEELED_EGG.get(), "Peeled Egg");
        add(TBAItems.EGG_STAMP_CREEPER.get(), "Creeper Egg Stamp");
        add(TBAItems.EGG_STAMP_FLOWER.get(), "Flower Egg Stamp");
        add(TBAItems.WOOL_THREAD.get(), "Wool Thread");
        add(TBAItems.SILK_THREAD.get(), "Silk Thread");
        add(TBAItems.COPPER_NEEDLE.get(), "Copper Needle");
    }

    private void addEasterEggs() {
        add(TBAItems.COLORED_EGG_BLACK.get(), "Black Colored Egg");
        add(TBAItems.COLORED_EGG_RED.get(), "Red Colored Egg");
        add(TBAItems.COLORED_EGG_GREEN.get(), "Green Colored Egg");
        add(TBAItems.COLORED_EGG_BROWN.get(), "Brown Colored Egg");
        add(TBAItems.COLORED_EGG_BLUE.get(), "Blue Colored Egg");
        add(TBAItems.COLORED_EGG_PURPLE.get(), "Purple Colored Egg");
        add(TBAItems.COLORED_EGG_CYAN.get(), "Cyan Colored Egg");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY.get(), "Light Gray Colored Egg");
        add(TBAItems.COLORED_EGG_GRAY.get(), "Gray Colored Egg");
        add(TBAItems.COLORED_EGG_PINK.get(), "Pink Colored Egg");
        add(TBAItems.COLORED_EGG_LIME.get(), "Lime Colored Egg");
        add(TBAItems.COLORED_EGG_YELLOW.get(), "Yellow Colored Egg");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE.get(), "Light Blue Colored Egg");
        add(TBAItems.COLORED_EGG_MAGENTA.get(), "Magenta Colored Egg");
        add(TBAItems.COLORED_EGG_ORANGE.get(), "Orange Colored Egg");
        add(TBAItems.COLORED_EGG_WHITE.get(), "White Colored Egg");
        add(TBAItems.COLORED_EGG_WHITE_CREEPER_BLACK.get(),
                "White Colored Egg with Black Creeper Stamp");
        add(TBAItems.COLORED_EGG_WHITE_CREEPER_RED.get(),
                "White Colored Egg with Red Creeper Stamp");
        add(TBAItems.COLORED_EGG_WHITE_CREEPER_GREEN.get(),
                "White Colored Egg with Green Creeper Stamp");
        add(TBAItems.COLORED_EGG_WHITE_CREEPER_BROWN.get(),
                "White Colored Egg with Brown Creeper Stamp");
        add(TBAItems.COLORED_EGG_WHITE_CREEPER_BLUE.get(),
                "White Colored Egg with Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_WHITE_CREEPER_PURPLE.get(),
                "White Colored Egg with Purple Creeper Stamp");
        add(TBAItems.COLORED_EGG_WHITE_CREEPER_CYAN.get(),
                "White Colored Egg with Cyan Creeper Stamp");
        add(TBAItems.COLORED_EGG_WHITE_CREEPER_LIGHT_GRAY.get(),
                "White Colored Egg with Light Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_WHITE_CREEPER_GRAY.get(),
                "White Colored Egg with Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_WHITE_CREEPER_PINK.get(),
                "White Colored Egg with Pink Creeper Stamp");
        add(TBAItems.COLORED_EGG_WHITE_CREEPER_LIME.get(),
                "White Colored Egg with Lime Creeper Stamp");
        add(TBAItems.COLORED_EGG_WHITE_CREEPER_YELLOW.get(),
                "White Colored Egg with Yellow Creeper Stamp");
        add(TBAItems.COLORED_EGG_WHITE_CREEPER_LIGHT_BLUE.get(),
                "White Colored Egg with Light Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_WHITE_CREEPER_MAGENTA.get(),
                "White Colored Egg with Magenta Creeper Stamp");
        add(TBAItems.COLORED_EGG_WHITE_CREEPER_ORANGE.get(),
                "White Colored Egg with Orange Creeper Stamp");
        add(TBAItems.COLORED_EGG_WHITE_CREEPER_WHITE.get(),
                "White Colored Egg with White Creeper Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_CREEPER_BLACK.get(),
                "Orange Colored Egg with Black Creeper Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_CREEPER_RED.get(),
                "Orange Colored Egg with Red Creeper Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_CREEPER_GREEN.get(),
                "Orange Colored Egg with Green Creeper Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_CREEPER_BROWN.get(),
                "Orange Colored Egg with Brown Creeper Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_CREEPER_BLUE.get(),
                "Orange Colored Egg with Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_CREEPER_PURPLE.get(),
                "Orange Colored Egg with Purple Creeper Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_CREEPER_CYAN.get(),
                "Orange Colored Egg with Cyan Creeper Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_CREEPER_LIGHT_GRAY.get(),
                "Orange Colored Egg with Light Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_CREEPER_GRAY.get(),
                "Orange Colored Egg with Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_CREEPER_PINK.get(),
                "Orange Colored Egg with Pink Creeper Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_CREEPER_LIME.get(),
                "Orange Colored Egg with Lime Creeper Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_CREEPER_YELLOW.get(),
                "Orange Colored Egg with Yellow Creeper Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_CREEPER_LIGHT_BLUE.get(),
                "Orange Colored Egg with Light Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_CREEPER_MAGENTA.get(),
                "Orange Colored Egg with Magenta Creeper Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_CREEPER_ORANGE.get(),
                "Orange Colored Egg with Orange Creeper Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_CREEPER_WHITE.get(),
                "Orange Colored Egg with White Creeper Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_CREEPER_BLACK.get(),
                "Magenta Colored Egg with Black Creeper Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_CREEPER_RED.get(),
                "Magenta Colored Egg with Red Creeper Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_CREEPER_GREEN.get(),
                "Magenta Colored Egg with Green Creeper Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_CREEPER_BROWN.get(),
                "Magenta Colored Egg with Brown Creeper Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_CREEPER_BLUE.get(),
                "Magenta Colored Egg with Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_CREEPER_PURPLE.get(),
                "Magenta Colored Egg with Purple Creeper Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_CREEPER_CYAN.get(),
                "Magenta Colored Egg with Cyan Creeper Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_CREEPER_LIGHT_GRAY.get(),
                "Magenta Colored Egg with Light Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_CREEPER_GRAY.get(),
                "Magenta Colored Egg with Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_CREEPER_PINK.get(),
                "Magenta Colored Egg with Pink Creeper Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_CREEPER_LIME.get(),
                "Magenta Colored Egg with Lime Creeper Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_CREEPER_YELLOW.get(),
                "Magenta Colored Egg with Yellow Creeper Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_CREEPER_LIGHT_BLUE.get(),
                "Magenta Colored Egg with Light Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_CREEPER_MAGENTA.get(),
                "Magenta Colored Egg with Magenta Creeper Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_CREEPER_ORANGE.get(),
                "Magenta Colored Egg with Orange Creeper Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_CREEPER_WHITE.get(),
                "Magenta Colored Egg with White Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_BLACK.get(),
                "Light Blue Colored Egg with Black Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_RED.get(),
                "Light Blue Colored Egg with Red Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_GREEN.get(),
                "Light Blue Colored Egg with Green Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_BROWN.get(),
                "Light Blue Colored Egg with Brown Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_BLUE.get(),
                "Light Blue Colored Egg with Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_PURPLE.get(),
                "Light Blue Colored Egg with Purple Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_CYAN.get(),
                "Light Blue Colored Egg with Cyan Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_LIGHT_GRAY.get(),
                "Light Blue Colored Egg with Light Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_GRAY.get(),
                "Light Blue Colored Egg with Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_PINK.get(),
                "Light Blue Colored Egg with Pink Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_LIME.get(),
                "Light Blue Colored Egg with Lime Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_YELLOW.get(),
                "Light Blue Colored Egg with Yellow Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_LIGHT_BLUE.get(),
                "Light Blue Colored Egg with Light Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_MAGENTA.get(),
                "Light Blue Colored Egg with Magenta Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_ORANGE.get(),
                "Light Blue Colored Egg with Orange Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_WHITE.get(),
                "Light Blue Colored Egg with White Creeper Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_CREEPER_BLACK.get(),
                "Yellow Colored Egg with Black Creeper Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_CREEPER_RED.get(),
                "Yellow Colored Egg with Red Creeper Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_CREEPER_GREEN.get(),
                "Yellow Colored Egg with Green Creeper Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_CREEPER_BROWN.get(),
                "Yellow Colored Egg with Brown Creeper Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_CREEPER_BLUE.get(),
                "Yellow Colored Egg with Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_CREEPER_PURPLE.get(),
                "Yellow Colored Egg with Purple Creeper Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_CREEPER_CYAN.get(),
                "Yellow Colored Egg with Cyan Creeper Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_CREEPER_LIGHT_GRAY.get(),
                "Yellow Colored Egg with Light Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_CREEPER_GRAY.get(),
                "Yellow Colored Egg with Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_CREEPER_PINK.get(),
                "Yellow Colored Egg with Pink Creeper Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_CREEPER_LIME.get(),
                "Yellow Colored Egg with Lime Creeper Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_CREEPER_YELLOW.get(),
                "Yellow Colored Egg with Yellow Creeper Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_CREEPER_LIGHT_BLUE.get(),
                "Yellow Colored Egg with Light Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_CREEPER_MAGENTA.get(),
                "Yellow Colored Egg with Magenta Creeper Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_CREEPER_ORANGE.get(),
                "Yellow Colored Egg with Orange Creeper Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_CREEPER_WHITE.get(),
                "Yellow Colored Egg with White Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIME_CREEPER_BLACK.get(),
                "Lime Colored Egg with Black Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIME_CREEPER_RED.get(),
                "Lime Colored Egg with Red Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIME_CREEPER_GREEN.get(),
                "Lime Colored Egg with Green Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIME_CREEPER_BROWN.get(),
                "Lime Colored Egg with Brown Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIME_CREEPER_BLUE.get(),
                "Lime Colored Egg with Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIME_CREEPER_PURPLE.get(),
                "Lime Colored Egg with Purple Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIME_CREEPER_CYAN.get(),
                "Lime Colored Egg with Cyan Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIME_CREEPER_LIGHT_GRAY.get(),
                "Lime Colored Egg with Light Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIME_CREEPER_GRAY.get(),
                "Lime Colored Egg with Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIME_CREEPER_PINK.get(),
                "Lime Colored Egg with Pink Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIME_CREEPER_LIME.get(),
                "Lime Colored Egg with Lime Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIME_CREEPER_YELLOW.get(),
                "Lime Colored Egg with Yellow Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIME_CREEPER_LIGHT_BLUE.get(),
                "Lime Colored Egg with Light Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIME_CREEPER_MAGENTA.get(),
                "Lime Colored Egg with Magenta Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIME_CREEPER_ORANGE.get(),
                "Lime Colored Egg with Orange Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIME_CREEPER_WHITE.get(),
                "Lime Colored Egg with White Creeper Stamp");
        add(TBAItems.COLORED_EGG_PINK_CREEPER_BLACK.get(),
                "Pink Colored Egg with Black Creeper Stamp");
        add(TBAItems.COLORED_EGG_PINK_CREEPER_RED.get(),
                "Pink Colored Egg with Red Creeper Stamp");
        add(TBAItems.COLORED_EGG_PINK_CREEPER_GREEN.get(),
                "Pink Colored Egg with Green Creeper Stamp");
        add(TBAItems.COLORED_EGG_PINK_CREEPER_BROWN.get(),
                "Pink Colored Egg with Brown Creeper Stamp");
        add(TBAItems.COLORED_EGG_PINK_CREEPER_BLUE.get(),
                "Pink Colored Egg with Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_PINK_CREEPER_PURPLE.get(),
                "Pink Colored Egg with Purple Creeper Stamp");
        add(TBAItems.COLORED_EGG_PINK_CREEPER_CYAN.get(),
                "Pink Colored Egg with Cyan Creeper Stamp");
        add(TBAItems.COLORED_EGG_PINK_CREEPER_LIGHT_GRAY.get(),
                "Pink Colored Egg with Light Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_PINK_CREEPER_GRAY.get(),
                "Pink Colored Egg with Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_PINK_CREEPER_PINK.get(),
                "Pink Colored Egg with Pink Creeper Stamp");
        add(TBAItems.COLORED_EGG_PINK_CREEPER_LIME.get(),
                "Pink Colored Egg with Lime Creeper Stamp");
        add(TBAItems.COLORED_EGG_PINK_CREEPER_YELLOW.get(),
                "Pink Colored Egg with Yellow Creeper Stamp");
        add(TBAItems.COLORED_EGG_PINK_CREEPER_LIGHT_BLUE.get(),
                "Pink Colored Egg with Light Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_PINK_CREEPER_MAGENTA.get(),
                "Pink Colored Egg with Magenta Creeper Stamp");
        add(TBAItems.COLORED_EGG_PINK_CREEPER_ORANGE.get(),
                "Pink Colored Egg with Orange Creeper Stamp");
        add(TBAItems.COLORED_EGG_PINK_CREEPER_WHITE.get(),
                "Pink Colored Egg with White Creeper Stamp");
        add(TBAItems.COLORED_EGG_GRAY_CREEPER_BLACK.get(),
                "Gray Colored Egg with Black Creeper Stamp");
        add(TBAItems.COLORED_EGG_GRAY_CREEPER_RED.get(),
                "Gray Colored Egg with Red Creeper Stamp");
        add(TBAItems.COLORED_EGG_GRAY_CREEPER_GREEN.get(),
                "Gray Colored Egg with Green Creeper Stamp");
        add(TBAItems.COLORED_EGG_GRAY_CREEPER_BROWN.get(),
                "Gray Colored Egg with Brown Creeper Stamp");
        add(TBAItems.COLORED_EGG_GRAY_CREEPER_BLUE.get(),
                "Gray Colored Egg with Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_GRAY_CREEPER_PURPLE.get(),
                "Gray Colored Egg with Purple Creeper Stamp");
        add(TBAItems.COLORED_EGG_GRAY_CREEPER_CYAN.get(),
                "Gray Colored Egg with Cyan Creeper Stamp");
        add(TBAItems.COLORED_EGG_GRAY_CREEPER_LIGHT_GRAY.get(),
                "Gray Colored Egg with Light Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_GRAY_CREEPER_GRAY.get(),
                "Gray Colored Egg with Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_GRAY_CREEPER_PINK.get(),
                "Gray Colored Egg with Pink Creeper Stamp");
        add(TBAItems.COLORED_EGG_GRAY_CREEPER_LIME.get(),
                "Gray Colored Egg with Lime Creeper Stamp");
        add(TBAItems.COLORED_EGG_GRAY_CREEPER_YELLOW.get(),
                "Gray Colored Egg with Yellow Creeper Stamp");
        add(TBAItems.COLORED_EGG_GRAY_CREEPER_LIGHT_BLUE.get(),
                "Gray Colored Egg with Light Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_GRAY_CREEPER_MAGENTA.get(),
                "Gray Colored Egg with Magenta Creeper Stamp");
        add(TBAItems.COLORED_EGG_GRAY_CREEPER_ORANGE.get(),
                "Gray Colored Egg with Orange Creeper Stamp");
        add(TBAItems.COLORED_EGG_GRAY_CREEPER_WHITE.get(),
                "Gray Colored Egg with White Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_BLACK.get(),
                "Light Gray Colored Egg with Black Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_RED.get(),
                "Light Gray Colored Egg with Red Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_GREEN.get(),
                "Light Gray Colored Egg with Green Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_BROWN.get(),
                "Light Gray Colored Egg with Brown Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_BLUE.get(),
                "Light Gray Colored Egg with Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_PURPLE.get(),
                "Light Gray Colored Egg with Purple Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_CYAN.get(),
                "Light Gray Colored Egg with Cyan Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_LIGHT_GRAY.get(),
                "Light Gray Colored Egg with Light Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_GRAY.get(),
                "Light Gray Colored Egg with Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_PINK.get(),
                "Light Gray Colored Egg with Pink Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_LIME.get(),
                "Light Gray Colored Egg with Lime Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_YELLOW.get(),
                "Light Gray Colored Egg with Yellow Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_LIGHT_BLUE.get(),
                "Light Gray Colored Egg with Light Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_MAGENTA.get(),
                "Light Gray Colored Egg with Magenta Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_ORANGE.get(),
                "Light Gray Colored Egg with Orange Creeper Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_WHITE.get(),
                "Light Gray Colored Egg with White Creeper Stamp");
        add(TBAItems.COLORED_EGG_CYAN_CREEPER_BLACK.get(),
                "Cyan Colored Egg with Black Creeper Stamp");
        add(TBAItems.COLORED_EGG_CYAN_CREEPER_RED.get(),
                "Cyan Colored Egg with Red Creeper Stamp");
        add(TBAItems.COLORED_EGG_CYAN_CREEPER_GREEN.get(),
                "Cyan Colored Egg with Green Creeper Stamp");
        add(TBAItems.COLORED_EGG_CYAN_CREEPER_BROWN.get(),
                "Cyan Colored Egg with Brown Creeper Stamp");
        add(TBAItems.COLORED_EGG_CYAN_CREEPER_BLUE.get(),
                "Cyan Colored Egg with Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_CYAN_CREEPER_PURPLE.get(),
                "Cyan Colored Egg with Purple Creeper Stamp");
        add(TBAItems.COLORED_EGG_CYAN_CREEPER_CYAN.get(),
                "Cyan Colored Egg with Cyan Creeper Stamp");
        add(TBAItems.COLORED_EGG_CYAN_CREEPER_LIGHT_GRAY.get(),
                "Cyan Colored Egg with Light Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_CYAN_CREEPER_GRAY.get(),
                "Cyan Colored Egg with Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_CYAN_CREEPER_PINK.get(),
                "Cyan Colored Egg with Pink Creeper Stamp");
        add(TBAItems.COLORED_EGG_CYAN_CREEPER_LIME.get(),
                "Cyan Colored Egg with Lime Creeper Stamp");
        add(TBAItems.COLORED_EGG_CYAN_CREEPER_YELLOW.get(),
                "Cyan Colored Egg with Yellow Creeper Stamp");
        add(TBAItems.COLORED_EGG_CYAN_CREEPER_LIGHT_BLUE.get(),
                "Cyan Colored Egg with Light Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_CYAN_CREEPER_MAGENTA.get(),
                "Cyan Colored Egg with Magenta Creeper Stamp");
        add(TBAItems.COLORED_EGG_CYAN_CREEPER_ORANGE.get(),
                "Cyan Colored Egg with Orange Creeper Stamp");
        add(TBAItems.COLORED_EGG_CYAN_CREEPER_WHITE.get(),
                "Cyan Colored Egg with White Creeper Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_CREEPER_BLACK.get(),
                "Purple Colored Egg with Black Creeper Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_CREEPER_RED.get(),
                "Purple Colored Egg with Red Creeper Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_CREEPER_GREEN.get(),
                "Purple Colored Egg with Green Creeper Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_CREEPER_BROWN.get(),
                "Purple Colored Egg with Brown Creeper Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_CREEPER_BLUE.get(),
                "Purple Colored Egg with Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_CREEPER_PURPLE.get(),
                "Purple Colored Egg with Purple Creeper Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_CREEPER_CYAN.get(),
                "Purple Colored Egg with Cyan Creeper Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_CREEPER_LIGHT_GRAY.get(),
                "Purple Colored Egg with Light Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_CREEPER_GRAY.get(),
                "Purple Colored Egg with Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_CREEPER_PINK.get(),
                "Purple Colored Egg with Pink Creeper Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_CREEPER_LIME.get(),
                "Purple Colored Egg with Lime Creeper Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_CREEPER_YELLOW.get(),
                "Purple Colored Egg with Yellow Creeper Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_CREEPER_LIGHT_BLUE.get(),
                "Purple Colored Egg with Light Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_CREEPER_MAGENTA.get(),
                "Purple Colored Egg with Magenta Creeper Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_CREEPER_ORANGE.get(),
                "Purple Colored Egg with Orange Creeper Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_CREEPER_WHITE.get(),
                "Purple Colored Egg with White Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLUE_CREEPER_BLACK.get(),
                "Blue Colored Egg with Black Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLUE_CREEPER_RED.get(),
                "Blue Colored Egg with Red Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLUE_CREEPER_GREEN.get(),
                "Blue Colored Egg with Green Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLUE_CREEPER_BROWN.get(),
                "Blue Colored Egg with Brown Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLUE_CREEPER_BLUE.get(),
                "Blue Colored Egg with Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLUE_CREEPER_PURPLE.get(),
                "Blue Colored Egg with Purple Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLUE_CREEPER_CYAN.get(),
                "Blue Colored Egg with Cyan Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLUE_CREEPER_LIGHT_GRAY.get(),
                "Blue Colored Egg with Light Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLUE_CREEPER_GRAY.get(),
                "Blue Colored Egg with Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLUE_CREEPER_PINK.get(),
                "Blue Colored Egg with Pink Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLUE_CREEPER_LIME.get(),
                "Blue Colored Egg with Lime Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLUE_CREEPER_YELLOW.get(),
                "Blue Colored Egg with Yellow Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLUE_CREEPER_LIGHT_BLUE.get(),
                "Blue Colored Egg with Light Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLUE_CREEPER_MAGENTA.get(),
                "Blue Colored Egg with Magenta Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLUE_CREEPER_ORANGE.get(),
                "Blue Colored Egg with Orange Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLUE_CREEPER_WHITE.get(),
                "Blue Colored Egg with White Creeper Stamp");
        add(TBAItems.COLORED_EGG_BROWN_CREEPER_BLACK.get(),
                "Brown Colored Egg with Black Creeper Stamp");
        add(TBAItems.COLORED_EGG_BROWN_CREEPER_RED.get(),
                "Brown Colored Egg with Red Creeper Stamp");
        add(TBAItems.COLORED_EGG_BROWN_CREEPER_GREEN.get(),
                "Brown Colored Egg with Green Creeper Stamp");
        add(TBAItems.COLORED_EGG_BROWN_CREEPER_BROWN.get(),
                "Brown Colored Egg with Brown Creeper Stamp");
        add(TBAItems.COLORED_EGG_BROWN_CREEPER_BLUE.get(),
                "Brown Colored Egg with Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_BROWN_CREEPER_PURPLE.get(),
                "Brown Colored Egg with Purple Creeper Stamp");
        add(TBAItems.COLORED_EGG_BROWN_CREEPER_CYAN.get(),
                "Brown Colored Egg with Cyan Creeper Stamp");
        add(TBAItems.COLORED_EGG_BROWN_CREEPER_LIGHT_GRAY.get(),
                "Brown Colored Egg with Light Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_BROWN_CREEPER_GRAY.get(),
                "Brown Colored Egg with Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_BROWN_CREEPER_PINK.get(),
                "Brown Colored Egg with Pink Creeper Stamp");
        add(TBAItems.COLORED_EGG_BROWN_CREEPER_LIME.get(),
                "Brown Colored Egg with Lime Creeper Stamp");
        add(TBAItems.COLORED_EGG_BROWN_CREEPER_YELLOW.get(),
                "Brown Colored Egg with Yellow Creeper Stamp");
        add(TBAItems.COLORED_EGG_BROWN_CREEPER_LIGHT_BLUE.get(),
                "Brown Colored Egg with Light Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_BROWN_CREEPER_MAGENTA.get(),
                "Brown Colored Egg with Magenta Creeper Stamp");
        add(TBAItems.COLORED_EGG_BROWN_CREEPER_ORANGE.get(),
                "Brown Colored Egg with Orange Creeper Stamp");
        add(TBAItems.COLORED_EGG_BROWN_CREEPER_WHITE.get(),
                "Brown Colored Egg with White Creeper Stamp");
        add(TBAItems.COLORED_EGG_GREEN_CREEPER_BLACK.get(),
                "Green Colored Egg with Black Creeper Stamp");
        add(TBAItems.COLORED_EGG_GREEN_CREEPER_RED.get(),
                "Green Colored Egg with Red Creeper Stamp");
        add(TBAItems.COLORED_EGG_GREEN_CREEPER_GREEN.get(),
                "Green Colored Egg with Green Creeper Stamp");
        add(TBAItems.COLORED_EGG_GREEN_CREEPER_BROWN.get(),
                "Green Colored Egg with Brown Creeper Stamp");
        add(TBAItems.COLORED_EGG_GREEN_CREEPER_BLUE.get(),
                "Green Colored Egg with Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_GREEN_CREEPER_PURPLE.get(),
                "Green Colored Egg with Purple Creeper Stamp");
        add(TBAItems.COLORED_EGG_GREEN_CREEPER_CYAN.get(),
                "Green Colored Egg with Cyan Creeper Stamp");
        add(TBAItems.COLORED_EGG_GREEN_CREEPER_LIGHT_GRAY.get(),
                "Green Colored Egg with Light Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_GREEN_CREEPER_GRAY.get(),
                "Green Colored Egg with Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_GREEN_CREEPER_PINK.get(),
                "Green Colored Egg with Pink Creeper Stamp");
        add(TBAItems.COLORED_EGG_GREEN_CREEPER_LIME.get(),
                "Green Colored Egg with Lime Creeper Stamp");
        add(TBAItems.COLORED_EGG_GREEN_CREEPER_YELLOW.get(),
                "Green Colored Egg with Yellow Creeper Stamp");
        add(TBAItems.COLORED_EGG_GREEN_CREEPER_LIGHT_BLUE.get(),
                "Green Colored Egg with Light Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_GREEN_CREEPER_MAGENTA.get(),
                "Green Colored Egg with Magenta Creeper Stamp");
        add(TBAItems.COLORED_EGG_GREEN_CREEPER_ORANGE.get(),
                "Green Colored Egg with Orange Creeper Stamp");
        add(TBAItems.COLORED_EGG_GREEN_CREEPER_WHITE.get(),
                "Green Colored Egg with White Creeper Stamp");
        add(TBAItems.COLORED_EGG_RED_CREEPER_BLACK.get(),
                "Red Colored Egg with Black Creeper Stamp");
        add(TBAItems.COLORED_EGG_RED_CREEPER_RED.get(),
                "Red Colored Egg with Red Creeper Stamp");
        add(TBAItems.COLORED_EGG_RED_CREEPER_GREEN.get(),
                "Red Colored Egg with Green Creeper Stamp");
        add(TBAItems.COLORED_EGG_RED_CREEPER_BROWN.get(),
                "Red Colored Egg with Brown Creeper Stamp");
        add(TBAItems.COLORED_EGG_RED_CREEPER_BLUE.get(),
                "Red Colored Egg with Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_RED_CREEPER_PURPLE.get(),
                "Red Colored Egg with Purple Creeper Stamp");
        add(TBAItems.COLORED_EGG_RED_CREEPER_CYAN.get(),
                "Red Colored Egg with Cyan Creeper Stamp");
        add(TBAItems.COLORED_EGG_RED_CREEPER_LIGHT_GRAY.get(),
                "Red Colored Egg with Light Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_RED_CREEPER_GRAY.get(),
                "Red Colored Egg with Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_RED_CREEPER_PINK.get(),
                "Red Colored Egg with Pink Creeper Stamp");
        add(TBAItems.COLORED_EGG_RED_CREEPER_LIME.get(),
                "Red Colored Egg with Lime Creeper Stamp");
        add(TBAItems.COLORED_EGG_RED_CREEPER_YELLOW.get(),
                "Red Colored Egg with Yellow Creeper Stamp");
        add(TBAItems.COLORED_EGG_RED_CREEPER_LIGHT_BLUE.get(),
                "Red Colored Egg with Light Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_RED_CREEPER_MAGENTA.get(),
                "Red Colored Egg with Magenta Creeper Stamp");
        add(TBAItems.COLORED_EGG_RED_CREEPER_ORANGE.get(),
                "Red Colored Egg with Orange Creeper Stamp");
        add(TBAItems.COLORED_EGG_RED_CREEPER_WHITE.get(),
                "Red Colored Egg with White Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLACK_CREEPER_BLACK.get(),
                "Black Colored Egg with Black Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLACK_CREEPER_RED.get(),
                "Black Colored Egg with Red Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLACK_CREEPER_GREEN.get(),
                "Black Colored Egg with Green Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLACK_CREEPER_BROWN.get(),
                "Black Colored Egg with Brown Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLACK_CREEPER_BLUE.get(),
                "Black Colored Egg with Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLACK_CREEPER_PURPLE.get(),
                "Black Colored Egg with Purple Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLACK_CREEPER_CYAN.get(),
                "Black Colored Egg with Cyan Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLACK_CREEPER_LIGHT_GRAY.get(),
                "Black Colored Egg with Light Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLACK_CREEPER_GRAY.get(),
                "Black Colored Egg with Gray Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLACK_CREEPER_PINK.get(),
                "Black Colored Egg with Pink Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLACK_CREEPER_LIME.get(),
                "Black Colored Egg with Lime Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLACK_CREEPER_YELLOW.get(),
                "Black Colored Egg with Yellow Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLACK_CREEPER_LIGHT_BLUE.get(),
                "Black Colored Egg with Light Blue Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLACK_CREEPER_MAGENTA.get(),
                "Black Colored Egg with Magenta Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLACK_CREEPER_ORANGE.get(),
                "Black Colored Egg with Orange Creeper Stamp");
        add(TBAItems.COLORED_EGG_BLACK_CREEPER_WHITE.get(),
                "Black Colored Egg with White Creeper Stamp");
        add(TBAItems.COLORED_EGG_WHITE_FLOWER_BLACK.get(),
                "White Colored Egg with Black Flower Stamp");
        add(TBAItems.COLORED_EGG_WHITE_FLOWER_RED.get(),
                "White Colored Egg with Red Flower Stamp");
        add(TBAItems.COLORED_EGG_WHITE_FLOWER_GREEN.get(),
                "White Colored Egg with Green Flower Stamp");
        add(TBAItems.COLORED_EGG_WHITE_FLOWER_BROWN.get(),
                "White Colored Egg with Brown Flower Stamp");
        add(TBAItems.COLORED_EGG_WHITE_FLOWER_BLUE.get(),
                "White Colored Egg with Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_WHITE_FLOWER_PURPLE.get(),
                "White Colored Egg with Purple Flower Stamp");
        add(TBAItems.COLORED_EGG_WHITE_FLOWER_CYAN.get(),
                "White Colored Egg with Cyan Flower Stamp");
        add(TBAItems.COLORED_EGG_WHITE_FLOWER_LIGHT_GRAY.get(),
                "White Colored Egg with Light Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_WHITE_FLOWER_GRAY.get(),
                "White Colored Egg with Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_WHITE_FLOWER_PINK.get(),
                "White Colored Egg with Pink Flower Stamp");
        add(TBAItems.COLORED_EGG_WHITE_FLOWER_LIME.get(),
                "White Colored Egg with Lime Flower Stamp");
        add(TBAItems.COLORED_EGG_WHITE_FLOWER_YELLOW.get(),
                "White Colored Egg with Yellow Flower Stamp");
        add(TBAItems.COLORED_EGG_WHITE_FLOWER_LIGHT_BLUE.get(),
                "White Colored Egg with Light Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_WHITE_FLOWER_MAGENTA.get(),
                "White Colored Egg with Magenta Flower Stamp");
        add(TBAItems.COLORED_EGG_WHITE_FLOWER_ORANGE.get(),
                "White Colored Egg with Orange Flower Stamp");
        add(TBAItems.COLORED_EGG_WHITE_FLOWER_WHITE.get(),
                "White Colored Egg with White Flower Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_FLOWER_BLACK.get(),
                "Orange Colored Egg with Black Flower Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_FLOWER_RED.get(),
                "Orange Colored Egg with Red Flower Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_FLOWER_GREEN.get(),
                "Orange Colored Egg with Green Flower Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_FLOWER_BROWN.get(),
                "Orange Colored Egg with Brown Flower Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_FLOWER_BLUE.get(),
                "Orange Colored Egg with Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_FLOWER_PURPLE.get(),
                "Orange Colored Egg with Purple Flower Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_FLOWER_CYAN.get(),
                "Orange Colored Egg with Cyan Flower Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_FLOWER_LIGHT_GRAY.get(),
                "Orange Colored Egg with Light Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_FLOWER_GRAY.get(),
                "Orange Colored Egg with Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_FLOWER_PINK.get(),
                "Orange Colored Egg with Pink Flower Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_FLOWER_LIME.get(),
                "Orange Colored Egg with Lime Flower Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_FLOWER_YELLOW.get(),
                "Orange Colored Egg with Yellow Flower Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_FLOWER_LIGHT_BLUE.get(),
                "Orange Colored Egg with Light Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_FLOWER_MAGENTA.get(),
                "Orange Colored Egg with Magenta Flower Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_FLOWER_ORANGE.get(),
                "Orange Colored Egg with Orange Flower Stamp");
        add(TBAItems.COLORED_EGG_ORANGE_FLOWER_WHITE.get(),
                "Orange Colored Egg with White Flower Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_FLOWER_BLACK.get(),
                "Magenta Colored Egg with Black Flower Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_FLOWER_RED.get(),
                "Magenta Colored Egg with Red Flower Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_FLOWER_GREEN.get(),
                "Magenta Colored Egg with Green Flower Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_FLOWER_BROWN.get(),
                "Magenta Colored Egg with Brown Flower Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_FLOWER_BLUE.get(),
                "Magenta Colored Egg with Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_FLOWER_PURPLE.get(),
                "Magenta Colored Egg with Purple Flower Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_FLOWER_CYAN.get(),
                "Magenta Colored Egg with Cyan Flower Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_FLOWER_LIGHT_GRAY.get(),
                "Magenta Colored Egg with Light Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_FLOWER_GRAY.get(),
                "Magenta Colored Egg with Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_FLOWER_PINK.get(),
                "Magenta Colored Egg with Pink Flower Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_FLOWER_LIME.get(),
                "Magenta Colored Egg with Lime Flower Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_FLOWER_YELLOW.get(),
                "Magenta Colored Egg with Yellow Flower Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_FLOWER_LIGHT_BLUE.get(),
                "Magenta Colored Egg with Light Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_FLOWER_MAGENTA.get(),
                "Magenta Colored Egg with Magenta Flower Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_FLOWER_ORANGE.get(),
                "Magenta Colored Egg with Orange Flower Stamp");
        add(TBAItems.COLORED_EGG_MAGENTA_FLOWER_WHITE.get(),
                "Magenta Colored Egg with White Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_BLACK.get(),
                "Light Blue Colored Egg with Black Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_RED.get(),
                "Light Blue Colored Egg with Red Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_GREEN.get(),
                "Light Blue Colored Egg with Green Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_BROWN.get(),
                "Light Blue Colored Egg with Brown Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_BLUE.get(),
                "Light Blue Colored Egg with Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_PURPLE.get(),
                "Light Blue Colored Egg with Purple Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_CYAN.get(),
                "Light Blue Colored Egg with Cyan Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_LIGHT_GRAY.get(),
                "Light Blue Colored Egg with Light Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_GRAY.get(),
                "Light Blue Colored Egg with Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_PINK.get(),
                "Light Blue Colored Egg with Pink Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_LIME.get(),
                "Light Blue Colored Egg with Lime Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_YELLOW.get(),
                "Light Blue Colored Egg with Yellow Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_LIGHT_BLUE.get(),
                "Light Blue Colored Egg with Light Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_MAGENTA.get(),
                "Light Blue Colored Egg with Magenta Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_ORANGE.get(),
                "Light Blue Colored Egg with Orange Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_WHITE.get(),
                "Light Blue Colored Egg with White Flower Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_FLOWER_BLACK.get(),
                "Yellow Colored Egg with Black Flower Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_FLOWER_RED.get(),
                "Yellow Colored Egg with Red Flower Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_FLOWER_GREEN.get(),
                "Yellow Colored Egg with Green Flower Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_FLOWER_BROWN.get(),
                "Yellow Colored Egg with Brown Flower Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_FLOWER_BLUE.get(),
                "Yellow Colored Egg with Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_FLOWER_PURPLE.get(),
                "Yellow Colored Egg with Purple Flower Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_FLOWER_CYAN.get(),
                "Yellow Colored Egg with Cyan Flower Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_FLOWER_LIGHT_GRAY.get(),
                "Yellow Colored Egg with Light Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_FLOWER_GRAY.get(),
                "Yellow Colored Egg with Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_FLOWER_PINK.get(),
                "Yellow Colored Egg with Pink Flower Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_FLOWER_LIME.get(),
                "Yellow Colored Egg with Lime Flower Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_FLOWER_YELLOW.get(),
                "Yellow Colored Egg with Yellow Flower Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_FLOWER_LIGHT_BLUE.get(),
                "Yellow Colored Egg with Light Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_FLOWER_MAGENTA.get(),
                "Yellow Colored Egg with Magenta Flower Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_FLOWER_ORANGE.get(),
                "Yellow Colored Egg with Orange Flower Stamp");
        add(TBAItems.COLORED_EGG_YELLOW_FLOWER_WHITE.get(),
                "Yellow Colored Egg with White Flower Stamp");
        add(TBAItems.COLORED_EGG_LIME_FLOWER_BLACK.get(),
                "Lime Colored Egg with Black Flower Stamp");
        add(TBAItems.COLORED_EGG_LIME_FLOWER_RED.get(),
                "Lime Colored Egg with Red Flower Stamp");
        add(TBAItems.COLORED_EGG_LIME_FLOWER_GREEN.get(),
                "Lime Colored Egg with Green Flower Stamp");
        add(TBAItems.COLORED_EGG_LIME_FLOWER_BROWN.get(),
                "Lime Colored Egg with Brown Flower Stamp");
        add(TBAItems.COLORED_EGG_LIME_FLOWER_BLUE.get(),
                "Lime Colored Egg with Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_LIME_FLOWER_PURPLE.get(),
                "Lime Colored Egg with Purple Flower Stamp");
        add(TBAItems.COLORED_EGG_LIME_FLOWER_CYAN.get(),
                "Lime Colored Egg with Cyan Flower Stamp");
        add(TBAItems.COLORED_EGG_LIME_FLOWER_LIGHT_GRAY.get(),
                "Lime Colored Egg with Light Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_LIME_FLOWER_GRAY.get(),
                "Lime Colored Egg with Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_LIME_FLOWER_PINK.get(),
                "Lime Colored Egg with Pink Flower Stamp");
        add(TBAItems.COLORED_EGG_LIME_FLOWER_LIME.get(),
                "Lime Colored Egg with Lime Flower Stamp");
        add(TBAItems.COLORED_EGG_LIME_FLOWER_YELLOW.get(),
                "Lime Colored Egg with Yellow Flower Stamp");
        add(TBAItems.COLORED_EGG_LIME_FLOWER_LIGHT_BLUE.get(),
                "Lime Colored Egg with Light Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_LIME_FLOWER_MAGENTA.get(),
                "Lime Colored Egg with Magenta Flower Stamp");
        add(TBAItems.COLORED_EGG_LIME_FLOWER_ORANGE.get(),
                "Lime Colored Egg with Orange Flower Stamp");
        add(TBAItems.COLORED_EGG_LIME_FLOWER_WHITE.get(),
                "Lime Colored Egg with White Flower Stamp");
        add(TBAItems.COLORED_EGG_PINK_FLOWER_BLACK.get(),
                "Pink Colored Egg with Black Flower Stamp");
        add(TBAItems.COLORED_EGG_PINK_FLOWER_RED.get(),
                "Pink Colored Egg with Red Flower Stamp");
        add(TBAItems.COLORED_EGG_PINK_FLOWER_GREEN.get(),
                "Pink Colored Egg with Green Flower Stamp");
        add(TBAItems.COLORED_EGG_PINK_FLOWER_BROWN.get(),
                "Pink Colored Egg with Brown Flower Stamp");
        add(TBAItems.COLORED_EGG_PINK_FLOWER_BLUE.get(),
                "Pink Colored Egg with Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_PINK_FLOWER_PURPLE.get(),
                "Pink Colored Egg with Purple Flower Stamp");
        add(TBAItems.COLORED_EGG_PINK_FLOWER_CYAN.get(),
                "Pink Colored Egg with Cyan Flower Stamp");
        add(TBAItems.COLORED_EGG_PINK_FLOWER_LIGHT_GRAY.get(),
                "Pink Colored Egg with Light Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_PINK_FLOWER_GRAY.get(),
                "Pink Colored Egg with Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_PINK_FLOWER_PINK.get(),
                "Pink Colored Egg with Pink Flower Stamp");
        add(TBAItems.COLORED_EGG_PINK_FLOWER_LIME.get(),
                "Pink Colored Egg with Lime Flower Stamp");
        add(TBAItems.COLORED_EGG_PINK_FLOWER_YELLOW.get(),
                "Pink Colored Egg with Yellow Flower Stamp");
        add(TBAItems.COLORED_EGG_PINK_FLOWER_LIGHT_BLUE.get(),
                "Pink Colored Egg with Light Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_PINK_FLOWER_MAGENTA.get(),
                "Pink Colored Egg with Magenta Flower Stamp");
        add(TBAItems.COLORED_EGG_PINK_FLOWER_ORANGE.get(),
                "Pink Colored Egg with Orange Flower Stamp");
        add(TBAItems.COLORED_EGG_PINK_FLOWER_WHITE.get(),
                "Pink Colored Egg with White Flower Stamp");
        add(TBAItems.COLORED_EGG_GRAY_FLOWER_BLACK.get(),
                "Gray Colored Egg with Black Flower Stamp");
        add(TBAItems.COLORED_EGG_GRAY_FLOWER_RED.get(),
                "Gray Colored Egg with Red Flower Stamp");
        add(TBAItems.COLORED_EGG_GRAY_FLOWER_GREEN.get(),
                "Gray Colored Egg with Green Flower Stamp");
        add(TBAItems.COLORED_EGG_GRAY_FLOWER_BROWN.get(),
                "Gray Colored Egg with Brown Flower Stamp");
        add(TBAItems.COLORED_EGG_GRAY_FLOWER_BLUE.get(),
                "Gray Colored Egg with Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_GRAY_FLOWER_PURPLE.get(),
                "Gray Colored Egg with Purple Flower Stamp");
        add(TBAItems.COLORED_EGG_GRAY_FLOWER_CYAN.get(),
                "Gray Colored Egg with Cyan Flower Stamp");
        add(TBAItems.COLORED_EGG_GRAY_FLOWER_LIGHT_GRAY.get(),
                "Gray Colored Egg with Light Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_GRAY_FLOWER_GRAY.get(),
                "Gray Colored Egg with Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_GRAY_FLOWER_PINK.get(),
                "Gray Colored Egg with Pink Flower Stamp");
        add(TBAItems.COLORED_EGG_GRAY_FLOWER_LIME.get(),
                "Gray Colored Egg with Lime Flower Stamp");
        add(TBAItems.COLORED_EGG_GRAY_FLOWER_YELLOW.get(),
                "Gray Colored Egg with Yellow Flower Stamp");
        add(TBAItems.COLORED_EGG_GRAY_FLOWER_LIGHT_BLUE.get(),
                "Gray Colored Egg with Light Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_GRAY_FLOWER_MAGENTA.get(),
                "Gray Colored Egg with Magenta Flower Stamp");
        add(TBAItems.COLORED_EGG_GRAY_FLOWER_ORANGE.get(),
                "Gray Colored Egg with Orange Flower Stamp");
        add(TBAItems.COLORED_EGG_GRAY_FLOWER_WHITE.get(),
                "Gray Colored Egg with White Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_BLACK.get(),
                "Light Gray Colored Egg with Black Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_RED.get(),
                "Light Gray Colored Egg with Red Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_GREEN.get(),
                "Light Gray Colored Egg with Green Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_BROWN.get(),
                "Light Gray Colored Egg with Brown Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_BLUE.get(),
                "Light Gray Colored Egg with Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_PURPLE.get(),
                "Light Gray Colored Egg with Purple Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_CYAN.get(),
                "Light Gray Colored Egg with Cyan Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_LIGHT_GRAY.get(),
                "Light Gray Colored Egg with Light Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_GRAY.get(),
                "Light Gray Colored Egg with Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_PINK.get(),
                "Light Gray Colored Egg with Pink Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_LIME.get(),
                "Light Gray Colored Egg with Lime Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_YELLOW.get(),
                "Light Gray Colored Egg with Yellow Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_LIGHT_BLUE.get(),
                "Light Gray Colored Egg with Light Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_MAGENTA.get(),
                "Light Gray Colored Egg with Magenta Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_ORANGE.get(),
                "Light Gray Colored Egg with Orange Flower Stamp");
        add(TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_WHITE.get(),
                "Light Gray Colored Egg with White Flower Stamp");
        add(TBAItems.COLORED_EGG_CYAN_FLOWER_BLACK.get(),
                "Cyan Colored Egg with Black Flower Stamp");
        add(TBAItems.COLORED_EGG_CYAN_FLOWER_RED.get(),
                "Cyan Colored Egg with Red Flower Stamp");
        add(TBAItems.COLORED_EGG_CYAN_FLOWER_GREEN.get(),
                "Cyan Colored Egg with Green Flower Stamp");
        add(TBAItems.COLORED_EGG_CYAN_FLOWER_BROWN.get(),
                "Cyan Colored Egg with Brown Flower Stamp");
        add(TBAItems.COLORED_EGG_CYAN_FLOWER_BLUE.get(),
                "Cyan Colored Egg with Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_CYAN_FLOWER_PURPLE.get(),
                "Cyan Colored Egg with Purple Flower Stamp");
        add(TBAItems.COLORED_EGG_CYAN_FLOWER_CYAN.get(),
                "Cyan Colored Egg with Cyan Flower Stamp");
        add(TBAItems.COLORED_EGG_CYAN_FLOWER_LIGHT_GRAY.get(),
                "Cyan Colored Egg with Light Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_CYAN_FLOWER_GRAY.get(),
                "Cyan Colored Egg with Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_CYAN_FLOWER_PINK.get(),
                "Cyan Colored Egg with Pink Flower Stamp");
        add(TBAItems.COLORED_EGG_CYAN_FLOWER_LIME.get(),
                "Cyan Colored Egg with Lime Flower Stamp");
        add(TBAItems.COLORED_EGG_CYAN_FLOWER_YELLOW.get(),
                "Cyan Colored Egg with Yellow Flower Stamp");
        add(TBAItems.COLORED_EGG_CYAN_FLOWER_LIGHT_BLUE.get(),
                "Cyan Colored Egg with Light Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_CYAN_FLOWER_MAGENTA.get(),
                "Cyan Colored Egg with Magenta Flower Stamp");
        add(TBAItems.COLORED_EGG_CYAN_FLOWER_ORANGE.get(),
                "Cyan Colored Egg with Orange Flower Stamp");
        add(TBAItems.COLORED_EGG_CYAN_FLOWER_WHITE.get(),
                "Cyan Colored Egg with White Flower Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_FLOWER_BLACK.get(),
                "Purple Colored Egg with Black Flower Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_FLOWER_RED.get(),
                "Purple Colored Egg with Red Flower Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_FLOWER_GREEN.get(),
                "Purple Colored Egg with Green Flower Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_FLOWER_BROWN.get(),
                "Purple Colored Egg with Brown Flower Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_FLOWER_BLUE.get(),
                "Purple Colored Egg with Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_FLOWER_PURPLE.get(),
                "Purple Colored Egg with Purple Flower Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_FLOWER_CYAN.get(),
                "Purple Colored Egg with Cyan Flower Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_FLOWER_LIGHT_GRAY.get(),
                "Purple Colored Egg with Light Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_FLOWER_GRAY.get(),
                "Purple Colored Egg with Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_FLOWER_PINK.get(),
                "Purple Colored Egg with Pink Flower Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_FLOWER_LIME.get(),
                "Purple Colored Egg with Lime Flower Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_FLOWER_YELLOW.get(),
                "Purple Colored Egg with Yellow Flower Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_FLOWER_LIGHT_BLUE.get(),
                "Purple Colored Egg with Light Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_FLOWER_MAGENTA.get(),
                "Purple Colored Egg with Magenta Flower Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_FLOWER_ORANGE.get(),
                "Purple Colored Egg with Orange Flower Stamp");
        add(TBAItems.COLORED_EGG_PURPLE_FLOWER_WHITE.get(),
                "Purple Colored Egg with White Flower Stamp");
        add(TBAItems.COLORED_EGG_BLUE_FLOWER_BLACK.get(),
                "Blue Colored Egg with Black Flower Stamp");
        add(TBAItems.COLORED_EGG_BLUE_FLOWER_RED.get(),
                "Blue Colored Egg with Red Flower Stamp");
        add(TBAItems.COLORED_EGG_BLUE_FLOWER_GREEN.get(),
                "Blue Colored Egg with Green Flower Stamp");
        add(TBAItems.COLORED_EGG_BLUE_FLOWER_BROWN.get(),
                "Blue Colored Egg with Brown Flower Stamp");
        add(TBAItems.COLORED_EGG_BLUE_FLOWER_BLUE.get(),
                "Blue Colored Egg with Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_BLUE_FLOWER_PURPLE.get(),
                "Blue Colored Egg with Purple Flower Stamp");
        add(TBAItems.COLORED_EGG_BLUE_FLOWER_CYAN.get(),
                "Blue Colored Egg with Cyan Flower Stamp");
        add(TBAItems.COLORED_EGG_BLUE_FLOWER_LIGHT_GRAY.get(),
                "Blue Colored Egg with Light Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_BLUE_FLOWER_GRAY.get(),
                "Blue Colored Egg with Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_BLUE_FLOWER_PINK.get(),
                "Blue Colored Egg with Pink Flower Stamp");
        add(TBAItems.COLORED_EGG_BLUE_FLOWER_LIME.get(),
                "Blue Colored Egg with Lime Flower Stamp");
        add(TBAItems.COLORED_EGG_BLUE_FLOWER_YELLOW.get(),
                "Blue Colored Egg with Yellow Flower Stamp");
        add(TBAItems.COLORED_EGG_BLUE_FLOWER_LIGHT_BLUE.get(),
                "Blue Colored Egg with Light Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_BLUE_FLOWER_MAGENTA.get(),
                "Blue Colored Egg with Magenta Flower Stamp");
        add(TBAItems.COLORED_EGG_BLUE_FLOWER_ORANGE.get(),
                "Blue Colored Egg with Orange Flower Stamp");
        add(TBAItems.COLORED_EGG_BLUE_FLOWER_WHITE.get(),
                "Blue Colored Egg with White Flower Stamp");
        add(TBAItems.COLORED_EGG_BROWN_FLOWER_BLACK.get(),
                "Brown Colored Egg with Black Flower Stamp");
        add(TBAItems.COLORED_EGG_BROWN_FLOWER_RED.get(),
                "Brown Colored Egg with Red Flower Stamp");
        add(TBAItems.COLORED_EGG_BROWN_FLOWER_GREEN.get(),
                "Brown Colored Egg with Green Flower Stamp");
        add(TBAItems.COLORED_EGG_BROWN_FLOWER_BROWN.get(),
                "Brown Colored Egg with Brown Flower Stamp");
        add(TBAItems.COLORED_EGG_BROWN_FLOWER_BLUE.get(),
                "Brown Colored Egg with Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_BROWN_FLOWER_PURPLE.get(),
                "Brown Colored Egg with Purple Flower Stamp");
        add(TBAItems.COLORED_EGG_BROWN_FLOWER_CYAN.get(),
                "Brown Colored Egg with Cyan Flower Stamp");
        add(TBAItems.COLORED_EGG_BROWN_FLOWER_LIGHT_GRAY.get(),
                "Brown Colored Egg with Light Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_BROWN_FLOWER_GRAY.get(),
                "Brown Colored Egg with Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_BROWN_FLOWER_PINK.get(),
                "Brown Colored Egg with Pink Flower Stamp");
        add(TBAItems.COLORED_EGG_BROWN_FLOWER_LIME.get(),
                "Brown Colored Egg with Lime Flower Stamp");
        add(TBAItems.COLORED_EGG_BROWN_FLOWER_YELLOW.get(),
                "Brown Colored Egg with Yellow Flower Stamp");
        add(TBAItems.COLORED_EGG_BROWN_FLOWER_LIGHT_BLUE.get(),
                "Brown Colored Egg with Light Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_BROWN_FLOWER_MAGENTA.get(),
                "Brown Colored Egg with Magenta Flower Stamp");
        add(TBAItems.COLORED_EGG_BROWN_FLOWER_ORANGE.get(),
                "Brown Colored Egg with Orange Flower Stamp");
        add(TBAItems.COLORED_EGG_BROWN_FLOWER_WHITE.get(),
                "Brown Colored Egg with White Flower Stamp");
        add(TBAItems.COLORED_EGG_GREEN_FLOWER_BLACK.get(),
                "Green Colored Egg with Black Flower Stamp");
        add(TBAItems.COLORED_EGG_GREEN_FLOWER_RED.get(),
                "Green Colored Egg with Red Flower Stamp");
        add(TBAItems.COLORED_EGG_GREEN_FLOWER_GREEN.get(),
                "Green Colored Egg with Green Flower Stamp");
        add(TBAItems.COLORED_EGG_GREEN_FLOWER_BROWN.get(),
                "Green Colored Egg with Brown Flower Stamp");
        add(TBAItems.COLORED_EGG_GREEN_FLOWER_BLUE.get(),
                "Green Colored Egg with Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_GREEN_FLOWER_PURPLE.get(),
                "Green Colored Egg with Purple Flower Stamp");
        add(TBAItems.COLORED_EGG_GREEN_FLOWER_CYAN.get(),
                "Green Colored Egg with Cyan Flower Stamp");
        add(TBAItems.COLORED_EGG_GREEN_FLOWER_LIGHT_GRAY.get(),
                "Green Colored Egg with Light Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_GREEN_FLOWER_GRAY.get(),
                "Green Colored Egg with Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_GREEN_FLOWER_PINK.get(),
                "Green Colored Egg with Pink Flower Stamp");
        add(TBAItems.COLORED_EGG_GREEN_FLOWER_LIME.get(),
                "Green Colored Egg with Lime Flower Stamp");
        add(TBAItems.COLORED_EGG_GREEN_FLOWER_YELLOW.get(),
                "Green Colored Egg with Yellow Flower Stamp");
        add(TBAItems.COLORED_EGG_GREEN_FLOWER_LIGHT_BLUE.get(),
                "Green Colored Egg with Light Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_GREEN_FLOWER_MAGENTA.get(),
                "Green Colored Egg with Magenta Flower Stamp");
        add(TBAItems.COLORED_EGG_GREEN_FLOWER_ORANGE.get(),
                "Green Colored Egg with Orange Flower Stamp");
        add(TBAItems.COLORED_EGG_GREEN_FLOWER_WHITE.get(),
                "Green Colored Egg with White Flower Stamp");
        add(TBAItems.COLORED_EGG_RED_FLOWER_BLACK.get(),
                "Red Colored Egg with Black Flower Stamp");
        add(TBAItems.COLORED_EGG_RED_FLOWER_RED.get(),
                "Red Colored Egg with Red Flower Stamp");
        add(TBAItems.COLORED_EGG_RED_FLOWER_GREEN.get(),
                "Red Colored Egg with Green Flower Stamp");
        add(TBAItems.COLORED_EGG_RED_FLOWER_BROWN.get(),
                "Red Colored Egg with Brown Flower Stamp");
        add(TBAItems.COLORED_EGG_RED_FLOWER_BLUE.get(),
                "Red Colored Egg with Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_RED_FLOWER_PURPLE.get(),
                "Red Colored Egg with Purple Flower Stamp");
        add(TBAItems.COLORED_EGG_RED_FLOWER_CYAN.get(),
                "Red Colored Egg with Cyan Flower Stamp");
        add(TBAItems.COLORED_EGG_RED_FLOWER_LIGHT_GRAY.get(),
                "Red Colored Egg with Light Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_RED_FLOWER_GRAY.get(),
                "Red Colored Egg with Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_RED_FLOWER_PINK.get(),
                "Red Colored Egg with Pink Flower Stamp");
        add(TBAItems.COLORED_EGG_RED_FLOWER_LIME.get(),
                "Red Colored Egg with Lime Flower Stamp");
        add(TBAItems.COLORED_EGG_RED_FLOWER_YELLOW.get(),
                "Red Colored Egg with Yellow Flower Stamp");
        add(TBAItems.COLORED_EGG_RED_FLOWER_LIGHT_BLUE.get(),
                "Red Colored Egg with Light Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_RED_FLOWER_MAGENTA.get(),
                "Red Colored Egg with Magenta Flower Stamp");
        add(TBAItems.COLORED_EGG_RED_FLOWER_ORANGE.get(),
                "Red Colored Egg with Orange Flower Stamp");
        add(TBAItems.COLORED_EGG_RED_FLOWER_WHITE.get(),
                "Red Colored Egg with White Flower Stamp");
        add(TBAItems.COLORED_EGG_BLACK_FLOWER_BLACK.get(),
                "Black Colored Egg with Black Flower Stamp");
        add(TBAItems.COLORED_EGG_BLACK_FLOWER_RED.get(),
                "Black Colored Egg with Red Flower Stamp");
        add(TBAItems.COLORED_EGG_BLACK_FLOWER_GREEN.get(),
                "Black Colored Egg with Green Flower Stamp");
        add(TBAItems.COLORED_EGG_BLACK_FLOWER_BROWN.get(),
                "Black Colored Egg with Brown Flower Stamp");
        add(TBAItems.COLORED_EGG_BLACK_FLOWER_BLUE.get(),
                "Black Colored Egg with Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_BLACK_FLOWER_PURPLE.get(),
                "Black Colored Egg with Purple Flower Stamp");
        add(TBAItems.COLORED_EGG_BLACK_FLOWER_CYAN.get(),
                "Black Colored Egg with Cyan Flower Stamp");
        add(TBAItems.COLORED_EGG_BLACK_FLOWER_LIGHT_GRAY.get(),
                "Black Colored Egg with Light Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_BLACK_FLOWER_GRAY.get(),
                "Black Colored Egg with Gray Flower Stamp");
        add(TBAItems.COLORED_EGG_BLACK_FLOWER_PINK.get(),
                "Black Colored Egg with Pink Flower Stamp");
        add(TBAItems.COLORED_EGG_BLACK_FLOWER_LIME.get(),
                "Black Colored Egg with Lime Flower Stamp");
        add(TBAItems.COLORED_EGG_BLACK_FLOWER_YELLOW.get(),
                "Black Colored Egg with Yellow Flower Stamp");
        add(TBAItems.COLORED_EGG_BLACK_FLOWER_LIGHT_BLUE.get(),
                "Black Colored Egg with Light Blue Flower Stamp");
        add(TBAItems.COLORED_EGG_BLACK_FLOWER_MAGENTA.get(),
                "Black Colored Egg with Magenta Flower Stamp");
        add(TBAItems.COLORED_EGG_BLACK_FLOWER_ORANGE.get(),
                "Black Colored Egg with Orange Flower Stamp");
        add(TBAItems.COLORED_EGG_BLACK_FLOWER_WHITE.get(),
                "Black Colored Egg with White Flower Stamp");
    }

    private void addBlocks() {
        add(TBABlocks.CERTIFICATE_BLOCK.get(), "Certificate of Completion");
        add(TBABlocks.QUARTZ_CLUSTER.get(), "Quartz Cluster");
        add(TBABlocks.FERMENTING_POT_BLOCK.get(), "Fermenting Pot");
        add(TBABlocks.CLOVE_BUSH.get(), "Clove Bush");
        add(TBABlocks.CUCUMBER_BUSH.get(), "Cucumber Bush");
        add(TBABlocks.DILL_BUSH.get(), "Dill Crop");

        add(TBABlocks.TBA_MINING_PORTAL_BLOCK.get(), "Mining Portal Block");

        add(TBABlocks.PICNIC_BLANKET_WHITE.get(), "White Picnic Blanket");
        add(TBABlocks.PICNIC_BLANKET_ORANGE.get(), "Orange Picnic Blanket");
        add(TBABlocks.PICNIC_BLANKET_MAGENTA.get(), "Magenta Picnic Blanket");
        add(TBABlocks.PICNIC_BLANKET_LIGHT_BLUE.get(), "Light Blue Picnic Blanket");
        add(TBABlocks.PICNIC_BLANKET_YELLOW.get(), "Yellow Picnic Blanket");
        add(TBABlocks.PICNIC_BLANKET_LIME.get(), "Lime Picnic Blanket");
        add(TBABlocks.PICNIC_BLANKET_PINK.get(), "Pink Picnic Blanket");
        add(TBABlocks.PICNIC_BLANKET_GRAY.get(), "Gray Picnic Blanket");
        add(TBABlocks.PICNIC_BLANKET_LIGHT_GRAY.get(), "Light Gray Picnic Blanket");
        add(TBABlocks.PICNIC_BLANKET_CYAN.get(), "Cyan Picnic Blanket");
        add(TBABlocks.PICNIC_BLANKET_PURPLE.get(), "Purple Picnic Blanket");
        add(TBABlocks.PICNIC_BLANKET_BLUE.get(), "Blue Picnic Blanket");
        add(TBABlocks.PICNIC_BLANKET_BROWN.get(), "Brown Picnic Blanket");
        add(TBABlocks.PICNIC_BLANKET_GREEN.get(), "Green Picnic Blanket");
        add(TBABlocks.PICNIC_BLANKET_RED.get(), "Red Picnic Blanket");
        add(TBABlocks.PICNIC_BLANKET_BLACK.get(), "Black Picnic Blanket");

        add(TBABlocks.PLATE_WHITE.get(), "White Plate");
        add(TBABlocks.PLATE_ORANGE.get(), "Orange Plate");
        add(TBABlocks.PLATE_MAGENTA.get(), "Magenta Plate");
        add(TBABlocks.PLATE_LIGHT_BLUE.get(), "Light Blue Plate");
        add(TBABlocks.PLATE_YELLOW.get(), "Yellow Plate");
        add(TBABlocks.PLATE_LIME.get(), "Lime Plate");
        add(TBABlocks.PLATE_PINK.get(), "Pink Plate");
        add(TBABlocks.PLATE_GRAY.get(), "Gray Plate");
        add(TBABlocks.PLATE_LIGHT_GRAY.get(), "Light Gray Plate");
        add(TBABlocks.PLATE_CYAN.get(), "Cyan Plate");
        add(TBABlocks.PLATE_PURPLE.get(), "Purple Plate");
        add(TBABlocks.PLATE_BLUE.get(), "Blue Plate");
        add(TBABlocks.PLATE_BROWN.get(), "Brown Plate");
        add(TBABlocks.PLATE_GREEN.get(), "Green Plate");
        add(TBABlocks.PLATE_RED.get(), "Red Plate");
        add(TBABlocks.PLATE_BLACK.get(), "Black Plate");

        add(TBABlocks.SCHOOL_DESK_OAK.get(), "Oak School Desk");
        add(TBABlocks.SCHOOL_DESK_BIRCH.get(), "Birch School Desk");
        add(TBABlocks.SCHOOL_DESK_SPRUCE.get(), "Spruce School Desk");
        add(TBABlocks.SCHOOL_DESK_JUNGLE.get(), "Jungle School Desk");
        add(TBABlocks.SCHOOL_DESK_ACACIA.get(), "Acacia School Desk");
        add(TBABlocks.SCHOOL_DESK_DARK_OAK.get(), "Dark Oak School Desk");
        add(TBABlocks.SCHOOL_DESK_MANGROVE.get(), "Mangrove School Desk");
        add(TBABlocks.SCHOOL_DESK_CRIMSON.get(), "Crimson School Desk");
        add(TBABlocks.SCHOOL_DESK_WARPED.get(), "Warped School Desk");

        add(TBABlocks.SCHOOL_DESK_CABINET_OAK.get(), "Oak School Desk Cabinet");
        add(TBABlocks.SCHOOL_DESK_CABINET_BIRCH.get(), "Birch School Desk Cabinet");
        add(TBABlocks.SCHOOL_DESK_CABINET_SPRUCE.get(), "Spruce School Desk Cabinet");
        add(TBABlocks.SCHOOL_DESK_CABINET_JUNGLE.get(), "Jungle School Desk Cabinet");
        add(TBABlocks.SCHOOL_DESK_CABINET_ACACIA.get(), "Acacia School Desk Cabinet");
        add(TBABlocks.SCHOOL_DESK_CABINET_DARK_OAK.get(), "Dark Oak School Desk Cabinet");
        add(TBABlocks.SCHOOL_DESK_CABINET_MANGROVE.get(), "Mangrove School Desk Cabinet");
        add(TBABlocks.SCHOOL_DESK_CABINET_CRIMSON.get(), "Crimson School Desk Cabinet");
        add(TBABlocks.SCHOOL_DESK_CABINET_WARPED.get(), "Warped School Desk Cabinet");

        add(TBABlocks.DESK_CHAIR_OAK.get(), "Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_OAK_WHITE.get(), "White Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_OAK_ORANGE.get(), "Orange Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_OAK_MAGENTA.get(), "Magenta Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_OAK_LIGHT_BLUE.get(), "Light Blue Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_OAK_YELLOW.get(), "Yellow Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_OAK_LIME.get(), "Lime Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_OAK_PINK.get(), "Pink Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_OAK_GRAY.get(), "Gray Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_OAK_LIGHT_GRAY.get(), "Light Gray Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_OAK_CYAN.get(), "Cyan Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_OAK_PURPLE.get(), "Purple Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_OAK_BLUE.get(), "Blue Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_OAK_BROWN.get(), "Brown Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_OAK_GREEN.get(), "Green Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_OAK_RED.get(), "Red Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_OAK_BLACK.get(), "Black Oak Desk Chair");

        add(TBABlocks.DESK_CHAIR_BIRCH.get(), "Birch Desk Chair");
        add(TBABlocks.DESK_CHAIR_BIRCH_WHITE.get(), "White Birch Desk Chair");
        add(TBABlocks.DESK_CHAIR_BIRCH_ORANGE.get(), "Orange Birch Desk Chair");
        add(TBABlocks.DESK_CHAIR_BIRCH_MAGENTA.get(), "Magenta Birch Desk Chair");
        add(TBABlocks.DESK_CHAIR_BIRCH_LIGHT_BLUE.get(), "Light Blue Birch Desk Chair");
        add(TBABlocks.DESK_CHAIR_BIRCH_YELLOW.get(), "Yellow Birch Desk Chair");
        add(TBABlocks.DESK_CHAIR_BIRCH_LIME.get(), "Lime Birch Desk Chair");
        add(TBABlocks.DESK_CHAIR_BIRCH_PINK.get(), "Pink Birch Desk Chair");
        add(TBABlocks.DESK_CHAIR_BIRCH_GRAY.get(), "Gray Birch Desk Chair");
        add(TBABlocks.DESK_CHAIR_BIRCH_LIGHT_GRAY.get(), "Light Gray Birch Desk Chair");
        add(TBABlocks.DESK_CHAIR_BIRCH_CYAN.get(), "Cyan Birch Desk Chair");
        add(TBABlocks.DESK_CHAIR_BIRCH_PURPLE.get(), "Purple Birch Desk Chair");
        add(TBABlocks.DESK_CHAIR_BIRCH_BLUE.get(), "Blue Birch Desk Chair");
        add(TBABlocks.DESK_CHAIR_BIRCH_BROWN.get(), "Brown Birch Desk Chair");
        add(TBABlocks.DESK_CHAIR_BIRCH_GREEN.get(), "Green Birch Desk Chair");
        add(TBABlocks.DESK_CHAIR_BIRCH_RED.get(), "Red Birch Desk Chair");
        add(TBABlocks.DESK_CHAIR_BIRCH_BLACK.get(), "Black Birch Desk Chair");

        add(TBABlocks.DESK_CHAIR_SPRUCE.get(), "Spruce Desk Chair");
        add(TBABlocks.DESK_CHAIR_SPRUCE_WHITE.get(), "White Spruce Desk Chair");
        add(TBABlocks.DESK_CHAIR_SPRUCE_ORANGE.get(), "Orange Spruce Desk Chair");
        add(TBABlocks.DESK_CHAIR_SPRUCE_MAGENTA.get(), "Magenta Spruce Desk Chair");
        add(TBABlocks.DESK_CHAIR_SPRUCE_LIGHT_BLUE.get(), "Light Blue Spruce Desk Chair");
        add(TBABlocks.DESK_CHAIR_SPRUCE_YELLOW.get(), "Yellow Spruce Desk Chair");
        add(TBABlocks.DESK_CHAIR_SPRUCE_LIME.get(), "Lime Spruce Desk Chair");
        add(TBABlocks.DESK_CHAIR_SPRUCE_PINK.get(), "Pink Spruce Desk Chair");
        add(TBABlocks.DESK_CHAIR_SPRUCE_GRAY.get(), "Gray Spruce Desk Chair");
        add(TBABlocks.DESK_CHAIR_SPRUCE_LIGHT_GRAY.get(), "Light Gray Spruce Desk Chair");
        add(TBABlocks.DESK_CHAIR_SPRUCE_CYAN.get(), "Cyan Spruce Desk Chair");
        add(TBABlocks.DESK_CHAIR_SPRUCE_PURPLE.get(), "Purple Spruce Desk Chair");
        add(TBABlocks.DESK_CHAIR_SPRUCE_BLUE.get(), "Blue Spruce Desk Chair");
        add(TBABlocks.DESK_CHAIR_SPRUCE_BROWN.get(), "Brown Spruce Desk Chair");
        add(TBABlocks.DESK_CHAIR_SPRUCE_GREEN.get(), "Green Spruce Desk Chair");
        add(TBABlocks.DESK_CHAIR_SPRUCE_RED.get(), "Red Spruce Desk Chair");
        add(TBABlocks.DESK_CHAIR_SPRUCE_BLACK.get(), "Black Spruce Desk Chair");

        add(TBABlocks.DESK_CHAIR_JUNGLE.get(), "Jungle Desk Chair");
        add(TBABlocks.DESK_CHAIR_JUNGLE_WHITE.get(), "White Jungle Desk Chair");
        add(TBABlocks.DESK_CHAIR_JUNGLE_ORANGE.get(), "Orange Jungle Desk Chair");
        add(TBABlocks.DESK_CHAIR_JUNGLE_MAGENTA.get(), "Magenta Jungle Desk Chair");
        add(TBABlocks.DESK_CHAIR_JUNGLE_LIGHT_BLUE.get(), "Light Blue Jungle Desk Chair");
        add(TBABlocks.DESK_CHAIR_JUNGLE_YELLOW.get(), "Yellow Jungle Desk Chair");
        add(TBABlocks.DESK_CHAIR_JUNGLE_LIME.get(), "Lime Jungle Desk Chair");
        add(TBABlocks.DESK_CHAIR_JUNGLE_PINK.get(), "Pink Jungle Desk Chair");
        add(TBABlocks.DESK_CHAIR_JUNGLE_GRAY.get(), "Gray Jungle Desk Chair");
        add(TBABlocks.DESK_CHAIR_JUNGLE_LIGHT_GRAY.get(), "Light Gray Jungle Desk Chair");
        add(TBABlocks.DESK_CHAIR_JUNGLE_CYAN.get(), "Cyan Jungle Desk Chair");
        add(TBABlocks.DESK_CHAIR_JUNGLE_PURPLE.get(), "Purple Jungle Desk Chair");
        add(TBABlocks.DESK_CHAIR_JUNGLE_BLUE.get(), "Blue Jungle Desk Chair");
        add(TBABlocks.DESK_CHAIR_JUNGLE_BROWN.get(), "Brown Jungle Desk Chair");
        add(TBABlocks.DESK_CHAIR_JUNGLE_GREEN.get(), "Green Jungle Desk Chair");
        add(TBABlocks.DESK_CHAIR_JUNGLE_RED.get(), "Red Jungle Desk Chair");
        add(TBABlocks.DESK_CHAIR_JUNGLE_BLACK.get(), "Black Jungle Desk Chair");

        add(TBABlocks.DESK_CHAIR_ACACIA.get(), "Acacia Desk Chair");
        add(TBABlocks.DESK_CHAIR_ACACIA_WHITE.get(), "White Acacia Desk Chair");
        add(TBABlocks.DESK_CHAIR_ACACIA_ORANGE.get(), "Orange Acacia Desk Chair");
        add(TBABlocks.DESK_CHAIR_ACACIA_MAGENTA.get(), "Magenta Acacia Desk Chair");
        add(TBABlocks.DESK_CHAIR_ACACIA_LIGHT_BLUE.get(), "Light Blue Acacia Desk Chair");
        add(TBABlocks.DESK_CHAIR_ACACIA_YELLOW.get(), "Yellow Acacia Desk Chair");
        add(TBABlocks.DESK_CHAIR_ACACIA_LIME.get(), "Lime Acacia Desk Chair");
        add(TBABlocks.DESK_CHAIR_ACACIA_PINK.get(), "Pink Acacia Desk Chair");
        add(TBABlocks.DESK_CHAIR_ACACIA_GRAY.get(), "Gray Acacia Desk Chair");
        add(TBABlocks.DESK_CHAIR_ACACIA_LIGHT_GRAY.get(), "Light Gray Acacia Desk Chair");
        add(TBABlocks.DESK_CHAIR_ACACIA_CYAN.get(), "Cyan Acacia Desk Chair");
        add(TBABlocks.DESK_CHAIR_ACACIA_PURPLE.get(), "Purple Acacia Desk Chair");
        add(TBABlocks.DESK_CHAIR_ACACIA_BLUE.get(), "Blue Acacia Desk Chair");
        add(TBABlocks.DESK_CHAIR_ACACIA_BROWN.get(), "Brown Acacia Desk Chair");
        add(TBABlocks.DESK_CHAIR_ACACIA_GREEN.get(), "Green Acacia Desk Chair");
        add(TBABlocks.DESK_CHAIR_ACACIA_RED.get(), "Red Acacia Desk Chair");
        add(TBABlocks.DESK_CHAIR_ACACIA_BLACK.get(), "Black Acacia Desk Chair");

        add(TBABlocks.DESK_CHAIR_DARK_OAK.get(), "Dark Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_DARK_OAK_WHITE.get(), "White Dark Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_DARK_OAK_ORANGE.get(), "Orange Dark Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_DARK_OAK_MAGENTA.get(), "Magenta Dark Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_DARK_OAK_LIGHT_BLUE.get(), "Light Blue Dark Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_DARK_OAK_YELLOW.get(), "Yellow Dark Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_DARK_OAK_LIME.get(), "Lime Dark Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_DARK_OAK_PINK.get(), "Pink Dark Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_DARK_OAK_GRAY.get(), "Gray Dark Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_DARK_OAK_LIGHT_GRAY.get(), "Light Gray Dark Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_DARK_OAK_CYAN.get(), "Cyan Dark Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_DARK_OAK_PURPLE.get(), "Purple Dark Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_DARK_OAK_BLUE.get(), "Blue Dark Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_DARK_OAK_BROWN.get(), "Brown Dark Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_DARK_OAK_GREEN.get(), "Green Dark Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_DARK_OAK_RED.get(), "Red Dark Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_DARK_OAK_BLACK.get(), "Black Dark Oak Desk Chair");

        add(TBABlocks.DESK_CHAIR_MANGROVE.get(), "Mangrove Desk Chair");
        add(TBABlocks.DESK_CHAIR_MANGROVE_WHITE.get(), "White Mangrove Desk Chair");
        add(TBABlocks.DESK_CHAIR_MANGROVE_ORANGE.get(), "Orange Mangrove Desk Chair");
        add(TBABlocks.DESK_CHAIR_MANGROVE_MAGENTA.get(), "Magenta Mangrove Desk Chair");
        add(TBABlocks.DESK_CHAIR_MANGROVE_LIGHT_BLUE.get(), "Light Blue Mangrove Desk Chair");
        add(TBABlocks.DESK_CHAIR_MANGROVE_YELLOW.get(), "Yellow Mangrove Desk Chair");
        add(TBABlocks.DESK_CHAIR_MANGROVE_LIME.get(), "Lime Mangrove Desk Chair");
        add(TBABlocks.DESK_CHAIR_MANGROVE_PINK.get(), "Pink Mangrove Desk Chair");
        add(TBABlocks.DESK_CHAIR_MANGROVE_GRAY.get(), "Gray Mangrove Desk Chair");
        add(TBABlocks.DESK_CHAIR_MANGROVE_LIGHT_GRAY.get(), "Light Gray Mangrove Desk Chair");
        add(TBABlocks.DESK_CHAIR_MANGROVE_CYAN.get(), "Cyan Mangrove Desk Chair");
        add(TBABlocks.DESK_CHAIR_MANGROVE_PURPLE.get(), "Purple Mangrove Desk Chair");
        add(TBABlocks.DESK_CHAIR_MANGROVE_BLUE.get(), "Blue Mangrove Desk Chair");
        add(TBABlocks.DESK_CHAIR_MANGROVE_BROWN.get(), "Brown Mangrove Desk Chair");
        add(TBABlocks.DESK_CHAIR_MANGROVE_GREEN.get(), "Green Mangrove Desk Chair");
        add(TBABlocks.DESK_CHAIR_MANGROVE_RED.get(), "Red Mangrove Desk Chair");
        add(TBABlocks.DESK_CHAIR_MANGROVE_BLACK.get(), "Black Mangrove Desk Chair");

        add(TBABlocks.DESK_CHAIR_CRIMSON.get(), "Crimson Desk Chair");
        add(TBABlocks.DESK_CHAIR_CRIMSON_WHITE.get(), "White Crimson Desk Chair");
        add(TBABlocks.DESK_CHAIR_CRIMSON_ORANGE.get(), "Orange Crimson Desk Chair");
        add(TBABlocks.DESK_CHAIR_CRIMSON_MAGENTA.get(), "Magenta Crimson Desk Chair");
        add(TBABlocks.DESK_CHAIR_CRIMSON_LIGHT_BLUE.get(), "Light Blue Crimson Desk Chair");
        add(TBABlocks.DESK_CHAIR_CRIMSON_YELLOW.get(), "Yellow Crimson Desk Chair");
        add(TBABlocks.DESK_CHAIR_CRIMSON_LIME.get(), "Lime Crimson Desk Chair");
        add(TBABlocks.DESK_CHAIR_CRIMSON_PINK.get(), "Pink Crimson Desk Chair");
        add(TBABlocks.DESK_CHAIR_CRIMSON_GRAY.get(), "Gray Crimson Desk Chair");
        add(TBABlocks.DESK_CHAIR_CRIMSON_LIGHT_GRAY.get(), "Light Gray Crimson Desk Chair");
        add(TBABlocks.DESK_CHAIR_CRIMSON_CYAN.get(), "Cyan Crimson Desk Chair");
        add(TBABlocks.DESK_CHAIR_CRIMSON_PURPLE.get(), "Purple Crimson Desk Chair");
        add(TBABlocks.DESK_CHAIR_CRIMSON_BLUE.get(), "Blue Crimson Desk Chair");
        add(TBABlocks.DESK_CHAIR_CRIMSON_BROWN.get(), "Brown Crimson Desk Chair");
        add(TBABlocks.DESK_CHAIR_CRIMSON_GREEN.get(), "Green Crimson Desk Chair");
        add(TBABlocks.DESK_CHAIR_CRIMSON_RED.get(), "Red Crimson Desk Chair");
        add(TBABlocks.DESK_CHAIR_CRIMSON_BLACK.get(), "Black Crimson Desk Chair");

        add(TBABlocks.DESK_CHAIR_WARPED.get(), "Warped Desk Chair");
        add(TBABlocks.DESK_CHAIR_WARPED_WHITE.get(), "White Warped Desk Chair");
        add(TBABlocks.DESK_CHAIR_WARPED_ORANGE.get(), "Orange Warped Desk Chair");
        add(TBABlocks.DESK_CHAIR_WARPED_MAGENTA.get(), "Magenta Warped Desk Chair");
        add(TBABlocks.DESK_CHAIR_WARPED_LIGHT_BLUE.get(), "Light Blue Warped Desk Chair");
        add(TBABlocks.DESK_CHAIR_WARPED_YELLOW.get(), "Yellow Warped Desk Chair");
        add(TBABlocks.DESK_CHAIR_WARPED_LIME.get(), "Lime Warped Desk Chair");
        add(TBABlocks.DESK_CHAIR_WARPED_PINK.get(), "Pink Warped Desk Chair");
        add(TBABlocks.DESK_CHAIR_WARPED_GRAY.get(), "Gray Warped Desk Chair");
        add(TBABlocks.DESK_CHAIR_WARPED_LIGHT_GRAY.get(), "Light Gray Warped Desk Chair");
        add(TBABlocks.DESK_CHAIR_WARPED_CYAN.get(), "Cyan Warped Desk Chair");
        add(TBABlocks.DESK_CHAIR_WARPED_PURPLE.get(), "Purple Warped Desk Chair");
        add(TBABlocks.DESK_CHAIR_WARPED_BLUE.get(), "Blue Warped Desk Chair");
        add(TBABlocks.DESK_CHAIR_WARPED_BROWN.get(), "Brown Warped Desk Chair");
        add(TBABlocks.DESK_CHAIR_WARPED_GREEN.get(), "Green Warped Desk Chair");
        add(TBABlocks.DESK_CHAIR_WARPED_RED.get(), "Red Warped Desk Chair");
        add(TBABlocks.DESK_CHAIR_WARPED_BLACK.get(), "Black Warped Desk Chair");

        add(TBABlocks.DESK_CHAIR_FIR.get(), "Fir Desk Chair");
        add(TBABlocks.DESK_CHAIR_FIR_WHITE.get(), "White Fir Desk Chair");
        add(TBABlocks.DESK_CHAIR_FIR_ORANGE.get(), "Orange Fir Desk Chair");
        add(TBABlocks.DESK_CHAIR_FIR_MAGENTA.get(), "Magenta Fir Desk Chair");
        add(TBABlocks.DESK_CHAIR_FIR_LIGHT_BLUE.get(), "Light Blue Fir Desk Chair");
        add(TBABlocks.DESK_CHAIR_FIR_YELLOW.get(), "Yellow Fir Desk Chair");
        add(TBABlocks.DESK_CHAIR_FIR_LIME.get(), "Lime Fir Desk Chair");
        add(TBABlocks.DESK_CHAIR_FIR_PINK.get(), "Pink Fir Desk Chair");
        add(TBABlocks.DESK_CHAIR_FIR_GRAY.get(), "Gray Fir Desk Chair");
        add(TBABlocks.DESK_CHAIR_FIR_LIGHT_GRAY.get(), "Light Gray Fir Desk Chair");
        add(TBABlocks.DESK_CHAIR_FIR_CYAN.get(), "Cyan Fir Desk Chair");
        add(TBABlocks.DESK_CHAIR_FIR_PURPLE.get(), "Purple Fir Desk Chair");
        add(TBABlocks.DESK_CHAIR_FIR_BLUE.get(), "Blue Fir Desk Chair");
        add(TBABlocks.DESK_CHAIR_FIR_BROWN.get(), "Brown Fir Desk Chair");
        add(TBABlocks.DESK_CHAIR_FIR_GREEN.get(), "Green Fir Desk Chair");
        add(TBABlocks.DESK_CHAIR_FIR_RED.get(), "Red Fir Desk Chair");
        add(TBABlocks.DESK_CHAIR_FIR_BLACK.get(), "Black Fir Desk Chair");

        add(TBABlocks.DESK_CHAIR_REDWOOD.get(), "Redwood Desk Chair");
        add(TBABlocks.DESK_CHAIR_REDWOOD_WHITE.get(), "White Redwood Desk Chair");
        add(TBABlocks.DESK_CHAIR_REDWOOD_ORANGE.get(), "Orange Redwood Desk Chair");
        add(TBABlocks.DESK_CHAIR_REDWOOD_MAGENTA.get(), "Magenta Redwood Desk Chair");
        add(TBABlocks.DESK_CHAIR_REDWOOD_LIGHT_BLUE.get(), "Light Blue Redwood Desk Chair");
        add(TBABlocks.DESK_CHAIR_REDWOOD_YELLOW.get(), "Yellow Redwood Desk Chair");
        add(TBABlocks.DESK_CHAIR_REDWOOD_LIME.get(), "Lime Redwood Desk Chair");
        add(TBABlocks.DESK_CHAIR_REDWOOD_PINK.get(), "Pink Redwood Desk Chair");
        add(TBABlocks.DESK_CHAIR_REDWOOD_GRAY.get(), "Gray Redwood Desk Chair");
        add(TBABlocks.DESK_CHAIR_REDWOOD_LIGHT_GRAY.get(), "Light Gray Redwood Desk Chair");
        add(TBABlocks.DESK_CHAIR_REDWOOD_CYAN.get(), "Cyan Redwood Desk Chair");
        add(TBABlocks.DESK_CHAIR_REDWOOD_PURPLE.get(), "Purple Redwood Desk Chair");
        add(TBABlocks.DESK_CHAIR_REDWOOD_BLUE.get(), "Blue Redwood Desk Chair");
        add(TBABlocks.DESK_CHAIR_REDWOOD_BROWN.get(), "Brown Redwood Desk Chair");
        add(TBABlocks.DESK_CHAIR_REDWOOD_GREEN.get(), "Green Redwood Desk Chair");
        add(TBABlocks.DESK_CHAIR_REDWOOD_RED.get(), "Red Redwood Desk Chair");
        add(TBABlocks.DESK_CHAIR_REDWOOD_BLACK.get(), "Black Redwood Desk Chair");

        add(TBABlocks.DESK_CHAIR_CHERRY.get(), "Cherry Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHERRY_WHITE.get(), "White Cherry Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHERRY_ORANGE.get(), "Orange Cherry Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHERRY_MAGENTA.get(), "Magenta Cherry Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHERRY_LIGHT_BLUE.get(), "Light Blue Cherry Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHERRY_YELLOW.get(), "Yellow Cherry Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHERRY_LIME.get(), "Lime Cherry Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHERRY_PINK.get(), "Pink Cherry Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHERRY_GRAY.get(), "Gray Cherry Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHERRY_LIGHT_GRAY.get(), "Light Gray Cherry Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHERRY_CYAN.get(), "Cyan Cherry Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHERRY_PURPLE.get(), "Purple Cherry Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHERRY_BLUE.get(), "Blue Cherry Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHERRY_BROWN.get(), "Brown Cherry Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHERRY_GREEN.get(), "Green Cherry Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHERRY_RED.get(), "Red Cherry Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHERRY_BLACK.get(), "Black Cherry Desk Chair");

        add(TBABlocks.DESK_CHAIR_MAHOGANY.get(), "Mahogany Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAHOGANY_WHITE.get(), "White Mahogany Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAHOGANY_ORANGE.get(), "Orange Mahogany Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAHOGANY_MAGENTA.get(), "Magenta Mahogany Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAHOGANY_LIGHT_BLUE.get(), "Light Blue Mahogany Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAHOGANY_YELLOW.get(), "Yellow Mahogany Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAHOGANY_LIME.get(), "Lime Mahogany Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAHOGANY_PINK.get(), "Pink Mahogany Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAHOGANY_GRAY.get(), "Gray Mahogany Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAHOGANY_LIGHT_GRAY.get(), "Light Gray Mahogany Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAHOGANY_CYAN.get(), "Cyan Mahogany Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAHOGANY_PURPLE.get(), "Purple Mahogany Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAHOGANY_BLUE.get(), "Blue Mahogany Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAHOGANY_BROWN.get(), "Brown Mahogany Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAHOGANY_GREEN.get(), "Green Mahogany Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAHOGANY_RED.get(), "Red Mahogany Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAHOGANY_BLACK.get(), "Black Mahogany Desk Chair");

        add(TBABlocks.DESK_CHAIR_JACARANDA.get(), "Jacaranda Desk Chair");
        add(TBABlocks.DESK_CHAIR_JACARANDA_WHITE.get(), "White Jacaranda Desk Chair");
        add(TBABlocks.DESK_CHAIR_JACARANDA_ORANGE.get(), "Orange Jacaranda Desk Chair");
        add(TBABlocks.DESK_CHAIR_JACARANDA_MAGENTA.get(), "Magenta Jacaranda Desk Chair");
        add(TBABlocks.DESK_CHAIR_JACARANDA_LIGHT_BLUE.get(), "Light Blue Jacaranda Desk Chair");
        add(TBABlocks.DESK_CHAIR_JACARANDA_YELLOW.get(), "Yellow Jacaranda Desk Chair");
        add(TBABlocks.DESK_CHAIR_JACARANDA_LIME.get(), "Lime Jacaranda Desk Chair");
        add(TBABlocks.DESK_CHAIR_JACARANDA_PINK.get(), "Pink Jacaranda Desk Chair");
        add(TBABlocks.DESK_CHAIR_JACARANDA_GRAY.get(), "Gray Jacaranda Desk Chair");
        add(TBABlocks.DESK_CHAIR_JACARANDA_LIGHT_GRAY.get(), "Light Gray Jacaranda Desk Chair");
        add(TBABlocks.DESK_CHAIR_JACARANDA_CYAN.get(), "Cyan Jacaranda Desk Chair");
        add(TBABlocks.DESK_CHAIR_JACARANDA_PURPLE.get(), "Purple Jacaranda Desk Chair");
        add(TBABlocks.DESK_CHAIR_JACARANDA_BLUE.get(), "Blue Jacaranda Desk Chair");
        add(TBABlocks.DESK_CHAIR_JACARANDA_BROWN.get(), "Brown Jacaranda Desk Chair");
        add(TBABlocks.DESK_CHAIR_JACARANDA_GREEN.get(), "Green Jacaranda Desk Chair");
        add(TBABlocks.DESK_CHAIR_JACARANDA_RED.get(), "Red Jacaranda Desk Chair");
        add(TBABlocks.DESK_CHAIR_JACARANDA_BLACK.get(), "Black Jacaranda Desk Chair");

        add(TBABlocks.DESK_CHAIR_PALM.get(), "Palm Desk Chair");
        add(TBABlocks.DESK_CHAIR_PALM_WHITE.get(), "White Palm Desk Chair");
        add(TBABlocks.DESK_CHAIR_PALM_ORANGE.get(), "Orange Palm Desk Chair");
        add(TBABlocks.DESK_CHAIR_PALM_MAGENTA.get(), "Magenta Palm Desk Chair");
        add(TBABlocks.DESK_CHAIR_PALM_LIGHT_BLUE.get(), "Light Blue Palm Desk Chair");
        add(TBABlocks.DESK_CHAIR_PALM_YELLOW.get(), "Yellow Palm Desk Chair");
        add(TBABlocks.DESK_CHAIR_PALM_LIME.get(), "Lime Palm Desk Chair");
        add(TBABlocks.DESK_CHAIR_PALM_PINK.get(), "Pink Palm Desk Chair");
        add(TBABlocks.DESK_CHAIR_PALM_GRAY.get(), "Gray Palm Desk Chair");
        add(TBABlocks.DESK_CHAIR_PALM_LIGHT_GRAY.get(), "Light Gray Palm Desk Chair");
        add(TBABlocks.DESK_CHAIR_PALM_CYAN.get(), "Cyan Palm Desk Chair");
        add(TBABlocks.DESK_CHAIR_PALM_PURPLE.get(), "Purple Palm Desk Chair");
        add(TBABlocks.DESK_CHAIR_PALM_BLUE.get(), "Blue Palm Desk Chair");
        add(TBABlocks.DESK_CHAIR_PALM_BROWN.get(), "Brown Palm Desk Chair");
        add(TBABlocks.DESK_CHAIR_PALM_GREEN.get(), "Green Palm Desk Chair");
        add(TBABlocks.DESK_CHAIR_PALM_RED.get(), "Red Palm Desk Chair");
        add(TBABlocks.DESK_CHAIR_PALM_BLACK.get(), "Black Palm Desk Chair");

        add(TBABlocks.DESK_CHAIR_WILLOW.get(), "Willow Desk Chair");
        add(TBABlocks.DESK_CHAIR_WILLOW_WHITE.get(), "White Willow Desk Chair");
        add(TBABlocks.DESK_CHAIR_WILLOW_ORANGE.get(), "Orange Willow Desk Chair");
        add(TBABlocks.DESK_CHAIR_WILLOW_MAGENTA.get(), "Magenta Willow Desk Chair");
        add(TBABlocks.DESK_CHAIR_WILLOW_LIGHT_BLUE.get(), "Light Blue Willow Desk Chair");
        add(TBABlocks.DESK_CHAIR_WILLOW_YELLOW.get(), "Yellow Willow Desk Chair");
        add(TBABlocks.DESK_CHAIR_WILLOW_LIME.get(), "Lime Willow Desk Chair");
        add(TBABlocks.DESK_CHAIR_WILLOW_PINK.get(), "Pink Willow Desk Chair");
        add(TBABlocks.DESK_CHAIR_WILLOW_GRAY.get(), "Gray Willow Desk Chair");
        add(TBABlocks.DESK_CHAIR_WILLOW_LIGHT_GRAY.get(), "Light Gray Willow Desk Chair");
        add(TBABlocks.DESK_CHAIR_WILLOW_CYAN.get(), "Cyan Willow Desk Chair");
        add(TBABlocks.DESK_CHAIR_WILLOW_PURPLE.get(), "Purple Willow Desk Chair");
        add(TBABlocks.DESK_CHAIR_WILLOW_BLUE.get(), "Blue Willow Desk Chair");
        add(TBABlocks.DESK_CHAIR_WILLOW_BROWN.get(), "Brown Willow Desk Chair");
        add(TBABlocks.DESK_CHAIR_WILLOW_GREEN.get(), "Green Willow Desk Chair");
        add(TBABlocks.DESK_CHAIR_WILLOW_RED.get(), "Red Willow Desk Chair");
        add(TBABlocks.DESK_CHAIR_WILLOW_BLACK.get(), "Black Willow Desk Chair");

        add(TBABlocks.DESK_CHAIR_DEAD.get(), "Dead Desk Chair");
        add(TBABlocks.DESK_CHAIR_DEAD_WHITE.get(), "White Dead Desk Chair");
        add(TBABlocks.DESK_CHAIR_DEAD_ORANGE.get(), "Orange Dead Desk Chair");
        add(TBABlocks.DESK_CHAIR_DEAD_MAGENTA.get(), "Magenta Dead Desk Chair");
        add(TBABlocks.DESK_CHAIR_DEAD_LIGHT_BLUE.get(), "Light Blue Dead Desk Chair");
        add(TBABlocks.DESK_CHAIR_DEAD_YELLOW.get(), "Yellow Dead Desk Chair");
        add(TBABlocks.DESK_CHAIR_DEAD_LIME.get(), "Lime Dead Desk Chair");
        add(TBABlocks.DESK_CHAIR_DEAD_PINK.get(), "Pink Dead Desk Chair");
        add(TBABlocks.DESK_CHAIR_DEAD_GRAY.get(), "Gray Dead Desk Chair");
        add(TBABlocks.DESK_CHAIR_DEAD_LIGHT_GRAY.get(), "Light Gray Dead Desk Chair");
        add(TBABlocks.DESK_CHAIR_DEAD_CYAN.get(), "Cyan Dead Desk Chair");
        add(TBABlocks.DESK_CHAIR_DEAD_PURPLE.get(), "Purple Dead Desk Chair");
        add(TBABlocks.DESK_CHAIR_DEAD_BLUE.get(), "Blue Dead Desk Chair");
        add(TBABlocks.DESK_CHAIR_DEAD_BROWN.get(), "Brown Dead Desk Chair");
        add(TBABlocks.DESK_CHAIR_DEAD_GREEN.get(), "Green Dead Desk Chair");
        add(TBABlocks.DESK_CHAIR_DEAD_RED.get(), "Red Dead Desk Chair");
        add(TBABlocks.DESK_CHAIR_DEAD_BLACK.get(), "Black Dead Desk Chair");

        add(TBABlocks.DESK_CHAIR_MAGIC.get(), "Magic Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAGIC_WHITE.get(), "White Magic Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAGIC_ORANGE.get(), "Orange Magic Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAGIC_MAGENTA.get(), "Magenta Magic Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAGIC_LIGHT_BLUE.get(), "Light Blue Magic Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAGIC_YELLOW.get(), "Yellow Magic Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAGIC_LIME.get(), "Lime Magic Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAGIC_PINK.get(), "Pink Magic Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAGIC_GRAY.get(), "Gray Magic Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAGIC_LIGHT_GRAY.get(), "Light Gray Magic Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAGIC_CYAN.get(), "Cyan Magic Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAGIC_PURPLE.get(), "Purple Magic Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAGIC_BLUE.get(), "Blue Magic Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAGIC_BROWN.get(), "Brown Magic Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAGIC_GREEN.get(), "Green Magic Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAGIC_RED.get(), "Red Magic Desk Chair");
        add(TBABlocks.DESK_CHAIR_MAGIC_BLACK.get(), "Black Magic Desk Chair");

        add(TBABlocks.DESK_CHAIR_UMBRAN.get(), "Umbran Desk Chair");
        add(TBABlocks.DESK_CHAIR_UMBRAN_WHITE.get(), "White Umbran Desk Chair");
        add(TBABlocks.DESK_CHAIR_UMBRAN_ORANGE.get(), "Orange Umbran Desk Chair");
        add(TBABlocks.DESK_CHAIR_UMBRAN_MAGENTA.get(), "Magenta Umbran Desk Chair");
        add(TBABlocks.DESK_CHAIR_UMBRAN_LIGHT_BLUE.get(), "Light Blue Umbran Desk Chair");
        add(TBABlocks.DESK_CHAIR_UMBRAN_YELLOW.get(), "Yellow Umbran Desk Chair");
        add(TBABlocks.DESK_CHAIR_UMBRAN_LIME.get(), "Lime Umbran Desk Chair");
        add(TBABlocks.DESK_CHAIR_UMBRAN_PINK.get(), "Pink Umbran Desk Chair");
        add(TBABlocks.DESK_CHAIR_UMBRAN_GRAY.get(), "Gray Umbran Desk Chair");
        add(TBABlocks.DESK_CHAIR_UMBRAN_LIGHT_GRAY.get(), "Light Gray Umbran Desk Chair");
        add(TBABlocks.DESK_CHAIR_UMBRAN_CYAN.get(), "Cyan Umbran Desk Chair");
        add(TBABlocks.DESK_CHAIR_UMBRAN_PURPLE.get(), "Purple Umbran Desk Chair");
        add(TBABlocks.DESK_CHAIR_UMBRAN_BLUE.get(), "Blue Umbran Desk Chair");
        add(TBABlocks.DESK_CHAIR_UMBRAN_BROWN.get(), "Brown Umbran Desk Chair");
        add(TBABlocks.DESK_CHAIR_UMBRAN_GREEN.get(), "Green Umbran Desk Chair");
        add(TBABlocks.DESK_CHAIR_UMBRAN_RED.get(), "Red Umbran Desk Chair");
        add(TBABlocks.DESK_CHAIR_UMBRAN_BLACK.get(), "Black Umbran Desk Chair");

        add(TBABlocks.DESK_CHAIR_HELLBARK.get(), "Hellbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_HELLBARK_WHITE.get(), "White Hellbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_HELLBARK_ORANGE.get(), "Orange Hellbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_HELLBARK_MAGENTA.get(), "Magenta Hellbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_HELLBARK_LIGHT_BLUE.get(), "Light Blue Hellbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_HELLBARK_YELLOW.get(), "Yellow Hellbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_HELLBARK_LIME.get(), "Lime Hellbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_HELLBARK_PINK.get(), "Pink Hellbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_HELLBARK_GRAY.get(), "Gray Hellbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_HELLBARK_LIGHT_GRAY.get(), "Light Gray Hellbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_HELLBARK_CYAN.get(), "Cyan Hellbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_HELLBARK_PURPLE.get(), "Purple Hellbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_HELLBARK_BLUE.get(), "Blue Hellbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_HELLBARK_BROWN.get(), "Brown Hellbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_HELLBARK_GREEN.get(), "Green Hellbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_HELLBARK_RED.get(), "Red Hellbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_HELLBARK_BLACK.get(), "Black Hellbark Desk Chair");

        add(TBABlocks.DESK_CHAIR_COCONUT.get(), "Coconut Desk Chair");
        add(TBABlocks.DESK_CHAIR_COCONUT_WHITE.get(), "White Coconut Desk Chair");
        add(TBABlocks.DESK_CHAIR_COCONUT_ORANGE.get(), "Orange Coconut Desk Chair");
        add(TBABlocks.DESK_CHAIR_COCONUT_MAGENTA.get(), "Magenta Coconut Desk Chair");
        add(TBABlocks.DESK_CHAIR_COCONUT_LIGHT_BLUE.get(), "Light Blue Coconut Desk Chair");
        add(TBABlocks.DESK_CHAIR_COCONUT_YELLOW.get(), "Yellow Coconut Desk Chair");
        add(TBABlocks.DESK_CHAIR_COCONUT_LIME.get(), "Lime Coconut Desk Chair");
        add(TBABlocks.DESK_CHAIR_COCONUT_PINK.get(), "Pink Coconut Desk Chair");
        add(TBABlocks.DESK_CHAIR_COCONUT_GRAY.get(), "Gray Coconut Desk Chair");
        add(TBABlocks.DESK_CHAIR_COCONUT_LIGHT_GRAY.get(), "Light Gray Coconut Desk Chair");
        add(TBABlocks.DESK_CHAIR_COCONUT_CYAN.get(), "Cyan Coconut Desk Chair");
        add(TBABlocks.DESK_CHAIR_COCONUT_PURPLE.get(), "Purple Coconut Desk Chair");
        add(TBABlocks.DESK_CHAIR_COCONUT_BLUE.get(), "Blue Coconut Desk Chair");
        add(TBABlocks.DESK_CHAIR_COCONUT_BROWN.get(), "Brown Coconut Desk Chair");
        add(TBABlocks.DESK_CHAIR_COCONUT_GREEN.get(), "Green Coconut Desk Chair");
        add(TBABlocks.DESK_CHAIR_COCONUT_RED.get(), "Red Coconut Desk Chair");
        add(TBABlocks.DESK_CHAIR_COCONUT_BLACK.get(), "Black Coconut Desk Chair");

        add(TBABlocks.DESK_CHAIR_WALNUT.get(), "Walnut Desk Chair");
        add(TBABlocks.DESK_CHAIR_WALNUT_WHITE.get(), "White Walnut Desk Chair");
        add(TBABlocks.DESK_CHAIR_WALNUT_ORANGE.get(), "Orange Walnut Desk Chair");
        add(TBABlocks.DESK_CHAIR_WALNUT_MAGENTA.get(), "Magenta Walnut Desk Chair");
        add(TBABlocks.DESK_CHAIR_WALNUT_LIGHT_BLUE.get(), "Light Blue Walnut Desk Chair");
        add(TBABlocks.DESK_CHAIR_WALNUT_YELLOW.get(), "Yellow Walnut Desk Chair");
        add(TBABlocks.DESK_CHAIR_WALNUT_LIME.get(), "Lime Walnut Desk Chair");
        add(TBABlocks.DESK_CHAIR_WALNUT_PINK.get(), "Pink Walnut Desk Chair");
        add(TBABlocks.DESK_CHAIR_WALNUT_GRAY.get(), "Gray Walnut Desk Chair");
        add(TBABlocks.DESK_CHAIR_WALNUT_LIGHT_GRAY.get(), "Light Gray Walnut Desk Chair");
        add(TBABlocks.DESK_CHAIR_WALNUT_CYAN.get(), "Cyan Walnut Desk Chair");
        add(TBABlocks.DESK_CHAIR_WALNUT_PURPLE.get(), "Purple Walnut Desk Chair");
        add(TBABlocks.DESK_CHAIR_WALNUT_BLUE.get(), "Blue Walnut Desk Chair");
        add(TBABlocks.DESK_CHAIR_WALNUT_BROWN.get(), "Brown Walnut Desk Chair");
        add(TBABlocks.DESK_CHAIR_WALNUT_GREEN.get(), "Green Walnut Desk Chair");
        add(TBABlocks.DESK_CHAIR_WALNUT_RED.get(), "Red Walnut Desk Chair");
        add(TBABlocks.DESK_CHAIR_WALNUT_BLACK.get(), "Black Walnut Desk Chair");

        add(TBABlocks.DESK_CHAIR_AZALEA.get(), "Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_AZALEA_WHITE.get(), "White Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_AZALEA_ORANGE.get(), "Orange Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_AZALEA_MAGENTA.get(), "Magenta Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_AZALEA_LIGHT_BLUE.get(), "Light Blue Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_AZALEA_YELLOW.get(), "Yellow Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_AZALEA_LIME.get(), "Lime Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_AZALEA_PINK.get(), "Pink Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_AZALEA_GRAY.get(), "Gray Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_AZALEA_LIGHT_GRAY.get(), "Light Gray Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_AZALEA_CYAN.get(), "Cyan Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_AZALEA_PURPLE.get(), "Purple Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_AZALEA_BLUE.get(), "Blue Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_AZALEA_BROWN.get(), "Brown Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_AZALEA_GREEN.get(), "Green Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_AZALEA_RED.get(), "Red Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_AZALEA_BLACK.get(), "Black Azalea Desk Chair");

        add(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA.get(), "Flowering Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_WHITE.get(), "White Flowering Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_ORANGE.get(), "Orange Flowering Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_MAGENTA.get(), "Magenta Flowering Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_LIGHT_BLUE.get(), "Light Blue Flowering Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_YELLOW.get(), "Yellow Flowering Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_LIME.get(), "Lime Flowering Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_PINK.get(), "Pink Flowering Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_GRAY.get(), "Gray Flowering Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_LIGHT_GRAY.get(), "Light Gray Flowering Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_CYAN.get(), "Cyan Flowering Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_PURPLE.get(), "Purple Flowering Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_BLUE.get(), "Blue Flowering Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_BROWN.get(), "Brown Flowering Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_GREEN.get(), "Green Flowering Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_RED.get(), "Red Flowering Azalea Desk Chair");
        add(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA_BLACK.get(), "Black Flowering Azalea Desk Chair");

        add(TBABlocks.DESK_CHAIR_GOLDEN_OAK.get(), "Golden Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_GOLDEN_OAK_WHITE.get(), "White Golden Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_GOLDEN_OAK_ORANGE.get(), "Orange Golden Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_GOLDEN_OAK_MAGENTA.get(), "Magenta Golden Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_GOLDEN_OAK_LIGHT_BLUE.get(), "Light Blue Golden Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_GOLDEN_OAK_YELLOW.get(), "Yellow Golden Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_GOLDEN_OAK_LIME.get(), "Lime Golden Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_GOLDEN_OAK_PINK.get(), "Pink Golden Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_GOLDEN_OAK_GRAY.get(), "Gray Golden Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_GOLDEN_OAK_LIGHT_GRAY.get(), "Light Gray Golden Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_GOLDEN_OAK_CYAN.get(), "Cyan Golden Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_GOLDEN_OAK_PURPLE.get(), "Purple Golden Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_GOLDEN_OAK_BLUE.get(), "Blue Golden Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_GOLDEN_OAK_BROWN.get(), "Brown Golden Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_GOLDEN_OAK_GREEN.get(), "Green Golden Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_GOLDEN_OAK_RED.get(), "Red Golden Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_GOLDEN_OAK_BLACK.get(), "Black Golden Oak Desk Chair");

        add(TBABlocks.DESK_CHAIR_AETHER_SKYROOT.get(), "Aether Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_WHITE.get(), "White Aether Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_ORANGE.get(), "Orange Aether Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_MAGENTA.get(), "Magenta Aether Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_LIGHT_BLUE.get(), "Light Blue Aether Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_YELLOW.get(), "Yellow Aether Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_LIME.get(), "Lime Aether Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_PINK.get(), "Pink Aether Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_GRAY.get(), "Gray Aether Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_LIGHT_GRAY.get(), "Light Gray Aether Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_CYAN.get(), "Cyan Aether Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_PURPLE.get(), "Purple Aether Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_BLUE.get(), "Blue Aether Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_BROWN.get(), "Brown Aether Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_GREEN.get(), "Green Aether Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_RED.get(), "Red Aether Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_AETHER_SKYROOT_BLACK.get(), "Black Aether Skyroot Desk Chair");

        add(TBABlocks.DESK_CHAIR_PREAM.get(), "Pream Desk Chair");
        add(TBABlocks.DESK_CHAIR_PREAM_WHITE.get(), "White Pream Desk Chair");
        add(TBABlocks.DESK_CHAIR_PREAM_ORANGE.get(), "Orange Pream Desk Chair");
        add(TBABlocks.DESK_CHAIR_PREAM_MAGENTA.get(), "Magenta Pream Desk Chair");
        add(TBABlocks.DESK_CHAIR_PREAM_LIGHT_BLUE.get(), "Light Blue Pream Desk Chair");
        add(TBABlocks.DESK_CHAIR_PREAM_YELLOW.get(), "Yellow Pream Desk Chair");
        add(TBABlocks.DESK_CHAIR_PREAM_LIME.get(), "Lime Pream Desk Chair");
        add(TBABlocks.DESK_CHAIR_PREAM_PINK.get(), "Pink Pream Desk Chair");
        add(TBABlocks.DESK_CHAIR_PREAM_GRAY.get(), "Gray Pream Desk Chair");
        add(TBABlocks.DESK_CHAIR_PREAM_LIGHT_GRAY.get(), "Light Gray Pream Desk Chair");
        add(TBABlocks.DESK_CHAIR_PREAM_CYAN.get(), "Cyan Pream Desk Chair");
        add(TBABlocks.DESK_CHAIR_PREAM_PURPLE.get(), "Purple Pream Desk Chair");
        add(TBABlocks.DESK_CHAIR_PREAM_BLUE.get(), "Blue Pream Desk Chair");
        add(TBABlocks.DESK_CHAIR_PREAM_BROWN.get(), "Brown Pream Desk Chair");
        add(TBABlocks.DESK_CHAIR_PREAM_GREEN.get(), "Green Pream Desk Chair");
        add(TBABlocks.DESK_CHAIR_PREAM_RED.get(), "Red Pream Desk Chair");
        add(TBABlocks.DESK_CHAIR_PREAM_BLACK.get(), "Black Pream Desk Chair");

        add(TBABlocks.DESK_CHAIR_EBONY.get(), "Ebony Desk Chair");
        add(TBABlocks.DESK_CHAIR_EBONY_WHITE.get(), "White Ebony Desk Chair");
        add(TBABlocks.DESK_CHAIR_EBONY_ORANGE.get(), "Orange Ebony Desk Chair");
        add(TBABlocks.DESK_CHAIR_EBONY_MAGENTA.get(), "Magenta Ebony Desk Chair");
        add(TBABlocks.DESK_CHAIR_EBONY_LIGHT_BLUE.get(), "Light Blue Ebony Desk Chair");
        add(TBABlocks.DESK_CHAIR_EBONY_YELLOW.get(), "Yellow Ebony Desk Chair");
        add(TBABlocks.DESK_CHAIR_EBONY_LIME.get(), "Lime Ebony Desk Chair");
        add(TBABlocks.DESK_CHAIR_EBONY_PINK.get(), "Pink Ebony Desk Chair");
        add(TBABlocks.DESK_CHAIR_EBONY_GRAY.get(), "Gray Ebony Desk Chair");
        add(TBABlocks.DESK_CHAIR_EBONY_LIGHT_GRAY.get(), "Light Gray Ebony Desk Chair");
        add(TBABlocks.DESK_CHAIR_EBONY_CYAN.get(), "Cyan Ebony Desk Chair");
        add(TBABlocks.DESK_CHAIR_EBONY_PURPLE.get(), "Purple Ebony Desk Chair");
        add(TBABlocks.DESK_CHAIR_EBONY_BLUE.get(), "Blue Ebony Desk Chair");
        add(TBABlocks.DESK_CHAIR_EBONY_BROWN.get(), "Brown Ebony Desk Chair");
        add(TBABlocks.DESK_CHAIR_EBONY_GREEN.get(), "Green Ebony Desk Chair");
        add(TBABlocks.DESK_CHAIR_EBONY_RED.get(), "Red Ebony Desk Chair");
        add(TBABlocks.DESK_CHAIR_EBONY_BLACK.get(), "Black Ebony Desk Chair");

        add(TBABlocks.DESK_CHAIR_CHORUS_NEST.get(), "Chorus Nest Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHORUS_NEST_WHITE.get(), "White Chorus Nest Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHORUS_NEST_ORANGE.get(), "Orange Chorus Nest Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHORUS_NEST_MAGENTA.get(), "Magenta Chorus Nest Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHORUS_NEST_LIGHT_BLUE.get(), "Light Blue Chorus Nest Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHORUS_NEST_YELLOW.get(), "Yellow Chorus Nest Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHORUS_NEST_LIME.get(), "Lime Chorus Nest Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHORUS_NEST_PINK.get(), "Pink Chorus Nest Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHORUS_NEST_GRAY.get(), "Gray Chorus Nest Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHORUS_NEST_LIGHT_GRAY.get(), "Light Gray Chorus Nest Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHORUS_NEST_CYAN.get(), "Cyan Chorus Nest Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHORUS_NEST_PURPLE.get(), "Purple Chorus Nest Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHORUS_NEST_BLUE.get(), "Blue Chorus Nest Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHORUS_NEST_BROWN.get(), "Brown Chorus Nest Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHORUS_NEST_GREEN.get(), "Green Chorus Nest Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHORUS_NEST_RED.get(), "Red Chorus Nest Desk Chair");
        add(TBABlocks.DESK_CHAIR_CHORUS_NEST_BLACK.get(), "Black Chorus Nest Desk Chair");

        add(TBABlocks.DESK_CHAIR_BLOODSHROOM.get(), "Bloodshroom Desk Chair");
        add(TBABlocks.DESK_CHAIR_BLOODSHROOM_WHITE.get(), "White Bloodshroom Desk Chair");
        add(TBABlocks.DESK_CHAIR_BLOODSHROOM_ORANGE.get(), "Orange Bloodshroom Desk Chair");
        add(TBABlocks.DESK_CHAIR_BLOODSHROOM_MAGENTA.get(), "Magenta Bloodshroom Desk Chair");
        add(TBABlocks.DESK_CHAIR_BLOODSHROOM_LIGHT_BLUE.get(), "Light Blue Bloodshroom Desk Chair");
        add(TBABlocks.DESK_CHAIR_BLOODSHROOM_YELLOW.get(), "Yellow Bloodshroom Desk Chair");
        add(TBABlocks.DESK_CHAIR_BLOODSHROOM_LIME.get(), "Lime Bloodshroom Desk Chair");
        add(TBABlocks.DESK_CHAIR_BLOODSHROOM_PINK.get(), "Pink Bloodshroom Desk Chair");
        add(TBABlocks.DESK_CHAIR_BLOODSHROOM_GRAY.get(), "Gray Bloodshroom Desk Chair");
        add(TBABlocks.DESK_CHAIR_BLOODSHROOM_LIGHT_GRAY.get(), "Light Gray Bloodshroom Desk Chair");
        add(TBABlocks.DESK_CHAIR_BLOODSHROOM_CYAN.get(), "Cyan Bloodshroom Desk Chair");
        add(TBABlocks.DESK_CHAIR_BLOODSHROOM_PURPLE.get(), "Purple Bloodshroom Desk Chair");
        add(TBABlocks.DESK_CHAIR_BLOODSHROOM_BLUE.get(), "Blue Bloodshroom Desk Chair");
        add(TBABlocks.DESK_CHAIR_BLOODSHROOM_BROWN.get(), "Brown Bloodshroom Desk Chair");
        add(TBABlocks.DESK_CHAIR_BLOODSHROOM_GREEN.get(), "Green Bloodshroom Desk Chair");
        add(TBABlocks.DESK_CHAIR_BLOODSHROOM_RED.get(), "Red Bloodshroom Desk Chair");
        add(TBABlocks.DESK_CHAIR_BLOODSHROOM_BLACK.get(), "Black Bloodshroom Desk Chair");

        add(TBABlocks.DESK_CHAIR_ENDERBARK.get(), "Enderbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_ENDERBARK_WHITE.get(), "White Enderbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_ENDERBARK_ORANGE.get(), "Orange Enderbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_ENDERBARK_MAGENTA.get(), "Magenta Enderbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_ENDERBARK_LIGHT_BLUE.get(), "Light Blue Enderbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_ENDERBARK_YELLOW.get(), "Yellow Enderbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_ENDERBARK_LIME.get(), "Lime Enderbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_ENDERBARK_PINK.get(), "Pink Enderbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_ENDERBARK_GRAY.get(), "Gray Enderbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_ENDERBARK_LIGHT_GRAY.get(), "Light Gray Enderbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_ENDERBARK_CYAN.get(), "Cyan Enderbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_ENDERBARK_PURPLE.get(), "Purple Enderbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_ENDERBARK_BLUE.get(), "Blue Enderbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_ENDERBARK_BROWN.get(), "Brown Enderbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_ENDERBARK_GREEN.get(), "Green Enderbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_ENDERBARK_RED.get(), "Red Enderbark Desk Chair");
        add(TBABlocks.DESK_CHAIR_ENDERBARK_BLACK.get(), "Black Enderbark Desk Chair");

        add(TBABlocks.DESK_CHAIR_GREENHEART.get(), "Greenheart Desk Chair");
        add(TBABlocks.DESK_CHAIR_GREENHEART_WHITE.get(), "White Greenheart Desk Chair");
        add(TBABlocks.DESK_CHAIR_GREENHEART_ORANGE.get(), "Orange Greenheart Desk Chair");
        add(TBABlocks.DESK_CHAIR_GREENHEART_MAGENTA.get(), "Magenta Greenheart Desk Chair");
        add(TBABlocks.DESK_CHAIR_GREENHEART_LIGHT_BLUE.get(), "Light Blue Greenheart Desk Chair");
        add(TBABlocks.DESK_CHAIR_GREENHEART_YELLOW.get(), "Yellow Greenheart Desk Chair");
        add(TBABlocks.DESK_CHAIR_GREENHEART_LIME.get(), "Lime Greenheart Desk Chair");
        add(TBABlocks.DESK_CHAIR_GREENHEART_PINK.get(), "Pink Greenheart Desk Chair");
        add(TBABlocks.DESK_CHAIR_GREENHEART_GRAY.get(), "Gray Greenheart Desk Chair");
        add(TBABlocks.DESK_CHAIR_GREENHEART_LIGHT_GRAY.get(), "Light Gray Greenheart Desk Chair");
        add(TBABlocks.DESK_CHAIR_GREENHEART_CYAN.get(), "Cyan Greenheart Desk Chair");
        add(TBABlocks.DESK_CHAIR_GREENHEART_PURPLE.get(), "Purple Greenheart Desk Chair");
        add(TBABlocks.DESK_CHAIR_GREENHEART_BLUE.get(), "Blue Greenheart Desk Chair");
        add(TBABlocks.DESK_CHAIR_GREENHEART_BROWN.get(), "Brown Greenheart Desk Chair");
        add(TBABlocks.DESK_CHAIR_GREENHEART_GREEN.get(), "Green Greenheart Desk Chair");
        add(TBABlocks.DESK_CHAIR_GREENHEART_RED.get(), "Red Greenheart Desk Chair");
        add(TBABlocks.DESK_CHAIR_GREENHEART_BLACK.get(), "Black Greenheart Desk Chair");

        add(TBABlocks.DESK_CHAIR_TINKER_SKYROOT.get(), "Tinker Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_WHITE.get(), "White Tinker Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_ORANGE.get(), "Orange Tinker Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_MAGENTA.get(), "Magenta Tinker Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_LIGHT_BLUE.get(), "Light Blue Tinker Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_YELLOW.get(), "Yellow Tinker Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_LIME.get(), "Lime Tinker Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_PINK.get(), "Pink Tinker Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_GRAY.get(), "Gray Tinker Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_LIGHT_GRAY.get(), "Light Gray Tinker Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_CYAN.get(), "Cyan Tinker Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_PURPLE.get(), "Purple Tinker Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_BLUE.get(), "Blue Tinker Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_BROWN.get(), "Brown Tinker Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_GREEN.get(), "Green Tinker Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_RED.get(), "Red Tinker Skyroot Desk Chair");
        add(TBABlocks.DESK_CHAIR_TINKER_SKYROOT_BLACK.get(), "Black Tinker Skyroot Desk Chair");

        add(TBABlocks.LOCKER_OAK.get(), "Oak Locker");
        add(TBABlocks.LOCKER_BIRCH.get(), "Birch Locker");
        add(TBABlocks.LOCKER_SPRUCE.get(), "Spruce Locker");
        add(TBABlocks.LOCKER_JUNGLE.get(), "Jungle Locker");
        add(TBABlocks.LOCKER_ACACIA.get(), "Acacia Locker");
        add(TBABlocks.LOCKER_DARK_OAK.get(), "Dark Oak Locker");
        add(TBABlocks.LOCKER_MANGROVE.get(), "Mangrove Locker");
        add(TBABlocks.LOCKER_CRIMSON.get(), "Crimson Locker");
        add(TBABlocks.LOCKER_WARPED.get(), "Warped Locker");

        add(TBABlocks.PARK_BENCH_OAK.get(), "Oak Park Bench");
        add(TBABlocks.PARK_BENCH_BIRCH.get(), "Birch Park Bench");
        add(TBABlocks.PARK_BENCH_SPRUCE.get(), "Spruce Park Bench");
        add(TBABlocks.PARK_BENCH_JUNGLE.get(), "Jungle Park Bench");
        add(TBABlocks.PARK_BENCH_ACACIA.get(), "Acacia Park Bench");
        add(TBABlocks.PARK_BENCH_DARK_OAK.get(), "Dark Oak Park Bench");
        add(TBABlocks.PARK_BENCH_MANGROVE.get(), "Mangrove Park Bench");
        add(TBABlocks.PARK_BENCH_CRIMSON.get(), "Crimson Park Bench");
        add(TBABlocks.PARK_BENCH_WARPED.get(), "Warped Park Bench");

        add(TBABlocks.TABLE_OAK.get(), "Oak Table");
        add(TBABlocks.TABLE_BIRCH.get(), "Birch Table");
        add(TBABlocks.TABLE_SPRUCE.get(), "Spruce Table");
        add(TBABlocks.TABLE_JUNGLE.get(), "Jungle Table");
        add(TBABlocks.TABLE_ACACIA.get(), "Acacia Table");
        add(TBABlocks.TABLE_DARK_OAK.get(), "Dark Oak Table");
        add(TBABlocks.TABLE_MANGROVE.get(), "Mangrove Table");
        add(TBABlocks.TABLE_CRIMSON.get(), "Crimson Table");
        add(TBABlocks.TABLE_WARPED.get(), "Warped Table");

        add(TBABlocks.SCHOOL_DESK_FIR.get(), "Fir School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_FIR.get(), "Fir School Desk Cabinet");
        add(TBABlocks.LOCKER_FIR.get(), "Fir Locker");
        add(TBABlocks.PARK_BENCH_FIR.get(), "Fir Park Bench");
        add(TBABlocks.TABLE_FIR.get(), "Fir Table");

        add(TBABlocks.SCHOOL_DESK_REDWOOD.get(), "Redwood School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_REDWOOD.get(), "Redwood School Desk Cabinet");
        add(TBABlocks.LOCKER_REDWOOD.get(), "Redwood Locker");
        add(TBABlocks.PARK_BENCH_REDWOOD.get(), "Redwood Park Bench");
        add(TBABlocks.TABLE_REDWOOD.get(), "Redwood Table");

        add(TBABlocks.SCHOOL_DESK_CHERRY.get(), "Cherry School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_CHERRY.get(), "Cherry School Desk Cabinet");
        add(TBABlocks.LOCKER_CHERRY.get(), "Cherry Locker");
        add(TBABlocks.PARK_BENCH_CHERRY.get(), "Cherry Park Bench");
        add(TBABlocks.TABLE_CHERRY.get(), "Cherry Table");

        add(TBABlocks.SCHOOL_DESK_MAHOGANY.get(), "Mahogany School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_MAHOGANY.get(), "Mahogany School Desk Cabinet");
        add(TBABlocks.LOCKER_MAHOGANY.get(), "Mahogany Locker");
        add(TBABlocks.PARK_BENCH_MAHOGANY.get(), "Mahogany Park Bench");
        add(TBABlocks.TABLE_MAHOGANY.get(), "Mahogany Table");

        add(TBABlocks.SCHOOL_DESK_JACARANDA.get(), "Jacaranda School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_JACARANDA.get(), "Jacaranda School Desk Cabinet");
        add(TBABlocks.LOCKER_JACARANDA.get(), "Jacaranda Locker");
        add(TBABlocks.PARK_BENCH_JACARANDA.get(), "Jacaranda Park Bench");
        add(TBABlocks.TABLE_JACARANDA.get(), "Jacaranda Table");

        add(TBABlocks.SCHOOL_DESK_PALM.get(), "Palm School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_PALM.get(), "Palm School Desk Cabinet");
        add(TBABlocks.LOCKER_PALM.get(), "Palm Locker");
        add(TBABlocks.PARK_BENCH_PALM.get(), "Palm Park Bench");
        add(TBABlocks.TABLE_PALM.get(), "Palm Table");

        add(TBABlocks.SCHOOL_DESK_WILLOW.get(), "Willow School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_WILLOW.get(), "Willow School Desk Cabinet");
        add(TBABlocks.LOCKER_WILLOW.get(), "Willow Locker");
        add(TBABlocks.PARK_BENCH_WILLOW.get(), "Willow Park Bench");
        add(TBABlocks.TABLE_WILLOW.get(), "Willow Table");

        add(TBABlocks.SCHOOL_DESK_DEAD.get(), "Dead School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_DEAD.get(), "Dead School Desk Cabinet");
        add(TBABlocks.LOCKER_DEAD.get(), "Dead Locker");
        add(TBABlocks.PARK_BENCH_DEAD.get(), "Dead Park Bench");
        add(TBABlocks.TABLE_DEAD.get(), "Dead Table");

        add(TBABlocks.SCHOOL_DESK_MAGIC.get(), "Magic School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_MAGIC.get(), "Magic School Desk Cabinet");
        add(TBABlocks.LOCKER_MAGIC.get(), "Magic Locker");
        add(TBABlocks.PARK_BENCH_MAGIC.get(), "Magic Park Bench");
        add(TBABlocks.TABLE_MAGIC.get(), "Magic Table");

        add(TBABlocks.SCHOOL_DESK_UMBRAN.get(), "Umbran School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_UMBRAN.get(), "Umbran School Desk Cabinet");
        add(TBABlocks.LOCKER_UMBRAN.get(), "Umbran Locker");
        add(TBABlocks.PARK_BENCH_UMBRAN.get(), "Umbran Park Bench");
        add(TBABlocks.TABLE_UMBRAN.get(), "Umbran Table");

        add(TBABlocks.SCHOOL_DESK_HELLBARK.get(), "Hellbark School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_HELLBARK.get(), "Hellbark School Desk Cabinet");
        add(TBABlocks.LOCKER_HELLBARK.get(), "Hellbark Locker");
        add(TBABlocks.PARK_BENCH_HELLBARK.get(), "Hellbark Park Bench");
        add(TBABlocks.TABLE_HELLBARK.get(), "Hellbark Table");

        add(TBABlocks.SCHOOL_DESK_COCONUT.get(), "Coconut School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_COCONUT.get(), "Coconut School Desk Cabinet");
        add(TBABlocks.LOCKER_COCONUT.get(), "Coconut Locker");
        add(TBABlocks.PARK_BENCH_COCONUT.get(), "Coconut Park Bench");
        add(TBABlocks.TABLE_COCONUT.get(), "Coconut Table");

        add(TBABlocks.SCHOOL_DESK_WALNUT.get(), "Walnut School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_WALNUT.get(), "Walnut School Desk Cabinet");
        add(TBABlocks.LOCKER_WALNUT.get(), "Walnut Locker");
        add(TBABlocks.PARK_BENCH_WALNUT.get(), "Walnut Park Bench");
        add(TBABlocks.TABLE_WALNUT.get(), "Walnut Table");

        add(TBABlocks.SCHOOL_DESK_AZALEA.get(), "Azalea School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_AZALEA.get(), "Azalea School Desk Cabinet");
        add(TBABlocks.LOCKER_AZALEA.get(), "Azalea Locker");
        add(TBABlocks.PARK_BENCH_AZALEA.get(), "Azalea Park Bench");
        add(TBABlocks.TABLE_AZALEA.get(), "Azalea Table");

        add(TBABlocks.SCHOOL_DESK_FLOWERING_AZALEA.get(), "Flowering Azalea School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_FLOWERING_AZALEA.get(), "Flowering Azalea School Desk Cabinet");
        add(TBABlocks.LOCKER_FLOWERING_AZALEA.get(), "Flowering Azalea Locker");
        add(TBABlocks.PARK_BENCH_FLOWERING_AZALEA.get(), "Flowering Azalea Park Bench");
        add(TBABlocks.TABLE_FLOWERING_AZALEA.get(), "Flowering Azalea Table");

        add(TBABlocks.SCHOOL_DESK_GOLDEN_OAK.get(), "Golden Oak School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_GOLDEN_OAK.get(), "Golden Oak School Desk Cabinet");
        add(TBABlocks.LOCKER_GOLDEN_OAK.get(), "Golden Oak Locker");
        add(TBABlocks.PARK_BENCH_GOLDEN_OAK.get(), "Golden Oak Park Bench");
        add(TBABlocks.TABLE_GOLDEN_OAK.get(), "Golden Oak Table");

        add(TBABlocks.SCHOOL_DESK_AETHER_SKYROOT.get(), "Aether Skyroot School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_AETHER_SKYROOT.get(), "Aether Skyroot School Desk Cabinet");
        add(TBABlocks.LOCKER_AETHER_SKYROOT.get(), "Aether Skyroot Locker");
        add(TBABlocks.PARK_BENCH_AETHER_SKYROOT.get(), "Aether Skyroot Park Bench");
        add(TBABlocks.TABLE_AETHER_SKYROOT.get(), "Aether Skyroot Table");

        add(TBABlocks.SCHOOL_DESK_PREAM.get(), "Pream School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_PREAM.get(), "Pream School Desk Cabinet");
        add(TBABlocks.LOCKER_PREAM.get(), "Pream Locker");
        add(TBABlocks.PARK_BENCH_PREAM.get(), "Pream Park Bench");
        add(TBABlocks.TABLE_PREAM.get(), "Pream Table");

        add(TBABlocks.SCHOOL_DESK_EBONY.get(), "Ebony School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_EBONY.get(), "Ebony School Desk Cabinet");
        add(TBABlocks.LOCKER_EBONY.get(), "Ebony Locker");
        add(TBABlocks.PARK_BENCH_EBONY.get(), "Ebony Park Bench");
        add(TBABlocks.TABLE_EBONY.get(), "Ebony Table");

        add(TBABlocks.SCHOOL_DESK_CHORUS_NEST.get(), "Chorus Nest School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_CHORUS_NEST.get(), "Chorus Nest School Desk Cabinet");
        add(TBABlocks.LOCKER_CHORUS_NEST.get(), "Chorus Nest Locker");
        add(TBABlocks.PARK_BENCH_CHORUS_NEST.get(), "Chorus Nest Park Bench");
        add(TBABlocks.TABLE_CHORUS_NEST.get(), "Chorus Nest Table");

        add(TBABlocks.SCHOOL_DESK_BLOODSHROOM.get(), "Bloodshroom School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_BLOODSHROOM.get(), "Bloodshroom School Desk Cabinet");
        add(TBABlocks.LOCKER_BLOODSHROOM.get(), "Bloodshroom Locker");
        add(TBABlocks.PARK_BENCH_BLOODSHROOM.get(), "Bloodshroom Park Bench");
        add(TBABlocks.TABLE_BLOODSHROOM.get(), "Bloodshroom Table");

        add(TBABlocks.SCHOOL_DESK_ENDERBARK.get(), "Enderbark School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_ENDERBARK.get(), "Enderbark School Desk Cabinet");
        add(TBABlocks.LOCKER_ENDERBARK.get(), "Enderbark Locker");
        add(TBABlocks.PARK_BENCH_ENDERBARK.get(), "Enderbark Park Bench");
        add(TBABlocks.TABLE_ENDERBARK.get(), "Enderbark Table");

        add(TBABlocks.SCHOOL_DESK_GREENHEART.get(), "Greenheart School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_GREENHEART.get(), "Greenheart School Desk Cabinet");
        add(TBABlocks.LOCKER_GREENHEART.get(), "Greenheart Locker");
        add(TBABlocks.PARK_BENCH_GREENHEART.get(), "Greenheart Park Bench");
        add(TBABlocks.TABLE_GREENHEART.get(), "Greenheart Table");

        add(TBABlocks.SCHOOL_DESK_TINKER_SKYROOT.get(), "Tinker Skyroot School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_TINKER_SKYROOT.get(), "Tinker Skyroot School Desk Cabinet");
        add(TBABlocks.LOCKER_TINKER_SKYROOT.get(), "Tinker Skyroot Locker");
        add(TBABlocks.PARK_BENCH_TINKER_SKYROOT.get(), "Tinker Skyroot Park Bench");
        add(TBABlocks.TABLE_TINKER_SKYROOT.get(), "Tinker Skyroot Table");

        add(TBABlocks.BOOKCASE_OAK.get(), "Oak Bookcase");
        add(TBABlocks.BOOKCASE_BIRCH.get(), "Birch Bookcase");
        add(TBABlocks.BOOKCASE_SPRUCE.get(), "Spruce Bookcase");
        add(TBABlocks.BOOKCASE_JUNGLE.get(), "Jungle Bookcase");
        add(TBABlocks.BOOKCASE_ACACIA.get(), "Acacia Bookcase");
        add(TBABlocks.BOOKCASE_DARK_OAK.get(), "Dark Oak Bookcase");
        add(TBABlocks.BOOKCASE_MANGROVE.get(), "Mangrove Bookcase");
        add(TBABlocks.BOOKCASE_CRIMSON.get(), "Crimson Bookcase");
        add(TBABlocks.BOOKCASE_WARPED.get(), "Warped Bookcase");
        add(TBABlocks.BOOKCASE_FIR.get(), "Fir Bookcase");
        add(TBABlocks.BOOKCASE_REDWOOD.get(), "Redwood Bookcase");
        add(TBABlocks.BOOKCASE_CHERRY.get(), "Cherry Bookcase");
        add(TBABlocks.BOOKCASE_MAHOGANY.get(), "Mahogany Bookcase");
        add(TBABlocks.BOOKCASE_JACARANDA.get(), "Jacaranda Bookcase");
        add(TBABlocks.BOOKCASE_PALM.get(), "Palm Bookcase");
        add(TBABlocks.BOOKCASE_WILLOW.get(), "Willow Bookcase");
        add(TBABlocks.BOOKCASE_DEAD.get(), "Dead Bookcase");
        add(TBABlocks.BOOKCASE_MAGIC.get(), "Magic Bookcase");
        add(TBABlocks.BOOKCASE_UMBRAN.get(), "Umbran Bookcase");
        add(TBABlocks.BOOKCASE_HELLBARK.get(), "Hellbark Bookcase");
        add(TBABlocks.BOOKCASE_COCONUT.get(), "Coconut Bookcase");
        add(TBABlocks.BOOKCASE_WALNUT.get(), "Walnut Bookcase");
        add(TBABlocks.BOOKCASE_AZALEA.get(), "Azalea Bookcase");
        add(TBABlocks.BOOKCASE_FLOWERING_AZALEA.get(), "Flowering Azalea Bookcase");
        add(TBABlocks.BOOKCASE_GOLDEN_OAK.get(), "Golden Oak Bookcase");
        add(TBABlocks.BOOKCASE_AETHER_SKYROOT.get(), "Aether Skyroot Bookcase");
        add(TBABlocks.BOOKCASE_PREAM.get(), "Pream Bookcase");
        add(TBABlocks.BOOKCASE_EBONY.get(), "Ebony Bookcase");
        add(TBABlocks.BOOKCASE_CHORUS_NEST.get(), "Chorus Nest Bookcase");
        add(TBABlocks.BOOKCASE_BLOODSHROOM.get(), "Bloodshroom Bookcase");
        add(TBABlocks.BOOKCASE_ENDERBARK.get(), "Enderbark Bookcase");
        add(TBABlocks.BOOKCASE_GREENHEART.get(), "Greenheart Bookcase");
        add(TBABlocks.BOOKCASE_TINKER_SKYROOT.get(), "Tinker Skyroot Bookcase");

        add(TBABlocks.BASKET_OAK_WHITE.get(), "White Oak Basket");
        add(TBABlocks.BASKET_OAK_LIGHT_GRAY.get(), "Light Gray Oak Basket");
        add(TBABlocks.BASKET_OAK_GRAY.get(), "Gray Oak Basket");
        add(TBABlocks.BASKET_OAK_BLACK.get(), "Black Oak Basket");
        add(TBABlocks.BASKET_OAK_BROWN.get(), "Brown Oak Basket");
        add(TBABlocks.BASKET_OAK_RED.get(), "Red Oak Basket");
        add(TBABlocks.BASKET_OAK_ORANGE.get(), "Orange Oak Basket");
        add(TBABlocks.BASKET_OAK_YELLOW.get(), "Yellow Oak Basket");
        add(TBABlocks.BASKET_OAK_LIME.get(), "Lime Oak Basket");
        add(TBABlocks.BASKET_OAK_GREEN.get(), "Green Oak Basket");
        add(TBABlocks.BASKET_OAK_CYAN.get(), "Cyan Oak Basket");
        add(TBABlocks.BASKET_OAK_LIGHT_BLUE.get(), "Light Blue Oak Basket");
        add(TBABlocks.BASKET_OAK_BLUE.get(), "Blue Oak Basket");
        add(TBABlocks.BASKET_OAK_PURPLE.get(), "Purple Oak Basket");
        add(TBABlocks.BASKET_OAK_MAGENTA.get(), "Magenta Oak Basket");
        add(TBABlocks.BASKET_OAK_PINK.get(), "Pink Oak Basket");
        add(TBABlocks.BASKET_BIRCH_WHITE.get(), "White Birch Basket");
        add(TBABlocks.BASKET_BIRCH_LIGHT_GRAY.get(), "Light Gray Birch Basket");
        add(TBABlocks.BASKET_BIRCH_GRAY.get(), "Gray Birch Basket");
        add(TBABlocks.BASKET_BIRCH_BLACK.get(), "Black Birch Basket");
        add(TBABlocks.BASKET_BIRCH_BROWN.get(), "Brown Birch Basket");
        add(TBABlocks.BASKET_BIRCH_RED.get(), "Red Birch Basket");
        add(TBABlocks.BASKET_BIRCH_ORANGE.get(), "Orange Birch Basket");
        add(TBABlocks.BASKET_BIRCH_YELLOW.get(), "Yellow Birch Basket");
        add(TBABlocks.BASKET_BIRCH_LIME.get(), "Lime Birch Basket");
        add(TBABlocks.BASKET_BIRCH_GREEN.get(), "Green Birch Basket");
        add(TBABlocks.BASKET_BIRCH_CYAN.get(), "Cyan Birch Basket");
        add(TBABlocks.BASKET_BIRCH_LIGHT_BLUE.get(), "Light Blue Birch Basket");
        add(TBABlocks.BASKET_BIRCH_BLUE.get(), "Blue Birch Basket");
        add(TBABlocks.BASKET_BIRCH_PURPLE.get(), "Purple Birch Basket");
        add(TBABlocks.BASKET_BIRCH_MAGENTA.get(), "Magenta Birch Basket");
        add(TBABlocks.BASKET_BIRCH_PINK.get(), "Pink Birch Basket");
        add(TBABlocks.BASKET_SPRUCE_WHITE.get(), "White Spruce Basket");
        add(TBABlocks.BASKET_SPRUCE_LIGHT_GRAY.get(), "Light Gray Spruce Basket");
        add(TBABlocks.BASKET_SPRUCE_GRAY.get(), "Gray Spruce Basket");
        add(TBABlocks.BASKET_SPRUCE_BLACK.get(), "Black Spruce Basket");
        add(TBABlocks.BASKET_SPRUCE_BROWN.get(), "Brown Spruce Basket");
        add(TBABlocks.BASKET_SPRUCE_RED.get(), "Red Spruce Basket");
        add(TBABlocks.BASKET_SPRUCE_ORANGE.get(), "Orange Spruce Basket");
        add(TBABlocks.BASKET_SPRUCE_YELLOW.get(), "Yellow Spruce Basket");
        add(TBABlocks.BASKET_SPRUCE_LIME.get(), "Lime Spruce Basket");
        add(TBABlocks.BASKET_SPRUCE_GREEN.get(), "Green Spruce Basket");
        add(TBABlocks.BASKET_SPRUCE_CYAN.get(), "Cyan Spruce Basket");
        add(TBABlocks.BASKET_SPRUCE_LIGHT_BLUE.get(), "Light Blue Spruce Basket");
        add(TBABlocks.BASKET_SPRUCE_BLUE.get(), "Blue Spruce Basket");
        add(TBABlocks.BASKET_SPRUCE_PURPLE.get(), "Purple Spruce Basket");
        add(TBABlocks.BASKET_SPRUCE_MAGENTA.get(), "Magenta Spruce Basket");
        add(TBABlocks.BASKET_SPRUCE_PINK.get(), "Pink Spruce Basket");
        add(TBABlocks.BASKET_JUNGLE_WHITE.get(), "White Jungle Basket");
        add(TBABlocks.BASKET_JUNGLE_LIGHT_GRAY.get(), "Light Gray Jungle Basket");
        add(TBABlocks.BASKET_JUNGLE_GRAY.get(), "Gray Jungle Basket");
        add(TBABlocks.BASKET_JUNGLE_BLACK.get(), "Black Jungle Basket");
        add(TBABlocks.BASKET_JUNGLE_BROWN.get(), "Brown Jungle Basket");
        add(TBABlocks.BASKET_JUNGLE_RED.get(), "Red Jungle Basket");
        add(TBABlocks.BASKET_JUNGLE_ORANGE.get(), "Orange Jungle Basket");
        add(TBABlocks.BASKET_JUNGLE_YELLOW.get(), "Yellow Jungle Basket");
        add(TBABlocks.BASKET_JUNGLE_LIME.get(), "Lime Jungle Basket");
        add(TBABlocks.BASKET_JUNGLE_GREEN.get(), "Green Jungle Basket");
        add(TBABlocks.BASKET_JUNGLE_CYAN.get(), "Cyan Jungle Basket");
        add(TBABlocks.BASKET_JUNGLE_LIGHT_BLUE.get(), "Light Blue Jungle Basket");
        add(TBABlocks.BASKET_JUNGLE_BLUE.get(), "Blue Jungle Basket");
        add(TBABlocks.BASKET_JUNGLE_PURPLE.get(), "Purple Jungle Basket");
        add(TBABlocks.BASKET_JUNGLE_MAGENTA.get(), "Magenta Jungle Basket");
        add(TBABlocks.BASKET_JUNGLE_PINK.get(), "Pink Jungle Basket");
        add(TBABlocks.BASKET_ACACIA_WHITE.get(), "White Acacia Basket");
        add(TBABlocks.BASKET_ACACIA_LIGHT_GRAY.get(), "Light Gray Acacia Basket");
        add(TBABlocks.BASKET_ACACIA_GRAY.get(), "Gray Acacia Basket");
        add(TBABlocks.BASKET_ACACIA_BLACK.get(), "Black Acacia Basket");
        add(TBABlocks.BASKET_ACACIA_BROWN.get(), "Brown Acacia Basket");
        add(TBABlocks.BASKET_ACACIA_RED.get(), "Red Acacia Basket");
        add(TBABlocks.BASKET_ACACIA_ORANGE.get(), "Orange Acacia Basket");
        add(TBABlocks.BASKET_ACACIA_YELLOW.get(), "Yellow Acacia Basket");
        add(TBABlocks.BASKET_ACACIA_LIME.get(), "Lime Acacia Basket");
        add(TBABlocks.BASKET_ACACIA_GREEN.get(), "Green Acacia Basket");
        add(TBABlocks.BASKET_ACACIA_CYAN.get(), "Cyan Acacia Basket");
        add(TBABlocks.BASKET_ACACIA_LIGHT_BLUE.get(), "Light Blue Acacia Basket");
        add(TBABlocks.BASKET_ACACIA_BLUE.get(), "Blue Acacia Basket");
        add(TBABlocks.BASKET_ACACIA_PURPLE.get(), "Purple Acacia Basket");
        add(TBABlocks.BASKET_ACACIA_MAGENTA.get(), "Magenta Acacia Basket");
        add(TBABlocks.BASKET_ACACIA_PINK.get(), "Pink Acacia Basket");
        add(TBABlocks.BASKET_DARK_OAK_WHITE.get(), "White Dark Oak Basket");
        add(TBABlocks.BASKET_DARK_OAK_LIGHT_GRAY.get(), "Light Gray Dark Oak Basket");
        add(TBABlocks.BASKET_DARK_OAK_GRAY.get(), "Gray Dark Oak Basket");
        add(TBABlocks.BASKET_DARK_OAK_BLACK.get(), "Black Dark Oak Basket");
        add(TBABlocks.BASKET_DARK_OAK_BROWN.get(), "Brown Dark Oak Basket");
        add(TBABlocks.BASKET_DARK_OAK_RED.get(), "Red Dark Oak Basket");
        add(TBABlocks.BASKET_DARK_OAK_ORANGE.get(), "Orange Dark Oak Basket");
        add(TBABlocks.BASKET_DARK_OAK_YELLOW.get(), "Yellow Dark Oak Basket");
        add(TBABlocks.BASKET_DARK_OAK_LIME.get(), "Lime Dark Oak Basket");
        add(TBABlocks.BASKET_DARK_OAK_GREEN.get(), "Green Dark Oak Basket");
        add(TBABlocks.BASKET_DARK_OAK_CYAN.get(), "Cyan Dark Oak Basket");
        add(TBABlocks.BASKET_DARK_OAK_LIGHT_BLUE.get(), "Light Blue Dark Oak Basket");
        add(TBABlocks.BASKET_DARK_OAK_BLUE.get(), "Blue Dark Oak Basket");
        add(TBABlocks.BASKET_DARK_OAK_PURPLE.get(), "Purple Dark Oak Basket");
        add(TBABlocks.BASKET_DARK_OAK_MAGENTA.get(), "Magenta Dark Oak Basket");
        add(TBABlocks.BASKET_DARK_OAK_PINK.get(), "Pink Dark Oak Basket");
        add(TBABlocks.BASKET_MANGROVE_WHITE.get(), "White Mangrove Basket");
        add(TBABlocks.BASKET_MANGROVE_LIGHT_GRAY.get(), "Light Gray Mangrove Basket");
        add(TBABlocks.BASKET_MANGROVE_GRAY.get(), "Gray Mangrove Basket");
        add(TBABlocks.BASKET_MANGROVE_BLACK.get(), "Black Mangrove Basket");
        add(TBABlocks.BASKET_MANGROVE_BROWN.get(), "Brown Mangrove Basket");
        add(TBABlocks.BASKET_MANGROVE_RED.get(), "Red Mangrove Basket");
        add(TBABlocks.BASKET_MANGROVE_ORANGE.get(), "Orange Mangrove Basket");
        add(TBABlocks.BASKET_MANGROVE_YELLOW.get(), "Yellow Mangrove Basket");
        add(TBABlocks.BASKET_MANGROVE_LIME.get(), "Lime Mangrove Basket");
        add(TBABlocks.BASKET_MANGROVE_GREEN.get(), "Green Mangrove Basket");
        add(TBABlocks.BASKET_MANGROVE_CYAN.get(), "Cyan Mangrove Basket");
        add(TBABlocks.BASKET_MANGROVE_LIGHT_BLUE.get(), "Light Blue Mangrove Basket");
        add(TBABlocks.BASKET_MANGROVE_BLUE.get(), "Blue Mangrove Basket");
        add(TBABlocks.BASKET_MANGROVE_PURPLE.get(), "Purple Mangrove Basket");
        add(TBABlocks.BASKET_MANGROVE_MAGENTA.get(), "Magenta Mangrove Basket");
        add(TBABlocks.BASKET_MANGROVE_PINK.get(), "Pink Mangrove Basket");
        add(TBABlocks.BASKET_CRIMSON_WHITE.get(), "White Crimson Basket");
        add(TBABlocks.BASKET_CRIMSON_LIGHT_GRAY.get(), "Light Gray Crimson Basket");
        add(TBABlocks.BASKET_CRIMSON_GRAY.get(), "Gray Crimson Basket");
        add(TBABlocks.BASKET_CRIMSON_BLACK.get(), "Black Crimson Basket");
        add(TBABlocks.BASKET_CRIMSON_BROWN.get(), "Brown Crimson Basket");
        add(TBABlocks.BASKET_CRIMSON_RED.get(), "Red Crimson Basket");
        add(TBABlocks.BASKET_CRIMSON_ORANGE.get(), "Orange Crimson Basket");
        add(TBABlocks.BASKET_CRIMSON_YELLOW.get(), "Yellow Crimson Basket");
        add(TBABlocks.BASKET_CRIMSON_LIME.get(), "Lime Crimson Basket");
        add(TBABlocks.BASKET_CRIMSON_GREEN.get(), "Green Crimson Basket");
        add(TBABlocks.BASKET_CRIMSON_CYAN.get(), "Cyan Crimson Basket");
        add(TBABlocks.BASKET_CRIMSON_LIGHT_BLUE.get(), "Light Blue Crimson Basket");
        add(TBABlocks.BASKET_CRIMSON_BLUE.get(), "Blue Crimson Basket");
        add(TBABlocks.BASKET_CRIMSON_PURPLE.get(), "Purple Crimson Basket");
        add(TBABlocks.BASKET_CRIMSON_MAGENTA.get(), "Magenta Crimson Basket");
        add(TBABlocks.BASKET_CRIMSON_PINK.get(), "Pink Crimson Basket");
        add(TBABlocks.BASKET_WARPED_WHITE.get(), "White Warped Basket");
        add(TBABlocks.BASKET_WARPED_LIGHT_GRAY.get(), "Light Gray Warped Basket");
        add(TBABlocks.BASKET_WARPED_GRAY.get(), "Gray Warped Basket");
        add(TBABlocks.BASKET_WARPED_BLACK.get(), "Black Warped Basket");
        add(TBABlocks.BASKET_WARPED_BROWN.get(), "Brown Warped Basket");
        add(TBABlocks.BASKET_WARPED_RED.get(), "Red Warped Basket");
        add(TBABlocks.BASKET_WARPED_ORANGE.get(), "Orange Warped Basket");
        add(TBABlocks.BASKET_WARPED_YELLOW.get(), "Yellow Warped Basket");
        add(TBABlocks.BASKET_WARPED_LIME.get(), "Lime Warped Basket");
        add(TBABlocks.BASKET_WARPED_GREEN.get(), "Green Warped Basket");
        add(TBABlocks.BASKET_WARPED_CYAN.get(), "Cyan Warped Basket");
        add(TBABlocks.BASKET_WARPED_LIGHT_BLUE.get(), "Light Blue Warped Basket");
        add(TBABlocks.BASKET_WARPED_BLUE.get(), "Blue Warped Basket");
        add(TBABlocks.BASKET_WARPED_PURPLE.get(), "Purple Warped Basket");
        add(TBABlocks.BASKET_WARPED_MAGENTA.get(), "Magenta Warped Basket");
        add(TBABlocks.BASKET_WARPED_PINK.get(), "Pink Warped Basket");
        add(TBABlocks.BASKET_FIR_WHITE.get(), "White Fir Basket");
        add(TBABlocks.BASKET_FIR_LIGHT_GRAY.get(), "Light Gray Fir Basket");
        add(TBABlocks.BASKET_FIR_GRAY.get(), "Gray Fir Basket");
        add(TBABlocks.BASKET_FIR_BLACK.get(), "Black Fir Basket");
        add(TBABlocks.BASKET_FIR_BROWN.get(), "Brown Fir Basket");
        add(TBABlocks.BASKET_FIR_RED.get(), "Red Fir Basket");
        add(TBABlocks.BASKET_FIR_ORANGE.get(), "Orange Fir Basket");
        add(TBABlocks.BASKET_FIR_YELLOW.get(), "Yellow Fir Basket");
        add(TBABlocks.BASKET_FIR_LIME.get(), "Lime Fir Basket");
        add(TBABlocks.BASKET_FIR_GREEN.get(), "Green Fir Basket");
        add(TBABlocks.BASKET_FIR_CYAN.get(), "Cyan Fir Basket");
        add(TBABlocks.BASKET_FIR_LIGHT_BLUE.get(), "Light Blue Fir Basket");
        add(TBABlocks.BASKET_FIR_BLUE.get(), "Blue Fir Basket");
        add(TBABlocks.BASKET_FIR_PURPLE.get(), "Purple Fir Basket");
        add(TBABlocks.BASKET_FIR_MAGENTA.get(), "Magenta Fir Basket");
        add(TBABlocks.BASKET_FIR_PINK.get(), "Pink Fir Basket");
        add(TBABlocks.BASKET_REDWOOD_WHITE.get(), "White Redwood Basket");
        add(TBABlocks.BASKET_REDWOOD_LIGHT_GRAY.get(), "Light Gray Redwood Basket");
        add(TBABlocks.BASKET_REDWOOD_GRAY.get(), "Gray Redwood Basket");
        add(TBABlocks.BASKET_REDWOOD_BLACK.get(), "Black Redwood Basket");
        add(TBABlocks.BASKET_REDWOOD_BROWN.get(), "Brown Redwood Basket");
        add(TBABlocks.BASKET_REDWOOD_RED.get(), "Red Redwood Basket");
        add(TBABlocks.BASKET_REDWOOD_ORANGE.get(), "Orange Redwood Basket");
        add(TBABlocks.BASKET_REDWOOD_YELLOW.get(), "Yellow Redwood Basket");
        add(TBABlocks.BASKET_REDWOOD_LIME.get(), "Lime Redwood Basket");
        add(TBABlocks.BASKET_REDWOOD_GREEN.get(), "Green Redwood Basket");
        add(TBABlocks.BASKET_REDWOOD_CYAN.get(), "Cyan Redwood Basket");
        add(TBABlocks.BASKET_REDWOOD_LIGHT_BLUE.get(), "Light Blue Redwood Basket");
        add(TBABlocks.BASKET_REDWOOD_BLUE.get(), "Blue Redwood Basket");
        add(TBABlocks.BASKET_REDWOOD_PURPLE.get(), "Purple Redwood Basket");
        add(TBABlocks.BASKET_REDWOOD_MAGENTA.get(), "Magenta Redwood Basket");
        add(TBABlocks.BASKET_REDWOOD_PINK.get(), "Pink Redwood Basket");
        add(TBABlocks.BASKET_CHERRY_WHITE.get(), "White Cherry Basket");
        add(TBABlocks.BASKET_CHERRY_LIGHT_GRAY.get(), "Light Gray Cherry Basket");
        add(TBABlocks.BASKET_CHERRY_GRAY.get(), "Gray Cherry Basket");
        add(TBABlocks.BASKET_CHERRY_BLACK.get(), "Black Cherry Basket");
        add(TBABlocks.BASKET_CHERRY_BROWN.get(), "Brown Cherry Basket");
        add(TBABlocks.BASKET_CHERRY_RED.get(), "Red Cherry Basket");
        add(TBABlocks.BASKET_CHERRY_ORANGE.get(), "Orange Cherry Basket");
        add(TBABlocks.BASKET_CHERRY_YELLOW.get(), "Yellow Cherry Basket");
        add(TBABlocks.BASKET_CHERRY_LIME.get(), "Lime Cherry Basket");
        add(TBABlocks.BASKET_CHERRY_GREEN.get(), "Green Cherry Basket");
        add(TBABlocks.BASKET_CHERRY_CYAN.get(), "Cyan Cherry Basket");
        add(TBABlocks.BASKET_CHERRY_LIGHT_BLUE.get(), "Light Blue Cherry Basket");
        add(TBABlocks.BASKET_CHERRY_BLUE.get(), "Blue Cherry Basket");
        add(TBABlocks.BASKET_CHERRY_PURPLE.get(), "Purple Cherry Basket");
        add(TBABlocks.BASKET_CHERRY_MAGENTA.get(), "Magenta Cherry Basket");
        add(TBABlocks.BASKET_CHERRY_PINK.get(), "Pink Cherry Basket");
        add(TBABlocks.BASKET_MAHOGANY_WHITE.get(), "White Mahogany Basket");
        add(TBABlocks.BASKET_MAHOGANY_LIGHT_GRAY.get(), "Light Gray Mahogany Basket");
        add(TBABlocks.BASKET_MAHOGANY_GRAY.get(), "Gray Mahogany Basket");
        add(TBABlocks.BASKET_MAHOGANY_BLACK.get(), "Black Mahogany Basket");
        add(TBABlocks.BASKET_MAHOGANY_BROWN.get(), "Brown Mahogany Basket");
        add(TBABlocks.BASKET_MAHOGANY_RED.get(), "Red Mahogany Basket");
        add(TBABlocks.BASKET_MAHOGANY_ORANGE.get(), "Orange Mahogany Basket");
        add(TBABlocks.BASKET_MAHOGANY_YELLOW.get(), "Yellow Mahogany Basket");
        add(TBABlocks.BASKET_MAHOGANY_LIME.get(), "Lime Mahogany Basket");
        add(TBABlocks.BASKET_MAHOGANY_GREEN.get(), "Green Mahogany Basket");
        add(TBABlocks.BASKET_MAHOGANY_CYAN.get(), "Cyan Mahogany Basket");
        add(TBABlocks.BASKET_MAHOGANY_LIGHT_BLUE.get(), "Light Blue Mahogany Basket");
        add(TBABlocks.BASKET_MAHOGANY_BLUE.get(), "Blue Mahogany Basket");
        add(TBABlocks.BASKET_MAHOGANY_PURPLE.get(), "Purple Mahogany Basket");
        add(TBABlocks.BASKET_MAHOGANY_MAGENTA.get(), "Magenta Mahogany Basket");
        add(TBABlocks.BASKET_MAHOGANY_PINK.get(), "Pink Mahogany Basket");
        add(TBABlocks.BASKET_JACARANDA_WHITE.get(), "White Jacaranda Basket");
        add(TBABlocks.BASKET_JACARANDA_LIGHT_GRAY.get(), "Light Gray Jacaranda Basket");
        add(TBABlocks.BASKET_JACARANDA_GRAY.get(), "Gray Jacaranda Basket");
        add(TBABlocks.BASKET_JACARANDA_BLACK.get(), "Black Jacaranda Basket");
        add(TBABlocks.BASKET_JACARANDA_BROWN.get(), "Brown Jacaranda Basket");
        add(TBABlocks.BASKET_JACARANDA_RED.get(), "Red Jacaranda Basket");
        add(TBABlocks.BASKET_JACARANDA_ORANGE.get(), "Orange Jacaranda Basket");
        add(TBABlocks.BASKET_JACARANDA_YELLOW.get(), "Yellow Jacaranda Basket");
        add(TBABlocks.BASKET_JACARANDA_LIME.get(), "Lime Jacaranda Basket");
        add(TBABlocks.BASKET_JACARANDA_GREEN.get(), "Green Jacaranda Basket");
        add(TBABlocks.BASKET_JACARANDA_CYAN.get(), "Cyan Jacaranda Basket");
        add(TBABlocks.BASKET_JACARANDA_LIGHT_BLUE.get(), "Light Blue Jacaranda Basket");
        add(TBABlocks.BASKET_JACARANDA_BLUE.get(), "Blue Jacaranda Basket");
        add(TBABlocks.BASKET_JACARANDA_PURPLE.get(), "Purple Jacaranda Basket");
        add(TBABlocks.BASKET_JACARANDA_MAGENTA.get(), "Magenta Jacaranda Basket");
        add(TBABlocks.BASKET_JACARANDA_PINK.get(), "Pink Jacaranda Basket");
        add(TBABlocks.BASKET_PALM_WHITE.get(), "White Palm Basket");
        add(TBABlocks.BASKET_PALM_LIGHT_GRAY.get(), "Light Gray Palm Basket");
        add(TBABlocks.BASKET_PALM_GRAY.get(), "Gray Palm Basket");
        add(TBABlocks.BASKET_PALM_BLACK.get(), "Black Palm Basket");
        add(TBABlocks.BASKET_PALM_BROWN.get(), "Brown Palm Basket");
        add(TBABlocks.BASKET_PALM_RED.get(), "Red Palm Basket");
        add(TBABlocks.BASKET_PALM_ORANGE.get(), "Orange Palm Basket");
        add(TBABlocks.BASKET_PALM_YELLOW.get(), "Yellow Palm Basket");
        add(TBABlocks.BASKET_PALM_LIME.get(), "Lime Palm Basket");
        add(TBABlocks.BASKET_PALM_GREEN.get(), "Green Palm Basket");
        add(TBABlocks.BASKET_PALM_CYAN.get(), "Cyan Palm Basket");
        add(TBABlocks.BASKET_PALM_LIGHT_BLUE.get(), "Light Blue Palm Basket");
        add(TBABlocks.BASKET_PALM_BLUE.get(), "Blue Palm Basket");
        add(TBABlocks.BASKET_PALM_PURPLE.get(), "Purple Palm Basket");
        add(TBABlocks.BASKET_PALM_MAGENTA.get(), "Magenta Palm Basket");
        add(TBABlocks.BASKET_PALM_PINK.get(), "Pink Palm Basket");
        add(TBABlocks.BASKET_WILLOW_WHITE.get(), "White Willow Basket");
        add(TBABlocks.BASKET_WILLOW_LIGHT_GRAY.get(), "Light Gray Willow Basket");
        add(TBABlocks.BASKET_WILLOW_GRAY.get(), "Gray Willow Basket");
        add(TBABlocks.BASKET_WILLOW_BLACK.get(), "Black Willow Basket");
        add(TBABlocks.BASKET_WILLOW_BROWN.get(), "Brown Willow Basket");
        add(TBABlocks.BASKET_WILLOW_RED.get(), "Red Willow Basket");
        add(TBABlocks.BASKET_WILLOW_ORANGE.get(), "Orange Willow Basket");
        add(TBABlocks.BASKET_WILLOW_YELLOW.get(), "Yellow Willow Basket");
        add(TBABlocks.BASKET_WILLOW_LIME.get(), "Lime Willow Basket");
        add(TBABlocks.BASKET_WILLOW_GREEN.get(), "Green Willow Basket");
        add(TBABlocks.BASKET_WILLOW_CYAN.get(), "Cyan Willow Basket");
        add(TBABlocks.BASKET_WILLOW_LIGHT_BLUE.get(), "Light Blue Willow Basket");
        add(TBABlocks.BASKET_WILLOW_BLUE.get(), "Blue Willow Basket");
        add(TBABlocks.BASKET_WILLOW_PURPLE.get(), "Purple Willow Basket");
        add(TBABlocks.BASKET_WILLOW_MAGENTA.get(), "Magenta Willow Basket");
        add(TBABlocks.BASKET_WILLOW_PINK.get(), "Pink Willow Basket");
        add(TBABlocks.BASKET_DEAD_WHITE.get(), "White Dead Basket");
        add(TBABlocks.BASKET_DEAD_LIGHT_GRAY.get(), "Light Gray Dead Basket");
        add(TBABlocks.BASKET_DEAD_GRAY.get(), "Gray Dead Basket");
        add(TBABlocks.BASKET_DEAD_BLACK.get(), "Black Dead Basket");
        add(TBABlocks.BASKET_DEAD_BROWN.get(), "Brown Dead Basket");
        add(TBABlocks.BASKET_DEAD_RED.get(), "Red Dead Basket");
        add(TBABlocks.BASKET_DEAD_ORANGE.get(), "Orange Dead Basket");
        add(TBABlocks.BASKET_DEAD_YELLOW.get(), "Yellow Dead Basket");
        add(TBABlocks.BASKET_DEAD_LIME.get(), "Lime Dead Basket");
        add(TBABlocks.BASKET_DEAD_GREEN.get(), "Green Dead Basket");
        add(TBABlocks.BASKET_DEAD_CYAN.get(), "Cyan Dead Basket");
        add(TBABlocks.BASKET_DEAD_LIGHT_BLUE.get(), "Light Blue Dead Basket");
        add(TBABlocks.BASKET_DEAD_BLUE.get(), "Blue Dead Basket");
        add(TBABlocks.BASKET_DEAD_PURPLE.get(), "Purple Dead Basket");
        add(TBABlocks.BASKET_DEAD_MAGENTA.get(), "Magenta Dead Basket");
        add(TBABlocks.BASKET_DEAD_PINK.get(), "Pink Dead Basket");
        add(TBABlocks.BASKET_MAGIC_WHITE.get(), "White Magic Basket");
        add(TBABlocks.BASKET_MAGIC_LIGHT_GRAY.get(), "Light Gray Magic Basket");
        add(TBABlocks.BASKET_MAGIC_GRAY.get(), "Gray Magic Basket");
        add(TBABlocks.BASKET_MAGIC_BLACK.get(), "Black Magic Basket");
        add(TBABlocks.BASKET_MAGIC_BROWN.get(), "Brown Magic Basket");
        add(TBABlocks.BASKET_MAGIC_RED.get(), "Red Magic Basket");
        add(TBABlocks.BASKET_MAGIC_ORANGE.get(), "Orange Magic Basket");
        add(TBABlocks.BASKET_MAGIC_YELLOW.get(), "Yellow Magic Basket");
        add(TBABlocks.BASKET_MAGIC_LIME.get(), "Lime Magic Basket");
        add(TBABlocks.BASKET_MAGIC_GREEN.get(), "Green Magic Basket");
        add(TBABlocks.BASKET_MAGIC_CYAN.get(), "Cyan Magic Basket");
        add(TBABlocks.BASKET_MAGIC_LIGHT_BLUE.get(), "Light Blue Magic Basket");
        add(TBABlocks.BASKET_MAGIC_BLUE.get(), "Blue Magic Basket");
        add(TBABlocks.BASKET_MAGIC_PURPLE.get(), "Purple Magic Basket");
        add(TBABlocks.BASKET_MAGIC_MAGENTA.get(), "Magenta Magic Basket");
        add(TBABlocks.BASKET_MAGIC_PINK.get(), "Pink Magic Basket");
        add(TBABlocks.BASKET_UMBRAN_WHITE.get(), "White Umbran Basket");
        add(TBABlocks.BASKET_UMBRAN_LIGHT_GRAY.get(), "Light Gray Umbran Basket");
        add(TBABlocks.BASKET_UMBRAN_GRAY.get(), "Gray Umbran Basket");
        add(TBABlocks.BASKET_UMBRAN_BLACK.get(), "Black Umbran Basket");
        add(TBABlocks.BASKET_UMBRAN_BROWN.get(), "Brown Umbran Basket");
        add(TBABlocks.BASKET_UMBRAN_RED.get(), "Red Umbran Basket");
        add(TBABlocks.BASKET_UMBRAN_ORANGE.get(), "Orange Umbran Basket");
        add(TBABlocks.BASKET_UMBRAN_YELLOW.get(), "Yellow Umbran Basket");
        add(TBABlocks.BASKET_UMBRAN_LIME.get(), "Lime Umbran Basket");
        add(TBABlocks.BASKET_UMBRAN_GREEN.get(), "Green Umbran Basket");
        add(TBABlocks.BASKET_UMBRAN_CYAN.get(), "Cyan Umbran Basket");
        add(TBABlocks.BASKET_UMBRAN_LIGHT_BLUE.get(), "Light Blue Umbran Basket");
        add(TBABlocks.BASKET_UMBRAN_BLUE.get(), "Blue Umbran Basket");
        add(TBABlocks.BASKET_UMBRAN_PURPLE.get(), "Purple Umbran Basket");
        add(TBABlocks.BASKET_UMBRAN_MAGENTA.get(), "Magenta Umbran Basket");
        add(TBABlocks.BASKET_UMBRAN_PINK.get(), "Pink Umbran Basket");
        add(TBABlocks.BASKET_HELLBARK_WHITE.get(), "White Hellbark Basket");
        add(TBABlocks.BASKET_HELLBARK_LIGHT_GRAY.get(), "Light Gray Hellbark Basket");
        add(TBABlocks.BASKET_HELLBARK_GRAY.get(), "Gray Hellbark Basket");
        add(TBABlocks.BASKET_HELLBARK_BLACK.get(), "Black Hellbark Basket");
        add(TBABlocks.BASKET_HELLBARK_BROWN.get(), "Brown Hellbark Basket");
        add(TBABlocks.BASKET_HELLBARK_RED.get(), "Red Hellbark Basket");
        add(TBABlocks.BASKET_HELLBARK_ORANGE.get(), "Orange Hellbark Basket");
        add(TBABlocks.BASKET_HELLBARK_YELLOW.get(), "Yellow Hellbark Basket");
        add(TBABlocks.BASKET_HELLBARK_LIME.get(), "Lime Hellbark Basket");
        add(TBABlocks.BASKET_HELLBARK_GREEN.get(), "Green Hellbark Basket");
        add(TBABlocks.BASKET_HELLBARK_CYAN.get(), "Cyan Hellbark Basket");
        add(TBABlocks.BASKET_HELLBARK_LIGHT_BLUE.get(), "Light Blue Hellbark Basket");
        add(TBABlocks.BASKET_HELLBARK_BLUE.get(), "Blue Hellbark Basket");
        add(TBABlocks.BASKET_HELLBARK_PURPLE.get(), "Purple Hellbark Basket");
        add(TBABlocks.BASKET_HELLBARK_MAGENTA.get(), "Magenta Hellbark Basket");
        add(TBABlocks.BASKET_HELLBARK_PINK.get(), "Pink Hellbark Basket");
        add(TBABlocks.BASKET_COCONUT_WHITE.get(), "White Coconut Basket");
        add(TBABlocks.BASKET_COCONUT_LIGHT_GRAY.get(), "Light Gray Coconut Basket");
        add(TBABlocks.BASKET_COCONUT_GRAY.get(), "Gray Coconut Basket");
        add(TBABlocks.BASKET_COCONUT_BLACK.get(), "Black Coconut Basket");
        add(TBABlocks.BASKET_COCONUT_BROWN.get(), "Brown Coconut Basket");
        add(TBABlocks.BASKET_COCONUT_RED.get(), "Red Coconut Basket");
        add(TBABlocks.BASKET_COCONUT_ORANGE.get(), "Orange Coconut Basket");
        add(TBABlocks.BASKET_COCONUT_YELLOW.get(), "Yellow Coconut Basket");
        add(TBABlocks.BASKET_COCONUT_LIME.get(), "Lime Coconut Basket");
        add(TBABlocks.BASKET_COCONUT_GREEN.get(), "Green Coconut Basket");
        add(TBABlocks.BASKET_COCONUT_CYAN.get(), "Cyan Coconut Basket");
        add(TBABlocks.BASKET_COCONUT_LIGHT_BLUE.get(), "Light Blue Coconut Basket");
        add(TBABlocks.BASKET_COCONUT_BLUE.get(), "Blue Coconut Basket");
        add(TBABlocks.BASKET_COCONUT_PURPLE.get(), "Purple Coconut Basket");
        add(TBABlocks.BASKET_COCONUT_MAGENTA.get(), "Magenta Coconut Basket");
        add(TBABlocks.BASKET_COCONUT_PINK.get(), "Pink Coconut Basket");
        add(TBABlocks.BASKET_WALNUT_WHITE.get(), "White Walnut Basket");
        add(TBABlocks.BASKET_WALNUT_LIGHT_GRAY.get(), "Light Gray Walnut Basket");
        add(TBABlocks.BASKET_WALNUT_GRAY.get(), "Gray Walnut Basket");
        add(TBABlocks.BASKET_WALNUT_BLACK.get(), "Black Walnut Basket");
        add(TBABlocks.BASKET_WALNUT_BROWN.get(), "Brown Walnut Basket");
        add(TBABlocks.BASKET_WALNUT_RED.get(), "Red Walnut Basket");
        add(TBABlocks.BASKET_WALNUT_ORANGE.get(), "Orange Walnut Basket");
        add(TBABlocks.BASKET_WALNUT_YELLOW.get(), "Yellow Walnut Basket");
        add(TBABlocks.BASKET_WALNUT_LIME.get(), "Lime Walnut Basket");
        add(TBABlocks.BASKET_WALNUT_GREEN.get(), "Green Walnut Basket");
        add(TBABlocks.BASKET_WALNUT_CYAN.get(), "Cyan Walnut Basket");
        add(TBABlocks.BASKET_WALNUT_LIGHT_BLUE.get(), "Light Blue Walnut Basket");
        add(TBABlocks.BASKET_WALNUT_BLUE.get(), "Blue Walnut Basket");
        add(TBABlocks.BASKET_WALNUT_PURPLE.get(), "Purple Walnut Basket");
        add(TBABlocks.BASKET_WALNUT_MAGENTA.get(), "Magenta Walnut Basket");
        add(TBABlocks.BASKET_WALNUT_PINK.get(), "Pink Walnut Basket");
        add(TBABlocks.BASKET_AZALEA_WHITE.get(), "White Azalea Basket");
        add(TBABlocks.BASKET_AZALEA_LIGHT_GRAY.get(), "Light Gray Azalea Basket");
        add(TBABlocks.BASKET_AZALEA_GRAY.get(), "Gray Azalea Basket");
        add(TBABlocks.BASKET_AZALEA_BLACK.get(), "Black Azalea Basket");
        add(TBABlocks.BASKET_AZALEA_BROWN.get(), "Brown Azalea Basket");
        add(TBABlocks.BASKET_AZALEA_RED.get(), "Red Azalea Basket");
        add(TBABlocks.BASKET_AZALEA_ORANGE.get(), "Orange Azalea Basket");
        add(TBABlocks.BASKET_AZALEA_YELLOW.get(), "Yellow Azalea Basket");
        add(TBABlocks.BASKET_AZALEA_LIME.get(), "Lime Azalea Basket");
        add(TBABlocks.BASKET_AZALEA_GREEN.get(), "Green Azalea Basket");
        add(TBABlocks.BASKET_AZALEA_CYAN.get(), "Cyan Azalea Basket");
        add(TBABlocks.BASKET_AZALEA_LIGHT_BLUE.get(), "Light Blue Azalea Basket");
        add(TBABlocks.BASKET_AZALEA_BLUE.get(), "Blue Azalea Basket");
        add(TBABlocks.BASKET_AZALEA_PURPLE.get(), "Purple Azalea Basket");
        add(TBABlocks.BASKET_AZALEA_MAGENTA.get(), "Magenta Azalea Basket");
        add(TBABlocks.BASKET_AZALEA_PINK.get(), "Pink Azalea Basket");
        add(TBABlocks.BASKET_FLOWERING_AZALEA_WHITE.get(), "White Flowering Azalea Basket");
        add(TBABlocks.BASKET_FLOWERING_AZALEA_LIGHT_GRAY.get(), "Light Gray Flowering Azalea Basket");
        add(TBABlocks.BASKET_FLOWERING_AZALEA_GRAY.get(), "Gray Flowering Azalea Basket");
        add(TBABlocks.BASKET_FLOWERING_AZALEA_BLACK.get(), "Black Flowering Azalea Basket");
        add(TBABlocks.BASKET_FLOWERING_AZALEA_BROWN.get(), "Brown Flowering Azalea Basket");
        add(TBABlocks.BASKET_FLOWERING_AZALEA_RED.get(), "Red Flowering Azalea Basket");
        add(TBABlocks.BASKET_FLOWERING_AZALEA_ORANGE.get(), "Orange Flowering Azalea Basket");
        add(TBABlocks.BASKET_FLOWERING_AZALEA_YELLOW.get(), "Yellow Flowering Azalea Basket");
        add(TBABlocks.BASKET_FLOWERING_AZALEA_LIME.get(), "Lime Flowering Azalea Basket");
        add(TBABlocks.BASKET_FLOWERING_AZALEA_GREEN.get(), "Green Flowering Azalea Basket");
        add(TBABlocks.BASKET_FLOWERING_AZALEA_CYAN.get(), "Cyan Flowering Azalea Basket");
        add(TBABlocks.BASKET_FLOWERING_AZALEA_LIGHT_BLUE.get(), "Light Blue Flowering Azalea Basket");
        add(TBABlocks.BASKET_FLOWERING_AZALEA_BLUE.get(), "Blue Flowering Azalea Basket");
        add(TBABlocks.BASKET_FLOWERING_AZALEA_PURPLE.get(), "Purple Flowering Azalea Basket");
        add(TBABlocks.BASKET_FLOWERING_AZALEA_MAGENTA.get(), "Magenta Flowering Azalea Basket");
        add(TBABlocks.BASKET_FLOWERING_AZALEA_PINK.get(), "Pink Flowering Azalea Basket");
        add(TBABlocks.BASKET_AETHER_SKYROOT_WHITE.get(), "White Aether Skyroot Basket");
        add(TBABlocks.BASKET_AETHER_SKYROOT_LIGHT_GRAY.get(), "Light Gray Aether Skyroot Basket");
        add(TBABlocks.BASKET_AETHER_SKYROOT_GRAY.get(), "Gray Aether Skyroot Basket");
        add(TBABlocks.BASKET_AETHER_SKYROOT_BLACK.get(), "Black Aether Skyroot Basket");
        add(TBABlocks.BASKET_AETHER_SKYROOT_BROWN.get(), "Brown Aether Skyroot Basket");
        add(TBABlocks.BASKET_AETHER_SKYROOT_RED.get(), "Red Aether Skyroot Basket");
        add(TBABlocks.BASKET_AETHER_SKYROOT_ORANGE.get(), "Orange Aether Skyroot Basket");
        add(TBABlocks.BASKET_AETHER_SKYROOT_YELLOW.get(), "Yellow Aether Skyroot Basket");
        add(TBABlocks.BASKET_AETHER_SKYROOT_LIME.get(), "Lime Aether Skyroot Basket");
        add(TBABlocks.BASKET_AETHER_SKYROOT_GREEN.get(), "Green Aether Skyroot Basket");
        add(TBABlocks.BASKET_AETHER_SKYROOT_CYAN.get(), "Cyan Aether Skyroot Basket");
        add(TBABlocks.BASKET_AETHER_SKYROOT_LIGHT_BLUE.get(), "Light Blue Aether Skyroot Basket");
        add(TBABlocks.BASKET_AETHER_SKYROOT_BLUE.get(), "Blue Aether Skyroot Basket");
        add(TBABlocks.BASKET_AETHER_SKYROOT_PURPLE.get(), "Purple Aether Skyroot Basket");
        add(TBABlocks.BASKET_AETHER_SKYROOT_MAGENTA.get(), "Magenta Aether Skyroot Basket");
        add(TBABlocks.BASKET_AETHER_SKYROOT_PINK.get(), "Pink Aether Skyroot Basket");
        add(TBABlocks.BASKET_PREAM_WHITE.get(), "White Pream Basket");
        add(TBABlocks.BASKET_PREAM_LIGHT_GRAY.get(), "Light Gray Pream Basket");
        add(TBABlocks.BASKET_PREAM_GRAY.get(), "Gray Pream Basket");
        add(TBABlocks.BASKET_PREAM_BLACK.get(), "Black Pream Basket");
        add(TBABlocks.BASKET_PREAM_BROWN.get(), "Brown Pream Basket");
        add(TBABlocks.BASKET_PREAM_RED.get(), "Red Pream Basket");
        add(TBABlocks.BASKET_PREAM_ORANGE.get(), "Orange Pream Basket");
        add(TBABlocks.BASKET_PREAM_YELLOW.get(), "Yellow Pream Basket");
        add(TBABlocks.BASKET_PREAM_LIME.get(), "Lime Pream Basket");
        add(TBABlocks.BASKET_PREAM_GREEN.get(), "Green Pream Basket");
        add(TBABlocks.BASKET_PREAM_CYAN.get(), "Cyan Pream Basket");
        add(TBABlocks.BASKET_PREAM_LIGHT_BLUE.get(), "Light Blue Pream Basket");
        add(TBABlocks.BASKET_PREAM_BLUE.get(), "Blue Pream Basket");
        add(TBABlocks.BASKET_PREAM_PURPLE.get(), "Purple Pream Basket");
        add(TBABlocks.BASKET_PREAM_MAGENTA.get(), "Magenta Pream Basket");
        add(TBABlocks.BASKET_PREAM_PINK.get(), "Pink Pream Basket");
        add(TBABlocks.BASKET_EBONY_WHITE.get(), "White Ebony Basket");
        add(TBABlocks.BASKET_EBONY_LIGHT_GRAY.get(), "Light Gray Ebony Basket");
        add(TBABlocks.BASKET_EBONY_GRAY.get(), "Gray Ebony Basket");
        add(TBABlocks.BASKET_EBONY_BLACK.get(), "Black Ebony Basket");
        add(TBABlocks.BASKET_EBONY_BROWN.get(), "Brown Ebony Basket");
        add(TBABlocks.BASKET_EBONY_RED.get(), "Red Ebony Basket");
        add(TBABlocks.BASKET_EBONY_ORANGE.get(), "Orange Ebony Basket");
        add(TBABlocks.BASKET_EBONY_YELLOW.get(), "Yellow Ebony Basket");
        add(TBABlocks.BASKET_EBONY_LIME.get(), "Lime Ebony Basket");
        add(TBABlocks.BASKET_EBONY_GREEN.get(), "Green Ebony Basket");
        add(TBABlocks.BASKET_EBONY_CYAN.get(), "Cyan Ebony Basket");
        add(TBABlocks.BASKET_EBONY_LIGHT_BLUE.get(), "Light Blue Ebony Basket");
        add(TBABlocks.BASKET_EBONY_BLUE.get(), "Blue Ebony Basket");
        add(TBABlocks.BASKET_EBONY_PURPLE.get(), "Purple Ebony Basket");
        add(TBABlocks.BASKET_EBONY_MAGENTA.get(), "Magenta Ebony Basket");
        add(TBABlocks.BASKET_EBONY_PINK.get(), "Pink Ebony Basket");
        add(TBABlocks.BASKET_CHORUS_NEST_WHITE.get(), "White Chorus Nest Basket");
        add(TBABlocks.BASKET_CHORUS_NEST_LIGHT_GRAY.get(), "Light Gray Chorus Nest Basket");
        add(TBABlocks.BASKET_CHORUS_NEST_GRAY.get(), "Gray Chorus Nest Basket");
        add(TBABlocks.BASKET_CHORUS_NEST_BLACK.get(), "Black Chorus Nest Basket");
        add(TBABlocks.BASKET_CHORUS_NEST_BROWN.get(), "Brown Chorus Nest Basket");
        add(TBABlocks.BASKET_CHORUS_NEST_RED.get(), "Red Chorus Nest Basket");
        add(TBABlocks.BASKET_CHORUS_NEST_ORANGE.get(), "Orange Chorus Nest Basket");
        add(TBABlocks.BASKET_CHORUS_NEST_YELLOW.get(), "Yellow Chorus Nest Basket");
        add(TBABlocks.BASKET_CHORUS_NEST_LIME.get(), "Lime Chorus Nest Basket");
        add(TBABlocks.BASKET_CHORUS_NEST_GREEN.get(), "Green Chorus Nest Basket");
        add(TBABlocks.BASKET_CHORUS_NEST_CYAN.get(), "Cyan Chorus Nest Basket");
        add(TBABlocks.BASKET_CHORUS_NEST_LIGHT_BLUE.get(), "Light Blue Chorus Nest Basket");
        add(TBABlocks.BASKET_CHORUS_NEST_BLUE.get(), "Blue Chorus Nest Basket");
        add(TBABlocks.BASKET_CHORUS_NEST_PURPLE.get(), "Purple Chorus Nest Basket");
        add(TBABlocks.BASKET_CHORUS_NEST_MAGENTA.get(), "Magenta Chorus Nest Basket");
        add(TBABlocks.BASKET_CHORUS_NEST_PINK.get(), "Pink Chorus Nest Basket");
        add(TBABlocks.BASKET_BLOODSHROOM_WHITE.get(), "White Bloodshroom Basket");
        add(TBABlocks.BASKET_BLOODSHROOM_LIGHT_GRAY.get(), "Light Gray Bloodshroom Basket");
        add(TBABlocks.BASKET_BLOODSHROOM_GRAY.get(), "Gray Bloodshroom Basket");
        add(TBABlocks.BASKET_BLOODSHROOM_BLACK.get(), "Black Bloodshroom Basket");
        add(TBABlocks.BASKET_BLOODSHROOM_BROWN.get(), "Brown Bloodshroom Basket");
        add(TBABlocks.BASKET_BLOODSHROOM_RED.get(), "Red Bloodshroom Basket");
        add(TBABlocks.BASKET_BLOODSHROOM_ORANGE.get(), "Orange Bloodshroom Basket");
        add(TBABlocks.BASKET_BLOODSHROOM_YELLOW.get(), "Yellow Bloodshroom Basket");
        add(TBABlocks.BASKET_BLOODSHROOM_LIME.get(), "Lime Bloodshroom Basket");
        add(TBABlocks.BASKET_BLOODSHROOM_GREEN.get(), "Green Bloodshroom Basket");
        add(TBABlocks.BASKET_BLOODSHROOM_CYAN.get(), "Cyan Bloodshroom Basket");
        add(TBABlocks.BASKET_BLOODSHROOM_LIGHT_BLUE.get(), "Light Blue Bloodshroom Basket");
        add(TBABlocks.BASKET_BLOODSHROOM_BLUE.get(), "Blue Bloodshroom Basket");
        add(TBABlocks.BASKET_BLOODSHROOM_PURPLE.get(), "Purple Bloodshroom Basket");
        add(TBABlocks.BASKET_BLOODSHROOM_MAGENTA.get(), "Magenta Bloodshroom Basket");
        add(TBABlocks.BASKET_BLOODSHROOM_PINK.get(), "Pink Bloodshroom Basket");
        add(TBABlocks.BASKET_ENDERBARK_WHITE.get(), "White Enderbark Basket");
        add(TBABlocks.BASKET_ENDERBARK_LIGHT_GRAY.get(), "Light Gray Enderbark Basket");
        add(TBABlocks.BASKET_ENDERBARK_GRAY.get(), "Gray Enderbark Basket");
        add(TBABlocks.BASKET_ENDERBARK_BLACK.get(), "Black Enderbark Basket");
        add(TBABlocks.BASKET_ENDERBARK_BROWN.get(), "Brown Enderbark Basket");
        add(TBABlocks.BASKET_ENDERBARK_RED.get(), "Red Enderbark Basket");
        add(TBABlocks.BASKET_ENDERBARK_ORANGE.get(), "Orange Enderbark Basket");
        add(TBABlocks.BASKET_ENDERBARK_YELLOW.get(), "Yellow Enderbark Basket");
        add(TBABlocks.BASKET_ENDERBARK_LIME.get(), "Lime Enderbark Basket");
        add(TBABlocks.BASKET_ENDERBARK_GREEN.get(), "Green Enderbark Basket");
        add(TBABlocks.BASKET_ENDERBARK_CYAN.get(), "Cyan Enderbark Basket");
        add(TBABlocks.BASKET_ENDERBARK_LIGHT_BLUE.get(), "Light Blue Enderbark Basket");
        add(TBABlocks.BASKET_ENDERBARK_BLUE.get(), "Blue Enderbark Basket");
        add(TBABlocks.BASKET_ENDERBARK_PURPLE.get(), "Purple Enderbark Basket");
        add(TBABlocks.BASKET_ENDERBARK_MAGENTA.get(), "Magenta Enderbark Basket");
        add(TBABlocks.BASKET_ENDERBARK_PINK.get(), "Pink Enderbark Basket");
        add(TBABlocks.BASKET_GREENHEART_WHITE.get(), "White Greenheart Basket");
        add(TBABlocks.BASKET_GREENHEART_LIGHT_GRAY.get(), "Light Gray Greenheart Basket");
        add(TBABlocks.BASKET_GREENHEART_GRAY.get(), "Gray Greenheart Basket");
        add(TBABlocks.BASKET_GREENHEART_BLACK.get(), "Black Greenheart Basket");
        add(TBABlocks.BASKET_GREENHEART_BROWN.get(), "Brown Greenheart Basket");
        add(TBABlocks.BASKET_GREENHEART_RED.get(), "Red Greenheart Basket");
        add(TBABlocks.BASKET_GREENHEART_ORANGE.get(), "Orange Greenheart Basket");
        add(TBABlocks.BASKET_GREENHEART_YELLOW.get(), "Yellow Greenheart Basket");
        add(TBABlocks.BASKET_GREENHEART_LIME.get(), "Lime Greenheart Basket");
        add(TBABlocks.BASKET_GREENHEART_GREEN.get(), "Green Greenheart Basket");
        add(TBABlocks.BASKET_GREENHEART_CYAN.get(), "Cyan Greenheart Basket");
        add(TBABlocks.BASKET_GREENHEART_LIGHT_BLUE.get(), "Light Blue Greenheart Basket");
        add(TBABlocks.BASKET_GREENHEART_BLUE.get(), "Blue Greenheart Basket");
        add(TBABlocks.BASKET_GREENHEART_PURPLE.get(), "Purple Greenheart Basket");
        add(TBABlocks.BASKET_GREENHEART_MAGENTA.get(), "Magenta Greenheart Basket");
        add(TBABlocks.BASKET_GREENHEART_PINK.get(), "Pink Greenheart Basket");
        add(TBABlocks.BASKET_TINKER_SKYROOT_WHITE.get(), "White Tinker Skyroot Basket");
        add(TBABlocks.BASKET_TINKER_SKYROOT_LIGHT_GRAY.get(), "Light Gray Tinker Skyroot Basket");
        add(TBABlocks.BASKET_TINKER_SKYROOT_GRAY.get(), "Gray Tinker Skyroot Basket");
        add(TBABlocks.BASKET_TINKER_SKYROOT_BLACK.get(), "Black Tinker Skyroot Basket");
        add(TBABlocks.BASKET_TINKER_SKYROOT_BROWN.get(), "Brown Tinker Skyroot Basket");
        add(TBABlocks.BASKET_TINKER_SKYROOT_RED.get(), "Red Tinker Skyroot Basket");
        add(TBABlocks.BASKET_TINKER_SKYROOT_ORANGE.get(), "Orange Tinker Skyroot Basket");
        add(TBABlocks.BASKET_TINKER_SKYROOT_YELLOW.get(), "Yellow Tinker Skyroot Basket");
        add(TBABlocks.BASKET_TINKER_SKYROOT_LIME.get(), "Lime Tinker Skyroot Basket");
        add(TBABlocks.BASKET_TINKER_SKYROOT_GREEN.get(), "Green Tinker Skyroot Basket");
        add(TBABlocks.BASKET_TINKER_SKYROOT_CYAN.get(), "Cyan Tinker Skyroot Basket");
        add(TBABlocks.BASKET_TINKER_SKYROOT_LIGHT_BLUE.get(), "Light Blue Tinker Skyroot Basket");
        add(TBABlocks.BASKET_TINKER_SKYROOT_BLUE.get(), "Blue Tinker Skyroot Basket");
        add(TBABlocks.BASKET_TINKER_SKYROOT_PURPLE.get(), "Purple Tinker Skyroot Basket");
        add(TBABlocks.BASKET_TINKER_SKYROOT_MAGENTA.get(), "Magenta Tinker Skyroot Basket");
        add(TBABlocks.BASKET_TINKER_SKYROOT_PINK.get(), "Pink Tinker Skyroot Basket");
    }

    private void addItemGroups() {
        add("itemGroup." + MODID, "Turtle Block Academy Tab");
    }
}