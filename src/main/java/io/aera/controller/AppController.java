package io.aera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    //localhost:8080/
    @RequestMapping("/")
    String hello(Model model){
        model.addAllAttributes("attr","hello");
        return "index";
    }
}
