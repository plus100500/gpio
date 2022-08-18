package ru.bityard.telegram.app.service;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import ru.bityard.gpio.api.controller.GpioObjectController;
import ru.bityard.gpio.api.dto.GpioState;
import ru.bityard.gpio.lib.util.LogKey;
import ru.bityard.telegram.app.model.KeyWordType;
import ru.bityard.telegram.app.repository.KeyWordsRepo;

@Slf4j
@EnableAsync
@Service
@RequiredArgsConstructor
public class TelegramBotListener {

  private final KeyWordsRepo keyWordsRepo;
  private final GpioObjectController gpioObjectController;

  @Async
  public CompletableFuture<String> parseReceived(long chatId, String message) {
    KeyWordType type = keyWordsRepo.getTypeByKey(message);
    GpioState gpioState = convert(type);
    gpioObjectController.getByName(message)
        .forEach(gpioObject -> {
          String response = gpioObjectController.switcher(gpioState, gpioObject);
          if (Objects.nonNull(response)) {
            //TODO нужно что то делать с полученным сообщением
          }
        });

    log.debug("{}, {}, {}, {}",
        keyValue(LogKey.LOG_POINT.getName(), "parseReceived"),
        keyValue(LogKey.TELEGRAM_KEY_TYPE.getName(), type),
        keyValue(LogKey.TELEGRAM_MESSAGE.getName(), message),
        keyValue(LogKey.TELEGRAM_CHAT_ID.getName(), chatId));
    return CompletableFuture.completedFuture(type.name());
  }

  private static GpioState convert(@NonNull KeyWordType type) {
    switch (type) {
      case ON: return GpioState.ON;
      case OFF: return GpioState.OFF;
      default: return GpioState.UNKNOWN;
    }
  }
}
