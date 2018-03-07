package com.java.academy.gym.repository;

import com.java.academy.gym.model.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactInfoDao extends JpaRepository<ContactInfo, Long> {

    ContactInfo getContactInfoByClubId(Long id);
}
