package com.onsvii.testtaskqoq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("notes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    String id;
    String title;
    String text;
    List<Tag> tags;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public enum Tag {
        BUSINESS, PERSONAL, IMPORTANT
    }
}
