package io.aera.controller;

import io.aera.entity.Personage;
import io.aera.service.PersonageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/personage")
@Controller
public class PersonageController {
    @Autowired
    private PersonageService personageService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Personage> getPersonageList(){
        return personageService.getPersonageList();
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Personage addPersonage(@RequestBody Personage personage) {
        return personageService.createPersonage(personage);
    }

    @RequestMapping(value = "/get/person/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Personage personage(@PathVariable(value = "id") String id) {
        return personageService.getPersonageById(Long.parseLong(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Personage updatePersonage(@RequestBody Personage personage) {
        return personageService.updatePersonage(personage);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePersonage(@PathVariable(value = "id") String id) {
        personageService.deletePersonageById(Long.parseLong(id));
    }
}
