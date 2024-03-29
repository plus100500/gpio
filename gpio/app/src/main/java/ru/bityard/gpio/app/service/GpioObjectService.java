package ru.bityard.gpio.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bityard.gpio.api.dto.GpioObjectDto;
import ru.bityard.gpio.app.mapper.GpioObjectMapper;
import ru.bityard.gpio.app.model.GpioObject;
import ru.bityard.gpio.api.dto.GpioState;
import ru.bityard.gpio.app.model.Relay;
import ru.bityard.gpio.app.repository.GpioObjectRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GpioObjectService {
    private final GpioObjectRepo gpioObjectRepo;
    private final GpioObjectMapper gpioObjectMapper;
    private final GpioClient gpioClient;

    public List<GpioObjectDto> getAll() {
        return gpioObjectMapper.convert(gpioObjectRepo.getAll());
    }

    public GpioObjectDto getByName(String name) {
        return gpioObjectMapper.convert(gpioObjectRepo.getByName(name));
    }

    /**
     *
     * @param gpioState -
     * @param dto -
     * @return - если ответ != null, значит нужно вернуть его инициатору процесса
     */
    public String switcher(GpioState gpioState, GpioObjectDto dto) {
        String response = null;
        GpioObject gpioObject = gpioObjectMapper.convert(dto);
        switch (gpioState) {
            case ON: {
                //TODO послать команду в gpio
                gpioClient.switchOn();
                //TODO сохранить состояние в gpioObject
                ((Relay) gpioObject.getGpioDevice()).setSwitchedOn(true);
                //TODO сформировать сообщение в ответ
                response = gpioObject.getName() + " включен";
            } break;
            case OFF: {

            } break;
            case UNKNOWN: {

            }
        }
        return response;
    }

    public GpioObjectDto create(GpioObjectDto dto) {
        return gpioObjectMapper.convert(gpioObjectRepo.save(gpioObjectMapper.convert(dto)));
    }
}
