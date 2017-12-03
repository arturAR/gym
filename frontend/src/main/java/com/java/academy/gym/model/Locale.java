package com.java.academy.gym.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "locales")
public class Locale extends BaseEntity {

    @NotNull
    @Size(max = 10)
    @Column(unique = true)
    private String languageCode;

    @Size(max = 100)
    private String language;

    @Size(max = 100)
    private String country;

    public Locale() {
    }

    public Locale(String languageCode, String language, String country) {
        this.languageCode = languageCode;
        this.language = language;
        this.country = country;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
