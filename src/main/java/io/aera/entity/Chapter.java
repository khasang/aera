package io.aera.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "chapters")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "chapter_id")
    private long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name = "goldprice")
    private BigDecimal goldPrice;

    @Column(name="date_modified", nullable = false)
    private LocalDateTime dateModified = LocalDateTime.now();

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

    public BigDecimal getGoldPrice() {
        return goldPrice;
    }

    public void setGoldPrice(BigDecimal goldPrice) {
        this.goldPrice = goldPrice;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime date) {
        this.dateModified = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chapter)) return false;

        Chapter chapter = (Chapter) o;

        if (getId() != chapter.getId()) return false;
        if (!getName().equals(chapter.getName())) return false;
        return getGoldPrice() != null ? getGoldPrice().equals(chapter.getGoldPrice()) : chapter.getGoldPrice() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getName().hashCode();
        result = 31 * result + (getGoldPrice() != null ? getGoldPrice().hashCode() : 0);
        return result;
    }
}
