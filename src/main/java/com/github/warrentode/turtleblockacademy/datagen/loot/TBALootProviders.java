package com.github.warrentode.turtleblockacademy.datagen.loot;

import biomesoplenty.api.biome.BOPBiomes;
import com.aetherteam.aether.data.resources.registries.AetherDimensions;
import com.catastrophe573.dimdungeons.DimDungeons;
import com.github.warrentode.turtleblockacademy.datagen.loot.tables.*;
import com.github.warrentode.turtleblockacademy.loot.conditions.BiomeTagCondition;
import com.github.warrentode.turtleblockacademy.loot.conditions.ModCheckCondition;
import com.github.warrentode.turtleblockacademy.loot.conditions.SeasonalCondition;
import com.github.warrentode.turtleblockacademy.util.TBATags;
import com.github.warrentode.turtleblockacademy.world.dimension.TBADimensions;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.worldgen.Structures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TBALootProviders extends LootTableProvider {
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>>
            loot_tables = ImmutableList.of(
            Pair.of(WaresLootTablesGen::new, LootContextParamSets.CHEST),
            Pair.of(LootbagLootTablesGen::new, LootContextParamSets.CHEST),
            Pair.of(DimDungeonLootTablesGen::new, LootContextParamSets.CHEST),
            Pair.of(PackLootTablesGen::new, LootContextParamSets.CHEST),
            Pair.of(KitchenLootTablesGen::new, LootContextParamSets.CHEST),
            Pair.of(TBABlockLootTablesGen::new, LootContextParamSets.BLOCK)
    );

    public TBALootProviders(DataGenerator generator) {
        super(generator);
    }


    @Override
    protected @NotNull List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return loot_tables;
    }

    @Override
    protected void validate(@NotNull Map<ResourceLocation, LootTable> map, @NotNull ValidationContext validationTracker) {
        map.forEach((id, table) -> LootTables.validate(validationTracker, id, table));
    }

    // mod loaded checks
    public static final LootItemCondition.Builder BOP_LOADED =
            ModCheckCondition.mod().isLoaded("biomesoplenty");
    public static final LootItemCondition.Builder TCONSTRUCT_LOADED =
            ModCheckCondition.mod().isLoaded("tconstruct");
    public static final LootItemCondition.Builder AETHER_LOADED =
            ModCheckCondition.mod().isLoaded("aether");
    public static final LootItemCondition.Builder ECOLOGICS_LOADED =
            ModCheckCondition.mod().isLoaded("ecologics");
    public static final LootItemCondition.Builder UNUSUALEND_LOADED =
            ModCheckCondition.mod().isLoaded("unusualend");
    public static final LootItemCondition.Builder PHANTASM_LOADED =
            ModCheckCondition.mod().isLoaded("phantasm");

    // dimension checks
    public static final LootItemCondition.Builder IN_OVERWORLD =
            LocationCheck.checkLocation(LocationPredicate.Builder.location()
                    .setDimension(Level.OVERWORLD));
    public static final LootItemCondition.Builder IN_NETHER =
            LocationCheck.checkLocation(LocationPredicate.Builder.location()
                    .setDimension(Level.NETHER));
    public static final LootItemCondition.Builder IN_END =
            LocationCheck.checkLocation(LocationPredicate.Builder.location()
                    .setDimension(Level.END));
    public static final LootItemCondition.Builder IN_AETHER =
            LocationCheck.checkLocation(LocationPredicate.Builder.location()
                    .setDimension(AetherDimensions.AETHER_LEVEL));
    public static final LootItemCondition.Builder IN_DUNGEON =
            LocationCheck.checkLocation(LocationPredicate.Builder.location()
                    .setDimension(DimDungeons.DUNGEON_DIMENSION));
    public static final LootItemCondition.Builder IN_MINING =
            LocationCheck.checkLocation(LocationPredicate.Builder.location()
                    .setDimension(TBADimensions.TDA_MINING_LEVEL));

    // holiday checks
    public static final LootItemCondition.Builder BIRTHDAY_EVENT = SeasonalCondition.season().set("BIRTHDAY");
    public static final LootItemCondition.Builder HALLOWEEN_EVENT = SeasonalCondition.season().set("HALLOWEEN");
    public static final LootItemCondition.Builder CHRISTMAS_EVENT = SeasonalCondition.season().set("CHRISTMAS");
    public static final LootItemCondition.Builder ANNIVERSARY_EVENT = SeasonalCondition.season().set("ANNIVERSARY");
    public static final LootItemCondition.Builder EASTER_EVENT = SeasonalCondition.season().set("EASTER");
    public static final LootItemCondition.Builder NEW_YEAR_EVENT = SeasonalCondition.season().set("NEW_YEAR");

    // season checks
    public static final LootItemCondition.Builder AUTUMN = SeasonalCondition.season().set("AUTUMN");
    public static final LootItemCondition.Builder SPRING = SeasonalCondition.season().set("SPRING");
    public static final LootItemCondition.Builder SUMMER = SeasonalCondition.season().set("SUMMER");
    public static final LootItemCondition.Builder WINTER = SeasonalCondition.season().set("WINTER");

    // structure checks
    public static final LootItemCondition.Builder IN_VILLAGE_SNOWY = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setStructure(Structures.VILLAGE_SNOWY.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_VILLAGE_TAIGA = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setStructure(Structures.VILLAGE_TAIGA.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_VILLAGE_PLAINS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setStructure(Structures.VILLAGE_PLAINS.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_VILLAGE_SAVANNA = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setStructure(Structures.VILLAGE_SAVANNA.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_VILLAGE_DESERT = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setStructure(Structures.VILLAGE_DESERT.unwrapKey().orElseThrow()));

    // tree biome tag checks
    public static final LootItemCondition.Builder HAS_SPRUCE = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_SPRUCE);
    public static final LootItemCondition.Builder HAS_BIRCH = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_BIRCH);
    public static final LootItemCondition.Builder HAS_JUNGLE = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_JUNGLE);
    public static final LootItemCondition.Builder HAS_ACACIA = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_ACACIA);
    public static final LootItemCondition.Builder HAS_DARK_OAK = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_DARK_OAK);
    public static final LootItemCondition.Builder HAS_MANGROVE = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_MANGROVE);
    public static final LootItemCondition.Builder HAS_WARPED_FUNGUS = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_WARPED_FUNGUS);
    public static final LootItemCondition.Builder HAS_CRIMSON_FUNGUS = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_CRIMSON_FUNGUS);
    public static final LootItemCondition.Builder HAS_FIR = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_FIR);
    public static final LootItemCondition.Builder HAS_REDWOOD = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_REDWOOD);
    public static final LootItemCondition.Builder HAS_CHERRY = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_CHERRY);
    public static final LootItemCondition.Builder HAS_MAHOGANY = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_MAHOGANY);
    public static final LootItemCondition.Builder HAS_JACARANDA = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_JACARANDA);
    public static final LootItemCondition.Builder HAS_PALM = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_PALM);
    public static final LootItemCondition.Builder HAS_WILLOW = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_WILLOW);
    public static final LootItemCondition.Builder HAS_DEAD = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_DEAD);
    public static final LootItemCondition.Builder HAS_MAGIC = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_MAGIC);
    public static final LootItemCondition.Builder HAS_UMBRAN = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_UMBRAN);
    public static final LootItemCondition.Builder HAS_HELLBARK = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_HELLBARK);
    public static final LootItemCondition.Builder HAS_COCONUT = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_COCONUT);
    public static final LootItemCondition.Builder HAS_AZALEA = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_AZALEA);
    public static final LootItemCondition.Builder HAS_CHORUS_NEST = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_CHORUS_NEST);
    public static final LootItemCondition.Builder HAS_EBONY = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_EBONY);
    public static final LootItemCondition.Builder HAS_PREAM = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_PREAM);
    public static final LootItemCondition.Builder HAS_AETHER_SKYROOT = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_AETHER_SKYROOT);
    public static final LootItemCondition.Builder HAS_GOLDEN_OAK = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_GOLDEN_OAK);
    public static final LootItemCondition.Builder HAS_BLOODSHROOM = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_BLOODSHROOM);
    public static final LootItemCondition.Builder HAS_ENDERBARK = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_ENDERBARK);
    public static final LootItemCondition.Builder HAS_GREENHEART = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_GREENHEART);
    public static final LootItemCondition.Builder HAS_FLOWERING_OAK = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_FLOWERING_OAK);
    public static final LootItemCondition.Builder HAS_RAINBOW_BIRCH = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_RAINBOW_BIRCH);
    public static final LootItemCondition.Builder HAS_MAPLE = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_MAPLE);
    public static final LootItemCondition.Builder HAS_ORIGIN = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_ORIGIN);
    public static final LootItemCondition.Builder HAS_YELLOW_AUTUMN = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_YELLOW_AUTUMN);
    public static final LootItemCondition.Builder HAS_ORANGE_AUTUMN = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_ORANGE_AUTUMN);
    // flower biome tag checks
    public static final LootItemCondition.Builder HAS_SUNFLOWER = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_SUNFLOWER);
    public static final LootItemCondition.Builder HAS_PEONY = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_PEONY);
    public static final LootItemCondition.Builder HAS_ROSE_BUSH = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_ROSE_BUSH);
    public static final LootItemCondition.Builder HAS_LILAC = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_LILAC);
    public static final LootItemCondition.Builder HAS_BUTTERCUP = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_BUTTERCUP);
    public static final LootItemCondition.Builder HAS_LILY_OF_THE_VALLEY = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_LILY_OF_THE_VALLEY);
    public static final LootItemCondition.Builder HAS_CORNFLOWER = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_CORNFLOWER);
    public static final LootItemCondition.Builder HAS_OXEYE_DAISY = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_OXEYE_DAISY);
    public static final LootItemCondition.Builder HAS_PINK_TULIP = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_PINK_TULIP);
    public static final LootItemCondition.Builder HAS_WHITE_TULIP = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_WHITE_TULIP);
    public static final LootItemCondition.Builder HAS_ORANGE_TULIP = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_ORANGE_TULIP);
    public static final LootItemCondition.Builder HAS_RED_TULIP = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_RED_TULIP);
    public static final LootItemCondition.Builder HAS_AZURE_BLUET = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_AZURE_BLUET);
    public static final LootItemCondition.Builder HAS_ALLIUM = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_ALLIUM);
    public static final LootItemCondition.Builder HAS_BLUE_ORCHID = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_BLUE_ORCHID);
    public static final LootItemCondition.Builder HAS_PURPLE_FLOWER = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_PURPLE_FLOWER);
    public static final LootItemCondition.Builder HAS_WHITE_FLOWER = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_PURPLE_FLOWER);
    public static final LootItemCondition.Builder HAS_GOLDENROD = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_GOLDENROD);
    public static final LootItemCondition.Builder HAS_WILDFLOWER = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_WILDFLOWER);
    public static final LootItemCondition.Builder HAS_CATTAIL = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_CATTAIL);
    public static final LootItemCondition.Builder HAS_WILTED_LILY = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_WILTED_LILY);
    public static final LootItemCondition.Builder HAS_VIOLET = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_VIOLET);
    public static final LootItemCondition.Builder HAS_ROSE = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_ROSE);
    public static final LootItemCondition.Builder HAS_WITHER_ROSE = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_WITHER_ROSE);
    public static final LootItemCondition.Builder HAS_GLOWFLOWER = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_GLOWFLOWER);
    public static final LootItemCondition.Builder HAS_LAVENDER = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_LAVENDER);
    public static final LootItemCondition.Builder HAS_ICY_IRIS = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_ICY_IRIS);
    public static final LootItemCondition.Builder HAS_BURNING_BLOSSOM = BiomeTagCondition.tag().set(TBATags.Biomes.HAS_BURNING_BLOSSOM);

    // individual biome checks
    // BOP BIOMES
    // overworld biomes
    public static final LootItemCondition.Builder IN_WOODLAND = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.WOODLAND));
    public static final LootItemCondition.Builder IN_WOODED_SCRUBLAND = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.WOODED_SCRUBLAND));
    public static final LootItemCondition.Builder IN_WETLAND = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.WETLAND));
    public static final LootItemCondition.Builder IN_WOODED_WASTELAND = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.WOODED_WASTELAND));
    public static final LootItemCondition.Builder IN_WASTELAND = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.WASTELAND));
    public static final LootItemCondition.Builder IN_VOLCANO = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.VOLCANO));
    public static final LootItemCondition.Builder IN_VOLCANIC_PLAINS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.VOLCANIC_PLAINS));
    public static final LootItemCondition.Builder IN_TUNDRA = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.TUNDRA));
    public static final LootItemCondition.Builder IN_TROPICS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.TROPICS));
    public static final LootItemCondition.Builder IN_SPIDER_NEST = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.SPIDER_NEST));
    public static final LootItemCondition.Builder IN_SNOWY_MAPLE_WOODS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.SNOWY_MAPLE_WOODS));
    public static final LootItemCondition.Builder IN_SNOWY_FIR_CLEARING = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.SNOWY_FIR_CLEARING));
    public static final LootItemCondition.Builder IN_SNOWY_CONIFEROUS_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.SNOWY_CONIFEROUS_FOREST));
    public static final LootItemCondition.Builder IN_ROCKY_SHRUBLAND = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.ROCKY_SHRUBLAND));
    public static final LootItemCondition.Builder IN_REDWOOD_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.REDWOOD_FOREST));
    public static final LootItemCondition.Builder IN_ROCKY_RAINFOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.ROCKY_RAINFOREST));
    public static final LootItemCondition.Builder IN_RAINFOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.RAINFOREST));
    public static final LootItemCondition.Builder IN_PRAIRIE = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.PRAIRIE));
    public static final LootItemCondition.Builder IN_PASTURE = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.PASTURE));
    public static final LootItemCondition.Builder IN_ORIGIN_VALLEY = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.ORIGIN_VALLEY));
    public static final LootItemCondition.Builder IN_ORCHARD = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.ORCHARD));
    public static final LootItemCondition.Builder IN_OMINOUS_WOODS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.OMINOUS_WOODS));
    public static final LootItemCondition.Builder IN_OLD_GROWTH_WOODLAND = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.OLD_GROWTH_WOODLAND));
    public static final LootItemCondition.Builder IN_MYSTIC_GROVE = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.MYSTIC_GROVE));
    public static final LootItemCondition.Builder IN_MUSKEG = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.MUSKEG));
    public static final LootItemCondition.Builder IN_MEDITERRANEAN_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.MEDITERRANEAN_FOREST));
    public static final LootItemCondition.Builder IN_MARSH = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.MARSH));
    public static final LootItemCondition.Builder IN_LUSH_SAVANNA = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.LUSH_SAVANNA));
    public static final LootItemCondition.Builder IN_LAVENDER_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.LAVENDER_FOREST));
    public static final LootItemCondition.Builder IN_LAVENDER_FIELD = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.LAVENDER_FIELD));
    public static final LootItemCondition.Builder IN_JADE_CLIFFS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.JADE_CLIFFS));
    public static final LootItemCondition.Builder IN_HIGHLAND_MOOR = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.HIGHLAND_MOOR));
    public static final LootItemCondition.Builder IN_HIGHLAND = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.HIGHLAND));
    public static final LootItemCondition.Builder IN_GLOWING_GROTTO = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.GLOWING_GROTTO));
    public static final LootItemCondition.Builder IN_FUNGAL_JUNGLE = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.FUNGAL_JUNGLE));
    public static final LootItemCondition.Builder IN_FORESTED_FIELD = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.FORESTED_FIELD));
    public static final LootItemCondition.Builder IN_FLOODPLAIN = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.FLOODPLAIN));
    public static final LootItemCondition.Builder IN_FIR_CLEARING = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.FIR_CLEARING));
    public static final LootItemCondition.Builder IN_PUMPKIN_PATCH = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.PUMPKIN_PATCH));
    public static final LootItemCondition.Builder IN_SEASONAL_ORCHARD = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.SEASONAL_ORCHARD));
    public static final LootItemCondition.Builder IN_SEASONAL_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.SEASONAL_FOREST));
    public static final LootItemCondition.Builder IN_MAPLE_WOODS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.MAPLE_WOODS));
    public static final LootItemCondition.Builder IN_FIELD = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.FIELD));
    public static final LootItemCondition.Builder IN_SCRUBLAND = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.SCRUBLAND));
    public static final LootItemCondition.Builder IN_SHRUBLAND = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.SHRUBLAND));
    public static final LootItemCondition.Builder IN_DUNE_BEACH = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.DUNE_BEACH));
    public static final LootItemCondition.Builder IN_LUSH_DESERT = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.LUSH_DESERT));
    public static final LootItemCondition.Builder IN_DRYLAND = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.DRYLAND));
    public static final LootItemCondition.Builder IN_OLD_GROWTH_DEAD_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.OLD_GROWTH_DEAD_FOREST));
    public static final LootItemCondition.Builder IN_DEAD_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.DEAD_FOREST));
    public static final LootItemCondition.Builder IN_CRAG = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.CRAG));
    public static final LootItemCondition.Builder IN_CONIFEROUS_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.CONIFEROUS_FOREST));
    public static final LootItemCondition.Builder IN_COLD_DESERT = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.COLD_DESERT));
    public static final LootItemCondition.Builder IN_GRASSLAND = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.GRASSLAND));
    public static final LootItemCondition.Builder IN_CLOVER_PATCH = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.CLOVER_PATCH));
    public static final LootItemCondition.Builder IN_BOG = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.BOG));
    public static final LootItemCondition.Builder IN_AURORAL_GARDEN = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.AURORAL_GARDEN));
    public static final LootItemCondition.Builder IN_BAMBOO_GROVE = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.BAMBOO_GROVE));
    public static final LootItemCondition.Builder IN_CHERRY_BLOSSOM_GROVE = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.CHERRY_BLOSSOM_GROVE));
    public static final LootItemCondition.Builder IN_BAYOU = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.BAYOU));
    // nether biomes
    public static final LootItemCondition.Builder IN_WITHERED_ABYSS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.WITHERED_ABYSS));
    public static final LootItemCondition.Builder IN_VISCERAL_HEAP = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.VISCERAL_HEAP));
    public static final LootItemCondition.Builder IN_UNDERGROWTH = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.UNDERGROWTH));
    public static final LootItemCondition.Builder IN_ERUPTING_INFERNO = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.ERUPTING_INFERNO));
    public static final LootItemCondition.Builder IN_CRYSTALLINE_CHASM = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(BOPBiomes.CRYSTALLINE_CHASM));

    // VANILLA BIOMES
    // nether biomes
    public static final LootItemCondition.Builder IN_NETHER_WASTES = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.NETHER_WASTES));
    public static final LootItemCondition.Builder IN_SOUL_VALLEY = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.SOUL_SAND_VALLEY));
    public static final LootItemCondition.Builder IN_CRIMSON_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.CRIMSON_FOREST));
    public static final LootItemCondition.Builder IN_WARPED_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.WARPED_FOREST));
    public static final LootItemCondition.Builder IN_BASALT_DELTAS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.BASALT_DELTAS));

    // end biomes
    public static final LootItemCondition.Builder IN_THE_END = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.THE_END));
    public static final LootItemCondition.Builder IN_SMALL_END_ISLANDS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.SMALL_END_ISLANDS));
    public static final LootItemCondition.Builder IN_END_MIDLANDS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.END_MIDLANDS));
    public static final LootItemCondition.Builder IN_END_HIGHLANDS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.END_HIGHLANDS));
    public static final LootItemCondition.Builder IN_END_BARRENS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.END_BARRENS));

    // OVERWORLD VANILLA BIOMES
    // arctic biomes
    public static final LootItemCondition.Builder IN_FROZEN_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.FROZEN_OCEAN));
    public static final LootItemCondition.Builder IN_DEEP_FROZEN_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.DEEP_FROZEN_OCEAN));
    public static final LootItemCondition.Builder IN_JAGGED_PEAKS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.JAGGED_PEAKS));
    public static final LootItemCondition.Builder IN_FROZEN_PEAKS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.FROZEN_PEAKS));
    public static final LootItemCondition.Builder IN_GROVE = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.GROVE));
    public static final LootItemCondition.Builder IN_SNOWY_SLOPES = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.SNOWY_SLOPES));
    public static final LootItemCondition.Builder IN_SNOWY_TAIGA = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.SNOWY_TAIGA));
    public static final LootItemCondition.Builder IN_FROZEN_RIVER = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.FROZEN_RIVER));
    public static final LootItemCondition.Builder IN_SNOWY_BEACH = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.SNOWY_BEACH));
    public static final LootItemCondition.Builder IN_SNOWY_PLAINS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.SNOWY_PLAINS));
    public static final LootItemCondition.Builder IN_ICE_SPIKES = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.ICE_SPIKES));
    // cold biomes
    public static final LootItemCondition.Builder IN_COLD_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.COLD_OCEAN));
    public static final LootItemCondition.Builder IN_DEEP_COLD_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.DEEP_COLD_OCEAN));
    public static final LootItemCondition.Builder IN_STONY_PEAKS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.STONY_PEAKS));
    public static final LootItemCondition.Builder IN_MEADOW = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.MEADOW));
    public static final LootItemCondition.Builder IN_WINDSWEPT_HILLS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.WINDSWEPT_HILLS));
    public static final LootItemCondition.Builder IN_WINDSWEPT_GRAVELLY_HILLS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.WINDSWEPT_GRAVELLY_HILLS));
    public static final LootItemCondition.Builder IN_WINDSWEPT_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.WINDSWEPT_FOREST));
    public static final LootItemCondition.Builder IN_TAIGA = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.TAIGA));
    public static final LootItemCondition.Builder IN_OLD_GROWTH_PINE_TAIGA = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.OLD_GROWTH_PINE_TAIGA));
    public static final LootItemCondition.Builder IN_OLD_GROWTH_SPRUCE_TAIGA = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.OLD_GROWTH_SPRUCE_TAIGA));
    public static final LootItemCondition.Builder IN_STONY_SHORE = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.STONY_SHORE));
    // temperate biomes
    public static final LootItemCondition.Builder IN_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.OCEAN));
    public static final LootItemCondition.Builder IN_DEEP_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.DEEP_OCEAN));
    public static final LootItemCondition.Builder IN_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.FOREST));
    public static final LootItemCondition.Builder IN_FLOWER_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.FLOWER_FOREST));
    public static final LootItemCondition.Builder IN_BIRCH_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.BIRCH_FOREST));
    public static final LootItemCondition.Builder IN_OLD_GROWTH_BIRCH_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.OLD_GROWTH_BIRCH_FOREST));
    public static final LootItemCondition.Builder IN_DARK_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.DARK_FOREST));
    public static final LootItemCondition.Builder IN_RIVER = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.RIVER));
    public static final LootItemCondition.Builder IN_BEACH = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.BEACH));
    public static final LootItemCondition.Builder IN_PLAINS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.PLAINS));
    public static final LootItemCondition.Builder IN_SUNFLOWER_PLAINS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.SUNFLOWER_PLAINS));
    // tropic biomes
    public static final LootItemCondition.Builder IN_LUKEWARM_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.LUKEWARM_OCEAN));
    public static final LootItemCondition.Builder IN_DEEP_LUKEWARM_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.DEEP_LUKEWARM_OCEAN));
    public static final LootItemCondition.Builder IN_MUSHROOM_FIELDS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.MUSHROOM_FIELDS));
    public static final LootItemCondition.Builder IN_JUNGLE = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.JUNGLE));
    public static final LootItemCondition.Builder IN_SPARSE_JUNGLE = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.SPARSE_JUNGLE));
    public static final LootItemCondition.Builder IN_BAMBOO_JUNGLE = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.BAMBOO_JUNGLE));
    public static final LootItemCondition.Builder IN_SWAMP = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.SWAMP));
    public static final LootItemCondition.Builder IN_MANGROVE_SWAMP = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.MANGROVE_SWAMP));
    // warm biomes
    public static final LootItemCondition.Builder IN_WARM_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.WARM_OCEAN));
    public static final LootItemCondition.Builder IN_SAVANNA = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.SAVANNA));
    public static final LootItemCondition.Builder IN_SAVANNA_PLATEAU = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.SAVANNA_PLATEAU));
    public static final LootItemCondition.Builder IN_WINDSWEPT_SAVANNA = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.WINDSWEPT_SAVANNA));
    // arid biomes
    public static final LootItemCondition.Builder IN_DESERT = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.DESERT));
    public static final LootItemCondition.Builder IN_BADLANDS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.BADLANDS));
    public static final LootItemCondition.Builder IN_WOODED_BADLANDS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.WOODED_BADLANDS));
    public static final LootItemCondition.Builder IN_ERODED_BADLANDS = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.ERODED_BADLANDS));
    // underground biomes
    public static final LootItemCondition.Builder IN_DEEP_DARK = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.DEEP_DARK));
    public static final LootItemCondition.Builder IN_DRIPSTONE_CAVES = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.DRIPSTONE_CAVES));
    public static final LootItemCondition.Builder IN_LUSH_CAVES = LocationCheck.checkLocation(LocationPredicate.Builder.location()
            .setBiome(Biomes.LUSH_CAVES));
}