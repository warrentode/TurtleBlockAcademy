package com.github.warrentode.turtleblockacademy.datagen.loot;

import com.aetherteam.aether.entity.AetherEntityTypes;
import com.faboslav.friendsandfoes.FriendsAndFoes;
import com.faboslav.friendsandfoes.init.FriendsAndFoesEntityTypes;
import com.github.warrentode.turtleblockacademy.loot.conditions.BlockTagCondition;
import com.github.warrentode.turtleblockacademy.loot.conditions.EntityTypeTagCondition;
import com.github.warrentode.turtleblockacademy.loot.conditions.ModCheckCondition;
import com.github.warrentode.turtleblockacademy.loot.modifiers.AddItemLootModifier;
import com.github.warrentode.turtleblockacademy.loot.modifiers.AddLootTableModifier;
import com.github.warrentode.turtleblockacademy.loot.tables.LootbagLootTables;
import com.github.warrentode.turtleblockacademy.loot.tables.PackBuiltInLootTables;
import com.github.warrentode.turtleblockacademy.util.PackTags;
import net.brnbrd.delightful.common.item.DelightfulItems;
import net.mcreator.phantasm.init.PhantasmModEntities;
import net.mcreator.unusualend.init.UnusualendModEntities;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.predicates.AlternativeLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import static com.aetherteam.aether.entity.AetherEntityTypes.*;

public class ModLootModifierGenProvider extends GlobalLootModifierProvider {
    public ModLootModifierGenProvider(DataGenerator gen, String modid) {
        super(gen, modid);
    }

    @Override
    protected void start() {
        add("add_starter_bonus_loot", new AddLootTableModifier(
                new LootItemCondition[]{
                        AlternativeLootItemCondition
                                .alternative(LootTableIdCondition.builder(BuiltInLootTables.SPAWN_BONUS_CHEST))
                                .build()
                },
                PackBuiltInLootTables.SPAWN_STARTER_BONUS, 1.0F
        ));
        add("add_ration_loot_bag_rascal_rewards", new AddLootTableModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(FriendsAndFoes.makeID("rewards/rascal_good_reward")).build()
                },
                LootbagLootTables.RATIONS_BAG_DROP, 1F
        ));
        add("additional_sand_drops", new AddLootTableModifier(
                new LootItemCondition[]{
                        AlternativeLootItemCondition
                                .alternative(LootTableIdCondition.builder(Blocks.GRAVEL.getLootTable()))
                                .or(BlockTagCondition.tag().set(PackTags.Blocks.SAND))
                                .build()
                },
                PackBuiltInLootTables.BONUS_SAND_DROPS, 0.5F
        ));
        add("add_bonus_end_city_loot", new AddLootTableModifier(
                new LootItemCondition[]{
                        AlternativeLootItemCondition
                                .alternative(LootTableIdCondition.builder(BuiltInLootTables.END_CITY_TREASURE))
                                .build()
                },
                PackBuiltInLootTables.UFO, 1.0F
        ));
        add("add_bonus_dungeon_loot", new AddLootTableModifier(
                new LootItemCondition[]{
                        AlternativeLootItemCondition
                                .alternative(LootTableIdCondition.builder(BuiltInLootTables.SIMPLE_DUNGEON))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.ABANDONED_MINESHAFT))
                                .build()
                },
                PackBuiltInLootTables.DUNGEON_REWARDS, 1.0F
        ));
        add("add_venison_drops", new AddItemLootModifier(
                new LootItemCondition[]{
                        LootItemKilledByPlayerCondition.killedByPlayer().build(),
                        ModCheckCondition.mod().isLoaded("delightful").build(),
                        EntityTypeTagCondition.tag().set(PackTags.EntityTypes.WILD_GAME).build()
                },
                DelightfulItems.VENISON_CHOPS.get(), 1, 2, 0.1F
        ));
        add("add_extra_loot_boss_currency_drops", new AddLootTableModifier(
                new LootItemCondition[]{
                        ModCheckCondition.mod().isLoaded("todecoins").build(),
                        LootItemKilledByPlayerCondition.killedByPlayer().build(),
                        AlternativeLootItemCondition
                                .alternative(LootTableIdCondition.builder(SLIDER.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(VALKYRIE_QUEEN.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(SUN_SPIRIT.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(UnusualendModEntities.ENDSTONE_GOLEM.get()
                                        .getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(FriendsAndFoesEntityTypes.WILDFIRE.get()
                                        .getDefaultLootTable()))
                                .build()
                },
                ResourceLocation.tryParse("todecoins:entity/todecoins_boss_currency_drops"), 1.0F
        ));
        add("add_extra_loot_currency_drops", new AddLootTableModifier(
                new LootItemCondition[]{
                        ModCheckCondition.mod().isLoaded("todecoins").build(),
                        LootItemKilledByPlayerCondition.killedByPlayer().build(),
                        AlternativeLootItemCondition
                                .alternative(LootTableIdCondition.builder(AetherEntityTypes.SENTRY.getId()))
                                .or(LootTableIdCondition.builder(AECHOR_PLANT.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(COCKATRICE.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(FIRE_MINION.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(SENTRY.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(BLUE_SWET.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(GOLDEN_SWET.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(WHIRLWIND.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EVIL_WHIRLWIND.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(VALKYRIE.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(ZEPHYR.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(UnusualendModEntities.BOLOK.getId()))
                                .or(LootTableIdCondition.builder(UnusualendModEntities.DRAGLING.getId()))
                                .or(LootTableIdCondition.builder(UnusualendModEntities.ENDER_BLOB.getId()))
                                .or(LootTableIdCondition.builder(UnusualendModEntities.UNDEAD_ENDERLING.getId()))
                                .or(LootTableIdCondition.builder(UnusualendModEntities.ENDSTONE_TRAPPER.getId()))
                                .or(LootTableIdCondition.builder(PhantasmModEntities.CRYSTIE.get()
                                        .getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(FriendsAndFoesEntityTypes.ICEOLOGER.get()
                                        .getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(MIMIC.get().getDefaultLootTable()))
                                .build()
                },
                ResourceLocation.tryParse("todecoins:entity/todecoins_currency_drops"), 1.0F
        ));
        add("add_extra_collectible_boss_coin_drops", new AddLootTableModifier(
                new LootItemCondition[]{
                        ModCheckCondition.mod().isLoaded("todecoins").build(),
                        LootItemKilledByPlayerCondition.killedByPlayer().build(),
                        AlternativeLootItemCondition
                                .alternative(LootTableIdCondition.builder(SLIDER.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(VALKYRIE_QUEEN.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(SUN_SPIRIT.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(UnusualendModEntities.ENDSTONE_GOLEM.get()
                                        .getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(FriendsAndFoesEntityTypes.WILDFIRE.get()
                                        .getDefaultLootTable()))
                                .build()
                },
                ResourceLocation.tryParse("todecoins:entity/collectible/boss_collectible_coin_drops"), 1.0F
        ));
        add("add_extra_collectible_entity_coin_drops", new AddLootTableModifier(
                new LootItemCondition[]{
                        ModCheckCondition.mod().isLoaded("todecoins").build(),
                        LootItemKilledByPlayerCondition.killedByPlayer().build(),
                        AlternativeLootItemCondition
                                .alternative(LootTableIdCondition.builder(AetherEntityTypes.SENTRY.getId()))
                                .or(LootTableIdCondition.builder(AECHOR_PLANT.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(COCKATRICE.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(FIRE_MINION.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(SENTRY.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(BLUE_SWET.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(GOLDEN_SWET.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(WHIRLWIND.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EVIL_WHIRLWIND.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(VALKYRIE.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(ZEPHYR.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(UnusualendModEntities.BOLOK.getId()))
                                .or(LootTableIdCondition.builder(UnusualendModEntities.DRAGLING.getId()))
                                .or(LootTableIdCondition.builder(UnusualendModEntities.ENDER_BLOB.getId()))
                                .or(LootTableIdCondition.builder(UnusualendModEntities.UNDEAD_ENDERLING.getId()))
                                .or(LootTableIdCondition.builder(UnusualendModEntities.ENDSTONE_TRAPPER.getId()))
                                .or(LootTableIdCondition.builder(PhantasmModEntities.CRYSTIE.get()
                                        .getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(FriendsAndFoesEntityTypes.ICEOLOGER.get()
                                        .getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(MIMIC.get().getDefaultLootTable()))
                                .build()
                },
                ResourceLocation.tryParse("todecoins:entity/collectible/entity_collectible_coin_drops"), 1.0F
        ));
        add("add_extra_collectible_holiday_coin_drops", new AddLootTableModifier(
                new LootItemCondition[]{
                        ModCheckCondition.mod().isLoaded("todecoins").build(),
                        LootItemKilledByPlayerCondition.killedByPlayer().build(),
                        AlternativeLootItemCondition
                                .alternative(LootTableIdCondition.builder(SLIDER.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(VALKYRIE_QUEEN.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(SUN_SPIRIT.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(UnusualendModEntities.ENDSTONE_GOLEM.get()
                                        .getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(FriendsAndFoesEntityTypes.WILDFIRE.get()
                                        .getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(AetherEntityTypes.SENTRY.getId()))
                                .or(LootTableIdCondition.builder(AECHOR_PLANT.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(COCKATRICE.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(FIRE_MINION.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(SENTRY.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(BLUE_SWET.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(GOLDEN_SWET.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(WHIRLWIND.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EVIL_WHIRLWIND.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(VALKYRIE.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(ZEPHYR.get().getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(UnusualendModEntities.BOLOK.getId()))
                                .or(LootTableIdCondition.builder(UnusualendModEntities.DRAGLING.getId()))
                                .or(LootTableIdCondition.builder(UnusualendModEntities.ENDER_BLOB.getId()))
                                .or(LootTableIdCondition.builder(UnusualendModEntities.UNDEAD_ENDERLING.getId()))
                                .or(LootTableIdCondition.builder(UnusualendModEntities.ENDSTONE_TRAPPER.getId()))
                                .or(LootTableIdCondition.builder(PhantasmModEntities.CRYSTIE.get()
                                        .getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(FriendsAndFoesEntityTypes.ICEOLOGER.get()
                                        .getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(MIMIC.get().getDefaultLootTable()))
                                .build()
                },
                ResourceLocation.tryParse("todecoins:entity/collectible/holiday_collectible_coin_drops"), 1.0F
        ));
    }
}