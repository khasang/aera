package io.aera.controller;

import io.aera.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    private Cat cat;

    //localhost:8080/
    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("attr", cat.getName());
        return "index";
    }
}
