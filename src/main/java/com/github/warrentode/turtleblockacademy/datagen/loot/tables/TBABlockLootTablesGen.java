package com.github.warrentode.turtleblockacademy.datagen.loot.tables;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.blocks.crop.CloveBushBlock;
import com.github.warrentode.turtleblockacademy.items.TBAItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Registry;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;
import static com.github.warrentode.turtleblockacademy.blocks.furniture.PicnicBlanket.PICNIC_BLANKET_LIST;

public class TBABlockLootTablesGen extends BlockLoot {
    @Override
    protected void addTables() {
        this.dropSelf(TBABlocks.CERTIFICATE_BLOCK.get());

        this.dropSelf(TBABlocks.FERMENTING_POT_BLOCK.get());

        PICNIC_BLANKET_LIST.forEach(this::dropSelf);

        this.add(TBABlocks.CLOVE_BUSH.get(), (block) ->
                applyExplosionDecay(block,
                        LootTable.lootTable().withPool(LootPool.lootPool()
                                        .when(LootItemBlockStatePropertyCondition
                                                .hasBlockStateProperties(TBABlocks.CLOVE_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(CloveBushBlock.AGE, CloveBushBlock.MAX_AGE)))
                                        .add(LootItem.lootTableItem(TBAItems.CLOVES.get()))
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
                                .withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(TBABlocks.CLOVE_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CloveBushBlock.AGE, 2)))
                                        .add(LootItem.lootTableItem(TBAItems.CLOVES.get()))
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));

        this.add(TBABlocks.CUCUMBER_BUSH.get(), (block) ->
                applyExplosionDecay(block,
                        LootTable.lootTable().withPool(LootPool.lootPool()
                                        .when(LootItemBlockStatePropertyCondition
                                                .hasBlockStateProperties(TBABlocks.CUCUMBER_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(CloveBushBlock.AGE, CloveBushBlock.MAX_AGE)))
                                        .add(LootItem.lootTableItem(TBAItems.CUCUMBER.get()))
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
                                .withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(TBABlocks.CUCUMBER_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CloveBushBlock.AGE, 2)))
                                        .add(LootItem.lootTableItem(TBAItems.CUCUMBER.get()))
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));

        this.add(TBABlocks.DILL_BUSH.get(), (block) ->
                applyExplosionDecay(block,
                        LootTable.lootTable().withPool(LootPool.lootPool()
                                        .when(LootItemBlockStatePropertyCondition
                                                .hasBlockStateProperties(TBABlocks.DILL_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(CloveBushBlock.AGE, CloveBushBlock.MAX_AGE)))
                                        .add(LootItem.lootTableItem(TBAItems.DILL_HERB.get()))
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
                                .withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(TBABlocks.DILL_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CloveBushBlock.AGE, 2)))
                                        .add(LootItem.lootTableItem(TBAItems.DILL_SEEDS.get()))
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));

        this.add(TBABlocks.QUARTZ_CLUSTER.get(), (block) ->
                createSilkTouchDispatchTable(block, LootItem.lootTableItem(Items.QUARTZ)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                        .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                                .of(ItemTags.CLUSTER_MAX_HARVESTABLES)))
                        .otherwise(applyExplosionDecay(block,
                                LootItem.lootTableItem(Items.QUARTZ)
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))))));

        LootItemCondition.Builder dillCropBuilder =
                LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(TBABlocks.DILL_BUSH.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                .hasProperty(CropBlock.AGE, 7));
        this.add(TBABlocks.DILL_BUSH.get(),
                createCropDrops(TBABlocks.DILL_BUSH.get(),
                        TBAItems.DILL_HERB.get(),
                        TBAItems.DILL_SEEDS.get(),
                        dillCropBuilder));

        this.dropSelf(TBABlocks.PLATE_WHITE.get());
        this.dropSelf(TBABlocks.PLATE_ORANGE.get());
        this.dropSelf(TBABlocks.PLATE_MAGENTA.get());
        this.dropSelf(TBABlocks.PLATE_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.PLATE_YELLOW.get());
        this.dropSelf(TBABlocks.PLATE_LIME.get());
        this.dropSelf(TBABlocks.PLATE_PINK.get());
        this.dropSelf(TBABlocks.PLATE_GRAY.get());
        this.dropSelf(TBABlocks.PLATE_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.PLATE_CYAN.get());
        this.dropSelf(TBABlocks.PLATE_PURPLE.get());
        this.dropSelf(TBABlocks.PLATE_BLUE.get());
        this.dropSelf(TBABlocks.PLATE_BROWN.get());
        this.dropSelf(TBABlocks.PLATE_GREEN.get());
        this.dropSelf(TBABlocks.PLATE_RED.get());
        this.dropSelf(TBABlocks.PLATE_BLACK.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_WARPED.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CRIMSON.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_MANGROVE.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_OAK.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_BIRCH.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_SPRUCE.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_DARK_OAK.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_JUNGLE.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_ACACIA.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_WARPED.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_CRIMSON.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_MANGROVE.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_OAK.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_BIRCH.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_SPRUCE.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_DARK_OAK.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_JUNGLE.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_ACACIA.get());

        this.dropSelf(TBABlocks.DESK_CHAIR_WARPED.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_CRIMSON.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_MANGROVE.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_OAK.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_BIRCH.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_SPRUCE.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_DARK_OAK.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_JUNGLE.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_ACACIA.get());

        this.dropSelf(TBABlocks.LOCKER_WARPED.get());
        this.dropSelf(TBABlocks.LOCKER_CRIMSON.get());
        this.dropSelf(TBABlocks.LOCKER_MANGROVE.get());
        this.dropSelf(TBABlocks.LOCKER_OAK.get());
        this.dropSelf(TBABlocks.LOCKER_BIRCH.get());
        this.dropSelf(TBABlocks.LOCKER_SPRUCE.get());
        this.dropSelf(TBABlocks.LOCKER_DARK_OAK.get());
        this.dropSelf(TBABlocks.LOCKER_JUNGLE.get());
        this.dropSelf(TBABlocks.LOCKER_ACACIA.get());

        this.dropSelf(TBABlocks.PARK_BENCH_WARPED.get());
        this.dropSelf(TBABlocks.PARK_BENCH_CRIMSON.get());
        this.dropSelf(TBABlocks.PARK_BENCH_MANGROVE.get());
        this.dropSelf(TBABlocks.PARK_BENCH_OAK.get());
        this.dropSelf(TBABlocks.PARK_BENCH_BIRCH.get());
        this.dropSelf(TBABlocks.PARK_BENCH_SPRUCE.get());
        this.dropSelf(TBABlocks.PARK_BENCH_DARK_OAK.get());
        this.dropSelf(TBABlocks.PARK_BENCH_JUNGLE.get());
        this.dropSelf(TBABlocks.PARK_BENCH_ACACIA.get());

        this.dropSelf(TBABlocks.TABLE_WARPED.get());
        this.dropSelf(TBABlocks.TABLE_CRIMSON.get());
        this.dropSelf(TBABlocks.TABLE_MANGROVE.get());
        this.dropSelf(TBABlocks.TABLE_OAK.get());
        this.dropSelf(TBABlocks.TABLE_BIRCH.get());
        this.dropSelf(TBABlocks.TABLE_SPRUCE.get());
        this.dropSelf(TBABlocks.TABLE_DARK_OAK.get());
        this.dropSelf(TBABlocks.TABLE_JUNGLE.get());
        this.dropSelf(TBABlocks.TABLE_ACACIA.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_FIR.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_FIR.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_FIR.get());
        this.dropSelf(TBABlocks.LOCKER_FIR.get());
        this.dropSelf(TBABlocks.PARK_BENCH_FIR.get());
        this.dropSelf(TBABlocks.TABLE_FIR.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_REDWOOD.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_REDWOOD.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_REDWOOD.get());
        this.dropSelf(TBABlocks.LOCKER_REDWOOD.get());
        this.dropSelf(TBABlocks.PARK_BENCH_REDWOOD.get());
        this.dropSelf(TBABlocks.TABLE_REDWOOD.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_CHERRY.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_CHERRY.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_CHERRY.get());
        this.dropSelf(TBABlocks.LOCKER_CHERRY.get());
        this.dropSelf(TBABlocks.PARK_BENCH_CHERRY.get());
        this.dropSelf(TBABlocks.TABLE_CHERRY.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_MAHOGANY.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_MAHOGANY.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_MAHOGANY.get());
        this.dropSelf(TBABlocks.LOCKER_MAHOGANY.get());
        this.dropSelf(TBABlocks.PARK_BENCH_MAHOGANY.get());
        this.dropSelf(TBABlocks.TABLE_MAHOGANY.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_JACARANDA.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_JACARANDA.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_JACARANDA.get());
        this.dropSelf(TBABlocks.LOCKER_JACARANDA.get());
        this.dropSelf(TBABlocks.PARK_BENCH_JACARANDA.get());
        this.dropSelf(TBABlocks.TABLE_JACARANDA.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_PALM.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_PALM.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_PALM.get());
        this.dropSelf(TBABlocks.LOCKER_PALM.get());
        this.dropSelf(TBABlocks.PARK_BENCH_PALM.get());
        this.dropSelf(TBABlocks.TABLE_PALM.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_WILLOW.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_WILLOW.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_WILLOW.get());
        this.dropSelf(TBABlocks.LOCKER_WILLOW.get());
        this.dropSelf(TBABlocks.PARK_BENCH_WILLOW.get());
        this.dropSelf(TBABlocks.TABLE_WILLOW.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_DEAD.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_DEAD.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_DEAD.get());
        this.dropSelf(TBABlocks.LOCKER_DEAD.get());
        this.dropSelf(TBABlocks.PARK_BENCH_DEAD.get());
        this.dropSelf(TBABlocks.TABLE_DEAD.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_MAGIC.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_MAGIC.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_MAGIC.get());
        this.dropSelf(TBABlocks.LOCKER_MAGIC.get());
        this.dropSelf(TBABlocks.PARK_BENCH_MAGIC.get());
        this.dropSelf(TBABlocks.TABLE_MAGIC.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_UMBRAN.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_UMBRAN.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_UMBRAN.get());
        this.dropSelf(TBABlocks.LOCKER_UMBRAN.get());
        this.dropSelf(TBABlocks.PARK_BENCH_UMBRAN.get());
        this.dropSelf(TBABlocks.TABLE_UMBRAN.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_HELLBARK.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_HELLBARK.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_HELLBARK.get());
        this.dropSelf(TBABlocks.LOCKER_HELLBARK.get());
        this.dropSelf(TBABlocks.PARK_BENCH_HELLBARK.get());
        this.dropSelf(TBABlocks.TABLE_HELLBARK.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_COCONUT.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_COCONUT.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_COCONUT.get());
        this.dropSelf(TBABlocks.LOCKER_COCONUT.get());
        this.dropSelf(TBABlocks.PARK_BENCH_COCONUT.get());
        this.dropSelf(TBABlocks.TABLE_COCONUT.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_WALNUT.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_WALNUT.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_WALNUT.get());
        this.dropSelf(TBABlocks.LOCKER_WALNUT.get());
        this.dropSelf(TBABlocks.PARK_BENCH_WALNUT.get());
        this.dropSelf(TBABlocks.TABLE_WALNUT.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_AZALEA.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_AZALEA.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_AZALEA.get());
        this.dropSelf(TBABlocks.LOCKER_AZALEA.get());
        this.dropSelf(TBABlocks.PARK_BENCH_AZALEA.get());
        this.dropSelf(TBABlocks.TABLE_AZALEA.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_FLOWERING_AZALEA.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_FLOWERING_AZALEA.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_FLOWERING_AZALEA.get());
        this.dropSelf(TBABlocks.LOCKER_FLOWERING_AZALEA.get());
        this.dropSelf(TBABlocks.PARK_BENCH_FLOWERING_AZALEA.get());
        this.dropSelf(TBABlocks.TABLE_FLOWERING_AZALEA.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_GOLDEN_OAK.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_GOLDEN_OAK.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_GOLDEN_OAK.get());
        this.dropSelf(TBABlocks.LOCKER_GOLDEN_OAK.get());
        this.dropSelf(TBABlocks.PARK_BENCH_GOLDEN_OAK.get());
        this.dropSelf(TBABlocks.TABLE_GOLDEN_OAK.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_AETHER_SKYROOT.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_AETHER_SKYROOT.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_AETHER_SKYROOT.get());
        this.dropSelf(TBABlocks.LOCKER_AETHER_SKYROOT.get());
        this.dropSelf(TBABlocks.PARK_BENCH_AETHER_SKYROOT.get());
        this.dropSelf(TBABlocks.TABLE_AETHER_SKYROOT.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_PREAM.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_PREAM.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_PREAM.get());
        this.dropSelf(TBABlocks.LOCKER_PREAM.get());
        this.dropSelf(TBABlocks.PARK_BENCH_PREAM.get());
        this.dropSelf(TBABlocks.TABLE_PREAM.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_EBONY.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_EBONY.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_EBONY.get());
        this.dropSelf(TBABlocks.LOCKER_EBONY.get());
        this.dropSelf(TBABlocks.PARK_BENCH_EBONY.get());
        this.dropSelf(TBABlocks.TABLE_EBONY.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_CHORUS_NEST.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_CHORUS_NEST.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_CHORUS_NEST.get());
        this.dropSelf(TBABlocks.LOCKER_CHORUS_NEST.get());
        this.dropSelf(TBABlocks.PARK_BENCH_CHORUS_NEST.get());
        this.dropSelf(TBABlocks.TABLE_CHORUS_NEST.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_BLOODSHROOM.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_BLOODSHROOM.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_BLOODSHROOM.get());
        this.dropSelf(TBABlocks.LOCKER_BLOODSHROOM.get());
        this.dropSelf(TBABlocks.PARK_BENCH_BLOODSHROOM.get());
        this.dropSelf(TBABlocks.TABLE_BLOODSHROOM.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_ENDERBARK.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_ENDERBARK.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_ENDERBARK.get());
        this.dropSelf(TBABlocks.LOCKER_ENDERBARK.get());
        this.dropSelf(TBABlocks.PARK_BENCH_ENDERBARK.get());
        this.dropSelf(TBABlocks.TABLE_ENDERBARK.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_GREENHEART.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_GREENHEART.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_GREENHEART.get());
        this.dropSelf(TBABlocks.LOCKER_GREENHEART.get());
        this.dropSelf(TBABlocks.PARK_BENCH_GREENHEART.get());
        this.dropSelf(TBABlocks.TABLE_GREENHEART.get());

        this.dropSelf(TBABlocks.SCHOOL_DESK_TINKER_SKYROOT.get());
        this.dropSelf(TBABlocks.SCHOOL_DESK_CABINET_TINKER_SKYROOT.get());
        this.dropSelf(TBABlocks.DESK_CHAIR_TINKER_SKYROOT.get());
        this.dropSelf(TBABlocks.LOCKER_TINKER_SKYROOT.get());
        this.dropSelf(TBABlocks.PARK_BENCH_TINKER_SKYROOT.get());
        this.dropSelf(TBABlocks.TABLE_TINKER_SKYROOT.get());

        this.dropSelf(TBABlocks.BOOKCASE_WARPED.get());
        this.dropSelf(TBABlocks.BOOKCASE_CRIMSON.get());
        this.dropSelf(TBABlocks.BOOKCASE_MANGROVE.get());
        this.dropSelf(TBABlocks.BOOKCASE_OAK.get());
        this.dropSelf(TBABlocks.BOOKCASE_BIRCH.get());
        this.dropSelf(TBABlocks.BOOKCASE_SPRUCE.get());
        this.dropSelf(TBABlocks.BOOKCASE_DARK_OAK.get());
        this.dropSelf(TBABlocks.BOOKCASE_JUNGLE.get());
        this.dropSelf(TBABlocks.BOOKCASE_ACACIA.get());
        this.dropSelf(TBABlocks.BOOKCASE_FIR.get());
        this.dropSelf(TBABlocks.BOOKCASE_REDWOOD.get());
        this.dropSelf(TBABlocks.BOOKCASE_CHERRY.get());
        this.dropSelf(TBABlocks.BOOKCASE_MAHOGANY.get());
        this.dropSelf(TBABlocks.BOOKCASE_JACARANDA.get());
        this.dropSelf(TBABlocks.BOOKCASE_PALM.get());
        this.dropSelf(TBABlocks.BOOKCASE_WILLOW.get());
        this.dropSelf(TBABlocks.BOOKCASE_DEAD.get());
        this.dropSelf(TBABlocks.BOOKCASE_MAGIC.get());
        this.dropSelf(TBABlocks.BOOKCASE_UMBRAN.get());
        this.dropSelf(TBABlocks.BOOKCASE_HELLBARK.get());
        this.dropSelf(TBABlocks.BOOKCASE_COCONUT.get());
        this.dropSelf(TBABlocks.BOOKCASE_WALNUT.get());
        this.dropSelf(TBABlocks.BOOKCASE_AZALEA.get());
        this.dropSelf(TBABlocks.BOOKCASE_FLOWERING_AZALEA.get());
        this.dropSelf(TBABlocks.BOOKCASE_GOLDEN_OAK.get());
        this.dropSelf(TBABlocks.BOOKCASE_AETHER_SKYROOT.get());
        this.dropSelf(TBABlocks.BOOKCASE_PREAM.get());
        this.dropSelf(TBABlocks.BOOKCASE_EBONY.get());
        this.dropSelf(TBABlocks.BOOKCASE_CHORUS_NEST.get());
        this.dropSelf(TBABlocks.BOOKCASE_BLOODSHROOM.get());
        this.dropSelf(TBABlocks.BOOKCASE_ENDERBARK.get());
        this.dropSelf(TBABlocks.BOOKCASE_GREENHEART.get());
        this.dropSelf(TBABlocks.BOOKCASE_TINKER_SKYROOT.get());


        this.dropSelf(TBABlocks.BASKET_OAK_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_OAK_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_OAK_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_OAK_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_OAK_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_OAK_RED.get());
        this.dropSelf(TBABlocks.BASKET_OAK_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_OAK_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_OAK_LIME.get());
        this.dropSelf(TBABlocks.BASKET_OAK_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_OAK_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_OAK_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_OAK_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_OAK_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_OAK_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_OAK_PINK.get());
        this.dropSelf(TBABlocks.BASKET_BIRCH_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_BIRCH_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_BIRCH_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_BIRCH_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_BIRCH_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_BIRCH_RED.get());
        this.dropSelf(TBABlocks.BASKET_BIRCH_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_BIRCH_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_BIRCH_LIME.get());
        this.dropSelf(TBABlocks.BASKET_BIRCH_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_BIRCH_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_BIRCH_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_BIRCH_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_BIRCH_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_BIRCH_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_BIRCH_PINK.get());
        this.dropSelf(TBABlocks.BASKET_SPRUCE_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_SPRUCE_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_SPRUCE_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_SPRUCE_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_SPRUCE_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_SPRUCE_RED.get());
        this.dropSelf(TBABlocks.BASKET_SPRUCE_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_SPRUCE_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_SPRUCE_LIME.get());
        this.dropSelf(TBABlocks.BASKET_SPRUCE_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_SPRUCE_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_SPRUCE_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_SPRUCE_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_SPRUCE_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_SPRUCE_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_SPRUCE_PINK.get());
        this.dropSelf(TBABlocks.BASKET_JUNGLE_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_JUNGLE_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_JUNGLE_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_JUNGLE_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_JUNGLE_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_JUNGLE_RED.get());
        this.dropSelf(TBABlocks.BASKET_JUNGLE_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_JUNGLE_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_JUNGLE_LIME.get());
        this.dropSelf(TBABlocks.BASKET_JUNGLE_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_JUNGLE_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_JUNGLE_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_JUNGLE_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_JUNGLE_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_JUNGLE_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_JUNGLE_PINK.get());
        this.dropSelf(TBABlocks.BASKET_ACACIA_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_ACACIA_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_ACACIA_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_ACACIA_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_ACACIA_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_ACACIA_RED.get());
        this.dropSelf(TBABlocks.BASKET_ACACIA_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_ACACIA_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_ACACIA_LIME.get());
        this.dropSelf(TBABlocks.BASKET_ACACIA_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_ACACIA_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_ACACIA_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_ACACIA_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_ACACIA_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_ACACIA_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_ACACIA_PINK.get());
        this.dropSelf(TBABlocks.BASKET_DARK_OAK_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_DARK_OAK_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_DARK_OAK_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_DARK_OAK_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_DARK_OAK_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_DARK_OAK_RED.get());
        this.dropSelf(TBABlocks.BASKET_DARK_OAK_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_DARK_OAK_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_DARK_OAK_LIME.get());
        this.dropSelf(TBABlocks.BASKET_DARK_OAK_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_DARK_OAK_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_DARK_OAK_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_DARK_OAK_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_DARK_OAK_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_DARK_OAK_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_DARK_OAK_PINK.get());
        this.dropSelf(TBABlocks.BASKET_MANGROVE_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_MANGROVE_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_MANGROVE_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_MANGROVE_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_MANGROVE_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_MANGROVE_RED.get());
        this.dropSelf(TBABlocks.BASKET_MANGROVE_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_MANGROVE_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_MANGROVE_LIME.get());
        this.dropSelf(TBABlocks.BASKET_MANGROVE_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_MANGROVE_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_MANGROVE_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_MANGROVE_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_MANGROVE_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_MANGROVE_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_MANGROVE_PINK.get());
        this.dropSelf(TBABlocks.BASKET_CRIMSON_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_CRIMSON_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_CRIMSON_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_CRIMSON_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_CRIMSON_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_CRIMSON_RED.get());
        this.dropSelf(TBABlocks.BASKET_CRIMSON_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_CRIMSON_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_CRIMSON_LIME.get());
        this.dropSelf(TBABlocks.BASKET_CRIMSON_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_CRIMSON_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_CRIMSON_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_CRIMSON_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_CRIMSON_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_CRIMSON_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_CRIMSON_PINK.get());
        this.dropSelf(TBABlocks.BASKET_WARPED_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_WARPED_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_WARPED_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_WARPED_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_WARPED_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_WARPED_RED.get());
        this.dropSelf(TBABlocks.BASKET_WARPED_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_WARPED_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_WARPED_LIME.get());
        this.dropSelf(TBABlocks.BASKET_WARPED_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_WARPED_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_WARPED_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_WARPED_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_WARPED_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_WARPED_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_WARPED_PINK.get());
        this.dropSelf(TBABlocks.BASKET_FIR_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_FIR_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_FIR_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_FIR_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_FIR_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_FIR_RED.get());
        this.dropSelf(TBABlocks.BASKET_FIR_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_FIR_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_FIR_LIME.get());
        this.dropSelf(TBABlocks.BASKET_FIR_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_FIR_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_FIR_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_FIR_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_FIR_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_FIR_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_FIR_PINK.get());
        this.dropSelf(TBABlocks.BASKET_REDWOOD_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_REDWOOD_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_REDWOOD_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_REDWOOD_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_REDWOOD_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_REDWOOD_RED.get());
        this.dropSelf(TBABlocks.BASKET_REDWOOD_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_REDWOOD_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_REDWOOD_LIME.get());
        this.dropSelf(TBABlocks.BASKET_REDWOOD_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_REDWOOD_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_REDWOOD_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_REDWOOD_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_REDWOOD_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_REDWOOD_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_REDWOOD_PINK.get());
        this.dropSelf(TBABlocks.BASKET_CHERRY_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_CHERRY_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_CHERRY_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_CHERRY_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_CHERRY_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_CHERRY_RED.get());
        this.dropSelf(TBABlocks.BASKET_CHERRY_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_CHERRY_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_CHERRY_LIME.get());
        this.dropSelf(TBABlocks.BASKET_CHERRY_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_CHERRY_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_CHERRY_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_CHERRY_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_CHERRY_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_CHERRY_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_CHERRY_PINK.get());
        this.dropSelf(TBABlocks.BASKET_MAHOGANY_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_MAHOGANY_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_MAHOGANY_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_MAHOGANY_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_MAHOGANY_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_MAHOGANY_RED.get());
        this.dropSelf(TBABlocks.BASKET_MAHOGANY_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_MAHOGANY_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_MAHOGANY_LIME.get());
        this.dropSelf(TBABlocks.BASKET_MAHOGANY_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_MAHOGANY_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_MAHOGANY_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_MAHOGANY_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_MAHOGANY_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_MAHOGANY_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_MAHOGANY_PINK.get());
        this.dropSelf(TBABlocks.BASKET_JACARANDA_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_JACARANDA_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_JACARANDA_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_JACARANDA_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_JACARANDA_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_JACARANDA_RED.get());
        this.dropSelf(TBABlocks.BASKET_JACARANDA_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_JACARANDA_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_JACARANDA_LIME.get());
        this.dropSelf(TBABlocks.BASKET_JACARANDA_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_JACARANDA_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_JACARANDA_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_JACARANDA_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_JACARANDA_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_JACARANDA_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_JACARANDA_PINK.get());
        this.dropSelf(TBABlocks.BASKET_PALM_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_PALM_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_PALM_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_PALM_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_PALM_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_PALM_RED.get());
        this.dropSelf(TBABlocks.BASKET_PALM_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_PALM_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_PALM_LIME.get());
        this.dropSelf(TBABlocks.BASKET_PALM_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_PALM_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_PALM_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_PALM_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_PALM_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_PALM_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_PALM_PINK.get());
        this.dropSelf(TBABlocks.BASKET_WILLOW_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_WILLOW_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_WILLOW_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_WILLOW_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_WILLOW_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_WILLOW_RED.get());
        this.dropSelf(TBABlocks.BASKET_WILLOW_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_WILLOW_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_WILLOW_LIME.get());
        this.dropSelf(TBABlocks.BASKET_WILLOW_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_WILLOW_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_WILLOW_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_WILLOW_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_WILLOW_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_WILLOW_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_WILLOW_PINK.get());
        this.dropSelf(TBABlocks.BASKET_DEAD_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_DEAD_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_DEAD_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_DEAD_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_DEAD_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_DEAD_RED.get());
        this.dropSelf(TBABlocks.BASKET_DEAD_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_DEAD_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_DEAD_LIME.get());
        this.dropSelf(TBABlocks.BASKET_DEAD_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_DEAD_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_DEAD_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_DEAD_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_DEAD_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_DEAD_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_DEAD_PINK.get());
        this.dropSelf(TBABlocks.BASKET_MAGIC_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_MAGIC_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_MAGIC_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_MAGIC_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_MAGIC_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_MAGIC_RED.get());
        this.dropSelf(TBABlocks.BASKET_MAGIC_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_MAGIC_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_MAGIC_LIME.get());
        this.dropSelf(TBABlocks.BASKET_MAGIC_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_MAGIC_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_MAGIC_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_MAGIC_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_MAGIC_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_MAGIC_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_MAGIC_PINK.get());
        this.dropSelf(TBABlocks.BASKET_UMBRAN_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_UMBRAN_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_UMBRAN_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_UMBRAN_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_UMBRAN_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_UMBRAN_RED.get());
        this.dropSelf(TBABlocks.BASKET_UMBRAN_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_UMBRAN_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_UMBRAN_LIME.get());
        this.dropSelf(TBABlocks.BASKET_UMBRAN_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_UMBRAN_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_UMBRAN_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_UMBRAN_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_UMBRAN_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_UMBRAN_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_UMBRAN_PINK.get());
        this.dropSelf(TBABlocks.BASKET_HELLBARK_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_HELLBARK_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_HELLBARK_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_HELLBARK_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_HELLBARK_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_HELLBARK_RED.get());
        this.dropSelf(TBABlocks.BASKET_HELLBARK_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_HELLBARK_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_HELLBARK_LIME.get());
        this.dropSelf(TBABlocks.BASKET_HELLBARK_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_HELLBARK_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_HELLBARK_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_HELLBARK_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_HELLBARK_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_HELLBARK_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_HELLBARK_PINK.get());
        this.dropSelf(TBABlocks.BASKET_COCONUT_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_COCONUT_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_COCONUT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_COCONUT_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_COCONUT_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_COCONUT_RED.get());
        this.dropSelf(TBABlocks.BASKET_COCONUT_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_COCONUT_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_COCONUT_LIME.get());
        this.dropSelf(TBABlocks.BASKET_COCONUT_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_COCONUT_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_COCONUT_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_COCONUT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_COCONUT_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_COCONUT_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_COCONUT_PINK.get());
        this.dropSelf(TBABlocks.BASKET_WALNUT_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_WALNUT_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_WALNUT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_WALNUT_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_WALNUT_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_WALNUT_RED.get());
        this.dropSelf(TBABlocks.BASKET_WALNUT_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_WALNUT_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_WALNUT_LIME.get());
        this.dropSelf(TBABlocks.BASKET_WALNUT_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_WALNUT_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_WALNUT_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_WALNUT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_WALNUT_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_WALNUT_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_WALNUT_PINK.get());
        this.dropSelf(TBABlocks.BASKET_AZALEA_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_AZALEA_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_AZALEA_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_AZALEA_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_AZALEA_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_AZALEA_RED.get());
        this.dropSelf(TBABlocks.BASKET_AZALEA_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_AZALEA_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_AZALEA_LIME.get());
        this.dropSelf(TBABlocks.BASKET_AZALEA_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_AZALEA_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_AZALEA_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_AZALEA_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_AZALEA_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_AZALEA_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_AZALEA_PINK.get());
        this.dropSelf(TBABlocks.BASKET_FLOWERING_AZALEA_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_FLOWERING_AZALEA_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_FLOWERING_AZALEA_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_FLOWERING_AZALEA_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_FLOWERING_AZALEA_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_FLOWERING_AZALEA_RED.get());
        this.dropSelf(TBABlocks.BASKET_FLOWERING_AZALEA_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_FLOWERING_AZALEA_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_FLOWERING_AZALEA_LIME.get());
        this.dropSelf(TBABlocks.BASKET_FLOWERING_AZALEA_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_FLOWERING_AZALEA_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_FLOWERING_AZALEA_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_FLOWERING_AZALEA_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_FLOWERING_AZALEA_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_FLOWERING_AZALEA_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_FLOWERING_AZALEA_PINK.get());
        this.dropSelf(TBABlocks.BASKET_AETHER_SKYROOT_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_AETHER_SKYROOT_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_AETHER_SKYROOT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_AETHER_SKYROOT_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_AETHER_SKYROOT_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_AETHER_SKYROOT_RED.get());
        this.dropSelf(TBABlocks.BASKET_AETHER_SKYROOT_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_AETHER_SKYROOT_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_AETHER_SKYROOT_LIME.get());
        this.dropSelf(TBABlocks.BASKET_AETHER_SKYROOT_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_AETHER_SKYROOT_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_AETHER_SKYROOT_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_AETHER_SKYROOT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_AETHER_SKYROOT_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_AETHER_SKYROOT_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_AETHER_SKYROOT_PINK.get());
        this.dropSelf(TBABlocks.BASKET_PREAM_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_PREAM_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_PREAM_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_PREAM_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_PREAM_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_PREAM_RED.get());
        this.dropSelf(TBABlocks.BASKET_PREAM_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_PREAM_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_PREAM_LIME.get());
        this.dropSelf(TBABlocks.BASKET_PREAM_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_PREAM_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_PREAM_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_PREAM_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_PREAM_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_PREAM_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_PREAM_PINK.get());
        this.dropSelf(TBABlocks.BASKET_EBONY_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_EBONY_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_EBONY_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_EBONY_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_EBONY_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_EBONY_RED.get());
        this.dropSelf(TBABlocks.BASKET_EBONY_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_EBONY_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_EBONY_LIME.get());
        this.dropSelf(TBABlocks.BASKET_EBONY_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_EBONY_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_EBONY_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_EBONY_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_EBONY_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_EBONY_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_EBONY_PINK.get());
        this.dropSelf(TBABlocks.BASKET_CHORUS_NEST_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_CHORUS_NEST_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_CHORUS_NEST_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_CHORUS_NEST_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_CHORUS_NEST_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_CHORUS_NEST_RED.get());
        this.dropSelf(TBABlocks.BASKET_CHORUS_NEST_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_CHORUS_NEST_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_CHORUS_NEST_LIME.get());
        this.dropSelf(TBABlocks.BASKET_CHORUS_NEST_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_CHORUS_NEST_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_CHORUS_NEST_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_CHORUS_NEST_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_CHORUS_NEST_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_CHORUS_NEST_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_CHORUS_NEST_PINK.get());
        this.dropSelf(TBABlocks.BASKET_BLOODSHROOM_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_BLOODSHROOM_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_BLOODSHROOM_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_BLOODSHROOM_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_BLOODSHROOM_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_BLOODSHROOM_RED.get());
        this.dropSelf(TBABlocks.BASKET_BLOODSHROOM_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_BLOODSHROOM_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_BLOODSHROOM_LIME.get());
        this.dropSelf(TBABlocks.BASKET_BLOODSHROOM_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_BLOODSHROOM_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_BLOODSHROOM_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_BLOODSHROOM_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_BLOODSHROOM_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_BLOODSHROOM_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_BLOODSHROOM_PINK.get());
        this.dropSelf(TBABlocks.BASKET_ENDERBARK_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_ENDERBARK_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_ENDERBARK_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_ENDERBARK_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_ENDERBARK_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_ENDERBARK_RED.get());
        this.dropSelf(TBABlocks.BASKET_ENDERBARK_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_ENDERBARK_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_ENDERBARK_LIME.get());
        this.dropSelf(TBABlocks.BASKET_ENDERBARK_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_ENDERBARK_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_ENDERBARK_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_ENDERBARK_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_ENDERBARK_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_ENDERBARK_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_ENDERBARK_PINK.get());
        this.dropSelf(TBABlocks.BASKET_GREENHEART_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_GREENHEART_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_GREENHEART_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_GREENHEART_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_GREENHEART_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_GREENHEART_RED.get());
        this.dropSelf(TBABlocks.BASKET_GREENHEART_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_GREENHEART_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_GREENHEART_LIME.get());
        this.dropSelf(TBABlocks.BASKET_GREENHEART_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_GREENHEART_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_GREENHEART_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_GREENHEART_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_GREENHEART_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_GREENHEART_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_GREENHEART_PINK.get());
        this.dropSelf(TBABlocks.BASKET_TINKER_SKYROOT_WHITE.get());
        this.dropSelf(TBABlocks.BASKET_TINKER_SKYROOT_LIGHT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_TINKER_SKYROOT_GRAY.get());
        this.dropSelf(TBABlocks.BASKET_TINKER_SKYROOT_BLACK.get());
        this.dropSelf(TBABlocks.BASKET_TINKER_SKYROOT_BROWN.get());
        this.dropSelf(TBABlocks.BASKET_TINKER_SKYROOT_RED.get());
        this.dropSelf(TBABlocks.BASKET_TINKER_SKYROOT_ORANGE.get());
        this.dropSelf(TBABlocks.BASKET_TINKER_SKYROOT_YELLOW.get());
        this.dropSelf(TBABlocks.BASKET_TINKER_SKYROOT_LIME.get());
        this.dropSelf(TBABlocks.BASKET_TINKER_SKYROOT_GREEN.get());
        this.dropSelf(TBABlocks.BASKET_TINKER_SKYROOT_CYAN.get());
        this.dropSelf(TBABlocks.BASKET_TINKER_SKYROOT_LIGHT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_TINKER_SKYROOT_BLUE.get());
        this.dropSelf(TBABlocks.BASKET_TINKER_SKYROOT_PURPLE.get());
        this.dropSelf(TBABlocks.BASKET_TINKER_SKYROOT_MAGENTA.get());
        this.dropSelf(TBABlocks.BASKET_TINKER_SKYROOT_PINK.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        //noinspection deprecation
        return ForgeRegistries.BLOCKS.getValues().stream().filter(
                        block -> MODID.equals(Registry.BLOCK.getKey(block).getNamespace()))
                .collect(Collectors.toSet());
    }
}