package com.github.warrentode.turtleblockacademy.datagen.loot.tables;

import cn.foggyhillside.endsdelight.registry.ItemRegistry;
import com.faboslav.friendsandfoes.init.FriendsAndFoesItems;
import com.github.warrentode.turtleblockacademy.loot.tables.CageriumLootTables;
import com.github.warrentode.turtleblockacademy.util.PackTags;
import com.scouter.oceansdelight.items.ODItems;
import net.brnbrd.delightful.common.item.DelightfulItems;
import net.mcreator.phantasm.init.PhantasmModItems;
import net.mcreator.unusualend.init.UnusualendModItems;
import net.minecraft.advancements.critereon.EntityFlagsPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.InstrumentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.entries.TagEntry;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;
import umpaz.nethersdelight.common.registry.NDItems;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CageriumLootTablesGen implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {
    // the primary purpose of these tables is to keep currency out of the auto farming system to preserve gameplay
    // balance and this needs to be hardcoded into this class to prevent GLM from accidentally landing in these tables
    protected static final EntityPredicate.Builder ENTITY_ON_FIRE = EntityPredicate.Builder.entity()
            .flags(EntityFlagsPredicate.Builder.flags().setOnFire(true).build());

    @Override
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(CageriumLootTables.WITHER, LootTable.lootTable());
        consumer.accept(CageriumLootTables.DRAGLING, LootTable.lootTable());
        consumer.accept(CageriumLootTables.ENDSTONE_TRAPPER, LootTable.lootTable());
        consumer.accept(CageriumLootTables.ENDSTONE_GOLEM, LootTable.lootTable());

        consumer.accept(CageriumLootTables.SHEEP, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.SHEEP_BLACK).setWeight(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.SHEEP_BLUE).setWeight(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.SHEEP_BROWN).setWeight(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.SHEEP_CYAN).setWeight(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.SHEEP_GREEN).setWeight(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.SHEEP_GRAY).setWeight(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.SHEEP_LIGHT_BLUE).setWeight(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.SHEEP_LIGHT_GRAY).setWeight(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.SHEEP_LIME).setWeight(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.SHEEP_MAGENTA).setWeight(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.SHEEP_ORANGE).setWeight(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.SHEEP_PINK).setWeight(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.SHEEP_PURPLE).setWeight(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.SHEEP_RED).setWeight(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.SHEEP_YELLOW).setWeight(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.SHEEP_WHITE).setWeight(20)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.MUTTON).apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(SmeltItemFunction.smelted()
                                        .when(LootItemEntityPropertyCondition
                                                .hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                ));

        consumer.accept(CageriumLootTables.SHEEP_YELLOW, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.YELLOW_WOOL))));
        consumer.accept(CageriumLootTables.SHEEP_WHITE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.WHITE_WOOL))));
        consumer.accept(CageriumLootTables.SHEEP_RED, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.RED_WOOL))));
        consumer.accept(CageriumLootTables.SHEEP_PURPLE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.PURPLE_WOOL))));
        consumer.accept(CageriumLootTables.SHEEP_PINK, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.PINK_WOOL))));
        consumer.accept(CageriumLootTables.SHEEP_ORANGE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.ORANGE_WOOL))));
        consumer.accept(CageriumLootTables.SHEEP_MAGENTA, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.MAGENTA_WOOL))));
        consumer.accept(CageriumLootTables.SHEEP_LIME, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.LIME_WOOL))));
        consumer.accept(CageriumLootTables.SHEEP_LIGHT_GRAY, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.LIGHT_GRAY_WOOL))));
        consumer.accept(CageriumLootTables.SHEEP_LIGHT_BLUE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.LIGHT_BLUE_WOOL))));
        consumer.accept(CageriumLootTables.SHEEP_GREEN, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.GREEN_WOOL))));
        consumer.accept(CageriumLootTables.SHEEP_GRAY, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.GRAY_WOOL))));
        consumer.accept(CageriumLootTables.SHEEP_CYAN, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.CYAN_WOOL))));
        consumer.accept(CageriumLootTables.SHEEP_BROWN, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.BROWN_WOOL))));
        consumer.accept(CageriumLootTables.SHEEP_BLUE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.BLUE_WOOL))));
        consumer.accept(CageriumLootTables.SHEEP_BLACK, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.BLACK_WOOL))));

        consumer.accept(CageriumLootTables.BAT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0F, 1.0F))
                        .add(LootItem.lootTableItem(Items.RABBIT_HIDE)
                                .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                ));

        consumer.accept(CageriumLootTables.OCELOT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.CAT_MORNING_GIFT)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                        .add(LootItem.lootTableItem(Items.STRING)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))))
                ));

        consumer.accept(CageriumLootTables.PILLAGER, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.FLETCHER_GIFT)
                                .when(LootItemRandomChanceCondition.randomChance(0.01F)))
                        .add(LootItem.lootTableItem(Items.CROSSBOW)
                                .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                ));

        consumer.accept(CageriumLootTables.VEX, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0F, 1.0F))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.ALLAY))
                        .add(LootItem.lootTableItem(Items.TOTEM_OF_UNDYING)
                                .when(LootItemRandomChanceCondition.randomChance(0.01F)))
                        .add(LootItem.lootTableItem(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get())
                                .when(LootItemRandomChanceCondition.randomChance(0.01F)))
                        .add(LootItem.lootTableItem(FriendsAndFoesItems.TOTEM_OF_FREEZING.get())
                                .when(LootItemRandomChanceCondition.randomChance(0.01F)))
                ));

        consumer.accept(CageriumLootTables.TADPOLE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0F, 1.0F))
                        .add(LootItem.lootTableItem(Items.SLIME_BALL)
                                .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                ));

        consumer.accept(CageriumLootTables.AXOLOTL, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.FISHING_FISH)
                                .when(LootItemRandomChanceCondition.randomChance(0.25F)))
                ));

        consumer.accept(CageriumLootTables.PIGLIN, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.PIGLIN_BARTERING))
                        .add(TagEntry.expandTag(ItemTags.PIGLIN_LOVED)
                                .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                        .add(TagEntry.expandTag(ItemTags.PIGLIN_FOOD))
                ));

        consumer.accept(CageriumLootTables.PIGLIN_BRUTE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.WEAPONSMITH_GIFT)
                                .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                        .add(TagEntry.expandTag(ItemTags.PIGLIN_FOOD))
                ));

        consumer.accept(CageriumLootTables.ALLAY, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.GIFTS))
                ));

        consumer.accept(CageriumLootTables.BEE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F))
                        .add(LootItem.lootTableItem(Items.HONEY_BOTTLE)
                                .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                        .add(LootItem.lootTableItem(Items.HONEYCOMB)
                                .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                ));

        consumer.accept(CageriumLootTables.ILLUSIONER, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get())))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.EMERALD).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 1.0F))))
                        .when(LootItemRandomChanceCondition.randomChance(0.02F))
                ));

        consumer.accept(CageriumLootTables.ICEOLOGER, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(FriendsAndFoesItems.TOTEM_OF_FREEZING.get())))
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.EMERALD)
                                .apply(SetItemCountFunction.setCount(
                                        UniformGenerator.between(0.0F, 1.0F)))
                                .apply(LootingEnchantFunction.lootingMultiplier(
                                        UniformGenerator.between(0.0F, 1.0F))))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer())));

        consumer.accept(CageriumLootTables.WILDFIRE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(3.0F, 5.0F))
                        .add(LootItem.lootTableItem(FriendsAndFoesItems.WILDFIRE_CROWN_FRAGMENT.get()))
                ));

        consumer.accept(CageriumLootTables.MOOBLOOM, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(TagEntry.expandTag(ItemTags.FLOWERS))
                        .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.LEATHER)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.BEEF).apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(1.0F, 3.0F)))
                                .apply(SmeltItemFunction.smelted()
                                        .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                ));

        consumer.accept(CageriumLootTables.VILLAGER, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.01F))
                        .add(LootItem.lootTableItem(Items.VILLAGER_SPAWN_EGG)))
        );

        consumer.accept(CageriumLootTables.TODEPIGLINMERCHANT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.PIGLIN_BARTERING)
                                .when(LootItemRandomChanceCondition.randomChance(0.25F)))
                ));

        consumer.accept(CageriumLootTables.WANDERING_TRADER, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.GIFTS)
                                .when(LootItemRandomChanceCondition.randomChance(0.25F)))
                ));

        consumer.accept(CageriumLootTables.NUMISMATIST, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.GIFTS)
                                .when(LootItemRandomChanceCondition.randomChance(0.25F)))
                ));

        consumer.accept(CageriumLootTables.FROG, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.SLIME_BALL)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))))
                        .add(LootItem.lootTableItem(Items.PEARLESCENT_FROGLIGHT)
                                .when(LootItemRandomChanceCondition.randomChance(0.02F)))
                        .add(LootItem.lootTableItem(Items.VERDANT_FROGLIGHT)
                                .when(LootItemRandomChanceCondition.randomChance(0.02F)))
                        .add(LootItem.lootTableItem(Items.OCHRE_FROGLIGHT)
                                .when(LootItemRandomChanceCondition.randomChance(0.02F)))
                ));

        consumer.accept(CageriumLootTables.ENDER_DRAGON, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.DRAGON_EGG)))
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 2))
                        .setBonusRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.DRAGON_HEAD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.DRAGON_BREATH).setWeight(1))
                        .add(LootItem.lootTableItem(ItemRegistry.DragonTooth.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ItemRegistry.DragonEggShell.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ItemRegistry.NonHatchableDragonEgg.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ItemRegistry.DragonLegBlock.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ItemRegistry.DragonTooth.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ItemRegistry.RawDragonMeat.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ItemRegistry.DragonTooth.get()).setWeight(1))
                ));

        consumer.accept(CageriumLootTables.CAT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.CAT_MORNING_GIFT)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                        .add(LootItem.lootTableItem(Items.STRING)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))))
                ));

        consumer.accept(CageriumLootTables.CAVE_SPIDER, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.STRING)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.SPIDER_EYE)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(-1.0F, 1.0F))))
                ));

        consumer.accept(CageriumLootTables.CHICKEN, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.FEATHER)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.EGG)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.CHICKEN).apply(SmeltItemFunction.smelted()
                                .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                ));

        consumer.accept(CageriumLootTables.COD, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.COD).apply(SmeltItemFunction.smelted()
                                .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.BONE_MEAL))
                ));

        consumer.accept(CageriumLootTables.COW, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ModItems.MILK_BOTTLE.get())
                                .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                        .add(LootItem.lootTableItem(Items.LEATHER)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.BEEF).apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(1.0F, 3.0F)))
                                .apply(SmeltItemFunction.smelted()
                                        .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                ));

        consumer.accept(CageriumLootTables.CREEPER, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.GUNPOWDER)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(TagEntry.expandTag(PackTags.Items.MUSIC_DISCS))
                        .when(LootItemRandomChanceCondition.randomChance(0.02F))
                ));

        consumer.accept(CageriumLootTables.DOLPHIN, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.COD).apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(SmeltItemFunction.smelted()
                                        .when(LootItemEntityPropertyCondition
                                                .hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                ));

        consumer.accept(CageriumLootTables.DONKEY, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F))))
                ));

        consumer.accept(CageriumLootTables.DROWNED, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.COPPER_INGOT))
                ));

        consumer.accept(CageriumLootTables.ELDER_GUARDIAN, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.PRISMARINE_CRYSTALS))
                        .add(LootItem.lootTableItem(Blocks.WET_SPONGE).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 1.0F))))
                        .add(LootItem.lootTableItem(Items.PRISMARINE_SHARD).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ODItems.GUARDIAN.get()))
                        .add(LootItem.lootTableItem(ODItems.ELDER_GUARDIAN_SLAB.get()))
                        .add(LootItem.lootTableItem(ODItems.GUARDIAN_TAIL.get()))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.FISHING_FISH)
                                .apply(SmeltItemFunction.smelted()
                                        .when(LootItemEntityPropertyCondition
                                                .hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                ));

        consumer.accept(CageriumLootTables.ENDERMAN, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.ENDER_PEARL).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 1.0F))))
                ));

        consumer.accept(CageriumLootTables.EVOKER, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.TOTEM_OF_UNDYING)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.EMERALD).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 1.0F))))
                        .when(LootItemRandomChanceCondition.randomChance(0.02F))
                ));

        consumer.accept(CageriumLootTables.GHAST, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.GHAST_TEAR).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.GUNPOWDER).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F))))
                ));

        consumer.accept(CageriumLootTables.GLOW_SQUID, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ODItems.TENTACLES.get()))
                        .add(LootItem.lootTableItem(Items.GLOW_INK_SAC).apply(SetItemCountFunction.
                                setCount(UniformGenerator.between(1.0F, 3.0F))))
                ));

        consumer.accept(CageriumLootTables.GUARDIAN, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.PRISMARINE_CRYSTALS))
                        .add(LootItem.lootTableItem(Items.PRISMARINE_SHARD).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.FISHING_FISH)
                                .apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition
                                        .hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                        .add(LootItem.lootTableItem(ODItems.GUARDIAN.get()))
                        .add(LootItem.lootTableItem(ODItems.GUARDIAN_TAIL.get()))
                ));

        consumer.accept(CageriumLootTables.HORSE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F))))
                ));

        consumer.accept(CageriumLootTables.HUSK, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.IRON_INGOT))
                        .add(LootItem.lootTableItem(Items.CARROT))
                        .add(LootItem.lootTableItem(Items.POTATO)
                                .apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition
                                        .hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                        .when(LootItemRandomChanceCondition.randomChance(0.02F))
                ));

        consumer.accept(CageriumLootTables.RAVAGER, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(DelightfulItems.VENISON_CHOPS.get()).apply(SetItemCountFunction
                                        .setCount(ConstantValue.exactly(1F)))
                                .apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition
                                        .hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
                                .when(LootItemRandomChanceCondition.randomChance(0.02F)))
                        .add(LootItem.lootTableItem(Items.SADDLE).apply(SetItemCountFunction
                                .setCount(ConstantValue.exactly(1.0F))))
                ));

        consumer.accept(CageriumLootTables.IRON_GOLEM, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.POPPY).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.IRON_INGOT).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(3.0F, 5.0F))))
                ));

        consumer.accept(CageriumLootTables.LLAMA, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F))))
                ));

        consumer.accept(CageriumLootTables.MAGMA_CUBE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.MAGMA_CREAM).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(-2.0F, 1.0F))))
                ));

        consumer.accept(CageriumLootTables.MULE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F))))
                ));

        consumer.accept(CageriumLootTables.MOOSHROOM, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.BEEF).apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(1.0F, 3.0F)))
                                .apply(SmeltItemFunction.smelted()
                                        .when(LootItemEntityPropertyCondition
                                                .hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                ));

        consumer.accept(CageriumLootTables.PANDA, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.BAMBOO).apply(SetItemCountFunction
                                .setCount(ConstantValue.exactly(1.0F))))
                ));

        consumer.accept(CageriumLootTables.PARROT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.FEATHER).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(1.0F, 2.0F))))
                ));

        consumer.accept(CageriumLootTables.PHANTOM, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.PHANTOM_MEMBRANE).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 1.0F))))
                ));

        consumer.accept(CageriumLootTables.PIG, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ModItems.HAM.get()).apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(1.0F, 3.0F)))
                                .apply(SmeltItemFunction.smelted()
                                        .when(LootItemEntityPropertyCondition
                                                .hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                        .add(LootItem.lootTableItem(Items.PORKCHOP).apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(1.0F, 3.0F)))
                                .apply(SmeltItemFunction.smelted()
                                        .when(LootItemEntityPropertyCondition
                                                .hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                ));

        consumer.accept(CageriumLootTables.POLAR_BEAR, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.COD).apply(SmeltItemFunction.smelted()
                                        .when(LootItemEntityPropertyCondition
                                                .hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
                                .setWeight(3).apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(0.0F, 2.0F))))
                        .add(LootItem.lootTableItem(Items.SALMON).apply(SmeltItemFunction.smelted()
                                        .when(LootItemEntityPropertyCondition
                                                .hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
                                .setWeight(3).apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(0.0F, 2.0F))))
                ));

        consumer.accept(CageriumLootTables.PUFFERFISH, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ODItems.FUGU_SLICE.get()))
                        .add(LootItem.lootTableItem(Items.PUFFERFISH)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.BONE_MEAL))
                        .when(LootItemRandomChanceCondition.randomChance(0.05F))
                ));

        consumer.accept(CageriumLootTables.RABBIT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.RABBIT_HIDE).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.RABBIT).apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(SmeltItemFunction.smelted()
                                        .when(LootItemEntityPropertyCondition
                                                .hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.RABBIT_FOOT))
                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                ));

        consumer.accept(CageriumLootTables.SALMON, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.SALMON).apply(SmeltItemFunction.smelted()
                                .when(LootItemEntityPropertyCondition
                                        .hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.BONE_MEAL))
                        .when(LootItemRandomChanceCondition.randomChance(0.05F))
                ));

        consumer.accept(CageriumLootTables.SHULKER, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.SHULKER_SHELL))
                        .add(LootItem.lootTableItem(ItemRegistry.ShulkerMeat.get()))
                ));

        consumer.accept(CageriumLootTables.SKELETON, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.ARROW).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.BONE).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F))))
                ));

        consumer.accept(CageriumLootTables.SKELETON_HORSE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.BONE).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F))))
                ));

        consumer.accept(CageriumLootTables.SLIME, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.SLIME_BALL).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F))))
                ));

        consumer.accept(CageriumLootTables.SNOW_GOLEM, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.SNOWBALL).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 15.0F))))
                ));

        consumer.accept(CageriumLootTables.SPIDER, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.STRING).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.SPIDER_EYE).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(-1.0F, 1.0F))))
                ));

        consumer.accept(CageriumLootTables.SQUID, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ODItems.TENTACLES.get()))
                        .add(LootItem.lootTableItem(Items.INK_SAC).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(1.0F, 3.0F))))
                ));

        consumer.accept(CageriumLootTables.STRAY, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.ARROW).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.BONE).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.TIPPED_ARROW).apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(SetPotionFunction.setPotion(Potions.SLOWNESS)))
                        .when(LootItemRandomChanceCondition.randomChance(0.02F))
                ));

        consumer.accept(CageriumLootTables.STRIDER, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(NDItems.STRIDER_SLICE.get()))
                        .add(LootItem.lootTableItem(Items.STRING).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(2.0F, 5.0F))))
                ));

        consumer.accept(CageriumLootTables.TRADER_LLAMA, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F))))
                ));

        consumer.accept(CageriumLootTables.TROPICAL_FISH, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.TROPICAL_FISH).apply(SetItemCountFunction
                                .setCount(ConstantValue.exactly(1.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.BONE_MEAL))
                        .when(LootItemRandomChanceCondition.randomChance(0.05F))
                ));

        consumer.accept(CageriumLootTables.TURTLE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.SEAGRASS).setWeight(3)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.TURTLE_EGG))
                        .when(LootItemRandomChanceCondition.randomChance(0.02F))
                ));

        consumer.accept(CageriumLootTables.WARDEN, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.SCULK_CATALYST))
                ));

        consumer.accept(CageriumLootTables.VINDICATOR, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.EMERALD).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 1.0F))))
                        .when(LootItemRandomChanceCondition.randomChance(0.02F))
                ));

        consumer.accept(CageriumLootTables.WITCH, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F))
                        .add(LootItem.lootTableItem(Items.GLOWSTONE_DUST).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F))))
                        .add(LootItem.lootTableItem(Items.SUGAR).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F))))
                        .add(LootItem.lootTableItem(Items.REDSTONE).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F))))
                        .add(LootItem.lootTableItem(Items.SPIDER_EYE).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F))))
                        .add(LootItem.lootTableItem(Items.GLASS_BOTTLE).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F))))
                        .add(LootItem.lootTableItem(Items.GUNPOWDER).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F))))
                        .add(LootItem.lootTableItem(Items.STICK).setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))))
                ));

        consumer.accept(CageriumLootTables.WITHER_SKELETON, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.COAL).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(-1.0F, 1.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.BONE).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.WITHER_SKELETON_SKULL))
                        .when(LootItemRandomChanceCondition.randomChance(0.02F))
                ));

        consumer.accept(CageriumLootTables.ZOGLIN, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(1.0F, 3.0F))))
                ));

        consumer.accept(CageriumLootTables.ZOMBIE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.IRON_INGOT))
                        .add(LootItem.lootTableItem(Items.CARROT))
                        .add(LootItem.lootTableItem(Items.POTATO).apply(SmeltItemFunction.smelted()
                                .when(LootItemEntityPropertyCondition
                                        .hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                        .when(LootItemRandomChanceCondition.randomChance(0.02F))
                ));

        consumer.accept(CageriumLootTables.ZOMBIE_HORSE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(0.0F, 2.0F)))
                                .when(LootItemRandomChanceCondition.randomChance(0.02F)))
                ));

        consumer.accept(CageriumLootTables.ZOMBIFIED_PIGLIN, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.GOLD_NUGGET).apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .when(LootItemRandomChanceCondition.randomChance(0.02F))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.GOLD_INGOT))
                        .when(LootItemRandomChanceCondition.randomChance(0.02F))
                ));

        consumer.accept(CageriumLootTables.ENDERMITE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0F, 1.0F))
                        .add(LootItem.lootTableItem(ItemRegistry.RawEnderMiteMeat.get()))
                        .add(LootItem.lootTableItem(Items.ENDER_PEARL)
                                .when(LootItemRandomChanceCondition.randomChance(0.01F)))
                ));

        consumer.accept(CageriumLootTables.BLAZE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.BLAZE_ROD)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer())));

        consumer.accept(CageriumLootTables.HOGLIN, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ModItems.HAM.get()).apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(2.0F, 4.0F)))
                                .apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition
                                        .hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
                                .when(LootItemRandomChanceCondition.randomChance(0.02F)))
                        .add(LootItem.lootTableItem(Items.PORKCHOP).apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(2.0F, 4.0F)))
                                .apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition
                                        .hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
                                .when(LootItemRandomChanceCondition.randomChance(0.02F))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(NDItems.HOGLIN_EAR.get()))
                        .add(LootItem.lootTableItem(NDItems.HOGLIN_LOIN.get()))
                        .add(LootItem.lootTableItem(NDItems.HOGLIN_HIDE.get()).apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .when(LootItemRandomChanceCondition.randomChance(0.02F)))
                        .add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .when(LootItemRandomChanceCondition.randomChance(0.02F)))
                ));

        consumer.accept(CageriumLootTables.ZOMBIE_VILLAGER, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(0.0F, 2.0F)))
                                .when(LootItemRandomChanceCondition.randomChance(0.02F))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.IRON_INGOT))
                        .add(LootItem.lootTableItem(Items.CARROT))
                        .add(LootItem.lootTableItem(Items.POTATO)
                                .apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition
                                        .hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                        .when(LootItemRandomChanceCondition.randomChance(0.02F))
                ));

        consumer.accept(CageriumLootTables.WOLF, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.STICK)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))))
                        .add(LootItem.lootTableItem(Items.BONE)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))))
                ));

        consumer.accept(CageriumLootTables.GOAT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.GOAT_HORN))
                        .apply(SetInstrumentFunction.setInstrumentOptions(InstrumentTags.GOAT_HORNS))
                        .when(LootItemRandomChanceCondition.randomChance(0.05F))
                ));

        consumer.accept(CageriumLootTables.SILVERFISH, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F))
                        .add(LootItem.lootTableItem(Items.CLAY_BALL)
                                .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                ));

        consumer.accept(CageriumLootTables.FOX, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.CAT_MORNING_GIFT)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                        .add(LootItem.lootTableItem(Items.SWEET_BERRIES)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))))
                ));

        consumer.accept(CageriumLootTables.CRYSTIE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 1.0F))
                        .add(LootItem.lootTableItem(PhantasmModItems.STARDUST.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
                ));

        consumer.accept(CageriumLootTables.UNDEAD_ENDERLING, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 2.0F))
                        .add(LootItem.lootTableItem(UnusualendModItems.ENDERLING_SCRAP.get()).setWeight(2))
                        .add(LootItem.lootTableItem(Items.ENDER_PEARL).setWeight(1))
                        .add(LootItem.lootTableItem(Items.BONE).setWeight(1)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))))
                ));

        consumer.accept(CageriumLootTables.ENDER_FIREFLY, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(UnusualendModItems.FIREFLY_BULB.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))))
                        .add(LootItem.lootTableItem(UnusualendModItems.ENDER_FIREFLY_EGG.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))))
                ));

        consumer.accept(CageriumLootTables.ENDER_BLOB, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0F, 1.0F))
                        .add(LootItem.lootTableItem(ItemRegistry.RawEnderMiteMeat.get()))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 2.0F))
                        .add(LootItem.lootTableItem(UnusualendModItems.END_BLOB.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootItem.lootTableItem(UnusualendModItems.ENDERBLOB_MOULT.get()))
                ));

        consumer.accept(CageriumLootTables.BOLOK, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(UnusualendModItems.BOLOK_BUCKET.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(UnusualendModItems.WARPED_MOSS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))))
                )
        );

        consumer.accept(CageriumLootTables.FISHING_FISH, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.COD).setWeight(60))
                        .add(LootItem.lootTableItem(Items.SALMON).setWeight(25))
                        .add(LootItem.lootTableItem(Items.TROPICAL_FISH).setWeight(2))
                        .add(LootItem.lootTableItem(Items.PUFFERFISH).setWeight(13))));

        consumer.accept(CageriumLootTables.CAT_MORNING_GIFT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.RABBIT_HIDE).setWeight(10))
                        .add(LootItem.lootTableItem(Items.RABBIT_FOOT).setWeight(10))
                        .add(LootItem.lootTableItem(Items.CHICKEN).setWeight(10))
                        .add(LootItem.lootTableItem(Items.FEATHER).setWeight(10))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(10))
                        .add(LootItem.lootTableItem(Items.STRING).setWeight(10))
                        .add(LootItem.lootTableItem(Items.PHANTOM_MEMBRANE).setWeight(2))));

        consumer.accept(CageriumLootTables.PIGLIN_BARTERING, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.BOOK).setWeight(5)
                                .apply((new EnchantRandomlyFunction.Builder()).withEnchantment(Enchantments.SOUL_SPEED)))
                        .add(LootItem.lootTableItem(Items.IRON_BOOTS).setWeight(8)
                                .apply((new EnchantRandomlyFunction.Builder()).withEnchantment(Enchantments.SOUL_SPEED)))
                        .add(LootItem.lootTableItem(Items.POTION).setWeight(8)
                                .apply(SetPotionFunction.setPotion(Potions.FIRE_RESISTANCE)))
                        .add(LootItem.lootTableItem(Items.SPLASH_POTION).setWeight(8)
                                .apply(SetPotionFunction.setPotion(Potions.FIRE_RESISTANCE)))
                        .add(LootItem.lootTableItem(Items.POTION).setWeight(10)
                                .apply(SetPotionFunction.setPotion(Potions.WATER)))
                        .add(LootItem.lootTableItem(Items.IRON_NUGGET).setWeight(10)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(10.0F, 36.0F))))
                        .add(LootItem.lootTableItem(Items.ENDER_PEARL).setWeight(10)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.STRING).setWeight(20)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 9.0F))))
                        .add(LootItem.lootTableItem(Items.QUARTZ).setWeight(20)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(5.0F, 12.0F))))
                        .add(LootItem.lootTableItem(Items.OBSIDIAN).setWeight(40))
                        .add(LootItem.lootTableItem(Items.CRYING_OBSIDIAN).setWeight(40)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                        .add(LootItem.lootTableItem(Items.FIRE_CHARGE).setWeight(40))
                        .add(LootItem.lootTableItem(Items.LEATHER).setWeight(40)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.SOUL_SAND).setWeight(40)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 8.0F))))
                        .add(LootItem.lootTableItem(Items.NETHER_BRICK).setWeight(40)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 8.0F))))
                        .add(LootItem.lootTableItem(Items.SPECTRAL_ARROW).setWeight(40)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(6.0F, 12.0F))))
                        .add(LootItem.lootTableItem(Items.GRAVEL).setWeight(40)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(8.0F, 16.0F))))
                        .add(LootItem.lootTableItem(Items.BLACKSTONE).setWeight(40)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(8.0F, 16.0F))))));

        consumer.accept(CageriumLootTables.GIFTS, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.CAT_MORNING_GIFT))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.ARMORER_GIFT))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.BUTCHER_GIFT))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.CARTOGRAPHER_GIFT))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.CLERIC_GIFT))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.FARMER_GIFT))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.FISHERMAN_GIFT))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.FLETCHER_GIFT))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.LEATHERWORKER_GIFT))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.LIBRARIAN_GIFT))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.MASON_GIFT))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.SHEPHERD_GIFT))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.TOOLSMITH_GIFT))
                        .add(LootTableReference.lootTableReference(CageriumLootTables.WEAPONSMITH_GIFT))
                ));

        consumer.accept(CageriumLootTables.ARMORER_GIFT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.CHAINMAIL_HELMET))
                        .add(LootItem.lootTableItem(Items.CHAINMAIL_CHESTPLATE))
                        .add(LootItem.lootTableItem(Items.CHAINMAIL_LEGGINGS))
                        .add(LootItem.lootTableItem(Items.CHAINMAIL_BOOTS))));
        consumer.accept(CageriumLootTables.BUTCHER_GIFT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.COOKED_RABBIT))
                        .add(LootItem.lootTableItem(Items.COOKED_CHICKEN))
                        .add(LootItem.lootTableItem(Items.COOKED_PORKCHOP))
                        .add(LootItem.lootTableItem(Items.COOKED_BEEF))
                        .add(LootItem.lootTableItem(Items.COOKED_MUTTON))));
        consumer.accept(CageriumLootTables.CARTOGRAPHER_GIFT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.MAP))
                        .add(LootItem.lootTableItem(Items.PAPER))));
        consumer.accept(CageriumLootTables.CLERIC_GIFT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.REDSTONE))
                        .add(LootItem.lootTableItem(Items.LAPIS_LAZULI))));
        consumer.accept(CageriumLootTables.FARMER_GIFT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.BREAD))
                        .add(LootItem.lootTableItem(Items.PUMPKIN_PIE))
                        .add(LootItem.lootTableItem(Items.COOKIE))));
        consumer.accept(CageriumLootTables.FISHERMAN_GIFT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.COD))
                        .add(LootItem.lootTableItem(Items.SALMON))));
        consumer.accept(CageriumLootTables.FLETCHER_GIFT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.ARROW).setWeight(26))
                        .add(LootItem.lootTableItem(Items.TIPPED_ARROW)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(SetPotionFunction.setPotion(Potions.SWIFTNESS)))
                        .add(LootItem.lootTableItem(Items.TIPPED_ARROW)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(SetPotionFunction.setPotion(Potions.SLOWNESS)))
                        .add(LootItem.lootTableItem(Items.TIPPED_ARROW)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(SetPotionFunction.setPotion(Potions.STRENGTH)))
                        .add(LootItem.lootTableItem(Items.TIPPED_ARROW)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(SetPotionFunction.setPotion(Potions.HEALING)))
                        .add(LootItem.lootTableItem(Items.TIPPED_ARROW)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(SetPotionFunction.setPotion(Potions.HARMING)))
                        .add(LootItem.lootTableItem(Items.TIPPED_ARROW)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(SetPotionFunction.setPotion(Potions.LEAPING)))
                        .add(LootItem.lootTableItem(Items.TIPPED_ARROW)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(SetPotionFunction.setPotion(Potions.REGENERATION)))
                        .add(LootItem.lootTableItem(Items.TIPPED_ARROW)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(SetPotionFunction.setPotion(Potions.FIRE_RESISTANCE)))
                        .add(LootItem.lootTableItem(Items.TIPPED_ARROW)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(SetPotionFunction.setPotion(Potions.WATER_BREATHING)))
                        .add(LootItem.lootTableItem(Items.TIPPED_ARROW)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(SetPotionFunction.setPotion(Potions.INVISIBILITY)))
                        .add(LootItem.lootTableItem(Items.TIPPED_ARROW)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(SetPotionFunction.setPotion(Potions.NIGHT_VISION)))
                        .add(LootItem.lootTableItem(Items.TIPPED_ARROW)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(SetPotionFunction.setPotion(Potions.WEAKNESS)))
                        .add(LootItem.lootTableItem(Items.TIPPED_ARROW)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(SetPotionFunction.setPotion(Potions.POISON)))));
        consumer.accept(CageriumLootTables.LEATHERWORKER_GIFT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.LEATHER))));
        consumer.accept(CageriumLootTables.LIBRARIAN_GIFT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.BOOK))));
        consumer.accept(CageriumLootTables.MASON_GIFT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.CLAY))));
        consumer.accept(CageriumLootTables.SHEPHERD_GIFT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.WHITE_WOOL))
                        .add(LootItem.lootTableItem(Items.ORANGE_WOOL))
                        .add(LootItem.lootTableItem(Items.MAGENTA_WOOL))
                        .add(LootItem.lootTableItem(Items.LIGHT_BLUE_WOOL))
                        .add(LootItem.lootTableItem(Items.YELLOW_WOOL))
                        .add(LootItem.lootTableItem(Items.LIME_WOOL))
                        .add(LootItem.lootTableItem(Items.PINK_WOOL))
                        .add(LootItem.lootTableItem(Items.GRAY_WOOL))
                        .add(LootItem.lootTableItem(Items.LIGHT_GRAY_WOOL))
                        .add(LootItem.lootTableItem(Items.CYAN_WOOL))
                        .add(LootItem.lootTableItem(Items.PURPLE_WOOL))
                        .add(LootItem.lootTableItem(Items.BLUE_WOOL))
                        .add(LootItem.lootTableItem(Items.BROWN_WOOL))
                        .add(LootItem.lootTableItem(Items.GREEN_WOOL))
                        .add(LootItem.lootTableItem(Items.RED_WOOL))
                        .add(LootItem.lootTableItem(Items.BLACK_WOOL))));
        consumer.accept(CageriumLootTables.TOOLSMITH_GIFT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.STONE_PICKAXE))
                        .add(LootItem.lootTableItem(Items.STONE_AXE))
                        .add(LootItem.lootTableItem(Items.STONE_HOE))
                        .add(LootItem.lootTableItem(Items.STONE_SHOVEL))));
        consumer.accept(CageriumLootTables.WEAPONSMITH_GIFT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.STONE_AXE))
                        .add(LootItem.lootTableItem(Items.GOLDEN_AXE))
                        .add(LootItem.lootTableItem(Items.IRON_AXE))));
    }
}
