package com.java.academy.gym.service;

import com.java.academy.gym.model.User;

import java.util.Optional;

/**
 * User service.
 */
public interface UserService {
    Optional<User> findOneByEmailWithRoles(String email);

    Optional<User> findOneByUserNameWithRoles(String userName);
}
