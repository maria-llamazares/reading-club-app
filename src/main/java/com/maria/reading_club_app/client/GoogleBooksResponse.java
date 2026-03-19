package com.maria.reading_club_app.client;

import lombok.Data;
import java.util.List;

@Data
public class GoogleBooksResponse {
    private List<Item> items;

    @Data
    public static class Item {
        private String id;
        private VolumeInfo volumeInfo;
    }

    @Data
    public static class VolumeInfo {
        private String title;
        private List<String> authors;
        private Integer pageCount;
        private String description;
        private ImageLinks imageLinks;
    }

    @Data
    public static class ImageLinks {
        private String thumbnail;
    }
}
