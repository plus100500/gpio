package ru.bityard.telegram.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.bityard.gpio.model.GpioObject;
import ru.bityard.gpio.repository.GpioObjectRepo;
import ru.bityard.gpio.service.GpioObjectService;
import ru.bityard.gpio.util.GpioObjectUtil;
import ru.bityard.telegram.model.KeyWordType;
import ru.bityard.telegram.repository.KeyWordsRepo;
import ru.bityard.util.AppLog;
import ru.bityard.util.LogKey;
import ru.bityard.util.LogLevel;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramBotHelper {
    private final KeyWordsRepo keyWordsRepo;
    private final GpioObjectRepo gpioObjectRepo;
    private final TelegramBot telegramBot;
    private final GpioObjectService gpioObjectService;

    @Async
    public CompletableFuture<String> parse(long chatId, String message) {
        KeyWordType type = keyWordsRepo.getTypeByKey(message);
        GpioObject gpioObject = gpioObjectRepo.getByName(message);
        String response = gpioObjectService.switcher(type,gpioObject);
        if (Objects.nonNull(response)) {
            this.send(chatId, response);
        }

        log.debug("{}, {}, {}, {}",
                keyValue(LogKey.LOG_POINT.getName(), "parse"),
                keyValue(LogKey.TELEGRAM_KEY_TYPE.getName(), type),
                keyValue(LogKey.TELEGRAM_MESSAGE.getName(), message),
                keyValue(LogKey.TELEGRAM_CHAT_ID.getName(), chatId));
        return CompletableFuture.completedFuture(type.name());
    }

    @Async
    public void send(long chatId, String text) {
        SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
        message.setChatId(String.valueOf(chatId));
        message.setText(text);
        try {
            telegramBot.execute(message); // Call method to send the message
        } catch (TelegramApiException e) {
            AppLog.exception(LogLevel.WARN, "send", e);
        }
    }
}
