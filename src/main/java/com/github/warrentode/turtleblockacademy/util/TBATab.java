package com.github.warrentode.turtleblockacademy.util;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.blocks.furniture.PlateBlock;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class TBATab extends CreativeModeTab {
    public static final TBATab TAB = new TBATab("turtleblockacademy");

    public TBATab(String label) {
        super(label);
    }

    public @NotNull ItemStack makeIcon() {
        return TBABlocks.CERTIFICATE_BLOCK.get().asItem().getDefaultInstance();
    }

    @Override
    public void fillItemList(@NotNull NonNullList<ItemStack> list) {
        // create item lists by type
        List<Item> academyItems = new ArrayList<>();
        List<Item> bookItems = new ArrayList<>();
        List<Item> workstations = new ArrayList<>();
        List<Item> eggStamps = new ArrayList<>();
        List<Item> edibles = new ArrayList<>();
        List<Item> seedItems = new ArrayList<>();
        List<Item> ingredients = new ArrayList<>();
        List<Item> crops = new ArrayList<>();
        List<Item> desks = new ArrayList<>();
        List<Item> deskCabinets = new ArrayList<>();
        List<Item> tables = new ArrayList<>();
        List<Item> chairs = new ArrayList<>();
        List<Item> benches = new ArrayList<>();
        List<Item> lockers = new ArrayList<>();
        List<Item> bookcases = new ArrayList<>();
        List<Item> plates = new ArrayList<>();
        List<Item> baskets = new ArrayList<>();
        List<Item> easterEggs = new ArrayList<>();
        List<Item> spawnEggs = new ArrayList<>();
        List<Item> other = new ArrayList<>();

        // Collect all items and populate lists based on type
        for (Item item : ForgeRegistries.ITEMS) {
            String itemType = getItemType(item);
            switch (itemType) {
                case "academy_supplies":
                    academyItems.add(item);
                    break;
                case "workstations":
                    workstations.add(item);
                    break;
                case "lectern_books":
                    bookItems.add(item);
                    break;
                case "easter_eggs":
                    easterEggs.add(item);
                    break;
                case "edibles":
                    edibles.add(item);
                    break;
                case "seeds":
                    seedItems.add(item);
                    break;
                case "ingredients":
                    ingredients.add(item);
                    break;
                case "crops":
                    crops.add(item);
                    break;
                case "desks":
                    desks.add(item);
                    break;
                case "desk_cabinets":
                    deskCabinets.add(item);
                    break;
                case "tables":
                    tables.add(item);
                    break;
                case "chairs":
                    chairs.add(item);
                    break;
                case "benches":
                    benches.add(item);
                    break;
                case "lockers":
                    lockers.add(item);
                    break;
                case "bookcases":
                    bookcases.add(item);
                    break;
                case "plates":
                    plates.add(item);
                    break;
                case "baskets":
                    baskets.add(item);
                    break;
                case "egg_stamps":
                    eggStamps.add(item);
                    break;
                case "spawn_eggs":
                    spawnEggs.add(item);
                    break;
                default: other.add(item);
            }
        }

        // Add each list to the creative tab
        for (Item item : academyItems) {
            item.fillItemCategory(this, list);
        }
        for (Item item : bookItems) {
            item.fillItemCategory(this, list);
        }
        for (Item item : workstations) {
            item.fillItemCategory(this, list);
        }
        for (Item item : eggStamps) {
            item.fillItemCategory(this, list);
        }
        for (Item item : edibles) {
            item.fillItemCategory(this, list);
        }
        for (Item item : seedItems) {
            item.fillItemCategory(this, list);
        }
        for (Item item : ingredients) {
            item.fillItemCategory(this, list);
        }
        for (Item item : crops) {
            item.fillItemCategory(this, list);
        }
        for (Item item : desks) {
            item.fillItemCategory(this, list);
        }
        for (Item item : deskCabinets) {
            item.fillItemCategory(this, list);
        }
        for (Item item : tables) {
            item.fillItemCategory(this, list);
        }
        for (Item item : chairs) {
            item.fillItemCategory(this, list);
        }
        for (Item item : benches) {
            item.fillItemCategory(this, list);
        }
        for (Item item : lockers) {
            item.fillItemCategory(this, list);
        }
        for (Item item : bookcases) {
            item.fillItemCategory(this, list);
        }
        for (Item item : plates) {
            item.fillItemCategory(this, list);
        }
        for (Item item : baskets) {
            item.fillItemCategory(this, list);
        }
        for (Item item : easterEggs) {
            item.fillItemCategory(this, list);
        }
        for (Item item : spawnEggs) {
            item.fillItemCategory(this, list);
        }
        for (Item item : other) {
            item.fillItemCategory(this, list);
        }
    }

    // custom method to get the type of the item being passed through
    private @NotNull String getItemType(@NotNull Item item) {
        if (item.getDefaultInstance().is(TBATags.Items.ACADEMY_SUPPLIES)) {
            return "academy_supplies";
        }
        // textbooks and guides
        else if (item.getDefaultInstance().is(TBATags.Items.LECTERN_BOOKS)) {
            return "lectern_books";
        }
        // edibles
        else if (item.getDefaultInstance().isEdible()) {
            return "edibles";
        }
        // seeds
        else if (item.getDefaultInstance().is(TBATags.Items.SEEDS)) {
            return "seeds";
        }
        // ingredients
        else if (item.getDefaultInstance().is(TBATags.Items.INGREDIENTS)) {
            return "ingredients";
        }
        // block items
        else if (item instanceof BlockItem blockItem) {
            // workstations
            if (blockItem.getBlock().defaultBlockState().is(TBABlocks.FERMENTING_POT_BLOCK.get())) {
                return "workstations";
            }
            // furniture
            else if (blockItem.getBlock().defaultBlockState().is(TBATags.Blocks.DESKS)) {
                return "desks";
            }
            else if (blockItem.getBlock().defaultBlockState().is(TBATags.Blocks.DESK_CABINETS)) {
                return "desk_cabinets";
            }
            else if (blockItem.getBlock().defaultBlockState().is(TBATags.Blocks.TABLES)) {
                return "tables";
            }
            else if (blockItem.getBlock().defaultBlockState().is(TBATags.Blocks.CHAIRS)) {
                return "chairs";
            }
            else if (blockItem.getBlock().defaultBlockState().is(TBATags.Blocks.BENCHES)) {
                return "benches";
            }
            else if (blockItem.getBlock().defaultBlockState().is(TBATags.Blocks.LOCKERS)) {
                return "lockers";
            }
            else if (blockItem.getBlock().defaultBlockState().is(TBATags.Blocks.BOOKCASES)) {
                return "bookcases";
            }
            else if (blockItem.getBlock() instanceof PlateBlock) {
                return "plates";
            }
            else if (blockItem.getBlock().defaultBlockState().is(TBATags.Blocks.BASKETS)) {
                return "baskets";
            }
            // crops
            else if (blockItem instanceof BonemealableBlock) {
                return "crops";
            }
        }
        // egg stamps
        else if (item.getDefaultInstance().is(TBATags.Items.EGG_STAMPS)) {
            return "egg_stamps";
        }
        // easter eggs
        else if (item.getDefaultInstance().is(TBATags.Items.EASTER_EGGS)) {
            return "easter_eggs";
        }
        // specify spawn eggs last
        else if (item instanceof ForgeSpawnEggItem) {
            return "spawn_eggs";
        }
        // add anything remaining to the end - can also add additional type checks as needed
        return "other";
    }

    private @NotNull String getItemName(Item item) {
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
    }

    private @NotNull String getItemResource(Item item) {
        String nameSpace = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getNamespace();
        String path = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();

        return nameSpace + ":" + path;
    }
}