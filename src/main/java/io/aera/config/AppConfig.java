package io.aera.config;

import io.aera.model.Cat;
import io.aera.model.Cow;
import io.aera.model.Message;
import io.aera.model.impl.CatImpl;
import io.aera.model.impl.CowImpl;
import io.aera.model.impl.DogImpl;
import io.aera.model.impl.MessageImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

@Bean
Cat makeCat(){
    return new CatImpl("Marsik");
}

    @Bean
    public Cow cow(){
        return new CowImpl("Zorka");
    };

}
