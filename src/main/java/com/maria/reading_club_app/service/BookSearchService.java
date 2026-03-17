package com.maria.reading_club_app.service;


import com.maria.reading_club_app.client.GoogleBooksResponse;
import com.maria.reading_club_app.dto.BookDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class BookSearchService {

    private final RestTemplate restTemplate;

    @Value("${google.books.api.key}")
    private String apiKey;

    @Value("${google.books.base-url}")
    private String baseUrl;

    public BookSearchService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<BookDTO> search(String query) {
        String url = baseUrl + "?q=" + query
                + "&maxResults=10&key=" + apiKey;

        GoogleBooksResponse response = restTemplate
                .getForObject(url, GoogleBooksResponse.class);

        if (response == null || response.getItems() == null) {
            return List.of();
        }

        return response.getItems().stream()
                .map(this::toDTO)
                .filter(b -> b.getPages() > 0)
                .toList();
    }

    private BookDTO toDTO(GoogleBooksResponse.Item item) {
        var info = item.getVolumeInfo();
        return BookDTO.builder()
                .googleId(item.getId())
                .title(info.getTitle())
                .author(info.getAuthors() != null
                        ? info.getAuthors().getFirst()
                        : "Unknown")
                .pages(info.getPageCount() != null
                        ? info.getPageCount() : 0)
                .description(info.getDescription())
                .coverUrl(info.getImageLinks() != null
                        ? info.getImageLinks().getThumbnail()
                        : null)
                .build();
    }
}