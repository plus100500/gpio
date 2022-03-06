package ru.bityard.gpio.repository;

import lombok.Data;
import ru.bityard.gpio.model.GpioObject;

import java.util.List;

@Data
public class InMemoryDbGpioObject {
    private List<GpioObject> objects;
}
