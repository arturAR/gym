package com.java.academy.gym.controller;

import com.java.academy.gym.model.Locale;
import com.java.academy.gym.service.InternationalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
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
    public Map<String, String> internationalizeMessages(@RequestBody Map<String, String> userMessages) {
        System.out.println(userMessages);
        return internationalizationService.internationalizeUserMessages(userMessages);
    }

    @GetMapping("/locales")
    public ResponseEntity<List<Locale>> getLocales() {
        return ResponseEntity.ok(internationalizationService.findAllLocales());
    }

    @GetMapping("/defaultLang")
    public ResponseEntity<String> getDefaultLanguage(HttpServletRequest request) {
        return ResponseEntity.ok("{\"lang\":\"" + request.getLocale().getLanguage().toUpperCase() + "\"}");
    }
}
