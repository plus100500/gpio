package ru.bityard.telegram.app.service;

import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramUtil {

    public static String getMessage(Update update) {
        return normalize(update.getMessage().getText());
    }

    public static String normalize(String text) {
        return text.toLowerCase();
    }
}
