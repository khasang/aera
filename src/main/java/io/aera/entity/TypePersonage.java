package io.aera.entity;

import javax.persistence.*;


@Entity
@Table(name = "personage_type")
public class TypePersonage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tpers_id")
    private long id;
    @Column(name = "tpers_name")
    private String name;

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
