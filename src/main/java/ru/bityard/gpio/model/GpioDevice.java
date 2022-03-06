package ru.bityard.gpio.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dallas.class, name = "dallas"),
        @JsonSubTypes.Type(value = Relay.class, name = "relay")
})
public abstract class GpioDevice {
    private String type;
}
