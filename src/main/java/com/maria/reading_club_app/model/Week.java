package com.maria.reading_club_app.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "weeks")
public class Week {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int weekNumber;
    private int pageFrom;
    private int pageTo;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;
}