package com.java.academy.gym.service.impl;

import com.java.academy.gym.model.UserMessage;
import com.java.academy.gym.repository.LocaleDao;
import com.java.academy.gym.repository.UserMessageDao;
import com.java.academy.gym.service.InternationalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InternationalizationServiceImpl implements InternationalizationService {

    private UserMessageDao userMessageDao;
    private LocaleDao localeDao;

    @Autowired
    public InternationalizationServiceImpl(UserMessageDao userMessageDao, LocaleDao localeDao) {
        this.userMessageDao = userMessageDao;
        this.localeDao = localeDao;
    }

    @Override
    public Map<String, String> findUserMessagesByKeysAndLanguageCode(List<String> messagesKeys, String languageCode) {
        Long localeId = localeDao.findByLanguageCode(languageCode).getId();
        return messagesKeys
                .stream()
                .map(key -> Optional.ofNullable(userMessageDao.findByMessageKeyAndLocaleId(key, localeId)))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toMap(UserMessage::getMessageKey, UserMessage::getMessageText));
    }
}
