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
    }

    private void addContainers() {
        add("container.turtleblockacademy.desk", "School Desk");
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
    }

    private void addItemGroups() {
        add("itemGroup.turtleblockacademy", "Turtle Block Academy Tab");
    }
}
