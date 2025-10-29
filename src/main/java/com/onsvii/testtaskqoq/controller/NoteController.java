package com.onsvii.testtaskqoq.controller;

import com.onsvii.testtaskqoq.dto.NoteCreateDTO;
import com.onsvii.testtaskqoq.dto.NoteDTO;
import com.onsvii.testtaskqoq.dto.NoteStatisticDTO;
import com.onsvii.testtaskqoq.dto.NoteSummaryDTO;
import com.onsvii.testtaskqoq.model.Note;
import com.onsvii.testtaskqoq.service.NoteServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
@Validated
public class NoteController {
    private final NoteServiceImpl noteService;

    @GetMapping
    public PagedModel<NoteSummaryDTO> findAll(@Valid @RequestParam(value = "tag",
                                                          required = false) List<Note.Tag> tags,
                                              @PageableDefault(sort = "createdAt",
                                                      direction = Sort.Direction.DESC) Pageable pageable) {

        return new PagedModel<>(noteService.findByTags(tags, pageable));
    }

    @GetMapping("/{id}")
    public NoteDTO findById(@PathVariable ObjectId id) {
        return null;
    }

    @GetMapping("/{id}/stats")
    public NoteStatisticDTO getNoteStats(@PathVariable ObjectId id) {
        return null;
    }

    @PostMapping
    public NoteDTO create(@Valid @RequestBody NoteCreateDTO noteDTO) {
        return noteService.create(noteDTO);
    }

    @PutMapping("/{id}")
    public NoteDTO update(@Valid @RequestBody NoteCreateDTO noteDTO,
                          @PathVariable ObjectId id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ObjectId id) {

    }
}
