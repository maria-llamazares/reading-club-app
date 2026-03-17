package com.maria.reading_club_app.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookDTO {
    private String googleId;
    private String title;
    private String author;
    private int pages;
    private String description;
    private String coverUrl;
}