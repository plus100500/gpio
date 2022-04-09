package ru.bityard.telegram.app.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import ru.bityard.telegram.app.repository.InMemoryDbKeyWords;

import java.io.IOException;

@Configuration
public class InMemoryTgDbConfig {

    @Bean
    public InMemoryDbKeyWords getInMemoryDbKeyWords() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(new ClassPathResource("keyWords.json").getFile(), InMemoryDbKeyWords.class);
    }
}
