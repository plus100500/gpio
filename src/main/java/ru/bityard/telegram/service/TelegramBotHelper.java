package ru.bityard.telegram.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.bityard.telegram.model.KeyWordType;
import ru.bityard.telegram.repository.InMemoryDbKeyWords;
import ru.bityard.telegram.repository.KeyWordsRepo;
import ru.bityard.util.LogKey;

import java.util.concurrent.CompletableFuture;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramBotHelper {
    private final KeyWordsRepo keyWordsRepo;

    @Async
    public CompletableFuture<String> parse(long chatId, String message) {
        KeyWordType type = keyWordsRepo.getTypeByKey(message);
        log.debug("{}, {}, {}, {}",
                keyValue(LogKey.LOG_POINT.getName(), "parse"),
                keyValue(LogKey.TELEGRAM_KEY_TYPE.getName(), type),
                keyValue(LogKey.TELEGRAM_MESSAGE.getName(), message),
                keyValue(LogKey.TELEGRAM_CHAT_ID.getName(), chatId));
        //TODO
//        String messageSend = "";
//        if (message.toLowerCase().equals("стат")) messageSend = telegramView.getDevices();
//        if (message.contains("включить") || message.contains("выключить"))
//            try {
//                messageSend = telegramView.set(message);
//            } catch (MyExceptions me) {
//                log.warn(me.toString());
//                messageSend = me.toString();
//            }
//        if (messageSend.equals("")) messageSend = message;
//        SendMessage message = new SendMessage().setChatId(chatId).setText(messageSend);
//
//        try {
//            execute(message);
//        } catch (TelegramApiException e) {
//            System.out.println("Telegram " + e);
//        }
        return CompletableFuture.completedFuture(type.name());
    }
}
