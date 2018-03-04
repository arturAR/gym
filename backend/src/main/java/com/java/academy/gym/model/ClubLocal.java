package com.java.academy.gym.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Club locals
 */
@Embeddable
public class ClubLocal implements Serializable {
    private static final long serialVersionUID = 5403533687994398074L;

    @Column(name = "DESCRIPTION", length = 300)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClubLocal)) return false;
        ClubLocal clubLocal = (ClubLocal) o;
        return Objects.equals(description, clubLocal.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return "ClubLocal{" +
                "description='" + description + '\'' +
                '}';
    }
}