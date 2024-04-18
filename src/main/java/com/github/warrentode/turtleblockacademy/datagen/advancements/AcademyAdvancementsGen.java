package com.github.warrentode.turtleblockacademy.datagen.advancements;

import com.github.warrentode.turtleblockacademy.TurtleBlockAcademy;
import com.github.warrentode.turtleblockacademy.blocks.ModBlocks;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.EntityPredicate;
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
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

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

        private static final List<ResourceKey<Biome>> EXPLORABLE_END_BIOMES =
                ImmutableList.of(Biomes.THE_END, Biomes.SMALL_END_ISLANDS, Biomes.END_MIDLANDS, Biomes.END_HIGHLANDS, Biomes.END_BARRENS);

        @SuppressWarnings("SameParameterValue")
        protected static @NotNull Advancement.Builder createParentAdvancement(ItemLike display, String name, ResourceLocation background, FrameType frame, boolean showToast, boolean announceToChat, boolean hidden) {
            return Advancement.Builder.advancement().display(display,
                    Component.translatable("academy.advancement." + name),
                    Component.translatable("academy.advancement." + name + ".desc"),
                    background, frame, showToast, announceToChat, hidden);
        }

        protected static @NotNull Advancement.Builder createSecretAdvancement() {
            return Advancement.Builder.advancement();
        }

        protected static @NotNull Advancement.Builder createAdvancement(Advancement parent, ItemLike display, String name, FrameType frame, boolean showToast, boolean announceToChat, boolean hidden) {
            return Advancement.Builder.advancement()
                    .parent(parent).display(display,
                            Component.translatable("advancement." + name),
                            Component.translatable("advancement." + name + ".desc"),
                            null, frame, showToast, announceToChat, hidden);
        }

        @Override
        public void accept(Consumer<Advancement> consumer) {
            Advancement root = createParentAdvancement(ModBlocks.CERTIFICATE_BLOCK.get(),
                    "root", new ResourceLocation("minecraft:textures/block/calcite.png"),
                    FrameType.CHALLENGE, false, false, false)
                    .addCriterion("tick", new PlayerTrigger.TriggerInstance(CriteriaTriggers.TICK.getId(),
                            EntityPredicate.Composite.ANY))
                    .save(consumer, getPath("root"));
            Advancement unlock_recipes = createSecretAdvancement()
                    .addCriterion("tick", new PlayerTrigger.TriggerInstance(CriteriaTriggers.TICK.getId(),
                            EntityPredicate.Composite.ANY))
                    .rewards(AdvancementRewards.Builder.function(new ResourceLocation("turtleblockacademy:unlock_recipes")))
                    .save(consumer, getPath("unlock_recipes"));


            Advancement explore_end = addBiomes(Advancement.Builder.advancement(), EXPLORABLE_END_BIOMES)
                    .parent(root).display(Items.FILLED_MAP,
                            Component.translatable("academy.advancement.explore_end"),
                            Component.translatable("academy.advancement.explore_end.desc"),
                            null, FrameType.CHALLENGE, true, true, false)
                    .rewards(AdvancementRewards.Builder.experience(500))
                    .save(consumer, getPath("explore_end"));
        }

        protected static Advancement.Builder addBiomes(Advancement.Builder builder, @NotNull List<ResourceKey<Biome>> biomes) {
            for (ResourceKey<Biome> resourcekey : biomes) {
                builder.addCriterion(resourcekey.location().toString(),
                        PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(resourcekey)));
            }

            return builder;
        }

        @Contract(pure = true)
        private @NotNull String getPath(String id) {
            return MODID + ":" + id;
        }
    }
}
