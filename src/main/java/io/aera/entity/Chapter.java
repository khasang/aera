package io.aera.entity;

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

    @Column(name = "price")
    private BigDecimal goldPrices;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "file_data")
    private byte[] file_data;

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

    public byte[] getFile_data() {
        return file_data;
    }

    public void setFile_data(byte[] file_data) {
        this.file_data = file_data;
    }
}
