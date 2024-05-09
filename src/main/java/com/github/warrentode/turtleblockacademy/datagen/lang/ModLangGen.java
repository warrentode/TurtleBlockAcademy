package com.github.warrentode.turtleblockacademy.datagen.lang;

import com.github.warrentode.turtleblockacademy.blocks.ModBlockRegistry;
import com.github.warrentode.turtleblockacademy.items.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class ModLangGen extends LanguageProvider {
    public ModLangGen(DataGenerator generator, String modid, String locale) {
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
    }

    private void addSubtitles() {
        add("subtitles.turtleblockacademy.desk_open", "Desk Drawer Opens");
        add("subtitles.turtleblockacademy.desk_close", "Desk Drawer Closes");
        add("subtitles.turtleblockacademy.locker_open", "Locker Opens");
        add("subtitles.turtleblockacademy.locker_close", "Locker Closes");
        add("subtitles.turtleblockacademy.bookcase_open", "Bookcase Opens");
        add("subtitles.turtleblockacademy.bookcase_close", "Bookcase Closes");
    }

    private void addContainers() {
        add("container.turtleblockacademy.desk", "School Desk");
        add("container.turtleblockacademy.storage", "Storage");
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
        add(ModItems.STUDENT_CARD.get(), "Turtle Block Academy Student ID");
    }

    private void addBlocks() {
        add(ModBlockRegistry.CERTIFICATE_BLOCK.get(), "Certificate of Completion");

        add(ModBlockRegistry.PLATE_WHITE.get(), "White Plate");
        add(ModBlockRegistry.PLATE_ORANGE.get(), "Orange Plate");
        add(ModBlockRegistry.PLATE_MAGENTA.get(), "Magenta Plate");
        add(ModBlockRegistry.PLATE_LIGHT_BLUE.get(), "Light Blue Plate");
        add(ModBlockRegistry.PLATE_YELLOW.get(), "Yellow Plate");
        add(ModBlockRegistry.PLATE_LIME.get(), "Lime Plate");
        add(ModBlockRegistry.PLATE_PINK.get(), "Pink Plate");
        add(ModBlockRegistry.PLATE_GRAY.get(), "Gray Plate");
        add(ModBlockRegistry.PLATE_LIGHT_GRAY.get(), "Light Gray Plate");
        add(ModBlockRegistry.PLATE_CYAN.get(), "Cyan Plate");
        add(ModBlockRegistry.PLATE_PURPLE.get(), "Purple Plate");
        add(ModBlockRegistry.PLATE_BLUE.get(), "Blue Plate");
        add(ModBlockRegistry.PLATE_BROWN.get(), "Brown Plate");
        add(ModBlockRegistry.PLATE_GREEN.get(), "Green Plate");
        add(ModBlockRegistry.PLATE_RED.get(), "Red Plate");
        add(ModBlockRegistry.PLATE_BLACK.get(), "Black Plate");

        add(ModBlockRegistry.SCHOOL_DESK_OAK.get(), "Oak School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_BIRCH.get(), "Birch School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_SPRUCE.get(), "Spruce School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_JUNGLE.get(), "Jungle School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_ACACIA.get(), "Acacia School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_DARK_OAK.get(), "Dark Oak School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_MANGROVE.get(), "Mangrove School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CRIMSON.get(), "Crimson School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_WARPED.get(), "Warped School Desk");

        add(ModBlockRegistry.SCHOOL_DESK_CABINET_OAK.get(), "Oak School Desk Cabinet");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_BIRCH.get(), "Birch School Desk Cabinet");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_SPRUCE.get(), "Spruce School Desk Cabinet");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_JUNGLE.get(), "Jungle School Desk Cabinet");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_ACACIA.get(), "Acacia School Desk Cabinet");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_DARK_OAK.get(), "Dark Oak School Desk Cabinet");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_MANGROVE.get(), "Mangrove School Desk Cabinet");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_CRIMSON.get(), "Crimson School Desk Cabinet");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_WARPED.get(), "Warped School Desk Cabinet");

        add(ModBlockRegistry.DESK_CHAIR_OAK.get(), "Oak Desk Chair");
        add(ModBlockRegistry.DESK_CHAIR_BIRCH.get(), "Birch Desk Chair");
        add(ModBlockRegistry.DESK_CHAIR_SPRUCE.get(), "Spruce Desk Chair");
        add(ModBlockRegistry.DESK_CHAIR_JUNGLE.get(), "Jungle Desk Chair");
        add(ModBlockRegistry.DESK_CHAIR_ACACIA.get(), "Acacia Desk Chair");
        add(ModBlockRegistry.DESK_CHAIR_DARK_OAK.get(), "Dark Oak Desk Chair");
        add(ModBlockRegistry.DESK_CHAIR_MANGROVE.get(), "Mangrove Desk Chair");
        add(ModBlockRegistry.DESK_CHAIR_CRIMSON.get(), "Crimson Desk Chair");
        add(ModBlockRegistry.DESK_CHAIR_WARPED.get(), "Warped Desk Chair");

        add(ModBlockRegistry.LOCKER_OAK.get(), "Oak Locker");
        add(ModBlockRegistry.LOCKER_BIRCH.get(), "Birch Locker");
        add(ModBlockRegistry.LOCKER_SPRUCE.get(), "Spruce Locker");
        add(ModBlockRegistry.LOCKER_JUNGLE.get(), "Jungle Locker");
        add(ModBlockRegistry.LOCKER_ACACIA.get(), "Acacia Locker");
        add(ModBlockRegistry.LOCKER_DARK_OAK.get(), "Dark Oak Locker");
        add(ModBlockRegistry.LOCKER_MANGROVE.get(), "Mangrove Locker");
        add(ModBlockRegistry.LOCKER_CRIMSON.get(), "Crimson Locker");
        add(ModBlockRegistry.LOCKER_WARPED.get(), "Warped Locker");

        add(ModBlockRegistry.PARK_BENCH_OAK.get(), "Oak Park Bench");
        add(ModBlockRegistry.PARK_BENCH_BIRCH.get(), "Birch Park Bench");
        add(ModBlockRegistry.PARK_BENCH_SPRUCE.get(), "Spruce Park Bench");
        add(ModBlockRegistry.PARK_BENCH_JUNGLE.get(), "Jungle Park Bench");
        add(ModBlockRegistry.PARK_BENCH_ACACIA.get(), "Acacia Park Bench");
        add(ModBlockRegistry.PARK_BENCH_DARK_OAK.get(), "Dark Oak Park Bench");
        add(ModBlockRegistry.PARK_BENCH_MANGROVE.get(), "Mangrove Park Bench");
        add(ModBlockRegistry.PARK_BENCH_CRIMSON.get(), "Crimson Park Bench");
        add(ModBlockRegistry.PARK_BENCH_WARPED.get(), "Warped Park Bench");

        add(ModBlockRegistry.TABLE_OAK.get(), "Oak Table");
        add(ModBlockRegistry.TABLE_BIRCH.get(), "Birch Table");
        add(ModBlockRegistry.TABLE_SPRUCE.get(), "Spruce Table");
        add(ModBlockRegistry.TABLE_JUNGLE.get(), "Jungle Table");
        add(ModBlockRegistry.TABLE_ACACIA.get(), "Acacia Table");
        add(ModBlockRegistry.TABLE_DARK_OAK.get(), "Dark Oak Table");
        add(ModBlockRegistry.TABLE_MANGROVE.get(), "Mangrove Table");
        add(ModBlockRegistry.TABLE_CRIMSON.get(), "Crimson Table");
        add(ModBlockRegistry.TABLE_WARPED.get(), "Warped Table");

        add(ModBlockRegistry.SCHOOL_DESK_FIR.get(), "Fir School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_FIR.get(), "Fir School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_FIR.get(), "Fir Desk Chair");
        add(ModBlockRegistry.LOCKER_FIR.get(), "Fir Locker");
        add(ModBlockRegistry.PARK_BENCH_FIR.get(), "Fir Park Bench");
        add(ModBlockRegistry.TABLE_FIR.get(), "Fir Table");

        add(ModBlockRegistry.SCHOOL_DESK_REDWOOD.get(), "Redwood School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_REDWOOD.get(), "Redwood School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_REDWOOD.get(), "Redwood Desk Chair");
        add(ModBlockRegistry.LOCKER_REDWOOD.get(), "Redwood Locker");
        add(ModBlockRegistry.PARK_BENCH_REDWOOD.get(), "Redwood Park Bench");
        add(ModBlockRegistry.TABLE_REDWOOD.get(), "Redwood Table");

        add(ModBlockRegistry.SCHOOL_DESK_CHERRY.get(), "Cherry School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_CHERRY.get(), "Cherry School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_CHERRY.get(), "Cherry Desk Chair");
        add(ModBlockRegistry.LOCKER_CHERRY.get(), "Cherry Locker");
        add(ModBlockRegistry.PARK_BENCH_CHERRY.get(), "Cherry Park Bench");
        add(ModBlockRegistry.TABLE_CHERRY.get(), "Cherry Table");

        add(ModBlockRegistry.SCHOOL_DESK_MAHOGANY.get(), "Mahogany School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_MAHOGANY.get(), "Mahogany School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_MAHOGANY.get(), "Mahogany Desk Chair");
        add(ModBlockRegistry.LOCKER_MAHOGANY.get(), "Mahogany Locker");
        add(ModBlockRegistry.PARK_BENCH_MAHOGANY.get(), "Mahogany Park Bench");
        add(ModBlockRegistry.TABLE_MAHOGANY.get(), "Mahogany Table");

        add(ModBlockRegistry.SCHOOL_DESK_JACARANDA.get(), "Jacaranda School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_JACARANDA.get(), "Jacaranda School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_JACARANDA.get(), "Jacaranda Desk Chair");
        add(ModBlockRegistry.LOCKER_JACARANDA.get(), "Jacaranda Locker");
        add(ModBlockRegistry.PARK_BENCH_JACARANDA.get(), "Jacaranda Park Bench");
        add(ModBlockRegistry.TABLE_JACARANDA.get(), "Jacaranda Table");

        add(ModBlockRegistry.SCHOOL_DESK_PALM.get(), "Palm School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_PALM.get(), "Palm School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_PALM.get(), "Palm Desk Chair");
        add(ModBlockRegistry.LOCKER_PALM.get(), "Palm Locker");
        add(ModBlockRegistry.PARK_BENCH_PALM.get(), "Palm Park Bench");
        add(ModBlockRegistry.TABLE_PALM.get(), "Palm Table");

        add(ModBlockRegistry.SCHOOL_DESK_WILLOW.get(), "Willow School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_WILLOW.get(), "Willow School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_WILLOW.get(), "Willow Desk Chair");
        add(ModBlockRegistry.LOCKER_WILLOW.get(), "Willow Locker");
        add(ModBlockRegistry.PARK_BENCH_WILLOW.get(), "Willow Park Bench");
        add(ModBlockRegistry.TABLE_WILLOW.get(), "Willow Table");

        add(ModBlockRegistry.SCHOOL_DESK_DEAD.get(), "Dead School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_DEAD.get(), "Dead School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_DEAD.get(), "Dead Desk Chair");
        add(ModBlockRegistry.LOCKER_DEAD.get(), "Dead Locker");
        add(ModBlockRegistry.PARK_BENCH_DEAD.get(), "Dead Park Bench");
        add(ModBlockRegistry.TABLE_DEAD.get(), "Dead Table");

        add(ModBlockRegistry.SCHOOL_DESK_MAGIC.get(), "Magic School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_MAGIC.get(), "Magic School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_MAGIC.get(), "Magic Desk Chair");
        add(ModBlockRegistry.LOCKER_MAGIC.get(), "Magic Locker");
        add(ModBlockRegistry.PARK_BENCH_MAGIC.get(), "Magic Park Bench");
        add(ModBlockRegistry.TABLE_MAGIC.get(), "Magic Table");

        add(ModBlockRegistry.SCHOOL_DESK_UMBRAN.get(), "Umbran School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_UMBRAN.get(), "Umbran School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_UMBRAN.get(), "Umbran Desk Chair");
        add(ModBlockRegistry.LOCKER_UMBRAN.get(), "Umbran Locker");
        add(ModBlockRegistry.PARK_BENCH_UMBRAN.get(), "Umbran Park Bench");
        add(ModBlockRegistry.TABLE_UMBRAN.get(), "Umbran Table");

        add(ModBlockRegistry.SCHOOL_DESK_HELLBARK.get(), "Hellbark School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_HELLBARK.get(), "Hellbark School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_HELLBARK.get(), "Hellbark Desk Chair");
        add(ModBlockRegistry.LOCKER_HELLBARK.get(), "Hellbark Locker");
        add(ModBlockRegistry.PARK_BENCH_HELLBARK.get(), "Hellbark Park Bench");
        add(ModBlockRegistry.TABLE_HELLBARK.get(), "Hellbark Table");

        add(ModBlockRegistry.SCHOOL_DESK_COCONUT.get(), "Coconut School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_COCONUT.get(), "Coconut School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_COCONUT.get(), "Coconut Desk Chair");
        add(ModBlockRegistry.LOCKER_COCONUT.get(), "Coconut Locker");
        add(ModBlockRegistry.PARK_BENCH_COCONUT.get(), "Coconut Park Bench");
        add(ModBlockRegistry.TABLE_COCONUT.get(), "Coconut Table");

        add(ModBlockRegistry.SCHOOL_DESK_WALNUT.get(), "Walnut School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_WALNUT.get(), "Walnut School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_WALNUT.get(), "Walnut Desk Chair");
        add(ModBlockRegistry.LOCKER_WALNUT.get(), "Walnut Locker");
        add(ModBlockRegistry.PARK_BENCH_WALNUT.get(), "Walnut Park Bench");
        add(ModBlockRegistry.TABLE_WALNUT.get(), "Walnut Table");

        add(ModBlockRegistry.SCHOOL_DESK_AZALEA.get(), "Azalea School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_AZALEA.get(), "Azalea School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_AZALEA.get(), "Azalea Desk Chair");
        add(ModBlockRegistry.LOCKER_AZALEA.get(), "Azalea Locker");
        add(ModBlockRegistry.PARK_BENCH_AZALEA.get(), "Azalea Park Bench");
        add(ModBlockRegistry.TABLE_AZALEA.get(), "Azalea Table");

        add(ModBlockRegistry.SCHOOL_DESK_FLOWERING_AZALEA.get(), "Flowering Azalea School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_FLOWERING_AZALEA.get(), "Flowering Azalea School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_FLOWERING_AZALEA.get(), "Flowering Azalea Desk Chair");
        add(ModBlockRegistry.LOCKER_FLOWERING_AZALEA.get(), "Flowering Azalea Locker");
        add(ModBlockRegistry.PARK_BENCH_FLOWERING_AZALEA.get(), "Flowering Azalea Park Bench");
        add(ModBlockRegistry.TABLE_FLOWERING_AZALEA.get(), "Flowering Azalea Table");

        add(ModBlockRegistry.SCHOOL_DESK_GOLDEN_OAK.get(), "Golden Oak School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_GOLDEN_OAK.get(), "Golden Oak School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_GOLDEN_OAK.get(), "Golden Oak Desk Chair");
        add(ModBlockRegistry.LOCKER_GOLDEN_OAK.get(), "Golden Oak Locker");
        add(ModBlockRegistry.PARK_BENCH_GOLDEN_OAK.get(), "Golden Oak Park Bench");
        add(ModBlockRegistry.TABLE_GOLDEN_OAK.get(), "Golden Oak Table");

        add(ModBlockRegistry.SCHOOL_DESK_AETHER_SKYROOT.get(), "Aether Skyroot School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_AETHER_SKYROOT.get(), "Aether Skyroot School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_AETHER_SKYROOT.get(), "Aether Skyroot Desk Chair");
        add(ModBlockRegistry.LOCKER_AETHER_SKYROOT.get(), "Aether Skyroot Locker");
        add(ModBlockRegistry.PARK_BENCH_AETHER_SKYROOT.get(), "Aether Skyroot Park Bench");
        add(ModBlockRegistry.TABLE_AETHER_SKYROOT.get(), "Aether Skyroot Table");

        add(ModBlockRegistry.SCHOOL_DESK_PREAM.get(), "Pream School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_PREAM.get(), "Pream School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_PREAM.get(), "Pream Desk Chair");
        add(ModBlockRegistry.LOCKER_PREAM.get(), "Pream Locker");
        add(ModBlockRegistry.PARK_BENCH_PREAM.get(), "Pream Park Bench");
        add(ModBlockRegistry.TABLE_PREAM.get(), "Pream Table");

        add(ModBlockRegistry.SCHOOL_DESK_EBONY.get(), "Ebony School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_EBONY.get(), "Ebony School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_EBONY.get(), "Ebony Desk Chair");
        add(ModBlockRegistry.LOCKER_EBONY.get(), "Ebony Locker");
        add(ModBlockRegistry.PARK_BENCH_EBONY.get(), "Ebony Park Bench");
        add(ModBlockRegistry.TABLE_EBONY.get(), "Ebony Table");

        add(ModBlockRegistry.SCHOOL_DESK_CHORUS_NEST.get(), "Chorus Nest School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_CHORUS_NEST.get(), "Chorus Nest School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_CHORUS_NEST.get(), "Chorus Nest Desk Chair");
        add(ModBlockRegistry.LOCKER_CHORUS_NEST.get(), "Chorus Nest Locker");
        add(ModBlockRegistry.PARK_BENCH_CHORUS_NEST.get(), "Chorus Nest Park Bench");
        add(ModBlockRegistry.TABLE_CHORUS_NEST.get(), "Chorus Nest Table");

        add(ModBlockRegistry.SCHOOL_DESK_BLOODSHROOM.get(), "Bloodshroom School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_BLOODSHROOM.get(), "Bloodshroom School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_BLOODSHROOM.get(), "Bloodshroom Desk Chair");
        add(ModBlockRegistry.LOCKER_BLOODSHROOM.get(), "Bloodshroom Locker");
        add(ModBlockRegistry.PARK_BENCH_BLOODSHROOM.get(), "Bloodshroom Park Bench");
        add(ModBlockRegistry.TABLE_BLOODSHROOM.get(), "Bloodshroom Table");

        add(ModBlockRegistry.SCHOOL_DESK_ENDERBARK.get(), "Enderbark School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_ENDERBARK.get(), "Enderbark School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_ENDERBARK.get(), "Enderbark Desk Chair");
        add(ModBlockRegistry.LOCKER_ENDERBARK.get(), "Enderbark Locker");
        add(ModBlockRegistry.PARK_BENCH_ENDERBARK.get(), "Enderbark Park Bench");
        add(ModBlockRegistry.TABLE_ENDERBARK.get(), "Enderbark Table");

        add(ModBlockRegistry.SCHOOL_DESK_GREENHEART.get(), "Greenheart School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_GREENHEART.get(), "Greenheart School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_GREENHEART.get(), "Greenheart Desk Chair");
        add(ModBlockRegistry.LOCKER_GREENHEART.get(), "Greenheart Locker");
        add(ModBlockRegistry.PARK_BENCH_GREENHEART.get(), "Greenheart Park Bench");
        add(ModBlockRegistry.TABLE_GREENHEART.get(), "Greenheart Table");

        add(ModBlockRegistry.SCHOOL_DESK_TINKER_SKYROOT.get(), "Tinker Skyroot School Desk");
        add(ModBlockRegistry.SCHOOL_DESK_CABINET_TINKER_SKYROOT.get(), "Tinker Skyroot School Desk Cabinet");
        add(ModBlockRegistry.DESK_CHAIR_TINKER_SKYROOT.get(), "Tinker Skyroot Desk Chair");
        add(ModBlockRegistry.LOCKER_TINKER_SKYROOT.get(), "Tinker Skyroot Locker");
        add(ModBlockRegistry.PARK_BENCH_TINKER_SKYROOT.get(), "Tinker Skyroot Park Bench");
        add(ModBlockRegistry.TABLE_TINKER_SKYROOT.get(), "Tinker Skyroot Table");

        add(ModBlockRegistry.BOOKCASE_OAK.get(), "Oak Bookcase");
        add(ModBlockRegistry.BOOKCASE_BIRCH.get(), "Birch Bookcase");
        add(ModBlockRegistry.BOOKCASE_SPRUCE.get(), "Spruce Bookcase");
        add(ModBlockRegistry.BOOKCASE_JUNGLE.get(), "Jungle Bookcase");
        add(ModBlockRegistry.BOOKCASE_ACACIA.get(), "Acacia Bookcase");
        add(ModBlockRegistry.BOOKCASE_DARK_OAK.get(), "Dark Oak Bookcase");
        add(ModBlockRegistry.BOOKCASE_MANGROVE.get(), "Mangrove Bookcase");
        add(ModBlockRegistry.BOOKCASE_CRIMSON.get(), "Crimson Bookcase");
        add(ModBlockRegistry.BOOKCASE_WARPED.get(), "Warped Bookcase");
        add(ModBlockRegistry.BOOKCASE_FIR.get(), "Fir Bookcase");
        add(ModBlockRegistry.BOOKCASE_REDWOOD.get(), "Redwood Bookcase");
        add(ModBlockRegistry.BOOKCASE_CHERRY.get(), "Cherry Bookcase");
        add(ModBlockRegistry.BOOKCASE_MAHOGANY.get(), "Mahogany Bookcase");
        add(ModBlockRegistry.BOOKCASE_JACARANDA.get(), "Jacaranda Bookcase");
        add(ModBlockRegistry.BOOKCASE_PALM.get(), "Palm Bookcase");
        add(ModBlockRegistry.BOOKCASE_WILLOW.get(), "Willow Bookcase");
        add(ModBlockRegistry.BOOKCASE_DEAD.get(), "Dead Bookcase");
        add(ModBlockRegistry.BOOKCASE_MAGIC.get(), "Magic Bookcase");
        add(ModBlockRegistry.BOOKCASE_UMBRAN.get(), "Umbran Bookcase");
        add(ModBlockRegistry.BOOKCASE_HELLBARK.get(), "Hellbark Bookcase");
        add(ModBlockRegistry.BOOKCASE_COCONUT.get(), "Coconut Bookcase");
        add(ModBlockRegistry.BOOKCASE_WALNUT.get(), "Walnut Bookcase");
        add(ModBlockRegistry.BOOKCASE_AZALEA.get(), "Azalea Bookcase");
        add(ModBlockRegistry.BOOKCASE_FLOWERING_AZALEA.get(), "Flowering Azalea Bookcase");
        add(ModBlockRegistry.BOOKCASE_GOLDEN_OAK.get(), "Golden Oak Bookcase");
        add(ModBlockRegistry.BOOKCASE_AETHER_SKYROOT.get(), "Aether Skyroot Bookcase");
        add(ModBlockRegistry.BOOKCASE_PREAM.get(), "Pream Bookcase");
        add(ModBlockRegistry.BOOKCASE_EBONY.get(), "Ebony Bookcase");
        add(ModBlockRegistry.BOOKCASE_CHORUS_NEST.get(), "Chorus Nest Bookcase");
        add(ModBlockRegistry.BOOKCASE_BLOODSHROOM.get(), "Bloodshroom Bookcase");
        add(ModBlockRegistry.BOOKCASE_ENDERBARK.get(), "Enderbark Bookcase");
        add(ModBlockRegistry.BOOKCASE_GREENHEART.get(), "Greenheart Bookcase");
        add(ModBlockRegistry.BOOKCASE_TINKER_SKYROOT.get(), "Tinker Skyroot Bookcase");
    }

    private void addItemGroups() {
        add("itemGroup.turtleblockacademy", "Turtle Block Academy Tab");
    }
}
