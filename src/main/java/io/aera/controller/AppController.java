package io.aera.controller;

import io.aera.model.*;
import io.aera.model.impl.DogImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
        model.addAttribute("attr"  , cat.getName() + " " + message.getMessage());
        model.addAttribute("attr2",dog.getName());
        model.addAttribute("attr3",cow.getName());
        System.out.println("AppController");
        return "index";
    }
    @RequestMapping("create")
    public  String createBullTable(Model model){
        model.addAttribute("status", bull.createBullTable());
        return "bull";
    }
}//class
