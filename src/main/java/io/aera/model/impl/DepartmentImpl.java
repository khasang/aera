package io.aera.model.impl;

import io.aera.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;

public class DepartmentImpl implements Department{
    private JdbcTemplate jdbcTemplate;

    private int id;
    private String departmentName;

    public DepartmentImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DepartmentImpl() {
    }

    @Override
    public String createTable() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS department");
        jdbcTemplate.execute(
                "CREATE TABLE public.department\n" +
                "(\n" +
                "    \"DEPT_NO\" character(3)[] COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                "    \"DEPARTMENT\" character varying(25)[] COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                "    CONSTRAINT department_pkey PRIMARY KEY (\"DEPT_NO\")\n" +
                ")");
        return "Table Department is created";
    }

    @Override
    public String addDepartment(String deptNo, String name){
        jdbcTemplate.execute("INSERT INTO department (\"DEPT_NO\", \"DEPARTMENT\") VALUES" +
                "('{" + deptNo + "}', " +
                "'{" + name + "}');");

        return "Added <" + deptNo + ". " + name + ">";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
