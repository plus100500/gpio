package ru.bityard.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.bityard.config.InMemoryDbConfig;
import ru.bityard.gpio.model.Dallas;
import ru.bityard.gpio.model.Relay;
import ru.bityard.gpio.repository.InMemoryDbGpioObject;
import ru.bityard.telegram.model.KeyWordType;
import ru.bityard.telegram.repository.InMemoryDbKeyWords;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(
        classes = InMemoryDbConfig.class)
public class InMemoryDbKeyWordsTest {

    @Autowired
    private InMemoryDbKeyWords inMemoryDbKeyWords;

    @Test
    public void test_01() {
        assertTrue(Objects.nonNull(inMemoryDbKeyWords.getKeyWords()));

        inMemoryDbKeyWords.getKeyWords().forEach(keyWord -> {
            assertTrue(Objects.nonNull(keyWord));
            assertFalse(keyWord.getKey().isEmpty());
            assertNotNull(keyWord.getType());
        });
    }

    @Test
    public void test_02() {
        assertEquals(KeyWordType.ON, inMemoryDbKeyWords.getTypeByKey("Нужно включить датчик"));
        assertEquals(KeyWordType.OFF, inMemoryDbKeyWords.getTypeByKey("Нужно выкл датчик"));
        assertEquals(KeyWordType.STAT, inMemoryDbKeyWords.getTypeByKey("Нужно показать статистику"));
        assertEquals(KeyWordType.UNKNOWN, inMemoryDbKeyWords.getTypeByKey("Нужно что-то сделать"));


    }
}