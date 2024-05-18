package com.github.warrentode.turtleblockacademy.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class TBAFoods {
    public static final FoodProperties BEET_WINE = new FoodProperties.Builder()
            .alwaysEat().fast().nutrition(1).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST,
                    600, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION,
                    100, 0), 0.1F).build();

    public static final FoodProperties VINEGAR_BOTTLE = new FoodProperties.Builder()
            .alwaysEat().fast().nutrition(1).saturationMod(0.01F).build();

    public static final FoodProperties RICE_DISHES = (new FoodProperties.Builder())
            .nutrition(14).saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(),
                    6000, 0), 1.0F).build();

    public static final FoodProperties SALAD_DISHES = (new FoodProperties.Builder())
            .nutrition(6).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION,
                            100, 0), 1.0F).build();
}
