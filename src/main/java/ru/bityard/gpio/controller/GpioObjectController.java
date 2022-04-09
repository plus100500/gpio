package ru.bityard.gpio.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.bityard.gpio.dto.GpioObjectDto;
import ru.bityard.gpio.service.GpioObjectService;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gpio-objects")
public class GpioObjectController {
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
}
