package ru.bityard.repository;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.bityard.config.InMemoryDbConfig;
import ru.bityard.model.GpioObject;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(
        classes = InMemoryDbConfig.class)
public class InMemoryDbTest {

    @Autowired
    private InMemoryDb inMemoryDb;

    @Test
    public void test_01() {
        assertTrue(Objects.nonNull(inMemoryDb.getObjects()));
        GpioObject gpioObject = inMemoryDb.getObjects().get(0);
        assertTrue(Objects.nonNull(gpioObject));
        assertFalse(gpioObject.getName().isEmpty());
        assertTrue(Objects.nonNull(gpioObject.getMaxTemp()));
        assertTrue(Objects.nonNull(gpioObject.getMinTemp()));
        assertTrue(Objects.nonNull(gpioObject.getGpio()));
        assertNotEquals(0L,gpioObject.getGpio().getNum());
        assertNotEquals(0,gpioObject.getGpio().getType());
    }
}