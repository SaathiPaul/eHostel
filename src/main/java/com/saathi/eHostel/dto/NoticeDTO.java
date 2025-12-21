package com.saathi.eHostel.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeDTO {
    private Long id;
    private LocalDateTime createdAt;
    private String title;
    private String body;
    private Long createdByWardenId;
}

//id
//created at
// title
// body
//created by warden id