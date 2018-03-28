package com.java.academy.gym.service.impl;

import com.java.academy.gym.model.User;
import com.java.academy.gym.repository.UserRepository;
import com.java.academy.gym.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation for {@link UserService}
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findOneByEmailWithRoles(String email) {
        return userRepository.findOneByEmailWithRoles(email);
    }

    @Override
    public Optional<User> findOneByUserNameWithRoles(String userName) {
        return userRepository.findOneByUserNameWithRoles(userName);
    }
}
