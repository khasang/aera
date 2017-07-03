package io.aera.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "stories")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "story_id")
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date = new Date();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Chapter> storyChapters = new ArrayList<>();

    public List<Chapter> getStoryChapters() {
        return storyChapters;
    }

    public void setStoryChapters(List<Chapter> storyChapters) {
        this.storyChapters = storyChapters;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
