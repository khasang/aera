package io.aera.service;

import io.aera.entity.PersonageType;

import java.util.List;

/**
 * Used for PersonageType functionality
 */
public interface PersonageTypeService {

    /**
     * Create PersonageType at database
     *
     * @param personageType - PersonageType for creation
     * @return PersonageType
     */
    PersonageType createTypePersonage(PersonageType personageType);

    /**
     * Update PersonageType at database
     *
     * @param personageType - PersonageType for update
     * @return PersonageType
     */
    PersonageType updateTypePersonage(PersonageType personageType);

    /**
     * Delete PersonageType from database by id
     *
     * @param typeId - unique id for typePersonage (PK)
     * @return
     */
    void deleteTypePersonById(long typeId);

    /**
     * Get PersonageType from database by id
     *
     * @param typePersonId - unique id for PersonageType (PK)
     * @return PersonageType
     */
    PersonageType getTypePersonageById(long typePersonId);

    /**
     * @return list of TypePersonages
     */
    List<PersonageType> getTypePersonageList();
}
