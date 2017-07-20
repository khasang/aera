package io.aera.service;


import io.aera.entity.History;

public interface HistoryService {

    /**
     * Creates history of user's actions in the database
     *
     * @param history
     * @return history
     */
    History createHistory(History history);
}
