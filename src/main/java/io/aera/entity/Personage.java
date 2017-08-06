package io.aera.entity;

import javax.persistence.*;

@Entity
@Table(name = "personages")
public class Personage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "level")
    private int level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personage_types_id")
    private PersonageType personageType;

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

    public PersonageType getPersonageType() {
        return personageType;
    }

    public void setPersonageType(PersonageType personageType) {
        this.personageType = personageType;
    }
}
