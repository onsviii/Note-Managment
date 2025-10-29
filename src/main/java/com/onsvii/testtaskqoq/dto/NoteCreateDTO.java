package com.onsvii.testtaskqoq.dto;

import com.onsvii.testtaskqoq.model.Note;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteCreateDTO {
    @NotBlank(message = "Title must not be empty")
    String title;
    @NotBlank(message = "Text must not be empty")
    String text;
    List<Note.Tag> tags;
}
