package io.aera.config;

import io.aera.model.Bull;
import io.aera.model.Cat;
import io.aera.model.Cow;
import io.aera.model.impl.CatImpl;
import io.aera.model.impl.CowImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = {"classpath:util.properties"})
public class AppConfig {
    @Autowired
    private Environment environment;

    @Bean
    Cat makeCat() {
        return new CatImpl("Marsik");
    }

    @Bean
    public Cow cow() {
        return new CowImpl("Zorka");
    }

    @Bean
    DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.postgresql.driver"));
        dataSource.setUrl(environment.getProperty("jdbc.postgresql.url"));
        dataSource.setUsername(environment.getProperty("jdbc.postgresql.name"));
        dataSource.setPassword(environment.getProperty("jdbc.postgresql.password"));
        return dataSource;
    }


    @Bean
    JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate =  new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
    @Bean
    Bull makeBull(){
        return new Bull(jdbcTemplate());
    }


}//class
