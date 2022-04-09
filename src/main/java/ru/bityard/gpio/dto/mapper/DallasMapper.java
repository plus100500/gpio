package ru.bityard.gpio.dto.mapper;

import org.mapstruct.Mapper;
import ru.bityard.gpio.dto.DallasDto;
import ru.bityard.gpio.model.Dallas;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DallasMapper {
    DallasDto convert(Dallas dallas);
    Dallas convert(DallasDto dto);
    List<DallasDto> convert(List<Dallas> dallasList);
}
