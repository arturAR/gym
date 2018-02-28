package com.java.academy.gym.controller;

import com.java.academy.gym.model.Club;
import com.java.academy.gym.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clubs")
public class ClubsController {

    private final ClubService clubService;

    @Autowired
    public ClubsController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Club>> getClubs() {
        return ResponseEntity.ok(clubService.findAllClubs());
    }

    @GetMapping("/{clubName}")
    public ResponseEntity<Club> getClub(@PathVariable(value = "clubName") String clubName) {
        return ResponseEntity.ok(clubService.findClubByName(clubName));
    }
}
