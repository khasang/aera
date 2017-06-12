package io.aera.config;

import io.aera.model.Dog;
import io.aera.model.impl.DogImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Dog dog() {
        return new DogImpl("Buster");
    }
}
