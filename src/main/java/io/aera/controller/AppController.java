package io.aera.controller;

import io.aera.model.Cat;
import io.aera.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class AppController {
    @Autowired
    private Cat cat;
    @Autowired
    Message message;

    // localhost:8080/
    @RequestMapping("/")
    public String hello(Model model){
        return "story";
    }

    @RequestMapping("/admin/page/")
    public String securePage(){
        return "admin";
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
