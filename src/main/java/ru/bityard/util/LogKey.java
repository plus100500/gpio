package ru.bityard.util;

public enum LogKey {

    EXCEPTION_MESSAGE("exceptionMessage"),
    EXCEPTION_CAUSE("exceptionCause"),
    EXCEPTION_TYPE("exceptionType"),
    LOG_POINT("logPoint");

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
