package com.java.academy.gym.repository;

import com.java.academy.gym.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileDao extends JpaRepository<UserProfile, Long> {

    UserProfile getUserProfileById(Long id);
}
