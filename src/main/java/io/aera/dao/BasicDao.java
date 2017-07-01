package io.aera.dao;

import io.aera.entity.Chapter;
import io.aera.entity.Story;
import org.hibernate.Session;

import java.util.List;

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

    /**
     * Get entity from database by ID
     * @param id - current ID of entity
     * @return found entity
     */
    T getById(long id);

    /**
     * Delete entity from database by ID
     * @param id - current ID of entity
     */
    void deleteById(long id);

    /**
     * @return List of entities
     */
    List<T> getAllEnities();

    /**
     * Update existing entity
     * @param entity
     * @return updated entity
     */
    T updateEntity(T entity);
}
