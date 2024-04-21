package com.github.warrentode.turtleblockacademy.datagen.tags;

import com.aetherteam.aether.entity.AetherEntityTypes;
import com.github.warrentode.turtleblockacademy.util.PackTags;
import net.mcreator.unusualend.init.UnusualendModEntities;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class EntityTypeTagsGen extends EntityTypeTagsProvider {
    public EntityTypeTagsGen(DataGenerator pGenerator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, modId, existingFileHelper);
    }


    @Override
    protected void addTags() {
        this.registerPackTags();
    }

    private void registerPackTags() {
        tag(PackTags.EntityTypes.ENDERMAN_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:snareling")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:watchling")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:blastling")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:endersent")));
        tag(PackTags.EntityTypes.ZOMBIFIED_PIGLIN_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:zombified_fungus_thrower")));
        tag(PackTags.EntityTypes.PIGLIN_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:fungus_thrower")));
        tag(PackTags.EntityTypes.SLIME_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:conjured_slime")));
        tag(PackTags.EntityTypes.PHANTOM_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:wraith")));
        tag(PackTags.EntityTypes.CREEPER_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:poison_anemone")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:quick_growing_kelp")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:wavewhisperer")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:whisperer")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:leapleaf")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:quick_growing_vine")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:poison_quill_vine")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:icy_creeper")));
        tag(PackTags.EntityTypes.SKELETON_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:sunken_skeleton")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:drowned_necromancer")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:necromancer")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:mossy_skeleton")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:skeleton_vanguard")));
        tag(PackTags.EntityTypes.ZOMBIE_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:frozen_zombie")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:jungle_zombie")));
        tag(PackTags.EntityTypes.WILDFIRE_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:wildfire")));
        tag(PackTags.EntityTypes.FLUTE_PET)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("friendsandfoes:glare")))
                .add(EntityType.FOX)
                .add(EntityType.FROG)
                .add(EntityType.AXOLOTL)
                .add(EntityType.RABBIT);
        tag(PackTags.EntityTypes.URN_SPAWN)
                .addOptional(UnusualendModEntities.ENDER_BLOB.getId())
                .addOptional(UnusualendModEntities.ENDER_FIREFLY.getId())
                .add(EntityType.SILVERFISH)
                .add(EntityType.ENDERMITE);
        tag(PackTags.EntityTypes.WILD_GAME)
                .add(EntityType.HOGLIN)
                .add(EntityType.GOAT)
                .add(EntityType.RAVAGER)
                .add(EntityType.POLAR_BEAR);
        tag(PackTags.EntityTypes.BOSSES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:endersent")))
                .addOptional(AetherEntityTypes.SUN_SPIRIT.getId())
                .addOptional(AetherEntityTypes.SLIDER.getId())
                .addOptional(AetherEntityTypes.VALKYRIE_QUEEN.getId())
                .addOptional(UnusualendModEntities.ENDSTONE_GOLEM.getId());
        tag(PackTags.EntityTypes.CAGERIUM_BOSS_TYPES)
                .addOptionalTag(PackTags.EntityTypes.BOSSES.location());
        tag(PackTags.EntityTypes.CAGERIUM_BLACKLIST);
        tag(PackTags.EntityTypes.EVOKER_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:windcaller")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:geomancer")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:mage")));
        tag(PackTags.EntityTypes.ICEOLOGER_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("friendsandfoes:iceologer")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:iceologer")));
        tag(PackTags.EntityTypes.ILLUSIONER_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:illusioner")));
        tag(PackTags.EntityTypes.VINDICATOR_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:royal_guard")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:mountaineer")));
        tag(PackTags.EntityTypes.IRON_GOLEM_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:redstone_cube")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:squall_golem")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:redstone_golem")));
        tag(PackTags.EntityTypes.ILLAGERS)
                .addTag(PackTags.EntityTypes.EVOKER_TYPES)
                .addTag(PackTags.EntityTypes.ICEOLOGER_TYPES)
                .addTag(PackTags.EntityTypes.ILLUSIONER_TYPES)
                .addTag(PackTags.EntityTypes.VINDICATOR_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:redstone_cube")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:squall_golem")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("dungeons_mobs:redstone_golem")));
        tag(PackTags.EntityTypes.DROPS_CURRENCY)
                .addOptional(AetherEntityTypes.AECHOR_PLANT.getId())
                .addOptional(AetherEntityTypes.COCKATRICE.getId())
                .addOptional(AetherEntityTypes.FIRE_MINION.getId())
                .addOptional(AetherEntityTypes.SENTRY.getId())
                .addOptional(AetherEntityTypes.BLUE_SWET.getId())
                .addOptional(AetherEntityTypes.GOLDEN_SWET.getId())
                .addOptional(AetherEntityTypes.WHIRLWIND.getId())
                .addOptional(AetherEntityTypes.EVIL_WHIRLWIND.getId())
                .addOptional(AetherEntityTypes.VALKYRIE.getId())
                .addOptional(AetherEntityTypes.ZEPHYR.getId())
                .addOptional(UnusualendModEntities.BOLOK.getId())
                .addOptional(UnusualendModEntities.DRAGLING.getId())
                .addOptional(UnusualendModEntities.ENDER_BLOB.getId())
                .addOptional(UnusualendModEntities.UNDEAD_ENDERLING.getId())
                .addOptional(UnusualendModEntities.ENDSTONE_TRAPPER.getId());
    }
}
