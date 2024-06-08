package com.github.warrentode.turtleblockacademy.items.food.eastereggs;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class EasterEggItem extends ConsumableItem {
    private DyeColor color;
    private final EasterEggProperties.Layer layer;

    public EasterEggItem(DyeColor baseColor, @Nullable DyeColor layerColor, EasterEggProperties.@NotNull Layer layer, @NotNull Properties properties) {
        // base properties for the eggs
        super(properties, true, true);
        this.layer = layer.getEggLayer();
    }

    public String getEggLayerName() {
        return this.layer.getLayerName();
    }

    public DyeColor getBaseColor() {
        return getColor();
    }

    public int getBaseTint(int tintIndex) {
        if (getBaseColor() == null) {
            return 0xFFFFFF;
        }
        return getTintIndex(getBaseColor().getFireworkColor());
    }

    public DyeColor getLayerColor() {
        return getColor();
    }

    public int getLayerTint(int tintIndex) {
        if (getLayerColor() == null) {
            return 0xFFFFFF;
        }
        return getTintIndex(getLayerColor().getTextColor());
    }

    @Nullable
    public DyeColor getColor() {
        return Objects.requireNonNullElse(color, DyeColor.WHITE);
    }

    public int getTintIndex(int tintIndex) {
        DyeColor tintColor = getColor();
        if (tintColor == null) {
            return 0xF9FFFE;
        }
        else {
            return switch (tintColor) {
                case ORANGE -> 0xF9801D;
                case MAGENTA -> 0xC74EBD;
                case LIGHT_BLUE -> 0x3AB3DA;
                case YELLOW -> 0xFED83D;
                case LIME -> 0x80C71F;
                case PINK -> 0xF38BAA;
                case GRAY -> 0x474F52;
                case LIGHT_GRAY -> 0x9D9D97;
                case CYAN -> 0x169C9C;
                case PURPLE -> 0x8932B8;
                case BLUE -> 0x3C44AA;
                case BROWN -> 0x835432;
                case GREEN -> 0x5E7C16;
                case RED -> 0xB02E26;
                case BLACK -> 0x1D1D21;
                default -> 0xF9FFFE;
            };
        }
    }

    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltips, @NotNull TooltipFlag isAdvanced) {
        if (Screen.hasShiftDown()) {
            tooltips.add(Component.translatable("tooltip.turtleblockacademy.easter_egg_item_custom_tooltip"));
        }
        else {
            tooltips.add(Component.translatable("tooltip.turtleblockacademy.easter_egg_item_food_effect"));
            tooltips.add(Component.translatable("tooltips.shift.hover").withStyle(ChatFormatting.GRAY));
        }
    }
}
