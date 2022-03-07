package ru.bityard.gpio.model;

import lombok.Data;

@Data
public class GpioObject {
    private Long id;
    private String name;
    private String description;
    private GpioDevice gpioDevice;
    private GpioPin gpio;
}
