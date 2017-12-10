package com.java.academy.gym.service.impl;

import com.java.academy.gym.model.UserMessage;
import com.java.academy.gym.repository.UserMessageDao;
import com.java.academy.gym.service.InternationalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InternationalizationServiceImpl implements InternationalizationService {
    private UserMessageDao userMessageDao;

    @Autowired
    public InternationalizationServiceImpl(UserMessageDao userMessageDao) {
        this.userMessageDao = userMessageDao;
    }

    @Override
    public Map<String, UserMessage> internationalizeUserMessages(Map<String, UserMessage> userMessages) {
        return userMessages
                .entrySet()
                .stream()
                .map(entry -> Optional.ofNullable(userMessageDao.findByMessageKeyAndLocaleLanguageCode(entry.getKey(),
                        entry.getValue().getLocale().getLanguageCode())))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toMap(UserMessage::getMessageKey, userMessage -> userMessage));
    }
}
