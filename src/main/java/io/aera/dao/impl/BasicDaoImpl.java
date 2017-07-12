package io.aera.dao.impl;

import io.aera.dao.BasicDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

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

    @Override
    public T getById(long id) {
        return getCurrentSession().get(entityClass, id);
    }

    @Override
    public void deleteById(long id) {
        Object deletedEntity = getById(id);
        if(deletedEntity!=null){
            getCurrentSession().delete(deletedEntity);
        }
    }

    @Override
    public T updateEntity(T entity) {
        getCurrentSession().update(entity);
        return entity;
    }

    @Override
    public List<T> getAllEnities() {
        CriteriaBuilder criteria = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteria.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);
        return sessionFactory.getCurrentSession().createQuery(criteriaQuery).list();
    }
}
