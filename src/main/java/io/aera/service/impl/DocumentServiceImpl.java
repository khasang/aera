package io.aera.service.impl;

import io.aera.dao.DocumentDao;
import io.aera.entity.Document;
import io.aera.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("documentService")
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentDao documentDao;

    @Override
    public void saveDocument(Document document) {
        documentDao.save(document);
    }

    @Override
    public Document getDocumentById(String documentId) {
        return documentDao.getDocumentById(documentId);
    }

    @Override
    public void removeDocumentById(String documentId) {
        documentDao.removeDocumentById(documentId);
    }
}
