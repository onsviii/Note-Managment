package com.onsvii.testtaskqoq.controller;

import com.onsvii.testtaskqoq.dto.NoteCreateDTO;
import com.onsvii.testtaskqoq.dto.NoteDTO;
import com.onsvii.testtaskqoq.dto.NoteStatisticDTO;
import com.onsvii.testtaskqoq.dto.NoteSummaryDto;
import com.onsvii.testtaskqoq.service.NoteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.*;

@RestController("/api/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteServiceImpl noteService;

    @GetMapping
    public PagedModel<NoteSummaryDto> findAll(Pageable pageable) {
        return null;
    }

    @GetMapping("/{id)")
    public NoteDTO findById(@PathVariable long id) {
        return null;
    }

    @GetMapping("/{id}/stats")
    public NoteStatisticDTO getNoteStats(@PathVariable long id) {
        return null;
    }

    @PostMapping
    public NoteDTO create(@RequestBody NoteDTO noteDTO) {
        return null;
    }

    @PutMapping("/{id}")
    public NoteDTO update(@RequestBody NoteCreateDTO noteDTO, @PathVariable long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {

    }
}
