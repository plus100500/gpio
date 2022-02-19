package ru.bityard.model;

import lombok.Data;

@Data
public class GpioObject {
    private String name;
    private Float maxTemp;
    private Float minTemp;
    private GpioItem gpio;
}
