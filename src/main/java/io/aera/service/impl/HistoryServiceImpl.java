package io.aera.service.impl;

import io.aera.dao.HistoryDao;
import io.aera.entity.History;
import io.aera.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("historyService")
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    HistoryDao historyDao;


    @Override
    public History createHistory(History history) {
        return historyDao.create(history);
    }
}
