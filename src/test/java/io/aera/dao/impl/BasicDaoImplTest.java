package io.aera.dao.impl;

import io.aera.config.HibernateTestConfig;
import io.aera.dao.BasicDao;
import io.aera.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateTestConfig.class})
public class BasicDaoImplTest {
    @Autowired
    private BasicDao basicDao;

    @Test
    public void createEntity(){
        basicDao.create(getUser());
        assertEquals(basicDao.getList().size(), 1);
    }

    @Test
    public void getAllEntities(){
        List<User> list = basicDao.getList();
        assertEquals(basicDao.getList().size(), list.size());
    }

    @Test
    public void findEntityById() {
        assertNotNull(basicDao.getById(1L));
        assertNull(basicDao.getById(5L));
    }

    public User getUser(){
        User user = new User();
        user.setId(1L);
        user.setLogin("raketa");
        user.setFirstname("Ivan");
        user.setLastname("Ivanov");
        user.setPassword("raketa");
        user.setEmail("ivan@yandex.ru");
        user.setRoleId(1);
        return user;
    }
}
