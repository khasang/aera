package io.aera.model;

/**
 * Created by admin on 12.06.2017.
 */
public class CatImple implements Cat{
    String name;

    public CatImple() {
    }

    public CatImple(String name) {
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
