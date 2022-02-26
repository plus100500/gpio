package ru.bityard.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.bityard.dto.GpioObjectDto;
import ru.bityard.service.GpioObjectService;

import java.util.Arrays;
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
}
