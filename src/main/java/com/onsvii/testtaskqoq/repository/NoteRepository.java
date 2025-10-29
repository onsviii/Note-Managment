package com.onsvii.testtaskqoq.repository;

import com.onsvii.testtaskqoq.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
    Page<Note> findByTagsInOrderByCreatedAtDesc(Collection<List<Note.Tag>> tags, Pageable p);
}
