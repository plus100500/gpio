package ru.bityard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bityard.service.telegram.TelegramBotService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/telegram")
public class TelegramController {
    private final TelegramBotService telegramBotService;

}
