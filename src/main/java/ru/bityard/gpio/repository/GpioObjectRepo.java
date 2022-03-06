package ru.bityard.gpio.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bityard.gpio.model.GpioObject;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GpioObjectRepo {
    private final InMemoryDbGpioObject repository;

    public List<GpioObject> getAll() {
        return repository.getObjects();
    }

    public GpioObject getByName(String name) {
        return repository.getObjects().stream().filter(o -> name.equals(o.getName())).findFirst().orElse(null);
    }

    public GpioObject save(GpioObject gpioObject) {
        repository.getObjects().add(gpioObject);
        return gpioObject;
    }


}
