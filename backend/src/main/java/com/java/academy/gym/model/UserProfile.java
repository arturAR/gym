package com.java.academy.gym.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER_PROFILES")
public class UserProfile extends BaseEntity {

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "SECOND_NAME", nullable = false)
    private String lastName;

    public UserProfile(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}
