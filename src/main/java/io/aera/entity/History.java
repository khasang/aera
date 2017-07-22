package io.aera.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private long id;
    private Date date;
    private String description;
    private String userLogin;
    private String currentSession;
    private String ipAddress;

    public History() {
        this.date = new Date();
        this.description = "";
        this.userLogin = "";
        this.currentSession = "";
        this.ipAddress = "";
    }

    public History(Date date, String description, String userLogin, String currentSession, String ipAddress) {
        this.date = date;
        this.description = description;
        this.userLogin = userLogin;
        this.currentSession = currentSession;
        this.ipAddress = ipAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(String currentSession) {
        this.currentSession = currentSession;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
