package com.java.academy.gym.controller;

import com.java.academy.gym.model.UserMessage;
import com.java.academy.gym.service.InternationalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/i18n")
public class InternationalizationController {
    private InternationalizationService internationalizationService;

    @Autowired
    public InternationalizationController(InternationalizationService internationalizationService) {
        this.internationalizationService = internationalizationService;
    }

    @PostMapping
    public Map<String, UserMessage> internationalizeMessages(@RequestBody Map<String, UserMessage> userMessages) {
        return internationalizationService.internationalizeUserMessages(userMessages);
    }
}
