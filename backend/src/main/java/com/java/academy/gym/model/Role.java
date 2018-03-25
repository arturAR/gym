package com.java.academy.gym.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="APP_ROLE")
public class Role extends BaseEntity {

    @Column(name="ROLE_NAME")
    private String roleName;
    @Column(name="DESCRIPTION")
    private String description;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
