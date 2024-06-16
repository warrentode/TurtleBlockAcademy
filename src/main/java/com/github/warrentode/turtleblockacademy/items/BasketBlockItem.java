package com.github.warrentode.turtleblockacademy.items;

import com.github.warrentode.turtleblockacademy.blocks.entity.BasketBlockEntity;
import com.github.warrentode.turtleblockacademy.blocks.entity.gui.basket.BasketMenu;
import com.github.warrentode.turtleblockacademy.blocks.furniture.BasketBlock;
import com.github.warrentode.turtleblockacademy.util.LogUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player playerIn, @NotNull InteractionHand hand) {
        ItemStack heldStack = playerIn.getItemInHand(hand);
        if (!level.isClientSide() && playerIn instanceof ServerPlayer serverPlayer) {
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

    @Override
    public void appendHoverText(@NotNull ItemStack basketItem, @Nullable Level level, @NotNull List<Component> toolTip, @NotNull TooltipFlag flag) {
        CompoundTag tag = basketItem.getTag();
        if (tag != null) {
            if (basketItem.getTag().contains("BlockEntityTag")) {
                if (basketItem.getTag().getCompound("BlockEntityTag").getCompound("inventory") != null) {
                    ItemStackHandler basketInventory = new ItemStackHandler(getInventorySize(basketItem));
                    basketInventory.deserializeNBT(basketItem.getTag().getCompound("BlockEntityTag").getCompound("inventory"));

                    toolTip.add(Component.translatable("container.turtleblockacademy.basket.contents").withStyle(ChatFormatting.ITALIC));

                    for (int i = 0; i < basketInventory.getSlots(); i++) {
                        if (basketInventory.getStackInSlot(i).getItem() != Items.AIR) {
                            MutableComponent mutableComponent = basketInventory.getStackInSlot(i).getHoverName().copy();
                            mutableComponent.append(" x").append(String.valueOf(basketItem.getCount()));
                            toolTip.add(Component.literal( "- " ).append(mutableComponent).withStyle(ChatFormatting.ITALIC));
                        }
                    }
                }
            }
        }
    }
}