package io.aera.service.impl;

import io.aera.dao.TypePersonageDao;
import io.aera.entity.TypePersonage;
import io.aera.service.TypePersonageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("typePersonageService")
public class TypePersonageServiceImpl implements TypePersonageService {
    @Autowired
    private TypePersonageDao typePersonageDao;

    @Override
    public TypePersonage createTypePersonage(TypePersonage typePersonage) {
        return typePersonageDao.create(typePersonage);
    }

    @Override
    public List<TypePersonage> getTypePersonageList() {
        return typePersonageDao.getList();
    }

    @Override
    public TypePersonage getTypePersonageById(long typePersonId) {
        return typePersonageDao.getById(typePersonId);
    }
}
