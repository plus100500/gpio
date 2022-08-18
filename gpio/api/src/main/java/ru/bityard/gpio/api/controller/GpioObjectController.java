package ru.bityard.gpio.api.controller;

import java.util.List;
import ru.bityard.gpio.api.dto.GpioObjectDto;
import ru.bityard.gpio.api.dto.GpioState;

public interface GpioObjectController {

  List<GpioObjectDto> getByName(String name);

  GpioObjectDto create(GpioObjectDto dto);

  String switcher(GpioState gpioState, GpioObjectDto gpioObjectDto);
}
