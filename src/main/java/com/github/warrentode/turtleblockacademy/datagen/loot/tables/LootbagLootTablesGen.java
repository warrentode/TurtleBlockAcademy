package com.github.warrentode.turtleblockacademy.datagen.loot.tables;

import com.github.warrentode.turtleblockacademy.loot.tables.*;
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

import static com.github.warrentode.turtleblockacademy.datagen.loot.TBALootProviders.*;


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

        consumer.accept(LootbagLootTables.TINKERS_KIT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(TinkerWorld.rawCobalt).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                        .add(LootItem.lootTableItem(Objects.requireNonNull(TinkerFluids.blazingBlood.getBucket())).setWeight(1)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                ));

        consumer.accept(LootbagLootTables.SHULKER_BOXES, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .setBonusRolls(ConstantValue.exactly(0))
                        .add(TagEntry.expandTag(TBATags.Items.SHULKER_BOXES)))
        );

        consumer.accept(LootbagLootTables.RATIONS, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .when(LootItemRandomChanceCondition.randomChance(0.25F))
                        .add(LootTableReference.lootTableReference(KitLootTables.KIT_BASIC_SUPPLIES)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootTableReference.lootTableReference(KitchenLootTables.KITCHEN)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.LOG_SET)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.LOG_SET))
                        .when(IN_MINING))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootItem.lootTableItem(Items.STONE_PICKAXE)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(1))
                        .add(TagEntry.expandTag(TBATags.Items.CHALK)))
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
                        .add(TagEntry.expandTag(TBATags.Items.EASTER_EGGS)))
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

        consumer.accept(LootbagLootTables.HOLIDAY_LOOTBAG, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.BIRTHDAY_LOOTBAG).when(BIRTHDAY_EVENT))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.HALLOWEEN_LOOTBAG).when(HALLOWEEN_EVENT))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.CHRISTMAS_LOOTBAG).when(CHRISTMAS_EVENT))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.ANNIVERSARY_LOOTBAG).when(ANNIVERSARY_EVENT))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.EASTER_LOOTBAG).when(EASTER_EVENT))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.NEW_YEAR_LOOTBAG).when(NEW_YEAR_EVENT))
                        // default
                        .add(LootTableReference.lootTableReference(WaresLootTables.SEASONAL_SHOPPER))
                ));

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

        consumer.accept(LootbagLootTables.MASTER_MAP_SALE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.MASTER_MAPBOX))
                )
        );
    }
}