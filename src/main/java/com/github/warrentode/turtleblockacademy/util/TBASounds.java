package com.github.warrentode.turtleblockacademy.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TBASounds {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);

    public static final RegistryObject<SoundEvent> BLOCK_DESK_OPEN = SOUNDS.register("block.turtleblockacademy.desk.open",
            () -> new SoundEvent(new ResourceLocation(MODID, "block.turtleblockacademy.desk.open")));
    public static final RegistryObject<SoundEvent> BLOCK_DESK_CLOSE = SOUNDS.register("block.turtleblockacademy.desk.close",
            () -> new SoundEvent(new ResourceLocation(MODID, "block.turtleblockacademy.desk.close")));

    public static final RegistryObject<SoundEvent> BLOCK_LOCKER_OPEN = SOUNDS.register("block.turtleblockacademy.locker.open",
            () -> new SoundEvent(new ResourceLocation(MODID, "block.turtleblockacademy.locker.open")));
    public static final RegistryObject<SoundEvent> BLOCK_LOCKER_CLOSE = SOUNDS.register("block.turtleblockacademy.locker.close",
            () -> new SoundEvent(new ResourceLocation(MODID, "block.turtleblockacademy.locker.close")));

    public static final RegistryObject<SoundEvent> BLOCK_BOOKCASE_OPEN = SOUNDS.register("block.turtleblockacademy.bookcase.open",
            () -> new SoundEvent(new ResourceLocation(MODID, "block.turtleblockacademy.bookcase.open")));
    public static final RegistryObject<SoundEvent> BLOCK_BOOKCASE_CLOSE = SOUNDS.register("block.turtleblockacademy.bookcase.close",
            () -> new SoundEvent(new ResourceLocation(MODID, "block.turtleblockacademy.bookcase.close")));

    public static final RegistryObject<SoundEvent> TREASURE_BEETLE_HURT = SOUNDS.register("entity.turtleblockacademy.treasure_beetle.hurt",
            ()-> new SoundEvent(new ResourceLocation(MODID, "entity.turtleblockacademy.treasure_beetle.hurt")));
    public static final RegistryObject<SoundEvent> TREASURE_BEETLE_DEATH = SOUNDS.register("entity.turtleblockacademy.treasure_beetle.death",
            ()-> new SoundEvent(new ResourceLocation(MODID, "entity.turtleblockacademy.treasure_beetle.death")));
    public static final RegistryObject<SoundEvent> TREASURE_BEETLE_AMBIENT = SOUNDS.register("entity.turtleblockacademy.treasure_beetle.ambient",
            ()-> new SoundEvent(new ResourceLocation(MODID, "entity.turtleblockacademy.treasure_beetle.ambient")));
    public static final RegistryObject<SoundEvent> TREASURE_BEETLE_STEP = SOUNDS.register("entity.turtleblockacademy.treasure_beetle.step",
            ()-> new SoundEvent(new ResourceLocation(MODID, "entity.turtleblockacademy.treasure_beetle.step")));
    public static final RegistryObject<SoundEvent> TREASURE_BEETLE_ITEM_DROP = SOUNDS.register("entity.turtleblockacademy.treasure_beetle.item_drop",
            ()-> new SoundEvent(new ResourceLocation(MODID, "entity.turtleblockacademy.treasure_beetle.item_drop")));
}
