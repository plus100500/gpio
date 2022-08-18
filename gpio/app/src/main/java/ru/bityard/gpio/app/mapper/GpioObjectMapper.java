package ru.bityard.gpio.app.mapper;

import org.mapstruct.Mapper;
import ru.bityard.gpio.api.dto.GpioObjectDto;
import ru.bityard.gpio.app.model.GpioObject;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GpioDeviceMapper.class, GpioPinMapper.class})
public interface GpioObjectMapper {

    GpioObjectDto convert(GpioObject gpioObject);

    GpioObject convert(GpioObjectDto dto);

    List<GpioObjectDto> convert(List<GpioObject> gpioObjectList);
}
