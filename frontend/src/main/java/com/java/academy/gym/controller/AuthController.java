package com.java.academy.gym.controller;

import com.java.academy.gym.model.CurrentUser;
import com.java.academy.gym.model.User;
import com.java.academy.gym.service.AuthService;
import com.java.academy.gym.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Authorization controller.
 */
@RestController
@RequestMapping("/backend/auth")
public class AuthController {
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final AbstractRememberMeServices rememberMeServices;
    private final UserService userService;
    private final AuthService authService;

    public AuthController(
            AbstractRememberMeServices rememberMeServices, UserService userService, AuthService authService) {
        this.rememberMeServices = rememberMeServices;
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(HttpServletRequest request, HttpServletResponse response) {
        User user = authService.getCurrentUserOrException();
        LOG.debug("Signing in....: {}", user.getEmail());

        authService.setCurrentUser(user);

        LOG.debug("Signing in for {} success", user.getEmail());

        return ResponseEntity.ok("ok");
    }

    @PostMapping("/check")
    public ResponseEntity<?> check() {
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/signout")
    public ResponseEntity<?> signOut(HttpServletRequest request, HttpServletResponse response) {
        signout(request, response);

        return ResponseEntity.ok("ok");
    }

    private void signout(HttpServletRequest request, HttpServletResponse response) {
        LOG.info("Sign out...");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            rememberMeServices.logout(request, response, auth);

            String username = ((CurrentUser) auth.getPrincipal()).getUsername();
            LOG.debug("Sign out for {} success", username);
        }
    }
}
