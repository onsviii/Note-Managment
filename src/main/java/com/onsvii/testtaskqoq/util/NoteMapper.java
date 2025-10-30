package com.onsvii.testtaskqoq.util;

import com.onsvii.testtaskqoq.dto.NoteCreateDTO;
import com.onsvii.testtaskqoq.dto.NoteDTO;
import com.onsvii.testtaskqoq.dto.NoteSummaryDTO;
import com.onsvii.testtaskqoq.model.Note;

public class NoteMapper {
    public static NoteDTO mapToNoteDTO(Note note) {
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(note.getId());
        noteDTO.setTitle(note.getTitle());
        noteDTO.setText(note.getText());
        noteDTO.setTags(note.getTags());
        noteDTO.setCreatedAt(note.getCreatedAt());
        noteDTO.setUpdatedAt(note.getUpdatedAt());

        return noteDTO;
    }

    public static NoteSummaryDTO mapToNoteSummaryDTO(Note note) {
        NoteSummaryDTO noteSummaryDTO = new NoteSummaryDTO();
        noteSummaryDTO.setId(note.getId());
        noteSummaryDTO.setTitle(note.getTitle());
        noteSummaryDTO.setCreatedAt(note.getCreatedAt());

        return noteSummaryDTO;
    }

    public static Note mapToNote(NoteCreateDTO noteDTO) {
        Note note = new Note();
        note.setTitle(noteDTO.getTitle());
        note.setText(noteDTO.getText());
        note.setTags(noteDTO.getTags());

        return note;
    }
}
