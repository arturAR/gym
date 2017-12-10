package com.java.academy.gym.repository;

import com.java.academy.gym.model.Locale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocaleDao extends JpaRepository<Locale, Long> {
    Locale findByLanguageCode(String languageCode);
}
