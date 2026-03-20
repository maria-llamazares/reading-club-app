package com.maria.reading_club_app.repository;

import com.maria.reading_club_app.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
}