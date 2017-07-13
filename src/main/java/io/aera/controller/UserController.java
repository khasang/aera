package io.aera.controller;

import io.aera.entity.User;
import io.aera.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

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
     * @return modelAndView
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
     * @return modelAndView
     */
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public ModelAndView showProfileForm(HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        User user = userService.findByLogin(principal.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/status");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView showUpdatePage(@PathVariable(value = "id") String id){
        User user = userService.getById(Long.parseLong(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/update/" + user.getId());
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public User updateUserForm(@RequestBody User user, @PathVariable(value = "id") String id){
        User currentUser = userService.getById(Long.parseLong(id));
        updateUser(currentUser, user);
        return userService.update(currentUser);
    }

    private User updateUser(User oldUser, User newUser) {
        oldUser.setId(oldUser.getId());
        oldUser.setLogin(newUser.getLogin());
        oldUser.setFirstname(newUser.getFirstname());
        oldUser.setLastname(newUser.getLastname());
        oldUser.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));
        oldUser.setEmail(newUser.getEmail());
        oldUser.setRoleId(oldUser.getRoleId());
        return oldUser;
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable(value = "id") String id){
        User user = userService.getById(Long.parseLong(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/status");
        modelAndView.addObject("user", user);
        return user;
    }
}
