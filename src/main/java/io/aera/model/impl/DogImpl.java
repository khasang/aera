package io.aera.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DogImpl {
    private String name;
    public DogImpl() {
    }

    //DogImpl dog;


    public String getName() {
        return name;
    }

   // @Override
    public void setName(String name) {
        this.name = name;
        System.out.println("in setter...");
    }
}
