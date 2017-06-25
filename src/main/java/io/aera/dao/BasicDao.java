package io.aera.dao;

import org.hibernate.Session;

/**
 * Basic dao operation for DAO child
 */
public interface BasicDao<T> {
    /**
     * @return current hibernate session
     */
    Session getCurrentSession();

    /**
     * Create entity at database
     * @param entity -  current entity for creation
     * @return created entity
     */
    T create(T entity);
}
