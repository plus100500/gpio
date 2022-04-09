package ru.bityard.telegram.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.bityard.util.AppLog;
import ru.bityard.util.LogKey;
import ru.bityard.util.LogLevel;

import javax.annotation.PostConstruct;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramBotService {

    private final TelegramBot telegramBot;
    private TelegramBotsApi telegramBotsApi;

    @PostConstruct
    public void init() {
        try {
            this.telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            this.telegramBotsApi.registerBot(telegramBot);
        } catch (TelegramApiException e) {
            AppLog.exception(LogLevel.WARN, "init", e);
        }
    }

    public void send(String text) {
        log.debug("{}, {}",
                keyValue(LogKey.LOG_POINT.getName(), "send"),
                keyValue(LogKey.TELEGRAM_MESSAGE.getName(), text));
    }
}
