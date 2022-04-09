package ru.bityard.telegram.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.bityard.gpio.lib.util.AppLog;
import ru.bityard.gpio.lib.util.LogKey;
import ru.bityard.gpio.lib.util.LogLevel;

import javax.annotation.PostConstruct;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

@Slf4j
@Component
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${telegram.bot.name}")
    private String name;

    @Value("${telegram.bot.token}")
    private String token;

    private final TelegramBotListener telegramBotListener;

    @Override
    public void onUpdateReceived(Update update) {
        try {
            String message = TelegramUtil.getMessage(update);
            long chatId = update.getMessage().getChatId();
            log.debug("{}, {}, {}",
                    keyValue(LogKey.LOG_POINT.getName(), "onUpdateReceived"),
                    keyValue(LogKey.TELEGRAM_MESSAGE.getName(), message),
                    keyValue(LogKey.TELEGRAM_CHAT_ID.getName(), chatId));

            telegramBotListener.parseReceived(chatId, message);

        } catch (Exception e) {
            AppLog.exception(LogLevel.WARN,"onUpdateReceived",e);
        }
    }

    @PostConstruct
    public void init() {
        log.info("{}, {}, {}", keyValue(LogKey.LOG_POINT.getName(), "init"),
                keyValue("telegram.name", this.getBotUsername()),
                keyValue("telegram.token", this.getBotToken()));
    }

    @Override
    public String getBotUsername() {
        return this.name;
    }

    @Override
    public String getBotToken() {
        return this.token;
    }
}
