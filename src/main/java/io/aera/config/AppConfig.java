package io.aera.config;

import io.aera.model.Cat;
import io.aera.model.impl.CatImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean
    @Scope("singleton")
    public Cat cat() {
        return new CatImpl("Riska");
    }
}
