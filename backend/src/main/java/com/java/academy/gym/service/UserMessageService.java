package com.java.academy.gym.service;

import java.util.List;
import java.util.Map;

public interface UserMessageService {

    Map<String, String> findUserMessagesByKeys(List<String> messagesKeys);
}
