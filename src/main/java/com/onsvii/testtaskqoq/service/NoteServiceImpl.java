package com.onsvii.testtaskqoq.service;

import com.onsvii.testtaskqoq.dto.NoteCreateDTO;
import com.onsvii.testtaskqoq.dto.NoteDTO;
import com.onsvii.testtaskqoq.dto.NoteStatisticDTO;
import com.onsvii.testtaskqoq.dto.NoteSummaryDTO;
import com.onsvii.testtaskqoq.exception.NotFoundException;
import com.onsvii.testtaskqoq.model.Note;
import com.onsvii.testtaskqoq.repository.NoteRepository;
import com.onsvii.testtaskqoq.util.NoteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    @Override
    public Page<NoteSummaryDTO> findAll(Pageable pageable) {
        return noteRepository
                .findAll(pageable)
                .map(NoteMapper::mapToNoteSummaryDTO);
    }

    @Override
    public Page<NoteSummaryDTO> findByTags(List<Note.Tag> tags, Pageable pageable) {
        if (tags == null || tags.isEmpty()) {
            return findAll(pageable);
        }

        return noteRepository
                .findByTagsInOrderByCreatedAtDesc(Collections.singleton(tags), pageable)
                .map(NoteMapper::mapToNoteSummaryDTO);
    }

    @Override
    public NoteDTO create(NoteCreateDTO noteDTO) {
        Note note = NoteMapper.mapToNote(noteDTO);
        noteRepository.save(note);

        return NoteMapper.mapToNoteDTO(note);
    }

    @Override
    public NoteDTO getById(String id) {
        Note note = noteRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Note with id " + id + " not found"));

        return NoteMapper.mapToNoteDTO(note);
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
