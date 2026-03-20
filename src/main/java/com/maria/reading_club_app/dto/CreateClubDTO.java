package com.maria.reading_club_app.dto;

import lombok.Data;

@Data
public class CreateClubDTO {
    private String book;
    private String author;
    private String googleId;
    private String coverUrl;
    private String description;
    private int pages;
    private int totalWeeks;
}