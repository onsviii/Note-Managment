package com.onsvii.testtaskqoq.dto;

import com.onsvii.testtaskqoq.model.Note;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteUpdateDTO {
    String title;
    String text;
    List<Note.Tag> tags;
}
