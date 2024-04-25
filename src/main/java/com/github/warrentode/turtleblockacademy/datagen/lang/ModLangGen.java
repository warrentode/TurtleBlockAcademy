package com.github.warrentode.turtleblockacademy.datagen.lang;

import com.github.warrentode.turtleblockacademy.blocks.ModBlocks;
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
        fillAdvancementKeys("explore_overworld", "Grand Tour of the World", "Visit All of the Overworld Biomes");
        fillAdvancementKeys("explore_nether", "Tour in the Hot Seat", "Visit All of the Nether Biomes");
        fillAdvancementKeys("explore_end", "Final Tour Before Retirement?", "Visit All of the End Biomes");
        fillAdvancementKeys("explore_aether", "Hostile Tour of the Heavens", "Visit All of the Aether Biomes");

        fillAdvancementKeys("curios_track", "Oh, How Very Curious this Curio", "A Strange or Interesting Collectible Object Indeed");
        fillAdvancementKeys("equip_light_source", "Let There Be Light", "Equip a Light Source");
        fillAdvancementKeys("equip_wallet", "Cash on Hand", "Equip a Wallet");
        fillAdvancementKeys("equip_quiver", "An Archer's Best Friend", "Equip a Quiver");
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
        add(ModBlocks.CERTIFICATE_BLOCK.get(), "Certificate of Completion");

        add(ModBlocks.SCHOOL_DESK_OAK.get(), "Oak School Desk");
        add(ModBlocks.SCHOOL_DESK_BIRCH.get(), "Birch School Desk");
        add(ModBlocks.SCHOOL_DESK_SPRUCE.get(), "Spruce School Desk");
        add(ModBlocks.SCHOOL_DESK_JUNGLE.get(), "Jungle School Desk");
        add(ModBlocks.SCHOOL_DESK_ACACIA.get(), "Acacia School Desk");
        add(ModBlocks.SCHOOL_DESK_DARK_OAK.get(), "Dark Oak School Desk");
        add(ModBlocks.SCHOOL_DESK_MANGROVE.get(), "Mangrove School Desk");
        add(ModBlocks.SCHOOL_DESK_CRIMSON.get(), "Crimson School Desk");
        add(ModBlocks.SCHOOL_DESK_WARPED.get(), "Warped School Desk");

        add(ModBlocks.SCHOOL_DESK_CABINET_OAK.get(), "Oak School Desk Cabinet");
        add(ModBlocks.SCHOOL_DESK_CABINET_BIRCH.get(), "Birch School Desk Cabinet");
        add(ModBlocks.SCHOOL_DESK_CABINET_SPRUCE.get(), "Spruce School Desk Cabinet");
        add(ModBlocks.SCHOOL_DESK_CABINET_JUNGLE.get(), "Jungle School Desk Cabinet");
        add(ModBlocks.SCHOOL_DESK_CABINET_ACACIA.get(), "Acacia School Desk Cabinet");
        add(ModBlocks.SCHOOL_DESK_CABINET_DARK_OAK.get(), "Dark Oak School Desk Cabinet");
        add(ModBlocks.SCHOOL_DESK_CABINET_MANGROVE.get(), "Mangrove School Desk Cabinet");
        add(ModBlocks.SCHOOL_DESK_CABINET_CRIMSON.get(), "Crimson School Desk Cabinet");
        add(ModBlocks.SCHOOL_DESK_CABINET_WARPED.get(), "Warped School Desk Cabinet");

        add(ModBlocks.DESK_CHAIR_OAK.get(), "Oak Desk Chair");
        add(ModBlocks.DESK_CHAIR_BIRCH.get(), "Birch Desk Chair");
        add(ModBlocks.DESK_CHAIR_SPRUCE.get(), "Spruce Desk Chair");
        add(ModBlocks.DESK_CHAIR_JUNGLE.get(), "Jungle Desk Chair");
        add(ModBlocks.DESK_CHAIR_ACACIA.get(), "Acacia Desk Chair");
        add(ModBlocks.DESK_CHAIR_DARK_OAK.get(), "Dark Oak Desk Chair");
        add(ModBlocks.DESK_CHAIR_MANGROVE.get(), "Mangrove Desk Chair");
        add(ModBlocks.DESK_CHAIR_CRIMSON.get(), "Crimson Desk Chair");
        add(ModBlocks.DESK_CHAIR_WARPED.get(), "Warped Desk Chair");

        add(ModBlocks.LOCKER_OAK.get(), "Oak Locker");
        add(ModBlocks.LOCKER_BIRCH.get(), "Birch Locker");
        add(ModBlocks.LOCKER_SPRUCE.get(), "Spruce Locker");
        add(ModBlocks.LOCKER_JUNGLE.get(), "Jungle Locker");
        add(ModBlocks.LOCKER_ACACIA.get(), "Acacia Locker");
        add(ModBlocks.LOCKER_DARK_OAK.get(), "Dark Oak Locker");
        add(ModBlocks.LOCKER_MANGROVE.get(), "Mangrove Locker");
        add(ModBlocks.LOCKER_CRIMSON.get(), "Crimson Locker");
        add(ModBlocks.LOCKER_WARPED.get(), "Warped Locker");

        add(ModBlocks.PARK_BENCH_OAK.get(), "Oak Park Bench");
        add(ModBlocks.PARK_BENCH_BIRCH.get(), "Birch Park Bench");
        add(ModBlocks.PARK_BENCH_SPRUCE.get(), "Spruce Park Bench");
        add(ModBlocks.PARK_BENCH_JUNGLE.get(), "Jungle Park Bench");
        add(ModBlocks.PARK_BENCH_ACACIA.get(), "Acacia Park Bench");
        add(ModBlocks.PARK_BENCH_DARK_OAK.get(), "Dark Oak Park Bench");
        add(ModBlocks.PARK_BENCH_MANGROVE.get(), "Mangrove Park Bench");
        add(ModBlocks.PARK_BENCH_CRIMSON.get(), "Crimson Park Bench");
        add(ModBlocks.PARK_BENCH_WARPED.get(), "Warped Park Bench");

        add(ModBlocks.TABLE_OAK.get(), "Oak Table");
        add(ModBlocks.TABLE_BIRCH.get(), "Birch Table");
        add(ModBlocks.TABLE_SPRUCE.get(), "Spruce Table");
        add(ModBlocks.TABLE_JUNGLE.get(), "Jungle Table");
        add(ModBlocks.TABLE_ACACIA.get(), "Acacia Table");
        add(ModBlocks.TABLE_DARK_OAK.get(), "Dark Oak Table");
        add(ModBlocks.TABLE_MANGROVE.get(), "Mangrove Table");
        add(ModBlocks.TABLE_CRIMSON.get(), "Crimson Table");
        add(ModBlocks.TABLE_WARPED.get(), "Warped Table");

        add(ModBlocks.SCHOOL_DESK_FIR.get(), "Fir School Desk");
        add(ModBlocks.SCHOOL_DESK_CABINET_FIR.get(), "Fir School Desk Cabinet");
        add(ModBlocks.DESK_CHAIR_FIR.get(), "Fir Desk Chair");
        add(ModBlocks.LOCKER_FIR.get(), "Fir Locker");
        add(ModBlocks.PARK_BENCH_FIR.get(), "Fir Park Bench");
        add(ModBlocks.TABLE_FIR.get(), "Fir Table");

        add(ModBlocks.SCHOOL_DESK_REDWOOD.get(), "Redwood School Desk");
        add(ModBlocks.SCHOOL_DESK_CABINET_REDWOOD.get(), "Redwood School Desk Cabinet");
        add(ModBlocks.DESK_CHAIR_REDWOOD.get(), "Redwood Desk Chair");
        add(ModBlocks.LOCKER_REDWOOD.get(), "Redwood Locker");
        add(ModBlocks.PARK_BENCH_REDWOOD.get(), "Redwood Park Bench");
        add(ModBlocks.TABLE_REDWOOD.get(), "Redwood Table");

        add(ModBlocks.SCHOOL_DESK_CHERRY.get(), "Cherry School Desk");
        add(ModBlocks.SCHOOL_DESK_CABINET_CHERRY.get(), "Cherry School Desk Cabinet");
        add(ModBlocks.DESK_CHAIR_CHERRY.get(), "Cherry Desk Chair");
        add(ModBlocks.LOCKER_CHERRY.get(), "Cherry Locker");
        add(ModBlocks.PARK_BENCH_CHERRY.get(), "Cherry Park Bench");
        add(ModBlocks.TABLE_CHERRY.get(), "Cherry Table");

        add(ModBlocks.SCHOOL_DESK_MAHOGANY.get(), "Mahogany School Desk");
        add(ModBlocks.SCHOOL_DESK_CABINET_MAHOGANY.get(), "Mahogany School Desk Cabinet");
        add(ModBlocks.DESK_CHAIR_MAHOGANY.get(), "Mahogany Desk Chair");
        add(ModBlocks.LOCKER_MAHOGANY.get(), "Mahogany Locker");
        add(ModBlocks.PARK_BENCH_MAHOGANY.get(), "Mahogany Park Bench");
        add(ModBlocks.TABLE_MAHOGANY.get(), "Mahogany Table");

        add(ModBlocks.SCHOOL_DESK_JACARANDA.get(), "Jacaranda School Desk");
        add(ModBlocks.SCHOOL_DESK_CABINET_JACARANDA.get(), "Jacaranda School Desk Cabinet");
        add(ModBlocks.DESK_CHAIR_JACARANDA.get(), "Jacaranda Desk Chair");
        add(ModBlocks.LOCKER_JACARANDA.get(), "Jacaranda Locker");
        add(ModBlocks.PARK_BENCH_JACARANDA.get(), "Jacaranda Park Bench");
        add(ModBlocks.TABLE_JACARANDA.get(), "Jacaranda Table");

        add(ModBlocks.SCHOOL_DESK_PALM.get(), "Palm School Desk");
        add(ModBlocks.SCHOOL_DESK_CABINET_PALM.get(), "Palm School Desk Cabinet");
        add(ModBlocks.DESK_CHAIR_PALM.get(), "Palm Desk Chair");
        add(ModBlocks.LOCKER_PALM.get(), "Palm Locker");
        add(ModBlocks.PARK_BENCH_PALM.get(), "Palm Park Bench");
        add(ModBlocks.TABLE_PALM.get(), "Palm Table");

        add(ModBlocks.SCHOOL_DESK_WILLOW.get(), "Willow School Desk");
        add(ModBlocks.SCHOOL_DESK_CABINET_WILLOW.get(), "Willow School Desk Cabinet");
        add(ModBlocks.DESK_CHAIR_WILLOW.get(), "Willow Desk Chair");
        add(ModBlocks.LOCKER_WILLOW.get(), "Willow Locker");
        add(ModBlocks.PARK_BENCH_WILLOW.get(), "Willow Park Bench");
        add(ModBlocks.TABLE_WILLOW.get(), "Willow Table");

        add(ModBlocks.SCHOOL_DESK_DEAD.get(), "Dead School Desk");
        add(ModBlocks.SCHOOL_DESK_CABINET_DEAD.get(), "Dead School Desk Cabinet");
        add(ModBlocks.DESK_CHAIR_DEAD.get(), "Dead Desk Chair");
        add(ModBlocks.LOCKER_DEAD.get(), "Dead Locker");
        add(ModBlocks.PARK_BENCH_DEAD.get(), "Dead Park Bench");
        add(ModBlocks.TABLE_DEAD.get(), "Dead Table");

        add(ModBlocks.SCHOOL_DESK_MAGIC.get(), "Magic School Desk");
        add(ModBlocks.SCHOOL_DESK_CABINET_MAGIC.get(), "Magic School Desk Cabinet");
        add(ModBlocks.DESK_CHAIR_MAGIC.get(), "Magic Desk Chair");
        add(ModBlocks.LOCKER_MAGIC.get(), "Magic Locker");
        add(ModBlocks.PARK_BENCH_MAGIC.get(), "Magic Park Bench");
        add(ModBlocks.TABLE_MAGIC.get(), "Magic Table");

        add(ModBlocks.SCHOOL_DESK_UMBRAN.get(), "Umbran School Desk");
        add(ModBlocks.SCHOOL_DESK_CABINET_UMBRAN.get(), "Umbran School Desk Cabinet");
        add(ModBlocks.DESK_CHAIR_UMBRAN.get(), "Umbran Desk Chair");
        add(ModBlocks.LOCKER_UMBRAN.get(), "Umbran Locker");
        add(ModBlocks.PARK_BENCH_UMBRAN.get(), "Umbran Park Bench");
        add(ModBlocks.TABLE_UMBRAN.get(), "Umbran Table");

        add(ModBlocks.SCHOOL_DESK_HELLBARK.get(), "Hellbark School Desk");
        add(ModBlocks.SCHOOL_DESK_CABINET_HELLBARK.get(), "Hellbark School Desk Cabinet");
        add(ModBlocks.DESK_CHAIR_HELLBARK.get(), "Hellbark Desk Chair");
        add(ModBlocks.LOCKER_HELLBARK.get(), "Hellbark Locker");
        add(ModBlocks.PARK_BENCH_HELLBARK.get(), "Hellbark Park Bench");
        add(ModBlocks.TABLE_HELLBARK.get(), "Hellbark Table");
    }

    private void addItemGroups() {
        add("itemGroup.turtleblockacademy", "Turtle Block Academy Tab");
    }
}
