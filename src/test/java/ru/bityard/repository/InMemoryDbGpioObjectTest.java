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

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(
        classes = InMemoryDbConfig.class)
public class InMemoryDbGpioObjectTest {

    @Autowired
    private InMemoryDbGpioObject inMemoryDbGpioObject;

    @Test
    public void test_01() {
        assertTrue(Objects.nonNull(inMemoryDbGpioObject.getObjects()));

        inMemoryDbGpioObject.getObjects().forEach(gpioObject -> {
            assertTrue(Objects.nonNull(gpioObject));
            assertFalse(gpioObject.getName().isEmpty());
            assertNotNull(gpioObject.getGpioDevice());
            switch ((int) gpioObject.getGpio().getNum()) {
                case 1: {
                    Dallas dallas = (Dallas) gpioObject.getGpioDevice();
                    assertTrue(Objects.nonNull(dallas.getSerial()));
                    assertFalse(dallas.getSerial().isEmpty());
                    assertTrue(Objects.nonNull(dallas.getMaxTemp()));
                    assertTrue(Objects.nonNull(dallas.getMinTemp()));
                    assertTrue(Objects.nonNull(gpioObject.getGpio()));
                    assertEquals(1L, gpioObject.getGpio().getNum());
                    assertEquals(1, gpioObject.getGpio().getType());
                }
                break;
                case 2: {
                    Dallas dallas = (Dallas) gpioObject.getGpioDevice();
                    assertTrue(Objects.nonNull(dallas.getSerial()));
                    assertFalse(dallas.getSerial().isEmpty());
                    assertTrue(Objects.nonNull(dallas.getMaxTemp()));
                    assertTrue(Objects.nonNull(dallas.getMinTemp()));
                    assertTrue(Objects.nonNull(gpioObject.getGpio()));
                    assertEquals(2L, gpioObject.getGpio().getNum());
                    assertEquals(1, gpioObject.getGpio().getType());
                }
                break;
                case 3: {
                    Relay relay = (Relay) gpioObject.getGpioDevice();
                    assertTrue(relay.isSwitchedOn());
                    assertTrue(relay.isInverse());
                    assertTrue(Objects.nonNull(gpioObject.getGpio()));
                    assertEquals(3L, gpioObject.getGpio().getNum());
                    assertEquals(2, gpioObject.getGpio().getType());
                }
                break;
            }
        });
    }
}