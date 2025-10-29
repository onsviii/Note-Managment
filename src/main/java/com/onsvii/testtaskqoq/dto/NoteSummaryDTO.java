package com.onsvii.testtaskqoq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteSummaryDTO {
    private ObjectId id;
    private String title;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
