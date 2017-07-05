package io.aera.dao.impl;

import io.aera.dao.TypePersonageDao;
import io.aera.entity.TypePersonage;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class TypePersonageDaoImpl extends BasicDaoImpl<TypePersonage> implements TypePersonageDao {
    @Autowired
    private SessionFactory sessionFactory;

    public TypePersonageDaoImpl(Class<TypePersonage> entityClass) {
        super(entityClass);
    }
}
