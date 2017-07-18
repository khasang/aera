package io.aera.service.impl;

import io.aera.dao.UserDao;
import io.aera.entity.User;
import io.aera.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User register(User user) {
        return userDao.create(user);
    }

    @Override
    public User getById(long id) {
        return userDao.getEntityById(id);
    }

    @Override
    public User findByLogin(String login) {
        return userDao.findEntityByName(login);
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public List<User> getListofUsers(){
        return userDao.getList();
    }

    @Override
    public User deleteStory(long id) {
        return userDao.delete(userDao.getEntityById(id));
    }
}
