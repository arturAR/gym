package com.java.academy.gym.service;

import com.java.academy.gym.model.Club;
import com.java.academy.gym.model.ContactInfo;

import java.util.List;
import java.util.Optional;

public interface ClubService {

    List<Club> findAllClubs();

    List<Club> findClubsByCity(String city);

    Optional<Club> findClubByName(Long id, String langCode);

    ContactInfo getInfoAboutClubByClubId(Long clubId);
}
