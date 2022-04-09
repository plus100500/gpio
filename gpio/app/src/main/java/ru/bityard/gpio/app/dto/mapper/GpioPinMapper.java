package ru.bityard.gpio.app.dto.mapper;

import org.mapstruct.Mapper;
import ru.bityard.gpio.app.dto.GpioPinDto;
import ru.bityard.gpio.app.model.GpioPin;

@Mapper(componentModel = "spring")
public interface GpioPinMapper {
    GpioPinDto convert(GpioPin gpioPin);
}
