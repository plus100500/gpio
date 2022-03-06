package ru.bityard.telegram.repository;

import lombok.Data;
import ru.bityard.telegram.model.KeyWord;
import ru.bityard.telegram.model.KeyWordType;

import java.util.List;
import java.util.Optional;

@Data
public class InMemoryDbKeyWords {
    private List<KeyWord> keyWords;

    public KeyWordType getTypeByKey(String key) {
        Optional<KeyWord> optional = keyWords.stream().filter(keyWord -> key.contains(keyWord.getKey())).findFirst();
        if (optional.isPresent())
            return optional.get().getType();
        else
            return KeyWordType.UNKNOWN;
    }
}
