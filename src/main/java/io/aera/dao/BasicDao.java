package io.aera.dao;

import io.aera.entity.Story;
import org.hibernate.Session;

import java.util.List;

/**
 * Basics dao operations for DAO child
 */
public interface BasicDao<T> {
    /**
     * @return current Hibernate session
     */
    Session getCurrentSession();

    /**
     * Create entity at database
     *
     * @param entity - current entity for creation
     * @return created entity
     */
    T create(T entity);

    /**
     * Find entity at database
     *
     * @param id - current id of entity
     * @return entity
     */
    T getById(long id);

    /**
     * @return list from entity
     * */
    List<T> getList();

    /**
     * Update entity at database
     *
     * @param entity - current entity for update
     * @return updated entity
     */
    T update(T entity);

    /**
     * Delete entity in database
     *
     * @param id -  id of entity for delete
     * @return entity
     */
    void deleteById(long id);
}
