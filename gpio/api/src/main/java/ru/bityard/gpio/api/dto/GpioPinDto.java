package ru.bityard.gpio.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Устройство, подключенное к GPIO")
public class GpioPinDto {
    @ApiModelProperty("Номер контакта, к которому подключено устройство")
    private long num;

    @ApiModelProperty("Тип устройства")
    private int type;
}
