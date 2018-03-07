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

    private final ClubRepo clubRepo;
    private final ContactInfoDao contactInfoDao;

    @Autowired
    public ClubServiceImpl(ClubRepo clubRepo, ContactInfoDao contactInfoDao) {
        this.clubRepo = clubRepo;
        this.contactInfoDao = contactInfoDao;
    }

    @Override
    public List<Club> findAllClubs(String locale) {
        return clubRepo.findAll(locale);
    }

    @Override
    public List<Club> findClubsByCity(String city, String locale) {
        return clubRepo.findAll(locale)
                .stream()
                .filter(club -> club.getContactInfo().getCity().equals(city))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Club> findClubByName(Long id, String langCode) {
        return clubRepo.findClubByNameAndLangCode(id, langCode);
    }

    @Override
    public ContactInfo getInfoAboutClubByClubId(Long id) {
        return contactInfoDao.getContactInfoByClubId(id);
    }
}
