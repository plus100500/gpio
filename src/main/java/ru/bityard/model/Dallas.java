package ru.bityard.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Dallas extends GpioDevice {
    @ApiModelProperty(value = "серийный номер датчика")
    private String serial;
    private Float maxTemp;
    private Float minTemp;
}
