package io.aera.controller;

import io.aera.model.Cat;
import io.aera.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// localhost:8080/
@RequestMapping("/")
public class AppController {
    @Autowired
    private Cat cat;

    @Autowired
    private Dog dog;

    @RequestMapping()
    public String hello(Model model){
        model.addAttribute("catName", cat.getName());
        model.addAttribute("dogName", dog.getName());
        return "index";
    }
}
