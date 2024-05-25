package com.github.warrentode.turtleblockacademy.datagen.lang;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.items.TBAItems;
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
    }

    private void addEntityTypes() {
        add("entity.turtleblockacademy.treasure_beetle", "Treasure Beetle");
        add("entity.turtleblockacademy.herobrine", "Herobrine");
    }

    private void addSubtitles() {
        add("subtitles.turtleblockacademy.desk_open", "Desk Drawer Opens");
        add("subtitles.turtleblockacademy.desk_close", "Desk Drawer Closes");
        add("subtitles.turtleblockacademy.locker_open", "Locker Opens");
        add("subtitles.turtleblockacademy.locker_close", "Locker Closes");
        add("subtitles.turtleblockacademy.bookcase_open", "Bookcase Opens");
        add("subtitles.turtleblockacademy.bookcase_close", "Bookcase Closes");
        add("subtitles.turtleblockacademy.treasure_beetle_hurts", "Treasure Beetle Hurts");
        add("subtitles.turtleblockacademy.treasure_beetle_ambient", "Treasure Beetle Hisses");
        add("subtitles.turtleblockacademy.treasure_beetle_death", "Treasure Beetle Dies");
        add("subtitles.turtleblockacademy.treasure_beetle_step", "Treasure Beetle Crawls");
        add("subtitles.turtleblockacademy.treasure_beetle_item_drop", "Treasure Beetle Drops Treasure");
        add("subtitles.turtleblockacademy.herobrine_ambient", "You feel you're being watched...");
    }

    private void addContainers() {
        add("container.turtleblockacademy.desk", "School Desk");
        add("container.turtleblockacademy.storage", "Storage");
        add("container.turtleblockacademy.fermenting_pot", "Fermenting Pot");
        add("container.turtleblockacademy.recipe_book.fermenting", "Showing Fermentable");
    }

    private void addMessages() {
        add("message." + MODID + ".registered", "You are now registered as a student of Turtle Block Academy");
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
        fillTooltipKeys("student_card_blank", "Blank Student Card - Use to Register as Student");
        fillTooltipKeys("certificate_blank", "Blank Certificate");
    }

    private void fillTooltipKeys(String key, String name) {
        add("tooltips.turtleblockacademy." + key, name);
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
    }

    private void addBlocks() {
        add(TBABlocks.CERTIFICATE_BLOCK.get(), "Certificate of Completion");
        add(TBABlocks.QUARTZ_CLUSTER.get(), "Quartz Cluster");
        add(TBABlocks.FERMENTING_POT_BLOCK.get(), "Fermenting Pot");
        add(TBABlocks.CLOVE_BUSH.get(), "Clove Bush");
        add(TBABlocks.CUCUMBER_BUSH.get(), "Cucumber Bush");
        add(TBABlocks.DILL_BUSH.get(), "Dill Crop");

        // add(TBABlocks.TBA_MINING_PORTAL.get(), "Mining Portal Block");

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
        add(TBABlocks.DESK_CHAIR_BIRCH.get(), "Birch Desk Chair");
        add(TBABlocks.DESK_CHAIR_SPRUCE.get(), "Spruce Desk Chair");
        add(TBABlocks.DESK_CHAIR_JUNGLE.get(), "Jungle Desk Chair");
        add(TBABlocks.DESK_CHAIR_ACACIA.get(), "Acacia Desk Chair");
        add(TBABlocks.DESK_CHAIR_DARK_OAK.get(), "Dark Oak Desk Chair");
        add(TBABlocks.DESK_CHAIR_MANGROVE.get(), "Mangrove Desk Chair");
        add(TBABlocks.DESK_CHAIR_CRIMSON.get(), "Crimson Desk Chair");
        add(TBABlocks.DESK_CHAIR_WARPED.get(), "Warped Desk Chair");

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
        add(TBABlocks.DESK_CHAIR_FIR.get(), "Fir Desk Chair");
        add(TBABlocks.LOCKER_FIR.get(), "Fir Locker");
        add(TBABlocks.PARK_BENCH_FIR.get(), "Fir Park Bench");
        add(TBABlocks.TABLE_FIR.get(), "Fir Table");

        add(TBABlocks.SCHOOL_DESK_REDWOOD.get(), "Redwood School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_REDWOOD.get(), "Redwood School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_REDWOOD.get(), "Redwood Desk Chair");
        add(TBABlocks.LOCKER_REDWOOD.get(), "Redwood Locker");
        add(TBABlocks.PARK_BENCH_REDWOOD.get(), "Redwood Park Bench");
        add(TBABlocks.TABLE_REDWOOD.get(), "Redwood Table");

        add(TBABlocks.SCHOOL_DESK_CHERRY.get(), "Cherry School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_CHERRY.get(), "Cherry School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_CHERRY.get(), "Cherry Desk Chair");
        add(TBABlocks.LOCKER_CHERRY.get(), "Cherry Locker");
        add(TBABlocks.PARK_BENCH_CHERRY.get(), "Cherry Park Bench");
        add(TBABlocks.TABLE_CHERRY.get(), "Cherry Table");

        add(TBABlocks.SCHOOL_DESK_MAHOGANY.get(), "Mahogany School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_MAHOGANY.get(), "Mahogany School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_MAHOGANY.get(), "Mahogany Desk Chair");
        add(TBABlocks.LOCKER_MAHOGANY.get(), "Mahogany Locker");
        add(TBABlocks.PARK_BENCH_MAHOGANY.get(), "Mahogany Park Bench");
        add(TBABlocks.TABLE_MAHOGANY.get(), "Mahogany Table");

        add(TBABlocks.SCHOOL_DESK_JACARANDA.get(), "Jacaranda School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_JACARANDA.get(), "Jacaranda School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_JACARANDA.get(), "Jacaranda Desk Chair");
        add(TBABlocks.LOCKER_JACARANDA.get(), "Jacaranda Locker");
        add(TBABlocks.PARK_BENCH_JACARANDA.get(), "Jacaranda Park Bench");
        add(TBABlocks.TABLE_JACARANDA.get(), "Jacaranda Table");

        add(TBABlocks.SCHOOL_DESK_PALM.get(), "Palm School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_PALM.get(), "Palm School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_PALM.get(), "Palm Desk Chair");
        add(TBABlocks.LOCKER_PALM.get(), "Palm Locker");
        add(TBABlocks.PARK_BENCH_PALM.get(), "Palm Park Bench");
        add(TBABlocks.TABLE_PALM.get(), "Palm Table");

        add(TBABlocks.SCHOOL_DESK_WILLOW.get(), "Willow School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_WILLOW.get(), "Willow School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_WILLOW.get(), "Willow Desk Chair");
        add(TBABlocks.LOCKER_WILLOW.get(), "Willow Locker");
        add(TBABlocks.PARK_BENCH_WILLOW.get(), "Willow Park Bench");
        add(TBABlocks.TABLE_WILLOW.get(), "Willow Table");

        add(TBABlocks.SCHOOL_DESK_DEAD.get(), "Dead School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_DEAD.get(), "Dead School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_DEAD.get(), "Dead Desk Chair");
        add(TBABlocks.LOCKER_DEAD.get(), "Dead Locker");
        add(TBABlocks.PARK_BENCH_DEAD.get(), "Dead Park Bench");
        add(TBABlocks.TABLE_DEAD.get(), "Dead Table");

        add(TBABlocks.SCHOOL_DESK_MAGIC.get(), "Magic School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_MAGIC.get(), "Magic School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_MAGIC.get(), "Magic Desk Chair");
        add(TBABlocks.LOCKER_MAGIC.get(), "Magic Locker");
        add(TBABlocks.PARK_BENCH_MAGIC.get(), "Magic Park Bench");
        add(TBABlocks.TABLE_MAGIC.get(), "Magic Table");

        add(TBABlocks.SCHOOL_DESK_UMBRAN.get(), "Umbran School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_UMBRAN.get(), "Umbran School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_UMBRAN.get(), "Umbran Desk Chair");
        add(TBABlocks.LOCKER_UMBRAN.get(), "Umbran Locker");
        add(TBABlocks.PARK_BENCH_UMBRAN.get(), "Umbran Park Bench");
        add(TBABlocks.TABLE_UMBRAN.get(), "Umbran Table");

        add(TBABlocks.SCHOOL_DESK_HELLBARK.get(), "Hellbark School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_HELLBARK.get(), "Hellbark School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_HELLBARK.get(), "Hellbark Desk Chair");
        add(TBABlocks.LOCKER_HELLBARK.get(), "Hellbark Locker");
        add(TBABlocks.PARK_BENCH_HELLBARK.get(), "Hellbark Park Bench");
        add(TBABlocks.TABLE_HELLBARK.get(), "Hellbark Table");

        add(TBABlocks.SCHOOL_DESK_COCONUT.get(), "Coconut School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_COCONUT.get(), "Coconut School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_COCONUT.get(), "Coconut Desk Chair");
        add(TBABlocks.LOCKER_COCONUT.get(), "Coconut Locker");
        add(TBABlocks.PARK_BENCH_COCONUT.get(), "Coconut Park Bench");
        add(TBABlocks.TABLE_COCONUT.get(), "Coconut Table");

        add(TBABlocks.SCHOOL_DESK_WALNUT.get(), "Walnut School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_WALNUT.get(), "Walnut School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_WALNUT.get(), "Walnut Desk Chair");
        add(TBABlocks.LOCKER_WALNUT.get(), "Walnut Locker");
        add(TBABlocks.PARK_BENCH_WALNUT.get(), "Walnut Park Bench");
        add(TBABlocks.TABLE_WALNUT.get(), "Walnut Table");

        add(TBABlocks.SCHOOL_DESK_AZALEA.get(), "Azalea School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_AZALEA.get(), "Azalea School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_AZALEA.get(), "Azalea Desk Chair");
        add(TBABlocks.LOCKER_AZALEA.get(), "Azalea Locker");
        add(TBABlocks.PARK_BENCH_AZALEA.get(), "Azalea Park Bench");
        add(TBABlocks.TABLE_AZALEA.get(), "Azalea Table");

        add(TBABlocks.SCHOOL_DESK_FLOWERING_AZALEA.get(), "Flowering Azalea School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_FLOWERING_AZALEA.get(), "Flowering Azalea School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA.get(), "Flowering Azalea Desk Chair");
        add(TBABlocks.LOCKER_FLOWERING_AZALEA.get(), "Flowering Azalea Locker");
        add(TBABlocks.PARK_BENCH_FLOWERING_AZALEA.get(), "Flowering Azalea Park Bench");
        add(TBABlocks.TABLE_FLOWERING_AZALEA.get(), "Flowering Azalea Table");

        add(TBABlocks.SCHOOL_DESK_GOLDEN_OAK.get(), "Golden Oak School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_GOLDEN_OAK.get(), "Golden Oak School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_GOLDEN_OAK.get(), "Golden Oak Desk Chair");
        add(TBABlocks.LOCKER_GOLDEN_OAK.get(), "Golden Oak Locker");
        add(TBABlocks.PARK_BENCH_GOLDEN_OAK.get(), "Golden Oak Park Bench");
        add(TBABlocks.TABLE_GOLDEN_OAK.get(), "Golden Oak Table");

        add(TBABlocks.SCHOOL_DESK_AETHER_SKYROOT.get(), "Aether Skyroot School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_AETHER_SKYROOT.get(), "Aether Skyroot School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_AETHER_SKYROOT.get(), "Aether Skyroot Desk Chair");
        add(TBABlocks.LOCKER_AETHER_SKYROOT.get(), "Aether Skyroot Locker");
        add(TBABlocks.PARK_BENCH_AETHER_SKYROOT.get(), "Aether Skyroot Park Bench");
        add(TBABlocks.TABLE_AETHER_SKYROOT.get(), "Aether Skyroot Table");

        add(TBABlocks.SCHOOL_DESK_PREAM.get(), "Pream School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_PREAM.get(), "Pream School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_PREAM.get(), "Pream Desk Chair");
        add(TBABlocks.LOCKER_PREAM.get(), "Pream Locker");
        add(TBABlocks.PARK_BENCH_PREAM.get(), "Pream Park Bench");
        add(TBABlocks.TABLE_PREAM.get(), "Pream Table");

        add(TBABlocks.SCHOOL_DESK_EBONY.get(), "Ebony School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_EBONY.get(), "Ebony School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_EBONY.get(), "Ebony Desk Chair");
        add(TBABlocks.LOCKER_EBONY.get(), "Ebony Locker");
        add(TBABlocks.PARK_BENCH_EBONY.get(), "Ebony Park Bench");
        add(TBABlocks.TABLE_EBONY.get(), "Ebony Table");

        add(TBABlocks.SCHOOL_DESK_CHORUS_NEST.get(), "Chorus Nest School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_CHORUS_NEST.get(), "Chorus Nest School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_CHORUS_NEST.get(), "Chorus Nest Desk Chair");
        add(TBABlocks.LOCKER_CHORUS_NEST.get(), "Chorus Nest Locker");
        add(TBABlocks.PARK_BENCH_CHORUS_NEST.get(), "Chorus Nest Park Bench");
        add(TBABlocks.TABLE_CHORUS_NEST.get(), "Chorus Nest Table");

        add(TBABlocks.SCHOOL_DESK_BLOODSHROOM.get(), "Bloodshroom School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_BLOODSHROOM.get(), "Bloodshroom School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_BLOODSHROOM.get(), "Bloodshroom Desk Chair");
        add(TBABlocks.LOCKER_BLOODSHROOM.get(), "Bloodshroom Locker");
        add(TBABlocks.PARK_BENCH_BLOODSHROOM.get(), "Bloodshroom Park Bench");
        add(TBABlocks.TABLE_BLOODSHROOM.get(), "Bloodshroom Table");

        add(TBABlocks.SCHOOL_DESK_ENDERBARK.get(), "Enderbark School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_ENDERBARK.get(), "Enderbark School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_ENDERBARK.get(), "Enderbark Desk Chair");
        add(TBABlocks.LOCKER_ENDERBARK.get(), "Enderbark Locker");
        add(TBABlocks.PARK_BENCH_ENDERBARK.get(), "Enderbark Park Bench");
        add(TBABlocks.TABLE_ENDERBARK.get(), "Enderbark Table");

        add(TBABlocks.SCHOOL_DESK_GREENHEART.get(), "Greenheart School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_GREENHEART.get(), "Greenheart School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_GREENHEART.get(), "Greenheart Desk Chair");
        add(TBABlocks.LOCKER_GREENHEART.get(), "Greenheart Locker");
        add(TBABlocks.PARK_BENCH_GREENHEART.get(), "Greenheart Park Bench");
        add(TBABlocks.TABLE_GREENHEART.get(), "Greenheart Table");

        add(TBABlocks.SCHOOL_DESK_TINKER_SKYROOT.get(), "Tinker Skyroot School Desk");
        add(TBABlocks.SCHOOL_DESK_CABINET_TINKER_SKYROOT.get(), "Tinker Skyroot School Desk Cabinet");
        add(TBABlocks.DESK_CHAIR_TINKER_SKYROOT.get(), "Tinker Skyroot Desk Chair");
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
    }

    private void addItemGroups() {
        add("itemGroup.turtleblockacademy", "Turtle Block Academy Tab");
    }
}
