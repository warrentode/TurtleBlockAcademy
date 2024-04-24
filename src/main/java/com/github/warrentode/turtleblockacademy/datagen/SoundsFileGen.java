package com.github.warrentode.turtleblockacademy.datagen;

import com.github.warrentode.turtleblockacademy.util.ModSounds;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class SoundsFileGen extends SoundDefinitionsProvider {
    protected SoundsFileGen(DataGenerator generator, String modid, ExistingFileHelper helper) {
        super(generator, modid, helper);
    }

    private static final String modid = "minecraft";

    @Override
    public void registerSounds() {
        this.add(ModSounds.BLOCK_DESK_OPEN, definition()
                .subtitle("subtitles.turtleblockacademy.desk_open")
                .with(sound(new ResourceLocation(modid, "block/barrel/open1")).pitch(2))
                .with(sound(new ResourceLocation(modid, "block/barrel/open2")).pitch(2))
        );
        this.add(ModSounds.BLOCK_DESK_CLOSE, definition()
                .subtitle("subtitles.turtleblockacademy.desk_close")
                .with(sound(new ResourceLocation(modid, "block/barrel/close")).pitch(2))
        );

        this.add(ModSounds.BLOCK_LOCKER_OPEN, definition()
                .subtitle("subtitles.turtleblockacademy.locker_open")
                .with(sound(new ResourceLocation(modid, "block/chest/open")).pitch(2))
        );
        this.add(ModSounds.BLOCK_LOCKER_CLOSE, definition()
                .subtitle("subtitles.turtleblockacademy.locker_close")
                .with(sound(new ResourceLocation(modid, "block/chest/close")).pitch(2))
        );
    }
}