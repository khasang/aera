package io.aera.dao.impl;

import io.aera.dao.BasicDao;
import io.aera.dao.StoryDao;
import io.aera.entity.Story;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class StoryDaoImpl extends BasicDaoImpl<Story> implements StoryDao{
    @Autowired
    private SessionFactory sessionFactory;

    public StoryDaoImpl(Class<Story> entityClass) {
        super(entityClass);
    }
}
