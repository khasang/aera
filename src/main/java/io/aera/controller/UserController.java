package io.aera.controller;

import io.aera.entity.User;
import io.aera.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles basic users' requests
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * Shows registration form
     *
     * @return ModelAndView
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegisterForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/register");
        return modelAndView;
    }

    /**
     * Registers new user
     *
     * @param user User database info
     * @return user added to db
     */
    @RequestMapping(value = "/register", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public User registerUser(@RequestBody User user) throws Exception {
        try {
            userService.register(user);
            return user;
        }
        catch (Exception e) {
            throw new Exception("User already exists");
        }
    }

    /**
     * Allows to login into application. Redirects to 'user/status.jsp'
     *
     * @return modelView
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLoginForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/login");
        return modelAndView;
    }

    /**
     * Shows basic profile page
     *
     * @return
     */
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public ModelAndView showProfileForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/status");
        return modelAndView;
    }
}
