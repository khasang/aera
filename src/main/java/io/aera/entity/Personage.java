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
    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    //private List<TypePerson> storyChapters = new ArrayList<>();

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
}
