package io.aera.dao.impl;

import io.aera.dao.UserDao;
import io.aera.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("userDao")
public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl() { super(User.class); }

    public UserDaoImpl(Class<User> entityClass) {
        super(entityClass);
    }
}
