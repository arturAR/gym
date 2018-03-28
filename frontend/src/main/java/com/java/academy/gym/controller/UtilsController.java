package com.java.academy.gym.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common/utils")
public class UtilsController {

    private static final Logger LOG = LoggerFactory.getLogger(UtilsController.class);

    private final PasswordEncoder passwordEncoder;

    public UtilsController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/encodePassword")
    public String encodePassword(@RequestParam("value") String value) {
        LOG.info("Requested encodePassword utils...");
        return passwordEncoder.encode(value);
    }
}
