package ru.bityard.gpio.app.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.bityard.gpio.api.controller.GpioObjectController;
import ru.bityard.gpio.api.dto.GpioObjectDto;
import ru.bityard.gpio.api.dto.GpioState;
import ru.bityard.gpio.app.service.GpioObjectService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gpio-objects")
public class GpioObjectControllerImpl implements GpioObjectController {

  private final GpioObjectService gpioObjectService;

  @ApiOperation(value = "Получение информации об объекте по наименованию, либо получение информации обо всех объектах")
  @ApiResponses({
      @ApiResponse(
          code = 200,
          response = GpioObjectDto[].class,
          message = "Массив Объектов"),
  })
  @GetMapping
  public List<GpioObjectDto> getByName(
      @ApiParam(value = "Наименование объекта")
      @RequestParam(value = "name", required = false) String name) {

    if (Objects.isNull(name) || name.isEmpty()) {
      return gpioObjectService.getAll();
    } else {
      return Collections.singletonList(gpioObjectService.getByName(name));
    }
  }

  @ApiOperation(value = "Добавление объекта")
  @ApiResponses({
      @ApiResponse(
          code = 200,
          response = GpioObjectDto.class,
          message = "Созданный объект"),
  })
  @PostMapping
  public GpioObjectDto create(
      @ApiParam(value = "Наименование объекта")
      @RequestBody GpioObjectDto dto) {

    return gpioObjectService.create(dto);
  }

  @ApiOperation(value = "Переключение состояния объекта")
  @ApiResponses({
      @ApiResponse(
          code = 200,
          response = GpioObjectDto.class,
          message = "Созданный объект"),
  })
  @PutMapping
  public String switcher(@ApiParam(value = "Состояние объекта")
  @RequestBody GpioState gpioState,
      @ApiParam(value = "Наименование объекта")
      @RequestBody GpioObjectDto dto) {
      return gpioObjectService.switcher(gpioState,dto);
  }
}
