package io.aera.controller;

import io.aera.model.Cat;
import io.aera.model.Cow;
import io.aera.model.Dog;
import io.aera.model.Message;
import io.aera.model.impl.CowImpl;
import io.aera.model.impl.DogImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    private Cat cat;
    @Autowired
    Message message;
    @Autowired // creates instance of DogImpl
    DogImpl dog;
    @Autowired
    Cow cow;
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
}
