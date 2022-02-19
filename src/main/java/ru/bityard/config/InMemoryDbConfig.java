package ru.bityard.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import ru.bityard.repository.InMemoryDb;

import java.io.IOException;

@Configuration
public class InMemoryDbConfig {

    @Bean
    public InMemoryDb getInMemoryDb() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(new ClassPathResource("./gpioItems.json").getFile(), InMemoryDb.class);
    }
}
