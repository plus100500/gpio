package ru.bityard.gpio.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = "ru.bityard")
@SpringBootApplication
public class GpioApp {

    public static void main(String[] args) {
        SpringApplication.run(GpioApp.class, args);
    }

}
