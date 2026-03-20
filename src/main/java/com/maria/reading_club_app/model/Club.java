package com.maria.reading_club_app.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "clubs")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String book;
    private String author;
    private String googleId;
    private String coverUrl;
    @Column(columnDefinition = "TEXT")
    private String description;
    private int pages;
    private int totalWeeks;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Week> weeks;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}