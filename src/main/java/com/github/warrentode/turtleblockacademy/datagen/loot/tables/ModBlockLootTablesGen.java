package com.github.warrentode.turtleblockacademy.datagen.loot.tables;

import com.github.warrentode.turtleblockacademy.blocks.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class ModBlockLootTablesGen extends BlockLoot {
    @Override
    protected void addTables() {
        this.dropSelf(ModBlocks.CERTIFICATE_BLOCK.get());

        this.dropSelf(ModBlocks.PLATE_WHITE.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_WARPED.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CRIMSON.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_MANGROVE.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_OAK.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_BIRCH.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_SPRUCE.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_DARK_OAK.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_JUNGLE.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_ACACIA.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_WARPED.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_CRIMSON.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_MANGROVE.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_OAK.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_BIRCH.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_SPRUCE.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_DARK_OAK.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_JUNGLE.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_ACACIA.get());

        this.dropSelf(ModBlocks.DESK_CHAIR_WARPED.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_CRIMSON.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_MANGROVE.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_OAK.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_BIRCH.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_SPRUCE.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_DARK_OAK.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_JUNGLE.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_ACACIA.get());

        this.dropSelf(ModBlocks.LOCKER_WARPED.get());
        this.dropSelf(ModBlocks.LOCKER_CRIMSON.get());
        this.dropSelf(ModBlocks.LOCKER_MANGROVE.get());
        this.dropSelf(ModBlocks.LOCKER_OAK.get());
        this.dropSelf(ModBlocks.LOCKER_BIRCH.get());
        this.dropSelf(ModBlocks.LOCKER_SPRUCE.get());
        this.dropSelf(ModBlocks.LOCKER_DARK_OAK.get());
        this.dropSelf(ModBlocks.LOCKER_JUNGLE.get());
        this.dropSelf(ModBlocks.LOCKER_ACACIA.get());

        this.dropSelf(ModBlocks.PARK_BENCH_WARPED.get());
        this.dropSelf(ModBlocks.PARK_BENCH_CRIMSON.get());
        this.dropSelf(ModBlocks.PARK_BENCH_MANGROVE.get());
        this.dropSelf(ModBlocks.PARK_BENCH_OAK.get());
        this.dropSelf(ModBlocks.PARK_BENCH_BIRCH.get());
        this.dropSelf(ModBlocks.PARK_BENCH_SPRUCE.get());
        this.dropSelf(ModBlocks.PARK_BENCH_DARK_OAK.get());
        this.dropSelf(ModBlocks.PARK_BENCH_JUNGLE.get());
        this.dropSelf(ModBlocks.PARK_BENCH_ACACIA.get());

        this.dropSelf(ModBlocks.TABLE_WARPED.get());
        this.dropSelf(ModBlocks.TABLE_CRIMSON.get());
        this.dropSelf(ModBlocks.TABLE_MANGROVE.get());
        this.dropSelf(ModBlocks.TABLE_OAK.get());
        this.dropSelf(ModBlocks.TABLE_BIRCH.get());
        this.dropSelf(ModBlocks.TABLE_SPRUCE.get());
        this.dropSelf(ModBlocks.TABLE_DARK_OAK.get());
        this.dropSelf(ModBlocks.TABLE_JUNGLE.get());
        this.dropSelf(ModBlocks.TABLE_ACACIA.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_FIR.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_FIR.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_FIR.get());
        this.dropSelf(ModBlocks.LOCKER_FIR.get());
        this.dropSelf(ModBlocks.PARK_BENCH_FIR.get());
        this.dropSelf(ModBlocks.TABLE_FIR.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_REDWOOD.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_REDWOOD.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_REDWOOD.get());
        this.dropSelf(ModBlocks.LOCKER_REDWOOD.get());
        this.dropSelf(ModBlocks.PARK_BENCH_REDWOOD.get());
        this.dropSelf(ModBlocks.TABLE_REDWOOD.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_CHERRY.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_CHERRY.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_CHERRY.get());
        this.dropSelf(ModBlocks.LOCKER_CHERRY.get());
        this.dropSelf(ModBlocks.PARK_BENCH_CHERRY.get());
        this.dropSelf(ModBlocks.TABLE_CHERRY.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_MAHOGANY.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_MAHOGANY.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_MAHOGANY.get());
        this.dropSelf(ModBlocks.LOCKER_MAHOGANY.get());
        this.dropSelf(ModBlocks.PARK_BENCH_MAHOGANY.get());
        this.dropSelf(ModBlocks.TABLE_MAHOGANY.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_JACARANDA.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_JACARANDA.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_JACARANDA.get());
        this.dropSelf(ModBlocks.LOCKER_JACARANDA.get());
        this.dropSelf(ModBlocks.PARK_BENCH_JACARANDA.get());
        this.dropSelf(ModBlocks.TABLE_JACARANDA.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_PALM.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_PALM.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_PALM.get());
        this.dropSelf(ModBlocks.LOCKER_PALM.get());
        this.dropSelf(ModBlocks.PARK_BENCH_PALM.get());
        this.dropSelf(ModBlocks.TABLE_PALM.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_WILLOW.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_WILLOW.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_WILLOW.get());
        this.dropSelf(ModBlocks.LOCKER_WILLOW.get());
        this.dropSelf(ModBlocks.PARK_BENCH_WILLOW.get());
        this.dropSelf(ModBlocks.TABLE_WILLOW.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_DEAD.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_DEAD.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_DEAD.get());
        this.dropSelf(ModBlocks.LOCKER_DEAD.get());
        this.dropSelf(ModBlocks.PARK_BENCH_DEAD.get());
        this.dropSelf(ModBlocks.TABLE_DEAD.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_MAGIC.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_MAGIC.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_MAGIC.get());
        this.dropSelf(ModBlocks.LOCKER_MAGIC.get());
        this.dropSelf(ModBlocks.PARK_BENCH_MAGIC.get());
        this.dropSelf(ModBlocks.TABLE_MAGIC.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_UMBRAN.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_UMBRAN.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_UMBRAN.get());
        this.dropSelf(ModBlocks.LOCKER_UMBRAN.get());
        this.dropSelf(ModBlocks.PARK_BENCH_UMBRAN.get());
        this.dropSelf(ModBlocks.TABLE_UMBRAN.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_HELLBARK.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_HELLBARK.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_HELLBARK.get());
        this.dropSelf(ModBlocks.LOCKER_HELLBARK.get());
        this.dropSelf(ModBlocks.PARK_BENCH_HELLBARK.get());
        this.dropSelf(ModBlocks.TABLE_HELLBARK.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_COCONUT.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_COCONUT.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_COCONUT.get());
        this.dropSelf(ModBlocks.LOCKER_COCONUT.get());
        this.dropSelf(ModBlocks.PARK_BENCH_COCONUT.get());
        this.dropSelf(ModBlocks.TABLE_COCONUT.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_WALNUT.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_WALNUT.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_WALNUT.get());
        this.dropSelf(ModBlocks.LOCKER_WALNUT.get());
        this.dropSelf(ModBlocks.PARK_BENCH_WALNUT.get());
        this.dropSelf(ModBlocks.TABLE_WALNUT.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_AZALEA.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_AZALEA.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_AZALEA.get());
        this.dropSelf(ModBlocks.LOCKER_AZALEA.get());
        this.dropSelf(ModBlocks.PARK_BENCH_AZALEA.get());
        this.dropSelf(ModBlocks.TABLE_AZALEA.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_FLOWERING_AZALEA.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_FLOWERING_AZALEA.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_FLOWERING_AZALEA.get());
        this.dropSelf(ModBlocks.LOCKER_FLOWERING_AZALEA.get());
        this.dropSelf(ModBlocks.PARK_BENCH_FLOWERING_AZALEA.get());
        this.dropSelf(ModBlocks.TABLE_FLOWERING_AZALEA.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_GOLDEN_OAK.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_GOLDEN_OAK.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_GOLDEN_OAK.get());
        this.dropSelf(ModBlocks.LOCKER_GOLDEN_OAK.get());
        this.dropSelf(ModBlocks.PARK_BENCH_GOLDEN_OAK.get());
        this.dropSelf(ModBlocks.TABLE_GOLDEN_OAK.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_AETHER_SKYROOT.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_AETHER_SKYROOT.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_AETHER_SKYROOT.get());
        this.dropSelf(ModBlocks.LOCKER_AETHER_SKYROOT.get());
        this.dropSelf(ModBlocks.PARK_BENCH_AETHER_SKYROOT.get());
        this.dropSelf(ModBlocks.TABLE_AETHER_SKYROOT.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_PREAM.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_PREAM.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_PREAM.get());
        this.dropSelf(ModBlocks.LOCKER_PREAM.get());
        this.dropSelf(ModBlocks.PARK_BENCH_PREAM.get());
        this.dropSelf(ModBlocks.TABLE_PREAM.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_EBONY.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_EBONY.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_EBONY.get());
        this.dropSelf(ModBlocks.LOCKER_EBONY.get());
        this.dropSelf(ModBlocks.PARK_BENCH_EBONY.get());
        this.dropSelf(ModBlocks.TABLE_EBONY.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_CHORUS_NEST.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_CHORUS_NEST.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_CHORUS_NEST.get());
        this.dropSelf(ModBlocks.LOCKER_CHORUS_NEST.get());
        this.dropSelf(ModBlocks.PARK_BENCH_CHORUS_NEST.get());
        this.dropSelf(ModBlocks.TABLE_CHORUS_NEST.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_BLOODSHROOM.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_BLOODSHROOM.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_BLOODSHROOM.get());
        this.dropSelf(ModBlocks.LOCKER_BLOODSHROOM.get());
        this.dropSelf(ModBlocks.PARK_BENCH_BLOODSHROOM.get());
        this.dropSelf(ModBlocks.TABLE_BLOODSHROOM.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_ENDERBARK.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_ENDERBARK.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_ENDERBARK.get());
        this.dropSelf(ModBlocks.LOCKER_ENDERBARK.get());
        this.dropSelf(ModBlocks.PARK_BENCH_ENDERBARK.get());
        this.dropSelf(ModBlocks.TABLE_ENDERBARK.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_GREENHEART.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_GREENHEART.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_GREENHEART.get());
        this.dropSelf(ModBlocks.LOCKER_GREENHEART.get());
        this.dropSelf(ModBlocks.PARK_BENCH_GREENHEART.get());
        this.dropSelf(ModBlocks.TABLE_GREENHEART.get());

        this.dropSelf(ModBlocks.SCHOOL_DESK_TINKER_SKYROOT.get());
        this.dropSelf(ModBlocks.SCHOOL_DESK_CABINET_TINKER_SKYROOT.get());
        this.dropSelf(ModBlocks.DESK_CHAIR_TINKER_SKYROOT.get());
        this.dropSelf(ModBlocks.LOCKER_TINKER_SKYROOT.get());
        this.dropSelf(ModBlocks.PARK_BENCH_TINKER_SKYROOT.get());
        this.dropSelf(ModBlocks.TABLE_TINKER_SKYROOT.get());

        this.dropSelf(ModBlocks.BOOKCASE_WARPED.get());
        this.dropSelf(ModBlocks.BOOKCASE_CRIMSON.get());
        this.dropSelf(ModBlocks.BOOKCASE_MANGROVE.get());
        this.dropSelf(ModBlocks.BOOKCASE_OAK.get());
        this.dropSelf(ModBlocks.BOOKCASE_BIRCH.get());
        this.dropSelf(ModBlocks.BOOKCASE_SPRUCE.get());
        this.dropSelf(ModBlocks.BOOKCASE_DARK_OAK.get());
        this.dropSelf(ModBlocks.BOOKCASE_JUNGLE.get());
        this.dropSelf(ModBlocks.BOOKCASE_ACACIA.get());
        this.dropSelf(ModBlocks.BOOKCASE_FIR.get());
        this.dropSelf(ModBlocks.BOOKCASE_REDWOOD.get());
        this.dropSelf(ModBlocks.BOOKCASE_CHERRY.get());
        this.dropSelf(ModBlocks.BOOKCASE_MAHOGANY.get());
        this.dropSelf(ModBlocks.BOOKCASE_JACARANDA.get());
        this.dropSelf(ModBlocks.BOOKCASE_PALM.get());
        this.dropSelf(ModBlocks.BOOKCASE_WILLOW.get());
        this.dropSelf(ModBlocks.BOOKCASE_DEAD.get());
        this.dropSelf(ModBlocks.BOOKCASE_MAGIC.get());
        this.dropSelf(ModBlocks.BOOKCASE_UMBRAN.get());
        this.dropSelf(ModBlocks.BOOKCASE_HELLBARK.get());
        this.dropSelf(ModBlocks.BOOKCASE_COCONUT.get());
        this.dropSelf(ModBlocks.BOOKCASE_WALNUT.get());
        this.dropSelf(ModBlocks.BOOKCASE_AZALEA.get());
        this.dropSelf(ModBlocks.BOOKCASE_FLOWERING_AZALEA.get());
        this.dropSelf(ModBlocks.BOOKCASE_GOLDEN_OAK.get());
        this.dropSelf(ModBlocks.BOOKCASE_AETHER_SKYROOT.get());
        this.dropSelf(ModBlocks.BOOKCASE_PREAM.get());
        this.dropSelf(ModBlocks.BOOKCASE_EBONY.get());
        this.dropSelf(ModBlocks.BOOKCASE_CHORUS_NEST.get());
        this.dropSelf(ModBlocks.BOOKCASE_BLOODSHROOM.get());
        this.dropSelf(ModBlocks.BOOKCASE_ENDERBARK.get());
        this.dropSelf(ModBlocks.BOOKCASE_GREENHEART.get());
        this.dropSelf(ModBlocks.BOOKCASE_TINKER_SKYROOT.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        //noinspection deprecation
        return ForgeRegistries.BLOCKS.getValues().stream().filter(
                block -> MODID.equals(Registry.BLOCK.getKey(block).getNamespace()))
                .collect(Collectors.toSet());
    }
}