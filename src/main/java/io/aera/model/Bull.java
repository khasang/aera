package io.aera.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class Bull {
    JdbcTemplate jdbcTemplate;

    public Bull() {
    }

    public Bull(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createBullTable() {
        jdbcTemplate.execute("DROP TABLE if EXISTS bulls");
        jdbcTemplate.execute("CREATE TABLE bulls(\n" +
                "id INTEGER CONSTRAINT firstkey PRIMARY KEY, \n" +
                "name VARCHAR (255) NOT NULL );");
        return "table created";
    }

}//class
