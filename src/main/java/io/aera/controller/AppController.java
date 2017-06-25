package io.aera.controller;

import io.aera.model.Department;
import io.aera.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
// localhost:8080/
@RequestMapping("/")
public class AppController {
    @Autowired
    private Department department;

    @Autowired
    private Employee employee;

    @RequestMapping("")
    public String index(){ return "index"; }

    @RequestMapping("Department/CreateTable")
    public String departmentCreateTable(Model model){
        model.addAttribute("result", department.createTable());
        return "result";
    }

    @RequestMapping(value = "addDepartment/{Dept_no}/{name}")
    public String departmentAdd(Model model, @PathVariable("Dept_no") String deptNo, @PathVariable("name") String name){
        model.addAttribute("result", department.addDepartment(deptNo, name));
        return "result";
    }

    @RequestMapping("Employee/CreateTable")
    public String employeeCreateTable(Model model){
        model.addAttribute("result", employee.createTable());
        return "result";
    }

    @RequestMapping(value = "addEmployee/{empNo}/{firstName}/{lastName}/{hireDate}/{deptNo}/{salary}")
    public String employeeAdd(Model model,
                       @PathVariable("empNo") String empNo, @PathVariable("firstName") String firstName,
                       @PathVariable("lastName") String lastName, @PathVariable("hireDate") String hireDate,
                       @PathVariable("deptNo") String deptNo, @PathVariable("salary") String salary){
        model.addAttribute("result", employee.addEmployee(empNo, firstName, lastName,
                hireDate, deptNo, salary));
        return "result";
    }

    @RequestMapping("/user")
    public String getUser(){
        return "user";
    }

    @RequestMapping("/admin")
    public String getAdmin(){
        return "admin";
    }
}
