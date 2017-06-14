package io.aera.config;

import io.aera.model.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
     public Cat cat(){
        return new Cat("Mursik");
    };
}
