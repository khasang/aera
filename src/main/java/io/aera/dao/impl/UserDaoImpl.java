package io.aera.dao.impl;

import io.aera.dao.UserDao;
import io.aera.entity.Roles;
import io.aera.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("userDao")
public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao {
    //@Autowired
    //private PasswordEncoder passwordEncoder;

    public UserDaoImpl() { super(User.class); }

    public UserDaoImpl(Class<User> entityClass) {
        super(entityClass);
    }

    @Override
    public User create(User entity) {
        entity.setRoleId(1);
        //entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        entity.setPassword(new BCryptPasswordEncoder().encode(entity.getPassword()));
        return super.create(entity);
    }
}
