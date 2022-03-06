package ru.bityard.gpio.model;

import lombok.Data;

@Data
public class GpioObject {
    private String name;
    private GpioDevice gpioDevice;
    private GpioPin gpio;
}
