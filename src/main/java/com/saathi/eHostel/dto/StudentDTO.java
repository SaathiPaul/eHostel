package com.saathi.eHostel.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String roomNumber;
}
