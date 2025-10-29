package com.onsvii.testtaskqoq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
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
    LocalDate createdAt;
    LocalDate updatedAt;

    public enum Tag {
        BUSINESS, PERSONAL, IMPORTANT
    }
}
