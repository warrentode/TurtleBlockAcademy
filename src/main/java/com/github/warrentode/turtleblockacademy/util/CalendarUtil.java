package com.github.warrentode.turtleblockacademy.util;

import com.mojang.math.Vector3f;
import com.mojang.math.Vector4f;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.server.ServerLifecycleHooks;
import sereneseasons.api.season.Season;
import sereneseasons.api.season.SeasonHelper;
import slimeknights.tconstruct.smeltery.block.FaucetBlock;

import java.awt.*;
import java.awt.image.ColorModel;
import java.util.Calendar;
import java.util.Objects;

public class CalendarUtil {
    public static Boolean isSeason;
    public static Vector3f PRIMARY_SEASONAL_COLOR = new Vector3f(0, 0, 0);
    public static Vector3f SECONDARY_SEASONAL_COLOR = new Vector3f(0, 0, 0);

    public static boolean check(String season) {
        if (ModList.get().isLoaded("sereneseasons")) {
            MinecraftServer minecraftServer = ServerLifecycleHooks.getCurrentServer().getPlayerList().getServer();
            //noinspection ConstantValue
            if (minecraftServer != null) {
                ServerLevel serverLevel = minecraftServer.createCommandSourceStack().getLevel();
                if (Objects.equals(season, "ANNIVERSARY")) {
                    return isSeason = CalendarUtil.isAnniversary(serverLevel);
                }
                if (Objects.equals(season, "BIRTHDAY")) {
                    return isSeason = CalendarUtil.isBirthday(serverLevel);
                }
                if (Objects.equals(season, "HALLOWEEN")) {
                    return isSeason = CalendarUtil.isHalloween(serverLevel);
                }
                if (Objects.equals(season, "CHRISTMAS")) {
                    return isSeason = CalendarUtil.isChristmas(serverLevel);
                }
                if (Objects.equals(season, "EASTER")) {
                    return isSeason = CalendarUtil.isEaster(serverLevel);
                }
                if (Objects.equals(season, "NEW_YEAR")) {
                    return isSeason = CalendarUtil.isNewYear(serverLevel);
                }
                if (Objects.equals(season, "SPRING")) {
                    return isSeason = CalendarUtil.isSpring(serverLevel);
                }
                if (Objects.equals(season, "SUMMER")) {
                    return isSeason = CalendarUtil.isSummer(serverLevel);
                }
                if (Objects.equals(season, "AUTUMN")) {
                    return isSeason = CalendarUtil.isAutumn(serverLevel);
                }
                if (Objects.equals(season, "WINTER")) {
                    return isSeason = CalendarUtil.isWinter(serverLevel);
                }
            }
        }
        return false;
    }

    public static boolean isAnniversary(ServerLevel level) {
        if (ModList.get().isLoaded("sereneseasons") && level.dimension() == Level.OVERWORLD) {
            // gold
            setPrimarySeasonalColor(255, 215, 0);
            // silver
            setSecondarySeasonalColor(192, 192, 192);
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            return subSeason == Season.SubSeason.EARLY_SPRING;
        }
        else if (!ModList.get().isLoaded("sereneseasons") || level.dimension() != Level.OVERWORLD) {
            // gold
            setPrimarySeasonalColor(255, 215, 0);
            // silver
            setSecondarySeasonalColor(192, 192, 192);
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);

            // week of the blog's first post on Patreon anniversary
            return month == Calendar.JANUARY && (date >= 21 && date <= 27);
        }
        else {
            return false;
        }
    }

    public static boolean isEaster(ServerLevel level) {
        if (ModList.get().isLoaded("sereneseasons") && level.dimension() == Level.OVERWORLD) {
            // fuchsia
            setPrimarySeasonalColor(255, 0, 255);
            // crayola canary
            setSecondarySeasonalColor(255, 255, 153);
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            return subSeason == Season.SubSeason.MID_SPRING;
        }
        else if (!ModList.get().isLoaded("sereneseasons") || level.dimension() != Level.OVERWORLD) {
            // fuchsia
            setPrimarySeasonalColor(255, 0, 255);
            // crayola canary
            setSecondarySeasonalColor(255, 255, 153);
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);

            return (month == Calendar.MARCH && date >= 19) || month == Calendar.APRIL;
        }
        else {
            return false;
        }
    }

    public static boolean isHalloween(ServerLevel level) {
        if (ModList.get().isLoaded("sereneseasons") && level.dimension() == Level.OVERWORLD) {
            // dark orange
            setPrimarySeasonalColor(255, 140, 0);
            // crayola licorice
            setSecondarySeasonalColor(26, 17, 16);
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            return subSeason == Season.SubSeason.MID_AUTUMN;
        }
        else if (!ModList.get().isLoaded("sereneseasons") || level.dimension() != Level.OVERWORLD) {
            // dark orange
            setPrimarySeasonalColor(255, 140, 0);
            // crayola licorice
            setSecondarySeasonalColor(26, 17, 16);
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);

            return month == Calendar.OCTOBER;
        }
        else {
            return false;
        }
    }

    public static boolean isChristmas(ServerLevel level) {
        if (ModList.get().isLoaded("sereneseasons") && level.dimension() == Level.OVERWORLD) {
            // crayola winter wizard
            setPrimarySeasonalColor(160, 230, 255);
            // crayola winter sky
            setSecondarySeasonalColor(255, 0, 124);
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            return subSeason == Season.SubSeason.EARLY_WINTER;
        }
        else if (!ModList.get().isLoaded("sereneseasons") || level.dimension() != Level.OVERWORLD) {
            // crayola winter wizard
            setPrimarySeasonalColor(160, 230, 255);
            // crayola winter sky
            setSecondarySeasonalColor(255, 0, 124);
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);

            return month == Calendar.DECEMBER;
        }
        else {
            return false;
        }
    }

    public static boolean isBirthday(ServerLevel level) {
        if (ModList.get().isLoaded("sereneseasons") && level.dimension() == Level.OVERWORLD) {
            // chocolate
            setPrimarySeasonalColor(210, 105, 30);
            // crayola strawberry
            setSecondarySeasonalColor(252, 90, 141);
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            return subSeason == Season.SubSeason.MID_WINTER;
        }
        else if (!ModList.get().isLoaded("sereneseasons") || level.dimension() != Level.OVERWORLD) {
            // chocolate
            setPrimarySeasonalColor(210, 105, 30);
            // crayola strawberry
            setSecondarySeasonalColor(252, 90, 141);
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);

            // week of todecoins' birthday
            return month == Calendar.DECEMBER && (date >= 19 && date <= 21);
        }
        else {
            return false;
        }
    }

    public static boolean isNewYear(ServerLevel level) {
        if (ModList.get().isLoaded("sereneseasons") && level.dimension() == Level.OVERWORLD) {
            // red
            setPrimarySeasonalColor(255, 0, 0);
            // crayola illuminating emerald
            setSecondarySeasonalColor(49, 145, 119);
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            return subSeason == Season.SubSeason.LATE_WINTER;
        }
        else if (!ModList.get().isLoaded("sereneseasons") || level.dimension() != Level.OVERWORLD) {
            // red
            setPrimarySeasonalColor(255, 0, 0);
            // crayola illuminating emerald
            setSecondarySeasonalColor(49, 145, 119);
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);

            // Georgian and lunisolar calendar time frames
            return (month == Calendar.DECEMBER && date == 31) || (month == Calendar.JANUARY && date == 1)
                    || ((month == Calendar.FEBRUARY && date <= 20) || (month == Calendar.JANUARY && date >= 21));
        }
        else {
            return false;
        }
    }

    public static boolean isSpring(ServerLevel level) {
        if (ModList.get().isLoaded("sereneseasons") && level.dimension() == Level.OVERWORLD) {
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            // pale green
            setPrimarySeasonalColor(152, 251, 152);
            // crayola sunglow
            setSecondarySeasonalColor(255, 204, 51);
            return subSeason == Season.SubSeason.EARLY_SPRING
                    || subSeason == Season.SubSeason.MID_SPRING
                    || subSeason == Season.SubSeason.LATE_SPRING;
        }
        else if (!ModList.get().isLoaded("sereneseasons") || level.dimension() != Level.OVERWORLD) {
            // pale green
            setPrimarySeasonalColor(152, 251, 152);
            // crayola sunglow
            setSecondarySeasonalColor(255, 204, 51);
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);

            return (month == Calendar.MARCH && date >= 20) || (month == Calendar.JUNE && date <= 20);
        }
        else {
            return false;
        }
    }

    public static boolean isSummer(ServerLevel level) {
        if (ModList.get().isLoaded("sereneseasons") && level.dimension() == Level.OVERWORLD) {
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            // yellow
            setPrimarySeasonalColor(255, 255, 0);
            // crayola wild watermelon
            setSecondarySeasonalColor(253, 91, 120);
            return subSeason == Season.SubSeason.EARLY_SUMMER
                    || subSeason == Season.SubSeason.MID_SUMMER
                    || subSeason == Season.SubSeason.LATE_SUMMER;
        }
        else if (!ModList.get().isLoaded("sereneseasons") || level.dimension() != Level.OVERWORLD) {
            // yellow
            setPrimarySeasonalColor(255, 255, 0);
            // crayola wild watermelon
            setSecondarySeasonalColor(253, 91, 120);
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);

            return (month == Calendar.JUNE && date >= 20) || (month == Calendar.SEPTEMBER && date <= 20);
        }
        else {
            return false;
        }
    }

    public static boolean isAutumn(ServerLevel level) {
        if (ModList.get().isLoaded("sereneseasons") && level.dimension() == Level.OVERWORLD) {
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            // burly wood
            setPrimarySeasonalColor(222, 184, 135);
            // crayola twilight lavender
            setSecondarySeasonalColor(138, 73, 107);
            return subSeason == Season.SubSeason.EARLY_AUTUMN
                    || subSeason == Season.SubSeason.MID_AUTUMN
                    || subSeason == Season.SubSeason.LATE_AUTUMN;
        }
        else if (!ModList.get().isLoaded("sereneseasons") || level.dimension() != Level.OVERWORLD) {
            // burly wood
            setPrimarySeasonalColor(222, 184, 135);
            // crayola twilight lavender
            setSecondarySeasonalColor(138, 73, 107);
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);

            return (month == Calendar.SEPTEMBER && date >= 20) || (month == Calendar.DECEMBER && date <= 20);
        }
        else {
            return false;
        }
    }

    public static boolean isWinter(ServerLevel level) {
        if (ModList.get().isLoaded("sereneseasons") && level.dimension() == Level.OVERWORLD) {
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            // powder blue
            setPrimarySeasonalColor(176, 224, 230);
            // crayola wintergreen dream
            setSecondarySeasonalColor(86, 136, 125);
            return subSeason == Season.SubSeason.EARLY_WINTER
                    || subSeason == Season.SubSeason.MID_WINTER
                    || subSeason == Season.SubSeason.LATE_WINTER;
        }
        else if (!ModList.get().isLoaded("sereneseasons") || level.dimension() != Level.OVERWORLD) {
            // powder blue
            setPrimarySeasonalColor(176, 224, 230);
            // crayola wintergreen dream
            setSecondarySeasonalColor(86, 136, 125);
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);

            return (month == Calendar.DECEMBER && date >= 20) || (month == Calendar.MARCH && date <= 20);
        }
        else {
            return false;
        }
    }

    public static Vector3f getPrimarySeasonalColor() {
        return PRIMARY_SEASONAL_COLOR;
    }

    public static Vector3f getSecondarySeasonalColor() {
        return SECONDARY_SEASONAL_COLOR;
    }

    /**
     omg trying to figure out tint indexing for the damn eggs paid off here, because I actually understood what I was
     reading when I looked up Vector3f color values after stumbling upon SlimeKnight's {@link FaucetBlock} while puzzling
     out how to get a festive particle effect going, so I know what I need to set up here to get the dust particle effect
     for the baskets to have random colors based on the seasonal event - I hope
     using the textureDiffuseColors equation in the {@link DyeColor} after reading this webpage:
     <a href="https://nanogui.readthedocs.io/en/latest/api/classnanogui_1_1Color.html">here</a>
     yes, it's for C++ and Python, but I should be able to translate it easily enough - we'll see
     Eigen method is not found in a quick search of my external libraries, but {@link Vector4f}, {@link Color}, and
     {@link ColorModel} were found - based on {@link ColorModel getDefaultTransferType} it would seem that maybe those
     values in the DyeColor class textureDiffuseColors equation deals with the pixel size to be transferred for the color
     model? Sorry, this is a lot of info - I'm bookmarking this all here for now as a reference, although I expect anyone
     coming here likely has a better understanding of all this than I do
     if this works, I'll mark this section of my code MIT for anyone to use, if not it will be get archived in the test
     bucket at some point for me to review and revisit, which sadly means some of the links will break so I will try to
     remember to relink the references if needed
     **/

    public static void setPrimarySeasonalColor(int red, int green, int blue) {
        /**
         I know, I could use the DyeColor class for this, but a part of me really wants to try tapping
         into the RGB values I use in GIMP when I tinker with graphics and what not and see what I can do
         with those values in here - what's the point if I don't experiment and stretch my wings in order to
         actually learn this stuff?
         **/

        /*
        what are these values actually for? are these the specific values I read about in the wiki that
        skew the block color values towards a certain end of the color spectrum? I don't need that
        for these particles - and why isn't the alpha channel present in the DyeColor class the way it is
        over on that web page?
         */

        /**
         "An alpha value of 1.0 or 255 means that the color is completely
         opaque and an alpha value of 0 or 0.0 means that the color is completely transparent. When constructing a Color
         with an explicit alpha or getting the color/alpha components of a Color, the color components are never
         pre-multiplied by the alpha component."

         - quoted from: <a href="https://docs.oracle.com/javafx/2/api/javafx/scene/paint/Color.html">here</a>
         **/

        /*
        given everything I've read so far, I still want to move forward with just testing out clean values
        for R, G, B - okay, so here we go...
         */

        // actually decided not to use this equation from the DyeColor class directly
        // this.textureDiffuseColors = new float[]{(float)i / 255.0F, (float)j / 255.0F, (float)k / 255.0F};

        float alpha = 255.0F;

        PRIMARY_SEASONAL_COLOR = new Vector3f(red / alpha, green / alpha, blue / alpha);
    }

    public static void setSecondarySeasonalColor(int red, int green, int blue) {
        float alpha = 255.0F;

        SECONDARY_SEASONAL_COLOR = new Vector3f(red / alpha, green / alpha, blue / alpha);
    }
}