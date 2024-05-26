package com.github.warrentode.turtleblockacademy.items;

import com.github.warrentode.turtleblockacademy.util.CalendarUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.Nullable;
import java.util.List;

public class EasterEggItem extends ConsumableItem {
    private static final String NBT_COLOR = "EggColor";
    private final boolean hasFoodEffectTooltip;
    private final boolean hasCustomTooltip;
    private final int color;

    public EasterEggItem(int color, Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = hasCustomTooltip;
        this.color = color;
    }

    public static int getEggColor(@NotNull ItemStack stack) {
        return stack.getOrCreateTag().getInt(NBT_COLOR);
    }

    public static void setEggColor(@NotNull ItemStack stack, int color) {
        stack.getOrCreateTag().putInt(NBT_COLOR, color);
    }

    public int getColor(ItemStack stack, int tintIndex) {
        if (tintIndex == 0) {
            return 0xFFFFFF;
        }
        return color;
    }


    @Override
    public void affectConsumer(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity consumer) {
        if (CalendarUtil.check("EASTER")) {
            consumer.addEffect(new MobEffectInstance(
                    MobEffects.JUMP,
                    200, 0, true, true, true));
        }
        else {
            consumer.addEffect(new MobEffectInstance(
                    ModEffects.COMFORT.get(),
                    200, 0, true, true, true));
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag isAdvanced) {
        if (Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            if (this.hasCustomTooltip) {
                MutableComponent textEmpty = Component
                        .translatable("tooltip.turtleblockacademy.easter_egg_item_custom." + this);
                tooltip.add(textEmpty.withStyle(ChatFormatting.BLUE));
            }

            if (this.hasFoodEffectTooltip) {
                TextUtils.addFoodEffectTooltip(stack, tooltip, 1.0F);
            }
        }
    }
}
