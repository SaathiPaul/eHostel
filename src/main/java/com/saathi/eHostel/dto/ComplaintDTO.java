package com.saathi.eHostel.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintDTO {
    private Long id;
    private Long createdByStudentId;
    private String message;
    private String status;
    private LocalDateTime createdAt;
}