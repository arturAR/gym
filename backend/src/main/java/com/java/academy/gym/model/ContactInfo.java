package com.java.academy.gym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT_INFOS")
public class ContactInfo extends BaseEntity {

    @JsonIgnore
    @OneToOne(mappedBy = "contactInfo")
    private Club club;
    @Column(name = "ADDRESS", nullable = false, length = 500)
    private String address;
    @Column(name = "PHONE_NUMBER", nullable = false, length = 15)
    private String phone;
    @Column(name = "CITY", nullable = false, length = 100)
    private String city;
    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    public ContactInfo() {}

    public ContactInfo(Club club, String address, String phone, String city) {
        this.club = club;
        this.address = address;
        this.phone = phone;
        this.city = city;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
