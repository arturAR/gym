package com.java.academy.gym.repository;

import com.java.academy.gym.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubDao extends JpaRepository<Club, Long> {

    Club findClubByName(String name);
}
