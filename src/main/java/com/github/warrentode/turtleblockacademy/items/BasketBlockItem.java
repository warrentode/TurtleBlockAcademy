package com.github.warrentode.turtleblockacademy.items;

import com.github.warrentode.turtleblockacademy.blocks.entity.BasketBlockEntity;
import com.github.warrentode.turtleblockacademy.blocks.entity.gui.basket.BasketMenu;
import com.github.warrentode.turtleblockacademy.blocks.furniture.BasketBlock;
import com.github.warrentode.turtleblockacademy.util.LogUtil;
import net.minecraft.nbt.CompoundTag;
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
        if (stack.getTag() != null && stack.getTag().contains("inventory")) {
            stackHandler.deserializeNBT(stack.getTag().getCompound("inventory"));
            LogUtil.info("Loaded inventory from item stack.");
        }
        else {
            LogUtil.info("No inventory data found on item stack. Creating new inventory.");
        }
        return stackHandler;
    }

    public void saveInventory(ItemStack stack, IItemHandler itemHandler) {
        if (itemHandler instanceof ItemStackHandler) {
            CompoundTag inventoryTag = ((ItemStackHandler) itemHandler).serializeNBT();
            stack.getOrCreateTag().put("inventory", inventoryTag);
            LogUtil.info("Saved inventory to item stack.");
        }
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player playerIn, @NotNull InteractionHand hand) {
        ItemStack heldStack = playerIn.getItemInHand(hand);
        if (!level.isClientSide() && playerIn instanceof ServerPlayer serverPlayer) {
            IItemHandler inventoryHandler = getInventory(heldStack);
            NetworkHooks.openScreen(serverPlayer, new SimpleMenuProvider(
                            (id, playerInventory, player) ->
                                    new BasketMenu(id, playerInventory),
                            Component.translatable("container.turtleblockacademy.basket")),
                    buf -> buf.writeItemStack(playerIn.getItemInHand(hand), false)
            );
            LogUtil.info("Opened basket screen.");
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