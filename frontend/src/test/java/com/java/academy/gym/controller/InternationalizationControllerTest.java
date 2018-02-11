package com.java.academy.gym.controller;

import com.java.academy.gym.model.Locale;
import com.java.academy.gym.model.UserMessage;
import com.java.academy.gym.service.InternationalizationService;
import com.java.academy.gym.util.JsonUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class InternationalizationControllerTest {
    private MockMvc mockMvc;

    @Mock
    private InternationalizationService mockInternationalizationService;

    @InjectMocks
    private InternationalizationController internationalizationController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(internationalizationController)
                .build();
    }

    @Test
    public void shouldReturnMapOfUserMessages() throws Exception {
        Locale locale = new Locale("pl_PL", "polish", "Poland");
        Map<String, String> userMessagesToInternationalize = new HashMap<>();
        userMessagesToInternationalize.put("MK1", "");
        userMessagesToInternationalize.put("MK2", "");
        UserMessage userMessage1 = new UserMessage(locale, "MK1", "Message1");
        UserMessage userMessage2 = new UserMessage(locale, "MK2", "Message2");

        Map<String, String> userMessages = new HashMap<>();
        userMessages.put("MK1", userMessage1.getMessageText());
        userMessages.put("MK2", userMessage2.getMessageText());

        when(mockInternationalizationService.internationalizeUserMessages(userMessagesToInternationalize))
                .thenReturn(userMessages);

        mockMvc.perform(post("/i18n")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JsonUtil.toJson(userMessagesToInternationalize)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("MK1", is("Message1")))
                .andExpect(jsonPath("MK2", is("Message2")));

        verify(mockInternationalizationService, times(1))
                .internationalizeUserMessages(userMessagesToInternationalize);
        verifyNoMoreInteractions(mockInternationalizationService);
    }
}
