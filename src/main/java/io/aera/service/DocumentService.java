package io.aera.service;

import io.aera.entity.Document;

public interface DocumentService {
    /**
     * Save document to DB
     * @param document
     */
    void saveDocument(Document document);

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
