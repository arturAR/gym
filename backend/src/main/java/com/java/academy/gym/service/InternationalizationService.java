package com.java.academy.gym.service;

import com.java.academy.gym.model.Locale;
import com.java.academy.gym.model.UserMessage;
import java.util.List;
import java.util.Map;

public interface InternationalizationService {
    List<Locale> findAllLocales();

    Map<String, UserMessage> internationalizeUserMessages(Map<String, UserMessage> userMessages);
}
