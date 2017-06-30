package io.aera.dao;

import org.hibernate.Session;

/**
 *Basics DAO operations for DAO child
 */


public interface BasicDao<T> {
    /**
     *
     * @return curren Hibernate session
     */
    Session getCurrentSession();

    /**
     *
     * Create entity at database
     *@param entity- current entity for creation
     * @return return created entity
     */
    T create(T entity);
}
