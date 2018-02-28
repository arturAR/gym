package com.java.academy.gym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CLUBS")
public class Club extends BaseEntity {

    private String name;
    @OneToOne
    @JoinColumn(name = "CONTACT_INFOS_ID")
    private ContactInfo contactInfo;
    private String description;

    //TODO add photos for gallery
    @Transient
    private List<String> pictures;
    //TODO change to entity class
    @Transient
    private List<String> classes;
    //TODO create crew list for club after User/Employee implementation
    @Transient
    private List<String> crew;

    public Club() {}

    public Club(String name, ContactInfo contactInfo, String description) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }

    public List<String> getCrew() {
        return crew;
    }

    public void setCrew(List<String> crew) {
        this.crew = crew;
    }
}
