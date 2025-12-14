package com.saathi.eHostel.dto;

import lombok.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintDTO {
    private Long id;
    private String message;
    private String status;
    private LocalDateTime createdAt;

}
