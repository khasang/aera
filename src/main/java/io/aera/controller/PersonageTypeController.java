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
    @Autowired
    private PersonageTypeService personageTypeService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<PersonageType> getPersonageTypeList(){
        return personageTypeService.getPersonageTypeList();
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public PersonageType addTypePersonage(@RequestBody PersonageType personageType) {
        return personageTypeService.createPersonageType(personageType);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PersonageType typePersonage(@PathVariable(value = "id") String id) {
        return personageTypeService.getPersonageTypeById(Long.parseLong(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public PersonageType updateTypePersonage(@RequestBody PersonageType personageType) {
        return personageTypeService.updatePersonageType(personageType);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePersonage(@PathVariable(value = "id") String id) {
        personageTypeService.deletePersonageTypeById(Long.parseLong(id));
    }
}
