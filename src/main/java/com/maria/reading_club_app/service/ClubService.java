package com.maria.reading_club_app.service;

import com.maria.reading_club_app.dto.ClubDTO;
import com.maria.reading_club_app.dto.CreateClubDTO;
import com.maria.reading_club_app.dto.WeekDTO;
import com.maria.reading_club_app.model.Club;
import com.maria.reading_club_app.model.Week;
import com.maria.reading_club_app.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubService {

    private final ClubRepository clubRepository;

    public ClubDTO createClub(CreateClubDTO dto) {
        Club club = new Club();
        club.setBook(dto.getBook());
        club.setAuthor(dto.getAuthor());
        club.setGoogleId(dto.getGoogleId());
        club.setCoverUrl(dto.getCoverUrl());
        club.setDescription(dto.getDescription());
        club.setPages(dto.getPages());
        club.setTotalWeeks(dto.getTotalWeeks());

        List<Week> weeks = generateWeeks(dto.getPages(), dto.getTotalWeeks(), club);
        club.setWeeks(weeks);

        Club saved = clubRepository.save(club);
        return toDTO(saved);
    }

    private List<Week> generateWeeks(int pages, int totalWeeks, Club club) {
        List<Week> weeks = new ArrayList<>();
        int pagesPerWeek = (int) Math.ceil((double) pages / totalWeeks);

        for (int i = 0; i < totalWeeks; i++) {
            Week week = new Week();
            week.setWeekNumber(i + 1);
            week.setPageFrom(i * pagesPerWeek + 1);
            week.setPageTo(Math.min((i + 1) * pagesPerWeek, pages));
            week.setCompleted(false);
            week.setClub(club);
            weeks.add(week);
        }
        return weeks;
    }

    private ClubDTO toDTO(Club club) {
        ClubDTO dto = new ClubDTO();
        dto.setId(club.getId());
        dto.setBook(club.getBook());
        dto.setAuthor(club.getAuthor());
        dto.setCoverUrl(club.getCoverUrl());
        dto.setPages(club.getPages());
        dto.setTotalWeeks(club.getTotalWeeks());
        dto.setCreatedAt(club.getCreatedAt());

        List<WeekDTO> weekDTOs = club.getWeeks().stream()
                .map(this::weekToDTO)
                .toList();
        dto.setWeeks(weekDTOs);
        return dto;
    }

    private WeekDTO weekToDTO(Week week) {
        WeekDTO dto = new WeekDTO();
        dto.setId(week.getId());
        dto.setWeekNumber(week.getWeekNumber());
        dto.setPageFrom(week.getPageFrom());
        dto.setPageTo(week.getPageTo());
        dto.setCompleted(week.isCompleted());
        return dto;
    }
}