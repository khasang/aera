package io.aera.controller;

import io.aera.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    private Dog dog;

    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("attr", dog.getName());
        return "index";
    }
}
