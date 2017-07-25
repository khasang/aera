package io.aera.service.impl;

import io.aera.dao.PersonageTypeDao;
import io.aera.entity.PersonageType;
import io.aera.service.PersonageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personageTypeService")
public class PersonageTypeServiceImpl implements PersonageTypeService {
    @Autowired
    private PersonageTypeDao personageTypeDao;

    @Override
    public PersonageType createTypePersonage(PersonageType personageType) {
        return personageTypeDao.create(personageType);
    }

    @Override
    public PersonageType updateTypePersonage(PersonageType personageType) {
        return personageTypeDao.update(personageType);
    }

    @Override
    public void deleteTypePersonById(long typeId) {
        personageTypeDao.deleteById(typeId);
    }

    @Override
    public List<PersonageType> getTypePersonageList() {
        return personageTypeDao.getList();
    }

    @Override
    public PersonageType getTypePersonageById(long typePersonId) {
        return personageTypeDao.getById(typePersonId);
    }
}
