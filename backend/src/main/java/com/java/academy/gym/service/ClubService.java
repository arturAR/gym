package com.java.academy.gym.service;

import com.java.academy.gym.model.Club;
import com.java.academy.gym.model.ContactInfo;

import java.util.List;

public interface ClubService {

    List<Club> findAllClubs();

    List<Club> findClubsByCity(String city);

    Club findClubByName(String name);

    ContactInfo getInfoAboutClubByClubName(String name);
}
