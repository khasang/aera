package io.aera.dao.impl;

import io.aera.dao.BasicDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public abstract class BasicDaoImpl<T> implements BasicDao<T>{
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

    @Override
    public T getById(long id) {
        return getCurrentSession().get(entityClass, id);
    }

    @Override
    public T update(T entity) {
        try {
            getCurrentSession().update(entity);
            return entity;
        }
        catch (PersistenceException e) {
            return null;
        }
    }

    @Override
    public void deleteById(long id) {
        try {
            T entity = getById(id);
            getCurrentSession().delete(entity);
        }
        catch (IllegalArgumentException e) {
            // Do nothing
        }
    }

    @Override
    public List<T> getList() {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);
        return getCurrentSession().createQuery(criteriaQuery).list();
   }
}
