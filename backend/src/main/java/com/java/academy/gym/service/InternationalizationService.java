package com.java.academy.gym.service;

import java.util.List;
import java.util.Map;

public interface InternationalizationService {

    Map<String, String> findUserMessagesByKeysAndLanguageCode(List<String> messagesKeys, String languageCode);
}
