package com.github.warrentode.turtleblockacademy.datagen.loot.tables;

import com.catastrophe573.dimdungeons.item.ItemRegistrar;
import com.github.warrentode.turtleblockacademy.datagen.loot.ModLootProviders;
import com.github.warrentode.turtleblockacademy.loot.tables.DimDungeonLootTables;
import com.github.warrentode.turtleblockacademy.loot.tables.KitchenLootTables;
import com.github.warrentode.turtleblockacademy.loot.tables.LootbagLootTables;
import com.github.warrentode.turtleblockacademy.loot.tables.PackBuiltInLootTables;
import com.github.warrentode.turtleblockacademy.util.PackTags;
import net.mcreator.justoutdoorstuffs.init.JustoutdoorstuffsModItems;
import net.mehvahdjukaar.cagerium.Cagerium;
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


public class LootbagLootTablesGen implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {
    @Override
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {

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
                        .add(TagEntry.expandTag(PackTags.Items.LOOTBAG_CURRENCY))
                )
        );
        //noinspection deprecation
        consumer.accept(LootbagLootTables.LEGENDARY, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                        .add(LootItem.lootTableItem(ItemRegistrar.ITEM_SECRET_BELL.get())
                                .apply(SetNbtFunction.setTag(Util.make(new CompoundTag(),
                                        (tag) -> tag.putInt("upgrade", 2))))
                                .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.LOOTBAG_CURRENCY))
                        .add(TagEntry.expandTag(PackTags.Items.LOOTBAG_SPECIAL_CURRENCY)
                                .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.GEMS)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 5))))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.DUNGEON_REWARDS))
                        .add(LootItem.lootTableItem(Cagerium.CAGE_BASE.get()).setWeight(1)
                                .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                        .add(LootItem.lootTableItem(Cagerium.TERRARIUM_BASE.get()).setWeight(1)
                                .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                        .add(LootItem.lootTableItem(Cagerium.PLATE_GEM.get()).setWeight(1)
                                .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                        .add(LootItem.lootTableItem(Cagerium.CAGE_KEY.get()).setWeight(1)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 5)))
                                .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                ));
        consumer.accept(LootbagLootTables.EPIC, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.GEMS)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 5))))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.UFO).when(ModLootProviders.IN_END))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(TinkerWorld.rawCobalt)
                                .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                        .add(LootItem.lootTableItem(Objects.requireNonNull(TinkerFluids.blazingBlood.getBucket()))
                                .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                ));

        //noinspection deprecation
        consumer.accept(LootbagLootTables.RARE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.GEMS)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 5))))
                        .add(LootItem.lootTableItem(ItemRegistrar.ITEM_BLANK_THEME_KEY.get()).setWeight(1)
                                .when(LootItemRandomChanceCondition.randomChance(0.01F))
                                .apply(SetNbtFunction.setTag(Util.make(new CompoundTag(),
                                        (tag) -> tag.putInt("theme", 3)))))
                        .add(LootItem.lootTableItem(ItemRegistrar.ITEM_BLANK_THEME_KEY.get()).setWeight(1)
                                .when(LootItemRandomChanceCondition.randomChance(0.01F))
                                .apply(SetNbtFunction.setTag(Util.make(new CompoundTag(),
                                        (tag) -> tag.putInt("theme", 4)))))
                        .add(LootItem.lootTableItem(ItemRegistrar.ITEM_BLANK_THEME_KEY.get()).setWeight(1)
                                .when(LootItemRandomChanceCondition.randomChance(0.01F))
                                .apply(SetNbtFunction.setTag(Util.make(new CompoundTag(),
                                        (tag) -> tag.putInt("theme", 5)))))
                        .add(LootItem.lootTableItem(ItemRegistrar.ITEM_BLANK_THEME_KEY.get()).setWeight(1)
                                .when(LootItemRandomChanceCondition.randomChance(0.01F))
                                .apply(SetNbtFunction.setTag(Util.make(new CompoundTag(),
                                        (tag) -> tag.putInt("theme", 6)))))
                        .add(LootItem.lootTableItem(Items.BELL).when(LootItemRandomChanceCondition.randomChance(0.25F)))
                        .add(TagEntry.expandTag(PackTags.Items.MUSIC_DISCS))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.REFINED_STORAGE_GIFTS)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                ));
        consumer.accept(LootbagLootTables.UNCOMMON, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(JustoutdoorstuffsModItems.BLUEPRINT_GARDEN_STUFFS.get()))
                        .add(LootItem.lootTableItem(JustoutdoorstuffsModItems.BLUEPRINT_PATIO_STUFFS.get()))
                        .add(TagEntry.expandTag(PackTags.Items.DOOR_PATTERNS))
                        .add(TagEntry.expandTag(PackTags.Items.TRAPDOOR_PATTERNS))
                        .add(TagEntry.expandTag(PackTags.Items.BACKPACK_UPGRADES)
                                .when(LootItemRandomChanceCondition.randomChance(0.05F)))
                        .add(TagEntry.expandTag(PackTags.Items.SHULKER_BOXES).when(ModLootProviders.IN_END)
                                .when(LootItemRandomChanceCondition.randomChance(0.05F)))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.GIFTS)
                                .when(LootItemRandomChanceCondition.randomChance(0.25F)))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(DimDungeonLootTables.KIT_MISC))
                ));

        consumer.accept(LootbagLootTables.COMMON, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootTableReference.lootTableReference(DimDungeonLootTables.KIT_RANDOM)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootTableReference.lootTableReference(DimDungeonLootTables.KIT_MISC)))
        );

        consumer.accept(LootbagLootTables.RATIONS, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootTableReference.lootTableReference(KitchenLootTables.KITCHEN))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.SPAWN_BONUS_CHEST)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootItem.lootTableItem(Items.STONE_PICKAXE))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootItem.lootTableItem(Items.CHARCOAL)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(6.0F, 10.0F))))
                )
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
                        .add(TagEntry.expandTag(PackTags.Items.CHOCOLATE))
                        .add(LootTableReference.lootTableReference(KitchenLootTables.FESTIVEDELIGHT_EDIBLES))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2))
                        .add(TagEntry.expandTag(PackTags.Items.EGGS)))
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
                        .add(TagEntry.expandTag(PackTags.Items.SWEETS))
                        .add(TagEntry.expandTag(PackTags.Items.TRICKS)
                                .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                ));

        consumer.accept(LootbagLootTables.BIRTHDAY_LOOTBAG, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.GIFTS))
                        .add(LootTableReference.lootTableReference(PackBuiltInLootTables.HOLIDAY_DECO)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3))
                        .add(TagEntry.expandTag(PackTags.Items.CAKES)))
        );

        //noinspection deprecation
        consumer.accept(LootbagLootTables.LEGENDARY_BAG_DROP, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootItem.lootTableItem(McRegistry.LOOT_BAG.get())
                                .apply(SetNbtFunction.setTag(Util.make(new CompoundTag(),
                                        (tag) -> {
                                            tag.putString("Type", "LEGENDARY");
                                            tag.putString("Loot", "lootbags:legendary_bag");
                                            tag.putInt("Color", 3329330);
                                            tag.putString("Name", "Loot Bag (Legendary)");
                                        }))))
                )
        );

        //noinspection deprecation
        consumer.accept(LootbagLootTables.BIRTHDAY_BAG_DROP, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootItem.lootTableItem(McRegistry.LOOT_BAG.get())
                                .apply(SetNbtFunction.setTag(Util.make(new CompoundTag(),
                                        (tag) -> {
                                            tag.putString("Type", "LEGENDARY");
                                            tag.putString("Loot", "lootbags:birthday_bag");
                                            tag.putInt("Color", 8388564);
                                            tag.putString("Name", "Birthday Bag");
                                        }))))
                )
        );

        //noinspection deprecation
        consumer.accept(LootbagLootTables.HALLOWEEN_BAG_DROP, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootItem.lootTableItem(McRegistry.LOOT_BAG.get())
                                .apply(SetNbtFunction.setTag(Util.make(new CompoundTag(),
                                        (tag) -> {
                                            tag.putString("Type", "LEGENDARY");
                                            tag.putString("Loot", "lootbags:trick_or_treat_bag");
                                            tag.putInt("Color", 16753920);
                                            tag.putString("Name", "Trick or Treat Bag");
                                        }))))
                )
        );

        //noinspection deprecation
        consumer.accept(LootbagLootTables.CHRISTMAS_BAG_DROP, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootItem.lootTableItem(McRegistry.LOOT_BAG.get())
                                .apply(SetNbtFunction.setTag(Util.make(new CompoundTag(),
                                        (tag) -> {
                                            tag.putString("Type", "LEGENDARY");
                                            tag.putString("Loot", "lootbags:christmas_bag");
                                            tag.putInt("Color", 65535);
                                            tag.putString("Name", "Christmas Bag");
                                        }))))
                )
        );

        //noinspection deprecation
        consumer.accept(LootbagLootTables.ANNIVERSARY_BAG_DROP, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootItem.lootTableItem(McRegistry.LOOT_BAG.get())
                                .apply(SetNbtFunction.setTag(Util.make(new CompoundTag(),
                                        (tag) -> {
                                            tag.putString("Type", "LEGENDARY");
                                            tag.putString("Loot", "lootbags:anniversary_bag");
                                            tag.putInt("Color", 12632256);
                                            tag.putString("Name", "Anniversary Bag");
                                        }))))
                )
        );

        //noinspection deprecation
        consumer.accept(LootbagLootTables.EASTER_BAG_DROP, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootItem.lootTableItem(McRegistry.LOOT_BAG.get())
                                .apply(SetNbtFunction.setTag(Util.make(new CompoundTag(),
                                        (tag) -> {
                                            tag.putString("Type", "LEGENDARY");
                                            tag.putString("Loot", "lootbags:easter_bag");
                                            tag.putInt("Color", 15132410);
                                            tag.putString("Name", "Easter Bag");
                                        }))))
                )
        );

        //noinspection deprecation
        consumer.accept(LootbagLootTables.NEW_YEAR_BAG_DROP, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootItem.lootTableItem(McRegistry.LOOT_BAG.get())
                                .apply(SetNbtFunction.setTag(Util.make(new CompoundTag(),
                                        (tag) -> {
                                            tag.putString("Type", "LEGENDARY");
                                            tag.putString("Loot", "lootbags:new_year_bag");
                                            tag.putInt("Color", 16766720);
                                            tag.putString("Name", "New Year Bag");
                                        }))))
                )
        );

        //noinspection deprecation
        consumer.accept(LootbagLootTables.EPIC_BAG_DROP, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootItem.lootTableItem(McRegistry.LOOT_BAG.get())
                                .apply(SetNbtFunction.setTag(Util.make(new CompoundTag(),
                                        (tag) -> {
                                            tag.putString("Type", "EPIC");
                                            tag.putString("Loot", "lootbags:epic_bag");
                                            tag.putInt("Color", 8388736);
                                            tag.putString("Name", "Loot Bag (Epic)");
                                        }))))
                )
        );

        //noinspection deprecation
        consumer.accept(LootbagLootTables.RARE_BAG_DROP, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootItem.lootTableItem(McRegistry.LOOT_BAG.get())
                                .apply(SetNbtFunction.setTag(Util.make(new CompoundTag(),
                                        (tag) -> {
                                            tag.putString("Type", "RARE");
                                            tag.putString("Loot", "lootbags:rare_bag");
                                            tag.putInt("Color", 16766720);
                                            tag.putString("Name", "Loot Bag (Rare)");
                                        }))))
                )
        );

        //noinspection deprecation
        consumer.accept(LootbagLootTables.LUCKY_LOOTBAG_DROP, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootItem.lootTableItem(McRegistry.LOOT_BAG.get())
                                .apply(SetNbtFunction.setTag(Util.make(new CompoundTag(),
                                        (tag) -> {
                                            tag.putString("Type", "RARE");
                                            tag.putString("Loot", "lootbags:lucky_bag");
                                            tag.putInt("Color", 16766720);
                                            tag.putString("Name", "Lucky Bag");
                                        }))))
                )
        );

        //noinspection deprecation
        consumer.accept(LootbagLootTables.UNCOMMON_BAG_DROP, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootItem.lootTableItem(McRegistry.LOOT_BAG.get())
                                .apply(SetNbtFunction.setTag(Util.make(new CompoundTag(),
                                        (tag) -> {
                                            tag.putString("Type", "UNCOMMON");
                                            tag.putString("Loot", "lootbags:uncommon_bag");
                                            tag.putInt("Color", 255);
                                            tag.putString("Name", "Loot Bag (Uncommon)");
                                        }))))
                )
        );

        //noinspection deprecation
        consumer.accept(LootbagLootTables.COMMON_BAG_DROP, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootItem.lootTableItem(McRegistry.LOOT_BAG.get())
                                .apply(SetNbtFunction.setTag(Util.make(new CompoundTag(),
                                        (tag) -> {
                                            tag.putString("Type", "COMMON");
                                            tag.putString("Loot", "lootbags:common_bag");
                                            tag.putInt("Color", 16777215);
                                            tag.putString("Name", "Loot Bag (Common)");
                                        }))))
                )
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

        consumer.accept(LootbagLootTables.LOOT_BAG_DROPS, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)).setBonusRolls(ConstantValue.exactly(0))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.LEGENDARY_BAG_DROP).setWeight(1).setQuality(6)
                                .when(LootItemRandomChanceCondition.randomChance(0.01F)))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.BIRTHDAY_BAG_DROP).setWeight(1)
                                .setQuality(5).when(ModLootProviders.BIRTHDAY_EVENT)
                                .when(LootItemRandomChanceCondition.randomChance(0.02F)))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.HALLOWEEN_BAG_DROP).setWeight(1)
                                .setQuality(5).when(ModLootProviders.HALLOWEEN_EVENT)
                                .when(LootItemRandomChanceCondition.randomChance(0.02F)))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.CHRISTMAS_BAG_DROP).setWeight(1)
                                .setQuality(5).when(ModLootProviders.CHRISTMAS_EVENT)
                                .when(LootItemRandomChanceCondition.randomChance(0.02F)))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.ANNIVERSARY_BAG_DROP).setWeight(1)
                                .setQuality(5).when(ModLootProviders.ANNIVERSARY_EVENT)
                                .when(LootItemRandomChanceCondition.randomChance(0.02F)))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.EASTER_BAG_DROP).setWeight(1)
                                .setQuality(5).when(ModLootProviders.EASTER_EVENT)
                                .when(LootItemRandomChanceCondition.randomChance(0.02F)))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.NEW_YEAR_BAG_DROP).setWeight(1)
                                .setQuality(5).when(ModLootProviders.NEW_YEAR_EVENT)
                                .when(LootItemRandomChanceCondition.randomChance(0.02F)))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.EPIC_BAG_DROP).setWeight(2).setQuality(4)
                                .when(LootItemRandomChanceCondition.randomChance(0.03F)))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.RARE_BAG_DROP).setWeight(3).setQuality(3)
                                .when(LootItemRandomChanceCondition.randomChance(0.04F)))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.LUCKY_LOOTBAG_DROP).setWeight(3).setQuality(3)
                                .when(LootItemRandomChanceCondition.randomChance(0.04F)))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.UNCOMMON_BAG_DROP).setWeight(4).setQuality(2)
                                .when(LootItemRandomChanceCondition.randomChance(0.05F)))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.COMMON_BAG_DROP).setWeight(5).setQuality(1)
                                .when(ModLootProviders.IN_MINING.or(ModLootProviders.UNDERGROUND))
                                .when(LootItemRandomChanceCondition.randomChance(0.06F)))
                        .add(LootTableReference.lootTableReference(LootbagLootTables.RATIONS_BAG_DROP).setWeight(5).setQuality(1)
                                .when(ModLootProviders.IN_MINING.or(ModLootProviders.UNDERGROUND))
                                .when(LootItemRandomChanceCondition.randomChance(0.06F)))
                ));
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
