package com.github.warrentode.turtleblockacademy.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HangingEntityItem;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PlateItem extends HangingEntityItem {
    public PlateItem(EntityType<? extends HangingEntity> type, Properties properties) {
        super(type, properties);
    }

    protected boolean mayPlace(@NotNull Player player, @NotNull Direction direction, @NotNull ItemStack stack, @NotNull BlockPos pos) {
        return !player.level.isOutsideBuildHeight(pos) && player.mayUseItemAt(pos, direction, stack);
    }
}