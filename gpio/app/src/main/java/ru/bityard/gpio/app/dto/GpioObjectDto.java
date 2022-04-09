package ru.bityard.gpio.app.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("Объект, подключенный к GPIO")
public class GpioObjectDto {
    private Long id;
    private String name;
    private String description;
    private GpioDeviceDto gpioDevice;
    private GpioPinDto gpio;
}
