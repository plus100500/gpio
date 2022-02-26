package ru.bityard.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.bityard.dto.GpioDeviceDto;
import ru.bityard.model.Dallas;
import ru.bityard.model.GpioDevice;
import ru.bityard.model.Relay;

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
