package io.aera.dao.impl;


import io.aera.config.AppConfig;
import io.aera.config.HibernateConfig;
import io.aera.config.application.WebConfig;
import io.aera.dao.HistoryDao;
import io.aera.entity.History;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, AppConfig.class})
@WebAppConfiguration
public class HistoryDaoImplTest {
    @Autowired
    HistoryDao historyDao;

    @Test
    public void testCreateEntity() {
        History history = new History(
                new Date(),
                "Test description",
                "anonymousUser",
                "currentSessionId",
                "localhost"
        );
        historyDao.create(history);
        assertNotNull(historyDao.getEntityById(history.getId()));
        assertEquals("Test description", history.getDescription());
    }
}
