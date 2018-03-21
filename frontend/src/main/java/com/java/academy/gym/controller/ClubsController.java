package com.java.academy.gym.controller;

import com.java.academy.gym.model.Club;
import com.java.academy.gym.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Club>> getClubs(@RequestParam("langCode") String langCode) {
        System.out.println("============");
        System.out.println(langCode);
        System.out.println("============");
        return ResponseEntity.ok(clubService.findAllClubs(langCode));
    }

    @GetMapping("/{clubId}")
    public ResponseEntity<Club> getClub(@PathVariable(value = "clubId") String clubId, @RequestParam("langCode") String langCode) {
        return ResponseEntity.ok(clubService.findClubByName(Long.valueOf(clubId), langCode).get());
    }
}
