package com.github.warrentode.turtleblockacademy.datagen.lang;

import com.github.warrentode.turtleblockacademy.blocks.ModBlocks;
import com.github.warrentode.turtleblockacademy.util.PlayerUtil;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLangGen extends LanguageProvider {
    public ModLangGen(DataGenerator generator, String modid, String locale) {
        super(generator, modid, locale);
    }

    @Override
    protected void addTranslations() {
        addItemGroups();
        addBlocks();
        addTooltips();
        addAdvancements();
    }

    private void addAdvancements() {
        fillAdvancementKeys("root", "Turtle Block Academy", "Principal Herobrine welcomes you!");
        fillAdvancementKeys("explore_end", "Final Tour Before Retirement",
                "Visit All of the End Biomes");
    }

    private void fillAdvancementKeys(String name, String title, String subtitle) {
        add("academy.advancement." + name, title);
        add("academy.advancement." + name + ".desc", subtitle);
    }

    private void addTooltips() {
        add(ModBlocks.CERTIFICATE_BLOCK.get().getDescriptionId() + "." + PlayerUtil.PLAYER_NAME_TAG, "§cLinked player§r %s");
        fillTooltipKeys("certificate_awarded", "This certificate is awarded to:");
        fillTooltipKeys("certificate_blank", "Certificates are awarded upon completion of academy tasks");
    }

    private void fillTooltipKeys(String key, String name) {
        add("tooltips.turtleblockacademy." + key, name);
    }

    private void addBlocks() {
        add(ModBlocks.CERTIFICATE_BLOCK.get(), "Certificate of Completion");
    }

    private void addItemGroups() {
        add("itemGroup.turtleblockacademy", "Turtle Block Academy Tab");
    }
}
