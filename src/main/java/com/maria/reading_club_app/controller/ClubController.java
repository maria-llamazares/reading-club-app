package com.maria.reading_club_app.controller;

import com.maria.reading_club_app.dto.ClubDTO;
import com.maria.reading_club_app.dto.CreateClubDTO;
import com.maria.reading_club_app.service.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clubs")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class ClubController {

    private final ClubService clubService;

    @PostMapping("/create")
    public ResponseEntity<ClubDTO> createClub(@RequestBody CreateClubDTO dto) {
        ClubDTO club = clubService.createClub(dto);
        return ResponseEntity.ok(club);
    }
}