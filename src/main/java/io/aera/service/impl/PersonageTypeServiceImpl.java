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
    public PersonageType createPersonageType(PersonageType personageType) {
        return personageTypeDao.create(personageType);
    }

    @Override
    public PersonageType updatePersonageType(PersonageType personageType) {
        return personageTypeDao.update(personageType);
    }

    @Override
    public void deletePersonageTypeById(long id) {
        personageTypeDao.deleteById(id);
    }

    @Override
    public List<PersonageType> getPersonageTypeList() {
        return personageTypeDao.getList();
    }

    @Override
    public PersonageType getPersonageTypeById(long id) {
        return personageTypeDao.getById(id);
    }
}
