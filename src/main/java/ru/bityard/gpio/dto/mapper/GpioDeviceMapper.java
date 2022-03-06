package ru.bityard.gpio.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.bityard.gpio.dto.GpioDeviceDto;
import ru.bityard.gpio.model.Dallas;
import ru.bityard.gpio.model.GpioDevice;
import ru.bityard.gpio.model.Relay;

import java.util.Objects;

@Mapper(componentModel = "spring", uses = {RelayMapper.class, DallasMapper.class})
public interface GpioDeviceMapper {
    RelayMapper relayMapper = Mappers.getMapper(RelayMapper.class);
    DallasMapper dallasMapper = Mappers.getMapper(DallasMapper.class);

    default GpioDeviceDto convert(GpioDevice gpioDevice) {
        if (Objects.isNull(gpioDevice)) return null;
        if (gpioDevice instanceof Relay) {
            return relayMapper.convert((Relay) gpioDevice);
        } else if (gpioDevice instanceof Dallas) {
            return dallasMapper.convert((Dallas) gpioDevice);
        }
        return null;
    }
}
