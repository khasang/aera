package io.aera.model;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by admin on 19.06.2017.
 */
public class Worker {
    private JdbcTemplate jdbcTemplate;

    public Worker() {
    }

    public Worker(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public String createDogTable() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS workers");
        jdbcTemplate.execute("CREATE  table workers (" + " id INTEGER CONSTRAINT firstkey PRIMARY KEY not null,"+" name VARCHAR (255));");
        return "table Created";
    }
}
