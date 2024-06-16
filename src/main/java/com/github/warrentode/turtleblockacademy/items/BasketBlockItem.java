package com.github.warrentode.turtleblockacademy.items;

import com.github.warrentode.turtleblockacademy.blocks.entity.BasketBlockEntity;
import com.github.warrentode.turtleblockacademy.blocks.entity.gui.basket.BasketMenu;
import com.github.warrentode.turtleblockacademy.blocks.furniture.BasketBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

public class BasketBlockItem extends BlockItem {
    public final BasketBlock basketBlock;

    public BasketBlockItem(Block block, Properties properties) {
        super(block, properties);
        this.basketBlock = (BasketBlock) block;
    }

    public DyeColor getColor() {
        return this.basketBlock.getColor();
    }

    public int getInventorySize(ItemStack stack) {
        return BasketBlockEntity.INVENTORY_SIZE;
    }

    public IItemHandler getInventory(ItemStack stack) {
        ItemStackHandler stackHandler = new ItemStackHandler(getInventorySize(stack));
        stackHandler.deserializeNBT(stack.getOrCreateTag().getCompound("inventory"));
        return stackHandler;
    }

    public void saveInventory(ItemStack stack, IItemHandler itemHandler) {
        if (itemHandler instanceof ItemStackHandler) {
            stack.getOrCreateTag().put("inventory", ((ItemStackHandler) itemHandler).serializeNBT());
        }
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player playerIn, @NotNull InteractionHand hand) {
        ItemStack heldStack = playerIn.getItemInHand(hand);
        if (!level.isClientSide() && playerIn instanceof ServerPlayer serverPlayer) {
            NetworkHooks.openScreen(serverPlayer, new SimpleMenuProvider(
                            (id, playerInventory, player) ->
                                    new BasketMenu(id, playerInventory,
                                            new SimpleContainer(getInventorySize(heldStack))),
                            Component.translatable("container.turtleblockacademy.basket")),
                    buf -> buf.writeItemStack(playerIn.getItemInHand(hand), false)
            );
        }
        return InteractionResultHolder.sidedSuccess(heldStack, level.isClientSide());
    }

    @Override
    public @NotNull InteractionResult place(@NotNull BlockPlaceContext context) {
        Player player = context.getPlayer();
        if (player != null && player.isShiftKeyDown()) {
            return super.place(context);
        }
        return InteractionResult.PASS;
    }
}