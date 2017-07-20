package io.aera.service;

import io.aera.entity.History;

/**
 * The primary goal of the interface is to write
 * a user's history to the database
 */
public interface HistoryService {

    /**
     * Writes history about new users' registration to the database
     *
     * @return history
     */
    History register();

    /**
     * Writes history to the database about showing profile page of the authenticated User
     *
     * @return history
     */
    History profile();

    /**
     * Writes history to the database of sending request to update User's information
     *
     * @return history
     */
    History update();

    /**
     * Writes history to the database about updating user's information
     *
     * @return history
     */
    History updateForm();

    /**
     * Writes history to the database about searching and showing User's information by id
     *
     * @return history
     */
    History findById();
}
