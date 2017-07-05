package io.aera.service;

import io.aera.entity.TypePersonage;

import java.util.List;

/**
 * Used for TypePersonage functionality
 */
public interface TypePersonageService {

    /**
     * Create TypePersonage at database
     *
     * @param typePersonage - TypePersonage for creation
     * @return TypePersonage
     */
    TypePersonage createTypePersonage(TypePersonage typePersonage);

    /**
     * Update TypePersonage at database
     *
     * @param typePersonage - TypePersonage for update
     * @return TypePersonage
     */
    TypePersonage updateTypePersonage(TypePersonage typePersonage);

    /**
     * Delete TypePersonage from database by id
     *
     * @param typeId - unique id for typePersonage (PK)
     * @return
     */
    void deleteTypePersonById(long typeId);

    /**
     * Get TypePersonage from database by id
     *
     * @param typePersonId - unique id for TypePersonage (PK)
     * @return TypePersonage
     */
    TypePersonage getTypePersonageById(long typePersonId);

    /**
     * @return list of TypePersonages
     */
    List<TypePersonage> getTypePersonageList();
}
