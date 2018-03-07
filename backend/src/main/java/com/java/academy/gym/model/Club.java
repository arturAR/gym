package com.java.academy.gym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "CLUBS")
public class Club extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTACT_INFOS_ID")
    private ContactInfo contactInfo;

    @JsonIgnore
    @ElementCollection
    @CollectionTable(name = "CLUB_LOCALS", joinColumns = {
            @JoinColumn(name = "REF_CLUB_ID", referencedColumnName = "ID")})
    @MapKeyJoinColumn(name = "LANG_CODE")
    private Map<Locale, ClubLocal> mapLocals = new HashMap<>();

    @Transient
    private ClubLocal clubLocal;

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

    public Club(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public ClubLocal getClubLocal() {
        return clubLocal;
    }

    public void setClubLocal(ClubLocal clubLocal) {
        this.clubLocal = clubLocal;
    }

    public Map<Locale, ClubLocal> getMapLocals() {
        return mapLocals;
    }

    public void setMapLocals(Map<Locale, ClubLocal> mapLocals) {
        this.mapLocals = mapLocals;
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