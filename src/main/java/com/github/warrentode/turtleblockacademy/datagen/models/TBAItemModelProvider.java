package com.github.warrentode.turtleblockacademy.datagen.models;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.items.TBAItems;
import com.github.warrentode.turtleblockacademy.items.food.eastereggs.EasterEggItem;
import com.github.warrentode.turtleblockacademy.items.food.eastereggs.EasterEggProperties;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
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

        blankColoredEgg(TBAItems.BOILED_EGG.get());
        blankColoredEgg(TBAItems.PEELED_EGG.get());
        // easter eggs models
        ItemStack stack = ItemStack.EMPTY;
        for (DyeColor baseEggColor : DyeColor.values()) {
            // sets up the blank colored egg result from the Easter Egg Item class
            Item eggItem = EasterEggItem.getBaseEggByColor(baseEggColor).getItem();

            // generate the blank colored egg models
            blankColoredEgg(eggItem);

            for (EasterEggProperties.Layer eggLayer: EasterEggProperties.Layer.values()) {
                for (DyeColor eggLayerColor : DyeColor.values()) {
                    // set up stamp name from the Easter Egg Properties class
                    String stampName = eggLayer.getLayerName().toLowerCase();

                    // sets up the stamped colored egg result from the Easter Egg Item class
                    Item stampedEggItem = EasterEggItem.getStampedEggByColor(eggLayer,baseEggColor, eggLayerColor).getItem();

                    // generate the stamped colored egg models
                    if (!stampName.equals("blank")) {
                        stampedColoredEgg(stampedEggItem, stampName);
                    }
                }
            }
        }
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

    private void stampedColoredEgg(Item stampedEggItem, String stampName) {
        ModelFile eggModel = new ModelFile.UncheckedModelFile(MODID + ":" + "item/template_stamped_egg");
        ResourceLocation eggTexture = new ResourceLocation(MODID, "item/egg_colored");
        ResourceLocation stampTexture = new ResourceLocation(MODID,
                "item/egg_stamp_" + stampName);

        withExistingParent(itemName(stampedEggItem), eggModel.getLocation())
                .texture("layer0", eggTexture);

        getBuilder(String.valueOf(stampedEggItem))
                .parent(eggModel)
                .texture("layer0", eggTexture)
                .texture("layer1", stampTexture);
    }

    private void blankColoredEgg(Item easterEgg) {
        ModelFile eggModel = new ModelFile.UncheckedModelFile(MODID + ":" + "item/template_colored_egg");
        ResourceLocation eggTexture = new ResourceLocation(MODID, "item/egg_colored");

        withExistingParent(itemName(easterEgg), eggModel.getLocation())
                .texture("layer0", eggTexture);

        getBuilder(String.valueOf(easterEgg)).parent(eggModel);
    }

    private void spawnEggItem(ForgeSpawnEggItem item) {
        withExistingParent(itemName(item), mcLoc("template_spawn_egg"));
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