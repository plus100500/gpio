package ru.bityard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GpioItem {
    @JsonProperty("id")
    private long num;
    private int type;
}
