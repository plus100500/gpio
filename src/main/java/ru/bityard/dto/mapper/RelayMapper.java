package ru.bityard.dto.mapper;

import org.mapstruct.Mapper;
import ru.bityard.dto.RelayDto;
import ru.bityard.model.Relay;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RelayMapper {
    RelayDto convert(Relay realy);
    List<RelayDto> convert(List<Relay> relayList);
}
