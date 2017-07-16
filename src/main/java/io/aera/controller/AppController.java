package io.aera.controller;

import io.aera.model.Cat;
import io.aera.model.Dog;
import io.aera.model.Message;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private static final Logger log = Logger.getLogger(AppController.class);

    @Autowired
    private Cat cat;
    @Autowired
    Message message;
    @Autowired
    private Dog dog;

    // localhost:8080/
    @RequestMapping("/")
    public String hello(Model model){
        log.error(AppController.class + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                + "Just enter to default page!");
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return "story";
    }

    @RequestMapping("/create")
    public String createDogTable(Model model){
        model.addAttribute("status", dog.createDogTable());
        return "dog";
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
