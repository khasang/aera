package io.aera.service.impl;

import io.aera.config.HibernateServiceTestConfig;
import io.aera.entity.User;
import io.aera.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateServiceTestConfig.class})
public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    //public User user = getUser();

    @Test
    public void registerUser() {
        userService.register(getUser());
        assertNotNull(userService.getById(1L));
    }

    public User getUser(){
        User user = new User();
        user.setId(1L);
        user.setLogin("raket");
        user.setFirstname("Ivanka");
        user.setLastname("Ivanova");
        user.setPassword("raket");
        user.setEmail("ivanka@yandex.ru");
        user.setRoleId(1);
        return user;
    }
}
