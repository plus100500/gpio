package ru.bityard.gpio.app.repository;

import lombok.Data;
import ru.bityard.gpio.app.model.GpioObject;

import java.util.List;

@Data
public class InMemoryDbGpioObject {
    private List<GpioObject> objects;
}
