package com.github.warrentode.turtleblockacademy.datagen.loot.tables;

import com.github.warrentode.turtleblockacademy.blocks.CloveBushBlock;
import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.github.warrentode.turtleblockacademy.items.TBAItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Registry;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TBABlockLootTablesGen extends BlockLoot {
    @Override
    protected void addTables() {
        this.dropSelf(TBABlocks.CERTIFICATE_BLOCK.get());

        this.dropSelf(TBABlocks.FERMENTING_POT_BLOCK.get());

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

        this.add(TBABlocks.QUARTZ_CLUSTER.get(), (block) ->
                createSilkTouchDispatchTable(block, LootItem.lootTableItem(Items.QUARTZ)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                        .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                                .of(ItemTags.CLUSTER_MAX_HARVESTABLES)))
                        .otherwise(applyExplosionDecay(block,
                                LootItem.lootTableItem(Items.QUARTZ)
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))))));

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
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        //noinspection deprecation
        return ForgeRegistries.BLOCKS.getValues().stream().filter(
                        block -> MODID.equals(Registry.BLOCK.getKey(block).getNamespace()))
                .collect(Collectors.toSet());
    }
}