package com.github.warrentode.turtleblockacademy.datagen;

import com.github.warrentode.turtleblockacademy.util.ModSounds;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class SoundsFileGen extends SoundDefinitionsProvider {
    protected SoundsFileGen(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, MODID, helper);
    }

    @Override
    public void registerSounds() {
        this.add(ModSounds.BLOCK_DESK_OPEN, definition()
                .subtitle("subtitles.turtleblockacademy.desk_open")
                .with(sound(new ResourceLocation("minecraft", "block/barrel/open1")).pitch(2))
                .with(sound(new ResourceLocation("minecraft", "block/barrel/open2")).pitch(2))
        );
        this.add(ModSounds.BLOCK_DESK_CLOSE, definition()
                .subtitle("subtitles.turtleblockacademy.desk_close")
                .with(sound(new ResourceLocation("minecraft", "block/barrel/close")).pitch(2))
        );

        this.add(ModSounds.BLOCK_LOCKER_OPEN, definition()
                .subtitle("subtitles.turtleblockacademy.locker_open")
                .with(sound(new ResourceLocation("minecraft", "block/chest/open")).pitch(2))
        );
        this.add(ModSounds.BLOCK_LOCKER_CLOSE, definition()
                .subtitle("subtitles.turtleblockacademy.locker_close")
                .with(sound(new ResourceLocation("minecraft", "block/chest/close")).pitch(2))
        );
    }
}