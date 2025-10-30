package com.onsvii.testtaskqoq.service;

import com.onsvii.testtaskqoq.dto.*;
import com.onsvii.testtaskqoq.exception.NotFoundException;
import com.onsvii.testtaskqoq.model.Note;
import com.onsvii.testtaskqoq.repository.NoteRepository;
import com.onsvii.testtaskqoq.util.NoteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
                .findByTagsInOrderByCreatedAtDesc(tags, pageable)
                .map(NoteMapper::mapToNoteSummaryDTO);
    }

    @Override
    public NoteDTO create(NoteCreateDTO noteDTO) {
        Note note = NoteMapper.mapToNote(noteDTO);
        note.setCreatedAt(LocalDateTime.now());
        note.setUpdatedAt(LocalDateTime.now());

        return NoteMapper.mapToNoteDTO(noteRepository.save(note));
    }

    @Override
    public NoteDTO findById(String id) {
        Note note = findEntityById(id);

        return NoteMapper.mapToNoteDTO(note);
    }

    @Override
    public NoteDTO update(String id, NoteCreateDTO noteDTO) {
        Note note = findEntityById(id);

        note.setTitle(noteDTO.getTitle());
        note.setText(noteDTO.getText());
        note.setTags(noteDTO.getTags());
        note.setUpdatedAt(LocalDateTime.now());

        return NoteMapper.mapToNoteDTO(noteRepository.save(note));
    }

    @Override
    public NoteDTO update(String id, NoteUpdateDTO noteDTO) {
        Note note = findEntityById(id);
        boolean updated = false;
        String title = noteDTO.getTitle();
        String text = noteDTO.getText();

        if (title != null) {
            if (title.isBlank()) {
                    throw new IllegalArgumentException("Title cannot be empty");
            }

            note.setTitle(noteDTO.getTitle());
            updated = true;
        }
        if (text != null) {
            if (text.isBlank()) {
                throw new IllegalArgumentException("Text cannot be empty");
            }

            note.setText(noteDTO.getText());
            updated = true;
        }
        if (noteDTO.getTags() != null) {
            note.setTags(noteDTO.getTags());
            updated = true;
        }

        if (!updated) {
            throw new IllegalArgumentException(
                    "At least one field must be provided for update");
        }

        note.setUpdatedAt(LocalDateTime.now());

        return NoteMapper.mapToNoteDTO(noteRepository.save(note));
    }

    @Override
    public void delete(String id) {
        Note note = findEntityById(id);
        noteRepository.delete(note);
    }

    @Override
    public NoteStatisticDTO computeStats(String id) {
        Note note = findEntityById(id);
        String text = note.getText();

        String[] tokens = text
                .toLowerCase()
                .replaceAll("[^a-zа-яїієґ0-9\\s]", "")
                .trim()
                .split("\\s+");

        Map<String, Long> wordCounts = Arrays.stream(tokens)
                .filter(token -> !token.isBlank())
                .collect(Collectors.groupingBy(
                        token -> token,
                        Collectors.counting()
                ));

        LinkedHashMap<String, Long> sorted = wordCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));

        return new  NoteStatisticDTO(id, sorted);
    }

    private Note findEntityById(String id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Note with id " + id + " not found"));
    }
}
