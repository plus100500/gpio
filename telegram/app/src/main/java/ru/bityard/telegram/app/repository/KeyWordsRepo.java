package ru.bityard.telegram.app.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bityard.telegram.app.model.KeyWord;
import ru.bityard.telegram.app.model.KeyWordType;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class KeyWordsRepo {
    private final InMemoryDbKeyWords inMemoryDbKeyWords;

    public KeyWordType getTypeByKey(String key) {
        Optional<KeyWord> optional = inMemoryDbKeyWords.getKeyWords().stream().filter(keyWord -> key.contains(keyWord.getKey())).findFirst();
        if (optional.isPresent())
            return optional.get().getType();
        else
            return KeyWordType.UNKNOWN;
    }
}
