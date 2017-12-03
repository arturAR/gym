package com.java.academy.gym.controller;

import com.java.academy.gym.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/i18n")
public class InternationalizationController {

    private UserMessageService userMessageService;

    @Autowired
    public InternationalizationController(UserMessageService userMessageService) {
        this.userMessageService = userMessageService;
    }

    @GetMapping
    public Map<String, String> internationalizeMessages(@RequestParam List<String> messagesKeys) {
        return userMessageService.findUserMessagesByKeys(messagesKeys);
    }
}
