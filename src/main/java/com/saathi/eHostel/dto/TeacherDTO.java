package com.saathi.eHostel.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TeacherDTO {
    private Long id;
    private String name;
    private String department;
    private String email;
    private String phone;

}
