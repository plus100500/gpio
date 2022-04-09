package ru.bityard.telegram.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import ru.bityard.gpio.model.GpioObject;
import ru.bityard.gpio.repository.GpioObjectRepo;
import ru.bityard.gpio.service.GpioObjectService;
import ru.bityard.telegram.model.KeyWordType;
import ru.bityard.telegram.repository.KeyWordsRepo;
import ru.bityard.util.LogKey;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

@Slf4j
@EnableAsync
@Service
@RequiredArgsConstructor
public class TelegramBotListener {
    private final KeyWordsRepo keyWordsRepo;
    private final GpioObjectRepo gpioObjectRepo;
    private final GpioObjectService gpioObjectService;

    @Async
    public CompletableFuture<String> parseReceived(long chatId, String message) {
        KeyWordType type = keyWordsRepo.getTypeByKey(message);
        GpioObject gpioObject = gpioObjectRepo.getByName(message);
        String response = gpioObjectService.switcher(type, gpioObject);
        if (Objects.nonNull(response)) {
            //TODO нужно что то делать с полученным сообщением
        }

        log.debug("{}, {}, {}, {}",
                keyValue(LogKey.LOG_POINT.getName(), "parseReceived"),
                keyValue(LogKey.TELEGRAM_KEY_TYPE.getName(), type),
                keyValue(LogKey.TELEGRAM_MESSAGE.getName(), message),
                keyValue(LogKey.TELEGRAM_CHAT_ID.getName(), chatId));
        return CompletableFuture.completedFuture(type.name());
    }
}
