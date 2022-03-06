package ru.bityard.service.gpio;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bityard.dto.GpioObjectDto;
import ru.bityard.dto.mapper.GpioObjectMapper;
import ru.bityard.repository.GpioObjectRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GpioObjectService {
    private final GpioObjectRepo gpioObjectRepo;
    private final GpioObjectMapper gpioObjectMapper;

    public List<GpioObjectDto> getAll() {
        return gpioObjectMapper.convert(gpioObjectRepo.getAll());
    }

    public GpioObjectDto getByName(String name) {
        return gpioObjectMapper.convert(gpioObjectRepo.getByName(name));
    }
}
