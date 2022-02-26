package ru.bityard.dto.mapper;

import org.mapstruct.Mapper;
import ru.bityard.dto.DallasDto;
import ru.bityard.model.Dallas;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DallasMapper {
    DallasDto convert(Dallas dallas);
    List<DallasDto> convert(List<Dallas> dallasList);
}
