package io.aera.dao.impl;

import io.aera.dao.PersonageDao;
import io.aera.entity.Personage;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonageDaoImpl extends BasicDaoImpl<Personage> implements PersonageDao {
    public PersonageDaoImpl(Class<Personage> entityClass) {
        super(entityClass);
    }
}
