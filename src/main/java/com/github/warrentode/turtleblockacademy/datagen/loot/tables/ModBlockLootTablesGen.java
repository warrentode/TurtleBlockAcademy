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
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        //noinspection deprecation
        return ForgeRegistries.BLOCKS.getValues().stream().filter(
                block -> MODID.equals(Registry.BLOCK.getKey(block).getNamespace()))
                .collect(Collectors.toSet());
    }
}