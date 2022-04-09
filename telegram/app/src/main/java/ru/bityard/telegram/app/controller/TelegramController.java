package ru.bityard.telegram.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bityard.telegram.app.service.TelegramBotService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/telegram")
public class TelegramController {
    private final TelegramBotService telegramBotService;

}
