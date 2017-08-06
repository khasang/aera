package io.aera.dao.impl;

import io.aera.dao.StoryDao;
import io.aera.entity.Story;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("storyDao")
public class StoryDaoImpl extends BasicDaoImpl<Story> implements StoryDao {
    @Autowired
    private SessionFactory sessionFactory;

    public StoryDaoImpl(){
        super(Story.class);
    }

    public StoryDaoImpl(Class<Story> entityClass) {
        super(entityClass);
    }
}
