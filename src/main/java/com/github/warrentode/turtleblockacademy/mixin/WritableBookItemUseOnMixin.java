package com.github.warrentode.turtleblockacademy.mixin;

import com.github.warrentode.turtleblockacademy.blocks.SchoolDeskBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.WritableBookItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WritableBookItem.class)
public class WritableBookItemUseOnMixin {

    @Inject(at = @At("HEAD"), method = "useOn", cancellable = true)
    public void useOn(@NotNull UseOnContext useOnContext, CallbackInfoReturnable<InteractionResult> cir) {
        Level level = useOnContext.getLevel();
        BlockPos pos = useOnContext.getClickedPos();
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();
        if (block instanceof SchoolDeskBlock) {
            cir.setReturnValue(SchoolDeskBlock.tryPlaceBook(useOnContext.getPlayer(), level, pos, state,
                    useOnContext.getItemInHand()) ?
                    InteractionResult.sidedSuccess(level.isClientSide) : InteractionResult.PASS);
        }
    }
}
