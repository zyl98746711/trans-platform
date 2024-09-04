package com.zyl.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * app日志
 */
public class AppLogger {

    private static final String NAME = "appLogger";

    private static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    public static Logger getLogger() {
        return LOGGER;
    }

    public static void log(String msg) {
        LOGGER.info(msg);
    }

    public static void log(String format, Object obj) {
        LOGGER.info(format, obj);
    }

    public static void log(String var1, Object... var2) {
        LOGGER.info(var1, var2);
    }


}
