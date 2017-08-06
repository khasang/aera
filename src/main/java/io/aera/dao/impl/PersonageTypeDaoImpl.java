package io.aera.dao.impl;

import io.aera.dao.PersonageTypeDao;
import io.aera.entity.PersonageType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonageTypeDaoImpl extends BasicDaoImpl<PersonageType> implements PersonageTypeDao {
    public PersonageTypeDaoImpl(Class<PersonageType> entityClass) {
        super(entityClass);
    }
}
