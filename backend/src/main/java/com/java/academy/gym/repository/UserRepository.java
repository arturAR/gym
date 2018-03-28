package com.java.academy.gym.repository;

import com.java.academy.gym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Repository for {@link User} entity
 */
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u INNER JOIN FETCH u.roles WHERE u.email=:email")
    Optional<User> findOneByEmailWithRoles(@Param("email") String email);

    @Query("SELECT u FROM User u INNER JOIN FETCH u.roles WHERE u.userName=:userName")
    Optional<User> findOneByUserNameWithRoles(@Param("userName") String userName);
}