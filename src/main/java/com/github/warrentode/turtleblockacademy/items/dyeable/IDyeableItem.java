package com.github.warrentode.turtleblockacademy.items.dyeable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;

public interface IDyeableItem {
    static ItemStack getInstance() {
        return ItemStack.EMPTY;
    }

    ItemStack dyeableInstance = getInstance();

    String TAG_COLOR = "color";
    String TAG_DISPLAY = "display";
    int DEFAULT_ITEM_COLOR = 16383998;

    default boolean hasCustomColor(@NotNull ItemStack stack) {
        CompoundTag tag = stack.getTagElement(TAG_DISPLAY);
        return tag != null && tag.contains(TAG_COLOR, 99);
    }

    default int getColor(@NotNull ItemStack stack) {
        CompoundTag tag = stack.getTagElement(TAG_DISPLAY);
        return tag != null && tag.contains(TAG_COLOR, 99)
                ? tag.getInt(TAG_COLOR) : DEFAULT_ITEM_COLOR;
    }

    //** TODO: set-up recipes types that call up the clearColor and dyeItem methods for the EasterEggItems
    //** Also need to make sure these items get their color handlers, model layers, and textures get setup
    // correctly - at this point I think I need to also take the time to set up the creative mode tab
    // properly too before it gets out of control - this mod project is already becoming as big of a has to
    // manage, plan, and learn for as the TodeCoins mod is, and what is more troubling is how much new stuff
    // I have had to learn in such a short span of time to get this much done for this

    static void clearColor(@NotNull ItemStack stack) {
        CompoundTag tag = stack.getTagElement(TAG_DISPLAY);
        if (tag != null && tag.contains(TAG_COLOR)) {
            tag.remove(TAG_COLOR);
        }
    }

    static void setColor(@NotNull ItemStack stack, int color) {
        stack.getOrCreateTagElement(TAG_DISPLAY).putInt(TAG_COLOR, color);
    }

    static ItemStack dyeItem(@NotNull ItemStack stack, List<DyeItem> dyeItems) {
        ItemStack itemstack = ItemStack.EMPTY;
        int[] TextureLayer = new int[3];
        int i = 0;
        int j = 0;
        Item item = stack.getItem();
        int j1;
        float f3;
        int i1;

        if (item instanceof IDyeableItem dyeableItem) {
            itemstack = stack.copy();
            itemstack.setCount(1);
            if (dyeableItem.hasCustomColor(stack)) {
                j1 = dyeableItem.getColor(itemstack);
                float f = (float) (j1 >> 16 & 255) / 255.0F;
                float f1 = (float) (j1 >> 8 & 255) / 255.0F;
                f3 = (float) (j1 & 255) / 255.0F;
                i += (int) (Math.max(f, Math.max(f1, f3)) * 255.0F);
                TextureLayer[0] += (int) (f * 255.0F);
                TextureLayer[1] += (int) (f1 * 255.0F);
                TextureLayer[2] += (int) (f3 * 255.0F);
                ++j;
            }

            for (Iterator<DyeItem> hasNext = dyeItems.iterator(); hasNext.hasNext(); ++j) {
                DyeItem dyeitem = hasNext.next();
                float[] afloat = dyeitem.getDyeColor().getTextureDiffuseColors();
                int i2 = (int) (afloat[0] * 255.0F);
                int l = (int) (afloat[1] * 255.0F);
                i1 = (int) (afloat[2] * 255.0F);
                i += Math.max(i2, Math.max(l, i1));
                TextureLayer[0] += i2;
                TextureLayer[1] += l;
                TextureLayer[2] += i1;
            }
        }

        if (dyeableInstance == null) {
            return ItemStack.EMPTY;
        }
        else {
            j1 = TextureLayer[0] / j;
            int k1 = TextureLayer[1] / j;
            int l1 = TextureLayer[2] / j;
            f3 = (float) i / (float) j;
            float f4 = (float) Math.max(j1, Math.max(k1, l1));
            j1 = (int) ((float) j1 * f3 / f4);
            k1 = (int) ((float) k1 * f3 / f4);
            l1 = (int) ((float) l1 * f3 / f4);
            i1 = (j1 << 8) + k1;
            i1 = (i1 << 8) + l1;

            setColor(itemstack, i1);
            return itemstack;
        }
    }
}