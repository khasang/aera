package io.aera.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class Dog {
    private JdbcTemplate jdbcTemplate;

    public Dog() {
    }

    public Dog(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createDogTable(){
        jdbcTemplate.execute("DROP TABLE IF EXISTS dogs");
        jdbcTemplate.execute("CREATE TABLE dogs(\n" +
                "id INTEGER CONSTRAINT firstkey PRIMARY KEY, \n" +
                "name VARCHAR (255) NOT NULL );");
        return "table created";
    }

}
