package io.aera.dao;

import io.aera.entity.Document;

public interface DocumentDao{
    /**
     * Save entity to DB
     * @param document
     */
    void save(Document document);

    /**
     * Get document from database by ID.
     * @param documentId - unique document ID
     * @return Document entity
     */
    Document getDocumentById(String documentId);

    /**
     * Remove existing document from DB by documentId
     * @param documentId
     */
    void removeDocumentById(String documentId);
}
