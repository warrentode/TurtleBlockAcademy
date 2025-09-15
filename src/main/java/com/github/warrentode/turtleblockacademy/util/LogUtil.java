package com.github.warrentode.turtleblockacademy.util;

import com.github.warrentode.turtleblockacademy.TurtleBlockAcademy;
import org.apache.logging.log4j.Logger;

public class LogUtil {
    public static final Logger PRINCIPAL_HEROBRINE = TurtleBlockAcademy.LOGGER;

    public static void debug(String message, Object... params) {
        PRINCIPAL_HEROBRINE.debug(message, params);
    }

    public static void info(String message, Object... params) {
        PRINCIPAL_HEROBRINE.info(message, params);
    }

    public static void warn(String message, Object... params) {
        PRINCIPAL_HEROBRINE.warn(message, params);
    }

    public static void error(String message, Object... params) {
        PRINCIPAL_HEROBRINE.error(message, params);
    }
}