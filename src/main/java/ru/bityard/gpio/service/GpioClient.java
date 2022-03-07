package ru.bityard.gpio.service;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.bityard.util.AppLog;
import ru.bityard.util.LogLevel;

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
            AppLog.exception(LogLevel.WARN, "GpioClient", e);
        }
    }

    public void switchOn() {
        if (isActive) {
            //TODO вот тут нужно разобраться как пользоваться gpio-библиотекой
        } else {
            log.warn("{}");
        }
    }
}
