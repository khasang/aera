package io.aera.controller;

import io.aera.entity.Person;
import io.aera.entity.Phone;
import io.aera.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {
    @Autowired
    private Dog dog;

    @RequestMapping("/")
    public String index() {
        return "story";
    }

    @RequestMapping("/page")
    public String page() {
        return "page";
    }

    @RequestMapping("/create")
    public String createDogTable(Model model) {
        model.addAttribute("result", dog.createTable());
        return "create";
    }

    @RequestMapping("/user/page")
    public String userPage() {
        return "userPage";
    }

    @RequestMapping("/admin/page")
    public String adminPage() {
        return "adminPage";
    }

    @RequestMapping(value = {"/password/{password}"}, method = RequestMethod.GET)
    public ModelAndView passwordEncode(@PathVariable("password") String password) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("password");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(password));
        return modelAndView;
    }

    @RequestMapping(value = {"/onetomany"})
    public String oneToMany() {
        Person person = new Person();
        Phone phone1 = new Phone("89085898365");
        Phone phone2 = new Phone("89085898248");

        List<Phone> phones = new ArrayList<>();
        phones.add(phone1);
        phones.add(phone2);
        person.getPhones().addAll(phones);

        return "success";
    }
}
