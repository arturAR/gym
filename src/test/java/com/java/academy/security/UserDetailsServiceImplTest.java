package com.java.academy.security;

import com.java.academy.dao.UserDetailsDao;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserDetailsServiceImplTest {

    @Test
    public void loadUserByUsername() {
        UserDetailsDao userDetailsDao = mock(UserDetailsDao.class);
        UserDetails userDetails = mock(UserDetails.class);
        when(userDetailsDao.getDetailsByName(any())).thenReturn(userDetails);
        UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl(userDetailsDao);
        String name = "test";
        UserDetails result = userDetailsService.loadUserByUsername(name);
        assertEquals(result, userDetails);
    }

}