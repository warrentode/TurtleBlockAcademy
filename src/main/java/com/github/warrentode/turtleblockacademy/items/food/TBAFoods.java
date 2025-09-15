package com.github.warrentode.turtleblockacademy.items.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class TBAFoods {
    public static final FoodProperties CUCUMBER = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.6F).build();

    public static final FoodProperties BEET_WINE = new FoodProperties.Builder()
            .alwaysEat().fast().nutrition(1).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST,
                    600, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION,
                    100, 0), 0.1F).build();

    public static final FoodProperties HARD_APPLE_CIDER = (new FoodProperties.Builder())
            .alwaysEat().fast().nutrition(1).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION,
                    1800, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION,
                    200, 0), 0.2F).build();

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

    public static final FoodProperties PICKLES = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.5F).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION,
                    1200, 0), 1.0F).build();

    public static final FoodProperties PEELED_EGGS = (new FoodProperties.Builder())
            .nutrition(4).saturationMod(0.7F).build();
}