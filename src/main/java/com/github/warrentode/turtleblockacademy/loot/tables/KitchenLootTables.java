package com.github.warrentode.turtleblockacademy.loot.tables;

import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class KitchenLootTables {
    private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();
    private static final Set<ResourceLocation> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);

    public static final ResourceLocation KITCHEN = register("chests/kitchen");
    public static final ResourceLocation VANILLA_EDIBLES = register("chests/kitchen/vanilla_edibles");
    public static final ResourceLocation AETHER_EDIBLES = register("chests/kitchen/aether_edibles");
    public static final ResourceLocation FARMERSDELIGHT_EDIBLES = register("chests/kitchen/farmersdelight_edibles");
    public static final ResourceLocation FARMERSRESPITE_EDIBLES = register("chests/kitchen/farmersrespite_edibles");
    public static final ResourceLocation DELIGHTFUL_EDIBLES = register("chests/kitchen/delightful_edibles");
    public static final ResourceLocation FASTFOODDELIGHT_EDIBLES = register("chests/kitchen/fastfooddelight_edibles");
    public static final ResourceLocation FESTIVEDELIGHT_EDIBLES = register("chests/kitchen/festivedelight_edibles");
    public static final ResourceLocation ENDSDELIGHT_EDIBLES = register("chests/kitchen/endsdelight_edibles");
    public static final ResourceLocation NETHERSSDELIGHT_EDIBLES = register("chests/kitchen/nethersdelight_edibles");
    public static final ResourceLocation OCEANSDELIGHT_EDIBLES = register("chests/kitchen/oceansdelight_edibles");
    public static final ResourceLocation SUPPLEMENTARIES_EDIBLES = register("chests/kitchen/supplementaries_edibles");
    public static final ResourceLocation HAUNTEDHARVEST_EDIBLES = register("chests/kitchen/hauntedharvest_edibles");
    public static final ResourceLocation SNOWYSPIRIT_EDIBLES = register("chests/kitchen/snowyspirit_edibles");
    public static final ResourceLocation ECOLOGICS_EDIBLES = register("chests/kitchen/ecologics_edibles");
    public static final ResourceLocation UNUSUALEND_EDIBLES = register("chests/kitchen/unusualend_edibles");
    public static final ResourceLocation PHANTASM_EDIBLES = register("chests/kitchen/phantasm_edibles");
    public static final ResourceLocation DRINKBEERREFILL_EDIBLES = register("chests/kitchen/drinkbeerrefill_edibles");
    public static final ResourceLocation KAWAIIDISHES_EDIBLES = register("chests/kitchen/kawaiidishes_edibles");
    public static final ResourceLocation WILDBERRIES_EDIBLES = register("chests/kitchen/wildberries_edibles");
    public static final ResourceLocation CRABBERSDELIGHT_EDIBLES = register("chests/kitchen/crabbersdelight_edibles");
    public static final ResourceLocation MINERSDELIGHT_EDIBLES = register("chests/kitchen/minersdelight_edibles");
    public static final ResourceLocation TBA_EDIBLES = register("chests/kitchen/turtleblockacademy_edibles");

    private static ResourceLocation register(String path) {
        return register(new ResourceLocation(MODID, path));
    }

    private static ResourceLocation register(ResourceLocation path) {
        if (LOCATIONS.add(path)) {
            return path;
        }
        else {
            throw new IllegalArgumentException(path + " is already a registered built-in loot table");
        }
    }

    @SuppressWarnings("unused")
    public static Set<ResourceLocation> all() {
        return IMMUTABLE_LOCATIONS;
    }
}
