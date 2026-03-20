package com.maria.reading_club_app.dto;

import lombok.Data;

@Data
public class WeekDTO {
    private Long id;
    private int weekNumber;
    private int pageFrom;
    private int pageTo;
    private boolean completed;
}