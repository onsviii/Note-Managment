package com.onsvii.testtaskqoq.dto;

import com.onsvii.testtaskqoq.model.Note;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO {
    ObjectId id;
    String title;
    String text;
    List<Note.Tag> tags;
    LocalDate createdAt;
    LocalDate updatedAt;
}
