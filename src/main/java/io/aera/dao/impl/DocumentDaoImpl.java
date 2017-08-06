package io.aera.dao.impl;

import io.aera.dao.DocumentDao;
import io.aera.entity.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Qualifier("documentDao")
public class DocumentDaoImpl extends BasicDaoImpl implements DocumentDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public DocumentDaoImpl(){
        super(Document.class);
    }

    protected DocumentDaoImpl(Class entityClass) {
        super(entityClass);
    }

    @Transactional
    @Override
    public void save(Document document) {
        getCurrentSession().save(document);
    }

    @Override
    public Document getDocumentById(String documentId) {
        return getCurrentSession().get(Document.class, documentId);
    }

    @Transactional
    @Override
    public void removeDocumentById(String documentId) {
        Document document = getDocumentById(documentId);
        if(document!=null){
            getCurrentSession().delete(document);
        }
    }
}
