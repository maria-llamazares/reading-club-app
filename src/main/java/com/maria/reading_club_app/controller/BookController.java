package com.maria.reading_club_app.controller;

import com.maria.reading_club_app.dto.BookDTO;
import com.maria.reading_club_app.service.BookSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class BookController {

    private final BookSearchService bookSearchService;

    @GetMapping("/search")
    public ResponseEntity<List<BookDTO>> search(
            @RequestParam String q) {
        if (q.isBlank() || q.length() < 2) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(bookSearchService.search(q));
    }
}
