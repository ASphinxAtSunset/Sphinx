package privt.gene.utils.apsect;

import org.slf4j.Logger;
import privt.gene.utils.apsect.enums.LogLevel;

/**
 * Created by Gene on 2017/12/21.
 */
public class LogUtils {
    public static void log(Logger LOGGER, LogLevel logLevel, String format, Object... arguments) {
        /**
         * 这里应该可以用switch替换
         */
        if (logLevel == LogLevel.debug) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(format, arguments);
            }
        } else if (logLevel == LogLevel.info) {
            LOGGER.info(format, arguments);
        } else if (logLevel == LogLevel.warning) {
            LOGGER.warn(format, arguments);
        } else if (logLevel == LogLevel.error) {
            LOGGER.error(format, arguments);
        } else {
            LOGGER.info(format, arguments);
        }
    }
    public static void log(Logger LOGGER, LogLevel logLevel, String msg) {
        if (logLevel == LogLevel.debug) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(msg);
            }
        } else if (logLevel == LogLevel.info) {
            LOGGER.info(msg);
        } else if (logLevel == LogLevel.warning) {
            LOGGER.warn(msg);
        } else if (logLevel == LogLevel.error) {
            LOGGER.error(msg);
        } else {
            LOGGER.info(msg);
        }
    }
}
