package com.java.academy.gym.service;

import com.java.academy.gym.model.UserMessage;

import java.util.Map;

public interface InternationalizationService {
    Map<String, UserMessage> internationalizeUserMessages(Map<String, UserMessage> userMessages);
}
