package ru.bityard.dto.mapper;

import org.mapstruct.Mapper;
import ru.bityard.dto.GpioPinDto;
import ru.bityard.model.GpioPin;

@Mapper(componentModel = "spring")
public interface GpioPinMapper {
    GpioPinDto convert(GpioPin gpioPin);
}
