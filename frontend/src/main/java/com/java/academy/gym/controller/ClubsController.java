package com.java.academy.gym.controller;

import com.java.academy.gym.model.Club;
import com.java.academy.gym.model.ContactInfo;
import com.java.academy.gym.model.Locale;
import com.java.academy.gym.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/clubs")
public class ClubsController {

    private final ClubService clubService;

    @Autowired
    public ClubsController(ClubService clubService) {
        this.clubService = clubService;
    }

    @PostMapping("/all")
    public ResponseEntity<List<Club>> getClubs(@RequestBody Map<String, String> langCodes) {
        System.out.println("============");
        System.out.println(langCodes.get("langCode"));
        System.out.println("============");
        return ResponseEntity.ok(clubService.findAllClubs(langCodes.get("langCode")));
    }

    @PostMapping("/{clubName}")
    public ResponseEntity<Club> getClub(@PathVariable(value = "clubName") String clubName, @RequestBody Locale locale) {
        return ResponseEntity.ok(clubService.findClubByName(Long.valueOf(clubName), locale.getLanguageCode()).get());
    }
}
