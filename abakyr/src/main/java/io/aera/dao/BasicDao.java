package io.aera.dao;

import io.aera.entity.Story;
import org.hibernate.Session;

/**
 * Basic dao operations with DAO children
 *
 */
public interface BasicDao<T> {
    /**
     * @return current Hibernate session
     */
    Session getCurrentSession();

    /**
     * Creates entity in the database
     *
     * @param entity
     * @return entity
     */
    T create(T entity);

    /**
     * Gets entity by id
     *
     * @param id - id of the entity
     * @return entity
     */
    T getById(long id);

    /**
     * Updates entity in the database
     *
     * @param entity
     * @return entity
     */
    T updateStory(T entity);

    /**
     * Deletes entity by id
     *
     * @param entity
     */
    void deleteStory(T entity);
}