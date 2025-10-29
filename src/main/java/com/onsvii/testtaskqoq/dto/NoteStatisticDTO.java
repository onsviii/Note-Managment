package com.onsvii.testtaskqoq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteStatisticDTO {
    String noteId;
    Map<String, Integer> wordCounts;
}
