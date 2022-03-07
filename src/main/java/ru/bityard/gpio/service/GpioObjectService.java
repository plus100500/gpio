package ru.bityard.gpio.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bityard.gpio.dto.GpioObjectDto;
import ru.bityard.gpio.dto.mapper.GpioObjectMapper;
import ru.bityard.gpio.model.GpioObject;
import ru.bityard.gpio.model.Relay;
import ru.bityard.gpio.repository.GpioObjectRepo;
import ru.bityard.telegram.model.KeyWordType;

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
     * @param keyWordType -
     * @param gpioObject -
     * @return - если ответ != null, значит нужно вернуть его инициатору процесса
     */
    public String switcher(KeyWordType keyWordType, GpioObject gpioObject) {
        String response = null;
        switch (keyWordType) {
            case ON: {
                //TODO послать команду в gpio
                gpioClient.switchOn();
                //TODO сохранить состояние в gpioObject
                ((Relay) gpioObject.getGpioDevice()).setSwitchedOn(true);
                //TODO сформировать сообщение в ответ
                response = gpioObject.getName() + "включен";
            } break;
            case OFF: {

            } break;
            case STAT: {

            }break;
            case UNKNOWN: {

            }
        }
        return response;
    }
}
