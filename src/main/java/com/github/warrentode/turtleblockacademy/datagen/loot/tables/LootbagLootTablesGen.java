package com.github.warrentode.turtleblockacademy.datagen.loot.tables;

import com.github.warrentode.turtleblockacademy.loot.tables.DimDungeonLootTables;
import com.github.warrentode.turtleblockacademy.loot.tables.KitchenLootTables;
import com.github.warrentode.turtleblockacademy.loot.tables.LootbagLootTables;
import com.github.warrentode.turtleblockacademy.loot.tables.PackBuiltInLootTables;
import com.github.warrentode.turtleblockacademy.util.TBATags;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.entries.TagEntry;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetNbtFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.world.TinkerWorld;
import tech.thatgravyboat.lootbags.common.registry.McRegistry;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static com.github.warrentode.turtleblockacademy.datagen.loot.TBALootProviders.IN_MINING;


public class LootbagLootTablesGen implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {
    @Override
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(LootbagLootTables.DECO_BAG, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(6))
                        .setBonusRolls(ConstantValue.exactly(0))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.PLUSHIES))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.BATH_DECO))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.ART_DECO))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.COOKERY_DECO))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.GARDEN_DECO))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.SCIENCE_DECO))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.COOKERY_DECO))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.HOLIDAY_DECO))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.MISC_DECO))
                )
        );

        consumer.accept(LootbagLootTables.PLUSHIE_BAG, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .setBonusRolls(ConstantValue.exactly(0))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.PLUSHIES))
                )
        );
        consumer.accept(LootbagLootTables.LOOTBAG_CURRENCY, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(4, 10))
                        .setBonusRolls(ConstantValue.exactly(0))
                        .add(TagEntry.expandTag(TBATags.Items.LOOTBAG_CURRENCY))
                )
        );

        consumer.accept(LootbagLootTables.CAGERIUM_KIT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .setBonusRolls(ConstantValue.exactly(1))
                        .add(TagEntry.expandTag(TBATags.Items.CAGERIUM_BLOCKS).setWeight(1)
                                .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                        .add(TagEntry.expandTag(TBATags.Items.CAGERIUM_ITEMS).setWeight(1)
                                .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                ));

        consumer.accept(LootbagLootTables.UFO_BAG, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.UFO))
                )
        );

        consumer.accept(LootbagLootTables.TINKERS_KIT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(TinkerWorld.rawCobalt)
                                .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                        .add(LootItem.lootTableItem(Objects.requireNonNull(TinkerFluids.blazingBlood.getBucket()))
                                .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                ));

        consumer.accept(LootbagLootTables.MUSIC_DISCS, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(TagEntry.expandTag(TBATags.Items.MUSIC_DISCS))
                ));

        consumer.accept(LootbagLootTables.SHULKER_BOXES, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .setBonusRolls(ConstantValue.exactly(0))
                        .add(TagEntry.expandTag(TBATags.Items.SHULKER_BOXES)))
        );

        consumer.accept(LootbagLootTables.BACKPACK_UPGRADES, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .setBonusRolls(ConstantValue.exactly(0))
                        .add(TagEntry.expandTag(TBATags.Items.BACKPACK_UPGRADES)))
        );

        consumer.accept(LootbagLootTables.RATIONS, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .when(LootItemRandomChanceCondition.randomChance(0.25F))
                        .add(LootTableReference.lootTableReference(DimDungeonLootTables.KIT_BASIC_SUPPLIES)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootTableReference.lootTableReference(KitchenLootTables.KITCHEN)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.LOG_SET)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.LOG_SET))
                        .when(IN_MINING))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootItem.lootTableItem(Items.STONE_PICKAXE)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootItem.lootTableItem(Items.CHARCOAL)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(6.0F, 10.0F)))))
        );

        consumer.accept(LootbagLootTables.NEW_YEAR_LOOTBAG, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2))
                        .add(LootTableReference.lootTableReference(KitchenLootTables.FESTIVEDELIGHT_EDIBLES))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.HOLIDAY_DECO))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2))
                        .add(LootItem.lootTableItem(Items.FIREWORK_ROCKET)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 8.0F))))
                )
        );

        consumer.accept(LootbagLootTables.EASTER_LOOTBAG, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.GIFTS))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.HOLIDAY_DECO))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2))
                        .add(TagEntry.expandTag(TBATags.Items.CHOCOLATE))
                        .add(LootTableReference.lootTableReference(KitchenLootTables.FESTIVEDELIGHT_EDIBLES))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2))
                        .add(TagEntry.expandTag(TBATags.Items.EGGS)))
        );

        consumer.accept(LootbagLootTables.ANNIVERSARY_LOOTBAG, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.GIFTS))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.HOLIDAY_DECO))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3))
                        .add(LootTableReference.lootTableReference(KitchenLootTables.DRINKBEERREFILL_EDIBLES))
                        .add(LootTableReference.lootTableReference(KitchenLootTables.FESTIVEDELIGHT_EDIBLES))
                )
        );

        consumer.accept(LootbagLootTables.CHRISTMAS_LOOTBAG, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.GIFTS))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.HOLIDAY_DECO))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3))
                        .add(LootTableReference.lootTableReference(KitchenLootTables.FESTIVEDELIGHT_EDIBLES))
                        .add(LootTableReference.lootTableReference(KitchenLootTables.SNOWYSPIRIT_EDIBLES))
                )
        );

        consumer.accept(LootbagLootTables.HALLOWEEN_LOOTBAG, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.HOLIDAY_DECO))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3))
                        .add(TagEntry.expandTag(TBATags.Items.SWEETS))
                        .add(TagEntry.expandTag(TBATags.Items.TRICKS)
                                .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                ));

        consumer.accept(LootbagLootTables.BIRTHDAY_LOOTBAG, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.GIFTS))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.HOLIDAY_DECO)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3))
                        .add(TagEntry.expandTag(TBATags.Items.CAKES)))
        );

        //noinspection deprecation
        consumer.accept(LootbagLootTables.RATIONS_BAG_DROP, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootItem.lootTableItem(McRegistry.LOOT_BAG.get())
                                .apply(SetNbtFunction.setTag(Util.make(new CompoundTag(),
                                        (tag) -> {
                                            tag.putString("Type", "COMMON");
                                            tag.putString("Loot", "lootbags:rations_bag");
                                            tag.putInt("Color", 16777215);
                                            tag.putString("Name", "Rations Bag");
                                        }))))
                )
        );

        consumer.accept(LootbagLootTables.END_MAP_SALE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.END_MAPBOX))
                )
        );
        consumer.accept(LootbagLootTables.NETHER_MAP_SALE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.NETHER_MAPBOX))
                )
        );
        consumer.accept(LootbagLootTables.OCEAN_MAP_SALE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.OCEAN_MAPS))
                )
        );
        consumer.accept(LootbagLootTables.SCOUT_MAP_SALE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.SCOUT_MAPS))
                )
        );
        consumer.accept(LootbagLootTables.SWAMP_MAP_SALE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.SWAMP_MAPS))
                )
        );
        consumer.accept(LootbagLootTables.TREASURE_MAP_SALE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.TREASURE_MAPS))
                )
        );
        consumer.accept(LootbagLootTables.UNDERGROUND_MAP_SALE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.UNDERGROUND_MAPS))
                )
        );
        consumer.accept(LootbagLootTables.JUNGLE_MAP_SALE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.JUNGLE_MAPS))
                )
        );
        consumer.accept(LootbagLootTables.MASTER_MAP_SALE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.MASTER_MAPBOX))
                )
        );
    }
}
