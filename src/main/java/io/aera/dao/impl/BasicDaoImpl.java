package io.aera.dao.impl;

import io.aera.dao.BasicDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

@Transactional
public abstract class BasicDaoImpl<T> implements BasicDao<T> {
private final Class<T> entityClass;
@Autowired
protected SessionFactory sessionFactory;

    protected BasicDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T create(T entity) {
        getCurrentSession().save(entity);
        return entity;
    }
}//class
