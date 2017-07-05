package io.aera.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<TypePersonage> typePersonage = new ArrayList<>();

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

    public List<TypePersonage> getTypePersonage() {
        return typePersonage;
    }

    public void setTypePersonage(List<TypePersonage> typePersonage) {
        this.typePersonage = typePersonage;
    }
}
