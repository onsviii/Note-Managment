package com.onsvii.testtaskqoq.service;

import com.onsvii.testtaskqoq.dto.NoteCreateDTO;
import com.onsvii.testtaskqoq.dto.NoteDTO;
import com.onsvii.testtaskqoq.dto.NoteStatisticDTO;
import com.onsvii.testtaskqoq.dto.NoteSummaryDTO;
import com.onsvii.testtaskqoq.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NoteService {
    Page<NoteSummaryDTO> findAll(Pageable pageable);
    Page<NoteSummaryDTO> findByTags(List<Note.Tag> tags, Pageable pageable);
    NoteDTO create(NoteCreateDTO noteDTO);
    NoteDTO getById(String id);
    NoteDTO update(String id, NoteCreateDTO noteDTO);
    void delete(String id);
    NoteStatisticDTO computeStats(String id);
}
