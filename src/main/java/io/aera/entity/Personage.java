package io.aera.entity;

import javax.persistence.*;

@Entity
@Table(name = "personage")
public class Personage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pers_id")
    private long id;
    @Column(name = "pers_name")
    private String name;
    @Column(name = "pers_level")
    private int level;

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
