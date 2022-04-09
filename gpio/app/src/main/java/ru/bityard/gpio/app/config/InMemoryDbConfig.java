package ru.bityard.gpio.app.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import ru.bityard.gpio.app.repository.InMemoryDbGpioObject;

import java.io.IOException;

@Configuration
public class InMemoryDbConfig {

    @Bean
    public InMemoryDbGpioObject getInMemoryDbGpioObject() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(new ClassPathResource("gpioItems.json").getFile(), InMemoryDbGpioObject.class);
    }
}
