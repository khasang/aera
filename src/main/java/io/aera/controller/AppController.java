package io.aera.controller;

import io.aera.model.Cat;
import io.aera.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
    @Autowired
    private Cat cat;

    @Autowired
    private Dog dog;

    // localhost:8080/
    @RequestMapping("/")
    public String hello(Model model){
        //model.addAttribute("attr", cat.getName());
        return "story";
    }

    @RequestMapping("/create")
    public String createDogTable(Model model){
        model.addAttribute("status", dog.createDogTable());
        return "dog";
    }

    @RequestMapping("/admin/page")
    public String securePage(){
        return "admin";
    }

    @RequestMapping("/user/page")
    public String getUser(){
        return "page";
    }

    @RequestMapping(value = "/password/{password}", method = RequestMethod.GET)
    public ModelAndView passwordEncode(@PathVariable("password") String password){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("password");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(password));
        return modelAndView;
    }

    @RequestMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model){
        model.addAttribute("error", error!=null);
        model.addAttribute("logout", logout!=null);

        return "login";
    }
}
