package com.java.academy.gym.service.impl;

import com.java.academy.gym.model.CurrentUser;
import com.java.academy.gym.model.User;
import com.java.academy.gym.service.AuthService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link AuthService}
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public User getCurrentUserOrException() {
        User user = null;
        if (SecurityContextHolder.getContext() != null
                && SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal() instanceof CurrentUser) {
            user = ((CurrentUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal()).getUser();
        }
        if (user == null) {
            throw new IllegalStateException("Access forbidden");
        }

        return user;
    }

    @Override
    public void setCurrentUser(User user) {
        ((CurrentUser) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal())
                .setUser(user);
    }
}
