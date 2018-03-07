package com.java.academy.gym.repository;

import com.java.academy.gym.BaseITest;
import com.java.academy.gym.model.Club;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class ClubRepoTest extends BaseITest {
    @Autowired
    private ClubRepo clubRepo;

    @Test
    public void testFindClubByNameAndLangCode() {
        String langCode = "EN";
        Long id = 1L;
        String name = "Bora Bora";
        String description = "Super Gym!";
        Optional<Club> clubOptional = clubRepo.findClubByNameAndLangCode(id, langCode);
        assertTrue(clubOptional.isPresent());
        assertEquals(description, clubOptional.get().getClubLocal().getDescription());
        assertEquals(name, clubOptional.get().getClubLocal().getName());
    }

    @Test
    public void testGetAll() {
        String langCode = "EN";
        List<Club> club = clubRepo.findAll(langCode);
        assertTrue(!club.isEmpty());
        assertEquals(1, club);
    }
}
