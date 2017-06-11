package io.aera.config;

import io.aera.model.Cat;
import io.aera.model.impl.CatImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Cat cat(){
        return new CatImpl("Riska");
    }
}
