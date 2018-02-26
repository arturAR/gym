package com.java.academy.gym.service.impl;

import com.java.academy.gym.model.Locale;
import com.java.academy.gym.model.UserMessage;
import com.java.academy.gym.repository.LocaleDao;
import com.java.academy.gym.repository.UserMessageDao;
import com.java.academy.gym.service.InternationalizationService;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InternationalizationServiceImplTest {
    private LocaleDao localeDao;
    private UserMessageDao userMessageDao;
    private InternationalizationService internationalizationService;

    @Before
    public void setup() {
        localeDao = mock(LocaleDao.class);
        userMessageDao = mock(UserMessageDao.class);
        internationalizationService = new InternationalizationServiceImpl(localeDao, userMessageDao);
    }

    @Test
    public void shouldInternationalizeUserMessages() {
        String languageCode = "pl_PL";
        Locale locale = new Locale(languageCode, "polish", "Poland");
        UserMessage userMessage1 = new UserMessage(locale, "MK1", "Message1");
        UserMessage userMessage2 = new UserMessage(locale, "MK2", "Message2");
        when(userMessageDao.findByMessageKeyAndLocaleLanguageCode("MK1", languageCode)).thenReturn(userMessage1);
        when(userMessageDao.findByMessageKeyAndLocaleLanguageCode("MK2", languageCode)).thenReturn(userMessage2);

        Map<String, String> userMessagesToInternationalize = new HashMap<>();
        userMessagesToInternationalize.put("lang", "pl_PL");
        userMessagesToInternationalize.put("MK1", "");
        userMessagesToInternationalize.put("MK2", "");
        Map<String, String> userMessages = internationalizationService
                .internationalizeUserMessages(userMessagesToInternationalize);

        assertTrue(userMessages.containsKey("MK1"));
        assertTrue(userMessages.containsValue(userMessage1.getMessageText()));
        assertTrue(userMessages.containsKey("MK2"));
        assertTrue(userMessages.containsValue(userMessage2.getMessageText()));
    }
}