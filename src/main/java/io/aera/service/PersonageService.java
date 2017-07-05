package io.aera.service;

import io.aera.entity.Personage;

import java.util.List;

/**
 * Used for personage functionality
 */
public interface PersonageService {

    /**
     * Create Personage at database
     *
     * @param personage - Personage for creation
     * @return Personage
     */
    Personage createPersonage(Personage personage);

    /**
     * Get Personage from database by id
     *
     * @param personId - unique id for personage (PK)
     * @return Personage
     */
    Personage getPersonageById(long personId);

    /**
     * @return list of personages
     */
    List<Personage> getPersonageList();

    /**
     * Update Personage at database
     *
     * @param personage - Personage for update
     * @return Personage
     */
    Personage updatePersonage(Personage personage);

    /**
     * Delete Personage from database by id
     *
     * @param personId - unique id for personage (PK)
     * @return
     */
    void deletePersonageById(long personId);
}
