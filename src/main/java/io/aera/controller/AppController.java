package io.aera.controller;

import io.aera.model.Cat;
import io.aera.model.Text;
import io.aera.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 11.06.2017.
 */
@Controller
public class AppController {
    @Autowired
    Cat cat;
    @Autowired
    Worker worker;

    @RequestMapping("/")
    public String hello(Model model){
        return "story";
    }
    @Autowired
    Text text;
    @RequestMapping("/who")
    public String text(Model model) {
        model.addAttribute("text", text.getDescription());

        return "index";
    }
    @RequestMapping("/create")
    public String createNewTableWorkers(Model model) {
        model.addAttribute("status" , worker.createDogTable());
        return "worker";
    }

    @RequestMapping(value = {"/password/{password}"}, method = RequestMethod.GET)
    public ModelAndView passwordEncode(@PathVariable("password") String password){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("password");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(password));
        return modelAndView;
    }

    @RequestMapping("/admin/page/")
    public String securePage(){
        return "admin";
    }

    @RequestMapping("/user/page/")
    public String userPage(){
        return "user";
    }
}
