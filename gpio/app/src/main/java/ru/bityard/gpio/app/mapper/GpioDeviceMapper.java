package ru.bityard.gpio.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.bityard.gpio.api.dto.DallasDto;
import ru.bityard.gpio.api.dto.GpioDeviceDto;
import ru.bityard.gpio.api.dto.RelayDto;
import ru.bityard.gpio.app.model.Dallas;
import ru.bityard.gpio.app.model.GpioDevice;
import ru.bityard.gpio.app.model.Relay;

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

    default GpioDevice convert(GpioDeviceDto dto) {
        if (Objects.isNull(dto)) return null;
        if (dto instanceof RelayDto) {
            return relayMapper.convert((RelayDto) dto);
        } else if (dto instanceof DallasDto) {
            return dallasMapper.convert((DallasDto) dto);
        }
        return null;
    }
}
