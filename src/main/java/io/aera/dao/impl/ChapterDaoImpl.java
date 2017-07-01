package io.aera.dao.impl;

import io.aera.dao.ChapterDao;
import io.aera.entity.Chapter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ChapterDaoImpl extends BasicDaoImpl<Chapter> implements ChapterDao {
    @Autowired
    private SessionFactory sessionFactory;

    public ChapterDaoImpl(Class<Chapter> entityClass) {
        super(entityClass);
    }
}
