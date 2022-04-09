package ru.bityard.gpio.app.dto.mapper;

import org.mapstruct.Mapper;
import ru.bityard.gpio.app.dto.RelayDto;
import ru.bityard.gpio.app.model.Relay;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RelayMapper {
    RelayDto convert(Relay realy);
    Relay convert(RelayDto dto);

    List<RelayDto> convert(List<Relay> relayList);
}
