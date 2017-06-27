package io.aera.dao;

import org.hibernate.Session;

/**
 * Basic dao operations for DAO children
 */
public interface BasicDao<T> {

    /**
     * @return current Hibernate session
     */
    Session getCurrentSession();

    /**
     * Create entity at database
     * @param entity - current entity for creation
     * @return created entity
     */
    T create(T entity);
}
