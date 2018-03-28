package com.java.academy.gym.service;

import com.java.academy.gym.model.User;

/**
 * Authorization service.
 */
public interface AuthService {
    User getCurrentUserOrException();

    void setCurrentUser(User user);
}