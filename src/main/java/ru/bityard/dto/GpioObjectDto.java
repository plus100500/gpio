package ru.bityard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Объект, подключенный к GPIO")
public class GpioObjectDto {
    @ApiModelProperty(value = "Произвольное наименование объекта", required = true)
    private String name;

    @ApiModelProperty(value = "Произвольное наименование объекта", required = true)
    private Float maxTemp;

    @ApiModelProperty(value = "Произвольное наименование объекта", required = true)
    private Float minTemp;

    private GpioItemDto gpio;
}
