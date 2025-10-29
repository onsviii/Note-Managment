package com.onsvii.testtaskqoq.dto;

import com.onsvii.testtaskqoq.model.Note;

import java.util.List;

public class NoteCreateDTO {
    String title;
    String text;
    List<Note.Tag> tags;
}
