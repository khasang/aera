package io.aera.model;

import java.util.Date;

public interface Employee {
    public String createTable();
    public String addEmployee(String empNo, String firstName, String lastName,
                              String hireDate, String deptNo, String salary);
}
