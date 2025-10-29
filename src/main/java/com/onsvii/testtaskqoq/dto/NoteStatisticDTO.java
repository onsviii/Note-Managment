package com.onsvii.testtaskqoq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteStatisticDTO {
    ObjectId noteId;
    Map<String, Integer> wordCounts;
}
