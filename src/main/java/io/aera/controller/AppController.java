package io.aera.controller;

import io.aera.model.Cat;
import io.aera.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    private Cat cat;
    @Autowired
    Message message;

    // localhost:8080/
    @RequestMapping("/")
    public String hello(Model model) {
        message.setMessageInfo("Big ane fat cat Tihon!");
        model.addAttribute("attr", message.getMessage());
        //model.addAttribute("attr", cat.getName());
        return "index";
    }
}
