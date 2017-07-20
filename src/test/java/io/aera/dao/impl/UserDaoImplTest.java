package io.aera.dao.impl;

import io.aera.config.AppConfig;
import io.aera.config.application.WebConfig;
import io.aera.dao.UserDao;
import io.aera.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, AppConfig.class})
@WebAppConfiguration
public class UserDaoImplTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testCreateEntity(){
        User user = userDao.create(createUser());
        long id = user.getId();
        assertNotNull(userDao.getEntityById(id));
        assertEquals("raketa", user.getLogin());
        userDao.delete(user);
    }

    @Test
    public void testGetAllUsers(){
        List<User> list = new ArrayList<>();
        User user = userDao.create(createUser());
        list.add(user);
        assertNotNull(userDao.getList());
        userDao.delete(user);
    }

    @Test
    public void testFindEntityByIdAndEntity() {
        User user = userDao.create(createUser());
        long id = user.getId();
        assertNotNull(userDao.getEntityById(id));
        User result = userDao.findEntityByName(user.getLogin());
        assertEquals("raketa", result.getLogin());
        userDao.delete(user);
    }

    @Test
    public void testUpdateUser(){
        User user = userDao.create(createUser());
        long id = user.getId();
        User updateduser = updateUser(user);
        userDao.update(updateduser);
        assertNotNull(userDao.getEntityById(id));
        assertEquals("phill", updateduser.getLogin());
        userDao.delete(userDao.getEntityById(id));
    }

    @Test
    public void testDeleteUser(){
        User user = userDao.create(createUser());
        long id = user.getId();
        assertNotNull(userDao.getEntityById(id));
        userDao.delete(user);
        assertNull(userDao.getEntityById(id));
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
