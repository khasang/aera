package io.aera.service.impl;

import io.aera.config.AppConfig;
import io.aera.config.application.WebConfig;
import io.aera.entity.User;
import io.aera.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, AppConfig.class})
@WebAppConfiguration
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void testRegisterUser() {
        User user = userService.register(createUser());
        assertNotNull(userService.getById(user.getId()));
        User userForComparison = userService.getById(user.getId());
        assertEquals("raketa", userForComparison.getLogin());
        userService.deleteStory(user.getId());
    }

    @Test
    public void testGetUserByIdNameOrList(){
        User user = userService.register(createUser());
        assertNotNull(userService.getById(user.getId()));
        assertNotNull(userService.findByLogin(user.getLogin()));
        assertNotNull(userService.getListofUsers());
        userService.deleteStory(user.getId());
    }

    @Test
    public void testUpdateUser(){
        User user = userService.register(createUser());
        User updatedUser = updateUser(user);
        userService.update(updatedUser);
        assertNotNull(userService.getById(updatedUser.getId()));
        User result = userService.getById(user.getId());
        assertEquals("phill", result.getLogin());
        userService.deleteStory(updatedUser.getId());
    }

    @Test
    public void testDeleteUser(){
        User user = userService.register(createUser());
        assertNotNull(userService.getById(user.getId()));
        userService.deleteStory(user.getId());
        assertNull(userService.getById(user.getId()));
    }

    private User updateUser(User user) {
        User newUser = user;
        newUser.setLogin("phill");
        newUser.setFirstname("Phillip");
        return newUser;
    }

    private User createUser(){
        User user = new User();
        user.setLogin("raketa");
        user.setFirstname("Ivan");
        user.setLastname("Ivanov");
        user.setPassword("raketa");
        user.setEmail("ivan@yandex.ru");
        return user;
    }
}
