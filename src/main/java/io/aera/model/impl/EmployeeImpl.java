package io.aera.model.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

public class EmployeeImpl implements io.aera.model.Employee {
    private JdbcTemplate jdbcTemplate;
    private String empNo;
    private String firstName;
    private String lastName;
    private Date hireDate;
    private String deptNo;
    private Double salary;


    public EmployeeImpl() { }

    public EmployeeImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String createTable() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS employee");
        jdbcTemplate.execute(
                "CREATE TABLE public.employee\n" +
                        "(\n" +
                        "    \"EMP_NO\" integer NOT NULL,\n" +
                        "    \"FIRST_NAME\" character varying(50) COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                        "    \"LAST_NAME\" character varying(50) COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                        "    \"HIRE_DATE\" date NOT NULL,\n" +
                        "    \"DEPT_NO\" character varying(3) COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                        "    \"SALARY\" double precision NOT NULL,\n" +
                        "    CONSTRAINT employee_pkey PRIMARY KEY (\"EMP_NO\")\n" +
                        ")");
        return "Table Employee is created";
    }




    @Override
    public String addEmployee(String empNo, String firstName, String lastName, String hireDate, String deptNo, String salary) {
        jdbcTemplate.execute("INSERT INTO public.employee ( \"EMP_NO\", \"FIRST_NAME\", \"LAST_NAME\", " +
                "\"HIRE_DATE\", \"DEPT_NO\", \"SALARY\") VALUES ( " +
                "'" + empNo + "', " +
                "'" + firstName + "', " +
                "'" + lastName + "', " +
                "'" + hireDate + "', " +
                "'" + deptNo + "', " +
                "'" + salary + "');");
        return "Added <" + empNo + ". " + firstName + " " + lastName + ">";

    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
