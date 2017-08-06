package io.aera.controller;

import io.aera.entity.PersonageType;
import io.aera.service.PersonageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/personage_type")
@Controller
public class PersonageTypeController {
    private final PersonageTypeService personageTypeService;

    @Autowired
    public PersonageTypeController(PersonageTypeService personageTypeService) {
        this.personageTypeService = personageTypeService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public PersonageType createPersonageType(@RequestBody PersonageType personageType) {
        return personageTypeService.createPersonageType(personageType);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public List<PersonageType> getPersonageTypeList() {
        return personageTypeService.getPersonageTypeList();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PersonageType getPersonageTypeById(@PathVariable(value = "id") String id) {
        return personageTypeService.getPersonageTypeById(Long.parseLong(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public PersonageType updatePersonageType(@RequestBody PersonageType personageType) {
        return personageTypeService.updatePersonageType(personageType);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePersonageTypeById(@PathVariable(value = "id") String id) {
        personageTypeService.deletePersonageTypeById(Long.parseLong(id));
    }
}
