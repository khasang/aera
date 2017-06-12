package io.aera.model.Impl;

import io.aera.model.Cat;

public class CatImpl implements Cat{
    private String name;

    public CatImpl() {
        name = "Unnamed";
    }

    public CatImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
