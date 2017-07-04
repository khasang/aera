package io.aera.config;

import io.aera.dao.PersonageDao;
import io.aera.dao.StoryDao;
import io.aera.dao.impl.PersonageDaoImpl;
import io.aera.dao.impl.StoryDaoImpl;
import io.aera.entity.Personage;
import io.aera.entity.Story;
import io.aera.model.Cat;
import io.aera.model.Dog;
import io.aera.model.impl.CatImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

@Configuration
@PropertySource(value = {"classpath:util.properties"})
@PropertySource(value = {"classpath:auth.properties"})
public class AppConfig {
    @Autowired
    private Environment environment;

    @Bean
    public UserDetailsService userDetailsService(){
        JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
        jdbcImpl.setDataSource(dataSource());
        jdbcImpl.setUsersByUsernameQuery(environment.getRequiredProperty("usersByQuery"));
        jdbcImpl.setAuthoritiesByUsernameQuery(environment.getRequiredProperty("rolesByQuery"));
        return jdbcImpl;
    }

    @Bean
    public Cat cat(){
        return new CatImpl("Riska");
    }

    @Bean
    StoryDao storyDao(){
        return new StoryDaoImpl(Story.class);
    }

    @Bean
    PersonageDao personageDao() {
        return new PersonageDaoImpl(Personage.class);
    }

    @Bean
    DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.postgresql.driver"));
        dataSource.setUrl(environment.getProperty("jdbc.postgresql.url"));
        dataSource.setUsername(environment.getProperty("jdbc.postgresql.name"));
        dataSource.setPassword(environment.getProperty("jdbc.postgresql.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    Dog dog(){
        return new Dog(jdbcTemplate());
    }
}
