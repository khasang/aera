package io.aera.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = {"classpath:utilTest.properties"})
public class TestConfig {
    @Autowired
    private Environment testEnvironment;

    @Bean
    DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(testEnvironment.getProperty("jdbc.postgresql.driver"));
        dataSource.setUrl(testEnvironment.getProperty("jdbc.postgresql.url"));
        dataSource.setUsername(testEnvironment.getProperty("jdbc.postgresql.username"));
        dataSource.setPassword(testEnvironment.getProperty("jdbc.postgresql.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
}
