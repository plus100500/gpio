package ru.bityard.gpio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Relay extends GpioDevice {
    @JsonProperty(value = "isSwitchedOn")
    private boolean isSwitchedOn;
    @ApiModelProperty(value = "Метка, каким образом подключено реле")
    @JsonProperty(value = "isInverse")
    private boolean isInverse;
}
