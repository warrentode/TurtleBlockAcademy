package com.github.warrentode.turtleblockacademy.blocks.entity.slot;

import com.github.warrentode.turtleblockacademy.blocks.entity.FermentingPotBlockEntity;
import com.github.warrentode.turtleblockacademy.recipe.TBARecipes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class FermentingPotResultSlot extends SlotItemHandler {
    public final FermentingPotBlockEntity potEntity;
    private final Player player;
    private int removeCount;

    public FermentingPotResultSlot(Player player, FermentingPotBlockEntity potEntity, IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
        this.potEntity = potEntity;
        this.player = player;
    }

    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        return net.minecraftforge.common.ForgeHooks.getBurnTime(stack, TBARecipes.RECIPE_TYPE_FERMENTING.get()) > 0;
    }

    @Override
    @Nonnull
    public ItemStack remove(int amount) {
        if (this.hasItem()) {
            this.removeCount += Math.min(amount, this.getItem().getCount());
        }

        return super.remove(amount);
    }

    @Override
    public void onTake(@NotNull Player player, @NotNull ItemStack stack) {
        this.checkTakeAchievements(stack);
        super.onTake(player, stack);
    }

    @Override
    protected void onQuickCraft(@NotNull ItemStack stack, int amount) {
        this.removeCount += amount;
        this.checkTakeAchievements(stack);
    }

    @Override
    protected void checkTakeAchievements(@NotNull ItemStack stack) {
        stack.onCraftedBy(this.player.level, this.player, this.removeCount);

        if (!this.player.level.isClientSide) {
            potEntity.awardUsedRecipes(this.player);
        }

        this.removeCount = 0;
    }
}