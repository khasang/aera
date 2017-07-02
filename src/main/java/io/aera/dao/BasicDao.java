package io.aera.dao;

import io.aera.entity.Story;
import org.hibernate.Session;

import java.util.List;

/**
 * Basics DAO operations for DAO child
 */
public interface BasicDao<T> {
    /**
     * @return current hibernate session
     */
    Session getCurrentSession();

    /**
     * Create entity at database
     * @param entity - current entity for creation
     * @return created entity
     */
    T create (T entity);

    /**
     * Find entity at database
     * @param id - entity id
     * @return entity
     */
    T getById(long id);

    /**
     * Update entity at database
     * @param entity - entity
     * @return entity
     */
    T update(T entity);

    /**
     * Delete entity by id
     * @param id - entity id to delete
     */
    void deleteById(long id);

    /**
     * Get list of entities
     * @return list of entities
     */
    List<T> getList();
}
