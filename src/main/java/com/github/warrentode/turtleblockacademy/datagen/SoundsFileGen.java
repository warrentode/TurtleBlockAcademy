package com.github.warrentode.turtleblockacademy.datagen;

import com.github.warrentode.turtleblockacademy.util.TBASounds;
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
        this.add(TBASounds.BLOCK_DESK_OPEN, definition()
                .subtitle("subtitles.turtleblockacademy.desk_open")
                .with(sound(new ResourceLocation("minecraft", "block/barrel/open1")).pitch(2))
                .with(sound(new ResourceLocation("minecraft", "block/barrel/open2")).pitch(2))
        );
        this.add(TBASounds.BLOCK_DESK_CLOSE, definition()
                .subtitle("subtitles.turtleblockacademy.desk_close")
                .with(sound(new ResourceLocation("minecraft", "block/barrel/close")).pitch(2))
        );

        this.add(TBASounds.BLOCK_LOCKER_OPEN, definition()
                .subtitle("subtitles.turtleblockacademy.locker_open")
                .with(sound(new ResourceLocation("minecraft", "block/chest/open")).pitch(2))
        );
        this.add(TBASounds.BLOCK_LOCKER_CLOSE, definition()
                .subtitle("subtitles.turtleblockacademy.locker_close")
                .with(sound(new ResourceLocation("minecraft", "block/chest/close")).pitch(2))
        );

        this.add(TBASounds.BLOCK_BOOKCASE_OPEN, definition()
                .subtitle("subtitles.turtleblockacademy.bookcase_open")
                .with(sound(new ResourceLocation("minecraft", "item/book/close_put1")))
                .with(sound(new ResourceLocation("minecraft", "item/book/close_put2")))
        );
        this.add(TBASounds.BLOCK_BOOKCASE_CLOSE, definition()
                .subtitle("subtitles.turtleblockacademy.bookcase_close")
                .with(sound(new ResourceLocation("minecraft", "item/book/close_put1")))
                .with(sound(new ResourceLocation("minecraft", "item/book/close_put2")))
        );

        this.add(TBASounds.TREASURE_BEETLE_HURT, definition()
                .subtitle("subtitles.turtleblockacademy.treasure_beetle_hurts")
                .with(sound(new ResourceLocation("minecraft", "mob/spider/say1")))
                .with(sound(new ResourceLocation("minecraft", "mob/spider/say2")))
                .with(sound(new ResourceLocation("minecraft", "mob/spider/say3")))
                .with(sound(new ResourceLocation("minecraft", "mob/spider/say4")))
        );
        this.add(TBASounds.TREASURE_BEETLE_AMBIENT, definition()
                .subtitle("subtitles.turtleblockacademy.treasure_beetle_ambient")
                .with(sound(new ResourceLocation("minecraft", "mob/spider/say1")))
                .with(sound(new ResourceLocation("minecraft", "mob/spider/say2")))
                .with(sound(new ResourceLocation("minecraft", "mob/spider/say3")))
                .with(sound(new ResourceLocation("minecraft", "mob/spider/say4")))
        );
        this.add(TBASounds.TREASURE_BEETLE_DEATH, definition()
                .subtitle("subtitles.turtleblockacademy.treasure_beetle_death")
                .with(sound(new ResourceLocation("minecraft", "mob/spider/death")))
        );
        this.add(TBASounds.TREASURE_BEETLE_STEP, definition()
                .subtitle("subtitles.turtleblockacademy.treasure_beetle_step")
                .with(sound(new ResourceLocation("minecraft", "mob/spider/step1")))
                .with(sound(new ResourceLocation("minecraft", "mob/spider/step2")))
                .with(sound(new ResourceLocation("minecraft", "mob/spider/step3")))
                .with(sound(new ResourceLocation("minecraft", "mob/spider/step4")))
        );
        this.add(TBASounds.TREASURE_BEETLE_ITEM_DROP, definition()
                .subtitle("subtitles.turtleblockacademy.treasure_beetle_item_drop")
                .with(sound(new ResourceLocation("minecraft", "note/icechime")))
        );
        this.add(TBASounds.HEROBRINE_AMBIENT, definition()
                .subtitle("subtitles.turtleblockacademy.herobrine_ambient")
                .with(sound(new ResourceLocation("turtleblockacademy", "silence")))
        );
    }
}