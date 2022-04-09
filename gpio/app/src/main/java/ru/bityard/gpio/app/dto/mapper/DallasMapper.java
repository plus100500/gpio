package ru.bityard.gpio.app.dto.mapper;

import org.mapstruct.Mapper;
import ru.bityard.gpio.app.dto.DallasDto;
import ru.bityard.gpio.app.model.Dallas;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DallasMapper {
    DallasDto convert(Dallas dallas);
    Dallas convert(DallasDto dto);
    List<DallasDto> convert(List<Dallas> dallasList);
}
