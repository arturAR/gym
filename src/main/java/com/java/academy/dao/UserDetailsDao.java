package com.java.academy.dao;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsDao {

    UserDetails getDetailsByName(String name);
}
