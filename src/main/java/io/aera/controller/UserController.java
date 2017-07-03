package io.aera.controller;

import io.aera.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handle requests for user functionality
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * Show register user form
     * @return ModelAndView
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegisterForm() {
        User user = new User();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/register");
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    /**
     * Register new user
     * @param user User database info
     * @return ModelAndView
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("statusMessage", "bla-bla-bla");
        modelAndView.addObject("user", user);
        modelAndView.setViewName("/user/status");
        return modelAndView;
    }
}
