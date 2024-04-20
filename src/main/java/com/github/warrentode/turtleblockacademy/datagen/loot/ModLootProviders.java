package com.github.warrentode.turtleblockacademy.datagen.loot;

import com.aetherteam.aether.data.resources.registries.AetherDimensions;
import com.catastrophe573.dimdungeons.DimDungeons;
import com.github.warrentode.turtleblockacademy.datagen.loot.tables.KitchenLootTablesGen;
import com.github.warrentode.turtleblockacademy.datagen.loot.tables.ModBlockLootTablesGen;
import com.github.warrentode.turtleblockacademy.loot.conditions.SeasonalCondition;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import de.maxhenkel.miningdimension.Main;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
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

public class ModLootProviders extends LootTableProvider {
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>>
            loot_tables = ImmutableList.of(
            Pair.of(KitchenLootTablesGen::new, LootContextParamSets.CHEST),
            Pair.of(ModBlockLootTablesGen::new, LootContextParamSets.BLOCK)
    );

    public ModLootProviders(DataGenerator pGenerator) {
        super(pGenerator);
    }


    @Override
    protected @NotNull List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return loot_tables;
    }

    @Override
    protected void validate(@NotNull Map<ResourceLocation, LootTable> map, @NotNull ValidationContext validationTracker) {
        map.forEach((id, table) -> LootTables.validate(validationTracker, id, table));
    }

    // dimension checks
    public static final LootItemCondition.Builder IN_OVERWORLD
            = LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(Level.OVERWORLD));
    public static final LootItemCondition.Builder IN_MINING =
            LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(Main.MINING_DIMENSION));
    public static final LootItemCondition.Builder IN_NETHER =
            LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(Level.NETHER));
    public static final LootItemCondition.Builder IN_END =
            LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(Level.END));
    public static final LootItemCondition.Builder IN_AETHER =
            LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(AetherDimensions.AETHER_LEVEL));
    public static final LootItemCondition.Builder IN_DUNGEON =
            LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(DimDungeons.DUNGEON_DIMENSION));

    // holiday checks
    public static final LootItemCondition.Builder BIRTHDAY_EVENT = SeasonalCondition.season().setSeason(Boolean.valueOf("BIRTHDAY"));
    public static final LootItemCondition.Builder HALLOWEEN_EVENT = SeasonalCondition.season().setSeason(Boolean.valueOf("HALLOWEEN"));
    public static final LootItemCondition.Builder CHRISTMAS_EVENT = SeasonalCondition.season().setSeason(Boolean.valueOf("CHRISTMAS"));
    public static final LootItemCondition.Builder ANNIVERSARY_EVENT = SeasonalCondition.season().setSeason(Boolean.valueOf("ANNIVERSARY"));
    public static final LootItemCondition.Builder EASTER_EVENT = SeasonalCondition.season().setSeason(Boolean.valueOf("EASTER"));
    public static final LootItemCondition.Builder NEW_YEAR_EVENT = SeasonalCondition.season().setSeason(Boolean.valueOf("NEW_YEAR"));

    // season checks
    public static final LootItemCondition.Builder AUTUMN = SeasonalCondition.season().setSeason(Boolean.valueOf("AUTUMN"));
    public static final LootItemCondition.Builder SPRING = SeasonalCondition.season().setSeason(Boolean.valueOf("SPRING"));
    public static final LootItemCondition.Builder SUMMER = SeasonalCondition.season().setSeason(Boolean.valueOf("SUMMER"));
    public static final LootItemCondition.Builder WINTER = SeasonalCondition.season().setSeason(Boolean.valueOf("WINTER"));
}