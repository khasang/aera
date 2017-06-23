package io.aera.entity;

import javax.persistence.*;

@Entity(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String number;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "details_id")
    private PhoneDetails phoneDetails;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneDetails getPhoneDetails() {
        return phoneDetails;
    }

    public void setPhoneDetails(PhoneDetails phoneDetails) {
        this.phoneDetails = phoneDetails;
    }
}
