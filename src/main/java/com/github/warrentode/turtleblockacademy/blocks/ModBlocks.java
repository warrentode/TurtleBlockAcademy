package com.github.warrentode.todeville.blocks;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.todeville.Todeville.MODID;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> CERTIFICATE_BLOCK = BLOCKS.register("certificate_block", ()->
            new CertificateBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GLOW_LICHEN).instabreak(),
                    CreativeModeTab.TAB_DECORATIONS));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
