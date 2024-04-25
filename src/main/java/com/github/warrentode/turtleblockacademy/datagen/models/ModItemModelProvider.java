package com.github.warrentode.turtleblockacademy.datagen.models;

import com.github.warrentode.turtleblockacademy.blocks.ModBlocks;
import com.github.warrentode.turtleblockacademy.items.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, String modid, ExistingFileHelper helper) {
        super(generator, modid, helper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.STUDENT_CARD.get());

        blockBasedModel(ModBlocks.CERTIFICATE_BLOCK.get().asItem());

        ModelFile plateModel = new ModelFile.UncheckedModelFile(modLoc("item/plate"));

        customItem(ModItems.PLATE_ITEM.get().getDefaultInstance(), plateModel,
                "minecraft", "block/chiseled_quartz_block",
                "minecraft", "block/quartz_block_bottom",
                "minecraft", "block/quartz_pillar_top");

        customItem(ModItems.PLATE_WHITE.get().getDefaultInstance(), plateModel,
                MODID, "item/plate_white_glazed",
                MODID, "item/plate_white_glazed",
                MODID, "item/plate_white_glazed");
    }

    public void customItem(@NotNull ItemStack result, ModelFile parent, String modid_1, String path_1,
                           String modid_2, String path_2, String modid_3, String path_3) {

        getBuilder(result.getItem().toString()).parent(parent)
                .texture("1", new ResourceLocation(modid_1, path_1))
                .texture("2", new ResourceLocation(modid_2, path_2))
                .texture("3", new ResourceLocation(modid_3, path_3));
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
