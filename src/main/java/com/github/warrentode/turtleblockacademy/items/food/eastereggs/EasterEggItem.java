package com.github.warrentode.turtleblockacademy.items.food.eastereggs;

import com.github.warrentode.turtleblockacademy.items.TBAItems;
import com.github.warrentode.turtleblockacademy.util.LogUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class EasterEggItem extends Item {
    public static final List<EasterEggItem> EASTER_EGGS = new ArrayList<>();
    private final DyeColor baseColor;
    private final DyeColor layerColor;
    private final EasterEggProperties.Layer layer;
    private final EasterEggItem easterEggItem;

    public EasterEggItem(DyeColor baseColor, @Nullable DyeColor layerColor, EasterEggProperties.@NotNull Layer layer, @NotNull Properties properties) {
        // base properties for the eggs
        super(properties);
        this.layer = layer.getEggLayer();
        this.baseColor = baseColor;
        this.layerColor = layerColor;
        this.easterEggItem = this;

        EASTER_EGGS.add(this);
    }

    public String getEggLayerName() {
        return this.layer.getLayerName();
    }

    public DyeColor getBaseColor(DyeColor color) {
        return this.baseColor;
    }

    public DyeColor getLayerColor(DyeColor color) {
        return this.layerColor;
    }

    public static @NotNull ItemStack getBaseEggByColor(@Nullable DyeColor color) {
        if (color == null) {
            return TBAItems.COLORED_EGG_WHITE.get().getDefaultInstance();
        }
        else {
            return switch (color) {
                case ORANGE -> TBAItems.COLORED_EGG_ORANGE.get().getDefaultInstance();
                case MAGENTA -> TBAItems.COLORED_EGG_MAGENTA.get().getDefaultInstance();
                case LIGHT_BLUE -> TBAItems.COLORED_EGG_LIGHT_BLUE.get().getDefaultInstance();
                case YELLOW -> TBAItems.COLORED_EGG_YELLOW.get().getDefaultInstance();
                case LIME -> TBAItems.COLORED_EGG_LIME.get().getDefaultInstance();
                case PINK -> TBAItems.COLORED_EGG_PINK.get().getDefaultInstance();
                case GRAY -> TBAItems.COLORED_EGG_GRAY.get().getDefaultInstance();
                case LIGHT_GRAY -> TBAItems.COLORED_EGG_LIGHT_GRAY.get().getDefaultInstance();
                case CYAN -> TBAItems.COLORED_EGG_CYAN.get().getDefaultInstance();
                case PURPLE -> TBAItems.COLORED_EGG_PURPLE.get().getDefaultInstance();
                case BLUE -> TBAItems.COLORED_EGG_BLUE.get().getDefaultInstance();
                case BROWN -> TBAItems.COLORED_EGG_BROWN.get().getDefaultInstance();
                case GREEN -> TBAItems.COLORED_EGG_GREEN.get().getDefaultInstance();
                case RED -> TBAItems.COLORED_EGG_RED.get().getDefaultInstance();
                case BLACK -> TBAItems.COLORED_EGG_BLACK.get().getDefaultInstance();
                default -> TBAItems.COLORED_EGG_WHITE.get().getDefaultInstance();
            };
        }
    }

    public static @NotNull ItemStack getStampedEggByColor(EasterEggProperties.Layer layer, @Nullable DyeColor baseColor, DyeColor layerColor) {
        if (layer == null) {
            LogUtil.error("Easter Egg layer needs to be defined.");
            return TBAItems.COLORED_EGG_WHITE.get().getDefaultInstance();
        }
        if (baseColor == null) {
            LogUtil.error("Easter Egg base color needs to be defined.");
            return TBAItems.COLORED_EGG_WHITE.get().getDefaultInstance();
        }
        if (layerColor == null) {
            LogUtil.error("Easter Egg layer color needs to be defined.");
            return TBAItems.COLORED_EGG_WHITE.get().getDefaultInstance();
        }
        else if (baseColor == DyeColor.ORANGE) {
            if (layer == EasterEggProperties.Layer.CREEPER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_ORANGE_CREEPER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_ORANGE_CREEPER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_ORANGE_CREEPER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_ORANGE_CREEPER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_ORANGE_CREEPER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_ORANGE_CREEPER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_ORANGE_CREEPER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_ORANGE_CREEPER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_ORANGE_CREEPER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_ORANGE_CREEPER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_ORANGE_CREEPER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_ORANGE_CREEPER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_ORANGE_CREEPER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_ORANGE_CREEPER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_ORANGE_CREEPER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_ORANGE_CREEPER_WHITE.get().getDefaultInstance();
                };
            }
            else if (layer == EasterEggProperties.Layer.FLOWER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_ORANGE_FLOWER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_ORANGE_FLOWER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_ORANGE_FLOWER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_ORANGE_FLOWER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_ORANGE_FLOWER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_ORANGE_FLOWER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_ORANGE_FLOWER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_ORANGE_FLOWER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_ORANGE_FLOWER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_ORANGE_FLOWER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_ORANGE_FLOWER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_ORANGE_FLOWER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_ORANGE_FLOWER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_ORANGE_FLOWER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_ORANGE_FLOWER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_ORANGE_FLOWER_WHITE.get().getDefaultInstance();
                };
            }
        }
        else if (baseColor == DyeColor.MAGENTA) {
            if (layer == EasterEggProperties.Layer.CREEPER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_MAGENTA_CREEPER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_MAGENTA_CREEPER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_MAGENTA_CREEPER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_MAGENTA_CREEPER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_MAGENTA_CREEPER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_MAGENTA_CREEPER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_MAGENTA_CREEPER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_MAGENTA_CREEPER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_MAGENTA_CREEPER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_MAGENTA_CREEPER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_MAGENTA_CREEPER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_MAGENTA_CREEPER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_MAGENTA_CREEPER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_MAGENTA_CREEPER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_MAGENTA_CREEPER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_MAGENTA_CREEPER_WHITE.get().getDefaultInstance();
                };
            }
            else if (layer == EasterEggProperties.Layer.FLOWER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_MAGENTA_FLOWER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_MAGENTA_FLOWER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_MAGENTA_FLOWER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_MAGENTA_FLOWER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_MAGENTA_FLOWER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_MAGENTA_FLOWER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_MAGENTA_FLOWER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_MAGENTA_FLOWER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_MAGENTA_FLOWER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_MAGENTA_FLOWER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_MAGENTA_FLOWER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_MAGENTA_FLOWER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_MAGENTA_FLOWER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_MAGENTA_FLOWER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_MAGENTA_FLOWER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_MAGENTA_FLOWER_WHITE.get().getDefaultInstance();
                };
            }
        }
        else if (baseColor == DyeColor.LIGHT_BLUE) {
            if (layer == EasterEggProperties.Layer.CREEPER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_LIGHT_BLUE_CREEPER_WHITE.get().getDefaultInstance();
                };
            }
            else if (layer == EasterEggProperties.Layer.FLOWER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_LIGHT_BLUE_FLOWER_WHITE.get().getDefaultInstance();
                };
            }
        }
        else if (baseColor == DyeColor.YELLOW) {
            if (layer == EasterEggProperties.Layer.CREEPER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_YELLOW_CREEPER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_YELLOW_CREEPER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_YELLOW_CREEPER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_YELLOW_CREEPER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_YELLOW_CREEPER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_YELLOW_CREEPER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_YELLOW_CREEPER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_YELLOW_CREEPER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_YELLOW_CREEPER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_YELLOW_CREEPER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_YELLOW_CREEPER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_YELLOW_CREEPER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_YELLOW_CREEPER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_YELLOW_CREEPER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_YELLOW_CREEPER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_YELLOW_CREEPER_WHITE.get().getDefaultInstance();
                };
            }
            else if (layer == EasterEggProperties.Layer.FLOWER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_YELLOW_FLOWER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_YELLOW_FLOWER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_YELLOW_FLOWER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_YELLOW_FLOWER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_YELLOW_FLOWER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_YELLOW_FLOWER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_YELLOW_FLOWER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_YELLOW_FLOWER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_YELLOW_FLOWER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_YELLOW_FLOWER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_YELLOW_FLOWER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_YELLOW_FLOWER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_YELLOW_FLOWER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_YELLOW_FLOWER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_YELLOW_FLOWER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_YELLOW_FLOWER_WHITE.get().getDefaultInstance();
                };
            }
        }
        else if (baseColor == DyeColor.LIME) {
            if (layer == EasterEggProperties.Layer.CREEPER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_LIME_CREEPER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_LIME_CREEPER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_LIME_CREEPER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_LIME_CREEPER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_LIME_CREEPER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_LIME_CREEPER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_LIME_CREEPER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_LIME_CREEPER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_LIME_CREEPER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_LIME_CREEPER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_LIME_CREEPER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_LIME_CREEPER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_LIME_CREEPER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_LIME_CREEPER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_LIME_CREEPER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_LIME_CREEPER_WHITE.get().getDefaultInstance();
                };
            }
            else if (layer == EasterEggProperties.Layer.FLOWER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_LIME_FLOWER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_LIME_FLOWER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_LIME_FLOWER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_LIME_FLOWER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_LIME_FLOWER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_LIME_FLOWER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_LIME_FLOWER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_LIME_FLOWER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_LIME_FLOWER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_LIME_FLOWER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_LIME_FLOWER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_LIME_FLOWER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_LIME_FLOWER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_LIME_FLOWER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_LIME_FLOWER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_LIME_FLOWER_WHITE.get().getDefaultInstance();
                };
            }
        }
        else if (baseColor == DyeColor.PINK) {
            if (layer == EasterEggProperties.Layer.CREEPER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_PINK_CREEPER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_PINK_CREEPER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_PINK_CREEPER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_PINK_CREEPER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_PINK_CREEPER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_PINK_CREEPER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_PINK_CREEPER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_PINK_CREEPER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_PINK_CREEPER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_PINK_CREEPER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_PINK_CREEPER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_PINK_CREEPER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_PINK_CREEPER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_PINK_CREEPER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_PINK_CREEPER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_PINK_CREEPER_WHITE.get().getDefaultInstance();
                };
            }
            else if (layer == EasterEggProperties.Layer.FLOWER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_PINK_FLOWER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_PINK_FLOWER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_PINK_FLOWER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_PINK_FLOWER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_PINK_FLOWER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_PINK_FLOWER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_PINK_FLOWER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_PINK_FLOWER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_PINK_FLOWER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_PINK_FLOWER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_PINK_FLOWER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_PINK_FLOWER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_PINK_FLOWER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_PINK_FLOWER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_PINK_FLOWER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_PINK_FLOWER_WHITE.get().getDefaultInstance();
                };
            }
        }
        else if (baseColor == DyeColor.GRAY) {
            if (layer == EasterEggProperties.Layer.CREEPER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_GRAY_CREEPER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_GRAY_CREEPER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_GRAY_CREEPER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_GRAY_CREEPER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_GRAY_CREEPER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_GRAY_CREEPER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_GRAY_CREEPER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_GRAY_CREEPER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_GRAY_CREEPER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_GRAY_CREEPER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_GRAY_CREEPER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_GRAY_CREEPER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_GRAY_CREEPER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_GRAY_CREEPER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_GRAY_CREEPER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_GRAY_CREEPER_WHITE.get().getDefaultInstance();
                };
            }
            else if (layer == EasterEggProperties.Layer.FLOWER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_GRAY_FLOWER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_GRAY_FLOWER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_GRAY_FLOWER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_GRAY_FLOWER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_GRAY_FLOWER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_GRAY_FLOWER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_GRAY_FLOWER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_GRAY_FLOWER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_GRAY_FLOWER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_GRAY_FLOWER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_GRAY_FLOWER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_GRAY_FLOWER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_GRAY_FLOWER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_GRAY_FLOWER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_GRAY_FLOWER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_GRAY_FLOWER_WHITE.get().getDefaultInstance();
                };
            }
        }
        else if (baseColor == DyeColor.LIGHT_GRAY) {
            if (layer == EasterEggProperties.Layer.CREEPER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_LIGHT_GRAY_CREEPER_WHITE.get().getDefaultInstance();
                };
            }
            else if (layer == EasterEggProperties.Layer.FLOWER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_LIGHT_GRAY_FLOWER_WHITE.get().getDefaultInstance();
                };
            }
        }
        else if (baseColor == DyeColor.CYAN) {
            if (layer == EasterEggProperties.Layer.CREEPER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_CYAN_CREEPER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_CYAN_CREEPER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_CYAN_CREEPER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_CYAN_CREEPER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_CYAN_CREEPER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_CYAN_CREEPER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_CYAN_CREEPER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_CYAN_CREEPER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_CYAN_CREEPER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_CYAN_CREEPER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_CYAN_CREEPER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_CYAN_CREEPER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_CYAN_CREEPER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_CYAN_CREEPER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_CYAN_CREEPER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_CYAN_CREEPER_WHITE.get().getDefaultInstance();
                };
            }
            else if (layer == EasterEggProperties.Layer.FLOWER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_CYAN_FLOWER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_CYAN_FLOWER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_CYAN_FLOWER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_CYAN_FLOWER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_CYAN_FLOWER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_CYAN_FLOWER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_CYAN_FLOWER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_CYAN_FLOWER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_CYAN_FLOWER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_CYAN_FLOWER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_CYAN_FLOWER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_CYAN_FLOWER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_CYAN_FLOWER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_CYAN_FLOWER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_CYAN_FLOWER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_CYAN_FLOWER_WHITE.get().getDefaultInstance();
                };
            }
        }
        else if (baseColor == DyeColor.PURPLE) {
            if (layer == EasterEggProperties.Layer.CREEPER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_PURPLE_CREEPER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_PURPLE_CREEPER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_PURPLE_CREEPER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_PURPLE_CREEPER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_PURPLE_CREEPER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_PURPLE_CREEPER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_PURPLE_CREEPER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_PURPLE_CREEPER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_PURPLE_CREEPER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_PURPLE_CREEPER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_PURPLE_CREEPER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_PURPLE_CREEPER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_PURPLE_CREEPER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_PURPLE_CREEPER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_PURPLE_CREEPER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_PURPLE_CREEPER_WHITE.get().getDefaultInstance();
                };
            }
            else if (layer == EasterEggProperties.Layer.FLOWER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_PURPLE_FLOWER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_PURPLE_FLOWER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_PURPLE_FLOWER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_PURPLE_FLOWER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_PURPLE_FLOWER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_PURPLE_FLOWER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_PURPLE_FLOWER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_PURPLE_FLOWER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_PURPLE_FLOWER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_PURPLE_FLOWER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_PURPLE_FLOWER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_PURPLE_FLOWER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_PURPLE_FLOWER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_PURPLE_FLOWER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_PURPLE_FLOWER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_PURPLE_FLOWER_WHITE.get().getDefaultInstance();
                };
            }
        }
        else if (baseColor == DyeColor.BLUE) {
            if (layer == EasterEggProperties.Layer.CREEPER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_BLUE_CREEPER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_BLUE_CREEPER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_BLUE_CREEPER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_BLUE_CREEPER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_BLUE_CREEPER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_BLUE_CREEPER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_BLUE_CREEPER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_BLUE_CREEPER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_BLUE_CREEPER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_BLUE_CREEPER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_BLUE_CREEPER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_BLUE_CREEPER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_BLUE_CREEPER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_BLUE_CREEPER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_BLUE_CREEPER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_BLUE_CREEPER_WHITE.get().getDefaultInstance();
                };
            }
            else if (layer == EasterEggProperties.Layer.FLOWER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_BLUE_FLOWER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_BLUE_FLOWER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_BLUE_FLOWER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_BLUE_FLOWER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_BLUE_FLOWER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_BLUE_FLOWER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_BLUE_FLOWER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_BLUE_FLOWER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_BLUE_FLOWER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_BLUE_FLOWER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_BLUE_FLOWER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_BLUE_FLOWER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_BLUE_FLOWER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_BLUE_FLOWER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_BLUE_FLOWER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_BLUE_FLOWER_WHITE.get().getDefaultInstance();
                };
            }
        }
        else if (baseColor == DyeColor.BROWN) {
            if (layer == EasterEggProperties.Layer.CREEPER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_BROWN_CREEPER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_BROWN_CREEPER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_BROWN_CREEPER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_BROWN_CREEPER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_BROWN_CREEPER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_BROWN_CREEPER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_BROWN_CREEPER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_BROWN_CREEPER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_BROWN_CREEPER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_BROWN_CREEPER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_BROWN_CREEPER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_BROWN_CREEPER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_BROWN_CREEPER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_BROWN_CREEPER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_BROWN_CREEPER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_BROWN_CREEPER_WHITE.get().getDefaultInstance();
                };
            }
            else if (layer == EasterEggProperties.Layer.FLOWER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_BROWN_FLOWER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_BROWN_FLOWER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_BROWN_FLOWER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_BROWN_FLOWER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_BROWN_FLOWER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_BROWN_FLOWER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_BROWN_FLOWER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_BROWN_FLOWER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_BROWN_FLOWER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_BROWN_FLOWER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_BROWN_FLOWER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_BROWN_FLOWER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_BROWN_FLOWER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_BROWN_FLOWER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_BROWN_FLOWER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_BROWN_FLOWER_WHITE.get().getDefaultInstance();
                };
            }
        }
        else if (baseColor == DyeColor.GREEN) {
            if (layer == EasterEggProperties.Layer.CREEPER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_GREEN_CREEPER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_GREEN_CREEPER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_GREEN_CREEPER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_GREEN_CREEPER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_GREEN_CREEPER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_GREEN_CREEPER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_GREEN_CREEPER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_GREEN_CREEPER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_GREEN_CREEPER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_GREEN_CREEPER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_GREEN_CREEPER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_GREEN_CREEPER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_GREEN_CREEPER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_GREEN_CREEPER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_GREEN_CREEPER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_GREEN_CREEPER_WHITE.get().getDefaultInstance();
                };
            }
            else if (layer == EasterEggProperties.Layer.FLOWER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_GREEN_FLOWER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_GREEN_FLOWER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_GREEN_FLOWER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_GREEN_FLOWER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_GREEN_FLOWER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_GREEN_FLOWER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_GREEN_FLOWER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_GREEN_FLOWER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_GREEN_FLOWER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_GREEN_FLOWER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_GREEN_FLOWER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_GREEN_FLOWER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_GREEN_FLOWER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_GREEN_FLOWER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_GREEN_FLOWER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_GREEN_FLOWER_WHITE.get().getDefaultInstance();
                };
            }
        }
        else if (baseColor == DyeColor.RED) {
            if (layer == EasterEggProperties.Layer.CREEPER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_RED_CREEPER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_RED_CREEPER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_RED_CREEPER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_RED_CREEPER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_RED_CREEPER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_RED_CREEPER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_RED_CREEPER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_RED_CREEPER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_RED_CREEPER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_RED_CREEPER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_RED_CREEPER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_RED_CREEPER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_RED_CREEPER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_RED_CREEPER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_RED_CREEPER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_RED_CREEPER_WHITE.get().getDefaultInstance();
                };
            }
            else if (layer == EasterEggProperties.Layer.FLOWER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_RED_FLOWER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_RED_FLOWER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_RED_FLOWER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_RED_FLOWER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_RED_FLOWER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_RED_FLOWER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_RED_FLOWER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_RED_FLOWER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_RED_FLOWER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_RED_FLOWER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_RED_FLOWER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_RED_FLOWER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_RED_FLOWER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_RED_FLOWER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_RED_FLOWER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_RED_FLOWER_WHITE.get().getDefaultInstance();
                };
            }
        }
        else if (baseColor == DyeColor.BLACK) {
            if (layer == EasterEggProperties.Layer.CREEPER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_BLACK_CREEPER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_BLACK_CREEPER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_BLACK_CREEPER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_BLACK_CREEPER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_BLACK_CREEPER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_BLACK_CREEPER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_BLACK_CREEPER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_BLACK_CREEPER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_BLACK_CREEPER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_BLACK_CREEPER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_BLACK_CREEPER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_BLACK_CREEPER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_BLACK_CREEPER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_BLACK_CREEPER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_BLACK_CREEPER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_BLACK_CREEPER_WHITE.get().getDefaultInstance();
                };
            }
            else if (layer == EasterEggProperties.Layer.FLOWER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_BLACK_FLOWER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_BLACK_FLOWER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_BLACK_FLOWER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_BLACK_FLOWER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_BLACK_FLOWER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_BLACK_FLOWER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_BLACK_FLOWER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_BLACK_FLOWER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_BLACK_FLOWER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_BLACK_FLOWER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_BLACK_FLOWER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_BLACK_FLOWER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_BLACK_FLOWER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_BLACK_FLOWER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_BLACK_FLOWER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_BLACK_FLOWER_WHITE.get().getDefaultInstance();
                };
            }
        }
        else {
            if (layer == EasterEggProperties.Layer.CREEPER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_WHITE_CREEPER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_WHITE_CREEPER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_WHITE_CREEPER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_WHITE_CREEPER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_WHITE_CREEPER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_WHITE_CREEPER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_WHITE_CREEPER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_WHITE_CREEPER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_WHITE_CREEPER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_WHITE_CREEPER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_WHITE_CREEPER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_WHITE_CREEPER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_WHITE_CREEPER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_WHITE_CREEPER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_WHITE_CREEPER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_WHITE_CREEPER_WHITE.get().getDefaultInstance();
                };
            }
            else if (layer == EasterEggProperties.Layer.FLOWER) {
                return switch (layerColor) {
                    case ORANGE -> TBAItems.COLORED_EGG_WHITE_FLOWER_ORANGE.get().getDefaultInstance();
                    case MAGENTA -> TBAItems.COLORED_EGG_WHITE_FLOWER_MAGENTA.get().getDefaultInstance();
                    case LIGHT_BLUE -> TBAItems.COLORED_EGG_WHITE_FLOWER_LIGHT_BLUE.get().getDefaultInstance();
                    case YELLOW -> TBAItems.COLORED_EGG_WHITE_FLOWER_YELLOW.get().getDefaultInstance();
                    case LIME -> TBAItems.COLORED_EGG_WHITE_FLOWER_LIME.get().getDefaultInstance();
                    case PINK -> TBAItems.COLORED_EGG_WHITE_FLOWER_PINK.get().getDefaultInstance();
                    case GRAY -> TBAItems.COLORED_EGG_WHITE_FLOWER_GRAY.get().getDefaultInstance();
                    case LIGHT_GRAY -> TBAItems.COLORED_EGG_WHITE_FLOWER_LIGHT_GRAY.get().getDefaultInstance();
                    case CYAN -> TBAItems.COLORED_EGG_WHITE_FLOWER_CYAN.get().getDefaultInstance();
                    case PURPLE -> TBAItems.COLORED_EGG_WHITE_FLOWER_PURPLE.get().getDefaultInstance();
                    case BLUE -> TBAItems.COLORED_EGG_WHITE_FLOWER_BLUE.get().getDefaultInstance();
                    case BROWN -> TBAItems.COLORED_EGG_WHITE_FLOWER_BROWN.get().getDefaultInstance();
                    case GREEN -> TBAItems.COLORED_EGG_WHITE_FLOWER_GREEN.get().getDefaultInstance();
                    case RED -> TBAItems.COLORED_EGG_WHITE_FLOWER_RED.get().getDefaultInstance();
                    case BLACK -> TBAItems.COLORED_EGG_WHITE_FLOWER_BLACK.get().getDefaultInstance();
                    default -> TBAItems.COLORED_EGG_WHITE_FLOWER_WHITE.get().getDefaultInstance();
                };
            }
        }

        return TBAItems.COLORED_EGG_WHITE.get().getDefaultInstance();
    }

    public int getBaseTint() {
        DyeColor baseTint = getBaseColor(this.baseColor);
        // values from https://www.w3schools.com/colors/colors_crayola.asp
        return switch (baseTint) {
            case ORANGE -> 0xFF9966;
            case MAGENTA -> 0xDB91EF;
            case LIGHT_BLUE -> 0x50BFE6;
            case YELLOW -> 0xFFD12A;
            case LIME -> 0xAFE313;
            case PINK -> 0xFC80A5;
            case GRAY -> 0x828E84;
            case LIGHT_GRAY -> 0xC8C8CD;
            case CYAN -> 0x3AA8C1;
            case PURPLE -> 0x9C51B6;
            case BLUE -> 0x2E5894;
            case BROWN -> 0xAF6E4D;
            case GREEN -> 0x29AB87;
            case RED -> 0xDA2C43;
            case BLACK -> 0x353839;
            default -> 0xFEFEFE;
        };
    }

    public int getStampTint() {
        DyeColor layerTint = getLayerColor(this.layerColor);
        // base layer values mixed 3 or more shades darker here https://www.w3schools.com/colors/colors_picker.asp
        if (layerTint != null) {
            return switch (layerTint) {
                case ORANGE -> 0xe64d00;
                case MAGENTA -> 0xa41dc9;
                case LIGHT_BLUE -> 0x1d9bc9;
                case YELLOW -> 0xe6b400;
                case LIME -> 0x7fa50d;
                case PINK -> 0xe10547;
                case GRAY -> 0x555e57;
                case LIGHT_GRAY -> 0x6d6d78;
                case CYAN -> 0x297889;
                case PURPLE -> 0x5c2d6c;
                case BLUE -> 0x2a5189;
                case BROWN -> 0x6a442f;
                case GREEN -> 0x196751;
                case RED -> 0x991a31;
                case BLACK -> 0x181a1b;
                default -> 0xcccccc;
            };
        }
        return 0xFEFEFE;
    }

    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltips, @NotNull TooltipFlag isAdvanced) {
        if (Screen.hasShiftDown()) {
            if (baseColor == DyeColor.WHITE) {
                tooltips.add(Component.translatable("tooltip.turtleblockacademy.easter_egg_item_custom_tooltip"));
            }
            else if (baseColor == DyeColor.ORANGE) {
                tooltips.add(Component.translatable("tooltip.turtleblockacademy.easter_egg_item_custom_tooltip1"));
            }
            else if (baseColor == DyeColor.MAGENTA) {
                tooltips.add(Component.translatable("tooltip.turtleblockacademy.easter_egg_item_custom_tooltip2"));
            }
            else if (baseColor == DyeColor.LIGHT_BLUE) {
                tooltips.add(Component.translatable("tooltip.turtleblockacademy.easter_egg_item_custom_tooltip3"));
            }
            else if (baseColor == DyeColor.YELLOW) {
                tooltips.add(Component.translatable("tooltip.turtleblockacademy.easter_egg_item_custom_tooltip4"));
            }
            else if (baseColor == DyeColor.LIME) {
                tooltips.add(Component.translatable("tooltip.turtleblockacademy.easter_egg_item_custom_tooltip5"));
            }
            else if (baseColor == DyeColor.PINK) {
                tooltips.add(Component.translatable("tooltip.turtleblockacademy.easter_egg_item_custom_tooltip6"));
            }
            else if (baseColor == DyeColor.GRAY) {
                tooltips.add(Component.translatable("tooltip.turtleblockacademy.easter_egg_item_custom_tooltip7"));
            }
            else if (baseColor == DyeColor.LIGHT_GRAY) {
                tooltips.add(Component.translatable("tooltip.turtleblockacademy.easter_egg_item_custom_tooltip8"));
            }
            else if (baseColor == DyeColor.CYAN) {
                tooltips.add(Component.translatable("tooltip.turtleblockacademy.easter_egg_item_custom_tooltip9"));
            }
            else if (baseColor == DyeColor.PURPLE) {
                tooltips.add(Component.translatable("tooltip.turtleblockacademy.easter_egg_item_custom_tooltip10"));
            }
            else if (baseColor == DyeColor.BLUE) {
                tooltips.add(Component.translatable("tooltip.turtleblockacademy.easter_egg_item_custom_tooltip11"));
            }
            else if (baseColor == DyeColor.BROWN) {
                tooltips.add(Component.translatable("tooltip.turtleblockacademy.easter_egg_item_custom_tooltip12"));
            }
            else if (baseColor == DyeColor.GREEN) {
                tooltips.add(Component.translatable("tooltip.turtleblockacademy.easter_egg_item_custom_tooltip13"));
            }
            else if (baseColor == DyeColor.RED) {
                tooltips.add(Component.translatable("tooltip.turtleblockacademy.easter_egg_item_custom_tooltip14"));
            }
            else {
                tooltips.add(Component.translatable("tooltip.turtleblockacademy.easter_egg_item_custom_tooltip15"));
            }
        }
        else {
            tooltips.add(Component.translatable("tooltips.shift.hover").withStyle(ChatFormatting.GRAY));
        }
    }
}