package ru.bityard.gpio.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GpioPin {
    @JsonProperty("id")
    private long num;
    private int type;
}
