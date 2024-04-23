package com.github.warrentode.turtleblockacademy.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);

    public static final RegistryObject<SoundEvent> BLOCK_DESK_OPEN = SOUNDS.register("block.turtleblockacademy.desk.open",
            () -> new SoundEvent(new ResourceLocation(MODID, "block.turtleblockacademy..desk.open")));
    public static final RegistryObject<SoundEvent> BLOCK_DESK_CLOSE = SOUNDS.register("block.turtleblockacademy..desk.close",
            () -> new SoundEvent(new ResourceLocation(MODID, "block.turtleblockacademy..desk.close")));
}
