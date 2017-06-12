package io.aera.controller;

import io.aera.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by admin on 11.06.2017.
 */
@Controller
public class AppController {
    @Autowired
    Cat cat;
    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("attr", cat.getName());
        return "index";
    }
}
