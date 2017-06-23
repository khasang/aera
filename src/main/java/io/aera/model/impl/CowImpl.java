package io.aera.model.impl;

import io.aera.model.Cow;

public class CowImpl implements Cow {
String name;

    public CowImpl(String name) {
        this.name = name;
    }

    public CowImpl() {
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
