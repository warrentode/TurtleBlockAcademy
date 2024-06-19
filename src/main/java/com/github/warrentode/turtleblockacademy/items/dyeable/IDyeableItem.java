package com.github.warrentode.turtleblockacademy.items.dyeable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;

// modified version of the vanilla DyeableLeatherItem class
public interface IDyeableItem {
    static ItemStack getInstance() {
        return dyeableInstance;
    }

    ItemStack dyeableInstance = getInstance();

    String TAG_COLOR = "color";
    String TAG_DISPLAY = "display";
    int DEFAULT_ITEM_COLOR = 16383998;

    default boolean hasCustomColor(@NotNull ItemStack customStack) {
        CompoundTag tag = customStack.getTagElement(TAG_DISPLAY);
        return tag != null && tag.contains(TAG_COLOR, 99);
    }

    default int getColor(@NotNull ItemStack stack) {
        CompoundTag tag = stack.getTagElement(TAG_DISPLAY);
        return tag != null && tag.contains(TAG_COLOR, 99)
                ? tag.getInt(TAG_COLOR) : DEFAULT_ITEM_COLOR;
    }

    default void clearColor(@NotNull ItemStack clearedStack) {
        CompoundTag tag = clearedStack.getTagElement(TAG_DISPLAY);
        if (tag != null && tag.contains(TAG_COLOR)) {
            tag.remove(TAG_COLOR);
        }
    }

    default int getTintIndex(int tintIndex) {
        if (tintIndex == 0) {
            return 0xFFFFFF;
        }
        return tintIndex;
    }

    static void setColor(@NotNull ItemStack coloredStack, int color) {
        coloredStack.getOrCreateTagElement(TAG_DISPLAY).putInt(TAG_COLOR, color);
    }

    static ItemStack dyeItem(@NotNull ItemStack stack, List<DyeItem> dyeItems) {
        //**used to accumulate the color components (RGB) of the itemStack.*//
        int[] intArray = new int[3];

        ItemStack dyedStack = ItemStack.EMPTY;
        Item item = stack.getItem();

        /** j1, f3, and i1: These variables are used to hold the color components from the itemStack's
         * existing color (if dyed already) and the color of the dyes being applied. */

        /** i, and j: are counters used to keep track of the total color values and the number of dyes applied */

        /** After applying all dyes, the method calculates the average color by dividing each component
         * sum in the intArray by the number of dyes applied (j) - this is what creates the final color value **/

        int i = 0; // total color value from the dye
        int j = 0; // total dye items added
        int j1;
        int i1;
        float f3;

        /*
        int[0]: RED CHANNEL in RGBA
        int[1]: GREEN CHANNEL in RGBA
        int[2]: BLUE CHANNEL in RGBA
        255.0F value is the alpha value for each color channel
        */

        if (item instanceof IDyeableItem dyeableItem) {
            dyedStack = stack.copy();
            dyedStack.setCount(1);
            if (dyeableItem.hasCustomColor(stack)) {
                j1 = dyeableItem.getColor(dyedStack);

                float f = (float) (j1 >> 16 & 255) / 255.0F;
                float f1 = (float) (j1 >> 8 & 255) / 255.0F;
                f3 = (float) (j1 & 255) / 255.0F;
                i += (int) (Math.max(f, Math.max(f1, f3)) * 255.0F);
                intArray[0] += (int) (f * 255.0F);
                intArray[1] += (int) (f1 * 255.0F);
                intArray[2] += (int) (f3 * 255.0F);
                ++j;
            }

            for (Iterator<DyeItem> hasNext = dyeItems.iterator(); hasNext.hasNext(); ++j) {
                DyeItem next = hasNext.next();
                float[] textureDiffuseColors = next.getDyeColor().getTextureDiffuseColors();
                int i2 = (int) (textureDiffuseColors[0] * 255.0F);
                int l = (int) (textureDiffuseColors[1] * 255.0F);
                i1 = (int) (textureDiffuseColors[2] * 255.0F);
                i += Math.max(i2, Math.max(l, i1));
                intArray[0] += i2;
                intArray[1] += l;
                intArray[2] += i1;
            }
        }

        if (dyeableInstance == null) {
            return ItemStack.EMPTY;
        }

        else {
            j1 = intArray[0] / j;
            int k1 = intArray[1] / j;
            int l1 = intArray[2] / j;
            f3 = (float) i / (float) j;
            float max = (float) Math.max(j1, Math.max(k1, l1));
            j1 = (int) ((float) j1 * f3 / max);
            k1 = (int) ((float) k1 * f3 / max);
            l1 = (int) ((float) l1 * f3 / max);
            i1 = (j1 << 8) + k1;
            i1 = (i1 << 8) + l1;

            setColor(dyedStack, i1);
            return dyedStack;
        }
    }

    // all of this is why the leather armor, for example, can end up with such wide varieties of color
}