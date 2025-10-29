package com.onsvii.testtaskqoq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteSummaryDto {
    private String id;
    private String title;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
