package io.myaera.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Dog {
    private JdbcTemplate jdbcTemplate;

    public Dog() {}

    @Autowired
    public Dog(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createTable() {
        jdbcTemplate.execute("");
        return "Dog table created";
    }
}
