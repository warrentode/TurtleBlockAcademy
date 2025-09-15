package com.github.warrentode.turtleblockacademy.util;

import com.mojang.math.Vector3f;
import com.mojang.math.Vector4f;
import net.minecraft.world.item.DyeColor;
import slimeknights.tconstruct.smeltery.block.FaucetBlock;

import java.awt.*;
import java.awt.image.ColorModel;

public class SeasonalParticleColors {
    public static Vector3f PRIMARY_SEASONAL_PARTICLE_COLOR = new Vector3f(0, 0, 0);
    public static Vector3f SECONDARY_SEASONAL_PARTICLE_COLOR = new Vector3f(0, 0, 0);

    public SeasonalParticleColors() {}

    /** this check methos needs to be called in whatever class using these colors before using the
     * get color methods in here, otherwise you end up with black particles
     * Alternatively, you could insert this method into some kind of tick event -
     * this entire system in this class was originally designed for a block, so the block
     * entity tick method works for this **/
    // checks for the season in the CalendarUtil class and sets the appropriate color values
    public static void eventCheck() {
        if (CalendarUtil.check("ANNIVERSARY")) {
            // gold
            setPrimarySeasonalColor(255, 215, 0);
            // silver
            setSecondarySeasonalColor(192, 192, 192);
        }
        else if (CalendarUtil.check("EASTER")) {
            // fuchsia
            setPrimarySeasonalColor(255, 0, 255);
            // crayola canary
            setSecondarySeasonalColor(255, 255, 153);
        }
        else if (CalendarUtil.check("HALLOWEEN")) {
            // dark orange
            setPrimarySeasonalColor(255, 140, 0);
            // crayola licorice
            setSecondarySeasonalColor(26, 17, 16);
        }
        else if (CalendarUtil.check("CHRISTMAS")) {
            // crayola winter wizard
            setPrimarySeasonalColor(160, 230, 255);
            // crayola winter sky
            setSecondarySeasonalColor(255, 0, 124);
        }
        else if (CalendarUtil.check("BIRTHDAY")) {
            // chocolate
            setPrimarySeasonalColor(210, 105, 30);
            // crayola strawberry
            setSecondarySeasonalColor(252, 90, 141);
        }
        else if (CalendarUtil.check("NEW_YEAR")) {
            // red
            setPrimarySeasonalColor(255, 0, 0);
            // crayola illuminating emerald
            setSecondarySeasonalColor(49, 145, 119);
        }
        else if (CalendarUtil.check("SPRING")) {
            // pale green
            setPrimarySeasonalColor(152, 251, 152);
            // crayola sunglow
            setSecondarySeasonalColor(255, 204, 51);
        }
        else if (CalendarUtil.check("SUMMER")) {
            // yellow
            setPrimarySeasonalColor(255, 255, 0);
            // crayola wild watermelon
            setSecondarySeasonalColor(253, 91, 120);
        }
        else if (CalendarUtil.check("AUTUMN")) {
            // burly wood
            setPrimarySeasonalColor(222, 184, 135);
            // crayola twilight lavender
            setSecondarySeasonalColor(138, 73, 107);
        }
        // defaults to winter colors
        else {
            // powder blue
            setPrimarySeasonalColor(176, 224, 230);
            // crayola wintergreen dream
            setSecondarySeasonalColor(86, 136, 125);
        }
    }

    public static Vector3f getPrimarySeasonalParticleColor() {
        return PRIMARY_SEASONAL_PARTICLE_COLOR;
    }

    public static Vector3f getSecondarySeasonalParticleColor() {
        return SECONDARY_SEASONAL_PARTICLE_COLOR;
    }

    /**
     * references:
     * SlimeKnight's {@link FaucetBlock}
     * textureDiffuseColors equation in the {@link DyeColor}
     * <a href="https://nanogui.readthedocs.io/en/latest/api/classnanogui_1_1Color.html">Color Methods for C++ and Python</a>
     * {@link Vector4f}
     * {@link Color}
     * {@link ColorModel}
     **/

    // sets the RGB color values for each particle color
    public static void setPrimarySeasonalColor(int red, int green, int blue) {
        /**
         "An alpha value of 1.0 or 255 means that the color is completely opaque
         and an alpha value of 0 or 0.0 means that the color is completely transparent."

         - quoted from: <a href="https://docs.oracle.com/javafx/2/api/javafx/scene/paint/Color.html">here</a>
         **/

        float alpha = 255.0F;
        PRIMARY_SEASONAL_PARTICLE_COLOR = new Vector3f(red / alpha, green / alpha, blue / alpha);
    }
    public static void setSecondarySeasonalColor(int red, int green, int blue) {
        float alpha = 255.0F;
        SECONDARY_SEASONAL_PARTICLE_COLOR = new Vector3f(red / alpha, green / alpha, blue / alpha);
    }
}