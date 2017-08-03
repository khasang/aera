package io.aera.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Column(name = "description")
    private String description;

    @Column(name="date_modified", nullable = false)
    private LocalDateTime dateModified = LocalDateTime.now();

    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "background_image_fk")
    private Image backgroundImage;
    */
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "background_image_fk")
    //@JsonIgnore
    private Document backgroundImage;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Column(name = "chapters")
    private List<Chapter> chapters = new ArrayList<>();

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> storyChapters) {
        this.chapters = storyChapters;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime date) {
        this.dateModified = date;
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

    public Document getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Document backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
}
