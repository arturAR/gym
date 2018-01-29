package com.java.academy.gym.service.impl;

import com.java.academy.gym.model.UserProfile;
import com.java.academy.gym.repository.UserProfileDao;
import com.java.academy.gym.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserProfileServiceImpl implements UserProfileService {
    private UserProfileDao userProfileDao;

    @Autowired
    public UserProfileServiceImpl(UserProfileDao userProfileDao) {
        this.userProfileDao = userProfileDao;
    }

    @Override
    public UserProfile getUserById(Long id) {
        return userProfileDao.getUserProfileById(id);
    }
}
