package io.aera.dao.impl;

import io.aera.dao.ChapterDao;
import io.aera.entity.Chapter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("chapterDao")
public class ChapterDaoImpl extends BasicDaoImpl<Chapter> implements ChapterDao {
    @Autowired
    private SessionFactory sessionFactory;

    public ChapterDaoImpl(){
        super(Chapter.class);
    }

    public ChapterDaoImpl(Class<Chapter> entityClass) {
        super(entityClass);
    }
}
