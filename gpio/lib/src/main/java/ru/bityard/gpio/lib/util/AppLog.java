package ru.bityard.gpio.lib.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

@Slf4j
public class AppLog {
    public static void exception(@NonNull LogLevel logLevel, String methodName, Throwable e) {
        switch (logLevel) {
            case INFO: {
                log.info("{}, {}, {}, {}",
                        keyValue(LogKey.LOG_POINT.getName(), methodName),
                        keyValue(LogKey.EXCEPTION_CAUSE.getName(), e.getCause()),
                        keyValue(LogKey.EXCEPTION_MESSAGE.getName(), e.getMessage()),
                        keyValue(LogKey.EXCEPTION_TYPE.getName(), e.getClass()));
            }
            break;
            case DEBUG: {
                log.debug("{}, {}, {}, {}",
                        keyValue(LogKey.LOG_POINT.getName(), methodName),
                        keyValue(LogKey.EXCEPTION_CAUSE.getName(), e.getCause()),
                        keyValue(LogKey.EXCEPTION_MESSAGE.getName(), e.getMessage()),
                        keyValue(LogKey.EXCEPTION_TYPE.getName(), e.getClass()));
            }
            break;
            case WARN: {
                log.warn("{}, {}, {}, {}",
                        keyValue(LogKey.LOG_POINT.getName(), methodName),
                        keyValue(LogKey.EXCEPTION_CAUSE.getName(), e.getCause()),
                        keyValue(LogKey.EXCEPTION_MESSAGE.getName(), e.getMessage()),
                        keyValue(LogKey.EXCEPTION_TYPE.getName(), e.getClass()));
            }
            break;
            case ERROR: {
                log.error("{}, {}, {}, {}",
                        keyValue(LogKey.LOG_POINT.getName(), methodName),
                        keyValue(LogKey.EXCEPTION_CAUSE.getName(), e.getCause()),
                        keyValue(LogKey.EXCEPTION_MESSAGE.getName(), e.getMessage()),
                        keyValue(LogKey.EXCEPTION_TYPE.getName(), e.getClass()));
            }
            break;
        }
    }
}
