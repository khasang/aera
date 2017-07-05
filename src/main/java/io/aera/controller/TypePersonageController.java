package io.aera.controller;

import io.aera.entity.TypePersonage;
import io.aera.service.TypePersonageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/type_personage")
@Controller
public class TypePersonageController {
    @Autowired
    private TypePersonageService typePersonageService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<TypePersonage> getTypePersonageList(){
        return typePersonageService.getTypePersonageList();
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public TypePersonage addTypePersonage(@RequestBody TypePersonage typePersonage) {
        return typePersonageService.createTypePersonage(typePersonage);
    }

    @RequestMapping(value = "/get/type_person/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TypePersonage typePersonage(@PathVariable(value = "id") String id) {
        return typePersonageService.getTypePersonageById(Long.parseLong(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public TypePersonage updateTypePersonage(@RequestBody TypePersonage typePersonage) {
        return typePersonageService.updateTypePersonage(typePersonage);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePersonage(@PathVariable(value = "id") String id) {
        typePersonageService.deleteTypePersonById(Long.parseLong(id));
    }
}
