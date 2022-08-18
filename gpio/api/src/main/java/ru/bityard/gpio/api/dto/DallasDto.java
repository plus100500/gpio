package ru.bityard.gpio.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DallasDto extends GpioDeviceDto {
    @ApiModelProperty(value = "серийный номер датчика")
    private String serial;
    private Float maxTemp;
    private Float minTemp;
}
