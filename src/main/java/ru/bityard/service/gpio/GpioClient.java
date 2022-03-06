package ru.bityard.service.gpio;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.bityard.util.LogKey;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

@Slf4j
@Service
public class GpioClient {

    private GpioController gpioClient;
    private boolean isActive;

    public GpioClient() {
        try {
            this.gpioClient = GpioFactory.getInstance();
            this.isActive = true;
        } catch (Throwable e) {
            log.warn("{}, {}, {}, {}",
                    keyValue(LogKey.LOG_POINT.getName(), "GpioClient"),
                    keyValue(LogKey.EXCEPTION_CAUSE.getName(), e.getCause()),
                    keyValue(LogKey.EXCEPTION_MESSAGE.getName(), e.getMessage()),
                    keyValue(LogKey.EXCEPTION_TYPE.getName(), e.getClass()));
        }
    }
}
