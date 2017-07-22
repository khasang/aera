package io.aera.controller;

import io.aera.entity.History;
import io.aera.entity.User;
import io.aera.service.HistoryService;
import io.aera.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;

/**
 * Handles basic users' requests
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger log = Logger.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @Autowired
    HistoryService historyService;

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
            log.debug("UserController.registerUser: New User Registering!");
            userService.register(user);
            historyService.register(user.getLogin());
            return user;
        }
        catch (Exception e) {
            log.debug("UserController.registerUser: User already exists!");
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
        if (user == null)
            log.debug("UserController.showProfileForm: User not found!");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/status");
        modelAndView.addObject("user", user);
        historyService.profile();
        return modelAndView;
    }

    /**
     * Shows update form
     *
     * @return update form
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView showUpdatePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/update");
        historyService.update();
        return modelAndView;
    }

    /**
     * Updates user's information
     *
     * @param user
     * @return updated user
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public User updateUserForm(@RequestBody User user, HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        User currentUser = userService.findByLogin(principal.getName());
        updateUser(currentUser, user);
        historyService.updateForm();
        log.debug("UserController.updateUserForm: " + SecurityContextHolder.getContext().getAuthentication().getName() + " Try to update user data!");
        return userService.update(currentUser);
    }

    /**
     * Private method to update user's information obtained through
     * method @updateUserForm() method
     *
     * @param oldUser
     * @param newUser
     * @return updated user
     */
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

    /**
     * Returns "user/status.jsp" with user's information
     *
     * @param id
     * @return user
     */
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable(value = "id") String id){
        User user = userService.getById(Long.parseLong(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/status");
        modelAndView.addObject("user", user);
        historyService.findById();
        return user;
    }
}
