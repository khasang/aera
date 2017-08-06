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
    PersonageType createPersonageType(PersonageType personageType);

    /**
     * Update PersonageType at database
     *
     * @param personageType - PersonageType for update
     * @return PersonageType
     */
    PersonageType updatePersonageType(PersonageType personageType);

    /**
     * Delete PersonageType from database by id
     *
     * @param id - unique id for PersonageType (PK)
     * @return
     */
    void deletePersonageTypeById(long id);

    /**
     * Get PersonageType from database by id
     *
     * @param id - unique id for PersonageType (PK)
     * @return PersonageType
     */
    PersonageType getPersonageTypeById(long id);

    /**
     * Get all PersonageType from database
     * @return list of PersonageTypes
     */
    List<PersonageType> getPersonageTypeList();
}
