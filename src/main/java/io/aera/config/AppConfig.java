package io.aera.config;

import io.aera.model.Cat;
import io.aera.model.Dog;
import io.aera.model.impl.CatImpl;
import io.aera.model.impl.DogImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Cat cat(){
        return new CatImpl("New cat");
    }

    @Bean
    public Dog dog(){
        return new DogImpl("New dog");
    }
}
