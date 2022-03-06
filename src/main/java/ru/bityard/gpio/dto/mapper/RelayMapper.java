package ru.bityard.gpio.dto.mapper;

import org.mapstruct.Mapper;
import ru.bityard.gpio.dto.RelayDto;
import ru.bityard.gpio.model.Relay;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RelayMapper {
    RelayDto convert(Relay realy);
    List<RelayDto> convert(List<Relay> relayList);
}
