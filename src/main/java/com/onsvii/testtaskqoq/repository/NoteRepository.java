package com.onsvii.testtaskqoq.repository;

import com.onsvii.testtaskqoq.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;

public interface NoteRepository extends MongoRepository<Note, String> {
    Page<Note> findByTagsInOrderByCreatedAtDesc(Collection<List<Note.Tag>> tags, Pageable p);
}
