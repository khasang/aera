package io.aera.model.impl;

import io.aera.model.Cat;

public class CatImpl implements Cat{
    private String name;

    public CatImpl(String name){
        setName(name);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
