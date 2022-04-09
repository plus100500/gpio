package ru.bityard.telegram.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.bityard.util.AppLog;
import ru.bityard.util.LogLevel;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramBotHelper {
    private final TelegramBot telegramBot;

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
