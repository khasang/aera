package io.aera.controller;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@Controller
public class AppController {
    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("attr", "hello");
        return "index";
    }

}
