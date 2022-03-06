package ru.bityard.service.telegram;

import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.argument.StructuredArguments;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.bityard.util.LogKey;

import javax.annotation.PostConstruct;

import static net.logstash.logback.argument.StructuredArguments.*;

@Slf4j
@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${telegram.bot.name}")
    private String name;

    @Value("${telegram.bot.token}")
    private String token;

    @Override
    public void onUpdateReceived(Update update) {
        log.info("{}", keyValue(LogKey.LOG_POINT.getName(), "onUpdateReceived"));
        // TODO
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
