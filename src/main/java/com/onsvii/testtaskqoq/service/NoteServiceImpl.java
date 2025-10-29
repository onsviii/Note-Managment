package com.onsvii.testtaskqoq.service;

import com.onsvii.testtaskqoq.dto.NoteCreateDTO;
import com.onsvii.testtaskqoq.dto.NoteDTO;
import com.onsvii.testtaskqoq.dto.NoteStatisticDTO;
import com.onsvii.testtaskqoq.dto.NoteSummaryDto;
import com.onsvii.testtaskqoq.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public Page<NoteSummaryDto> findALL(Pageable pageable) {
        return null;
    }

    @Override
    public NoteDTO create(NoteCreateDTO note) {
        return null;
    }

    @Override
    public NoteDTO getById(String id) {
        return null;
    }

    @Override
    public NoteDTO update(String id, NoteCreateDTO note) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public NoteStatisticDTO computeStats(String id) {
        return null;
    }
}
