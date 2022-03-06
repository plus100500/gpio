package ru.bityard.gpio.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = DallasDto.class, name = "dallas"),
        @JsonSubTypes.Type(value = RelayDto.class, name = "relay")
})
public abstract class GpioDeviceDto {
    private String type;
}
