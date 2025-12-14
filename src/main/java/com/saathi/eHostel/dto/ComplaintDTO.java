package com.saathi.eHostel.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ComplaintDTO {
    private Long id;
    private String message;
    private String status;
    private LocalDateTime createdAt;
}
