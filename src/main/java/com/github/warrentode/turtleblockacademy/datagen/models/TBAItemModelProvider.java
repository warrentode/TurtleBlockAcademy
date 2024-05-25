package com.github.warrentode.turtleblockacademy.datagen.models;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.items.TBAItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TBAItemModelProvider extends ItemModelProvider {
    public TBAItemModelProvider(DataGenerator generator, String modid, ExistingFileHelper helper) {
        super(generator, modid, helper);
    }

    @Override
    protected void registerModels() {
        basicItem(TBAItems.STUDENT_CARD.get());

        basicItem(TBAItems.BEET_WINE.get());
        basicItem(TBAItems.VINEGAR_BOTTLE.get());
        basicItem(TBAItems.BEET_RISOTTO.get());
        basicItem(TBAItems.BEET_SALAD.get());
        basicItem(TBAItems.BEET_PICKLES.get());

        basicItem(TBAItems.CLOVES.get());
        basicItem(TBAItems.CLOVE_SEEDS.get());
        basicItem(TBAItems.DRIED_CLOVES.get());
        basicItem(TBAItems.GROUND_CLOVES.get());
        basicItem(TBAItems.PICKLING_SALT.get());
        basicItem(TBAItems.WHEAT_FLOUR.get());
        basicItem(TBAItems.YEAST.get());
        basicItem(TBAItems.HARD_APPLE_CIDER.get());

        blockBasedModel(TBABlocks.CERTIFICATE_BLOCK.get().asItem());
        blockBasedModel(TBABlocks.FERMENTING_POT_BLOCK.get().asItem());
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
