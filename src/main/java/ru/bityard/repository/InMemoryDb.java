package ru.bityard.repository;

import lombok.Data;
import ru.bityard.model.GpioObject;

import java.util.List;

@Data
public class InMemoryDb {
    private List<GpioObject> objects;
}
