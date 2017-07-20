package io.aera.dao.impl;

import io.aera.dao.HistoryDao;
import io.aera.entity.History;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("historyDao")
public class HistoryDaoImpl extends BasicDaoImpl<History> implements HistoryDao {

    public HistoryDaoImpl() { super(History.class); }

    public HistoryDaoImpl(Class<History> entityClass) {
        super(entityClass);
    }
}
