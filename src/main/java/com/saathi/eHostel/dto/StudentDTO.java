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
    private String registrationNumber;
    private String department;
    private String email;
    private String phone;
    private String guardianPhone;
    private String roomNumber;
    private String password;
}