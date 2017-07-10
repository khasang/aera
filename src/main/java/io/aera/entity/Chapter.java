package io.aera.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "chapters")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "chapter_id")
    private long id;

    @Column(name="name", nullable = false)
    private String name;

    private BigDecimal goldPrices;

    /*@Basic(fetch = FetchType.LAZY)
    @Column(name = "file_data")
    private byte[] file_data;*/

    /*@ManyToOne
    @JoinColumn(name = "story_id", foreignKey = @ForeignKey(name = "STORY_ID_FK"))
    private Story story;*/


    public BigDecimal getGoldPrices() {
        return goldPrices;
    }

    public void setGoldPrices(BigDecimal goldPrices) {
        this.goldPrices = goldPrices;
    }

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

    /*public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }*/

    /*public byte[] getFile_data() {
        return file_data;
    }

    public void setFile_data(byte[] file_data) {
        this.file_data = file_data;
    }*/


}
