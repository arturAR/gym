package com.java.academy.gym.service.impl;

import com.java.academy.gym.model.Club;
import com.java.academy.gym.model.ContactInfo;
import com.java.academy.gym.repository.ClubRepo;
import com.java.academy.gym.repository.ContactInfoDao;
import com.java.academy.gym.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepo clubDao;
    private final ContactInfoDao contactInfoDao;

    @Autowired
    public ClubServiceImpl(ClubRepo clubDao, ContactInfoDao contactInfoDao) {
        this.clubDao = clubDao;
        this.contactInfoDao = contactInfoDao;
    }

    @Override
    public List<Club> findAllClubs() {
        return clubDao.findAll();
    }

    @Override
    public List<Club> findClubsByCity(String city) {
        return clubDao.findAll()
                .stream()
                .filter(club -> club.getContactInfo().getCity().equals(city))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Club> findClubByName(Long id, String langCode) {
        return clubDao.findClubByNameAndLangCode(id, langCode);
    }

    @Override
    public ContactInfo getInfoAboutClubByClubId(Long clubId) {
        return contactInfoDao.findOne(clubId);
    }
}
