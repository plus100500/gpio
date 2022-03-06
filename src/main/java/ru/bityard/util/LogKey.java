package ru.bityard.util;

public enum LogKey {

    EXCEPTION_MESSAGE("exceptionMessage"),
    EXCEPTION_CAUSE("exceptionCause"),
    EXCEPTION_TYPE("exceptionType"),
    LOG_POINT("logPoint"),
    TELEGRAM_MESSAGE("telegramMessage"),
    TELEGRAM_CHAT_ID("telegramChatId"),
    TELEGRAM_KEY_TYPE("telegramKeyType");

    private final String name;

    LogKey(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }
}
