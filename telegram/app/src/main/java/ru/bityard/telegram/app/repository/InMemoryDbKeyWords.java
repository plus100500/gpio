package ru.bityard.telegram.app.repository;

import lombok.Data;
import ru.bityard.telegram.app.model.KeyWord;

import java.util.List;

@Data
public class InMemoryDbKeyWords {
    private List<KeyWord> keyWords;
}
