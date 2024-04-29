package com.github.warrentode.turtleblockacademy.datagen.advancements;

import biomesoplenty.api.biome.BOPBiomes;
import com.aetherteam.aether.data.resources.registries.AetherBiomes;
import com.aetherteam.aether.data.resources.registries.AetherDimensions;
import com.aetherteam.aether.item.AetherItems;
import com.catastrophe573.dimdungeons.DimDungeons;
import com.github.warrentode.turtleblockacademy.TurtleBlockAcademy;
import com.github.warrentode.turtleblockacademy.blocks.ModBlocks;
import com.github.warrentode.turtleblockacademy.loot.tables.PackBuiltInLootTables;
import com.github.warrentode.turtleblockacademy.util.PackTags;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import de.maxhenkel.miningdimension.Main;
import net.mehvahdjukaar.supplementaries.reg.ModRegistry;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.CuriosTriggers;
import top.theillusivec4.curios.api.SlotPredicate;
import top.theillusivec4.curios.api.SlotTypePreset;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import static com.catastrophe573.dimdungeons.item.ItemRegistrar.*;
import static com.github.Pandarix.beautify.core.init.ItemInit.BOOKSTACK_ITEM;
import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;
import static de.maxhenkel.miningdimension.Main.MINING_DIMENSION;

public class AcademyAdvancementsGen extends AdvancementProvider {
    private final Path PATH;

    public AcademyAdvancementsGen(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, helper);
        PATH = generator.getOutputFolder();
    }

    private static @NotNull Path getPath(@NotNull Path pathIn, @NotNull Advancement advancementIn) {
        return pathIn.resolve("data/" + advancementIn.getId().getNamespace() + "/advancements/" + advancementIn.getId().getPath() + ".json");
    }

    @Override
    public void run(@NotNull CachedOutput cache) {
        Set<ResourceLocation> set = Sets.newHashSet();
        Consumer<Advancement> consumer = (advancement) -> {
            if (!set.add(advancement.getId())) {
                throw new IllegalStateException("This is Principal Herobrine speaking, you have a duplicate advancement: " + advancement.getId());
            }
            else {
                Path path1 = getPath(PATH, advancement);
                try {
                    DataProvider.saveStable(cache, advancement.deconstruct().serializeToJson(), path1);
                }
                catch (IOException ioException) {
                    TurtleBlockAcademy.LOGGER.error("This is Principal Herobrine speaking, we couldn't save this advancement: {}", path1, ioException);
                }
            }
        };

        new TurtleBlockAcademyAdvancements().accept(consumer);
    }

    public static class TurtleBlockAcademyAdvancements implements Consumer<Consumer<Advancement>> {
        private static final List<ResourceKey<Biome>> EXPLORABLE_OVERWORLD_BIOMES =
                ImmutableList.of(
                        BOPBiomes.WOODLAND, BOPBiomes.WOODED_SCRUBLAND, BOPBiomes.WETLAND, BOPBiomes.WOODED_WASTELAND,
                        BOPBiomes.WASTELAND, BOPBiomes.VOLCANO, BOPBiomes.VOLCANIC_PLAINS, BOPBiomes.TUNDRA, BOPBiomes.TROPICS,
                        BOPBiomes.SPIDER_NEST, BOPBiomes.SNOWY_MAPLE_WOODS, BOPBiomes.SNOWY_FIR_CLEARING,
                        BOPBiomes.SNOWY_CONIFEROUS_FOREST, BOPBiomes.ROCKY_SHRUBLAND, BOPBiomes.REDWOOD_FOREST,
                        BOPBiomes.ROCKY_RAINFOREST, BOPBiomes.RAINFOREST, BOPBiomes.PRAIRIE, BOPBiomes.PASTURE,
                        BOPBiomes.ORIGIN_VALLEY, BOPBiomes.ORCHARD, BOPBiomes.OMINOUS_WOODS, BOPBiomes.OLD_GROWTH_WOODLAND,
                        BOPBiomes.MYSTIC_GROVE, BOPBiomes.MUSKEG, BOPBiomes.MEDITERRANEAN_FOREST, BOPBiomes.MARSH,
                        BOPBiomes.LUSH_SAVANNA, BOPBiomes.LAVENDER_FOREST, BOPBiomes.LAVENDER_FIELD, BOPBiomes.JADE_CLIFFS,
                        BOPBiomes.HIGHLAND_MOOR, BOPBiomes.HIGHLAND, BOPBiomes.GLOWING_GROTTO, BOPBiomes.FUNGAL_JUNGLE,
                        BOPBiomes.FORESTED_FIELD, BOPBiomes.FLOODPLAIN, BOPBiomes.FIR_CLEARING, BOPBiomes.PUMPKIN_PATCH,
                        BOPBiomes.SEASONAL_ORCHARD, BOPBiomes.SEASONAL_FOREST, BOPBiomes.MAPLE_WOODS, BOPBiomes.FIELD,
                        BOPBiomes.SCRUBLAND, BOPBiomes.SHRUBLAND, BOPBiomes.DUNE_BEACH, BOPBiomes.LUSH_DESERT, BOPBiomes.DRYLAND,
                        BOPBiomes.OLD_GROWTH_DEAD_FOREST, BOPBiomes.DEAD_FOREST, BOPBiomes.CRAG, BOPBiomes.CONIFEROUS_FOREST,
                        BOPBiomes.COLD_DESERT, BOPBiomes.GRASSLAND, BOPBiomes.CLOVER_PATCH, BOPBiomes.BOG, BOPBiomes.AURORAL_GARDEN,
                        BOPBiomes.BAMBOO_GROVE, BOPBiomes.CHERRY_BLOSSOM_GROVE, BOPBiomes.BAYOU, Biomes.FROZEN_OCEAN,
                        Biomes.DEEP_FROZEN_OCEAN, Biomes.JAGGED_PEAKS, Biomes.FROZEN_PEAKS, Biomes.GROVE, Biomes.SNOWY_SLOPES,
                        Biomes.SNOWY_TAIGA, Biomes.FROZEN_RIVER, Biomes.SNOWY_BEACH, Biomes.SNOWY_PLAINS, Biomes.ICE_SPIKES,
                        Biomes.COLD_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.STONY_PEAKS, Biomes.MEADOW, Biomes.WINDSWEPT_HILLS,
                        Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA,
                        Biomes.OLD_GROWTH_SPRUCE_TAIGA, Biomes.STONY_SHORE, Biomes.OCEAN, Biomes.DEEP_OCEAN, Biomes.FOREST,
                        Biomes.FLOWER_FOREST, Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.DARK_FOREST,
                        Biomes.RIVER, Biomes.BEACH, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS, Biomes.LUKEWARM_OCEAN,
                        Biomes.DEEP_LUKEWARM_OCEAN, Biomes.MUSHROOM_FIELDS, Biomes.JUNGLE, Biomes.SPARSE_JUNGLE,
                        Biomes.BAMBOO_JUNGLE, Biomes.SWAMP, Biomes.MANGROVE_SWAMP, Biomes.WARM_OCEAN, Biomes.SAVANNA,
                        Biomes.SAVANNA_PLATEAU, Biomes.WINDSWEPT_SAVANNA, Biomes.DESERT, Biomes.BADLANDS, Biomes.WOODED_BADLANDS,
                        Biomes.ERODED_BADLANDS, Biomes.DEEP_DARK, Biomes.DRIPSTONE_CAVES, Biomes.LUSH_CAVES
                );

        private static final List<ResourceKey<Biome>> EXPLORABLE_NETHER_BIOMES =
                ImmutableList.of(BOPBiomes.CRYSTALLINE_CHASM, BOPBiomes.ERUPTING_INFERNO, BOPBiomes.UNDERGROWTH, BOPBiomes.WITHERED_ABYSS, BOPBiomes.VISCERAL_HEAP, Biomes.NETHER_WASTES, Biomes.SOUL_SAND_VALLEY, Biomes.WARPED_FOREST, Biomes.CRIMSON_FOREST, Biomes.BASALT_DELTAS);

        private static final List<ResourceKey<Biome>> EXPLORABLE_END_BIOMES =
                ImmutableList.of(Biomes.THE_END, Biomes.SMALL_END_ISLANDS, Biomes.END_MIDLANDS, Biomes.END_HIGHLANDS, Biomes.END_BARRENS);

        private static final List<ResourceKey<Biome>> EXPLORABLE_AETHER_BIOMES =
                ImmutableList.of(AetherBiomes.SKYROOT_GROVE, AetherBiomes.SKYROOT_FOREST, AetherBiomes.SKYROOT_MEADOW, AetherBiomes.SKYROOT_WOODLAND);

        @SuppressWarnings("SameParameterValue")
        protected static @NotNull Advancement.Builder createParentAdvancement(ItemLike display, String name, ResourceLocation background, FrameType frame, boolean showToast, boolean announceToChat, boolean hidden) {
            return Advancement.Builder.advancement().display(display,
                    Component.translatable("advancement." + MODID + "." + name),
                    Component.translatable("advancement." + MODID + "." + name + ".desc"),
                    background, frame, showToast, announceToChat, hidden);
        }

        protected static @NotNull Advancement.Builder createSecretAdvancement() {
            return Advancement.Builder.advancement();
        }

        @SuppressWarnings("SameParameterValue")
        protected static @NotNull Advancement.Builder createAdvancement(Advancement parent, ItemLike display, String name, FrameType frame, boolean showToast, boolean announceToChat, boolean hidden) {
            return Advancement.Builder.advancement()
                    .parent(parent).display(display,
                            Component.translatable("advancement." + MODID + "." + name),
                            Component.translatable("advancement." + MODID + "." + name + ".desc"),
                            null, frame, showToast, announceToChat, hidden);
        }

        @SuppressWarnings("unused")
        @Override
        public void accept(Consumer<Advancement> consumer) {
            Advancement root = createParentAdvancement(ModBlocks.CERTIFICATE_BLOCK.get(),
                    "root", new ResourceLocation("minecraft:textures/block/calcite.png"),
                    FrameType.CHALLENGE, false, false, false)
                    .addCriterion("tick", new PlayerTrigger.TriggerInstance(CriteriaTriggers.TICK.getId(),
                            EntityPredicate.Composite.ANY))
                    .rewards(AdvancementRewards.Builder.function(new ResourceLocation("turtleblockacademy:give_student_card")))
                    .save(consumer, getPath(MODID, "root"));

            Advancement unlock_recipes = createSecretAdvancement()
                    .addCriterion("tick", new PlayerTrigger.TriggerInstance(CriteriaTriggers.TICK.getId(),
                            EntityPredicate.Composite.ANY))
                    .rewards(AdvancementRewards.Builder.function(new ResourceLocation("turtleblockacademy:unlock_recipes")))
                    .save(consumer, getPath(MODID, "unlock_recipes"));

            Advancement science_track = createSecretAdvancement()
                    .addCriterion("tick", new PlayerTrigger.TriggerInstance(CriteriaTriggers.TICK.getId(),
                            EntityPredicate.Composite.ANY))
                    .rewards(AdvancementRewards.Builder.loot(new ResourceLocation(PackBuiltInLootTables.BREWING_GUIDE.toString())))
                    .save(consumer, getPath(MODID, "give_brewing_guide"));

            Advancement curios_track = createAdvancement(root, Items.GLOW_ITEM_FRAME,
                    "curios_track",
                    FrameType.GOAL, false, false, false)
                    .addCriterion("tick", new PlayerTrigger.TriggerInstance(CriteriaTriggers.TICK.getId(),
                            EntityPredicate.Composite.ANY))
                    .save(consumer, getPath(MODID, "curios_track"));

            Advancement exploration_track = createAdvancement(root, Items.LEATHER_BOOTS,
                    "exploration_track",
                    FrameType.GOAL, false, false, false)
                    .addCriterion("tick", new PlayerTrigger.TriggerInstance(CriteriaTriggers.TICK.getId(),
                            EntityPredicate.Composite.ANY))
                    .save(consumer, getPath(MODID, "exploration_track"));

            Advancement enteredMining = Advancement.Builder.advancement()
                    .parent(exploration_track)
                    .display(Main.TELEPORTER_ITEM.get(),
                            Component.translatable("advancement." + MODID + "." + "enter_mining"),
                            Component.translatable("advancement." + MODID + "." + "enter_mining.desc"),
                            null, FrameType.TASK, false, false, false)
                    .addCriterion("entered_mining", net.minecraft.advancements.critereon.ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(MINING_DIMENSION))
                    .rewards(AdvancementRewards.Builder.function(new ResourceLocation("turtleblockacademy:set_mining_stage")))
                    .save(consumer, getPath(MODID, "exploration/enter_mining"));

            Advancement enteredNether = Advancement.Builder.advancement()
                    .parent(enteredMining)
                    .display(Items.FLINT_AND_STEEL,
                            Component.translatable("advancements.story.enter_the_nether.title"),
                            Component.translatable("advancements.story.enter_the_nether.description"),
                            null, FrameType.TASK, false, false, false)
                    .addCriterion("entered_nether", net.minecraft.advancements.critereon.ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(Level.NETHER))
                    .rewards(AdvancementRewards.Builder.function(new ResourceLocation("turtleblockacademy:set_nether_stage")))
                    .save(consumer, getPath(MODID, "exploration/enter_the_nether"));

            Advancement enteredEnd = Advancement.Builder.advancement()
                    .parent(enteredNether)
                    .display(Blocks.END_STONE, Component.translatable("advancements.story.enter_the_end.title"), Component.translatable("advancements.story.enter_the_end.description"),
                            null, FrameType.TASK, false, false, false)
                    .addCriterion("entered_end", net.minecraft.advancements.critereon.ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(Level.END))
                    .rewards(AdvancementRewards.Builder.function(new ResourceLocation("turtleblockacademy:set_end_stage")))
                    .save(consumer, getPath(MODID, "exploration/enter_the_end"));

            Advancement enteredAether = Advancement.Builder.advancement()
                    .parent(enteredEnd)
                    .display(Blocks.GLOWSTONE,
                            Component.translatable("advancement.aether.enter_aether"),
                            Component.translatable("advancement.aether.enter_aether.desc"),
                            null, FrameType.TASK, false, false, false)
                    .addCriterion("enter_aether", net.minecraft.advancements.critereon.ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(AetherDimensions.AETHER_LEVEL))
                    .rewards(AdvancementRewards.Builder.function(new ResourceLocation("turtleblockacademy:set_aether_stage")))
                    .save(consumer, getPath(MODID, "exploration/enter_aether"));

            Advancement enteredPersonalSpace = Advancement.Builder.advancement()
                    .parent(enteredNether)
                    .display(ITEM_BLANK_BUILD_KEY.get(),
                            Component.translatable("advancements.dimdungeons.dungeons.enter_personal_space.title"),
                            Component.translatable("advancements.dimdungeons.dungeons.enter_personal_space.description"),
                            null, FrameType.TASK, false, false, false)
                    .addCriterion("entered_space", net.minecraft.advancements.critereon.ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(DimDungeons.BUILD_DIMENSION))
                    .rewards(AdvancementRewards.Builder.function(new ResourceLocation("turtleblockacademy:set_apartment_stage")))
                    .save(consumer, getPath(MODID, "exploration/enter_personal_space"));

            Advancement enteredDungeons = Advancement.Builder.advancement()
                    .parent(enteredPersonalSpace)
                    .display(ITEM_PORTAL_KEY.get(),
                            Component.translatable("advancements.dimdungeons.dungeons.enter_basic_dungeon.title"),
                            Component.translatable("advancements.dimdungeons.dungeons.enter_basic_dungeon.description"),
                            null, FrameType.TASK, false, false, false)
                    .addCriterion("entered_dungeon", net.minecraft.advancements.critereon.ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(DimDungeons.DUNGEON_DIMENSION))
                    .rewards(AdvancementRewards.Builder.function(new ResourceLocation("turtleblockacademy:set_dungeons_stage")))
                    .save(consumer, getPath(MODID, "exploration/enter_basic_dungeon"));

            Advancement explore_overworld = addBiomes(Advancement.Builder.advancement(), EXPLORABLE_OVERWORLD_BIOMES)
                    .parent(exploration_track).display(Items.DIAMOND_BOOTS,
                            Component.translatable("advancement." + MODID + "." + "explore_overworld"),
                            Component.translatable("advancement." + MODID + "." + "explore_overworld.desc"),
                            null, FrameType.TASK, true, true, false)
                    .rewards(AdvancementRewards.Builder.experience(500))
                    .save(consumer, getPath(MODID, "exploration/explore_overworld"));

            Advancement explore_nether = addBiomes(Advancement.Builder.advancement(), EXPLORABLE_NETHER_BIOMES)
                    .parent(explore_overworld).display(Items.NETHERITE_BOOTS,
                            Component.translatable("advancement." + MODID + "." + "explore_nether"),
                            Component.translatable("advancement." + MODID + "." + "explore_nether.desc"),
                            null, FrameType.TASK, true, true, false)
                    .rewards(AdvancementRewards.Builder.experience(500))
                    .save(consumer, getPath(MODID, "exploration/explore_nether"));

            Advancement explore_end = addBiomes(Advancement.Builder.advancement(), EXPLORABLE_END_BIOMES)
                    .parent(explore_nether).display(Items.FILLED_MAP,
                            Component.translatable("advancement." + MODID + "." + "explore_end"),
                            Component.translatable("advancement." + MODID + "." + "explore_end.desc"),
                            null, FrameType.TASK, true, true, false)
                    .rewards(AdvancementRewards.Builder.experience(500))
                    .save(consumer, getPath(MODID, "exploration/explore_end"));

            Advancement explore_aether = addBiomes(Advancement.Builder.advancement(), EXPLORABLE_AETHER_BIOMES)
                    .parent(explore_end).display(AetherItems.GOLDEN_PARACHUTE.get(),
                            Component.translatable("advancement." + MODID + "." + "explore_aether"),
                            Component.translatable("advancement." + MODID + "." + "explore_aether.desc"),
                            null, FrameType.TASK, true, true, false)
                    .rewards(AdvancementRewards.Builder.experience(500))
                    .save(consumer, getPath(MODID, "exploration/explore_aether"));

            Advancement equip_light_source = createAdvancement(curios_track, Items.LANTERN,
                    "equip_light_source", FrameType.TASK, true, true, false)
                    .addCriterion("equip_light_source",
                            CuriosTriggers.equip()
                                    .withItem(ItemPredicate.Builder.item().of(PackTags.Items.CURIO_LIGHT_SOURCE))
                                    .withSlot(SlotPredicate.Builder.slot().of(SlotTypePreset.HANDS.getIdentifier(), SlotTypePreset.BELT.getIdentifier()))
                                    .withLocation(LocationPredicate.Builder.location())
                                    .build())
                    .rewards(AdvancementRewards.Builder.experience(500))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("curios", "equip_light_source"));

            @SuppressWarnings("unused")
            Advancement equip_quiver = createAdvancement(curios_track, ModRegistry.QUIVER_ITEM.get(),
                    "equip_quiver", FrameType.TASK, true, true, false)
                    .addCriterion("equip_quiver",
                            CuriosTriggers.equip()
                                    .withItem(ItemPredicate.Builder.item().of(ModRegistry.QUIVER_ITEM.get()))
                                    .withSlot(SlotPredicate.Builder.slot().of(SlotTypePreset.BELT.getIdentifier()))
                                    .withLocation(LocationPredicate.Builder.location())
                                    .build())
                    .rewards(AdvancementRewards.Builder.function(new ResourceLocation("turtleblockacademy:add_belt_slot")))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("curios", "equip_quiver"));

            Advancement education_track = createAdvancement(root, BOOKSTACK_ITEM.get(),
                    "education_track",
                    FrameType.GOAL, false, false, false)
                    .addCriterion("tick", new PlayerTrigger.TriggerInstance(CriteriaTriggers.TICK.getId(),
                            EntityPredicate.Composite.ANY))
                    .save(consumer, getPath(MODID, "education_track"));

            Advancement completeFoodSafety = Advancement.Builder.advancement()
                    .parent(education_track)
                    .display(ModBlocks.CERTIFICATE_BLOCK.get(),
                            Component.translatable("advancement." + MODID + "." + "complete_food_safety"),
                            Component.translatable("advancement." + MODID + "." + "complete_food_safety.desc"),
                            null, FrameType.TASK, false, false, false)
                    .addCriterion("completed_food_safety", net.minecraft.advancements.critereon.ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(MINING_DIMENSION))
                    .rewards(AdvancementRewards.Builder.function(new ResourceLocation("turtleblockacademy:give_kitchen_certificate")))
                    .save(consumer, getPath(MODID, "education/complete_food_safety"));
        }

        @SuppressWarnings("SameParameterValue")
        protected static Advancement.Builder addBiomes(Advancement.Builder builder, @NotNull List<ResourceKey<Biome>> biomes) {
            for (ResourceKey<Biome> resourcekey : biomes) {
                builder.addCriterion(resourcekey.location().toString(),
                        PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(resourcekey)));
            }

            return builder;
        }

        @Contract(pure = true)
        private @NotNull String getPath(String modid, String path) {
            return modid + ":" + path;
        }
    }
}