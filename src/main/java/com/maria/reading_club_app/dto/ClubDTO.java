package com.maria.reading_club_app.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ClubDTO {
    private Long id;
    private String book;
    private String author;
    private String coverUrl;
    private int pages;
    private int totalWeeks;
    private LocalDateTime createdAt;
    private List<WeekDTO> weeks;
}