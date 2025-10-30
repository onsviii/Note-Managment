package com.onsvii.testtaskqoq.controller;

import com.onsvii.testtaskqoq.dto.*;
import com.onsvii.testtaskqoq.model.Note;
import com.onsvii.testtaskqoq.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
@Validated
public class NoteController {
    private final NoteService noteService;

    @GetMapping
    public PagedModel<NoteSummaryDTO> findAll(@RequestParam(value = "tag",
                                                          required = false) List<Note.Tag> tags,
                                              @PageableDefault(sort = "createdAt",
                                                      direction = Sort.Direction.DESC) Pageable pageable) {

        return new PagedModel<>(noteService.findByTags(tags, pageable));
    }

    @GetMapping("/{id}")
    public NoteDTO findById(@PathVariable String id) {
        return noteService.findById(id);
    }

    @GetMapping("/{id}/stats")
    public NoteStatisticDTO getNoteStats(@PathVariable String id) {
        return noteService.computeStats(id);
    }

    @PostMapping
    public ResponseEntity<NoteDTO> create(@Valid @RequestBody NoteCreateDTO noteDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(noteService.create(noteDTO));
    }

    @PutMapping("/{id}")
    public NoteDTO update(@PathVariable String id,
                          @Valid @RequestBody NoteCreateDTO noteDTO) {
        return noteService.update(id,noteDTO);
    }

    @PatchMapping("/{id}")
    public NoteDTO update(@PathVariable String id,
                          @Valid @RequestBody NoteUpdateDTO noteDTO) {
        return noteService.update(id, noteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        noteService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
