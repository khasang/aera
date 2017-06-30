package io.aera.entity;

import javax.persistence.*;

@Entity
//optional
@Table(name = "cats")

public class Cat {

    public Cat() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cat_id")
    private long id;
    @Column(name = "cat_name")
    private String name;


}//class
