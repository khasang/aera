package io.aera.controller;

import io.aera.model.*;
import io.aera.model.impl.DogImpl;
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
    private Message message;//
    @Autowired // creates instance of DogImpl
    private DogImpl dog;
    @Autowired
    private Cow cow;
    @Autowired
    private Bull bull;

    //localhost:8080/
    @RequestMapping("/")
    public String hello(Model model) {
        message.setMessageInfo("Big and fat cat");
        dog.setName("Rex");
        model.addAttribute("attr", cat.getName() + " " + message.getMessage());
        model.addAttribute("attr2", dog.getName());
        model.addAttribute("attr3", cow.getName());
        System.out.println("AppController");
        return "index";
    }

    @RequestMapping("/bull")
    public String createBullTable(Model model) {
        model.addAttribute("status", bull.createBullTable());
        return "bull";
    }

    // @RequestMapping("/user/page")
    //public String getUser() {
    //  return "page";
    //}

    @RequestMapping("/admin/page")
    public String securePage() {
        return "admin";

    }

    //localhost:8080/password/admin
    @RequestMapping(value = {"/password/{password}"}, method = RequestMethod.GET)
    public ModelAndView passwordEncode(@PathVariable("password") String password) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("password");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        modelAndView.addObject("crypt", bCryptPasswordEncoder.encode(password));
        System.out.println(bCryptPasswordEncoder.encode(password));
        return modelAndView;
    }

}//class
