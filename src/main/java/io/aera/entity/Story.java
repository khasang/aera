package io.aera.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "story")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "story_id")
    private long id;
    private long age;

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Chapter> storyChapters = new ArrayList<>();

    public List<Chapter> getStoryChapters() {
        return storyChapters;
    }

    public void setStoryChapters(List<Chapter> storyChapters) {
        this.storyChapters = storyChapters;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
