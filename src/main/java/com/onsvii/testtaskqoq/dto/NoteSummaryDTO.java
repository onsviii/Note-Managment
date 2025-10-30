package com.onsvii.testtaskqoq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteSummaryDTO {
    private String id;
    private String title;
    private LocalDateTime createdAt;
}
