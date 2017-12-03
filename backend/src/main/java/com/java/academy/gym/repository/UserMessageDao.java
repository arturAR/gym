package com.java.academy.gym.repository;

import com.java.academy.gym.model.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMessageDao extends JpaRepository<UserMessage, Long> {

    UserMessage getUserMessageByMessageKey(String messageKey);
}
