package ru.bityard.exception;

import io.swagger.annotations.Api;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Api("Кастомизированная ошибка")
@Getter
@Setter
@Builder
public class AppException extends RuntimeException {

    public AppException() {
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(Throwable cause) {
        super(cause);
    }

    public AppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
