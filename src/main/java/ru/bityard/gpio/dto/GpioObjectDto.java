package ru.bityard.gpio.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("Объект, подключенный к GPIO")
public class GpioObjectDto {
    private String name;
    private GpioDeviceDto gpioDevice;
    private GpioPinDto gpio;
}
