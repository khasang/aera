package io.aera.service.impl;

import io.aera.dao.HistoryDao;
import io.aera.entity.History;
import io.aera.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Date;

@Service
@Qualifier("historyService")
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    HistoryDao historyDao;

    @Override
    public History register(){
        WebAuthenticationDetails details = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        History history = new History(new Date(), "Registering new User!",
                SecurityContextHolder.getContext().getAuthentication().getName(),
                RequestContextHolder.currentRequestAttributes().getSessionId(),
                details.getRemoteAddress());
        return historyDao.create(history);
    }

    @Override
    public History profile() {
        WebAuthenticationDetails details = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        History history = new History(new Date(), "User logged in Profile page!",
                SecurityContextHolder.getContext().getAuthentication().getName(),
                RequestContextHolder.currentRequestAttributes().getSessionId(),
                details.getRemoteAddress());
        return historyDao.create(history);
    }

    @Override
    public History update() {
        WebAuthenticationDetails details = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        History history = new History(new Date(), "Sent request to update User!",
                SecurityContextHolder.getContext().getAuthentication().getName(),
                RequestContextHolder.currentRequestAttributes().getSessionId(),
                details.getRemoteAddress());
        return historyDao.create(history);
    }

    @Override
    public History updateForm() {
        WebAuthenticationDetails details = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        History history = new History(new Date(), "Updating User's information Page!",
                SecurityContextHolder.getContext().getAuthentication().getName(),
                RequestContextHolder.currentRequestAttributes().getSessionId(),
                details.getRemoteAddress());
        return historyDao.create(history);
    }

    @Override
    public History findById() {
        WebAuthenticationDetails details = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        History history = new History(new Date(), "Showing User's information!",
                SecurityContextHolder.getContext().getAuthentication().getName(),
                RequestContextHolder.currentRequestAttributes().getSessionId(),
                details.getRemoteAddress());
        return historyDao.create(history);
    }
}
