package com.java.academy.dao;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class InMemoryUserDetailsDaoTest {

    @Test
    public void testInMemoryDao() {
        InMemoryUserDetailsDao inMemoryUserDetailsDao = new InMemoryUserDetailsDao();
        assertEquals(inMemoryUserDetailsDao.userDetails.size(), 2);
    }

    @Test
    public void testGetDetailsByName() {
        InMemoryUserDetailsDao inMemoryUserDetailsDao = new InMemoryUserDetailsDao();
        String name = "user";
        String userPw = "pass";
        assertEquals(inMemoryUserDetailsDao.getDetailsByName(name).isAccountNonExpired(), true);
        assertEquals(inMemoryUserDetailsDao.getDetailsByName(name).isAccountNonLocked(), true);
        assertEquals(inMemoryUserDetailsDao.getDetailsByName(name).isCredentialsNonExpired(), true);
        assertEquals(inMemoryUserDetailsDao.getDetailsByName(name).isEnabled(), true);
        assertEquals(inMemoryUserDetailsDao.getDetailsByName(name).getUsername(), name);
        assertEquals(inMemoryUserDetailsDao.getDetailsByName(name).getPassword(), new Md5PasswordEncoder().encodePassword(userPw, ""));
        assertEquals(inMemoryUserDetailsDao.getDetailsByName(name).getAuthorities().size(), 1);
    }

}