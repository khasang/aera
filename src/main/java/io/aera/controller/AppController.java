package io.aera.controller;

import io.aera.model.Cat;
import io.aera.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class AppController {
    @Autowired
    private Cat cat;
    @Autowired
    Message message;
    @Autowired
    JdbcTemplate jdbcTemplate;

    // localhost:8080/
    @RequestMapping("/")
    public String hello(Model model){
        return "index";
    }

    @RequestMapping("/admin/page/")
    public String securePage(){
        return "admin";
    }

    @RequestMapping(value = "/initialize/", produces = "application/json")
    @ResponseBody
    public boolean initialize() {
        jdbcTemplate.execute("INSERT INTO roles(id, role) VALUES (1, 'ROLE_ADMIN')");
        jdbcTemplate.execute("INSERT INTO roles(id, role) VALUES (2, 'ROLE_USER')");
        jdbcTemplate.execute("INSERT INTO players(id, login, firstname, lastname, password, email, role_id) " +
                "VALUES (0, 'admin', 'admin', 'admin', '$2a$10$88eS7/xx1b.G63tc5SNFv.NxIsoD4h9usZkWYjjbNdLpD3KD8s8WK', 'admin@aera.com', 1)");
        return true;
    }

    // localhost:8080/password/admin
    @RequestMapping(value = {"/password/{password}"}, method = RequestMethod.GET)
    public ModelAndView passwordEncode(@PathVariable("password") String password){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("password");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(password));
        return modelAndView;
    }
}
