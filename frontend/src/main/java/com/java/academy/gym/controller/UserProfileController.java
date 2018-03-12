package com.java.academy.gym.controller;

import com.java.academy.gym.model.UserProfile;
import com.java.academy.gym.service.UserProfileService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserProfileController {

    private UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @RequestMapping("/{id}")
    public UserProfile getUserById(@PathVariable Long id) {
        return userProfileService.getUserById(id);
    }
}
