package com.java.academy.gym.service.impl;

import com.java.academy.gym.model.Locale;
import com.java.academy.gym.model.UserMessage;
import com.java.academy.gym.repository.LocaleDao;
import com.java.academy.gym.repository.UserMessageDao;
import com.java.academy.gym.service.InternationalizationService;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
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
        internationalizationService = new InternationalizationServiceImpl(userMessageDao, localeDao);
    }

    @Test
    public void shouldFindUserMessagesByKeysAndLanguageCode() {
        String languageCode = "pl_PL";
        Locale locale = new Locale(languageCode, "polish", "Poland");
        locale.setId(1L);
        UserMessage userMessage1 = new UserMessage(locale, "MK1", "Message1");
        UserMessage userMessage2 = new UserMessage(locale, "MK2", "Message2");
        List<String> messagesKeys = new ArrayList<>(Arrays.asList("MK1", "MK2"));
        when(localeDao.findByLanguageCode(languageCode)).thenReturn(locale);
        when(userMessageDao.findByMessageKeyAndLocaleId("MK1", 1L)).thenReturn(userMessage1);
        when(userMessageDao.findByMessageKeyAndLocaleId("MK2", 1L)).thenReturn(userMessage2);

        Map<String, String> userMessages = internationalizationService
                .findUserMessagesByKeysAndLanguageCode(messagesKeys, languageCode);

        Map<String, String> expectedUserMessages = new HashMap<>();
        expectedUserMessages.put(userMessage1.getMessageKey(), userMessage1.getMessageText());
        expectedUserMessages.put(userMessage2.getMessageKey(), userMessage2.getMessageText());
        assertEquals(expectedUserMessages, userMessages);
    }

}