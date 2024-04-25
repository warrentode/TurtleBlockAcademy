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
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        //noinspection deprecation
        return ForgeRegistries.BLOCKS.getValues().stream().filter(
                block -> MODID.equals(Registry.BLOCK.getKey(block).getNamespace()))
                .collect(Collectors.toSet());
    }
}