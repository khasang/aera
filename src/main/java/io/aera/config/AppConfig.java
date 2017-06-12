package io.aera.config;

import io.aera.model.Cat;
import io.aera.model.CatImple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;

@Configuration
public class AppConfig {
    @Bean
    public Cat cat() {
        return new CatImple("Barsik");
    }
}
