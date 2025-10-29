package com.onsvii.testtaskqoq.service;

import com.onsvii.testtaskqoq.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteService {
    Page<NoteSummaryDto> findALL(Pageable pageable);
    NoteDTO create(NoteCreateDTO note);
    NoteDTO getById(String id);
    NoteDTO update(String id, NoteCreateDTO note);
    void delete(String id);
    NoteStatisticDTO computeStats(String id);
}
