package com.github.warrentode.turtleblockacademy.datagen.loot.tables;

import biomesoplenty.api.block.BOPBlocks;
import com.github.warrentode.turtleblockacademy.loot.tables.TradeLootTables;
import net.mcreator.phantasm.init.PhantasmModBlocks;
import net.mcreator.unusualend.init.UnusualendModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;
import samebutdifferent.ecologics.registry.ModBlocks;
import slimeknights.tconstruct.world.TinkerWorld;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static com.aetherteam.aether.block.AetherBlocks.GOLDEN_OAK_LOG;
import static com.aetherteam.aether.block.AetherBlocks.SKYROOT_LOG;
import static com.github.warrentode.turtleblockacademy.datagen.loot.TBALootProviders.*;

public class TradeLootTablesGen implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {
    @Override
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(TradeLootTables.LOG_TRADE_TABLE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Blocks.SPRUCE_LOG).when(HAS_SPRUCE.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(Blocks.BIRCH_LOG).when(HAS_BIRCH.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(Blocks.JUNGLE_LOG).when(HAS_JUNGLE.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(Blocks.ACACIA_LOG).when(HAS_ACACIA.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(Blocks.DARK_OAK_LOG).when(HAS_DARK_OAK.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(Blocks.MANGROVE_LOG).when(HAS_MANGROVE.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(Blocks.WARPED_STEM).when(HAS_WARPED_FUNGUS.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(Blocks.CRIMSON_STEM).when(HAS_CRIMSON_FUNGUS.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(BOPBlocks.FIR_LOG.get()).when(HAS_FIR.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(BOPBlocks.REDWOOD_LOG.get()).when(HAS_REDWOOD.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(BOPBlocks.CHERRY_LOG.get()).when(HAS_CHERRY.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(BOPBlocks.MAHOGANY_LOG.get()).when(HAS_MAHOGANY.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(BOPBlocks.JACARANDA_LOG.get()).when(HAS_JACARANDA.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(BOPBlocks.PALM_LOG.get()).when(HAS_PALM.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(BOPBlocks.WILLOW_LOG.get()).when(HAS_WILLOW.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(BOPBlocks.DEAD_LOG.get()).when(HAS_DEAD.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(BOPBlocks.MAGIC_LOG.get()).when(HAS_MAGIC.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(BOPBlocks.UMBRAN_LOG.get()).when(HAS_UMBRAN.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(BOPBlocks.HELLBARK_LOG.get()).when(HAS_HELLBARK.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(ModBlocks.COCONUT_LOG.get()).when(HAS_COCONUT.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(ModBlocks.AZALEA_LOG.get()).when(HAS_AZALEA.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(ModBlocks.FLOWERING_AZALEA_LOG.get()).when(HAS_AZALEA.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get()).when(HAS_CHORUS_NEST.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(UnusualendModBlocks.CHORUS_NEST_PLANKS.get()).when(HAS_CHORUS_NEST.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(PhantasmModBlocks.EBONY_WOOD.get()).when(HAS_EBONY.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(PhantasmModBlocks.PREAM_LOG.get()).when(HAS_PREAM.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(SKYROOT_LOG.get()).when(HAS_AETHER_SKYROOT.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(GOLDEN_OAK_LOG.get()).when(HAS_GOLDEN_OAK.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(TinkerWorld.bloodshroom.getLog()).when(HAS_BLOODSHROOM.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(TinkerWorld.enderbark.getLog()).when(HAS_ENDERBARK.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(TinkerWorld.greenheart.getLog()).when(HAS_GREENHEART.or(IN_DUNGEON).or(IN_MINING))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        // default offers
                        .add(LootItem.lootTableItem(TinkerWorld.skyroot.getLog()).when(LootItemRandomChanceCondition.randomChance(0.1F))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(ModBlocks.WALNUT_LOG.get())
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                        .add(LootItem.lootTableItem(Blocks.OAK_LOG)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6))))
                )
        );
    }
}