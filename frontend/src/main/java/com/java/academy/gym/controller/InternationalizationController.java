package com.java.academy.gym.controller;

import com.java.academy.gym.model.Locale;
import com.java.academy.gym.model.UserMessage;
import com.java.academy.gym.service.InternationalizationService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/locales")
    public ResponseEntity<List<Locale>> getLocales() {
        return ResponseEntity.ok(internationalizationService.findAllLocales());
    }
}