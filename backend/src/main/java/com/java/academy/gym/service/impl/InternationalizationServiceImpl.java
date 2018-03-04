package com.java.academy.gym.service.impl;

import com.java.academy.gym.model.Locale;
import com.java.academy.gym.model.UserMessage;
import com.java.academy.gym.repository.LocaleDao;
import com.java.academy.gym.repository.UserMessageDao;
import com.java.academy.gym.service.InternationalizationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InternationalizationServiceImpl implements InternationalizationService {
    private LocaleDao localeDao;
    private UserMessageDao userMessageDao;

    @Autowired
    public InternationalizationServiceImpl(LocaleDao localeDao, UserMessageDao userMessageDao) {
        this.localeDao = localeDao;
        this.userMessageDao = userMessageDao;
    }

    @Override
    public List<Locale> findAllLocales() {
        return localeDao.findAll();
    }

    @Override
    public Map<String, String> internationalizeUserMessages(Map<String, String> userMessages) {
        String locale = userMessages.get("lang");
        return userMessages
                .entrySet()
                .stream()
                .map(entry -> Optional.ofNullable(userMessageDao.findByMessageKeyAndLocaleLanguageCode(entry.getKey(), locale)))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toMap(UserMessage::getMessageKey, UserMessage::getMessageText));
    }
}
