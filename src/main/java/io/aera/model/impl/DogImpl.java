package io.aera.model.impl;

import io.aera.model.Dog;

public class DogImpl implements Dog {
    private String name;

    public DogImpl(String name) {
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
