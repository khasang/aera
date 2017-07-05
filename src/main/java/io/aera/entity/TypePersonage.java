package io.aera.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "type_person")
public class TypePersonage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tpers_id")
    private long id;
    @Column(name = "tpers_name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Personage> personages = new ArrayList<>();

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

    public List<Personage> getPersonage() {
        return personages;
    }

    public void setPersonage(List<Personage> personages) {
        this.personages = personages;
    }
}
