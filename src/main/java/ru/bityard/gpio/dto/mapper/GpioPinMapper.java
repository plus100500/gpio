package ru.bityard.gpio.dto.mapper;

import org.mapstruct.Mapper;
import ru.bityard.gpio.dto.GpioPinDto;
import ru.bityard.gpio.model.GpioPin;

@Mapper(componentModel = "spring")
public interface GpioPinMapper {
    GpioPinDto convert(GpioPin gpioPin);
}
