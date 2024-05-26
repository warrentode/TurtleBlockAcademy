package com.github.warrentode.turtleblockacademy.datagen.models;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.items.TBAItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
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
    protected static final ExistingFileHelper.ResourceType TEXTURE
            = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES,
            ".png", "textures");
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

        blankEasterEgg(TBAItems.COLORED_EGG_BLANK_WHITE.get());
        blankEasterEgg(TBAItems.COLORED_EGG_BLANK_ORANGE.get());
        blankEasterEgg(TBAItems.COLORED_EGG_BLANK_RED.get());
        blankEasterEgg(TBAItems.COLORED_EGG_BLANK_MAGENTA.get());
        blankEasterEgg(TBAItems.COLORED_EGG_BLANK_LIGHT_BLUE.get());
        blankEasterEgg(TBAItems.COLORED_EGG_BLANK_YELLOW.get());
        blankEasterEgg(TBAItems.COLORED_EGG_BLANK_LIME.get());
        blankEasterEgg(TBAItems.COLORED_EGG_BLANK_PINK.get());
        blankEasterEgg(TBAItems.COLORED_EGG_BLANK_GRAY.get());
        blankEasterEgg(TBAItems.COLORED_EGG_BLANK_LIGHT_GRAY.get());
        blankEasterEgg(TBAItems.COLORED_EGG_BLANK_CYAN.get());
        blankEasterEgg(TBAItems.COLORED_EGG_BLANK_PURPLE.get());
        blankEasterEgg(TBAItems.COLORED_EGG_BLANK_BLUE.get());
        blankEasterEgg(TBAItems.COLORED_EGG_BLANK_BROWN.get());
        blankEasterEgg(TBAItems.COLORED_EGG_BLANK_GREEN.get());
        blankEasterEgg(TBAItems.COLORED_EGG_BLANK_BLACK.get());
    }

    private void spawnEggItem(ForgeSpawnEggItem item) {
        withExistingParent(String.valueOf(item), mcLoc("template_spawn_egg"));
    }

    private void blankEasterEgg(Item easterEgg) {
        ModelFile blankEasterEggModel = new ModelFile.UncheckedModelFile(MODID + ":" + "item/template_colored_egg_blank");
        ResourceLocation coloredEggTexture = new ResourceLocation(MODID, "item/colored_egg");
        ResourceLocation blankOverlayTexture = new ResourceLocation(MODID, "item/colored_egg_blank_overlay");
        this.helper.trackGenerated(coloredEggTexture, TEXTURE);
        this.helper.trackGenerated(blankOverlayTexture, TEXTURE);

        withExistingParent(itemName(easterEgg), blankEasterEggModel.getLocation())
                .texture("0", coloredEggTexture)
                .texture("1", blankOverlayTexture);

        getBuilder(String.valueOf(easterEgg))
                .parent(blankEasterEggModel)
                .texture("0", coloredEggTexture)
                .texture("1", blankOverlayTexture);
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
