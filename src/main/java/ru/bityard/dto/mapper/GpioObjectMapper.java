package ru.bityard.dto.mapper;

import org.mapstruct.Mapper;
import ru.bityard.dto.GpioObjectDto;
import ru.bityard.model.GpioObject;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GpioDeviceMapper.class, GpioPinMapper.class})
public interface GpioObjectMapper {

    GpioObjectDto convert(GpioObject gpioObject);

    List<GpioObjectDto> convert(List<GpioObject> gpioObjectList);
}
