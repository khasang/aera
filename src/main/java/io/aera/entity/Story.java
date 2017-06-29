package io.aera.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "stories")
public class Story
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "story_id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_created", nullable = false)
    private Date dateCreated = new Date();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Chapter> chapters = new ArrayList<>();

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "image_background")
    private byte[] imageBackground;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public byte[] getImageBackground() {
        return imageBackground;
    }

    public void setImageBackground(byte[] imageBackground) {
        this.imageBackground = imageBackground;
    }
}
