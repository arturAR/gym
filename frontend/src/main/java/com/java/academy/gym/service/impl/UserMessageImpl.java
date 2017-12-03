package com.java.academy.gym.service.impl;

import com.java.academy.gym.model.UserMessage;
import com.java.academy.gym.repository.UserMessageDao;
import com.java.academy.gym.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserMessageImpl implements UserMessageService{

    private UserMessageDao userMessageDao;

    @Autowired
    public UserMessageImpl(UserMessageDao userMessageDao) {
        this.userMessageDao = userMessageDao;
    }

    @Override
    public Map<String, String> findUserMessagesByKeys(List<String> messagesKeys) {
        return messagesKeys
                .stream()
                .map(key -> Optional.ofNullable(userMessageDao.getUserMessageByMessageKey(key)))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toMap(UserMessage::getMessageKey, UserMessage::getMessageText));
    }
}
