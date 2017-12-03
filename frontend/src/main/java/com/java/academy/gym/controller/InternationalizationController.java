package com.java.academy.gym.controller;

import com.java.academy.gym.dto.LocaleUserMessagesRequestDto;
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
    public Map<String, String> internationalizeMessages(@RequestBody LocaleUserMessagesRequestDto userMessagesRequest) {
        return internationalizationService.findUserMessagesByKeysAndLanguageCode(
                userMessagesRequest.getMessagesKeys(),
                userMessagesRequest.getLanguageCode());
    }
}
