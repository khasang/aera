package io.aera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AppController {
    @RequestMapping("")
    public String personageControl() {
        return "personageControl";
    }
}
