package com.java.academy.gym.service;

import com.java.academy.gym.model.UserProfile;
import org.springframework.stereotype.Service;

@Service
public interface UserProfileService {

    UserProfile getUserById(Long id);
}
