package com.onsvii.testtaskqoq.service;

import com.onsvii.testtaskqoq.dto.*;
import com.onsvii.testtaskqoq.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NoteService {
    Page<NoteSummaryDTO> findAll(Pageable pageable);
    Page<NoteSummaryDTO> findByTags(List<Note.Tag> tags, Pageable pageable);
    NoteDTO create(NoteCreateDTO noteDTO);
    NoteDTO findById(String id);
    NoteDTO update(String id, NoteCreateDTO noteDTO);
    NoteDTO update(String id, NoteUpdateDTO noteDTO);
    void delete(String id);
    NoteStatisticDTO computeStats(String id);
}
