package com.java.academy.gym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LOCALES")
public class Locale implements Serializable {
    private static final long serialVersionUID = -3542746401741355126L;

    @Id
    @Column(name = "LANG_CODE", nullable = false, unique = true, length = 10)
    private String languageCode;

    @Column(name = "LANGUAGE", length = 255)
    private String language;

    @Column(name = "COUNTRY", length = 255)
    private String country;

    @JsonIgnore
    @Column(name = "VERSION")
    @Version
    private Integer version;

    public Locale() {}

    public Locale(String languageCode, String language, String country) {
        this.languageCode = languageCode;
        this.language = language;
        this.country = country;
        this.version = 1;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locale locale = (Locale) o;

        if (!languageCode.equals(locale.languageCode)) return false;
        if (language != null ? !language.equals(locale.language) : locale.language != null) return false;
        return country != null ? country.equals(locale.country) : locale.country == null;
    }

    @Override
    public int hashCode() {
        int result = languageCode.hashCode();
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}
