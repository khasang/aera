package io.aera.dao;

import org.hibernate.Session;

import java.util.List;

/**
 * Basic dao operation for DAO child
 */
public interface BasicDao<T> {
    /**
     * @return current hibernate session
     */
    Session getCurrentSession();

    /**
     * Create entity in database
     *
     * @param entity -  current entity for creation
     * @return created entity
     */
    T create(T entity);

    /**
     * Find entity in database
     *
     * @param id -  current id of entity
     * @return entity
     */
    T getById(long id);

    /**
     * Update entity in database
     *
     * @param entity - entity for update
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

    /**
     * @return list from entity
     */
    List<T> getList();
}
