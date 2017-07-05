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
